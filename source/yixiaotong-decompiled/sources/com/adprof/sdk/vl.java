package com.adprof.sdk;

import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class vl {
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m724a(d dVar) {
        q0 q0Var;
        z2 z2Var;
        return dVar == null || (q0Var = dVar.f188a) == null || (z2Var = q0Var.f643a) == null || z2Var.f891a == null;
    }

    public static boolean b(d dVar) {
        try {
            if (m724a(dVar)) {
                return false;
            }
            String str = ((ul) Objects.requireNonNull(dVar.f188a.f643a.f891a)).c;
            pk.d("DLFailUtil landPageDP=" + str);
            return "open".equalsIgnoreCase(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c(d dVar) {
        try {
            if (m724a(dVar)) {
                return true;
            }
            String str = ((ul) Objects.requireNonNull(dVar.f188a.f643a.f891a)).b;
            pk.d("DLFailUtil dpFail=" + str);
            return "open".equalsIgnoreCase(str);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static ul a(d dVar) {
        q0 q0Var;
        z2 z2Var;
        ul ulVar;
        if (dVar == null || (q0Var = dVar.f188a) == null || (z2Var = q0Var.f643a) == null || (ulVar = z2Var.f891a) == null) {
            return null;
        }
        return ulVar;
    }
}
