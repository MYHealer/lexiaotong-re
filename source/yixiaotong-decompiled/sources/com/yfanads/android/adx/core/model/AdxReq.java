package com.yfanads.android.adx.core.model;

import android.text.TextUtils;
import com.hihonor.adsdk.base.g.j.e.a;
import com.ubixnow.ooooo.o0OO000o;
import com.umeng.analytics.pro.am;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.utils.b;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import com.yfanads.android.libs.utils.Util;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
@Deprecated
public final class AdxReq implements Serializable {

    @SerializedName("app_hash")
    public String appHash;

    @SerializedName("app_id")
    public String appId;

    @SerializedName("bidfloor")
    public long bidFloor;

    @SerializedName("clientTime")
    public String clientTime;
    public String country;

    @SerializedName("device_adid")
    public String deviceAdid;

    @SerializedName("device_apiLevel")
    public int deviceApiLevel;

    @SerializedName("device_disk_available")
    public long deviceAvailableDiskSize;

    @SerializedName("device_mem_available")
    public long deviceAvailableMemSize;

    @SerializedName("device_boot_time")
    public String deviceBootTime;

    @SerializedName("device_carrier")
    public String deviceCarrier;

    @SerializedName("device_density")
    public String deviceDensity;

    @SerializedName("device_disk_total")
    public long deviceDiskSize;

    @SerializedName("device_height")
    public String deviceHeight;

    @SerializedName("device_hmscore")
    public String deviceHmsCore;

    @SerializedName("device_imsi")
    public String deviceImsi;

    @SerializedName("device_mac")
    public String deviceMac;

    @SerializedName("device_mem_total")
    public long deviceMemorySize;

    @SerializedName("device_network")
    public String deviceNetwork;

    @SerializedName("device_ppi")
    public String devicePpi;

    @SerializedName("device_screenSize")
    public String deviceScreenSize;

    @SerializedName("device_sys_init")
    public String deviceSysInit;

    @SerializedName("device_sys_update")
    public String deviceSysUpdate;

    @SerializedName("device_syscmp_time")
    public String deviceSyscmpTime;

    @SerializedName("device_type_os")
    public String deviceTypeOS;

    @SerializedName("device_ua")
    public String deviceUA;

    @SerializedName("device_update_mark")
    public String deviceUpdateMark;

    @SerializedName("device_wifi_mac")
    public String deviceWifiMac;

    @SerializedName("installed_app")
    public String installedApp;
    public String language;

    @SerializedName("pid")
    public String pId;

    @SerializedName("rID")
    public String reqId;

    @SerializedName("sdkVer")
    public String sdkVer;

    @SerializedName("support_wx")
    public int supportWX;

    @SerializedName("is_mobile")
    public String isMobile = "1";
    public String gender = "-1";
    public String yob = "";
    public String keywords = "";

    @SerializedName("deny_cats")
    public String dencyCats = "";

    @SerializedName("deny_cids")
    public String dencyCids = "";

    @SerializedName("deny_ader_ids")
    public String dencyAderIds = "";

    @SerializedName(o0OO000o.o00O0O0O)
    public String ext = "";

    @SerializedName(a.hnadsn)
    public String appPackage = "";

    @SerializedName("app_name")
    public String appName = "";

    @SerializedName("app_ver")
    public String appVer = "";

    @SerializedName("device_geo_lat")
    public String deviceGeoLat = "";

    @SerializedName("device_geo_lon")
    public String deviceGeoLon = "";

    @SerializedName("device_imei")
    public String deviceImei = "";

    @SerializedName("device_oaid")
    public String deviceOaid = "";

    @SerializedName("device_battery_level")
    public String deviceBatteryLevel = "";

    @SerializedName(am.ai)
    public String deviceType = "0";

    @SerializedName(am.F)
    public String deviceBrand = "";

    @SerializedName("device_model")
    public String deviceModel = "";

    @SerializedName("device_width")
    public String deviceWidth = "";

    @SerializedName("device_os")
    public String deviceOS = "Android";

    @SerializedName("device_orientation")
    public String deviceOrientation = "";

    @SerializedName("device_rom_version")
    public String deviceRoomVersion = "";

    @SerializedName("device_appstore_ver")
    public String deviceAppStoreVer = "";

