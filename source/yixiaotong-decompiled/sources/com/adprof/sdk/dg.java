package com.adprof.sdk;

import android.net.TrafficStats;
import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class dg implements Runnable, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cg f1129a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fj f219a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final li f220a;

    public dg(cg cgVar, li liVar, fj fjVar) {
        this.f220a = liVar;
        this.f1129a = cgVar;
        this.f219a = fjVar;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return (obj == null && hashCode() == obj.hashCode()) ? 0 : 1;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        li liVar = this.f220a;
        SystemClock.elapsedRealtime();
        try {
            liVar.getClass();
            int i = kp.f1273a;
            liVar.m676a();
            TrafficStats.setThreadStatsTag(liVar.b);
            fg fgVarA = this.f1129a.a(liVar);
            if (fgVarA.f293a) {
                synchronized (liVar.f446a) {
                    z = liVar.f448a;
                }
                if (z) {
                    liVar.b();
                    return;
                }
            }
            ri riVarA = liVar.a(fgVarA);
            liVar.m675a();
            this.f219a.a(liVar, riVarA);
            synchronized (liVar.f446a) {
            }
        } catch (jp e) {
            SystemClock.elapsedRealtime();
            liVar.getClass();
            this.f219a.a(liVar, e);
            liVar.b();
        } catch (Throwable th) {
            Log.e("GT-Volley", lp.a("Unhandled exception %s", th.toString()), th);
            jp jpVar = new jp(th);
            SystemClock.elapsedRealtime();
            this.f219a.a(liVar, jpVar);
            liVar.b();
        }
    }
}
