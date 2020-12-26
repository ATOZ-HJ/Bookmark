package com.bookmark.designpatterns.singleton;

/**
 * @author: hj
 * @date: 2020-12-26 16:07
 * @description: 枚举实现
 *   1.线程安全
 *   2.可以防止反射攻击 ，其他实现不能保证，需要在构造方法中加入防止多次实例化的代码 --- 反射攻击：通过反射 ，使用setAccessible()方法可以将私有的构造方法方位级别设置为public
 *   3.多次序列化和反序列化后，不会创建多个对象； 而其他实现需要使用transient关键字修饰所有的变量
 **/
public enum  SingletonImpl6 {
    /**
     * 实例
     */
        INSTANCE;

    private String objName;

    private String getObjName() {
        return objName;
    }

    private void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        //单例测试
        SingletonImpl6 firstSingleton  = SingletonImpl6.INSTANCE;
        firstSingleton.setObjName("first name");
        System.out.println("firstSingleton = " + firstSingleton.getObjName());

        SingletonImpl6 secondSingleton = SingletonImpl6.INSTANCE;
        secondSingleton.setObjName("second name");
        System.out.println("firstSingleton = " + firstSingleton.getObjName());
        System.out.println("secondSingleton = " + secondSingleton.getObjName());

        //反射获取实例测试
        SingletonImpl6[] enumConstants = SingletonImpl6.class.getEnumConstants();
        for (SingletonImpl6 enumConstant : enumConstants) {
            System.out.println("objName = " + enumConstant.getObjName());
        }
    }
}
