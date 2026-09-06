package com.xiaomi.onetrack.api;

import android.text.TextUtils;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f9434a;

    public n(m mVar) {
        this.f9434a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            c.a().a(this.f9434a.b);
            com.xiaomi.onetrack.b.a.a().a(this.f9434a.f.getAppId());
            if (com.xiaomi.onetrack.util.z.b(this.f9434a.f.getAdEventAppId())) {
                c.a().c();
                com.xiaomi.onetrack.b.a.a().a(this.f9434a.f.getAdEventAppId());
            }
            if (com.xiaomi.onetrack.util.aa.B() == 0) {
                com.xiaomi.onetrack.util.aa.n(System.currentTimeMillis());
            }
            if (!TextUtils.isEmpty(this.f9434a.f.getInstanceId())) {
                com.xiaomi.onetrack.util.o.a().a(this.f9434a.f.getInstanceId());
            }
            this.f9434a.m();
            com.xiaomi.onetrack.util.d.a();
            com.xiaomi.onetrack.c.i.c(false);
        } catch (Throwable th) {
            com.xiaomi.onetrack.util.p.b(ijiami_1011.s.s.s.d(new byte[]{43, 92, 92, 100, 19, 5, 2, 15, 47, 15, 65}, "d290ad"), ijiami_1011.s.s.s.d(new byte[]{88, 94, 95, 70, 70, 52, 14, Ascii.SYN, 13, 7, 67, 32, 73, 85, 85, 71, Ascii.DC2, 12, 19, 68, 3, 26, 84, 6, 68, 68, 83, Ascii.DC2, Ascii.DC2, 11, 19, 11, 17, 3, 83, 9, 84, 10}, "1062fc") + th.getMessage());
        }
    }
}
