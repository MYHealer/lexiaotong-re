package com.baidu.oauth.sdkbqt.a.a;

import android.os.Build;
import com.baidu.oauth.sdkbqt.auth.AuthInfo;
import com.baidu.oauth.sdkbqt.auth.BdOauthSdk;
import com.cdo.oaps.ad.OapsKey;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f1857a = "Utils";

    h() {
    }

    static Map<String, String> a() {
        com.baidu.oauth.sdkbqt.a.d.b(f1857a, "buildCommonParams begin");
        HashMap map = new HashMap();
        map.put("client", "android");
        map.put("v", String.valueOf(System.currentTimeMillis()));
        map.put(com.alipay.sdk.packet.e.n, Build.MODEL);
        map.put("sdk_version", "2.0.6.10");
        AuthInfo authInfo = BdOauthSdk.getAuthInfo();
        if (authInfo != null) {
            map.put(com.alipay.sdk.cons.b.h, authInfo.getAppKey());
            map.put(OapsKey.KEY_PKG, authInfo.getPackageName());
            map.put("cuid", authInfo.getDeviceId());
            map.put("app_version", com.baidu.oauth.sdkbqt.a.h.b(authInfo.getContext()));
        }
        return map;
    }
}
