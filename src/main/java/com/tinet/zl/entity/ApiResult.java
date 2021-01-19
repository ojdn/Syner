package com.tinet.zl.entity;

import java.io.Serializable;

/**
 * @Author: zhang lei
 * @Describe: All things are difficult before they are easy.
 * @CreatTime: 2021-01-18-15-52
 */
public class ApiResult<T> implements Serializable {
    public static final String SUCCESS_DESCRIPTION = "成功";
    public static final int SUCCESS_RESULT = 0;
    public static final int FAIL_RESULT = -1;
    private int result;
    private String description;
    private int errorCode;
    private T data;

    public ApiResult() {
    }

    public ApiResult(int result) {
        this.result = result;
        if (result == 0) {
            this.description = "成功";
        }

    }

    public ApiResult(T data) {
        this.result = 0;
        this.description = "成功";
        this.data = data;
    }

    public ApiResult(int result, String description) {
        this.result = result;
        this.description = description;
    }

    public ApiResult(int result, String description, int errorCode) {
        this.result = result;
        this.description = description;
        this.errorCode = errorCode;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
        if (result == 0) {
            this.description = "成功";
        }

    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return super.toString() + ", result=" + this.result + ", description=" + this.description + ", errorCode=" + this.errorCode;
    }
}
