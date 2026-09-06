package com.hihonor.adsdk.base.g.k.e;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.bean.c;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.base.g.d;
import com.hihonor.adsdk.base.net.ApiResult;
import com.hihonor.adsdk.base.net.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends d {

    class a implements f<String> {
        final /* synthetic */ AdTrack hnadsa;
        final /* synthetic */ c hnadsb;

        a(AdTrack adTrack, c cVar) {
            this.hnadsa = adTrack;
            this.hnadsb = cVar;
        }

        @Override // com.hihonor.adsdk.base.net.f
        public void hnadsa(ApiResult<String> apiResult) {
            b.this.hnadsa(this.hnadsa, apiResult.hnadsa(), apiResult.errorCode, apiResult.errorMessage, (c<AdTrack>) this.hnadsb);
        }

        @Override // com.hihonor.adsdk.base.net.f
        public void hnadsa(String str, Throwable th) {
            b.this.hnadsa(this.hnadsa, str, th.getMessage(), this.hnadsb);
        }
    }

    @Override // com.hihonor.adsdk.base.g.d
    protected String hnadsa() {
        return "AdWorkFlowReport";
    }

    @Override // com.hihonor.adsdk.base.g.d
    protected void hnadsa(AdTrack adTrack, com.hihonor.adsdk.base.api.a aVar, c<AdTrack> cVar) {
        try {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsa(), "reportByWorkFlow#call reportByWorkFlow ad", new Object[0]);
            String body = adTrack.getBody();
            aVar.hnadsb(com.hihonor.adsdk.base.net.request.a.hnadsa(HnAds.get().getContext(), com.hihonor.adsdk.base.c.h2.hnadsd, body).hnadsb(), com.hihonor.adsdk.base.net.request.a.hnadsa(body)).hnadsa(new a(adTrack, cVar));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), "reportTrackerUrl#start report track url error " + e.getMessage(), new Object[0]);
            hnadsa(adTrack, ErrorCode.d.hnadsc, ErrorCode.d.hnadsd + e.getMessage());
            hnadsa(adTrack, cVar);
        }
    }
}
