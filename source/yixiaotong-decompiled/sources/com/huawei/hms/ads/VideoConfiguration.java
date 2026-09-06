package com.huawei.hms.ads;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class VideoConfiguration {
    private int audioFocusType;
    private int autoPlayNetwork;
    private boolean clickToFullScreenRequested;
    private boolean customizeOperateRequested;
    private boolean isMute;

    /* JADX INFO: renamed from: com.huawei.hms.ads.VideoConfiguration$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private boolean Code = false;
        private boolean V = false;
        private int I = 0;
        private boolean Z = true;
        private int B = 1;

        private boolean Code(int i) {
            return (i == 2 || i == 0 || i == 1) ? false : true;
        }

        public final VideoConfiguration build() {
            return new VideoConfiguration(this, null);
        }

        public Builder setAudioFocusType(int i) {
            this.B = i;
            return this;
        }

        public Builder setAutoPlayNetwork(int i) {
            if (Code(i)) {
                this.I = -1;
                return this;
            }
            this.I = i;
            return this;
        }

        public Builder setClickToFullScreenRequested(boolean z) {
            this.V = z;
            return this;
        }

        public Builder setCustomizeOperateRequested(boolean z) {
            this.Code = z;
            return this;
        }

        public Builder setStartMuted(boolean z) {
            this.Z = z;
            return this;
        }
    }

    private VideoConfiguration(Builder builder) {
        this.customizeOperateRequested = false;
        this.clickToFullScreenRequested = false;
        this.autoPlayNetwork = 0;
        this.isMute = true;
        this.audioFocusType = 1;
        if (builder != null) {
            this.clickToFullScreenRequested = builder.V;
            this.customizeOperateRequested = builder.Code;
            this.audioFocusType = builder.B;
            this.autoPlayNetwork = builder.I;
            this.isMute = builder.Z;
        }
    }

    /* synthetic */ VideoConfiguration(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public int getAudioFocusType() {
        return this.audioFocusType;
    }

    public int getAutoPlayNetwork() {
        return this.autoPlayNetwork;
    }

    public final boolean isClickToFullScreenRequested() {
        return this.clickToFullScreenRequested;
    }

    public final boolean isCustomizeOperateRequested() {
        return this.customizeOperateRequested;
    }

    public final boolean isStartMuted() {
        return this.isMute;
    }
}
