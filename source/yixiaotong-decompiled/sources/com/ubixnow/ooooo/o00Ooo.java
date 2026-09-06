package com.ubixnow.ooooo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.adtype.nativead.api.UMNNativeApkDownloadListener;
import com.ubixnow.adtype.nativead.api.UMNNativeEventListener;
import com.ubixnow.adtype.nativead.api.UMNNativeMediaListener;
import com.ubixnow.adtype.nativead.api.UMNNativeStatusListener;
import com.ubixnow.core.bean.UMNNativeExtraInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class o00Ooo extends o00oOoo {
    public static final String VIDEO_TYPE = "1";
    public UMNNativeApkDownloadListener apkDownloadListener;
    private UMNNativeEventListener mNativeEventListener;
    private UMNNativeMediaListener mNativeMediaListener;
    public final String TAG = "----o00Ooo";
    public final String IMAGE_TYPE = "2";
    public final String UNKNOW_TYPE = "0";
    public String mAdSourceType = "0";

    public void apkDownloadFailed() {
        UMNNativeApkDownloadListener uMNNativeApkDownloadListener = this.apkDownloadListener;
        if (uMNNativeApkDownloadListener != null) {
            uMNNativeApkDownloadListener.onDownloadFailed();
        }
    }

    public void apkDownloadFinished() {
        UMNNativeApkDownloadListener uMNNativeApkDownloadListener = this.apkDownloadListener;
        if (uMNNativeApkDownloadListener != null) {
            uMNNativeApkDownloadListener.onDownloadFinished();
        }
    }

    public void apkDownloadIdle() {
    }

    public void apkDownloadPaused(int i) {
        UMNNativeApkDownloadListener uMNNativeApkDownloadListener = this.apkDownloadListener;
        if (uMNNativeApkDownloadListener != null) {
            uMNNativeApkDownloadListener.onPaused(i);
        }
    }

    public void apkDownloadProgressUpdate(int i) {
        UMNNativeApkDownloadListener uMNNativeApkDownloadListener = this.apkDownloadListener;
        if (uMNNativeApkDownloadListener != null) {
            uMNNativeApkDownloadListener.onProgressUpdate(i);
        }
    }

    public void apkInstall() {
    }

    public abstract void bindDislikeListener(View.OnClickListener onClickListener);

    public abstract void clear(View view);

    public abstract View getAdIconView();

    public abstract View getAdMediaView(Object... objArr);

    public String getAdType() {
        return this.mAdSourceType;
    }

    public abstract ViewGroup getCustomAdContainer();

    public abstract boolean isNativeExpress();

    public final void notifyAdClicked() {
        UMNNativeEventListener uMNNativeEventListener = this.mNativeEventListener;
        if (uMNNativeEventListener != null) {
            uMNNativeEventListener.onAdClicked();
        }
    }

    public final void notifyAdDislikeClick() {
        UMNNativeEventListener uMNNativeEventListener = this.mNativeEventListener;
        if (uMNNativeEventListener != null) {
            uMNNativeEventListener.onAdClose();
        }
    }

    public final void notifyAdExposure() {
        UMNNativeEventListener uMNNativeEventListener = this.mNativeEventListener;
        if (uMNNativeEventListener != null) {
            uMNNativeEventListener.onAdExposure();
        }
    }

    public final void notifyAdStatusChanged() {
        try {
            UMNNativeEventListener uMNNativeEventListener = this.mNativeEventListener;
            if (uMNNativeEventListener == null || !(uMNNativeEventListener instanceof UMNNativeStatusListener)) {
                return;
            }
            ((UMNNativeStatusListener) uMNNativeEventListener).onAdStatusChanged();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public final void notifyAdVideoEnd() {
        UMNNativeMediaListener uMNNativeMediaListener = this.mNativeMediaListener;
        if (uMNNativeMediaListener != null) {
            uMNNativeMediaListener.onVideoEnd();
        }
    }

    public final void notifyAdVideoError() {
        UMNNativeMediaListener uMNNativeMediaListener = this.mNativeMediaListener;
        if (uMNNativeMediaListener != null) {
            uMNNativeMediaListener.onVideoError();
        }
    }

    public final void notifyAdVideoStart() {
        UMNNativeMediaListener uMNNativeMediaListener = this.mNativeMediaListener;
        if (uMNNativeMediaListener != null) {
            uMNNativeMediaListener.onVideoStart();
        }
    }

    public final void notifyDownloadConfirm(Context context, View view) {
    }

    public abstract void onPause();

    public abstract void onResume();

    public abstract void pauseVideo();

    public abstract void regist(ViewGroup viewGroup, UMNNativeExtraInfo uMNNativeExtraInfo);

    public abstract void resumeVideo();

    public void setAdType(String str) {
        this.mAdSourceType = str;
    }

    public void setApkDownloadListener(UMNNativeApkDownloadListener uMNNativeApkDownloadListener) {
        this.apkDownloadListener = uMNNativeApkDownloadListener;
    }

    public void setNativeEventListener(UMNNativeEventListener uMNNativeEventListener) {
        this.mNativeEventListener = uMNNativeEventListener;
    }

    public void setNativeMediaListener(UMNNativeMediaListener uMNNativeMediaListener) {
        this.mNativeMediaListener = uMNNativeMediaListener;
    }

    public void setNativeStatusListener(UMNNativeEventListener uMNNativeEventListener) {
        this.mNativeEventListener = uMNNativeEventListener;
    }

    public abstract void setVideoMute(boolean z);

    public abstract void startVideo();

    public abstract void stopVideo();
}
