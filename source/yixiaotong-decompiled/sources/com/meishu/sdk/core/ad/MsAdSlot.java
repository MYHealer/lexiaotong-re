package com.meishu.sdk.core.ad;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MsAdSlot {
    private String channel;
    private int fetchCount;
    private int fixedHeight;
    private int height;
    private boolean hideSkipButton;
    private boolean isClickToClose;
    private boolean isMute;
    private boolean isSplashFullScreen;
    private boolean isVideoAutoPlay;
    private String pid;
    private boolean showDetail;
    private int width;

    public static class Builder {
        private String channel;
        private int fixedHeight;
        private boolean hideSkipButton;
        private boolean isClickToClose;
        private boolean isSplashFullScreen;
        private boolean nativeFeedUseShake;
        private String pid;
        private boolean showDetail;
        private int width = -1;
        private int height = -1;
        private boolean isVideoAutoPlay = true;
        private int fetchCount = 1;
        private boolean isMute = true;

        public MsAdSlot build() {
            return new MsAdSlot(this);
        }

        public Builder setChannel(String str) {
            this.channel = str;
            return this;
        }

        public Builder setFetchCount(int i) {
            this.fetchCount = i;
            return this;
        }

        public Builder setFixHeight(int i) {
            this.fixedHeight = i;
            return this;
        }

        public Builder setHeight(int i) {
            this.height = i;
            return this;
        }

        public Builder setIsClickToClose(boolean z) {
            this.isClickToClose = z;
            return this;
        }

        public Builder setIsHideSkipBtn(boolean z) {
            this.hideSkipButton = z;
            return this;
        }

        public Builder setIsVideoAutoPlay(boolean z) {
            this.isVideoAutoPlay = z;
            return this;
        }

        public Builder setIsshowDetail(boolean z) {
            this.showDetail = z;
            return this;
        }

        public Builder setNativeFeedUseShake(boolean z) {
            this.nativeFeedUseShake = z;
            return this;
        }

        public Builder setPid(String str) {
            this.pid = str;
            return this;
        }

        public Builder setSplashIsFullScreen(boolean z) {
            this.isSplashFullScreen = z;
            return this;
        }

        public Builder setVideoMute(boolean z) {
            this.isMute = z;
            return this;
        }

        public Builder setWidth(int i) {
            this.width = i;
            return this;
        }
    }

    public MsAdSlot(Builder builder) {
        this.width = -1;
        this.height = -1;
        this.isVideoAutoPlay = true;
        this.fetchCount = 1;
        this.isMute = true;
        this.pid = builder.pid;
        this.width = builder.width;
        this.height = builder.height;
        this.isClickToClose = builder.isClickToClose;
        this.showDetail = builder.showDetail;
        this.isVideoAutoPlay = builder.isVideoAutoPlay;
        this.fixedHeight = builder.fixedHeight;
        this.fetchCount = builder.fetchCount;
        this.isMute = builder.isMute;
        this.hideSkipButton = builder.hideSkipButton;
        this.isSplashFullScreen = builder.isSplashFullScreen;
        this.channel = builder.channel;
    }

    public String getChannel() {
        return this.channel;
    }

    public int getFetchCount() {
        return this.fetchCount;
    }

    public int getFixedHeight() {
        return this.fixedHeight;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getIsClickToClose() {
        return this.isClickToClose;
    }

    public boolean getIsHideSkipButton() {
        return this.hideSkipButton;
    }

    public boolean getIsMute() {
        return this.isMute;
    }

    public boolean getIsShowDetail() {
        return this.showDetail;
    }

    public boolean getIsVideoAutoPlay() {
        return this.isVideoAutoPlay;
    }

    public String getPid() {
        return this.pid;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isSplashFullScreen() {
        return this.isSplashFullScreen;
    }
}
