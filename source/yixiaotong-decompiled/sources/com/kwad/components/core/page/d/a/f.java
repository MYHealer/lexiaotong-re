package com.kwad.components.core.page.d.a;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class f extends com.kwad.components.core.page.d.a.a {
    private boolean aeA;
    private com.kwad.components.core.b.a mTitleBarHelper;

    public interface a {
        void bx(int i);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.core.page.d.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.aeA = TextUtils.equals(this.adZ.mPageUrl, com.kwad.sdk.core.response.helper.a.aY(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate)));
        uf();
    }

    private String getTitle() {
        if (TextUtils.isEmpty(this.adZ.mPageTitle)) {
            return (this.adZ.mAdTemplate.adInfoList == null || this.adZ.mAdTemplate.adInfoList.size() <= 0 || this.adZ.mAdTemplate.adInfoList.get(0) == null) ? "详情页面" : com.kwad.sdk.core.response.helper.a.cs(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate));
        }
        return this.adZ.mPageTitle;
    }

    private void uf() {
        com.kwad.components.core.b.a aVar = new com.kwad.components.core.b.a(this.adZ.mRootContainer);
        this.mTitleBarHelper = aVar;
        aVar.a(new com.kwad.components.core.b.b(getTitle()));
        this.mTitleBarHelper.ak(true);
        this.mTitleBarHelper.a(new com.kwad.components.core.b.a.InterfaceC0650a() { // from class: com.kwad.components.core.page.d.a.f.1
            @Override // com.kwad.components.core.b.a.InterfaceC0650a
            public final void w(View view) {
                f.this.B(view);
            }

            @Override // com.kwad.components.core.b.a.InterfaceC0650a
            public final void x(View view) {
                f.this.C(view);
            }
        });
        ViewGroup viewGroupIb = this.mTitleBarHelper.ib();
        int i = 0;
        if (!this.adZ.mAdTemplate.mIsForceJumpLandingPage && !com.kwad.sdk.core.response.helper.a.cL(this.adZ.mAdTemplate) && !com.kwad.sdk.core.response.helper.b.dP(com.kwad.sdk.core.response.helper.e.eO(this.adZ.mAdTemplate))) {
            i = 8;
        }
        viewGroupIb.setVisibility(i);
        this.adZ.a(new a() { // from class: com.kwad.components.core.page.d.a.f.2
            @Override // com.kwad.components.core.page.d.a.f.a
            public final void bx(int i2) {
                f.this.mTitleBarHelper.ib().setVisibility(i2 == 1 ? 0 : 8);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(View view) {
        if (this.adZ != null) {
            this.adZ.a(this.aeA, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(View view) {
        if (this.adZ.aeb != null) {
            this.adZ.aeb.tR();
        }
    }
}
