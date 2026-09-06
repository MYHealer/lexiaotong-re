package com.huawei.secure.android.common.util;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SecurityCommonException extends Exception {
    private static final long c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f4575a;
    private String b;

    public SecurityCommonException() {
    }

    public String getMsgDes() {
        return this.b;
    }

    public String getRetCd() {
        return this.f4575a;
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f4575a = str;
        this.b = str2;
    }
}
