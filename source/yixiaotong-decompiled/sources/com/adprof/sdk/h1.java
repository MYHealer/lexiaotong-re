package com.adprof.sdk;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class h1 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1201a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f329a;

    public h1(ej ejVar) {
        this.f1201a = 10;
        if (ejVar != null) {
            this.f328a = ejVar.f261a;
            Integer num = ejVar.f1152a;
            this.f1201a = num != null ? num.intValue() : 10;
            if (pk.m706a()) {
                pk.d("\ndelayevent delay = " + this.f1201a + "  url = " + this.f328a);
            }
        }
    }
}
