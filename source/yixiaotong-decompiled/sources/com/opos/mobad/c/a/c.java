package com.opos.mobad.c.a;

import android.content.Context;
import android.os.Bundle;
import com.opos.mobad.provider.strategy.AppInfo;
import com.opos.mobad.provider.strategy.StrategyInfo;
import com.opos.mobad.r.a.u;
import com.opos.mobad.r.a.v;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f6694a;
    private String b;
    private com.opos.mobad.provider.strategy.b c;

    public interface a {
        void a();

        void a(u uVar, long j);
    }

    public interface b {
        void a();

        void a(Bundle bundle);
    }

    public c(Context context, String str, String str2) {
        this.f6694a = str;
        this.b = str2;
        this.c = new com.opos.mobad.provider.strategy.b(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<v> list, long j) {
        com.opos.cmn.an.f.a.b("DispatchController", "write strategy:", list);
        try {
            Bundle bundle = new Bundle();
            for (v vVar : list) {
                bundle.putByteArray(vVar.q, v.c.b(vVar));
            }
            this.c.a(this.f6694a, new StrategyInfo(j, bundle));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("DispatchController", "write strategy fail", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(u uVar, long j) {
        com.opos.cmn.an.f.a.b("DispatchController", "write app:" + uVar);
        try {
            this.c.a(this.b, this.f6694a, new AppInfo(j, u.c.b(uVar)));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("DispatchController", "write app fail", e);
        }
    }

    public void a(final a aVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    AppInfo appInfoB = c.this.c.b(c.this.f6694a);
                    if (appInfoB == null) {
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                            return;
                        }
                        return;
                    }
                    u uVarA = u.c.a(appInfoB.b);
                    long j = appInfoB.f7277a;
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(uVarA, j);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("DispatchController", "readAppInfo fail", e);
                    a aVar4 = aVar;
                    if (aVar4 != null) {
                        aVar4.a();
                    }
                }
            }
        });
    }

    public void a(final b bVar) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.c.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle bundleA = c.this.c.a(c.this.f6694a);
                    if (bundleA != null) {
                        b bVar2 = bVar;
                        if (bVar2 != null) {
                            bVar2.a(bundleA);
                            return;
                        }
                        return;
                    }
                    com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail with strategyInfo null");
                    b bVar3 = bVar;
                    if (bVar3 != null) {
                        bVar3.a();
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("DispatchController", "readPosStrategy fail", e);
                    b bVar4 = bVar;
                    if (bVar4 != null) {
                        bVar4.a();
                    }
                }
            }
        });
    }

    public void a(final u uVar, final long j) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.c.3
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(uVar.c().a(new ArrayList(0)).b(), j);
                c.this.a(uVar.g, uVar.j != null ? uVar.j.longValue() : 0L);
            }
        });
    }
}
