package com.ubix.ssp.open.manager;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.constant.h;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.AdSize;
import com.ubix.ssp.open.nativee.express.NativeExpressAd;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressAdListener;
import com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d implements UBiXNativeExpressManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9062a = "d";
    private com.ubix.ssp.ad.i.d b;

    class a implements com.ubix.ssp.ad.g.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeExpressAdListener f9063a;

        a(UBiXNativeExpressAdListener uBiXNativeExpressAdListener) {
            this.f9063a = uBiXNativeExpressAdListener;
        }

        @Override // com.ubix.ssp.ad.g.f
        public void onAdLoadFailed(AdError adError) {
            if (this.f9063a != null) {
                u.c(d.f9062a, "onAdLoadFailed in");
                this.f9063a.onAdLoadFailed(adError);
            }
            u.c(d.f9062a, "onAdLoadFailed out ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }

        @Override // com.ubix.ssp.ad.g.f
        public void onAdLoadSucceed(List<NativeExpressAd> list) {
            if (this.f9063a != null) {
                u.e(d.f9062a, "onAdLoadSucceed in");
                this.f9063a.onAdLoadSucceed(list);
            }
            u.e(d.f9062a, "onAdLoadSucceed out");
        }
    }

    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager
    public String getBiddingToken() {
        com.ubix.ssp.ad.i.d dVar = this.b;
        if (dVar == null) {
            u.e(f9062a, "getBiddingToken:null");
            return null;
        }
        String strA = dVar.a();
        u.f("getBiddingToken:" + strA);
        return strA;
    }

    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager
    public void loadAd() {
        com.ubix.ssp.ad.i.d dVar = this.b;
        if (dVar != null) {
            dVar.b();
            u.e(f9062a, h.Code);
        }
    }

    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager
    public void loadAd(int i) {
        com.ubix.ssp.ad.i.d dVar = this.b;
        if (dVar != null) {
            dVar.b(i);
            u.e(f9062a, "loadAd count:" + i);
        }
    }

    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager
    public void loadBiddingAd(String str) {
        com.ubix.ssp.ad.i.d dVar = this.b;
        if (dVar != null) {
            dVar.a(str);
            u.e(f9062a, "loadBiddingAd adm:" + str);
        }
    }

    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager
    public void loadNativeExpressAd(Context context, String str, AdSize adSize, UBiXNativeExpressAdListener uBiXNativeExpressAdListener) {
        if (u.a()) {
            String str2 = f9062a;
            u.e(str2, "slot id:" + str + "   AdSize:" + adSize + "   listener is null:" + (uBiXNativeExpressAdListener == null) + "   context is null:" + (context == null));
            if (context != null) {
                u.e(str2, "context is activity:" + (context instanceof Activity));
            }
        }
        this.b = new com.ubix.ssp.ad.i.d(context, str, adSize, new a(uBiXNativeExpressAdListener));
    }

    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager
    public void loadNativeExpressAd(Context context, String str, UBiXNativeExpressAdListener uBiXNativeExpressAdListener) {
        loadNativeExpressAd(context, str, new AdSize(-1, -2), uBiXNativeExpressAdListener);
    }

    @Override // com.ubix.ssp.open.nativee.express.UBiXNativeExpressManager
    public void setExtraInfo(HashMap<String, String> map) {
        com.ubix.ssp.ad.i.d dVar = this.b;
        if (dVar != null) {
            dVar.a(map);
            u.e(f9062a, "setExtraInfo");
        }
    }
}
