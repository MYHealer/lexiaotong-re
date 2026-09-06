package com.hihonor.adsdk.base.api.splash;

import android.graphics.Bitmap;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseExpressAd;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface SplashExpressAd extends BaseExpressAd {
    String getActionTips();

    String getActionType();

    int getAdFlagFontSize();

    int getBrandFontSize();

    int getImpDuration();

    double getShakeAcc();

    double getShakeAngle();

    double getShakeDuration();

    int getSkipFontSize();

    String getTargetTips();

    boolean isCachedData();

    void setLogoArea(View view);

    void setLogoArea(View view, int i);

    void setLogoResId(int i);

    void setLogoView(Bitmap bitmap);

    void setMediaCopyrightResId(int i);

    void setMediaCopyrightString(String str);

    void setMediaNameResId(int i);

    void setMediaNameString(String str);
}
