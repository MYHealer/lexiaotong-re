package com.yfanads.android.model;

import android.text.TextUtils;
import com.google.common.base.Ascii;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.yfanads.android.db.e;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class YFAdError {
    public static final String ERROR_ADX_EXPOSURE = "9926";
    public static final String ERROR_ADX_REPLENISH_EXPOSURE = "15007";
    public static final String ERROR_BAIXUN_CONTEXT = "9928";

    @Deprecated
    public static final String ERROR_BD_FAILED = "9911";

    @Deprecated
    public static final String ERROR_BD_NO_TYPE = "99142";
    public static final String ERROR_CSJ_CONTEXT = "9924";
    public static final String ERROR_DATA_NULL = "9901";
    public static final String ERROR_DEFAULT = "99";
    public static final String ERROR_EMPTY = "1006";
    public static final String ERROR_EXCEPTION_LOAD = "9902";
    public static final String ERROR_EXCEPTION_RENDER = "9904";
    public static final String ERROR_EXCEPTION_SHOW = "9903";
    public static final String ERROR_INIT_FAILED = "9916";
    public static final String ERROR_INTER_SHOW_FAILED = "9908";
    public static final String ERROR_JINDAI_CONTEXT = "9929";

    @Deprecated
    public static final String ERROR_KS_NO_TYPE = "99141";
    public static final String ERROR_MEISHU_CONTEXT = "9930";

    @Deprecated
    public static final String ERROR_NATIVE = "9920";
    public static final String ERROR_NET_ERROR = "1001";
    public static final String ERROR_NET_TIMEOUT = "1004";
    public static final String ERROR_NONE_SDK = "9905";

    @Deprecated
    public static final String ERROR_NONE_STRATEGY = "9907";
    public static final String ERROR_OPPO_CONTEXT = "9922";
    public static final String ERROR_OVER_DAY = "1008";
    public static final String ERROR_OVER_HOUR = "1007";
    public static final String ERROR_OVER_NUM = "1009";

    @Deprecated
    public static final String ERROR_RENDER_FAILED = "9915";
    public static final String ERROR_SHOP_MALL_SHOW_FAILED = "9909";
    public static final String ERROR_SUPPLIER_SELECT = "9906";

    @Deprecated
    public static final String ERROR_TANX_CONTEXT = "9925";
    public static final String ERROR_TOTAL_TIMEOUT = "1005";
    public static final String ERROR_VIVO_CONTEXT = "9923";
    public static final String ERROR_YLH_CONTEXT = "9921";
    public static final String REWARD_SERVER_FAIL = "9927";
    public String code;
    public String msg;

    public YFAdError(String str, String str2) {
        this.code = str;
        this.msg = str2;
    }

    public static YFAdError parseErr(int i) {
        return parseErr(i + "");
    }

    public String toString() {
        return "eCode = " + this.code + " , msg = " + this.msg;
    }

    public static YFAdError parseErr(String str) {
        return parseErr(str, "");
    }

    public static YFAdError parseErr(int i, String str) {
        return parseErr(i + "", str);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static YFAdError parseErr(String str, String str2) {
        str.getClass();
        str.hashCode();
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case 1507424:
                if (str.equals("1001")) {
                    b = 0;
                }
                break;
            case 1507427:
                if (str.equals("1004")) {
                    b = 1;
                }
                break;
            case 1507428:
                if (str.equals("1005")) {
                    b = 2;
                }
                break;
            case 1507429:
                if (str.equals(ERROR_EMPTY)) {
                    b = 3;
                }
                break;
            case 1507430:
                if (str.equals(ERROR_OVER_HOUR)) {
                    b = 4;
                }
                break;
            case 1507431:
                if (str.equals(ERROR_OVER_DAY)) {
                    b = 5;
                }
                break;
            case 1507432:
                if (str.equals(ERROR_OVER_NUM)) {
                    b = 6;
                }
                break;
            case 1754401:
                if (str.equals(ERROR_DATA_NULL)) {
                    b = 7;
                }
                break;
            case 1754402:
                if (str.equals(ERROR_EXCEPTION_LOAD)) {
                    b = 8;
                }
                break;
            case 1754403:
                if (str.equals(ERROR_EXCEPTION_SHOW)) {
                    b = 9;
                }
                break;
            case 1754404:
                if (str.equals(ERROR_EXCEPTION_RENDER)) {
                    b = 10;
                }
                break;
            case 1754405:
                if (str.equals(ERROR_NONE_SDK)) {
                    b = 11;
                }
                break;
            case 1754406:
                if (str.equals(ERROR_SUPPLIER_SELECT)) {
                    b = 12;
                }
                break;
            case 1754407:
                if (str.equals(ERROR_NONE_STRATEGY)) {
                    b = 13;
                }
                break;
            case 1754432:
                if (str.equals(ERROR_BD_FAILED)) {
                    b = 14;
                }
                break;
            case 1754436:
                if (str.equals(ERROR_RENDER_FAILED)) {
                    b = 15;
                }
                break;
            case 1754437:
                if (str.equals(ERROR_INIT_FAILED)) {
                    b = 16;
                }
                break;
            case 1754462:
                if (str.equals(ERROR_NATIVE)) {
                    b = 17;
                }
                break;
            case 1754463:
                if (str.equals(ERROR_YLH_CONTEXT)) {
                    b = Ascii.DC2;
                }
                break;
            case 1754464:
                if (str.equals(ERROR_OPPO_CONTEXT)) {
                    b = 19;
                }
                break;
            case 1754465:
                if (str.equals(ERROR_VIVO_CONTEXT)) {
                    b = Ascii.DC4;
                }
                break;
            case 1754466:
                if (str.equals(ERROR_CSJ_CONTEXT)) {
                    b = Ascii.NAK;
                }
                break;
            case 1754467:
                if (str.equals(ERROR_TANX_CONTEXT)) {
                    b = Ascii.SYN;
                }
                break;
            case 54387534:
                if (str.equals(ERROR_KS_NO_TYPE)) {
                    b = Ascii.ETB;
                }
                break;
            case 54387535:
                if (str.equals(ERROR_BD_NO_TYPE)) {
                    b = Ascii.CAN;
                }
                break;
        }
        switch (b) {
            case 0:
                return new YFAdError(str, e.a("网络请求失败_", str2));
            case 1:
                return new YFAdError(str, e.a("广告单层超时_", str2));
            case 2:
                return new YFAdError(str, e.a("广告瀑布流超时_", str2));
            case 3:
                return new YFAdError(str, e.a("广告策略为空_", str2));
            case 4:
                return new YFAdError(str, e.a("广告超过限制_时_", str2));
            case 5:
                return new YFAdError(str, e.a("广告超过限制_天_", str2));
            case 6:
                return new YFAdError(str, e.a("广告超过间隔_次_", str2));
            case 7:
                return new YFAdError(str, e.a("广告返回的数据为空_", str2));
            case 8:
                return new YFAdError(str, e.a("_", str2));
            case 9:
                return new YFAdError(str, e.a("广告展示异常_", str2));
            case 10:
                return new YFAdError(str, e.a("广告渲染异常_", str2));
            case 11:
                return new YFAdError(str, e.a("未接入广告源或适配器_", str2));
            case 12:
                return new YFAdError(str, e.a("广告策略调度异常_", str2));
            case 13:
                return new YFAdError(str, e.a("没有找到执行策略_", str2));
            case 14:
                return new YFAdError(str, e.a("百度广告加载失败_", str2));
            case 15:
                return new YFAdError(str, e.a("广告渲染失败_", str2));
            case 16:
                return new YFAdError(str, e.a("广告源初始化失败_", str2));
            case 17:
                return new YFAdError(str, e.a("自渲染失败_", str2));
            case 18:
                return new YFAdError(str, e.a("优量汇模板广告请求非activity上下文_", str2));
            case 19:
                return new YFAdError(str, e.a("OPPO广告请求非activity上下文_", str2));
            case 20:
                return new YFAdError(str, e.a("VIVO广告请求非activity上下文_", str2));
            case 21:
                return new YFAdError(str, e.a("穿山甲GroMore广告请求非activity上下文_", str2));
            case 22:
                return new YFAdError(str, e.a("TanX请求非activity上下文_", str2));
            case 23:
                return new YFAdError(str, e.a("没有快手类型_", str2));
            case 24:
                return new YFAdError(str, e.a("没有百度类型_", str2));
            default:
                try {
                    if (str.equals("20001") && !TextUtils.isEmpty(str2) && str2.contains("reason:")) {
                        String[] strArrSplit = str2.split("reason:");
                        if (strArrSplit.length > 1 && !TextUtils.isEmpty(strArrSplit[1])) {
                            String strTrim = strArrSplit[1].trim();
                            if (strTrim.contains(CrashHianalyticsData.MESSAGE)) {
                                return new YFAdError("99_" + str + "_" + strTrim.split(CrashHianalyticsData.MESSAGE)[0], "广告源_".concat(str2));
                            }
                            return new YFAdError("99_" + str + "_" + strTrim, "广告源_".concat(str2));
                        }
                        return new YFAdError("99_".concat(str), "广告源_".concat(str2));
                    }
                    return new YFAdError("99_".concat(str), "广告源_" + str2);
                } catch (Exception unused) {
                    return new YFAdError("99_".concat(str), e.a("广告源_", str2));
                }
        }
    }
}
