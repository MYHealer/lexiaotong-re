package com.meishu.sdk.platform.pangle;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class PangleInitManager {
    private static final String TAG = "PangleInitManager";
    private static PangleInitManager sInstance;
    private boolean isInit;

    public interface InitCallback {
        void onError(int i, String str);

        void onSuccess();
    }

    private static PAGConfig buildNewConfig(Context context, String str) {
        return new PAGConfig.Builder().appId(str).debugLog(true).build();
    }

    public static synchronized PangleInitManager getInstance() {
        if (sInstance == null) {
            sInstance = new PangleInitManager();
        }
        return sInstance;
    }

    public synchronized void initSdk(Context context, String str, final InitCallback initCallback) {
        if (!this.isInit) {
            PAGSdk.init(context, buildNewConfig(context, str), new PAGSdk.PAGInitCallback() { // from class: com.meishu.sdk.platform.pangle.PangleInitManager.1
                public void fail(int i, String str2) {
                    Log.i(PangleInitManager.TAG, "pangle init fail: " + i);
                    InitCallback initCallback2 = initCallback;
                    if (initCallback2 != null) {
                        initCallback2.onError(i, str2);
                    }
                }

                public void success() {
                    Log.i(PangleInitManager.TAG, "pangle init success: ");
                    PangleInitManager.this.isInit = true;
                    InitCallback initCallback2 = initCallback;
                    if (initCallback2 != null) {
                        initCallback2.onSuccess();
                    }
                }
            });
        } else {
            if (initCallback != null) {
                initCallback.onSuccess();
            }
        }
    }
}
