package com.miui.zeus.mimo.sdk.ad.reward;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.a2;
import com.miui.zeus.mimo.sdk.b2;
import com.miui.zeus.mimo.sdk.base.BaseAdView;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.z1;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RewardView extends BaseAdView implements z1 {
    private static final String TAG = null;
    public b2 eventListener;
    private boolean isMsaRenderFail;
    public a2 mRewardViewCreateListener;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f5306a;

        public a(Throwable th) {
            this.f5306a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{227, this});
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{226, this});
        }
    }

    static {
        NCall.IV(new Object[]{228});
    }

    public RewardView(Context context) {
        super(context);
        this.isMsaRenderFail = false;
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.c0
    public void destroy() {
        NCall.IV(new Object[]{229, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.z1
    public boolean onBackPressed() {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT), this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClickCloseView() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR), this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClicked() {
        NCall.IV(new Object[]{232, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onGetReward() {
        NCall.IV(new Object[]{233, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onGetReward(int i) {
        NCall.IV(new Object[]{234, this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onPicAdEnd() {
        NCall.IV(new Object[]{235, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoComplete() {
        NCall.IV(new Object[]{236, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoPause() {
        NCall.IV(new Object[]{237, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoSkip() {
        NCall.IV(new Object[]{238, this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onVideoStart() {
        NCall.IV(new Object[]{239, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateFailed(Throwable th) {
        NCall.IV(new Object[]{240, this, th});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateSuccess() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE), this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.z1
    public void setAdInfo(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE), this, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.z1
    public void setRewardVideoAdViewListener(b2 b2Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE), this, b2Var});
    }

    @Override // com.miui.zeus.mimo.sdk.z1
    public void setRewardViewCreateListener(a2 a2Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE), this, a2Var});
    }
}
