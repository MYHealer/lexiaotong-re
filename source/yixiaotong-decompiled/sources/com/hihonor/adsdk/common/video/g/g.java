package com.hihonor.adsdk.common.video.g;

import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g implements e {
    private static final String hnadsb = "ProxyVideoCacheManager";
    private com.hihonor.adsdk.common.video.g.j.e hnadsa;

    static /* synthetic */ class a {
    }

    private static class b {
        private static final g hnadsa = new g(null);

        private b() {
        }
    }

    /* synthetic */ g(a aVar) {
        this();
    }

    public static g hnadsa() {
        return b.hnadsa;
    }

    private com.hihonor.adsdk.common.video.g.j.e hnadsc(Context context) {
        return new com.hihonor.adsdk.common.video.g.j.e.b(context).hnadsa(10, com.hihonor.adsdk.common.video.g.a.hnadsb).hnadsa();
    }

    private g() {
    }

    private com.hihonor.adsdk.common.video.g.j.e hnadsb(Context context) {
        if (this.hnadsa == null) {
            this.hnadsa = hnadsc(context);
        }
        return this.hnadsa;
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public boolean hnadsa(Context context) {
        return hnadsb(context) != null;
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public boolean hnadsa(Context context, String str) {
        com.hihonor.adsdk.common.video.g.j.e eVarHnadsb = hnadsb(context);
        if (eVarHnadsb != null) {
            return eVarHnadsb.hnadse(str);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "isPreCached,proxy is null,return", new Object[0]);
        return false;
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public String hnadsc(Context context, String str) {
        com.hihonor.adsdk.common.video.g.j.e eVarHnadsb = hnadsb(context);
        if (eVarHnadsb != null) {
            return eVarHnadsb.hnadsd(str);
        }
        com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "getProxyUrl,proxy is null,return param url", new Object[0]);
        return str;
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public void hnadsb(Context context, String str) {
        com.hihonor.adsdk.common.video.g.j.e eVarHnadsb = hnadsb(context);
        if (eVarHnadsb != null) {
            eVarHnadsb.hnadsg(str);
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsb, "preCache,proxy is null,return", new Object[0]);
        }
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public boolean hnadsa(Context context, String str, String str2) {
        boolean zEquals = str.equals(str2);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "isNeedPlayOnline: " + zEquals, new Object[0]);
        return zEquals;
    }
}
