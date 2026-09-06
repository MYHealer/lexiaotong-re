package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.constant.ConsentStatus;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class au extends ah {
    public au() {
        super(ak.w);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).setConsentStatus(ConsentStatus.forValue(new JSONObject(str).optInt(com.huawei.openalliance.ad.constant.ba.Q, ConsentStatus.UNKNOWN.getValue())));
        V(remoteCallResultCallback, true);
    }
}
