package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.hihonor.updater.installsdk.api.TraceUrlData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class jj {
    private static final String Code = "EventRecordUitl";
    private Context V;

    public jj(Context context) {
        this.V = context;
    }

    public void Code(Bundle bundle, AdContentData adContentData) {
        String str;
        if (bundle == null || adContentData == null) {
            str = "param or ad is null";
        } else {
            el elVar = new el(bundle);
            String strW = elVar.w(TraceUrlData.JsonKeyOld.KEY_EVENT_TYPE);
            if (TextUtils.isEmpty(strW)) {
                str = "eventType is null";
            } else {
                String strW2 = elVar.w(com.huawei.openalliance.ad.constant.br.f.U);
                boolean zCode = elVar.Code(com.huawei.openalliance.ad.constant.br.f.W, false);
                boolean zCode2 = elVar.Code(com.huawei.openalliance.ad.constant.br.f.Y, false);
                if (!TextUtils.isEmpty(strW2)) {
                    try {
                        JSONObject jSONObject = new JSONObject(strW2);
                        jSONObject.put(com.huawei.openalliance.ad.constant.br.f.R, strW);
                        jSONObject.put("contentId", adContentData.a());
                        jSONObject.put("slotId", adContentData.L());
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(com.huawei.openalliance.ad.constant.br.f.U, jSONObject.toString());
                        jSONObject2.put(com.huawei.openalliance.ad.constant.br.f.X, zCode);
                        jSONObject2.put(com.huawei.openalliance.ad.constant.br.f.aa, zCode2);
                        if (adContentData.aF() == 3) {
                            jSONObject2.put("templateId", adContentData.aE());
                        } else {
                            jSONObject2.put("templateId", adContentData.E());
                        }
                        jSONObject2.put("apiVer", adContentData.aF());
                        jSONObject2.put("show_id", adContentData.D());
                        jSONObject2.put("unique_id", adContentData.aa());
                        fh.V(Code, "start report event, eventType: %s, uniqueId: %s", strW, adContentData.aa());
                        jk.Code(this.V, jSONObject2.toString());
                        return;
                    } catch (JSONException unused) {
                        fh.V(Code, "reportEvent json error, type: %s", strW);
                        return;
                    }
                }
                str = "paramStr is null";
            }
        }
        fh.V(Code, str);
    }
}
