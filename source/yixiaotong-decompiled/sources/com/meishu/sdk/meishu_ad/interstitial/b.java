package com.meishu.sdk.meishu_ad.interstitial;

import com.meishu.sdk.core.ad.BaseAdSlot;

/* JADX INFO: compiled from: InterstitialAdSlot.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b extends BaseAdSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5021a;

    /* JADX INFO: compiled from: InterstitialAdSlot.java */
    public class a extends BaseAdSlot.Builder<a, b> {
        public a() {
            super();
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot build() {
            return b.this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder returnThis() {
            return this;
        }

        @Override // com.meishu.sdk.core.ad.BaseAdSlot.Builder
        public BaseAdSlot.Builder setTitle(String str) {
            b.this.f5021a = str;
            return this;
        }
    }

    @Override // com.meishu.sdk.core.ad.BaseAdSlot
    public String getTitle() {
        return this.f5021a;
    }
}
