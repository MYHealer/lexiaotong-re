package com.hihonor.adsdk.base.f;

import android.text.TextUtils;
import com.hihonor.adsdk.base.api.BaseAd;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h {
    private static final String hnadsa = "PromotionHandlerFactory";

    public static f hnadsa(int i, BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "PromotionHandlerFactory#createHandler base ad is null.", new Object[0]);
            return new e(null);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "create handler promotionPurpose = " + i + ",pkgType=" + baseAd.getPkgType() + ", miniProgramType= " + baseAd.getMiniProgramType() + ", webUrlIsNULL=" + TextUtils.isEmpty(baseAd.getLandingPageUrl()), new Object[0]);
        if (i == 10000) {
            return new g(baseAd);
        }
        if (i == 0) {
            return (baseAd.getPkgType() == 2 && baseAd.getLandingPageType() == 0) ? new g(baseAd) : new k(baseAd);
        }
        if (i == 1) {
            return new k(baseAd);
        }
        if (i == 2) {
            return new b(baseAd);
        }
        if (i == 4) {
            return new c(baseAd);
        }
        if (i == 103) {
            return new j(baseAd);
        }
        if (i == 10001) {
            return new com.hihonor.adsdk.base.f.l.f(baseAd);
        }
        if (i == 10003) {
            return new com.hihonor.adsdk.base.f.l.b(baseAd);
        }
        if (i == 10002) {
            return new com.hihonor.adsdk.base.f.l.a(baseAd);
        }
        if (i == 5) {
            return new com.hihonor.adsdk.base.f.l.g(baseAd);
        }
        if (i == 3) {
            int miniProgramType = baseAd.getMiniProgramType();
            if (miniProgramType == 3) {
                return new com.hihonor.adsdk.base.f.l.b(baseAd);
            }
            if (miniProgramType == 2) {
                return new com.hihonor.adsdk.base.f.l.a(baseAd);
            }
            if (miniProgramType == 1) {
                return new com.hihonor.adsdk.base.f.l.f(baseAd);
            }
        }
        return TextUtils.isEmpty(baseAd.getLandingPageUrl()) ? new e(baseAd) : new k(baseAd);
    }
}
