package com.opos.mobad.c.a;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import com.opos.mobad.b.a.j;
import com.opos.mobad.b.a.k;
import com.opos.mobad.b.a.m;
import com.opos.mobad.b.a.n;
import com.opos.mobad.b.a.o;
import com.opos.mobad.provider.record.ControlEntity;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f6690a;
    private String b;
    private int c;
    private int d;
    private com.opos.mobad.provider.record.a e;
    private AtomicReference<ControlEntity> f = new AtomicReference<>(null);
    private com.opos.cmn.i.a g = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.c.a.b.1
        @Override // com.opos.cmn.i.a.b
        public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
            if (b.this.e == null) {
                interfaceC0895a.b();
            } else {
                b.this.a(interfaceC0895a);
            }
        }
    }, 10000, 0);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
        if (this.f.get() == null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (b.this.f.get() == null) {
                            ControlEntity controlEntityD = b.this.e.d();
                            LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(b.this.f, null, controlEntityD);
                            com.opos.cmn.an.f.a.b("", "control local:" + controlEntityD);
                        }
                    } catch (Exception e) {
                        com.opos.cmn.an.f.a.b("", "loal fail", e);
                    }
                }
            });
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.c.a.b.3
            @Override // java.lang.Runnable
            public void run() {
                b.this.b(interfaceC0895a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
        try {
            m.a aVarI = new m.a().b(com.opos.mobad.service.e.b.n().f()).c("").g(com.opos.mobad.service.d.a.a().g()).h(com.opos.mobad.service.d.a.a().h()).i(com.opos.mobad.service.d.a.a().i());
            com.opos.mobad.service.d.a.C0991a c0991aL = com.opos.mobad.service.d.a.a().l();
            if (c0991aL != null) {
                m.a aVarA = aVarI.a(c0991aL.f7355a);
                c0991aL.getClass();
                aVarA.a((Integer) 1);
            } else {
                aVarI.a("");
            }
            n nVarB = new n.a().a(aVarI.b()).a(new o.a().c(com.opos.cmn.an.c.c.c()).a(com.opos.cmn.an.c.d.b()).b(com.opos.cmn.an.c.d.a()).b()).c(com.opos.cmn.an.c.a.a(this.f6690a)).a(com.opos.cmn.an.c.c.a()).b();
            HashMap map = new HashMap();
            map.put("Content-Type", "application/x-protobuf");
            map.put("Route-Data", com.opos.cmn.biz.a.e.a(this.f6690a));
            com.opos.cmn.func.a.a.d.a aVarB = new com.opos.cmn.func.a.a.d.a().a(j.c.b(new j.a().a(this.b).a(nVarB).b(this.f6690a.getPackageName()).b(Integer.valueOf(this.c)).a(Integer.valueOf(this.d)).a(Boolean.valueOf(com.opos.mobad.service.d.a.a().k())).b(Boolean.valueOf(com.opos.mobad.service.d.a.a().e())).b())).a(map).b(l());
            aVarB.a("POST");
            com.opos.cmn.func.a.a.e eVarA = com.opos.cmn.func.a.a.b.a().a(this.f6690a, aVarB.a());
            if (eVarA == null || 200 != eVarA.f6077a) {
                interfaceC0895a.b();
                return;
            }
            k kVarA = k.c.a(eVarA.c);
            com.opos.cmn.an.f.a.b("", "control succ:", kVarA);
            ControlEntity controlEntity = new ControlEntity((kVarA.s != null ? kVarA.s : k.e).booleanValue(), (kVarA.t != null ? kVarA.t : k.f).booleanValue(), (kVarA.u != null ? kVarA.u : k.g).booleanValue(), (kVarA.v != null ? kVarA.v : k.h).booleanValue(), (kVarA.w != null ? kVarA.w : k.i).booleanValue(), (kVarA.x != null ? kVarA.x : k.j).booleanValue(), (kVarA.z != null ? kVarA.z : k.l).booleanValue(), System.currentTimeMillis(), (kVarA.y != null ? kVarA.y : k.k).booleanValue(), (kVarA.B != null ? kVarA.B : k.n).booleanValue(), (kVarA.A != null ? kVarA.A : k.m).booleanValue(), (kVarA.C != null ? kVarA.C : k.o).booleanValue(), (kVarA.D != null ? kVarA.D : k.p).booleanValue());
            this.f.set(controlEntity);
            try {
                this.e.a(controlEntity);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("", "set local fail", e);
            }
            interfaceC0895a.a();
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("", "refresh fail", th);
            interfaceC0895a.b();
        }
    }

    private String l() {
        return "https://uapi.ads.heytapmobi.com/union/strategy/ability/select";
    }

    public void a(Context context, String str, int i, int i2) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f6690a = context;
        this.b = str;
        this.e = new com.opos.mobad.provider.record.a(context);
        this.c = i;
        this.d = i2;
        this.g.a();
    }

    public boolean a() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.f7272a;
        }
        this.g.a();
        return k.e.booleanValue();
    }

    public boolean b() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.b;
        }
        this.g.a();
        return k.f.booleanValue();
    }

    public boolean c() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.c;
        }
        this.g.a();
        return k.g.booleanValue();
    }

    public boolean d() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.e;
        }
        this.g.a();
        return k.h.booleanValue();
    }

    public boolean e() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.f;
        }
        this.g.a();
        return k.i.booleanValue();
    }

    public boolean f() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.i;
        }
        this.g.a();
        return k.l.booleanValue();
    }

    public boolean g() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.h;
        }
        this.g.a();
        return k.k.booleanValue();
    }

    public boolean h() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.j;
        }
        this.g.a();
        return k.n.booleanValue();
    }

    public boolean i() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.k;
        }
        this.g.a();
        return k.m.booleanValue();
    }

    public boolean j() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.l;
        }
        this.g.a();
        return k.o.booleanValue();
    }

    public boolean k() {
        ControlEntity controlEntity = this.f.get();
        if (controlEntity != null) {
            return controlEntity.m;
        }
        this.g.a();
        return k.p.booleanValue();
    }
}
