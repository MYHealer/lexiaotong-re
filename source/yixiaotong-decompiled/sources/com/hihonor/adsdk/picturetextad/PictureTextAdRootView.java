package com.hihonor.adsdk.picturetextad;

import android.content.Context;
import android.util.AttributeSet;
import com.hihonor.adsdk.base.api.feed.PictureTextExpressAd;
import com.hihonor.adsdk.base.widget.base.AdRootView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class PictureTextAdRootView extends AdRootView<PictureTextExpressAdImpl> {
    public PictureTextAdRootView(Context context) {
        super(context);
    }

    public void setAd(PictureTextExpressAd pictureTextExpressAd) {
        if (pictureTextExpressAd instanceof PictureTextExpressAdImpl) {
            bindAd((PictureTextExpressAdImpl) pictureTextExpressAd);
            requestLayout();
        }
    }

    public PictureTextAdRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
