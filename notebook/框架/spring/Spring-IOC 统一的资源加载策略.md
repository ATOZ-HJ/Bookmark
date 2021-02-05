### Spring - IOC 统一资源加载策略



#### 一、统一的资源定义 Resource 接口

1. ##### 类图结构

<img src="static/image-20210205112532284.png" alt="image-20210205112532284" style="zoom:150%;" />



针对不同的资源类型，提供了不同的具体实现：

- InputStreamSource : 资源定义的顶层接口，定义了获取输入流的接口方法
- Resource : Spring所有资源的统一抽象和访问接口
- AbstractResource: 抽象类，对Resouce接口的默认实现，子类可以根据实际情况，进行不同的实现，如果需要自定义Resouce，则可以直接继承该类，并实现自己的方法。
- FileSystemResource : 对 java.io.file 的封装，可以查看源码的构造方法。

- ByteArrayResource ：对字节数组进行了封装，字节数组可以构造成 ByteArrayInputStream 字节数组输入流
- UrlResource ：对网络资源的定义，内部对 java.net.url 进行了封装