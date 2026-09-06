package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class df {
    private static final String Code = "EngineAnalysisUtil";
    private Context V;

    public df(Context context) {
        this.V = context;
    }

    public void Code(Bundle bundle, AdContentData adContentData) {
        String str;
        if (bundle == null || adContentData == null) {
            str = "param or ad is null";
        } else {
            el elVar = new el(bundle);
            String strW = elVar.w(com.huawei.openalliance.ad.constant.br.f.K);
            if (TextUtils.isEmpty(strW)) {
                str = "analysisType is null";
            } else {
                String strW2 = elVar.w(com.huawei.openalliance.ad.constant.br.f.T);
                boolean zCode = elVar.Code(com.huawei.openalliance.ad.constant.br.f.W, false);
                boolean zCode2 = elVar.Code(com.huawei.openalliance.ad.constant.br.f.Y, false);
                if (!TextUtils.isEmpty(strW2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strW2);
                        jSONObject.put(com.huawei.openalliance.ad.constant.br.f.K, strW);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(com.huawei.openalliance.ad.constant.br.f.T, jSONObject.toString());
                        jSONObject2.put(com.huawei.openalliance.ad.constant.br.f.X, zCode);
                        jSONObject2.put(com.huawei.openalliance.ad.constant.br.f.aa, zCode2);
                        jSONObject2.put("content_id", adContentData.a());
                        jSONObject2.put("slotid", adContentData.L());
                        if (adContentData.aF() == 3) {
                            jSONObject2.put("templateId", adContentData.aE());
                        } else {
                            jSONObject2.put("templateId", adContentData.E());
                        }
                        jSONObject2.put("apiVer", adContentData.aF());
                        jSONObject2.put("unique_id", adContentData.aa());
                        fh.V(Code, "start report analysis, analysisType: %s, uniqueId: %s", strW, adContentData.aa());
                        dd.Code(this.V, jSONObject2.toString());
                        return;
                    } catch (JSONException unused) {
                        fh.V(Code, "onAnalysis json error, type: %s", strW);
                        return;
                    }
                }
                str = "analysisInfo is empty";
            }
        }
        fh.V(Code, str);
    }
}
