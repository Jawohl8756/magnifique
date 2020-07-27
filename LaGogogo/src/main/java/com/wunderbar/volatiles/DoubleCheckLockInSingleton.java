package com.wunderbar.volatiles;/**
 *
 */

/**
 * @author katze
 * @date 2020/7/27 17:33
 * @description 单例模式的双重检查锁using volatile
 */
public class DoubleCheckLockInSingleton {

    //声明一个变量，用volatile修饰
    private static volatile DoubleCheckLockInSingleton singleton;

    //私有化构造函数，不让外界new对象
    private DoubleCheckLockInSingleton() {
    }

    /**
     * 获取单例对象的过程中，进行双重检查
     * */
    public static DoubleCheckLockInSingleton getInstance() {
        if (singleton == null) {
            synchronized (DoubleCheckLockInSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckLockInSingleton();
                }
            }
        }
        return singleton;
    }
}

