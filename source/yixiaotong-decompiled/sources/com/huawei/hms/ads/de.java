package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.analysis.DynamicLoaderAnalysis;
import com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis;
import com.huawei.openalliance.ad.inter.HiAd;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class de {
    private static final String Code = "DyLoaderAnalysisUtil";
    private static a I = null;
    private static final String V = "decouple";

    private static class a implements IDynamicLoaderAnalysis {
        private Context Code;

        public a(Context context) {
            this.Code = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }

        @Override // com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis
        public void onLoaderException(String str, String str2, int i, String str3) {
            if (HiAd.getInstance(this.Code).isEnableUserInfo()) {
                dd.Code(this.Code, str, str2, i, str3);
            }
        }

        @Override // com.huawei.hms.ads.analysis.IDynamicLoaderAnalysis
        public void onLoaderSuccess(String str, String str2, long j) {
            if (HiAd.getInstance(this.Code).isEnableUserInfo()) {
                dd.Code(this.Code, str, str2, j);
            }
        }
    }

    public static void Code(Context context) {
        try {
            if (I == null) {
                I = new a(context);
            }
            DynamicLoaderAnalysis.getInstance().registerDynamicLoaderAnalysis(V, I);
        } catch (Throwable th) {
            fh.I(Code, "init analysis err: %s", th.getClass().getSimpleName());
        }
    }
}
