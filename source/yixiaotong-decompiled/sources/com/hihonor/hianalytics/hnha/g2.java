package com.hihonor.hianalytics.hnha;

import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3640a;
    private long b;
    private long c;

    public g2(String str, long j) {
        this.c = 0L;
        this.f3640a = str;
        this.b = j;
    }

    public g2(String str, long j, long j2) {
        this.f3640a = str;
        this.b = j;
        this.c = j2;
    }

    public String a() {
        return this.f3640a;
    }

    public long b() {
        return this.c;
    }

    public long c() {
        return this.b;
    }

    public boolean d() {
        return !TextUtils.isEmpty(this.f3640a) && this.b > 0 && this.c >= 0;
    }
}
