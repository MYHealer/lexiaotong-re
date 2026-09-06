package com.hihonor.dlinstall.ipc;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface Constants {

    public interface DetailPageDispatchType {
        public static final int TYPE_COMMERCIAL_BOTTOM = 5;
        public static final int TYPE_COMMERCIAL_MINI = 4;
        public static final int TYPE_FULL = 2;
        public static final int TYPE_HALF = 3;
    }

    public interface DetailPageType {
        public static final int FULL_SCREEN = 0;
        public static final int FULL_SCREEN_TRANSLUCENT_THEME = 2;
        public static final int HALF_SCREEN = 1;
    }

    public interface DownloadInstallBtnState {
        public static final int DEFAULT = 0;
        public static final int DOWNLOADING = 2;
        public static final int FINISH = 7;
        public static final int PAUSE = 4;
        public static final int WAITING = 1;
    }

    public interface DownloadType {
        public static final int AUTO = 3;
        public static final int MANUAL = 2;
        public static final int SILENT = 1;
    }

    public interface Errors {
        public static final int ERR_APP_SIGN_HASH_INVALID = 108;
        public static final int ERR_CANCELED = 400;
        public static final int ERR_CANCELED_DELETE = 401;
        public static final int ERR_CONNECT_ERROR = 109;
        public static final int ERR_FILEPATH_INVALID = 112;
        public static final int ERR_FILE_BUSY = 204;
        public static final int ERR_INSTALL_ALREADY_INSTALLED = 306;
        public static final int ERR_INSTALL_APK_FILE_INVALID = 309;
        public static final int ERR_INSTALL_FAIL = 301;
        public static final int ERR_INSTALL_NEW_FILE_INVALID = 305;
        public static final int ERR_INSTALL_NOT_INSTALLED = 307;
        public static final int ERR_INSTALL_NO_PERMISSION = 302;
        public static final int ERR_INSTALL_PATCH_FAIL = 304;
        public static final int ERR_INSTALL_PATCH_FILE_INVALID = 303;
        public static final int ERR_INSTALL_SESSION_INVALID = 310;
        public static final int ERR_INSTALL_SYSTEM_INSTALL_ABORTED = 314;
        public static final int ERR_INSTALL_SYSTEM_INSTALL_BLOCKED = 313;
        public static final int ERR_INSTALL_SYSTEM_INSTALL_CONFLICT = 316;
        public static final int ERR_INSTALL_SYSTEM_INSTALL_FAILURE = 312;
        public static final int ERR_INSTALL_SYSTEM_INSTALL_INCOMPATIBLE = 318;
        public static final int ERR_INSTALL_SYSTEM_INSTALL_INVALID = 315;
        public static final int ERR_INSTALL_SYSTEM_INSTALL_STORAGE = 317;
        public static final int ERR_INSTALL_VERSION_NOT_MATCHED = 308;
        public static final int ERR_INSTALL_WAIT_INSTALL_RESULT_TIMEOUT = 311;
        public static final int ERR_LATEST_VERSION = 111;
        public static final int ERR_MAX_RETRY = 206;
        public static final int ERR_MODE_BASIC = 501;
        public static final int ERR_MODE_KID = 500;
        public static final int ERR_NO_DATA = 10005;
        public static final int ERR_NO_ENOUGH_SPACE = 105;
        public static final int ERR_NO_INSTALL = 205;
        public static final int ERR_NO_NETWORK = 10003;
        public static final int ERR_NO_PERMISSION = 10004;
        public static final int ERR_NO_SUPPORT = 10006;
        public static final int ERR_PARAMETER_INVALID = 101;
        public static final int ERR_SDCARD_LOST = 106;
        public static final int ERR_SERVICE_UNAVAILABLE = 10001;
        public static final int ERR_UNKNOWN = -1;
        public static final int ERR_URL_INVALID = 110;
        public static final int ERR_USER_NOT_AGREE_PRIVACY_STATEMENT = 10002;
    }

    public interface LauncherInstallType {
        public static final int TYPE_CLONE = 2;
        public static final int TYPE_DEFAULT = 0;
        public static final int TYPE_HOT_RECOMMEND = 1;
    }

    public interface MarketType {
        public static final int BASIC_MODE = 1;
        public static final int KID_MODE = 2;
        public static final int NORMAL_MODE = 0;
    }

    public interface PageType {
        public static final int TRAFFIC_DOWNLOAD = 1;
    }

    public interface TaskType {
        public static final int DEFAULT = 0;
        public static final int SILENT_UPDATE = 1;
    }

    public interface WaitingState {
        public static final int QUEUE = 0;
        public static final int WIFI = 1;
    }
}
