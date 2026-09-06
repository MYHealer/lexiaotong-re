package com.gnete.upbc.cashier.e;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.gnete.upbc.cashier.GnetePayChannel;
import com.gnete.upbc.cashier.GnetePayListener;
import com.gnete.upbc.cashier.GnetePayRequest;
import com.gnete.upbc.cashier.b.j;
import com.huawei.openalliance.ad.constant.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: ALIPAYHandler.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class a extends b {

    /* JADX INFO: renamed from: com.gnete.upbc.cashier.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ALIPAYHandler.java */
    class C0385a implements com.gnete.upbc.cashier.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.gnete.upbc.cashier.f.b f3288a;

        /* JADX INFO: renamed from: com.gnete.upbc.cashier.e.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ALIPAYHandler.java */
        class C0386a implements b.InterfaceC0387b {
            C0386a() {
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a() {
                com.gnete.upbc.cashier.g.b.a(GnetePayChannel.ALIPAY, a.this.c);
            }

            @Override // com.gnete.upbc.cashier.e.b.InterfaceC0387b
            public void a(String str, Throwable th) {
                a aVar = a.this;
                com.gnete.upbc.cashier.g.b.a(aVar.f3290a, aVar.b, str, th, aVar.c);
            }
        }

        C0385a(com.gnete.upbc.cashier.f.b bVar) {
            this.f3288a = bVar;
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(com.gnete.upbc.cashier.b.a aVar) {
            a.this.a(aVar.b(), new C0386a());
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a(String str, Throwable th) {
            a aVar = a.this;
            com.gnete.upbc.cashier.g.b.a(aVar.f3290a, aVar.b, str, th, aVar.c);
        }

        @Override // com.gnete.upbc.cashier.a.b
        public void a() {
            this.f3288a.dismissAllowingStateLoss();
        }
    }

    public a(Activity activity, GnetePayRequest gnetePayRequest, GnetePayListener gnetePayListener) {
        super(activity, gnetePayRequest, gnetePayListener);
    }

    @Override // com.gnete.upbc.cashier.e.b
    public void a(j jVar, b.InterfaceC0387b interfaceC0387b) {
        if (TextUtils.isEmpty(jVar.c()) || TextUtils.isEmpty(jVar.b())) {
            interfaceC0387b.a("appid或跳转路径未配置，请联系客户经理", null);
            return;
        }
        String strA = com.gnete.upbc.cashier.a.a();
        if (TextUtils.isEmpty(strA)) {
            strA = jVar.a();
        }
        String strB = b(strA);
        if (TextUtils.isEmpty(strB)) {
            interfaceC0387b.a("appScheme未配置，请联系客户经理", null);
            return;
        }
        try {
            this.f3290a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("alipays://platformapi/startapp?".concat("appId=").concat(jVar.c()).concat("&ap_framework_sceneId=1300").concat("&chInfo=ch_outerUrl").concat("&thirdPartSchema=").concat(strB).concat(String.format("&page=%s?%s", jVar.b(), a("appPayRequest=".concat(com.gnete.upbc.cashier.g.a.b().b("miniuser", jVar.c()).b("msgType", jVar.d()).b("package", jVar.f()).b("minipath", jVar.b()).b("appScheme", strA).b("sign", jVar.i()).b("prepayid", jVar.g()).b("noncestr", jVar.e()).b(com.alipay.sdk.tid.b.f, jVar.j()).a().toString())))).concat("&query=").concat(a("ap_framework_sceneId=1300")))));
            interfaceC0387b.a();
        } catch (Exception e) {
            interfaceC0387b.a("跳转支付宝支付失败", e);
        }
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void b() {
        com.gnete.upbc.cashier.f.b bVar = new com.gnete.upbc.cashier.f.b();
        bVar.show(this.f3290a.getFragmentManager(), "ALIPAY_LOADING");
        com.gnete.upbc.cashier.a.g.a(this.b.a()).a(new C0385a(bVar));
    }

    @Override // com.gnete.upbc.cashier.e.b
    protected void e() {
        if (this.b.e().b().contains(com.gnete.upbc.cashier.b.f.ALIPAY)) {
            return;
        }
        com.gnete.upbc.cashier.g.b.a(this.f3290a, this.b, "订单不支持支付宝支付", (Throwable) null, this.c);
    }

    public a(Activity activity, com.gnete.upbc.cashier.b.b bVar, GnetePayListener gnetePayListener) {
        super(activity, bVar, gnetePayListener);
    }

    private String b(String str) {
        String strReplace;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split(";");
        int i = 0;
        if (strArrSplit.length <= 1 && !strArrSplit[0].contains(x.bQ)) {
            strReplace = strArrSplit[0];
        } else {
            int length = strArrSplit.length;
            while (true) {
                if (i >= length) {
                    strReplace = "";
                    break;
                }
                String str2 = strArrSplit[i];
                if (!TextUtils.isEmpty(str2) && str2.trim().startsWith("Android:")) {
                    strReplace = str2.replace("Android:", "");
                    break;
                }
                if (!TextUtils.isEmpty(str2) && str2.trim().startsWith("android:")) {
                    strReplace = str2.replace("android:", "");
                    break;
                }
                i++;
            }
        }
        return !strReplace.contains("://") ? strReplace.concat("://") : strReplace;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(new String(str.getBytes(), StandardCharsets.UTF_8), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            Log.e("a", e.getMessage(), e);
            return "";
        }
    }
}
