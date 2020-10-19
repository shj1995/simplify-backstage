package com.shj1995.simplifybackstage.core.controller;

import lombok.Data;

/**
 * @author shj1995
 * @since 1.0.0
 */
@Data
public class ApiResult<T> {
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误消息,主要是面向接口调用人员
     */
    private String errorMessage;
    /**
     * 用户提示,一般和错误消息一致,特殊情况会有不同
     */
    private String toast;
    /**
     * 接口响应数据
     */
    private T data;

    public static <E> ApiResult<E> newSuccessResult(E data) {
        return new ApiResult<E>("00000", "ok", data, "");
    }


    public static <E> ApiResult<E> newErrorResult(ApiErrorInfo errorInfo) {
        return new ApiResult<E>(errorInfo.getCode(), errorInfo.getMessage(), null, errorInfo.getMessage());
    }

    public static <E> ApiResult<E> newErrorResult(ApiErrorInfo errorInfo, E data) {
        return new ApiResult<E>(errorInfo.getCode(), errorInfo.getMessage(), data);
    }

    public static <E> ApiResult<E> newErrorResult(ApiErrorInfo errorInfo, String toast) {
        return new ApiResult<E>(errorInfo.getCode(), errorInfo.getMessage(), null, toast);
    }

    public static <E> ApiResult<E> newErrorResult(ApiErrorInfo errorInfo, E data, String toast) {
        return new ApiResult<E>(errorInfo.getCode(), errorInfo.getMessage(), data, toast);
    }

    private ApiResult(String code, String message, T data) {
        this.errorCode = code;
        this.errorMessage = message;
        this.data = data;
        this.toast = message;
    }

    private ApiResult(String code, String message, T data, String toast) {
        this.errorCode = code;
        this.errorMessage = message;
        this.data = data;
        this.toast = toast;
    }
}
