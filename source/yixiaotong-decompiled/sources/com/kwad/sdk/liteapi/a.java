package com.kwad.sdk.liteapi;

import android.content.Context;
import com.yxcorp.kuaishou.addfp.KWEGIDDFP;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a {
    public static String doSign(Context context, String str) {
        return KWEGIDDFP.doSign(context, str);
    }

    public static void handlePolicy(JSONObject jSONObject) {
        KWEGIDDFP.handlePolicy(jSONObject);
    }
}
