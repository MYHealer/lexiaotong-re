package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.metadata.ApkInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.inter.data.AdContentData;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class kd extends kr {
    private static final String Code = "AppEnterAction";

    public kd(Context context, AdContentData adContentData) {
        super(context, adContentData);
    }

    @Override // com.huawei.hms.ads.kr
    public boolean Code() {
        ApkInfo apkInfoE;
        fh.V(Code, "handle app enter action");
        MetaData metaDataS = this.Z.S();
        if (metaDataS != null && (apkInfoE = metaDataS.e()) != null) {
            String strCode = apkInfoE.Code();
            kw.a aVar = new kw.a();
            aVar.Code(apkInfoE).Code(this.Z);
            if (com.huawei.openalliance.ad.utils.h.Code(this.I, strCode, aVar.Code())) {
                Code("app");
                jk.Code(this.I, this.Z, (Integer) 1);
                return true;
            }
        }
        return I();
    }

    @Override // com.huawei.hms.ads.kr
    public void V() {
        Code("app");
    }
}
