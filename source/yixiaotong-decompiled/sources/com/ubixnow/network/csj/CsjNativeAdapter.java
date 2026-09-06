package com.ubixnow.network.csj;

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
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjNativeAdapter extends UMNCustomNativeAdapter {
    private final String OooO00o = this.customTag + "CsjNativeAdapter";
    public WeakReference<Context> OooO0O0;

    private void OooO00o(UMNNativeParams uMNNativeParams, o00O000 o00o000) {
        CsjNativeExpressAd csjNativeExpressAd = new CsjNativeExpressAd(this.OooO0O0.get(), uMNNativeParams, o00o000.OooO00o.OooO0o0);
        csjNativeExpressAd.loadAd(this.nativeInfo, this.loadListener);
        this.customNativeAd = csjNativeExpressAd;
    }

    private void OooO0O0(UMNNativeParams uMNNativeParams, o00O000 o00o000) {
        CsjNativeAd csjNativeAd = new CsjNativeAd(this.OooO0O0.get(), uMNNativeParams, o00o000.OooO00o.OooO0o0, this.nativeInfo);
        csjNativeAd.loadAd("3", this.nativeInfo, this.loadListener);
        this.customNativeAd = csjNativeAd;
    }

    public void loadAd(o00O000 o00o000) {
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if (baseDevConfig instanceof UMNNativeParams) {
            UMNNativeParams uMNNativeParams = (UMNNativeParams) baseDevConfig;
            if (uMNNativeParams.adStyle == 1) {
                OooO0O0(uMNNativeParams, o00o000);
            } else {
                OooO00o(uMNNativeParams, o00o000);
            }
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void loadCustomAd(Context context, final o00O000 o00o000, Object... objArr) {
        createNativeInfo(o00o000);
        this.OooO0O0 = new WeakReference<>(context);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0) && objArr != null) {
            CsjInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.csj.CsjNativeAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = CsjNativeAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", CsjInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) CsjNativeAdapter.this.nativeInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    CsjNativeAdapter.this.loadAd(o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, CsjInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.nativeInfo));
        }
    }
}
