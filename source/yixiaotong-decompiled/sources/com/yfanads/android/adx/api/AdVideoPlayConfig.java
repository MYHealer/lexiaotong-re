package com.yfanads.android.adx.api;

import com.yfanads.android.adx.core.annotate.AdSdkApi;
import com.yfanads.android.adx.core.load.AdxLoader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@AdSdkApi
public interface AdVideoPlayConfig {

    @AdSdkApi
    public static class Builder {
        AdVideoPlayConfig config = (AdVideoPlayConfig) AdxLoader.get().newInstance(AdVideoPlayConfig.class);

        @AdSdkApi
        public AdVideoPlayConfig build() {
            return this.config;
        }

        @AdSdkApi
        public Builder videoAutoPlayType(int i) {
            AdVideoPlayConfig adVideoPlayConfig = this.config;
            if (adVideoPlayConfig != null) {
                adVideoPlayConfig.setVideoAutoPlayType(i);
            }
            return this;
        }

        @AdSdkApi
        public Builder videoSoundEnable(boolean z) {
            AdVideoPlayConfig adVideoPlayConfig = this.config;
            if (adVideoPlayConfig != null) {
                adVideoPlayConfig.setVideoSoundEnable(z);
            }
            return this;
        }
    }

    @AdSdkApi
    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoAutoPlayType {
        public static final int AUTO_PLAY = 1;
        public static final int AUTO_PLAY_WIFI = 2;
        public static final int NO_AUTO_PLAY = 3;
        public static final int UNKNOWN = 0;
    }

    @AdSdkApi
    int getVideoAutoPlayType();

    @AdSdkApi
    boolean isVideoSoundEnable();

    @AdSdkApi
    @Deprecated
    void setDataFlowAutoStart(boolean z);

    @AdSdkApi
    void setVideoAutoPlayType(int i);

    @AdSdkApi
    void setVideoSoundEnable(boolean z);
}
