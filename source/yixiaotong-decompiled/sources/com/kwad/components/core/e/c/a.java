package com.kwad.components.core.e.c;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import com.hihonor.adsdk.base.ErrorCode;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a extends KSFrameLayout {
    private final b Qv;
    private final b.C0660b Qw;
    private d Qx;
    private InterfaceC0659a Qy;
    private final AdTemplate mAdTemplate;
    private final Context mContext;
    private Presenter mPresenter;
    private final AdBaseFrameLayout mRootContainer;

    /* JADX INFO: renamed from: com.kwad.components.core.e.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0659a {
        void pF();
    }

    public final void setChangeListener(InterfaceC0659a interfaceC0659a) {
        this.Qy = interfaceC0659a;
    }

    public a(Context context, b bVar, b.C0660b c0660b) {
        super(context);
        this.mContext = context;
        this.Qv = bVar;
        this.Qw = c0660b;
        this.mAdTemplate = c0660b.adTemplate;
        m.inflate(context, R.layout.ksad_download_dialog_layout, this);
        AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        this.mRootContainer = adBaseFrameLayout;
        b(adBaseFrameLayout, "rootView is null");
        b((KsAdWebView) adBaseFrameLayout.findViewById(R.id.ksad_download_tips_web_card_webView), ErrorCode.MSG_AD_COMMON_WEB_VIEW_IS_NULL);
    }

    private void b(View view, String str) {
        if (view == null) {
            throw new RuntimeException("inflateView fail " + str + "\n--viewCount:" + getChildCount() + "\n--context:" + this.mContext.getClass().getName() + "\n--LayoutInflater context: " + LayoutInflater.from(this.mContext).getContext().getClass().getName() + "\n--classloader:" + getClass().getClassLoader().getClass().getName());
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        this.Qx = pE();
        Presenter presenterBJ = bJ();
        this.mPresenter = presenterBJ;
        presenterBJ.N(this.mRootContainer);
        this.mPresenter.q(this.Qx);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        d dVar = this.Qx;
        if (dVar != null) {
            dVar.release();
        }
        Presenter presenter = this.mPresenter;
        if (presenter != null) {
            presenter.destroy();
        }
    }

    private d pE() {
        d dVar = new d();
        dVar.Qv = this.Qv;
        dVar.Qw = this.Qw;
        dVar.mAdTemplate = this.mAdTemplate;
        dVar.mRootContainer = this.mRootContainer;
        if (com.kwad.sdk.core.response.helper.a.aL(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
            dVar.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        }
        return dVar;
    }

    private static Presenter bJ() {
        Presenter presenter = new Presenter();
        presenter.a(new e());
        return presenter;
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        InterfaceC0659a interfaceC0659a = this.Qy;
        if (interfaceC0659a != null) {
            interfaceC0659a.pF();
        }
    }
}
