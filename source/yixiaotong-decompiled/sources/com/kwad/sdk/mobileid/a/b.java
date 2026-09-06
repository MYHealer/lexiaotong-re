package com.kwad.sdk.mobileid.a;

import client.android.yixiaotong.util.TimeUtils;
import com.huawei.openalliance.ad.constant.x;
import com.icbc.paysdk.constants.Constants;
import com.kwad.sdk.core.network.d;
import com.kwad.sdk.i;
import com.kwad.sdk.utils.an;
import com.masget.base.AppConfig;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class b extends d {
    private static String biY;

    private static String Su() {
        return "300012755841";
    }

    private static String Sv() {
        return "CB607A51A7A639E532D288AB8C963DB6";
    }

    @Override // com.kwad.sdk.core.network.d, com.kwad.sdk.core.network.b
    public final void buildBaseBody() {
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final String getUrl() {
        return i.Fe();
    }

    @Override // com.kwad.sdk.core.network.b, com.kwad.sdk.core.network.f
    public final JSONObject getBody() {
        try {
            biY = Ss();
            String strSt = St();
            String strAo = ao(strSt, biY);
            putBody(com.alipay.sdk.tid.b.f, strSt);
            putBody("sign", strAo);
            putBody("traceId", biY);
            putBody("appId", Su());
            putBody(Constants.InterfaceVersion, AppConfig.OPEN_API_VERSION);
        } catch (Throwable th) {
            reportSdkCaughtException(th);
        }
        return this.mBodyParams;
    }

    private static String Ss() {
        return UUID.randomUUID().toString().replace(x.A, "");
    }

    private static String ao(String str, String str2) {
        return an.md5(Su() + str + str2 + AppConfig.OPEN_API_VERSION + Sv());
    }

    private static String St() {
        return new SimpleDateFormat(TimeUtils.FORMATDATETIME1).format(new Date());
    }
}
