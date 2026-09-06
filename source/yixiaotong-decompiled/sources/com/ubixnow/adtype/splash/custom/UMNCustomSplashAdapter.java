package com.ubixnow.adtype.splash.custom;

import android.view.ViewGroup;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.o000O00O;
import com.ubixnow.ooooo.o000O0O0;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.o00OO00O;
import com.ubixnow.ooooo.o00OOOOo;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class UMNCustomSplashAdapter extends o00OO00O {
    public o000O0O0 eventListener;
    public String customTag = "----ubixsplash_lm_";
    public o000O00O<UMNCustomSplashAdapter> splashInfo = new o000O00O<>();

    public void createSplashInfo(o00O000 o00o000) {
        this.splashInfo.setAbsBaseAdapter(this);
        this.splashInfo.setBaseAdConfig(o00o000);
    }

    @Override // com.ubixnow.ooooo.o00O
    public oo00o getUbixInfo() {
        return this.splashInfo;
    }

    public void internalShow(ViewGroup viewGroup, o000O0O0 o000o0o0) {
        this.eventListener = o000o0o0;
        show(viewGroup);
    }

    public void internalShow(o00OOOOo o00ooooo, o000O0O0 o000o0o0) {
        this.eventListener = o000o0o0;
        handle(o00ooooo);
        show(o00ooooo.OooO0O0());
    }

    public void onAdDataLoadFailed(String str, String str2) {
        showLog(this.customTag + getClass().getSimpleName(), "onAdDataLoadFailed code=" + str + " msg=" + str2);
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, str + "", str2).setInfo((Object) this.splashInfo));
        }
    }

    public void onAdDataLoadSuc() {
        showLog(this.customTag + getClass().getSimpleName(), "onAdDataLoaded");
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdDataLoaded(this.splashInfo);
        }
    }

    public void onAdDataLoaded() {
        showLog(this.customTag + getClass().getSimpleName(), "onAdDataLoaded");
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdDataLoaded(this.splashInfo);
        }
    }

    public void onRenderFail(int i, String str) {
        showLog(this.customTag + getClass().getSimpleName(), "onRenderFail code=" + i + " msg=" + str);
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdRenderFail(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) this.splashInfo));
        }
    }
}
