package com.kwad.sdk.crash.report.upload;

import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.crash.utils.g;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.y;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class d {
    public static void a(final File file, boolean z, final CountDownLatch countDownLatch) {
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "upload()" + Thread.currentThread());
        final f fVar = new f();
        fVar.bgh = bf.getDeviceId();
        HashMap map = new HashMap();
        map.put("mLogUUID", g.gI(file.getName()));
        fVar.bgj = new JSONObject(map).toString();
        fVar.bgk = y.getExtension(file.getName());
        fVar.bgm = file;
        final boolean z2 = true;
        new l<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.1
            @Override // com.kwad.sdk.core.network.l
            public final boolean isPostByJson() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str) {
                return gH(str);
            }

            private static GetUploadTokenResult gH(String str) {
                JSONObject jSONObject = new JSONObject(str);
                GetUploadTokenResult getUploadTokenResult = new GetUploadTokenResult();
                getUploadTokenResult.parseJson(jSONObject);
                return getUploadTokenResult;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: QL, reason: merged with bridge method [inline-methods] */
            public c createRequest() {
                return new c(bf.getDeviceId(), fVar.bgg, "zip");
            }
        }.request(new o<c, GetUploadTokenResult>() { // from class: com.kwad.sdk.crash.report.upload.d.2
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar2, int i, String str) {
                a((c) fVar2, i, str);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(c cVar, GetUploadTokenResult getUploadTokenResult) throws Throwable {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onSuccess url=" + cVar.getUrl() + " ---{" + getUploadTokenResult.uploadToken);
                if (getUploadTokenResult.isResultOk()) {
                    fVar.bgl = getUploadTokenResult.uploadToken;
                    b.a(file, fVar, new a() { // from class: com.kwad.sdk.crash.report.upload.d.2.1
                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void QJ() {
                            if (countDownLatch != null) {
                                countDownLatch.countDown();
                            }
                        }

                        @Override // com.kwad.sdk.crash.report.upload.a
                        public final void QK() {
                            com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile onSuccess " + Thread.currentThread() + " delete file:" + file.getPath());
                            if (countDownLatch != null) {
                                countDownLatch.countDown();
                            }
                            if (z2) {
                                y.delete(file.getPath());
                            }
                        }
                    });
                }
            }

            private static void a(c cVar, int i, String str) {
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "onError errorCode=" + i + "errorMsg=" + str + "url=" + cVar.getUrl());
            }
        });
    }
}
