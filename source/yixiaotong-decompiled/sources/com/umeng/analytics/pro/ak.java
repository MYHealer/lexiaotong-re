package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.miui.deviceid.IdentifierManager;

/* JADX INFO: compiled from: XiaomiDeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
class ak implements z {
    ak() {
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        String strB = null;
        try {
            if (!IdentifierManager.a()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            } else {
                strB = IdentifierManager.b(context);
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return strB;
    }
}
