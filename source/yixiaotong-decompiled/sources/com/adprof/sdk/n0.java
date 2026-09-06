package com.adprof.sdk;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class n0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f492a;
    public int b;
    public int c;

    public n0(qj qjVar) {
        if (qjVar != null) {
            this.f492a = qjVar.f680a;
            Integer num = qjVar.f1387a;
            this.f1314a = num != null ? num.intValue() : 0;
            Integer num2 = qjVar.b;
            this.b = num2 != null ? num2.intValue() : 0;
            Integer num3 = qjVar.c;
            this.c = num3 != null ? num3.intValue() : 0;
        }
    }
}
