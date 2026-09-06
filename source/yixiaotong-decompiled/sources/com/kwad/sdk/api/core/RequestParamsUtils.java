package com.kwad.sdk.api.core;

import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public final class RequestParamsUtils {
    public static final String USER_AGENT_KEY = "User-Agent";
    private static String sUserAgent;

    private static String getUserAgentParams() {
        try {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            StringBuilder sb = new StringBuilder();
            int length = property.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
                } else {
                    sb.append(cCharAt);
                }
            }
            sb.append(x.A);
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getUserAgent() {
        if (TextUtils.isEmpty(sUserAgent)) {
            sUserAgent = getUserAgentParams() + "ksad-android-5.4.10.1";
        }
        return sUserAgent;
    }
}
