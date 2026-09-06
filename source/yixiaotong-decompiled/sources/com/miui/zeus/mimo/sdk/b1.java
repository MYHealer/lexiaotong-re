package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.view.KeyCharacterMap;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.huawei.openalliance.ad.constant.ai;
import com.miui.zeus.comp.videoplayer.PlayState;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.download.AutoDownloadController;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.video.TextureVideoView;
import com.miui.zeus.mimo.sdk.view.MimoVideoTipsView;
import com.miui.zeus.mimo.sdk.view.SkipCountDownView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.BubbleDownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b1 extends j0 implements i8 {
    public static final /* synthetic */ int z = 0;
    public SkipCountDownView o;
    public MimoVideoTipsView p;
    public i0 q;
    public AutoDownloadController r;
    public DownloadButtonICP s;
    public n7 t;
    public CommonActionHandler u;
    public Runnable v;
    public BubbleDownloadButtonICP w;
    public View x;
    public boolean y;

    public class a implements SkipCountDownView.c {
        public a() {
        }

        @Override // com.miui.zeus.mimo.sdk.view.SkipCountDownView.c
        public void clickCountDownView(ClickAreaType clickAreaType) {
            b1 b1Var = b1.this;
            b1Var.onClick(b1Var.o, clickAreaType);
        }

        @Override // com.miui.zeus.mimo.sdk.view.SkipCountDownView.c
        public void clickSkipView(View view) {
            b1 b1Var = b1.this;
            MimoAdInfo mimoAdInfo = b1Var.d;
            if (mimoAdInfo == null || !mimoAdInfo.a(b1Var.e, b1Var.f)) {
                return;
            }
            b1 b1Var2 = b1.this;
            b1Var2.onClick(b1Var2.h, ClickAreaType.TYPE_CLOSE);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b1.this.b.a();
        }
    }

    public class c implements CommonActionHandler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5371a;
        public final /* synthetic */ ClickAreaType b;

        public c(View view, ClickAreaType clickAreaType) {
            this.f5371a = view;
            this.b = clickAreaType;
        }

        @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
        public void a(boolean z) {
            b1 b1Var = b1.this;
            View view = this.f5371a;
            ClickAreaType clickAreaType = this.b;
            int i = b1.z;
            b1Var.a(z, view, clickAreaType);
        }
    }

    public b1(Context context) {
        super(context);
        this.s = null;
        this.y = true;
    }

    private View getDownloadBtnView() {
        DownloadButtonICP downloadButtonICP = this.s;
        if (downloadButtonICP != null && downloadButtonICP.isShown()) {
            return this.s;
        }
        BubbleDownloadButtonICP bubbleDownloadButtonICP = this.w;
        if (bubbleDownloadButtonICP == null || !bubbleDownloadButtonICP.isShown()) {
            return null;
        }
        return this.w;
    }

    @Override // com.miui.zeus.mimo.sdk.j0
    public void a(View view) {
        super.a(view);
        setIClickAreaListener(this);
        this.o = (SkipCountDownView) view.findViewById(a0.v4);
        this.p = (MimoVideoTipsView) view.findViewById(a0.E3);
        this.q = (i0) view.findViewById(a0.N3);
        this.o.setOnItemClickListener(new a());
        this.w = (BubbleDownloadButtonICP) view.findViewById(a0.X3);
        this.x = view.findViewById(a0.d);
    }

    @Override // com.miui.zeus.mimo.sdk.j0
    public void a(MimoAdInfo mimoAdInfo) {
    }

    public final void a(boolean z2, View view, ClickAreaType clickAreaType) {
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLICK, this.d, this.mViewEventInfo, k6.a(ijiami_1011.s.s.s.d(new byte[]{51}, "caab6c"), z2 ? ClickAreaType.TYPE_CPM_BUTTON : clickAreaType, b(view).f5387a, clickAreaType == ClickAreaType.TYPE_NATIVE_SHAKE ? getExtShakeInfo() : null));
        w3 w3Var = this.i;
        if (w3Var != null) {
            w3Var.onClicked();
        }
    }

    public final boolean a(Activity activity) {
        return activity != null && activity.getResources().getConfiguration().orientation == 1;
    }

    public final c6 b(View view) {
        View rootView = getRootView();
        SkipCountDownView skipCountDownView = this.o;
        return new c6(view, rootView, skipCountDownView == null ? this.h : skipCountDownView.getCloseView(), null, new View[]{getDownloadBtnView()}, this.mViewEventInfo, false, false);
    }

    @Override // com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        super.destroy();
        AutoDownloadController autoDownloadController = this.r;
        if (autoDownloadController != null) {
            autoDownloadController.c();
            this.r = null;
        }
        i0 i0Var = this.q;
        if (i0Var != null) {
            i0Var.destroy();
        }
        CommonActionHandler commonActionHandler = this.u;
        if (commonActionHandler != null) {
            commonActionHandler.a();
            this.u = null;
        }
        BubbleDownloadButtonICP bubbleDownloadButtonICP = this.w;
        if (bubbleDownloadButtonICP != null) {
            bubbleDownloadButtonICP.b();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j0
    public int getLayoutId() {
        return a0.V;
    }

    @Override // com.miui.zeus.mimo.sdk.j0
    public ClickAreaType getVideoCLickAreaType() {
        return ClickAreaType.TYPE_FULL_VIDEO;
    }

    @Override // com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        DownloadButtonICP downloadButtonICP;
        BubbleDownloadButtonICP bubbleDownloadButtonICP;
        TextureVideoView textureVideoView;
        ClickEventType clickEventTypeA = this.d.a(clickAreaType);
        if (AdMarkICP.a(view) || ClickAreaType.TYPE_CLOSE == clickAreaType) {
            a(view, clickAreaType);
            return;
        }
        if (clickEventTypeA == ClickEventType.CLICK_DISABLE) {
            return;
        }
        removeShakeView();
        if (clickAreaType == ClickAreaType.TYPE_FULL_VIDEO && this.d.H0 > 0) {
            if (clickEventTypeA == ClickEventType.CLICK_AUTO_DOWNLOAD || this.u.b()) {
                return;
            }
            if (clickEventTypeA == ClickEventType.CLICK_NO_AUTO_DOWNLOAD) {
                MimoMediaView mimoMediaView = this.b;
                if (mimoMediaView != null && (textureVideoView = mimoMediaView.b) != null && textureVideoView.isPlaying()) {
                    this.b.a();
                }
                this.q.setVisibility(8);
                this.p.a(this.d, this, this, this.i, new c1(this));
                this.p.c();
                return;
            }
        }
        if (this.d.B1.booleanValue() && (((downloadButtonICP = this.s) != null && clickAreaType == downloadButtonICP.getClickAreaType() && !this.s.a() && this.s.getVisibility() == 0) || ((bubbleDownloadButtonICP = this.w) != null && clickAreaType == bubbleDownloadButtonICP.getClickAreaType() && !this.w.a() && this.w.getVisibility() == 0))) {
            a(false, view, clickAreaType);
            a(view, ClickAreaType.TYPE_FRAUD_CLOSE);
            return;
        }
        CommonActionHandler commonActionHandler = this.u;
        if (commonActionHandler != null) {
            commonActionHandler.b = new c(view, clickAreaType);
            commonActionHandler.a(this.d, clickAreaType);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.d7
    public void onPicEnd() {
        n7 n7Var = this.t;
        if (n7Var != null) {
            n7Var.onNeedEndPage();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.d7
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
        n7 n7Var = this.t;
        if (n7Var != null) {
            n7Var.onNeedEndPage();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.d7
    public void onVideoProgressUpdate(int i, int i2) {
        super.onVideoProgressUpdate(i, i2);
        String strValueOf = String.valueOf(Math.round(Math.round(((double) Math.max(i2 - i, 0)) / 1000.0d)));
        if (this.o != null) {
            MimoAdInfo mimoAdInfo = this.d;
            if (mimoAdInfo == null || !mimoAdInfo.a(this.e, this.f)) {
                SkipCountDownView skipCountDownView = this.o;
                skipCountDownView.b.setVisibility(8);
                skipCountDownView.c.setVisibility(8);
            } else {
                SkipCountDownView skipCountDownView2 = this.o;
                skipCountDownView2.b.setVisibility(0);
                skipCountDownView2.c.setVisibility(0);
            }
            this.o.setCountDown(strValueOf);
            this.o.setVisibility(0);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
        super.pause();
        Runnable runnable = this.v;
        if (runnable != null) {
            y8.b.removeCallbacks(runnable);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
        i iVar;
        if (getVisibility() != 0 || this.b == null) {
            return;
        }
        MimoVideoTipsView mimoVideoTipsView = this.p;
        if (mimoVideoTipsView == null || mimoVideoTipsView.getVisibility() != 0) {
            super.resume();
            return;
        }
        TextureVideoView textureVideoView = this.b.getTextureVideoView();
        if (textureVideoView != null && (iVar = textureVideoView.e) != null && iVar.getPlayState() != PlayState.PLAYING) {
            textureVideoView.e.start();
        }
        this.b.postDelayed(new b(), 100L);
    }

    @Override // com.miui.zeus.mimo.sdk.j0, com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        super.setAdInfo(activity, mimoAdInfo, w3Var);
        this.b.a(this.k.getResources().getConfiguration().orientation);
        this.q.setIClickAreaListener(this);
        this.q.setAdInfo(activity, mimoAdInfo, w3Var);
        AutoDownloadController autoDownloadController = new AutoDownloadController(getContext());
        this.r = autoDownloadController;
        autoDownloadController.b();
        this.u = new CommonActionHandler(getContext(), activity, w3Var);
        if (activity.getResources().getConfiguration().orientation == 2) {
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).addRule(12, 0);
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).addRule(10);
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).addRule(14);
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).leftMargin = f9.a(getContext(), 21.8f);
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).topMargin = f9.a(getContext(), 7.3f);
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).rightMargin = f9.a(getContext(), 21.8f);
            ((RelativeLayout.LayoutParams) this.q.getLayoutParams()).addRule(2, 0);
            ((RelativeLayout.LayoutParams) this.q.getLayoutParams()).addRule(12);
            ((RelativeLayout.LayoutParams) this.q.getLayoutParams()).addRule(14);
            ((RelativeLayout.LayoutParams) this.q.getLayoutParams()).bottomMargin = f9.a(getContext(), 14.5f);
            this.q.getLayoutParams().width = (f9.c(getContext()) * 2) / 3;
            View viewFindViewById = findViewById(a0.t1);
            if (viewFindViewById != null && this.c.getVisibility() == 0) {
                viewFindViewById.setVisibility(0);
            }
        } else if (KeyCharacterMap.deviceHasKey(4) && KeyCharacterMap.deviceHasKey(3)) {
            KeyCharacterMap.deviceHasKey(82);
        }
        if (!mimoAdInfo.t() && a(activity)) {
            ((RelativeLayout.LayoutParams) this.q.getLayoutParams()).bottomMargin = f9.a(getContext(), 30.0f);
        }
        i0 i0Var = this.q;
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(330L);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        i0Var.setVisibility(0);
        i0Var.startAnimation(translateAnimation);
        if (mimoAdInfo.v()) {
            this.o.setVisibility(0);
        }
        String str = mimoAdInfo.K0;
        if (com.miui.zeus.mimo.sdk.b.a(str, ijiami_1011.s.s.s.d(new byte[]{6, 75, 14, Ascii.SYN, Ascii.DC4, 12, 15, 3}, "b9afde"))) {
            Runnable runnable = this.v;
            if (runnable != null) {
                y8.b.removeCallbacks(runnable);
            }
            d1 d1Var = new d1(this, mimoAdInfo);
            this.v = d1Var;
            y8.b.postDelayed(d1Var, mimoAdInfo.n());
        } else if (com.miui.zeus.mimo.sdk.b.a(str, ijiami_1011.s.s.s.d(new byte[]{6, 69, 81, 82, 15, 0}, "d030ce"))) {
            u7 u7Var = new u7(getContext(), getContext().getResources().getConfiguration().orientation);
            int iIndexOfChild = ((ViewGroup) this.p.getParent()).indexOfChild(this.p);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            if (a(activity)) {
                layoutParams.topMargin = f9.a(getContext(), mimoAdInfo.B() ? 90.0f : 32.0f);
                layoutParams.bottomMargin = f9.a(getContext(), 52.0f);
            }
            ((ViewGroup) this.p.getParent()).addView(u7Var, iIndexOfChild, layoutParams);
            u7Var.a(mimoAdInfo.L0, this);
        }
        this.s = this.q.getDownloadBtn();
        if (this.w != null && this.d.u() && com.miui.zeus.mimo.sdk.b.h(this.d.F1)) {
            SixElementsView sixElementsView = this.c;
            if (sixElementsView != null) {
                MimoAdInfo mimoAdInfo2 = this.d;
                String str2 = mimoAdInfo2.i;
                String str3 = mimoAdInfo2.k;
                String strE = mimoAdInfo2.e();
                MimoAdInfo mimoAdInfo3 = this.d;
                sixElementsView.a(str2, str3, strE, mimoAdInfo3.m, mimoAdInfo3.l, mimoAdInfo3.n, true);
            }
            i0 i0Var2 = this.q;
            if (i0Var2 != null) {
                this.y = false;
                i0Var2.setVisibility(8);
            }
            View view = this.x;
            if (view != null) {
                view.setVisibility(0);
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.w.getLayoutParams();
            if (!a(activity)) {
                layoutParams2.width = f9.a(getContext(), 388.0f);
                layoutParams2.height = -2;
            } else if (f9.d(getContext()) > 1200) {
                layoutParams2.width = ai.af;
                layoutParams2.height = -2;
                if (f9.d(getContext()) > 1560.0d) {
                    layoutParams2.width = 1560;
                }
            }
            this.w.setLayoutParams(layoutParams2);
            this.w.setVisibility(0);
            this.w.a(this.d, false, false, this.j, false);
        }
    }

    public void setOnNeedEndPageListener(n7 n7Var) {
        this.t = n7Var;
    }

    public void a(View view, ClickAreaType clickAreaType) {
        MimoMediaView mimoMediaView = this.b;
        if (mimoMediaView != null) {
            mimoMediaView.b();
            this.b.setVisibility(8);
        }
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLOSE, this.d, this.mViewEventInfo, k6.a(ijiami_1011.s.s.s.d(new byte[]{124}, "9c0e16"), b(view).f5387a, clickAreaType));
        w3 w3Var = this.i;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
    }
}
