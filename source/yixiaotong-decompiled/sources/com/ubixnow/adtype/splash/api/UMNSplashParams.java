package com.ubixnow.adtype.splash.api;

import com.ubixnow.core.common.BaseDevConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNSplashParams extends BaseDevConfig {
    public int height;
    public int skipTime;
    public int width;

    /* JADX INFO: renamed from: com.ubixnow.adtype.splash.api.UMNSplashParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder extends BaseDevConfig.Builder {
        public int skipTime;
        private int width = 0;
        private int height = 0;

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public UMNSplashParams build() {
            return new UMNSplashParams(this, null);
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder fetchAdTimeOut(int i) {
            this.timeout = i;
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

        public Builder setSkipTime(int i) {
            if (i < 3) {
                this.skipTime = 3;
            } else {
                if (i > 15) {
                    i = 5;
                }
                this.skipTime = i;
            }
            return this;
        }

        @Override // com.ubixnow.core.common.BaseDevConfig.Builder
        public Builder setSlotId(String str) {
            this.slotId = str;
            return this;
        }

        public Builder setSplashHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setSplashWidth(int i) {
            this.width = i;
            return this;
        }
    }

    private UMNSplashParams(Builder builder) {
        this.slotId = builder.slotId;
        this.map = builder.map;
        this.width = builder.width;
        this.height = builder.height;
        this.timeout = builder.timeout;
        this.skipTime = builder.skipTime;
    }

    public /* synthetic */ UMNSplashParams(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }
}
