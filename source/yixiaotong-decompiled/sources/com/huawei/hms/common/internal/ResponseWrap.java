package com.huawei.hms.common.internal;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.hihonor.adsdk.base.download.marketdownload.a;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.ubixnow.ooooo.o0OO000o;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ResponseWrap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f3982a;
    private ResponseHeader b;

    public ResponseWrap(ResponseHeader responseHeader) {
        this.b = responseHeader;
    }

    public boolean fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b.setStatusCode(JsonUtil.getIntValue(jSONObject, o0OO000o.o000o0oo));
            this.b.setErrorCode(JsonUtil.getIntValue(jSONObject, "error_code"));
            this.b.setErrorReason(JsonUtil.getStringValue(jSONObject, "error_reason"));
            this.b.setSrvName(JsonUtil.getStringValue(jSONObject, "srv_name"));
            this.b.setApiName(JsonUtil.getStringValue(jSONObject, "api_name"));
            this.b.setAppID(JsonUtil.getStringValue(jSONObject, "app_id"));
            this.b.setPkgName(JsonUtil.getStringValue(jSONObject, a.hnadse));
            this.b.setSessionId(JsonUtil.getStringValue(jSONObject, "session_id"));
            this.b.setTransactionId(JsonUtil.getStringValue(jSONObject, CommonCode.MapKey.TRANSACTION_ID));
            this.b.setResolution(JsonUtil.getStringValue(jSONObject, "resolution"));
            this.f3982a = JsonUtil.getStringValue(jSONObject, TtmlNode.TAG_BODY);
            return true;
        } catch (JSONException e) {
            HMSLog.e("ResponseWrap", "fromJson failed: " + e.getMessage());
            return false;
        }
    }

    public String getBody() {
        if (TextUtils.isEmpty(this.f3982a)) {
            this.f3982a = new JSONObject().toString();
        }
        return this.f3982a;
    }

    public ResponseHeader getResponseHeader() {
        return this.b;
    }

    public void setBody(String str) {
        this.f3982a = str;
    }

    public void setResponseHeader(ResponseHeader responseHeader) {
        this.b = responseHeader;
    }

    public String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(o0OO000o.o000o0oo, this.b.getStatusCode());
            jSONObject.put("error_code", this.b.getErrorCode());
            jSONObject.put("error_reason", this.b.getErrorReason());
            jSONObject.put("srv_name", this.b.getSrvName());
            jSONObject.put("api_name", this.b.getApiName());
            jSONObject.put("app_id", this.b.getAppID());
            jSONObject.put(a.hnadse, this.b.getPkgName());
            jSONObject.put(CommonCode.MapKey.TRANSACTION_ID, this.b.getTransactionId());
            jSONObject.put("resolution", this.b.getResolution());
            String sessionId = this.b.getSessionId();
            if (!TextUtils.isEmpty(sessionId)) {
                jSONObject.put("session_id", sessionId);
            }
            if (!TextUtils.isEmpty(this.f3982a)) {
                jSONObject.put(TtmlNode.TAG_BODY, this.f3982a);
            }
        } catch (JSONException e) {
            HMSLog.e("ResponseWrap", "toJson failed: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "ResponseWrap{body='" + this.f3982a + "', responseHeader=" + this.b + '}';
    }
}
