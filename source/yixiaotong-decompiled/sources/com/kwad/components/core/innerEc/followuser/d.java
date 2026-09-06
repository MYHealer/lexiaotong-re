package com.kwad.components.core.innerEc.followuser;

import com.kwad.components.core.innerEc.f;
import com.kwad.components.offline.api.core.adInnerEc.Callback;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.by;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d {
    public static void a(String str, final Callback callback) {
        final Map<String, String> mapRj = f.rj();
        if (mapRj == null) {
            a(callback, "-100", "user not login");
            return;
        }
        b bVarAA = aA(str);
        if (bVarAA == null) {
            a(callback, "-101", "params from h5 not legal: " + str);
        } else {
            final a aVarAz = a.az(bVarAA.Ti);
            new l<c, FollowUserResultData>() { // from class: com.kwad.components.core.innerEc.followuser.d.1
                @Override // com.kwad.sdk.core.network.l
                public final /* synthetic */ BaseResultData parseData(String str2) {
                    return aB(str2);
                }

                private static FollowUserResultData aB(String str2) {
                    FollowUserResultData followUserResultData = new FollowUserResultData();
                    followUserResultData.parseJson(new JSONObject(str2));
                    return followUserResultData;
                }

                /* JADX INFO: Access modifiers changed from: private */
                @Override // com.kwad.sdk.core.network.a
                /* JADX INFO: renamed from: rq, reason: merged with bridge method [inline-methods] */
                public c createRequest() {
                    return new c(mapRj, aVarAz);
                }
            }.request(new g<c, FollowUserResultData>() { // from class: com.kwad.components.core.innerEc.followuser.d.2
                @Override // com.kwad.sdk.core.network.g
                public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str2) {
                    m(i, str2);
                }

                @Override // com.kwad.sdk.core.network.g
                public final /* synthetic */ void onStartRequest(com.kwad.sdk.core.network.f fVar) {
                    a((c) fVar);
                }

                @Override // com.kwad.sdk.core.network.g
                public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                    rr();
                }

                private static void a(c cVar) {
                    com.kwad.sdk.core.d.c.w("FollowUserRequestHelper", "onStartRequest: " + cVar.getUrl());
                }

                private void rr() {
                    d.a(callback, "success");
                }

                private void m(int i, String str2) {
                    d.a(callback, new StringBuilder().append(i).toString(), str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Callback callback, final String str, final String str2) {
        com.kwad.sdk.core.d.c.w("FollowUserRequestHelper", "notifyError errorCode: " + str + ", errorMsg: " + str2);
        if (callback != null) {
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.followuser.d.3
                @Override // java.lang.Runnable
                public final void run() {
                    callback.onFail(str, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final Callback callback, final String str) {
        com.kwad.sdk.core.d.c.w("FollowUserRequestHelper", "notifySuccess: ");
        if (callback != null) {
            by.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.followuser.d.4
                @Override // java.lang.Runnable
                public final void run() {
                    callback.onSuccess(str);
                }
            });
        }
    }

    private static b aA(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            b bVar = new b();
            bVar.parseJson(jSONObject);
            return bVar;
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            return null;
        }
    }
}
