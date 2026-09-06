package com.ubix.ssp.open.manager;

import android.app.Activity;
import android.content.Context;
import com.huawei.openalliance.ad.constant.h;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.open.AdError;
import com.ubix.ssp.open.nativee.NativeAd;
import com.ubix.ssp.open.nativee.UBiXNativeAdListener;
import com.ubix.ssp.open.nativee.UBiXNativeManager;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e implements UBiXNativeManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9064a = "e";
    private com.ubix.ssp.ad.i.c b;

    class a implements com.ubix.ssp.ad.g.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeAdListener f9065a;

        a(UBiXNativeAdListener uBiXNativeAdListener) {
            this.f9065a = uBiXNativeAdListener;
        }

        @Override // com.ubix.ssp.ad.g.g
        public void a(ArrayList<NativeAd> arrayList) {
            if (this.f9065a != null) {
                u.e(e.f9064a, "onAdLoadSucceed in");
                this.f9065a.onAdLoadSucceed(arrayList);
            }
            u.e(e.f9064a, "onAdLoadSucceed out");
        }

        @Override // com.ubix.ssp.ad.g.g
        public void onAdLoadFailed(AdError adError) {
            if (this.f9065a != null) {
                u.c(e.f9064a, "onAdLoadFailed: ErrorCode in");
                this.f9065a.onAdLoadFailed(adError);
            }
            u.c(e.f9064a, "onAdLoadFailed out: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
        }
    }

    class b implements com.ubix.ssp.ad.g.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ UBiXNativeAdListener f9066a;

        b(UBiXNativeAdListener uBiXNativeAdListener) {
            this.f9066a = uBiXNativeAdListener;
        }

        @Override // com.ubix.ssp.ad.g.g
        public void a(ArrayList<NativeAd> arrayList) {
            UBiXNativeAdListener uBiXNativeAdListener = this.f9066a;
            if (uBiXNativeAdListener != null) {
                uBiXNativeAdListener.onAdLoadSucceed(arrayList);
                u.e(e.f9064a, "[ADD adType]onAdLoadSucceed ");
            }
        }

        @Override // com.ubix.ssp.ad.g.g
        public void onAdLoadFailed(AdError adError) {
            UBiXNativeAdListener uBiXNativeAdListener = this.f9066a;
            if (uBiXNativeAdListener != null) {
                uBiXNativeAdListener.onAdLoadFailed(adError);
                u.c(e.f9064a, "[ADD adType]onAdLoadFailed: ErrorCode:" + adError.getErrorCode() + "   ErrorMessage:" + adError.getErrorMessage());
            }
        }
    }

    @Override // com.ubix.ssp.open.nativee.UBiXNativeManager
    public String getBiddingToken() {
        com.ubix.ssp.ad.i.c cVar = this.b;
        if (cVar == null) {
            u.e(f9064a, "getBiddingToken:null");
            return null;
        }
        String strB = cVar.B();
        u.f("getBiddingToken:" + strB);
        return strB;
    }

    @Override // com.ubix.ssp.open.nativee.UBiXNativeManager
    public void loadAd() {
        com.ubix.ssp.ad.i.c cVar = this.b;
        if (cVar != null) {
            cVar.C();
            u.e(f9064a, h.Code);
        }
    }

    @Override // com.ubix.ssp.open.nativee.UBiXNativeManager
    public void loadAd(int i) {
        com.ubix.ssp.ad.i.c cVar = this.b;
        if (cVar != null) {
            cVar.m(i);
            u.e(f9064a, "loadAd count:" + i);
        }
    }

    @Override // com.ubix.ssp.open.nativee.UBiXNativeManager
    public void loadBiddingAd(String str) {
        com.ubix.ssp.ad.i.c cVar = this.b;
        if (cVar != null) {
            cVar.h(str);
            u.e(f9064a, "loadBiddingAd adm:" + str);
        }
    }

    @Override // com.ubix.ssp.open.nativee.UBiXNativeManager
    public void loadNativeAd(Context context, String str, int i, UBiXNativeAdListener uBiXNativeAdListener) {
        String str2 = f9064a;
        u.e(str2, "slot id:" + str + "   adType:" + i + "   listener is null:" + (uBiXNativeAdListener == null) + "   context is null:" + (context == null));
        if (context != null) {
            u.e(str2, "context is activity:" + (context instanceof Activity));
        }
        this.b = new com.ubix.ssp.ad.i.c(context, str, i, new b(uBiXNativeAdListener));
    }

    @Override // com.ubix.ssp.open.nativee.UBiXNativeManager
    public void loadNativeAd(Context context, String str, UBiXNativeAdListener uBiXNativeAdListener) {
        if (u.a()) {
            String str2 = f9064a;
            u.e(str2, "slot id:" + str + "   listener is null:" + (uBiXNativeAdListener == null) + "   context is null:" + (context == null));
            if (context != null) {
                u.e(str2, "context is activity:" + (context instanceof Activity));
            }
        }
        this.b = new com.ubix.ssp.ad.i.c(context, str, 2, new a(uBiXNativeAdListener));
    }

    @Override // com.ubix.ssp.open.nativee.UBiXNativeManager
    public void setExtraInfo(HashMap<String, String> map) {
        com.ubix.ssp.ad.i.c cVar = this.b;
        if (cVar != null) {
            cVar.a(map);
            u.e(f9064a, "setExtraInfo");
        }
    }
}
