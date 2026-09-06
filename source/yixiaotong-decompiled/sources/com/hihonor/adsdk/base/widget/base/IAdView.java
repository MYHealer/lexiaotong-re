package com.hihonor.adsdk.base.widget.base;

import com.hihonor.adsdk.base.callback.DislikeItemClickListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface IAdView {
    void release();

    void setAdCloseView(AdFlagCloseView adFlagCloseView);

    void setDislikeItemClickListener(DislikeItemClickListener dislikeItemClickListener);
}
