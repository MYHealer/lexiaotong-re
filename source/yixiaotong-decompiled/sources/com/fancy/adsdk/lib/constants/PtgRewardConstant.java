package com.fancy.adsdk.lib.constants;

import com.baidu.oauth.sdkbqt.result.OauthResult;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgRewardConstant {

    @Retention(RetentionPolicy.SOURCE)
    public @interface REWARD_PARAMS {
        public static final String EXTRA = "extra";
        public static final String REWARD_AMOUNT = "reward_amount";
        public static final String REWARD_NAME = "reward_name";
        public static final String REWARD_TYPE = "reward_type";
        public static final String SERVER_CODE = "server_code";
        public static final String SERVER_MSG = "server_msg";
        public static final String USER_ID = "user_id";
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface REWARD_VERIFY {
        public static final int NEED_VERIFY = 1;
        public static final int NO_VERIFY = 0;
    }

    public enum ServerErr {
        DEF(-1, "有效奖励"),
        SUC(200, "有效奖励"),
        SUC_ERR(200, "无效奖励"),
        ERR_DATA(400, "数据类型异常"),
        ERR_PAR(401, "数据解析异常"),
        ERR_PARAMS(403, "参数异常"),
        ERR_BODY(404, "服务端地址或广告参数为空"),
        ERR_NET(405, OauthResult.RESULT_MSG_NETWORK_EXCEPTION),
        ERR_TIMEOUT(406, "网络超时"),
        ERR_SERVER(407, "服务端异常");

        private final int code;
        private final String msg;

        ServerErr(int i, String str) {
            this.code = i;
            this.msg = str;
        }

        public int getCode() {
            return this.code;
        }

        public String getMsg() {
            return this.msg;
        }
    }
}
