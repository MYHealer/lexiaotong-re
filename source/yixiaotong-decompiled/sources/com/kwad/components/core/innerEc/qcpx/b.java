package com.kwad.components.core.innerEc.qcpx;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.components.core.innerEc.f;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.utils.ae;
import com.kwad.sdk.utils.by;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public final class b {
    public static void h(final Context context, final AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        final Map<String, String> mapRj = f.rj();
        if (mapRj == null) {
            c.d("ReceiveQcpxRequestHelper", "requestReceiveQcpx: map is null, not login");
            return;
        }
        if (!com.kwad.sdk.core.response.helper.a.dH(e.eO(adTemplate))) {
            c.d("ReceiveQcpxRequestHelper", "requestReceiveQcpx: there is no qcpx");
            return;
        }
        final ReceiveQcpxBody receiveQcpxBodyNewInstance = ReceiveQcpxBody.newInstance(adTemplate);
        final String str = receiveQcpxBodyNewInstance.receiveToast;
        final String str2 = receiveQcpxBodyNewInstance.receiveFailToast;
        new l<a, ReceiveQcpxResultData>() { // from class: com.kwad.components.core.innerEc.qcpx.b.1
            @Override // com.kwad.sdk.core.network.l
            public final /* synthetic */ BaseResultData parseData(String str3) {
                return aR(str3);
            }

            private static ReceiveQcpxResultData aR(String str3) {
                ReceiveQcpxResultData receiveQcpxResultData = new ReceiveQcpxResultData();
                receiveQcpxResultData.parseJson(new JSONObject(str3));
                return receiveQcpxResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            /* JADX INFO: renamed from: tl, reason: merged with bridge method [inline-methods] */
            public a createRequest() {
                return new a(mapRj, receiveQcpxBodyNewInstance);
            }
        }.request(new g<a, ReceiveQcpxResultData>() { // from class: com.kwad.components.core.innerEc.qcpx.b.2
            @Override // com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(com.kwad.sdk.core.network.f fVar, int i, String str3) {
                n(i, str3);
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* synthetic */ void onStartRequest(com.kwad.sdk.core.network.f fVar) {
                a((a) fVar);
            }

            @Override // com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.f fVar, BaseResultData baseResultData) {
                a((ReceiveQcpxResultData) baseResultData);
            }

            private static void a(a aVar) {
                c.w("ReceiveQcpxRequestHelper", "request onStartRequest: " + aVar.getUrl());
            }

            private void a(ReceiveQcpxResultData receiveQcpxResultData) {
                c.w("ReceiveQcpxRequestHelper", "request onSuccess: " + receiveQcpxResultData.errorMsg);
                b.a(adTemplate, context, "success", str);
            }

            private void n(int i, String str3) {
                c.w("ReceiveQcpxRequestHelper", "request onError: errorCode: " + i + ", errorMsg: " + str3);
                b.a(adTemplate, context, i, str3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, final Context context, final int i, final String str, final String str2) {
        int i2 = 4;
        if (!l.HTTP_CODE_ERROR_MSG.equals(str) && i != com.kwad.sdk.core.network.e.aTc.errorCode) {
            int i3 = com.kwad.sdk.core.network.e.aTd.errorCode;
            i2 = 3;
        }
        com.kwad.sdk.core.adlog.c.u(adTemplate, i2);
        by.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.qcpx.b.3
            @Override // java.lang.Runnable
            public final void run() {
                String str3 = str2;
                if (!TextUtils.isEmpty(str)) {
                    str3 = str;
                }
                c.w("ReceiveQcpxRequestHelper", "notifyError errorCode: " + i + ", errorMsg: " + str + ", defaultToast: " + str2 + ", targetToast: " + str3);
                ae.c(context, str3, 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdTemplate adTemplate, final Context context, final String str, final String str2) {
        com.kwad.sdk.core.adlog.c.cA(adTemplate);
        by.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.innerEc.qcpx.b.4
            @Override // java.lang.Runnable
            public final void run() {
                c.w("ReceiveQcpxRequestHelper", "notifySuccess: " + str + ", toast: " + str2);
                ae.c(context, str2, 0);
            }
        });
    }
}
