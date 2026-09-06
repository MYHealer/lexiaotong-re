package com.byazt.ik;

import client.android.yixiaotong.util.TimeUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
@com.byazt.zqa.c(c = {0, 1, 2058, 13})
public class tt {
    public String c;
    public long n;
    public String tt;
    public String uj;
    public String ve;

    public String c() {
        return this.uj;
    }

    public void c(long j) {
        this.n = j;
    }

    public void c(String str) {
        this.c = str;
    }

    public void tt(String str) {
        this.tt = str;
    }

    public void uj(String str) {
        this.uj = str;
    }

    public void ve(String str) {
        this.ve = str;
    }

    public String toString() {
        return "MediationBehaviorDbData{primeRit='" + this.c + "', adnRit='" + this.tt + "', adnName='" + this.ve + "', adAction='" + this.uj + "', timeStamp=" + new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date(this.n)) + '}';
    }
}
