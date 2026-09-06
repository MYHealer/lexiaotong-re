package com.kwad.components.ad.reward;

import com.kwad.components.ad.reward.model.RewardFraudVerifyRespInfo;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class k {
    private static void h(final g gVar) {
        new com.kwad.sdk.core.network.l<com.kwad.components.core.request.m, RewardFraudVerifyRespInfo>() { // from class: com.kwad.components.ad.reward.k.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return J(str);
            }

            private static RewardFraudVerifyRespInfo J(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo = new RewardFraudVerifyRespInfo();
                rewardFraudVerifyRespInfo.parseJson(jSONObject);
                return rewardFraudVerifyRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: hG, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.m createRequest() {
                return new com.kwad.components.core.request.m(gVar.mAdTemplate);
            }
        }.request(i(gVar));
    }

    private static com.kwad.sdk.core.network.o<com.kwad.components.core.request.m, RewardFraudVerifyRespInfo> i(final g gVar) {
        return new com.kwad.sdk.core.network.o<com.kwad.components.core.request.m, RewardFraudVerifyRespInfo>() { // from class: com.kwad.components.ad.reward.k.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(com.kwad.sdk.core.network.f fVar) {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((RewardFraudVerifyRespInfo) baseResultData);
            }

            private void a(final RewardFraudVerifyRespInfo rewardFraudVerifyRespInfo) {
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.k.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        gVar.sW = rewardFraudVerifyRespInfo.isFraud() ? 3 : 2;
                        gVar.sX = rewardFraudVerifyRespInfo.getCode();
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.request.m mVar, int i, String str) {
                super.onError(mVar, i, str);
                com.kwad.sdk.core.d.c.d("RewardFraudVerifyUtil", "error: " + i);
            }
        };
    }

    public static boolean a(g gVar, long j, long j2, long j3) {
        long jDq = com.kwad.sdk.core.response.helper.a.dq(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate));
        if (j <= ((j2 - 800) - j3) - jDq || jDq <= 0 || !com.kwad.sdk.core.response.helper.a.m984do(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate))) {
            return false;
        }
        h(gVar);
        return true;
    }
}
