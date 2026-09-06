package com.kwad.components.core.innerEc;

import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class d {
    private l<b, InnerEcLoginBindResultDate> SO;

    public final void a(final String str, final c cVar, final String str2) {
        l<b, InnerEcLoginBindResultDate> lVar = new l<b, InnerEcLoginBindResultDate>() { // from class: com.kwad.components.core.innerEc.d.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str3) {
                return ay(str3);
            }

            private static InnerEcLoginBindResultDate ay(String str3) {
                JSONObject jSONObject = new JSONObject(str3);
                InnerEcLoginBindResultDate innerEcLoginBindResultDate = new InnerEcLoginBindResultDate();
                innerEcLoginBindResultDate.parseJson(jSONObject);
                return innerEcLoginBindResultDate;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: rd, reason: merged with bridge method [inline-methods] */
            public b createRequest() {
                return new b(str, str2);
            }
        };
        this.SO = lVar;
        lVar.request(new o<b, InnerEcLoginBindResultDate>() { // from class: com.kwad.components.core.innerEc.d.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((InnerEcLoginBindResultDate) baseResultData);
            }

            private void a(InnerEcLoginBindResultDate innerEcLoginBindResultDate) {
                if (cVar != null) {
                    if (innerEcLoginBindResultDate.isParseSuccess()) {
                        cVar.a(innerEcLoginBindResultDate.getData());
                    } else {
                        cVar.rc();
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(b bVar, int i, String str3) {
                super.onError(bVar, i, str3);
                c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.rc();
                }
            }
        });
    }
}
