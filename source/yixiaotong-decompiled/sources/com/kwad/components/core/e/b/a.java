package com.kwad.components.core.e.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.core.e.b.a$a, reason: collision with other inner class name */
    static class C0658a {
        private static final c Qs = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    private static c pC() {
        return C0658a.Qs;
    }

    public static String B(long j) {
        String strC = pC().C(j);
        return strC.endsWith("=") ? strC.replace("=", "") : strC;
    }

    public static long am(String str) {
        return pC().an(str);
    }
}
