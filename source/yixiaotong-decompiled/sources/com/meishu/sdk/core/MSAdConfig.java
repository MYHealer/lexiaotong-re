package com.meishu.sdk.core;

import android.app.Activity;
import android.location.Location;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.google.android.exoplayer2.C;
import com.meishu.sdk.core.webview.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class MSAdConfig {
    public static final int DEVICE_CONTROL_ALL_CLOSE = 2;
    public static final int DEVICE_CONTROL_ALL_OPEN = 0;
    public static final int DEVICE_CONTROL_ONLY_OAID = 1;
    public static final int DOWNLOAD_CONFIRM_ALWAYS = 1;
    public static final int DOWNLOAD_CONFIRM_AUTO = 0;
    public static final int DOWNLOAD_CONFIRM_NEVER = 2;
    public static final String PLATFORM_BD = "BAIDU";
    public static final String PLATFORM_CSJ = "CSJ";
    public static final String PLATFORM_GDT = "GDT";
    public static final String PLATFORM_KS = "KS";
    public static final int SECURE_ALL = 2;
    public static final int SECURE_HTTP = 0;
    public static final int SECURE_HTTPS = 1;
    private static List<Integer> disableSensorTypes;
    private String[] advertiserId;
    private String appId;
    private String authority;
    private boolean canUseSdkPersonalRecommend;
    private CustomController customController;
    private String deny_ader_ids;
    private String deny_cats;
    private String deny_cids;
    private int downloadConfirm;
    private boolean enableBootId;
    private boolean enableDebug;
    private boolean enableInstallBroadcast;
    private boolean enableInterstitialAutoClose;
    private boolean enableNotify;
    private boolean enableOaid;
    private String ext;
    private boolean gdt2Toggle;
    private HashMap<String, Object> initSdkMap;
    private boolean isTest;
    private String oaid_cert_name;
    private int[] preRenderPaddings;
    private int secure;
    private boolean showFeedAdLogo;
    private boolean showLogo;
    private boolean splashClickPause;
    private String splashClickText;
    private boolean splashClickToClosed;
    private long splashShowTime;
    private boolean useMediation;
    private String userId;
    private String userKeywords;
    private Integer userType;
    private Class<? extends Activity> webViewActivity;
    private Class<? extends m> webViewClient;
    private Class<? extends com.meishu.sdk.core.webview.d> webViewDownloadListener;
    private String wx_appid;
    private static String initUUID = UUID.randomUUID().toString();
    private static long initTime = System.currentTimeMillis();

    /* JADX INFO: renamed from: com.meishu.sdk.core.MSAdConfig$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private static List<Integer> disableSensorTypes;
        private String[] advertiserId;
        private String appId;
        private String authority;
        private CustomController customController;
        private String deny_ader_ids;
        private String deny_cats;
        private String deny_cids;
        private String ext;
        private boolean gdt2Toggle;
        private HashMap<String, Object> initSdkMap;
        private String oaid_cert_name;
        private int[] preRenderPaddings;
        private String splashClickText;
        private String userId;
        private String userKeywords;
        private Integer userType;
        private Class<? extends Activity> webViewActivity;
        private Class<? extends m> webViewClient;
        private Class<? extends com.meishu.sdk.core.webview.d> webViewDownloadListener;
        private String wx_appid;
        private boolean canUseSdkPersonalRecommend = true;
        private boolean enableDebug = false;
        private boolean enableNotify = true;
        private boolean enableOaid = true;
        private int downloadConfirm = 0;
        private int secure = 2;
        private boolean showFeedAdLogo = false;
        private boolean splashClickPause = true;
        private boolean showLogo = true;
        private boolean enableInterstitialAutoClose = true;
        private long splashShowTime = 5000;
        private boolean useMediation = true;
        private boolean enableInstallBroadcast = true;
        private boolean splashClickToClosed = false;
        private boolean enableBootId = true;

        public Builder appId(String str) {
            this.appId = str;
            return this;
        }

        public MSAdConfig build() {
            if (TextUtils.isEmpty(this.appId)) {
                throw new RuntimeException("appId错误");
            }
            return new MSAdConfig(this, null);
        }

        public Builder customController(CustomController customController) {
            this.customController = customController;
            return this;
        }

        public Builder downloadConfirm(int i) {
            if (i == 0 || 1 == i || 2 == i) {
                this.downloadConfirm = i;
            }
            return this;
        }

        public Builder enableBootId(boolean z) {
            this.enableBootId = z;
            return this;
        }

        public Builder enableDebug(boolean z) {
            this.enableDebug = z;
            return this;
        }

        public Builder enableInstallBroadcast(boolean z) {
            this.enableInstallBroadcast = z;
            return this;
        }

        public Builder enableInterstitialAutoClose(boolean z) {
            this.enableInterstitialAutoClose = z;
            return this;
        }

        public Builder enableNotify(boolean z) {
            this.enableNotify = z;
            return this;
        }

        public Builder enableOaid(boolean z) {
            this.enableOaid = z;
            return this;
        }

        public Builder enableSdkPersonalRecommend(boolean z) {
            this.canUseSdkPersonalRecommend = z;
            return this;
        }

        @Deprecated
        public Builder gdt2Toggle(Boolean bool) {
            this.gdt2Toggle = bool.booleanValue();
            return this;
        }

        public Builder secure(int i) {
            if (2 == i || i == 0 || 1 == i) {
                this.secure = i;
            }
            return this;
        }

        public Builder setAuthority(String str) {
            this.authority = str;
            return this;
        }

        public Builder setInitSdkMap(HashMap<String, Object> map) {
            this.initSdkMap = map;
            return this;
        }

        public Builder setOaidCertName(String str) {
            this.oaid_cert_name = str;
            return this;
        }

        public Builder setSplashClickToClose(boolean z) {
            this.splashClickToClosed = z;
            return this;
        }

        public Builder setSplashShowTime(long j) {
            if (j >= C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
                this.splashShowTime = j;
            }
            return this;
        }

        public Builder setUseMediation(boolean z) {
            this.useMediation = z;
            return this;
        }

        public Builder setWxAppid(String str) {
            this.wx_appid = str;
            return this;
        }

        public Builder showFeedAdLogo(boolean z) {
            this.showFeedAdLogo = z;
            return this;
        }

        public Builder showLogo(boolean z) {
            this.showLogo = z;
            return this;
        }

        public Builder splashClickPause(boolean z) {
            this.splashClickPause = z;
            return this;
        }

        public Builder splashClickText(String str) {
            this.splashClickText = str;
            return this;
        }

        public Builder userAdvertiserId(String... strArr) {
            if (strArr != null) {
                this.advertiserId = strArr;
            }
            return this;
        }

        public Builder userDenyAderIds(String str) {
            this.deny_ader_ids = str;
            return this;
        }

        public Builder userDenyCats(String str) {
            this.deny_cats = str;
            return this;
        }

        public Builder userDenyCids(String str) {
            this.deny_cids = str;
            return this;
        }

        public Builder userExt(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.ext = str;
            }
            return this;
        }

        public Builder userId(String str) {
            this.userId = str;
            return this;
        }

        public Builder userKeywords(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.userKeywords = str;
            }
            return this;
        }

        public Builder userType(int i) {
            this.userType = Integer.valueOf(i);
            return this;
        }

        public Builder webViewActivity(Class<? extends Activity> cls) {
            this.webViewActivity = cls;
            return this;
        }

        public Builder webViewClient(Class<? extends m> cls) {
            this.webViewClient = cls;
            return this;
        }

        public Builder webviewDownloadListener(Class<? extends com.meishu.sdk.core.webview.d> cls) {
            this.webViewDownloadListener = cls;
            return this;
        }

        public Builder disableSensorType(int i) {
            if (disableSensorTypes == null) {
                disableSensorTypes = new ArrayList();
            }
            disableSensorTypes.add(Integer.valueOf(i));
            return this;
        }

        public Builder userPreRenderPaddings(int i, int i2, int i3, int i4) {
            if (this.preRenderPaddings == null) {
                this.preRenderPaddings = new int[4];
            }
            int[] iArr = this.preRenderPaddings;
            iArr[0] = i;
            iArr[1] = i2;
            iArr[2] = i3;
            iArr[3] = i4;
            return this;
        }
    }

    public static abstract class CustomController {
        public boolean canReadInstalledPackages() {
            return true;
        }

        public boolean canUseMacAddress() {
            return true;
        }

        public boolean canUseNetworkState() {
            return true;
        }

        public boolean canUseStoragePermission() {
            return true;
        }

        public String getAndroidId() {
            return null;
        }

        public String getDevImei() {
            return null;
        }

        public Location getLocation() {
            return null;
        }

        public String getMacAddress() {
            return null;
        }

        public String getOaid() {
            return null;
        }

        public LocationProvider getTTLocation() {
            return null;
        }

        public boolean isCanUseAndroidId() {
            return true;
        }

        public boolean isCanUseImsi() {
            return true;
        }

        public boolean isCanUseLocation() {
            return true;
        }

        public boolean isCanUsePermissionRecordAudio() {
            return true;
        }

        public boolean isCanUsePhoneState() {
            return true;
        }

        public boolean isCanUseWifiState() {
            return true;
        }

        public boolean isCsjUsePhoneState() {
            return true;
        }

        public boolean isStorageCollectEnable() {
            return true;
        }
    }

    static {
        List<Integer> list = disableSensorTypes;
        if (list != null) {
            list.clear();
        }
    }

    public /* synthetic */ MSAdConfig(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static long initTime() {
        return initTime;
    }

    public static String initUUID() {
        return initUUID;
    }

    public String appId() {
        return this.appId;
    }

    public CustomController customController() {
        return this.customController;
    }

    public int downloadConfirm() {
        return this.downloadConfirm;
    }

    public void downloadConfirm(int i) {
        if (i == 0 || 1 == i || 2 == i) {
            this.downloadConfirm = i;
        }
    }

    public boolean enableDebug() {
        return this.enableDebug;
    }

    public void enableInstallBroadcast(boolean z) {
        this.enableInstallBroadcast = z;
    }

    public boolean enableInstallBroadcast() {
        return this.enableInstallBroadcast;
    }

    public boolean enableNotify() {
        return this.enableNotify;
    }

    public boolean enableOaid() {
        return this.enableOaid;
    }

    public void enableSdkPersonalRecommend(boolean z) {
        this.canUseSdkPersonalRecommend = z;
    }

    public void gdt2Toggle(Boolean bool) {
        this.gdt2Toggle = bool.booleanValue();
    }

    public String getAuthority() {
        return this.authority;
    }

    public boolean getCanUseSdkPersonalRecommend() {
        return this.canUseSdkPersonalRecommend;
    }

    public List<Integer> getDisableSensorTypes() {
        return disableSensorTypes;
    }

    public boolean getEnableInterstitialAutoClose() {
        return this.enableInterstitialAutoClose;
    }

    public HashMap<String, Object> getInitSdkMap() {
        return this.initSdkMap;
    }

    public String getOaidCertName() {
        return this.oaid_cert_name;
    }

    public long getSplashShowTime() {
        return this.splashShowTime;
    }

    public String getWxAppid() {
        return this.wx_appid;
    }

    public boolean isEnableBootId() {
        return this.enableBootId;
    }

    public boolean isSplashClickToClosed() {
        return this.splashClickToClosed;
    }

    public boolean isTest() {
        return false;
    }

    public boolean isUseMediation() {
        return this.useMediation;
    }

    public int secure() {
        return this.secure;
    }

    public void setEnableInterstitialAutoClose(boolean z) {
        this.enableInterstitialAutoClose = z;
    }

    public void setInitSdkMap(HashMap<String, Object> map) {
        this.initSdkMap = map;
    }

    public void setOaidCertName(String str) {
        this.oaid_cert_name = str;
    }

    public void setSplashClickToClosed(boolean z) {
        this.splashClickToClosed = z;
    }

    public void setSplashShowTime(long j) {
        if (j < C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS) {
            return;
        }
        this.splashShowTime = j;
    }

    public void setUseMediation(boolean z) {
        this.useMediation = z;
    }

    public void setUserKeyWords(String str) {
        this.userKeywords = str;
    }

    public void setWxAppid(String str) {
        this.wx_appid = str;
    }

    public boolean showFeedAdLogo() {
        return this.showFeedAdLogo;
    }

    public void showLogo(boolean z) {
        this.showLogo = z;
    }

    public boolean showLogo() {
        return this.showLogo;
    }

    public void splashClickPause(boolean z) {
        this.splashClickPause = z;
    }

    public boolean splashClickPause() {
        return this.splashClickPause;
    }

    public String splashClickText() {
        return this.splashClickText;
    }

    public void splashClickText(String str) {
        this.splashClickText = str;
    }

    public void userAdvertiserId(String... strArr) {
        this.advertiserId = strArr;
    }

    public String[] userAdvertiserId() {
        return this.advertiserId;
    }

    public String userDenyAderIds() {
        return this.deny_ader_ids;
    }

    public void userDenyAderIds(String str) {
        this.deny_ader_ids = str;
    }

    public String userDenyCats() {
        return this.deny_cats;
    }

    public void userDenyCats(String str) {
        this.deny_cats = str;
    }

    public String userDenyCids() {
        return this.deny_cids;
    }

    public void userDenyCids(String str) {
        this.deny_cids = str;
    }

    public String userExt() {
        return this.ext;
    }

    public void userExt(String str) {
        this.ext = str;
    }

    public String userId() {
        return this.userId;
    }

    public void userId(String str) {
        this.userId = str;
    }

    public String userKeywords() {
        return this.userKeywords;
    }

    public void userKeywords(String str) {
        this.userKeywords = str;
    }

    public int[] userPreRenderPaddings() {
        return this.preRenderPaddings;
    }

    public Integer userType() {
        return this.userType;
    }

    public Class<? extends Activity> webViewActivity() {
        return this.webViewActivity;
    }

    public Class<? extends m> webViewClient() {
        return this.webViewClient;
    }

    public Class<? extends com.meishu.sdk.core.webview.d> webViewDownloadListener() {
        return this.webViewDownloadListener;
    }

    private MSAdConfig(Builder builder) {
        this.splashClickPause = true;
        this.gdt2Toggle = false;
        this.showLogo = true;
        this.enableInterstitialAutoClose = true;
        this.enableInstallBroadcast = true;
        this.splashClickToClosed = false;
        this.enableBootId = true;
        this.canUseSdkPersonalRecommend = true;
        this.splashShowTime = 5000L;
        this.useMediation = true;
        this.appId = builder.appId;
        this.enableDebug = builder.enableDebug;
        this.enableNotify = builder.enableNotify;
        this.enableOaid = builder.enableOaid;
        this.downloadConfirm = builder.downloadConfirm;
        this.secure = builder.secure;
        this.userId = builder.userId;
        this.userType = builder.userType;
        this.userKeywords = builder.userKeywords;
        this.customController = builder.customController;
        this.webViewDownloadListener = builder.webViewDownloadListener;
        this.webViewClient = builder.webViewClient;
        this.webViewActivity = builder.webViewActivity;
        this.ext = builder.ext;
        this.preRenderPaddings = builder.preRenderPaddings;
        this.showFeedAdLogo = builder.showFeedAdLogo;
        this.splashClickText = builder.splashClickText;
        this.gdt2Toggle = builder.gdt2Toggle;
        this.deny_cats = builder.deny_cats;
        this.deny_cids = builder.deny_cids;
        this.deny_ader_ids = builder.deny_ader_ids;
        this.splashClickPause = builder.splashClickPause;
        this.wx_appid = builder.wx_appid;
        this.advertiserId = builder.advertiserId;
        this.showLogo = builder.showLogo;
        this.oaid_cert_name = builder.oaid_cert_name;
        this.canUseSdkPersonalRecommend = builder.canUseSdkPersonalRecommend;
        this.enableInterstitialAutoClose = builder.enableInterstitialAutoClose;
        this.splashShowTime = builder.splashShowTime;
        this.useMediation = builder.useMediation;
        this.initSdkMap = builder.initSdkMap;
        this.enableInstallBroadcast = builder.enableInstallBroadcast;
        this.splashClickToClosed = builder.splashClickToClosed;
        disableSensorTypes = Builder.disableSensorTypes;
        this.enableBootId = builder.enableBootId;
        this.authority = builder.authority;
    }

    public void clearAllSensorTypes() {
        List<Integer> list = disableSensorTypes;
        if (list != null) {
            list.clear();
        }
    }

    public void clearDisableSensor(int i) {
        try {
            List<Integer> list = disableSensorTypes;
            if (list != null) {
                Iterator<Integer> it = list.iterator();
                while (it.hasNext()) {
                    if (it.next().intValue() == i) {
                        it.remove();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disableSensorType(int i) {
        if (disableSensorTypes == null) {
            disableSensorTypes = new ArrayList();
        }
        disableSensorTypes.add(Integer.valueOf(i));
    }

    public Boolean gdt2Toggle() {
        return Boolean.valueOf(this.gdt2Toggle);
    }

    public void userPreRenderPaddings(int i, int i2, int i3, int i4) {
        if (this.preRenderPaddings == null) {
            this.preRenderPaddings = new int[4];
        }
        int[] iArr = this.preRenderPaddings;
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
    }
}
