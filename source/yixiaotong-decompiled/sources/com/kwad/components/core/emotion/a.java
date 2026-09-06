package com.kwad.components.core.emotion;

import android.app.Application;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class a {
    public static void a(final Application application) {
        new l<b, EmotionPackageResponse>() { // from class: com.kwad.components.core.emotion.a.1
            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return qO();
            }

            private static b qO() {
                return new b();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* JADX INFO: renamed from: at, reason: merged with bridge method [inline-methods] */
            public EmotionPackageResponse parseData(String str) {
                EmotionPackageResponse emotionPackageResponse = new EmotionPackageResponse();
                emotionPackageResponse.parseJson(new JSONObject(str));
                com.kwad.components.core.innerEc.f.b(application, emotionPackageResponse.getFullJson());
                return emotionPackageResponse;
            }
        }.request(new g<b, EmotionPackageResponse>() { // from class: com.kwad.components.core.emotion.a.2
            @Override // com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onError(f fVar, int i, String str) {
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(f fVar) {
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
            }
        });
    }
}
