package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.components.d;
import com.kwad.sdk.components.h;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.response.helper.f;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.br;
import com.masget.base.AppConfig;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final int CODE_RESULT_OK = 1;
    private static final long serialVersionUID = -8657363515914699792L;
    public String cookie;
    public String errorMsg;
    public String extra;
    public boolean hasAd;
    public long llsid;
    public int result;
    public String testErrorMsg;

    public boolean hasData() {
        return this.hasAd;
    }

    public boolean isDataEmpty() {
        return false;
    }

    public boolean isResultOk() {
        return this.result == 1;
    }

    public boolean notifyFailOnResultError() {
        return true;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.llsid = jSONObject.optLong(KSUtil.REQUEST_ID);
        this.result = jSONObject.optInt("result");
        this.hasAd = jSONObject.optBoolean("hasAd");
        this.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        this.testErrorMsg = jSONObject.optString("testErrorMsg");
        String strOptString = jSONObject.optString("extra");
        if (!br.isNullString(strOptString)) {
            this.extra = ((e) d.f(e.class)).getResponseData(strOptString);
        }
        h hVar = (h) d.f(h.class);
        if (hVar != null) {
            hVar.av(jSONObject.optString("egid"));
            hVar.F(jSONObject.optLong("gidExpireTimeMs"));
        }
        String strOptString2 = jSONObject.optString(AppConfig.CONF_COOKIE);
        this.cookie = strOptString2;
        if (TextUtils.isEmpty(strOptString2)) {
            return;
        }
        f.Nz().fn(this.cookie);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        return baseToJson();
    }

    public JSONObject baseToJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, KSUtil.REQUEST_ID, this.llsid);
        ac.putValue(jSONObject, "extra", this.extra);
        ac.putValue(jSONObject, "result", this.result);
        ac.putValue(jSONObject, "hasAd", this.hasAd);
        ac.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, this.errorMsg);
        ac.putValue(jSONObject, "testErrorMsg", this.testErrorMsg);
        ac.putValue(jSONObject, AppConfig.CONF_COOKIE, this.cookie);
        return jSONObject;
    }
}
