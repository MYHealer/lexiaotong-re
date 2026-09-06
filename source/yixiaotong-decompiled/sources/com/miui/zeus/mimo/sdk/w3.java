package com.miui.zeus.mimo.sdk;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public interface w3 {
    String getCachedResource(String str, boolean z);

    int getDialogThemeId();

    Bitmap getVideoBitmap();

    boolean isMuted();

    void onClickCloseView();

    void onClicked();

    void onDownloadCancel();

    void onDownloadFailed(int i);

    void onDownloadFinished();

    void onDownloadPaused();

    void onDownloadProgressUpdated(int i);

    void onDownloadStarted();

    void onGetReward(int i);

    void onInstallFailed(int i);

    void onInstallStart();

    void onInstallSuccess();

    boolean onJumpWebView(String str);

    void onPicAdEnd();

    void onVideoComplete();

    void onVideoPause();

    void onVideoResume();

    void onVideoSkip();

    void onVideoStart();

    boolean openAdInfoWebView(long j);
}
