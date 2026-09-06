package com.kwad.sdk.core.adlog;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.huawei.hms.ads.gf;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.br;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends com.kwad.sdk.core.network.b {
    int aLd;
    private final com.kwad.sdk.core.adlog.c.a aLe;
    private final AdTemplate mAdTemplate;

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b
    public final void buildBaseHeader() {
    }

    public a(com.kwad.sdk.core.adlog.c.a aVar) {
        this.aLe = aVar;
        this.mAdTemplate = aVar.adTemplate;
        this.aLd = aVar.aKI;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        return this.mBodyParams;
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        String strReplaceFirst;
        String strReplaceFirst2;
        Context context = ServiceProvider.getContext();
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        int i = this.aLd;
        if (i == 1) {
            String str = adInfoEO.adBaseInfo.showUrl;
            if (this.mAdTemplate.mBidEcpm == 0 && ((h) ServiceProvider.get(h.class)).FO()) {
                strReplaceFirst2 = str.replaceFirst("__PR__", String.valueOf(com.kwad.sdk.core.response.helper.a.aX(e.eO(this.mAdTemplate))));
            } else {
                strReplaceFirst2 = str.replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm));
            }
            strReplaceFirst = strReplaceFirst2.replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            a(strReplaceFirst, this.aLe);
            a(strReplaceFirst, this.mAdTemplate, this.aLe);
        } else if (i == 2) {
            strReplaceFirst = al.av(context, al.a(adInfoEO.adBaseInfo.clickUrl, this.aLe.no)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            b(strReplaceFirst, this.aLe);
            a(strReplaceFirst, this.mAdTemplate, this.aLe);
        } else {
            strReplaceFirst = adInfoEO.adBaseInfo.convUrl.replaceFirst("__ACTION__", String.valueOf(this.aLd)).replaceFirst("__PR__", String.valueOf(this.mAdTemplate.mBidEcpm)).replaceFirst("__TYPE__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerType)).replaceFirst("__BEHAVIOR__", String.valueOf(this.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior));
            c(strReplaceFirst, this.aLe);
        }
        IR();
        return strReplaceFirst;
    }

    private void a(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.aML >= 0) {
            putBody("adOrder", aVar.aML);
        }
        if (aVar.QX >= 0) {
            putBody("adInterstitialSource", aVar.QX);
        }
        if (!TextUtils.isEmpty(aVar.aMj)) {
            putBody("adRenderArea", aVar.aMj);
        }
        putBody("adxResult", aVar.adxResult);
        if (aVar.aMP != 0) {
            putBody("fingerSwipeType", aVar.aMP);
        }
        if (aVar.aMQ != 0) {
            putBody("fingerSwipeDistance", aVar.aMQ);
        }
        if (aVar.aMI != -1) {
            putBody("installStatus", aVar.aMI);
        }
        if (aVar.QZ != null) {
            putBody("clientExtData", aVar.QZ.toJson().toString());
        }
        if (aVar.aMT != null) {
            putBody("clientPkFailAdInfo", aVar.aMT);
        }
        if (aVar.Rb != -1) {
            putBody("triggerType", aVar.Rb);
        }
        if (aVar.Ra != 0) {
            putBody("photoSizeStyle", aVar.Ra);
        }
    }

    private void a(String str, AdTemplate adTemplate, com.kwad.sdk.core.adlog.c.a aVar) {
        if (TextUtils.isEmpty(str) || adTemplate == null) {
            return;
        }
        if (adTemplate.mInitVoiceStatus != 0) {
            putBody("initVoiceStatus", adTemplate.mInitVoiceStatus);
        }
        if (this.mAdTemplate.mBidEcpm == 0) {
            putBody("ecpmType", 2);
        } else {
            putBody("ecpmType", 1);
        }
        if (aVar == null) {
            return;
        }
        if (aVar.aMA != 0) {
            putBody("adAggPageSource", aVar.aMA);
        }
        if (TextUtils.isEmpty(aVar.QY)) {
            return;
        }
        putBody("payload", aVar.QY);
    }

    private void b(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.nm != 0) {
            putBody("itemClickType", aVar.nm);
        }
        if (!TextUtils.isEmpty(aVar.QY)) {
            putBody("payload", aVar.QY);
        }
        if (aVar.aMA != 0) {
            putBody("adAggPageSource", aVar.aMA);
        }
        if (aVar.aML >= 0) {
            putBody("adOrder", aVar.aML);
        }
        if (aVar.QX >= 0) {
            putBody("adInterstitialSource", aVar.QX);
        }
        if (aVar.Rb != -1) {
            putBody("triggerType", aVar.Rb);
        }
        if (aVar.aMS != 0) {
            putBody("cardCloseType", aVar.aMS);
        }
        putBody("adxResult", aVar.adxResult);
        if (aVar.np > 0.0d) {
            putBody("splashShakeAcceleration", aVar.np);
        }
        if (!TextUtils.isEmpty(aVar.aMM)) {
            putBody("splashInteractionRotateAngle", aVar.aMM);
        }
        if (aVar.aMP != 0) {
            putBody("fingerSwipeType", aVar.aMP);
        }
        if (aVar.aMQ != 0) {
            putBody("fingerSwipeDistance", aVar.aMQ);
        }
        if (aVar.zV > 0) {
            putBody("playedDuration", aVar.zV);
        }
        if (aVar.aMK > 0) {
            putBody("playedRate", aVar.aMK);
        }
        if (aVar.aMT != null) {
            putBody("clientPkFailAdInfo", aVar.aMT);
        }
        if (aVar.aMs != -1) {
            putBody("retainCodeType", aVar.aMs);
        }
        if (aVar.QZ != null) {
            putBody("clientExtData", aVar.QZ.toJson().toString());
        }
        if (aVar.aMR != 0) {
            putBody("finger_swiper_angle", aVar.aMR);
        }
        if (aVar.Ra != 0) {
            putBody("photoSizeStyle", aVar.Ra);
        }
    }

    private void c(String str, com.kwad.sdk.core.adlog.c.a aVar) {
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (aVar.aMh != 0) {
            putBody("itemCloseType", aVar.aMh);
        }
        if (aVar.aMf > 0) {
            putBody("photoPlaySecond", aVar.aMf);
        }
        if (aVar.aMg != 0) {
            putBody("awardReceiveStage", aVar.aMg);
        }
        if (aVar.aMi != 0) {
            putBody("elementType", aVar.aMi);
        }
        if (!TextUtils.isEmpty(aVar.QY)) {
            putBody("payload", aVar.QY);
        }
        if (aVar.QZ != null) {
            putBody("clientExtData", aVar.QZ.toJson().toString());
        }
        if (aVar.aMt > 0) {
            putBody("deeplinkType", aVar.aMt);
        }
        if (!TextUtils.isEmpty(aVar.aMu)) {
            putBody("deeplinkAppName", aVar.aMu);
        }
        if (aVar.aMv != 0) {
            putBody("deeplinkFailedReason", aVar.aMv);
        }
        if (aVar.downloadSource > 0) {
            putBody(gf.I, aVar.downloadSource);
        }
        if (aVar.aMS != 0) {
            putBody("cardCloseType", aVar.aMS);
        }
        if (aVar.aMw > 0) {
            putBody("isPackageChanged", aVar.aMw);
        }
        putBody("installedFrom", aVar.aMx);
        putBody("isChangedEndcard", aVar.aMz);
        if (aVar.aMA != 0) {
            putBody("adAggPageSource", aVar.aMA);
        }
        if (aVar.aMy != null) {
            putBody("downloadFailedReason", aVar.aMy);
        }
        if (!br.isNullString(aVar.aMC)) {
            putBody("installedPackageName", aVar.aMC);
        }
        if (!br.isNullString(aVar.aMB)) {
            putBody("serverPackageName", aVar.aMB);
        }
        if (aVar.aME > 0) {
            putBody("closeButtonClickTime", aVar.aME);
        }
        if (aVar.aMD > 0) {
            putBody("closeButtonImpressionTime", aVar.aMD);
        }
        if (aVar.downloadStatus >= 0) {
            putBody("downloadStatus", aVar.downloadStatus);
        }
        if (aVar.aMF > 0) {
            putBody("landingPageLoadedDuration", aVar.aMF);
        }
        if (aVar.RD > 0) {
            putBody("leaveTime", aVar.RD);
        }
        if (aVar.aMG > 0) {
            putBody("adItemClickBackDuration", aVar.aMG);
        }
        if (aVar.aMs != -1) {
            putBody("retainCodeType", aVar.aMs);
        }
        if (aVar.aMk > -1) {
            putBody("highestLossPrice", aVar.aMk);
        }
        if (aVar.aMl >= 0 || aVar.aMl == -9999) {
            putBody("impFailReason", aVar.aMl);
        }
        if (aVar.aMm > -1 || aVar.aMm == -9999) {
            putBody("winEcpm", aVar.aMm);
        }
        if (aVar.adnType > 0 || aVar.adnType == -9999) {
            putBody("adnType", aVar.adnType);
        }
        if (!TextUtils.isEmpty(aVar.adnName)) {
            putBody(MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (!TextUtils.isEmpty(aVar.aMn)) {
            putBody("adnAdvertiser", aVar.aMn);
        }
        if (!TextUtils.isEmpty(aVar.aMo)) {
            putBody("adnTitle", aVar.aMo);
        }
        if (!TextUtils.isEmpty(aVar.aMp)) {
            putBody("adnRequestId", aVar.aMp);
        }
        putBody("adnShowType", aVar.aMq);
        putBody("adnClickType", aVar.aMr);
        putBody("adnMaterialType", aVar.adnMaterialType);
        if (!TextUtils.isEmpty(aVar.adnMaterialUrl)) {
            putBody("adnMaterialUrl", aVar.adnMaterialUrl);
        }
        putBody("downloadCardType", aVar.aMJ);
        putBody("landingPageType", aVar.ads);
        if (aVar.QX >= 0) {
            putBody("adInterstitialSource", aVar.QX);
        }
        if (aVar.aMN > 0) {
            putBody("downloadInstallType", aVar.aMN);
        }
        if (aVar.aMP != 0) {
            putBody("fingerSwipeType", aVar.aMP);
        }
        if (aVar.aMQ != 0) {
            putBody("fingerSwipeDistance", aVar.aMQ);
        }
        if (aVar.aMO > 0) {
            putBody("businessSceneType", aVar.aMO);
        }
        if (aVar.zV > 0) {
            putBody("playedDuration", aVar.zV);
        }
        if (aVar.aMK > 0) {
            putBody("playedRate", aVar.aMK);
        }
        if (aVar.aMH != -1) {
            putBody("appStorePageType", aVar.aMH);
        }
        if (aVar.Rb != -1) {
            putBody("triggerType", aVar.Rb);
        }
        if (aVar.Ra != 0) {
            putBody("photoSizeStyle", aVar.Ra);
        }
    }

    private void IR() {
        JSONObject jSONObject = this.aLe.aMe;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        ac.putValue(jSONObject, "clientTimestamp", System.currentTimeMillis());
        putBody("extData", jSONObject.toString());
    }

    /* JADX INFO: renamed from: com.kwad.sdk.core.adlog.a$a, reason: collision with other inner class name */
    public static class C0733a extends com.kwad.sdk.core.response.a.a {
        public String aLA;
        public int aLB;
        public int aLC;
        public int aLD;
        public int aLE;
        public AdTrackLog aLF;
        public int aLG;
        public int aLf;
        public String aLg;
        public String aLh;
        public String aLi;
        public String aLj;
        public String aLl;
        public int aLm;
        public int aLn;
        public int aLo;
        public int aLp;
        public int aLq;
        public boolean aLr;
        public String aLs;
        public JSONObject aLt;
        public int aLv;
        public int aLw;
        public int aLx;
        public int aLy;
        public String aLz;
        public String templateId;
        public int tkPublishType;
        public int aLk = -1;
        public long duration = -1;
        public int showLiveStatus = -1;
        public int aLu = 0;
        public int showLiveStyle = -1;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            int i = this.aLk;
            if (i != -1) {
                ac.putValue(jSONObject, "shield_reason", i);
            }
            long j = this.duration;
            if (j != -1) {
                ac.putValue(jSONObject, "duration", j);
            }
            int i2 = this.showLiveStatus;
            if (i2 != -1) {
                ac.putValue(jSONObject, "show_live_status", i2);
            }
            int i3 = this.showLiveStyle;
            if (i3 != -1) {
                ac.putValue(jSONObject, "show_live_style", i3);
            }
            AdTrackLog adTrackLog = this.aLF;
            if (adTrackLog != null) {
                ac.putValue(jSONObject, "ad_track_log", adTrackLog.toJson().toString());
            }
            JSONObject jSONObject2 = this.aLt;
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.putOpt(next, this.aLt.get(next));
                    }
                } catch (Throwable unused) {
                }
            }
        }

        public final AdTrackLog a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.g.a<AdTrackLog> aVar) {
            h hVar;
            if (adTemplate == null || (hVar = (h) ServiceProvider.get(h.class)) == null || !hVar.FZ()) {
                return null;
            }
            AdTrackLog adTrackLog = new AdTrackLog(str, str2);
            this.aLF = adTrackLog;
            adTrackLog.bindABParams(adTemplate);
            if (aVar != null) {
                aVar.accept(this.aLF);
            }
            return this.aLF;
        }
    }
}
