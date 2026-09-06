package com.kwad.sdk.api.loader;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.analytics.pro.am;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
final class a {

    /* JADX INFO: renamed from: com.kwad.sdk.api.loader.a$a, reason: collision with other inner class name */
    static class C0726a {
        int aHC;
        String aHD;
        transient File aHE;
        long interval;
        String md5;
        String sdkVersion;

        public final boolean HA() {
            return this.aHC == 1;
        }

        public final boolean HB() {
            return this.aHC == -1;
        }

        C0726a() {
        }

        public final String toString() {
            return "Data{dynamicType=" + this.aHC + ", dynamicUrl='" + this.aHD + "', md5='" + this.md5 + "', interval=" + this.interval + ", sdkVersion='" + this.sdkVersion + "', downloadFile=" + this.aHE + '}';
        }

        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.aHC = jSONObject.optInt("dynamicType");
            this.aHD = jSONObject.optString("dynamicUrl");
            this.md5 = jSONObject.optString("md5");
            this.interval = jSONObject.optLong(am.aT);
            this.sdkVersion = jSONObject.optString("sdkVersion");
        }
    }

    static class b {
        C0726a aHF;
        String errorMsg;
        long result;

        final boolean isLegal() {
            return this.result == 1 && this.aHF != null;
        }

        b() {
        }

        public final void parseJson(JSONObject jSONObject) {
            this.result = jSONObject.optLong("result");
            this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
            C0726a c0726a = new C0726a();
            this.aHF = c0726a;
            c0726a.parseJson(jSONObject.optJSONObject("data"));
        }

        public final String toString() {
            return "UpdateData{result=" + this.result + ", errorMsg='" + this.errorMsg + "', data=" + this.aHF + '}';
        }
    }
}
