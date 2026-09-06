package com.xiaomi.onetrack.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.UserManager;
import android.os.storage.StorageManager;
import android.preference.PreferenceManager;
import com.google.common.base.Ascii;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\2263432.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9515a = ijiami_1011.s.s.s.d(new byte[]{36, 6, 93, 108, 70, 80, 13}, "bd8929");

    private j() {
    }

    public static Context a(Context context) {
        if (e(context)) {
            p.a(f9515a, ijiami_1011.s.s.s.d(new byte[]{82, 6, 68, 100, 4, 5, 4, 39, 9, 12, 69, 0, 77, Ascii.ETB, 16, 69, 0, Ascii.ETB, Ascii.DC4, Ascii.SYN, 8, 66, 94, Ascii.ETB, 92, 4, 89, 89, 69, 0, Ascii.NAK, Ascii.FS}, "5c07ec"));
            return context;
        }
        p.a(f9515a, ijiami_1011.s.s.s.d(new byte[]{1, 6, 16, 97, 4, 84, 4, 39, 9, 12, 69, 0, Ascii.RS, Ascii.ETB, 68, Ascii.RS, 69, 81, 19, 1, 7, Ascii.SYN, 84, 69, Ascii.DC2, 11, 1, Ascii.DC2, Ascii.SYN, 83, 7, 1, 70, 1, 69, Ascii.GS}, "fcd2e2"));
        return context.createDeviceProtectedStorageContext();
    }

    public static void a(PreferenceManager preferenceManager) {
        preferenceManager.setStorageDeviceProtected();
    }

    public static boolean a() {
        try {
            return ((Boolean) StorageManager.class.getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{88, 75, 37, 92, 93, 93, 36, 10, 5, 16, 72, Ascii.NAK, 69, 93, 7, 123, 80, 76, 8, Ascii.DC2, 3, 45, 67, 32, 92, 77, 15, 84, 69, 93, 5}, "18c518"), new Class[0]).invoke(null, new Object[0]).getClass().getDeclaredMethod(ijiami_1011.s.s.s.d(new byte[]{94, Ascii.SYN, 119, 12, 93, 86, 36, 10, 5, 16, 72, Ascii.NAK, 67, 0, 85, 43, 80, 71, 8, Ascii.DC2, 3, 45, 67, 32, 90, 16, 93, 4, 69, 86, 5}, "7e1e13"), Boolean.TYPE).invoke(null, new Object[0])).booleanValue();
        } catch (Exception e) {
            p.b(f9515a, ijiami_1011.s.s.s.d(new byte[]{73, Ascii.DC2, Ascii.GS, Ascii.NAK}, "c875c6") + e);
            return false;
        }
    }

    public static boolean b(Context context) {
        try {
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(ijiami_1011.s.s.s.d(new byte[]{95, 81, Ascii.FS, 87, Ascii.DC4, 81, 19, 0}, "44e0a0"));
            return a() && keyguardManager != null && keyguardManager.isKeyguardSecure();
        } catch (Exception e) {
            p.a(f9515a, ijiami_1011.s.s.s.d(new byte[]{39, 113, 117, 39, 4, 79, 8, 7, 3, 35, 95, 1, 50, 86, 68, 6, 5, 108, 17, 55, 5, 16, 84, 0, 15, 127, 95, 0, 10, Ascii.EM, 36, Ascii.FS, 5, 7, 65, 17, 8, 92, 94, 89, 65}, "a30ca9") + e.getMessage());
            return false;
        }
    }

    public static boolean c(Context context) {
        return b(context) && !e(context);
    }

    public static boolean d(Context context) {
        return !e(context);
    }

    private static boolean e(Context context) {
        try {
            UserManager userManager = (UserManager) context.getSystemService(ijiami_1011.s.s.s.d(new byte[]{67, 74, 87, Ascii.ETB}, "692e49"));
            return userManager != null && userManager.isUserUnlocked();
        } catch (Exception e) {
            p.a(f9515a, ijiami_1011.s.s.s.d(new byte[]{8, 75, 98, 75, 81, 69, 52, 10, 10, 13, 82, 14, 4, 92, Ascii.ETB, 125, 76, 84, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11, 91, Ascii.CAN}, "a87847") + e.getMessage());
            return false;
        }
    }

    private static boolean f(Context context) {
        return false;
    }
}
