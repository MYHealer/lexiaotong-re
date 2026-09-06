package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.common.inter.LoaderCommonInter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class eh implements LoaderCommonInter {
    private static final String Code = "LoaderCommonHandler";
    private static eh V;
    private static final byte[] Z = new byte[0];
    private Context I;

    private eh(Context context) {
        this.I = context;
    }

    public static eh Code(Context context) {
        return V(context);
    }

    private static eh V(Context context) {
        eh ehVar;
        synchronized (Z) {
            if (V == null) {
                V = new eh(context);
            }
            ehVar = V;
        }
        return ehVar;
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderCommonInter
    public boolean isTrustApp(String str, String str2) {
        return com.huawei.openalliance.ad.constant.dh.Code(this.I, str, str2);
    }

    @Override // com.huawei.hms.ads.common.inter.LoaderCommonInter
    public void saveReportPoint(int i, Integer num, Integer num2) {
        if (fh.Code()) {
            fh.Code(Code, "saveReportPoint");
        }
        dd.Code(this.I, i, num, num2);
    }
}
