package com.meishu.sdk.meishu_ad.reward;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.meishu.sdk.R;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.meishu_ad.n0;
import com.meishu.sdk.meishu_ad.view.MeishuVideoTextureView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class FullScreenMediaView extends FrameLayout implements n0 {
    public static final /* synthetic */ int r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MeishuVideoTextureView f5065a;
    public com.meishu.sdk.core.bquery.i b;
    public CircleProcessBar c;
    public MediaPlayer d;
    public n0.b e;
    public long f;
    public com.meishu.sdk.meishu_ad.nativ.e g;
    public com.meishu.sdk.meishu_ad.nativ.a h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public Handler o;
    public boolean p;
    public List<n0.a> q;

    public class a extends com.meishu.sdk.core.safe.c {
        public a(Looper looper) {
            super(looper);
        }

        @Override // com.meishu.sdk.core.safe.c
        public void a(Message message) {
            super.a(message);
            int currentPosition = FullScreenMediaView.this.f5065a.getCurrentPosition();
            FullScreenMediaView.this.c.a(currentPosition);
            FullScreenMediaView fullScreenMediaView = FullScreenMediaView.this;
            long j = fullScreenMediaView.f;
            if (j > 0 && currentPosition >= j && !fullScreenMediaView.i) {
                fullScreenMediaView.i = true;
                n0.b bVar = FullScreenMediaView.this.e;
                if (bVar != null) {
                    bVar.onKeepTimeFinished();
                }
            }
            double duration = ((double) currentPosition) / ((double) FullScreenMediaView.this.f5065a.getDuration());
            if (duration >= 0.25d && duration < 0.5d) {
                FullScreenMediaView fullScreenMediaView2 = FullScreenMediaView.this;
                if (!fullScreenMediaView2.j) {
                    com.meishu.sdk.meishu_ad.nativ.e eVar = fullScreenMediaView2.g;
                    if (eVar != null) {
                        eVar.onVideoOneQuarter();
                    }
                    FullScreenMediaView.this.j = true;
                }
            } else if (duration >= 0.5d && duration < 0.75d) {
                FullScreenMediaView fullScreenMediaView3 = FullScreenMediaView.this;
                if (!fullScreenMediaView3.k) {
                    com.meishu.sdk.meishu_ad.nativ.e eVar2 = fullScreenMediaView3.g;
                    if (eVar2 != null) {
                        eVar2.onVideoOneHalf();
                    }
                    FullScreenMediaView.this.k = true;
                }
            } else if (duration >= 0.75d && duration < 1.0d) {
                FullScreenMediaView fullScreenMediaView4 = FullScreenMediaView.this;
                if (!fullScreenMediaView4.l) {
                    com.meishu.sdk.meishu_ad.nativ.e eVar3 = fullScreenMediaView4.g;
                    if (eVar3 != null) {
                        eVar3.onVideoThreeQuarter();
                    }
                    FullScreenMediaView.this.l = true;
                }
            }
            FullScreenMediaView.this.o.sendEmptyMessageDelayed(1, 100L);
        }
    }

    public FullScreenMediaView(Context context) {
        super(context);
        this.f = -1L;
        this.m = false;
        this.n = false;
        this.o = new a(Looper.getMainLooper());
        this.q = new ArrayList();
        a(context);
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void a(n0.b bVar, long j) {
        this.e = bVar;
        if (j > 0) {
            this.f = j;
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public View getVideoView() {
        return this;
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void mute() {
        b();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        LogUtil.d("FullScreenMediaView", "onDetachedFromWindow: ");
        super.onDetachedFromWindow();
        Handler handler = this.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void pause() {
        this.f5065a.c();
        d();
        com.meishu.sdk.meishu_ad.nativ.e eVar = this.g;
        if (eVar != null) {
            eVar.onVideoPause();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void resume() {
        this.f5065a.e();
        e();
        com.meishu.sdk.meishu_ad.nativ.e eVar = this.g;
        if (eVar != null) {
            eVar.onVideoResume();
        }
    }

    public void setAdListener(com.meishu.sdk.meishu_ad.nativ.a aVar) {
        this.h = aVar;
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void setNativeAdMediaListener(com.meishu.sdk.meishu_ad.nativ.e eVar) {
        this.g = eVar;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.f5065a.setOnInfoListener(onInfoListener);
    }

    public void setOnVideoLoadedListener(n0.c cVar) {
    }

    public void setVideoCover(String str) {
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void setVideoPath(String str) {
        this.f5065a.setVideoPath(str);
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void start() {
        this.f5065a.e();
        e();
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void unmute() {
        c();
    }

    public final void d() {
        this.b.b(R.id.ms_controlbar_video_play_button).d(0);
        this.b.b(R.id.ms_center_play_button).d(0);
        this.b.b(R.id.ms_controlbar_video_pause_button).d(8);
        if (this.o.hasMessages(1)) {
            this.o.removeMessages(1);
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void replay() {
        if (this.p) {
            return;
        }
        start();
    }

    public final void b() {
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(0.0f, 0.0f);
            this.b.b(R.id.ms_video_volume_mute).d(0);
            this.b.b(R.id.ms_video_volume).d(8);
        }
    }

    public final void c() {
        MediaPlayer mediaPlayer = this.d;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(1.0f, 1.0f);
            this.b.b(R.id.ms_video_volume_mute).d(8);
            this.b.b(R.id.ms_video_volume).d(0);
        }
    }

    public final void e() {
        if (!this.m && this.n) {
            com.meishu.sdk.meishu_ad.nativ.e eVar = this.g;
            if (eVar != null) {
                eVar.onVideoStart();
            }
            com.meishu.sdk.meishu_ad.nativ.a aVar = this.h;
            if (aVar != null) {
                aVar.onADExposure();
            }
            this.m = true;
        }
        this.p = true;
        this.b.b(R.id.ms_controlbar_video_play_button).d(8);
        this.b.b(R.id.ms_center_play_button).d(8);
        this.b.b(R.id.ms_controlbar_video_pause_button).d(0);
        long j = this.f;
        this.c.setmTotalTime((j <= 0 || j >= ((long) this.f5065a.getDuration())) ? this.f5065a.getDuration() : (int) this.f);
        if (this.o.hasMessages(1)) {
            return;
        }
        this.o.sendEmptyMessage(1);
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void a(n0.a aVar) {
        this.q.add(aVar);
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public boolean a() {
        return this.f5065a.g;
    }

    public final void a(Context context) {
        setTag("meishu_media_view");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.ms_full_screen_video_player_layout, (ViewGroup) null);
        addView(viewInflate);
        MeishuVideoTextureView meishuVideoTextureView = (MeishuVideoTextureView) viewInflate.findViewById(R.id.ms_video_view);
        this.f5065a = meishuVideoTextureView;
        meishuVideoTextureView.setUseTransform(false);
        com.meishu.sdk.core.bquery.i iVar = new com.meishu.sdk.core.bquery.i(this);
        this.b = iVar;
        CircleProcessBar circleProcessBar = (CircleProcessBar) iVar.b(R.id.ms_process_bar).d;
        this.c = circleProcessBar;
        circleProcessBar.setVisibility(8);
        com.meishu.sdk.core.bquery.i iVarB = this.b.b(R.id.ms_center_play_button);
        com.meishu.sdk.meishu_ad.reward.a aVar = new com.meishu.sdk.meishu_ad.reward.a(this);
        View view = iVarB.d;
        if (view != null) {
            view.setOnClickListener(aVar);
        }
        com.meishu.sdk.core.bquery.i iVarB2 = this.b.b(R.id.ms_controlbar_video_play_button);
        b bVar = new b(this);
        View view2 = iVarB2.d;
        if (view2 != null) {
            view2.setOnClickListener(bVar);
        }
        com.meishu.sdk.core.bquery.i iVarB3 = this.b.b(R.id.ms_controlbar_video_pause_button);
        c cVar = new c(this);
        View view3 = iVarB3.d;
        if (view3 != null) {
            view3.setOnClickListener(cVar);
        }
        com.meishu.sdk.core.bquery.i iVarB4 = this.b.b(R.id.ms_video_volume_mute);
        d dVar = new d(this);
        View view4 = iVarB4.d;
        if (view4 != null) {
            view4.setOnClickListener(dVar);
        }
        com.meishu.sdk.core.bquery.i iVarB5 = this.b.b(R.id.ms_video_volume);
        e eVar = new e(this);
        View view5 = iVarB5.d;
        if (view5 != null) {
            view5.setOnClickListener(eVar);
        }
        this.f5065a.setOnErrorListener(new f(this));
        this.f5065a.setOnPreparedListener(new g(this));
        this.f5065a.setOnCompletionListener(new h(this));
    }

    public FullScreenMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = -1L;
        this.m = false;
        this.n = false;
        this.o = new a(Looper.getMainLooper());
        this.q = new ArrayList();
        a(context);
    }

    public FullScreenMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = -1L;
        this.m = false;
        this.n = false;
        this.o = new a(Looper.getMainLooper());
        this.q = new ArrayList();
        a(context);
    }
}
