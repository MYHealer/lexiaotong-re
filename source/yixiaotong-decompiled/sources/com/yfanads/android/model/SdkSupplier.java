package com.yfanads.android.model;

import android.text.TextUtils;
import com.alipay.sdk.util.e;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.thirdpart.gson.annotations.Expose;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFLog;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class SdkSupplier implements Serializable {

    @Expose
    @SerializedName("abID")
    private String abId;

    @Expose
    private String adId;
    private AdInfo adInfo;

    @Expose
    public int adType;
    private int cType;
    private long cacheTimeout;
    private Object custom;

    @Expose
    @SerializedName("ecpm")
    public long ecpm;
    private long flowTime;

    @Expose
    @SerializedName("gID")
    private String gId;

    @Expose
    public int index;
    private boolean isBidSuccess;
    private long lastLoadTime;

    @Expose
    @SerializedName("layerID")
    public String layerId;

    @Expose
    public NetworkDTO network;

    @Expose
    public int position;

    @Expose
    @SerializedName("rID")
    private String rId;
    private int refreshInterval;

    @Expose
    public long requestTimeout;

    @Expose
    @SerializedName("sID")
    private String sId;
    private long waterfallTime;
    private final AtomicInteger adStatus = new AtomicInteger(-1);
    private boolean isFromCache = false;
    private boolean isOverPrice = true;
    private long oldBEcpm = -1;

    public static class NetworkDTO implements Serializable {

        @Expose
        @SerializedName("networkID")
        public int networkId;

        @Expose
        public ParamDTO param;

        public static class ParamDTO implements Serializable {

            @Expose
            @SerializedName(YFAdsConst.REPORT_APPID)
            public String appId;

            @Expose
            @SerializedName("appKey")
            public String appKey;

            @Expose
            @SerializedName("appSecret")
            public String appSecret;

            @Expose
            @SerializedName("appToken")
            public String appToken;

            @Expose
            @SerializedName("cfg")
            public TemplateConf cfg;

            @Expose
            @SerializedName("headBidding")
            public int headBidding;

            @Expose
            @SerializedName("potID")
            public String potId;

            @Expose
            @SerializedName("renderID")
            public int renderId;

            @Expose
            @SerializedName("tpid")
            public String tpId;

            @Expose
            @SerializedName("wxAppID")
            public String wxAppId;
        }
    }

    private String adStatus() {
        int i = this.adStatus.get();
        if (i == 0) {
            return "loading";
        }
        if (i == 1) {
            return "success";
        }
        if (i == 2) {
            return e.f1657a;
        }
        if (i == 3) {
            return "startShow";
        }
        if (i != 4) {
            return i != 5 ? "default" : "exposure";
        }
        return "timeOut";
    }

    private String getPoId() {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.potId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SdkSupplier sdkSupplier = (SdkSupplier) obj;
        String potId = getPotId();
        return !TextUtils.isEmpty(potId) && potId.equals(sdkSupplier.getPotId());
    }

    public String getAdId() {
        return this.adId;
    }

    public AdInfo getAdInfo() {
        return this.adInfo;
    }

    public int getAdStatus() {
        return this.adStatus.get();
    }

    public String getAdnAdId() {
        return getPoId();
    }

    public String getAdnAppId() {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.appId;
    }

    public String getAdnId() {
        NetworkDTO networkDTO = this.network;
        return networkDTO != null ? String.valueOf(networkDTO.networkId) : "";
    }

    public int getAdnIdValue() {
        NetworkDTO networkDTO = this.network;
        if (networkDTO != null) {
            return networkDTO.networkId;
        }
        return -1;
    }

    public String getAppId() {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.appId;
    }

    public int getCType() {
        return this.cType;
    }

    public int getChannel() {
        NetworkDTO networkDTO = this.network;
        if (networkDTO != null) {
            return networkDTO.networkId;
        }
        return -1;
    }

    public Object getCustom() {
        return this.custom;
    }

    public long getFlowTime() {
        return this.flowTime;
    }

    public long getOldBEcpm() {
        return this.oldBEcpm;
    }

    public String getPotId() {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.potId;
    }

    public int getRefreshInterval() {
        return this.refreshInterval;
    }

    public int getRenderId(int i) {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null) ? i : paramDTO.renderId;
    }

    public void getReport(EventData eventData) {
        if (eventData == null) {
            return;
        }
        eventData.sId = this.sId;
        eventData.abId = this.abId;
        eventData.gId = this.gId;
        eventData.adId = this.adId;
        eventData.aType = this.adType;
        eventData.lId = this.layerId;
        eventData.rId = this.rId;
        NetworkDTO networkDTO = this.network;
        if (networkDTO != null) {
            eventData.adnId = networkDTO.networkId;
            NetworkDTO.ParamDTO paramDTO = networkDTO.param;
            if (paramDTO != null) {
                eventData.adnAdId = paramDTO.potId;
                eventData.adnAppId = paramDTO.appId;
                eventData.isBid = paramDTO.headBidding;
            }
        }
        eventData.ecpm = this.ecpm;
    }

    public String getReqId() {
        return this.rId;
    }

    public String getSessionId() {
        return this.sId;
    }

    public String getSourceByLog() {
        return YFAdsConst.getSource(this.network.networkId);
    }

    public TemplateConf getTemplateConf() {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        if (networkDTO == null || (paramDTO = networkDTO.param) == null) {
            return null;
        }
        return paramDTO.cfg;
    }

    public String getTemplateKey(String str) {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null) ? str : paramDTO.tpId;
    }

    public long getWaterfallTime() {
        return this.waterfallTime;
    }

    public String getWxAppId() {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null) ? "" : paramDTO.wxAppId;
    }

    public boolean hasNoLastLoadTime() {
        return this.lastLoadTime <= 0;
    }

    public int hashCode() {
        String potId = getPotId();
        return TextUtils.isEmpty(potId) ? super.hashCode() : potId.hashCode() + 527;
    }

    public boolean isAdStatus(int i) {
        return this.adStatus.get() == i;
    }

    public boolean isBanner() {
        return this.adType == YFAdType.BANNER.getType() && getRenderId(1) == 1;
    }

    public boolean isBidSuccess() {
        return this.isBidSuccess;
    }

    public boolean isBidding() {
        NetworkDTO.ParamDTO paramDTO;
        NetworkDTO networkDTO = this.network;
        return (networkDTO == null || (paramDTO = networkDTO.param) == null || paramDTO.headBidding != 1) ? false : true;
    }

    public boolean isCacheExpires() {
        return System.currentTimeMillis() - this.lastLoadTime > this.cacheTimeout;
    }

    public boolean isControlClickChannel() {
        int i;
        NetworkDTO networkDTO = this.network;
        return networkDTO != null && ((i = networkDTO.networkId) == 12 || i == 1 || i == 11 || i == 2 || i == 3 || i == 4 || i == 9);
    }

    public boolean isDevelop() {
        return this.adType == YFAdType.NATIV.getType() && getRenderId(1) == 3;
    }

    public boolean isFromCache() {
        return this.isFromCache;
    }

    public boolean isInterNative() {
        YFLog.debug("isInterNative cType: " + this.cType + " renderId: " + getRenderId(1));
        return this.cType == YFAdType.INTR.getType() && getRenderId(1) == 2;
    }

    public boolean isLoadFailed() {
        return this.adStatus.get() == 2;
    }

    public boolean isLoadSuccess() {
        return this.adStatus.get() == 1;
    }

    public boolean isLoading() {
        return this.adStatus.get() == 0;
    }

    public boolean isMute() {
        return isMuted();
    }

    public boolean isMuted() {
        return getTemplateConf() == null || getTemplateConf().vm == 1;
    }

    public boolean isNative() {
        return this.adType == YFAdType.NATIV.getType() && getRenderId(1) == 2;
    }

    public boolean isOverPrice() {
        return this.isOverPrice;
    }

    public boolean isShakeAction() {
        TemplateConf templateConf = getTemplateConf();
        if (templateConf == null) {
            return false;
        }
        int i = templateConf.is;
        return i == 2 || i == 3;
    }

    public boolean isTemplate() {
        return this.adType == YFAdType.NATIV.getType() && getRenderId(1) == 1;
    }

    public boolean isTimeOut() {
        return this.adStatus.get() == 4;
    }

    public boolean isTwistAction() {
        TemplateConf templateConf = getTemplateConf();
        if (templateConf == null) {
            return false;
        }
        int i = templateConf.is;
        return i == 4 || i == 5;
    }

    public void setAdInfo(AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    public void setAdStatus(int i) {
        this.adStatus.set(i);
    }

    public void setBidSuccess(boolean z) {
        this.isBidSuccess = z;
    }

    public void setCType(int i) {
        this.cType = i;
    }

    public void setCacheTimeout(long j) {
        this.cacheTimeout = j;
    }

    public void setCustom(Object obj) {
        this.custom = obj;
    }

    public void setEcpm(long j, long j2) {
        if (this.oldBEcpm == -1) {
            this.oldBEcpm = j;
        }
        this.ecpm = j2;
        long j3 = this.oldBEcpm;
        this.isOverPrice = j3 <= 0 || j3 <= j2;
    }

    public void setFlowTime() {
        this.flowTime = System.currentTimeMillis();
    }

    public void setFromCache(boolean z) {
        this.isFromCache = z;
    }

    public void setRefreshInterval(int i) {
        this.refreshInterval = i;
    }

    public void setReqId(String str) {
        this.rId = str;
    }

    public void setWaterfallTime() {
        this.waterfallTime = System.currentTimeMillis();
    }

    public String toShortString() {
        return (!isBidding() ? "ps_" + this.position : "") + "|i_" + this.index + "|" + getSourceByLog() + "|" + getPoId() + "|b_" + isBidding() + "|p_" + this.ecpm + x.A + this.oldBEcpm + "|rid_" + this.rId;
    }

    public String toString() {
        AdInfo adInfo;
        boolean zIsBidding = isBidding();
        Object obj = "";
        StringBuilder sbAppend = new StringBuilder().append(!zIsBidding ? "ps_" + this.position : "").append("|i_").append(this.index).append("|").append(getSourceByLog()).append("|").append(getPoId()).append("|b_").append(zIsBidding).append("|c_").append(this.isFromCache).append("|p_").append(this.ecpm).append(zIsBidding ? x.A + this.oldBEcpm : "");
        if (UrlConst.isTestEnv() && (adInfo = this.adInfo) != null) {
            obj = adInfo;
        }
        return sbAppend.append(obj).toString();
    }

    public void updLastLoadTime() {
        this.lastLoadTime = System.currentTimeMillis();
    }

    public void updateData(String str) {
        setWaterfallTime();
        setFlowTime();
        this.rId = str;
    }

    public void initKeys(String str, String str2, String str3, String str4, String str5) {
        this.adId = str;
        this.sId = str2;
        this.abId = str3;
        this.gId = str4;
        this.rId = str5;
        this.flowTime = System.currentTimeMillis();
    }
}
