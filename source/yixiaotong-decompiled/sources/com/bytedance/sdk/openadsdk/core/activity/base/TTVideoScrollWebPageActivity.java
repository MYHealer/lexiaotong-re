package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.byazt.dh.ve;
import com.byazt.ff.TTScrollView;
import com.byazt.nr.m;
import com.byazt.un.uj;
import com.byazt.vfu.a;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView bx;

    static {
        StubApp.interface11(23291);
    }

    @Override // com.byazt.cty.BaseLandingPageActivity, com.byazt.cty.BaseThemeActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity$1, reason: invalid class name */
    @c(c = {0, 80, 81, 82, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY, 717})
    public class AnonymousClass1 implements TTScrollView.c {
        public AnonymousClass1() {
        }

        @Override // com.byazt.ff.TTScrollView.c
        public void c(boolean z) {
            try {
                if (TTVideoScrollWebPageActivity.this.pf != null && (TTVideoScrollWebPageActivity.this.pf instanceof uj)) {
                    if (z && !TTVideoScrollWebPageActivity.this.pf.gt()) {
                        ((uj) TTVideoScrollWebPageActivity.this.pf).a(false);
                    } else {
                        TTVideoScrollWebPageActivity.this.pf.a();
                    }
                }
            } catch (Throwable th) {
                m.ve("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity$2, reason: invalid class name */
    @c(c = {0, 80, 81, 82, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE, MediaPlayer.MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF, MediaPlayer.MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY, 718})
    public class AnonymousClass2 implements ve.InterfaceC0133ve {
        @Override // com.byazt.dh.ve.InterfaceC0133ve
        public void onProgressUpdate(long j, long j2) {
        }

        @Override // com.byazt.dh.ve.InterfaceC0133ve
        public void onVideoAdContinuePlay() {
        }

        @Override // com.byazt.dh.ve.InterfaceC0133ve
        public void onVideoAdPaused() {
        }

        @Override // com.byazt.dh.ve.InterfaceC0133ve
        public void onVideoComplete() {
        }

        public AnonymousClass2() {
        }

        @Override // com.byazt.dh.ve.InterfaceC0133ve
        public void onVideoAdStartPlay() {
            if (TTVideoScrollWebPageActivity.this.bx == null || TTVideoScrollWebPageActivity.this.bx.c() || TTVideoScrollWebPageActivity.this.pf == null) {
                return;
            }
            TTVideoScrollWebPageActivity.this.pf.sp();
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(a.pf(this));
    }
}
