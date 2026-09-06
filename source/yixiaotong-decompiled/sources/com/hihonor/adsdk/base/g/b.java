package com.hihonor.adsdk.base.g;

import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.g.j.d.j;
import com.hihonor.adsdk.base.g.j.d.n;
import com.hihonor.adsdk.base.g.j.d.o;
import com.hihonor.adsdk.base.g.j.d.q;
import com.hihonor.adsdk.base.g.j.d.q0;
import com.hihonor.adsdk.base.g.j.d.s;
import com.hihonor.adsdk.base.g.j.d.s0;
import com.hihonor.adsdk.base.g.j.d.t;
import com.hihonor.adsdk.base.g.j.d.t0;
import com.hihonor.adsdk.base.g.j.d.x;
import com.hihonor.adsdk.base.g.j.d.z;
import com.hihonor.adsdk.base.g.k.c.b0;
import com.hihonor.adsdk.base.mediation.adn.AdnConfig;
import com.hihonor.adsdk.base.mediation.comm.adevent.ADEvent;
import com.hihonor.adsdk.base.net.request.TrackAdRequest;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class b {
    private static final String hnadsa = "ReportUtils";

    public static void hnadsa(com.hihonor.adsdk.base.mediation.comm.adevent.a aVar, int i, com.hihonor.adsdk.base.g.j.d.c cVar) {
        if (aVar != null) {
            aVar.hnadsa(new ADEvent(i, cVar));
        } else {
            hnadsa(i, cVar);
        }
    }

    public static void hnadsa(int i, com.hihonor.adsdk.base.g.j.d.c cVar) {
        hnadsa(i, (AdListener) null, cVar);
    }

    public static void hnadsa(int i, AdListener adListener, com.hihonor.adsdk.base.g.j.d.c cVar) {
        com.hihonor.adsdk.base.g.j.d.h1.a aVarHnadsa = com.hihonor.adsdk.base.g.j.g.b.hnadsa(cVar);
        if (i == 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad load start", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.j1.h(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            hnadsa(cVar);
            return;
        }
        if (100 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad load success.", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.j1.i(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (106 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad close", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.g(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            if (adListener != null) {
                adListener.onAdClosed();
                return;
            }
            return;
        }
        if (121 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "AdEvent,Feed show", new Object[0]);
            new x(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            if (adListener != null) {
                adListener.onAdClosed();
                return;
            }
            return;
        }
        if (122 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "AdEvent,Feed cancel", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.g(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            if (adListener != null) {
                adListener.onAdClosed();
                return;
            }
            return;
        }
        if (107 == i || 101 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad fail type:", Integer.valueOf(i));
            new com.hihonor.adsdk.base.g.j.d.j1.g(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (115 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad init fail type:", Integer.valueOf(i));
            new q0(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (105 == i || 407 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad click type:", Integer.valueOf(i));
            new com.hihonor.adsdk.base.g.j.d.f(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            if (adListener != null) {
                adListener.onAdClicked();
                return;
            }
            return;
        }
        if (116 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad click close", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.h(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (103 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad shown", new Object[0]);
            new t0(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            if (adListener != null) {
                adListener.onAdImpression();
                return;
            }
            return;
        }
        if (104 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad reward", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.j1.f(cVar, String.valueOf(2), cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 401) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad download start", new Object[0]);
            new t(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 403) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad download resume", new Object[0]);
            new s(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 402) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad download pause", new Object[0]);
            new q(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 404) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad download fail", new Object[0]);
            new o(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 405) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad download end", new Object[0]);
            new n(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 406) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad install end", new Object[0]);
            new z(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 202) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad video start", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.k1.e(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 204) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad video pause", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.k1.c(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 203) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad video resume", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.k1.d(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 206) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad video end", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.k1.a(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 207) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad video error", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.k1.b(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            return;
        }
        if (i == 500) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad bidding win", new Object[0]);
            return;
        }
        if (i == 501) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad bidding loss", new Object[0]);
            return;
        }
        if (108 == i) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad dismissed", new Object[0]);
            new com.hihonor.adsdk.base.g.j.d.g(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
            if (adListener != null) {
                adListener.onAdSkip(cVar.k());
                return;
            }
            return;
        }
        if (119 == i) {
            new j(cVar, cVar.hnadsl(), aVarHnadsa).hnadsa("type", String.valueOf(2)).hnadse();
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "#AdEvent#Ad mini app", new Object[0]);
            if (adListener != null) {
                adListener.onMiniAppStarted();
                return;
            }
            return;
        }
        if (110 == i) {
            if (adListener != null) {
                adListener.onAdImpressionFailed(com.hihonor.adsdk.common.f.q.hnadsf(cVar.hnadss()), cVar.hnadst());
            }
            new s0(cVar, cVar.hnadsl(), aVarHnadsa).hnadse();
        }
    }

    public static void hnadsa(int i, BaseAd baseAd) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportAppInfoClickEvent baseAd is null", new Object[0]);
            return;
        }
        new com.hihonor.adsdk.base.g.j.d.a(i, baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).hnadse();
        new com.hihonor.adsdk.base.g.k.c.a(i).hnadsa(baseAd, baseAd.getTrackUrl().getCommons());
    }

    private static void hnadsa(com.hihonor.adsdk.base.g.j.d.c cVar) {
        if (cVar == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "reportTrack but adEventBean == null", new Object[0]);
            return;
        }
        TrackAdRequest trackAdRequest = new TrackAdRequest();
        trackAdRequest.setAdUnitId(cVar.hnadsl());
        trackAdRequest.setAdType(cVar.hnadsk());
        trackAdRequest.setMediaRequestId(cVar.f());
        trackAdRequest.setLoadType(cVar.hnadsw());
        trackAdRequest.setSdkVersionName("10024300");
        trackAdRequest.setThirdPlatformId(AdnConfig.b.hnadsa);
        trackAdRequest.setLoadAction(String.valueOf(0));
        trackAdRequest.setOaid(com.hihonor.adsdk.base.init.j.b.hnadsa().hnadsb());
        trackAdRequest.setPackageName(HnAds.get().getContext() != null ? HnAds.get().getContext().getPackageName() : "");
        new b0(trackAdRequest).hnadsa(cVar.hnadsl(), cVar.hnadsx());
    }
}
