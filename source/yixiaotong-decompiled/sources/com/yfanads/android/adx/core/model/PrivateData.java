package com.yfanads.android.adx.core.model;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public interface PrivateData {
    public static final String deviceIsroot = "0";
    public static final String deviceType = "1";

    String country();

    String deviceAdid();

    int deviceApiLevel();

    String deviceAppStoreVer();

    String deviceBatteryLevel();

    String deviceBootMark();

    String deviceBrand();

    String deviceCarrier();

    String deviceDensity();

    String[] deviceGeo();

    String deviceHeight();

    String deviceHmsCore();

    String deviceId();

    String deviceImei();

    String deviceImsi();

    String deviceMac();

    String deviceModel();

    String deviceNetwork();

    String deviceOaid();

    String deviceOrientation();

    String devicePpi();

    String deviceRoomVersion();

    String deviceSsid();

    String deviceSysInit();

    String deviceSysUpdate();

    String deviceSyscmpTime();

    String deviceTypeOS();

    String deviceUA();

    String deviceUpdateMark();

    String deviceWidth();

    String deviceWifiMac();

    String getClientTime();

    long getDeviceAvailableDiskSize();

    long getDeviceAvailableMemorySize();

    String getDeviceBootTime();

    long getDeviceDiskSize();

    long getDeviceMemorySize();

    String getDeviceScreenSize();

    String getSDKVersion();

    String installedApp();

    String language();

    boolean supportWX();
}
