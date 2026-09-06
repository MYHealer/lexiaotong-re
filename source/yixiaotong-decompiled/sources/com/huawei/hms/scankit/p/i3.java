package com.huawei.hms.scankit.p;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.mlsdk.common.AgConnectInfo;

/* JADX INFO: compiled from: HaUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f4276a = "i3";
    private static volatile Bundle b;

    public static Bundle a(Context context) {
        if (context == null) {
            return new Bundle();
        }
        if (b == null) {
            Bundle bundle = new Bundle();
            try {
                String string = AGConnectServicesConfig.fromContext(context).getString(AgConnectInfo.AgConnectKey.APPLICATION_ID);
                if (string == null) {
                    string = context.getPackageName();
                }
                bundle.putString("appid", string);
            } catch (RuntimeException unused) {
                Log.e(f4276a, "getAppInfo: RuntimeException");
            } catch (Exception unused2) {
                Log.e(f4276a, "getAppInfo: Exception");
            }
            b = bundle;
        }
        return b;
    }
}
