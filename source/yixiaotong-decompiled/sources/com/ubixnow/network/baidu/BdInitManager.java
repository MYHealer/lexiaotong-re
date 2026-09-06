package com.ubixnow.network.baidu;

import android.content.Context;
import com.baidu.mobads.sdk.api.AdSettings;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.huawei.hms.ads.ez;
import com.meishu.sdk.core.MSAdConfig;
import com.stub.StubApp;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.oO00000o;
import com.ubixnow.ooooo.ooooO000;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class BdInitManager extends o00O0O0O {
    private static BdInitManager OooO0o0;

    private void OooO00o() {
        try {
            MobadsPermissionSettings.setPermissionOAID(j1.OooO0Oo);
            MobadsPermissionSettings.setPermissionReadDeviceID(j1.OooO0O0);
            MobadsPermissionSettings.setPermissionAppList(j1.OooO0oo);
            MobadsPermissionSettings.setPermissionLocation(j1.OooO00o);
            MobadsPermissionSettings.setPermissionStorage(j1.OooO0o);
            MobadsPermissionSettings.setLimitPersonalAds(!j1.OooO);
        } catch (Throwable th) {
            ooooO000.OooO00o(th);
        }
    }

    public static synchronized BdInitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new BdInitManager();
        }
        return OooO0o0;
    }

    public String getName() {
        return MSAdConfig.PLATFORM_BD;
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return AdSettings.getSDKVersion();
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
    public synchronized void initSDK(Context context, o00O000 o00o000, o00O0OO0 o00o0oo0) {
        super.initSDK(context, o00o000, o00o0oo0);
        try {
            if (isNeedInit(o00o000)) {
                trackSdkInitStart(o00o000);
                ooooO000.OooO0O0("-----bd--init", "appid: " + o00o000.OooO00o.OooO0Oo);
                OooO00o();
                new BDAdConfig.Builder().setAppsid(o00o000.OooO00o.OooO0Oo).putExtraParam("pk_change_rc", ez.V).putExtraParam("mi_market_rc", ez.V).setCloseShake(!oO00000o.o00O0O.OooOOOo).build(StubApp.getOrigApplicationContext(context.getApplicationContext())).init();
                this.OooO0O0 = true;
                trackingAdsInitSucc(o00o000);
            }
            if (j1.OooOOo0 != this.OooO0OO) {
                OooO00o();
                this.OooO0OO = j1.OooOOo0;
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
