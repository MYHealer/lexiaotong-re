package com.hihonor.adsdk.base.api;

import android.view.View;
import android.widget.ImageView;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.common.video.OnVideoPlayListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface AdVideo {
    int getAutoPlay();

    int getPlayerState();

    View getPureVideoView();

    View getPureVideoView(AdVideoSize adVideoSize);

    View getVideoView();

    View getVideoView(AdVideoSize adVideoSize);

    boolean isMuted();

    void pause();

    void releasePlayer();

    void replay();

    void resume();

    void setMuted(boolean z);

    void setVideoCoverScaleType(ImageView.ScaleType scaleType);

    void setVideoListener(OnVideoPlayListener onVideoPlayListener);

    void start();

    void start(boolean z);
}
