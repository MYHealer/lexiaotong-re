package com.kwad.sdk.api;

import com.kwad.sdk.api.core.KsAdSdkApi;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
@KsAdSdkApi
public interface KsInnerAd {

    @KsAdSdkApi
    public interface KsInnerAdInteractionListener {
        @KsAdSdkApi
        void onAdClicked(KsInnerAd ksInnerAd);

        @KsAdSdkApi
        void onAdShow(KsInnerAd ksInnerAd);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface KsInnerAdType {
        public static final int AGGREGATION = 1;
        public static final int REFLOW = 2;
        public static final int UNKNOWN = 0;
    }

    int getType();
}
