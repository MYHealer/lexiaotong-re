package com.hihonor.adsdk.base.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RewardBean {
    private String adId;
    private String adRequestId;
    private int adType;
    private String adUnitId;
    private String appPackage;
    private String appVersion;
    private int dataType;
    private List<Integer> incentivePoints = new ArrayList();
    private boolean isClickReward;
    private String mChannelInfo;
    private String mTemplateId;
    private int sequence;

    public RewardBean(BaseAdInfo baseAdInfo) {
        this.adRequestId = baseAdInfo.getAdRequestId();
        this.adUnitId = baseAdInfo.getAdUnitId();
        this.adId = baseAdInfo.getAdId();
        this.appPackage = baseAdInfo.getAppPackage();
        this.sequence = baseAdInfo.getSequence();
        this.appVersion = baseAdInfo.getAppVersion();
        this.mChannelInfo = baseAdInfo.channelInfo;
        if (!com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) baseAdInfo.getIncentivePoints())) {
            Iterator<Integer> it = baseAdInfo.getIncentivePoints().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (iIntValue == 1) {
                    this.isClickReward = true;
                } else {
                    this.incentivePoints.add(Integer.valueOf(iIntValue));
                }
            }
        }
        this.adType = baseAdInfo.getAdType();
        this.dataType = baseAdInfo.getDataType();
        this.mTemplateId = baseAdInfo.getTemplateId();
    }

    public String getAdId() {
        return this.adId;
    }

    public String getAdRequestId() {
        return this.adRequestId;
    }

    public int getAdType() {
        return this.adType;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getAppPackage() {
        return this.appPackage;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getChannelInfo() {
        return this.mChannelInfo;
    }

    public int getDataType() {
        return this.dataType;
    }

    public List<Integer> getIncentivePoints() {
        return this.incentivePoints;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String getTemplateId() {
        return this.mTemplateId;
    }

    public boolean isClickReward() {
        return this.isClickReward;
    }
}
