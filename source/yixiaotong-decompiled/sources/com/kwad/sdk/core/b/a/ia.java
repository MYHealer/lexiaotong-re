package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.LiveInfo;
import com.kwad.sdk.core.response.model.LiveRewardInfo;
import com.kwad.sdk.core.scene.URLPackage;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class ia implements com.kwad.sdk.core.d<LiveInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((LiveInfo) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((LiveInfo) bVar, jSONObject);
    }

    private static void a(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveInfo.livingLink = jSONObject.optString("livingLink");
        if (JSONObject.NULL.toString().equals(liveInfo.livingLink)) {
            liveInfo.livingLink = "";
        }
        liveInfo.shennongjiaLog = jSONObject.optString("shennongjiaLog");
        if (JSONObject.NULL.toString().equals(liveInfo.shennongjiaLog)) {
            liveInfo.shennongjiaLog = "";
        }
        liveInfo.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (JSONObject.NULL.toString().equals(liveInfo.nebulaKwaiLink)) {
            liveInfo.nebulaKwaiLink = "";
        }
        liveInfo.linkCode = jSONObject.optString("linkCode");
        if (JSONObject.NULL.toString().equals(liveInfo.linkCode)) {
            liveInfo.linkCode = "";
        }
        liveInfo.liveStreamId = jSONObject.optString("liveStreamId");
        if (JSONObject.NULL.toString().equals(liveInfo.liveStreamId)) {
            liveInfo.liveStreamId = "";
        }
        liveInfo.authorId = jSONObject.optLong(URLPackage.KEY_AUTHOR_ID);
        liveInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(liveInfo.title)) {
            liveInfo.title = "";
        }
        liveInfo.coverUrl = jSONObject.optString("coverUrl");
        if (JSONObject.NULL.toString().equals(liveInfo.coverUrl)) {
            liveInfo.coverUrl = "";
        }
        liveInfo.user = new LiveInfo.User();
        liveInfo.user.parseJson(jSONObject.optJSONObject("user"));
        liveInfo.coverUrlCdn = new LiveInfo.CoverUrlCdn();
        liveInfo.coverUrlCdn.parseJson(jSONObject.optJSONObject("coverUrlCdn"));
        liveInfo.audienceCount = jSONObject.optInt("audienceCount");
        liveInfo.caption = jSONObject.optString("caption");
        if (JSONObject.NULL.toString().equals(liveInfo.caption)) {
            liveInfo.caption = "";
        }
        liveInfo.cover_thumbnail_urls = new ArrayList();
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cover_thumbnail_urls");
        if (jSONArrayOptJSONArray != null) {
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                LiveInfo.CoverThumbnailUrl coverThumbnailUrl = new LiveInfo.CoverThumbnailUrl();
                coverThumbnailUrl.parseJson(jSONArrayOptJSONArray.optJSONObject(i));
                liveInfo.cover_thumbnail_urls.add(coverThumbnailUrl);
            }
        }
        liveInfo.exp_tag = jSONObject.optString("exp_tag");
        if (JSONObject.NULL.toString().equals(liveInfo.exp_tag)) {
            liveInfo.exp_tag = "";
        }
        liveInfo.liveStreamPlayCdnList = new ArrayList();
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("liveStreamPlayCdnList");
        if (jSONArrayOptJSONArray2 != null) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                LiveInfo.LiveStreamPlayCDNNode liveStreamPlayCDNNode = new LiveInfo.LiveStreamPlayCDNNode();
                liveStreamPlayCDNNode.parseJson(jSONArrayOptJSONArray2.optJSONObject(i2));
                liveInfo.liveStreamPlayCdnList.add(liveStreamPlayCDNNode);
            }
        }
        liveInfo.livePageType = jSONObject.optInt("livePageType");
        liveInfo.pageDataKey = jSONObject.optString("pageDataKey");
        if (JSONObject.NULL.toString().equals(liveInfo.pageDataKey)) {
            liveInfo.pageDataKey = "";
        }
        liveInfo.kwaiUserId = jSONObject.optString("kwaiUserId");
        if (JSONObject.NULL.toString().equals(liveInfo.kwaiUserId)) {
            liveInfo.kwaiUserId = "";
        }
        liveInfo.shopItemId = jSONObject.optString("shopItemId");
        if (JSONObject.NULL.toString().equals(liveInfo.shopItemId)) {
            liveInfo.shopItemId = "";
        }
        liveInfo.rewardInfo = new LiveRewardInfo();
        liveInfo.rewardInfo.parseJson(jSONObject.optJSONObject("rewardInfo"));
        liveInfo.deeplink = jSONObject.optString("deeplink");
        if (JSONObject.NULL.toString().equals(liveInfo.deeplink)) {
            liveInfo.deeplink = "";
        }
    }

    private static JSONObject b(LiveInfo liveInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (liveInfo.livingLink != null && !liveInfo.livingLink.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "livingLink", liveInfo.livingLink);
        }
        if (liveInfo.shennongjiaLog != null && !liveInfo.shennongjiaLog.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "shennongjiaLog", liveInfo.shennongjiaLog);
        }
        if (liveInfo.nebulaKwaiLink != null && !liveInfo.nebulaKwaiLink.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "nebulaKwaiLink", liveInfo.nebulaKwaiLink);
        }
        if (liveInfo.linkCode != null && !liveInfo.linkCode.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "linkCode", liveInfo.linkCode);
        }
        if (liveInfo.liveStreamId != null && !liveInfo.liveStreamId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamId", liveInfo.liveStreamId);
        }
        if (liveInfo.authorId != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, URLPackage.KEY_AUTHOR_ID, liveInfo.authorId);
        }
        if (liveInfo.title != null && !liveInfo.title.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "title", liveInfo.title);
        }
        if (liveInfo.coverUrl != null && !liveInfo.coverUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "coverUrl", liveInfo.coverUrl);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "user", liveInfo.user);
        com.kwad.sdk.utils.ac.a(jSONObject, "coverUrlCdn", liveInfo.coverUrlCdn);
        if (liveInfo.audienceCount != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "audienceCount", liveInfo.audienceCount);
        }
        if (liveInfo.caption != null && !liveInfo.caption.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "caption", liveInfo.caption);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "cover_thumbnail_urls", liveInfo.cover_thumbnail_urls);
        if (liveInfo.exp_tag != null && !liveInfo.exp_tag.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "exp_tag", liveInfo.exp_tag);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "liveStreamPlayCdnList", liveInfo.liveStreamPlayCdnList);
        if (liveInfo.livePageType != 0) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "livePageType", liveInfo.livePageType);
        }
        if (liveInfo.pageDataKey != null && !liveInfo.pageDataKey.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pageDataKey", liveInfo.pageDataKey);
        }
        if (liveInfo.kwaiUserId != null && !liveInfo.kwaiUserId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "kwaiUserId", liveInfo.kwaiUserId);
        }
        if (liveInfo.shopItemId != null && !liveInfo.shopItemId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "shopItemId", liveInfo.shopItemId);
        }
        com.kwad.sdk.utils.ac.a(jSONObject, "rewardInfo", liveInfo.rewardInfo);
        if (liveInfo.deeplink != null && !liveInfo.deeplink.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "deeplink", liveInfo.deeplink);
        }
        return jSONObject;
    }
}
