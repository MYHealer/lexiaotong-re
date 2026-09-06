package com.miui.zeus.mimo.sdk.ad.splash;

import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.common.ViewMeasureHelper;
import com.miui.zeus.mimo.sdk.f3;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.r3;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SplashAdUIController implements f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ViewGroup f5342a;
    public MimoAdInfo b;
    public f3 c;
    public r3 d;
    public String e;
    public String f;
    public SplashAdView g;
    public ViewMeasureHelper h;
    public boolean i = true;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5343a;

        public a(View view) {
            this.f5343a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED), this});
        }
    }

    @Override // com.miui.zeus.mimo.sdk.f3
    public void a(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND), this, mimoAdError, m4Var});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdClick() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI), this});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdDismissed() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_SWITCH), this});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdRenderFailed(int i, String str) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS), this, Integer.valueOf(i), str});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdShow() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS), this});
    }
}
