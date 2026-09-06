package com.kwad.sdk.core.b.a;

import com.kwad.sdk.crash.model.message.AnrReason;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class bj implements com.kwad.sdk.core.d<AnrReason> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((AnrReason) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((AnrReason) bVar, jSONObject);
    }

    private static void a(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        anrReason.mTag = jSONObject.optString("mTag");
        if (JSONObject.NULL.toString().equals(anrReason.mTag)) {
            anrReason.mTag = "";
        }
        anrReason.mShortMsg = jSONObject.optString("mShortMsg");
        if (JSONObject.NULL.toString().equals(anrReason.mShortMsg)) {
            anrReason.mShortMsg = "";
        }
        anrReason.mLongMsg = jSONObject.optString("mLongMsg");
        if (JSONObject.NULL.toString().equals(anrReason.mLongMsg)) {
            anrReason.mLongMsg = "";
        }
    }

    private static JSONObject b(AnrReason anrReason, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (anrReason.mTag != null && !anrReason.mTag.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mTag", anrReason.mTag);
        }
        if (anrReason.mShortMsg != null && !anrReason.mShortMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mShortMsg", anrReason.mShortMsg);
        }
        if (anrReason.mLongMsg != null && !anrReason.mLongMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "mLongMsg", anrReason.mLongMsg);
        }
        return jSONObject;
    }
}
