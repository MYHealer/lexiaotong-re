package com.meishu.sdk.platform.ks.draw;

import com.meishu.sdk.core.ad.draw.DrawAd;
import com.meishu.sdk.core.loader.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSDrawAd extends DrawAd {
    public KSDrawAd(d dVar) {
        super(dVar, "KS");
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void destroy() {
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public int getDrawType() {
        return 2;
    }
}
