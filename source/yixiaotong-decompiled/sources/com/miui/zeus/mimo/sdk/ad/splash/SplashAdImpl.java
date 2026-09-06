package com.miui.zeus.mimo.sdk.ad.splash;

import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.SplashAd;
import com.miui.zeus.mimo.sdk.a7;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.f3;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class SplashAdImpl extends BaseAdImpl implements f3 {
    public static final String t = null;
    public SplashAdUIController n;
    public ViewGroup o;
    public SplashAd.SplashAdLoadListener p;
    public SplashAd.SplashAdInteractionListener q;
    public long r;
    public boolean m = false;
    public Runnable s = new a();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT), this});
        }
    }

    public class b implements SplashAd.SplashAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SplashAd.SplashAdListener f5340a;
        public final /* synthetic */ ViewGroup b;

        public class a implements SplashAd.SplashAdInteractionListener {
            public a() {
            }

            @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
            public void onAdClick() {
                NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME), this});
            }

            @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
            public void onAdDismissed() {
                NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD), this});
            }

            @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
            public void onAdRenderFailed(int i, String str) {
                NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC), this, Integer.valueOf(i), str});
            }

            @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
            public void onAdShow() {
                NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF), this});
            }
        }

        public b(SplashAd.SplashAdListener splashAdListener, ViewGroup viewGroup) {
            this.f5340a = splashAdListener;
            this.b = viewGroup;
        }

        @Override // com.miui.zeus.mimo.sdk.SplashAd.BaseAdLoadListener
        public void onAdLoadFailed(int i, String str) {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY), this, Integer.valueOf(i), str});
        }

        @Override // com.miui.zeus.mimo.sdk.SplashAd.BaseAdLoadListener
        public void onAdLoaded() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY), this});
        }

        @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdLoadListener
        public void onAdRequestSuccess() {
            NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE), this});
        }
    }

    static {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS)});
    }

    public SplashAdImpl() {
        this.d = true;
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(long j) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY), this, Long.valueOf(j)});
    }

    public void a(ViewGroup viewGroup, ADParams aDParams, SplashAd.SplashAdListener splashAdListener) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT), this, viewGroup, aDParams, splashAdListener});
    }

    public void a(ViewGroup viewGroup, SplashAd.SplashAdInteractionListener splashAdInteractionListener) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU), this, viewGroup, splashAdInteractionListener});
    }

    public void a(ADParams aDParams, SplashAd.SplashAdLoadListener splashAdLoadListener) {
        NCall.IV(new Object[]{357, this, aDParams, splashAdLoadListener});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP), this, mimoAdInfo});
    }

    @Override // com.miui.zeus.mimo.sdk.f3
    public void a(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT), this, mimoAdError, m4Var});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(boolean z) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL), this, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL), this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b(a7 a7Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD), this, a7Var});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void e() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD), this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void f() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void g() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void h() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdClick() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME), this});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdDismissed() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION), this});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdRenderFailed(int i, String str) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD), this, Integer.valueOf(i), str});
    }

    @Override // com.miui.zeus.mimo.sdk.SplashAd.SplashAdInteractionListener
    public void onAdShow() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT), this});
    }
}
