package com.smpark.springexample.rest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponse<T> {

    private boolean result; // 결과 여부
    private String message; // 결과 메세지
    private int responseCode; // 결과 코드
    private T data; // 결과 데이터


    public DataResponse(T data) {
        this.data = data;

        result = true;
        message = "success";
        responseCode = 1;
    }

    public void setData(T data) {
        this.data = data;

        result = true;
        message = "success";
        responseCode = 1;
    }

    public DataResponse() {
        this.result = false;
        this.message = "seccess";
        this.responseCode = 0;
    }

    public void setError(String message, int responseCode) {
        this.result = false;
        this.message = message;
        this.responseCode = responseCode;
    }

}