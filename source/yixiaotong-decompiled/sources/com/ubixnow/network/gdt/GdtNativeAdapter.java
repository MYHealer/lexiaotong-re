package com.ubixnow.network.gdt;

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
public class GdtNativeAdapter extends UMNCustomNativeAdapter {
    private final String OooO00o = this.customTag + GdtInitManager.getInstance().getName();
    public WeakReference<Context> OooO0O0;

    private void OooO00o(UMNNativeParams uMNNativeParams, o00O000 o00o000) {
        GdtNativeExpressAd gdtNativeExpressAd = new GdtNativeExpressAd(this.OooO0O0.get(), uMNNativeParams, o00o000.OooO00o.OooO0o0, this.nativeInfo);
        this.customNativeAd = gdtNativeExpressAd;
        gdtNativeExpressAd.loadAd(this.loadListener);
    }

    private void OooO0O0(UMNNativeParams uMNNativeParams, o00O000 o00o000) {
        GdtNativeAd gdtNativeAd = new GdtNativeAd(this.OooO0O0.get(), "3", o00o000.OooO00o.OooO0o0, this.nativeInfo);
        this.customNativeAd = gdtNativeAd;
        gdtNativeAd.loadNativeAd(this.loadListener);
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
            GdtInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.gdt.GdtNativeAdapter.1
                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onError(Throwable th) {
                    o00O00o0 o00o00o0 = GdtNativeAdapter.this.loadListener;
                    if (o00o00o0 != null) {
                        o00o00o0.onNoAdError(new ErrorInfo("500041", GdtInitManager.getInstance().getName() + oOO00O0.ubix_initError_msg + th.getMessage()).setInfo((Object) GdtNativeAdapter.this.nativeInfo));
                    }
                }

                @Override // com.ubixnow.ooooo.o00O0OO0
                public void onSuccess() {
                    GdtNativeAdapter.this.loadAd(o00o000);
                }
            });
            return;
        }
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_appIdorPlaceIdNull, GdtInitManager.getInstance().getName() + oOO00O0.ubix_appIdorPlaceIdNull_msg).setInfo((Object) this.nativeInfo));
        }
    }
}
