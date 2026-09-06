package com.ubixnow.network.feisuo;

import android.content.Context;
import android.location.Location;
import android.text.TextUtils;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.core.api.UMNConfigUserInfo;
import com.ubixnow.ooooo.h1;
import com.ubixnow.ooooo.i1;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o0O0ooO;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.ooooO000;
import com.zm.fissionsdk.api.FissionConfig;
import com.zm.fissionsdk.api.FissionSdk;
import com.zm.fissionsdk.api.FissionSensitivityController;
import com.zm.fissionsdk.api.interfaces.IFissionRuntime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class FeiSuoInitManager extends o00O0O0O {
    private static Map<o00O0OO0, o00O000> OooO0o = new HashMap();
    private static FeiSuoInitManager OooO0o0;

    private IFissionRuntime OooO00o() {
        return new IFissionRuntime() { // from class: com.ubixnow.network.feisuo.FeiSuoInitManager.2
            public String getAndroidId() {
                return j1.OooOOO;
            }

            public int getCarrier() {
                return 0;
            }

            public int getDeviceType() {
                int iOooOO0O = i1.OooOO0O();
                if (iOooOO0O == 0) {
                    return 1;
                }
                return iOooOO0O;
            }

            public String getImei() {
                return j1.OooOO0o;
            }

            public double getLatitude() {
                Location location = j1.OooOO0O;
                if (location != null) {
                    return location.getLatitude();
                }
                return 0.0d;
            }

            public double getLongitude() {
                Location location = j1.OooOO0O;
                if (location != null) {
                    return location.getLongitude();
                }
                return 0.0d;
            }

            public String getMac() {
                return j1.OooOOO0;
            }

            public int getNetworkType() {
                int i = h1.OooO0O0().OooOOo0;
                if (i == 1) {
                    return 2;
                }
                if (i == 2) {
                    return 4;
                }
                if (i == 3) {
                    return 5;
                }
                if (i != 4) {
                    return i != 5 ? 3 : 7;
                }
                return 6;
            }

            public String getOAid() {
                if (!TextUtils.isEmpty(j1.OooOOOO)) {
                    return j1.OooOOOO;
                }
                String strOooO0o0 = oOo00o00.OooO0o0("oaid");
                return !TextUtils.isEmpty(strOooO0o0) ? strOooO0o0 : "";
            }

            public String getUid() {
                UMNConfigUserInfo uMNConfigUserInfo = o0O0ooO.OooO0o0;
                return uMNConfigUserInfo == null ? "" : uMNConfigUserInfo.getUserId();
            }

            public boolean isLogin() {
                return false;
            }
        };
    }

    private FissionSensitivityController OooO0O0() {
        FissionSensitivityController.Builder builder = new FissionSensitivityController.Builder();
        builder.setCanGetAndroidId(j1.OooO0OO);
        builder.setCanGetAppList(j1.OooO0oo);
        builder.setCanGetLocation(j1.OooO00o);
        builder.setCanReadPhoneState(j1.OooO0O0);
        builder.setCanGetNetworkState(j1.OooO0oO);
        builder.setCanGetOaid(j1.OooO0Oo);
        return builder.build();
    }

    public static synchronized FeiSuoInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new FeiSuoInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return "FeiSuo";
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return FissionSdk.getSdkVersionName();
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
            return "";
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000) {
        super.initSDK(context, o00o000);
        initSDK(context, o00o000, null);
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, final o00O000 o00o000, o00O0OO0 o00o0oo0) {
        super.initSDK(context, o00o000, o00o0oo0);
        try {
            OooO0o.put(o00o0oo0, o00o000);
            if (!isNeedInit(o00o000) || FissionSdk.isInitSuccess()) {
                onSuccesses(false);
            } else {
                ooooO000.OooO0O0("-----FeiSuoInitManager", "init");
                trackSdkInitStart(o00o000);
                FissionConfig.Builder token = new FissionConfig.Builder().setAppId(o00o000.OooO00o.OooO0Oo).setToken(o00o000.OooO00o.OooO0o);
                UMNConfigUserInfo uMNConfigUserInfo = o0O0ooO.OooO0o0;
                FissionSdk.init(context, token.setChannel(uMNConfigUserInfo == null ? "" : uMNConfigUserInfo.getChannel()).setDebug(UMNAdManager.getInstance().getConfig().isDebug).setSensitivityController(OooO0O0()).setAllowShowNotification(true).setFissionRuntime(OooO00o()).setSupportMultiProcess(false).addGlobalConfig("userAgent", o0O0ooO.OooO0o).addGlobalConfig("personalRecommend", Boolean.valueOf(j1.OooO)).addGlobalConfig("sensorEnable", Boolean.valueOf(oO00000o.o00O0O.OooOOOo)).build(), new FissionSdk.InitCallback() { // from class: com.ubixnow.network.feisuo.FeiSuoInitManager.1
                    public void onFailed(int i, String str) {
                        FeiSuoInitManager.this.trackingAdsInitFail(o00o000, i + "", str);
                        FeiSuoInitManager.this.onError(new Exception(str));
                    }

                    public void onSuccess() {
                        FeiSuoInitManager.this.OooO0O0 = true;
                        FeiSuoInitManager.this.onSuccesses(true);
                    }
                });
            }
        } catch (Throwable th) {
            trackingAdsInitFail(o00o000, "-1", th.getMessage());
            ooooO000.OooO00o(th);
            onError(th);
        }
    }

    public synchronized void onError(Throwable th) {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---FeiSuoInitManager:", "FeiSuo init fail");
                next.getKey().onError(th);
                it.remove();
            }
        } catch (Exception e) {
            ooooO000.OooO00o(e);
        }
    }

    public synchronized void onSuccesses(boolean z) {
        try {
            Iterator<Map.Entry<o00O0OO0, o00O000>> it = OooO0o.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<o00O0OO0, o00O000> next = it.next();
                ooooO000.OooO0O0("---FeiSuoInitManager:", "FeiSuo init succ");
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
