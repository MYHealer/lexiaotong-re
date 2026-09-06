package com.opos.process.bridge.server;

import android.app.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d f8425a = new d();
    private List<Service> b = Collections.synchronizedList(new ArrayList());

    private d() {
    }

    static d a() {
        return f8425a;
    }

    boolean a(Service service) {
        return this.b.add(service);
    }

    boolean b(Service service) {
        return this.b.remove(service);
    }
}
