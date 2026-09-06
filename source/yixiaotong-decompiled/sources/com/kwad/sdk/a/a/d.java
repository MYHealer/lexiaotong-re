package com.kwad.sdk.a.a;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    public static String H(AdInfo adInfo) {
        return com.kwad.sdk.core.config.e.Kt().replace("[appname]", adInfo.adBaseInfo.appName).replace("[appsize]", com.kwad.components.core.t.e.a(adInfo.adBaseInfo.packageSize, true)).replace("[appver]", adInfo.adBaseInfo.appVersion);
    }

    public static String Hr() {
        String strKu = com.kwad.sdk.core.config.e.Ku();
        return TextUtils.isEmpty(strKu) ? "安装" : strKu;
    }

    public static String Hs() {
        String strKv = com.kwad.sdk.core.config.e.Kv();
        return TextUtils.isEmpty(strKv) ? "取消" : strKv;
    }
}
