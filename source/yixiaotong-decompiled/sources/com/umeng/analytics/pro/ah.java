package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import org.repackage.com.heytap.openid.sdk.OpenIDSDK;

/* JADX INFO: compiled from: OppoDeviceIdSupplier.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class ah implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f9097a = false;

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        try {
            if (!this.f9097a) {
                OpenIDSDK.a(context);
                this.f9097a = true;
            }
            if (!OpenIDSDK.a()) {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
                return null;
            }
            return OpenIDSDK.c(context);
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
