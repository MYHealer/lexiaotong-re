package com.hihonor.adsdk.common.video.g;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b {
    private static final String hnadsb = "CacheFactory";
    private e hnadsa;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.video.g.b$b, reason: collision with other inner class name */
    private static class C0465b {
        private static final b hnadsa = new b(null);

        private C0465b() {
        }
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    public static b hnadsa() {
        return C0465b.hnadsa;
    }

    public void hnadsc() {
        int iHnadsb = com.hihonor.adsdk.common.video.h.c.hnadsb();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "initCacheManager,playerType: " + iHnadsb, new Object[0]);
        if (iHnadsb == 2) {
            this.hnadsa = com.hihonor.adsdk.common.video.g.h.e.c.hnadsa();
        } else if (iHnadsb == 3) {
            this.hnadsa = com.hihonor.adsdk.common.video.g.h.d.c.hnadsa();
        } else {
            this.hnadsa = g.hnadsa();
        }
    }

    private b() {
    }

    public e hnadsb() {
        if (this.hnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "getCacheManager,initCacheManager", new Object[0]);
            hnadsc();
        }
        return this.hnadsa;
    }
}
