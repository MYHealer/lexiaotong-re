package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.view.MimoWebViewActivity;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class z6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5760a = ijiami_1011.s.s.s.d(new byte[]{Ascii.RS, 7}, "d17510");

    public static void a(Context context, String str, String str2, MimoAdInfo mimoAdInfo, String str3, r3 r3Var) {
        Intent intent = new Intent(context, (Class<?>) MimoWebViewActivity.class);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(ijiami_1011.s.s.s.d(new byte[]{88, 10, 88, 6, 60, 67, 19, 8}, "4e9bc6"), str);
        }
        if (!TextUtils.isEmpty(str2) && mimoAdInfo != null) {
            e4.a(str2, mimoAdInfo);
            intent.putExtra(ijiami_1011.s.s.s.d(new byte[]{92, 2, 4, 86, 68, 95, 7, Ascii.GS, 47, 6}, "5fa806"), str2);
        }
        if (!TextUtils.isEmpty(str3) && r3Var != null) {
            f4 f4VarA = f4.a();
            f4VarA.getClass();
            if (!TextUtils.isEmpty(str3)) {
                f4VarA.f5424a.put(str3, r3Var);
            }
            intent.putExtra(ijiami_1011.s.s.s.d(new byte[]{93, 13, 70, 90, 10, 93, 0, 0, 47, 6}, "9b14f2"), str3);
        }
        intent.putExtra(ijiami_1011.s.s.s.d(new byte[]{81, 88, 12, 85, 13, 1}, "27b3df"), ijiami_1011.s.s.s.d(new byte[]{9, 81, 14, 10, 17, 1, 10, 59, 7, 6, 87, 0, 1, 92, 1, 4, 1, 14}, "d8cebe"));
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static boolean a(Context context, String str) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    m.d(f5760a, ijiami_1011.s.s.s.d(new byte[]{16, 66, 3, Ascii.ETB, 16, 53, 4, 6, 39, 1, 69, 12, Ascii.NAK, 95, Ascii.SYN, Ascii.FS}, "c6bedb"));
                    a(context, str, null, null, null, null);
                    return true;
                }
            } catch (Exception e) {
                m.b(f5760a, ijiami_1011.s.s.s.d(new byte[]{71, 91, 94, SignedBytes.MAX_POWER_OF_TWO, 96, 83, 3, 37, 5, Ascii.SYN, 88, 19, 93, 71, 72}, "431776"), e);
            }
        }
        return false;
    }
}
