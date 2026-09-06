package com.hihonor.adsdk.base.h;

import android.content.Context;
import com.hihonor.adsdk.base.callback.i;
import com.hihonor.adsdk.base.net.m;
import com.hihonor.adsdk.base.net.request.BaseRequest;
import com.hihonor.adsdk.base.net.resp.InitResp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public final class f implements e {
    private static final String hnadsa = "InitRepository";

    private static final class a {
        public static final f hnadsa = new f();

        private a() {
        }
    }

    public static f hnadsa() {
        return a.hnadsa;
    }

    @Override // com.hihonor.adsdk.base.h.e
    public void hnadsa(Context context, com.hihonor.adsdk.base.callback.e<InitResp> eVar) {
        com.hihonor.adsdk.common.b.b.hnadsc(hnadsa, "initAd#call initialize ad", new Object[0]);
        BaseRequest baseRequest = new BaseRequest();
        m.hnadsb().hnadsc().hnadsa(com.hihonor.adsdk.base.net.request.a.hnadsa(context, com.hihonor.adsdk.base.c.h2.hnadsa, baseRequest.getJsonCache()).hnadsb(), com.hihonor.adsdk.base.net.request.a.hnadsa(context, baseRequest)).hnadsa(new i(eVar));
    }
}
