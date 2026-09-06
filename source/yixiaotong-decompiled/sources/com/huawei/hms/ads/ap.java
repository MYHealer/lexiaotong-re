package com.huawei.hms.ads;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.uiengine.IPPSUiEngineCallback;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
class ap extends ah {
    private static final String Z = "JsbQueryDsl";

    public ap() {
        super(ak.N);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (com.huawei.openalliance.ad.utils.bc.Code(str)) {
            Code(remoteCallResultCallback, this.Code, 1001, null, true);
            return;
        }
        fh.V(Z, "query dsl");
        try {
            com.huawei.openalliance.ad.utils.c.Code(str, new IPPSUiEngineCallback.b() { // from class: com.huawei.hms.ads.ap.1
                @Override // com.huawei.hms.ads.uiengine.IPPSUiEngineCallback
                public void onCallResult(String str2, Bundle bundle) {
                    if (bundle == null) {
                        ah.Code(remoteCallResultCallback, ap.this.Code, 1000, null, false);
                        return;
                    }
                    try {
                        el elVar = new el(bundle);
                        String strW = elVar.w("templateId");
                        String strW2 = elVar.w("styleId");
                        String strW3 = elVar.w(com.huawei.openalliance.ad.constant.db.S);
                        fh.V(ap.Z, "query h5 dsl, tmpId: %s, styleId: %s", strW, strW2);
                        if (!com.huawei.openalliance.ad.utils.bc.Code(strW) && !com.huawei.openalliance.ad.utils.bc.Code(strW2) && !com.huawei.openalliance.ad.utils.bc.Code(strW3)) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("templateId", strW);
                            jSONObject.put("styleId", strW2);
                            jSONObject.put(com.huawei.openalliance.ad.constant.db.S, strW3);
                            ah.Code(remoteCallResultCallback, ap.this.Code, 1000, jSONObject.toString(), false);
                            return;
                        }
                        fh.I(ap.Z, "illegal param");
                        ah.Code(remoteCallResultCallback, ap.this.Code, 1001, null, false);
                    } catch (JSONException unused) {
                        fh.Z(ap.Z, "query h5 dsl json exception");
                        ah.Code(remoteCallResultCallback, ap.this.Code, 1011, null, false);
                    }
                }
            });
        } catch (Throwable unused) {
            Code(remoteCallResultCallback, true);
        }
    }
}
