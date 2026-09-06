package com.byazt.lr;

import android.text.TextUtils;
import com.byazt.gq.t;
import com.byazt.nr.m;
import com.byazt.ou.my;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@com.byazt.zqa.c(c = {0, 1, 155, 34})
public class a {
    public final AtomicInteger c;

    @com.byazt.zqa.c(c = {0, 1, 155, 464})
    private static class c {
        public static a c = new a();
    }

    public static a c() {
        return c.c;
    }

    private a() {
        this.c = new AtomicInteger(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String tt() {
        return (this.c.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com").concat("/customer/api/app/deep_link");
    }

    public void c(final com.byazt.nn.n nVar, final x xVar) {
        if (t.uj() == null) {
            com.byazt.dm.ve.c().c("getDownloadNetworkFactory == NULL");
            c(401, nVar);
        } else {
            com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.lr.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a aVar = a.this;
                    aVar.tt(nVar, aVar.tt(), a.this.c(nVar, true, 4), xVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.nn.n nVar, String str, byte[] bArr, x xVar) {
        if (this.c.get() < 6) {
            this.c.incrementAndGet();
            tt(nVar, str, bArr, xVar);
        } else {
            c("当前网络不佳，请稍后再试");
            this.c.set(0);
            c(402, nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(final com.byazt.nn.n nVar, final String str, final byte[] bArr, final x xVar) {
        t.uj().c(str, bArr, "application/json; charset=utf-8", 0, new my() { // from class: com.byazt.lr.a.2
            @Override // com.byazt.ou.my
            public void c(String str2) {
                a.this.c(nVar, str2, xVar);
            }

            @Override // com.byazt.ou.my
            public void c(Throwable th) {
                a.this.c(nVar, str, bArr, xVar);
            }
        });
    }

    private void c(final String str) {
        com.byazt.di.x.c().tt().post(new Runnable() { // from class: com.byazt.lr.a.3
            @Override // java.lang.Runnable
            public void run() {
                t.ve().c(6, t.getContext(), null, str, null, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] c(com.byazt.nn.n nVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", nVar.c());
            jSONObject.put("package_name", nVar.n());
            jSONObject.put("call_scene", 50);
            if (z) {
                jSONObject.put("sender_package_name", t.getContext().getPackageName());
                jSONObject.put("sender_version", t.da().n);
                if (i > 0) {
                    jSONObject.put("store", i);
                }
            } else {
                jSONObject.put("id", String.valueOf(nVar.tt()));
                if (nVar.rl().getDeepLink() != null) {
                    if (TextUtils.isEmpty(nVar.rl().getDeepLink().getWebUrl())) {
                        com.byazt.dm.ve.c().c("web_url is null");
                    }
                    jSONObject.put("web_url", nVar.rl().getDeepLink().getWebUrl());
                } else {
                    com.byazt.dm.ve.c().c("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.byazt.dm.ve.c().c("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.byazt.nn.n nVar, String str, x xVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.byazt.dm.ve.c().c("response content is null");
                c(404, nVar);
                xVar.c();
                return;
            }
            this.c.set(0);
            n nVarSp = n.sp(str);
            if (nVarSp.c() != 0) {
                c(403, nVar);
                xVar.c();
            } else if (TextUtils.isEmpty(nVarSp.tt())) {
                c(405, nVar);
                xVar.c();
            } else {
                xVar.c(nVarSp.tt());
            }
        } catch (Exception e) {
            com.byazt.dm.ve.c().c(e, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void c(int i, com.byazt.nn.n nVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i));
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zn.c.c().c("get_miui_market_compliance_error", jSONObject, nVar);
    }

    public void c(int i, com.byazt.nn.n nVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i));
        } catch (Exception e) {
            m.c(e);
        }
        com.byazt.zn.c.c().c("get_miui_market_compliance_success", jSONObject, nVar);
    }
}
