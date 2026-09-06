package com.byazt.yv;

import android.telephony.TelephonyManager;
import com.huawei.openalliance.ad.constant.ai;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, ai.y, 34})
public class a {
    public static String c(TelephonyManager telephonyManager) throws SecurityException {
        if (da.tt) {
            da.c("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }
}
