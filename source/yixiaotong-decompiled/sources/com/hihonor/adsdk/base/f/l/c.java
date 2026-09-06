package com.hihonor.adsdk.base.f.l;

import android.content.Context;
import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.f.i;
import com.hihonor.adsdk.common.f.b0;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class c extends com.hihonor.adsdk.base.f.a {
    public c(BaseAd baseAd) {
        super(baseAd);
    }

    protected void hnadsa(int i, int i2, com.hihonor.adsdk.base.g.j.d.h1.b bVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "call base mini app un install app method.", new Object[0]);
        hnadsa(String.format(Locale.ENGLISH, "unInstallApp#Start mini app fail. %s APP is not install", hnadsf()), 1009, i, i2, bVar);
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected int hnadsb() {
        return 3;
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadse() {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "call base Mini APP start default enter.", new Object[0]);
        Context context = HnAds.get().getContext();
        if (context == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "startMiniAppDefault, context is null, the toast cannot be displayed.", new Object[0]);
            return;
        }
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "startMiniAppDefault handler start default fail, Cause by base ad is null.", new Object[0]);
            hnadsa(context);
        } else if (TextUtils.isEmpty(this.hnadsa.getLandingPageUrl())) {
            hnadsa(context);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "startMiniAppDefault handler start default web page.", new Object[0]);
            i.hnadsa(this.hnadsa).hnadsa(false).hnadsa(1).hnadsd();
        }
    }

    protected abstract String hnadsf();

    protected abstract String hnadsg();

    protected abstract int hnadsh();

    protected boolean hnadsi() {
        boolean zHnadsa = com.hihonor.adsdk.base.j.b.hnadsa(HnAds.get().getContext(), hnadsg());
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "BaseMiniAppHandler#" + hnadsf() + " is installed? " + zHnadsa, new Object[0]);
        return zHnadsa;
    }

    @Override // com.hihonor.adsdk.base.f.a
    protected void hnadsa(Context context) {
        if (hnadsi()) {
            b0.hnadsb(context.getString(R.string.ads_page_unsupport));
        } else {
            b0.hnadsb(context.getString(R.string.ads_not_open_mini_program, hnadsf()));
        }
    }

    protected void hnadsa(String str, int i, int i2, int i3, com.hihonor.adsdk.base.g.j.d.h1.b bVar) {
        if (!hnadsc()) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "BaseMiniAppHandler Unable to call reportStartFail, Cause by BaseAd is null.", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), str, new Object[0]);
        int iHnadsa = com.hihonor.adsdk.base.j.f.hnadsa(this.hnadsa.getPromotionPurpose(), this.hnadsa.getMiniProgramType());
        if (bVar == null) {
            bVar = new com.hihonor.adsdk.base.g.j.d.h1.b();
        }
        com.hihonor.adsdk.base.g.j.d.h1.b bVar2 = bVar;
        bVar2.hnadsc(String.valueOf(this.hnadsa.getSequence()));
        bVar2.hnadsb(String.valueOf(iHnadsa));
        new com.hihonor.adsdk.base.g.j.d.i(this.hnadsa.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.hnadsa), bVar2, ErrorCode.c.hnadsa, str).hnadsa(i3).hnadsa(0L).hnadsa(this.hnadsa.getDeeplinkUrl()).hnadsa(com.hihonor.adsdk.base.g.j.e.a.L0, String.valueOf(this.hnadsa.getItemPosition())).hnadsa("code", String.valueOf(i)).hnadse();
        com.hihonor.adsdk.base.g.k.c.f fVar = new com.hihonor.adsdk.base.g.k.c.f(ErrorCode.c.hnadsa, str, 2, 0);
        BaseAd baseAd = this.hnadsa;
        fVar.hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
        com.hihonor.adsdk.common.b.b.hnadse(hnadsa(), str, new Object[0]);
    }
}
