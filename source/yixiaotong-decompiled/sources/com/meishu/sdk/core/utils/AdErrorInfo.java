package com.meishu.sdk.core.utils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AdErrorInfo {
    public static int LOAD_ERROR = 1;
    public static int RENDER_ERROR = 2;
    private int code;
    private int errorType;
    private String message;

    public AdErrorInfo(int i, int i2, String str) {
        this.errorType = i;
        this.code = i2;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public int getErrorType() {
        return this.errorType;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setErrorType(int i) {
        this.errorType = i;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
