package com.ubixnow.network.wangmai;

import android.content.Context;
import android.text.TextUtils;
import com.ubix.wm.appsdkdex.WMAdSdk;
import com.ubix.wm.appsdkdex.WMCustomPrivateController;
import com.ubix.wm.common.bean.WMLocation;
import com.ubixnow.core.api.UMNAdManager;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class WangMaiInitManager extends o00O0O0O {
    private static WangMaiInitManager OooO0o0;
    private final String OooO0o = "-----wangmai--init";

    public static synchronized WangMaiInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new WangMaiInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return "WANGMAI";
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return WMAdSdk.getSdkVersion();
        } catch (Exception e) {
            ooooO000.OooO00o(e);
            return "";
        }
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, o00O000 o00o000) {
        super.initSDK(context, o00o000);
        initSDK(context, o00o000, null);
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public synchronized void initSDK(Context context, final o00O000 o00o000, final o00O0OO0 o00o0oo0) {
        super.initSDK(context, o00o000, o00o0oo0);
        try {
            ooooO000.OooO0O0("-----wangmai--init", "appid: " + o00o000.OooO00o.OooO0Oo + ", " + o00o000.OooO00o.OooO0o);
            if (isNeedInit(o00o000)) {
                trackSdkInitStart(o00o000);
                new WMAdSdk.Builder().setToken(o00o000.OooO00o.OooO0Oo).setkey(o00o000.OooO00o.OooO0o).enablePersonalized(j1.OooO).enableSensor(oO00000o.o00O0O.OooOOOo).enableCrashHandle(true).debug(UMNAdManager.getInstance().getConfig().isDebug).setPrivateController(new WMCustomPrivateController() { // from class: com.ubixnow.network.wangmai.WangMaiInitManager.1
                    public String getDevImei() {
                        return !TextUtils.isEmpty(j1.OooOO0o) ? j1.OooOO0o : "";
                    }

                    public String getDevMacAddress() {
                        return j1.OooOOO0;
                    }

                    public String getDevOaid() {
                        if (!TextUtils.isEmpty(j1.OooOOOO)) {
                            return j1.OooOOOO;
                        }
                        String strOooO0o0 = oOo00o00.OooO0o0("oaid");
                        return !TextUtils.isEmpty(strOooO0o0) ? strOooO0o0 : "";
                    }

                    public WMLocation getLocation() {
                        return j1.OooOO0O != null ? new WMLocation(j1.OooOO0O.getLatitude(), j1.OooOO0O.getLongitude(), j1.OooOO0O.getAccuracy()) : super.getLocation();
                    }

                    public boolean isCanUseAppList() {
                        return j1.OooO0oo;
                    }

                    public boolean isCanUseBootId() {
                        return false;
                    }

                    public boolean isCanUseInstallPackages() {
                        return true;
                    }

                    public boolean isCanUseLocation() {
                        return j1.OooO00o;
                    }

                    public boolean isCanUseNetworkState() {
                        return j1.OooO0o0 && j1.OooO0oO;
                    }

                    public boolean isCanUseOaid() {
                        return j1.OooO0Oo;
                    }

                    public boolean isCanUsePermissionRecordAudio() {
                        return false;
                    }

                    public boolean isCanUsePhoneState() {
                        return j1.OooO0O0;
                    }

                    public boolean isCanUseWifiState() {
                        return j1.OooO0o0 && j1.OooO0oO;
                    }

                    public boolean isCanUseWriteExternal() {
                        return j1.OooO0o;
                    }
                }).build(context).init(new WMAdSdk.IInitCallback() { // from class: com.ubixnow.network.wangmai.WangMaiInitManager.2
                    public void onFail(String str) {
                        ooooO000.OooO0O0("-----wangmai--init", "sdk初始化失败," + str);
                        WangMaiInitManager.this.trackingAdsInitFail(o00o000, "-1", str);
                        o00O0OO0 o00o0oo1 = o00o0oo0;
                        if (o00o0oo1 != null) {
                            o00o0oo1.onError(new Exception(str));
                        }
                    }

                    public void onSuccess() {
                        ooooO000.OooO00o("-----wangmai--init", "sdk初始化成功");
                        WangMaiInitManager.this.OooO0O0 = true;
                        WangMaiInitManager.this.trackingAdsInitSucc(o00o000);
                        if (o00o0oo0 != null) {
                            WangMaiInitManager.this.trackRedirectStart(o00o000);
                            o00o0oo0.onSuccess();
                        }
                    }
                });
            } else if (o00o0oo0 != null) {
                trackRedirectStart();
                o00o0oo0.onSuccess();
            }
        } catch (Throwable th) {
            trackingAdsInitFail(o00o000, "-1", th.getMessage());
            ooooO000.OooO00o(th);
            if (o00o0oo0 != null) {
                o00o0oo0.onError(th);
            }
        }
    }
}
