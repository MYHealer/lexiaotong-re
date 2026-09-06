package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.consent.inter.Consent;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class at extends ah {
    private static final int B = 1;
    private static final int Z = 0;

    public at() {
        super(ak.x);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(Context context, String str, RemoteCallResultCallback<String> remoteCallResultCallback) {
        Consent.getInstance(context).setUnderAgeOfPromise(new JSONObject(str).optInt(com.huawei.openalliance.ad.constant.ba.R, 0) == 1);
        V(remoteCallResultCallback, true);
    }
}
