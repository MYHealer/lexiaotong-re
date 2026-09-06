package com.meishu.sdk.platform.sigmob.custom;

import android.content.Context;
import android.location.Location;
import com.meishu.sdk.core.AdSdk;
import com.meishu.sdk.core.utils.LogUtil;
import com.meishu.sdk.core.utils.ReflectUtil;
import com.meishu.sdk.platform.sigmob.custom.init.ProxyOnInitializationListener;
import com.meishu.sdk.platform.sigmob.custom.init.ProxyOnStartListener;
import com.sigmob.windad.OnInitializationListener;
import com.sigmob.windad.WindAdOptions;
import com.sigmob.windad.WindAds;
import com.sigmob.windad.WindCustomController;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SigmobCustomInitManager {
    public static final String TAG = "SigmobCustomInitManager";
    private static SigmobCustomInitManager sInstance;
    private boolean isInit;

    public interface InitCallback {
        void onError(int i, String str);

        void onSuccess();
    }

    private static boolean sensorCanUse() {
        try {
            List<Integer> disableSensorTypes = AdSdk.adConfig() != null ? AdSdk.adConfig().getDisableSensorTypes() : null;
            return (disableSensorTypes != null && disableSensorTypes.contains(1) && disableSensorTypes.contains(9) && disableSensorTypes.contains(4)) ? false : true;
        } catch (Exception unused) {
            return true;
        }
    }

    private static void setSensorStatus(WindAds windAds) {
        Method method = ReflectUtil.getMethod(WindAds.class, "setSensorStatus", Boolean.TYPE);
        if (method == null) {
            method = ReflectUtil.getMethod(WindAds.class, "setSensorStatus", Boolean.class);
        }
        if (method == null) {
            return;
        }
        ReflectUtil.invokeMethod(method, windAds, Boolean.valueOf(sensorCanUse()));
    }

    public static synchronized SigmobCustomInitManager getInstance() {
        if (sInstance == null) {
            sInstance = new SigmobCustomInitManager();
        }
        return sInstance;
    }

    public synchronized void initSdk(Context context, String str, String str2, final InitCallback initCallback) {
        if (this.isInit) {
            if (initCallback != null) {
                initCallback.onSuccess();
            }
            return;
        }
        final WindAds windAdsSharedAds = WindAds.sharedAds();
        windAdsSharedAds.setDebugEnable(AdSdk.adConfig() != null && AdSdk.adConfig().enableDebug());
        setSensorStatus(windAdsSharedAds);
        windAdsSharedAds.setPersonalizedAdvertisingOn(AdSdk.adConfig().getCanUseSdkPersonalRecommend());
        WindAdOptions windAdOptions = new WindAdOptions(str, str2);
        windAdOptions.setCustomController(new WindCustomController() { // from class: com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.1
            public String getAndroidId() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getAndroidId() : super.getAndroidId();
            }

            public String getDevImei() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getDevImei() : super.getDevImei();
            }

            public String getDevOaid() {
                return AdSdk.getLocalOaid();
            }

            public Location getLocation() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().getLocation() : super.getLocation();
            }

            public boolean isCanUseAndroidId() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseAndroidId() : super.isCanUseAndroidId();
            }

            public boolean isCanUseAppList() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().canReadInstalledPackages() : super.isCanUseAppList();
            }

            public boolean isCanUseLocation() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUseLocation() : super.isCanUseLocation();
            }

            public boolean isCanUsePhoneState() {
                return AdSdk.adConfig().customController() != null ? AdSdk.adConfig().customController().isCanUsePhoneState() : super.isCanUsePhoneState();
            }
        });
        Method method = ReflectUtil.getMethod(WindAds.class, "init", Context.class, WindAdOptions.class, OnInitializationListener.class);
        if (method != null) {
            LogUtil.dev(TAG, "new api");
            ReflectUtil.invokeMethod(method, windAdsSharedAds, context, windAdOptions, (OnInitializationListener) Proxy.newProxyInstance(OnInitializationListener.class.getClassLoader(), new Class[]{OnInitializationListener.class}, new ProxyOnInitializationListener(new InitCallback() { // from class: com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.2
                @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
                public void onError(int i, String str3) {
                    LogUtil.d(SigmobCustomInitManager.TAG, "onInitializationFail");
                    SigmobCustomInitManager.this.isInit = false;
                    InitCallback initCallback2 = initCallback;
                    if (initCallback2 != null) {
                        initCallback2.onError(-1, str3);
                    }
                }

                @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
                public void onSuccess() {
                    LogUtil.dev(SigmobCustomInitManager.TAG, "init success");
                    Class<?> cls = ReflectUtil.getClass("com.sigmob.windad.OnStartListener");
                    if (cls == null) {
                        LogUtil.d(SigmobCustomInitManager.TAG, "not find OnStartListener");
                        SigmobCustomInitManager.this.isInit = false;
                        InitCallback initCallback2 = initCallback;
                        if (initCallback2 != null) {
                            initCallback2.onError(-1, "not find com.sigmob.windad.OnStartListener");
                            return;
                        }
                        return;
                    }
                    Method method2 = ReflectUtil.getMethod(WindAds.class, "start", cls);
                    if (method2 != null) {
                        ReflectUtil.invokeMethod(method2, windAdsSharedAds, Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new ProxyOnStartListener(new InitCallback() { // from class: com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.2.1
                            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
                            public void onError(int i, String str3) {
                                LogUtil.d(SigmobCustomInitManager.TAG, "onStartFail：" + str3);
                            }

                            @Override // com.meishu.sdk.platform.sigmob.custom.SigmobCustomInitManager.InitCallback
                            public void onSuccess() {
                                LogUtil.dev(SigmobCustomInitManager.TAG, "start success");
                                SigmobCustomInitManager.this.isInit = true;
                                InitCallback initCallback3 = initCallback;
                                if (initCallback3 != null) {
                                    initCallback3.onSuccess();
                                }
                            }
                        })));
                        return;
                    }
                    LogUtil.d(SigmobCustomInitManager.TAG, "not find start method");
                    SigmobCustomInitManager.this.isInit = false;
                    InitCallback initCallback3 = initCallback;
                    if (initCallback3 != null) {
                        initCallback3.onError(-1, "not find start method");
                    }
                }
            })));
            return;
        }
        Method method2 = ReflectUtil.getMethod(WindAds.class, "startWithOptions", Context.class, WindAdOptions.class);
        if (method2 != null) {
            LogUtil.dev(TAG, "old api");
            ReflectUtil.invokeMethod(method2, windAdsSharedAds, context, windAdOptions);
            this.isInit = true;
            if (initCallback != null) {
                initCallback.onSuccess();
            }
        }
    }
}
