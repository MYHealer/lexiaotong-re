package com.opos.mobad.activity.webview.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.activity.webview.e;
import com.opos.mobad.cmn.func.adhandler.f;
import com.opos.mobad.cmn.func.b.g;
import com.opos.mobad.d.c.c;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a implements com.opos.mobad.activity.webview.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e f6599a;
    private AdItemData b;
    private MaterialData c;
    private com.opos.mobad.cmn.func.a d;
    private volatile com.opos.mobad.b e;
    private WebDataHepler f;
    private com.opos.mobad.activity.webview.b.a g;
    private f h;
    private com.opos.mobad.t.a i;

    public a(com.opos.mobad.b bVar, f fVar) {
        this.e = bVar;
        this.h = fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i) {
        if (this.e == null) {
            com.opos.cmn.an.f.a.b("AdJsListener", "load but has destroy");
        } else if (TextUtils.isEmpty(str)) {
            com.opos.cmn.an.f.a.b("AdJsListener", "notify but empty funcName " + i);
        } else {
            c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.7
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.e == null) {
                        com.opos.cmn.an.f.a.b("AdJsListener", "load but has destroy");
                    } else {
                        a aVar = a.this;
                        aVar.e(aVar.b(str, i));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, AdItemData adItemData) {
        com.opos.mobad.cmn.service.pkginstall.c.b bVarI = g.i();
        if (this.e == null) {
            return;
        }
        com.opos.mobad.b bVarC = this.e.c();
        if (bVarI == null) {
            com.opos.mobad.cmn.service.pkginstall.c.a(bVarC.b()).a(str, bVarC, adItemData);
        } else {
            com.opos.mobad.cmn.service.pkginstall.c.a(bVarC.b()).a(str, bVarC, bVarI, adItemData);
        }
    }

    private void a(final Callable<Boolean> callable, final String str) {
        f fVar = this.h;
        if (fVar != null && fVar.b() && fVar.a()) {
            fVar.b(this.e.b(), new f.a() { // from class: com.opos.mobad.activity.webview.a.a.8
                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void a() {
                    a.this.a(str, (Callable<Boolean>) callable);
                }

                @Override // com.opos.mobad.cmn.func.adhandler.f.a
                public void b() {
                    a.this.a(str, 3);
                }
            });
        } else {
            a(str, callable);
        }
    }

    private boolean a(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str, String str2, String str3, String str4, String str5) {
        switch (i) {
            case 1:
            case 3:
                a(str2, this.b);
                this.f6599a.a(str, str2, str3, str4);
                return true;
            case 2:
                this.f6599a.b(str);
                return true;
            case 4:
                this.f6599a.c(str);
                return true;
            case 5:
                return b(str);
            case 6:
                return c(str2);
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, String str2, String str3, String str4, String str5) {
        if (!com.opos.cmn.an.d.a.a(str) && this.d != null) {
            com.opos.cmn.an.f.a.b("AdJsListener", "downloadApk pkgName=" + str + ",posId=" + str2 + ",channelPkg=" + (str3 != null ? str3 : "null") + ",trackContent=" + (str4 != null ? str4 : "null") + ",trackReference=" + (str5 != null ? str5 : "null"));
            if (this.e != null) {
                com.opos.mobad.cmn.func.a aVar = this.d;
                Context contextB = this.e.b();
                MaterialData materialData = this.c;
                String strO = materialData != null ? materialData.o() : "";
                AdItemData adItemData = this.b;
                if (aVar.a(contextB, str, str2, str3, strO, str4, str5, adItemData != null ? adItemData.af() : "")) {
                    f(str);
                    a(str, this.b);
                    com.opos.cmn.an.f.a.b("AdJsListener", "downloadApk pkgName" + str + " = true");
                    return true;
                }
            }
            com.opos.cmn.an.f.a.b("AdJsListener", "downloadApk pkgName=" + str + " = false");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Callable<Boolean> callable) {
        if (callable != null) {
            try {
                if (callable.call().booleanValue()) {
                    a(str, 1);
                    return true;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdJsListener", "", e);
            }
        }
        a(str, 2);
        return false;
    }

    private String b(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            return jSONObject.toString();
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return "javascript:" + str + "(" + b(i) + ")";
    }

    private boolean b(final Callable<Boolean> callable, final String str) {
        f fVar = this.h;
        if (fVar == null || !fVar.b()) {
            return a(str, callable);
        }
        fVar.a(this.e.b(), new f.a() { // from class: com.opos.mobad.activity.webview.a.a.9
            @Override // com.opos.mobad.cmn.func.adhandler.f.a
            public void a() {
                a.this.a(str, (Callable<Boolean>) callable);
            }

            @Override // com.opos.mobad.cmn.func.adhandler.f.a
            public void b() {
                a.this.a(str, 3);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(String str) {
        e eVar;
        try {
            com.opos.cmn.an.f.a.b("AdJsListener", "loadUrl=" + (str != null ? str : "null"));
            if (com.opos.cmn.an.d.a.a(str) || (eVar = this.f6599a) == null) {
                return;
            }
            eVar.a(str);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        try {
            if (this.i != null) {
                HashMap map = new HashMap();
                map.put("app_pkg", str);
                this.i.a(map);
            }
        } catch (Throwable unused) {
            com.opos.cmn.an.f.a.d("AdJsListener", "notifyDlClick");
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public int a() {
        return g.g();
    }

    public void a(com.opos.mobad.activity.webview.b.a aVar) {
        this.g = aVar;
    }

    public void a(e eVar, WebDataHepler webDataHepler, com.opos.mobad.cmn.func.a aVar) {
        this.f6599a = eVar;
        this.f = webDataHepler;
        AdItemData adItemDataA = webDataHepler.a();
        this.b = adItemDataA;
        this.c = adItemDataA.i().get(0);
        this.d = aVar;
    }

    public void a(com.opos.mobad.t.a aVar) {
        this.i = aVar;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, final String str2) {
        try {
            com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant instantUrl=" + (str != null ? str : "null"));
            if (this.e == null || com.opos.cmn.an.d.a.a(str) || this.d == null) {
                c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.13
                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.e(str2);
                        com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                    }
                });
            } else {
                this.d.a(this.e.b(), this.f.a().d(), this.f.a().e(), str, new com.opos.mobad.cmn.func.a.InterfaceC0945a() { // from class: com.opos.mobad.activity.webview.a.a.12
                    @Override // com.opos.mobad.cmn.func.a.InterfaceC0945a
                    public void a() {
                        com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant success.");
                    }

                    @Override // com.opos.mobad.cmn.func.a.InterfaceC0945a
                    public void a(int i, String str3) {
                        c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.12.1
                            @Override // java.lang.Runnable
                            public void run() {
                                a.this.e(str2);
                                com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                            }
                        });
                    }
                }, this.c.o());
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(final String str, final String str2, final String str3, final String str4, final int i, final String str5) {
        com.opos.cmn.an.f.a.b("AdJsListener", "actionDownload pkgName :" + str2 + ",actionType:" + i + ",url:" + str);
        if (this.f6599a == null) {
            a(str5, 2);
            return;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            a(str5, 2);
            return;
        }
        Callable<Boolean> callable = new Callable<Boolean>() { // from class: com.opos.mobad.activity.webview.a.a.14
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.a(i, str, str2, str3, str4, str5));
            }
        };
        if (a(i)) {
            a(callable, str5);
        } else {
            b(callable, str5);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, boolean z, String str2) {
        try {
            a(str, z, (String) null, (String) null, str2);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(final String str, boolean z, final String str2, final String str3, String str4) {
        a(new Callable() { // from class: com.opos.mobad.activity.webview.a.a.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() {
                try {
                    if (a.this.f != null) {
                        a aVar = a.this;
                        return Boolean.valueOf(aVar.a(str, aVar.f.b(), a.this.c.r(), str2, str3));
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("AdJsListener", "", e);
                }
                return false;
            }
        }, str4);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean a(String str) {
        boolean z = false;
        int i = -1;
        if (!TextUtils.isEmpty(str)) {
            try {
                String[] strArrSplit = str.split(",");
                if (strArrSplit != null && strArrSplit.length > 0) {
                    SensorManager sensorManager = (SensorManager) this.e.b().getSystemService("sensor");
                    for (String str2 : strArrSplit) {
                        try {
                            int i2 = Integer.parseInt(str2);
                            if (sensorManager.getDefaultSensor(i2) == null) {
                                i = i2;
                            }
                        } catch (Throwable th) {
                            com.opos.cmn.an.f.a.d("AdJsListener", "parse error", th);
                        }
                    }
                    z = true;
                }
            } catch (Throwable th2) {
                com.opos.cmn.an.f.a.d("AdJsListener", "isSupportSensorType error", th2);
            }
        }
        com.opos.cmn.an.f.a.a("AdJsListener", "isSupportSensorType,types=" + str + ",notSupportType=" + i + ",isSupportSensors=" + z);
        return z;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean a(final String str, final String str2, String str3) {
        return b(new Callable() { // from class: com.opos.mobad.activity.webview.a.a.10
            @Override // java.util.concurrent.Callable
            public Object call() throws Exception {
                return Boolean.valueOf(a.this.d.a(a.this.e.b(), a.this.b.ad(), str, str2));
            }
        }, str3);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String b() {
        return g.f();
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String b(String str, String str2) {
        String string = "";
        if (this.f6599a == null) {
            return "";
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            com.opos.mobad.cmn.service.a.b bVarA = this.f6599a.a(str, str2);
            if (bVarA != null && bVarA.f6846a == 102) {
                this.f6599a.a(str, str2, "", "");
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("dlStatus", bVarA != null ? bVarA.f6846a : 0);
                jSONObject.put("dlProcess", bVarA != null ? bVarA.b : 0);
                string = jSONObject.toString();
            } catch (JSONException e) {
                com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
            }
        }
        com.opos.cmn.an.f.a.b("AdJsListener", "getDownloaderStatus :" + string);
        return string;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void b(final String str, final String str2, String str3) {
        a(new Callable<Boolean>() { // from class: com.opos.mobad.activity.webview.a.a.15
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                boolean z;
                if (com.opos.cmn.an.d.a.a(str) || a.this.d == null || a.this.e == null || !a.this.d.d(a.this.e.b(), str)) {
                    z = false;
                } else {
                    a.this.f(str2);
                    a aVar = a.this;
                    aVar.a(str2, aVar.b);
                    com.opos.cmn.an.f.a.b("AdJsListener", "launchMarketDeeplinkDLApk pkgName" + str2 + " = true");
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }, str3);
    }

    public boolean b(String str) {
        if (this.e == null || com.opos.cmn.an.d.a.a(str)) {
            return false;
        }
        try {
            return com.opos.mobad.f.b.b.a(this.e.b(), com.opos.cmn.d.a.a(this.e.b(), str));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e);
            return false;
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void c() {
        try {
            e eVar = this.f6599a;
            if (eVar != null) {
                eVar.a();
            }
            com.opos.mobad.activity.webview.b.a aVar = this.g;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void c(final String str, final String str2, String str3) {
        a(new Callable<Boolean>() { // from class: com.opos.mobad.activity.webview.a.a.2
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                boolean z;
                if (com.opos.cmn.an.d.a.a(str) || a.this.d == null || a.this.e == null || !a.this.d.e(a.this.e.b(), str)) {
                    z = false;
                } else {
                    a.this.f(str2);
                    a aVar = a.this;
                    aVar.a(str2, aVar.b);
                    com.opos.cmn.an.f.a.b("AdJsListener", "launchMarketDeeplinkDLApk pkgName" + str2 + " = true");
                    z = true;
                }
                return Boolean.valueOf(z);
            }
        }, str3);
    }

    public boolean c(String str) {
        com.opos.mobad.cmn.func.a aVar;
        if (com.opos.cmn.an.d.a.a(str) || this.e == null || (aVar = this.d) == null) {
            return false;
        }
        boolean zA = aVar.a(this.e.b(), str);
        if (zA && this.f.a().z()) {
            g.i().c(this.f.a(), str);
        }
        return zA;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean c(final String str, String str2) {
        return b(new Callable<Boolean>() { // from class: com.opos.mobad.activity.webview.a.a.3
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf(a.this.c(str));
            }
        }, str2);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void d() {
        com.opos.cmn.an.f.a.a("AdJsListener", "goBackOrFinish");
        if (this.f6599a != null) {
            c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.11
                @Override // java.lang.Runnable
                public void run() {
                    a.this.f6599a.c();
                }
            });
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void d(final String str) {
        c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.6
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f6599a != null) {
                    a.this.f6599a.d(str);
                }
            }
        });
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean d(final String str, String str2) {
        return b(new Callable<Boolean>() { // from class: com.opos.mobad.activity.webview.a.a.4
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Boolean call() throws Exception {
                return Boolean.valueOf((TextUtils.isEmpty(str) || a.this.d == null || a.this.e == null) ? false : a.this.d.b(a.this.e.b(), str));
            }
        }, str2);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String e() {
        WebDataHepler webDataHepler = this.f;
        return webDataHepler == null ? "" : webDataHepler.b();
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void e(final String str, final String str2) {
        c.c(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.f6599a != null) {
                    a.this.f6599a.b(str, str2);
                }
            }
        });
    }

    public void f() {
        this.e = null;
    }
}
