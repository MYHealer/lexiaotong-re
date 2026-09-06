package com.ubix.ssp.ad.d;

import android.view.View;
import com.ubix.ssp.open.ParamsReview;
import com.ubix.ssp.open.UBiXAdLossInfo;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.express.NativeExpressAd;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressInteractionListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressVideoListener;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i implements NativeExpressAd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.ubix.ssp.ad.i.d f8616a;
    private long b;
    private int c;
    private NativeAd d;
    private boolean e;
    private long f;

    public void a(int i) {
        this.c = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(com.ubix.ssp.ad.i.d dVar) {
        this.f8616a = dVar;
    }

    public void a(NativeAd nativeAd) {
        this.d = nativeAd;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b(long j) {
        this.f = j;
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public void destroy() {
        com.ubix.ssp.ad.i.d dVar = this.f8616a;
        if (dVar != null) {
            dVar.a(this.d);
        }
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    @Deprecated
    public int getAdType() {
        return this.c;
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public int getCreativeType() {
        return this.c;
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public View getNativeExpressView() {
        return this.f8616a.b(this.d);
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public ParamsReview getParamsReview() {
        return this.f8616a.c(this.d);
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public long getPrice() {
        return this.b;
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public long getVideoDuration() {
        return this.f;
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public boolean isValid() {
        com.ubix.ssp.ad.i.d dVar = this.f8616a;
        if (dVar != null) {
            return dVar.d(this.d);
        }
        return false;
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public boolean isVideoAd() {
        return this.e;
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public void lossNotice(UBiXAdLossInfo uBiXAdLossInfo) {
        com.ubix.ssp.ad.i.d dVar;
        if (uBiXAdLossInfo == null || (dVar = this.f8616a) == null) {
            return;
        }
        dVar.a(this.d, uBiXAdLossInfo.getInfo());
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public void renderExpressNativeAd(UBiXNativeExpressInteractionListener uBiXNativeExpressInteractionListener) {
        this.f8616a.a(this.d, uBiXNativeExpressInteractionListener);
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public void setNativeExpressVideoListener(UBiXNativeExpressVideoListener uBiXNativeExpressVideoListener) {
        this.f8616a.a(this.d, uBiXNativeExpressVideoListener);
    }

    @Override // com.ubix.ssp.open.nativee.express.NativeExpressAd
    public void winNotice(long j) {
        com.ubix.ssp.ad.i.d dVar = this.f8616a;
        if (dVar != null) {
            dVar.a(this.d, j);
        }
    }
}
