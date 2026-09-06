package com.kwad.components.core.page;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.kwad.components.offline.api.core.adInnerEc.ExternalExitListener;
import com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f extends com.kwad.components.core.n.d<com.kwad.components.core.page.d.a.b> implements YodaWebPageListener {
    private static final Set<WeakReference<f>> adE = new HashSet();
    private AdWebViewActivityProxy.a adC;
    private ExternalExitListener adD;
    private WebView ade;
    private AdTemplate mAdTemplate;
    private Context mContext;
    private String mPageTitle;
    private String mPageUrl;

    @Override // com.kwad.components.core.n.d
    public final void a(ViewGroup viewGroup) {
    }

    @Override // com.kwad.components.core.n.d
    public final void initData() {
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onPageFinished() {
    }

    public final void setExternalExitListener(ExternalExitListener externalExitListener) {
        this.adD = externalExitListener;
    }

    @Override // com.kwad.components.core.n.d
    public final ViewGroup tq() {
        return this;
    }

    public static void a(WebView webView, com.kwad.components.core.b.b bVar) {
        f fVarA = a(webView);
        if (fVarA != null) {
            fVarA.b(bVar);
        }
    }

    private static f a(WebView webView) {
        f fVar;
        WebView webView2;
        if (webView == null) {
            return null;
        }
        for (WeakReference<f> weakReference : adE) {
            if (weakReference != null && weakReference.get() != null && (fVar = weakReference.get()) != null && (webView2 = fVar.ade) != null && webView.equals(webView2)) {
                return fVar;
            }
        }
        return null;
    }

    public f(Context context) {
        super(context);
    }

    public final void c(Context context, AdWebViewActivityProxy.a aVar) {
        this.adC = aVar;
        this.mContext = context;
        this.mAdTemplate = aVar.getAdTemplate();
        this.mPageUrl = aVar.tT();
        this.mPageTitle = aVar.tS();
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        return R.layout.ksad_merchant_landing_view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* JADX INFO: renamed from: ub, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.core.page.d.a.b an() {
        com.kwad.components.core.page.d.a.b bVar = new com.kwad.components.core.page.d.a.b();
        bVar.mContext = this.mContext;
        bVar.mAdTemplate = this.mAdTemplate;
        bVar.adC = this.adC;
        bVar.mPageTitle = this.mPageTitle;
        bVar.mPageUrl = this.mPageUrl;
        bVar.mRootContainer = this.oC;
        bVar.aea = this.ade;
        return bVar;
    }

    @Override // com.kwad.components.core.n.d
    public final Presenter onCreatePresenter() {
        Presenter presenter = new Presenter();
        presenter.a(new com.kwad.components.core.page.b.a());
        return presenter;
    }

    private void b(com.kwad.components.core.b.b bVar) {
        if (this.abm == 0 || ((com.kwad.components.core.page.d.a.b) this.abm).aeg == null) {
            return;
        }
        ((com.kwad.components.core.page.d.a.b) this.abm).aeg.a(bVar);
    }

    public final void b(Activity activity) {
        FrameLayout frameLayout = (FrameLayout) this.oC.findViewById(R.id.ksad_merchant_web_container);
        WebView webViewA = com.kwad.components.core.innerEc.f.a(activity, this, this.adD);
        this.ade = webViewA;
        if (webViewA != null) {
            frameLayout.addView(webViewA, -1, -1);
        }
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onReceivedError() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onReceivedError");
        com.kwad.components.core.innerEc.logger.a.m(this.mAdTemplate, this.mPageUrl);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onPagePause() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onPagePause");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onPageResume() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onPageFinished");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onBackground() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onBackground");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onForeground() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onForeground");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onLeave() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onLeave");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onReentry() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onReentry");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onVisibleChange(boolean z) {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onVisibleChange " + z);
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final void onLoadPage() {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onLoadPage");
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "onKey " + i + PPSLabelView.Code + keyEvent.getAction());
        return false;
    }

    @Override // com.kwad.components.offline.api.core.adInnerEc.YodaWebPageListener
    public final boolean overrideUrlLoading(WebView webView, String str) {
        com.kwad.sdk.core.d.c.w("MerchantLandingPageView", "overrideUrlLoading url:" + str);
        return true;
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        WebView webView = this.ade;
        if (webView != null) {
            webView.destroy();
            this.ade = null;
        }
        ((com.kwad.components.core.page.d.a.b) this.abm).aea = null;
        this.mContext = null;
        super.af();
    }
}
