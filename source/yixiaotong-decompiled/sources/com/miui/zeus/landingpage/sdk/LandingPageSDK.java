package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class LandingPageSDK {
    public static void init(Context context) {
        if (context == null) {
            m.b(s.d(new byte[]{40, 3, 88, 81, 13, 13, 6, 52, 7, 5, 84, 54, 32, 41}, "db65dc"), s.d(new byte[]{91, 9, 8, 16, 81, 72, Ascii.NAK, 68, 15, 17, 17, 11, 77, 10, 10, 68, Ascii.CAN, 16, Ascii.DC2, 16, 9, Ascii.DC2, 17, 12, 86, 15, Ascii.DC2}, "8ffd40"));
        } else {
            m.d(s.d(new byte[]{41, 80, 93, 5, 13, 87, 6, 52, 7, 5, 84, 54, 33, 122}, "e13ad9"), s.d(new byte[]{126, 87, 94, 80, 88, 92, 6, 52, 7, 5, 84, 54, 118, 125, 16, 93, 95, 91, Ascii.NAK, 68, 87, 76, 2, 75, 10}, "260412"));
            y8.a(context);
        }
    }

    public static boolean isDebugOn() {
        return y8.d;
    }

    public static void setDebugOn(boolean z) {
        y8.d = z;
        m.f5524a = z ? 1000 : 1;
    }
}
