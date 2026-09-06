package com.fancy.adsdk.lib;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.fancy._kp;
import com.fancy._kr;
import com.fancy.adsdk.lib.interf.PtgCustomController;
import com.fancy.adsdk.lib.utils.Logger;
import java.io.File;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class PtgSDKConfig {
    private Map<String, String> appIdMap;
    private Map<String, String> appKeyMap;
    private String baseTrackingUrl;
    private int blin;
    private boolean debug;
    private int delayLin;
    private String detectRule;
    private long detectRuleInterval;
    private List<String> dpWhiteList;
    private int fdRule;
    private int imageUpgrade;
    private long initEndTime;
    private long initStartTime;
    private volatile Integer lessThanVc;
    private int lin;
    private int linc;
    private int lind;
    private File localPolicyFile;
    private InputStream localPolicyFileInputStream;
    private int mediaStatus;
    private String policyVersion;
    private String[] providers;
    private String ptgApiUrl;
    private PtgCustomController ptgCustomController;
    private List<String> qaList;
    private int qaNRTime;
    private int sdkLogoId;
    private int slin;
    private Boolean supportHttp;
    private boolean supportMultiProcess;
    private String vendorId = "";
    private String packageName = "";
    private String sdkLogoUrl = "";
    private String initTrackingUrl = "";
    private String mediaSecret = "";
    private String localPolicyEncode = "UTF-8";
    private String keyToken = "";
    private boolean allowDirectDownloadOverMobileNetwork = false;
    private boolean allowDirectDownloadOverWifiNetwork = false;
    private String appVersionName = "";
    private String appVersionCode = "";
    private String wechatAppId = "";
    public final String S2S_URL_RLS = "https%3A%2F%2Fg.fancyapi.com%2Fs2s";
    private String mediaId = "undefined";
    private String appName = "undefined";

    public static class Builder {
        private boolean allowMobileDownload;
        private boolean allowWifiDownload;
        private Map<String, String> appIdMap;
        private Map<String, String> appKeyMap;
        private boolean debug;
        private String[] providers;
        private PtgCustomController ptgCustomController;
        private int sdkLogoId;
        private Boolean supportHttp;
        private boolean supportMultiProcess;
        private String mediaId = "";
        private String appName = "";
        private String vendorId = "";
        private String sdkLogoUrl = "";
        private String mediaSecret = "";
        private String appVersion = "";
        private String appVersionCode = "";
        private String localPolicyEncode = "UTF-8";

        private String buildKeyToken(String str, String str2) {
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? "" : com.fancy.adsdk.lib.utils._a._c(String.format("%s%s", str, str2)).toUpperCase();
        }

        public PtgSDKConfig build() {
            PtgSDKConfig ptgSDKConfig = new PtgSDKConfig();
            ptgSDKConfig.setMediaId(this.mediaId);
            ptgSDKConfig.setAppName(this.appName);
            ptgSDKConfig.setVendorId(this.vendorId);
            ptgSDKConfig.setDebug(this.debug);
            ptgSDKConfig.setSdkLogoId(this.sdkLogoId);
            ptgSDKConfig.setSdkLogoUrl(this.sdkLogoUrl);
            ptgSDKConfig.setProviders(this.providers);
            ptgSDKConfig.setAllowDirectDownloadOverMobileNetwork(this.allowMobileDownload);
            ptgSDKConfig.setAllowDirectDownloadOverWifiNetwork(this.allowWifiDownload);
            ptgSDKConfig.setMediaSecret(this.mediaSecret);
            ptgSDKConfig.setLocalPolicyEncode(this.localPolicyEncode);
            ptgSDKConfig.setKeyToken(buildKeyToken(ptgSDKConfig.getMediaId(), ptgSDKConfig.getMediaSecret()));
            ptgSDKConfig.setPtgCustomController(this.ptgCustomController);
            ptgSDKConfig.setSupportMultiProcess(this.supportMultiProcess);
            ptgSDKConfig.setAppVersionName(this.appVersion);
            ptgSDKConfig.setAppVersionCode(this.appVersionCode);
            ptgSDKConfig.setAppIdMap(this.appIdMap);
            ptgSDKConfig.setAppKeyMap(this.appKeyMap);
            ptgSDKConfig.setSupportHttp(this.supportHttp);
            return ptgSDKConfig;
        }

        public Builder setAllowMobileDownload(boolean z) {
            this.allowMobileDownload = z;
            return this;
        }

        public Builder setAllowWifiDownload(boolean z) {
            this.allowWifiDownload = z;
            return this;
        }

        public Builder setAppIdMap(Map<String, String> map) {
            this.appIdMap = map;
            return this;
        }

        public Builder setAppKeyMap(Map<String, String> map) {
            this.appKeyMap = map;
            return this;
        }

        public Builder setAppName(String str) {
            this.appName = str;
            return this;
        }

        public Builder setAppVersion(String str) {
            this.appVersion = str;
            return this;
        }

        public Builder setAppVersionCode(String str) {
            this.appVersionCode = str;
            return this;
        }

        public Builder setDebug(boolean z) {
            this.debug = z;
            return this;
        }

        public Builder setMediaId(String str) {
            this.mediaId = str;
            return this;
        }

        public Builder setMediaSecret(String str) {
            this.mediaSecret = str;
            return this;
        }

        public Builder setProviders(String... strArr) {
            this.providers = strArr;
            return this;
        }

        @Deprecated
        public Builder setPtgAppId(String str) {
            this.vendorId = str;
            return this;
        }

        public Builder setPtgCustomController(PtgCustomController ptgCustomController) {
            this.ptgCustomController = ptgCustomController;
            return this;
        }

        public Builder setSdkLogo(int i) {
            this.sdkLogoId = i;
            return this;
        }

        public Builder setSdkLogo(String str) {
            this.sdkLogoUrl = str;
            return this;
        }

        public Builder setSupportHttp(Boolean bool) {
            this.supportHttp = bool;
            return this;
        }

        public Builder setSupportMultiProcess(boolean z) {
            this.supportMultiProcess = z;
            return this;
        }

        public boolean supportMultiProcess() {
            return this.supportMultiProcess;
        }
    }

    public PtgSDKConfig() {
        this.ptgApiUrl = "";
        this.policyVersion = "";
        try {
            this.ptgApiUrl = URLDecoder.decode("https%3A%2F%2Fg.fancyapi.com%2Fs2s", "UTF-8");
        } catch (Exception unused) {
        }
        this.policyVersion = "1";
    }

    public String getAppId(String str) {
        Map<String, String> map = this.appIdMap;
        return map != null ? map.get(str) : "";
    }

    public Map<String, String> getAppIdMap() {
        return this.appIdMap;
    }

    public Map<String, String> getAppKeyMap() {
        return this.appKeyMap;
    }

    public String getAppName() {
        return this.appName;
    }

    public String getAppVersionCode() {
        return this.appVersionCode;
    }

    public String getAppVersionName() {
        return this.appVersionName;
    }

    public String getBaseTrackingUrl() {
        return this.baseTrackingUrl;
    }

    public int getBlin() {
        return this.blin;
    }

    public String getChannel() {
        return "fancy";
    }

    public int getDelayLin() {
        return this.delayLin;
    }

    public String getDetectRule() {
        return this.detectRule;
    }

    public long getDetectRuleInterval() {
        return this.detectRuleInterval;
    }

    public List<String> getDpWhiteList() {
        return this.dpWhiteList;
    }

    public int getFdRule() {
        return this.fdRule;
    }

    public long getInitTime() {
        long j = this.initStartTime;
        if (j > 0) {
            long j2 = this.initEndTime;
            if (j2 > 0) {
                return j2 - j;
            }
        }
        return 0L;
    }

    public String getInitTrackingUrl() {
        return this.initTrackingUrl;
    }

    public String getKeyToken() {
        return this.keyToken;
    }

    public int getLessThanVc() {
        if (this.lessThanVc == null) {
            try {
                Context context = PtgAdSdk.getContext();
                if (context != null) {
                    String str_d = _kr._d(context, "sdk_local_less_than");
                    if (!TextUtils.isEmpty(str_d) && TextUtils.isDigitsOnly(str_d)) {
                        this.lessThanVc = Integer.valueOf(Integer.parseInt(str_d));
                    }
                }
            } catch (Exception unused) {
            }
            if (this.lessThanVc == null) {
                this.lessThanVc = 24;
            }
        }
        return this.lessThanVc.intValue();
    }

    public int getLin() {
        return this.lin;
    }

    public int getLinc() {
        return this.linc;
    }

    public int getLind() {
        return this.lind;
    }

    public String getLocalPolicyEncode() {
        return this.localPolicyEncode;
    }

    public File getLocalPolicyFile() {
        return this.localPolicyFile;
    }

    public InputStream getLocalPolicyFileInputStream() {
        return this.localPolicyFileInputStream;
    }

    public String getMediaId() {
        return this.mediaId;
    }

    public String getMediaSecret() {
        return this.mediaSecret;
    }

    public int getMediaStatus() {
        return this.mediaStatus;
    }

    public String getPUrl(Context context) {
        return _kr._d(context, "p_url");
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getPolicyUrl() {
        Context context = PtgAdSdk.getContext();
        String str_d = context != null ? _kr._d(context, "ptg_policy_url") : "";
        return str_d == null ? "" : str_d;
    }

    public String getPolicyVersion() {
        return this.policyVersion;
    }

    public String[] getProviders() {
        return this.providers;
    }

    public String getPtgApiUrl() {
        return this.ptgApiUrl;
    }

    public PtgCustomController getPtgCustomController() {
        return this.ptgCustomController;
    }

    public List<String> getQaList() {
        return this.qaList;
    }

    public int getQaNRTime() {
        return this.qaNRTime;
    }

    public long getRtbLogInterval(Context context) {
        return _kr._b(context, "rtb_log_interval");
    }

    public String getRtbLogUrl(Context context) {
        return _kr._d(context, "rtb_log_url");
    }

    public int getSdkLogoId() {
        return this.sdkLogoId;
    }

    public String getSdkLogoUrl() {
        return this.sdkLogoUrl;
    }

    public String getSdkVersionCode() {
        return "200900063";
    }

    public String getSdkVersionName() {
        return "2.9.63";
    }

    public int getSlin() {
        return this.slin;
    }

    public Boolean getSupportHttp() {
        return this.supportHttp;
    }

    public String getVendorId() {
        return this.vendorId;
    }

    public String getWechatAppId() {
        return this.wechatAppId;
    }

    public boolean imageUpgrade() {
        return this.imageUpgrade == 0;
    }

    public boolean isAllowDirectDownloadOverMobileNetwork() {
        return this.allowDirectDownloadOverMobileNetwork;
    }

    public boolean isAllowDirectDownloadOverWifiNetwork() {
        return this.allowDirectDownloadOverWifiNetwork;
    }

    public boolean isDebug() {
        return this.debug;
    }

    public boolean isPersonalizedState() {
        return _kr._a(PtgAdSdk.getContext(), "ptg_personalized_state");
    }

    public boolean isProgrammaticRecommendState() {
        return _kr._a(PtgAdSdk.getContext(), "ptg_programmatic_recommend_state");
    }

    public boolean isSensorStatus() {
        return _kr._a(PtgAdSdk.getContext(), "ptg_sensor_status");
    }

    public int isSupport() {
        return 0;
    }

    public void setAllowDirectDownloadOverMobileNetwork(boolean z) {
        this.allowDirectDownloadOverMobileNetwork = z;
    }

    public void setAllowDirectDownloadOverWifiNetwork(boolean z) {
        this.allowDirectDownloadOverWifiNetwork = z;
    }

    public void setAppIdMap(Map<String, String> map) {
        this.appIdMap = map;
    }

    public void setAppKeyMap(Map<String, String> map) {
        this.appKeyMap = map;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public void setAppVersionCode(String str) {
        this.appVersionCode = str;
    }

    public void setAppVersionName(String str) {
        this.appVersionName = str;
    }

    public void setBaseTrackingUrl(String str) {
        this.baseTrackingUrl = str;
    }

    public void setBlin(int i) {
        this.blin = i;
    }

    public void setDebug(boolean z) {
        this.debug = z;
        if (z) {
            Logger.openDebug();
        }
    }

    public void setDelayLin(int i) {
        this.delayLin = i;
    }

    public void setDetectRule(String str) {
        this.detectRule = str;
    }

    public void setDetectRuleInterval(long j) {
        this.detectRuleInterval = j;
    }

    public void setDpWhiteList(List<String> list) {
        this.dpWhiteList = list;
    }

    public void setFdRule(int i) {
        this.fdRule = i;
    }

    public void setImageUpgrade(int i) {
        this.imageUpgrade = i;
    }

    public void setInitEndTime() {
        this.initEndTime = System.currentTimeMillis();
    }

    public void setInitStartTime() {
        this.initStartTime = System.currentTimeMillis();
    }

    public void setInitTrackingUrl(String str) {
        this.initTrackingUrl = str;
    }

    public void setKeyToken(String str) {
        this.keyToken = str;
    }

    public void setLessThanVc(Context context, int i) {
        this.lessThanVc = Integer.valueOf(i);
        if (context != null) {
            _kr._a(context, "sdk_local_less_than", String.valueOf(i));
        }
    }

    public void setLin(int i) {
        this.lin = i;
    }

    public void setLinc(int i) {
        this.linc = i;
    }

    public void setLind(int i) {
        this.lind = i;
    }

    public void setLocalPolicyEncode(String str) {
        this.localPolicyEncode = str;
    }

    public void setLocalPolicyFile(File file) {
        this.localPolicyFile = file;
    }

    public void setLocalPolicyFileInputStream(InputStream inputStream) {
        this.localPolicyFileInputStream = inputStream;
    }

    public void setMediaId(String str) {
        this.mediaId = str;
    }

    public void setMediaSecret(String str) {
        this.mediaSecret = str;
    }

    public void setMediaStatus(int i) {
        this.mediaStatus = i;
    }

    public void setPUrl(Context context, String str) {
        _kr._a(context, "p_url", str);
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPersonalizedState(boolean z) {
        Context context = PtgAdSdk.getContext();
        if (context == null) {
            ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
        } else {
            _kr._b(Boolean.valueOf(z), "ptg_personalized_state");
            com.fancy.adsdk.lib.utils._d._b(new _kp(context, "ptg_personalized_state", z));
        }
    }

    public void setPolicyUrl(String str) {
        Context context = PtgAdSdk.getContext();
        if (context != null) {
            _kr._a(context, "ptg_policy_url", str);
        }
    }

    public void setPolicyVersion(String str) {
        this.policyVersion = str;
    }

    public void setProgrammaticRecommendState(boolean z) {
        Context context = PtgAdSdk.getContext();
        if (context == null) {
            ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
        } else {
            _kr._b(Boolean.valueOf(z), "ptg_programmatic_recommend_state");
            com.fancy.adsdk.lib.utils._d._b(new _kp(context, "ptg_programmatic_recommend_state", z));
        }
    }

    public void setProviders(String... strArr) {
        this.providers = strArr;
    }

    public void setPtgApiUrl(String str) {
        this.ptgApiUrl = str;
    }

    public void setPtgCustomController(PtgCustomController ptgCustomController) {
        if (ptgCustomController != null) {
            this.ptgCustomController = ptgCustomController;
        }
    }

    public void setQaList(List<String> list) {
        this.qaList = list;
    }

    public void setQaNRTime(int i) {
        this.qaNRTime = i;
    }

    public void setRtbLogInterval(Context context, long j) {
        _kr._a(context, "rtb_log_interval", j);
    }

    public void setRtbLogUrl(Context context, String str) {
        _kr._a(context, "rtb_log_url", str);
    }

    public void setSdkLogoId(int i) {
        this.sdkLogoId = i;
    }

    public void setSdkLogoUrl(String str) {
        this.sdkLogoUrl = str;
    }

    public void setSensorStatus(boolean z) {
        Context context = PtgAdSdk.getContext();
        if (context == null) {
            ConcurrentHashMap<String, SharedPreferences> concurrentHashMap = _kr._a;
        } else {
            _kr._b(Boolean.valueOf(z), "ptg_sensor_status");
            com.fancy.adsdk.lib.utils._d._b(new _kp(context, "ptg_sensor_status", z));
        }
    }

    public void setSlin(int i) {
        this.slin = i;
    }

    public void setSupportHttp(Boolean bool) {
        this.supportHttp = bool;
    }

    public void setSupportMultiProcess(boolean z) {
        this.supportMultiProcess = z;
    }

    public void setVendorId(String str) {
        this.vendorId = str;
    }

    public void setWechatAppId(String str) {
        this.wechatAppId = str;
    }

    public boolean supportMultiProcess() {
        return this.supportMultiProcess;
    }
}
