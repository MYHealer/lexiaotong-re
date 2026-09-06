package com.kwad.sdk.crash.report;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.kwad.sdk.utils.ac;
import com.ubixnow.ooooo.oOOOoo00;
import cz.msebera.android.httpclient.protocol.HTTP;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ReportEvent implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 8652448382850235426L;
    public long clientIncrementId;
    public long clientTimeStamp;
    public String sessionId;
    public StatPackage statPackage;
    public String timeZone;

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.clientTimeStamp = jSONObject.optLong("clientTimeStamp");
        this.clientIncrementId = jSONObject.optLong("clientIncrementId");
        this.sessionId = jSONObject.optString("sessionId");
        this.statPackage.parseJson(jSONObject.optJSONObject("statPackage"));
        this.timeZone = jSONObject.optString("timeZone");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "clientTimeStamp", this.clientTimeStamp);
        ac.putValue(jSONObject, "clientIncrementId", this.clientIncrementId);
        ac.putValue(jSONObject, "sessionId", this.sessionId);
        ac.a(jSONObject, "statPackage", this.statPackage);
        ac.putValue(jSONObject, "timeZone", this.timeZone);
        return jSONObject;
    }

    public static class StatPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -6225392281821567840L;
        public CustomStatEvent customStatEvent;
        public ExceptionEvent exceptionEvent;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.exceptionEvent.parseJson(jSONObject.optJSONObject("exceptionEvent"));
            this.customStatEvent.parseJson(jSONObject.optJSONObject("customStatEvent"));
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.a(jSONObject, "exceptionEvent", this.exceptionEvent);
            ac.a(jSONObject, "customStatEvent", this.customStatEvent);
            return jSONObject;
        }
    }

    public static class ExceptionEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436344L;
        public String flag;
        public String message;
        public int type;
        public UrlPackage urlPackage;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.message = jSONObject.optString(CrashHianalyticsData.MESSAGE);
            this.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
            this.flag = jSONObject.optString("flag");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "type", this.type);
            ac.putValue(jSONObject, CrashHianalyticsData.MESSAGE, this.message);
            ac.a(jSONObject, "urlPackage", this.urlPackage);
            ac.putValue(jSONObject, "flag", this.flag);
            return jSONObject;
        }
    }

    public static class CustomStatEvent implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 5177557263564436342L;
        public String key;
        public String value;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.key = jSONObject.optString("key");
            this.value = jSONObject.optString(oOOOoo00.OooOo0o);
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "key", this.key);
            ac.putValue(jSONObject, oOOOoo00.OooOo0o, this.value);
            return jSONObject;
        }
    }

    public static class UrlPackage implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = 2535768638193007414L;
        public String identity;
        public String page;
        public int pageType;
        public String params;

        @Override // com.kwad.sdk.core.b
        public void parseJson(JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.page = jSONObject.optString("page");
            this.params = jSONObject.optString("params");
            this.identity = jSONObject.optString(HTTP.IDENTITY_CODING);
            this.pageType = jSONObject.optInt("pageType");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            ac.putValue(jSONObject, "page", this.page);
            ac.putValue(jSONObject, "params", this.params);
            ac.putValue(jSONObject, HTTP.IDENTITY_CODING, this.identity);
            ac.putValue(jSONObject, "pageType", this.pageType);
            return jSONObject;
        }
    }
}
