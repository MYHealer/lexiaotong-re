package com.meishu.sdk.platform.duomeng;

import android.content.Context;
import android.location.Location;
import com.domob.sdk.common.config.DMConfig;
import com.domob.sdk.common.config.PermissionConfig;
import com.domob.sdk.platform.DMAdSdk;
import com.meishu.sdk.core.AdSdk;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class DmInitManager {
    private static final String TAG = "DmInitManager";
    private static DmInitManager sInstance;
    private boolean isInit;

    public interface InitCallback {
        void onError(int i, String str);

        void onSuccess();
    }

    public static synchronized DmInitManager getInstance() {
        if (sInstance == null) {
            sInstance = new DmInitManager();
        }
        return sInstance;
    }

    public synchronized void initSdk(Context context, String str, InitCallback initCallback) {
        try {
            if (this.isInit) {
                if (initCallback != null) {
                    initCallback.onSuccess();
                }
                return;
            }
            try {
                DMAdSdk.getInstance().init(StubApp.getOrigApplicationContext(context.getApplicationContext()), new DMConfig().debug(false).setPermission(new PermissionConfig() { // from class: com.meishu.sdk.platform.duomeng.DmInitManager.1
                    public String getAndroidId() {
                        return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getAndroidId() : super.getAndroidId();
                    }

                    public String getImei() {
                        return super.getImei();
                    }

                    public Location getLocation() {
                        return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getLocation() : super.getLocation();
                    }

                    public String getOAID() {
                        return AdSdk.getLocalOaid();
                    }

                    public boolean isCanGetAndroidId() {
                        return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseAndroidId() : super.isCanGetAndroidId();
                    }

                    public boolean isCanGetAppList() {
                        return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canReadInstalledPackages() : super.isCanGetAppList();
                    }

                    public boolean isCanGetLocation() {
                        return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseLocation() : super.isCanGetLocation();
                    }

                    public boolean isCanGetOAID() {
                        return false;
                    }

                    public boolean isCanGetPhoneState() {
                        return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUsePhoneState() : super.isCanGetPhoneState();
                    }

                    public boolean isCanUseStorage() {
                        return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canUseStoragePermission() : super.isCanUseStorage();
                    }

                    public boolean isUsePersonalRecommend() {
                        return AdSdk.adConfig().getCanUseSdkPersonalRecommend();
                    }
                }));
                this.isInit = true;
                if (initCallback != null) {
                    initCallback.onSuccess();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
