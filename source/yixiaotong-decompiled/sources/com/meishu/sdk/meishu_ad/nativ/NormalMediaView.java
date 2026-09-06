package com.meishu.sdk.meishu_ad.nativ;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.meishu.sdk.R;
import com.meishu.sdk.activity.MeishuDetailActivity;
import com.meishu.sdk.core.ad.recycler.RecylcerAdInteractionListener;
import com.meishu.sdk.core.safe.SafeBroadcastReceiver;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.view.RoundImageView;
import com.meishu.sdk.meishu_ad.n0;
import com.meishu.sdk.meishu_ad.view.MeishuVideoTextureView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class NormalMediaView extends FrameLayout implements n0 {
    public static final /* synthetic */ int b0 = 0;
    public n0.c A;
    public n0.b B;
    public e C;
    public MediaPlayer.OnInfoListener D;
    public com.meishu.sdk.meishu_ad.nativ.a E;
    public boolean F;
    public com.meishu.sdk.meishu_ad.lifecycle.c G;
    public volatile boolean H;
    public volatile boolean I;
    public volatile boolean J;
    public volatile boolean K;
    public Handler L;
    public int M;
    public int N;
    public boolean O;
    public RecylcerAdInteractionListener P;
    public String Q;
    public ImageView R;
    public boolean S;
    public boolean T;
    public boolean U;
    public List<n0.a> V;
    public BroadcastReceiver W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5040a;
    public d a0;
    public MeishuVideoTextureView b;
    public com.meishu.sdk.core.bquery.i c;
    public TextView d;
    public TextView e;
    public ProgressBar f;
    public boolean g;
    public int h;
    public int i;
    public long j;
    public String k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public int p;
    public com.meishu.sdk.meishu_ad.nativ.b q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public float x;
    public float y;
    public boolean z;

    public class a extends com.meishu.sdk.core.safe.l {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            com.meishu.sdk.meishu_ad.nativ.a aVar;
            NormalMediaView normalMediaView = NormalMediaView.this;
            if (!normalMediaView.F && (aVar = normalMediaView.E) != null) {
                aVar.onADExposure();
            }
            RecylcerAdInteractionListener recylcerAdInteractionListener = NormalMediaView.this.P;
            if (recylcerAdInteractionListener != null) {
                recylcerAdInteractionListener.onAdExposure();
            }
        }
    }

    public class b extends SafeBroadcastReceiver {
        public b() {
        }

        @Override // com.meishu.sdk.core.safe.SafeBroadcastReceiver
        public void a(Context context, Intent intent) {
            com.meishu.sdk.core.utils.f.b(NormalMediaView.this.getContext(), NormalMediaView.this.q);
        }
    }

    public class c extends com.meishu.sdk.core.safe.c {
        public c() {
        }

        @Override // com.meishu.sdk.core.safe.c
        public void a(Message message) {
            super.a(message);
            int currentPosition = NormalMediaView.this.b.getCurrentPosition();
            NormalMediaView normalMediaView = NormalMediaView.this;
            normalMediaView.a(normalMediaView.d, currentPosition);
            NormalMediaView.this.f.setProgress(currentPosition);
            long duration = NormalMediaView.this.b.getDuration();
            NormalMediaView normalMediaView2 = NormalMediaView.this;
            if (normalMediaView2.j > duration) {
                normalMediaView2.j = duration - 100;
            }
            e eVar = normalMediaView2.C;
            if (eVar != null && normalMediaView2.p == 1 && currentPosition > 0 && duration > 0) {
                eVar.onProgressUpdate(currentPosition, duration);
            }
            NormalMediaView normalMediaView3 = NormalMediaView.this;
            long j = normalMediaView3.j;
            if (j > 0 && currentPosition >= j && !normalMediaView3.H) {
                NormalMediaView.this.H = true;
                n0.b bVar = NormalMediaView.this.B;
                if (bVar != null) {
                    bVar.onKeepTimeFinished();
                }
            }
            double d = (currentPosition * 1.0f) / duration;
            if (d < 0.25d || d >= 0.5d) {
                if (d < 0.5d || d >= 0.75d) {
                    if (d >= 0.75d && d < 1.0d && !NormalMediaView.this.K) {
                        e eVar2 = NormalMediaView.this.C;
                        if (eVar2 != null) {
                            eVar2.onVideoThreeQuarter();
                        }
                        NormalMediaView.this.K = true;
                    }
                } else if (!NormalMediaView.this.J) {
                    e eVar3 = NormalMediaView.this.C;
                    if (eVar3 != null) {
                        eVar3.onVideoOneHalf();
                    }
                    NormalMediaView.this.J = true;
                }
            } else if (!NormalMediaView.this.I) {
                e eVar4 = NormalMediaView.this.C;
                if (eVar4 != null) {
                    eVar4.onVideoOneQuarter();
                }
                NormalMediaView.this.I = true;
            }
            NormalMediaView.this.L.sendEmptyMessageDelayed(1, 100L);
        }
    }

    public interface d {
    }

    public NormalMediaView(Context context) {
        super(context);
        this.f5040a = getClass().getSimpleName();
        this.g = true;
        this.j = -1L;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.F = false;
        this.L = new c();
        this.V = new ArrayList();
        this.W = new b();
        a(context);
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void a(n0.b bVar, long j) {
        this.B = bVar;
        if (j > 0) {
            this.j = j;
        }
    }

    public int getCurrentPosition() {
        try {
            this.N = this.b.getCurrentPosition();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.N;
    }

    public int getDuration() {
        return this.b.getDuration();
    }

    public MeishuVideoTextureView getMeishuVideoView() {
        return this.b;
    }

    public int getPlayState() {
        return this.p;
    }

    public Bitmap getVideoThumb() {
        try {
            if (TextUtils.isEmpty(this.Q)) {
                return null;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(this.Q);
            return mediaMetadataRetriever.getFrameAtTime();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public View getVideoView() {
        return this;
    }

    public final void i() {
        LogUtil.d(this.f5040a, com.meishu.sdk.activity.a.a("onPlay ").append(hashCode()).toString());
        if (this.s && !this.r && !this.u) {
            this.r = true;
            this.b.post(new h(this));
        }
        this.c.b(R.id.ms_center_play_button).d(8);
        if (this.s) {
            this.c.b(R.id.ms_video_cover).d(4);
            this.c.b(R.id.ms_progress_loading).d(8);
        }
        this.f.setMax(this.b.getDuration());
        a(this.e, this.b.getDuration());
        if (this.L.hasMessages(1)) {
            return;
        }
        this.L.sendEmptyMessage(1);
    }

    public void j() {
        if (this.b.getMediaPlayer() != null) {
            try {
                this.b.getMediaPlayer().setVolume(1.0f, 1.0f);
                this.w = false;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.c.b(R.id.ms_video_volume_mute).d(8);
            this.c.b(R.id.ms_video_volume).d(0);
            e eVar = this.C;
            if (eVar != null) {
                eVar.onVideoUnmute();
            }
        }
    }

    public void l() {
        try {
            MediaPlayer mediaPlayer = this.b.getMediaPlayer();
            LogUtil.d(this.f5040a, "stop(), mediaPlayer=" + mediaPlayer + ",isPlaying=" + (mediaPlayer != null && mediaPlayer.isPlaying()));
            if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                try {
                    mediaPlayer.stop();
                    mediaPlayer.reset();
                    mediaPlayer.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        h();
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void mute() {
        g();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n = true;
        if (this.u) {
            if (!this.r) {
                MeishuVideoTextureView meishuVideoTextureView = this.b;
                if (meishuVideoTextureView.g) {
                    this.r = true;
                    meishuVideoTextureView.post(new a());
                }
            }
            int i = this.p;
            if (i == 0 && this.g) {
                start();
            } else if (i == 1 || (i == 2 && this.g)) {
                resume();
            }
        }
        if (this.g) {
            com.meishu.sdk.core.event.b.a(getContext(), this.W, new IntentFilter("ACTION_DOWNLOAD_CLICKED"));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n = false;
        if (this.u && this.p == 1 && !this.o && this.g) {
            pause();
        }
        if (this.g) {
            com.meishu.sdk.core.event.b.a(getContext(), this.W);
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    /* JADX WARN: Code duplicated, block: B:19:0x0048 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x004a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:22:0x0057 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[ADDED_TO_REGION] */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        float f = this.x;
        if (0.0f < f) {
            float f2 = this.y;
            if (0.0f >= f2) {
                i3 = this.h;
                if (i3 > 0 && (i4 = this.i) > 0) {
                    if (size <= 0 && size2 == 0) {
                        i2 = View.MeasureSpec.makeMeasureSpec((int) ((i4 * size) / i3), 1073741824);
                    } else if (size != 0 && size2 > 0) {
                        i = View.MeasureSpec.makeMeasureSpec((int) ((i3 * size2) / i4), 1073741824);
                    } else if (size > 0 && size2 > 0) {
                        i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        i2 = View.MeasureSpec.makeMeasureSpec((int) ((this.i * size) / this.h), 1073741824);
                    }
                }
            } else if (size > 0 && size2 == 0) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) ((f2 * size) / f), 1073741824);
            } else if (size == 0 && size2 > 0) {
                i = View.MeasureSpec.makeMeasureSpec((int) ((f * size2) / f2), 1073741824);
            }
        } else {
            i3 = this.h;
            if (i3 > 0) {
                if (size <= 0) {
                    if (size != 0) {
                        if (size > 0) {
                            i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                            i2 = View.MeasureSpec.makeMeasureSpec((int) ((this.i * size) / this.h), 1073741824);
                        }
                    } else if (size > 0) {
                        i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        i2 = View.MeasureSpec.makeMeasureSpec((int) ((this.i * size) / this.h), 1073741824);
                    }
                } else if (size != 0) {
                    if (size > 0) {
                        i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                        i2 = View.MeasureSpec.makeMeasureSpec((int) ((this.i * size) / this.h), 1073741824);
                    }
                } else if (size > 0) {
                    i = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                    i2 = View.MeasureSpec.makeMeasureSpec((int) ((this.i * size) / this.h), 1073741824);
                }
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        int i;
        super.onWindowFocusChanged(z);
        if (this.T) {
            return;
        }
        if (!z && (i = this.p) != 3 && i != 0 && this.n && !this.o && this.M != 1) {
            LogUtil.d(this.f5040a, "onWindowFocusChanged,onPause");
            pause();
        } else if (z) {
            int i2 = this.p;
            if (i2 == 2 || (this.o && i2 != 3 && this.n)) {
                LogUtil.d(this.f5040a, com.meishu.sdk.activity.a.a("onResume,playState=").append(this.p).toString());
                resume();
            }
        }
    }

    public void setAdListener(com.meishu.sdk.meishu_ad.nativ.a aVar) {
        this.E = aVar;
        this.F = false;
    }

    public void setConfigHeight(int i) {
        this.i = i;
    }

    public void setConfigWidth(int i) {
        this.h = i;
    }

    public void setContainerHeight(float f) {
        this.y = f;
    }

    public void setContainerWidth(float f) {
        this.x = f;
    }

    public void setDisplayMode(int i) {
        this.b.setDisplayMode(i);
    }

    public void setFromLogo(String str) {
        if (str != null) {
            this.c.b(R.id.ms_img_meishu_ad_tag).a(str, false);
        }
    }

    public void setFromLogoVisibility(int i) {
        com.meishu.sdk.core.bquery.i iVarB = this.c.b(R.id.ms_img_meishu_ad_tag);
        View view = iVarB.d;
        if (view == null || view.getVisibility() == i) {
            return;
        }
        iVarB.d.setVisibility(i);
    }

    public void setInitMute(boolean z) {
        if (z) {
            this.c.b(R.id.ms_video_volume_mute).d(0);
            this.c.b(R.id.ms_video_volume).d(8);
        } else {
            this.c.b(R.id.ms_video_volume_mute).d(8);
            this.c.b(R.id.ms_video_volume).d(0);
        }
        this.b.setInitMute(z);
    }

    public void setIsEyes(int i) {
        this.M = i;
    }

    public void setMsAd(com.meishu.sdk.meishu_ad.nativ.b bVar) {
        this.q = bVar;
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void setNativeAdMediaListener(e eVar) {
        this.C = eVar;
    }

    public void setOnExposureListener(RecylcerAdInteractionListener recylcerAdInteractionListener) {
        this.P = recylcerAdInteractionListener;
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.D = onInfoListener;
    }

    public void setOnPreparedListener(d dVar) {
        this.a0 = dVar;
    }

    public void setOnVideoLoadedListener(n0.c cVar) {
        this.A = cVar;
    }

    public void setPlayOnce(boolean z) {
        this.t = z;
    }

    public void setProgressLoadingVisible(boolean z) {
        if (z) {
            this.c.b(R.id.ms_progress_loading).d(0);
        } else {
            this.c.b(R.id.ms_progress_loading).d(8);
        }
    }

    public void setRadius(int i) {
        try {
            ImageView imageView = this.R;
            if (imageView instanceof RoundImageView) {
                ((RoundImageView) imageView).setCornerRadius(i);
            }
            this.b.setRadius((int) com.meishu.sdk.core.utils.m.a(getContext(), i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRecycler(boolean z) {
        this.u = z;
    }

    public void setRewardWeb(boolean z) {
        this.T = z;
    }

    public void setUseTransform(boolean z) {
        this.b.setUseTransform(z);
    }

    public void setVideoEndCover(String str) {
        this.l = str;
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void unmute() {
        j();
    }

    public void c() {
        MediaPlayer mediaPlayer = this.b.getMediaPlayer();
        if (mediaPlayer == null) {
            return;
        }
        if (this.h <= 0 || this.i <= 0) {
            this.h = mediaPlayer.getVideoWidth();
            this.i = mediaPlayer.getVideoHeight();
            requestLayout();
        }
    }

    public boolean e() {
        try {
            return this.b.getMediaPlayer() != null && this.b.getMediaPlayer().isPlaying();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void g() {
        if (this.b.getMediaPlayer() != null) {
            try {
                this.b.getMediaPlayer().setVolume(0.0f, 0.0f);
                this.w = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.c.b(R.id.ms_video_volume_mute).d(0);
            this.c.b(R.id.ms_video_volume).d(8);
            e eVar = this.C;
            if (eVar != null) {
                eVar.onVideoMute();
            }
        }
    }

    public void k() {
        n0.c cVar = this.A;
        if (cVar != null) {
            cVar.onLoaded(this);
        }
    }

    public void setActivityForLifecycle(Activity activity) {
        if (this.G == null) {
            com.meishu.sdk.meishu_ad.lifecycle.c cVar = new com.meishu.sdk.meishu_ad.lifecycle.c();
            this.G = cVar;
            cVar.b = activity;
        }
    }

    public void setVideoCover(String str) {
        this.k = str;
        this.c.b(R.id.ms_video_cover).a(str, false);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[Catch: all -> 0x002c, TRY_LEAVE, TryCatch #2 {all -> 0x002c, blocks: (B:5:0x000c, B:7:0x0010, B:11:0x0024, B:13:0x0028, B:10:0x0021), top: B:31:0x000c, inners: #0 }] */
    public void d() {
        SurfaceTexture surfaceTexture;
        MeishuVideoTextureView meishuVideoTextureView = this.b;
        if (meishuVideoTextureView != null) {
            LogUtil.d(meishuVideoTextureView.f5114a, "destroy");
            try {
                MediaPlayer mediaPlayer = meishuVideoTextureView.b;
                if (mediaPlayer != null) {
                    try {
                        mediaPlayer.stop();
                        meishuVideoTextureView.b.reset();
                        meishuVideoTextureView.b.release();
                        meishuVideoTextureView.b = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    surfaceTexture = meishuVideoTextureView.n;
                    if (surfaceTexture != null) {
                        surfaceTexture.release();
                    }
                } else {
                    surfaceTexture = meishuVideoTextureView.n;
                    if (surfaceTexture != null) {
                        surfaceTexture.release();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        try {
            if (this.L.hasMessages(1)) {
                this.L.removeMessages(1);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.meishu.sdk.meishu_ad.lifecycle.c cVar = this.G;
        if (cVar != null) {
            cVar.b = null;
        }
    }

    public final void h() {
        if (this.m) {
            this.c.b(R.id.ms_center_play_button).d(0);
        }
        if (this.L.hasMessages(1)) {
            this.L.removeMessages(1);
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void setVideoPath(String str) {
        this.Q = str;
        this.b.setVideoPath(str);
    }

    public void setAutoStart(boolean z) {
        this.g = z;
        if (z) {
            return;
        }
        this.c.b(R.id.ms_center_play_button).d(0);
    }

    public void setVideoCoverScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.R;
        if (imageView == null || scaleType == null) {
            return;
        }
        imageView.setScaleType(scaleType);
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void a(n0.a aVar) {
        this.V.add(aVar);
    }

    public void b() {
        try {
            ImageView imageView = this.R;
            if (imageView == null) {
                return;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.width = getMeishuVideoView().getMeasuredWidth();
            if (getMeishuVideoView() == null) {
                return;
            }
            layoutParams.height = getMeishuVideoView().getMeasuredHeight();
            this.R.setLayoutParams(layoutParams);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void resume() {
        if ((this.t && this.p == 3) || this.p == 0) {
            return;
        }
        this.v = false;
        this.p = 1;
        this.b.d();
        i();
        e eVar = this.C;
        if (eVar != null) {
            eVar.onVideoResume();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public boolean a() {
        return this.b.g;
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void pause() {
        int i;
        e eVar;
        if ((this.t && this.p == 3) || (i = this.p) == 0) {
            return;
        }
        this.v = true;
        this.p = 2;
        this.b.c();
        h();
        if (i == 2 || (eVar = this.C) == null) {
            return;
        }
        eVar.onVideoPause();
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void replay() {
        if (this.t && this.p == 3) {
            return;
        }
        this.p = 0;
        this.v = false;
        this.U = false;
        start();
    }

    public final void a(TextView textView, int i) {
        int i2 = i / 1000;
        textView.setText(String.format(Locale.CHINA, "%02d:%02d", Integer.valueOf(i2 / 60), Integer.valueOf(i2 % 60)));
    }

    public final void a(Context context) {
        View viewInflate;
        setTag("meishu_media_view");
        if (this.z) {
            viewInflate = LayoutInflater.from(context).inflate(R.layout.ms_normal_video_player_layout2, (ViewGroup) null);
        } else {
            viewInflate = LayoutInflater.from(context).inflate(R.layout.ms_normal_video_player_layout, (ViewGroup) null);
        }
        addView(viewInflate, -1, -2);
        this.b = (MeishuVideoTextureView) viewInflate.findViewById(R.id.ms_video_view);
        this.R = (ImageView) viewInflate.findViewById(R.id.ms_video_cover);
        com.meishu.sdk.core.bquery.i iVar = new com.meishu.sdk.core.bquery.i(this);
        this.c = iVar;
        this.d = (TextView) iVar.b(R.id.ms_video_currentTime).d;
        this.e = (TextView) this.c.b(R.id.ms_video_endTime).d;
        this.f = (ProgressBar) this.c.b(R.id.ms_video_seekBar).d;
        com.meishu.sdk.core.bquery.i iVarB = this.c.b(R.id.ms_center_play_button);
        i iVar2 = new i(this);
        View view = iVarB.d;
        if (view != null) {
            view.setOnClickListener(iVar2);
        }
        com.meishu.sdk.core.bquery.i iVarB2 = this.c.b(R.id.ms_controlbar_video_play_button);
        j jVar = new j(this);
        View view2 = iVarB2.d;
        if (view2 != null) {
            view2.setOnClickListener(jVar);
        }
        com.meishu.sdk.core.bquery.i iVarB3 = this.c.b(R.id.ms_controlbar_video_pause_button);
        k kVar = new k(this);
        View view3 = iVarB3.d;
        if (view3 != null) {
            view3.setOnClickListener(kVar);
        }
        com.meishu.sdk.core.bquery.i iVarB4 = this.c.b(R.id.ms_video_volume_mute);
        l lVar = new l(this);
        View view4 = iVarB4.d;
        if (view4 != null) {
            view4.setOnClickListener(lVar);
        }
        com.meishu.sdk.core.bquery.i iVarB5 = this.c.b(R.id.ms_video_volume);
        m mVar = new m(this);
        View view5 = iVarB5.d;
        if (view5 != null) {
            view5.setOnClickListener(mVar);
        }
        this.b.setOnErrorListener(new n(this));
        this.b.setOnPreparedListener(new o(this));
        this.b.setOnCompletionListener(new p(this));
        this.b.setOnInfoListener(new g(this));
        if (getContext() instanceof Activity) {
            com.meishu.sdk.meishu_ad.lifecycle.c cVar = new com.meishu.sdk.meishu_ad.lifecycle.c();
            this.G = cVar;
            cVar.b = (Activity) getContext();
        }
    }

    public final void f() {
        Bitmap bitmap;
        try {
            this.p = 3;
            String str = !TextUtils.isEmpty(this.l) ? this.l : this.k;
            if (str == null) {
                MeishuVideoTextureView meishuVideoTextureView = this.b;
                if (meishuVideoTextureView != null && (bitmap = meishuVideoTextureView.getBitmap()) != null && !this.S) {
                    b();
                    com.meishu.sdk.core.bquery.i iVarB = this.c.b(R.id.ms_video_cover);
                    View view = iVarB.d;
                    if (view instanceof ImageView) {
                        ((ImageView) view).setImageBitmap(bitmap);
                    }
                    iVarB.d(0);
                }
            } else if (!this.S) {
                b();
                this.c.b(R.id.ms_video_cover).a(str, false).d(0);
            }
            View view2 = this.c.b(R.id.ms_video_cover).d;
            if (view2 != null && view2.getVisibility() == 0 && this.t) {
                this.c.b(R.id.ms_video_view).d(8);
            }
            h();
            int duration = this.b.getDuration();
            a(this.d, duration);
            this.f.setProgress(duration);
            if (!this.g) {
                this.c.b(R.id.ms_center_play_button).d(0);
            }
            if (this.O) {
                return;
            }
            if (this.j <= 0 && this.B != null && !this.H) {
                this.H = true;
                this.B.onKeepTimeFinished();
            }
            Iterator<n0.a> it = this.V.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            e eVar = this.C;
            if (eVar != null) {
                eVar.onVideoComplete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            d();
        }
    }

    @Override // com.meishu.sdk.meishu_ad.n0
    public void start() {
        int i = this.p;
        if (i == 0 || i == 3) {
            if (this.t && i == 3) {
                return;
            }
            this.p = 1;
            this.I = false;
            this.J = false;
            this.K = false;
            if (this.v) {
                return;
            }
            this.b.e();
            i();
            e eVar = this.C;
            if (eVar == null || !this.b.g || this.U) {
                return;
            }
            this.U = true;
            eVar.onVideoStart();
        }
    }

    public void b(boolean z) {
        this.m = z;
        if (z) {
            this.c.b(R.id.ms_control).d(0);
        } else {
            this.c.b(R.id.ms_control).d(8);
        }
    }

    public void a(boolean z) {
        this.o = true;
        f fVarA = this.q.a();
        MeishuDetailActivity.setMeishuVideoView(this);
        MeishuDetailActivity.setNativeAdData(this.q);
        Intent intent = new Intent(getContext(), (Class<?>) MeishuDetailActivity.class);
        intent.setFlags(67108864);
        intent.putExtra(MeishuDetailActivity.EXTRA_INTERACTION_TYPE, fVarA.getInteractionType());
        intent.putExtra(MeishuDetailActivity.EXTRA_DURL, fVarA.getdUrl());
        intent.putExtra(MeishuDetailActivity.EXTRA_APP_NAME, fVarA.getAppName());
        intent.putExtra(MeishuDetailActivity.EXTRA_ICON_URL, fVarA.iconUrl);
        intent.putExtra(MeishuDetailActivity.EXTRA_CONTENT, fVarA.c);
        intent.putExtra(MeishuDetailActivity.EXTRA_SCORE, fVarA.getScore());
        intent.putExtra(MeishuDetailActivity.EXTRA_DOWN_NUM, fVarA.getDownNum());
        intent.putExtra(MeishuDetailActivity.EXTRA_VIDEO_WIDTH, fVarA.f5047a);
        intent.putExtra(MeishuDetailActivity.EXTRA_VIDEO_HEIGHT, fVarA.b);
        intent.putExtra(MeishuDetailActivity.EXTRA_STRONG_ACTION, z);
        intent.putExtra(MeishuDetailActivity.EXTRA_VIDEO_COVER, fVarA.getVideo_cover());
        intent.putExtra(MeishuDetailActivity.EXTRA_VIDEO_END_COVER, fVarA.h);
        if (!(getContext() instanceof Activity)) {
            intent.addFlags(268435456);
        }
        getContext().startActivity(intent);
    }

    public NormalMediaView(Context context, boolean z) {
        super(context);
        this.f5040a = getClass().getSimpleName();
        this.g = true;
        this.j = -1L;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.F = false;
        this.L = new c();
        this.V = new ArrayList();
        this.W = new b();
        this.z = z;
        a(context);
    }

    public NormalMediaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5040a = getClass().getSimpleName();
        this.g = true;
        this.j = -1L;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.F = false;
        this.L = new c();
        this.V = new ArrayList();
        this.W = new b();
        a(context);
    }

    public NormalMediaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5040a = getClass().getSimpleName();
        this.g = true;
        this.j = -1L;
        this.p = 0;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.F = false;
        this.L = new c();
        this.V = new ArrayList();
        this.W = new b();
        a(context);
    }
}
