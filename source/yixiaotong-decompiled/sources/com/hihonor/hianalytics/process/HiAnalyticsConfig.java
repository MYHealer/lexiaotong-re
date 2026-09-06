package com.hihonor.hianalytics.process;

import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.hnha.y0;
import com.hihonor.hianalytics.hnha.z0;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.o;
import com.hihonor.hianalytics.util.s;
import com.huawei.hms.ads.ez;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HiAnalyticsConfig {
    private static final String TAG = "HiAnalyticsConfig";
    z0 cfgData;

    public static final class Builder {
        private String aaidCustom;
        private String androidIdCustom;
        private String channel;
        private String collectURL;
        private Map<String, String> httpHeaders;
        private String imeiCustom;
        private boolean isAndroidIdEnabled;
        private boolean isImeiEnabled;
        private boolean isMccMncEnabled;
        private boolean isOAIDTracking;
        private boolean isSNEnabled;
        private boolean isSessionEnabled;
        private boolean isUDIDEnabled;
        private String snCustom;
        private String udidCustom;
        private int portLimitSize = 10;
        private int expiryTime = 7;
        private boolean isUUIDEnabled = false;
        private String upid = "";
        private String oaid = "";
        private String honorOaid = "";
        private String commonProp = "";

        public HiAnalyticsConfig build() {
            j2.a(HiAnalyticsConfig.TAG, "build start");
            return new HiAnalyticsConfig(this, null);
        }

        public Builder setAAID(String str) {
            if (o.b("aaid_CustomSet", str, 4096)) {
                j2.a(HiAnalyticsConfig.TAG, "setAAID aaidCustom=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setAAID overLenAaidCustom=" + SystemUtils.a(str));
                str = "";
            }
            this.aaidCustom = str;
            return this;
        }

        public Builder setAndroidId(String str) {
            if (o.b("AndroidId_CustomSet", str, 4096)) {
                j2.a(HiAnalyticsConfig.TAG, "setAndroidId androidIdCustom=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setAndroidId overLenAndroidIdCustom=" + SystemUtils.a(str));
                str = "";
            }
            this.androidIdCustom = str;
            return this;
        }

        public Builder setAutoReportThreshold(int i) {
            j2.a(HiAnalyticsConfig.TAG, "setAutoReportThreshold limitSize=" + i);
            this.portLimitSize = o.a(i, 500, 10);
            return this;
        }

        public Builder setCacheExpireTime(int i) {
            j2.a(HiAnalyticsConfig.TAG, "setCacheExpireTime expiryTime=" + i);
            this.expiryTime = o.a(i, Integer.MAX_VALUE, 2);
            p2.d().a(i);
            return this;
        }

        public Builder setChannel(String str) {
            if (o.b("channel", str, 256)) {
                j2.a(HiAnalyticsConfig.TAG, "setChannel channel=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setChannel overLenChannel=" + SystemUtils.a(str));
                str = "";
            }
            this.channel = str;
            return this;
        }

        public Builder setCollectURL(String str) {
            if (s.b(str)) {
                j2.a(HiAnalyticsConfig.TAG, "setCollectURL collectURL=" + str);
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setCollectURL checkFailedUrl=" + str);
                str = "";
            }
            if (str.endsWith("/") || str.endsWith("\\")) {
                str = str.substring(0, str.length() - 1);
            }
            this.collectURL = str;
            return this;
        }

        public Builder setCommonProp(Map<String, String> map) {
            String str;
            if (o.c(map)) {
                try {
                    String strValueOf = String.valueOf(new JSONObject(map));
                    j2.c(HiAnalyticsConfig.TAG, "setCommonProp size=" + map.size() + ",len=" + strValueOf.length());
                    this.commonProp = strValueOf;
                } catch (Throwable th) {
                    str = "setCommonProp failEx=" + SystemUtils.getDesensitizedException(th);
                    j2.g(HiAnalyticsConfig.TAG, str);
                }
                return this;
            }
            str = "setCommonProp with illegalMapValue";
            j2.g(HiAnalyticsConfig.TAG, str);
            return this;
        }

        public Builder setEnableAndroidID(boolean z) {
            j2.a(HiAnalyticsConfig.TAG, "setEnableAndroidID isAndroidIdEnabled=" + z + ",version=white");
            if (SystemUtils.n()) {
                this.isAndroidIdEnabled = z;
            }
            return this;
        }

        public Builder setEnableImei(boolean z) {
            j2.a(HiAnalyticsConfig.TAG, "setEnableImei isImeiEnabled=" + z + ",version=white");
            if (SystemUtils.n()) {
                this.isImeiEnabled = z;
            }
            return this;
        }

        public Builder setEnableMccMnc(boolean z) {
            j2.a(HiAnalyticsConfig.TAG, "setEnableMccMnc isMccMncEnabled=" + z + ",version=white");
            if (SystemUtils.n()) {
                this.isMccMncEnabled = z;
            }
            return this;
        }

        public Builder setEnableSN(boolean z) {
            j2.a(HiAnalyticsConfig.TAG, "setEnableSN isSNEnabled=" + z + ",version=white");
            if (SystemUtils.n()) {
                this.isSNEnabled = z;
            }
            return this;
        }

        public Builder setEnableSession(boolean z) {
            j2.a(HiAnalyticsConfig.TAG, "setEnableSession isEnableSession=" + z);
            this.isSessionEnabled = z;
            return this;
        }

        public Builder setEnableUDID(boolean z) {
            j2.a(HiAnalyticsConfig.TAG, "setEnableUDID isUDIDEnabled=" + z + ",version=white");
            this.isUDIDEnabled = z;
            return this;
        }

        public Builder setEnableUUID(boolean z) {
            j2.a(HiAnalyticsConfig.TAG, "setEnableUUID isEnableUUID=" + z);
            this.isUUIDEnabled = z;
            return this;
        }

        public Builder setHonorOAID(String str) {
            if (o.b("honorOaid", str, 4096)) {
                j2.c(HiAnalyticsConfig.TAG, "setHonorOAID honorOaid=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setHonorOAID overLenOaid=" + SystemUtils.a(str));
                str = "";
            }
            this.honorOaid = str;
            return this;
        }

        @Deprecated
        public Builder setHttpHeader(Map<String, String> map) {
            Map<String, String> mapB = o.b(map);
            j2.a(HiAnalyticsConfig.TAG, "setHttpHeader httpHeaders=" + map);
            if (mapB != null && mapB.size() > 0) {
                this.httpHeaders = mapB;
            }
            return this;
        }

        public Builder setImei(String str) {
            if (o.b("IMEI_CustomSet", str, 4096)) {
                j2.a(HiAnalyticsConfig.TAG, "setImei imeiCustom=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setImei overLenImeiCustom=" + SystemUtils.a(str));
                str = "";
            }
            this.imeiCustom = str;
            return this;
        }

        public Builder setOAID(String str) {
            if (o.b("oaid", str, 4096)) {
                j2.c(HiAnalyticsConfig.TAG, "setOAID oaid=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setOAID overLenOaid=" + SystemUtils.a(str));
                str = "";
            }
            this.oaid = str;
            return this;
        }

        public Builder setOAIDTracking(boolean z) {
            this.isOAIDTracking = z;
            return this;
        }

        public Builder setSN(String str) {
            if (o.b("SN_CustomSet", str, 4096)) {
                j2.a(HiAnalyticsConfig.TAG, "setSN snCustom=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setSN overLenSnCustom=" + SystemUtils.a(str));
                str = "";
            }
            this.snCustom = str;
            return this;
        }

        public Builder setUdid(String str) {
            if (o.b("Udid_CustomSet", str, 4096)) {
                j2.a(HiAnalyticsConfig.TAG, "setUdid udidCustom=" + SystemUtils.a(str));
            } else {
                j2.a(HiAnalyticsConfig.TAG, "setUdid overLenUdidCustom=" + SystemUtils.a(str));
                str = "";
            }
            this.udidCustom = str;
            return this;
        }

        public Builder setUpid(String str) {
            if (o.b("upid", str, 4096)) {
                j2.c(HiAnalyticsConfig.TAG, "setUpid upid=" + SystemUtils.a(str));
            } else {
                j2.g(HiAnalyticsConfig.TAG, "setUpid overLenUpid=" + SystemUtils.a(str));
                str = "";
            }
            this.upid = str;
            return this;
        }
    }

    static /* synthetic */ class a {
    }

    public HiAnalyticsConfig(z0 z0Var) {
        this.cfgData = new z0(z0Var);
    }

    private HiAnalyticsConfig(Builder builder) {
        this.cfgData = new z0();
        setDeviceConfig(builder);
        this.cfgData.a(builder.isMccMncEnabled);
        this.cfgData.b(builder.channel);
        this.cfgData.c(builder.collectURL);
        this.cfgData.a(builder.aaidCustom);
        this.cfgData.b(builder.portLimitSize);
        this.cfgData.a(builder.expiryTime);
        this.cfgData.b(builder.isSessionEnabled);
        this.cfgData.c(builder.isUUIDEnabled);
        this.cfgData.a(builder.httpHeaders);
        this.cfgData.h(builder.upid);
        this.cfgData.g(builder.oaid);
        this.cfgData.i(builder.isOAIDTracking ? ez.Code : ez.V);
        this.cfgData.d(builder.honorOaid);
        this.cfgData.f(builder.commonProp);
    }

    /* synthetic */ HiAnalyticsConfig(Builder builder, a aVar) {
        this(builder);
    }

    public HiAnalyticsConfig(HiAnalyticsConfig hiAnalyticsConfig) {
        this.cfgData = new z0(hiAnalyticsConfig.cfgData);
    }

    private void setDeviceConfig(Builder builder) {
        y0 y0VarE = this.cfgData.e();
        y0VarE.b(builder.isImeiEnabled);
        y0VarE.b(builder.imeiCustom);
        y0VarE.c(builder.isSNEnabled);
        y0VarE.d(builder.snCustom);
        y0VarE.d(builder.isUDIDEnabled);
        y0VarE.c(builder.udidCustom);
        y0VarE.a(builder.isAndroidIdEnabled);
        y0VarE.a(builder.androidIdCustom);
    }
}
