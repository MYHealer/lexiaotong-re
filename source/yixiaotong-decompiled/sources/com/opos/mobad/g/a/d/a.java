package com.opos.mobad.g.a.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f6966a = new AtomicInteger(0);
    private final AtomicBoolean b = new AtomicBoolean(false);
    private com.opos.cmn.i.a c = new com.opos.cmn.i.a(new com.opos.cmn.i.a.b() { // from class: com.opos.mobad.g.a.d.a.1
        @Override // com.opos.cmn.i.a.b
        public void a(com.opos.cmn.i.a.InterfaceC0895a interfaceC0895a) {
            a.this.b();
            interfaceC0895a.a();
        }
    }, Integer.MAX_VALUE, 6000);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b() {
        if (this.b.get()) {
            return true;
        }
        if (this.f6966a.incrementAndGet() < 3) {
            return false;
        }
        com.opos.cmn.an.f.a.b("Ads-Intercept", "meet server intercept count");
        return this.b.compareAndSet(false, true);
    }

    public boolean a() {
        return this.b.get();
    }
}
