package com.ubix.ssp.ad.e.a0;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.hms.ads.ez;
import com.stub.StubApp;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f8687a;
    private static Timer b;
    private static TimerTask c;
    private static volatile boolean d;
    private static boolean e;
    private HashMap<String, String> f;
    private boolean g;
    private boolean h;
    private com.ubix.ssp.ad.d.l i;
    volatile boolean j = false;

    class a implements com.ubix.ssp.ad.e.a0.d.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.a0.d f8688a;
        final /* synthetic */ Timer b;
        final /* synthetic */ com.ubix.ssp.ad.e.y.a.a.b c;

        a(com.ubix.ssp.ad.e.a0.d dVar, Timer timer, com.ubix.ssp.ad.e.y.a.a.b bVar) {
            this.f8688a = dVar;
            this.b = timer;
            this.c = bVar;
        }

        @Override // com.ubix.ssp.ad.e.a0.d.f
        public void a() {
            u.b("new deeplink 目标app已安装 ", "调起成功");
            f.this.j = true;
            this.f8688a.c();
            this.f8688a.a((com.ubix.ssp.ad.e.a0.d.InterfaceC1085d) null);
            Timer timer = this.b;
            if (timer != null) {
                timer.cancel();
            }
            com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.c, f.this.f, 403);
        }

        @Override // com.ubix.ssp.ad.e.a0.d.f
        public void b() {
        }
    }

    class b implements com.ubix.ssp.ad.e.a0.d.InterfaceC1085d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.a0.d f8689a;
        final /* synthetic */ Timer b;
        final /* synthetic */ com.ubix.ssp.ad.e.y.a.a.b c;

        b(com.ubix.ssp.ad.e.a0.d dVar, Timer timer, com.ubix.ssp.ad.e.y.a.a.b bVar) {
            this.f8689a = dVar;
            this.b = timer;
            this.c = bVar;
        }

        @Override // com.ubix.ssp.ad.e.a0.d.InterfaceC1085d
        public void a(int i) {
            u.b("new deeplink 目标app已安装 ", "调起失败onDenied");
            f.this.j = true;
            this.f8689a.a((com.ubix.ssp.ad.e.a0.d.InterfaceC1085d) null);
            this.f8689a.c();
            Timer timer = this.b;
            if (timer != null) {
                timer.cancel();
            }
            com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.c, f.this.f, 404);
        }

        @Override // com.ubix.ssp.ad.e.a0.d.InterfaceC1085d
        public void b(int i) {
        }
    }

    class c extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.y.a.a.b f8690a;
        final /* synthetic */ com.ubix.ssp.ad.e.a0.d b;
        final /* synthetic */ Timer c;

        c(com.ubix.ssp.ad.e.y.a.a.b bVar, com.ubix.ssp.ad.e.a0.d dVar, Timer timer) {
            this.f8690a = bVar;
            this.b = dVar;
            this.c = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (!f.this.j) {
                    u.b("new deeplink 目标app已安装 ", "但是调起失败");
                    com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.f8690a, f.this.f, 404);
                    com.ubix.ssp.ad.e.a0.d dVar = this.b;
                    if (dVar != null) {
                        dVar.c();
                        this.b.a((com.ubix.ssp.ad.e.a0.d.InterfaceC1085d) null);
                    }
                }
                boolean unused = f.e = true;
                Timer timer = this.c;
                if (timer != null) {
                    timer.cancel();
                }
                cancel();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class d extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int[] f8691a;
        final /* synthetic */ com.ubix.ssp.ad.e.y.a.a.b b;
        final /* synthetic */ Timer c;

        d(int[] iArr, com.ubix.ssp.ad.e.y.a.a.b bVar, Timer timer) {
            this.f8691a = iArr;
            this.b = bVar;
            this.c = timer;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                boolean zC = com.ubix.ssp.ad.e.a0.c.C();
                int[] iArr = this.f8691a;
                int i = iArr[0];
                if (i > 100) {
                    if (zC) {
                        u.b("deeplink 目标app已安装 ", "但是调起失败" + this.f8691a[0]);
                        com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.b, f.this.f, 404);
                    } else {
                        com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.b, f.this.f, 403);
                    }
                    boolean unused = f.e = true;
                    Timer timer = this.c;
                    if (timer != null) {
                        timer.cancel();
                    }
                    cancel();
                    return;
                }
                iArr[0] = i + 1;
                if (zC) {
                    return;
                }
                if (!f.f8687a) {
                    boolean unused2 = f.f8687a = true;
                    com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.b, f.this.f, 403);
                }
                Timer timer2 = this.c;
                if (timer2 != null) {
                    timer2.cancel();
                }
                cancel();
                if (f.b != null) {
                    f.b.cancel();
                }
                if (f.c != null) {
                    f.c.cancel();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class e implements com.ubix.ssp.ad.e.z.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f8692a;
        final /* synthetic */ com.ubix.ssp.ad.d.a b;
        final /* synthetic */ n c;
        final /* synthetic */ o d;

        e(p pVar, com.ubix.ssp.ad.d.a aVar, n nVar, o oVar) {
            this.f8692a = pVar;
            this.b = aVar;
            this.c = nVar;
            this.d = oVar;
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar) {
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar, HashMap<String, String> map) {
            n nVar;
            int iD = f.this.d(this.b.f8604a);
            if ((iD == 2 || iD == 22) && (nVar = this.c) != null) {
                nVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void b(com.ubix.ssp.ad.e.z.h hVar) {
            o oVar = this.d;
            if (oVar != null) {
                oVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void c(com.ubix.ssp.ad.e.z.h hVar) {
            p pVar = this.f8692a;
            if (pVar != null) {
                pVar.a(hVar);
            }
        }
    }

    /* JADX INFO: renamed from: com.ubix.ssp.ad.e.a0.f$f, reason: collision with other inner class name */
    class C1087f implements com.ubix.ssp.ad.e.z.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.a f8693a;
        final /* synthetic */ String b;

        C1087f(com.ubix.ssp.ad.d.a aVar, String str) {
            this.f8693a = aVar;
            this.b = str;
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void a() {
            com.ubix.ssp.ad.d.a aVar = this.f8693a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8693a.f8604a.d.B, 0, f.this.i, this.b, null);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void b() {
            com.ubix.ssp.ad.d.a aVar = this.f8693a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8693a.f8604a.d.F, 0, f.this.i, this.b, null);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void c() {
            com.ubix.ssp.ad.d.a aVar = this.f8693a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8693a.f8604a.d.C, 0, f.this.i, this.b, null);
        }
    }

    class g implements com.ubix.ssp.ad.g.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r f8694a;
        final /* synthetic */ int b;
        final /* synthetic */ com.ubix.ssp.ad.d.a c;
        final /* synthetic */ s d;
        final /* synthetic */ q e;
        final /* synthetic */ o f;

        g(r rVar, int i, com.ubix.ssp.ad.d.a aVar, s sVar, q qVar, o oVar) {
            this.f8694a = rVar;
            this.b = i;
            this.c = aVar;
            this.d = sVar;
            this.e = qVar;
            this.f = oVar;
        }

        @Override // com.ubix.ssp.ad.g.b
        public void onCancel() {
            q qVar = this.e;
            if (qVar != null) {
                qVar.a();
            }
            try {
                com.ubix.ssp.ad.e.s.b.c().a(com.ubix.ssp.ad.e.a0.c.e(), this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.g.b
        public void onClose() {
            o oVar = this.f;
            if (oVar != null) {
                oVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.g.b
        public void onConfirm() {
            s sVar;
            r rVar = this.f8694a;
            if (rVar != null) {
                rVar.a();
            }
            try {
                boolean zA = false;
                if (com.ubix.ssp.ad.e.s.b.c().b(this.b) == 46) {
                    if (TextUtils.isEmpty(this.c.f8604a.d.o)) {
                        com.ubix.ssp.ad.e.y.a.a aVar = this.c.f8604a;
                        zA = com.ubix.ssp.ad.e.a0.c.a(aVar.d.h, com.ubix.ssp.ad.e.a0.c.a(aVar.f));
                    } else {
                        int iD = f.this.d(this.c.f8604a);
                        if (iD == 2 || iD == 22) {
                            zA = true;
                        }
                    }
                    if (zA && (sVar = this.d) != null) {
                        sVar.a();
                    }
                }
                if (com.ubix.ssp.ad.e.s.b.c().b(this.b) == 44 || zA) {
                    return;
                }
                f.a(f.this.i, this.c, this.b);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    class h implements com.ubix.ssp.ad.e.z.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f8695a;
        final /* synthetic */ r b;
        final /* synthetic */ com.ubix.ssp.ad.d.a c;
        final /* synthetic */ int d;
        final /* synthetic */ q e;
        final /* synthetic */ o f;

        h(p pVar, r rVar, com.ubix.ssp.ad.d.a aVar, int i, q qVar, o oVar) {
            this.f8695a = pVar;
            this.b = rVar;
            this.c = aVar;
            this.d = i;
            this.e = qVar;
            this.f = oVar;
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar) {
            q qVar = this.e;
            if (qVar != null) {
                qVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar, HashMap<String, String> map) {
            r rVar = this.b;
            if (rVar == null || rVar.a()) {
                f.a(f.this.i, this.c, this.d);
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void b(com.ubix.ssp.ad.e.z.h hVar) {
            o oVar = this.f;
            if (oVar != null) {
                oVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void c(com.ubix.ssp.ad.e.z.h hVar) {
            p pVar = this.f8695a;
            if (pVar != null) {
                pVar.a(hVar);
            }
        }
    }

    class i implements com.ubix.ssp.ad.e.z.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.a f8696a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;

        i(com.ubix.ssp.ad.d.a aVar, int i, String str) {
            this.f8696a = aVar;
            this.b = i;
            this.c = str;
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void a() {
            com.ubix.ssp.ad.d.a aVar = this.f8696a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            if (this.b != 1) {
                f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8696a.f8604a.d.B, 0, f.this.i, this.c, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE", 6);
            bundle.putString("TITLE", "隐私");
            bundle.putString("TARGET_URL", this.f8696a.f8604a.d.B);
            com.ubix.ssp.ad.e.a0.c.a(com.ubix.ssp.ad.e.a0.c.a(), bundle, (com.ubix.ssp.ad.e.z.h.c) null, (com.ubix.ssp.ad.e.z.h.b) null);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void b() {
            com.ubix.ssp.ad.d.a aVar = this.f8696a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            if (this.b != 1) {
                f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8696a.f8604a.d.F, 0, f.this.i, this.c, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE", 6);
            bundle.putString("TITLE", "应用介绍");
            bundle.putString("TARGET_URL", this.f8696a.f8604a.d.F);
            com.ubix.ssp.ad.e.a0.c.a(com.ubix.ssp.ad.e.a0.c.a(), bundle, (com.ubix.ssp.ad.e.z.h.c) null, (com.ubix.ssp.ad.e.z.h.b) null);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void c() {
            com.ubix.ssp.ad.d.a aVar = this.f8696a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            if (this.b != 1) {
                f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8696a.f8604a.d.C, 0, f.this.i, this.c, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putInt("TYPE", 6);
            bundle.putString("TITLE", "权限");
            bundle.putString("TARGET_URL", this.f8696a.f8604a.d.C);
            com.ubix.ssp.ad.e.a0.c.a(com.ubix.ssp.ad.e.a0.c.a(), bundle, (com.ubix.ssp.ad.e.z.h.c) null, (com.ubix.ssp.ad.e.z.h.b) null);
        }
    }

    class j implements com.ubix.ssp.ad.e.z.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f8697a;
        final /* synthetic */ r b;
        final /* synthetic */ com.ubix.ssp.ad.d.a c;
        final /* synthetic */ int d;
        final /* synthetic */ q e;
        final /* synthetic */ o f;

        j(p pVar, r rVar, com.ubix.ssp.ad.d.a aVar, int i, q qVar, o oVar) {
            this.f8697a = pVar;
            this.b = rVar;
            this.c = aVar;
            this.d = i;
            this.e = qVar;
            this.f = oVar;
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar) {
            q qVar = this.e;
            if (qVar != null) {
                qVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void a(com.ubix.ssp.ad.e.z.h hVar, HashMap<String, String> map) {
            r rVar = this.b;
            if (rVar == null || rVar.a()) {
                f.a(f.this.i, this.c, this.d);
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void b(com.ubix.ssp.ad.e.z.h hVar) {
            o oVar = this.f;
            if (oVar != null) {
                oVar.a();
            }
        }

        @Override // com.ubix.ssp.ad.e.z.h.c
        public void c(com.ubix.ssp.ad.e.z.h hVar) {
            p pVar = this.f8697a;
            if (pVar != null) {
                pVar.a(hVar);
            }
        }
    }

    class k implements com.ubix.ssp.ad.e.z.h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.d.a f8698a;
        final /* synthetic */ String b;

        k(com.ubix.ssp.ad.d.a aVar, String str) {
            this.f8698a = aVar;
            this.b = str;
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void a() {
            com.ubix.ssp.ad.d.a aVar = this.f8698a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8698a.f8604a.d.B, 0, f.this.i, this.b, null);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void b() {
            com.ubix.ssp.ad.d.a aVar = this.f8698a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8698a.f8604a.d.F, 0, f.this.i, this.b, null);
        }

        @Override // com.ubix.ssp.ad.e.z.h.b
        public void c() {
            com.ubix.ssp.ad.d.a aVar = this.f8698a;
            if (aVar == null || aVar.f8604a.d == null) {
                return;
            }
            f.a(com.ubix.ssp.ad.e.a0.c.a(), this.f8698a.f8604a.d.C, 0, f.this.i, this.b, null);
        }
    }

    class l extends com.ubix.ssp.ad.e.x.a.d {
        final /* synthetic */ com.ubix.ssp.ad.d.a b;
        final /* synthetic */ int c;

        l(com.ubix.ssp.ad.d.a aVar, int i) {
            this.b = aVar;
            this.c = i;
        }

        @Override // com.ubix.ssp.ad.e.x.a
        public void a(String str) {
            try {
                u.b("testUrl-onResponse:  " + str);
                JSONObject jSONObject = new JSONObject(str);
                com.ubix.ssp.ad.e.s.b.c().a(com.ubix.ssp.ad.e.a0.c.e(), jSONObject.getJSONObject("data").getString("clickid"), jSONObject.getJSONObject("data").getString("dstlink"), this.b, this.c);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.ubix.ssp.ad.e.x.a
        public void b(com.ubix.ssp.ad.e.x.d dVar) {
            u.b("launchSDK onFailure " + dVar.e);
        }
    }

    class m implements com.ubix.ssp.ad.e.a0.c.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.ubix.ssp.ad.e.y.a.a f8699a;

        m(com.ubix.ssp.ad.e.y.a.a aVar) {
            this.f8699a = aVar;
        }

        @Override // com.ubix.ssp.ad.e.a0.c.h
        public void a(int i, int i2) {
            try {
                HashMap<String, String> map = new HashMap<>();
                map.put("__U_TB_CHECK__", i + "");
                if (i == 0) {
                    com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.f8699a.d, map, 405);
                } else {
                    com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(this.f8699a.d, map, 406);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public interface n {
        void a();
    }

    public interface o {
        void a();
    }

    public interface p {
        void a(com.ubix.ssp.ad.e.z.h hVar);
    }

    public interface q {
        void a();
    }

    public interface r {
        boolean a();
    }

    public interface s {
        void a();
    }

    public f(com.ubix.ssp.ad.d.l lVar, HashMap<String, String> map) {
        this.f = new HashMap<>();
        this.f = map;
        this.i = lVar;
        if (map == null || !map.containsKey("__NO_CLICK_CONFIRM_KEY__")) {
            return;
        }
        this.g = Boolean.parseBoolean(map.get("__NO_CLICK_CONFIRM_KEY__"));
    }

    public static String a(com.ubix.ssp.ad.e.y.a.a.c cVar) {
        if (cVar == null || !cVar.o) {
            return null;
        }
        return cVar.n;
    }

    @Deprecated
    public static void a(com.ubix.ssp.ad.d.a aVar, int i2) {
        com.ubix.ssp.ad.e.x.g.b().a(aVar.f8604a.d.m, (Map<String, String>) null, new l(aVar, i2));
    }

    private void a(com.ubix.ssp.ad.e.y.a.a.b bVar) {
        if (d) {
            return;
        }
        d = true;
        Timer timer = new Timer();
        timer.schedule(new d(new int[]{0}, bVar, timer), 100L, 50L);
    }

    private void a(com.ubix.ssp.ad.e.y.a.a.b bVar, int i2) {
        if (d) {
            return;
        }
        d = true;
        u.b("new deeplink 目标app已安装 ", "调起检测开始");
        Timer timer = new Timer();
        com.ubix.ssp.ad.e.a0.d dVar = new com.ubix.ssp.ad.e.a0.d(com.ubix.ssp.ad.e.a0.c.e());
        dVar.a(new a(dVar, timer, bVar));
        dVar.a(new b(dVar, timer, bVar));
        timer.schedule(new c(bVar, dVar, timer), 5000L);
    }

    private static void a(com.ubix.ssp.ad.e.y.a.a aVar, boolean z) {
        if (z && aVar.i.equals("121")) {
            com.ubix.ssp.ad.e.a0.c.a(new m(aVar));
        }
    }

    public static boolean a(Context context, com.ubix.ssp.ad.e.y.a.a.b bVar) {
        u.b("adClickAction: ", "小程序调起类广告 ");
        return x.a(StubApp.getOrigApplicationContext(context.getApplicationContext()), bVar.u);
    }

    public static boolean a(Context context, String str, int i2, int i3, String str2, com.ubix.ssp.ad.e.y.a.a aVar, boolean z, boolean z2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (i3 == 1) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(805339136);
                com.ubix.ssp.ad.e.a0.c.e().startActivity(intent);
                return true;
            }
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName(context.getPackageName(), "com.ubix.ssp.open.comm.UBiXWebViewActivity"));
            intent2.putExtra("webUrl", str);
            intent2.putExtra("adType", i2 + "");
            intent2.putExtra("useInnerFace", z);
            intent2.putExtra("slotId", str2);
            if (aVar != null) {
                intent2.putExtra("ubixAdBytes", com.ubix.ssp.ad.e.y.c.f.a(aVar));
                if (a(aVar.f) != null) {
                    intent2.putExtra("replacePkg", a(aVar.f));
                }
                com.ubix.ssp.ad.e.y.a.a.c cVar = aVar.f;
                if (cVar != null) {
                    intent2.putExtra("removePkg", cVar.r);
                }
            }
            if (z2) {
                ((Activity) context).startActivityForResult(intent2, 866);
            } else {
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
            if (aVar != null) {
                com.ubix.ssp.ad.e.w.k.a(StubApp.getOrigApplicationContext(context.getApplicationContext())).a(aVar.d, 102);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean a(Context context, String str, int i2, com.ubix.ssp.ad.d.l lVar, String str2, com.ubix.ssp.ad.e.y.a.a aVar) {
        return a(context, str, i2, lVar.j0(), str2, aVar, false, false);
    }

    public static boolean a(com.ubix.ssp.ad.d.l lVar, com.ubix.ssp.ad.d.a aVar, int i2) {
        try {
            if (!com.ubix.ssp.ad.e.a0.c.g(com.ubix.ssp.ad.e.a0.c.e())) {
                Toast.makeText(com.ubix.ssp.ad.e.a0.c.e(), "下载失败", 0).show();
                return false;
            }
            com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.f8604a.d;
            u.b("adClickAction: ", " downloadApp " + bVar.n);
            if (TextUtils.isEmpty(bVar.n)) {
                if (bVar.l != 1) {
                    return false;
                }
                a(aVar, i2);
                return true;
            }
            if (lVar.o() == 1) {
                a(com.ubix.ssp.ad.e.a0.c.e(), bVar.n, 0, 1, "", null, false, false);
            } else {
                com.ubix.ssp.ad.e.s.b.c().a(com.ubix.ssp.ad.e.a0.c.e(), bVar.g, bVar.n, aVar, i2);
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private boolean b(com.ubix.ssp.ad.e.y.a.a aVar) {
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        com.ubix.ssp.ad.e.y.a.a.b.i iVar;
        return (aVar == null || (bVar = aVar.d) == null || (iVar = bVar.K) == null || TextUtils.isEmpty(iVar.c) || TextUtils.isEmpty(aVar.d.K.b)) ? false : true;
    }

    private boolean b(com.ubix.ssp.ad.e.y.a.a aVar, String str) {
        try {
            com.ubix.ssp.ad.e.y.a.a.b.j jVar = aVar.d.S;
            if (jVar != null && jVar.b != 0) {
                String str2 = !TextUtils.isEmpty(jVar.c) ? new String(com.ubix.ssp.ad.e.a0.n.a().a(aVar.d.S.c.getBytes(StandardCharsets.UTF_8))) : null;
                int i2 = aVar.d.S.b;
                if (i2 == 1) {
                    if (!this.i.B0() || TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    String strA = com.ubix.ssp.ad.e.a0.c.a(aVar.f);
                    Intent intentC = com.ubix.ssp.ad.e.a0.c.c(str);
                    com.ubix.ssp.ad.e.a0.c.a(intentC, str2);
                    com.ubix.ssp.ad.e.a0.c.a(StubApp.getOrigApplicationContext(com.ubix.ssp.ad.e.a0.c.e().getApplicationContext()), intentC, strA);
                    return true;
                }
                if (i2 == 2) {
                    if (!this.i.w0() || TextUtils.isEmpty(aVar.d.S.d) || TextUtils.isEmpty(str2)) {
                        return false;
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(new String(com.ubix.ssp.ad.e.a0.n.a().a("cGtnTmFtZQ==".getBytes(StandardCharsets.UTF_8))), aVar.d.h);
                    jSONObject.put(new String(com.ubix.ssp.ad.e.a0.n.a().a("ZGVlcExpbms=".getBytes(StandardCharsets.UTF_8))), aVar.d.S.d);
                    return com.ubix.ssp.ad.e.a0.c.a(com.ubix.ssp.ad.e.a0.c.e(), str2, jSONObject);
                }
                if (i2 != 3 || !this.i.I0() || TextUtils.isEmpty(aVar.d.S.d)) {
                    return false;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("a", aVar.d.h);
                jSONObject2.put(com.kuaishou.weapon.p0.t.l, aVar.d.S.d);
                String strA2 = com.ubix.ssp.ad.e.a0.c.a(aVar.f);
                Intent intentC2 = com.ubix.ssp.ad.e.a0.c.c(aVar.d.S.d);
                intentC2.setData(null);
                intentC2.setAction(new String(com.ubix.ssp.ad.e.a0.n.a().a("Y29tLmthaXhpbmthbi51Z2MudmlkZW8uYXRvbS5zZXR0aW5nLlNka1JlZGlyZWN0SnVtcEFjdGl2aXR5".getBytes(StandardCharsets.UTF_8))));
                intentC2.putExtra(new String(com.ubix.ssp.ad.e.a0.n.a().a("aW50ZW50X2J1bmRsZV9jb21tb25fdHJhbnNmZXJfZGF0YQ==".getBytes(StandardCharsets.UTF_8))), jSONObject2.toString());
                com.ubix.ssp.ad.e.a0.c.a(StubApp.getOrigApplicationContext(com.ubix.ssp.ad.e.a0.c.e().getApplicationContext()), intentC2, strA2);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    private boolean c(com.ubix.ssp.ad.e.y.a.a aVar) {
        try {
            com.ubix.ssp.ad.e.y.a.a.b.i iVar = aVar.d.K;
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(805339136);
            intent.setComponent(new ComponentName(iVar.b, iVar.c));
            intent.setData(Uri.parse(aVar.d.o));
            com.ubix.ssp.ad.e.y.a.a.b.c[] cVarArr = iVar.d;
            if (cVarArr != null && cVarArr.length > 0) {
                for (com.ubix.ssp.ad.e.y.a.a.b.c cVar : cVarArr) {
                    if (!TextUtils.isEmpty(cVar.c)) {
                        String str = cVar.c;
                        int i2 = cVar.e;
                        if (i2 == 0) {
                            intent.putExtra(str, cVar.d);
                        } else if (i2 == 1) {
                            intent.putExtra(str, Integer.parseInt(cVar.d));
                        } else if (i2 == 2) {
                            try {
                                intent.putExtra(str, Boolean.parseBoolean(cVar.d));
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            com.ubix.ssp.ad.e.a0.y.d.d.e().a(true);
            com.ubix.ssp.ad.e.a0.y.d.d.e().a(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName());
            com.ubix.ssp.ad.e.a0.c.e().startActivity(intent);
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private void e(com.ubix.ssp.ad.e.y.a.a aVar) {
        int iP = this.i.p();
        com.ubix.ssp.ad.e.y.a.a.b bVar = aVar.d;
        if (iP == 0) {
            a(bVar);
        } else {
            a(bVar, iP);
        }
    }

    private int f(com.ubix.ssp.ad.e.y.a.a aVar) {
        if (b(aVar)) {
            return !c(aVar) ? 23 : 22;
        }
        return 21;
    }

    public int a(com.ubix.ssp.ad.d.a aVar, int i2, String str, int i3, int i4, int i5, p pVar, q qVar, r rVar, o oVar, s sVar, com.ubix.ssp.ad.g.c cVar, n nVar, com.ubix.ssp.ad.g.h hVar) {
        com.ubix.ssp.ad.e.y.a.a aVar2;
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        Object obj;
        Object obj2;
        boolean z;
        Context contextA;
        boolean zIsFinishing;
        boolean z2;
        try {
            d = false;
            f8687a = false;
            e = false;
            if (aVar != null && (aVar2 = aVar.f8604a) != null && (bVar = aVar2.d) != null) {
                Bundle bundle = new Bundle();
                try {
                    String str2 = bVar.g;
                    String str3 = bVar.A;
                    String str4 = bVar.z;
                    String str5 = bVar.C;
                    String str6 = bVar.F;
                    String str7 = bVar.B;
                    obj2 = "__CLICK_AREA__";
                    try {
                        String str8 = bVar.H;
                        obj = "__NO_CLICK_CONFIRM_KEY__";
                        try {
                            String str9 = bVar.I;
                            long j2 = bVar.G;
                            bundle.putBoolean("IS_DOWNLOAD", com.ubix.ssp.ad.e.a0.c.a(str2, str3, str4, str5, str7, str6));
                            bundle.putString("ICON_URL", bVar.i);
                            bundle.putString("DOWNLOAD_APP_NAME", str2);
                            bundle.putString("DOWNLOAD_APP_PUBLISHER", str4);
                            bundle.putString("DOWNLOAD_APP_VERSION", str3);
                            bundle.putLong("DOWNLOAD_APP_SIZE", j2);
                            bundle.putString("DOWNLOAD_APP_ICP_NUMBER", str8);
                            bundle.putString("DOWNLOAD_APP_SUITABLE_AGE", str9);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obj = "__NO_CLICK_CONFIRM_KEY__";
                    }
                } catch (Exception e4) {
                    e = e4;
                    obj = "__NO_CLICK_CONFIRM_KEY__";
                    obj2 = "__CLICK_AREA__";
                }
                if (TextUtils.isEmpty(bVar.o)) {
                    str = str;
                    z = false;
                } else {
                    com.ubix.ssp.ad.e.y.a.a aVar3 = aVar.f8604a;
                    com.ubix.ssp.ad.e.y.a.a.C1107a c1107a = aVar3.l;
                    if (c1107a != null) {
                        int i6 = c1107a.b;
                        if (i6 == 1) {
                            bundle.putInt("TYPE", 3);
                            com.ubix.ssp.ad.e.a0.c.a(com.ubix.ssp.ad.e.a0.c.e(), bundle, new e(pVar, aVar, nVar, oVar), new C1087f(aVar, str));
                            return 32;
                        }
                        z2 = i6 == 2;
                    }
                    int iD = d(aVar3);
                    boolean z3 = iD == 2 || iD == 22;
                    if (z3) {
                        if (z2) {
                            return 31;
                        }
                        return iD;
                    }
                    z = z3;
                }
                if (bVar.u != null) {
                    boolean zA = a(com.ubix.ssp.ad.e.a0.c.e(), bVar);
                    if (zA && zA) {
                        return 5;
                    }
                    z = zA;
                }
                if (!TextUtils.isEmpty(bVar.n)) {
                    HashMap<String, String> map = this.f;
                    if (map != null && map.containsKey("__CAN_RUN_ACTIVE_KEY__")) {
                        this.h = Boolean.parseBoolean(this.f.get("__CAN_RUN_ACTIVE_KEY__"));
                    }
                    if (bVar.l == 1 || cVar != null || this.h) {
                        if (com.ubix.ssp.ad.e.a0.c.a(!TextUtils.isEmpty(aVar.u) ? aVar.u : bVar.h, com.ubix.ssp.ad.e.a0.c.a(aVar.f8604a.f))) {
                            com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(bVar, this.f, 401);
                            com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(bVar, this.f, 307);
                            z = true;
                        }
                        if (z) {
                            return 2;
                        }
                    }
                    boolean zA2 = z;
                    HashMap<String, String> map2 = this.f;
                    if (map2 != null) {
                        Object obj3 = obj;
                        if (map2.containsKey(obj3)) {
                            this.g = Boolean.parseBoolean(this.f.get(obj3));
                        }
                    }
                    if (com.ubix.ssp.ad.d.b.r != 1 || this.g) {
                        if (hVar == null || aVar.e != 9) {
                            zA2 = a(this.i, aVar, i4);
                        } else {
                            HashMap<String, String> map3 = this.f;
                            if (map3 != null) {
                                Object obj4 = obj2;
                                if ("2".equals(map3.get(obj4)) || "16".equals(this.f.get(obj4)) || BaseWrapper.ENTER_ID_17.equals(this.f.get(obj4)) || BaseWrapper.ENTER_ID_18.equals(this.f.get(obj4)) || BaseWrapper.ENTER_ID_19.equals(this.f.get(obj4))) {
                                    zA2 = a(this.i, aVar, i4);
                                }
                            }
                            if (!hVar.a()) {
                                return 6;
                            }
                        }
                    } else {
                        if (cVar != null) {
                            try {
                                contextA = com.ubix.ssp.ad.e.a0.c.e();
                                try {
                                    zIsFinishing = contextA instanceof Activity ? ((Activity) contextA).isFinishing() : true;
                                } catch (Throwable unused) {
                                }
                            } catch (Throwable unused2) {
                                contextA = null;
                            }
                            if (zIsFinishing) {
                                contextA = com.ubix.ssp.ad.e.a0.c.a();
                            }
                            cVar.a(contextA, bundle, new g(rVar, i4, aVar, sVar, qVar, oVar));
                            return 7;
                        }
                        bundle.putString("ICON_URL", bVar.i);
                        bundle.putInt("TYPE", 2);
                        if (i3 == 1) {
                            com.ubix.ssp.ad.e.a0.c.a(com.ubix.ssp.ad.e.a0.c.e(), bundle, new h(pVar, rVar, aVar, i4, qVar, oVar), new i(aVar, i5, str));
                        } else {
                            com.ubix.ssp.ad.e.a0.c.b(com.ubix.ssp.ad.e.a0.c.a(), bundle, new j(pVar, rVar, aVar, i4, qVar, oVar), new k(aVar, str));
                        }
                        if (!TextUtils.isEmpty(bVar.n)) {
                            return 6;
                        }
                    }
                    if (zA2) {
                        return 4;
                    }
                }
                if (TextUtils.isEmpty(bVar.m)) {
                    u.b("clicked methods all failed ");
                } else {
                    String strA = bVar.m;
                    try {
                        strA = com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(0, bVar.M, bVar.P, this.f, bVar.m);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (a(com.ubix.ssp.ad.e.a0.c.e(), strA, i2, this.i, str, aVar.f8604a)) {
                        return this.i.j0() == 1 ? 33 : 3;
                    }
                }
                String strA2 = bVar.m;
                try {
                    strA2 = com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(0, bVar.M, bVar.P, this.f, bVar.m);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
                return a(com.ubix.ssp.ad.e.a0.c.e(), strA2, i2, this.i, str, aVar.f8604a) ? 3 : 1;
            }
            u.b("click ad is null");
            return 1;
        } catch (Exception e5) {
            e5.printStackTrace();
            return 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        if (com.ubix.ssp.ad.e.a0.c.f8631a.getPackageManager().getLaunchIntentForPackage(r10.d.h) != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (com.ubix.ssp.ad.e.a0.c.e().getPackageManager().resolveActivity(r5, 65536) != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(r10.d, r9.f, 401);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0066, code lost:
    
        if (com.ubix.ssp.ad.e.a0.u.a() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0068, code lost:
    
        com.ubix.ssp.ad.e.a0.u.e("super opt op&hr&vi=" + r9.i.B0() + "&" + r9.i.w0() + "&" + r9.i.I0());
        r0 = new java.lang.StringBuilder("super opt info=");
        r1 = r10.d.S;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00a3, code lost:
    
        if (r1 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a5, code lost:
    
        r1 = r1.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00aa, code lost:
    
        r1 = "null";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ac, code lost:
    
        com.ubix.ssp.ad.e.a0.u.e(r0.append(r1).toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00b7, code lost:
    
        r0 = b(r10, r11);
        com.ubix.ssp.ad.e.a0.u.e("super opt result=" + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00cc, code lost:
    
        if (r0 == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ce, code lost:
    
        e(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d1, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d2, code lost:
    
        r0 = r10.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d8, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dc, code lost:
    
        if (r0.s != 1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00f1, code lost:
    
        if (r11.startsWith(new java.lang.String(com.ubix.ssp.ad.e.a0.n.a().a("aHR0cA=="))) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0100, code lost:
    
        if (new com.ubix.ssp.ad.e.a0.y.b().a(com.ubix.ssp.ad.e.a0.c.e(), r11, true) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0102, code lost:
    
        e(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0105, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0106, code lost:
    
        com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(r10.d, r9.f, 404);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0115, code lost:
    
        return 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0116, code lost:
    
        r4 = f(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011c, code lost:
    
        if (r4 != 21) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0122, code lost:
    
        if (a(r10) == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0129, code lost:
    
        if (r4 != 22) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x012b, code lost:
    
        e(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012f, code lost:
    
        com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(r10.d, r9.f, 404);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:?, code lost:
    
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:?, code lost:
    
        return 20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int a(com.ubix.ssp.ad.e.y.a.a aVar, String str) {
        int iF = 1;
        if (aVar == null || aVar.d == null) {
            return 1;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = aVar.d.o;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
            if (!TextUtils.isEmpty(aVar.d.h)) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return iF;
        com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(aVar.d, this.f, 402);
        return 1;
    }

    public boolean a(com.ubix.ssp.ad.e.y.a.a aVar) {
        com.ubix.ssp.ad.e.y.a.a.b bVar;
        if (aVar != null && (bVar = aVar.d) != null) {
            String str = bVar.o;
            if (!TextUtils.isEmpty(str)) {
                try {
                    String strA = com.ubix.ssp.ad.e.a0.c.a(aVar.f);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    if (!TextUtils.isEmpty(strA)) {
                        intent.putExtra("android.intent.extra.REFERRER", Uri.parse("android-app://" + strA));
                    }
                    intent.addFlags(805339136);
                    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    com.ubix.ssp.ad.e.a0.y.d.d.e().a(true);
                    com.ubix.ssp.ad.e.a0.y.d.d.e().a(stackTrace[0].getClassName() + "." + stackTrace[0].getMethodName());
                    com.ubix.ssp.ad.e.a0.c.e().startActivity(intent);
                    e(aVar);
                    try {
                        a(aVar, ez.Code.equals(this.f.get("__SHOULD_CHECK__")));
                    } catch (Exception unused) {
                    }
                    u.b("打开deeplink  ", "安装该APP ");
                    if (com.ubix.ssp.ad.e.a0.c.g("com.tencent.mm") && !TextUtils.isEmpty(str) && str.startsWith("weixin://")) {
                        d = true;
                        com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(bVar, this.f, 403);
                    }
                    u.b("打开deeplink  ", "installed " + f8687a + " getTargetUrl: " + str);
                    return true;
                } catch (Exception unused2) {
                    u.d("打开deeplink  ", "没有安装该APP ");
                    com.ubix.ssp.ad.e.w.k.a(com.ubix.ssp.ad.e.a0.c.e()).a(bVar, this.f, 402);
                }
            }
        }
        return false;
    }

    public int d(com.ubix.ssp.ad.e.y.a.a aVar) {
        return a(aVar, (String) null);
    }
}
