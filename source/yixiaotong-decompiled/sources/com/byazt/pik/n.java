package com.byazt.pik;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 903, 46})
public class n {
    public String c;
    public long tt;
    public long ve;

    public long c() {
        return this.tt;
    }

    public void c(long j) {
        this.tt = j;
    }

    public void c(String str) {
        this.c = str;
    }

    public String getType() {
        return this.c;
    }

    public long tt() {
        return this.ve;
    }

    public void tt(long j) {
        this.ve = j;
    }

    public boolean ve() {
        return CrashHianalyticsData.TIME.equals(this.c);
    }
}
