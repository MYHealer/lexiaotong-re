package com.adprof.sdk;

import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.adprof.sdk.api.AdError;
import com.stub.StubApp;
import java.util.Timer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class po extends RelativeLayout implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, View.OnTouchListener, ro {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1370a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ViewGroup f599a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f600a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressBar f601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f602a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ep f603a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public gp f604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public no f605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public oo f606a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public po f607a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public qo f608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public rg f609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Class f610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Timer f611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f612a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f613b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ViewGroup f614b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ImageView f615b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f616b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ViewGroup f617c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public ImageView f618c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f619c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ViewGroup f620d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public ImageView f621d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f622d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public ViewGroup f623e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f624e;
    public ViewGroup f;

    public po(Context context) {
        super(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        this.f1370a = -1;
        this.b = -1;
        this.c = -1;
        this.f597a = 0L;
        this.f613b = 0L;
        this.f612a = false;
        this.f616b = true;
        this.f619c = true;
        this.f622d = false;
        a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    @Override // com.adprof.sdk.ro
    public void a() {
        this.f1370a = 3;
        e eVar = this.f602a;
        if (eVar != null) {
            eVar.onVideoLoad();
        }
        e eVar2 = this.f602a;
        if (eVar2 != null) {
            eVar2.onVideoStart();
        }
        pk.a("mediaInterface start");
        k();
        this.f603a.d();
        setSoundChange(this.f619c);
        if (this.f608a.a().toString().toLowerCase().contains("mp3") || this.f608a.a().toString().toLowerCase().contains("wma") || this.f608a.a().toString().toLowerCase().contains("aac") || this.f608a.a().toString().toLowerCase().contains("m4a") || this.f608a.a().toString().toLowerCase().contains("wav")) {
            k();
        }
    }

    @Override // com.adprof.sdk.ro
    public void a(int i, int i2) {
        pk.b("onError " + i + " - " + i2 + " [" + hashCode() + "] ");
        e eVar = this.f602a;
        if (eVar != null) {
            eVar.onVideoError(AdError.ERROR_AD_VIDEO_PLAY_FAIL);
        }
        if (i == 38 || i2 == -38 || i == -38 || i2 == 38 || i2 == -19) {
            return;
        }
        h();
        this.f603a.c();
    }

    public void a(Context context) {
        View.inflate(context, getLayoutId(), this);
        this.f620d = (ViewGroup) findViewById(R.id.adprof_native_video_sound_rl);
        this.f614b = (ViewGroup) findViewById(R.id.adprof_native_video_start_rl);
        this.f617c = (ViewGroup) findViewById(R.id.adprof_native_video_fullscreen_rl);
        this.f600a = (ImageView) findViewById(R.id.adprof_native_video_sound_btn);
        this.f599a = (ViewGroup) findViewById(R.id.adprof_native_video_surface_fl);
        this.f = (ViewGroup) findViewById(R.id.adprof_native_video_app_rl);
        this.f601a = (ProgressBar) findViewById(R.id.adprof_native_video_bottom_progress);
        this.f623e = (ViewGroup) findViewById(R.id.adprof_native_video_big_replay);
        this.f615b = (ImageView) findViewById(R.id.adprof_native_video_thumb);
        this.f621d = (ImageView) findViewById(R.id.adprof_native_video_blur_iv);
        this.f598a = findViewById(R.id.adprof_native_video_layout_bottom);
        ImageView imageView = new ImageView(context);
        this.f618c = imageView;
        imageView.setImageResource(R.drawable.adprof_video_play);
        this.f618c.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.f618c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(h8.a(25.0f), h8.a(25.0f));
        layoutParams.addRule(13);
        this.f618c.setLayoutParams(layoutParams);
        addView(this.f618c);
        this.f618c.setOnClickListener(this);
        this.f620d.setOnClickListener(this);
        this.f614b.setOnClickListener(this);
        this.f617c.setOnClickListener(this);
        this.f623e.setOnClickListener(this);
        h8.b();
        h8.m641a();
        this.f606a = new oo(this, new ko(this));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(com.huawei.openalliance.ad.constant.x.co);
        hc.a(context, this.f606a, intentFilter);
        this.f1370a = -1;
    }

    @Override // com.adprof.sdk.ro
    public void b() {
        Runtime.getRuntime().gc();
        e eVar = this.f602a;
        if (eVar != null) {
            eVar.onVideoCompleted();
        }
        pk.a("onAutoCompletion  [" + hashCode() + "] ");
        c();
        g();
        Window windowM681a = md.m681a(getContext());
        if (windowM681a != null) {
            windowM681a.clearFlags(128);
        }
        o();
        this.f607a = null;
    }

    @Override // com.adprof.sdk.ro
    public void b(int i, int i2) {
        String str;
        pk.a("onInfo what - " + i + " extra - " + i2);
        if (i == 3) {
            int i3 = this.f1370a;
            if (i3 == 3 || i3 == 2) {
                k();
                return;
            }
            return;
        }
        if (i == 701) {
            if (this.f1370a == 4) {
                this.f624e = true;
                this.f603a.a();
                j();
            }
            str = "MEDIA_INFO_BUFFERING_START";
        } else {
            if (i != 702) {
                return;
            }
            if (this.f624e) {
                this.f624e = false;
                this.f603a.d();
                k();
            }
            str = "MEDIA_INFO_BUFFERING_END";
        }
        pk.a(str);
    }

    public void c() {
        Timer timer = this.f611a;
        if (timer != null) {
            timer.cancel();
            this.f611a = null;
        }
        no noVar = this.f605a;
        if (noVar != null) {
            noVar.cancel();
            this.f605a = null;
        }
    }

    @Override // com.adprof.sdk.ro
    public void c(int i, int i2) {
        this.d = i2;
        this.e = i;
        gp gpVar = this.f604a;
        if (gpVar != null && (gpVar.f1198a != i || gpVar.b != i2)) {
            gpVar.f1198a = i;
            gpVar.b = i2;
            gpVar.requestLayout();
        }
        if (this.f612a) {
            requestLayout();
        }
    }

    public void d() {
        po poVar = this.f607a;
        if (poVar != null) {
            int i = poVar.f1370a;
            if (i == 6 || i == 0 || i == 1 || i == 7) {
                m();
            } else if (i != 5) {
                poVar.j();
                this.f607a.f603a.a();
            }
        }
    }

    public void e() {
        int i;
        po poVar = this.f607a;
        if (poVar == null || (i = poVar.f1370a) == 0) {
            pk.a("------goOnPlayOnResume:startVideo " + this.f1370a);
            if (this.f1370a != 6) {
                q();
                return;
            }
            return;
        }
        if (i == 5) {
            e eVar = this.f602a;
            if (eVar != null) {
                eVar.onVideoResume();
            }
            this.f607a.k();
            this.f607a.f603a.d();
            return;
        }
        if (i == 3) {
            e eVar2 = this.f602a;
            if (eVar2 != null) {
                eVar2.onVideoStart();
            }
            this.f607a.f603a.d();
            this.f607a.k();
            return;
        }
        if (i == 1) {
            if (this.f1370a == 3) {
                this.f603a.d();
            } else {
                q();
            }
        }
    }

    public final void f() {
        try {
            ep epVar = this.f603a;
            if (epVar != null) {
                epVar.c();
            }
            Class cls = this.f610a;
            this.f603a = cls == null ? new ep(this) : (ep) cls.getConstructor(po.class).newInstance(this);
        } catch (Throwable th) {
            pk.b("------VideoAdView initPlayerInterface error: ", th);
        }
    }

    public void g() {
        pk.c("onStateAutoComplete  [" + hashCode() + "] ");
        this.f1370a = 6;
        c();
        ProgressBar progressBar = this.f601a;
        if (progressBar != null) {
            progressBar.setProgress(100);
        }
    }

    public ViewGroup getAppContainer() {
        return this.f;
    }

    public Context getApplicationContext() {
        Context origApplicationContext;
        Context context = getContext();
        return (context == null || (origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext())) == null) ? context : origApplicationContext;
    }

    public ImageView getBlurImageView() {
        return this.f621d;
    }

    public long getCurrentPositionWhenPlaying() {
        int i = this.f1370a;
        if (i != 4 && i != 5) {
            return 0L;
        }
        try {
            MediaPlayer mediaPlayer = this.f603a.f263a;
            if (mediaPlayer != null) {
                return mediaPlayer.getCurrentPosition();
            }
            return 0L;
        } catch (IllegalStateException e) {
            pk.b("VideoAdView getCurrentPositionWhenPlaying error: ", e);
            return 0L;
        }
    }

    public long getDuration() {
        MediaPlayer mediaPlayer;
        try {
            ep epVar = this.f603a;
            if (epVar == null || (mediaPlayer = epVar.f263a) == null) {
                return 0L;
            }
            return mediaPlayer.getDuration();
        } catch (Throwable th) {
            pk.b("VideoAdView getDuration error: ", th);
            return 0L;
        }
    }

    public ViewGroup getGtAdView() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        while (!(viewGroup instanceof f) && (viewGroup = (ViewGroup) getParent()) != null) {
        }
        return viewGroup;
    }

    public int getLayoutId() {
        return R.layout.adprof_video_player;
    }

    public Bitmap getTextureBitmap() {
        gp gpVar = this.f604a;
        if (gpVar != null) {
            return gpVar.getBitmap();
        }
        return null;
    }

    public ImageView getThumbView() {
        return this.f615b;
    }

    public int getVideoHeight() {
        return this.d;
    }

    @Override // com.adprof.sdk.ro
    public qo getVideoPlayerDataSource() {
        return this.f608a;
    }

    public int getVideoSurferViewHeight() {
        gp gpVar = this.f604a;
        if (gpVar != null) {
            return gpVar.getHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        return this.e;
    }

    public void h() {
        ViewGroup viewGroup;
        pk.a("onStateError  [" + hashCode() + "] ");
        this.f1370a = 7;
        c();
        if (this.b != 1 || this.f612a || (viewGroup = this.f614b) == null) {
            return;
        }
        viewGroup.setVisibility(0);
    }

    public void i() {
        ImageView imageView;
        ViewGroup viewGroup;
        pk.a("onStateNormal stat" + this.f1370a + " [" + hashCode() + "] ");
        this.f1370a = 0;
        ImageView imageView2 = this.f615b;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        if (!this.f612a && (viewGroup = this.f614b) != null) {
            viewGroup.setVisibility(0);
        }
        if (this.f612a && !this.f616b && (imageView = this.f618c) != null && imageView != null) {
            imageView.setVisibility(0);
        }
        c();
        ep epVar = this.f603a;
        if (epVar != null) {
            epVar.c();
        }
        if (this.f612a && this.f616b && this.f608a != null) {
            post(new lo(this));
        }
    }

    public void j() {
        ViewGroup viewGroup;
        pk.c("onStatePause  [" + hashCode() + "] ");
        this.f1370a = 5;
        if (!this.f612a && (viewGroup = this.f614b) != null) {
            viewGroup.setVisibility(0);
        }
        e eVar = this.f602a;
        if (eVar != null) {
            eVar.onVideoPause();
        }
        c();
    }

    public void k() {
        ImageView imageView;
        ViewGroup viewGroup;
        pk.a("onStatePlaying  [" + hashCode() + "] ");
        ImageView imageView2 = this.f615b;
        if (imageView2 != null) {
            imageView2.setVisibility(4);
        }
        if (!this.f612a && (viewGroup = this.f614b) != null) {
            viewGroup.setVisibility(4);
        }
        if (this.f612a && (imageView = this.f618c) != null && imageView != null) {
            imageView.setVisibility(4);
        }
        if (this.f1370a == 3) {
            long j = this.f597a;
            if (j != 0) {
                this.f603a.a(j);
                this.f597a = 0L;
            }
        }
        this.f1370a = 4;
        p();
    }

    public void l() {
        pk.a("onStatePreparing  [" + hashCode() + "] ");
        this.f1370a = 1;
        o();
    }

    public void m() {
        pk.c("releaseAllVideos");
        po poVar = this.f607a;
        if (poVar != null) {
            poVar.n();
            this.f607a = null;
        }
    }

    public void n() {
        pk.a("reset  [" + hashCode() + "] ");
        c();
        o();
        i();
        this.f599a.removeAllViews();
        Window windowM681a = md.m681a(getContext());
        if (windowM681a != null) {
            windowM681a.clearFlags(128);
        }
        ep epVar = this.f603a;
        if (epVar != null) {
            epVar.c();
        }
    }

    public void o() {
        ProgressBar progressBar = this.f601a;
        if (progressBar != null) {
            progressBar.setProgress(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        onTouch(view, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        pk.a("VideoAdView onDetachedFromWindow [" + hashCode() + "]");
        m();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            int i3 = this.b;
            if (i3 != 1 && i3 != 2) {
                if (!this.f612a || this.e <= 0 || this.d <= 0) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size = View.MeasureSpec.getSize(i2);
                int i4 = (int) (size * (this.e / this.d));
                setMeasuredDimension(i4, size);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                if (getChildCount() > 0) {
                    getChildAt(0).measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    return;
                }
                return;
            }
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            if (pk.f594a) {
                pk.a(th);
            }
            super.onMeasure(i, i2);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            getDuration();
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
        c();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
        pk.a("bottomProgress onStopTrackingTouch [" + hashCode() + "] ");
        p();
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        int i = this.f1370a;
        if (i == 4 || i == 5) {
            long progress = (((long) seekBar.getProgress()) * getDuration()) / 100;
            this.c = seekBar.getProgress();
            this.f603a.a(progress);
            pk.a("seekTo " + progress + " [" + hashCode() + "] ");
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0094  */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getAction() == 1) {
            if (view == this.f617c) {
                int i = this.b;
                if (i == 0) {
                    rg rgVar = this.f609a;
                    if (rgVar != null) {
                        rgVar.onScreenFullscreen();
                    }
                    this.b = 1;
                } else if (i == 1) {
                    this.f613b = System.currentTimeMillis();
                    rg rgVar2 = this.f609a;
                    if (rgVar2 != null) {
                        rgVar2.onScreenNormal();
                    }
                    this.b = 0;
                }
            } else if (view == this.f620d) {
                setSoundChange(!this.f619c);
            } else if (view == this.f623e) {
                e eVar = this.f602a;
                if (eVar != null) {
                    eVar.onVideoRestart();
                }
                q();
            } else {
                if (view == this.f614b) {
                    int i2 = this.f1370a;
                    if (i2 == 0) {
                        q();
                    } else if (i2 == 4) {
                        pk.a("pauseVideo [" + hashCode() + "] ");
                        this.f603a.a();
                        j();
                    } else if (i2 == 5) {
                        e eVar2 = this.f602a;
                        if (eVar2 != null) {
                            eVar2.onVideoResume();
                        }
                        this.f603a.d();
                        k();
                    } else if (i2 == 6) {
                        q();
                    } else if (i2 == 3) {
                        this.f603a.d();
                        k();
                        e eVar3 = this.f602a;
                        if (eVar3 != null) {
                            eVar3.onVideoStart();
                        }
                    }
                    return true;
                }
                if (view == this.f618c) {
                    q();
                    return true;
                }
            }
        }
        return false;
    }

    public void p() {
        c();
        this.f611a = new Timer();
        no noVar = new no(this);
        this.f605a = noVar;
        this.f611a.schedule(noVar, 0L, 300L);
    }

    public void q() {
        setCurrentVideoAdView(this);
        try {
            f();
            ViewGroup viewGroup = this.f623e;
            if (viewGroup != null) {
                viewGroup.setVisibility(4);
            }
        } catch (Throwable th) {
            pk.b("VideoAdView startVideo error [" + hashCode() + "] ", th);
        }
        Window windowM681a = md.m681a(getContext());
        if (windowM681a != null) {
            windowM681a.setFlags(16777216, 16777216);
            windowM681a.addFlags(128);
        }
        gp gpVar = this.f604a;
        if (gpVar != null) {
            this.f599a.removeView(gpVar);
        }
        gp gpVar2 = new gp(getContext());
        this.f604a = gpVar2;
        gpVar2.setSurfaceTextureListener(this.f603a);
        this.f599a.addView(this.f604a, new FrameLayout.LayoutParams(-1, -1, 17));
        l();
    }

    @Override // com.adprof.sdk.ro
    public void setBufferProgress(int i) {
    }

    public void setCurrentVideoAdView(po poVar) {
        this.f607a = poVar;
    }

    public void setHolderImageResource(int i) {
    }

    public void setMediaInterface(Class cls) {
        n();
        this.f610a = cls;
    }

    @Override // android.view.View
    public void setRotation(float f) {
        this.f604a.setRotation(f);
    }

    public void setScreen(int i) {
        if (i == 0) {
            this.b = 0;
        } else if (i == 1) {
            this.b = 1;
        } else {
            if (i != 2) {
                return;
            }
            this.b = 2;
        }
    }

    public void setSoundChange(boolean z) {
        ImageView imageView;
        int i;
        this.f619c = z;
        if (z) {
            ep epVar = this.f603a;
            if (epVar != null) {
                epVar.b(0.0f);
            }
            imageView = this.f600a;
            i = R.drawable.adprof_video_mute;
        } else {
            ep epVar2 = this.f603a;
            if (epVar2 != null) {
                epVar2.b(1.0f);
            }
            imageView = this.f600a;
            i = R.drawable.adprof_video_unmute;
        }
        imageView.setImageResource(i);
    }

    public void setState(int i) {
        if (i == 0) {
            i();
            return;
        }
        if (i == 1) {
            l();
            return;
        }
        if (i == 2) {
            this.f1370a = 2;
            this.f597a = 0;
            this.f608a.f1391a = 0;
            MediaPlayer mediaPlayer = this.f603a.f263a;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(null);
            }
            this.f603a.c();
            this.f603a.b();
            return;
        }
        if (i == 4) {
            k();
            return;
        }
        if (i == 5) {
            j();
        } else if (i == 6) {
            g();
        } else {
            if (i != 7) {
                return;
            }
            h();
        }
    }

    @Override // com.adprof.sdk.ro
    public void setSurfaceTexture(SurfaceTexture surfaceTexture) {
        gp gpVar = this.f604a;
        if (gpVar != null) {
            gpVar.setSurfaceTexture(surfaceTexture);
        }
    }

    public void setTextureViewRotation(int i) {
        gp gpVar;
        po poVar = this.f607a;
        if (poVar == null || (gpVar = poVar.f604a) == null) {
            return;
        }
        gpVar.setRotation(i);
    }

    public void setUp(String str) {
        a(new qo(str, null), 0);
    }

    public void setVideoAdStatusListener(e eVar) {
        this.f602a = eVar;
    }

    public void setVideoAdViewListener(rg rgVar) {
        this.f609a = rgVar;
    }

    public void setVideoImageDisplayType(int i) {
        gp gpVar;
        po poVar = this.f607a;
        if (poVar == null || (gpVar = poVar.f604a) == null) {
            return;
        }
        gpVar.requestLayout();
    }

    public void a(boolean z, boolean z2) {
        this.f612a = z;
        this.f616b = z2;
        if (z) {
            ViewGroup viewGroup = this.f617c;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.f614b;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            ViewGroup viewGroup3 = this.f623e;
            if (viewGroup3 != null) {
                viewGroup3.setVisibility(8);
            }
            ViewGroup viewGroup4 = this.f620d;
            if (viewGroup4 != null) {
                viewGroup4.setVisibility(8);
            }
            ProgressBar progressBar = this.f601a;
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            View view = this.f598a;
            if (view != null) {
                view.setVisibility(8);
            }
            ImageView imageView = this.f618c;
            if (imageView != null) {
                imageView.setVisibility(this.f616b ? 8 : 0);
            }
        }
    }

    public void a(qo qoVar, int i) {
        if (System.currentTimeMillis() - this.f613b < 200) {
            return;
        }
        this.f608a = qoVar;
        this.b = i;
        i();
        this.f610a = null;
    }

    public void a(io ioVar, boolean z) {
        ViewGroup viewGroup;
        int i;
        int iOrdinal = ioVar.ordinal();
        if (iOrdinal == 0) {
            viewGroup = this.f614b;
            i = z ? 0 : 4;
            if (viewGroup == null) {
                return;
            }
        } else if (iOrdinal == 2) {
            viewGroup = this.f617c;
            i = z ? 0 : 4;
            if (viewGroup == null) {
                return;
            }
        } else if (iOrdinal == 3) {
            viewGroup = this.f620d;
            i = z ? 0 : 4;
            if (viewGroup == null) {
                return;
            }
        } else {
            if (iOrdinal != 4) {
                return;
            }
            viewGroup = this.f623e;
            i = z ? 0 : 4;
            if (viewGroup == null) {
                return;
            }
        }
        viewGroup.setVisibility(i);
    }
}
