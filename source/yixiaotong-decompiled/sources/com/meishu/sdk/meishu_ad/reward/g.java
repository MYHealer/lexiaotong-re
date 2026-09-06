package com.meishu.sdk.meishu_ad.reward;

import android.media.MediaPlayer;
import com.meishu.sdk.R;

/* JADX INFO: compiled from: FullScreenMediaView.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class g extends com.meishu.sdk.core.safe.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FullScreenMediaView f5072a;

    public g(FullScreenMediaView fullScreenMediaView) {
        this.f5072a = fullScreenMediaView;
    }

    @Override // com.meishu.sdk.core.safe.h
    public void a(MediaPlayer mediaPlayer) {
        this.f5072a.d = mediaPlayer;
        mediaPlayer.setVideoScalingMode(1);
        this.f5072a.n = true;
        FullScreenMediaView fullScreenMediaView = this.f5072a;
        if (fullScreenMediaView.p) {
            fullScreenMediaView.e();
        } else {
            fullScreenMediaView.b.b(R.id.ms_controlbar_video_play_button).d(0);
            fullScreenMediaView.b.b(R.id.ms_center_play_button).d(0);
            fullScreenMediaView.b.b(R.id.ms_controlbar_video_pause_button).d(8);
            fullScreenMediaView.c.a(0);
            fullScreenMediaView.c.setmTotalTime(fullScreenMediaView.d.getDuration());
            if (fullScreenMediaView.o.hasMessages(1)) {
                fullScreenMediaView.o.removeMessages(1);
            }
        }
        this.f5072a.c.setVisibility(0);
        this.f5072a.p = false;
        com.meishu.sdk.meishu_ad.nativ.e eVar = this.f5072a.g;
        if (eVar != null) {
            eVar.onVideoLoaded();
        }
    }
}
