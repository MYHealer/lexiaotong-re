package com.hihonor.adsdk.base.net.request;

import com.hihonor.adsdk.base.bean.Address;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class DeviceData {
    private Address address;
    private String appVersion;
    private String carrier;
    private String cityCode;
    private int connectionType;
    private String countryCode;
    private int deviceMode;
    private int deviceType;
    private String gaid;
    private String gaidMd5;
    private int honorLmt;
    private String honorOaid;
    private String honorOaidMd5;
    private String language;
    private String magicUiVersion;
    private String make;
    private String mmsData;
    private String model;
    private int orientation;
    private String os;
    private String osv;
    private int ppi;
    private String romVersion;
    private int screenHeight;
    private int screenWidth;
    private String sdkVersion;
    private long timeStamp;
    private String ua;

    public DeviceData() {
    }

    public Address getAddress() {
        return this.address;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getCityCode() {
        return this.cityCode;
    }

    public int getConnectionType() {
        return this.connectionType;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public int getDeviceMode() {
        return this.deviceMode;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public String getGaid() {
        return this.gaid;
    }

    public String getGaidMd5() {
        return this.gaidMd5;
    }

    public int getHonorLmt() {
        return this.honorLmt;
    }

    public String getHonorOaid() {
        return this.honorOaid;
    }

    public String getHonorOaidMd5() {
        return this.honorOaidMd5;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMagicUiVersion() {
        return this.magicUiVersion;
    }

    public String getMake() {
        return this.make;
    }

    public String getMmsData() {
        return this.mmsData;
    }

    public String getModel() {
        return this.model;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public String getOs() {
        return this.os;
    }

    public String getOsv() {
        return this.osv;
    }

    public int getPpi() {
        return this.ppi;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public int getScreenHeight() {
        return this.screenHeight;
    }

    public int getScreenWidth() {
        return this.screenWidth;
    }

    public String getSdkVersion() {
        return this.sdkVersion;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getUa() {
        return this.ua;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public DeviceData(a aVar) {
        this.appVersion = aVar.hnadsa;
        this.carrier = aVar.hnadsb;
        this.connectionType = aVar.hnadsc;
        this.countryCode = aVar.hnadsd;
        this.deviceType = aVar.hnadse;
        this.gaid = aVar.hnadsf;
        this.gaidMd5 = aVar.hnadsg;
        this.language = aVar.hnadsh;
        this.make = aVar.hnadsi;
        this.model = aVar.hnadsj;
        this.orientation = aVar.hnadsk;
        this.os = aVar.hnadsl;
        this.osv = aVar.hnadsm;
        this.ppi = aVar.hnadsn;
        this.screenHeight = aVar.hnadso;
        this.screenWidth = aVar.hnadsp;
        this.sdkVersion = aVar.hnadsq;
        this.cityCode = aVar.hnadsr;
        this.magicUiVersion = aVar.hnadss;
        this.address = aVar.hnadst;
        this.honorOaid = aVar.hnadsu;
        this.honorOaidMd5 = aVar.hnadsv;
        this.honorLmt = aVar.hnadsx;
        this.timeStamp = aVar.hnadsy;
        this.ua = aVar.hnadsw;
        this.deviceMode = aVar.hnadsz;
        this.romVersion = aVar.f3512a;
        this.mmsData = aVar.b;
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3512a;
        private String b;
        private String hnadsa;
        private String hnadsb;
        private int hnadsc;
        private String hnadsd;
        private int hnadse;
        private String hnadsf;
        private String hnadsg;
        private String hnadsh;
        private String hnadsi;
        private String hnadsj;
        private int hnadsk;
        private String hnadsl;
        private String hnadsm;
        private int hnadsn;
        private int hnadso;
        private int hnadsp;
        private String hnadsq;
        private String hnadsr;
        private String hnadss;
        private Address hnadst;
        private String hnadsu;
        private String hnadsv;
        private String hnadsw;
        private int hnadsx;
        private long hnadsy;
        private int hnadsz;

        public a hnadsa(int i) {
            this.hnadsc = i;
            return this;
        }

        public a hnadsa(long j) {
            this.hnadsy = j;
            return this;
        }

        public a hnadsa(Address address) {
            this.hnadst = address;
            return this;
        }

        public a hnadsa(String str) {
            this.hnadsa = str;
            return this;
        }

        public a hnadsb(int i) {
            this.hnadsz = i;
            return this;
        }

        public a hnadsb(String str) {
            this.hnadsb = str;
            return this;
        }

        public a hnadsc(int i) {
            this.hnadse = i;
            return this;
        }

        public a hnadsc(String str) {
            this.hnadsr = str;
            return this;
        }

        public a hnadsd(int i) {
            this.hnadsx = i;
            return this;
        }

        public a hnadsd(String str) {
            this.hnadsd = str;
            return this;
        }

        public a hnadse(int i) {
            this.hnadsk = i;
            return this;
        }

        public a hnadse(String str) {
            this.hnadsf = str;
            return this;
        }

        public a hnadsf(int i) {
            this.hnadsn = i;
            return this;
        }

        public a hnadsf(String str) {
            this.hnadsg = str;
            return this;
        }

        public a hnadsg(int i) {
            this.hnadso = i;
            return this;
        }

        public a hnadsg(String str) {
            this.hnadsu = str;
            return this;
        }

        public a hnadsh(int i) {
            this.hnadsp = i;
            return this;
        }

        public a hnadsh(String str) {
            this.hnadsv = str;
            return this;
        }

        public a hnadsi(String str) {
            this.hnadsh = str;
            return this;
        }

        public a hnadsj(String str) {
            this.hnadss = str;
            return this;
        }

        public a hnadsk(String str) {
            this.hnadsi = str;
            return this;
        }

        public a hnadsl(String str) {
            this.b = str;
            return this;
        }

        public a hnadsm(String str) {
            this.hnadsj = str;
            return this;
        }

        public a hnadsn(String str) {
            this.hnadsl = str;
            return this;
        }

        public a hnadso(String str) {
            this.hnadsm = str;
            return this;
        }

        public a hnadsp(String str) {
            this.f3512a = str;
            return this;
        }

        public a hnadsq(String str) {
            this.hnadsq = str;
            return this;
        }

        public a hnadsr(String str) {
            this.hnadsw = str;
            return this;
        }

        public DeviceData hnadsa() {
            return new DeviceData(this);
        }
    }
}
