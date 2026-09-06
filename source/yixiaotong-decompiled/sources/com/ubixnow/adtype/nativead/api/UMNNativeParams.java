package com.ubixnow.adtype.nativead.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.core.common.BaseDevConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNNativeParams extends BaseDevConfig {
    public int adStyle;
    public boolean cacheAd;
    public int height;
    public int width;

    /* JADX INFO: renamed from: com.ubixnow.adtype.nativead.api.UMNNativeParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends BaseDevConfig.Builder {
        public int adStyle;
        private boolean cacheAd;
        private int width = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int height = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public UMNNativeParams build() {
            return new UMNNativeParams(this, null);
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder fetchAdTimeOut(int i) {
            this.timeout = i;
            return this;
        }

        public Builder isCa(boolean z) {
            this.cacheAd = z;
            return this;
        }

        public Builder setAdStyle(int i) {
            this.adStyle = i;
            return this;
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder setExtra(Map<String, Object> map) {
            this.map = map;
            return this;
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public /* bridge */ /* synthetic */ BaseDevConfig.Builder setExtra(Map map) {
            return setExtra((Map<String, Object>) map);
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

    private UMNNativeParams(Builder builder) {
        this.slotId = builder.slotId;
        this.adStyle = builder.adStyle;
        this.width = builder.width;
        this.height = builder.height;
        this.map = builder.map;
        this.cacheAd = builder.cacheAd;
        this.timeout = builder.timeout;
    }

    public /* synthetic */ UMNNativeParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
