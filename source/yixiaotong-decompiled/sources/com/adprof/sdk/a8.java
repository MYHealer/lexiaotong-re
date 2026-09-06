package com.adprof.sdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class a8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1027a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Object f12a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static volatile String f13a = "";

    public static String a() {
        String strA = sl.a("o_aid_encrypt");
        return !TextUtils.isEmpty(strA) ? a.a(strA, "adprof_private_a") : "";
    }

    public static String a(Context context, eb ebVar) {
        try {
            if (TextUtils.isEmpty(f13a) || f13a.startsWith("00000")) {
                String strA = a();
                if (TextUtils.isEmpty(strA)) {
                    synchronized (f12a) {
                        if (System.currentTimeMillis() - f1027a > com.kuaishou.weapon.p0.bg.s) {
                            f1027a = System.currentTimeMillis();
                            y7.a(context, new z7(ebVar));
                        }
                    }
                } else {
                    f13a = strA;
                    ((fe) ebVar).a(f13a);
                }
            } else {
                ((fe) ebVar).a(f13a);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f13a;
    }
}
