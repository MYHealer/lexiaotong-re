package com.opos.mobad.video.player;

import android.os.RemoteException;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.opos.mobad.o.a.AbstractBinderC0977a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.o.a f8331a;

    public a(com.opos.mobad.o.a aVar) {
        this.f8331a = aVar;
    }

    @Override // com.opos.mobad.o.a
    public void a() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onReward");
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a();
        }
    }

    @Override // com.opos.mobad.o.a
    public void a(int i, String str) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onShowFailed");
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a(i, str);
        }
    }

    @Override // com.opos.mobad.o.a
    public void a(long j) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", IAdInterListener.AdCommandType.AD_CLICK);
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a(j);
        }
    }

    @Override // com.opos.mobad.o.a
    public void a(long j, boolean z) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessClose currentPos=", Long.valueOf(j), ", isEnd=", Boolean.valueOf(z));
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a(j, z);
        }
    }

    @Override // com.opos.mobad.o.a
    public void a(com.opos.mobad.o.c cVar) throws RemoteException {
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a(cVar);
        }
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "getFallbackAd");
    }

    @Override // com.opos.mobad.o.a
    public void a(String str) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessError err=", str);
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    @Override // com.opos.mobad.o.a
    public void a(String str, com.opos.mobad.o.b bVar) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onAdShow transformData=", str);
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a(str, bVar);
        }
    }

    @Override // com.opos.mobad.o.a
    public void a(Map map) throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onDlClick info=", map);
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.a(map);
        }
    }

    @Override // com.opos.mobad.o.a
    public void b() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onRenderSuccess");
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // com.opos.mobad.o.a
    public void c() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onClose");
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // com.opos.mobad.o.a
    public void d() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessStart");
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.opos.mobad.o.a
    public void e() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onProcessComplete");
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.e();
        }
    }

    @Override // com.opos.mobad.o.a
    public void f() throws RemoteException {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "onInstantExit");
        com.opos.mobad.o.a aVar = this.f8331a;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void g() {
        com.opos.cmn.an.f.a.b("AdShowCallbackWrapper", "destroy");
        this.f8331a = null;
    }
}
