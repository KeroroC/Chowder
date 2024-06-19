package xyz.keroro.designPattern.singleton;

/**
 * 懒汉式单例
 * @author wangpeng
 * @since 2024年01月15日 19:06
 */
public class LazyInitializationSingleton {

    private static volatile LazyInitializationSingleton instance;

    private String name;

    private LazyInitializationSingleton() {}

    /**
     * 多线程情况下会有问题，简单粗暴地给方法加synchronized修饰的话性能又降低了
     * @return ins
     */
    public static LazyInitializationSingleton getInstance() {
        if (instance == null) {
            instance = new LazyInitializationSingleton();
        }
        return instance;
    }

    /**
     * 双重检查锁定(Double-Check Locking)实现饿汉式单例
     * 需要volatile修饰变量，确保线程访问到的数据是实时的没有缓存，也会降低性能
     * @return ins
     */
    public static LazyInitializationSingleton getInstance2() {
        if (instance == null) {
            synchronized (LazyInitializationSingleton.class) {
                if (instance == null) {
                    instance = new LazyInitializationSingleton();
                }
            }
        }
        return instance;
    }
}
