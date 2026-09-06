package com.miui.zeus.safe.sdk;

import android.content.Context;
import com.miui.zeus.safe.sdk.config.AccessibilityConfig;
import com.miui.zeus.safe.sdk.config.BatteryConfig;
import com.miui.zeus.safe.sdk.config.DevelopmentConfig;
import com.miui.zeus.safe.sdk.config.HookConfig;
import com.miui.zeus.safe.sdk.config.RootConfig;
import com.miui.zeus.safe.sdk.config.UsbConfig;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class MSafeHelper {
    private MSafeHelper() {
    }

    public static AccessibilityConfig getAccessibilityConfig() {
        return new AccessibilityConfig();
    }

    public static BatteryConfig getBatteryConfig() {
        return new BatteryConfig();
    }

    public static DevelopmentConfig getDevelopmentConfig() {
        return new DevelopmentConfig();
    }

    public static HookConfig getHookConfig() {
        return new HookConfig();
    }

    public static RootConfig getRootConfig() {
        return new RootConfig();
    }

    public static UsbConfig getUsbConfig() {
        return new UsbConfig();
    }

    public static void init(Context context) {
        if (context != null) {
            a.f5762a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }
}
