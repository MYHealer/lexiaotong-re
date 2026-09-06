package com.miui.zeus.mimo.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5585a = ijiami_1011.s.s.s.d(new byte[]{68, 80}, "6fc41e");

    public static boolean a(Context context, String str) {
        boolean z = false;
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(ijiami_1011.s.s.s.d(new byte[]{84, 14, 95, 79, Ascii.ESC, 13, 0, 11, 11, 11, Ascii.US, 8, 86, 19, 89, 4, Ascii.ETB}, "7a2acd"), 128).metaData;
            if (bundle == null) {
                return false;
            }
            z = bundle.getBoolean(str);
            m.a(f5585a, ijiami_1011.s.s.s.d(new byte[]{3, 93, Ascii.DC2, 35, 95, 12, 13, 1, 7, 12, 124, 0, 16, 89, 34, 0, 68, 2, 65, 15, 3, Ascii.ESC, 12}, "d8fa0c") + str + ijiami_1011.s.s.s.d(new byte[]{78, 69, 79, 3, 93, 16, 4, 89}, "be9b1e") + z);
            return z;
        } catch (PackageManager.NameNotFoundException e) {
            m.b(f5585a, ijiami_1011.s.s.s.d(new byte[]{84, 6, 76, 39, 95, 88, 13, 1, 7, 12, 124, 0, 71, 2, 124, 4, 68, 86, 65, 1, Ascii.DC4, 16, 94, Ascii.ETB}, "3c8e07"), e);
            return z;
        }
    }
}
