package com.baidu.oauth.sdkbqt.a;

import android.text.TextUtils;
import com.fancy.adsdk.lib.constants.BiddingConst;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f1861a = "bdoauth_init";
    public static final String b = "bdoauth_open";
    public static final String c = "bdoauth_suc";
    public static final String d = "bdoauth_err";
    private static final HashMap<String, String> e;

    private f() {
    }

    static {
        HashMap<String, String> map = new HashMap<>();
        e = map;
        map.put("pid", BiddingConst.ADN_ID.MM);
        map.put("type", "1023");
        map.put(com.alipay.sdk.packet.e.n, "android");
    }

    public static void a(String str) {
        a(str, null);
    }

    public static void a(String str, HashMap<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.baidu.oauth.sdkbqt.a.a.g gVar = new com.baidu.oauth.sdkbqt.a.a.g();
            gVar.a(e);
            gVar.a("name", str);
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        gVar.a(entry.getKey(), entry.getValue());
                    }
                }
            }
            new com.baidu.oauth.sdkbqt.a.a.a().a(c.c(), gVar, new g(true));
        } catch (Throwable th) {
            d.a(th);
        }
    }
}
