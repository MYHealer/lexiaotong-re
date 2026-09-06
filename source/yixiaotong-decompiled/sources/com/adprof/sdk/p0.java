package com.adprof.sdk;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class p0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1353a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public o0 f542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f543a;
    public String b;

    public p0(cj cjVar) {
        this.f1353a = 0;
        if (cjVar != null) {
            try {
                this.f543a = cjVar.b;
                this.b = cjVar.c;
                Integer num = cjVar.f175a;
                this.f1353a = num != null ? num.intValue() : 0;
                pk.d("server返回数据  ddp = " + this.f1353a);
                wi wiVar = cjVar.f1113a;
                if (wiVar != null) {
                    this.f542a = new o0(wiVar);
                }
            } catch (Throwable th) {
                pk.b("adprofsdk", th);
            }
        }
    }
}
