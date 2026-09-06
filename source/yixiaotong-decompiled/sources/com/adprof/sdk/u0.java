package com.adprof.sdk;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class u0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1449a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f751a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    public u0(ui uiVar) {
        if (uiVar != null) {
            if (pk.m706a()) {
                pk.d("server返回数据 ad_app  = " + uiVar);
            }
            this.f751a = uiVar.f756a;
            this.b = uiVar.f757b;
            this.c = uiVar.c;
            this.i = uiVar.j;
            this.j = uiVar.e;
            Integer num = uiVar.f755a;
            if (num != null) {
                num.intValue();
            }
            Double d = uiVar.f1461a;
            if (d != null) {
                d.floatValue();
            }
            Integer num2 = uiVar.b;
            this.f1449a = num2 != null ? num2.intValue() : 0;
            this.d = uiVar.f;
            this.e = uiVar.g;
            this.f = uiVar.h;
            this.g = uiVar.i;
            this.h = uiVar.k;
        }
    }
}
