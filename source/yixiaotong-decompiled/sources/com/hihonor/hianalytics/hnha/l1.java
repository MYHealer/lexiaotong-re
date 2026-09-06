package com.hihonor.hianalytics.hnha;

import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f3656a = false;
    private volatile long b = 0;
    private a c = null;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f3657a = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
        boolean b;
        private long c;

        a(long j) {
            this.f3657a += "_" + j;
            this.c = j;
            this.b = true;
            l1.this.f3656a = false;
        }

        private void a(long j) {
            j2.c("SessionWrapper", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.f3657a = string;
            this.f3657a = string.replace(com.huawei.openalliance.ad.constant.x.A, "");
            this.f3657a += "_" + j;
            this.c = j;
            this.b = true;
        }

        private boolean a(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private boolean b(long j, long j2) {
            return j2 - j >= 1800000;
        }

        void b(long j) {
            if (l1.this.f3656a) {
                l1.this.f3656a = false;
                a(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                a(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }
    }

    public void a() {
        this.c = null;
        this.b = 0L;
        this.f3656a = false;
    }

    public synchronized void a(long j) {
        if (this.b == 0) {
            j2.g("SessionWrapper", "OnBackground() need to be called before!");
        } else {
            this.f3656a = j - this.b > 30000;
            this.b = 0L;
        }
    }

    public String b() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.f3657a;
        }
        j2.g("SessionWrapper", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    void b(long j) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.b(j);
        } else {
            j2.c("SessionWrapper", "Session is first flush");
            this.c = new a(j);
        }
    }

    public synchronized void c(long j) {
        this.f3656a = true;
        this.b = j;
    }

    public boolean c() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b;
        }
        j2.g("SessionWrapper", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
