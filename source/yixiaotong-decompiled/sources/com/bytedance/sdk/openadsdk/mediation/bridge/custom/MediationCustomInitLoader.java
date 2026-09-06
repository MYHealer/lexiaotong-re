package com.bytedance.sdk.openadsdk.mediation.bridge.custom;

import android.content.Context;
import android.util.SparseArray;
import com.byazt.bog.a;
import com.byazt.rl.ve;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.LocationProvider;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 83, 265, 266, 1894})
public abstract class MediationCustomInitLoader extends com.byazt.op.c {
    private Function<SparseArray<Object>, Object> c;

    @Override // com.byazt.op.c
    public SparseArray<Object> get() {
        return null;
    }

    public String getBiddingToken(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract String getNetworkSdkVersion();

    public String getSdkInfo(Context context, Map<String, Object> map) {
        return null;
    }

    public abstract void initializeADN(Context context, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map);

    public final void initInnerADN(Context context, com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig mediationCustomInitConfig, Map<String, Object> map, Function<SparseArray<Object>, Object> function) {
        this.c = function;
        c();
        try {
            initializeADN(context, mediationCustomInitConfig, map);
        } catch (Exception e) {
            a.c(e);
        }
    }

    private void c() {
        if (this.c != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(AVMDLDataLoader.KeyIsLoaderFactoryP2PLevel));
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8402, this);
            this.c.apply(sparseArray);
        }
    }

    public void notifyInitDuration(boolean z, long j) {
        if (this.c != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 8270);
            sparseArray.put(-99999985, String.class);
            sparseArray.put(8073, Long.valueOf(j));
            sparseArray.put(8557, Integer.valueOf(z ? 1 : 0));
            this.c.apply(sparseArray);
        }
    }

    public final void callInitSuccess() {
        if (this.c != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, Integer.valueOf(AVMDLDataLoader.KeyIsEnableEarlyData));
            sparseArray.put(-99999985, String.class);
            this.c.apply(sparseArray);
        }
    }

    public final boolean isInit() {
        if (this.c == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 8220);
        sparseArray.put(-99999985, Boolean.class);
        return ((Boolean) MediationValueUtil.objectValue(this.c.apply(sparseArray), Boolean.class, Boolean.FALSE)).booleanValue();
    }

    public final void initAdn(Context context, ValueSet valueSet) {
        MediationInitConfig mediationInitConfigCreate = MediationInitConfig.create(valueSet);
        TTCustomController tTCustomControllerC = c(mediationInitConfigCreate);
        Map customInitMap = mediationInitConfigCreate.getCustomInitMap();
        if (customInitMap == null) {
            customInitMap = new HashMap();
        }
        customInitMap.put("custom_controller", tTCustomControllerC);
        initInnerADN(context, new com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig(mediationInitConfigCreate.getCustomInitConfigValueSet()), customInitMap, mediationInitConfigCreate.getCustomGMConfiguration());
    }

    @Override // com.byazt.op.c
    public <T> T applyFunction(int i, ValueSet valueSet, Class<T> cls) {
        if (i == 8240) {
            initAdn((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), ve.c((SparseArray<Object>) valueSet.objectValue(8424, SparseArray.class)).tt());
        } else {
            if (i == 8139) {
                return (T) getBiddingToken((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i == 8217) {
                return (T) getSdkInfo((Context) valueSet.objectValue(AVMDLDataLoader.KeyIsLiveWaitP2pReadyThreshold, Context.class), (Map) valueSet.objectValue(8075, Map.class));
            }
            if (i == 8218) {
                return (T) getNetworkSdkVersion();
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    private TTCustomController c(final MediationInitConfig mediationInitConfig) {
        return new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader.1
            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseLocation() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.isCanUseLocation();
                }
                return super.isCanUseLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public LocationProvider getTTLocation() {
                IMediationLocation location;
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null && (location = mediationInitConfig2.getLocation()) != null) {
                    final double latitude = location.getLatitude();
                    final double longitude = location.getLongitude();
                    return new LocationProvider() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader.1.1
                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLatitude() {
                            return latitude;
                        }

                        @Override // com.bytedance.sdk.openadsdk.LocationProvider
                        public double getLongitude() {
                            return longitude;
                        }
                    };
                }
                return super.getTTLocation();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean alist() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.appList();
                }
                return super.alist();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePhoneState() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.isCanUsePhoneState();
                }
                return super.isCanUsePhoneState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevImei() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.getDevImei();
                }
                return super.getDevImei();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWifiState() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.isCanUseWifiState();
                }
                return super.isCanUseWifiState();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getMacAddress() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.getMacAddress();
                }
                return super.getMacAddress();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseWriteExternal() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.isCanUseWriteExternal();
                }
                return super.isCanUseWriteExternal();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getDevOaid() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.getDevOaid();
                }
                return super.getDevOaid();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUseAndroidId() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.isCanUseAndroidId();
                }
                return super.isCanUseAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public String getAndroidId() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.getAndroidId();
                }
                return super.getAndroidId();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public MediationPrivacyConfig getMediationPrivacyConfig() {
                return new MediationPrivacyConfig() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomInitLoader.1.2
                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public List<String> getCustomAppList() {
                        if (mediationInitConfig != null) {
                            return mediationInitConfig.getAppList();
                        }
                        return super.getCustomAppList();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public List<String> getCustomDevImeis() {
                        if (mediationInitConfig != null) {
                            return mediationInitConfig.getDevImeis();
                        }
                        return super.getCustomDevImeis();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isCanUseOaid() {
                        if (mediationInitConfig != null) {
                            return mediationInitConfig.isCanUseOaid();
                        }
                        return super.isCanUseOaid();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isLimitPersonalAds() {
                        if (mediationInitConfig != null) {
                            return mediationInitConfig.isLimitPersonalAds();
                        }
                        return super.isLimitPersonalAds();
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.init.MediationPrivacyConfig, com.bytedance.sdk.openadsdk.mediation.init.IMediationPrivacyConfig
                    public boolean isProgrammaticRecommend() {
                        if (mediationInitConfig != null) {
                            return mediationInitConfig.isProgrammaticRecommend();
                        }
                        return super.isProgrammaticRecommend();
                    }
                };
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public boolean isCanUsePermissionRecordAudio() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.isCanUsePermissionRecordAudio();
                }
                return super.isCanUsePermissionRecordAudio();
            }

            @Override // com.bytedance.sdk.openadsdk.TTCustomController
            public Map<String, Object> userPrivacyConfig() {
                MediationInitConfig mediationInitConfig2 = mediationInitConfig;
                if (mediationInitConfig2 != null) {
                    return mediationInitConfig2.userPrivacyConfig();
                }
                return super.userPrivacyConfig();
            }
        };
    }
}
