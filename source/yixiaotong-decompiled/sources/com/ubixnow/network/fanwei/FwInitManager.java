package com.ubixnow.network.fanwei;

import android.content.Context;
import android.text.TextUtils;
import com.ptg.adsdk.lib.PtgAdSdk;
import com.ptg.adsdk.lib.PtgSDKConfig;
import com.ptg.adsdk.lib.interf.PtgCustomController;
import com.ptg.adsdk.lib.model.AdLocation;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FwInitManager extends o00O0O0O {
    private static FwInitManager OooO0o;
    private static Map<o00O0OO0, o00O000> OooO0o0 = new HashMap();
    private PtgSDKConfig OooO0oO;
    private PtgCustomController OooO0oo;

    public static synchronized FwInitManager getInstance() {
        if (OooO0o == null) {
            OooO0o = new FwInitManager();
        }
        return OooO0o;
    }

    public String getName() {
        return "Fancy";
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return PtgAdSdk.getConfig().getSdkVersionName();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return "";
        }
    }

    public synchronized void initConfig(o00O000 o00o000) {
        try {
            this.OooO0oo = new PtgCustomController() { // from class: com.ubixnow.network.fanwei.FwInitManager.1
                public String getMediaAndroidId() {
                    return j1.OooOOO;
                }

                public String getMediaDeviceImei() {
                    return j1.OooOO0o;
                }

                public String getMediaDeviceOaId() {
                    if (!TextUtils.isEmpty(j1.OooOOOO)) {
                        return j1.OooOOOO;
                    }
                    String strOooO0o0 = oOo00o00.OooO0o0("oaid");
                    return !TextUtils.isEmpty(strOooO0o0) ? strOooO0o0 : super.getMediaDeviceOaId();
                }

                public List<String> getMediaInstalledPackages() {
                    return j1.OooOOOo;
                }

                public AdLocation getMediaLocation() {
                    if (j1.OooOO0O == null) {
                        return super.getMediaLocation();
                    }
                    AdLocation adLocation = new AdLocation();
                    adLocation.setLongitude(j1.OooOO0O.getLongitude());
                    adLocation.setLatitude(j1.OooOO0O.getLatitude());
                    return adLocation;
                }

                public String getMediaMacAddress() {
                    return j1.OooOOO0;
                }

                public int getPersonalizedState() {
                    return !j1.OooO ? 1 : 0;
                }

                public boolean getProgrammaticRecommendState() {
                    return j1.OooOO0;
                }

                public boolean isAllowSDKInstallList() {
                    return j1.OooO0oo;
                }

                public boolean isAllowSDKObtainAndroidId() {
                    return j1.OooO0OO;
                }

                public boolean isAllowSDKObtainIp() {
                    return false;
                }

                public boolean isAllowSDKObtainLocation() {
                    return j1.OooO00o;
                }

                public boolean isAllowSDKObtainMacAddress() {
                    return j1.OooO0o0;
                }

                public boolean isAllowSDKObtainOaId() {
                    return false;
                }

                public boolean isAllowSDKObtainPhoneInfo() {
                    return j1.OooO0O0;
                }

                public boolean isAllowSDKObtainWifiState() {
                    return j1.OooO0oO;
                }

                public boolean isAllowSDKObtainWriteExternal() {
                    return j1.OooO0o;
                }

                public boolean isCanUseCarrier() {
                    return j1.OooO0O0;
                }
            };
            this.OooO0oO = new PtgSDKConfig.Builder().setMediaId(o00o000.OooO00o.OooO0Oo).setMediaSecret(o00o000.OooO00o.OooO0o).setDebug(ooooO000.OooO00o).setPtgCustomController(this.OooO0oo).build();
            try {
                PtgAdSdk.setPersonalizedState(j1.OooO);
                PtgAdSdk.setProgrammaticRecommendState(j1.OooOO0);
            } catch (Throwable th) {
                ooooO000.OooO00o(th);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000) {
        super.initSDK(context, o00o000);
        initSDK(context, o00o000, null);
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, final o00O000 o00o000, o00O0OO0 o00o0oo0) {
        try {
            super.initSDK(context, o00o000, o00o0oo0);
            OooO0o0.put(o00o0oo0, o00o000);
            try {
                PtgAdSdk.class.getDeclaredMethod("isInitialized", new Class[0]);
                if (!isNeedInit(o00o000) || PtgAdSdk.isInitialized()) {
                    onSuccess(false);
                } else {
                    ooooO000.OooO0O0("-----FancyInitManager", "init");
                    trackSdkInitStart(o00o000);
                    initConfig(o00o000);
                    PtgAdSdk.init(BaseUtils.getContext(), this.OooO0oO, new PtgAdSdk.Callback() { // from class: com.ubixnow.network.fanwei.FwInitManager.2
                        public void fail(int i, String str) {
                            FwInitManager.this.trackingAdsInitFail(o00o000, i + "", str + "");
                            FwInitManager.this.onError(new Exception(str));
                        }

                        public void success() {
                            FwInitManager.this.OooO0O0 = true;
                            FwInitManager.this.onSuccess(true);
                        }
                    });
                }
            } catch (Throwable unused) {
                if (isNeedInit(o00o000)) {
                    ooooO000.OooO0O0("-----FancyInitManager", "init2");
                    trackSdkInitStart(o00o000);
                    initConfig(o00o000);
                    PtgAdSdk.init(BaseUtils.getContext(), this.OooO0oO);
                    this.OooO0O0 = true;
                    onSuccess(true);
                } else {
                    this.OooO0O0 = true;
                    onSuccess(false);
                }
            }
            if (j1.OooOOo0 != this.OooO0OO) {
                initConfig(o00o000);
                PtgAdSdk.setPtgCustomController(this.OooO0oo);
                try {
                    PtgAdSdk.mergeCustomController();
                } catch (Throwable th) {
                    ooooO000.OooO00o(th);
                }
                this.OooO0OO = j1.OooOOo0;
            }
        } catch (Exception e) {
            trackingAdsInitFail(o00o000, "-1", e.getMessage());
            ooooO000.OooO00o(e);
            onError(e);
        }
    }

    public synchronized void onError(Throwable th) {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o0.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---FwInitManager:", "fancy init fail");
                next.getKey().onError(th);
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void onSuccess(boolean z) {
        try {
            PtgAdSdk.setSensorStatus(oO00000o.o00O0O.OooOOOo);
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o0.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---FwInitManager:", "fancy init succ");
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
