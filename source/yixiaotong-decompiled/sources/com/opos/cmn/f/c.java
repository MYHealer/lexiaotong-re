package com.opos.cmn.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f6059a;

    public static b a() {
        b aVar;
        b bVar = f6059a;
        if (bVar != null) {
            return bVar;
        }
        synchronized (c.class) {
            aVar = f6059a;
            if (aVar == null) {
                aVar = new a();
                f6059a = aVar;
            }
        }
        return aVar;
    }

    public static String b() {
        return "";
    }
}
