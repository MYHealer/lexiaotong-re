package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class aj implements com.kwad.sdk.core.d<com.kwad.sdk.core.adlog.c.a> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.adlog.c.a) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.adlog.c.a) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.adTemplate = new AdTemplate();
        aVar.adTemplate.parseJson(jSONObject.optJSONObject("adTemplate"));
        aVar.aMe = jSONObject.optJSONObject("extData");
        aVar.aKI = jSONObject.optInt("adActionType");
        aVar.aMf = jSONObject.optInt("photoPlaySecond");
        aVar.aMg = jSONObject.optInt("awardReceiveStage");
        aVar.nm = jSONObject.optInt("itemClickType");
        aVar.aMh = jSONObject.optInt("itemCloseType");
        aVar.aMi = jSONObject.optInt("elementType");
        aVar.aMj = jSONObject.optString("adRenderArea");
        if (JSONObject.NULL.toString().equals(aVar.aMj)) {
            aVar.aMj = "";
        }
        aVar.aMk = jSONObject.optLong("highestLossPrice");
        aVar.aMl = jSONObject.optInt("impFailReason");
        aVar.aMm = jSONObject.optLong("winEcpm");
        aVar.adnType = jSONObject.optInt("adnType");
        aVar.adnName = jSONObject.optString(MediationConstant.KEY_ADN_NAME);
        if (JSONObject.NULL.toString().equals(aVar.adnName)) {
            aVar.adnName = "";
        }
        aVar.aMn = jSONObject.optString("adnAdvertiser");
        if (JSONObject.NULL.toString().equals(aVar.aMn)) {
            aVar.aMn = "";
        }
        aVar.aMo = jSONObject.optString("adnTitle");
        if (JSONObject.NULL.toString().equals(aVar.aMo)) {
            aVar.aMo = "";
        }
        aVar.aMp = jSONObject.optString("adnRequestId");
        if (JSONObject.NULL.toString().equals(aVar.aMp)) {
            aVar.aMp = "";
        }
        aVar.aMq = jSONObject.optInt("adnShowType");
        aVar.aMr = jSONObject.optInt("adnClickType");
        aVar.adnMaterialType = jSONObject.optInt("adnMaterialType");
        aVar.adnMaterialUrl = jSONObject.optString("adnMaterialUrl");
        if (JSONObject.NULL.toString().equals(aVar.adnMaterialUrl)) {
            aVar.adnMaterialUrl = "";
        }
        aVar.aMs = jSONObject.optInt("retainCodeType");
        aVar.Ra = jSONObject.optInt("photoSizeStyle");
        aVar.QY = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(aVar.QY)) {
            aVar.QY = "";
        }
        aVar.aMt = jSONObject.optInt("deeplinkType");
        aVar.aMu = jSONObject.optString("deeplinkAppName");
        if (JSONObject.NULL.toString().equals(aVar.aMu)) {
            aVar.aMu = "";
        }
        aVar.aMv = jSONObject.optInt("deeplinkFailedReason");
        aVar.downloadSource = jSONObject.optInt(com.huawei.hms.ads.gf.I);
        aVar.aMw = jSONObject.optInt("isPackageChanged");
        aVar.aMx = jSONObject.optString("installedFrom");
        if (JSONObject.NULL.toString().equals(aVar.aMx)) {
            aVar.aMx = "";
        }
        aVar.aMy = jSONObject.optString("downloadFailedReason");
        if (JSONObject.NULL.toString().equals(aVar.aMy)) {
            aVar.aMy = "";
        }
        aVar.aMz = jSONObject.optInt("isChangedEndcard");
        aVar.aMA = jSONObject.optInt("adAggPageSource");
        aVar.aMB = jSONObject.optString("serverPackageName");
        if (JSONObject.NULL.toString().equals(aVar.aMB)) {
            aVar.aMB = "";
        }
        aVar.aMC = jSONObject.optString("installedPackageName");
        if (JSONObject.NULL.toString().equals(aVar.aMC)) {
            aVar.aMC = "";
        }
        aVar.aMD = jSONObject.optInt("closeButtonImpressionTime");
        aVar.aME = jSONObject.optInt("closeButtonClickTime");
        aVar.aMF = jSONObject.optLong("landingPageLoadedDuration");
        aVar.RD = jSONObject.optLong("leaveTime");
        aVar.aMG = jSONObject.optLong("adItemClickBackDuration");
        aVar.aMH = jSONObject.optInt("appStorePageType");
        aVar.aMI = jSONObject.optInt("installStatus");
        aVar.downloadStatus = jSONObject.optInt("downloadStatus");
        aVar.aMJ = jSONObject.optInt("downloadCardType");
        aVar.QZ = new com.kwad.sdk.core.adlog.a.C0733a();
        aVar.QZ.parseJson(jSONObject.optJSONObject("clientExtData"));
        aVar.ads = jSONObject.optInt("landingPageType");
        aVar.zV = jSONObject.optLong("playedDuration");
        aVar.aMK = jSONObject.optInt("playedRate");
        aVar.aML = jSONObject.optInt("adOrder");
        aVar.QX = jSONObject.optInt("adInterstitialSource");
        aVar.np = jSONObject.optDouble("splashShakeAcceleration");
        aVar.aMM = jSONObject.optString("splashInteractionRotateAngle");
        if (JSONObject.NULL.toString().equals(aVar.aMM)) {
            aVar.aMM = "";
        }
        aVar.aMN = jSONObject.optInt("downloadInstallType");
        aVar.aMO = jSONObject.optInt("businessSceneType");
        aVar.adxResult = jSONObject.optInt("adxResult");
        aVar.aMP = jSONObject.optInt("fingerSwipeType");
        aVar.aMQ = jSONObject.optInt("fingerSwipeDistance");
        aVar.aMR = jSONObject.optInt("finger_swipe_angle");
        aVar.Rb = jSONObject.optInt("triggerType");
        aVar.aMS = jSONObject.optInt("cardCloseType");
        aVar.aMT = jSONObject.optString("clientPkFailAdInfo");
        if (JSONObject.NULL.toString().equals(aVar.aMT)) {
            aVar.aMT = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.adlog.c.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "adTemplate", aVar.adTemplate);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "extData", aVar.aMe);
        if (aVar.aKI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adActionType", aVar.aKI);
        }
        if (aVar.aMf != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoPlaySecond", aVar.aMf);
        }
        if (aVar.aMg != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "awardReceiveStage", aVar.aMg);
        }
        if (aVar.nm != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "itemClickType", aVar.nm);
        }
        if (aVar.aMh != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "itemCloseType", aVar.aMh);
        }
        if (aVar.aMi != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "elementType", aVar.aMi);
        }
        if (aVar.aMj != null && !aVar.aMj.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adRenderArea", aVar.aMj);
        }
        if (aVar.aMk != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "highestLossPrice", aVar.aMk);
        }
        if (aVar.aMl != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "impFailReason", aVar.aMl);
        }
        if (aVar.aMm != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "winEcpm", aVar.aMm);
        }
        if (aVar.adnType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnType", aVar.adnType);
        }
        if (aVar.adnName != null && !aVar.adnName.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediationConstant.KEY_ADN_NAME, aVar.adnName);
        }
        if (aVar.aMn != null && !aVar.aMn.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnAdvertiser", aVar.aMn);
        }
        if (aVar.aMo != null && !aVar.aMo.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnTitle", aVar.aMo);
        }
        if (aVar.aMp != null && !aVar.aMp.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnRequestId", aVar.aMp);
        }
        if (aVar.aMq != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnShowType", aVar.aMq);
        }
        if (aVar.aMr != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnClickType", aVar.aMr);
        }
        if (aVar.adnMaterialType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnMaterialType", aVar.adnMaterialType);
        }
        if (aVar.adnMaterialUrl != null && !aVar.adnMaterialUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adnMaterialUrl", aVar.adnMaterialUrl);
        }
        if (aVar.aMs != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "retainCodeType", aVar.aMs);
        }
        if (aVar.Ra != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoSizeStyle", aVar.Ra);
        }
        if (aVar.QY != null && !aVar.QY.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "payload", aVar.QY);
        }
        if (aVar.aMt != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplinkType", aVar.aMt);
        }
        if (aVar.aMu != null && !aVar.aMu.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplinkAppName", aVar.aMu);
        }
        if (aVar.aMv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplinkFailedReason", aVar.aMv);
        }
        if (aVar.downloadSource != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.huawei.hms.ads.gf.I, aVar.downloadSource);
        }
        if (aVar.aMw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isPackageChanged", aVar.aMw);
        }
        if (aVar.aMx != null && !aVar.aMx.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "installedFrom", aVar.aMx);
        }
        if (aVar.aMy != null && !aVar.aMy.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadFailedReason", aVar.aMy);
        }
        if (aVar.aMz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isChangedEndcard", aVar.aMz);
        }
        if (aVar.aMA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adAggPageSource", aVar.aMA);
        }
        if (aVar.aMB != null && !aVar.aMB.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serverPackageName", aVar.aMB);
        }
        if (aVar.aMC != null && !aVar.aMC.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "installedPackageName", aVar.aMC);
        }
        if (aVar.aMD != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "closeButtonImpressionTime", aVar.aMD);
        }
        if (aVar.aME != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "closeButtonClickTime", aVar.aME);
        }
        if (aVar.aMF != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "landingPageLoadedDuration", aVar.aMF);
        }
        if (aVar.RD != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "leaveTime", aVar.RD);
        }
        if (aVar.aMG != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adItemClickBackDuration", aVar.aMG);
        }
        if (aVar.aMH != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appStorePageType", aVar.aMH);
        }
        if (aVar.aMI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "installStatus", aVar.aMI);
        }
        if (aVar.downloadStatus != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadStatus", aVar.downloadStatus);
        }
        if (aVar.aMJ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadCardType", aVar.aMJ);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "clientExtData", aVar.QZ);
        if (aVar.ads != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "landingPageType", aVar.ads);
        }
        if (aVar.zV != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playedDuration", aVar.zV);
        }
        if (aVar.aMK != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playedRate", aVar.aMK);
        }
        if (aVar.aML != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adOrder", aVar.aML);
        }
        if (aVar.QX != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adInterstitialSource", aVar.QX);
        }
        if (aVar.np != 0.0d) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "splashShakeAcceleration", aVar.np);
        }
        if (aVar.aMM != null && !aVar.aMM.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "splashInteractionRotateAngle", aVar.aMM);
        }
        if (aVar.aMN != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadInstallType", aVar.aMN);
        }
        if (aVar.aMO != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "businessSceneType", aVar.aMO);
        }
        if (aVar.adxResult != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adxResult", aVar.adxResult);
        }
        if (aVar.aMP != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fingerSwipeType", aVar.aMP);
        }
        if (aVar.aMQ != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "fingerSwipeDistance", aVar.aMQ);
        }
        if (aVar.aMR != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "finger_swipe_angle", aVar.aMR);
        }
        if (aVar.Rb != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "triggerType", aVar.Rb);
        }
        if (aVar.aMS != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cardCloseType", aVar.aMS);
        }
        if (aVar.aMT != null && !aVar.aMT.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clientPkFailAdInfo", aVar.aMT);
        }
        return jSONObject;
    }
}
