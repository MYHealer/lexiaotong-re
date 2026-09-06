package com.miui.zeus.landingpage.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.landingpage.sdk.activity.WebViewActivity;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {
    public static boolean a(Intent intent) {
        Context context = y8.f5752a;
        boolean zA = false;
        if (context == null || intent == null) {
            m.b(s.d(new byte[]{123, 87, 90, 6, 95, 15, 6, 52, 7, 5, 84, 48, 67, 95, 88, 17}, "764b6a"), s.d(new byte[]{80, 14, 89, 76, 6, 26, Ascii.NAK, 68, 9, 16, 17, 12, 93, Ascii.NAK, 82, 86, Ascii.ETB, 66, 2, 5, 8, 66, 95, 10, 71, 65, 85, 93, 67, 12, Ascii.DC4, 8, 10}, "3a78cb"));
            return false;
        }
        if (TextUtils.isEmpty(intent.getPackage())) {
            Intent intent2 = new Intent(intent);
            c.a(intent2, context);
            zA = a(intent2, context);
        }
        return !zA ? a(intent, context) : zA;
    }

    public static boolean a(Intent intent, Context context) {
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            m.b(s.d(new byte[]{127, 87, 91, 6, 88, 13, 6, 52, 7, 5, 84, 48, 71, 95, 89, 17}, "365b1c"), s.d(new byte[]{65, 76, 74, 76, 0, 94, 46, Ascii.DC4, 3, 12}, "2598e3"), e);
            return false;
        }
    }

    public static boolean a(String str) {
        return str.startsWith(s.d(new byte[]{92, 7, SignedBytes.MAX_POWER_OF_TWO, 92, 87, Ascii.ETB}, "1f272c")) || str.startsWith(s.d(new byte[]{90, 89, 8, 87, 74, 8, 4, 16}, "70e68c"));
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(s.d(new byte[]{88, 70, 77, 71}, "029745")) || str.startsWith(s.d(new byte[]{94, 16, Ascii.NAK, 65, 71}, "6da144"));
    }

    public static boolean b(String str, boolean z, int i) {
        try {
            Context context = y8.f5752a;
            Intent intent = new Intent(context, (Class<?>) WebViewActivity.class);
            intent.setFlags(268435456);
            Bundle bundle = new Bundle();
            bundle.putString(s.d(new byte[]{15, 86, 76, 107, 68, Ascii.DC4, 13}, "d3541f"), str);
            bundle.putBoolean(s.d(new byte[]{91, 85, 77, 103, Ascii.DC2, 14, 14, 19, 57, Ascii.SYN, 94, Ascii.NAK, 111, 82, 85, 74}, "0048af"), z);
            bundle.putInt(s.d(new byte[]{82, 80, 77, 109, 9, SignedBytes.MAX_POWER_OF_TWO, 8, 1, 8, Ascii.SYN, 80, 17, 80, 90, 90}, "9542f2"), i);
            intent.putExtras(bundle);
            context.startActivity(intent);
            return true;
        } catch (Exception e) {
            m.b(s.d(new byte[]{41, 82, 94, 86, 13, 91, 6, 52, 7, 5, 84, 48, 17, 90, 92, 65}, "e302d5"), s.d(new byte[]{Ascii.DC2, 76, 4, 74, Ascii.SYN, 54, 4, 6, 48, 11, 84, Ascii.DC2, 32, 91, 17, 81, Ascii.DC4, 8, Ascii.NAK, Ascii.GS, 70, 7, 11}, "a8e8ba"), e);
            return false;
        }
    }

    public static boolean c(String str) {
        Intent uri;
        if (TextUtils.isEmpty(str)) {
            uri = null;
        } else {
            try {
                uri = Intent.parseUri(str, 0);
            } catch (Exception e) {
                m.b(s.d(new byte[]{116, 4, 95, 5, 13, 12, 6, 52, 7, 5, 84, 48, 76, 12, 93, Ascii.DC2}, "8e1adb"), s.d(new byte[]{10, 73, 84, 91, 124, 81, 4, Ascii.DC4, 42, 11, 95, 14, 69, 92, 11}, "e91584"), e);
                uri = null;
            }
        }
        if (uri == null) {
            return false;
        }
        uri.addFlags(268435456);
        uri.setComponent(null);
        uri.setSelector(null);
        return a(uri);
    }

    public static boolean d(String str) {
        Context context = y8.f5752a;
        if (!TextUtils.isEmpty(str) && a(str)) {
            try {
                Intent intent = new Intent(s.d(new byte[]{3, 88, 81, 75, 11, 13, 5, 74, 15, 12, 69, 0, 12, 66, Ascii.ESC, 88, 7, 16, 8, 11, 8, 76, 103, 44, 39, 97}, "b659dd"));
                intent.setData(Uri.parse(str));
                intent.setPackage(s.d(new byte[]{5, 93, 90, Ascii.FS, 74, 12, 0, 11, 11, 11, Ascii.US, 8, 7, SignedBytes.MAX_POWER_OF_TWO, 92, 87, 70}, "f2722e"));
                intent.addFlags(268435456);
                intent.addFlags(8388608);
                intent.addFlags(C.BUFFER_FLAG_FIRST_SAMPLE);
                context.startActivity(intent);
                return true;
            } catch (Exception e) {
                m.b(s.d(new byte[]{123, 0, 88, 1, 8, 8, 6, 52, 7, 5, 84, 48, 67, 8, 90, Ascii.SYN}, "7a6eaf"), s.d(new byte[]{Ascii.DC2, Ascii.ETB, 4, Ascii.SYN, 65, 115, 14, 19, 8, 14, 94, 4, 5, 33, Ascii.FS, 41, 92, 122, 0, Ascii.SYN, 13, 7, 69}, "aced57"), e);
            }
        }
        return false;
    }

    public static boolean a(String str, boolean z, int i) {
        if (y8.f5752a == null) {
            m.b(s.d(new byte[]{124, 0, 8, 1, 88, 94, 6, 52, 7, 5, 84, 48, 68, 8, 10, Ascii.SYN}, "0afe10"), s.d(new byte[]{Ascii.DC2, 6, 88, Ascii.ETB, 10, 90, Ascii.NAK, 68, 15, 12, 88, 17, 50, Ascii.ETB, 80, 84, 1, 70, Ascii.DC2}, "ab37d5"));
            return false;
        }
        if (TextUtils.isEmpty(str)) {
            m.b(s.d(new byte[]{46, 83, 95, 80, 90, 13, 6, 52, 7, 5, 84, 48, Ascii.SYN, 91, 93, 71}, "b2143c"), s.d(new byte[]{Ascii.SYN, 70, 13, 66, 88, SignedBytes.MAX_POWER_OF_TWO, 65, 1, 11, Ascii.DC2, 69, Ascii.FS}, "c4ab13"));
            return false;
        }
        try {
            m.a(s.d(new byte[]{46, 3, 11, 84, 89, 12, 6, 52, 7, 5, 84, 48, Ascii.SYN, 11, 9, 67}, "bbe00b"), s.d(new byte[]{16, 17, 92, 88}, "ec0ef0") + str + s.d(new byte[]{Ascii.EM, 66, Ascii.NAK, 68, Ascii.DC2, 9, 14, 19, 50, 13, 65, 39, 84, 16, 8}, "5b5daa") + z + s.d(new byte[]{Ascii.FS, 13, 16, 10, 4, 12, Ascii.NAK, 5, Ascii.DC2, 11, 94, 11, 13}, "0bbcab") + i);
            if (b(str)) {
                m.a(s.d(new byte[]{40, 80, 95, 80, 12, 95, 6, 52, 7, 5, 84, 48, 16, 88, 93, 71}, "d114e1"), s.d(new byte[]{65, Ascii.DC2, 80, 17, Ascii.DC2, 53, 4, 6, 48, 11, 84, Ascii.DC2, 115, 5, 69, 10, 16, 11, Ascii.NAK, Ascii.GS}, "2f1cfb"));
                return b(str, z, i);
            }
            if (a(str)) {
                m.a(s.d(new byte[]{123, 88, 15, 83, 10, 8, 6, 52, 7, 5, 84, 48, 67, 80, 13, 68}, "79a7cf"), s.d(new byte[]{71, Ascii.DC2, 81, 65, 17, 114, Ascii.CAN, 41, 15, 47, 80, Ascii.ETB, 95, 3, 68}, "4f03e0"));
                return d(str);
            }
            m.a(s.d(new byte[]{116, 86, 95, 0, 10, 8, 6, 52, 7, 5, 84, 48, 76, 94, 93, Ascii.ETB}, "871dcf"), s.d(new byte[]{12, 72, 93, 94, 115, 93, 4, Ascii.DC4, 42, 11, 95, 14}, "c88078"));
            return c(str);
        } catch (Exception e) {
            m.b(s.d(new byte[]{124, 81, 90, 80, 12, 95, 6, 52, 7, 5, 84, 48, 68, 89, 88, 71}, "0044e1"), s.d(new byte[]{90, 86, 93, 1, 16, 119, Ascii.EM, 7, 3, Ascii.DC2, 69, 12, 89, 89, 9}, "673e02"), e);
            return false;
        }
    }
}
