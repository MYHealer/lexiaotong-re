package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class en extends ah {
    public en() {
        super(ak.F);
    }

    @Override // com.huawei.hms.ads.ah, com.huawei.hms.ads.ae
    public void execute(final Context context, final String str, final RemoteCallResultCallback<String> remoteCallResultCallback) {
        if (fh.Code()) {
            fh.Code("JsbClickComplianceEle", "start");
        }
        final String strOptString = new JSONObject(str).optString(com.huawei.openalliance.ad.constant.ba.aU, "");
        Code(context, str, true, new ad() { // from class: com.huawei.hms.ads.en.1
            @Override // com.huawei.hms.ads.ad
            public void Code(AdContentData adContentData) {
                String str2;
                int i = 3002;
                if (adContentData != null) {
                    com.huawei.openalliance.ad.inter.data.AppInfo appInfoY = adContentData.y();
                    if (appInfoY != null) {
                        String str3 = strOptString;
                        str3.hashCode();
                        switch (str3) {
                            case "privacyUrl":
                                appInfoY.Code(context);
                                break;
                            case "permissionUrl":
                                appInfoY.V(context);
                                break;
                            case "appDetailUrl":
                                com.huawei.openalliance.ad.inter.data.l lVar = new com.huawei.openalliance.ad.inter.data.l(adContentData);
                                MaterialClickInfo materialClickInfo = (MaterialClickInfo) com.huawei.openalliance.ad.utils.ad.V(str, MaterialClickInfo.class, new Class[0]);
                                if (materialClickInfo != null && com.huawei.openalliance.ad.utils.bc.L(materialClickInfo.I()) && materialClickInfo.Code() != null) {
                                    lVar.Code(en.this.Code(context), materialClickInfo);
                                    break;
                                } else {
                                    lVar.V(en.this.Code(context));
                                    break;
                                }
                                break;
                        }
                        i = 1000;
                    } else {
                        str2 = "appInfo not exist";
                    }
                    ah.Code(remoteCallResultCallback, en.this.Code, i, null, true);
                }
                str2 = "ad not exist";
                fh.Code("JsbClickComplianceEle", str2);
                ah.Code(remoteCallResultCallback, en.this.Code, i, null, true);
            }
        });
    }
}
