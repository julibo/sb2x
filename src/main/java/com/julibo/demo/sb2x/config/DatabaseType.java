package com.julibo.demo.sb2x.config;

/**
 * 列出数据源类型
 * @author carson
 * @date 2019-11-25
 */
public enum DatabaseType {
    /**
     * 主从数据源
     */
    master("write"), slave("read");

    private String name;

    DatabaseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DatabaseType{" + "name='" + name + '\'' + "}";
    }

}
