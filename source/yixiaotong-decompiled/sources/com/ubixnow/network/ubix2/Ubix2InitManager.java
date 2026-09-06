package com.ubixnow.network.ubix2;

import android.content.Context;
import android.location.Location;
import com.ubix.ssp.open.UBiXAdPrivacyManager;
import com.ubix.ssp.open.UBiXAdSetting;
import com.ubix.ssp.open.UBiXInitManger;
import com.ubixnow.core.api.UMNConfigUserInfo;
import com.ubixnow.core.utils.error.ErrorInfo;
import com.ubixnow.ooooo.j1;
import com.ubixnow.ooooo.o00O000;
import com.ubixnow.ooooo.o00O0O0O;
import com.ubixnow.ooooo.o00O0OO0;
import com.ubixnow.ooooo.o0O0ooO;
import com.ubixnow.ooooo.ooooO000;
import com.ubixnow.utils.BaseUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class Ubix2InitManager extends o00O0O0O {
    private static Ubix2InitManager OooO0o0;

    public static ErrorInfo getErrorInfo(String str) {
        return new ErrorInfo("500041", "ubix初始化失败 " + str);
    }

    public static synchronized Ubix2InitManager getInstance() {
        if (OooO0o0 == null) {
            OooO0o0 = new Ubix2InitManager();
        }
        return OooO0o0;
    }

    public static String getName() {
        return "Ubix2";
    }

    @Override // com.ubixnow.ooooo.o00O0O0O
    public String getVersion() {
        try {
            return UBiXInitManger.getInstance(BaseUtils.getContext()).getSdkVersion();
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
        UBiXAdSetting uBiXAdSettingBuild;
        super.initSDK(context, o00o000, o00o0oo0);
        try {
            if (isNeedInit(o00o000)) {
                trackSdkInitStart(o00o000);
                ooooO000.OooO0O0("-----Ubix--init", "appid: " + o00o000.OooO00o.OooO0Oo);
                UBiXAdPrivacyManager.Builder canUseAndroidId = new UBiXAdPrivacyManager.Builder().setCanUseLocation(j1.OooO00o).setCanUseWifiState(j1.OooO0oO).setCanUseWriteExternal(j1.OooO0o).setCanUseMacAddress(j1.OooO0o0).setCanUseOaid(j1.OooO0Oo).setCanUsePhoneState(j1.OooO0O0).setCanGetAppList(j1.OooO0oo).setCanUseAndroidId(j1.OooO0OO);
                Location location = j1.OooOO0O;
                double latitude = location != null ? location.getLatitude() : 0.0d;
                Location location2 = j1.OooOO0O;
                UBiXAdPrivacyManager uBiXAdPrivacyManagerBuild = canUseAndroidId.setLocation(latitude, location2 != null ? location2.getLongitude() : 0.0d).setAppList(j1.OooOOOo).setDevImei(j1.OooOO0o).setDevOaid(j1.OooOOOO).setAndroidId(j1.OooOOO).setMacAddress(j1.OooOOO0).setPersonalizedState(!j1.OooO ? 1 : 0).build();
                try {
                    HashMap map = new HashMap();
                    map.put("UserAgent", o0O0ooO.OooO0o);
                    UBiXAdSetting.Builder privacyManager = new UBiXAdSetting.Builder().setExtra(map).setPrivacyManager(uBiXAdPrivacyManagerBuild);
                    UMNConfigUserInfo uMNConfigUserInfo = o0O0ooO.OooO0o0;
                    UBiXAdSetting.Builder userId = privacyManager.setUserId(uMNConfigUserInfo == null ? "" : uMNConfigUserInfo.getUserId());
                    UMNConfigUserInfo uMNConfigUserInfo2 = o0O0ooO.OooO0o0;
                    uBiXAdSettingBuild = userId.setPublisherId(uMNConfigUserInfo2 == null ? "" : uMNConfigUserInfo2.getChannel()).build();
                } catch (Throwable th) {
                    ooooO000.OooO00o(th);
                    UBiXAdSetting.Builder privacyManager2 = new UBiXAdSetting.Builder().setPrivacyManager(uBiXAdPrivacyManagerBuild);
                    UMNConfigUserInfo uMNConfigUserInfo3 = o0O0ooO.OooO0o0;
                    UBiXAdSetting.Builder userId2 = privacyManager2.setUserId(uMNConfigUserInfo3 == null ? "" : uMNConfigUserInfo3.getUserId());
                    UMNConfigUserInfo uMNConfigUserInfo4 = o0O0ooO.OooO0o0;
                    uBiXAdSettingBuild = userId2.setPublisherId(uMNConfigUserInfo4 == null ? "" : uMNConfigUserInfo4.getChannel()).build();
                }
                UBiXInitManger.getInstance(BaseUtils.getContext()).setDebugLog(false);
                UBiXInitManger.getInstance(BaseUtils.getContext()).launchSDK(o00o000.OooO00o.OooO0Oo, uBiXAdSettingBuild);
                trackingAdsInitSucc(o00o000);
                this.OooO0O0 = true;
            }
            o00o0oo0.onSuccess();
            trackRedirectStart();
        } catch (Throwable th2) {
            trackingAdsInitFail(o00o000, "-1", th2.getMessage());
            th2.printStackTrace();
            if (o00o0oo0 != null) {
                o00o0oo0.onError(th2);
            }
        }
    }
}
