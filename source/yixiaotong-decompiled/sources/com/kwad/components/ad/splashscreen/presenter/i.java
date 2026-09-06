package com.kwad.components.ad.splashscreen.presenter;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public abstract class i extends e implements com.kwad.sdk.core.j.c {
    private static long oe = 400;
    private com.kwad.components.ad.splashscreen.e.a HV;
    private Vibrator hw;

    protected abstract void fY();

    protected abstract void initView();

    protected abstract void j(int i, String str);

    protected abstract void mJ();

    protected abstract void mK();

    protected abstract void mL();

    protected abstract void mM();

    protected abstract void mN();

    @Override // com.kwad.sdk.mvp.Presenter
    public void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        if (this.HC == null) {
            return;
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        mL();
        mJ();
        if (com.kwad.sdk.core.response.helper.a.aL(adInfoEO)) {
            mO();
        }
        mK();
        fY();
        this.HC.GP.a(this);
    }

    private void mO() {
        if (this.HC != null) {
            com.kwad.components.ad.splashscreen.e.a aVar = this.HV;
            if (aVar == null) {
                this.HV = new com.kwad.components.ad.splashscreen.e.a(getContext(), this.HC.mAdTemplate) { // from class: com.kwad.components.ad.splashscreen.presenter.i.1
                    {
                        super(adTemplate);
                    }

                    @Override // com.kwad.components.ad.splashscreen.e.a
                    public final void k(int i, String str) {
                        i.this.j(i, str);
                    }
                };
            } else {
                aVar.setAdTemplate(this.HC.mAdTemplate);
            }
            com.kwad.components.core.e.d.d dVar = this.HC.mApkDownloadHelper;
            if (dVar != null) {
                dVar.b(this.HV);
            }
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void onUnbind() {
        super.onUnbind();
        if (this.HC != null && this.HC.GP != null) {
            this.HC.GP.b(this);
        }
        mN();
        by.b(getContext(), this.hw);
    }

    protected final void mP() {
        Context context = getContext();
        if (context != null) {
            this.hw = (Vibrator) context.getSystemService("vibrator");
        }
        by.a(getContext(), this.hw);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        if (this.HC.GS) {
            return;
        }
        mM();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        mN();
    }
}
