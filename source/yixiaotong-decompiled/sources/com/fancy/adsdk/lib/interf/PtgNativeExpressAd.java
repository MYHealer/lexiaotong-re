package com.fancy.adsdk.lib.interf;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.fancy.adsdk.lib.model.AdError;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public interface PtgNativeExpressAd extends PtgAd {

    public interface AdInteractionListener extends ExpressAdInteractionListener {
    }

    public interface CustomizeVideo {
        String getCoverUrl();

        String getVideoUrl();

        void reportVideoComplete();

        void reportVideoError();

        void reportVideoPause();

        void reportVideoProgress(long j, long j2);

        void reportVideoResume();

        void reportVideoStart();
    }

    public interface ExpressAdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();

        void onRenderFail(AdError adError);

        void onRenderSuccess(View view);
    }

    @Override // com.fancy.adsdk.lib.interf.PtgAd
    void destroy();

    NativeAdvertData getAdvertData();

    CustomizeVideo getCustomizeVideo();

    View getExpressAdView();

    List<Object> getFilterWords();

    int getImageMode();

    Map<String, Object> getMediaExtraInfo();

    View getMediaView();

    boolean isSelfRender();

    boolean isVideo();

    void pauseVideo();

    void registerAdvertViews(ViewGroup viewGroup, List<View> list, List<View> list2, View view);

    void render();

    void setCanInterruptVideoPlay(boolean z);

    void setDownloadListener(PtgAppDownloadListener ptgAppDownloadListener);

    void setExpressInteractionListener(AdInteractionListener adInteractionListener);

    void setExpressViewColor(String str);

    void setSlideIntervalTime(int i);

    void setVideoAdListener(PtgVideoAdListener ptgVideoAdListener);

    void showInteractionExpressAd(Activity activity);

    void startVideo();
}
