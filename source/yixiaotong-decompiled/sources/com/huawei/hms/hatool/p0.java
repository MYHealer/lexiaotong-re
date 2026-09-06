package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f4102a = 1800000;
    private volatile boolean b = false;
    private a c = null;

    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f4103a = UUID.randomUUID().toString().replace(com.huawei.openalliance.ad.constant.x.A, "");
        boolean b;
        private long c;

        a(long j) {
            this.f4103a += "_" + j;
            this.c = j;
            this.b = true;
            p0.this.b = false;
        }

        private boolean a(long j, long j2) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTimeInMillis(j2);
            return (calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6)) ? false : true;
        }

        private void b(long j) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String string = UUID.randomUUID().toString();
            this.f4103a = string;
            this.f4103a = string.replace(com.huawei.openalliance.ad.constant.x.A, "");
            this.f4103a += "_" + j;
            this.c = j;
            this.b = true;
        }

        private boolean b(long j, long j2) {
            return j2 - j >= p0.this.f4102a;
        }

        void a(long j) {
            if (p0.this.b) {
                p0.this.b = false;
                b(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                b(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }
    }

    public String a() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.f4103a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    void a(long j) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(j);
        } else {
            v.c("hmsSdk", "Session is first flush");
            this.c = new a(j);
        }
    }

    public boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
