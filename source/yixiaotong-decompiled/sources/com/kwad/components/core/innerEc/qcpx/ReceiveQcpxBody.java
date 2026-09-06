package com.kwad.components.core.innerEc.qcpx;

import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdCouponReceiveParam;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ReceiveQcpxBody extends AdCouponReceiveParam {
    public long creativeId;
    public String flowTag = "universeClosure";
    public long llsid;

    public static ReceiveQcpxBody newInstance(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        AdInfo adInfoEO = e.eO(adTemplate);
        if (adInfoEO.adCouponReceiveParam == null) {
            return null;
        }
        AdCouponReceiveParam adCouponReceiveParam = adInfoEO.adCouponReceiveParam;
        ReceiveQcpxBody receiveQcpxBody = new ReceiveQcpxBody();
        receiveQcpxBody.receiveToast = adCouponReceiveParam.receiveToast;
        receiveQcpxBody.receiveFailToast = adCouponReceiveParam.receiveFailToast;
        receiveQcpxBody.sign = adCouponReceiveParam.sign;
        receiveQcpxBody.ext = adCouponReceiveParam.ext;
        if (receiveQcpxBody.ext == null) {
            receiveQcpxBody.ext = "";
        }
        receiveQcpxBody.flowType = adCouponReceiveParam.flowType;
        receiveQcpxBody.llsid = e.eL(adTemplate);
        receiveQcpxBody.creativeId = e.eY(adTemplate);
        return receiveQcpxBody;
    }
}
