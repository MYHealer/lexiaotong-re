package com.heytap.msp.mobad.api.params;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class NativeAdError {
    public int code;
    public String msg;

    public NativeAdError(int i, String str) {
        this.code = i;
        this.msg = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "NativeAdError{code=" + this.code + ", msg='" + this.msg + "'}";
    }
}
