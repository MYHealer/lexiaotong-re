package com.opos.cmn.an.f.b;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.cmn.an.f.b.a.b f5910a;
    private e b = new e();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f5911a;
        final /* synthetic */ int b;

        a(Object obj, int i) {
            this.f5911a = obj;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b(this.f5911a, this.b);
        }
    }

    private void a(com.opos.cmn.an.f.b.b.c cVar) {
        if (cVar.f5901a.e == 2 && a()) {
            this.f5910a = new com.opos.cmn.an.f.b.a.d();
            if (c.b()) {
                Log.d("LogHandler", "use NearLogImpl");
            }
        }
        if (this.f5910a == null) {
            this.f5910a = new com.opos.cmn.an.f.b.a.a();
            if (c.b()) {
                Log.d("LogHandler", "use BasicLogImpl");
            }
        }
    }

    private boolean a() {
        try {
            String canonicalName = com.oplus.log.b.class.getCanonicalName();
            if (TextUtils.isEmpty(canonicalName) || !c.b()) {
                return true;
            }
            Log.d("LogHandler", canonicalName + " exits");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void a(Object obj, int i) {
        this.b.a(new a(obj, i));
    }

    public void b(Object obj, int i) {
        com.opos.cmn.an.f.b.b.e eVar;
        com.opos.cmn.an.f.b.b.f fVar;
        if (obj != null) {
            try {
                switch (i) {
                    case 1:
                        com.opos.cmn.an.f.b.b.c cVar = (com.opos.cmn.an.f.b.b.c) obj;
                        a(cVar);
                        this.f5910a.a(cVar.f5901a);
                        break;
                    case 2:
                        com.opos.cmn.an.f.b.a.b bVar = this.f5910a;
                        if (bVar != null) {
                            bVar.a((com.opos.cmn.an.f.b.b.d) obj);
                        }
                        break;
                    case 3:
                        com.opos.cmn.an.f.b.a.b bVar2 = this.f5910a;
                        if (bVar2 != null) {
                            com.opos.cmn.an.f.b.b.g gVar = (com.opos.cmn.an.f.b.b.g) obj;
                            bVar2.a(gVar.f5907a, gVar.b);
                        }
                        break;
                    case 4:
                        com.opos.cmn.an.f.b.a.b bVar3 = this.f5910a;
                        if (bVar3 != null) {
                            bVar3.a(((com.opos.cmn.an.f.b.b.b) obj).f5900a);
                        }
                        break;
                    case 5:
                        com.opos.cmn.an.f.b.a.b bVar4 = this.f5910a;
                        if (bVar4 != null) {
                            bVar4.a();
                        }
                        break;
                    case 6:
                        com.opos.cmn.an.f.b.a.b bVar5 = this.f5910a;
                        if (bVar5 != null && (eVar = (com.opos.cmn.an.f.b.b.e) obj) != null) {
                            bVar5.a(eVar.f5905a);
                        }
                        break;
                    case 7:
                        com.opos.cmn.an.f.b.a.b bVar6 = this.f5910a;
                        if (bVar6 != null && (fVar = (com.opos.cmn.an.f.b.b.f) obj) != null) {
                            bVar6.b(fVar.f5906a);
                        }
                        break;
                    default:
                        return;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
