package com.jd.ad.sdk.mdt.service;

import com.jd.ad.sdk.bl.adload.JADAdLoadListener;
import com.jd.ad.sdk.dl.addata.JADMaterialData;
import com.jd.ad.sdk.dl.model.IJADExtra;
import com.jd.ad.sdk.dl.model.JADSlot;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface JADAdService {
    boolean enablePreloadAd(String str, JADSlot jADSlot);

    IJADExtra getJADExtra(String str);

    List<JADMaterialData> getJADMaterialDataList(String str);

    void loadAd(String str, JADSlot jADSlot, JADAdLoadListener jADAdLoadListener);

    void loadAdFromCache(String str, JADSlot jADSlot, JADAdLoadListener jADAdLoadListener);

    void printRequestData(JADSlot jADSlot);

    void registerAd(String str);

    void registerAdPreloader(String str, JADSlot jADSlot);

    void removeData(String str);

    void unregisterAd(String str);

    void unregisterAdPreloader(String str, JADSlot jADSlot);
}
