package com.bytedance.sdk.openadsdk.mediation.init;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public interface IMediationConfig {
    JSONObject getCustomLocalConfig();

    boolean getHttps();

    Map<String, Object> getLocalExtra();

    MediationConfigUserInfoForSegment getMediationConfigUserInfoForSegment();

    String getOpensdkVer();

    String getPublisherDid();

    boolean isOpenAdnTest();

    boolean isSupportH265();

    boolean isSupportSplashZoomout();

    boolean isWxInstalled();

    String wxAppId();
}
