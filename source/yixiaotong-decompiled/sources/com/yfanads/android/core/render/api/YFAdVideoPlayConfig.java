package com.yfanads.android.core.render.api;

import com.yfanads.android.core.render.impl.YFVideoPlayConfigImpl;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface YFAdVideoPlayConfig {

    public static class Builder {
        private boolean dataFlowAutoStart;
        private boolean videoSoundEnable;
        private YFVideoPlayConfigImpl config = new YFVideoPlayConfigImpl();
        private boolean isNoCache = false;

        public YFAdVideoPlayConfig build() {
            return this.config;
        }

        public Builder noCache() {
            this.config.setNoCache();
            return this;
        }

        public Builder videoAutoPlayType(int i) {
            this.config.setVideoAutoPlayType(i);
            return this;
        }

        public Builder videoSoundEnable(boolean z) {
            this.config.setVideoSoundEnable(z);
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoAutoPlayType {
        public static final int AUTO_PLAY = 1;
        public static final int AUTO_PLAY_WIFI = 2;
        public static final int NO_AUTO_PLAY = 3;
        public static final int UNKNOWN = 0;
    }

    int getVideoAutoPlayType();

    boolean isDataFlowAutoStart();

    boolean isNoCache();

    boolean isVideoSoundEnable();

    @Deprecated
    void setDataFlowAutoStart(boolean z);

    void setNoCache();

    void setVideoAutoPlayType(int i);

    void setVideoSoundEnable(boolean z);
}
