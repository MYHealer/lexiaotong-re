package com.hihonor.adsdk.base.callback;

import com.hihonor.adsdk.base.ErrorCode;
import com.hihonor.adsdk.base.callback.filter.ResFilterBean;
import com.hihonor.adsdk.base.net.ApiResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i<RESP> implements com.hihonor.adsdk.base.net.f<RESP> {
    private static final String hnadsc = "HttpCallbackProxy";
    protected e<RESP> hnadsa;
    protected boolean hnadsb = false;

    public i(e<RESP> eVar) {
        this.hnadsa = eVar;
    }

    protected void hnadsa(String str, RESP resp, String str2) {
    }

    protected void hnadsc(RESP resp) {
    }

    protected void hnadsd(RESP resp) {
    }

    public void hnadsa(ApiResult<RESP> apiResult, boolean z) {
        this.hnadsb = z;
        hnadsa((ApiResult) apiResult);
    }

    protected void hnadsb(RESP resp) {
        if (this.hnadsb) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "Resp isSuccess, but timeout", new Object[0]);
            hnadsd(resp);
            hnadsc(resp);
            return;
        }
        ResFilterBean resFilterBeanHnadsa = hnadsa(resp);
        if (resFilterBeanHnadsa == null) {
            this.hnadsa.hnadsa(String.valueOf(ErrorCode.AD_EXCEPTION_FILTERED), new Throwable("ResFilterBean is null by adDataFiltered end. Normally does not appearAD_FILTERING_LIST list is null"));
            hnadsc(resp);
            return;
        }
        if (resFilterBeanHnadsa.isNeedFilter() && resFilterBeanHnadsa.isEmptyResult()) {
            this.hnadsa.hnadsa(String.valueOf(ErrorCode.HI_AD_EMPTY_BY_FILTER), new Throwable("AD filter by SDK, ad list is empty.AD_FILTERING_LIST" + com.hihonor.adsdk.base.j.g.hnadsa(resFilterBeanHnadsa.getListResultsData())));
        } else {
            this.hnadsa.hnadsa(resp);
        }
        hnadsc(resp);
    }

    public void hnadsa(String str, Throwable th, boolean z) {
        this.hnadsb = z;
        hnadsa(str, th);
    }

    @Override // com.hihonor.adsdk.base.net.f
    public void hnadsa(ApiResult<RESP> apiResult) {
        RESP resp;
        if (this.hnadsa == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "apiCallback is null", new Object[0]);
            return;
        }
        if (apiResult == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "Resp is null", new Object[0]);
            hnadsa(String.valueOf(ErrorCode.RESPONSE_FAIL), new Throwable(com.hihonor.adsdk.base.net.d.a.hnadsd), (Object) null);
        } else if (apiResult.hnadsa() && (resp = apiResult.data) != null) {
            hnadsb(resp);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(hnadsc, "Resp isSuccess is false", new Object[0]);
            hnadsa(apiResult.errorCode, new Throwable(apiResult.errorMessage), apiResult.data);
        }
    }

    @Override // com.hihonor.adsdk.base.net.f
    public void hnadsa(String str, Throwable th) {
        hnadsa(str, th, (Object) null);
    }

    protected void hnadsa(String str, Throwable th, RESP resp) {
        hnadsa(str, resp, th.getMessage());
        if (this.hnadsb) {
            return;
        }
        this.hnadsa.hnadsa(str, th);
    }

    protected ResFilterBean hnadsa(RESP resp) {
        return new ResFilterBean();
    }
}
