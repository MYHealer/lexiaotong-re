package com.bytedance.msdk.adapter.baidu;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.bytedance.msdk.adapter.BaiduMobAds.BuildConfig;
import com.bytedance.msdk.adapter.baidu.base.MediationInitBaseFunction;
import com.bytedance.msdk.adapter.baidu.base.config.MediationInitConfig;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduAdapterConfiguration extends MediationInitBaseFunction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f2978a = false;

    private void a() {
        BaiduAdapterUtil.printPrivacyLog(this.mInitConfig);
        MobadsPermissionSettings.setPermissionReadDeviceID(this.mInitConfig.isCanUsePhoneState());
        MobadsPermissionSettings.setPermissionLocation(this.mInitConfig.isCanUseLocation());
        MobadsPermissionSettings.setPermissionStorage(this.mInitConfig.isCanUseWriteExternal());
        MobadsPermissionSettings.setPermissionAppList(this.mInitConfig.appList());
        MobadsPermissionSettings.setLimitPersonalAds(this.mInitConfig.isLimitPersonalAds());
        MobadsPermissionSettings.setPermissionOAID(this.mInitConfig.isCanUseOaid());
        Log.d("Tme", "baidu_setPermissionOAID:" + this.mInitConfig.isCanUseOaid());
    }

    private boolean a(Context context, String str, String str2, Object obj) {
        String str3;
        if (context != null && str != null) {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                String strValueOf = String.valueOf(BaiduAdapterUtil.privacyEnableByName(this.mInitConfig, "installUninstallListen", true));
                BDAdConfig.Builder builderPutExtraParam = new BDAdConfig.Builder().setAppsid(str).putExtraParam("pk_change_rc", strValueOf).putExtraParam("mi_market_rc", strValueOf);
                if (!TextUtils.isEmpty(str2)) {
                    builderPutExtraParam.setWXAppid(str2);
                }
                if (obj instanceof Boolean) {
                    boolean zBooleanValue = ((Boolean) obj).booleanValue();
                    builderPutExtraParam.setCloseShake(zBooleanValue);
                    str3 = "--==-- baidu close shake: " + zBooleanValue;
                } else {
                    str3 = "--==-- baidu close shake: null";
                }
                Log.e("TMe", str3);
                Log.i("Tme", "baidu_p:" + strValueOf);
                builderPutExtraParam.build(context).init();
                notifyInitTime(1, jCurrentTimeMillis, System.currentTimeMillis());
                a();
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.MediationInitBaseFunction
    public <T> T callFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
        if (i == 8101) {
            return BuildConfig.ADAPTER_VERSION;
        }
        if (i == 8104) {
            try {
                return (T) AdSettings.getSDKVersion();
            } catch (Throwable th) {
                th.printStackTrace();
                return "0.0";
            }
        }
        if (i == 8105) {
            return (T) this.mInitConfig.getGromoreVersion();
        }
        if (i == 8124) {
            this.mInitConfig.setMediationCustomControllerValueSet(MediationValueUtil.objectValue(sparseArray.get(8517), Object.class, null));
            a();
        }
        return null;
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.MediationInitBaseFunction
    public void realInitAdn(Context context, MediationInitConfig mediationInitConfig) {
        synchronized (BaiduAdapterConfiguration.class) {
            if (this.f2978a) {
                notifySuccess();
            } else if (a(context, mediationInitConfig.getAppId(), mediationInitConfig.getWxAppId(), mediationInitConfig.getBaiduCloseShake())) {
                this.f2978a = true;
                notifySuccess();
            } else {
                notifyFail("baidu init fail");
            }
        }
    }
}
