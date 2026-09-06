package com.hihonor.adsdk.base.net;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.common.f.z;
import retrofit2.Call;
import retrofit2.Response;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a<RESP> implements g<RESP> {
    private static final String hnadsb = "ApiCall";
    protected final Call<ApiResult<RESP>> hnadsa;

    a(Call<ApiResult<RESP>> call) {
        this.hnadsa = call;
    }

    @Override // com.hihonor.adsdk.base.net.g
    public ApiResult<RESP> hnadsa() {
        ApiResult<RESP> apiResult = new ApiResult<>();
        try {
            ApiResult<RESP> apiResultBody = this.hnadsa.execute().body();
            if (apiResultBody != null) {
                com.hihonor.adsdk.common.b.b.hnadsc(hnadsb, "origin ApiResult#execute#errorMessage = " + apiResultBody.errorMessage + ", code=" + apiResultBody.errorCode, new Object[0]);
                return apiResultBody;
            }
            apiResult.errorCode = "10002";
            apiResult.errorMessage = d.a.hnadsd;
            return apiResult;
        } catch (Exception e) {
            apiResult.errorMessage = "Exception:" + e.getMessage();
            apiResult.errorCode = "10001";
            com.hihonor.adsdk.common.b.b.hnadsb(hnadsb, "execute, Error in ApiResult execution, Exception: " + e.getMessage(), new Object[0]);
            return apiResult;
        }
    }

    @Override // com.hihonor.adsdk.base.net.g
    public void hnadsb() {
        this.hnadsa.cancel();
    }

    @Override // com.hihonor.adsdk.base.net.g
    public boolean hnadsc() {
        Call<ApiResult<RESP>> call = this.hnadsa;
        if (call != null) {
            return call.isExecuted();
        }
        return false;
    }

    @Override // com.hihonor.adsdk.base.net.g
    public boolean hnadsd() {
        Call<ApiResult<RESP>> call = this.hnadsa;
        if (call != null) {
            return call.isCanceled();
        }
        return false;
    }

    @Override // com.hihonor.adsdk.base.net.g
    public void hnadsa(f<RESP> fVar) {
        this.hnadsa.enqueue(new C0445a(fVar));
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.base.net.a$a, reason: collision with other inner class name */
    class C0445a extends c<ApiResult<RESP>> {
        final /* synthetic */ f hnadsa;

        C0445a(f fVar) {
            this.hnadsa = fVar;
        }

        @Override // com.hihonor.adsdk.base.net.c
        void hnadsa(Call<ApiResult<RESP>> call, Response<ApiResult<RESP>> response) {
            String strHeader;
            ApiResult<RESP> apiResultBody = response.body();
            com.hihonor.adsdk.common.b.b.hnadsc(a.hnadsb, "origin ApiResult#onResult#message = " + response.message() + ", code=" + response.code(), new Object[0]);
            if (call != null && (strHeader = call.request().header(com.hihonor.adsdk.base.c.m0.hnadsg)) != null) {
                com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(strHeader, 3);
                com.hihonor.adsdk.base.net.o.b.hnadsa().hnadsa(strHeader, 14);
            }
            f fVar = this.hnadsa;
            if (fVar == null) {
                return;
            }
            if (apiResultBody != null) {
                fVar.hnadsa(apiResultBody);
            } else {
                com.hihonor.adsdk.common.b.b.hnadsc(a.hnadsb, "Resp is null", new Object[0]);
                this.hnadsa.hnadsa(String.valueOf(ErrorCode.RESPONSE_FAIL), new Throwable(z.hnadsa(response.code(), d.a.hnadsd + response.message())));
            }
        }

        @Override // com.hihonor.adsdk.base.net.c
        void hnadsa(Call<ApiResult<RESP>> call, Throwable th) {
            f fVar = this.hnadsa;
            if (fVar != null) {
                fVar.hnadsa(String.valueOf(ErrorCode.c.hnadsd), th);
            }
        }
    }
}
