package com.meishu.sdk.platform.csj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.b;
import com.meishu.sdk.core.utils.j0;
import com.meishu.sdk.core.utils.x0;
import com.stub.StubApp;
import com.ubixnow.ooooo.oOOOoo00;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJAdConfig extends b {
    private static final String TAG = "CSJAdConfig";
    private String appName = "";
    private String personalTypeValue = "1";
    private TTAdConfig ttAdConfig;

    private TTAdConfig buildTTConfig(String str) {
        if (AdSdk.adConfig().getCanUseSdkPersonalRecommend()) {
            this.personalTypeValue = "1";
        } else {
            this.personalTypeValue = "0";
        }
        TTAdConfig.Builder builder = new TTAdConfig.Builder();
        if (j0.b) {
            try {
                Method declaredMethod = Class.forName("com.bytedance.sdk.openadsdk.TTAdConfig$Builder").getDeclaredMethod("useMediation", Boolean.TYPE);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(builder, Boolean.TRUE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        builder.appId(str).debug(AdSdk.adConfig().enableDebug()).appName(this.appName).titleBarTheme(1).data(getData(this.personalTypeValue)).allowShowNotify(AdSdk.adConfig().enableNotify()).supportMultiProcess(false).customController(new TTCustomController() { // from class: com.meishu.sdk.platform.csj.CSJAdConfig.3
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canReadInstalledPackages() : super.alist();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getDevImei() : super.getDevImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                return AdSdk.getLocalOaid();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getMacAddress() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getMacAddress() : super.getMacAddress();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getTTLocation() : super.getTTLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseAndroidId() : super.isCanUseAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                if (AdSdk.adConfig().customController() != null) {
                    return AdSdk.adConfig().customController().isCanUseLocation();
                }
                return true;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUsePermissionRecordAudio() : super.isCanUsePermissionRecordAudio();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                if (AdSdk.adConfig().customController() == null) {
                    return super.isCanUsePhoneState();
                }
                if (AdSdk.adConfig().customController().isCsjUsePhoneState()) {
                    return AdSdk.adConfig().customController().isCanUsePhoneState();
                }
                return false;
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseWifiState() : super.isCanUseWifiState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canUseStoragePermission() : super.isCanUseWriteExternal();
            }
        });
        if (AdSdk.adConfig().userKeywords() != null) {
            builder.keywords(AdSdk.adConfig().userKeywords());
        }
        int iDownloadConfirm = AdSdk.adConfig().downloadConfirm();
        if (iDownloadConfirm == 1) {
            builder.directDownloadNetworkType(new int[0]);
        } else if (iDownloadConfirm != 2) {
            builder.directDownloadNetworkType(4);
        } else {
            builder.directDownloadNetworkType(4, 1);
        }
        builder.debug(AdSdk.adConfig().enableDebug());
        return builder.build();
    }

    private String getData(String str) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", "personal_ads_type");
            jSONObject.put(oOOOoo00.OooOo0o, str);
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static TTAdManager getTtAdManager() {
        return TTAdSdk.getAdManager();
    }

    public static boolean isInitSuccess() {
        return TTAdSdk.isInitSuccess();
    }

    private void updateData(String str) {
        TTAdSdk.updateAdConfig(new TTAdConfig.Builder().data(getData(str)).build());
    }

    @Override // com.meishu.sdk.core.b
    public void onInit(Context context, String str, String str2) {
        this.appName = x0.b(context);
        if (this.ttAdConfig == null) {
            this.ttAdConfig = buildTTConfig(str);
            try {
                Class<?> cls = Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk$InitCallback");
                Class<?> cls2 = Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk");
                try {
                    Class<?> cls3 = Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk$Callback");
                    cls2.getDeclaredMethod("init", Context.class, TTAdConfig.class).invoke(null, StubApp.getOrigApplicationContext(context.getApplicationContext()), this.ttAdConfig);
                    cls2.getDeclaredMethod("start", cls3).invoke(null, Proxy.newProxyInstance(CSJAdConfig.class.getClassLoader(), new Class[]{cls3}, new InvocationHandler() { // from class: com.meishu.sdk.platform.csj.CSJAdConfig.1
                        @Override // java.lang.reflect.InvocationHandler
                        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                            "success".equals(method.getName());
                            return null;
                        }
                    }));
                } catch (Exception unused) {
                    cls2.getDeclaredMethod("init", Context.class, TTAdConfig.class, cls).invoke(null, StubApp.getOrigApplicationContext(context.getApplicationContext()), this.ttAdConfig, Proxy.newProxyInstance(CSJAdConfig.class.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: com.meishu.sdk.platform.csj.CSJAdConfig.2
                        @Override // java.lang.reflect.InvocationHandler
                        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                            return null;
                        }
                    }));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
