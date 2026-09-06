package com.byazt.hr;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 42})
public class i extends uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2308a;
    public String sp;
    public long x;

    public void c(long j) {
        this.x = j;
    }

    public String da() {
        return this.sp;
    }

    public long i() {
        return this.f2308a;
    }

    public long sl() {
        return this.x;
    }

    public boolean t() {
        return this.x != 0;
    }

    public i(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        super(str, str2, str3, str4, i);
        this.x = 0L;
        this.f2308a = 0L;
        try {
            this.f2308a = Long.parseLong(str5);
        } catch (Exception unused) {
        }
        this.sp = str6;
    }

    public i(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7) {
        this(str, str2, str3, str4, i, str5, str6);
        this.x = 0L;
        try {
            this.x = Long.parseLong(str7);
        } catch (Exception unused) {
        }
    }

    @Override // com.byazt.hr.uj
    public boolean x() {
        return (TextUtils.isEmpty(this.sp) || this.f2308a == 0) ? false : true;
    }

    @Override // com.byazt.hr.uj
    public String toString() {
        return "BaseIntervalBean{waterfallId='" + this.c + "', showRulesVersion='" + this.ve + "', timingMode=" + this.n + "}IntervalPacingBean{pacing=" + this.f2308a + ", pacingRuleId='" + this.sp + "', effectiveTime=" + this.x + '}';
    }
}
