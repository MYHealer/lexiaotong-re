package com.miui.zeus.mimo.sdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ADParams {
    private int adCount;
    private String height;
    private boolean isFullScreen;
    private String upId;
    private String width;

    /* JADX INFO: renamed from: com.miui.zeus.mimo.sdk.ADParams$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private String height;
        private String upId;
        private String width;
        private int adCount = 1;
        private boolean isFullScreen = true;

        public ADParams build() {
            return new ADParams(this.upId, this.width, this.height, this.adCount, this.isFullScreen, null);
        }

        public Builder setAdCount(int i) {
            this.adCount = i;
            return this;
        }

        public Builder setAdSize(int i, int i2) {
            this.width = String.valueOf(i);
            this.height = String.valueOf(i2);
            return this;
        }

        public Builder setLayoutFullScreen(boolean z) {
            this.isFullScreen = z;
            return this;
        }

        public Builder setUpId(String str) {
            this.upId = str;
            return this;
        }
    }

    private ADParams() {
        this.isFullScreen = true;
    }

    private ADParams(String str, String str2, String str3, int i, boolean z) {
        this.upId = str;
        this.width = str2;
        this.height = str3;
        this.adCount = i;
        this.isFullScreen = z;
    }

    public /* synthetic */ ADParams(String str, String str2, String str3, int i, boolean z, AnonymousClass1 anonymousClass1) {
        this(str, str2, str3, i, z);
    }

    public int getAdCount() {
        return this.adCount;
    }

    public String getHeight() {
        return this.height;
    }

    public String getUpId() {
        return this.upId;
    }

    public String getWidth() {
        return this.width;
    }

    public boolean isFullScreen() {
        return this.isFullScreen;
    }
}
