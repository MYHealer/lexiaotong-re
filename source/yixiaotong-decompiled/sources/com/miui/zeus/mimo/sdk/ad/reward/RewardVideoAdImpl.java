package com.miui.zeus.mimo.sdk.ad.reward;

import android.app.Activity;
import android.content.Intent;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.RewardVideoAd;
import com.miui.zeus.mimo.sdk.a7;
import com.miui.zeus.mimo.sdk.b2;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class RewardVideoAdImpl extends BaseAdImpl implements b2 {
    public static final String r = null;
    public static long s;
    public RewardVideoAd.RewardVideoLoadListener m;
    public Intent n;
    public RewardVideoAd.RewardVideoInteractionListener o;
    public long p;
    public String q;

    static {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT)});
    }

    public final void a(Activity activity, String str, boolean z) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE), this, activity, str, Boolean.valueOf(z)});
    }

    public void a(ADParams aDParams, RewardVideoAd.RewardVideoLoadListener rewardVideoLoadListener) {
        NCall.IV(new Object[]{255, this, aDParams, rewardVideoLoadListener});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{256, this, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public int b(MimoAdInfo mimoAdInfo) {
        return NCall.II(new Object[]{257, this, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b(a7 a7Var) {
        NCall.IV(new Object[]{258, this, a7Var});
    }

    @Override // com.miui.zeus.mimo.sdk.b2
    public void c(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{259, this, mimoAdError, m4Var});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public boolean c() {
        return NCall.IZ(new Object[]{260, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public boolean d() {
        return NCall.IZ(new Object[]{261, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void e() {
        NCall.IV(new Object[]{262, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void f() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE), this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdClick() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdDismissed() {
        NCall.IV(new Object[]{265, this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdFailed(String str) {
        NCall.IV(new Object[]{266, this, str});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onAdPresent() {
        NCall.IV(new Object[]{267, this});
    }

    @Override // com.miui.zeus.mimo.sdk.b2
    public void onGetReward(int i) {
        NCall.IV(new Object[]{268, this, Integer.valueOf(i)});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onPicAdEnd() {
        NCall.IV(new Object[]{269, this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onReward() {
        NCall.IV(new Object[]{270, this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoComplete() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoPause() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoSkip() {
        NCall.IV(new Object[]{273, this});
    }

    @Override // com.miui.zeus.mimo.sdk.RewardVideoAd.RewardVideoInteractionListener
    public void onVideoStart() {
        NCall.IV(new Object[]{274, this});
    }
}
