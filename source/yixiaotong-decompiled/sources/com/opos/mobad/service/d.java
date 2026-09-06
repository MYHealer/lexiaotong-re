package com.opos.mobad.service;

import android.content.Context;
import com.opos.cmn.an.custom.policy.PolicyConfig;
import com.opos.cmn.an.custom.policy.PolicyManager;
import com.opos.process.bridge.provider.BridgeDispatchException;
import com.opos.process.bridge.provider.BridgeExecuteException;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f7344a = new d();
    private boolean b = false;
    private com.opos.mobad.service.a.a d = new com.opos.mobad.service.a.a();
    private f c = new f("");

    private d() {
    }

    public static final synchronized void a() {
        d dVar = f7344a;
        f7344a = new d();
        dVar.d();
    }

    private static void a(final Context context) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.opos.cmn.func.a.a.b.a().a(context);
            }
        });
    }

    public static void a(Context context, com.opos.mobad.service.e.d.InterfaceC0994d interfaceC0994d, com.opos.mobad.service.e.d.g gVar, com.opos.mobad.service.e.d.f fVar, com.opos.mobad.service.e.d.e eVar, com.opos.mobad.service.b.d.a aVar, com.opos.mobad.ad.e eVar2) {
        com.opos.mobad.service.b.b.a().a(context);
        com.opos.mobad.service.b.b.a().a(aVar);
        if (!com.opos.cmn.an.f.a.b(context) && eVar2.b()) {
            b.a(context);
        }
        com.opos.mobad.service.e.d.a().a(context, interfaceC0994d, gVar, fVar, eVar);
        com.opos.cmn.c.a.b();
        com.opos.mobad.f.e.a().a(context);
    }

    private static void a(final Context context, final boolean z, final boolean z2) {
        if (context == null) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.d.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    new com.opos.mobad.provider.init.a(context).a(z, z2, com.opos.cmn.biz.a.d.a(context));
                } catch (BridgeDispatchException | BridgeExecuteException e) {
                    com.opos.cmn.an.f.a.d("ServiceManager", "", e);
                }
            }
        });
    }

    public static void a(Context context, boolean z, boolean z2, String str) {
        c();
        com.opos.cmn.c.a.a(context, z, z2);
        a(context, z, z2);
        com.opos.cmn.a.a.a(z, str);
    }

    public static void a(Context context, boolean z, boolean z2, boolean z3, com.opos.mobad.ad.e eVar) {
        if (z3) {
            com.opos.cmn.a.a.c();
        }
        a(context);
        com.opos.mobad.service.d.a.a().a(context, z2, eVar);
        com.opos.mobad.service.d.a.a().a(z);
        com.opos.mobad.service.e.b.n().a(context, eVar, z);
    }

    public static final com.opos.mobad.service.a.a b() {
        return f7344a.d;
    }

    private static void c() {
        HashMap map = new HashMap();
        map.put(PolicyConfig.UserData.KEY_IMEI, false);
        PolicyManager.getInstance().setPolicyConfig(new PolicyConfig.Builder().setCanReadUserDataMap(map).build());
    }

    private void d() {
        b.a();
        com.opos.mobad.service.e.d.a().t();
        com.opos.cmn.c.a.a();
        com.opos.mobad.service.e.b.n().o();
    }
}
