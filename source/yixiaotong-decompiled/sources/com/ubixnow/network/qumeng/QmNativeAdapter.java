package com.ubixnow.network.qumeng;

import android.content.Context;
import com.ubixnow.adtype.nativead.api.UMNNativeParams;
import com.ubixnow.adtype.nativead.custom.UMNCustomNativeAdapter;
import com.ubixnow.core.common.BaseDevConfig;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00O0OO0;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class QmNativeAdapter extends UMNCustomNativeAdapter {
    private WeakReference<Context> OooO00o;

    private void OooO00o(UMNNativeParams uMNNativeParams, o00O000 o00o000) {
        QmNativeExpressAd qmNativeExpressAd = new QmNativeExpressAd(this.OooO00o.get(), uMNNativeParams, o00o000.OooO00o.OooO0o0, this.nativeInfo);
        this.customNativeAd = qmNativeExpressAd;
        qmNativeExpressAd.loadAd(this.loadListener);
    }

    private void OooO0O0(UMNNativeParams uMNNativeParams, o00O000 o00o000) {
        QmNativeAd qmNativeAd = new QmNativeAd(this.OooO00o.get(), "3", o00o000.OooO00o.OooO0o0, this.nativeInfo);
        this.customNativeAd = qmNativeAd;
        qmNativeAd.loadNativeAd(this.loadListener);
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
        this.OooO00o = new WeakReference<>(context);
        QmInitManager.getInstance().initSDK(context, o00o000, new o00O0OO0() { // from class: com.ubixnow.network.qumeng.QmNativeAdapter.1
            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onError(Throwable th) {
                o00O00o0 o00o00o0 = QmNativeAdapter.this.loadListener;
                if (o00o00o0 != null) {
                    o00o00o0.onNoAdError(QmInitManager.getErrorInfo(th.getMessage()).setInfo((Object) QmNativeAdapter.this.nativeInfo));
                }
            }

            @Override // com.ubixnow.ooooo.o00O0OO0
            public void onSuccess() {
                QmNativeAdapter.this.loadAd(o00o000);
            }
        });
    }
}
