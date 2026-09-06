package com.hihonor.adsdk.base.g.k.e;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.bean.c;
import com.hihonor.adsdk.base.dp.entity.AdTrack;
import com.hihonor.adsdk.base.g.d;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends d {

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.g.k.e.a$a, reason: collision with other inner class name */
    class C0439a implements Callback<ResponseBody> {
        final /* synthetic */ AdTrack hnadsa;
        final /* synthetic */ c hnadsb;

        C0439a(AdTrack adTrack, c cVar) {
            this.hnadsa = adTrack;
            this.hnadsb = cVar;
        }

        @Override // retrofit2.Callback
        public void onFailure(Call<ResponseBody> call, Throwable th) {
            a.this.hnadsa(this.hnadsa, String.valueOf(ErrorCode.RESPONSE_FAIL), th.getMessage(), this.hnadsb);
        }

        @Override // retrofit2.Callback
        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
            a.this.hnadsa(this.hnadsa, response.isSuccessful(), String.valueOf(response.code()), response.message(), (c<AdTrack>) this.hnadsb);
        }
    }

    @Override // com.hihonor.adsdk.base.g.d
    protected String hnadsa() {
        return "AdTrackingReport";
    }

    @Override // com.hihonor.adsdk.base.g.d
    protected void hnadsa(AdTrack adTrack, com.hihonor.adsdk.base.api.a aVar, c<AdTrack> cVar) {
        try {
            aVar.hnadsa(adTrack.getTrackUrl()).enqueue(new C0439a(adTrack, cVar));
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsa(), "reportTrackerUrl, start report track url error " + e.getMessage(), new Object[0]);
            hnadsa(adTrack, ErrorCode.d.hnadsc, ErrorCode.d.hnadsd + e.getMessage());
            hnadsa(adTrack, cVar);
        }
    }
}
