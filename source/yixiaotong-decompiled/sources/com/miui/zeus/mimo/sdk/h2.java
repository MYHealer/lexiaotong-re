package com.miui.zeus.mimo.sdk;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bumptech.glide.Glide;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;
import com.miui.zeus.mimo.sdk.view.IBindDataView;
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
public abstract class h2 extends RootICP implements IBindDataView, i8 {
    public static final /* synthetic */ int r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageICP f5445a;
    public ViewGroup b;
    public IconICP c;
    public BrandICP d;
    public AdMarkICP e;
    public MimoScoreView f;
    public SummaryICP g;
    public DownloadButtonICP h;
    public SixElementsView i;
    public Activity j;
    public CloseICP k;
    public MimoAdInfo l;
    public CommonActionHandler m;
    public w3 n;
    public boolean o;
    public boolean p;
    public LinearLayout q;

    public class a implements SixElementsView.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w3 f5446a;

        public a(h2 h2Var, w3 w3Var) {
            this.f5446a = w3Var;
        }

        @Override // com.miui.zeus.mimo.sdk.view.component.SixElementsView.e
        public void a(String str) {
            this.f5446a.onJumpWebView(str);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h2 h2Var = h2.this;
            ClickAreaType clickAreaType = ClickAreaType.TYPE_CLOSE;
            int i = h2.r;
            h2Var.a(view, clickAreaType);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h2.this.onClick(view, ClickAreaType.TYPE_END_CARD);
        }
    }

    public class d implements CommonActionHandler.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f5449a;
        public final /* synthetic */ ClickAreaType b;

        public d(View view, ClickAreaType clickAreaType) {
            this.f5449a = view;
            this.b = clickAreaType;
        }

        @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
        public void a(boolean z) {
            h2 h2Var = h2.this;
            View view = this.f5449a;
            ClickAreaType clickAreaType = this.b;
            int i = h2.r;
            h2Var.a(z, view, clickAreaType);
        }
    }

    public h2(Context context) {
        this(context, null);
    }

    public h2(Context context, AttributeSet attributeSet) {
        this(context, null, 0);
    }

    public h2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = false;
        this.p = false;
    }

    public void a(View view) {
        this.f5445a = (ImageICP) view.findViewById(a0.k4);
        this.b = (ViewGroup) view.findViewById(a0.H1);
        IconICP iconICP = (IconICP) view.findViewById(a0.B2);
        this.c = iconICP;
        iconICP.setClickAreaType(ClickAreaType.TYPE_END_ICON);
        this.d = (BrandICP) view.findViewById(a0.k3);
        this.e = (AdMarkICP) view.findViewById(a0.k0);
        this.f = (MimoScoreView) view.findViewById(a0.y2);
        this.g = (SummaryICP) view.findViewById(a0.e0);
        this.h = (DownloadButtonICP) view.findViewById(a0.T0);
        this.i = (SixElementsView) view.findViewById(a0.j);
        this.k = (CloseICP) view.findViewById(a0.i2);
        this.q = (LinearLayout) view.findViewById(a0.v3);
    }

    public final void a(boolean z, View view, ClickAreaType clickAreaType) {
        AdEvent adEvent = AdEvent.CLICK;
        MimoAdInfo mimoAdInfo = this.l;
        n6 n6Var = this.mViewEventInfo;
        String strD = ijiami_1011.s.s.s.d(new byte[]{113}, "480f04");
        if (z) {
            clickAreaType = ClickAreaType.TYPE_CPM_BUTTON;
        }
        com.miui.zeus.mimo.sdk.b.a(adEvent, mimoAdInfo, n6Var, k6.a(strD, clickAreaType, getClickViewInfo(view), null));
        w3 w3Var = this.n;
        if (w3Var != null) {
            w3Var.onClicked();
        }
    }

    public void destroy() {
        CommonActionHandler commonActionHandler = this.m;
        if (commonActionHandler != null) {
            commonActionHandler.a();
        }
        DownloadButtonICP downloadButtonICP = this.h;
        if (downloadButtonICP != null) {
            downloadButtonICP.b();
        }
    }

    public final j6 getClickViewInfo(View view) {
        return new c6(view, this, this.k, null, new View[]{this.h}, this.mViewEventInfo, false, false).f5387a;
    }

    public abstract int getLayoutId();

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public boolean onBackPressed() {
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLOSE, this.l, this.mViewEventInfo, k6.a(ijiami_1011.s.s.s.d(new byte[]{114}, "7d9b4a"), null, null));
        return true;
    }

    @Override // com.miui.zeus.mimo.sdk.i8
    public void onClick(View view, ClickAreaType clickAreaType) {
        DownloadButtonICP downloadButtonICP;
        if (AdMarkICP.a(view) || ClickAreaType.TYPE_CLOSE == clickAreaType) {
            a(view, clickAreaType);
            return;
        }
        if (this.l.B1.booleanValue() && (downloadButtonICP = this.h) != null && clickAreaType == downloadButtonICP.getClickAreaType() && !this.h.a()) {
            a(false, view, clickAreaType);
            a(view, ClickAreaType.TYPE_FRAUD_CLOSE);
            return;
        }
        CommonActionHandler commonActionHandler = this.m;
        if (commonActionHandler != null) {
            commonActionHandler.b = new d(view, clickAreaType);
            commonActionHandler.a(this.l, clickAreaType);
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
        MimoAdInfo mimoAdInfo;
        super.onVisibilityChanged(view, i);
        if (i != 0 || this.p || (mimoAdInfo = this.l) == null) {
            return;
        }
        this.p = true;
        com.miui.zeus.mimo.sdk.b.a(AdEvent.END_PAGE_VIEW, mimoAdInfo);
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void pause() {
    }

    @Override // com.miui.zeus.mimo.sdk.view.IBindDataView
    public void resume() {
    }

    public void setAdInfo(Activity activity, MimoAdInfo mimoAdInfo, w3 w3Var) {
        this.l = mimoAdInfo;
        this.j = activity;
        this.n = w3Var;
        setCLickAreaListener(this);
        a(LayoutInflater.from(getContext()).inflate(getLayoutId(), (ViewGroup) this, true));
        this.m = new CommonActionHandler(getContext(), activity, w3Var);
        w3 w3Var2 = this.n;
        String strF = TextUtils.isEmpty(mimoAdInfo.c(w3Var2)) ? mimoAdInfo.f() : mimoAdInfo.c(w3Var2);
        if (TextUtils.isEmpty(strF)) {
            Bitmap videoBitmap = w3Var2.getVideoBitmap();
            if (videoBitmap != null) {
                this.f5445a.a(videoBitmap, this.o, this);
            }
        } else {
            Glide.with(y8.f5752a).asBitmap().load(strF).into(new i2(this));
        }
        this.c.a(com.miui.zeus.mimo.sdk.b.h(mimoAdInfo.b(this.n)) ? mimoAdInfo.b(this.n) : mimoAdInfo.A, this);
        this.d.setVisibility(com.miui.zeus.mimo.sdk.b.h(mimoAdInfo.r()) ? 0 : 8);
        this.d.a(mimoAdInfo.r(), this);
        AdMarkICP adMarkICP = this.e;
        adMarkICP.f5687a.setText(mimoAdInfo.a());
        adMarkICP.setOnClickListener(adMarkICP.new a(mimoAdInfo, this));
        this.f.a(mimoAdInfo.o, mimoAdInfo.b(), this);
        this.g.a(mimoAdInfo.p(), this);
        this.h.a(mimoAdInfo, false, true, this, false);
        this.h.setClickAreaType(ClickAreaType.TYPE_END_BUTTON);
        this.i.a(mimoAdInfo.i, mimoAdInfo.k, mimoAdInfo.e(), mimoAdInfo.m, mimoAdInfo.l, mimoAdInfo.n, false);
        this.i.setVisibility(mimoAdInfo.D() ? 0 : 4);
        this.i.setOnItemClickListener(new a(this, w3Var));
        this.k.setOnClickListener(new b());
        this.b.setOnClickListener(new c());
        com.miui.zeus.mimo.sdk.b.a(this.q, this.e, this.d);
    }

    public final void a(View view, ClickAreaType clickAreaType) {
        com.miui.zeus.mimo.sdk.b.a(AdEvent.CLOSE, this.l, this.mViewEventInfo, k6.a(ijiami_1011.s.s.s.d(new byte[]{33}, "d742f1"), getClickViewInfo(view), clickAreaType));
        w3 w3Var = this.n;
        if (w3Var != null) {
            w3Var.onClickCloseView();
        }
        Activity activity = this.j;
        if (activity != null) {
            activity.finish();
        }
    }
}
