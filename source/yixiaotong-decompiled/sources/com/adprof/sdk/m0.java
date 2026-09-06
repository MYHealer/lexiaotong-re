package com.adprof.sdk;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class m0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f455a;
    public int b;

    public m0(kj kjVar) {
        if (kjVar != null) {
            this.f455a = kjVar.f427a;
            Integer num = kjVar.f1268a;
            this.f1296a = num != null ? num.intValue() : 0;
            Integer num2 = kjVar.b;
            this.b = num2 != null ? num2.intValue() : 0;
        }
    }
}
