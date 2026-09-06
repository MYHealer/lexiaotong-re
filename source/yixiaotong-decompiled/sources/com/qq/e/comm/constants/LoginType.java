package com.qq.e.comm.constants;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public enum LoginType {
    Unknow(0),
    WeiXin(1),
    QQ(2);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f8497a;

    LoginType(int i) {
        this.f8497a = i;
        ordinal();
    }

    public int getValue() {
        return this.f8497a;
    }
}
