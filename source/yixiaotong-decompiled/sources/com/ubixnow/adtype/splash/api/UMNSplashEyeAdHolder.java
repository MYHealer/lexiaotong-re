package com.ubixnow.adtype.splash.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.ubixnow.ooooo.o00O00OO;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNSplashEyeAdHolder extends o00O00OO {
    public static final String TAG = "----SplashPlusManger";
    public static int platformId = 1;

    public static View getSplashView(Activity activity) {
        int i = platformId;
        if (i == 1) {
            loadPangle(activity);
            return null;
        }
        if (i != 2) {
            return null;
        }
        loadGdt(activity);
        return null;
    }

    private static View loadGdt(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.ubixnow.network.gdt.SplashZoomOutManager");
            return (View) cls.getMethod("getSplashView", Activity.class).invoke(cls.getDeclaredMethod("getInstance", Context.class).invoke(cls, activity.getBaseContext()), activity);
        } catch (Exception e) {
            ooooO000.OooO0O0("-----getSplashView ", "====Exception " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    private static View loadPangle(Activity activity) {
        try {
            Class<?> cls = Class.forName("com.ubixnow.network.pangle.SplashClickEyeManager");
            return (View) cls.getMethod("startSplashClickEye", Activity.class).invoke(cls.getDeclaredMethod("getInstance", new Class[0]).invoke(cls, new Object[0]), activity);
        } catch (Exception e) {
            ooooO000.OooO0O0("-----getSplashView loadPangle: ", "====Exception " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public static void setSplashView() {
    }
}
