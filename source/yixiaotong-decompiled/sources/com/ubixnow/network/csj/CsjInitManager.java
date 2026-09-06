package com.ubixnow.network.csj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTAdConfig;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import com.meishu.sdk.core.MSAdConfig;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o0O0ooO;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CsjInitManager extends o00O0O0O {
    private static Map<o00O0OO0, o00O000> OooO0o = new HashMap();
    private static CsjInitManager OooO0o0;

    public static synchronized CsjInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new CsjInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return MSAdConfig.PLATFORM_CSJ;
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return TTAdSdk.getAdManager().getSDKVersion();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return "";
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(final Context context, final o00O000 o00o000) {
        super.initSDK(context, o00o000);
        BaseUtils.runInMainThread(new Runnable() { // from class: com.ubixnow.network.csj.CsjInitManager.1
            @Override // java.lang.Runnable
            public void run() {
                CsjInitManager.this.initSDK(context, o00o000, null);
            }
        });
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, final o00O000 o00o000, final o00O0OO0 o00o0oo0) {
        super.initSDK(context, o00o000, o00o0oo0);
        BaseUtils.runInMainThread(new Runnable() { // from class: com.ubixnow.network.csj.CsjInitManager.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    CsjInitManager.OooO0o.put(o00o0oo0, o00o000);
                    ooooO000.OooO0O0("-----csj----init", "appid: " + o00o000.OooO00o.OooO0Oo + " thread" + Thread.currentThread().getName());
                    TTAdConfig tTAdConfigBuild = new TTAdConfig.Builder().appId(o00o000.OooO00o.OooO0Oo).appName(o00o000.OooO00o.OooO0o).directDownloadNetworkType(4).supportMultiProcess(false).data(!j1.OooO ? "[{\"name\" :\"personal_ads_type\",\"value\":\"0\"}]" : "[{\"name\" :\"personal_ads_type\",\"value\":\"1\"}]").useMediation(true).debug(UMNAdManager.getInstance().getConfig().isDebug).customController(new TTCustomController() { // from class: com.ubixnow.network.csj.CsjInitManager.2.1
                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public boolean alist() {
                            return j1.OooO0oo;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public String getAndroidId() {
                            return !TextUtils.isEmpty(j1.OooOOO) ? j1.OooOOO : super.getAndroidId();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public String getDevImei() {
                            return !TextUtils.isEmpty(j1.OooOO0o) ? j1.OooOO0o : super.getDevImei();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public String getDevOaid() {
                            if (!TextUtils.isEmpty(j1.OooOOOO)) {
                                return j1.OooOOOO;
                            }
                            String strOooO0o0 = oOo00o00.OooO0o0("oaid");
                            return !TextUtils.isEmpty(strOooO0o0) ? strOooO0o0 : super.getDevOaid();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public String getMacAddress() {
                            return !TextUtils.isEmpty(j1.OooOOO0) ? j1.OooOOO0 : super.getMacAddress();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public MediationPrivacyConfig getMediationPrivacyConfig() {
                            return new MediationPrivacyConfig() { // from class: com.ubixnow.network.csj.CsjInitManager.2.1.1
                                @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                                public List<String> getCustomAppList() {
                                    HashSet hashSet = new HashSet();
                                    List<String> list = j1.OooOOOo;
                                    if (list != null && !list.isEmpty()) {
                                        hashSet.addAll(j1.OooOOOo);
                                    }
                                    if (!o0O0ooO.OooO0Oo.isEmpty()) {
                                        hashSet.addAll(o0O0ooO.OooO0Oo);
                                    }
                                    return new ArrayList(hashSet);
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                                public List<String> getCustomDevImeis() {
                                    if (TextUtils.isEmpty(j1.OooOO0o)) {
                                        return super.getCustomDevImeis();
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(j1.OooOO0o);
                                    return arrayList;
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                                public boolean isCanUseOaid() {
                                    return j1.OooO0Oo;
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                                public boolean isLimitPersonalAds() {
                                    return !j1.OooO;
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                                public boolean isProgrammaticRecommend() {
                                    return j1.OooOO0;
                                }
                            };
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public LocationProvider getTTLocation() {
                            try {
                                if (j1.OooOO0O != null) {
                                    return new LocationProvider() { // from class: com.ubixnow.network.csj.CsjInitManager.2.1.2
                                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                                        public double getLatitude() {
                                            return j1.OooOO0O.getLatitude();
                                        }

                                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                                        public double getLongitude() {
                                            return j1.OooOO0O.getLongitude();
                                        }
                                    };
                                }
                            } catch (Throwable th) {
                                ooooO000.OooO00o(th);
                            }
                            return super.getTTLocation();
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public boolean isCanUseAndroidId() {
                            return j1.OooO0OO;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public boolean isCanUseLocation() {
                            return j1.OooO00o;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public boolean isCanUsePermissionRecordAudio() {
                            return false;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public boolean isCanUsePhoneState() {
                            return j1.OooO0O0;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public boolean isCanUseWifiState() {
                            return j1.OooO0oO;
                        }

                        @Override // com.bytedance.sdk.openadsdk.TTCustomController
                        public boolean isCanUseWriteExternal() {
                            return j1.OooO0o;
                        }
                    }).build();
                    if (!CsjInitManager.this.isNeedInit(o00o000) || TTAdSdk.isSdkReady()) {
                        CsjInitManager.this.onSuccess(false, o00o000);
                    } else {
                        CsjInitManager.this.trackSdkInitStart(o00o000);
                        try {
                            Method declaredMethod = TTAdSdk.class.getDeclaredMethod("init", Context.class, TTAdConfig.class);
                            declaredMethod.setAccessible(true);
                            declaredMethod.invoke(null, BaseUtils.getContext(), tTAdConfigBuild);
                            TTAdSdk.start(new TTAdSdk.Callback() { // from class: com.ubixnow.network.csj.CsjInitManager.2.2
                                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                                public void fail(int i, String str) {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    CsjInitManager.this.trackingAdsInitFail(o00o000, i + "", str + "");
                                    CsjInitManager.this.onError(new Exception(str));
                                }

                                @Override // com.bytedance.sdk.openadsdk.TTAdSdk.InitCallback
                                public void success() {
                                    CsjInitManager.this.OooO0O0 = true;
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    CsjInitManager.this.onSuccess(true, o00o000);
                                }
                            });
                        } catch (Throwable th) {
                            ooooO000.OooO00o(th);
                            CsjInitManager.this.trackingAdsInitFail(o00o000, "-1", th.getMessage());
                            CsjInitManager.this.onError(new Exception(th));
                        }
                    }
                    if (j1.OooOOo0 != CsjInitManager.this.OooO0OO) {
                        TTAdSdk.updateAdConfig(tTAdConfigBuild);
                        CsjInitManager.this.OooO0OO = j1.OooOOo0;
                    }
                } catch (Throwable th2) {
                    CsjInitManager.this.trackingAdsInitFail(o00o000, "-1", th2.getMessage());
                    ooooO000.OooO00o(th2);
                    CsjInitManager.this.onError(th2);
                }
            }
        });
    }

    public synchronized void onError(Throwable th) {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---CsjInitManager:", "csj init fail");
                next.getKey().onError(th);
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void onSuccess(boolean z, o00O000 o00o000) {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---CsjInitManager:", "csj init succ");
                if (z) {
                    trackingAdsInitSucc(next.getValue());
                }
                trackRedirectStart(next.getValue());
                next.getKey().onSuccess();
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }
}
