## 谈谈你对Java平台的理解

### 典型回答

Java本身是一种面向对象的语言，最显著的特点有两个方面，一个是所谓的书写一次，到处运行，也即 write once，run anywhere ，能够非常容易的获得跨平台的特点，另外就是垃圾收集（GC，garbage collection），Java通过垃圾收集器（garbage collector）回收分配内存，大部分情况下，程序员不需要自己操心内存的分配和回收。

JRE 是Java的运行环境，包含JVM和Java类库，以及一些模块等；JDK可以看成是JRE的一个超集，，提供了更多的工具，比如编译器javac，各种诊断工具等

对于Java是解释执行这句话是不太准确的，我们开发的Java的源代码，首先通过Javac编译成字节码，然后在运行的时候，通过Java虚拟机JVM内嵌的解释器将字节码转换为最终的机器码。但是常见的JVM，比如大多数情况下使用的oracle JDK提供的Hotspot JVM，都提供了JIT(just-in-time)编译器，也就是常见的动态编译器，JIT能够在运行的时候将热点代码编译成机器吗，这种情况下热点代码就是编译执行了，而不是解释执行。

区分编译执行和解释执行：

1. 编译执行：编译器讲源程序的每一条语句都编译成机器语言，并保存成二进制的文件，翻译和执行是分开的，这样计算机就可以直接运行编译后的文件，例如c ，c++都是靠编译实现的
2. 解释执行：在执行程序的时候，通过解释器解释成机器能够识别的机器语言，翻译与执行是一次性完成的，例如Java的解释执行其实是先将Java文件编译成class文件，然后再程序执行的时候，由JVM内嵌的解释器将字节码转换为最终的机器码，然后再去执行；

JIT编译器负责将热点代码在运行的时候编译成机器码并且保存下来，减少解释执行的时间开销，从而达到提高效率的目的。



对于该问题的回答应该是宽泛的，从Java语言的特点，平台的优缺点，jdk，jre，jvm相关的内容，都可以去说。但是宽泛的问题容易给自己挖坑。



## Exception和Error有什么区别

### 典型回答

Exception和Error都继承了Throwable类，在Java中只有Throwable类型的实例才可以被抛出（throw）活着不活（catch），它是异常处理机制的基本组成类型。

Exception和Error体现了Java平台设计者对于不同异常的分类，Exception是程序正常运行中，可以预料到的意外情况，可能并且应该被捕获，进行相应的处理

Error是指在正常的情况下，不大可能出现的情况，绝大多数的Error都会导致程序比如JVM本身处于非正常的不可恢复的，所以不方便捕获也不需要补货，常见的必入outOfmemoryError等，都是Error的子类。

Exception又分为可检查（checked）异常和不检查（unchecked）异常，可检查异常在源代码中必须显示的进行捕获处理，这是编译期检查的一部分，前面我介绍的不可检查Error，是Throwable不是Exception

不检查异常就是所谓的运行时异常，类似的Null Pointer Exception、Array IndexOutOfBounds Exception之类，通常是可以通过编码避免的逻辑错误，具体根据需要来判断是否需要捕获，并不会做编译器强制要求。



### 考点分析

一、理解Throwable、Exception、Error的设计和分类，比如掌握那些应用最为广泛的子类，以及如何自定义异常，其实就是异常的分类

![image-20210829173256309](Java核心技术36讲.assets/image-20210829173256309.png)

例如：NoClassDefFoundError和ClassNotFoundException有什么区别

1. 首先NoClassDefFoundError是Error的子类，ClassNotFoundException是Exception的子类

#### ClassNotFoundException：

当使用类加载器的加载某个类的时候，发现所有的path下面都没有找到，从引导类路径，扩展类路径到当前的classpath下都没有找到，就会抛出ClassNotFoundException异常，比如，加载JDBC驱动包的时候，以来的jar包不在classpath下，就会抛出该异常。

执行以下方法的时候容易抛出这些异常

```java
Class.forName()
ClassLoader.loadClass()
ClassLoader.findSystemClass()
```



#### NoClassDefFoundError

1. 编译的时候存在的某个类，但是运行的时候却找不到了

```Java
public class A {
 
    public void hello(){
 
        System.out.println("A hello");
    }
 
}
 
 class B {
 
     public static void main(String[] args) {
 
         A a=new A();
 
     }
 
}
```

上面的Java类编译后产生两个类文件，一个A.class，一个B.class，如果在编译后删除了A的class文件，然后直接执行B的main方法，就会抛出NoClassDefFoundError错误，因为当执行到 A a=new A()；这一步的时候，jvm认为这个类肯定在当前的classpath里面的，要不然编译都不会通过，更不用提执行了。所以直接抛出error，认为这个问题很严重

2. 类初始化失败，还继续使用这个类，也会导致报该错误

```java
//声明类
public class  Loading {
 
    static double i=1/0;//故意使得类初始化失败.
 
    public static void print(){
 
        System.out.println("123");
    }
 
}

//使用类
public static void main(String[] args) {
 
        try {
            double i=Loading.i;
        }catch (Throwable e){
        //此处，必须用Throwable，用Exception会直接退出.
            System.out.println(e);
        }
        //继续使用.
        Loading.print();
 
 
    }
    



```

报错如下

```java
Exception in thread "main" java.lang.NoClassDefFoundError: Could not initialize class class_loader.exception.Loading
java.lang.ExceptionInInitializerError
    at class_loader.exception.NoClassFoundErrorTest.main(NoClassFoundErrorTest.java:18)
    at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke(Method.java:498)

```

#### 总结

1. 当使用反射或者类加载器的loadClass方法去动态的加载一个所有classpath里面都不存在的类，类加载器中运行时的load阶段就会直接抛出ClassNotFoundException异常。另外jvm认为这个异常是可以被预知的需要提前被check。
2. 在编译时期正常，但是在运行时执行new关键词的时候，发现依赖类找不到，或者对于初始化失败的一个类，再次访问其境台成员或者方法，会直接抛出NoClassDefFoundError
3. 前者侧重在类加载器加载阶段找不到类信息，后者侧重在使用阶段出现问题比如实例化依赖类找不到或者类本身就初始化失败了



二、理解Java语言中操作Throwable的元素和实践

try-catch-finally：

注意只有finally对应的try块代码被执行了，finally里面的代码才会被执行

throw：在代码中抛出一个异常

throws：throws是方法可能抛出异常的声明







