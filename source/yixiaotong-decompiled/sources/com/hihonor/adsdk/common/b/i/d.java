package com.hihonor.adsdk.common.b.i;

import android.util.Log;
import com.hihonor.adsdk.common.b.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d implements g {
    static final String hnadsa = "NO_TAG";

    @Override // com.hihonor.adsdk.common.b.g
    public void hnadsa(int i, String str, String str2) {
        if (str == null) {
            str = hnadsa;
        }
        Log.println(i, str, str2);
    }
}
