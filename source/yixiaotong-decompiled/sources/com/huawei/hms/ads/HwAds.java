package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HwAds {
    private HwAds() {
    }

    public static int getAppActivateStyle() {
        return k.Code().C();
    }

    public static RequestOptions getRequestOptions() {
        return k.Code().I();
    }

    public static String getSDKVersion() {
        return k.Code().V();
    }

    public static void init(Context context) {
        init(context, null);
    }

    public static void init(Context context, String str) {
        k.Code().Code(context, str);
    }

    public static boolean isAppInstalledNotify() {
        return k.Code().B();
    }

    public static void setAppActivateStyle(int i) {
        k.Code().V(i);
    }

    public static void setAppInstalledNotify(boolean z) {
        k.Code().V(z);
    }

    public static void setBrand(int i) {
        k.Code().Code(i);
    }

    public static void setConsent(String str) {
        k.Code().Code(str);
    }

    public static void setInfoController(InformationController informationController) {
        k.Code().Code(informationController);
    }

    public static void setRequestOptions(RequestOptions requestOptions) {
        k.Code().Code(requestOptions);
    }

    public static void setVideoMuted(boolean z) {
        k.Code().Code(z);
    }

    public static void setVideoVolume(float f) {
        k.Code().Code(f);
    }
}
