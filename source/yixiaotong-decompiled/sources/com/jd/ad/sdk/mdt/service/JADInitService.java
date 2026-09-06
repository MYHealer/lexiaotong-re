package com.jd.ad.sdk.mdt.service;

import com.jd.ad.sdk.dl.model.JADSlot;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADInitService {
    void createDefaultAdInstance(JADSlot jADSlot);

    String getAdUrl(String str);

    int getDs(String str);

    float getFeedShakeAngleValue();

    float getFeedShakeSensitivityValue();

    float getFeedShakeTimeValue();

    int getJumpToH5DelayTime();

    int getNeedCheckMediaClickH5();

    int getOpenReflectOaid();

    int getR(String str);

    int getSen(String str);

    float getShakeAngleValue();

    float getShakeSensitivityValue();

    float getShakeTimeValue();

    float getSwipeAngle();

    float getSwipeLength();

    boolean isForbidModelToH5();
}
