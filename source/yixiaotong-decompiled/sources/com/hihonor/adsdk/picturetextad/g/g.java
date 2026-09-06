package com.hihonor.adsdk.picturetextad.g;

import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends b<com.hihonor.adsdk.picturetextad.h.d> {
    public g(BaseAd baseAd) {
        super(baseAd);
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected com.hihonor.adsdk.picturetextad.h.d a(View view) {
        return new com.hihonor.adsdk.picturetextad.h.g(view);
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int b() {
        return R.layout.honor_ads_video_vertical_001;
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int a() {
        return R.layout.honor_ads_video_vertical_001_download;
    }
}
