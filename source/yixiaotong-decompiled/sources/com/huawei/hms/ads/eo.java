package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class eo extends ah {
    public eo() {
        super(ak.J);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        fh.Code("JsbClickShare", "start");
        final String strOptString = new JSONObject(str).optString("cshareUrl", "");
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.eo.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                int i;
                if (adContentData != null) {
                    fh.Code("JsbClickShare", "start dialog activity");
                    com.huawei.openalliance.ad.inter.data.l lVar = new com.huawei.openalliance.ad.inter.data.l(adContentData);
                    lVar.S(strOptString);
                    com.huawei.openalliance.ad.activity.c.Code(context, lVar, adContentData);
                    i = 1000;
                } else {
                    fh.Code("JsbClickShare", "ad not exist");
                    i = 3002;
                }
                ah.Code(remoteCallResultCallback, eo.this.Code, i, null, true);
            }
        });
    }
}
