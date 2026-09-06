package com.alipay.sdk.packet.impl;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class d extends com.alipay.sdk.packet.e {
    public static final String t = "log_v";

    @Override // com.alipay.sdk.packet.e
    protected String a(String str, JSONObject jSONObject) {
        return str;
    }

    @Override // com.alipay.sdk.packet.e
    protected JSONObject a() throws JSONException {
        return null;
    }

    @Override // com.alipay.sdk.packet.e
    protected Map<String, String> a(boolean z, String str) {
        HashMap map = new HashMap();
        map.put(com.alipay.sdk.packet.e.f1647a, String.valueOf(z));
        map.put(com.alipay.sdk.packet.e.d, "application/octet-stream");
        map.put(com.alipay.sdk.packet.e.g, "CBC");
        return map;
    }

    @Override // com.alipay.sdk.packet.e
    protected String c() throws JSONException {
        HashMap<String, String> map = new HashMap<>();
        map.put("api_name", "/sdk/log");
        map.put(com.alipay.sdk.packet.e.j, "1.0.0");
        HashMap<String, String> map2 = new HashMap<>();
        map2.put(t, "1.0");
        return a(map, map2);
    }

    @Override // com.alipay.sdk.packet.e
    public com.alipay.sdk.packet.b a(Context context, String str) throws Throwable {
        return a(context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }
}
