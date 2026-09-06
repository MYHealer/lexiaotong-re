package com.hihonor.dlinstall.ability.base;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class ResponseData<T> {
    public T data;
    public int errorCode;
    public String errorMessage;
    public int marketType;

    public ResponseData(T t, int i, int i2, String str) {
        this.data = t;
        this.marketType = i;
        this.errorCode = i2;
        this.errorMessage = str;
    }

    public ResponseData(T t, int i, String str) {
        this.marketType = 0;
        this.data = t;
        this.errorCode = i;
        this.errorMessage = str;
    }

    public String toString() {
        return "ResponseData{errorCode=" + this.errorCode + ", errorMessage='" + this.errorMessage + "', data=" + this.data + ", marketType=" + this.marketType + '}';
    }
}
