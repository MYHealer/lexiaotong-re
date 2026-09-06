package com.meishu.sdk.platform.tradplus;

import android.content.Context;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.MSAdConfig;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class TradPlusInitManager {
    public static final String APPID = "appId";
    public static final String ECPM = "ecpm";
    public static final String PLACEMENTID = "placementId";
    private boolean isInit;

    /* JADX INFO: renamed from: com.meishu.sdk.platform.tradplus.TradPlusInitManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public interface InitCallback {
        void onError();

        void onSuccess();
    }

    public static class TradPlusInitManagerHolder {
        private static final TradPlusInitManager instance = new TradPlusInitManager(null);

        private TradPlusInitManagerHolder() {
        }
    }

    public /* synthetic */ TradPlusInitManager(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static synchronized TradPlusInitManager getInstance() {
        return TradPlusInitManagerHolder.instance;
    }

    private void notifyError(InitCallback initCallback) {
        if (initCallback != null) {
            initCallback.onError();
        }
    }

    private void notifySuccess(InitCallback initCallback) {
        if (initCallback != null) {
            initCallback.onSuccess();
        }
    }

    public String getNetworkName() {
        return "MS";
    }

    private TradPlusInitManager() {
    }

    public void initSDK(Context context, Map<String, String> map, InitCallback initCallback) {
        try {
            if (this.isInit) {
                notifySuccess(initCallback);
                return;
            }
            AdSdk.init(context, new MSAdConfig.Builder().appId(map.get("appId")).enableDebug(true).downloadConfirm(1).build());
            this.isInit = true;
            notifySuccess(initCallback);
        } catch (Exception e) {
            e.printStackTrace();
            notifyError(initCallback);
        }
    }
}
