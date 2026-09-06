package com.kwad.sdk.core.b.a;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.scene.URLPackage;
import com.opos.mobad.activity.VideoActivity;
import com.yfanads.ads.chanel.ks.utils.KSUtil;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class kq implements com.kwad.sdk.core.d<com.kwad.sdk.core.report.n> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((com.kwad.sdk.core.report.n) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((com.kwad.sdk.core.report.n) bVar, jSONObject);
    }

    private static void a(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        nVar.timestamp = jSONObject.optLong(com.alipay.sdk.tid.b.f);
        nVar.sessionId = jSONObject.optString("sessionId");
        if (JSONObject.NULL.toString().equals(nVar.sessionId)) {
            nVar.sessionId = "";
        }
        nVar.OT = jSONObject.optLong("seq");
        nVar.aVs = jSONObject.optLong("listId");
        nVar.actionType = jSONObject.optLong(VideoActivity.EXTRA_KEY_ACTION_TYPE);
        nVar.QY = jSONObject.optString("payload");
        if (JSONObject.NULL.toString().equals(nVar.QY)) {
            nVar.QY = "";
        }
        nVar.llsid = jSONObject.optLong(KSUtil.REQUEST_ID);
        nVar.aVt = jSONObject.optJSONObject("extra");
        nVar.aVu = jSONObject.optJSONObject("impAdExtra");
        nVar.posId = jSONObject.optLong("posId");
        nVar.contentType = jSONObject.optInt("contentType");
        nVar.realShowType = jSONObject.optInt("realShowType");
        nVar.photoId = jSONObject.optLong("photoId");
        nVar.position = jSONObject.optLong("position");
        nVar.aVv = jSONObject.optLong("serverPosition");
        nVar.aVw = jSONObject.optLong("photoDuration");
        nVar.aVx = jSONObject.optLong("effectivePlayDuration");
        nVar.apv = jSONObject.optLong("playDuration");
        nVar.blockDuration = jSONObject.optLong("blockDuration");
        nVar.aVy = jSONObject.optLong("intervalDuration");
        nVar.aVz = jSONObject.optLong("allIntervalDuration");
        nVar.aVA = jSONObject.optLong("flowSdk");
        nVar.aVB = jSONObject.optLong("blockTimes");
        nVar.contentSourceType = jSONObject.optInt("contentSourceType", new Integer("0").intValue());
        nVar.aMA = jSONObject.optInt("adAggPageSource");
        nVar.entryPageSource = jSONObject.optString("entryPageSource");
        if (JSONObject.NULL.toString().equals(nVar.entryPageSource)) {
            nVar.entryPageSource = "";
        }
        nVar.urlPackage = new URLPackage();
        nVar.urlPackage.parseJson(jSONObject.optJSONObject("urlPackage"));
        nVar.aVC = new URLPackage();
        nVar.aVC.parseJson(jSONObject.optJSONObject("referURLPackage"));
        nVar.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        nVar.aVD = jSONObject.optString("photoSize");
        if (JSONObject.NULL.toString().equals(nVar.aVD)) {
            nVar.aVD = "";
        }
        nVar.aVE = jSONObject.optJSONArray("appInstalled");
        nVar.aVF = jSONObject.optJSONArray("appUninstalled");
        nVar.aVG = new com.kwad.sdk.core.report.n.a();
        nVar.aVG.parseJson(jSONObject.optJSONObject("clientExt"));
        nVar.aVH = jSONObject.optInt("playerType");
        nVar.aVI = jSONObject.optInt("uiType");
        nVar.aVJ = jSONObject.optInt("isLeftSlipStatus", new Integer("0").intValue());
        nVar.aqR = jSONObject.optInt("refreshType");
        nVar.aVK = jSONObject.optInt("photoResponseType", new Integer("0").intValue());
        nVar.aVL = jSONObject.optString("failUrl");
        if (JSONObject.NULL.toString().equals(nVar.aVL)) {
            nVar.aVL = "";
        }
        nVar.errorMsg = jSONObject.optString(MediationConstant.KEY_ERROR_MSG);
        if (JSONObject.NULL.toString().equals(nVar.errorMsg)) {
            nVar.errorMsg = "";
        }
        nVar.errorCode = jSONObject.optInt("errorCode", new Integer("0").intValue());
        nVar.creativeId = jSONObject.optLong("creativeId");
        nVar.aVO = jSONObject.optString("cacheFailedReason");
        if (JSONObject.NULL.toString().equals(nVar.aVO)) {
            nVar.aVO = "";
        }
        nVar.aVP = jSONObject.optJSONObject("appExt");
        nVar.aVQ = jSONObject.optJSONArray("appRunningInfoList");
        nVar.downloadDuration = jSONObject.optLong("downloadDuration");
        nVar.pageType = jSONObject.optInt("pageType", new Integer("0").intValue());
        nVar.aVR = jSONObject.optInt("speedLimitStatus");
        nVar.aVS = jSONObject.optInt("speedLimitThreshold");
        nVar.aVT = jSONObject.optInt("currentRealDownloadSpeed");
        nVar.aVV = jSONObject.optJSONArray("sdkPlatform");
        nVar.aVW = jSONObject.optBoolean("isKsUnion");
        nVar.aVX = jSONObject.optString("trackMethodName");
        if (JSONObject.NULL.toString().equals(nVar.aVX)) {
            nVar.aVX = "";
        }
        nVar.aVY = jSONObject.optInt("viewModeType", new Integer("0").intValue());
        nVar.clickTime = jSONObject.optLong("clickTime");
        nVar.aWa = jSONObject.optLong("frameRenderTime");
        nVar.aWb = jSONObject.optInt("playerEnterAction");
        nVar.aWc = jSONObject.optString("requestUrl");
        if (JSONObject.NULL.toString().equals(nVar.aWc)) {
            nVar.aWc = "";
        }
        nVar.aWd = jSONObject.optLong("requestTotalTime");
        nVar.aWe = jSONObject.optLong("requestResponseTime");
        nVar.aWf = jSONObject.optLong("requestParseDataTime");
        nVar.aWg = jSONObject.optLong("requestCallbackTime");
        nVar.aWh = jSONObject.optString("requestFailReason");
        if (JSONObject.NULL.toString().equals(nVar.aWh)) {
            nVar.aWh = "";
        }
        nVar.ajo = jSONObject.optString("pageName");
        if (JSONObject.NULL.toString().equals(nVar.ajo)) {
            nVar.ajo = "";
        }
        nVar.ajw = jSONObject.optLong("pageCreateTime");
        nVar.ajx = jSONObject.optLong("pageResumeTime");
        nVar.aWi = jSONObject.optInt("trackUrlType");
        nVar.aWj = jSONObject.optJSONArray("trackUrlList");
        nVar.ajv = jSONObject.optLong("pageLaunchTime");
        nVar.aWm = jSONObject.optJSONArray("appAuthorityInfoList");
        nVar.aWn = jSONObject.optString("tkVersion");
        if (JSONObject.NULL.toString().equals(nVar.aWn)) {
            nVar.aWn = "";
        }
        nVar.aWo = jSONObject.optString("jsVersion");
        if (JSONObject.NULL.toString().equals(nVar.aWo)) {
            nVar.aWo = "";
        }
        nVar.aWp = jSONObject.optString("jsFileName");
        if (JSONObject.NULL.toString().equals(nVar.aWp)) {
            nVar.aWp = "";
        }
        nVar.aWq = jSONObject.optString("jsErrorMsg");
        if (JSONObject.NULL.toString().equals(nVar.aWq)) {
            nVar.aWq = "";
        }
        nVar.aWr = jSONObject.optString("jsConfig");
        if (JSONObject.NULL.toString().equals(nVar.aWr)) {
            nVar.aWr = "";
        }
        nVar.aWs = jSONObject.optInt("adBizType");
        nVar.aWt = jSONObject.optString("customKey");
        if (JSONObject.NULL.toString().equals(nVar.aWt)) {
            nVar.aWt = "";
        }
        nVar.aWu = jSONObject.optString("customValue");
        if (JSONObject.NULL.toString().equals(nVar.aWu)) {
            nVar.aWu = "";
        }
        nVar.trace = jSONObject.optString("trace");
        if (JSONObject.NULL.toString().equals(nVar.trace)) {
            nVar.trace = "";
        }
        nVar.aWv = jSONObject.optInt("filterCode");
        nVar.aWw = jSONObject.optInt("sdkVersionCode");
        nVar.sdkVersion = jSONObject.optString("sdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.sdkVersion)) {
            nVar.sdkVersion = "";
        }
        nVar.aWx = jSONObject.optString("adSdkVersion");
        if (JSONObject.NULL.toString().equals(nVar.aWx)) {
            nVar.aWx = "";
        }
        nVar.sdkApiVersion = jSONObject.optString("sdkApiVersion");
        if (JSONObject.NULL.toString().equals(nVar.sdkApiVersion)) {
            nVar.sdkApiVersion = "";
        }
        nVar.sdkType = jSONObject.optInt("sdkType");
        nVar.aWy = jSONObject.optLong("appUseDuration");
        nVar.aWz = jSONObject.optLong("appStartType");
        nVar.aRP = jSONObject.optLong("sequenceNumber");
        nVar.OQ = jSONObject.optString("appColdStart");
        if (JSONObject.NULL.toString().equals(nVar.OQ)) {
            nVar.OQ = "";
        }
        nVar.OR = jSONObject.optString("appStart");
        if (JSONObject.NULL.toString().equals(nVar.OR)) {
            nVar.OR = "";
        }
    }

    private static JSONObject b(com.kwad.sdk.core.report.n nVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (nVar.timestamp != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, com.alipay.sdk.tid.b.f, nVar.timestamp);
        }
        if (nVar.sessionId != null && !nVar.sessionId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sessionId", nVar.sessionId);
        }
        if (nVar.OT != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "seq", nVar.OT);
        }
        if (nVar.aVs != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "listId", nVar.aVs);
        }
        if (nVar.actionType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, VideoActivity.EXTRA_KEY_ACTION_TYPE, nVar.actionType);
        }
        if (nVar.QY != null && !nVar.QY.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "payload", nVar.QY);
        }
        if (nVar.llsid != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, KSUtil.REQUEST_ID, nVar.llsid);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "extra", nVar.aVt);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "impAdExtra", nVar.aVu);
        if (nVar.posId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "posId", nVar.posId);
        }
        if (nVar.contentType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "contentType", nVar.contentType);
        }
        if (nVar.realShowType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "realShowType", nVar.realShowType);
        }
        if (nVar.photoId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoId", nVar.photoId);
        }
        if (nVar.position != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "position", nVar.position);
        }
        if (nVar.aVv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "serverPosition", nVar.aVv);
        }
        if (nVar.aVw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoDuration", nVar.aVw);
        }
        if (nVar.aVx != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "effectivePlayDuration", nVar.aVx);
        }
        if (nVar.apv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playDuration", nVar.apv);
        }
        if (nVar.blockDuration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blockDuration", nVar.blockDuration);
        }
        if (nVar.aVy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "intervalDuration", nVar.aVy);
        }
        if (nVar.aVz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "allIntervalDuration", nVar.aVz);
        }
        if (nVar.aVA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "flowSdk", nVar.aVA);
        }
        if (nVar.aVB != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "blockTimes", nVar.aVB);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "contentSourceType", nVar.contentSourceType);
        if (nVar.aMA != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adAggPageSource", nVar.aMA);
        }
        if (nVar.entryPageSource != null && !nVar.entryPageSource.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "entryPageSource", nVar.entryPageSource);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "urlPackage", nVar.urlPackage);
        com.kwad.sdk.utils.ac.a(jSONObject, "referURLPackage", nVar.aVC);
        if (nVar.authorId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, nVar.authorId);
        }
        if (nVar.aVD != null && !nVar.aVD.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "photoSize", nVar.aVD);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appInstalled", nVar.aVE);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appUninstalled", nVar.aVF);
        com.kwad.sdk.utils.ac.a(jSONObject, "clientExt", nVar.aVG);
        if (nVar.aVH != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playerType", nVar.aVH);
        }
        if (nVar.aVI != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "uiType", nVar.aVI);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "isLeftSlipStatus", nVar.aVJ);
        if (nVar.aqR != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "refreshType", nVar.aqR);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "photoResponseType", nVar.aVK);
        if (nVar.aVL != null && !nVar.aVL.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "failUrl", nVar.aVL);
        }
        if (nVar.errorMsg != null && !nVar.errorMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, MediationConstant.KEY_ERROR_MSG, nVar.errorMsg);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "errorCode", nVar.errorCode);
        if (nVar.creativeId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "creativeId", nVar.creativeId);
        }
        if (nVar.aVO != null && !nVar.aVO.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "cacheFailedReason", nVar.aVO);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appExt", nVar.aVP);
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appRunningInfoList", nVar.aVQ);
        if (nVar.downloadDuration != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "downloadDuration", nVar.downloadDuration);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "pageType", nVar.pageType);
        if (nVar.aVR != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "speedLimitStatus", nVar.aVR);
        }
        if (nVar.aVS != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "speedLimitThreshold", nVar.aVS);
        }
        if (nVar.aVT != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "currentRealDownloadSpeed", nVar.aVT);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkPlatform", nVar.aVV);
        if (nVar.aVW) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "isKsUnion", nVar.aVW);
        }
        if (nVar.aVX != null && !nVar.aVX.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "trackMethodName", nVar.aVX);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "viewModeType", nVar.aVY);
        if (nVar.clickTime != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "clickTime", nVar.clickTime);
        }
        if (nVar.aWa != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "frameRenderTime", nVar.aWa);
        }
        if (nVar.aWb != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "playerEnterAction", nVar.aWb);
        }
        if (nVar.aWc != null && !nVar.aWc.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestUrl", nVar.aWc);
        }
        if (nVar.aWd != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestTotalTime", nVar.aWd);
        }
        if (nVar.aWe != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestResponseTime", nVar.aWe);
        }
        if (nVar.aWf != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestParseDataTime", nVar.aWf);
        }
        if (nVar.aWg != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestCallbackTime", nVar.aWg);
        }
        if (nVar.aWh != null && !nVar.aWh.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "requestFailReason", nVar.aWh);
        }
        if (nVar.ajo != null && !nVar.ajo.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageName", nVar.ajo);
        }
        if (nVar.ajw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageCreateTime", nVar.ajw);
        }
        if (nVar.ajx != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageResumeTime", nVar.ajx);
        }
        if (nVar.aWi != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "trackUrlType", nVar.aWi);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "trackUrlList", nVar.aWj);
        if (nVar.ajv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageLaunchTime", nVar.ajv);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "appAuthorityInfoList", nVar.aWm);
        if (nVar.aWn != null && !nVar.aWn.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "tkVersion", nVar.aWn);
        }
        if (nVar.aWo != null && !nVar.aWo.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "jsVersion", nVar.aWo);
        }
        if (nVar.aWp != null && !nVar.aWp.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "jsFileName", nVar.aWp);
        }
        if (nVar.aWq != null && !nVar.aWq.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "jsErrorMsg", nVar.aWq);
        }
        if (nVar.aWr != null && !nVar.aWr.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "jsConfig", nVar.aWr);
        }
        if (nVar.aWs != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adBizType", nVar.aWs);
        }
        if (nVar.aWt != null && !nVar.aWt.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "customKey", nVar.aWt);
        }
        if (nVar.aWu != null && !nVar.aWu.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "customValue", nVar.aWu);
        }
        if (nVar.trace != null && !nVar.trace.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "trace", nVar.trace);
        }
        if (nVar.aWv != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "filterCode", nVar.aWv);
        }
        if (nVar.aWw != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkVersionCode", nVar.aWw);
        }
        if (nVar.sdkVersion != null && !nVar.sdkVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkVersion", nVar.sdkVersion);
        }
        if (nVar.aWx != null && !nVar.aWx.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "adSdkVersion", nVar.aWx);
        }
        if (nVar.sdkApiVersion != null && !nVar.sdkApiVersion.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkApiVersion", nVar.sdkApiVersion);
        }
        if (nVar.sdkType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sdkType", nVar.sdkType);
        }
        if (nVar.aWy != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appUseDuration", nVar.aWy);
        }
        if (nVar.aWz != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appStartType", nVar.aWz);
        }
        if (nVar.aRP != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "sequenceNumber", nVar.aRP);
        }
        if (nVar.OQ != null && !nVar.OQ.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appColdStart", nVar.OQ);
        }
        if (nVar.OR != null && !nVar.OR.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "appStart", nVar.OR);
        }
        return jSONObject;
    }
}
