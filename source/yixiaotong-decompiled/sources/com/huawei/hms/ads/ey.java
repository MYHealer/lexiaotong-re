package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.inner.data.JsbCallBackData;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ey extends ah {

    private static class a implements com.huawei.openalliance.ad.inter.listeners.g {
        RewardItem Code;
        private RemoteCallResultCallback<String> I;
        private String V;

        a(RemoteCallResultCallback<String> remoteCallResultCallback, String str, RewardItem rewardItem) {
            this.Code = rewardItem;
            this.I = remoteCallResultCallback;
            this.V = str;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void B() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(this.Code, false, ai.Z));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.I));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code(int i, int i2) {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.B));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void I() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.S));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void V() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.C));
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Z() {
            ah.Code(this.I, this.V, 1000, new JsbCallBackData(null, false, ai.V));
        }
    }

    public ey() {
        super(ak.j);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.ey.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                if (adContentData == null) {
                    fh.V("JsbStartRewardAdActivity", "adContentData is null, start activity failed");
                    ah.Code(remoteCallResultCallback, ey.this.Code, 3002, null, true);
                    return;
                }
                com.huawei.openalliance.ad.inter.data.q qVar = new com.huawei.openalliance.ad.inter.data.q(adContentData);
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    String strOptString = jSONObject.optString("customData");
                    String strOptString2 = jSONObject.optString(com.huawei.openalliance.ad.constant.ba.r);
                    boolean zOptBoolean = jSONObject.optBoolean("muted", true);
                    boolean zOptBoolean2 = jSONObject.optBoolean(com.huawei.openalliance.ad.constant.ba.aA, true);
                    int iOptInt = jSONObject.optInt("audioFocusType", 1);
                    if (!TextUtils.isEmpty(strOptString)) {
                        qVar.Code(strOptString);
                    }
                    if (!TextUtils.isEmpty(strOptString2)) {
                        qVar.V(strOptString2);
                    }
                    if (iOptInt == 1 || iOptInt == 2 || iOptInt == 0) {
                        qVar.Code(iOptInt);
                    }
                    qVar.Code(zOptBoolean);
                    qVar.V(zOptBoolean2);
                    qVar.a_(true);
                } catch (Throwable unused) {
                    fh.I("JsbStartRewardAdActivity", "content parse error");
                }
                qVar.Code(ey.this.Code(context), new a(remoteCallResultCallback, ey.this.Code, qVar.S()));
                ey.this.V(remoteCallResultCallback, false);
            }
        });
    }
}
