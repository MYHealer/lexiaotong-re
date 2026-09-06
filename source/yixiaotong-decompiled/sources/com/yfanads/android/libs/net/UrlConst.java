package com.yfanads.android.libs.net;

import android.text.TextUtils;
import com.huawei.hms.ads.dynamicloader.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class UrlConst {
    public static String ADS_DOMAIN = "";
    public static final String ADX = "adx-data";
    public static String ADX_REQ_URL = "";
    public static String AES_KEY = "";
    public static final String API = "api";
    public static final String DOMAIN_KEY = ".yfanads.com";
    public static final int ERROR_CODE = 99500;
    public static final String HTTP = "http:";
    public static final String HTTPS = "https:";
    public static final String LOG = "log";
    private static String PKG_IV = "";
    private static String PKG_KEY = "";
    public static final String PRD_KEY = "//";
    public static String REWARD_URL = "";
    private static String RSA_KEY = "";
    private static final String SIGN_KEY = "YiFanYYDSForver";
    public static final String TEST_KEY = "//test.";
    public static final String TRACKER = "tracker";
    public static String UPD_DOMAIN = "";
    public static String URL_GET_ADS = "";
    public static String URL_TRACE = "";
    public static String URL_UPLOAD = "";
    public static String URL_UPLOAD_LOG = "";
    private static boolean isPrd = true;
    private static String shopMallAmount;

    private UrlConst() {
    }

    public static String getAdxReq(String str, String str2) {
        return ADX_REQ_URL + "?appId=" + str + "&adId=" + str2;
    }

    public static String getAmount() {
        return shopMallAmount;
    }

    public static String getApiDomain(String str) {
        return ADS_DOMAIN + str;
    }

    public static String getGetAds(String str) {
        return getGetAds(str, false);
    }

    public static String getGetAds(String str, boolean z) {
        StringBuilder sbAppend;
        String strReplace;
        if (z) {
            sbAppend = new StringBuilder().append(ADS_DOMAIN);
            strReplace = URL_GET_ADS.replace(b.f, "v2");
        } else {
            sbAppend = new StringBuilder().append(ADS_DOMAIN);
            strReplace = URL_GET_ADS;
        }
        return sbAppend.append(strReplace).append(str).toString();
    }

    public static String getKey() {
        return AES_KEY;
    }

    public static String getPkgIV() {
        return PKG_IV;
    }

    public static String getPkgKey() {
        return PKG_KEY;
    }

    public static String getRewardDomain(String str) {
        return REWARD_URL + str;
    }

    public static String getRsaKey() {
        return RSA_KEY;
    }

    public static String getSignKey() {
        return SIGN_KEY;
    }

    public static String getTraceUrl() {
        return URL_TRACE;
    }

    public static String getUpdDomain(String str) {
        return UPD_DOMAIN + str;
    }

    public static String getUpload(boolean z) {
        StringBuilder sbAppend;
        String strReplace;
        if (z) {
            sbAppend = new StringBuilder().append(UPD_DOMAIN);
            strReplace = URL_UPLOAD.replace(b.f, "v2");
        } else {
            sbAppend = new StringBuilder().append(UPD_DOMAIN);
            strReplace = URL_UPLOAD;
        }
        return sbAppend.append(strReplace).toString();
    }

    public static String getUploadLog() {
        return URL_UPLOAD_LOG;
    }

    public static void init(String str, String str2) {
        if (isPrd) {
            initPrdEnv(str, str2);
        }
    }

    private static void initPrdEnv(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "http://api.yfanads.com";
        }
        ADS_DOMAIN = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = "http://tracker.yfanads.com";
        }
        UPD_DOMAIN = str2;
        REWARD_URL = ADS_DOMAIN;
        URL_GET_ADS = "/api/v1/ads";
        URL_UPLOAD = "/api/v1/ads/batchUpload";
        ADX_REQ_URL = "http://adx-data.yfanads.com/v1/ad";
        URL_UPLOAD_LOG = "http://log.yfanads.com/ads/v1/upload/log";
        URL_TRACE = UPD_DOMAIN + "/api/v1/ads/trace";
        AES_KEY = "TDj3KptvpnZ5qQ$wzju86b5$HcmkqHem";
        PKG_KEY = "67928jjh9iu4034a";
        PKG_IV = "r45932n763bdc44c";
        RSA_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzgYbYs1H+rlq4DhgzkC9Osx41BEU2VOQeC4AxnCC2V2uqjzkvF0NlfjFY+yOusbKNFfq+3396Ix/ILsMLegUuDV65e3NVJES7UTgKB6dyLqix+EmWDr8uq9n5FhbodjhPQmMZQxvfJkoSXJYP2JuYGpI1Tn0+62Zhh72AgI+eZ0+Dc6SsS0kQRurTDBnX9pYqDI5Xo2CzyVyyrQk+ePMGwLTnl1NL1RHWN178jO3+OBEi8u9lYvgpOt8F0gfxToTdHmaCpgKTYwG3Ua41cwKhrF1SpL7d4R15bpwi/XFnw4Mdx1bEO2WS7EYjEuQ7Vg5TOesQ22MtMUHRSxu895TCQIDAQAB";
    }

    public static boolean isTestEnv() {
        return !isPrd;
    }

    public static void setAdsDomain(String str) {
        ADS_DOMAIN = str;
    }

    public static void setUpdDomain(String str) {
        UPD_DOMAIN = str;
    }
}
