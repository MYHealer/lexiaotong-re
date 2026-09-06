package com.yfanads.android.adx.player.yfplayer;

import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface IVideoPlayListener {
    void onAdClicked(View view);

    void onAdShow();

    void onVideoPlayComplete();

    void onVideoPlayError(int i, int i2);

    void onVideoPlayStart();

    void onVideoProgress(int i);
}
