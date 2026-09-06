package com.adprof.sdk;

import com.bykv.vk.component.ttvideo.ILivePlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class ml {
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static int m687a(d dVar) {
        q0 q0Var;
        o1 o1Var;
        if (dVar == null || (q0Var = dVar.f188a) == null || (o1Var = q0Var.f639a) == null) {
            return 2;
        }
        return o1Var.c;
    }

    public static int b(d dVar) {
        q0 q0Var;
        o1 o1Var;
        if (dVar == null || (q0Var = dVar.f188a) == null || (o1Var = q0Var.f639a) == null) {
            return 3;
        }
        return o1Var.d;
    }

    public static double a(d dVar) {
        q0 q0Var;
        o1 o1Var;
        if (dVar == null || (q0Var = dVar.f188a) == null || (o1Var = q0Var.f639a) == null) {
            return 15.0d;
        }
        return o1Var.f1333a;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m688a(d dVar) {
        q0 q0Var;
        o1 o1Var;
        if (dVar == null || (q0Var = dVar.f188a) == null || (o1Var = q0Var.f639a) == null) {
            return false;
        }
        return o1Var.f527d;
    }

    public static void a(c2 c2Var, d dVar) {
        z2 z2Var;
        ul ulVar;
        if (c2Var == null || dVar == null) {
            return;
        }
        try {
            q0 q0Var = dVar.f188a;
            if (q0Var == null || (z2Var = q0Var.f643a) == null || (ulVar = z2Var.f891a) == null) {
                return;
            }
            String str = ulVar.h;
            if (str.isEmpty()) {
                return;
            }
            int i = Integer.parseInt(str);
            c2Var.f154a = i > 0 ? i * 1000 : ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
            pk.d("shake cool interval set to " + c2Var.f154a + "ms (" + i + "s)");
        } catch (Exception e) {
            pk.a(e);
        }
    }
}
