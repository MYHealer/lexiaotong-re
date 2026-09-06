package com.huawei.hms.ads;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.tauth.DefaultUiListener;
import com.tencent.tauth.Tencent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class lc implements la {
    private static final int B = 600;
    private static final String C = "com.tencent.tauth.Tencent";
    private static final String Code = "QQSharer";
    private static final int I = 40;
    private static final int V = 30;
    private static final int Z = 200;

    private static Bundle Code(le leVar, lg lgVar) {
        Bundle bundle = new Bundle();
        if (leVar != null && lgVar != null) {
            boolean zBooleanValue = lgVar.V().booleanValue();
            bundle.putString("title", lh.Code(leVar.V(), zBooleanValue ? 30 : 40));
            bundle.putString("summary", lh.Code(leVar.I(), lgVar.V().booleanValue() ? 200 : 600));
            bundle.putString("targetUrl", leVar.Z());
            String strCode = leVar.Code();
            bundle.putString(strCode.startsWith("http") ? ld.f3875a : "imageLocalUrl", strCode);
            bundle.putInt("req_type", 1);
            bundle.putInt("cflag", zBooleanValue ? 2 : 1);
        }
        return bundle;
    }

    @Override // com.huawei.hms.ads.la
    public void Code(Activity activity, le leVar, lg lgVar) {
        fh.V(Code, "start QQ share");
        Tencent.createInstance(lgVar.Code(), activity).shareToQQ(activity, Code(leVar, lgVar), new DefaultUiListener());
    }

    @Override // com.huawei.hms.ads.la
    public boolean Code() {
        return lh.Code(C);
    }
}
