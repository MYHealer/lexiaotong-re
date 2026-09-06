package com.ubixnow.network.youshi;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.insightvision.openadsdk.api.AbsCustomControl;
import com.insightvision.openadsdk.api.FanTiAdSdk;
import com.insightvision.openadsdk.api.FanTiAppConfig;
import com.stub.StubApp;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.oO0O0OoO;
import com.ubixnow.ooooo.oOO00O0;
import com.ubixnow.ooooo.oOo00o00;
import com.ubixnow.ooooo.ooooO000;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class YouShiInitManager extends o00O0O0O {
    private static String OooO0o = "";
    private static YouShiInitManager OooO0o0;

    public static ErrorInfo getErrorInfo(String str) {
        return new ErrorInfo("500041", getInstance().getName() + oOO00O0.ubix_initError_msg + str);
    }

    public static synchronized YouShiInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new YouShiInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return "YOUSHI";
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            ooooO000.OooO0O0("-----youshiInit", "getVersion " + OooO0o);
            if (!TextUtils.isEmpty(OooO0o)) {
                return OooO0o;
            }
            String sDKVersion = FanTiAdSdk.getAdManager().getSDKVersion();
            OooO0o = sDKVersion;
            return sDKVersion;
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
    public synchronized void initSDK(Context context, o00O000 o00o000, o00O0OO0 o00o0oo0) {
        try {
            super.initSDK(context, o00o000, o00o0oo0);
            oO0O0OoO oo0o0ooo = o00o000.OooO00o;
            String str = oo0o0ooo.OooO0Oo;
            String str2 = oo0o0ooo.OooO0o;
            ooooO000.OooO0O0("-----youshiInit", "init " + str);
            if (isNeedInit(o00o000)) {
                trackSdkInitStart(o00o000);
                FanTiAppConfig.Builder builder = new FanTiAppConfig.Builder(str, str2, new AbsCustomControl() { // from class: com.ubixnow.network.youshi.YouShiInitManager.1
                    public List<PackageInfo> getAppList() {
                        return super.getAppList();
                    }

                    public String getOaid() {
                        if (!TextUtils.isEmpty(j1.OooOOOO)) {
                            return j1.OooOOOO;
                        }
                        String strOooO0o0 = oOo00o00.OooO0o0("oaid");
                        return !TextUtils.isEmpty(strOooO0o0) ? strOooO0o0 : "";
                    }

                    public boolean isCanUseAppList() {
                        return j1.OooO0oo;
                    }

                    public boolean isCanUseLocation() {
                        return j1.OooO00o;
                    }

                    public boolean isCanUseOaid() {
                        return j1.OooO0Oo;
                    }

                    public boolean isCanUseSensor() {
                        return oO00000o.o00O0O.OooOOOo;
                    }

                    public boolean isCanUseUserAgent() {
                        return super.isCanUseUserAgent();
                    }
                });
                builder.debug(false);
                FanTiAdSdk.initialize((Application) StubApp.getOrigApplicationContext(context.getApplicationContext()), builder.build());
                this.OooO0O0 = true;
                trackingAdsInitSucc(o00o000);
            }
            if (o00o0oo0 != null) {
                o00o0oo0.onSuccess();
                trackRedirectStart();
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
