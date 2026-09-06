package com.kwad.components.core.page;

import android.content.Context;
import android.view.ViewGroup;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class d extends com.kwad.components.core.n.d<com.kwad.components.core.page.d.a.b> {
    private AdWebViewActivityProxy.a adC;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    private boolean mAutoShow;
    private Context mContext;
    private String mH5AuthUrl;
    private com.kwad.components.core.page.a.b mLandPageViewListener;
    private String mPageTitle;
    private String mPageUrl;
    private boolean mShowPermission;
    private com.kwad.sdk.core.webview.d.a.b mWebCardCloseListener;

    @Override // com.kwad.components.core.n.d
    public final void initData() {
    }

    public void setLandPageViewListener(com.kwad.components.core.page.a.b bVar) {
        this.mLandPageViewListener = bVar;
    }

    protected d(Context context) {
        super(context);
    }

    @Override // com.kwad.components.core.n.d
    public void a(ViewGroup viewGroup) {
        this.mAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.release();
            this.mAdWebView = null;
        }
    }

    @Override // com.kwad.components.core.n.d
    public int getLayoutId() {
        return R.layout.ksad_activity_ad_webview;
    }

    public static d b(Context context, AdWebViewActivityProxy.a aVar) {
        d dVar = new d(context);
        dVar.c(context, aVar);
        return dVar;
    }

    protected final void c(Context context, AdWebViewActivityProxy.a aVar) {
        this.adC = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.tT();
        this.mH5AuthUrl = aVar.tY();
        this.mPageTitle = aVar.tS();
        this.mShowPermission = aVar.tV();
        this.mAutoShow = aVar.tX();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.core.n.d
    /* JADX INFO: renamed from: ub */
    public com.kwad.components.core.page.d.a.b an() {
        com.kwad.components.core.page.d.a.b bVar = new com.kwad.components.core.page.d.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.adC = this.adC;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mH5AuthUrl = this.mH5AuthUrl;
        bVar.mAutoShow = this.mAutoShow;
        bVar.mShowPermission = this.mShowPermission;
        bVar.aeb = this.mLandPageViewListener;
        bVar.setWebCardCloseListener(this.mWebCardCloseListener);
        bVar.mRootContainer = this.oC;
        return bVar;
    }

    public void setWebCardCloseListener(com.kwad.sdk.core.webview.d.a.b bVar) {
        this.mWebCardCloseListener = bVar;
        if (this.mAdWebView != null || bVar == null) {
            return;
        }
        bVar.b(null);
    }

    public boolean getCanInterceptBackClick() {
        return ((com.kwad.components.core.page.d.a.b) this.mPresenter.SB()).uk();
    }

    public final void uc() {
        ((com.kwad.components.core.page.d.a.b) this.mPresenter.SB()).uc();
    }

    @Override // com.kwad.components.core.n.d
    public Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.core.page.d.a.f());
        presenter.a(new com.kwad.components.core.page.d.a.e());
        if (com.kwad.sdk.core.response.helper.e.S(((com.kwad.components.core.page.d.a.b) this.abm).mAdTemplate)) {
            presenter.a(new com.kwad.components.core.page.d.a.c());
        }
        if (com.kwad.sdk.core.response.helper.a.aU(com.kwad.sdk.core.response.helper.e.eO(((com.kwad.components.core.page.d.a.b) this.abm).mAdTemplate)) && com.kwad.components.core.r.a.wm().ws() && com.kwad.components.core.r.a.wm().wn() == 1) {
            presenter.a(new com.kwad.components.core.page.d.a.d());
        }
        presenter.a(new com.kwad.components.core.page.d.a.g());
        return presenter;
    }
}
