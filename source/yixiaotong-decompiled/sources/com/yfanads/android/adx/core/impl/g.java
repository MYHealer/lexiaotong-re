package com.yfanads.android.adx.core.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import com.stub.StubApp;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.CustomController;
import com.yfanads.android.adx.core.model.PrivateData;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.YFLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: compiled from: PrivateDataImpl.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class g implements PrivateData {
    public g(AdxSdkConfig adxSdkConfig) {
        com.yfanads.android.adx.service.c.a().a(com.yfanads.android.adx.service.d.a(), adxSdkConfig);
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String country() {
        return com.yfanads.android.adx.service.c.a.f9618a.f9617a;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceAdid() {
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB == null || !customControllerB.canUseAndroidId()) {
            return "";
        }
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        Context context = com.yfanads.android.adx.service.d.b;
        if (!TextUtils.isEmpty(cVar.v)) {
            return cVar.v;
        }
        String string = Settings.System.getString(context.getContentResolver(), "android_id");
        cVar.v = string;
        return string == null ? "" : string;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final int deviceApiLevel() {
        return com.yfanads.android.adx.service.c.a.f9618a.j;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceAppStoreVer() {
        return com.yfanads.android.adx.service.c.a.f9618a.A;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceBatteryLevel() {
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceBootMark() {
        return com.yfanads.android.adx.service.c.a.f9618a.n;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceBrand() {
        return com.yfanads.android.adx.service.c.a.f9618a.h;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceCarrier() {
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB == null || !customControllerB.canUsePhoneState()) {
            return "";
        }
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        Context context = com.yfanads.android.adx.service.d.b;
        cVar.getClass();
        if (!com.yfanads.android.adx.utils.b.a(context, "android.permission.READ_PHONE_STATE")) {
            com.yfanads.android.adx.utils.a.d("carrier has no READ_PHONE_STATE");
            return "";
        }
        if (TextUtils.isEmpty(cVar.u)) {
            try {
                cVar.u = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
            } catch (Exception e) {
                YFLog.error("getCarrier fail " + e.getMessage());
            }
        }
        String str = cVar.u;
        return str == null ? "" : str;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceDensity() {
        return String.valueOf(com.yfanads.android.adx.service.c.a.f9618a.f);
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String[] deviceGeo() {
        Exception e;
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB != null) {
            if (customControllerB.canUseLocation()) {
                com.yfanads.android.adx.service.b bVar = com.yfanads.android.adx.service.b.C1175b.f9616a;
                Context context = com.yfanads.android.adx.service.d.b;
                bVar.getClass();
                if (com.yfanads.android.adx.utils.b.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
                    if (bVar.b == null) {
                        bVar.b = (LocationManager) context.getSystemService("location");
                    }
                    List<String> providers = bVar.b.getProviders(true);
                    String str = "gps";
                    if (providers.contains("gps")) {
                        try {
                            com.yfanads.android.adx.utils.a.c("loc use gps first.");
                            try {
                                if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.h) == 0) {
                                    bVar.f9615a = bVar.b.getLastKnownLocation("gps");
                                }
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str = null;
                        }
                    } else {
                        str = null;
                    }
                    Location location = bVar.f9615a;
                    if (location == null || location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) {
                        String str2 = "network";
                        if (providers.contains("network")) {
                            try {
                                com.yfanads.android.adx.utils.a.c("loc gps fail, use network location second.");
                                try {
                                    bVar.f9615a = bVar.b.getLastKnownLocation("network");
                                } catch (Exception e4) {
                                    e = e4;
                                    e.printStackTrace();
                                }
                            } catch (Exception e5) {
                                String str3 = str;
                                e = e5;
                                str2 = str3;
                            }
                            str = str2;
                        }
                    }
                    Location location2 = bVar.f9615a;
                    if ((location2 == null || location2.getLatitude() == 0.0d || location2.getLongitude() == 0.0d) && providers.contains("passive")) {
                        try {
                            com.yfanads.android.adx.utils.a.c("loc network fail, use passive location third.");
                            try {
                                bVar.f9615a = bVar.b.getLastKnownLocation("passive");
                                str = "passive";
                            } catch (Exception e6) {
                                e = e6;
                                str = "passive";
                                e.printStackTrace();
                            }
                        } catch (Exception e7) {
                            e = e7;
                        }
                    }
                    if (str == null) {
                        com.yfanads.android.adx.utils.a.b("loc has no provider, return.");
                    } else {
                        Location location3 = bVar.f9615a;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        com.yfanads.android.adx.utils.a.c("isNeedUpd " + jCurrentTimeMillis);
                        if (location3 == null || location3.getLatitude() == 0.0d || location3.getLongitude() == 0.0d || jCurrentTimeMillis >= 60000) {
                            bVar.b(context, str);
                        }
                    }
                } else {
                    com.yfanads.android.adx.utils.a.d("loc has no ACCESS_FINE_LOCATION");
                }
                com.yfanads.android.adx.utils.a.c("loc[]");
                Location location4 = bVar.f9615a;
                if (location4 != null) {
                    return new String[]{location4.getLatitude() + "", location4.getLongitude() + ""};
                }
            } else if (customControllerB.location() != null) {
                return new String[]{customControllerB.location().f9563a + "", customControllerB.location().b + ""};
            }
        }
        return null;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceHeight() {
        return String.valueOf(com.yfanads.android.adx.service.c.a.f9618a.d);
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceHmsCore() {
        return com.yfanads.android.adx.service.c.a.f9618a.z;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceId() {
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        if (!TextUtils.isEmpty(cVar.x)) {
            return cVar.x;
        }
        String clientId = DeviceUtils.getClientId();
        cVar.x = clientId;
        return clientId;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceImei() {
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB == null) {
            return "";
        }
        if (customControllerB.canUsePhoneState()) {
            return com.yfanads.android.adx.service.c.a.f9618a.a(com.yfanads.android.adx.service.d.b);
        }
        return customControllerB.devImei() != null ? customControllerB.devImei() : "";
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceImsi() {
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        return (customControllerB == null || !customControllerB.canUsePhoneState()) ? "" : com.yfanads.android.adx.service.c.a.f9618a.b(com.yfanads.android.adx.service.d.b);
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceMac() {
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB == null || !customControllerB.canUseMacAddress()) {
            return "";
        }
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        Context context = com.yfanads.android.adx.service.d.b;
        cVar.getClass();
        if (!com.yfanads.android.adx.utils.b.a(context, com.kuaishou.weapon.p0.g.d)) {
            com.yfanads.android.adx.utils.a.d("mac has no ACCESS_WIFI_STATE");
            return "";
        }
        if (TextUtils.isEmpty(cVar.r)) {
            WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
            if (wifiManager.getConnectionInfo() != null) {
                cVar.r = wifiManager.getConnectionInfo().getMacAddress();
            }
        }
        String str = cVar.r;
        return str == null ? "" : str;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceModel() {
        return com.yfanads.android.adx.service.c.a.f9618a.i;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceNetwork() {
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        Context context = com.yfanads.android.adx.service.d.b;
        cVar.getClass();
        return String.valueOf(com.yfanads.android.adx.service.c.c(context));
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceOaid() {
        return YFAdsPhone.getInstance().getDeviceId();
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceOrientation() {
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        Context context = com.yfanads.android.adx.service.d.b;
        cVar.getClass();
        int i = context.getResources().getConfiguration().orientation;
        int i2 = 1;
        if (i != 2) {
            i2 = i == 1 ? 0 : -1;
        }
        return String.valueOf(i2);
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String devicePpi() {
        return String.valueOf(com.yfanads.android.adx.service.c.a.f9618a.g);
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceRoomVersion() {
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceSsid() {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB == null || !customControllerB.canUseMacAddress()) {
            return "";
        }
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        Context context = com.yfanads.android.adx.service.d.b;
        cVar.getClass();
        if (!com.yfanads.android.adx.utils.b.a(context, com.kuaishou.weapon.p0.g.d)) {
            com.yfanads.android.adx.utils.a.d("ssid has no ACCESS_WIFI_STATE");
            return "";
        }
        if (TextUtils.isEmpty(cVar.w) && (wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")) != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
            String ssid = connectionInfo.getSSID();
            if (ssid.length() > 2 && ssid.charAt(0) == '\"' && ssid.charAt(ssid.length() - 1) == '\"') {
                cVar.w = ssid.substring(1, ssid.length() - 1);
            }
        }
        String str = cVar.w;
        return str == null ? "" : str;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceSysInit() {
        return com.yfanads.android.adx.service.c.a.f9618a.l;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceSysUpdate() {
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceSyscmpTime() {
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceTypeOS() {
        return com.yfanads.android.adx.service.c.a.f9618a.k;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceUA() {
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        cVar.getClass();
        if (TextUtils.isEmpty(DeviceUtils.getUA())) {
            return com.yfanads.android.adx.service.c.H;
        }
        cVar.getClass();
        return DeviceUtils.getUA();
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceUpdateMark() {
        return com.yfanads.android.adx.service.c.a.f9618a.o;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceWidth() {
        return String.valueOf(com.yfanads.android.adx.service.c.a.f9618a.c);
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String deviceWifiMac() {
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB == null || !customControllerB.canUseMacAddress()) {
            return "";
        }
        com.yfanads.android.adx.service.c cVar = com.yfanads.android.adx.service.c.a.f9618a;
        Context context = com.yfanads.android.adx.service.d.b;
        cVar.getClass();
        if (!com.yfanads.android.adx.utils.b.a(context, com.kuaishou.weapon.p0.g.d)) {
            com.yfanads.android.adx.utils.a.d("mac has no ACCESS_WIFI_STATE");
            return "";
        }
        if (TextUtils.isEmpty(cVar.r)) {
            WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
            if (wifiManager.getConnectionInfo() != null) {
                cVar.r = wifiManager.getConnectionInfo().getMacAddress();
            }
        }
        String str = cVar.r;
        return str == null ? "" : str;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String getClientTime() {
        try {
            return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSZ").format(new Date());
        } catch (Exception e) {
            com.yfanads.android.adx.components.base.e.a(e, new StringBuilder("getClientTime "));
            return "";
        }
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final long getDeviceAvailableDiskSize() {
        return com.yfanads.android.adx.service.c.a.f9618a.E;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final long getDeviceAvailableMemorySize() {
        return com.yfanads.android.adx.service.c.a.f9618a.G;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String getDeviceBootTime() {
        return com.yfanads.android.adx.service.c.a.f9618a.m;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final long getDeviceDiskSize() {
        return com.yfanads.android.adx.service.c.a.f9618a.D;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final long getDeviceMemorySize() {
        return com.yfanads.android.adx.service.c.a.f9618a.F;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String getDeviceScreenSize() {
        return com.yfanads.android.adx.service.c.a.f9618a.C;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String getSDKVersion() {
        return com.yfanads.android.adx.service.c.a.f9618a.p;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String installedApp() {
        CustomController customControllerB = com.yfanads.android.adx.service.d.b();
        if (customControllerB != null && customControllerB.canUseAppList()) {
            com.yfanads.android.adx.service.c.a.f9618a.getClass();
        }
        return "";
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final String language() {
        return com.yfanads.android.adx.service.c.a.f9618a.b;
    }

    @Override // com.yfanads.android.adx.core.model.PrivateData
    public final boolean supportWX() {
        return com.yfanads.android.adx.service.c.a.f9618a.B;
    }
}
