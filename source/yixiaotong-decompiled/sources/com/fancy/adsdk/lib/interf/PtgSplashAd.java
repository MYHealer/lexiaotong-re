package com.fancy.adsdk.lib.interf;

import android.app.Activity;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.model.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgSplashAd extends PtgAd {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdShow();

        void onAdSkip();

        void onAdTimeOver();

        void onDismiss(int i);

        void onRenderError(AdError adError);

        void onRenderSuccess();
    }

    NativeAdvertData getAdvertData();

    void load();

    void preload();

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setSplashInteractionListener(AdInteractionListener adInteractionListener);

    void showAd(ViewGroup viewGroup);

    void showAd(ViewGroup viewGroup, Activity activity);
}
