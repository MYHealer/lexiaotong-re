package com.hihonor.adsdk.common.video.g.h;

import android.content.Context;
import com.hihonor.adsdk.common.video.g.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class b implements e, c {
    private static final String hnadsb = "BaseExoPlayerCacheManager";
    private a hnadsa;

    @Override // com.hihonor.adsdk.common.video.g.e
    public boolean hnadsa(Context context) {
        return hnadsb(context) != null;
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public boolean hnadsa(Context context, String str) {
        return false;
    }

    protected abstract a hnadsc(Context context);

    @Override // com.hihonor.adsdk.common.video.g.e
    public String hnadsc(Context context, String str) {
        return str;
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public boolean hnadsa(Context context, String str, String str2) {
        a aVarHnadsb = hnadsb(context);
        boolean z = aVarHnadsb == null || !aVarHnadsb.hnadsb();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "isNeedPlayOnline: " + z, new Object[0]);
        return z;
    }

    protected a hnadsb(Context context) {
        if (this.hnadsa == null) {
            this.hnadsa = hnadsc(context);
        }
        return this.hnadsa;
    }

    @Override // com.hihonor.adsdk.common.video.g.e
    public void hnadsb(Context context, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "preCache...", new Object[0]);
    }
}
