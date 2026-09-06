package com.oplus.stdid.sdk;

import android.content.Context;
import android.os.Looper;
import android.util.Log;
import com.fancy.adsdk.lib.constants.BiddingConst;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f5844a;
    public static boolean b;
    public static boolean c;
    public static Context d;

    public static String a(int i, String str) {
        HashMap<String, String> mapA;
        if (!f5844a) {
            Log.e("IDHelper", "1001");
            return "";
        }
        if (!c) {
            mapA = s_a.s_a.s_a.c.d.a(i);
        } else {
            if (!b()) {
                return "";
            }
            mapA = a(i);
        }
        return mapA.get(str) == null ? "" : mapA.get(str);
    }

    public static HashMap<String, String> a(int i) {
        int iA = s_a.s_a.s_a.c.a.a(i);
        if (iA != 10000) {
            throw new RuntimeException(iA + "");
        }
        return b.a.f5841a.a(d, s_a.s_a.s_a.c.a.b(i));
    }

    public static boolean a() {
        if (!f5844a) {
            Log.e("IDHelper", "1001");
            return false;
        }
        if (c) {
            return b;
        }
        if (!s_a.s_a.s_a.c.d.f9753a) {
            Log.e("IDHelper", "1001");
        }
        return s_a.s_a.s_a.c.d.b || s_a.s_a.s_a.c.d.c;
    }

    public static boolean b() {
        String str;
        if (!b) {
            str = BiddingConst.BIDDING_LOSS.WITH_LOW_PRICE_IN_HB;
        } else {
            if (Looper.myLooper() != Looper.getMainLooper()) {
                return true;
            }
            str = BiddingConst.BIDDING_LOSS.WITH_BIDDING_TIMEOUT;
        }
        Log.e("IDHelper", str);
        return false;
    }
}
