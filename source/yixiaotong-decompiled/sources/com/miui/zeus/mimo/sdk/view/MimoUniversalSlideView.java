package com.miui.zeus.mimo.sdk.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.a0;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.f9;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.m;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.y8;
import ijiami_1011.s.s.s;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MimoUniversalSlideView extends LinearLayout implements h8 {
    public static final /* synthetic */ int g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RootICP f5672a;
    public double b;
    public boolean c;
    public boolean d;
    public final Runnable e;
    public final Runnable f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MimoUniversalSlideView.this.d = true;
            MimoUniversalSlideView.a(MimoUniversalSlideView.this);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MimoUniversalSlideView mimoUniversalSlideView = MimoUniversalSlideView.this;
            int i = MimoUniversalSlideView.g;
            mimoUniversalSlideView.a();
        }
    }

    public MimoUniversalSlideView(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public MimoUniversalSlideView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 0.0d;
        this.c = false;
        this.d = false;
        this.e = new a();
        this.f = new b();
    }

    public static void a(MimoUniversalSlideView mimoUniversalSlideView) {
        RootICP rootICP;
        mimoUniversalSlideView.getClass();
        m.a(s.d(new byte[]{40, 88, 85, 14, 101, 94, 8, Ascii.DC2, 3, 16, 66, 4, 9, 98, 84, 8, 84, 85, 55, 13, 3, Ascii.NAK}, "e18a00"), s.d(new byte[]{66, 81, 90, 78, Ascii.SYN, 90, 51, 1, Ascii.NAK, 13, 68, Ascii.ETB, 82, 92, 103, 92, 87, 83, Ascii.CAN, 94, 70}, "195967") + mimoUniversalSlideView.c + s.d(new byte[]{72, Ascii.SYN, 85, 98, 80, 93, Ascii.SYN, 94, 70}, "d68182") + mimoUniversalSlideView.d);
        mimoUniversalSlideView.setVisibility(0);
        if (mimoUniversalSlideView.c && mimoUniversalSlideView.d && (rootICP = mimoUniversalSlideView.f5672a) != null) {
            rootICP.setUniversalSlideSlop(true, mimoUniversalSlideView.b);
        }
    }

    public final void a() {
        m.a(s.d(new byte[]{124, 93, 88, 88, 101, 15, 8, Ascii.DC2, 3, 16, 66, 4, 93, 103, 89, 94, 84, 4, 55, 13, 3, Ascii.NAK}, "14570a"), s.d(new byte[]{89, 88, 84, 4}, "110a76"));
        setVisibility(8);
        RootICP rootICP = this.f5672a;
        if (rootICP != null) {
            rootICP.setUniversalSlideSlop(false, this.b);
        }
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_UNIVERSAL_SLIDE;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = y8.b;
        handler.removeCallbacks(this.e);
        handler.removeCallbacks(this.f);
        a();
    }

    public void a(final MimoAdInfo mimoAdInfo, RootICP rootICP) {
        setVisibility(8);
        this.f5672a = rootICP;
        View viewInflate = LayoutInflater.from(getContext()).inflate(a0.q0, (ViewGroup) this, true);
        final View viewFindViewById = viewInflate.findViewById(a0.g4);
        ImageICP imageICP = (ImageICP) viewInflate.findViewById(a0.F3);
        imageICP.a(mimoAdInfo.m1, (i8) null, new RequestListener<Drawable>() { // from class: com.miui.zeus.mimo.sdk.view.MimoUniversalSlideView.1
            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
                m.b(s.d(new byte[]{116, 91, 90, 95, 96, 93, 8, Ascii.DC2, 3, 16, 66, 4, 85, 97, 91, 89, 81, 86, 55, 13, 3, Ascii.NAK}, "927053"), mimoAdInfo.m1 + s.d(new byte[]{Ascii.SYN, 92, 91, 120, 89, 5, 5, 34, 7, 11, 93, 0, 82, 9, Ascii.NAK}, "63546d"), glideException);
                MimoUniversalSlideView mimoUniversalSlideView = MimoUniversalSlideView.this;
                int i = MimoUniversalSlideView.g;
                mimoUniversalSlideView.getClass();
                Handler handler = y8.b;
                handler.removeCallbacks(mimoUniversalSlideView.e);
                handler.removeCallbacks(mimoUniversalSlideView.f);
                mimoUniversalSlideView.a();
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
                m.a(s.d(new byte[]{125, 80, 93, 86, 55, 91, 8, Ascii.DC2, 3, 16, 66, 4, 92, 106, 92, 80, 6, 80, 55, 13, 3, Ascii.NAK}, "0909b5"), mimoAdInfo.m1 + s.d(new byte[]{70, 13, 90, 55, 3, Ascii.SYN, 14, 17, Ascii.DC4, 1, 84, 55, 3, 3, 80, Ascii.FS}, "fb4efe"));
                MimoUniversalSlideView.this.c = true;
                viewFindViewById.setVisibility(0);
                MimoUniversalSlideView.a(MimoUniversalSlideView.this);
                return false;
            }
        });
        imageICP.setClickAreaType(ClickAreaType.TYPE_UNIVERSAL_SLIDE);
        m.a(s.d(new byte[]{126, 89, 92, 13, 100, 95, 8, Ascii.DC2, 3, 16, 66, 4, 95, 99, 93, 11, 85, 84, 55, 13, 3, Ascii.NAK}, "301b11"), s.d(new byte[]{85, 12, 8, 94, 92, 82, 52, 10, 15, Ascii.DC4, 84, Ascii.ETB, 69, 2, 10, 107, 89, 92, 5, 1, 48, 11, 84, Ascii.DC2}, "6cf855"));
        long j = mimoAdInfo.k1;
        long j2 = mimoAdInfo.l1;
        this.b = mimoAdInfo.c1 * f9.c(getContext());
        Handler handler = y8.b;
        handler.postDelayed(this.e, j * 1000);
        handler.postDelayed(this.f, (j + j2) * 1000);
    }
}
