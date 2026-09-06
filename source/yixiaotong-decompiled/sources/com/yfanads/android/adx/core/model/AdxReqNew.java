package com.yfanads.android.adx.core.model;

import com.alipay.sdk.packet.e;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.ai;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.d;
import com.unionpay.tsmservice.mi.data.Constant;
import com.yfanads.android.adx.AdxSdkConfig;
import com.yfanads.android.adx.api.AdxScene;
import com.yfanads.android.adx.utils.a;
import com.yfanads.android.libs.thirdpart.gson.annotations.SerializedName;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.utils.YFUtil;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.Serializable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class AdxReqNew implements Serializable {

    @SerializedName("ad")
    public AdxAd ad;

    @SerializedName("app")
    public AdxApp app;

    @SerializedName(e.n)
    public AdxDevice device;

    @SerializedName("supportwx")
    public int supportWX;

    @SerializedName(ClientCookie.SECURE_ATTR)
    public final int secure = 3;

    @SerializedName("maxTimeoutMS")
    public final int maxTimeoutMS = ai.af;

    public static class AdxAd implements Serializable {

        @SerializedName("adtype")
        public int adtype;

        @SerializedName("bidfloor")
        public int bidfloor;

        @SerializedName("height")
        public int height;

        @SerializedName("id")
        public String id;

        @SerializedName("width")
        public int width;

        public AdxAd(String str, int i, int i2, int i3, int i4) {
            this.id = str;
            this.bidfloor = i;
            this.adtype = i2;
            this.width = i3;
            this.height = i4;
        }
    }

    public static class AdxApp implements Serializable {

        @SerializedName("bundle")
        public String bundle;

        @SerializedName("flowType")
        public int flowType = 1;

        @SerializedName("id")
        public String id;

        @SerializedName("name")
        public String name;

        @SerializedName("sdkVer")
        public String sdkVer;

        @SerializedName("ver")
        public String ver;

        public AdxApp(String str, String str2, String str3, String str4) {
            this.id = str;
            this.name = str2;
            this.bundle = str3;
            this.ver = str4;
        }
    }

    public static class AdxDevice implements Serializable {

        @SerializedName(OapsKey.KEY_ADID)
        public String adid;

        @SerializedName("apilevel")
        public int apilevel;

        @SerializedName("appHash")
        public String appHash;

        @SerializedName("appstorever")
        public String appstorever;

        @SerializedName("batterylevel")
        public String batterylevel;

        @SerializedName("bootmark")
        public String bootmark;

        @SerializedName("brand")
        public String brand;

        @SerializedName(am.P)
        public String carrier;

        @SerializedName("clienttime")
        public String clienttime;

        @SerializedName("densit")
        public String densit;

        @SerializedName("disktotal")
        public float disktotal;

        @SerializedName("height")
        public int height;

        @SerializedName("hmscore")
        public String hmscore;

        @SerializedName("imei")
        public String imei;

        @SerializedName("imsi")
        public int imsi;

        @SerializedName("installedapps")
        public String installedapps;

        @SerializedName("ip")
        public String ip;

        @SerializedName("isroot")
        public String isroot;

        @SerializedName("language")
        public String language;

        @SerializedName(d.C)
        public float lat;

        @SerializedName("lon")
        public float lon;

        @SerializedName(Constant.KEY_MAC)
        public String mac;

        @SerializedName("memtotal")
        public float memtotal;

        @SerializedName("model")
        public String model;

        @SerializedName("network")
        public int network;

        @SerializedName("oaid")
        public String oaid;

        @SerializedName("orientation")
        public int orientation;

        @SerializedName("osv")
        public String osv;

        @SerializedName("ppi")
        public int ppi;

        @SerializedName("romversion")
        public String romversion;

        @SerializedName("screensize")
        public float screensize;

        @SerializedName("startuptime")
        public String startuptime;

        @SerializedName("syscmptime")
        public String syscmptime;

        @SerializedName("sysinittime")
        public String sysinittime;

        @SerializedName("sysupdatetime")
        public String sysupdatetime;

        @SerializedName("type")
        public int type;

        @SerializedName("ua")
        public String ua;

        @SerializedName("updatemark")
        public String updatemark;

        @SerializedName("width")
        public int width;

        @SerializedName(am.O)
        public String country = "CN";

        @SerializedName("geotype")
        public final int geotype = 1;

        @SerializedName(am.x)
        public final String os = "ANDROID";

        @SerializedName(am.M)
        public final String timezone = "28800";
    }

    public static AdxReqNew create(AdxSdkConfig adxSdkConfig, PrivateData privateData, AdxScene adxScene) {
        String appHash;
        AdxReqNew adxReqNew = new AdxReqNew();
        String str = "";
        if (adxSdkConfig != null) {
            String str2 = adxSdkConfig.ip;
            adxReqNew.app = new AdxApp(adxSdkConfig.appId, adxSdkConfig.appName, adxSdkConfig.appPageName, adxSdkConfig.appVersion);
            appHash = adxSdkConfig.isAutoListPackage ? Util.getAppHash() : "";
            str = str2;
        } else {
            appHash = "";
        }
        if (adxScene != null) {
            adxReqNew.ad = new AdxAd(adxScene.getPosId(), (int) adxScene.getEcpm(), adxScene.getAdStyle(), adxScene.getWidth(), adxScene.getHeight());
        }
        if (privateData != null) {
            AdxDevice adxDevice = new AdxDevice();
            adxDevice.ip = str;
            adxDevice.country = privateData.country();
            adxDevice.language = privateData.language();
            String[] strArrDeviceGeo = privateData.deviceGeo();
            if (strArrDeviceGeo != null && strArrDeviceGeo.length >= 2) {
                adxDevice.lat = YFUtil.toFloat(strArrDeviceGeo[0], 0.0f);
                adxDevice.lon = YFUtil.toFloat(strArrDeviceGeo[1], 0.0f);
            }
            adxDevice.imei = privateData.deviceImei();
            adxDevice.oaid = privateData.deviceOaid();
            adxDevice.adid = privateData.deviceAdid();
            adxDevice.ppi = YFUtil.toInt(privateData.devicePpi(), 0);
            adxDevice.densit = privateData.deviceDensity();
            adxDevice.mac = privateData.deviceMac();
            adxDevice.osv = privateData.deviceTypeOS();
            adxDevice.apilevel = privateData.deviceApiLevel();
            adxDevice.batterylevel = privateData.deviceBatteryLevel();
            adxDevice.brand = privateData.deviceBrand();
            adxDevice.model = privateData.deviceModel();
            adxDevice.width = YFUtil.toInt(privateData.deviceWidth(), 0);
            adxDevice.height = YFUtil.toInt(privateData.deviceHeight(), 0);
            adxDevice.carrier = privateData.deviceCarrier();
            adxDevice.network = YFUtil.toInt(privateData.deviceNetwork(), 0);
            adxDevice.ua = privateData.deviceUA();
            adxDevice.orientation = YFUtil.toInt(privateData.deviceOrientation(), 0);
            adxDevice.romversion = privateData.deviceRoomVersion();
            adxDevice.hmscore = privateData.deviceHmsCore();
            adxDevice.appstorever = privateData.deviceAppStoreVer();
            adxDevice.bootmark = privateData.deviceBootMark();
            adxDevice.updatemark = privateData.deviceUpdateMark();
            adxDevice.sysupdatetime = privateData.deviceSysUpdate();
            adxDevice.sysinittime = privateData.deviceSysInit();
            adxDevice.startuptime = privateData.getDeviceBootTime();
            adxDevice.syscmptime = privateData.deviceSyscmpTime();
            adxDevice.mac = privateData.deviceWifiMac();
            adxDevice.clienttime = privateData.getClientTime();
            a.a("adx data:" + privateData.getDeviceScreenSize() + "|" + adxDevice.network);
            adxDevice.screensize = YFUtil.toFloat(privateData.getDeviceScreenSize(), 0.0f);
            adxDevice.disktotal = privateData.getDeviceDiskSize();
            adxDevice.memtotal = privateData.getDeviceMemorySize();
            adxDevice.appHash = appHash;
            adxReqNew.device = adxDevice;
            adxReqNew.supportWX = privateData.supportWX() ? 1 : 0;
            AdxApp adxApp = adxReqNew.app;
            if (adxApp != null) {
                adxApp.sdkVer = privateData.getSDKVersion();
            }
        }
        return adxReqNew;
    }
}
