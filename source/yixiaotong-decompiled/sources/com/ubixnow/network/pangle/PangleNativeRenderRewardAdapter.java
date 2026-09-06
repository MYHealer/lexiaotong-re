package com.ubixnow.network.pangle;

import android.content.Context;
import android.text.TextUtils;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o0000Ooo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.utils.BaseUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class PangleNativeRenderRewardAdapter extends o0000Ooo {
    /* JADX INFO: Access modifiers changed from: private */
    public void loadAd(Context context) {
        new PangleNativeAd(context, getUMNNativeParams(), this.mBaseAdConfig.OooO00o.OooO0o0, this.OooO0o).loadAd("12", this.OooO0o, this.OooOOo);
    }

    @Override // com.ubixnow.ooooo.o0000Ooo
    public String getLogoText() {
        return "穿山甲广告";
    }

    @Override // com.ubixnow.adtype.reward.custom.UMNCustomRewardAdapter
    public void loadRewardAd(final Context context, o00O000 o00o000) {
        createADInfo(o00o000);
        if (TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) || TextUtils.isEmpty(o00o000.OooO00o.OooO0o0)) {
            callNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, PangleInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.absUbixInfo));
        } else {
            PangleInitManager.getInstance().initSDK(BaseUtils.getContext(), o00o000, new o00O0OO0() { // from class: com.ubixnow.network.pangle.PangleNativeRenderRewardAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    PangleNativeRenderRewardAdapter.this.callNoAdError(new ErrorInfo("500041", PangleInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) PangleNativeRenderRewardAdapter.this.absUbixInfo));
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    PangleNativeRenderRewardAdapter.this.loadAd(context);
                }
            });
        }
    }
}
