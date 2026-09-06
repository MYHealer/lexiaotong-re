package com.kwad.components.ad.reward;

import com.huawei.openalliance.ad.constant.x;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.br;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class p {
    public static void b(final AdTemplate adTemplate, AdInfo adInfo) {
        final String strBY = com.kwad.sdk.core.response.helper.a.bY(adInfo);
        com.kwad.sdk.core.d.c.d("ServerCallbackHandle", "handleRewardVerify callbackUrl: " + strBY);
        if (br.isNullString(strBY)) {
            return;
        }
        com.kwad.sdk.utils.i.execute(new Runnable() { // from class: com.kwad.components.ad.reward.p.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.kwad.sdk.core.network.c cVarDoGet = com.kwad.sdk.h.EG().doGet(strBY, null);
                    if (cVarDoGet == null) {
                        L("Network Error: url invalid");
                        return;
                    }
                    if (cVarDoGet.code == 200) {
                        a aVar = new a(cVarDoGet.aSY);
                        if (aVar.isValid()) {
                            hK();
                            return;
                        } else {
                            L(aVar.errorMsg);
                            return;
                        }
                    }
                    L("Network Error: " + cVarDoGet.aSY);
                } catch (Throwable th) {
                    L("Request Error: " + th.getMessage());
                }
            }

            private void hK() {
                com.kwad.components.core.p.a.vL().h(adTemplate, 0, "success");
            }

            private void L(String str) {
                com.kwad.components.core.p.a.vL().h(adTemplate, 1, str);
            }
        });
    }

    static class a {
        private String errorMsg;
        private boolean un;

        public final boolean isValid() {
            return this.un;
        }

        public a(String str) {
            JSONObject jSONObject;
            this.errorMsg = x.A;
            try {
                jSONObject = new JSONObject(str);
            } catch (Throwable th) {
                th.printStackTrace();
                this.un = false;
                this.errorMsg = "数据解析失败";
                jSONObject = null;
            }
            parseJson(jSONObject);
        }

        private void parseJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.un = jSONObject.optBoolean("isValid");
                this.errorMsg = jSONObject.toString();
            }
        }
    }
}
