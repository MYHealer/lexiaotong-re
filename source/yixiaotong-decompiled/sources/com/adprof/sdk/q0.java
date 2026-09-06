package com.adprof.sdk;

import android.text.TextUtils;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public final class q0 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1373a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e2 f637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i1 f638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public o1 f639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p0 f640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u0 f641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public y2 f642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z2 f643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f644a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f646b;
    public int c;
    public int d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f636a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f645a = false;

    public q0(zi ziVar) {
        this.c = 1;
        if (ziVar != null) {
            try {
                if (pk.m706a()) {
                    aj.m574a(ziVar);
                }
            } catch (Throwable unused) {
            }
            this.f644a = ziVar.f918a;
            this.f646b = ziVar.f919b;
            Integer num = ziVar.f917a;
            this.f1373a = num != null ? num.intValue() : 0;
            Integer num2 = ziVar.c;
            this.b = num2 != null ? num2.intValue() : 0;
            if (!TextUtils.isEmpty(ziVar.f920c)) {
                this.f643a = new z2(ziVar.f920c);
            }
            Integer num3 = ziVar.d;
            this.c = num3 != null ? num3.intValue() : 1;
            if (!z6.m736a() && a(this.c) && !b()) {
                this.c = 1;
            }
            ij ijVar = ziVar.f913a;
            if (ijVar != null) {
                this.f638a = new i1(ijVar);
            }
            cj cjVar = ziVar.f1558a;
            if (cjVar != null) {
                this.f640a = new p0(cjVar);
            }
            ui uiVar = ziVar.f916a;
            if (uiVar != null) {
                this.f641a = new u0(uiVar);
            }
            sj sjVar = ziVar.f915a;
            if (sjVar != null) {
                this.f642a = new y2(sjVar);
            }
            mj mjVar = ziVar.f914a;
            if (mjVar != null) {
                this.f639a = new o1(mjVar);
            }
            Integer num4 = ziVar.b;
            if (num4 != null) {
                num4.intValue();
            }
            Integer num5 = ziVar.f;
            this.d = num5 != null ? num5.intValue() : 0;
        }
    }

    public int a() {
        return this.c;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public o1 m707a() {
        return this.f639a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public z2 m708a() {
        return this.f643a;
    }

    public final boolean a(int i) {
        return i == 3 || i == 4;
    }

    public final boolean b() {
        ul ulVar;
        z2 z2Var = this.f643a;
        return (z2Var == null || (ulVar = z2Var.f891a) == null || !"1".equals(ulVar.j)) ? false : true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m709a() {
        p0 p0Var = this.f640a;
        return p0Var != null && p0Var.f1353a == 1;
    }
}
