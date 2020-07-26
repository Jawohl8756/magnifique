package com.wunderbar.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;


/**
 * @author Rommel
 * @date 2020/3/22 17:32
 * @description Java 8 Meta Space 演示
 * <p>
 * JVM参数设置
 * -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m
 * <p>
 * Java8及以后的版本使用Metaspace来代替永久代
 * <p>
 * Metaspace是方法区在Hotspot中的实现，它与持久代最大的区别在于：Metaspace并不在虚拟机内存中而是使用本地内存
 * 也即在java8中，class metadata(the virtual machines internal presentation of java class),被存储在叫做
 * Metaspace的native memory
 * <p>
 * 永久代(java8后被原空间Metaspace取代了)存放了以下信息:
 * 1.虚拟机加载的类信息
 * 2.常量池
 * 3.静态变量
 * 4.即时编译后的代码
 * <p>
 * 模拟Metaspace空间溢出，我们不断生成类往元空间灌，类占据的空间总是会超过Metaspace指定的空间大小
 */
public class MetaSpaceDemo {
    static class OOMTest {}

    public static void main(String[] args) {
        int i = 0;//模拟计数器

        try {

            while (true) {
                i++;
                Enhancer enhancer=new Enhancer();
                enhancer.setSuperclass(OOMTest.class);
                enhancer.setUseCache(false);
                enhancer.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                enhancer.create();
            }

        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println("********第多少次后发生了异常:" + i);
        }
    }



}

