package com.ubixnow.adtype.banner.custom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.OooO0o;
import com.ubixnow.ooooo.OooOO0O;
import com.ubixnow.ooooo.o00O;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O00o0;
import com.ubixnow.ooooo.oOO00O;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oo00o;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public abstract class UMNCustomBannerAdapter extends o00O {
    public OooO0o eventListener;
    public boolean hasCallBack;
    public String customTag = "----ubixbanner_lm_";
    public OooOO0O<UMNCustomBannerAdapter> absUbixInfo = new OooOO0O<UMNCustomBannerAdapter>() { // from class: com.ubixnow.adtype.banner.custom.UMNCustomBannerAdapter.1
    };
    public int bannerRefreshTime = 0;

    public void createADInfo(o00O000 o00o000) {
        this.absUbixInfo.setAbsBaseAdapter(this);
        OooOO0O<UMNCustomBannerAdapter> oooOO0O = this.absUbixInfo;
        oooOO0O.adType = "04";
        oooOO0O.setBaseAdConfig(o00o000);
    }

    @Override // com.ubixnow.ooooo.o00O
    public oo00o getUbixInfo() {
        return this.absUbixInfo;
    }

    public boolean getVideoPlayMute() {
        oOO00O ooo00o;
        o00O000 o00o000 = this.mBaseAdConfig;
        if (o00o000 == null || (ooo00o = o00o000.OooOOO0) == null) {
            return false;
        }
        return ooo00o.Oooo0OO;
    }

    public abstract View getView();

    @Override // com.ubixnow.ooooo.o00O
    public void innerLoad(Context context, o00O000 o00o000, Object... objArr) {
        super.innerLoad(context, o00o000, objArr);
        loadBannerAd(context, o00o000);
    }

    public abstract void loadBannerAd(Context context, o00O000 o00o000);

    @Override // com.ubixnow.ooooo.o00O
    public void loadCustomAd(Context context, o00O000 o00o000, Object... objArr) {
    }

    public int parseBannerRefreshTime(String str) {
        if (str != null) {
            try {
                return Integer.parseInt(new JSONObject(str).optJSONObject("advCo").optString(oOO00O.OooO0oo));
            } catch (Exception unused) {
            }
        }
        return -1;
    }

    public void renderFail(String str, String str2) {
        showLog(this.customTag + getClass().getSimpleName(), "onRenderFail code=" + str + " msg=" + str2);
        o00O00o0 o00o00o0 = this.loadListener;
        if (o00o00o0 != null) {
            o00o00o0.onAdRenderFail(new ErrorInfo(oOO00O0.ubix_no_ad, oOO00O0.ubix_no_ad_msg, str, str2).setInfo((Object) this.absUbixInfo));
        }
    }

    public void setEventListener(OooO0o oooO0o) {
        this.eventListener = oooO0o;
    }

    public abstract void show(ViewGroup viewGroup);
}
