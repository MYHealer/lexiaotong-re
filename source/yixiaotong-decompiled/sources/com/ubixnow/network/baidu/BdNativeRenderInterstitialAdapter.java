package com.ubixnow.network.baidu;

import android.content.Context;
import android.text.TextUtils;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000oOoO;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdNativeRenderInterstitialAdapter extends o000oOoO {
    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        new BdNativeAd(context, getUMNNativeParams(), this.mBaseAdConfig.OooO00o.OooO0o0, this.OooO0o).loadAd("10", this.OooOO0O, this.OooO0o);
    }

    @Override // com.ubixnow.ooooo.o000oOoO
    public String getLogoText() {
        return "百度广告";
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(final Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        if (TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) || TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            callNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, BdInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        } else {
            BdInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.baidu.BdNativeRenderInterstitialAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    BdNativeRenderInterstitialAdapter.this.callNoAdError(new ErrorInfo("500041", BdInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) BdNativeRenderInterstitialAdapter.this.absUbixInfo));
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    BdNativeRenderInterstitialAdapter.this.loadAd(context);
                }
            });
        }
    }
}
