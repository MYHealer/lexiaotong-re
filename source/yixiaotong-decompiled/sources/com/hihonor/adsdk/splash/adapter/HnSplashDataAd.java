package com.hihonor.adsdk.splash.adapter;

import android.graphics.Bitmap;
import android.view.View;
import com.hihonor.adsdk.base.api.HnMediationExpressDataAd;
import com.hihonor.adsdk.base.api.splash.SplashExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnSplashDataAd extends HnMediationExpressDataAd<SplashExpressAd> implements SplashExpressAd {
    public HnSplashDataAd(SplashExpressAd splashExpressAd) {
        super(splashExpressAd);
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public String getActionTips() {
        T t = this.hnadsd;
        if (t == 0) {
            return "";
        }
        ((SplashExpressAd) t).getActionTips();
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public String getActionType() {
        T t = this.hnadsd;
        return t != 0 ? ((SplashExpressAd) t).getActionType() : "";
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public int getAdFlagFontSize() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).getAdFlagFontSize();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public int getBrandFontSize() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).getBrandFontSize();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public int getImpDuration() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).getImpDuration();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public double getShakeAcc() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).getShakeAcc();
        }
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public double getShakeAngle() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).getShakeAngle();
        }
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public double getShakeDuration() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).getShakeDuration();
        }
        return 0.0d;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public int getSkipFontSize() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).getSkipFontSize();
        }
        return 0;
    }

    @Override // com.hihonor.adsdk.base.api.HnMediationExpressDataAd, com.hihonor.adsdk.base.api.BaseAd
    public String getTargetTips() {
        T t = this.hnadsd;
        if (t == 0) {
            return "";
        }
        ((SplashExpressAd) t).getActionTips();
        return "";
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public boolean isCachedData() {
        T t = this.hnadsd;
        if (t != 0) {
            return ((SplashExpressAd) t).isCachedData();
        }
        return false;
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoArea(View view) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setLogoArea(view);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoResId(int i) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setLogoResId(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoView(Bitmap bitmap) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setLogoView(bitmap);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaCopyrightResId(int i) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setMediaCopyrightResId(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaCopyrightString(String str) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setMediaCopyrightString(str);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaNameResId(int i) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setMediaNameResId(i);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setMediaNameString(String str) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setMediaNameString(str);
        }
    }

    @Override // com.hihonor.adsdk.base.api.splash.SplashExpressAd
    public void setLogoArea(View view, int i) {
        T t = this.hnadsd;
        if (t != 0) {
            ((SplashExpressAd) t).setLogoArea(view, i);
        }
    }
}
