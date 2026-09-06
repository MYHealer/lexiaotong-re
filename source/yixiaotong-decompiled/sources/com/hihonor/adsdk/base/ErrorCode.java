package com.hihonor.adsdk.base;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface ErrorCode {
    public static final int AD_ADAPTER_IS_NULL = 31002;
    public static final int AD_APP_KEY_EMPTY = 30008;
    public static final int AD_APP_RESERVE_FAIL_CODE = 1022;
    public static final String AD_APP_RESERVE_FAIL_MSG = "预约失败";
    public static final int AD_BID_FAILED = 30076;

    @Deprecated
    public static final int AD_BIND_VIEW = 30062;
    public static final int AD_BIND_VIEW_ERR = 30063;
    public static final int AD_CODE_BUNDLE_PARAM_NO_MATCH = 30092;
    public static final int AD_CODE_DELETE_TRACK_BUT_DAO_IS_NULL = 30151;
    public static final int AD_CODE_DELETE_TRACK_ERROR = 30145;
    public static final int AD_CODE_INSERT_BATCH_TRACK_ERROR = 30149;
    public static final int AD_CODE_PAGE_FINISHED = 30103;
    public static final int AD_CODE_QUERY_BATCH_TRACK_ERROR = 30148;
    public static final int AD_CODE_SDK_INIT_FAIL = 30091;
    public static final int AD_CODE_START_ACTIVITY_CONTEXT_NULL = 30101;
    public static final int AD_CODE_START_ACTIVITY_EXCEPTION = 30102;
    public static final int AD_CODE_START_ACTIVITY_FAILED = 30100;
    public static final int AD_CODE_UPDATE_FAIL_COUNT_BUT_DAO_IS_NULL = 30146;
    public static final int AD_CODE_UPDATE_FAIL_COUNT_ERROR = 30147;
    public static final int AD_COMMON_WEB_VIEW_IS_NULL = 30124;
    public static final int AD_CRASH_CODE = 30088;
    public static final int AD_CREATE_ADAPTER_ERROR = 31004;
    public static final int AD_DATA_ERR_APP_NAME = 30086;
    public static final int AD_DATA_ERR_PACK_NAME = 30085;
    public static final int AD_DEEP_LINK_WEB_VIEW_INIT_FAIL = 30022;
    public static final int AD_DISLIKE_SHOW = 30104;
    public static final int AD_DISLIKE_SHOW_EXCEPTION = 30133;

    @Deprecated
    public static final int AD_DNS_LOCAL_FAILURE = 30097;
    public static final int AD_DNS_PARSE_FAILURE = 30112;
    public static final int AD_DNS_PARSE_SUCCEED = 30111;

    @Deprecated
    public static final int AD_DNS_REQUEST_FAILURE = 30098;
    public static final int AD_DNS_TENCENT_NO_DEPENDENCY = 30096;
    public static final int AD_DOWN_CODE_CLIENT_IS_NOT_WHITELIST = 3103;
    public static final int AD_DOWN_CODE_CLIENT_IS_NULL = 30031;
    public static final int AD_DOWN_CODE_CLIENT_UN_CONNECTED = 30032;
    public static final int AD_DOWN_CODE_MARKET_CLIENT_UN_CONNECTED = 30093;
    public static final int AD_DOWN_LOAD_BUTTON_CLICK = 30023;
    public static final int AD_DOWN_LOAD_CANCEL = 30021;
    public static final int AD_DOWN_LOAD_MARKET_VERSION_SUPPORT_NO = 30090;
    public static final int AD_EXCEPTION_FILTERED = 30080;
    public static final String AD_EXCEPTION_FILTERED_MESSAGE = "ResFilterBean is null by adDataFiltered end. Normally does not appear";
    public static final int AD_EXCESS_COUNT_UN_EXPOSURE = 30079;
    public static final String AD_EXCESS_COUNT_UN_EXPOSURE_MESSAGE = "Excess ad exposure failed. ";
    public static final int AD_HTTP_EXCEPTION_chain_NULL = 30143;
    public static final int AD_INSTALL_FAIL = 30015;
    public static final int AD_INTERSTITIAL_VIDEO_TIME_OUT = 30089;

    @Deprecated
    public static final int AD_LANDING_PAGE_URL_IS_NULL = 30039;
    public static final int AD_LOADED_LISTENER_IS_NULL = 31001;
    public static final int AD_LOADING_EXCESS_EXPOSURE = 30014;
    public static final int AD_LOADING_TIME_OUT = 30013;
    public static final int AD_MARKET_DETAIL_START_FAIL = 30122;
    public static final int AD_MEDIA_DISABLE = 30007;
    public static final int AD_MESSAGE_ERR_AD_UNIT_NULL = 30105;
    public static final int AD_MESSAGE_ERR_INTENT_NULL = 30106;
    public static final int AD_MMS_CHANNEL_INFO_BIND_ERROR = 30117;
    public static final String AD_MMS_CHANNEL_INFO_BIND_ERROR_MSG = "bind service error.";
    public static final int AD_MMS_CHANNEL_INFO_BIND_FAIL = 30116;
    public static final String AD_MMS_CHANNEL_INFO_BIND_FAIL_MSG = "bind service fail.";
    public static final int AD_MMS_CHANNEL_INFO_FAIL = 30113;
    public static final int AD_MMS_CHANNEL_INFO_FAIL_BINDER_NULL = 30114;
    public static final String AD_MMS_CHANNEL_INFO_FAIL_BINDER_NULL_MSG = "get channel info fail.cause by binder is null";
    public static final int AD_MMS_CHANNEL_INFO_FAIL_CONTEXT_NULL = 30115;
    public static final String AD_MMS_CHANNEL_INFO_FAIL_CONTEXT_NULL_MSG = "channel info fail. connect before context is null.";
    public static final String AD_MMS_CHANNEL_INFO_FAIL_MSG = "get channel info success, but channel info is null or empty.";
    public static final int AD_MMS_CURSOR_FAIL = 30109;
    public static final String AD_MMS_CURSOR_FAIL_MSG = "mms cursor is null.";
    public static final int AD_MMS_GET_CHANNEL_INFO_REMOTE_ERROR = 30118;
    public static final String AD_MMS_GET_CHANNEL_INFO_REMOTE_ERROR_MSG = "call get channel info remote error. ";
    public static final int AD_MMS_QUERY_FAIL = 30110;
    public static final String AD_MMS_QUERY_FAIL_MSG = "mms query is exception.";
    public static final int AD_MMS_SEC_INFO_FAIL = 30108;
    public static final String AD_MMS_SEC_INFO_FAIL_MSG = "sec info is null or empty.";
    public static final int AD_NOTIFY_POPUP_WINDOW_DIS = 30120;
    public static final int AD_NOTIFY_POPUP_WINDOW_DIS_NULL = 30119;
    public static final int AD_NOTIFY_POPUP_WINDOW_SHOW_EXCEPTION = 30121;
    public static final int AD_NULL_AD = 30040;
    public static final int AD_NULL_DOWN = 30019;
    public static final int AD_OAID_INFO_NULL = 30035;
    public static final int AD_OPEN_ERROR = 30074;
    public static final int AD_PACK_UN_INSTALLED = 30066;
    public static final int AD_RECOVER_SYS_APP_ERR = 30070;
    public static final int AD_REGISTER_SENSOR_ERR = 30132;
    public static final int AD_RENDER_FAIL = 31003;
    public static final int AD_RESOURCE_REQUEST_LOADING_TIME_OUT = 30075;
    public static final String AD_REWARD_CLICK_PUBLISH_FAIL_MSG = "click reward no hnRewardListener";
    public static final String AD_REWARD_DOWNLOAD_PUBLISH_FAIL_MSG = "download reward no hnRewardListener";
    public static final int AD_REWARD_NO_CALL_MEDIA = 30065;
    public static final int AD_REWARD_PUBLISH_FAIL = 30107;
    public static final int AD_SHOW_FAIL_REWARD = 30094;
    public static final int AD_SLOT_ID_EMPTY = 30004;
    public static final int AD_SLOT_NONE = 30003;
    public static final int AD_SUB_TYPE_DEFAULT = 30041;
    public static final int AD_TEMPLATE_BEYOND_ERR_CODE = 30144;
    public static final int AD_TRACK_DB_ERR = 30069;
    public static final int AD_UN_SUPPORT_MOBILE_NET_DOWNLOAD = 30034;
    public static final int AD_UTIL_GSON_ERR = 30064;
    public static final int AD_VIDEO_RELEASE_BEFORE_PLAY = 30131;
    public static final int AD_VIEW_RELEASE_BUT_WITHOUT_EXPOSURE = 30087;
    public static final int AD_VIEW_SET_AD_FAIL = 30067;
    public static final int AD_WEB_DETAIL_URL_NULL = 30095;
    public static final int AD_WEB_MARKET_ERROR = 30073;
    public static final int AD_WEB_SSL_ERR = 31005;
    public static final int BID_RESULT_EMPTY = 30078;
    public static final int DB_CACHE_AD_NORMAL = 30081;
    public static final int DB_CACHE_AD_NULL = 30050;
    public static final int DB_CACHE_DEL_EXCEPTION = 30049;
    public static final int DB_CACHE_GET_EXCEPTION = 30051;
    public static final int DB_CACHE_INFO_DONE = 30047;
    public static final int DB_CACHE_INFO_ERROR = 30045;
    public static final int DB_CACHE_INFO_EXCEPTION = 30046;
    public static final int DB_CACHE_INSERT_EXCEPTION = 30048;
    public static final int DB_CREATE_ERROR = 30042;
    public static final int DB_UPDATE_ERROR = 30043;
    public static final int DELETE_EXPIRED_CACHE_AD_DATA = 30083;
    public static final int DELETE_ON_IMPRESSION_CACHE_AD_DATA = 30084;
    public static final int ENVIRONMENT_ERROR = 30044;
    public static final String ENVIRONMENT_NOT_SUP = "ad load but not support by environment";
    public static final int EXCEPTION_ERR_CODE = 30140;
    public static final String EXCEPTION_ERR_CODE_MSG = "Exception.";
    public static final String EXCESS_EXPOSURE_MESSAGE = "The backend returns an ad that exceeds the media settings";
    public static final int EX_INTERSTITIAL_AD_NULL = 30068;
    public static final int EX_VIDEO_ABNORMAL = 30055;
    public static final int EX_VIDEO_ADAPTER_NULL = 30057;
    public static final int EX_VIDEO_REWARD_AD_NULL = 30056;
    public static final int GAME_RESERVE_RESULT_ERR_CODE = 30142;
    public static final String GAME_RESERVE_RESULT_ERR_MSG = "GameReserveResult is null.";
    public static final int GET_LOCATION_MANAGER_ERR_CODE = 30134;
    public static final String GET_LOCATION_MANAGER__ERR_MSG = "get location manager exception: ";
    public static final int GLIDE_EXCEPTION_ACTIVITY_IS_DESTROYED = 30082;
    public static final String GLIDE_EXCEPTION_ACTIVITY_IS_DESTROYED_MSG = "glide load image exception, activity is destroyed";
    public static final int HI_AD_EMPTY_BY_FILTER = 30012;
    public static final int HI_AD_INTERSTITIAL_VIEW_INVALID = 30072;
    public static final int HI_AD_PACK_INSTALLED = 30011;
    public static final int HI_AD_TYPE_MISMATCH = 30010;
    public static final int HI_AD_VIDEO_INVALID = 30071;
    public static final int HI_AD_VIEW_ADD_TIME_OUT = 30009;
    public static final int HI_APP_PACK_REPEATED = 30099;
    public static final int INIT_ERROR = 30001;
    public static final int MEDIA_UN_USE_AD = 30036;
    public static final String MSG_AD_COMMON_WEB_VIEW_IS_NULL = "webView is null";
    public static final String MSG_REGISTER_SENSOR_ERR = "register sensor but has err:";
    public static final String MSG_REPORT_GLIDE_LOAD_EXCEPTION = "glide load has exception:";
    public static final String MSG_REPORT_GLIDE_URL_EMPTY = "glide preload but checkUrlIsEmpty.";
    public static final String MSG_REPORT_URL_FAIL_MAX_COUNT = "Report tracking url fail more than max count";
    public static final String MSG_VIDEO_RELEASE_BEFORE_PLAY = "video buffer error.";
    public static final String MSG_WEB_BASE_AD_IS_NULL = "web baseAd is null";
    public static final String MSG_WEB_CURRENT_LOAD_URL_IS_NULL = "web currentLoadUrl is empty";
    public static final String MSG_WEB_LAYOUT_CONTAINER_IS_NULL = "mWebViewReportControl is null";
    public static final int NETWORK_UNAVAILABLE_ERR_CODE = 30139;
    public static final String NETWORK_UNAVAILABLE_ERR_CODE_MSG = "NetWork Unavailable.";
    public static final int NOT_INIT = 30002;
    public static final int NOT_NETWORK = 1012;
    public static final String NOT_NETWORK_MSG = "The network may appear as error, or you are not connected to the network. Please check the network and try again.";
    public static final int NO_SUCCESS_INSTANCE = 30077;
    public static final int REMOVE_LOCATION_ERR_CODE = 30136;
    public static final String REMOVE_LOCATION_ERR_MSG = "remove geolocation updates exception: ";
    public static final String REPORT_AD_DEEP_LINK_WEB_VIEW_INIT_FAIL = "AD Deeplink initViews but  new WebView err ";
    public static final String REPORT_AD_DOWN_LOAD_BUTTON_CLICK = "AD download or recover start";
    public static final String REPORT_AD_DOWN_LOAD_CANCEL = "AD pack app down cancel, by ";
    public static final String REPORT_AD_EMPTY_BY_FILTER = "AD filter by SDK, ad list is empty.";
    public static final String REPORT_AD_INSTALL_FAIL = "AD install fail by Pre-installed apps";
    public static final String REPORT_AD_INTERSTITIAL_VIEW_INVALID = "ViewStub is nll";

    @Deprecated
    public static final String REPORT_AD_LANDING_PAGE_URL_IS_NULL = "landingPageUrl is null";
    public static final String REPORT_AD_NULL_AD = "ad is null , by detachedFromWindow .";
    public static final String REPORT_AD_NULL_DOWN = "reportByStatus but ad is null.";
    public static final String REPORT_AD_PACK_HI_AD_PACK_INSTALLED = "AD filter by package client";
    public static final String REPORT_AD_PACK_HI_AD_PACK_SLOT = "AD filter by installed or unInstalled, need the ad promotion purpose.";
    public static final String REPORT_AD_SUB_TYPE_DEFAULT = "ad subType not support ";
    public static final String REPORT_AD_TYPE_MISMATCH = "AD type mismatch";
    public static final String REPORT_AD_VIDEO_INVALID = "AD video is invalid";
    public static final String REPORT_AD_VIEW_ADD_TIME_OUT_MSG = "Ad rendered, but add page timeout.";
    public static final String REPORT_APP_PACK_HI_APP_PACK_REPEATED = "App filter by Repeating with ad";
    public static final int REPORT_GLIDE_LOAD_EXCEPTION = 30128;
    public static final int REPORT_GLIDE_PRELOAD_EXCEPTION = 30129;
    public static final int REPORT_GLIDE_URL_EMPTY = 30130;
    public static final int REPORT_URL_FAIL_MAX_COUNT = 30127;
    public static final int REQUEST_LOCATION_ERR_CODE = 30135;
    public static final String REQUEST_LOCATION_ERR_MSG = "request geolocation exception: ";
    public static final int RESERVATIONS_ERR_CODE = 30137;
    public static final String RESERVATIONS_ERR_CODE_MSG = "reservations is null or empty.";
    public static final int RESERVATION_ERR_CODE = 30138;
    public static final String RESERVATION_ERR_CODE_MSG = "reservation is null or empty.";
    public static final int RESPONSE_DATA_EMPTY = 30005;
    public static final int RESPONSE_FAIL = 30006;

    @Deprecated
    public static final int SDK_STATUES_FALSE = 30038;

    @Deprecated
    public static final int SDK_STATUES_LIMIT_FALSE = 30037;
    public static final String STR_AD_BIND_VIEW = "AD bind to view.";
    public static final String STR_AD_BIND_VIEW_ERR = "AD bind to view，but has err.";
    public static final String STR_AD_DISLIKE_SHOW = "ad DislikePopupWindow is show.";
    public static final String STR_AD_DISLIKE_SHOW_EXCEPTION = "dislike popup window show, but there has exception:";
    public static final String STR_AD_DNS_TENCENT_NO_DEPENDENCY = "No dependency on TencentDns.";
    public static final String STR_AD_HTTP_EXCEPTION_chain_NULL = "chain is null.";
    public static final String STR_AD_INTERSTITIAL_VIDEO_TIME_OUT = "interstitial ad, video play time out, times is :";
    public static final String STR_AD_MARKET_DETAIL_START_FAIL = "notify popup window show, but there has exception:";
    public static final String STR_AD_NOTIFY_POPUP_WINDOW_DIS = "media call dismissNotifyPopupWindow. ";
    public static final String STR_AD_NOTIFY_POPUP_WINDOW_SHOW_EXCEPTION = "notify popup window show, but there has exception:";
    public static final String STR_AD_PACK_UN_INSTALLED = "AD filter by package unInstalled";
    public static final String STR_AD_RECOVER_SYS_APP_ERR = "recoverSysApp,fail.";
    public static final String STR_AD_TEMPLATE_BEYOND_ERR_MSG = "ad template beyond or null";
    public static final String STR_AD_TRACK_DB_ERR = "happen some err, when Track report";
    public static final String STR_AD_UTIL_GSON_ERR = "AD use gson has Exception.";
    public static final String STR_AD_VIEW_SET_AD_FAIL = "ad view set BaseAd fail.";
    public static final String STR_AD_WEB_DETAIL_URL_NULL = "web detail loadSuccess but url is null";
    public static final String STR_AD_WEB_MARKET_CONTEXT_ERROR = "start web, but has context error.";
    public static final String STR_AD_WEB_MARKET_ERROR = "start web, but has error.";
    public static final String STR_BID_FAILED = "The backend returns an ad that bid failed";
    public static final String STR_BID_RESULT_EMPTY = "after bid,result is empty";
    public static final String STR_DB_CACHE_AD_NORMAL = "db getAdData, ad is normal. return to media";
    public static final String STR_DB_CACHE_AD_NULL = "db getAdData, but ad is null.";
    public static final String STR_DB_CACHE_DEL_EXCEPTION = "db delAdData, but has Exception.";
    public static final String STR_DB_CACHE_GET_EXCEPTION = "db getAdData, but has Exception.";
    public static final String STR_DB_CACHE_INFO_DONE = "db saveAdData done.";
    public static final String STR_DB_CACHE_INFO_ERROR = "db saveAdData, but baseAdInfo is null or list ls isEmpty.";
    public static final String STR_DB_CACHE_INFO_EXCEPTION = "db saveAdData, but has Exception.";
    public static final String STR_DB_CACHE_INSERT_EXCEPTION = "db insert result < 0.";
    public static final String STR_EX_INTERSTITIAL_AD_LISTENER_NULL = "Open InterstitialActivity, but ad Listener is null.";
    public static final String STR_EX_INTERSTITIAL_AD_NULL = "Open InterstitialActivity, but ad is null.";
    public static final String STR_EX_VIDEO_ABNORMAL = "parameter abnormal when need report.";
    public static final String STR_EX_VIDEO_ABNORMAL_THE = "has exceptionally.";
    public static final String STR_EX_VIDEO_ADAPTER_NULL = "start play, but none adapter.";
    public static final String STR_EX_VIDEO_REWARD_AD_LISTENER_NULL = "Open RewardActivity, but ad Listener is null.";
    public static final String STR_EX_VIDEO_REWARD_AD_NULL = "Open RewardActivity, but ad is null.";
    public static final String STR_EX_VIDEO_REWARD_AD_VIDEO_NULL = "Open RewardActivity, but video is null.";
    public static final String STR_NO_SUCCESS_INSTANCE = "no success instance";
    public static final String STR_OPEN_ACTIVITY = "start app, but has error.";
    public static final int SUB_HANDLER_GET_EXCEPTION = 30152;
    public static final int SUCCESS = 0;
    public static final String SUCCESS_MSG = "success";
    public static final int WEB_BASE_AD_IS_NULL = 30125;
    public static final int WEB_CURRENT_LOAD_URL_IS_NULL = 30126;
    public static final int WEB_LAYOUT_CONTAINER_IS_NULL = 30123;

    public interface a {
        public static final int hnadsa = -1;
        public static final int hnadsb = 0;
        public static final int hnadsc = 1;
        public static final int hnadsd = 0;
        public static final int hnadse = 1;
    }

    public interface b {
        public static final int hnadsa = -1;
        public static final int hnadsb = 1000;
        public static final int hnadsc = 1001;
        public static final int hnadsd = 1002;
        public static final int hnadse = 1003;
        public static final int hnadsf = 1004;
        public static final int hnadsg = 1005;
        public static final int hnadsh = 1006;
        public static final int hnadsi = 1007;
        public static final int hnadsj = 1008;
        public static final int hnadsk = 1009;
        public static final int hnadsl = 1010;
        public static final int hnadsm = 1011;
        public static final int hnadsn = 1012;
        public static final int hnadso = 1013;
        public static final int hnadsp = 1014;
    }

    public interface c {
        public static final int hnadsa = 30024;
        public static final String hnadsb = "start deeplink fail";
        public static final String hnadsc = "deepLink is empty";
        public static final int hnadsd = 30025;
        public static final int hnadse = 30026;
        public static final String hnadsf = "Ad rendered,but on detached from window not add to page";
        public static final int hnadsg = 30027;
        public static final int hnadsh = 30028;
        public static final int hnadsi = 30029;
        public static final String hnadsj = "Ad filter data, but downloadInstallClient not support";
        public static final int hnadsk = 30030;
        public static final String hnadsl = "Ad filter data, but current media not has permissions";
    }

    public interface d {
        public static final int hnadsa = 100001;
        public static final String hnadsb = "report fail. ";
        public static final int hnadsc = 100002;
        public static final String hnadsd = "report before fail. ";
        public static final int hnadse = 100003;
        public static final String hnadsf = "report url is empty";
        public static final int hnadsg = 100004;
        public static final String hnadsh = "report fail max limit";
        public static final int hnadsi = 100005;
        public static final int hnadsj = 100006;
        public static final int hnadsk = 100007;
        public static final String hnadsl = "get LandingPageUrl() is null when startWebDetailPage";
    }
}
