package com.byazt.pct;

import android.text.TextUtils;
import client.android.yixiaotong.v3.comman.AppTypeIdUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 130})
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2620a;
    public final int c;
    public final String n;
    public final String sp;
    public final String tt;
    public final String uj;
    public final String ve;
    public final String x;

    /* JADX INFO: renamed from: com.byazt.pct.m$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 56})
    static /* synthetic */ class AnonymousClass1 {
    }

    public /* synthetic */ m(c cVar, AnonymousClass1 anonymousClass1) {
        this(cVar);
    }

    public static c c() {
        return new c(null);
    }

    public static m c(String str, int i) {
        return new m(str, i);
    }

    private m(String str, int i) {
        this.tt = null;
        this.ve = null;
        this.uj = null;
        this.n = null;
        this.f2620a = str;
        this.sp = null;
        this.c = i;
        this.x = null;
    }

    private m(c cVar) {
        this.tt = cVar.c;
        this.ve = cVar.tt;
        this.uj = cVar.ve;
        this.n = cVar.uj;
        this.f2620a = cVar.n;
        this.sp = cVar.f2621a;
        this.c = 1;
        this.x = cVar.sp;
    }

    public static boolean c(m mVar) {
        return mVar == null || mVar.c != 1 || TextUtils.isEmpty(mVar.uj) || TextUtils.isEmpty(mVar.n);
    }

    public String toString() {
        return "methodName: " + this.uj + ", params: " + this.n + ", callbackId: " + this.f2620a + ", type: " + this.ve + ", version: " + this.tt + ", ";
    }

    @com.byazt.zqa.c(c = {0, 1, AppTypeIdUtil.NewDevice4GDrinkOTA_1, 600})
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f2621a;
        public String c;
        public String n;
        public String sp;
        public String tt;
        public String uj;
        public String ve;

        public c a(String str) {
            this.f2621a = str;
            return this;
        }

        public c c(String str) {
            this.c = str;
            return this;
        }

        public c n(String str) {
            this.n = str;
            return this;
        }

        public c sp(String str) {
            this.sp = str;
            return this;
        }

        public c tt(String str) {
            this.tt = str;
            return this;
        }

        public c uj(String str) {
            this.uj = str;
            return this;
        }

        public c ve(String str) {
            this.ve = str;
            return this;
        }

        public /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }

        private c() {
        }

        public m c() {
            return new m(this, (AnonymousClass1) null);
        }
    }
}
