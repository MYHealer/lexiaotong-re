package com.bytedance.sdk.openadsdk.mediation;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IMediationPreloadRequestInfo {
    AdSlot getAdSlot();

    int getAdType();

    List<String> getPrimeRitList();
}
