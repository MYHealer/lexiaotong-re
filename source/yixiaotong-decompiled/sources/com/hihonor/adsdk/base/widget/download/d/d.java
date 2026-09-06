package com.hihonor.adsdk.base.widget.download.d;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.dialog.DateFlowTipActivity;
import com.hihonor.adsdk.base.download.f;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.common.f.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d extends a {
    private static final String hnadsm = "DownloadHandler";
    private CharSequence hnadsg;
    private CharSequence hnadsh;
    private CharSequence hnadsi;
    private int hnadsj;
    private com.hihonor.adsdk.base.widget.download.b hnadsk;
    private boolean hnadsl;

    public d(HnDownloadButton hnDownloadButton) {
        super(hnDownloadButton);
        this.hnadsl = false;
    }

    private void hnadsf(CharSequence charSequence) {
        this.hnadsa.reset();
        this.hnadsa.setIndicatingText(charSequence);
    }

    private boolean hnadsi() {
        boolean z = this.hnadsd.getPkgType() == 2;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "isHonorMarketPkg is %b", Boolean.valueOf(z));
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void hnadsj() {
        hnadsb(1);
    }

    private void hnadsk() {
        BaseAd baseAd = this.hnadsd;
        if (baseAd == null || !com.hihonor.adsdk.base.widget.download.c.hnadsb(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "prepareDownloadState Not APP_POPULARIZE_DOWNLOAD", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "stateChangeCallback add button isStateChangeCallback:%s, hashCode:%d", Boolean.valueOf(this.hnadsl), Integer.valueOf(hashCode()));
        f.hnadsa(this.hnadsd).hnadsb(this.hnadsk, this.hnadsc);
        this.hnadsl = true;
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public int hnadsa() {
        return this.hnadsj;
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsa(BaseAd baseAd, int i) {
        super.hnadsa(baseAd, i);
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "setBaseAd---> download ad.", new Object[0]);
        if (this.hnadsd != baseAd) {
            hnadsb();
        }
        if (this.hnadsk == null) {
            this.hnadsk = new com.hihonor.adsdk.base.widget.download.b(this.hnadsa);
        }
        if (this.hnadsa.isAttachedToWindow()) {
            hnadsk();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsb() {
        this.hnadsa.reset();
        BaseAd baseAd = this.hnadsd;
        if (baseAd == null || baseAd.getInstallPkgType() != 1) {
            return;
        }
        this.hnadsa.setIdleText(this.hnadsg);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsc() {
        super.hnadsc();
        hnadsk();
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsd() {
        com.hihonor.adsdk.base.widget.download.a aVar;
        int state = this.hnadsa.getState();
        if (state == 4) {
            f.hnadsa(this.hnadsd).hnadse(this.hnadsk, this.hnadsc);
            com.hihonor.adsdk.base.api.e.hnadsa().hnadsa(this.hnadsd);
            return;
        }
        boolean z = state == 0 && (aVar = this.hnadse) != null && aVar.hnadsa() == 1;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "open loading page %s", Boolean.valueOf(z));
        boolean z2 = state == 0 || state == 2;
        boolean zHnadsd = o.hnadsd(this.hnadsa.getContext());
        boolean z3 = this.hnadsd.getInstallPkgType() == 0;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "onClick state: " + state + ", InstallPkgType: " + this.hnadsd.getInstallPkgType() + ", isMobile: " + zHnadsd, new Object[0]);
        if (com.hihonor.adsdk.base.download.marketdownload.c.hnadsa().hnadsb()) {
            hnadsa(z2, z3, zHnadsd, z);
        } else {
            hnadsb(z2, z3, zHnadsd, z);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadse() {
        super.hnadse();
        if (this.hnadsl) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "stateChangeCallback remove button hashCode:%d", Integer.valueOf(hashCode()));
            f.hnadsa(this.hnadsd).hnadsa(this.hnadsk);
            this.hnadsl = false;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsg() {
        hnadsf(this.hnadsh);
    }

    private void hnadsc(int i) {
        this.hnadsa.updateProgressBy(i);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsc(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "setTryAgainText, tryAgainText is null", new Object[0]);
        } else {
            this.hnadsh = charSequence;
        }
    }

    private void hnadsb(boolean z, boolean z2, boolean z3, boolean z4) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "useMarketTrafficPopMarketPack---> needDoDownload: " + z + ",isNonPreInstalled: " + z2 + ",isMobile: " + z3 + ",isOpenLoadingPage: " + z4, new Object[0]);
        if (z4) {
            hnadsb(1);
        } else {
            com.hihonor.adsdk.base.api.e.hnadsa().hnadsa(this.hnadsd);
        }
        if (z && z2 && z3) {
            if (hnadsi()) {
                f.hnadsa(this.hnadsd).hnadse(this.hnadsk, this.hnadsc);
                return;
            } else {
                DateFlowTipActivity.hnadsa(this.hnadsd, this.hnadsc);
                return;
            }
        }
        f.hnadsa(this.hnadsd).hnadse(this.hnadsk, this.hnadsc);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadse(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "setWaitText, waitText is null", new Object[0]);
        } else {
            this.hnadsi = charSequence;
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsa(com.hihonor.adsdk.base.widget.download.a aVar) {
        super.hnadsa(aVar);
        com.hihonor.adsdk.base.widget.download.a aVar2 = this.hnadse;
        if (aVar2 != null) {
            this.hnadsj = aVar2.hnadsa();
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    protected void hnadsa(String str) {
        if (this.hnadsd.getInstallPkgType() == 1) {
            hnadsa((CharSequence) str);
        } else {
            this.hnadsa.setIdleText(str);
        }
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsa(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "onDownloadWait " + i, new Object[0]);
        if (this.hnadsd != null && hnadsi()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "onDownloadWait pkgType is honor market", new Object[0]);
            this.hnadsa.waiting(this.hnadsi, i);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "onDownloadWait pkgType is not honor market", new Object[0]);
            hnadsc(i);
        }
    }

    private void hnadsa(boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "useAdTrafficPopMarketPack---> needDoDownload: " + z + ",isNonPreInstalled: " + z2 + ",isMobile: " + z3 + ",isOpenLoadingPage: " + z4, new Object[0]);
        if (this.hnadsd.getPkgType() == 2 && this.hnadsd.getLandingPageType() == 0) {
            z5 = true;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "jump honor market %s", Boolean.valueOf(z5));
        if (z && z2 && z3) {
            if (!z4) {
                com.hihonor.adsdk.base.api.e.hnadsa().hnadsa(this.hnadsd);
            } else {
                if (z5) {
                    DateFlowTipActivity.hnadsa(this.hnadsd, this.hnadsc, new DateFlowTipActivity.b() { // from class: com.hihonor.adsdk.base.widget.download.d.d$$ExternalSyntheticLambda0
                        @Override // com.hihonor.adsdk.base.dialog.DateFlowTipActivity.b
                        public final void hnadsa() {
                            this.f$0.hnadsj();
                        }
                    });
                    return;
                }
                hnadsb(1);
            }
            DateFlowTipActivity.hnadsa(this.hnadsd, this.hnadsc);
            return;
        }
        if (z4) {
            hnadsb(1);
        } else {
            com.hihonor.adsdk.base.api.e.hnadsa().hnadsa(this.hnadsd);
        }
        f.hnadsa(this.hnadsd).hnadse(this.hnadsk, this.hnadsc);
    }

    @Override // com.hihonor.adsdk.base.widget.download.d.a
    public void hnadsa(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsm, "setRecoverText, recoverText is null", new Object[0]);
        } else {
            this.hnadsg = charSequence;
        }
    }
}
