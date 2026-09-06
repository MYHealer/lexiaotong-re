package com.ubixnow.adtype.reward.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.core.common.BaseDevConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNRewardParams extends BaseDevConfig {
    public int height;
    public int orientation;
    public int width;

    /* JADX INFO: renamed from: com.ubixnow.adtype.reward.api.UMNRewardParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends BaseDevConfig.Builder {
        private int width = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        private int height = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;
        private int orientation = 1;

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public UMNRewardParams build() {
            return new UMNRewardParams(this, null);
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

        public Builder setOrientation(int i) {
            this.orientation = i;
            return this;
        }

        public Builder setRewardHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setRewardWidth(int i) {
            this.width = i;
            return this;
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder setSlotId(String str) {
            this.slotId = str;
            return this;
        }
    }

    private UMNRewardParams(Builder builder) {
        this.orientation = 1;
        this.slotId = builder.slotId;
        this.map = builder.map;
        this.width = builder.width;
        this.height = builder.height;
        this.orientation = builder.orientation;
        this.timeout = builder.timeout;
    }

    public /* synthetic */ UMNRewardParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
