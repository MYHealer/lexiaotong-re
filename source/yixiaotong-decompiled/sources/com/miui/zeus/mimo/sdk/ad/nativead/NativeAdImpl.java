package com.miui.zeus.mimo.sdk.ad.nativead;

import android.app.Activity;
import android.view.View;
import com.alibaba.fastjson.asm.Opcodes;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.ADParams;
import com.miui.zeus.mimo.sdk.NativeAd;
import com.miui.zeus.mimo.sdk.NegativeFeedbackCallback;
import com.miui.zeus.mimo.sdk.a7;
import com.miui.zeus.mimo.sdk.base.BaseAdImpl;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.m4;
import com.miui.zeus.mimo.sdk.utils.error.MimoAdError;
import com.miui.zeus.mimo.sdk.y1;
import com.xiaomi.ad.feedback.IAdFeedbackListener;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class NativeAdImpl extends BaseAdImpl implements NativeAdUIController.b {
    public static final String s = null;
    public y1 m;
    public NativeAdUIController n;
    public NativeAd.NativeAdInteractionListener o;
    public long p;
    public boolean q = false;
    public Activity r;

    /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.ad.nativead.NativeAdImpl$1, reason: invalid class name */
    public class AnonymousClass1 extends IAdFeedbackListener.Stub {
        public final /* synthetic */ NegativeFeedbackCallback val$callback;

        /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.ad.nativead.NativeAdImpl$1$a */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f5301a;

            public a(int i) {
                this.f5301a = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                NCall.IV(new Object[]{162, this});
            }
        }

        public AnonymousClass1(NegativeFeedbackCallback negativeFeedbackCallback) {
            this.val$callback = negativeFeedbackCallback;
        }

        @Override // com.xiaomi.ad.feedback.IAdFeedbackListener
        public void onFinished(int i) {
            NCall.IV(new Object[]{161, this, Integer.valueOf(i)});
        }
    }

    static {
        NCall.IV(new Object[]{163});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(long j) {
        NCall.IV(new Object[]{164, this, Long.valueOf(j)});
    }

    public void a(View view, NativeAdViewBinder nativeAdViewBinder, NativeAd.NativeAdInteractionListener nativeAdInteractionListener) {
        NCall.IV(new Object[]{165, this, view, nativeAdViewBinder, nativeAdInteractionListener});
    }

    public void a(ADParams aDParams, y1 y1Var, boolean z) {
        NCall.IV(new Object[]{166, this, aDParams, y1Var, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(MimoAdInfo mimoAdInfo) {
        NCall.IV(new Object[]{167, this, mimoAdInfo});
    }

    public final void a(String str) {
        NCall.IV(new Object[]{Integer.valueOf(Opcodes.JSR), this, str});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void a(boolean z) {
        NCall.IV(new Object[]{Integer.valueOf(Opcodes.RET), this, Boolean.valueOf(z)});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b() {
        NCall.IV(new Object[]{170, this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void b(a7 a7Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE), this, a7Var});
    }

    public void b(MimoAdError mimoAdError, m4 m4Var) {
        NCall.IV(new Object[]{172, this, mimoAdError, m4Var});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public boolean c() {
        return NCall.IZ(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT), this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdImpl
    public void f() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE), this});
    }

    public final void i() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED), this});
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
    public void onAdClick() {
        NCall.IV(new Object[]{176, this});
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
    public void onAdClosed() {
        NCall.IV(new Object[]{177, this});
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
    public void onAdShow() {
        NCall.IV(new Object[]{178, this});
    }

    @Override // com.miui.zeus.mimo.sdk.NativeAd.NativeAdInteractionListener
    public void onRenderFail(int i, String str) {
        NCall.IV(new Object[]{179, this, Integer.valueOf(i), str});
    }
}
