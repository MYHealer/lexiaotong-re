package com.kwad.sdk.mobileid.a;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.mobileid.d;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ai;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class a extends com.kwad.sdk.mobileid.b {
    private l<b, CMTokenResponse> aqr;
    private int retryCount = 0;
    private int aUX = 3;

    static /* synthetic */ int c(a aVar) {
        int i = aVar.retryCount;
        aVar.retryCount = i + 1;
        return i;
    }

    @Override // com.kwad.sdk.mobileid.b
    public final void cD(Context context) {
        d(context, false);
    }

    public final void d(final Context context, final boolean z) {
        d dVar;
        if (z) {
            dVar = new d(true, "uaidTokenCanRequestByWifi");
        } else {
            dVar = new d(true, "uaidTokenCanRequest");
        }
        com.kwad.sdk.mobileid.c.b(context, dVar);
        l<b, CMTokenResponse> lVar = new l<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.1
            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return Sp();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* JADX INFO: renamed from: hf, reason: merged with bridge method [inline-methods] */
            public CMTokenResponse parseData(String str) {
                CMTokenResponse cMTokenResponse = new CMTokenResponse();
                cMTokenResponse.parseJson(new JSONObject(str));
                ai.ag(context, cMTokenResponse.getResultToken());
                com.kwad.sdk.mobileid.a.Sg();
                com.kwad.sdk.mobileid.c.a(context, cMTokenResponse);
                return cMTokenResponse;
            }

            private static b Sp() {
                return new b();
            }
        };
        this.aqr = lVar;
        lVar.request(new o<b, CMTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                B(i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(b bVar, CMTokenResponse cMTokenResponse) {
                d dVar2;
                super.onSuccess(bVar, cMTokenResponse);
                boolean z2 = !TextUtils.isEmpty(ai.m988do(context));
                boolean z3 = a.this.retryCount < a.this.aUX;
                if (z2 && z3) {
                    a.c(a.this);
                    if (z) {
                        dVar2 = new d(true, "uaidTokenCanRequestByWifi");
                    } else {
                        dVar2 = new d(true, "uaidTokenCanRequest");
                    }
                    a.this.cE(context);
                } else if (!z2) {
                    dVar2 = new d(false, "noRequestUaidTokenEmpty");
                } else {
                    dVar2 = new d(false, "noRequestUaidRetry");
                }
                com.kwad.sdk.mobileid.c.c(context, dVar2);
            }

            private void B(int i, String str) {
                com.kwad.sdk.mobileid.c.b(context, i, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cE(final Context context) {
        new l<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.3
            @Override // com.kwad.sdk.core.network.a
            public final /* synthetic */ f createRequest() {
                return Sq();
            }

            private static c Sq() {
                return new c();
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            /* JADX INFO: renamed from: hg, reason: merged with bridge method [inline-methods] */
            public UaidTokenResponse parseData(String str) {
                UaidTokenResponse uaidTokenResponse = new UaidTokenResponse();
                uaidTokenResponse.parseJson(new JSONObject(str));
                if (!TextUtils.isEmpty(uaidTokenResponse.uaid)) {
                    ai.af(ServiceProvider.Ud(), uaidTokenResponse.uaid);
                    ai.e(ServiceProvider.Ud(), System.currentTimeMillis());
                }
                ai.ag(ServiceProvider.Ud(), "");
                com.kwad.sdk.mobileid.c.a(context, uaidTokenResponse);
                return uaidTokenResponse;
            }
        }.request(new o<c, UaidTokenResponse>() { // from class: com.kwad.sdk.mobileid.a.a.4
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(f fVar, int i, String str) {
                C(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(f fVar, BaseResultData baseResultData) {
                Sr();
            }

            private void C(int i, String str) {
                com.kwad.sdk.mobileid.a.Sg();
                com.kwad.sdk.mobileid.c.c(context, i, str);
            }

            private static void Sr() {
                com.kwad.sdk.mobileid.a.Sg();
            }
        });
    }
}
