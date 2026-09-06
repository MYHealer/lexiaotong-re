package client.android.yixiaotong.v4.util.um;

import android.app.Activity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.umeng.analytics.MobclickAgent;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UmConfigUtil {
    private static final String TAG = "UmConfigUtil";

    public enum MainPage {
        MainPage_V1,
        MainPage_V3,
        MainPage_V4
    }

    public enum UsePlatform {
        V1,
        V3,
        V4
    }

    public static void setMainPageEvent(Activity activity) {
        if (activity == null) {
            return;
        }
        String platform = getPlatform(activity);
        LogUtil.e(TAG, "setMainPageEvent:" + platform);
        new HashMap().put("MainPage_" + platform, platform);
        MobclickAgent.onEvent(activity, "MainPage_" + platform);
    }

    public static void setRequestSplashAdEvent(Activity activity) {
        if (activity == null) {
            return;
        }
        String platform = getPlatform(activity);
        LogUtil.e(TAG, "setRequestSplashAdEvent:" + platform);
        new HashMap().put("Splash_Ad_Request_" + platform, platform);
        MobclickAgent.onEvent(activity, "Splash_Ad_Request_" + platform);
    }

    public static void setSplashAdSuccessEvent(Activity activity) {
        if (activity == null) {
            return;
        }
        String platform = getPlatform(activity);
        LogUtil.e(TAG, "setSplashAdSuccessEvent:" + platform);
        new HashMap().put("Splash_Ad_Success_" + platform, platform);
        MobclickAgent.onEvent(activity, "Splash_Ad_Success_" + platform);
    }

    public static void setRequestInterstitialAdEvent(Activity activity) {
        if (activity == null) {
            return;
        }
        LogUtil.e(TAG, "setRequestInterstitialAdEvent");
        String platform = getPlatform(activity);
        new HashMap().put("Interstitial_Ad_Request_" + platform, platform);
        MobclickAgent.onEvent(activity, "Interstitial_Ad_Request_" + platform);
    }

    public static void setInterstitialAdSuccessEvent(Activity activity) {
        if (activity == null) {
            return;
        }
        LogUtil.e(TAG, "setInterstitialAdSuccessEvent");
        String platform = getPlatform(activity);
        new HashMap().put("Interstitial_Ad_Success_" + platform, platform);
        MobclickAgent.onEvent(activity, "Interstitial_Ad_Success_" + platform);
    }

    public static void setRequestNativeAdEvent(Activity activity) {
        if (activity == null) {
            return;
        }
        LogUtil.e(TAG, "setRequestNativeAdEvent");
        String platform = getPlatform(activity);
        new HashMap().put("Native_Ad_Request_" + platform, platform);
        MobclickAgent.onEvent(activity, "Native_Ad_Request_" + platform);
    }

    public static void setNativeAdSuccessEvent(Activity activity) {
        if (activity == null) {
            return;
        }
        LogUtil.e(TAG, "setNativeAdSuccessEvent");
        String platform = getPlatform(activity);
        new HashMap().put("Native_Ad_Success_" + platform, platform);
        MobclickAgent.onEvent(activity, "Native_Ad_Success_" + platform);
    }

    private static String getPlatform(Activity activity) {
        int platformInfo = LocalDataUtil.getPlatformInfo(activity);
        if (platformInfo == 0) {
            return UsePlatform.V1 + "";
        }
        if (platformInfo == 1) {
            return UsePlatform.V3 + "";
        }
        return platformInfo == 4 ? UsePlatform.V4 + "" : "MainPage_Unknown";
    }
}
