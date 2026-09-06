package com.hihonor.hianalytics.process;

import android.content.Context;
import android.view.View;
import com.hihonor.hianalytics.hnha.h;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.module.config.HiAnalyticsAutoConfig;
import com.hihonor.hianalytics.module.exposure.ExposureInfo;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.o;
import com.hihonor.hianalytics.util.r;
import com.yfanads.android.utils.YFAdsConst;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public interface HiAnalyticsInstance {

    public static final class Builder {
        private static final String TAG = "HiAnalyticsInstance_Builder";
        private String accountBrandId;
        private String appBrandId;
        private String appid;
        private String handsetManufacturer;
        private String hansetBrandId;
        private final Context mContext;
        private HiAnalyticsConfig operConf = null;
        private HiAnalyticsConfig maintConf = null;
        private HiAnalyticsConfig diffConf = null;
        private HiAnalyticsConfig preInstallConf = null;
        private HiAnalyticsAutoConfig autoConfig = null;

        public Builder(Context context) {
            this.mContext = context;
            SystemUtils.a(context);
        }

        private Builder setAutoConfig(HiAnalyticsAutoConfig hiAnalyticsAutoConfig) {
            this.autoConfig = hiAnalyticsAutoConfig;
            return this;
        }

        private void setParam(d dVar) {
            HiAnalyticsConfig hiAnalyticsConfig = this.operConf;
            dVar.c(hiAnalyticsConfig == null ? null : new HiAnalyticsConfig(hiAnalyticsConfig));
            HiAnalyticsConfig hiAnalyticsConfig2 = this.maintConf;
            dVar.b(hiAnalyticsConfig2 == null ? null : new HiAnalyticsConfig(hiAnalyticsConfig2));
            HiAnalyticsConfig hiAnalyticsConfig3 = this.diffConf;
            dVar.a(hiAnalyticsConfig3 == null ? null : new HiAnalyticsConfig(hiAnalyticsConfig3));
            HiAnalyticsConfig hiAnalyticsConfig4 = this.preInstallConf;
            dVar.d(hiAnalyticsConfig4 != null ? new HiAnalyticsConfig(hiAnalyticsConfig4) : null);
            dVar.b.d(this.appid);
            dVar.b.c(this.appBrandId);
            dVar.b.f(this.hansetBrandId);
            dVar.b.b(this.accountBrandId);
            dVar.b.e(this.handsetManufacturer);
            dVar.b.a(this.autoConfig);
        }

        public HiAnalyticsInstance create(String str) {
            StringBuilder sb;
            long jA = r.a();
            if (this.mContext == null) {
                sb = new StringBuilder("create instance context is null with tag=");
            } else if (str == null || !o.a("tag", str, "[a-zA-Z0-9][a-zA-Z0-9_]{0,255}")) {
                sb = new StringBuilder("create check failed tag=");
            } else if (HiAnalyticsManager.getInitFlag(str)) {
                sb = new StringBuilder("create already exists tag=");
            } else if (a.c().d(str)) {
                sb = new StringBuilder("create not allowed here blackTag=");
            } else {
                if (a.c().e() - a.c().f() <= 200) {
                    d dVar = new d(str);
                    setParam(dVar);
                    long jA2 = r.a() - jA;
                    d dVarA = a.c().a(str, dVar);
                    if (dVarA != null) {
                        dVar = dVarA;
                    }
                    long jA3 = r.a();
                    p2.a().a(str);
                    j2.c(TAG, "create spendTime=(" + r.b(r.a() - jA) + "," + r.b(jA2) + "," + r.b(r.a() - jA3) + "),tag=" + str + ",context=" + this.mContext);
                    return dVar;
                }
                sb = new StringBuilder("number exceeds the limit withTag=");
            }
            j2.b(TAG, sb.append(str).toString());
            return null;
        }

        public HiAnalyticsInstance refresh(String str) {
            d dVarG = h.g(str);
            if (dVarG == null) {
                j2.a(TAG, "refresh withTag=" + str + " impl not exist");
                return create(str);
            }
            dVarG.refresh(1, this.maintConf);
            dVarG.refresh(0, this.operConf);
            dVarG.refresh(3, this.diffConf);
            dVarG.refresh(2, this.preInstallConf);
            dVarG.b.d(this.appid);
            dVarG.b.c(this.appBrandId);
            dVarG.b.f(this.hansetBrandId);
            dVarG.b.b(this.accountBrandId);
            dVarG.b.e(this.handsetManufacturer);
            b.c(str);
            return dVarG;
        }

        public Builder setAccountBrandId(String str) {
            if (o.b("accountBrandId", str, 256)) {
                j2.a(TAG, "setAccountBrandId accountBrandId=" + str);
            } else {
                j2.g(TAG, "setAccountBrandId overLenAccountBrandId=" + str);
                str = "";
            }
            this.accountBrandId = str;
            return this;
        }

        public Builder setAppBrandId(String str) {
            if (o.b("appBrandId", str, 256)) {
                j2.a(TAG, "setAppBrandId appBrandId=" + str);
            } else {
                j2.g(TAG, "setAppBrandId overLenAppBrandId=" + str);
                str = "";
            }
            this.appBrandId = str;
            return this;
        }

        public Builder setAppId(String str) {
            j2.a(TAG, "setAppid appid=" + SystemUtils.a(str));
            this.appid = o.a(YFAdsConst.REPORT_APPID, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", "");
            return this;
        }

        @Deprecated
        public Builder setDiffConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.diffConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setHandsetManufacturer(String str) {
            if (o.b("handsetManufacturer", str, 256)) {
                j2.a(TAG, "setHandsetManufacturer handsetManufacturer=" + str);
            } else {
                j2.g(TAG, "setHandsetManufacturer overLenHandsetManufacturer=" + str);
                str = "";
            }
            this.handsetManufacturer = str;
            return this;
        }

        public Builder setHansetBrandId(String str) {
            if (o.b("hansetBrandId", str, 256)) {
                j2.a(TAG, "setHansetBrandId hansetBrandId=" + str);
            } else {
                j2.g(TAG, "setHansetBrandId overLenHansetBrandId=" + str);
                str = "";
            }
            this.hansetBrandId = str;
            return this;
        }

        public Builder setMaintConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.maintConf = hiAnalyticsConfig;
            return this;
        }

        public Builder setOperConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.operConf = hiAnalyticsConfig;
            return this;
        }

        @Deprecated
        public Builder setPreInstallConf(HiAnalyticsConfig hiAnalyticsConfig) {
            this.preInstallConf = hiAnalyticsConfig;
            return this;
        }
    }

    void addExposureView(View view, ExposureInfo exposureInfo);

    void clearData();

    boolean hasCachedData(int i);

    void newInstanceUUID();

    void onBackground(long j);

    void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap);

    void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3);

    @Deprecated
    void onEvent(Context context, String str, String str2);

    void onEvent(String str, LinkedHashMap<String, String> linkedHashMap);

    void onEventNew(int i, String str, LinkedHashMap<String, String> linkedHashMap);

    void onForeground(long j);

    void onFragmentPause(Object obj);

    void onFragmentResume(Object obj);

    void onPause(Context context);

    void onPause(Context context, LinkedHashMap<String, String> linkedHashMap);

    void onPause(String str, LinkedHashMap<String, String> linkedHashMap);

    @Deprecated
    void onReport(int i);

    @Deprecated
    void onReport(Context context, int i);

    @Deprecated
    void onReportNew(int i);

    void onResume(Context context);

    void onResume(Context context, LinkedHashMap<String, String> linkedHashMap);

    void onResume(String str, LinkedHashMap<String, String> linkedHashMap);

    void onStreamEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap);

    void onStreamEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3);

    void onViewClick(View view, JSONObject jSONObject);

    void refresh(int i, HiAnalyticsConfig hiAnalyticsConfig);

    void removeExposureView(View view);

    void removeExposureView(View view, String str);

    void setAccountBrandId(String str);

    void setAppBrandId(String str);

    @Deprecated
    void setAppid(String str);

    void setCommonProp(int i, Map<String, String> map);

    void setExposureIdentifier(View view, String str);

    void setHandsetManufacturer(String str);

    void setHansetBrandId(String str);

    void setHonorOAID(int i, String str);

    void setOAID(int i, String str);

    void setOAIDTrackingFlag(int i, boolean z);

    void setUpid(int i, String str);
}
