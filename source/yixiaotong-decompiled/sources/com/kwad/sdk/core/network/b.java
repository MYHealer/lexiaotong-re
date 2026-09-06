package com.kwad.sdk.core.network;

import android.text.TextUtils;
import com.huawei.hms.ads.ez;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bu;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class b implements f {
    private static final String COOKIE_KEY = "cookie";
    private final Map<String, String> mHeader = new HashMap();
    public final JSONObject mBodyParams = new JSONObject();

    protected abstract void buildBaseBody();

    protected abstract void buildBaseHeader();

    protected boolean enableCrashReport() {
        return true;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getBodyMap() {
        return null;
    }

    public JSONObject getBodyParams() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.f
    public Map<String, String> getHeader() {
        return this.mHeader;
    }

    @Override // com.kwad.sdk.core.network.f
    public SceneImpl getScene() {
        return null;
    }

    @Override // com.kwad.sdk.core.network.f
    public abstract String getUrl();

    protected void onCreate() {
    }

    protected b() {
        try {
            onCreate();
            buildBaseHeader();
            buildBaseBody();
            if (encryptDisable()) {
                addHeader("x-ksad-ignore-decrypt", ez.Code);
            }
            addHeader("cookie", com.kwad.sdk.core.response.helper.f.Nz().NA());
            com.kwad.sdk.core.a.d.h(getHeader());
            addHeader("User-Agent", p.getUserAgent());
            addHeader("BrowserUa", p.Mi());
            addHeader("SystemUa", p.Mh());
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
    }

    protected void reportSdkCaughtException(Throwable th) {
        if (enableCrashReport()) {
            ServiceProvider.reportSdkCaughtException(th);
        } else {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public static String mergeCookies(String... strArr) {
        String strTrim;
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : strArr) {
            if (str != null && !str.trim().isEmpty()) {
                for (String str2 : str.split(";")) {
                    String strTrim2 = str2.trim();
                    if (!strTrim2.isEmpty()) {
                        int iIndexOf = strTrim2.indexOf(61);
                        if (iIndexOf > 0) {
                            String strTrim3 = strTrim2.substring(0, iIndexOf).trim();
                            strTrim = strTrim2.substring(iIndexOf + 1).trim();
                            strTrim2 = strTrim3;
                        } else {
                            strTrim = "";
                        }
                        if (!strTrim2.isEmpty()) {
                            linkedHashMap.put(strTrim2, strTrim);
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (sb.length() > 0) {
                sb.append("; ");
            }
            sb.append((String) entry.getKey());
            if (!((String) entry.getValue()).isEmpty()) {
                sb.append("=").append((String) entry.getValue());
            }
        }
        return sb.toString();
    }

    public final void addHeader(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        String str3 = str.equalsIgnoreCase("cookie") ? "cookie" : str;
        if (str.equalsIgnoreCase("cookie") && this.mHeader.containsKey("cookie")) {
            this.mHeader.put("cookie", mergeCookies(this.mHeader.get("cookie"), str2));
        } else {
            this.mHeader.put(str3, str2);
        }
    }

    @Override // com.kwad.sdk.core.network.f
    public JSONObject getBody() {
        if (encryptDisable()) {
            return this.mBodyParams;
        }
        JSONObject jSONObject = new JSONObject();
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        ac.putValue(jSONObject, "version", fVar.getSDKVersion());
        if (!TextUtils.isEmpty(bu.getAppId())) {
            ac.putValue(jSONObject, "appId", bu.getAppId());
        } else {
            ac.putValue(jSONObject, "appId", fVar.getAppId());
        }
        ac.putValue(jSONObject, CrashHianalyticsData.MESSAGE, com.kwad.sdk.core.a.d.ax(getBodyParamsString()));
        com.kwad.sdk.core.a.d.a(getUrl(), getHeader(), jSONObject.toString());
        return jSONObject;
    }

    protected String getBodyParamsString() {
        return this.mBodyParams.toString();
    }

    public boolean encryptDisable() {
        return com.kwad.sdk.components.g.encryptDisable();
    }

    protected String getRequestHost() {
        return com.kwad.sdk.i.EI();
    }

    public void putBody(String str, String str2) {
        ac.putValue(this.mBodyParams, str, str2);
    }

    public void putBody(String str, double d) {
        ac.putValue(this.mBodyParams, str, d);
    }

    public void putBody(String str, int i) {
        ac.putValue(this.mBodyParams, str, i);
    }

    public void putBody(String str, float f) {
        ac.putValue(this.mBodyParams, str, f);
    }

    public void putBody(String str, byte b) {
        ac.putValue(this.mBodyParams, str, b);
    }

    public void putBody(String str, long j) {
        ac.putValue(this.mBodyParams, str, j);
    }

    public void putBody(String str, boolean z) {
        ac.putValue(this.mBodyParams, str, z);
    }

    public void putBody(String str, JSONObject jSONObject) {
        ac.putValue(this.mBodyParams, str, jSONObject);
    }

    public void putBody(String str, JSONArray jSONArray) {
        ac.putValue(this.mBodyParams, str, jSONArray);
    }

    public void putBody(String str, com.kwad.sdk.core.b bVar) {
        ac.a(this.mBodyParams, str, bVar);
    }

    public void putBody(String str, List<? extends com.kwad.sdk.core.b> list) {
        ac.putValue(this.mBodyParams, str, list);
    }
}
