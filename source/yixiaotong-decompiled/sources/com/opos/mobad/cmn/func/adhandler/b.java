package com.opos.mobad.cmn.func.adhandler;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.RemoteException;
import android.text.TextUtils;
import com.opos.cmn.i.l;
import com.opos.mobad.cmn.func.adhandler.a.h;
import com.opos.mobad.cmn.func.adhandler.a.i;
import com.opos.mobad.cmn.func.adhandler.a.j;
import com.opos.mobad.cmn.func.adhandler.a.k;
import com.opos.mobad.cmn.func.adhandler.a.m;
import com.opos.mobad.cmn.func.adhandler.a.n;
import com.opos.mobad.model.data.ApkSignerData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.mobad.b f6780a;
    private String b;
    private com.opos.mobad.cmn.func.a c;
    private com.opos.mobad.cmn.func.adhandler.f d;
    private com.opos.mobad.ad.f e;

    public interface a {
        void a(int i, int i2, String str, String str2);

        void a(int i, int i2, String str, String str2, String str3);

        void b(int i, int i2, String str, String str2);
    }

    /* JADX INFO: renamed from: com.opos.mobad.cmn.func.adhandler.b$b, reason: collision with other inner class name */
    public interface InterfaceC0949b {
        void a(c cVar);
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f6789a;
        public final int b;
        public int c;

        public c(int i, int i2) {
            this.b = i2;
            this.f6789a = i;
        }

        public c a(int i) {
            this.c = i;
            return this;
        }

        public boolean a() {
            return this.b == 1;
        }

        public String toString() {
            return "Result{resultType=" + this.f6789a + ", resultCode=" + this.b + '}';
        }
    }

    public interface d {
        void a(e eVar);
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.opos.mobad.cmn.func.adhandler.d f6790a;
        public c b;
        public c c;
        private List<c> d = new ArrayList();

        public e a(c cVar) {
            this.b = cVar;
            this.c = cVar;
            return this;
        }

        public e a(com.opos.mobad.cmn.func.adhandler.d dVar) {
            this.f6790a = dVar;
            return this;
        }

        public boolean a() {
            c cVar = this.b;
            return cVar != null && cVar.a();
        }

        public e b(c cVar) {
            this.d.add(cVar);
            this.c = cVar;
            return this;
        }

        public boolean b() {
            c cVar = this.c;
            return cVar != null && cVar.a();
        }

        public boolean c() {
            return a() || b();
        }

        public String toString() {
            return "ResultObject{, targetResult=" + this.b + ", lastResult=" + this.c + ", mBaseResult=" + this.d + '}';
        }
    }

    private static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f6791a;
        private String b;
        private String c;
        private Signature d;

        public f(Signature signature) {
            this.d = signature;
        }

        public String a() {
            if (!TextUtils.isEmpty(this.f6791a)) {
                return this.f6791a;
            }
            try {
                this.f6791a = l.a("md5", this.d);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e);
            }
            return this.f6791a;
        }

        public String b() {
            if (!TextUtils.isEmpty(this.b)) {
                return this.b;
            }
            try {
                this.b = l.a("sha1", this.d);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e);
            }
            return this.b;
        }

        public String c() {
            if (!TextUtils.isEmpty(this.c)) {
                return this.c;
            }
            try {
                this.c = l.a("sha256", this.d);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e);
            }
            return this.c;
        }
    }

    private class g extends com.opos.mobad.t.a.AbstractBinderC0999a {
        private com.opos.mobad.t.a b;

        public g(com.opos.mobad.t.a aVar) {
            this.b = aVar;
        }

        @Override // com.opos.mobad.t.a
        public void a() throws RemoteException {
            com.opos.mobad.t.a aVar = this.b;
            if (aVar != null) {
                aVar.a();
            }
        }

        @Override // com.opos.mobad.t.a
        public void a(com.opos.mobad.t.b bVar) throws RemoteException {
            com.opos.mobad.t.a aVar = this.b;
            if (aVar != null) {
                aVar.a(bVar);
            }
        }

        @Override // com.opos.mobad.t.a
        public void a(final Map map) throws RemoteException {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "web onDlClick=" + map + ",mDlClickListener=" + b.this.e);
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.g.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.e != null) {
                        b.this.e.a(map);
                    }
                }
            });
        }
    }

    public b(com.opos.mobad.b bVar, String str, com.opos.mobad.cmn.func.a aVar, com.opos.mobad.cmn.func.adhandler.f fVar) {
        this.f6780a = bVar;
        this.b = str;
        this.c = aVar;
        this.d = fVar;
    }

    private int a(ApkSignerData apkSignerData, List<f> list) {
        if (TextUtils.isEmpty(apkSignerData.f7187a) && TextUtils.isEmpty(apkSignerData.b) && TextUtils.isEmpty(apkSignerData.c)) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            f fVar = list.get(i);
            if ((TextUtils.isEmpty(apkSignerData.f7187a) || apkSignerData.f7187a.equals(fVar.a())) && ((TextUtils.isEmpty(apkSignerData.b) || apkSignerData.b.equals(fVar.b())) && (TextUtils.isEmpty(apkSignerData.c) || apkSignerData.c.equals(fVar.c())))) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, int i3, InterfaceC0949b interfaceC0949b) {
        if (interfaceC0949b != null) {
            c cVar = new c(i, i2);
            cVar.a(i3);
            interfaceC0949b.a(cVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x0069  */
    /* JADX WARN: Code duplicated, block: B:45:? A[RETURN, SYNTHETIC] */
    private void a(com.opos.mobad.cmn.func.adhandler.a.e eVar, final com.opos.mobad.cmn.func.adhandler.f fVar, final com.opos.mobad.cmn.func.adhandler.f.a aVar) {
        Runnable runnable;
        if ((eVar instanceof com.opos.mobad.cmn.func.adhandler.a.b.d) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.b.C0948b) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.a.a) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.d.a) || (eVar instanceof i) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.d) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.b.a) || (eVar instanceof n.b) || (eVar instanceof n.a)) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to request keyGuard");
            if (fVar != null && fVar.b()) {
                runnable = new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        fVar.a(b.this.f6780a.b(), aVar);
                    }
                };
                com.opos.cmn.an.j.b.c(runnable);
                return;
            }
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to default");
            if (aVar != null) {
                aVar.a();
            }
        }
        if ((eVar instanceof h) || (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.c) || (eVar instanceof j)) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to request verify");
            if (fVar != null && fVar.b() && fVar.a()) {
                runnable = new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        fVar.b(b.this.f6780a.b(), aVar);
                    }
                };
                com.opos.cmn.an.j.b.c(runnable);
                return;
            }
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "Type to default");
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, d dVar) {
        if (dVar != null) {
            dVar.a(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.cmn.func.adhandler.d dVar, int i, int i2, InterfaceC0949b interfaceC0949b) {
        if (interfaceC0949b != null) {
            interfaceC0949b.a(new c(i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.cmn.func.adhandler.d dVar, int i, int i2, d dVar2) {
        if (dVar2 != null) {
            dVar2.a(new e().a(dVar).a(new c(i, i2)));
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0035 A[Catch: Exception -> 0x003c, TRY_LEAVE, TryCatch #0 {Exception -> 0x003c, blocks: (B:4:0x0008, B:6:0x000e, B:8:0x001e, B:9:0x0031, B:10:0x0035), top: B:15:0x0008 }] */
    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.b.c cVar, InterfaceC0949b interfaceC0949b) {
        String str;
        if (cVar != null) {
            try {
                if (cVar.a() && this.c.b(this.f6780a.b(), cVar.f6768a)) {
                    a(dVar, 18, 1, interfaceC0949b);
                    str = "handleGoogleMarket open deeplink success.extraUrl = " + cVar.f6768a;
                } else {
                    a(dVar, 18, -1, interfaceC0949b);
                    str = "handleGoogleMarket open deeplink fail.";
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        } else {
            a(dVar, 18, -1, interfaceC0949b);
            str = "handleGoogleMarket open deeplink fail.";
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", str);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0034 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:4:0x0007, B:6:0x000d, B:8:0x001d, B:9:0x0030, B:10:0x0034), top: B:15:0x0007 }] */
    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.b.d dVar2, InterfaceC0949b interfaceC0949b) {
        String str;
        if (dVar2 != null) {
            try {
                if (dVar2.a() && this.c.b(this.f6780a.b(), dVar2.f6768a)) {
                    a(dVar, 5, 1, interfaceC0949b);
                    str = "handleDeepLink open deeplink success.extraUrl = " + dVar2.f6768a;
                } else {
                    a(dVar, 5, -1, interfaceC0949b);
                    str = "handleDeepLink open deeplink fail.open homepage";
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        } else {
            a(dVar, 5, -1, interfaceC0949b);
            str = "handleDeepLink open deeplink fail.open homepage";
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", str);
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.b bVar, InterfaceC0949b interfaceC0949b) {
        if (bVar != null) {
            try {
                if (!TextUtils.isEmpty(bVar.f6768a) && this.c.b(this.f6780a.b(), bVar.f6768a)) {
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDetailPage targetUrl=" + bVar.f6768a + " success.");
                    a(dVar, 11, 1, interfaceC0949b);
                    return;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDetailPage targetUrl=" + (bVar != null ? bVar.f6768a : "null") + " fail.");
        a(dVar, 11, -1, interfaceC0949b);
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, final com.opos.mobad.cmn.func.adhandler.a.c cVar, InterfaceC0949b interfaceC0949b) {
        if (cVar != null) {
            try {
                if (cVar.a()) {
                    String str = cVar.f6769a;
                    String str2 = cVar.b;
                    String str3 = cVar.d;
                    String str4 = cVar.c;
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDownloader pkgName=" + str2 + ",appName=" + str3 + ",md5=" + str4 + ",url=" + str);
                    if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                        a(dVar, 7, -1, interfaceC0949b);
                        return;
                    }
                    this.f6780a.l().a(this.f6780a.n().b(), this.f6780a.n().c());
                    this.f6780a.l().a(str, str2, str4, str3, new com.opos.mobad.cmn.service.a.c() { // from class: com.opos.mobad.cmn.func.adhandler.b.7
                        @Override // com.opos.mobad.cmn.service.a.c
                        public void a(int i, int i2, String str5, String str6) {
                            if (cVar.f != null) {
                                cVar.f.a(i, i2, str5, str6);
                            }
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void a(int i, int i2, String str5, String str6, String str7) {
                            if (cVar.f != null) {
                                cVar.f.a(i, i2, str5, str6, str7);
                            }
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void b(int i, int i2, String str5, String str6) {
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void c(int i, int i2, String str5, String str6) {
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void d(int i, int i2, String str5, String str6) {
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void e(int i, int i2, String str5, String str6) {
                        }

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (obj == null || obj.hashCode() != hashCode()) {
                                return super.equals(obj);
                            }
                            return true;
                        }

                        @Override // com.opos.mobad.cmn.service.a.c
                        public void f(int i, int i2, String str5, String str6) {
                            if (cVar.f != null) {
                                cVar.f.b(i, i2, str5, str6);
                            }
                        }

                        public int hashCode() {
                            String str5 = cVar.e;
                            return TextUtils.isEmpty(str5) ? super.hashCode() : str5.hashCode();
                        }
                    });
                    a(dVar, 7, 1, interfaceC0949b);
                    return;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        }
        a(dVar, 7, -1, interfaceC0949b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.e eVar, InterfaceC0949b interfaceC0949b) {
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handlerClickAction dataType: " + eVar.getClass().getName());
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.b.d) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.b.d) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.b.C0948b) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.b.C0948b) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.a.a) {
            ((com.opos.mobad.cmn.func.adhandler.a.a.a) eVar).a(this.f6780a, dVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.d.a) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.d.a) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof h) {
            a(dVar, (h) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.c) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.c) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof j) {
            a(dVar, (j) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.b.c) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.b.c) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof k) {
            a(dVar, (k) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof n) {
            a(dVar, (n) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.d) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.d) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.b.a) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.b) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof com.opos.mobad.cmn.func.adhandler.a.f) {
            a(dVar, (com.opos.mobad.cmn.func.adhandler.a.f) eVar, interfaceC0949b);
            return;
        }
        if (eVar instanceof i) {
            a(dVar, (i) eVar, interfaceC0949b);
        } else if (eVar instanceof m) {
            a(dVar, (m) eVar, interfaceC0949b);
        } else {
            a(dVar, 0, -2, interfaceC0949b);
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0023 A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #0 {Exception -> 0x002e, blocks: (B:4:0x0004, B:6:0x000a, B:7:0x0023), top: B:13:0x0004 }] */
    private void a(final com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.f fVar, final InterfaceC0949b interfaceC0949b) {
        if (fVar != null) {
            try {
                if (fVar.a()) {
                    this.c.a(this.f6780a.b(), fVar.f6771a, fVar.b, fVar.c, new com.opos.mobad.cmn.func.a.InterfaceC0945a() { // from class: com.opos.mobad.cmn.func.adhandler.b.6
                        @Override // com.opos.mobad.cmn.func.a.InterfaceC0945a
                        public void a() {
                            b.this.a(dVar, 6, 1, interfaceC0949b);
                            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleInstant open instant success.");
                        }

                        @Override // com.opos.mobad.cmn.func.a.InterfaceC0945a
                        public void a(int i, String str) {
                            b.this.a(6, -3, i, interfaceC0949b);
                            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleInstant open instant fail.open web, code:" + i + ",msg:" + str);
                        }
                    }, fVar.d);
                } else {
                    a(dVar, 6, -1, interfaceC0949b);
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleInstant open instant fail.open web");
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
            }
        } else {
            a(dVar, 6, -1, interfaceC0949b);
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleInstant open instant fail.open web");
        }
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, h hVar, InterfaceC0949b interfaceC0949b) {
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk posId=" + this.b);
        if (hVar == null || !hVar.a()) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk null data");
            a(dVar, 1, -1, interfaceC0949b);
            return;
        }
        if (hVar.f6773a ? this.c.e(this.f6780a.b(), hVar.b) : this.c.d(this.f6780a.b(), hVar.b)) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk deepLinkUrl=" + hVar.b + " = true ,isSafeJump = " + hVar.f6773a);
            a(dVar, 1, 1, interfaceC0949b);
        } else {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleDeeplinkDLApk deepLinkUrl=" + hVar.b + " = false ,isSafeJump = " + hVar.f6773a);
            a(dVar, 1, -1, interfaceC0949b);
        }
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, i iVar, InterfaceC0949b interfaceC0949b) {
        String str;
        if (iVar != null) {
            try {
                if (iVar.a()) {
                    if (this.c.a(this.f6780a.b(), iVar.c, iVar.f6774a, iVar.b)) {
                        a(dVar, 8, 1, interfaceC0949b);
                        str = "handleMiniProgram open success.";
                    } else {
                        a(dVar, 8, -3, interfaceC0949b);
                        str = "handleMiniProgram open fail.open web";
                    }
                    com.opos.cmn.an.f.a.a("AdHandlerCombination", str);
                    return;
                }
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
                return;
            }
        }
        a(dVar, 8, -1, interfaceC0949b);
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleMiniProgram error param instant fail.open web");
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, j jVar, InterfaceC0949b interfaceC0949b) {
        if (jVar == null || !jVar.a()) {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleDLApk null data");
            a(dVar, 1, -1, interfaceC0949b);
        } else if (this.c.a(this.f6780a.b(), jVar.f6775a, this.b, jVar.b, jVar.c, jVar.d, jVar.e, jVar.f)) {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleDLApk pkgName" + jVar.f6775a + " = true");
            a(dVar, 1, 1, interfaceC0949b);
        } else {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleDLApk pkgName=" + jVar.f6775a + " = false");
            a(dVar, 1, -2, interfaceC0949b);
        }
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, k kVar, InterfaceC0949b interfaceC0949b) {
        int i;
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleOverseaOPPOMarket posId=" + this.b);
        if (kVar == null || !kVar.a()) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleOverseaOPPOMarket null data");
            a(dVar, 17, -1, interfaceC0949b);
            return;
        }
        if (this.c.e(this.f6780a.b(), kVar.b)) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleOverseaOPPOMarket deepLinkUrl=" + kVar.b + " = true ");
            i = 1;
        } else {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleOverseaOPPOMarket deepLinkUrl=" + kVar.b + " = false ");
            i = -3;
        }
        a(dVar, 17, i, interfaceC0949b);
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, m mVar, InterfaceC0949b interfaceC0949b) {
        String str;
        if (mVar != null) {
            try {
                if (mVar.a()) {
                    if (this.c.b(this.f6780a.b(), mVar.f6778a, mVar.b, mVar.c)) {
                        a(dVar, 19, 1, interfaceC0949b);
                        str = "handleWeChatNativePage open success.";
                    } else {
                        a(dVar, 19, -3, interfaceC0949b);
                        str = "handleWeChatNativePage open fail.";
                    }
                    com.opos.cmn.an.f.a.a("AdHandlerCombination", str);
                    return;
                }
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.a("AdHandlerCombination", "handleWeChatNativePage exception", th);
                return;
            }
        }
        a(dVar, 19, -1, interfaceC0949b);
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleWeChatNativePage error param instant fail.");
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, n nVar, InterfaceC0949b interfaceC0949b) {
        if ((nVar instanceof n.b) || (nVar instanceof n.a)) {
            c(dVar, nVar, interfaceC0949b);
        } else {
            b(dVar, nVar, interfaceC0949b);
        }
    }

    private void a(final com.opos.mobad.cmn.func.adhandler.d dVar, final d dVar2) {
        if (dVar == null) {
            return;
        }
        com.opos.cmn.an.j.b.d(new Runnable() { // from class: com.opos.mobad.cmn.func.adhandler.b.4
            @Override // java.lang.Runnable
            public void run() {
                final e eVar = new e();
                eVar.a(dVar);
                com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleAdClickAction adItemData=", dVar.a());
                b bVar = b.this;
                com.opos.mobad.cmn.func.adhandler.d dVar3 = dVar;
                bVar.a(dVar3, dVar3.f, new InterfaceC0949b() { // from class: com.opos.mobad.cmn.func.adhandler.b.4.1
                    @Override // com.opos.mobad.cmn.func.adhandler.b.InterfaceC0949b
                    public void a(c cVar) {
                        if (cVar != null) {
                            eVar.a(cVar);
                            if (cVar.a()) {
                                b.this.a(eVar, dVar2);
                                return;
                            }
                        }
                        b.this.a(dVar, eVar, dVar2, 0);
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.opos.mobad.cmn.func.adhandler.d dVar, final e eVar, final d dVar2, final int i) {
        com.opos.mobad.cmn.func.adhandler.a.e eVarA = a(dVar.g, i);
        if (eVarA == null) {
            a(eVar, dVar2);
        } else {
            a(dVar, eVarA, new InterfaceC0949b() { // from class: com.opos.mobad.cmn.func.adhandler.b.5
                @Override // com.opos.mobad.cmn.func.adhandler.b.InterfaceC0949b
                public void a(c cVar) {
                    if (cVar != null) {
                        eVar.b(cVar);
                        if (cVar.a()) {
                            b.this.a(eVar, dVar2);
                        } else {
                            b.this.a(dVar, eVar, dVar2, i + 1);
                        }
                    }
                }
            });
        }
    }

    private void a(com.opos.mobad.cmn.func.adhandler.d dVar, String str, String str2, d dVar2) {
        try {
            Intent intent = new Intent(str);
            intent.setPackage(str2);
            List<ResolveInfo> listQueryIntentServices = this.f6780a.b().getPackageManager().queryIntentServices(intent, 128);
            if (listQueryIntentServices != null && listQueryIntentServices.size() == 1) {
                intent.putExtra("from", this.f6780a.b().getPackageName());
                this.f6780a.b().startService(intent);
                if (dVar2 != null) {
                    a(dVar, 16, 0, dVar2);
                    return;
                }
                return;
            }
            if (dVar2 != null) {
                a(dVar, 16, 6, dVar2);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "", e2);
            if (dVar2 != null) {
                a(dVar, 16, 7, dVar2);
            }
        }
    }

    public static boolean a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 17:
            case 18:
            case 19:
            case 20:
                return true;
            case 14:
            case 15:
            case 16:
            default:
                return false;
        }
    }

    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.a aVar, d dVar2) {
        PackageInfo packageInfo;
        Signature[] apkContentsSigners;
        PackageManager packageManager = this.f6780a.b().getPackageManager();
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                packageInfo = packageManager.getPackageInfo(aVar.f6767a, 134217856);
                if (packageInfo == null) {
                    if (dVar2 != null) {
                        a(dVar, 16, 3, dVar2);
                    }
                    return false;
                }
                apkContentsSigners = packageInfo.signingInfo.getApkContentsSigners();
            } else {
                packageInfo = packageManager.getPackageInfo(aVar.f6767a, 192);
                if (packageInfo == null) {
                    if (dVar2 != null) {
                        a(dVar, 16, 3, dVar2);
                    }
                    return false;
                }
                apkContentsSigners = packageInfo.signatures;
            }
            if (aVar.d > packageInfo.versionCode) {
                if (dVar2 != null) {
                    a(dVar, 16, 4, dVar2);
                }
                return false;
            }
            if (aVar.c == null || apkContentsSigners == null) {
                if (dVar2 != null) {
                    a(dVar, 16, 5, dVar2);
                }
                return false;
            }
            if (aVar.c.size() <= 0 || aVar.c.size() != apkContentsSigners.length) {
                if (dVar2 != null) {
                    a(dVar, 16, 5, dVar2);
                }
                return false;
            }
            ArrayList arrayList = new ArrayList(apkContentsSigners.length);
            for (Signature signature : apkContentsSigners) {
                arrayList.add(new f(signature));
            }
            Iterator<ApkSignerData> it = aVar.c.iterator();
            while (it.hasNext()) {
                int iA = a(it.next(), arrayList);
                if (iA < 0) {
                    if (dVar2 != null) {
                        a(dVar, 16, 5, dVar2);
                    }
                    return false;
                }
                arrayList.remove(iA);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "activation fail not install");
            if (dVar2 != null) {
                a(dVar, 16, 3, dVar2);
            }
            return false;
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "activation fail", e2);
            if (dVar2 != null) {
                a(dVar, 16, 1, dVar2);
            }
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x003a  */
    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.b.C0948b c0948b, InterfaceC0949b interfaceC0949b) {
        boolean z = false;
        if (c0948b != null) {
            try {
                if (c0948b.a() && this.c.b(this.f6780a.b(), c0948b.f6768a)) {
                    a(dVar, 9, 1, interfaceC0949b);
                    try {
                        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleForInstalledDeepLink open deeplink success.extraUrl = " + c0948b.f6768a);
                        z = true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e);
                    }
                } else {
                    a(dVar, 9, -1, interfaceC0949b);
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleForInstalledDeepLink open deeplink fail.open homepage");
                }
            } catch (Exception e3) {
                e = e3;
            }
        } else {
            a(dVar, 9, -1, interfaceC0949b);
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleForInstalledDeepLink open deeplink fail.open homepage");
        }
        return z;
    }

    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.d.a aVar, InterfaceC0949b interfaceC0949b) {
        boolean z = false;
        if (aVar != null) {
            try {
                if (aVar.a() && this.c.a(this.f6780a.b(), aVar.f6770a)) {
                    a(dVar, 10, 1, interfaceC0949b);
                    try {
                        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleHomePage pkgName=" + aVar.f6770a + " success.");
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e);
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleHomePage pkgName=" + (aVar != null ? aVar.f6770a : "null") + " fail.");
        a(dVar, 10, -1, interfaceC0949b);
        return false;
    }

    private boolean a(com.opos.mobad.cmn.func.adhandler.d dVar, com.opos.mobad.cmn.func.adhandler.a.d dVar2, InterfaceC0949b interfaceC0949b) {
        boolean z = false;
        if (dVar2 != null) {
            try {
                if (dVar2.a() && this.c.a(this.f6780a.b(), dVar2.f6770a)) {
                    a(dVar, 4, 1, interfaceC0949b);
                    try {
                        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleHomePage pkgName=" + dVar2.f6770a + " success.");
                        return true;
                    } catch (Exception e2) {
                        e = e2;
                        z = true;
                        com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e);
                        return z;
                    }
                }
            } catch (Exception e3) {
                e = e3;
            }
        }
        com.opos.cmn.an.f.a.b("AdHandlerCombination", "handleHomePage pkgName=" + (dVar2 != null ? dVar2.f6770a : "null") + " fail.");
        a(dVar, 4, -1, interfaceC0949b);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.opos.mobad.cmn.func.adhandler.d dVar) {
        if (dVar.f instanceof com.opos.mobad.cmn.func.adhandler.a.a) {
            c(dVar);
            return;
        }
        if (dVar.f instanceof com.opos.mobad.cmn.func.adhandler.a.l) {
            e(dVar);
            return;
        }
        if (dVar.f instanceof com.opos.mobad.cmn.func.adhandler.a.g) {
            d(dVar);
        } else if (com.opos.mobad.cmn.func.adhandler.b.a.a(dVar.f)) {
            a(dVar, dVar.d);
        } else {
            a(dVar, 0, -1, dVar.d);
        }
    }

    private void b(com.opos.mobad.cmn.func.adhandler.d dVar, n nVar, InterfaceC0949b interfaceC0949b) {
        String str;
        String str2;
        String strA;
        String str3 = "";
        String str4 = "AdHandlerCombination";
        int i = nVar instanceof n.c ? 13 : 3;
        if (nVar == null || !nVar.a()) {
            a(dVar, i, -1, interfaceC0949b);
            return;
        }
        dVar.e.a(com.opos.mobad.service.f.b.EnumC0995b.WEB_VIEW).a("1");
        try {
            com.opos.cmn.an.f.a.b(str4, "loadWebPage url=" + nVar.f6779a);
            if (-1 != com.opos.mobad.cmn.func.b.g.c(nVar.f6779a)) {
                try {
                    strA = com.opos.mobad.cmn.func.b.g.a(nVar.b, nVar.c, nVar.f6779a, this.b);
                } catch (Exception e2) {
                    e = e2;
                    str = str3;
                    str2 = str4;
                    com.opos.cmn.an.f.a.a(str2, str, (Throwable) e);
                    a(dVar, i, -2, interfaceC0949b);
                }
            } else {
                strA = str3;
            }
            String strA2 = com.opos.mobad.service.f.c.a(this.f6780a.b(), nVar.f6779a, dVar.e);
            if (dVar.c != null) {
                com.opos.mobad.cmn.func.b.g.a(dVar.c);
            }
            try {
                if (TextUtils.isEmpty(nVar.f)) {
                    this.c.a(this.f6780a, this.b, strA2, dVar.f6795a, strA, new g(null));
                } else {
                    this.c.a(this.f6780a, this.b, strA2, dVar.f6795a, strA, nVar.f, new g(nVar.d), nVar.e, nVar.g);
                }
                a(dVar, i, 1, interfaceC0949b);
            } catch (Exception e3) {
                e = e3;
                str = str3;
                str2 = str4;
                com.opos.cmn.an.f.a.a(str2, str, (Throwable) e);
                a(dVar, i, -2, interfaceC0949b);
            }
        } catch (Exception e4) {
            e = e4;
            str3 = str3;
            str4 = str4;
        }
    }

    private void c(com.opos.mobad.cmn.func.adhandler.d dVar) {
        if (dVar == null) {
            return;
        }
        com.opos.mobad.cmn.func.adhandler.a.a aVar = (com.opos.mobad.cmn.func.adhandler.a.a) dVar.f;
        if (aVar == null || !aVar.a()) {
            a(dVar, 16, 2, dVar.d);
        } else if (a(dVar, aVar, dVar.d)) {
            a(dVar, aVar.b, aVar.f6767a, dVar.d);
        }
    }

    private void c(com.opos.mobad.cmn.func.adhandler.d dVar, n nVar, InterfaceC0949b interfaceC0949b) {
        int i;
        dVar.e.a(com.opos.mobad.service.f.b.EnumC0995b.BROWSER).a("1");
        String str = nVar.f6779a;
        int i2 = nVar instanceof n.b ? 12 : 2;
        if (nVar.a()) {
            String strA = com.opos.mobad.service.f.c.a(this.f6780a.b(), str, dVar.e);
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "loadWebPageByBrowser url=" + strA);
            this.c.c(this.f6780a.b(), strA);
            i = 1;
        } else {
            i = -1;
        }
        a(dVar, i2, i, interfaceC0949b);
    }

    private void d(com.opos.mobad.cmn.func.adhandler.d dVar) {
        if (dVar == null) {
            return;
        }
        com.opos.mobad.cmn.func.adhandler.a.g gVar = (com.opos.mobad.cmn.func.adhandler.a.g) dVar.f;
        if (gVar == null || !gVar.a()) {
            a(dVar, 15, -1, dVar.d);
            return;
        }
        String str = gVar.f6772a;
        try {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "loadWebPage url=" + str);
            String strA = -1 != com.opos.mobad.cmn.func.b.g.c(str) ? com.opos.mobad.cmn.func.b.g.a(gVar.b, gVar.c, str, this.b) : "";
            String strA2 = com.opos.mobad.cmn.func.b.g.a(this.f6780a.b(), str, (int[]) null, 0L);
            if (dVar.c != null) {
                com.opos.mobad.cmn.func.b.g.a(dVar.c);
            }
            this.c.a(this.f6780a, this.b, strA2, dVar.a(), strA, gVar.d);
            a(dVar, 15, 1, dVar.d);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdHandlerCombination", "", (Throwable) e2);
            a(dVar, 15, -2, dVar.d);
        }
    }

    private void e(com.opos.mobad.cmn.func.adhandler.d dVar) {
        int i;
        if (dVar == null) {
            return;
        }
        com.opos.mobad.cmn.func.adhandler.a.l lVar = (com.opos.mobad.cmn.func.adhandler.a.l) dVar.f;
        if (lVar == null || !lVar.a()) {
            i = -1;
        } else {
            this.c.a(this.f6780a.b(), lVar.f6777a, lVar.b, lVar.c, lVar.d);
            i = 1;
        }
        a(dVar, 14, i, dVar.d);
    }

    public com.opos.mobad.cmn.func.adhandler.a.e a(List<com.opos.mobad.cmn.func.adhandler.a.e> list, int i) {
        if (list == null || list.size() <= 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public void a(com.opos.mobad.ad.f fVar) {
        this.e = fVar;
    }

    public void a(final com.opos.mobad.cmn.func.adhandler.d dVar) {
        if (dVar == null) {
            return;
        }
        com.opos.mobad.cmn.func.adhandler.f fVar = this.d;
        if (fVar != null && fVar.b()) {
            a(dVar.f, fVar, new com.opos.mobad.cmn.func.adhandler.f.a() { // from class: com.opos.mobad.cmn.func.adhandler.b.1
                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void a() {
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "execute keyguard success");
                    b.this.b(dVar);
                }

                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void b() {
                    com.opos.cmn.an.f.a.b("AdHandlerCombination", "execute keyguard fail");
                    b bVar = b.this;
                    com.opos.mobad.cmn.func.adhandler.d dVar2 = dVar;
                    bVar.a(dVar2, dVar2.f.b(), -4, dVar.d);
                }
            });
        } else {
            com.opos.cmn.an.f.a.b("AdHandlerCombination", "execute without lock Handler");
            b(dVar);
        }
    }
}
