package com.ubixnow.adtype.interstital.api;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.ubixnow.core.common.BaseDevConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNInterstitalParams extends BaseDevConfig {
    public boolean closeAfterClick;
    public int height;
    public int width;

    /* JADX INFO: renamed from: com.ubixnow.adtype.interstital.api.UMNInterstitalParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends BaseDevConfig.Builder {
        private boolean closeAfterClick;
        private int width = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL;
        private int height = MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK;

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public UMNInterstitalParams build() {
            return new UMNInterstitalParams(this, null);
        }

        public Builder closeAfterClick(boolean z) {
            this.closeAfterClick = z;
            return this;
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

        public Builder setInterstitalHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setInterstitalWidth(int i) {
            this.width = i;
            return this;
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder setSlotId(String str) {
            this.slotId = str;
            return this;
        }
    }

    private UMNInterstitalParams(Builder builder) {
        this.slotId = builder.slotId;
        this.map = builder.map;
        this.width = builder.width;
        this.height = builder.height;
        this.closeAfterClick = builder.closeAfterClick;
        this.timeout = builder.timeout;
    }

    public /* synthetic */ UMNInterstitalParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
