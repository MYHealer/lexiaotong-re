package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.cd;
import com.huawei.openalliance.ad.inter.data.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class NativeAdConverter {
    public static NativeAd deserialization(Context context, String str) {
        return deserialization(context, str, null);
    }

    public static NativeAd deserialization(Context context, String str, NativeAdConfiguration nativeAdConfiguration) {
        g gVarCode = g.a.Code(str);
        if (gVarCode == null) {
            return null;
        }
        cd cdVar = new cd(context, gVarCode);
        if (nativeAdConfiguration != null) {
            cdVar.Code(nativeAdConfiguration);
        }
        return cdVar;
    }

    public static String serialization(NativeAd nativeAd) {
        if (nativeAd instanceof cd) {
            return g.a.Code(((cd) nativeAd).Code());
        }
        return null;
    }
}
