package com.ubixnow.ooooo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class oOO00O0 {
    public static final String httpStatuException = "-9001";
    public static final String material_exception = "-1023";
    public static final String material_exception_msg = "catch里出现异常";
    public static final String material_isready_false = "-1022";
    public static final String material_isready_false_msg = "isReady false";
    public static final String material_problem = "-1024";
    public static final String material_problem_msg = "素材物料异常";
    public static final String need_init_code = "-1025";
    public static final String need_init_code_msg = "请先初始化SDK";
    public static final String networkError = "-9002";
    public static final String networkErrorMsg = "网络异常，请查看网络情况！";
    public static final String ubix_ad_imp_interval = "-1005";
    public static final String ubix_ad_imp_interval_msg = "当前广告位曝光太频繁";
    public static final String ubix_appIdorPlaceIdNull = "500302";
    public static final String ubix_appIdorPlaceIdNull_msg = "appid或 slotid 为空";
    public static final String ubix_bidding_filter_price = "-1008";
    public static final String ubix_bidding_filter_price_msg = "bidding 价格太低被过滤掉";
    public static final String ubix_cantShowIntertital = "-1020";
    public static final String ubix_cantShowIntertital_msg = "没有可用于展示的插屏广告";
    public static final String ubix_cantShowSplash = "-1013";
    public static final String ubix_cantShowSplash_msg = "没有可用于展示的开屏广告";
    public static final String ubix_context_native_exception_error = "-1019";
    public static final String ubix_context_native_exception_error_msg = "信息流由于异常被全部过滤";
    public static final String ubix_context_native_filter_error = "-1018";
    public static final String ubix_context_native_filter_error_msg = "信息流bidding被全部过滤";
    public static final String ubix_context_type_error = "-1019";
    public static final String ubix_context_type_error_msg = " context 不能转换为activity";
    public static final String ubix_filter = "-1006";
    public static final String ubix_filter_msg = "过滤全部的广告平台";
    public static final String ubix_img_check_material = "-1015";
    public static final String ubix_img_check_material_msg = "图片审核中";
    public static final String ubix_img_check_neterror = "-1017";
    public static final String ubix_img_check_neterror_msg = "素材审核接口异常";
    public static final String ubix_img_check_refuse = "-1018";
    public static final String ubix_img_check_refuse_msg = "素材审核不通过";
    public static final String ubix_img_check_video = "-1016";
    public static final String ubix_img_check_video_msg = "视频审核中";
    public static final String ubix_img_download_error = "-1014";
    public static final String ubix_img_download_error_msg = "图片下载失败";
    public static final String ubix_initError = "500041";
    public static final String ubix_initError_msg = "初始化失败 ";
    public static final String ubix_loadError_msg = "渲染方式不支持 ";
    public static final String ubix_no_ad = "-1000";
    public static final String ubix_no_ad_msg = "没有广告填充";
    public static final String ubix_no_ad_return_msg = "没有任何广告返回";
    public static final String ubix_no_adapter = "-1007";
    public static final String ubix_params_faile = "-9009";
    public static final String ubix_pbparse_error = "-9008";
    public static final String ubix_pbparse_error_msg = "pb 解析失败！";
    public static final String ubix_request_timeout_msg = "广告请求超时";
    public static final String ubix_return_error_msg = "广告超时返回广告发生异常";
    public static final String ubix_show_error = "-1001";
    public static final String ubix_show_error_msg = "展示失败";
    public static final String ubix_splash_show_error = "-1010";
    public static final String ubix_splash_show_error_msg = "show超时";
    public static final String ubix_timeout = "-1009";
    public static final String ubix_timeout_msg = "请求超时";
    public static final String ubix_videoshow_error_msg = "播放失败";
    public static final String unknowMsg = "发生未知异常";
    public static final String unknown = "-9000";

    public enum OooO00o {
        FILTER_WFTIMEOUT_IS0("-2000", "瀑布流中的单层超时时间为0"),
        FILTER_RENDER_TYPE("-2001", "开发者请求广告的渲染方式与服务端配置的不一致。"),
        FILTER_FREQUENT("-2002", "请求曝光太频繁，该请求被过滤"),
        FILTER_NOCONFIG("-2003", "没有配置"),
        ADS_RESPONSE_TIMEOUT("-2004", "广告源返回超时"),
        RENDER_TYPE_ERROR("-2005", "广告源渲染方式不匹配"),
        RENDER_FAIL("-500500", "渲染失败"),
        DATA_FAIL("-500400", "加载失败"),
        SHOW_ERROR("-1011", "广告无效，请检查广告是否加载成功"),
        MATERIAL_FILTER("-2006", "素材被过滤");

        private String OooOO0o;
        private String OooOOO0;

        OooO00o(String str, String str2) {
            this.OooOO0o = str;
            this.OooOOO0 = str2;
        }

        public String OooO00o() {
            return this.OooOO0o;
        }

        public String OooO0O0() {
            return this.OooOOO0;
        }
    }
}