    @SerializedName("device_boot_mark")
    public String deviceBootMark = "";

    @SerializedName("device_ssid")
    public String deviceSsid = "";

    @SerializedName("device_isroot")
    public String deviceIsroot = "0";

    @SerializedName("device_ip")
    public String deviceIP = "";

    public static AdxReq create(AdxSdkConfig adxSdkConfig, PrivateData privateData, AdxScene adxScene) {
        AdxReq adxReq = new AdxReq();
        if (adxSdkConfig != null) {
            adxReq.appId = adxSdkConfig.appId;
            adxReq.appName = b.a(adxSdkConfig.appName);
            adxReq.appVer = adxSdkConfig.appVersion;
            adxReq.appPackage = adxSdkConfig.appPageName;
            adxReq.deviceIP = b.a(adxSdkConfig.ip);
            if (adxSdkConfig.isAutoListPackage && !TextUtils.isEmpty(Util.getAppHash())) {
                adxReq.appHash = b.a(Util.getAppHash());
            }
        }
        adxReq.bidFloor = adxScene.getEcpm();
        adxReq.pId = adxScene.getPosId();
        adxReq.reqId = adxScene.getReqId();
        if (privateData != null) {
            adxReq.country = privateData.country();
            adxReq.language = privateData.language();
            String[] strArrDeviceGeo = privateData.deviceGeo();
            if (strArrDeviceGeo != null) {
                adxReq.deviceGeoLat = strArrDeviceGeo[0];
                adxReq.deviceGeoLon = strArrDeviceGeo[1];
            }
            adxReq.deviceImei = privateData.deviceImei();
            adxReq.deviceOaid = b.a(privateData.deviceOaid());
            adxReq.sdkVer = privateData.getSDKVersion();
            adxReq.deviceAdid = privateData.deviceAdid();
            adxReq.devicePpi = privateData.devicePpi();
            adxReq.deviceDensity = privateData.deviceDensity();
            adxReq.deviceMac = privateData.deviceMac();
            adxReq.deviceTypeOS = privateData.deviceTypeOS();
            adxReq.deviceApiLevel = privateData.deviceApiLevel();
            adxReq.deviceBatteryLevel = privateData.deviceBatteryLevel();
            adxReq.deviceBrand = privateData.deviceBrand();
            adxReq.deviceModel = privateData.deviceModel();
            adxReq.deviceWidth = privateData.deviceWidth();
            adxReq.deviceHeight = privateData.deviceHeight();
            adxReq.deviceImsi = privateData.deviceImsi();
            adxReq.deviceCarrier = privateData.deviceCarrier();
            adxReq.deviceNetwork = privateData.deviceNetwork();
            adxReq.deviceUA = b.a(privateData.deviceUA());
            adxReq.deviceOrientation = privateData.deviceOrientation();
            adxReq.deviceRoomVersion = privateData.deviceRoomVersion();
            adxReq.deviceHmsCore = privateData.deviceHmsCore();
            adxReq.deviceAppStoreVer = privateData.deviceAppStoreVer();
            adxReq.deviceBootMark = privateData.deviceBootMark();
            adxReq.deviceUpdateMark = privateData.deviceUpdateMark();
            adxReq.deviceSysUpdate = privateData.deviceSysUpdate();
            adxReq.deviceSysInit = privateData.deviceSysInit();
            adxReq.deviceBootTime = privateData.getDeviceBootTime();
            adxReq.deviceSyscmpTime = privateData.deviceSyscmpTime();
            adxReq.deviceSsid = privateData.deviceSsid();
            adxReq.deviceWifiMac = privateData.deviceWifiMac();
            adxReq.installedApp = privateData.installedApp();
            adxReq.clientTime = privateData.getClientTime();
            adxReq.supportWX = privateData.supportWX() ? 1 : 0;
            adxReq.deviceScreenSize = privateData.getDeviceScreenSize();
            adxReq.deviceDiskSize = privateData.getDeviceDiskSize();
            adxReq.deviceAvailableDiskSize = privateData.getDeviceAvailableDiskSize();
            adxReq.deviceMemorySize = privateData.getDeviceMemorySize();
            adxReq.deviceAvailableMemSize = privateData.getDeviceAvailableMemorySize();
        }
        return adxReq;
    }
}
