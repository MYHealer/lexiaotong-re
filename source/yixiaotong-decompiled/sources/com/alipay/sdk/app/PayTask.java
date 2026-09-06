package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alipay.sdk.util.H5PayResultModel;
import com.alipay.sdk.util.l;
import com.alipay.sdk.util.n;
import com.cdo.oaps.ad.OapsKey;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.huawei.openalliance.ad.constant.ba;
import com.masget.base.AppConfig;
import com.stub.StubApp;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PayTask {
    private static final long i = 3000;
    private Activity b;
    private com.alipay.sdk.widget.a c;
    private String d = "wappaygw.alipay.com/service/rest.htm";
    private String e = "mclient.alipay.com/service/rest.htm";
    private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
    private Map<String, a> g = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Object f1613a = com.alipay.sdk.util.e.class;
    private static long h = 0;
    private static long j = -1;

    public String getVersion() {
        return "15.6.8";
    }

    public PayTask(Activity activity) {
        this.b = activity;
        com.alipay.sdk.sys.b.a().a(this.b, com.alipay.sdk.data.c.b());
        com.alipay.sdk.app.statistic.a.a(activity);
        this.c = new com.alipay.sdk.widget.a(activity, com.alipay.sdk.widget.a.b);
    }

    public synchronized String pay(String str, boolean z) {
        String strA;
        if (b()) {
            return j.d();
        }
        if (z) {
            showLoading();
        }
        if (str.contains("payment_inst=")) {
            String strSubstring = str.substring(str.indexOf("payment_inst=") + 13);
            int iIndexOf = strSubstring.indexOf(38);
            if (iIndexOf > 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            i.a(strSubstring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            i.a("");
        }
        if (str.contains(com.alipay.sdk.cons.a.r)) {
            com.alipay.sdk.cons.a.s = true;
        }
        if (com.alipay.sdk.cons.a.s) {
            if (str.startsWith(com.alipay.sdk.cons.a.t)) {
                str = str.substring(str.indexOf(com.alipay.sdk.cons.a.t) + 53);
            } else if (str.startsWith(com.alipay.sdk.cons.a.u)) {
                str = str.substring(str.indexOf(com.alipay.sdk.cons.a.u) + 52);
            }
        }
        try {
            strA = a(str);
            com.alipay.sdk.util.i.a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()), strA);
            com.alipay.sdk.data.a.g().a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()));
            dismissLoading();
            com.alipay.sdk.app.statistic.a.b(StubApp.getOrigApplicationContext(this.b.getApplicationContext()), str);
        } catch (Throwable th) {
            try {
                String strC = j.c();
                com.alipay.sdk.util.c.a(th);
                com.alipay.sdk.data.a.g().a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()));
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(StubApp.getOrigApplicationContext(this.b.getApplicationContext()), str);
                strA = strC;
            } catch (Throwable th2) {
                com.alipay.sdk.data.a.g().a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()));
                dismissLoading();
                com.alipay.sdk.app.statistic.a.b(StubApp.getOrigApplicationContext(this.b.getApplicationContext()), str);
                throw th2;
            }
        }
        return strA;
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        return l.a(pay(str, z));
    }

    public synchronized String fetchTradeToken() {
        return com.alipay.sdk.util.i.a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()));
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String strFetchOrderInfoFromH5PayUrl;
        strFetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl)) {
            new Thread(new g(this, strFetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl);
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strTrim = str.trim();
                if (strTrim.startsWith("https://" + this.d) || strTrim.startsWith("http://" + this.d)) {
                    String strTrim2 = strTrim.replaceFirst("(http|https)://" + this.d + "\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.sys.a(this.b).a("sc", "h5tonative") + "\"";
                    }
                }
                if (strTrim.startsWith("https://" + this.e) || strTrim.startsWith("http://" + this.e)) {
                    String strTrim3 = strTrim.replaceFirst("(http|https)://" + this.e + "\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + n.a("<request_token>", "</request_token>", n.b(strTrim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + new com.alipay.sdk.sys.a(this.b).a("sc", "h5tonative") + "\"";
                    }
                }
                if ((strTrim.startsWith("https://" + this.f) || strTrim.startsWith("http://" + this.f)) && ((strTrim.contains("alipay.wap.create.direct.pay.by.user") || strTrim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(strTrim.replaceFirst("(http|https)://" + this.f + "\\?", "").trim()))) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str);
                        jSONObject.put("bizcontext", new com.alipay.sdk.sys.a(this.b).a("sc", "h5tonative"));
                        return "new_external_info==" + jSONObject.toString();
                    } catch (Throwable th) {
                        com.alipay.sdk.util.c.a(th);
                    }
                }
                g gVar = null;
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String strA = n.a("?", "", str);
                    if (!TextUtils.isEmpty(strA)) {
                        Map<String, String> mapB = n.b(strA);
                        StringBuilder sb = new StringBuilder();
                        if (a(false, true, com.alipay.sdk.app.statistic.c.ad, sb, mapB, com.alipay.sdk.app.statistic.c.ad, "alipay_trade_no")) {
                            a(true, false, "pay_phase_id", sb, mapB, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = mapB.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(mapB.get(ba.D))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(mapB.get(OapsKey.KEY_SUB_ID)) || !TextUtils.isEmpty(mapB.get("s_id")))) {
                                str2 = TtmlNode.VERTICAL;
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!a(true, true, "extern_token", sb, mapB, "extern_token", ba.D, OapsKey.KEY_SUB_ID, "s_id")) {
                                return "";
                            }
                            a(true, false, "appenv", sb, mapB, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            a aVar = new a(this, gVar);
                            aVar.a(mapB.get("return_url"));
                            aVar.c(mapB.get("show_url"));
                            aVar.b(mapB.get("pay_order_id"));
                            String str3 = sb.toString() + "&bizcontext=\"" + new com.alipay.sdk.sys.a(this.b).a("sc", "h5tonative") + "\"";
                            this.g.put(str3, aVar);
                            return str3;
                        }
                    }
                }
                if (!strTrim.contains("mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !strTrim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if (com.alipay.sdk.data.a.g().c() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(strTrim).find()) {
                        Uri uri = Uri.parse(strTrim);
                        String queryParameter = uri.getQueryParameter("return_url");
                        String queryParameter2 = uri.getQueryParameter("show_url");
                        String queryParameter3 = uri.getQueryParameter("pay_order_id");
                        String strA2 = a(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                        String strA3 = a(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = uri.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(uri.getQueryParameter(ba.D)) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(uri.getQueryParameter(OapsKey.KEY_SUB_ID)) ? TtmlNode.VERTICAL : "";
                        strArr[3] = !TextUtils.isEmpty(uri.getQueryParameter("s_id")) ? TtmlNode.VERTICAL : "";
                        String strA4 = a(strArr);
                        String strA5 = a(uri.getQueryParameter("extern_token"), uri.getQueryParameter(ba.D), uri.getQueryParameter(OapsKey.KEY_SUB_ID), uri.getQueryParameter("s_id"));
                        String strA6 = a(uri.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(strA2) && !TextUtils.isEmpty(strA4) && !TextUtils.isEmpty(strA5)) {
                            String str4 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strA2, strA3, strA4, strA5, strA6, new com.alipay.sdk.sys.a(this.b).a("sc", "h5tonative"));
                            a aVar2 = new a(this, null);
                            aVar2.a(queryParameter);
                            aVar2.c(queryParameter2);
                            aVar2.b(queryParameter3);
                            aVar2.d(strA2);
                            this.g.put(str4, aVar2);
                            return str4;
                        }
                    }
                }
                String strA7 = new com.alipay.sdk.sys.a(this.b).a("sc", "h5tonative");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("url", strTrim);
                jSONObject2.put("bizcontext", strA7);
                return String.format("new_external_info==%s", jSONObject2.toString());
            }
        } catch (Throwable th2) {
            com.alipay.sdk.util.c.a(th2);
        }
        return "";
    }

    private static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        try {
            com.alipay.sdk.sys.b.a().a(context, com.alipay.sdk.data.c.b());
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - h < com.alipay.sdk.data.a.g().e()) {
                return false;
            }
            h = jElapsedRealtime;
            com.alipay.sdk.data.a.g().a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            return true;
        } catch (Exception e) {
            com.alipay.sdk.util.c.a(e);
            return false;
        }
        throw th;
    }

    private class a {
        private String b;
        private String c;
        private String d;
        private String e;

        public String a() {
            return this.b;
        }

        public void a(String str) {
            this.b = str;
        }

        public String b() {
            return this.d;
        }

        public void b(String str) {
            this.d = str;
        }

        public String c() {
            return this.c;
        }

        public void c(String str) {
            this.c = str;
        }

        public String d() {
            return this.e;
        }

        public void d(String str) {
            this.e = str;
        }

        private a() {
            this.b = "";
            this.c = "";
            this.d = "";
            this.e = "";
        }

        /* synthetic */ a(PayTask payTask, g gVar) {
            this();
        }
    }

    private boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i2];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i2++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        }
        if (z) {
            sb.append("&").append(str).append("=\"").append(str2).append("\"");
            return true;
        }
        sb.append(str).append("=\"").append(str2).append("\"");
        return true;
    }

    public synchronized H5PayResultModel h5Pay(String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] strArrSplit = pay(str, z).split(";");
            HashMap map = new HashMap();
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("={");
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    map.put(strSubstring, a(str2, strSubstring));
                }
            }
            if (map.containsKey(l.f1664a)) {
                h5PayResultModel.setResultCode(map.get(l.f1664a));
            }
            h5PayResultModel.setReturnUrl(a(str, map));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.T, "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.U, th);
            com.alipay.sdk.util.c.a(th);
        }
        return h5PayResultModel;
    }

    private String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean zEquals = "9000".equals(map.get(l.f1664a));
        String str2 = map.get("result");
        a aVarRemove = this.g.remove(str);
        String[] strArr = new String[2];
        strArr[0] = aVarRemove != null ? aVarRemove.b() : "";
        strArr[1] = aVarRemove != null ? aVarRemove.d() : "";
        a(strArr);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String strA = a(n.a("&callBackUrl=\"", "\"", str2), n.a("&call_back_url=\"", "\"", str2), n.a(com.alipay.sdk.cons.a.p, "\"", str2), URLDecoder.decode(n.a(com.alipay.sdk.cons.a.q, "&", str2), "utf-8"), URLDecoder.decode(n.a("&callBackUrl=", "&", str2), "utf-8"), n.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (aVarRemove != null) {
            String strA2 = zEquals ? aVarRemove.a() : aVarRemove.c();
            if (!TextUtils.isEmpty(strA2)) {
                return strA2;
            }
        }
        return aVarRemove != null ? com.alipay.sdk.data.a.g().d() : "";
    }

    private String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(com.alipay.sdk.util.i.d));
    }

    private com.alipay.sdk.util.e.a a() {
        return new h(this);
    }

    public void showLoading() {
        com.alipay.sdk.widget.a aVar = this.c;
        if (aVar != null) {
            aVar.b();
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.widget.a aVar = this.c;
        if (aVar != null) {
            aVar.c();
            this.c = null;
        }
    }

    private String a(String str) {
        String strA = new com.alipay.sdk.sys.a(this.b).a(str);
        if (strA.contains("paymethod=\"expressGateway\"")) {
            return b(strA);
        }
        List<com.alipay.sdk.data.a.C0082a> listF = com.alipay.sdk.data.a.g().f();
        if (!com.alipay.sdk.data.a.g().q || listF == null) {
            listF = i.f1624a;
        }
        if (n.b(this.b, listF)) {
            com.alipay.sdk.util.e eVar = new com.alipay.sdk.util.e(this.b, a());
            String strA2 = eVar.a(strA);
            eVar.a();
            if (TextUtils.equals(strA2, com.alipay.sdk.util.e.f1657a) || TextUtils.equals(strA2, com.alipay.sdk.util.e.b)) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.O, "");
                return b(strA);
            }
            if (TextUtils.isEmpty(strA2)) {
                return j.c();
            }
            if (!strA2.contains(PayResultActivity.f1611a)) {
                return strA2;
            }
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.Q, "");
            return a(strA, listF, strA2, this.b);
        }
        com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.P, "");
        return b(strA);
    }

    private static String a(String str, List<com.alipay.sdk.data.a.C0082a> list, String str2, Activity activity) {
        n.a aVarA = n.a(activity, list);
        if (aVarA == null || aVarA.a() || aVarA.b() || !TextUtils.equals(aVarA.f1667a.packageName, PayResultActivity.c)) {
            return str2;
        }
        com.alipay.sdk.util.c.b("msp", "PayTask:payResult: NOT_LOGIN");
        String strValueOf = String.valueOf(str.hashCode());
        PayResultActivity.b.put(strValueOf, new Object());
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra(PayResultActivity.e, str);
        intent.putExtra(PayResultActivity.f, activity.getPackageName());
        intent.putExtra(PayResultActivity.d, strValueOf);
        activity.startActivity(intent);
        synchronized (PayResultActivity.b.get(strValueOf)) {
            try {
                com.alipay.sdk.util.c.b("msp", "PayTask:payResult: wait");
                PayResultActivity.b.get(strValueOf).wait();
            } catch (InterruptedException e) {
                com.alipay.sdk.util.c.b("msp", "PayTask:payResult: InterruptedException:" + e);
                return j.c();
            }
        }
        String str3 = PayResultActivity.a.b;
        com.alipay.sdk.util.c.b("msp", "PayTask:payResult: result:" + str3);
        return str3;
    }

    private String b(String str) {
        showLoading();
        k kVarB = null;
        try {
            try {
                try {
                    JSONObject jSONObjectC = new com.alipay.sdk.packet.impl.e().a(StubApp.getOrigApplicationContext(this.b.getApplicationContext()), str).c();
                    String strOptString = jSONObjectC.optString("end_code", null);
                    List<com.alipay.sdk.protocol.b> listA = com.alipay.sdk.protocol.b.a(jSONObjectC.optJSONObject(com.alipay.sdk.cons.c.c).optJSONObject(com.alipay.sdk.cons.c.d));
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        if (listA.get(i2).b() == com.alipay.sdk.protocol.a.Update) {
                            com.alipay.sdk.protocol.b.a(listA.get(i2));
                        }
                    }
                    a(jSONObjectC);
                    dismissLoading();
                    for (int i3 = 0; i3 < listA.size(); i3++) {
                        com.alipay.sdk.protocol.b bVar = listA.get(i3);
                        if (bVar.b() == com.alipay.sdk.protocol.a.WapPay) {
                            String strA = a(bVar);
                            dismissLoading();
                            return strA;
                        }
                        if (bVar.b() == com.alipay.sdk.protocol.a.OpenWeb) {
                            String strA2 = a(bVar, strOptString);
                            dismissLoading();
                            return strA2;
                        }
                    }
                } catch (IOException e) {
                    kVarB = k.b(k.NETWORK_ERROR.a());
                    com.alipay.sdk.app.statistic.a.a("net", e);
                }
            } catch (Throwable th) {
                com.alipay.sdk.util.c.a(th);
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, th);
            }
            dismissLoading();
            if (kVarB == null) {
                kVarB = k.b(k.FAILED.a());
            }
            return j.a(kVarB.a(), kVarB.b(), "");
        } catch (Throwable th2) {
            dismissLoading();
            throw th2;
        }
    }

    private void a(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("tid");
            String strOptString2 = jSONObject.optString(com.alipay.sdk.tid.b.e);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            com.alipay.sdk.tid.b.a(com.alipay.sdk.sys.b.a().b()).a(strOptString, strOptString2);
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.H, th);
        }
    }

    private String a(com.alipay.sdk.protocol.b bVar, String str) {
        boolean zB;
        String strA;
        String[] strArrC = bVar.c();
        Intent intent = new Intent(this.b, (Class<?>) H5PayActivity.class);
        try {
            JSONObject jSONObjectD = n.d(new String(com.alipay.sdk.encrypt.a.a(strArrC[2])));
            intent.putExtra("url", strArrC[0]);
            intent.putExtra("title", strArrC[1]);
            intent.putExtra("version", "v2");
            intent.putExtra("method", jSONObjectD.optString("method", "POST"));
            j.a(false);
            j.a((String) null);
            this.b.startActivity(intent);
            Object obj = f1613a;
            synchronized (obj) {
                try {
                    obj.wait();
                    zB = j.b();
                    strA = j.a();
                    j.a(false);
                    j.a((String) null);
                } catch (InterruptedException e) {
                    com.alipay.sdk.util.c.a(e);
                    return j.c();
                }
            }
            String strA2 = "";
            if (zB) {
                try {
                    List<com.alipay.sdk.protocol.b> listA = com.alipay.sdk.protocol.b.a(n.d(new String(com.alipay.sdk.encrypt.a.a(strA))));
                    for (int i2 = 0; i2 < listA.size(); i2++) {
                        com.alipay.sdk.protocol.b bVar2 = listA.get(i2);
                        if (bVar2.b() == com.alipay.sdk.protocol.a.SetResult) {
                            String[] strArrC2 = bVar2.c();
                            strA2 = j.a(Integer.valueOf(strArrC2[1]).intValue(), strArrC2[0], n.e(strArrC2[2]));
                            break;
                        }
                    }
                } catch (Throwable th) {
                    com.alipay.sdk.util.c.a(th);
                    com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, th, strA);
                }
            }
            if (!TextUtils.isEmpty(strA2)) {
                return strA2;
            }
            try {
                return j.a(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th2) {
                com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, th2, "endCode: " + str);
                return j.a(8000, "", "");
            }
        } catch (Throwable th3) {
            com.alipay.sdk.util.c.a(th3);
            com.alipay.sdk.app.statistic.a.a(com.alipay.sdk.app.statistic.c.b, com.alipay.sdk.app.statistic.c.u, th3, Arrays.toString(strArrC));
            return j.c();
        }
    }

    private String a(com.alipay.sdk.protocol.b bVar) {
        String[] strArrC = bVar.c();
        Intent intent = new Intent(this.b, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrC[0]);
        if (strArrC.length == 2) {
            bundle.putString(AppConfig.CONF_COOKIE, strArrC[1]);
        }
        intent.putExtras(bundle);
        this.b.startActivity(intent);
        Object obj = f1613a;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e) {
                com.alipay.sdk.util.c.a(e);
                return j.c();
            }
        }
        String strA = j.a();
        return TextUtils.isEmpty(strA) ? j.c() : strA;
    }

    private static boolean b() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - j < 3000) {
            return true;
        }
        j = jElapsedRealtime;
        return false;
    }
}
