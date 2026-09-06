package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.MimoUniversalSlideView;
import com.miui.zeus.mimo.sdk.view.component.CloseICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public abstract class j0 extends RootICP implements IBindDataView, d7, SixElementsView.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView f5477a;
    public MimoMediaView b;
    public SixElementsView c;
    public MimoAdInfo d;
    public long e;
    public long f;
    public boolean g;
    public CloseICP h;
    public w3 i;
    public i8 j;
    public Activity k;
    public k8 l;
    public l6 m;
    public View n;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j0 j0Var = j0.this;
            j0Var.setMute(!j0Var.b.e);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MimoMediaView mimoMediaView = j0.this.b;
            if (mimoMediaView != null) {
                mimoMediaView.b();
            }
            i8 i8Var = j0.this.j;
            if (i8Var != null) {
                i8Var.onClick(view, ClickAreaType.TYPE_CLOSE);
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = j0.this.j;
            if (i8Var != null) {
                i8Var.onClick(view, ClickAreaType.TYPE_OTHER);
            }
        }
    }

    public j0(Context context) {
        this(context, null);
    }

    public j0(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public j0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.g = true;
    }

    public void a(View view) {
        this.f5477a = (ImageView) view.findViewById(a0.R4);
        this.b = (MimoMediaView) view.findViewById(a0.Q0);
        this.c = (SixElementsView) view.findViewById(a0.U);
        this.h = (CloseICP) view.findViewById(a0.V3);
        this.f5477a.setOnClickListener(new a());
        CloseICP closeICP = this.h;
        if (closeICP != null) {
            closeICP.setOnClickListener(new b());
        }
    }

    public void a(MimoAdInfo mimoAdInfo) {
        boolean z = !mimoAdInfo.t() || mimoAdInfo.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{7}, "1fde09")) || mimoAdInfo.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{1, 58, 7, 78, 2}, "7e4606"));
        int iA = f9.a(getContext(), z ? 29.1f : 21.8f);
        int iA2 = f9.a(getContext(), z ? 334.5f : 349.0f);
        if (this.k.getResources().getConfiguration().orientation == 1) {
            iA2 = f9.d(getContext()) - (iA * 2);
        }
        if (!z) {
            setPadding(f9.a(getContext(), 7.3f), f9.a(getContext(), 7.3f), f9.a(getContext(), 7.3f), 0);
            iA2 -= f9.a(getContext(), 7.3f) * 2;
        }
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(iA2, mimoAdInfo.p0.trim().endsWith(ijiami_1011.s.s.s.d(new byte[]{108, 7, 74, 1}, "342349")) ? (iA2 * 2) / 3 : (iA2 * 9) / 16));
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
    public void a(String str) {
        w3 w3Var = this.i;
        if (w3Var != null) {
            w3Var.onJumpWebView(str);
        }
    }

    public void destroy() {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.b();
            this.b = null;
        }
    }

    public CloseICP getCloseICP() {
        return this.h;
    }

    public l6 getExtShakeInfo() {
        return this.m;
    }

    public abstract int getLayoutId();

    public int getSixElementsTextColor() {
        return Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{Ascii.SYN, 126, 118, 37, 112, 36, 39, 34, 32}, "580c6b"));
    }

    public abstract ClickAreaType getVideoCLickAreaType();

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onCreateViewSuccess(i iVar) {
    }

    public void onPicEnd() {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onPicMode() {
        ImageView imageView = this.f5477a;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    public void onVideoEnd() {
        this.e = 100L;
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.setProgress(100);
        }
        w3 w3Var = this.i;
        if (w3Var != null) {
            w3Var.onVideoComplete();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoError() {
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoPause() {
        w3 w3Var = this.i;
        if (w3Var != null) {
            w3Var.onVideoPause();
        }
    }

    public void onVideoProgressUpdate(int i, int i2) {
        this.e = i;
        this.f = i2;
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.setProgress((i * 100) / i2);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoResume() {
        w3 w3Var = this.i;
        if (w3Var != null) {
            w3Var.onVideoResume();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVideoStart() {
        this.e = 0L;
        w3 w3Var = this.i;
        if (w3Var != null) {
            w3Var.onVideoStart();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.d7
    public void onVolumeChanged(boolean z) {
        ImageView imageView = this.f5477a;
        if (imageView != null) {
            imageView.setSelected(!z);
        }
    }

    public void pause() {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.a();
        }
        k8 k8Var = this.l;
        if (k8Var != null) {
            k8Var.a();
        }
    }

    public void removeShakeView() {
        k8 k8Var = this.l;
        if (k8Var != null) {
            k8Var.a();
            removeView(this.l);
            this.l = null;
        }
    }

    public void resume() {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.c();
        }
        k8 k8Var = this.l;
        if (k8Var != null) {
            k8Var.c();
        }
    }

    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        Context context;
        float f;
        MimoAdInfo mimoAdInfo2;
        boolean zD;
        this.d = mimoAdInfo;
        this.i = w3Var;
        this.k = activity;
        View viewFindViewById = findViewById(a0.f5);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new c());
        }
        removeAllViews();
        View viewInflate = LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true);
        a(viewInflate);
        a(mimoAdInfo);
        this.b.setOnVideoAdListener(this);
        this.b.setProgress(0);
        this.b.setMute(w3Var.isMuted());
        this.b.setProgressViewVisibility(this.d.E() ? 0 : 4);
        if (getVideoCLickAreaType() != null) {
            this.b.setViewClickAreaType(getVideoCLickAreaType());
        }
        this.b.setPicStartCountDown(this.g);
        this.b.a(this.d, w3Var, this.j);
        this.f5477a.setVisibility(this.d.E() ? 0 : 4);
        if (this.c != null) {
            View viewFindViewById2 = viewInflate.findViewById(a0.o0);
            this.n = viewFindViewById2;
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(this.d.D() ? 0 : 4);
                zD = this.d.D();
            } else {
                zD = false;
            }
            this.c.setTextColor(getSixElementsTextColor());
            SixElementsView sixElementsView = this.c;
            MimoAdInfo mimoAdInfo3 = this.d;
            String str = mimoAdInfo3.i;
            String str2 = mimoAdInfo3.k;
            String strE = mimoAdInfo3.e();
            MimoAdInfo mimoAdInfo4 = this.d;
            sixElementsView.a(str, str2, strE, mimoAdInfo4.m, mimoAdInfo4.l, mimoAdInfo4.n, zD);
            this.c.setVisibility(this.d.D() ? 0 : 4);
            this.c.setOnItemClickListener(this);
        }
        MimoAdInfo mimoAdInfo5 = this.d;
        if (mimoAdInfo5.a1) {
            ClickAreaType clickAreaType = ClickAreaType.TYPE_NATIVE_SHAKE;
            ClickEventType clickEventTypeA = mimoAdInfo5.a(clickAreaType);
            ClickEventType clickEventType = ClickEventType.CLICK_DISABLE;
            if (clickEventTypeA != clickEventType && (mimoAdInfo2 = this.d) != null && mimoAdInfo2.a1 && mimoAdInfo2.a(clickAreaType) != clickEventType) {
                removeShakeView();
                this.l = new k8(getContext(), null);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.l, layoutParams);
                this.l.a(this.d, new k0(this));
                this.l.c();
            }
        }
        MimoAdInfo mimoAdInfo6 = this.d;
        if (mimoAdInfo6 == null || mimoAdInfo6.a(ClickAreaType.TYPE_UNIVERSAL_SLIDE) == ClickEventType.CLICK_DISABLE) {
            return;
        }
        MimoUniversalSlideView mimoUniversalSlideView = new MimoUniversalSlideView(getContext(), null);
        mimoUniversalSlideView.a(this.d, this);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        if (this.d.p0.trim().startsWith(ijiami_1011.s.s.s.d(new byte[]{75, 81, 69, 86, 82, 94, 55, 1, Ascii.DC4, Ascii.SYN, 88, 6, 89, 94, 116}, "827370")) || this.d.p0.trim().startsWith(ijiami_1011.s.s.s.d(new byte[]{Ascii.ETB, 83, 70, 85, 7, 91, 41, 11, Ascii.DC4, 11, 75, 10, 10, 68, 85, 92, 33}, "d040b5")) || this.d.p0.trim().toLowerCase().contains(ijiami_1011.s.s.s.d(new byte[]{82, 92, 93, 83, 11, 82, 19, 15}, "0328f3"))) {
            layoutParams2.gravity = 81;
            if (getContext().getResources().getConfiguration().orientation == 1) {
                context = getContext();
                f = 260.0f;
            } else {
                context = getContext();
                f = 121.0f;
            }
            layoutParams2.bottomMargin = f9.a(context, f);
        } else {
            layoutParams2.gravity = 17;
        }
        addView(mimoUniversalSlideView, layoutParams2);
    }

    public void setIClickAreaListener(i8 i8Var) {
        this.j = i8Var;
        setCLickAreaListener(i8Var);
    }

    public void setMute(boolean z) {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.setMute(z);
        }
    }
}
