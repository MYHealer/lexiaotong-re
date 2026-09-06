package com.kwad.components.ad.splashscreen.presenter;

import com.kwad.components.core.widget.ComplianceTextView;
import com.kwad.sdk.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class f extends e {
    private ComplianceTextView dZ;

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ComplianceTextView complianceTextView = (ComplianceTextView) findViewById(com.kwad.components.ad.splashscreen.e.c.A(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate)) ? R.id.ksad_compliance_right_view : R.id.ksad_compliance_left_view);
        this.dZ = complianceTextView;
        complianceTextView.setBackgroundColor(0);
        this.dZ.setVisibility(0);
        this.dZ.setAdTemplate(this.HC.mAdTemplate);
    }
}
