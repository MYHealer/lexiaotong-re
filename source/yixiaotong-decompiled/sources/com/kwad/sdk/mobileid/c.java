package com.kwad.sdk.mobileid;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.mobileid.model.CMTokenResponse;
import com.kwad.sdk.mobileid.model.UaidTokenResponse;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bf;
import com.kwad.sdk.utils.bi;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class c {
    private static String traceId;

    public static void a(Context context, d dVar) {
        traceId = UUID.randomUUID().toString();
        C(a(context, 1, dVar));
    }

    public static void b(Context context, d dVar) {
        C(a(context, 2, dVar));
    }

    public static void a(Context context, CMTokenResponse cMTokenResponse) {
        UaidInfo uaidInfoA = a(context, 3, new d(true, "uaidTokenCanRequest"));
        uaidInfoA.token = cMTokenResponse.getResultToken();
        uaidInfoA.errorCode = cMTokenResponse.getResultCode();
        uaidInfoA.errorMsg = cMTokenResponse.getResultMsg();
        uaidInfoA.result = !TextUtils.isEmpty(uaidInfoA.token) ? 1 : 0;
        C(uaidInfoA);
    }

    public static void b(Context context, int i, String str) {
        UaidInfo uaidInfoA = a(context, 3, new d(false, "uaidTokenCanRequest"));
        uaidInfoA.token = null;
        uaidInfoA.errorCode = new StringBuilder().append(i).toString();
        uaidInfoA.errorMsg = str;
        uaidInfoA.result = 0;
        C(uaidInfoA);
    }

    public static void c(Context context, d dVar) {
        C(a(context, 4, dVar));
    }

    public static void a(Context context, UaidTokenResponse uaidTokenResponse) {
        UaidInfo uaidInfoA = a(context, 5, new d(true, "uaidTokenCanRequest"));
        uaidInfoA.uaid = uaidTokenResponse.uaid;
        uaidInfoA.errorCode = new StringBuilder().append(uaidTokenResponse.result).toString();
        uaidInfoA.errorMsg = uaidTokenResponse.errorMsg;
        uaidInfoA.result = !TextUtils.isEmpty(uaidInfoA.token) ? 1 : 0;
        C(uaidInfoA);
    }

    public static void c(Context context, int i, String str) {
        UaidInfo uaidInfoA = a(context, 5, new d(false, "uaidTokenCanRequest"));
        uaidInfoA.uaid = null;
        uaidInfoA.errorCode = new StringBuilder().append(i).toString();
        uaidInfoA.errorMsg = str;
        uaidInfoA.result = 0;
        C(uaidInfoA);
    }

    private static UaidInfo a(Context context, int i, d dVar) {
        boolean zUseNetworkStateDisable = be.useNetworkStateDisable();
        boolean zUsePhoneStateDisable = be.usePhoneStateDisable();
        String strDT = bf.dT(context);
        return UaidInfo.newBuilder().ff(i).hd(traceId).hc(dVar.Sm()).he(dVar.Sn()).fg(aq.e(context, strDT, zUseNetworkStateDisable)).fh(aq.dB(context)).cg((strDT == null || TextUtils.isEmpty(strDT.trim())) ? false : true).ce(!zUseNetworkStateDisable).cf(!zUsePhoneStateDisable).So();
    }

    private static void C(final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.Oi().execute(new bi() { // from class: com.kwad.sdk.mobileid.c.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (aVar != null) {
                    com.kwad.sdk.core.d.c.d("UAIDMonitor", "asyncReport json: " + aVar.toJson().toString());
                }
                com.kwad.sdk.commercial.c.y(aVar);
            }
        });
    }
}
