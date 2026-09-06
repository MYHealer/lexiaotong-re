package com.ubixnow.adtype.banner.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.core.common.BaseDevConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNBannerParams extends BaseDevConfig {
    public int height;
    public int width;

    /* JADX INFO: renamed from: com.ubixnow.adtype.banner.api.UMNBannerParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends BaseDevConfig.Builder {
        private int width = MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME;
        private int height = 50;

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public UMNBannerParams build() {
            return new UMNBannerParams(this, null);
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder fetchAdTimeOut(int i) {
            this.timeout = i;
            return this;
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public BaseDevConfig.Builder setExtra(Map<String, Object> map) {
            this.map = map;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder setSlotId(String str) {
            this.slotId = str;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }
    }

    private UMNBannerParams(Builder builder) {
        this.slotId = builder.slotId;
        this.map = builder.map;
        this.width = builder.width;
        this.height = builder.height;
        this.timeout = builder.timeout;
    }

    public /* synthetic */ UMNBannerParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
