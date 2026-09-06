package com.hihonor.adsdk.picturetextad.g;

import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends b<com.hihonor.adsdk.picturetextad.h.d> {
    public e(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected com.hihonor.adsdk.picturetextad.h.d a(View view) {
        return new com.hihonor.adsdk.picturetextad.h.e(view);
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int b() {
        return R.layout.honor_ads_picture_small_001;
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int a() {
        return R.layout.honor_ads_picture_small_001_download;
    }
}
