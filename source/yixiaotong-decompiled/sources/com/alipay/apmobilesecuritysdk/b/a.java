package com.alipay.apmobilesecuritysdk.b;

import com.alipay.security.mobile.module.http.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class a {
    private static a b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1593a = 0;

    public static a a() {
        return b;
    }

    public final void a(int i) {
        this.f1593a = i;
    }

    public final int b() {
        return this.f1593a;
    }

    public final String c() {
        String strA = d.a();
        if (com.alipay.security.mobile.module.a.a.b(strA)) {
            return strA;
        }
        int i = this.f1593a;
        if (i == 1) {
            return "http://mobilegw.stable.alipay.net/mgw.htm";
        }
        if (i != 3) {
            return i != 4 ? "https://mobilegw.alipay.com/mgw.htm" : "http://mobilegw.aaa.alipay.net/mgw.htm";
        }
        return "http://mobilegw-1-64.test.alipay.net/mgw.htm";
    }
}
