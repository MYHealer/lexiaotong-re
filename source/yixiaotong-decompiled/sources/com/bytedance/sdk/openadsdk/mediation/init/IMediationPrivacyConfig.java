package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IMediationPrivacyConfig {
    List<String> getCustomAppList();

    List<String> getCustomDevImeis();

    boolean isCanUseOaid();

    boolean isLimitPersonalAds();

    boolean isProgrammaticRecommend();
}
