package com.kwad.components.core.innerEc;

import android.text.TextUtils;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.ba;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.br;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class InnerEcLoginBindResultDate extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 3673908042518000752L;
    private InnerEcUserLoginBindInfo data;

    public InnerEcUserLoginBindInfo getData() {
        return this.data;
    }

    @Override // com.kwad.sdk.core.response.model.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            String strOptString = jSONObject.optString("data");
            com.kwad.sdk.core.a.e eVar = (com.kwad.sdk.core.a.e) com.kwad.sdk.components.d.f(com.kwad.sdk.core.a.e.class);
            if (br.isNullString(strOptString) || eVar == null) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(eVar.getResponseData(strOptString));
            InnerEcUserLoginBindInfo innerEcUserLoginBindInfo = new InnerEcUserLoginBindInfo();
            this.data = innerEcUserLoginBindInfo;
            innerEcUserLoginBindInfo.userId = jSONObject2.optLong(ba.r);
            this.data.userName = jSONObject2.optString("userName");
            this.data.serviceToken = jSONObject2.optString("serviceToken");
            this.data.expire = jSONObject2.optLong("expire");
            this.data.sid = jSONObject2.optString(OapsKey.KEY_SUB_ID);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.d("json bug", e.toString());
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    public boolean isParseSuccess() {
        InnerEcUserLoginBindInfo innerEcUserLoginBindInfo = this.data;
        if (innerEcUserLoginBindInfo == null || TextUtils.isEmpty(innerEcUserLoginBindInfo.serviceToken) || TextUtils.isEmpty(this.data.sid) || this.data.userId <= 0) {
            return false;
        }
        return this.data.expire > System.currentTimeMillis();
    }
}
