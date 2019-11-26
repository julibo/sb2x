package com.julibo.demo.sb2x.domain;

import java.util.Arrays;

/**
 * @author carson
 * @date 2019-11-25
 */
public enum SexEnum {

    /**
     * 性别
     */
    MAN(1, "男"),WOMAN(2, "女");

    private int key;

    private String value;

    SexEnum(int key, String value) {
        this.key = key;
        this.value =value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public static String getSexByKey(int key) {
        return Arrays.stream(SexEnum.values())
                .filter(SexEnum -> SexEnum.getKey() == key)
                .map(SexEnum -> SexEnum.getValue())
                .findFirst()
                .get();
    }
}
