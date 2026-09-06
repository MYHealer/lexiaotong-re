package com.opos.mobad.video.player.c.a.a.a;

import android.text.TextUtils;
import com.icbc.paysdk.webview.ICBCWebChromeClient;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f8346a;
    public JSONObject b;
    public String c;
    public String d;
    public String e;

    public a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f8346a = jSONObject.optString(ICBCWebChromeClient.JAVASCRIPT_COMMON_VALUE_FUNCTION);
            this.c = jSONObject.optString("JSSDK");
            this.d = jSONObject.optString("__msg_type");
            this.e = jSONObject.optString("__callback_id");
            this.b = jSONObject.optJSONObject("params");
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("TTJavaScriptMessage", "JavaScriptMessage error", th);
        }
    }

    public String toString() {
        return "TTJavaScriptMessage{mFunc='" + this.f8346a + "', mParam=" + this.b + ", mJsSdk='" + this.c + "', mMsgType='" + this.d + "', mCallbackId='" + this.e + "'}";
    }
}
