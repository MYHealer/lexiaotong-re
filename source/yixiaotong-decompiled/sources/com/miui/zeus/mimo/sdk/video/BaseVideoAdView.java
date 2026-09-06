package com.miui.zeus.mimo.sdk.video;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.miui.zeus.comp.videoplayer.PlayState;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.d7;
import com.miui.zeus.mimo.sdk.i;
import com.miui.zeus.mimo.sdk.k6;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.n6;
import com.miui.zeus.mimo.sdk.s3;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import ijiami_1011.s.s.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class BaseVideoAdView extends FrameLayout {
    public static final String u = "BaseVideoAdView";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5650a;
    public TextureVideoView b;
    public ImageICP c;
    public final List<d7> d;
    public boolean e;
    public boolean f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public MimoAdInfo n;
    public File o;
    public boolean p;
    public final TextureVideoView.c q;
    public final TextureVideoView.e r;
    public final TextureVideoView.f s;
    public final Runnable t;

    public class a implements TextureVideoView.c {
        public a() {
        }
    }

    public class b implements TextureVideoView.e {
        public b() {
        }
    }

    public class c implements TextureVideoView.f {
        public c() {
        }
    }

    public class d implements Runnable {
        public d() {
        }

        /* JADX WARN: Undo finally extract visitor
        java.lang.NullPointerException: Cannot invoke "Object.hashCode()" because "this.second" is null
        	at jadx.core.utils.Pair.hashCode(Pair.java:35)
        	at java.base/java.util.HashMap.hash(HashMap.java:338)
        	at java.base/java.util.HashMap.getNode(HashMap.java:568)
        	at java.base/java.util.HashMap.containsKey(HashMap.java:594)
        	at jadx.core.dex.visitors.finaly.traverser.state.TraverserGlobalCommonState.hasBlocksBeenCached(TraverserGlobalCommonState.java:35)
        	at jadx.core.dex.visitors.finaly.traverser.handlers.MergePathActivePathTraverserHandler.handle(MergePathActivePathTraverserHandler.java:174)
        	at jadx.core.dex.visitors.finaly.traverser.handlers.AbstractActivePathTraverserHandler.process(AbstractActivePathTraverserHandler.java:19)
        	at jadx.core.dex.visitors.finaly.traverser.TraverserController.processHandlerImplementations(TraverserController.java:43)
        	at jadx.core.dex.visitors.finaly.traverser.TraverserController.advance(TraverserController.java:156)
        	at jadx.core.dex.visitors.finaly.traverser.TraverserController.process(TraverserController.java:79)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.findCommonInsns(MarkFinallyVisitor.java:404)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.extractFinally(MarkFinallyVisitor.java:284)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.processTryBlock(MarkFinallyVisitor.java:202)
        	at jadx.core.dex.visitors.finaly.MarkFinallyVisitor.visit(MarkFinallyVisitor.java:135)
         */
        @Override // java.lang.Runnable
        public void run() {
            TextureVideoView textureVideoView;
            int currentPosition;
            BaseVideoAdView baseVideoAdView;
            BaseVideoAdView baseVideoAdView2 = BaseVideoAdView.this;
            if (!baseVideoAdView2.f || baseVideoAdView2.h > baseVideoAdView2.g || !baseVideoAdView2.p) {
                if (!baseVideoAdView2.f5650a || (textureVideoView = baseVideoAdView2.b) == null) {
                    return;
                }
                try {
                    try {
                        if (textureVideoView.isPlaying() && (currentPosition = BaseVideoAdView.this.b.getCurrentPosition()) >= 0) {
                            int duration = BaseVideoAdView.this.b.getDuration();
                            if (duration < 0 || currentPosition > duration) {
                                TextureVideoView textureVideoView2 = BaseVideoAdView.this.b;
                                if (textureVideoView2.s) {
                                    textureVideoView2.seekTo(0);
                                } else {
                                    textureVideoView2.pause();
                                    BaseVideoAdView.a(BaseVideoAdView.this);
                                }
                            } else {
                                int i = (int) ((currentPosition * 100.0f) / duration);
                                String str = BaseVideoAdView.u;
                                m.d(BaseVideoAdView.u, s.d(new byte[]{118, 77, 70, 67, 6, 91, Ascii.NAK, 68, Ascii.SYN, 13, 66, 12, 65, 81, 91, 95, 89, Ascii.NAK}, "5841c5") + i + s.d(new byte[]{19}, "628642"));
                                ImageICP imageICP = BaseVideoAdView.this.c;
                                if (imageICP != null) {
                                    imageICP.setVisibility(8);
                                }
                                BaseVideoAdView.a(BaseVideoAdView.this, i);
                                Iterator<d7> it = BaseVideoAdView.this.d.iterator();
                                while (it.hasNext()) {
                                    it.next().onVideoProgressUpdate(currentPosition, duration);
                                }
                            }
                        }
                    } catch (Exception e) {
                        String str2 = BaseVideoAdView.u;
                        m.b(BaseVideoAdView.u, s.d(new byte[]{101, 66, 80, 17, Ascii.US, 70, 17, 11, Ascii.NAK, 11, 69, 12, 91, 89, Ascii.NAK, 6, Ascii.RS, 5, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11}, "475cff"), e);
                    }
                    BaseVideoAdView baseVideoAdView3 = BaseVideoAdView.this;
                    baseVideoAdView3.postDelayed(baseVideoAdView3.t, 500L);
                    return;
                } catch (Throwable th) {
                    BaseVideoAdView baseVideoAdView4 = BaseVideoAdView.this;
                    baseVideoAdView4.postDelayed(baseVideoAdView4.t, 500L);
                    throw th;
                }
            }
            try {
                try {
                    for (d7 d7Var : baseVideoAdView2.d) {
                        BaseVideoAdView baseVideoAdView5 = BaseVideoAdView.this;
                        d7Var.onVideoProgressUpdate(baseVideoAdView5.h, baseVideoAdView5.g);
                    }
                    baseVideoAdView = BaseVideoAdView.this;
                    int i2 = baseVideoAdView.h + 1000;
                    baseVideoAdView.h = i2;
                    if (i2 > baseVideoAdView.g) {
                        Iterator<d7> it2 = baseVideoAdView.d.iterator();
                        while (it2.hasNext()) {
                            it2.next().onPicEnd();
                        }
                        BaseVideoAdView.this.a(AdEvent.PIC_FINISH);
                        return;
                    }
                } catch (Throwable th2) {
                    BaseVideoAdView baseVideoAdView6 = BaseVideoAdView.this;
                    if (baseVideoAdView6.h > baseVideoAdView6.g) {
                        Iterator<d7> it3 = baseVideoAdView6.d.iterator();
                        while (it3.hasNext()) {
                            it3.next().onPicEnd();
                        }
                        BaseVideoAdView.this.a(AdEvent.PIC_FINISH);
                    } else {
                        baseVideoAdView6.postDelayed(baseVideoAdView6.t, 1000L);
                    }
                    throw th2;
                }
            } catch (Exception e2) {
                String str3 = BaseVideoAdView.u;
                m.b(BaseVideoAdView.u, s.d(new byte[]{105, SignedBytes.MAX_POWER_OF_TWO, 86, 19, 79, 19, 17, 11, Ascii.NAK, 11, 69, 12, 87, 91, 19, 4, 78, 80, 4, Ascii.DC4, Ascii.DC2, 11, 94, 11}, "853a63"), e2);
                baseVideoAdView = BaseVideoAdView.this;
                if (baseVideoAdView.h > baseVideoAdView.g) {
                    Iterator<d7> it4 = baseVideoAdView.d.iterator();
                    while (it4.hasNext()) {
                        it4.next().onPicEnd();
                    }
                }
                baseVideoAdView.postDelayed(baseVideoAdView.t, 1000L);
            }
            baseVideoAdView.postDelayed(baseVideoAdView.t, 1000L);
        }
    }

    public BaseVideoAdView(Context context) {
        this(context, null);
    }

    public BaseVideoAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseVideoAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = new ArrayList();
        this.e = true;
        this.f = false;
        this.p = true;
        this.q = new a();
        this.r = new b();
        this.s = new c();
        this.t = new d();
        a(context);
    }

    public static void a(BaseVideoAdView baseVideoAdView) {
        baseVideoAdView.f5650a = false;
        Iterator<d7> it = baseVideoAdView.d.iterator();
        while (it.hasNext()) {
            it.next().onVideoEnd();
        }
        if (baseVideoAdView.m) {
            return;
        }
        baseVideoAdView.m = true;
        baseVideoAdView.a(AdEvent.VIDEO_FINISH);
    }

    public void a() {
        TextureVideoView textureVideoView = this.b;
        if (textureVideoView != null && textureVideoView.isPlaying()) {
            this.b.pause();
            Iterator<d7> it = this.d.iterator();
            while (it.hasNext()) {
                it.next().onVideoPause();
            }
            if (this.l) {
                a(AdEvent.VIDEO_PAUSE);
            }
        }
        removeCallbacks(this.t);
    }

    public void b() {
        try {
            this.b.e();
            removeCallbacks(this.t);
            this.d.clear();
            this.b.setOnCompletionListener(null);
            this.b.setOnPreparedListener(null);
            this.b.setOnRenderListener(null);
        } catch (Exception unused) {
        }
    }

    public abstract void b(Context context);

    public void c() {
        TextureVideoView textureVideoView = this.b;
        if (textureVideoView == null || textureVideoView.isPlaying()) {
            return;
        }
        TextureVideoView textureVideoView2 = this.b;
        i iVar = textureVideoView2.e;
        if (iVar != null && iVar.getPlayState() != PlayState.PLAYING) {
            textureVideoView2.e.start();
        }
        Iterator<d7> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onVideoResume();
        }
        if (this.l) {
            a(AdEvent.VIDEO_RESUME);
        }
        removeCallbacks(this.t);
        post(this.t);
    }

    public MimoAdInfo getAdInfo() {
        return this.n;
    }

    public abstract ImageICP getBackgroundImageView();

    public int getDuration() {
        if (!this.f) {
            return this.b.getDuration();
        }
        this.n.getClass();
        return (int) SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
    }

    public abstract TextureVideoView getTextureVideoView();

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setLooping(boolean z) {
        TextureVideoView textureVideoView = this.b;
        if (textureVideoView != null) {
            textureVideoView.setLooping(z);
        }
    }

    public void setMute(boolean z) {
        if (this.e == z) {
            return;
        }
        this.e = z;
        this.b.setMute(z);
        boolean z2 = this.e;
        Iterator<d7> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(z2);
        }
    }

    public void setOnVideoAdListener(d7 d7Var) {
        if (this.d.contains(d7Var)) {
            return;
        }
        this.d.add(d7Var);
    }

    public void setPicStartCountDown(boolean z) {
        this.p = z;
    }

    public static void a(BaseVideoAdView baseVideoAdView, int i) {
        AdEvent adEvent;
        baseVideoAdView.getClass();
        if (i >= 25 && !baseVideoAdView.i) {
            baseVideoAdView.i = true;
            adEvent = AdEvent.VIDEO_Q1;
        } else if (i >= 50 && !baseVideoAdView.j) {
            baseVideoAdView.j = true;
            adEvent = AdEvent.VIDEO_Q2;
        } else if (i >= 75 && !baseVideoAdView.k) {
            baseVideoAdView.k = true;
            adEvent = AdEvent.VIDEO_Q3;
        } else {
            if (i < 95 || baseVideoAdView.m) {
                return;
            }
            baseVideoAdView.m = true;
            adEvent = AdEvent.VIDEO_FINISH;
        }
        baseVideoAdView.a(adEvent);
    }

    public static void a(BaseVideoAdView baseVideoAdView, boolean z, String str, String str2) {
        String str3;
        s3 s3Var;
        String strD;
        String strD2;
        MimoAdInfo mimoAdInfo = baseVideoAdView.n;
        if (mimoAdInfo == null) {
            return;
        }
        if (mimoAdInfo.v()) {
            MimoAdInfo mimoAdInfo2 = baseVideoAdView.n;
            str3 = mimoAdInfo2.u;
            s3Var = mimoAdInfo2.e0;
            strD = s.d(new byte[]{111, 121, 115, 32, 118, 110, 45, 43, 39, 38}, "907e91");
            strD2 = z ? s.d(new byte[]{Ascii.NAK, 80, 5, 3, 9, 58, 14, 10, 10, 11, 95, 0, 60, 95, 0, 15, 10, 58, 13, 11, 7, 6}, "c9affe") : s.d(new byte[]{19, 90, 83, 81, 86, 102, 14, 10, 10, 11, 95, 0, 58, SignedBytes.MAX_POWER_OF_TWO, 66, 87, 90, 92, Ascii.DC2, Ascii.ETB, 57, 14, 94, 4, 1}, "e37499");
        } else {
            File file = baseVideoAdView.o;
            if (file == null || !file.exists()) {
                return;
            }
            MimoAdInfo mimoAdInfo3 = baseVideoAdView.n;
            str3 = mimoAdInfo3.u;
            s3Var = mimoAdInfo3.e0;
            strD = s.d(new byte[]{97, 125, 113, 117, 121, 107, 45, 43, 39, 38}, "745064");
            strD2 = z ? s.d(new byte[]{Ascii.DC2, 80, 81, 80, 91, 108, 2, 5, 5, 10, 84, 58, 2, 88, 92, 89, 107, 95, 14, 5, 2}, "d95543") : s.d(new byte[]{68, 13, 2, 1, 13, 105, 2, 5, 5, 10, 84, 58, 65, 17, 5, 7, 7, 69, Ascii.DC2, 59, 10, 13, 80, 1}, "2dfdb6");
        }
        com.miui.zeus.mimo.sdk.b.a(str3, s3Var, strD, strD2, System.currentTimeMillis(), str, str2);
    }

    public final void a(Context context) {
        b(context);
        this.b = getTextureVideoView();
        this.c = getBackgroundImageView();
        this.b.setOnCompletionListener(this.q);
        this.b.setOnPreparedListener(this.r);
        this.b.setOnRenderListener(this.s);
        this.b.setKeepScreenOn(true);
        boolean z = this.e;
        Iterator<d7> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().onVolumeChanged(z);
        }
    }

    public final void a(AdEvent adEvent) {
        MimoAdInfo mimoAdInfo;
        k6 k6Var;
        if (this.n.v()) {
            mimoAdInfo = this.n;
            String strValueOf = String.valueOf(true);
            k6Var = new k6();
            k6Var.c = strValueOf;
        } else {
            mimoAdInfo = this.n;
            String strValueOf2 = String.valueOf(false);
            k6Var = new k6();
            k6Var.c = strValueOf2;
        }
        com.miui.zeus.mimo.sdk.b.a(adEvent, mimoAdInfo, (n6) null, k6Var);
    }
}
