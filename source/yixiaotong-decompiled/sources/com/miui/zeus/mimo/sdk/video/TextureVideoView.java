package com.miui.zeus.mimo.sdk.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.net.Uri;
import android.opengl.GLES20;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.MediaController;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.comp.videoplayer.PlayException;
import com.miui.zeus.comp.videoplayer.PlayState;
import com.miui.zeus.comp.zeusplayer.xiaomiplayer.ZeusMediaXiaoMiPlayer;
import com.miui.zeus.mimo.sdk.d7;
import com.miui.zeus.mimo.sdk.h;
import com.miui.zeus.mimo.sdk.i;
import com.miui.zeus.mimo.sdk.j;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.y8;
import com.stub.StubApp;
import ijiami_1011.s.s.s;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TextureVideoView extends TextureView implements MediaController.MediaPlayerControl {
    public static final String w = "TextureVideoView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, String> f5658a;
    public int b;
    public int c;
    public Surface d;
    public i e;
    public int f;
    public int g;
    public int h;
    public MediaController i;
    public c j;
    public e k;
    public f l;
    public d m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public Uri u;
    public TextureView.SurfaceTextureListener v;

    public class a implements h {
        public a() {
        }

        @Override // com.miui.zeus.mimo.sdk.h
        public void a(int i, int i2) {
            TextureVideoView.this.c();
        }

        @Override // com.miui.zeus.mimo.sdk.h
        public void a(PlayException playException, int i, int i2) {
            TextureVideoView textureVideoView = TextureVideoView.this;
            Throwable th = playException != null ? playException.cause : null;
            String str = TextureVideoView.w;
            textureVideoView.a(i, i2, th);
        }

        @Override // com.miui.zeus.mimo.sdk.h
        public void a(PlayState playState, PlayState playState2) {
        }

        @Override // com.miui.zeus.mimo.sdk.h
        public void a(boolean z) {
        }

        @Override // com.miui.zeus.mimo.sdk.h
        public void b() {
            TextureVideoView textureVideoView = TextureVideoView.this;
            f fVar = textureVideoView.l;
            if (fVar != null) {
                i iVar = textureVideoView.e;
                BaseVideoAdView.c cVar = (BaseVideoAdView.c) fVar;
                Iterator<d7> it = BaseVideoAdView.this.d.iterator();
                while (it.hasNext()) {
                    it.next().onCreateViewSuccess(iVar);
                }
                BaseVideoAdView.a(BaseVideoAdView.this, false, String.valueOf(0), s.d(new byte[]{-125, -22, -11, -47, -18, -2}, "ebe4da"));
            }
        }

        @Override // com.miui.zeus.mimo.sdk.h
        public void c() {
            MediaController mediaController;
            TextureVideoView textureVideoView = TextureVideoView.this;
            if (textureVideoView.e == null) {
                return;
            }
            textureVideoView.b = 2;
            textureVideoView.q = true;
            textureVideoView.p = true;
            textureVideoView.o = true;
            e eVar = textureVideoView.k;
            if (eVar != null) {
                BaseVideoAdView.b bVar = (BaseVideoAdView.b) eVar;
                BaseVideoAdView.this.f5650a = true;
                BaseVideoAdView baseVideoAdView = BaseVideoAdView.this;
                baseVideoAdView.b.setMute(baseVideoAdView.e);
                BaseVideoAdView baseVideoAdView2 = BaseVideoAdView.this;
                boolean z = baseVideoAdView2.e;
                Iterator<d7> it = baseVideoAdView2.d.iterator();
                while (it.hasNext()) {
                    it.next().onVolumeChanged(z);
                }
                BaseVideoAdView.this.b.start();
                BaseVideoAdView baseVideoAdView3 = BaseVideoAdView.this;
                baseVideoAdView3.removeCallbacks(baseVideoAdView3.t);
                BaseVideoAdView baseVideoAdView4 = BaseVideoAdView.this;
                baseVideoAdView4.post(baseVideoAdView4.t);
                Iterator<d7> it2 = BaseVideoAdView.this.d.iterator();
                while (it2.hasNext()) {
                    it2.next().onVideoStart();
                }
                BaseVideoAdView baseVideoAdView5 = BaseVideoAdView.this;
                if (!baseVideoAdView5.l) {
                    baseVideoAdView5.l = true;
                    BaseVideoAdView.this.a(AdEvent.VIDEO_START);
                }
            }
            MediaController mediaController2 = textureVideoView.i;
            if (mediaController2 != null) {
                mediaController2.setEnabled(true);
            }
            textureVideoView.g = textureVideoView.e.getVideoWidth();
            textureVideoView.h = textureVideoView.e.getVideoHeight();
            int i = textureVideoView.n;
            if (i != 0) {
                textureVideoView.seekTo(i);
            }
            if (textureVideoView.g == 0 || textureVideoView.h == 0) {
                if (textureVideoView.c == 3) {
                    textureVideoView.start();
                    return;
                }
                return;
            }
            textureVideoView.getSurfaceTexture().setDefaultBufferSize(textureVideoView.g, textureVideoView.h);
            if (textureVideoView.c == 3) {
                textureVideoView.start();
                MediaController mediaController3 = textureVideoView.i;
                if (mediaController3 != null) {
                    mediaController3.show();
                    return;
                }
                return;
            }
            if (textureVideoView.isPlaying()) {
                return;
            }
            if ((i != 0 || textureVideoView.getCurrentPosition() > 0) && (mediaController = textureVideoView.i) != null) {
                mediaController.show(0);
            }
        }

        @Override // com.miui.zeus.mimo.sdk.h
        public void a() {
            TextureVideoView textureVideoView = TextureVideoView.this;
            if (textureVideoView.s) {
                d dVar = textureVideoView.m;
                if (dVar != null) {
                    dVar.a(textureVideoView.e);
                }
                TextureVideoView.this.d();
                return;
            }
            textureVideoView.b = 5;
            textureVideoView.c = 5;
            MediaController mediaController = textureVideoView.i;
            if (mediaController != null) {
                mediaController.hide();
            }
            c cVar = textureVideoView.j;
            if (cVar != null) {
                BaseVideoAdView.a(BaseVideoAdView.this);
            }
        }
    }

    public class b implements TextureView.SurfaceTextureListener {
        public b() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureVideoView.this.d = new Surface(surfaceTexture);
            TextureVideoView.this.d();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Surface surface = TextureVideoView.this.d;
            if (surface != null) {
                surface.release();
                TextureVideoView.this.d = null;
            }
            MediaController mediaController = TextureVideoView.this.i;
            if (mediaController != null) {
                mediaController.hide();
            }
            TextureVideoView.this.a(true);
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            TextureVideoView textureVideoView = TextureVideoView.this;
            boolean z = textureVideoView.c == 3;
            boolean z2 = i > 0 && i2 > 0;
            if (textureVideoView.e != null && z && z2) {
                int i3 = textureVideoView.n;
                if (i3 != 0) {
                    textureVideoView.seekTo(i3);
                }
                TextureVideoView.this.start();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public interface c {
    }

    public interface d {
        void a(i iVar);
    }

    public interface e {
    }

    public interface f {
    }

    public TextureVideoView(Context context) {
        this(context, null);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextureVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = true;
        this.s = false;
        this.t = true;
        b bVar = new b();
        this.v = bVar;
        this.g = 0;
        this.h = 0;
        setSurfaceTextureListener(bVar);
        setFocusable(true);
        setClickable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.b = 0;
        this.c = 0;
    }

    private void setVideoURI(Uri uri) {
        this.u = uri;
        this.f5658a = null;
        this.n = 0;
        d();
        requestLayout();
        invalidate();
    }

    public final void a() {
        MediaController mediaController;
        if (this.e == null || (mediaController = this.i) == null) {
            return;
        }
        mediaController.setMediaPlayer(this);
        this.i.setAnchorView(getParent() instanceof View ? (View) getParent() : this);
        this.i.setEnabled(b());
    }

    public final void a(int i, int i2, Throwable th) {
        m.b(w, s.d(new byte[]{113, Ascii.ETB, 19, 9, 17, 89, 65}, "4eafcc") + i + s.d(new byte[]{26}, "680e49") + i2);
        this.b = -1;
        this.c = -1;
        MediaController mediaController = this.i;
        if (mediaController != null) {
            mediaController.hide();
        }
        f fVar = this.l;
        if (fVar != null) {
            BaseVideoAdView.c cVar = (BaseVideoAdView.c) fVar;
            cVar.getClass();
            String str = BaseVideoAdView.u;
            m.b(BaseVideoAdView.u, s.d(new byte[]{19, 90, 83, Ascii.US, 68, 85, 19, Ascii.SYN, 9, 16, 17, Ascii.DC2, 11, 87, 70, 91}, "c62fd0") + i + s.d(new byte[]{Ascii.DC4, Ascii.EM, 1, 72, 16, 70, 0, 89}, "89d0d4") + i2);
            BaseVideoAdView.this.f5650a = false;
            Iterator<d7> it = BaseVideoAdView.this.d.iterator();
            while (it.hasNext()) {
                it.next().onVideoError();
            }
            BaseVideoAdView.a(BaseVideoAdView.this, true, String.valueOf(i2), ((th == null || th.getMessage() == null) ? new StringBuilder().append(s.d(new byte[]{70, 89, 83, Ascii.ESC, Ascii.EM, 85, 19, Ascii.SYN, 9, 16, 17, Ascii.DC2, 94, 84, 70, 95}, "652b90")).append(i).append(s.d(new byte[]{Ascii.FS, 65, 84, 72, Ascii.ETB, Ascii.SYN, 0, 89}, "0a10cd")).append(i2) : new StringBuilder().append(s.d(new byte[]{69, 91, 7, 72, Ascii.NAK, 4, 19, Ascii.SYN, 9, 16, 17, Ascii.DC2, 93, 86, Ascii.DC2, 12}, "57f15a")).append(i).append(s.d(new byte[]{72, Ascii.NAK, 81, 65, Ascii.NAK, 65, 0, 89}, "d549a3")).append(i2).append(s.d(new byte[]{Ascii.FS, Ascii.CAN, 65, 81, 69, 95, Ascii.SYN, 5, 4, 14, 84, 88}, "085970")).append(th.getMessage())).toString());
        }
    }

    public final void a(boolean z) {
        i iVar = this.e;
        if (iVar != null) {
            iVar.release();
            this.e = null;
            this.b = 0;
            if (z) {
                this.c = 0;
            }
            if (this.r) {
                ((AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService(s.d(new byte[]{81, Ascii.DC4, 87, 92, 13}, "0a35b8"))).abandonAudioFocus(null);
            }
        }
    }

    public final boolean b() {
        int i;
        return (this.e == null || (i = this.b) == -1 || i == 0 || i == 1) ? false : true;
    }

    public void c() {
        i iVar = this.e;
        if (iVar == null) {
            return;
        }
        this.g = iVar.getVideoWidth();
        int videoHeight = this.e.getVideoHeight();
        this.h = videoHeight;
        if (this.g == 0 || videoHeight == 0) {
            return;
        }
        getSurfaceTexture().setDefaultBufferSize(this.g, this.h);
        requestLayout();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return this.o;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return this.p;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return this.q;
    }

    public final void d() {
        if (this.u == null || this.d == null) {
            return;
        }
        a(false);
        if (this.r) {
            ((AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService(s.d(new byte[]{5, Ascii.ETB, 0, 13, 89}, "dbdd6c"))).requestAudioFocus(null, 3, 1);
        }
        try {
            if (this.t) {
                Context context = y8.f5752a;
                com.miui.zeus.mimo.sdk.b.f5368a = ZeusMediaXiaoMiPlayer.class;
                this.e = com.miui.zeus.mimo.sdk.b.c(context);
                m.a(w, s.d(new byte[]{91, 75, 83, 82, SignedBytes.MAX_POWER_OF_TWO, 4, 65, Ascii.FS, 15, 3, 94, 8, 81, Ascii.EM, 91, 86, 80, 8, 0, 52, 10, 3, 72, 0, 74}, "89634a"));
            } else {
                Context context2 = y8.f5752a;
                com.miui.zeus.mimo.sdk.b.f5368a = j.class;
                this.e = com.miui.zeus.mimo.sdk.b.c(context2);
                m.a(w, s.d(new byte[]{90, 75, 86, 84, 77, 80, 65, Ascii.ETB, Ascii.US, 17, 69, 0, 84, Ascii.EM, 94, 80, 93, 92, 0, 52, 10, 3, 72, 0, 75}, "993595"));
            }
            this.f = getAudioSessionId();
            this.e.addEventListener(new a());
            this.e.setSurface(this.d);
            this.e.setScreenOnWhilePlaying(true);
            this.e.open(this.u.toString(), this.f5658a);
            this.e.setLooping(this.s);
            this.b = 1;
            a();
        } catch (Exception e2) {
            this.b = -1;
            this.c = -1;
            a(1, 0, e2);
        }
    }

    public void e() {
        i iVar = this.e;
        if (iVar != null) {
            iVar.stop();
            this.e.release();
            this.e = null;
            this.b = 0;
            this.c = 0;
            if (this.r) {
                ((AudioManager) StubApp.getOrigApplicationContext(getContext().getApplicationContext()).getSystemService(s.d(new byte[]{0, 16, 0, 15, 86}, "aedf9a"))).abandonAudioFocus(null);
            }
        }
        if (this.d == null) {
            return;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        egl10.eglInitialize(eGLDisplayEglGetDisplay, null);
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        egl10.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344}, eGLConfigArr, 1, new int[1]);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        EGLSurface eGLSurfaceEglCreateWindowSurface = egl10.eglCreateWindowSurface(eGLDisplayEglGetDisplay, eGLConfig, this.d, new int[]{12344});
        egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, eGLContextEglCreateContext);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16384);
        egl10.eglSwapBuffers(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
        egl10.eglDestroySurface(eGLDisplayEglGetDisplay, eGLSurfaceEglCreateWindowSurface);
        EGLSurface eGLSurface = EGL10.EGL_NO_SURFACE;
        egl10.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
        egl10.eglDestroyContext(eGLDisplayEglGetDisplay, eGLContextEglCreateContext);
        egl10.eglTerminate(eGLDisplayEglGetDisplay);
    }

    public final void f() {
        if (this.i.isShowing()) {
            this.i.hide();
        } else {
            this.i.show();
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return this.f;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (b()) {
            return (int) this.e.getCurrentPosition();
        }
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (b()) {
            return (int) this.e.getDuration();
        }
        return -1;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return b() && this.e.getPlayState() == PlayState.PLAYING;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureVideoView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureVideoView.class.getName());
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z = (i == 4 || i == 24 || i == 25 || i == 164 || i == 82 || i == 5 || i == 6) ? false : true;
        if (b() && z && this.i != null) {
            if (i == 79 || i == 85) {
                if (this.e.getPlayState() == PlayState.PLAYING) {
                    pause();
                    this.i.show();
                } else {
                    start();
                    this.i.hide();
                }
                return true;
            }
            if (i == 126) {
                if (this.e.getPlayState() != PlayState.PLAYING) {
                    start();
                    this.i.hide();
                }
                return true;
            }
            if (i == 86 || i == 127) {
                if (this.e.getPlayState() == PlayState.PLAYING) {
                    pause();
                    this.i.show();
                }
                return true;
            }
            f();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int defaultSize = TextureView.getDefaultSize(this.g, i);
        int defaultSize2 = TextureView.getDefaultSize(this.h, i2);
        View.MeasureSpec.getMode(i);
        View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.g;
        if (i4 > 0 && (i3 = this.h) > 0 && size > 0 && size2 > 0) {
            float f2 = (i4 * 1.0f) / i3;
            float f3 = size;
            float f4 = size2;
            if (f2 > (f3 * 1.0f) / f4) {
                defaultSize = (int) (f4 * f2);
                defaultSize2 = size2;
            } else {
                defaultSize2 = (int) (f3 / f2);
                defaultSize = size;
            }
        }
        if (defaultSize > size || defaultSize2 > size2) {
            float f5 = defaultSize;
            float f6 = (f5 * 1.0f) / size;
            float f7 = defaultSize2;
            float fMax = Math.max(f6, (1.0f * f7) / size2);
            defaultSize = (int) (f5 / fMax);
            defaultSize2 = (int) (f7 / fMax);
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!b() || this.i == null) {
            return false;
        }
        f();
        return false;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!b() || this.i == null) {
            return false;
        }
        f();
        return false;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (b() && this.e.getPlayState() == PlayState.PLAYING) {
            this.e.pause();
            this.b = 4;
        }
        this.c = 4;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        if (b()) {
            this.e.seekTo(i);
            i = 0;
        }
        this.n = i;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
    }

    public void setData(Uri uri) {
        this.u = uri;
        this.f5658a = null;
        this.n = 0;
        d();
        requestLayout();
        invalidate();
    }

    public void setLooping(boolean z) {
        this.s = z;
    }

    public void setMediaController(MediaController mediaController) {
        MediaController mediaController2 = this.i;
        if (mediaController2 != null) {
            mediaController2.hide();
        }
        this.i = mediaController;
        a();
    }

    public void setMute(boolean z) {
        i iVar = this.e;
        if (iVar != null) {
            iVar.setMute(z);
        }
    }

    public void setOnCompletionListener(c cVar) {
        this.j = cVar;
    }

    public void setOnLooperListener(d dVar) {
        this.m = dVar;
    }

    public void setOnPreparedListener(e eVar) {
        this.k = eVar;
    }

    public void setOnRenderListener(f fVar) {
        this.l = fVar;
    }

    public void setShouldRequestAudioFocus(boolean z) {
        this.r = z;
    }

    public void setUseXiaomiVideoPlayer(boolean z) {
        this.t = z;
    }

    public void setVideoPath(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        setVideoURI(this.t ? Uri.parse(file.getAbsolutePath()) : Uri.fromFile(file));
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (b()) {
            this.e.start();
            this.b = 3;
        }
        this.c = 3;
    }
}
