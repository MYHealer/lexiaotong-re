package com.huawei.hms.mlplugin.card.bcr;

import android.os.Build;
import com.byazt.bv.BaseConstants;
import com.unionpay.tsmservice.mi.data.Constant;

/* JADX INFO: compiled from: OSUtils.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class s {
    public static boolean a() {
        return "HUAWEI".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean b() {
        return BaseConstants.ROM_OPPO_UPPER_CONSTANT.equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean c() {
        return "VIVO".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean d() {
        return Constant.DEVICE_XIAOMI.equalsIgnoreCase(Build.MANUFACTURER);
    }
}
