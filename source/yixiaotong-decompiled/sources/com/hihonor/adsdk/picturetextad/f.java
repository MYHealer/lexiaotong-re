package com.hihonor.adsdk.picturetextad;

import android.content.Context;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.api.BaseAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f3545a = "PictureTextAdViewFactory";

    public static PictureTextAdView a(Context context, BaseAd baseAd) {
        PictureTextAdView pictureTextAdView = new PictureTextAdView(context);
        pictureTextAdView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        pictureTextAdView.setAd(baseAd);
        return pictureTextAdView;
    }
}
