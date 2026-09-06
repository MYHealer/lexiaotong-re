package com.miui.zeus.mimo.sdk.ad.banner;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.b0;
import com.miui.zeus.mimo.sdk.base.BaseAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.c0;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BannerAdView extends BaseAdView implements c0 {
    private static final String TAG = null;
    private boolean isFirstLoad;
    private boolean isMsaRenderFail;
    private boolean isStartBtnDownLoad;
    private b0 mListener;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f5286a;

        public a(Throwable th) {
            this.f5286a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS), this});
        }
    }

    static {
        NCall.IV(new Object[]{311});
    }

    public BannerAdView(Context context) {
        super(context);
        this.isFirstLoad = false;
        this.isStartBtnDownLoad = false;
        this.isMsaRenderFail = false;
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.c0
    public void destroy() {
        NCall.IV(new Object[]{312, this});
    }

    @Override // com.miui.zeus.mimo.sdk.c0
    public float getTranslationX() {
        return NCall.IF(new Object[]{313, this});
    }

    @Override // com.miui.zeus.mimo.sdk.c0
    public boolean isStartBtnDownLoad() {
        return NCall.IZ(new Object[]{314, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClickCloseView() {
        NCall.IV(new Object[]{315, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClicked() {
        NCall.IV(new Object[]{316, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onDownloadCancel() {
        NCall.IV(new Object[]{317, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onDownloadFinished() {
        NCall.IV(new Object[]{318, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onDownloadStarted() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateFailed(Throwable th) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME), this, th});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateSuccess() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD), this});
    }

    @Override // com.miui.zeus.mimo.sdk.c0
    public void setAdInfo(MimoAdInfo mimoAdInfo, boolean z) {
        NCall.IV(new Object[]{322, this, mimoAdInfo, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView
    public void setMute(boolean z) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL), this, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.c0
    public void setTranslationX(float f) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR), this, Float.valueOf(f)});
    }

    @Override // com.miui.zeus.mimo.sdk.c0
    public void setViewListener(b0 b0Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_PLAY_TYPE), this, b0Var});
    }
}
