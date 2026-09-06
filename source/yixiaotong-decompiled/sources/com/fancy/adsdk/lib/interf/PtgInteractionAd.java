package com.fancy.adsdk.lib.interf;

import android.app.Activity;
import com.fancy.adsdk.lib.model.AdError;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgInteractionAd extends PtgAd {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();

        void onRenderError(AdError adError);
    }

    void closureInterstitialAd();

    NativeAdvertData getAdvertData();

    Map<String, Object> getMediaExtraInfo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener);

    void showInteractionAd(Activity activity);
}
