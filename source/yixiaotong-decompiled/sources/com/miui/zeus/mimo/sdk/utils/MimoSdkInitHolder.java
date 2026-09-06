package com.miui.zeus.mimo.sdk.utils;

import com.google.common.base.Ascii;
import com.miui.zeus.landingpage.sdk.LandingPageSDK;
import com.miui.zeus.mimo.sdk.MimoCustomController;
import com.miui.zeus.mimo.sdk.MimoLocation;
import com.miui.zeus.mimo.sdk.m;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class MimoSdkInitHolder {
    private static MimoCustomController sCustomController = null;
    private static boolean sDebugOn = false;
    private static boolean sDebugOnSetting = false;
    private static boolean sHasInit = false;
    private static boolean sInitSuccess = false;
    private static boolean sPersonalizedAdEnable = true;
    private static int sRequestEnvironment;

    public class a extends MimoCustomController {
        @Override // com.miui.zeus.mimo.sdk.MimoCustomController
        public boolean alist() {
            return true;
        }

        @Override // com.miui.zeus.mimo.sdk.MimoCustomController
        public MimoLocation getMimoLocation() {
            return null;
        }

        @Override // com.miui.zeus.mimo.sdk.MimoCustomController
        public boolean isCanUseLocation() {
            return true;
        }

        @Override // com.miui.zeus.mimo.sdk.MimoCustomController
        public boolean isCanUseWifiState() {
            return true;
        }
    }

    private MimoSdkInitHolder() {
    }

    public static MimoCustomController getCustomController() {
        if (sCustomController == null) {
            sCustomController = new a();
        }
        return sCustomController;
    }

    public static int getRequestEnvironment() {
        return sRequestEnvironment;
    }

    public static int getVersionCode() {
        return 539;
    }

    public static String getVersionName() {
        return s.d(new byte[]{81, Ascii.CAN, 6, 26, 8}, "d65414");
    }

    public static boolean isDebugOn() {
        if (sDebugOn) {
            return true;
        }
        return sDebugOnSetting;
    }

    public static boolean isHasInit() {
        return sHasInit;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static boolean isPersonalizedAdEnabled() {
        return sPersonalizedAdEnable;
    }

    public static void setDebugOn(boolean z) {
        sDebugOn = z;
        m.f5524a = z ? 1000 : 1;
        LandingPageSDK.setDebugOn(z);
    }

    public static void setDebugOnSetting(boolean z) {
        sDebugOnSetting = z;
        LandingPageSDK.setDebugOn(z);
    }

    public static void setHasInit(boolean z) {
        sHasInit = z;
    }

    public static void setInitSuccess(boolean z) {
        sInitSuccess = z;
    }

    public static void setPersonalizedAdEnabled(boolean z) {
        sPersonalizedAdEnable = z;
    }

    public static void setsCustomController(MimoCustomController mimoCustomController) {
        sCustomController = mimoCustomController;
    }
}
