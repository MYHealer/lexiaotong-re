package com.meishu.sdk.meishu_ad.splash;

import com.meishu.sdk.core.ad.BaseAdSlot;

/* JADX INFO: compiled from: SplashAdSlot.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends com.meishu.sdk.meishu_ad.nativ.f {
    public int E = 3;
    public int F;
    public int G;
    public int H;

    /* JADX INFO: compiled from: SplashAdSlot.java */
    public class a extends BaseAdSlot.Builder<a, d> {
        public a() {
            super();
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot build() {
            return d.this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder returnThis() {
            return this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setPowerIndex(int i) {
            d.this.F = i;
            return this;
        }
    }

    @Override // com.meishu.sdk.core.ad.BaseAdSlot
    public int getClk_type() {
        return this.E;
    }

    @Override // com.meishu.sdk.core.ad.BaseAdSlot
    public int getPower_index() {
        return this.F;
    }
}
