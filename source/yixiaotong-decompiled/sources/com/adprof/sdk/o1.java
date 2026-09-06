package com.adprof.sdk;

import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class o1 implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f1333a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f522a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Boolean f523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f524a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f525b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f526c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f527d;
    public int e;

    public o1(mj mjVar) {
        this.f522a = -1;
        this.b = -1;
        this.f523a = Boolean.FALSE;
        this.f524a = false;
        this.f525b = false;
        this.f526c = false;
        this.f1333a = 15.0d;
        this.c = 2;
        this.d = 3;
        this.f527d = false;
        this.e = 1;
        if (pk.m706a()) {
            pk.d("server返回数据 interaction = " + mjVar);
        }
        if (mjVar != null) {
            Integer num = mjVar.f491f;
            this.f522a = num != null ? num.intValue() : 0;
            Boolean bool = mjVar.c;
            this.f524a = bool != null ? bool.booleanValue() : false;
            Boolean bool2 = mjVar.b;
            this.f523a = Boolean.valueOf(bool2 != null ? bool2.booleanValue() : false);
            Double d = mjVar.f481a;
            this.f1333a = d != null ? d.doubleValue() : 15.0d;
            Long l = mjVar.f485b;
            this.c = l != null ? l.intValue() : 2;
            Long l2 = mjVar.f487c;
            this.d = l2 != null ? l2.intValue() : 3;
            Boolean bool3 = mjVar.d;
            this.f527d = bool3 != null ? bool3.booleanValue() : false;
            if (pk.m706a()) {
                pk.d("server返回数据 shake_sensitivity_f = " + this.f1333a + "   shake_detection = " + this.c + "  shake_hit_count = " + this.d);
            }
            Long l3 = mjVar.f489d;
            if (l3 != null) {
                l3.intValue();
            }
            Boolean bool4 = Boolean.TRUE;
            this.f525b = bool4.equals(mjVar.f);
            this.f526c = bool4.equals(mjVar.e);
            this.e = 1;
            Integer num2 = mjVar.g;
            this.b = num2 != null ? num2.intValue() : 0;
            Integer num3 = mjVar.f482a;
            if (num3 != null) {
                num3.intValue();
            }
            Integer num4 = mjVar.f484b;
            if (num4 != null) {
                num4.intValue();
            }
            Integer num5 = mjVar.f486c;
            if (num5 != null) {
                num5.intValue();
            }
        }
    }

    public boolean a() {
        return this.f525b;
    }
}
