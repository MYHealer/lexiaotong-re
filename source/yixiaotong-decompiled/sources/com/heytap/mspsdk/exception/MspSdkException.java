package com.heytap.mspsdk.exception;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class MspSdkException extends RuntimeException {
    private int code;

    public MspSdkException(int i, String str) {
        super(str);
        this.code = i;
    }

    public MspSdkException(String str, Throwable th, int i) {
        super(str, th);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "MspSdkException{code=" + this.code + ",message=" + super.toString() + '}';
    }
}
