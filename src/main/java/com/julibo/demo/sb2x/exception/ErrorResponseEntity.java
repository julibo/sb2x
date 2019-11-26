package com.julibo.demo.sb2x.exception;

import lombok.Data;

/**
 * 异常信息模版
 * @author carson
 * @date 2019-11-25
 */
@Data
public class ErrorResponseEntity {

    private int code;
    private String message;

    public ErrorResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
