package com.miui.zeus.safe.sdk.config;

import android.view.accessibility.AccessibilityManager;
import com.google.common.base.Ascii;
import com.miui.zeus.safe.sdk.a;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class AccessibilityConfig {
    public boolean isAccessibilityEnabled() {
        AccessibilityManager accessibilityManager = (AccessibilityManager) a.a().getSystemService(s.d(new byte[]{2, 91, 85, 0, Ascii.NAK, 65, 8, 6, 15, 14, 88, 17, 26}, "c86ef2"));
        if (accessibilityManager == null) {
            return false;
        }
        return accessibilityManager.isEnabled();
    }
}
