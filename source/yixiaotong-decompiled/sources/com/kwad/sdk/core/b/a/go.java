package com.kwad.sdk.core.b.a;

import com.kwad.components.core.innerEc.logger.InnerEcError;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class go implements com.kwad.sdk.core.d<InnerEcError> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        a((InnerEcError) bVar, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(com.kwad.sdk.core.b bVar, JSONObject jSONObject) {
        return b((InnerEcError) bVar, jSONObject);
    }

    private static void a(InnerEcError innerEcError, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        innerEcError.errorUrl = jSONObject.optString("errorUrl");
        if (JSONObject.NULL.toString().equals(innerEcError.errorUrl)) {
            innerEcError.errorUrl = "";
        }
        innerEcError.payOrderNo = jSONObject.optString("pay_order_no");
        if (JSONObject.NULL.toString().equals(innerEcError.payOrderNo)) {
            innerEcError.payOrderNo = "";
        }
        innerEcError.payErrorMsg = jSONObject.optString("pay_error_msg");
        if (JSONObject.NULL.toString().equals(innerEcError.payErrorMsg)) {
            innerEcError.payErrorMsg = "";
        }
        innerEcError.payMerchantId = jSONObject.optString("pay_merchant_id");
        if (JSONObject.NULL.toString().equals(innerEcError.payMerchantId)) {
            innerEcError.payMerchantId = "";
        }
        innerEcError.payOriginalResultCode = jSONObject.optInt("pay_original_result_code", new Integer("0").intValue());
        innerEcError.payExtData = jSONObject.optString("pay_ext_data");
        if (JSONObject.NULL.toString().equals(innerEcError.payExtData)) {
            innerEcError.payExtData = "";
        }
    }

    private static JSONObject b(InnerEcError innerEcError, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (innerEcError.errorUrl != null && !innerEcError.errorUrl.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "errorUrl", innerEcError.errorUrl);
        }
        if (innerEcError.payOrderNo != null && !innerEcError.payOrderNo.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_order_no", innerEcError.payOrderNo);
        }
        if (innerEcError.payErrorMsg != null && !innerEcError.payErrorMsg.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_error_msg", innerEcError.payErrorMsg);
        }
        if (innerEcError.payMerchantId != null && !innerEcError.payMerchantId.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_merchant_id", innerEcError.payMerchantId);
        }
        com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_original_result_code", innerEcError.payOriginalResultCode);
        if (innerEcError.payExtData != null && !innerEcError.payExtData.equals("")) {
            com.kwad.sdk.utils.ac.putValue(jSONObject, "pay_ext_data", innerEcError.payExtData);
        }
        return jSONObject;
    }
}
