package com.ubixnow.core.api;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class UMNAdConstant {
    public static final String IMAGE_TYPE = "2";
    public static final String UNKNOWN = "0";
    public static final String VIDEO = "1";

    public static class DownloadStatus {
        public static final int STATUS_DOWNLOADING = 4;
        public static final int STATUS_DOWNLOAD_FAILED = 16;
        public static final int STATUS_DOWNLOAD_FINISHED = 8;
        public static final int STATUS_DOWNLOAD_PAUSED = 32;
        public static final int STATUS_IDLE = 0;
        public static final int STATUS_INSTALLED = 1;
    }

    public static class GdtConstant {
    }

    public interface InteractionType {
        public static final int DOWNLOAD = 1;
        public static final int H5 = 2;
        public static final int UNKNOWN = 0;
    }

    public static class JDConstant {
        public static String CLOSE_HIDE = "close_hide";
        public static final String JD_NATIVE_EXPRESS_HEIGHT = "jd_native_express_height";
        public static final String JD_NATIVE_EXPRESS_WIDTH = "jd_native_express_width";
        public static final String NATIVE_EXPRESS_ACTIVITY = "native_express_activity";
    }

    public static class NativeConstant {
        public static final int TYPE_EXPRESS_AD = 2;
        public static final int TYPE_NATIVE_AD = 1;
    }

    public static class PangleConstant {
        public static final String PANGLE_HEIGHT = "pangle_height";
        public static final String PANGLE_WIDTH = "pangle_width";
    }

    public static class RewardTaskAction {
        public static final String DOWNLOAD = "1";
        public static final String INSTALL = "2";
        public static final String NONE = "0";
        public static final String VIEW = "3";
    }

    public static class SplashConstant {
        public static final String NEW_SKIP_STYLE = "new_skip_style";
        public static final String OPPO_SPLASH_BOTTOM_VIEW = "oppo_splash_bottom_view";
        public static final String container = "container";
    }
}
