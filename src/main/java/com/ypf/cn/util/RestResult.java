package com.ypf.cn.util;

public final class RestResult<T> {

    public static final String CODE_SUCCESS = "0000";

    // public static final String MSG_SUCCESS = "鎿嶄綔鎴愬姛";
    public static final String MSG_SUCCESS = "";

    // public static final String CODE_SUCCESS2 = "0";

    public static final String CODE_FAIL = "9999";

    public static final String MSG_FAIL = "失败";

    public static final RestResult<Object> OK = new RestResult<Object>(CODE_SUCCESS);

    public static final RestResult<Object> FAIL = new RestResult<Object>(CODE_FAIL, MSG_FAIL);

    private String code = CODE_SUCCESS;

    private String msg = MSG_SUCCESS;

    private T data;

    public RestResult(String code) {
        super();
        this.code = code;
    }

    public RestResult(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public RestResult(String code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> RestResult<T> ok() {
        return new RestResult<T>(CODE_SUCCESS, MSG_SUCCESS);
    }

    public static <T> RestResult<T> ok(T data) {
        return new RestResult<T>(CODE_SUCCESS, MSG_SUCCESS, data);
    }

    public static <T> RestResult<T> fail() {
        return new RestResult<T>(CODE_FAIL, MSG_FAIL);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RestResult [code=");
        builder.append(code);
        builder.append(", msg=");
        builder.append(msg);
        builder.append(", data=");
        builder.append(data);
        builder.append("]");
        return builder.toString();
    }

}

