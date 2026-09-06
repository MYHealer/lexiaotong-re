package com.jd.ad.sdk.dl.error;

import android.text.TextUtils;
import com.hihonor.adsdk.base.ErrorCode;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public enum JADError {
    GW_REQUEST_SLOT_IS_NULL_ERROR(ErrorCode.AD_LOADED_LISTENER_IS_NULL, "slot is null"),
    GW_REQUEST_AD_TYPE_IS_NOT_SET_ERROR(ErrorCode.AD_WEB_SSL_ERR, "ad type is error"),
    GW_RESPONSE_TOLERATE_TIME_ERROR(31018, "arrive tolerance time when load"),
    RENDER_AD_VIEW_IS_NULL_ERROR(33001, "ad view is null"),
    RENDER_CREATE_AD_VIEW_FAIL_ERROR(33002, "create ad view failed"),
    RENDER_IMAGE_URL_IS_NULL_ERROR(33003, "ad image is null"),
    RENDER_IMAGE_LOAD_FAIL_ERROR(33004, "ad image load failed"),
    RENDER_DYNAMIC_VIEW_INIT_OTHER_ERROR(33013, "other error"),
    RENDER_TOLERATE_TIME_ERROR(33016, "arrive tolerance time when render"),
    RENDER_SPLASH_RESPONSE_TEMPLATE_ID_ERROR(33017, "create splash ad view failed by data"),
    RENDER_FEED_RESPONSE_TEMPLATE_ID_ERROR(33018, "create feed ad view failed by data"),
    RENDER_VIDEO_FAIL_ERROR(330302, "ad video render failed"),
    EXPOSURE_EXCEPTION_ERROR(34001, "exposure error "),
    DEFAULT_ERROR(-1, "error");

    public int code;
    public String message;

    JADError(int i, String str) {
        this.code = i;
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage(String... strArr) {
        StringBuilder sb = new StringBuilder(this.message);
        if (strArr != null) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    sb.append(x.bQ).append(str);
                }
            }
        }
        return sb.toString();
    }
}
