package com.hihonor.hianalytics.hnha;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public final class k {
    private static final k d = new k();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private r f3651a;
    private t b;
    private l c;

    private k() {
    }

    public static t a() {
        k kVar = d;
        t tVar = kVar.b;
        if (tVar != null) {
            return tVar;
        }
        synchronized (kVar) {
            t tVar2 = kVar.b;
            if (tVar2 != null) {
                return tVar2;
            }
            t tVar3 = new t();
            kVar.b = tVar3;
            return tVar3;
        }
    }

    public static l b() {
        k kVar = d;
        l lVar = kVar.c;
        if (lVar != null) {
            return lVar;
        }
        synchronized (kVar) {
            l lVar2 = kVar.c;
            if (lVar2 != null) {
                return lVar2;
            }
            l lVar3 = new l();
            kVar.c = lVar3;
            return lVar3;
        }
    }

    public static r c() {
        k kVar = d;
        r rVar = kVar.f3651a;
        if (rVar != null) {
            return rVar;
        }
        synchronized (kVar) {
            r rVar2 = kVar.f3651a;
            if (rVar2 != null) {
                return rVar2;
            }
            r rVar3 = new r();
            kVar.f3651a = rVar3;
            return rVar3;
        }
    }
}
