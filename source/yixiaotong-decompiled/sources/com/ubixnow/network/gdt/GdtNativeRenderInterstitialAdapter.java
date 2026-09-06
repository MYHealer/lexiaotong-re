package com.ubixnow.network.gdt;

import android.content.Context;
import android.text.TextUtils;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000oOoO;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class GdtNativeRenderInterstitialAdapter extends o000oOoO {
    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        new GdtNativeAd(context, "10", this.mBaseAdConfig.OooO00o.OooO0o0, this.OooO0o).loadNativeAd(this.OooOO0O);
    }

    @Override // com.ubixnow.ooooo.o000oOoO
    public String getLogoText() {
        return "优量汇广告";
    }

    @Override // com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter
    public void loadInterstitalAd(final Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        if (TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) || TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            callNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, GdtInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        } else {
            GdtInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.gdt.GdtNativeRenderInterstitialAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    GdtNativeRenderInterstitialAdapter.this.callNoAdError(new ErrorInfo("500041", GdtInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) GdtNativeRenderInterstitialAdapter.this.absUbixInfo));
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    GdtNativeRenderInterstitialAdapter.this.loadAd(context);
                }
            });
        }
    }
}
