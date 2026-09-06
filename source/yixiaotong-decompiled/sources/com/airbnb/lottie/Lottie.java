package com.airbnb.lottie;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class Lottie {
    private Lottie() {
    }

    public static void initialize(LottieConfig lottieConfig) {
        L.setFetcher(lottieConfig.networkFetcher);
        L.setCacheProvider(lottieConfig.cacheProvider);
        L.setTraceEnabled(lottieConfig.enableSystraceMarkers);
        L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
        L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
        L.setDisablePathInterpolatorCache(lottieConfig.disablePathInterpolatorCache);
    }
}
