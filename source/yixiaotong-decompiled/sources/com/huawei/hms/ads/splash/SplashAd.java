package com.huawei.hms.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.huawei.hms.ads.utils.c;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.s;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.h;
import com.huawei.openalliance.ad.ipc.g;
import com.huawei.openalliance.ad.utils.d;
import com.huawei.openalliance.ad.utils.i;
import com.huawei.openalliance.ad.utils.q;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class SplashAd {
    private static int B;
    private final SplashView C;

    public SplashAd(Context context) {
        this.C = new SplashView(context);
    }

    private static int Code(Context context, int i) {
        if (i != 0) {
            return (i == 1 || context == null || context.getResources().getConfiguration().orientation != 2) ? 1 : 0;
        }
        return 0;
    }

    static void Code(Context context, String str, int i, AdParam adParam, AdSlotParam.a aVar) {
        if (adParam == null || aVar == null) {
            return;
        }
        aVar.V(B).I(d.Z(context)).Z(d.B(context)).Code(c.Code(adParam.V())).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).I(adParam.I()).C(adParam.C());
        if (adParam.Code() != null) {
            aVar.Code(adParam.Code());
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(str);
        aVar.Code(arrayList).Code(Code(context, i));
    }

    public static void dismissExSplashSlogan(final Context context) {
        i.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.k, null, null, null);
            }
        });
    }

    public static boolean isExSplashEnable(Context context) {
        return d.L(context);
    }

    public static void preloadAd(Context context, String str, int i, AdParam adParam) {
        if (context == null || str == null) {
            return;
        }
        B = q.I(context);
        h hVarCode = com.huawei.openalliance.ad.inter.g.Code(context);
        if (hVarCode instanceof com.huawei.openalliance.ad.inter.g) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(context, str, i, adParam, aVar);
            ((com.huawei.openalliance.ad.inter.g) hVarCode).I(aVar.S());
            hVarCode.Code();
        }
    }

    public static void setDefaultSplashMode(Context context, int i) {
        com.huawei.openalliance.ad.inter.g.Code(context).C(i);
    }

    public static void setSloganShowTimeWhenNoAd(final Context context, final int i) {
        i.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.l, String.valueOf(i), null, null);
            }
        });
    }

    public AdContentData Code() {
        return this.C.getAdContentData();
    }

    public void dismissExSplash(final Context context) {
        i.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.3
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.m, null, null, null);
            }
        });
    }

    public BiddingInfo getBiddingInfo() {
        return this.C.getBiddingInfo() == null ? new BiddingInfo() : this.C.getBiddingInfo();
    }

    /* JADX INFO: renamed from: getSplashView, reason: merged with bridge method [inline-methods] */
    public SplashView m974getSplashView() {
        return this.C;
    }

    public boolean isLoaded() {
        return !this.C.I();
    }

    public boolean isLoading() {
        return this.C.isLoading();
    }

    public void loadAd(SplashLoadListener splashLoadListener) {
        this.C.setSplashLoadListener(splashLoadListener);
        this.C.V();
    }

    public void sendBiddingFailed(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getLurl(), false);
        fh.Code("SplashAd", "sendBiddingFailed result success");
    }

    public void sendBiddingSuccess(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getNurl(), true);
        fh.Code("SplashAd", "sendBiddingSuccess result success");
    }

    public void setAdParam(String str, int i, AdParam adParam) {
        if (this.C.getContext() == null) {
            return;
        }
        AdSlotParam.a aVar = new AdSlotParam.a();
        Code(this.C.getContext(), str, i, adParam, aVar);
        this.C.setAdSlotParam(aVar.S());
    }

    public void setAudioFocusType(int i) {
        this.C.setAudioFocusType(i);
    }

    public void setExSplashShowTime(final Context context, final int i) {
        i.I(new Runnable() { // from class: com.huawei.hms.ads.splash.SplashAd.4
            @Override // java.lang.Runnable
            public void run() {
                g.V(context).Code(s.n, String.valueOf(i), null, null);
            }
        });
    }

    public void setLogo(View view) {
        this.C.setLogo(view);
    }

    public void setLogoBitmap(Bitmap bitmap) {
        this.C.setLogoBitmap(bitmap);
    }

    public void setLogoResId(int i) {
        this.C.setLogoResId(i);
    }

    public void setMediaNameResId(int i) {
        this.C.setMediaNameResId(i);
    }

    public void setMediaNameString(String str) {
        this.C.setMediaNameString(str);
    }

    public void setSloganResId(int i) {
        this.C.setSloganResId(i);
    }

    public void setSloganView(View view) {
        this.C.setSloganView(view);
    }

    public void setSplashListener(SplashListener splashListener) {
        this.C.setSplashListener(splashListener);
    }

    public void setWideSloganResId(int i) {
        this.C.setWideSloganResId(i);
    }

    public void showAd(boolean z) {
        this.C.Code(z);
    }
}
