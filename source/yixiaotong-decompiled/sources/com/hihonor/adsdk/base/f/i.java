package com.hihonor.adsdk.base.f;

import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.b0;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class i {
    private static final String hnadsg = "PromotionManager";
    private BaseAd hnadsa;
    private int hnadsb = 0;
    private boolean hnadsc = true;
    private int hnadsd = -1;
    private f hnadse;
    private int hnadsf;

    public i() {
    }

    public static i hnadsa() {
        return new i();
    }

    private void hnadsc() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "call reportClickReward mIsReportRewardPoint=" + this.hnadsc, new Object[0]);
        if (this.hnadsc) {
            com.hihonor.adsdk.base.api.e.hnadsa().hnadsa(this.hnadsa);
        }
    }

    public i hnadsa(int i) {
        this.hnadsd = i;
        return this;
    }

    public i hnadsa(boolean z) {
        this.hnadsc = z;
        return this;
    }

    public i hnadsb(int i) {
        this.hnadsb = i;
        return this;
    }

    public void hnadsd() {
        if (Objects.isNull(this.hnadsa)) {
            com.hihonor.adsdk.common.b.b.hnadse(hnadsg, "trigger start fail.Cause by baseAd is null.", new Object[0]);
            b0.hnadsc(R.string.ads_page_unsupport);
            return;
        }
        int promotionPurpose = this.hnadsd;
        if (promotionPurpose == -1) {
            promotionPurpose = this.hnadsa.getPromotionPurpose();
        }
        if (this.hnadse == null || this.hnadsd != -1 || this.hnadsf != this.hnadsa.hashCode()) {
            this.hnadse = h.hnadsa(promotionPurpose, this.hnadsa);
        }
        this.hnadsf = this.hnadsa.hashCode();
        this.hnadse.hnadsa(this.hnadsb);
        this.hnadse.start();
        hnadsc();
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "-----> [%s] triggerStart promotionPurpose=" + promotionPurpose + ", scene=" + this.hnadsb + ", baseAdHashCode=" + this.hnadsa.hashCode(), this.hnadse.hnadsa());
    }

    public static i hnadsa(BaseAd baseAd) {
        return new i(baseAd);
    }

    public i hnadsb(BaseAd baseAd) {
        this.hnadsa = baseAd;
        f fVar = this.hnadse;
        if (fVar != null) {
            fVar.hnadsa(baseAd);
        }
        return this;
    }

    private i(BaseAd baseAd) {
        this.hnadsa = baseAd;
    }

    public void hnadsa(long j) {
        f fVar;
        if (Objects.isNull(this.hnadsa) || (fVar = this.hnadse) == null) {
            return;
        }
        fVar.hnadsb(j);
    }

    public void hnadsb(long j) {
        f fVar;
        if (Objects.isNull(this.hnadsa) || (fVar = this.hnadse) == null) {
            return;
        }
        fVar.hnadsa(j);
    }

    public void hnadsb() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsg, "call release.", new Object[0]);
        this.hnadsa = null;
    }
}
