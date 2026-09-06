package com.adprof.sdk.api;

import client.android.yixiaotong.v3.comman.AppTypeIdUtil;
import com.baidu.oauth.sdkbqt.result.OauthResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum AdError {
    ERROR_AD_NOT_INIT(100, "sdk未初始化"),
    ERROR_AD_INIT_FAIL(101, "sdk初始化失败"),
    ERROR_AD_CODE_ID_EMPTY(102, "广告位ID为空"),
    ERROR_AD_LOAD_TIMEOUT(103, "广告加载超时"),
    ERROR_AD_LOAD_FAIL_LOADING(104, "广告正在加载中,请稍后再加载"),
    ERROR_AD_REQUEST(105, "广告请求出错"),
    ERROR_AD_NETWORK(106, OauthResult.RESULT_MSG_NETWORK_EXCEPTION),
    ERROR_AD_FILE_DOWNLOAD(107, "广告资源文件下载错误"),
    ERROR_AD_BAD_REQUEST(108, "内部错误，请联系运营或技术人员"),
    ERROR_AD_INFORMATION_LOSE(109, "server下发的广告缺失关键信息"),
    ERROR_AD_PLAY(110, "广告播放出错"),
    ERROR_AD_VIDEO_PLAY_FAIL(111, "广告视频播放出错"),
    ERROR_AD_NOT_READY(112, "广告未ready"),
    ERROR_AD_EXPIRED(100307, "广告已过有效期"),
    ERROR_AD_CONTAINER_IS_NULL(113, "广告容器不能为null"),
    ERROR_AD_CONTAINER_NOT_VIEW_GROUP(114, "广告容器只允许为ViewGroup类型"),
    ERROR_AD_ACTIVITY_IS_NULL(115, "广告Activity不能为null"),
    ERROR_AD_CONTAINER_VISIBILITY(116, "广告容器展示异常"),
    ERROR_FEEDBACK(100400, "反馈异常"),
    ERROR_MACRO(100500, "宏替换异常"),
    ERROR_REQUEST_UNKNOWN(AppTypeIdUtil.Drink4GCostControl_1, "程序异常！"),
    ERROR_REQUEST_NO_NETWORK(118, "广告请求失败，请检查网络是否连接！"),
    ERROR_AD_FREQUENCY(119, "不满足频控"),
    ERROR_REQUEST_AD_EMPTY(400006, "广告素材请求失败，没有合适的广告！"),
    ERROR_NO_AD(120, "无广告填充"),
    ERROR_SERVER_ADS_EMPTY(121, "服务端返回的 ads 字段为空"),
    ERROR_SERVER_DATA_EMPTY(AppTypeIdUtil.NewDevice4GBathOTA, "服务端返回的 data 为空"),
    ERROR_REQUEST_EXCEPTION(AppTypeIdUtil.NewDevice4GDrinkOTA_1, "请求广告时发生异常"),
    ERROR_RESPONSE_CODE_NOT_0(AppTypeIdUtil.NewDevice4GDrinkOTA_2, "respondBean.code 不为 0 "),
    ERROR_RESPONSE_PRICE_REASON(126, "price reason"),
    ERROR_NATIVE_SHOW_NOT_HALF_SCREEN(127, " 广告展示的宽度 需要 大于 屏幕宽度 的一半");


    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f43a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f44a;

    AdError(int i, String str) {
        this.f43a = i;
        this.f44a = str;
    }

    public static AdError getAdError(int i) {
        for (AdError adError : values()) {
            if (adError.getErrorCode() == i) {
                return adError;
            }
        }
        return null;
    }

    public int getErrorCode() {
        return this.f43a;
    }

    public String getMessage() {
        return this.f44a;
    }

    public void setErrorMessage(int i, String str) {
        this.f43a = i;
        this.f44a = str;
    }

    public void setMessage(String str) {
        this.f44a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return String.format("{ \"error_code\":%d, \"message\": %s }", Integer.valueOf(this.f43a), this.f44a);
    }
}
