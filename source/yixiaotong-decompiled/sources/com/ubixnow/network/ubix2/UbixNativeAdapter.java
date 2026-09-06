package com.ubixnow.network.ubix2;

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
public class UbixNativeAdapter extends UMNCustomNativeAdapter {
    private final String OooO00o = this.customTag + getClass().getSimpleName();
    private WeakReference<Context> OooO0O0;
    private o00O000 OooO0OO;

    public void loadAd() {
        BaseDevConfig baseDevConfig = this.mBaseAdConfig.OooO0o0;
        if (baseDevConfig instanceof UMNNativeParams) {
            UMNNativeParams uMNNativeParams = (UMNNativeParams) baseDevConfig;
            if (uMNNativeParams.adStyle == 1) {
                loadNative();
            } else {
                loadExpress(uMNNativeParams);
            }
        }
    }

    @Override // com.ubixnow.ooooo.o00O
    public void loadCustomAd(Context context, o00O000 o00o000, Object... objArr) {
        this.OooO0O0 = new WeakReference<>(context);
        this.OooO0OO = o00o000;
        createNativeInfo(o00o000);
        if (!TextUtils.isEmpty(o00o000.OooO00o.OooO0Oo) && !TextUtils.isEmpty(o00o000.OooO00o.OooO0o0) && objArr != null) {
            Ubix2InitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.ubix2.UbixNativeAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = UbixNativeAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        StringBuilder sb = new StringBuilder();
                        Ubix2InitManager.getInstance();
                        o00o00o0.onNoAdError(new ErrorInfo("500041", sb.append(Ubix2InitManager.getName()).append(oOO00O0.ubix_initError_msg).append(th.getMessage()).toString()).setInfo((Object) UbixNativeAdapter.this.nativeInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    UbixNativeAdapter.this.loadAd();
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            StringBuilder sb = new StringBuilder();
            Ubix2InitManager.getInstance();
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, sb.append(Ubix2InitManager.getName()).append(oOO00O0.ubix_appIdorPlaceIdNull_msg).toString()).setInfo((Object) this.nativeInfo));
        }
    }

    public void loadExpress(UMNNativeParams uMNNativeParams) {
        UbixNativeExpressAd ubixNativeExpressAd = new UbixNativeExpressAd(this.OooO0O0.get(), uMNNativeParams, this.OooO0OO.OooO00o.OooO0o0, this.nativeInfo);
        this.customNativeAd = ubixNativeExpressAd;
        ubixNativeExpressAd.loadAd(this.loadListener);
    }

    public void loadNative() {
        UbixNativeAd ubixNativeAd = new UbixNativeAd(this.OooO0O0.get());
        ubixNativeAd.loadAd(this.nativeInfo, this.adsSlotid, this.loadListener);
        this.customNativeAd = ubixNativeAd;
    }
}
