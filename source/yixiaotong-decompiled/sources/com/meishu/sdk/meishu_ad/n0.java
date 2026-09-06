package com.meishu.sdk.meishu_ad;

import android.view.View;
import android.view.ViewParent;

/* JADX INFO: compiled from: MediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface n0 {

    /* JADX INFO: compiled from: MediaView.java */
    public interface a {
        void onCompleted();
    }

    /* JADX INFO: compiled from: MediaView.java */
    public interface b {
        void onKeepTimeFinished();
    }

    /* JADX INFO: compiled from: MediaView.java */
    public interface c {
        void onLoaded(n0 n0Var);
    }

    void a(a aVar);

    void a(b bVar, long j);

    boolean a();

    ViewParent getParent();

    View getVideoView();

    void mute();

    void pause();

    void replay();

    void resume();

    void setNativeAdMediaListener(com.meishu.sdk.meishu_ad.nativ.e eVar);

    void setVideoPath(String str);

    void start();

    void unmute();
}
