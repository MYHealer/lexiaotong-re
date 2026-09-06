package com.heytap.msp.mobad.api.params;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class InterstitialParams {
    public final InterstitialScene interstitialScene;

    public static class Builder {
        private InterstitialScene interstitialScene;

        public InterstitialParams build() {
            return new InterstitialParams(this);
        }

        public Builder scene(InterstitialScene interstitialScene) {
            this.interstitialScene = interstitialScene;
            return this;
        }
    }

    public enum InterstitialScene {
        NORMAL,
        INSTANT_EXIT
    }

    public InterstitialParams(Builder builder) {
        this.interstitialScene = builder.interstitialScene;
    }
}
