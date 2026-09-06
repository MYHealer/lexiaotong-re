package com.hihonor.hianalytics.v2;

import android.content.Context;
import com.hihonor.hianalytics.hnha.h;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.process.HiAnalyticsConfig;
import com.hihonor.hianalytics.process.HiAnalyticsManager;
import com.hihonor.hianalytics.process.a;
import com.hihonor.hianalytics.process.d;
import com.hihonor.hianalytics.util.SystemUtils;
import com.stub.StubApp;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@Deprecated
public class HiAnalyticsConf {

    public static class Builder {
        String appid;
        HiAnalyticsConfig.Builder diffConfigBuilder;
        Context mContext;
        HiAnalyticsConfig.Builder maintConfigBuilder;
        HiAnalyticsConfig.Builder operConfigBuilder;
        HiAnalyticsConfig.Builder preConfigBuilder;

        public Builder(Context context) {
            if (context != null) {
                this.mContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            SystemUtils.a(context);
            this.maintConfigBuilder = new HiAnalyticsConfig.Builder();
            this.operConfigBuilder = new HiAnalyticsConfig.Builder();
            this.diffConfigBuilder = new HiAnalyticsConfig.Builder();
            this.preConfigBuilder = new HiAnalyticsConfig.Builder();
        }

        public void create() throws IllegalAccessException, InvocationTargetException {
            if (this.mContext == null) {
                j2.b("HiAnalyticsConf", "create context is null,create failed!");
                return;
            }
            HiAnalyticsConfig hiAnalyticsConfigBuild = this.maintConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild2 = this.operConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild3 = this.diffConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild4 = this.preConfigBuilder.build();
            d dVar = new d("_default_config_tag");
            dVar.c(hiAnalyticsConfigBuild2);
            dVar.b(hiAnalyticsConfigBuild);
            dVar.a(hiAnalyticsConfigBuild3);
            dVar.d(hiAnalyticsConfigBuild4);
            j2.c("HiAnalyticsConf", "create context=" + this.mContext);
            a.c().a("_default_config_tag", dVar);
            HiAnalyticsManager.setAppid(this.appid);
            p2.a().a("_default_config_tag");
        }

        public void refresh(boolean z) throws IllegalAccessException, InvocationTargetException {
            HiAnalyticsConfig hiAnalyticsConfigBuild = this.maintConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild2 = this.operConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild3 = this.diffConfigBuilder.build();
            HiAnalyticsConfig hiAnalyticsConfigBuild4 = this.preConfigBuilder.build();
            d dVarG = h.g("_default_config_tag");
            if (dVarG == null) {
                j2.g("HiAnalyticsConf", "refresh calling before create. defaultTag=_default_config_tag has no instance.value=" + z);
                return;
            }
            j2.c("HiAnalyticsConf", "refresh is execute withValue=" + z);
            dVarG.refresh(1, hiAnalyticsConfigBuild);
            dVarG.refresh(0, hiAnalyticsConfigBuild2);
            dVarG.refresh(3, hiAnalyticsConfigBuild3);
            dVarG.refresh(2, hiAnalyticsConfigBuild4);
            if (z) {
                a.c().a("_default_config_tag");
            }
            HiAnalyticsManager.setAppid(this.appid);
        }

        public Builder setAndroidId(String str) {
            j2.c("HiAnalyticsConf", "setAndroidId value=" + SystemUtils.a(str));
            this.operConfigBuilder.setAndroidId(str);
            this.maintConfigBuilder.setAndroidId(str);
            this.diffConfigBuilder.setAndroidId(str);
            this.preConfigBuilder.setAndroidId(str);
            return this;
        }

        public Builder setAppID(String str) {
            j2.c("HiAnalyticsConf", "setAppID value=" + SystemUtils.a(str));
            this.appid = str;
            return this;
        }

        public Builder setAutoReportThreshold(int i) {
            j2.c("HiAnalyticsConf", "setAutoReportThreshold value=" + i);
            this.operConfigBuilder.setAutoReportThreshold(i);
            this.maintConfigBuilder.setAutoReportThreshold(i);
            this.diffConfigBuilder.setAutoReportThreshold(i);
            this.preConfigBuilder.setAutoReportThreshold(i);
            return this;
        }

        public Builder setCacheExpireTime(int i) {
            j2.c("HiAnalyticsConf", "setCacheExpireTime value=" + i);
            this.operConfigBuilder.setCacheExpireTime(i);
            this.maintConfigBuilder.setCacheExpireTime(i);
            this.diffConfigBuilder.setCacheExpireTime(i);
            this.preConfigBuilder.setCacheExpireTime(i);
            return this;
        }

        public Builder setChannel(String str) {
            j2.c("HiAnalyticsConf", "setChannel value=" + SystemUtils.a(str));
            this.operConfigBuilder.setChannel(str);
            this.maintConfigBuilder.setChannel(str);
            this.diffConfigBuilder.setChannel(str);
            this.preConfigBuilder.setChannel(str);
            return this;
        }

        public Builder setCollectURL(int i, String str) {
            HiAnalyticsConfig.Builder builder;
            j2.c("HiAnalyticsConf", "setCollectURL type=" + i + ",url=" + str);
            if (i == 0) {
                builder = this.operConfigBuilder;
            } else {
                if (i != 1) {
                    if (i != 3) {
                        j2.g("HiAnalyticsConf", "Builder.setCollectURL(int type,String collectURL): invalid type!");
                    } else {
                        builder = this.diffConfigBuilder;
                    }
                    return this;
                }
                builder = this.maintConfigBuilder;
            }
            builder.setCollectURL(str);
            return this;
        }

        @Deprecated
        public Builder setEnableAndroidID(boolean z) {
            j2.c("HiAnalyticsConf", "setEnableAndroidID value=" + z);
            this.maintConfigBuilder.setEnableAndroidID(z);
            this.operConfigBuilder.setEnableAndroidID(z);
            this.diffConfigBuilder.setEnableAndroidID(z);
            this.preConfigBuilder.setEnableAndroidID(z);
            return this;
        }

        @Deprecated
        public Builder setEnableImei(boolean z) {
            j2.c("HiAnalyticsConf", "setEnableImei value=" + z);
            this.operConfigBuilder.setEnableImei(z);
            this.maintConfigBuilder.setEnableImei(z);
            this.diffConfigBuilder.setEnableImei(z);
            this.preConfigBuilder.setEnableImei(z);
            return this;
        }

        public Builder setEnableMccMnc(boolean z) {
            j2.c("HiAnalyticsConf", "setEnableMccMnc value=" + z);
            this.maintConfigBuilder.setEnableMccMnc(z);
            this.operConfigBuilder.setEnableMccMnc(z);
            this.diffConfigBuilder.setEnableMccMnc(z);
            this.preConfigBuilder.setEnableMccMnc(z);
            return this;
        }

        @Deprecated
        public Builder setEnableSN(boolean z) {
            j2.c("HiAnalyticsConf", "setEnableSN value=" + z);
            this.maintConfigBuilder.setEnableSN(z);
            this.operConfigBuilder.setEnableSN(z);
            this.diffConfigBuilder.setEnableSN(z);
            this.preConfigBuilder.setEnableSN(z);
            return this;
        }

        public Builder setEnableSession(boolean z) {
            j2.c("HiAnalyticsConf", "setEnableSession value=" + z);
            this.operConfigBuilder.setEnableSession(z);
            return this;
        }

        @Deprecated
        public Builder setEnableUDID(boolean z) {
            j2.c("HiAnalyticsConf", "setEnableUDID value=" + z);
            this.maintConfigBuilder.setEnableUDID(z);
            this.operConfigBuilder.setEnableUDID(z);
            this.diffConfigBuilder.setEnableUDID(z);
            this.preConfigBuilder.setEnableUDID(z);
            return this;
        }

        public Builder setEnableUUID(boolean z) {
            j2.c("HiAnalyticsConf", "setEnableUUID value=" + z);
            this.operConfigBuilder.setEnableUUID(z);
            this.maintConfigBuilder.setEnableUUID(z);
            this.diffConfigBuilder.setEnableUUID(z);
            this.preConfigBuilder.setEnableUUID(z);
            return this;
        }

        public Builder setHttpHeader(Map<String, String> map) {
            this.operConfigBuilder.setHttpHeader(map);
            this.maintConfigBuilder.setHttpHeader(map);
            this.diffConfigBuilder.setHttpHeader(map);
            this.preConfigBuilder.setHttpHeader(map);
            return this;
        }

        public Builder setIMEI(String str) {
            j2.c("HiAnalyticsConf", "setIMEI value=" + SystemUtils.a(str));
            this.operConfigBuilder.setImei(str);
            this.maintConfigBuilder.setImei(str);
            this.diffConfigBuilder.setImei(str);
            this.preConfigBuilder.setImei(str);
            return this;
        }

        public Builder setSN(String str) {
            j2.c("HiAnalyticsConf", "setSN value=" + SystemUtils.a(str));
            this.operConfigBuilder.setSN(str);
            this.maintConfigBuilder.setSN(str);
            this.diffConfigBuilder.setSN(str);
            this.preConfigBuilder.setSN(str);
            return this;
        }

        public Builder setUDID(String str) {
            j2.c("HiAnalyticsConf", "setUDID value=" + SystemUtils.a(str));
            this.operConfigBuilder.setUdid(str);
            this.maintConfigBuilder.setUdid(str);
            this.diffConfigBuilder.setUdid(str);
            this.preConfigBuilder.setUdid(str);
            return this;
        }
    }
}
