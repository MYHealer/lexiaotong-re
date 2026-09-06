package com.adprof.sdk;

import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public abstract class s4 {
    public static int a(d dVar) {
        try {
            int i = Integer.parseInt(((ul) Objects.requireNonNull(dVar.f188a.f643a.f891a)).l);
            if (i <= 0) {
                return 120;
            }
            return i;
        } catch (Exception unused) {
            return 120;
        }
    }

    public static HashMap a(HashMap map) {
        return new HashMap();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m714a(d dVar) {
        try {
            int i = Integer.parseInt(((ul) Objects.requireNonNull(dVar.f188a.f643a.f891a)).l);
            pk.d("bannerutil  RefreshSeconds = " + i);
            return i > 0;
        } catch (Exception e) {
            pk.a(e);
            return false;
        }
    }
}
