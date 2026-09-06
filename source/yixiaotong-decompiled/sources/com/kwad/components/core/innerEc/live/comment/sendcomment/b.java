package com.kwad.components.core.innerEc.live.comment.sendcomment;

import com.kwad.components.core.innerEc.f;
import com.kwad.components.core.innerEc.live.i.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {
    private final AdTemplate TQ;

    public interface a {
        void a(LiveSendCommentResponse liveSendCommentResponse, com.kwad.components.core.innerEc.live.base.b bVar);
    }

    public b(AdTemplate adTemplate) {
        this.TQ = adTemplate;
    }

    public final void a(String str, final a aVar) {
        final com.kwad.components.core.innerEc.live.base.b bVarAE = com.kwad.components.core.innerEc.live.base.b.rv().aD(e.aM(this.TQ)).aC(e.aN(this.TQ)).aF(str).aE(e.getKwaiUserId());
        new l<com.kwad.components.core.innerEc.live.comment.sendcomment.a, LiveSendCommentResponse>() { // from class: com.kwad.components.core.innerEc.live.comment.sendcomment.b.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str2) {
                return aI(str2);
            }

            private static LiveSendCommentResponse aI(String str2) {
                JSONObject jSONObject = new JSONObject(str2);
                LiveSendCommentResponse liveSendCommentResponse = new LiveSendCommentResponse();
                liveSendCommentResponse.parseJson(jSONObject);
                return liveSendCommentResponse;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: rD, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.innerEc.live.comment.sendcomment.a createRequest() {
                return new com.kwad.components.core.innerEc.live.comment.sendcomment.a(bVarAE, f.rj());
            }
        }.request(new o<com.kwad.components.core.innerEc.live.comment.sendcomment.a, LiveSendCommentResponse>() { // from class: com.kwad.components.core.innerEc.live.comment.sendcomment.b.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(com.kwad.components.core.innerEc.live.comment.sendcomment.a aVar2, final LiveSendCommentResponse liveSendCommentResponse) {
                super.onSuccess(aVar2, liveSendCommentResponse);
                c.d("LiveSendCommentService", "sendComment success");
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.comment.sendcomment.b.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        aVar.a(liveSendCommentResponse, bVarAE);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(com.kwad.components.core.innerEc.live.comment.sendcomment.a aVar2, final int i, final String str2) {
                super.onError(aVar2, i, str2);
                c.d("LiveSendCommentService", "sendComment error: " + str2);
                by.postOnUiThread(new bi() { // from class: com.kwad.components.core.innerEc.live.comment.sendcomment.b.2.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                    }
                });
            }
        });
    }
}
