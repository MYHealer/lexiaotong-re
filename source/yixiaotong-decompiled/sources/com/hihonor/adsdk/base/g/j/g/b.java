package com.hihonor.adsdk.base.g.j.g;

import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.BaseAdInfo;
import com.hihonor.adsdk.base.bean.EventAdImpl;
import com.hihonor.adsdk.base.bean.InstallNotifyBean;
import com.hihonor.adsdk.base.bean.RewardBean;
import com.hihonor.adsdk.base.download.g;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.base.i.d;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    public static final int hnadsa = 0;

    private b() {
    }

    private static com.hihonor.adsdk.base.g.j.d.h1.a.C0436a hnadsa() {
        return a.hnadsa("0");
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsb() {
        return hnadsa().hnadsa();
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(String str, String str2, int i, int i2) {
        return a.hnadsa(hnadsa(), str, str2, i, i2);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(AdTrack adTrack) {
        com.hihonor.adsdk.base.g.j.d.h1.a.C0436a c0436aHnadsa = hnadsa();
        c0436aHnadsa.hnadsa(adTrack.getAdId());
        return a.hnadsa(c0436aHnadsa, "", adTrack.getRequestId(), -1, 0);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(String str, String str2, int i, int i2, String str3, String str4) {
        return a.hnadsa(hnadsa(), str, str2, i, i2, str3, str4);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(int i, String str, String str2, int i2, int i3, int i4) {
        return a.hnadsa(hnadsa(), i, str, str2, i2, i3, i4);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(RewardBean rewardBean) {
        if (Objects.isNull(rewardBean)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), rewardBean);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(InstallNotifyBean installNotifyBean) {
        if (Objects.isNull(installNotifyBean)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), installNotifyBean);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(d dVar) {
        if (Objects.isNull(dVar)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), dVar);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(g gVar) {
        if (Objects.isNull(gVar)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), gVar);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.bean.b bVar, String str) {
        if (Objects.isNull(bVar)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), bVar, str);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(EventAdImpl eventAdImpl) {
        if (Objects.isNull(eventAdImpl)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), eventAdImpl);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(com.hihonor.adsdk.base.g.j.d.c cVar) {
        if (Objects.isNull(cVar)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), cVar);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(BaseAd baseAd) {
        if (Objects.isNull(baseAd)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), baseAd);
    }

    public static com.hihonor.adsdk.base.g.j.d.h1.a hnadsa(BaseAdInfo baseAdInfo) {
        if (Objects.isNull(baseAdInfo)) {
            return hnadsa().hnadsa();
        }
        return a.hnadsa(hnadsa(), baseAdInfo);
    }
}
