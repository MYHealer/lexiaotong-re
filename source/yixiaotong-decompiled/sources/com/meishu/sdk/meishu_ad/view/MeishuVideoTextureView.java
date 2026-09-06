package com.meishu.sdk.meishu_ad.view;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.huawei.openalliance.ad.constant.ba;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.meishu.sdk.core.safe.k;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.m;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MeishuVideoTextureView extends TextureView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5114a;
    public MediaPlayer b;
    public MediaPlayer.OnPreparedListener c;
    public MediaPlayer.OnCompletionListener d;
    public MediaPlayer.OnInfoListener e;
    public MediaPlayer.OnVideoSizeChangedListener f;
    public boolean g;
    public Surface h;
    public int i;
    public int j;
    public boolean k;
    public Surface l;
    public int m;
    public SurfaceTexture n;
    public TextureView.SurfaceTextureListener o;

    public class a extends com.meishu.sdk.core.safe.h {
        public a() {
        }

        @Override // com.meishu.sdk.core.safe.h
        public void a(MediaPlayer mediaPlayer) {
            MeishuVideoTextureView meishuVideoTextureView = MeishuVideoTextureView.this;
            meishuVideoTextureView.g = true;
            MediaPlayer.OnPreparedListener onPreparedListener = meishuVideoTextureView.c;
            if (onPreparedListener != null) {
                onPreparedListener.onPrepared(mediaPlayer);
            }
        }
    }

    public class b extends com.meishu.sdk.core.safe.e {
        public b() {
        }

        @Override // com.meishu.sdk.core.safe.e
        public void a(MediaPlayer mediaPlayer) {
            MediaPlayer.OnCompletionListener onCompletionListener = MeishuVideoTextureView.this.d;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(mediaPlayer);
            }
        }
    }

    public class c extends com.meishu.sdk.core.safe.d {
        public c() {
        }

        @Override // com.meishu.sdk.core.safe.d
        public void a(MediaPlayer mediaPlayer, int i) {
            LogUtil.d(MeishuVideoTextureView.this.f5114a, "video buffer: " + i);
        }
    }

    public class d extends com.meishu.sdk.core.safe.g {
        public d() {
        }

        @Override // com.meishu.sdk.core.safe.g
        public boolean safeOnInfo(MediaPlayer mediaPlayer, int i, int i2) {
            LogUtil.d(MeishuVideoTextureView.this.f5114a, "media player info: " + i + PPSLabelView.Code + i2);
            MediaPlayer.OnInfoListener onInfoListener = MeishuVideoTextureView.this.e;
            if (onInfoListener != null) {
                return onInfoListener.onInfo(mediaPlayer, i, i2);
            }
            return true;
        }
    }

    public class e extends k {
        public e() {
        }

        @Override // com.meishu.sdk.core.safe.k
        public void safeOnVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            int measuredWidth;
            int measuredHeight;
            MeishuVideoTextureView meishuVideoTextureView = MeishuVideoTextureView.this;
            meishuVideoTextureView.i = i;
            meishuVideoTextureView.j = i2;
            MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = meishuVideoTextureView.f;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(mediaPlayer, i, i2);
            }
            MeishuVideoTextureView meishuVideoTextureView2 = MeishuVideoTextureView.this;
            if (meishuVideoTextureView2.l != null) {
                return;
            }
            LogUtil.i(meishuVideoTextureView2.f5114a, "" + i + PPSLabelView.Code + i2);
            if (MeishuVideoTextureView.this.getParent() instanceof View) {
                measuredWidth = ((View) MeishuVideoTextureView.this.getParent()).getMeasuredWidth();
                measuredHeight = ((View) MeishuVideoTextureView.this.getParent()).getMeasuredHeight();
            } else {
                measuredWidth = MeishuVideoTextureView.this.getMeasuredWidth();
                measuredHeight = MeishuVideoTextureView.this.getMeasuredHeight();
            }
            Matrix matrixA = MeishuVideoTextureView.this.a(measuredWidth, measuredHeight);
            MeishuVideoTextureView meishuVideoTextureView3 = MeishuVideoTextureView.this;
            if (!meishuVideoTextureView3.k) {
                meishuVideoTextureView3.a(measuredWidth, measuredHeight, matrixA);
            } else {
                meishuVideoTextureView3.setTransform(matrixA);
                MeishuVideoTextureView.this.postInvalidate();
            }
        }
    }

    public class f extends m {
        public f() {
        }

        @Override // com.meishu.sdk.core.safe.m
        public boolean safeOnSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // com.meishu.sdk.core.safe.m
        public void safeOnSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        @Override // com.meishu.sdk.core.safe.m
        public void safeOnSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // com.meishu.sdk.core.safe.m
        public void safeOnSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            try {
                MeishuVideoTextureView meishuVideoTextureView = MeishuVideoTextureView.this;
                meishuVideoTextureView.n = surfaceTexture;
                if (meishuVideoTextureView.b != null) {
                    meishuVideoTextureView.h = new Surface(surfaceTexture);
                    MeishuVideoTextureView meishuVideoTextureView2 = MeishuVideoTextureView.this;
                    meishuVideoTextureView2.b.setSurface(meishuVideoTextureView2.h);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class g extends l {
        public g() {
        }

        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            MeishuVideoTextureView.this.requestLayout();
        }
    }

    public class h extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5122a;

        public h(MeishuVideoTextureView meishuVideoTextureView, int i) {
            this.f5122a = i;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            try {
                outline.setRoundRect(new Rect(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()), this.f5122a);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public MeishuVideoTextureView(Context context) {
        super(context);
        this.f5114a = getClass().getSimpleName();
        this.g = false;
        this.k = true;
        this.m = 1;
        this.o = new f();
        a();
    }

    public void a() {
        a(new MediaPlayer());
    }

    public void c() {
        LogUtil.d(this.f5114a, "pause");
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null || !this.g) {
            return;
        }
        try {
            mediaPlayer.pause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void d() {
        LogUtil.d(this.f5114a, ba.ag);
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.g) {
                return;
            }
            mediaPlayer.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void e() {
        LogUtil.d(this.f5114a, "start");
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.g) {
                return;
            }
            mediaPlayer.start();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public MediaPlayer getMediaPlayer() {
        return this.b;
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int measuredHeight;
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            if (getParent() instanceof View) {
                measuredWidth = ((View) getParent()).getMeasuredWidth();
                measuredHeight = ((View) getParent()).getMeasuredHeight();
            } else {
                measuredWidth = getMeasuredWidth();
                measuredHeight = getMeasuredHeight();
            }
            if (this.k) {
                return;
            }
            a(measuredWidth, measuredHeight, a(measuredWidth, measuredHeight));
        }
    }

    @Override // android.view.TextureView, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    public void setDisplayMode(int i) {
        if (i == 1 || i == 2) {
            this.m = i;
        }
    }

    public void setInitMute(boolean z) {
        if (z) {
            this.b.setVolume(0.0f, 0.0f);
        } else {
            this.b.setVolume(1.0f, 1.0f);
        }
    }

    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.b != null) {
            this.d = onCompletionListener;
        }
    }

    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        if (this.b != null) {
            this.e = onInfoListener;
        }
    }

    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        if (this.b != null) {
            this.c = onPreparedListener;
        }
    }

    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.f = onVideoSizeChangedListener;
    }

    public void setUseTransform(boolean z) {
        this.k = z;
    }

    public boolean b() {
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public int getCurrentPosition() {
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.g) {
                return 0;
            }
            return mediaPlayer.getCurrentPosition();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public int getDuration() {
        try {
            MediaPlayer mediaPlayer = this.b;
            if (mediaPlayer == null || !this.g) {
                return 0;
            }
            return mediaPlayer.getDuration();
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setOnErrorListener(onErrorListener);
        }
    }

    public void setRadius(int i) {
        try {
            setOutlineProvider(new h(this, i));
            setClipToOutline(true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(MediaPlayer mediaPlayer) {
        this.b = mediaPlayer;
        mediaPlayer.setAudioStreamType(3);
        this.b.setScreenOnWhilePlaying(true);
        this.b.setOnPreparedListener(new a());
        this.b.setOnCompletionListener(new b());
        this.b.setOnBufferingUpdateListener(new c());
        this.b.setOnInfoListener(new d());
        this.b.setOnVideoSizeChangedListener(new e());
        setSurfaceTextureListener(this.o);
    }

    public void setVideoPath(String str) {
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setDataSource(str);
            this.b.prepareAsync();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public Matrix a(float f2, float f3) {
        if (f2 == 0.0f || f3 == 0.0f || this.i == 0 || this.j == 0) {
            return null;
        }
        LogUtil.d(this.f5114a, "adjustVideoRadio " + f2 + PPSLabelView.Code + f3 + PPSLabelView.Code + this.i + PPSLabelView.Code + this.j);
        float f4 = f2 / this.i;
        float f5 = f3 / this.j;
        Matrix matrix = new Matrix();
        matrix.preTranslate((f2 - this.i) / 2.0f, (f3 - this.j) / 2.0f);
        matrix.preScale(this.i / f2, this.j / f3);
        if (2 == this.m) {
            matrix.postScale(f4, f5, f2 / 2.0f, f3 / 2.0f);
        } else if (f4 >= f5) {
            matrix.postScale(f5, f5, f2 / 2.0f, f3 / 2.0f);
        } else {
            matrix.postScale(f4, f4, f2 / 2.0f, f3 / 2.0f);
        }
        return matrix;
    }

    public final void a(int i, int i2, Matrix matrix) {
        if (matrix == null) {
            return;
        }
        RectF rectF = new RectF(0.0f, 0.0f, i, i2);
        matrix.mapRect(rectF);
        LogUtil.i(this.f5114a, "changeViewSize " + matrix + PPSLabelView.Code + ((int) rectF.width()) + PPSLabelView.Code + ((int) rectF.height()));
        getLayoutParams().width = (int) rectF.width();
        getLayoutParams().height = ((int) rectF.height()) + 1;
        post(new g());
    }

    public MeishuVideoTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5114a = getClass().getSimpleName();
        this.g = false;
        this.k = true;
        this.m = 1;
        this.o = new f();
        a();
    }

    public MeishuVideoTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5114a = getClass().getSimpleName();
        this.g = false;
        this.k = true;
        this.m = 1;
        this.o = new f();
        a();
    }
}
