package com.shj1995.simplifybackstage.core.controller;

import lombok.Getter;

/**
 * @author shj1995
 * @since 1.0.0
 */
public enum ApiErrorInfo {

    A0001("A0001", "客户端错误"),
    A0101("A0101", "缺少参数"),
    A0102("A0102", "参数错误"),
    B0001("B0001", "服务端错误"),
    B0101("B0101", "数据不存在"),
    C0001("C0001", "第三方错误");

    ApiErrorInfo(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    String code;
    @Getter
    String message;
}
