package com.hihonor.adsdk.picturetextad.g;

import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends b<com.hihonor.adsdk.picturetextad.h.b> {
    public c(BaseAd baseAd) {
        super(baseAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.picturetextad.g.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.hihonor.adsdk.picturetextad.h.b a(View view) {
        return new com.hihonor.adsdk.picturetextad.h.b(view);
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int a() {
        return R.layout.honor_ads_picture_big_001_download;
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int b() {
        return R.layout.honor_ads_picture_big_001;
    }
}
