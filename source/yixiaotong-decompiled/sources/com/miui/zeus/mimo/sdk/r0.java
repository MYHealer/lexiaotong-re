package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
import com.miui.zeus.mimo.sdk.view.MimoMarkView;
import com.miui.zeus.mimo.sdk.view.MimoScoreView;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP;
import com.miui.zeus.mimo.sdk.view.component.AdMarkICP.a;
import com.miui.zeus.mimo.sdk.view.component.BrandICP;
import com.miui.zeus.mimo.sdk.view.component.CloseICP;
import com.miui.zeus.mimo.sdk.view.component.DownloadButtonICP;
import com.miui.zeus.mimo.sdk.view.component.IconICP;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;
import com.miui.zeus.mimo.sdk.view.component.RootICP;
import com.miui.zeus.mimo.sdk.view.component.SixElementsView;
import com.miui.zeus.mimo.sdk.view.component.SummaryICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r0 extends RootICP implements IBindDataView, SixElementsView.e, i8 {
    public static final /* synthetic */ int p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageICP f5578a;
    public SixElementsView b;
    public CloseICP c;
    public IconICP d;
    public BrandICP e;
    public AdMarkICP f;
    public MimoScoreView g;
    public MimoMarkView h;
    public SummaryICP i;
    public DownloadButtonICP j;
    public MimoAdInfo k;
    public w3 l;
    public CommonActionHandler m;
    public LinearLayout n;
    public boolean o;

    public class a implements CommonActionHandler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5579a;
        public final /* synthetic */ ClickAreaType b;

        public a(View view, ClickAreaType clickAreaType) {
            this.f5579a = view;
            this.b = clickAreaType;
        }

        @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
        public void a(boolean z) {
            r0 r0Var = r0.this;
            View view = this.f5579a;
            ClickAreaType clickAreaType = this.b;
            int i = r0.p;
            r0Var.notifyViewClicked(view, clickAreaType, z);
        }
    }

    public r0(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public r0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = false;
    }

    public final c6 a(View view) {
        return new c6(view, getRootView(), this.c, null, new View[]{this.j}, this.mViewEventInfo, false, false);
    }

    @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
    public void a(String str) {
        w3 w3Var = this.l;
        if (w3Var != null) {
            w3Var.onJumpWebView(str);
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void destroy() {
        CommonActionHandler commonActionHandler = this.m;
        if (commonActionHandler != null) {
            commonActionHandler.a();
            this.m = null;
        }
        DownloadButtonICP downloadButtonICP = this.j;
        if (downloadButtonICP != null) {
            downloadButtonICP.b();
        }
    }

    public final void notifyViewClicked(View view, ClickAreaType clickAreaType, boolean z) {
        c6 c6VarA = a(view);
        AdEvent adEvent = AdEvent.CLICK;
        MimoAdInfo mimoAdInfo = this.k;
        n6 n6Var = this.mViewEventInfo;
        String strD = ijiami_1011.s.s.s.d(new byte[]{39}, "b71f87");
        if (z) {
            clickAreaType = ClickAreaType.TYPE_CPM_BUTTON;
        }
        b.a(adEvent, mimoAdInfo, n6Var, k6.a(strD, clickAreaType, c6VarA.f5387a, null));
        w3 w3Var = this.l;
        if (w3Var != null) {
            w3Var.onClicked();
        }
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        DownloadButtonICP downloadButtonICP;
        ClickEventType clickEventTypeA = this.k.a(clickAreaType);
        if (AdMarkICP.a(view) || ClickAreaType.TYPE_CLOSE == clickAreaType) {
            a(view, clickAreaType);
            return;
        }
        if (clickEventTypeA == ClickEventType.CLICK_DISABLE) {
            return;
        }
        if (this.k.B1.booleanValue() && (downloadButtonICP = this.j) != null && clickAreaType == downloadButtonICP.getClickAreaType() && !this.j.a()) {
            notifyViewClicked(view, clickAreaType, false);
            a(view, ClickAreaType.TYPE_FRAUD_CLOSE);
            return;
        }
        CommonActionHandler commonActionHandler = this.m;
        if (commonActionHandler != null) {
            commonActionHandler.b = new a(view, clickAreaType);
            commonActionHandler.a(this.k, clickAreaType);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0 || this.o) {
            return;
        }
        this.o = true;
        b.a(AdEvent.END_PAGE_VIEW, this.k);
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        SixElementsView sixElementsView;
        this.k = mimoAdInfo;
        this.l = w3Var;
        setCLickAreaListener(this);
        this.m = new CommonActionHandler(getContext(), activity, w3Var);
        View viewInflate = LayoutInflater.from(getContext()).inflate(activity.getResources().getConfiguration().orientation == 2 ? a0.J0 : a0.m, (ViewGroup) this, true);
        int i = a0.x4;
        this.n = (LinearLayout) viewInflate.findViewById(i);
        this.f5578a = (ImageICP) viewInflate.findViewById(a0.n3);
        this.b = (SixElementsView) viewInflate.findViewById(a0.f5280a);
        this.d = (IconICP) viewInflate.findViewById(a0.d3);
        this.c = (CloseICP) viewInflate.findViewById(a0.W0);
        this.e = (BrandICP) viewInflate.findViewById(a0.z3);
        this.f = (AdMarkICP) viewInflate.findViewById(a0.S1);
        this.g = (MimoScoreView) viewInflate.findViewById(a0.V1);
        this.h = (MimoMarkView) viewInflate.findViewById(a0.n5);
        this.i = (SummaryICP) viewInflate.findViewById(a0.f2);
        this.j = (DownloadButtonICP) viewInflate.findViewById(a0.e1);
        this.c.setClickAreaListener(this);
        if (f9.b(getContext()) > 100 && (sixElementsView = this.b) != null) {
            ((RelativeLayout.LayoutParams) sixElementsView.getLayoutParams()).bottomMargin = f9.b(getContext());
        }
        findViewById(a0.G).setOnClickListener(new q0(this));
        this.f5578a.a(this.k, w3Var, this);
        this.b.setTextColor(Color.parseColor(ijiami_1011.s.s.s.d(new byte[]{Ascii.ESC, 39, 113, 116, 126, 115, 39}, "8a7285")));
        this.b.a(mimoAdInfo.i, mimoAdInfo.k, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, false);
        this.b.setVisibility(mimoAdInfo.D() ? 0 : 4);
        this.b.setOnItemClickListener(this);
        String cachedResource = w3Var.getCachedResource(mimoAdInfo.A, false);
        if (b.g(cachedResource)) {
            cachedResource = mimoAdInfo.A;
        }
        this.d.setVisibility(mimoAdInfo.t() ? 0 : 8);
        this.d.a(cachedResource, this);
        AdMarkICP adMarkICP = this.f;
        adMarkICP.f5687a.setText(mimoAdInfo.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, this));
        int iA = this.f.a(mimoAdInfo.a().toString());
        this.e.setVisibility(b.g(mimoAdInfo.r()) ? 8 : 0);
        this.e.a(mimoAdInfo.r(), this);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.n.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        this.e.setMaxWidth(this.n.getMeasuredWidth() - iA);
        this.g.setVisibility(mimoAdInfo.t() ? 0 : 8);
        this.g.a(mimoAdInfo.o, mimoAdInfo.b(), this);
        this.h.a(mimoAdInfo.d(), this);
        this.i.setVisibility(b.g(mimoAdInfo.p()) ? 8 : 0);
        this.i.a(mimoAdInfo.p(), this);
        this.j.a(mimoAdInfo, false, true, this, false);
        b.a((LinearLayout) viewInflate.findViewById(i), this.f, this.e);
    }

    public final void a(View view, ClickAreaType clickAreaType) {
        b.a(AdEvent.CLOSE, this.k, this.mViewEventInfo, k6.a(ijiami_1011.s.s.s.d(new byte[]{118}, "3c6b1d"), a(view).f5387a, clickAreaType));
        w3 w3Var = this.l;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
    }
}
