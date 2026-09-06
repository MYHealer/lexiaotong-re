package com.kwad.components.ad.splashscreen.presenter.endcard;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b extends com.kwad.components.ad.splashscreen.presenter.e {
    private ComplianceTextView dZ;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        nl();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }

    private void nl() {
        if (com.kwad.sdk.core.response.helper.a.aV(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(R.id.ksad_compliance_splash_endcard);
            this.dZ = complianceTextView;
            complianceTextView.setBackgroundColor(0);
            this.dZ.setVisibility(0);
            this.dZ.setAdTemplate(this.HC.mAdTemplate);
        }
    }
}
