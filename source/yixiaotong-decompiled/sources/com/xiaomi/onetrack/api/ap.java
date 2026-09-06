package com.xiaomi.onetrack.api;

import com.xiaomi.onetrack.OneTrack;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class ap implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ao f9415a;

    public ap(ao aoVar) {
        this.f9415a = aoVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (OneTrack.isRestrictGetNetworkInfo()) {
            c.a().f();
        }
    }
}
