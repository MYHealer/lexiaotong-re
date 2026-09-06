package com.fancy.adsdk.lib.constants;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgErrorCode {
    public static final String ILLEGAL_PATH = "404 not found";
    public static final String ILLEGAL_REQUEST = "400 无效的请求";
    public static final String ILLEGAL_SERVER = "502 Bad Gateway";
    public static final int LOAD_AD_SUC = 0;
    public static final String PACKAGE_NAME_ERROR_STR = "包名校验失败，请检查包名！";
    public static final int SDK_AD_DATA_ERR = 10002;
    public static final int SDK_AD_SLOT_ERR = 10010;
    public static final int SDK_AD_STYLE_ERR = 10027;
    public static final int SDK_BELOW_BASE_PRICE = 10026;
    public static final String SDK_BELOW_BASE_PRICE_STR = "广告价格低于底价！";
    public static final int SDK_CLICK_ERR = 60001;
    public static final String SDK_CLICK_ERR_MSG1 = "不支持的点击类型！";
    public static final int SDK_DP_PERMISSION_PROHIBIT = 50013;
    public static final int SDK_FORBID_AD = 10001;
    public static final int SDK_INIT = 10007;
    public static final String SDK_INIT_1 = "消耗源未初始化";
    public static final int SDK_INTERNAL = 10019;
    public static final int SDK_INTERNAL_ERROR = 10019;
    public static final String SDK_INTERNAL_ERR_MSG1 = "当前网络异常！";
    public static final int SDK_NET_ERR = 10005;
    public static final int SDK_NOT_READY = 10007;
    public static final int SDK_NOT_SUPPORT = 10044;
    public static final int SDK_NO_AD = 10001;
    public static final String SDK_NO_AD_1 = "无广告！";
    public static final String SDK_NO_AD_2 = "请求成功，无广告！";
    public static final int SDK_NO_MATCHED_POLICY = 10019;
    public static final int SDK_NULL_COEDID = 10008;
    public static final int SDK_NULL_PROVIDER = 10013;
    public static final int SDK_PARAM_ERR = 10003;
    public static final int SDK_RENDER_ERROR = 10016;
    public static final String SDK_RENDER_ERROR_1 = "渲染失败！";
    public static final String SDK_RENDER_ERROR_10 = "webview加载失败，请检查网络或稍后重试！";
    public static final String SDK_RENDER_ERROR_2 = "媒体传入广告容器异常！";
    public static final String SDK_RENDER_ERROR_3 = "消耗源广告视图异常！";
    public static final String SDK_RENDER_ERROR_4 = "消耗源广告对象异常！";
    public static final String SDK_RENDER_ERROR_5 = "广告资源已过期！请获取最新广告资源。";
    public static final String SDK_RENDER_ERROR_6 = "广告数据为空，请联系平台处理！";
    public static final String SDK_RENDER_ERROR_7 = "广告位类型不合法，请联系平台处理！";
    public static final String SDK_RENDER_ERROR_8 = "广告样式不合法，请联系平台处理！";
    public static final String SDK_RENDER_ERROR_9 = "广告布局异常，请重试！";
    public static final int SDK_REQUEST_INTERRUPT_BECAUSE_PARAMS_MISS = 10010;
    public static final int SDK_REQUEST_OVER_TIME = 10045;
    public static final int SDK_RESOURCE_ERROR = 10017;
    public static final String SDK_RESOURCE_ERR_MSG1 = "资源数据异常！";
    public static final String SDK_RESOURCE_ERR_MSG2 = "资源检测异常！";
    public static final String SDK_RESOURCE_ERR_MSG3 = "广告资源异常！";
    public static final int SDK_SPLASH_SINGLE_ERROR = 10014;
    public static final int SDK_TIMEOUT = 10004;
    public static final int SDK_UNKNOWN = 10011;
    public static final int SDK_VIDEO_PLAY_ERROR = 10018;
    public static final int WHAT_NO_SUPPORT = 10;
    public static final int WHERE_LOAD = 8;
    public static final int WHO_APP = 10003;
    public static final int WHO_SLOT = 102;

    public static String AD_DATA_ERROR() {
        return "广告数据为空！";
    }

    public static String AD_OBJ_ERROR() {
        return "广告对象为空！";
    }

    public static String AD_SLOT_ERROR() {
        return "广告Slot为空！";
    }

    public static String AD_STYLE_ERROR() {
        return SDK_RENDER_ERROR_8;
    }

    public static String AD_STYLE_ERROR_DEBUG() {
        return "广告样式(%s,%s,%s)不合法，请联系平台处理！";
    }

    public static String APP_NETWORK_ERROR() {
        return "网络异常!";
    }

    public static String APP_SLOT_ERROR() {
        return "slotId 或 apiId 不能为空!";
    }
}
