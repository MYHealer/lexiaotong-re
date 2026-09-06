package com.byazt.hr;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 15})
public abstract class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f2310a;
    public String c;
    public int n;
    public String tt;
    public String uj;
    public String ve;

    public String a() {
        return this.uj;
    }

    public boolean c() {
        return this.f2310a;
    }

    public String n() {
        return this.ve;
    }

    public int sp() {
        return this.n;
    }

    public String tt() {
        return this.c;
    }

    public String ve() {
        return this.tt;
    }

    public boolean x() {
        return this.n == 1;
    }

    public String uj() {
        return TextUtils.isEmpty(this.tt) ? this.c : this.c + "_" + this.tt;
    }

    public uj(String str, String str2, String str3, String str4, int i) {
        this.c = str;
        this.ve = str3;
        this.n = i;
        this.tt = str2;
        this.f2310a = !TextUtils.isEmpty(str2);
        this.uj = str4;
    }

    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.c + "', showRulesVersion='" + this.ve + "', timingMode=" + this.n + '}';
    }
}
