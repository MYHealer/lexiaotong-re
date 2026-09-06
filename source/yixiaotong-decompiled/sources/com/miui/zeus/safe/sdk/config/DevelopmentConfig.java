package com.miui.zeus.safe.sdk.config;

import android.provider.Settings;
import com.google.common.base.Ascii;
import com.miui.zeus.safe.sdk.a;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DevelopmentConfig {
    public boolean isOpenDevelopmentSetting() {
        return Settings.Secure.getInt(a.a().getContentResolver(), s.d(new byte[]{0, 6, 78, 0, 84, 14, 17, 9, 3, 12, 69, 58, Ascii.ETB, 6, 76, 17, 81, 15, 6, Ascii.ETB, 57, 7, 95, 4, 6, 15, 93, 1}, "dc8e8a"), 0) != 0;
    }

    public boolean isOpenUSBDebugSetting() {
        return Settings.Secure.getInt(a.a().getContentResolver(), s.d(new byte[]{82, 81, 6, 58, 82, 86, 0, 6, 10, 7, 85}, "35de78"), 0) != 0;
    }
}
