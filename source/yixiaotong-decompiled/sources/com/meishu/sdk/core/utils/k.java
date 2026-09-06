package com.meishu.sdk.core.utils;

import android.text.TextUtils;
import com.meishu.sdk.core.AdSdk;

/* JADX INFO: compiled from: DeviceUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k implements MiitHelper.a {
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        j.f4912a = str;
        try {
            try {
                String strC = f1.c(str);
                AdSdk.getSharedPreferences().edit().putString("oaid_e", strC).apply();
                q.a().b("oaid_e", strC);
            } catch (Exception e) {
                e.printStackTrace();
            }
            LogUtil.d("DeviceUtil", "Write oaid to cache, oaid=" + j.f4912a);
        } catch (Throwable th) {
            LogUtil.d("DeviceUtil", "Write oaid to cache failed");
            th.printStackTrace();
        }
    }
}
