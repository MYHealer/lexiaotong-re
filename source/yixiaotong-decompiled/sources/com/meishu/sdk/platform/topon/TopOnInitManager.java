package com.meishu.sdk.platform.topon;

import android.content.Context;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.api.MediationInitCallback;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TopOnInitManager extends ATInitMediation {
    private static final String TAG = "TopOnInitManager";
    private static TopOnInitManager sInstance;
    private MSAdConfig.CustomController customController;
    private boolean isInit;
    private boolean enableOaid = true;
    private boolean enableInstallBroadcast = true;
    private boolean enableBootId = true;
    private int secure = -1;

    private TopOnInitManager() {
    }

    public int getAdapterBridgeVersion() {
        return 0;
    }

    public String getNetworkName() {
        return "MS";
    }

    public String getNetworkVersion() {
        return AdSdk.getVersionName();
    }

    public void setCustomController(MSAdConfig.CustomController customController) {
        this.customController = customController;
    }

    public void setEnableBootId(boolean z) {
        this.enableBootId = z;
    }

    public void setEnableInstallBroadcast(boolean z) {
        this.enableInstallBroadcast = z;
    }

    public void setEnableOaid(boolean z) {
        this.enableOaid = z;
    }

    public void setSecure(int i) {
        this.secure = i;
    }

    public static TopOnInitManager getInstance() {
        if (sInstance == null) {
            synchronized (TopOnInitManager.class) {
                if (sInstance == null) {
                    sInstance = new TopOnInitManager();
                }
            }
        }
        return sInstance;
    }

    public void initSDK(Context context, Map<String, Object> map, MediationInitCallback mediationInitCallback) {
        if (this.isInit) {
            mediationInitCallback.onSuccess();
            return;
        }
        MSAdConfig.Builder builderDownloadConfirm = new MSAdConfig.Builder().appId((String) map.get("app_id")).enableOaid(this.enableOaid).enableInstallBroadcast(this.enableInstallBroadcast).enableBootId(this.enableBootId).enableDebug(true).secure(this.secure).downloadConfirm(1);
        MSAdConfig.CustomController customController = this.customController;
        if (customController != null) {
            builderDownloadConfirm.customController(customController);
        }
        AdSdk.init(context, builderDownloadConfirm.build());
        this.isInit = true;
        mediationInitCallback.onSuccess();
    }
}
