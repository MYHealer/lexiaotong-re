package com.bytedance.sdk.openadsdk;

import com.byazt.zqa.c;
import com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 1701})
public abstract class TTCustomController {
    public boolean alist() {
        return true;
    }

    public String getAndroidId() {
        return null;
    }

    public String getDevImei() {
        return null;
    }

    public String getDevOaid() {
        return null;
    }

    public String getMacAddress() {
        return null;
    }

    public IMediationPrivacyConfig getMediationPrivacyConfig() {
        return null;
    }

    public LocationProvider getTTLocation() {
        return null;
    }

    public boolean isCanUseAndroidId() {
        return true;
    }

    public boolean isCanUseLocation() {
        return true;
    }

    public boolean isCanUseMessage() {
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

    public boolean isCanUseWriteExternal() {
        return true;
    }

    public Map<String, Object> userPrivacyConfig() {
        return null;
    }
}
