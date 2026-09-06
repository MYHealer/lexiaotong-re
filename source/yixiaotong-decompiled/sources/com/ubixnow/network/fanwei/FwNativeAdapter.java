package com.ubixnow.network.fanwei;

import android.content.Context;
import android.text.TextUtils;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAdapter;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oOO00O0;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwNativeAdapter extends UMNCustomNativeAdapter {
    private void OooO00o(o00O000 o00o000) {
        FwNativeExpressAd fwNativeExpressAd = new FwNativeExpressAd(this.nativeInfo, o00o000.OooO00o.OooO0o0);
        this.customNativeAd = fwNativeExpressAd;
        fwNativeExpressAd.loadAd(this.nativeInfo, this.loadListener);
    }

    private void OooO0O0(o00O000 o00o000) {
        FwNativeAd fwNativeAd = new FwNativeAd(o00o000.OooO00o.OooO0o0, this.nativeInfo);
        this.customNativeAd = fwNativeAd;
        fwNativeAd.loadAd("3", this.nativeInfo, this.loadListener);
    }

    public void loadAd(o00O000 o00o000) {
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if (baseDevConfig instanceof UMNNativeParams) {
            if (((UMNNativeParams) baseDevConfig).adStyle == 1) {
                OooO0O0(o00o000);
            } else {
                OooO00o(o00o000);
            }
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void loadCustomAd(Context context, final o00O000 o00o000, Object... objArr) {
        createNativeInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0) && objArr != null) {
            FwInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.fanwei.FwNativeAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = FwNativeAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", FwInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) FwNativeAdapter.this.nativeInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    FwNativeAdapter.this.loadAd(o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, FwInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.nativeInfo));
        }
    }
}
