package com.ubixnow.adtype.interstital.custom;

import android.app.Activity;
import android.content.Context;
import com.ubixnow.adtype.interstital.api.UMNInterstitalParams;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooOo;
import com.ubixnow.ooooo.o00O;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.oOO00O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class UMNCustomInterstitalAdapter extends o00O {
    public OooOo eventListener;
    public Context mContext;
    public UMNInterstitalParams mParams;
    public String customTag = "----ubixInterstital_lm_";
    public oo00o<UMNCustomInterstitalAdapter> absUbixInfo = new oo00o<UMNCustomInterstitalAdapter>() { // from class: com.ubixnow.adtype.interstital.custom.UMNCustomInterstitalAdapter.1
    };
    public boolean isMute = true;

    public void createADInfo(o00O000 o00o000) {
        this.absUbixInfo.setAbsBaseAdapter(this);
        oo00o<UMNCustomInterstitalAdapter> oo00oVar = this.absUbixInfo;
        oo00oVar.adType = "5";
        oo00oVar.setBaseAdConfig(o00o000);
    }

    public boolean getInterstitialType() {
        oOO00O ooo00o;
        o00O000 o00o000 = this.mBaseAdConfig;
        if (o00o000 == null || (ooo00o = o00o000.OooOOO0) == null) {
            return false;
        }
        return ooo00o.Oooo0O0;
    }

    @Override // com.ubixnow.ooooo.o00O
    public oo00o getUbixInfo() {
        return this.absUbixInfo;
    }

    public boolean getVideoPlayMute() {
        oOO00O ooo00o;
        o00O000 o00o000 = this.mBaseAdConfig;
        if (o00o000 == null || (ooo00o = o00o000.OooOOO0) == null) {
            return true;
        }
        return ooo00o.Oooo0OO;
    }

    public String getVideoPlayPolicy() {
        oOO00O ooo00o;
        o00O000 o00o000 = this.mBaseAdConfig;
        return (o00o000 == null || (ooo00o = o00o000.OooOOO0) == null) ? "" : ooo00o.Oooo0;
    }

    @Override // com.ubixnow.ooooo.o00O
    public void innerLoad(Context context, o00O000 o00o000, Object... objArr) {
        super.innerLoad(context, o00o000, objArr);
        this.isMute = getVideoPlayMute();
        this.mContext = context;
        loadInterstitalAd(context, o00o000);
    }

    @Override // com.ubixnow.ooooo.o00O
    public void loadCustomAd(Context context, o00O000 o00o000, Object... objArr) {
    }

    public abstract void loadInterstitalAd(Context context, o00O000 o00o000);

    public void onAdDataLoadFailed(int i, String str) {
        showLog(this.customTag + getClass().getSimpleName(), "onAdDataLoadFailed");
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onNoAdError(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, i + "", str).setInfo((Object) this.absUbixInfo));
        }
    }

    public void onAdDataLoaded() {
        showLog(this.customTag + getClass().getSimpleName(), "onAdDataLoaded");
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdDataLoaded(this.absUbixInfo);
        }
    }

    public void onAdRenderFail(String str, String str2) {
        showLog(this.customTag + getClass().getSimpleName(), "onRenderFail");
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdRenderFail(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, str + "", str2).setInfo((Object) this.absUbixInfo));
        }
    }

    public void setEventListener(OooOo oooOo) {
        this.eventListener = oooOo;
    }

    public abstract void show(Activity activity);
}
