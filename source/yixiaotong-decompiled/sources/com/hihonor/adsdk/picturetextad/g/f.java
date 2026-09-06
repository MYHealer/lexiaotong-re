package com.hihonor.adsdk.picturetextad.g;

import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends b<com.hihonor.adsdk.picturetextad.h.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3546a = "ThreePictureAdapter";

    public f(BaseAd baseAd) {
        super(baseAd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.hihonor.adsdk.picturetextad.g.b
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.hihonor.adsdk.picturetextad.h.f a(View view) {
        return new com.hihonor.adsdk.picturetextad.h.f(view);
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int a() {
        return R.layout.honor_ads_picture_three_002_download;
    }

    @Override // com.hihonor.adsdk.picturetextad.g.b
    protected int b() {
        return R.layout.honor_ads_picture_three_002;
    }
}
