package com.miui.zeus.mimo.sdk.ad.splash;

import android.content.Context;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.miui.zeus.mimo.sdk.base.BaseAdView;
import com.miui.zeus.mimo.sdk.f3;
import ijiami_1011.NCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SplashAdView extends BaseAdView {
    private boolean isMsaRenderFail;
    private f3 mAdListener;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f5344a;

        public a(Throwable th) {
            this.f5344a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            NCall.IV(new Object[]{350, this});
        }
    }

    public SplashAdView(Context context) {
        super(context);
        this.isMsaRenderFail = false;
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClickCloseView() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL), this});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl, com.miui.zeus.mimo.sdk.w3
    public void onClicked() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER), this});
    }

    @Override // com.miui.zeus.mimo.sdk.base.BaseAdView, com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateFailed(Throwable th) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_200), this, th});
    }

    @Override // com.miui.zeus.mimo.sdk.common.CommonEventImpl
    public void onViewCreateSuccess() {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300), this});
    }

    public void setSplashInteractionListener(f3 f3Var) {
        NCall.IV(new Object[]{Integer.valueOf(MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_400), this, f3Var});
    }
}
