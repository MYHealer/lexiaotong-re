package com.bytedance.msdk.adapter.baidu;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public abstract class BaiduBaseLoader extends MediationAdLoaderBaseFunction {
    public Object getMagicStickerParams() {
        Map<String, Object> extraObject;
        if (this.mSlotValueSet == null || (extraObject = this.mSlotValueSet.getExtraObject()) == null) {
            return null;
        }
        return extraObject.get("key_baidu_native_magic_sticker_params");
    }

    public Object getNativeCouponParams() {
        Map<String, Object> extraObject;
        if (this.mSlotValueSet == null || (extraObject = this.mSlotValueSet.getExtraObject()) == null) {
            return null;
        }
        return extraObject.get("key_baidu_native_coupon_params");
    }

    public Object getNativeECommerceParams() {
        Map<String, Object> extraObject;
        if (this.mSlotValueSet == null || (extraObject = this.mSlotValueSet.getExtraObject()) == null) {
            return null;
        }
        return extraObject.get("key_baidu_native_eCommerce_params");
    }

    public Object getNativeFlipPageParams() {
        Map<String, Object> extraObject;
        if (this.mSlotValueSet == null || (extraObject = this.mSlotValueSet.getExtraObject()) == null) {
            return null;
        }
        return extraObject.get("key_baidu_native_flippage_params");
    }

    public Object getSlotExtraObject(String str) {
        Map<String, Object> extraObject;
        if (TextUtils.isEmpty(str) || this.mSlotValueSet == null || (extraObject = this.mSlotValueSet.getExtraObject()) == null) {
            return null;
        }
        return extraObject.get(str);
    }

    public void setBiddingResult(String str, boolean z, RequestParameters requestParameters) {
        String str2;
        MediationApiLog.i("-------baidu_isClientBidding:" + z + " requestParameters:" + requestParameters);
        if (z && requestParameters != null) {
            MediationApiLog.i("-------baidu_mSlotValueSet:" + z + " isBidNotify:" + this.mSlotValueSet.isBidNotify());
            if (this.mSlotValueSet != null && this.mSlotValueSet.isBidNotify()) {
                Map<String, Object> extraObject = this.mSlotValueSet.getExtraObject();
                MediationApiLog.i("-------baidu_ extraObject:" + extraObject);
                if (extraObject == null || extraObject.size() == 0) {
                    return;
                }
                MediationApiLog.i("-------baidu_ extraObject.toString:" + extraObject.toString());
                try {
                    String str3 = (String) extraObject.get(MediationConstant.BIDDING_WIN_ADN);
                    if (TextUtils.isEmpty(str3)) {
                        MediationApiLog.i("-------baidu_ no adn win");
                        return;
                    }
                    double dDoubleValue = ((Double) extraObject.get(MediationConstant.BIDDING_WIN_PRICE)).doubleValue();
                    boolean zBooleanValue = ((Boolean) extraObject.get(MediationConstant.BIDDING_IS_OPEN_ECPM)).booleanValue();
                    MediationApiLog.i("-------baidu_ winAdn:" + str3 + " winPrice:" + dDoubleValue + " isOpenEcpm = " + zBooleanValue);
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    Map<String, String> ext = requestParameters.getExt();
                    MediationApiLog.i("-------baidu_ customExt:" + ext);
                    if (ext == null) {
                        return;
                    }
                    MediationApiLog.i("-------baidu_ customExt.toString:" + ext.toString());
                    if (zBooleanValue) {
                        MediationApiLog.i("----------baidu_RequestParameters : 价格回传2.0");
                        ext.put("A", "5");
                        ext.put("B", "" + ((int) dDoubleValue));
                        Map map = (Map) extraObject.get(MediationConstant.BIDDING_REQUEST_ID_MAP);
                        if (map != null) {
                            String str4 = (String) map.get(str);
                            if (!TextUtils.isEmpty(str4)) {
                                ext.put("K", str4);
                            }
                        }
                    } else {
                        MediationApiLog.i("----------baidu_RequestParameters : 价格回传1.0");
                        if ("baidu".equals(str3)) {
                            ext.put("A", "2");
                            str2 = "" + ((int) dDoubleValue);
                        } else {
                            ext.put("A", "5");
                            str2 = "0";
                        }
                        ext.put("B", str2);
                    }
                    MediationApiLog.i("----------baidu_RequestParameters :" + requestParameters.getExt().toString());
                } catch (Throwable th) {
                    MediationApiLog.i("---------baidu_ e:" + th.toString());
                }
            }
        }
    }
}
