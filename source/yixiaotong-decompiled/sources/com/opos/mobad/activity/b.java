package com.opos.mobad.activity;

import android.os.RemoteException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends com.opos.mobad.t.a.AbstractBinderC0999a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.t.a f6593a;

    public b(com.opos.mobad.t.a aVar) {
        this.f6593a = aVar;
    }

    @Override // com.opos.mobad.t.a
    public void a() throws RemoteException {
        com.opos.mobad.t.a aVar = this.f6593a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.t.a
    public void a(com.opos.mobad.t.b bVar) throws RemoteException {
        com.opos.mobad.t.a aVar = this.f6593a;
        if (aVar != null) {
            aVar.a(bVar);
        }
    }

    @Override // com.opos.mobad.t.a
    public void a(Map map) throws RemoteException {
        com.opos.mobad.t.a aVar = this.f6593a;
        if (aVar != null) {
            aVar.a(map);
        }
    }

    public void b() {
        this.f6593a = null;
    }
}
