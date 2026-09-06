package com.hihonor.hianalytics.mid.policy;

import com.hihonor.hianalytics.hnha.g;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.r3;
import com.hihonor.hianalytics.hnha.s3;
import com.hihonor.hianalytics.hnha.t3;
import com.hihonor.hianalytics.hnha.u;
import com.hihonor.hianalytics.process.b;
import com.hihonor.hianalytics.receiver.AnalyticsCloudConfigReceiver;
import com.hihonor.hianalytics.receiver.MonitorReceiver;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class a {
    private s3 d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MonitorReceiver f3702a = new MonitorReceiver();
    private final AnalyticsCloudConfigReceiver b = new AnalyticsCloudConfigReceiver();
    private final LifecycleMonitor c = new LifecycleMonitor();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        t3.f(new r3() { // from class: com.hihonor.hianalytics.mid.policy.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
    }

    public String a(boolean z) {
        return this.f3702a.a(z);
    }

    public void a() {
        if (!SystemUtils.a()) {
            j2.a("PolicyManager", "backgroundToReport userUnlock");
        } else {
            if (!g.v()) {
                j2.c("PolicyManager", "backgroundToReport not able");
                return;
            }
            j2.c("PolicyManager", "backgroundToReport tagSize=" + g.a().size());
            b.a("", 0, 5);
        }
    }

    public boolean b(boolean z) {
        return this.f3702a.b(z);
    }

    public void c() {
        s3 s3Var;
        String str;
        if (!SystemUtils.a()) {
            str = "periodToReport not canDirectAccessStorage";
        } else if (b(false)) {
            int iF = u.f();
            if (iF <= 0) {
                str = "periodToReport noEventRecord";
            } else {
                int iR = g.r();
                if (iR > 0) {
                    s3 s3Var2 = this.d;
                    if (s3Var2 == null) {
                        this.d = new s3(new Runnable() { // from class: com.hihonor.hianalytics.mid.policy.a$$ExternalSyntheticLambda1
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f$0.b();
                            }
                        });
                    } else {
                        t3.a(s3Var2);
                    }
                    int iC = r.c();
                    int i = iC - iF;
                    if (i <= 0) {
                        j2.c("PolicyManager", "periodToReport backInterval=" + r.b(i) + ",reportInterval=" + r.b(iR));
                        u.a(iC);
                        s3Var = this.d;
                    } else {
                        if (i >= iR) {
                            j2.c("PolicyManager", "periodToReport successInterval=" + r.b(i) + ",reportInterval=" + r.b(iR));
                            u.a(iC);
                            g.z();
                            t3.a(this.d, ((long) g.r()) * 1000);
                            b.a("", 0, 6);
                            return;
                        }
                        j2.a("PolicyManager", "periodToReport notAbleInterval=" + r.b(i) + ",reportInterval=" + r.b(iR));
                        s3Var = this.d;
                        iR -= i;
                    }
                    t3.a(s3Var, ((long) iR) * 1000);
                    return;
                }
                str = "periodToReport illegal reportInterval=" + iR;
            }
        } else {
            str = "periodToReport network not ready";
        }
        j2.a("PolicyManager", str);
    }

    public synchronized void d() {
        this.f3702a.a();
        this.b.a();
        this.c.d();
        c();
    }
}
