package com.wunderbar.lock;

import com.wunderbar.cas.TimeUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Rommel
 * @date 2020/3/1 20:45
 * @description 读写锁 ，共享锁
 * 读锁，是共享锁
 * 写锁，是独占锁
 * <p>
 * 多个线程同事读取一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是
 * 如果有一个线程想去写共享资源，就不应该有其他项城可以对该资源进行读取或者写入
 * 小总结：
 * 读-读能共存
 * 读-写不能共存
 * 写-写不能共存
 * <p>
 * 理论：编码：总结
 * IT开发工程师成功之道
 * <p>
 * 方法论
 * <p>
 * Before |  After
 * <p>
 * 写操作，原子独占,整个过程必须是一个完整的统一体，中间不许被分割，被打断
 * */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) {
        //线程操作资源类
        MyCache myCache =new MyCache();

        //5个线程，分别设置数据
        for(int i=1;i<=5;i++){
            final int tempInt =i;
            new Thread(()->{
                try {
                    myCache.put(tempInt+"",tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }

        //5个线程，分别读取数据
        for(int i=1;i<=5;i++){
            final int tempInt =i;
            new Thread(()->{
                try {
                    myCache.get(tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }

    }
}

/**
 *
 *
 * 缓存资源类，Redis ,Memcached，都需要同读同写
 *
 * */
class MyCache {//缓存类： 读 写 清空

    private volatile Map<String, Object> map = new HashMap<>();
    //private Lock lock =new ReentrantLock();//宁可错杀一千，绝不放过一个。

    private ReentrantReadWriteLock reentrantReadWriteLock =new ReentrantReadWriteLock();//可重入读写锁，雌雄同体


    //缓存的写操作
    public void put(String key, Object value) throws InterruptedException {

        reentrantReadWriteLock.writeLock().lock();//加锁

        try {

            System.out.println(Thread.currentThread().getName() + "\t 正在写入..." + key);
            //暂停一会线程
            TimeUtil.SECONDS.sleep(100);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成...");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.writeLock().unlock();//解锁
        }


    }

    //缓存的读操作
    public void get(String key) throws InterruptedException {

        reentrantReadWriteLock.readLock().lock();//加锁
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取..." );
            //暂停一会线程
            TimeUtil.SECONDS.sleep(100);
            Object result=map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成..."+result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantReadWriteLock.readLock().unlock();//解锁
        }

    }

    //缓存的清理
    public void clearMap(){
        map.clear();

    }

}
