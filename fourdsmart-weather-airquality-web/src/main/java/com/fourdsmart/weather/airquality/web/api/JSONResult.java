package com.fourdsmart.weather.airquality.web.api;

/**
 * @author 作者 E-mail: caojianfeng@4dsmart.cn
 * @version 1.0
 * @date 创建时间：16/8/10
 */
public class JSONResult<T> {

    private boolean success;

    private T data;

    private String error;

    public JSONResult(boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public JSONResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "WeatherResult [success=" + success + ", data=" + data + ", error=" + error + "]";
    }

}
