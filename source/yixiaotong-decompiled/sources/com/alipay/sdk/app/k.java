package com.alipay.sdk.app;

import com.baidu.oauth.sdkbqt.result.OauthResult;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public enum k {
    SUCCEEDED(9000, "处理成功"),
    FAILED(4000, "系统繁忙，请稍后再试"),
    CANCELED(6001, OauthResult.RESULT_MSG_USER_CANCEL),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(4001, OauthResult.RESULT_MSG_PARAMS_INVALID),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");

    private int h;
    private String i;

    public static k b(int i) {
        if (i == 4001) {
            return PARAMS_ERROR;
        }
        if (i == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i == 8000) {
            return PAY_WAITTING;
        }
        if (i == 9000) {
            return SUCCEEDED;
        }
        if (i != 6001) {
            return i != 6002 ? FAILED : NETWORK_ERROR;
        }
        return CANCELED;
    }

    public int a() {
        return this.h;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(String str) {
        this.i = str;
    }

    public String b() {
        return this.i;
    }

    k(int i, String str) {
        this.h = i;
        this.i = str;
    }
}
