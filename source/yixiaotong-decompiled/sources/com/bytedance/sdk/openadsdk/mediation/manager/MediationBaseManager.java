package com.bytedance.sdk.openadsdk.mediation.manager;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface MediationBaseManager {
    List<MediationAdLoadInfo> getAdLoadInfo();

    MediationAdEcpmInfo getBestEcpm();

    List<MediationAdEcpmInfo> getCacheList();

    List<MediationAdEcpmInfo> getMultiBiddingEcpm();

    MediationAdEcpmInfo getShowEcpm();

    boolean isReady();
}
