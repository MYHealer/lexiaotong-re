package com.miui.zeus.mimo.sdk.common;

import android.content.Context;
import android.graphics.Bitmap;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.huawei.openalliance.ad.constant.ai;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.r3;
import com.miui.zeus.mimo.sdk.w3;
import ijiami_1011.NCall;
import java.io.File;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CommonEventImpl implements w3 {
    public MimoAdInfo mAdInfo;
    public Context mContext;
    public r3 mDownloadListener;
    public Bitmap mVideoBitmap;

    public CommonEventImpl(Context context) {
        this.mContext = context;
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public String getCachedResource(String str, boolean z) {
        return (String) NCall.IL(new Object[]{426, this, str, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public int getDialogThemeId() {
        return NCall.II(new Object[]{427, this});
    }

    @Deprecated
    public File getHttpVideoCacheFile(String str) {
        return (File) NCall.IL(new Object[]{428, this, str});
    }

    @Deprecated
    public String getHttpVideoProxyUrl(String str, boolean z) {
        return (String) NCall.IL(new Object[]{429, this, str, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public Bitmap getVideoBitmap() {
        return (Bitmap) NCall.IL(new Object[]{430, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public boolean isMuted() {
        return NCall.IZ(new Object[]{431, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onClickCloseView() {
        NCall.IV(new Object[]{Integer.valueOf(ai.s), this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onClicked() {
        NCall.IV(new Object[]{433, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onDownloadCancel() {
        NCall.IV(new Object[]{434, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onDownloadFailed(int i) {
        NCall.IV(new Object[]{435, this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onDownloadFinished() {
        NCall.IV(new Object[]{436, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onDownloadPaused() {
        NCall.IV(new Object[]{437, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onDownloadProgressUpdated(int i) {
        NCall.IV(new Object[]{438, this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onDownloadStarted() {
        NCall.IV(new Object[]{439, this});
    }

    public void onGetReward() {
        NCall.IV(new Object[]{440, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onGetReward(int i) {
        NCall.IV(new Object[]{441, this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onInstallFailed(int i) {
        NCall.IV(new Object[]{Integer.valueOf(ai.t), this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onInstallStart() {
        NCall.IV(new Object[]{443, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onInstallSuccess() {
        NCall.IV(new Object[]{444, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public boolean onJumpWebView(String str) {
        return NCall.IZ(new Object[]{445, this, str});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onPicAdEnd() {
        NCall.IV(new Object[]{446, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onVideoComplete() {
        NCall.IV(new Object[]{447, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onVideoPause() {
        NCall.IV(new Object[]{448, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onVideoResume() {
        NCall.IV(new Object[]{449, this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onVideoSkip() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public void onVideoStart() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME), this});
    }

    public void onViewCreateFailed(Throwable th) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME), this, th});
    }

    public void onViewCreateSuccess() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.w3
    public boolean openAdInfoWebView(long j) {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME), this, Long.valueOf(j)});
    }

    public void setAdInfo(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME), this, mimoAdInfo});
    }

    public void setDownloadListener(r3 r3Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME), this, r3Var});
    }

    public void setVideoBitmap(Bitmap bitmap) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME), this, bitmap});
    }
}
