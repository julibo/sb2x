package com.julibo.demo.sb2x.config;

/**
 * 保存一个线程安全的DatabaseType容器
 * @author carson
 * @date 2019-11-25
 */
public class DatabaseContextHolder {

    private static final ThreadLocal<DatabaseType> contextHolder = new ThreadLocal<>();

    public static void setDatabaseType(DatabaseType type) {
        contextHolder.set(type);
    }

    public static DatabaseType getDatabaseType() {
        return contextHolder.get();
    }

}
