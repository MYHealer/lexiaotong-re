package com.hihonor.hianalytics.process;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.hianalytics.hnha.c1;
import com.hihonor.hianalytics.hnha.h;
import com.hihonor.hianalytics.hnha.j2;
import com.hihonor.hianalytics.hnha.k1;
import com.hihonor.hianalytics.hnha.n1;
import com.hihonor.hianalytics.hnha.p2;
import com.hihonor.hianalytics.hnha.z0;
import com.hihonor.hianalytics.module.ModuleConstants;
import com.hihonor.hianalytics.module.exposure.ExposureInfo;
import com.hihonor.hianalytics.util.SystemUtils;
import com.hihonor.hianalytics.util.o;
import com.hihonor.hianalytics.util.p;
import com.huawei.hms.ads.ez;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.utils.YFAdsConst;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class d implements HiAnalyticsInstance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f3710a;
    public final c1 b;

    public d(String str) {
        this.f3710a = str;
        this.b = new c1(str);
    }

    private boolean a(int i) {
        return o.a(this.f3710a, i, this.b.a(i)) == 0;
    }

    public void a(HiAnalyticsConfig hiAnalyticsConfig) {
        j2.a("HiAnalyticsInstanceImpl", "setDiffConf haTag=" + this.f3710a + ",diffConf=" + hiAnalyticsConfig);
        this.b.a(hiAnalyticsConfig == null ? null : hiAnalyticsConfig.cfgData);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void addExposureView(View view, ExposureInfo exposureInfo) {
        com.hihonor.hianalytics.module.a.a(ModuleConstants.SUB_MODULE_AUTO, 201, view, exposureInfo);
    }

    public void b(HiAnalyticsConfig hiAnalyticsConfig) {
        j2.a("HiAnalyticsInstanceImpl", "setMaintConf haTag=" + this.f3710a + ",mainConf=" + hiAnalyticsConfig);
        this.b.b(hiAnalyticsConfig == null ? null : hiAnalyticsConfig.cfgData);
    }

    public void c(HiAnalyticsConfig hiAnalyticsConfig) {
        j2.a("HiAnalyticsInstanceImpl", "setOperConf haTag=" + this.f3710a + ",operConf=" + hiAnalyticsConfig);
        this.b.c(hiAnalyticsConfig == null ? null : hiAnalyticsConfig.cfgData);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void clearData() {
        if (!SystemUtils.a()) {
            j2.g("HiAnalyticsInstanceImpl", "clearData haTag=" + this.f3710a + " with userUnLock");
        } else {
            j2.d("HiAnalyticsInstanceImpl", "clearData haTag=" + this.f3710a);
            b.a(this.f3710a);
        }
    }

    public void d(HiAnalyticsConfig hiAnalyticsConfig) {
        j2.a("HiAnalyticsInstanceImpl", "setPreInstallConf haTag=" + this.f3710a + ",preInstallConf=" + hiAnalyticsConfig);
        this.b.d(hiAnalyticsConfig == null ? null : hiAnalyticsConfig.cfgData);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public boolean hasCachedData(int i) {
        return p2.c().a(this.f3710a, i);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void newInstanceUUID() throws IllegalAccessException, InvocationTargetException {
        boolean zG;
        int i;
        StringBuilder sbAppend;
        String str;
        String strA = p.a("global_v2", this.f3710a, "");
        if (TextUtils.isEmpty(strA)) {
            strA = UUID.randomUUID().toString().replace(x.A, "");
            p.b("global_v2", this.f3710a, strA);
            zG = this.b.g(strA);
            i = zG ? 5 : 4;
            sbAppend = new StringBuilder("newInstanceUUID haTag==").append(this.f3710a).append(",isChange=").append(zG);
            str = ",newInstanceUUID=";
        } else {
            zG = this.b.g(strA);
            i = zG ? 5 : 4;
            sbAppend = new StringBuilder("newInstanceUUID haTag==").append(this.f3710a).append(",isChange=").append(zG);
            str = ",instanceUUID=";
        }
        j2.a(i, "HiAnalyticsInstanceImpl", sbAppend.append(str).append(SystemUtils.a(strA)).toString());
        if (zG) {
            b.c(this.f3710a);
        }
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onBackground(long j) {
        StringBuilder sbAppend;
        String str;
        z0 z0VarI = this.b.i();
        if (z0VarI == null) {
            sbAppend = new StringBuilder("onBackground haTag=").append(this.f3710a);
            str = " with No operConf";
        } else if (z0VarI.r()) {
            j2.c("HiAnalyticsInstanceImpl", "onBackground haTag=" + this.f3710a + ",time=" + j);
            k1.a().a(this.f3710a, j);
            return;
        } else {
            sbAppend = new StringBuilder("onBackground haTag=").append(this.f3710a);
            str = " with sessionSwitch not open";
        }
        j2.g("HiAnalyticsInstanceImpl", sbAppend.append(str).toString());
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        p2.c().a(this.f3710a, i, str, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3) {
        p2.c().a(this.f3710a, i, str, linkedHashMap, linkedHashMap2, linkedHashMap3);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    @Deprecated
    public void onEvent(Context context, String str, String str2) {
        p2.c().a(this.f3710a, str, str2);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onEvent(String str, LinkedHashMap<String, String> linkedHashMap) {
        p2.c().a(this.f3710a, 0, str, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onEventNew(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        p2.c().a(this.f3710a, i, str, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onForeground(long j) {
        StringBuilder sbAppend;
        String str;
        z0 z0VarI = this.b.i();
        if (z0VarI == null) {
            sbAppend = new StringBuilder("onForeground haTag=").append(this.f3710a);
            str = " with No operConf";
        } else if (z0VarI.r()) {
            j2.c("HiAnalyticsInstanceImpl", "onForeground haTag=" + this.f3710a + ",time=" + j);
            k1.a().b(this.f3710a, j);
            return;
        } else {
            sbAppend = new StringBuilder("onForeground haTag=").append(this.f3710a);
            str = " with sessionSwitch not open";
        }
        j2.g("HiAnalyticsInstanceImpl", sbAppend.append(str).toString());
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onFragmentPause(Object obj) {
        com.hihonor.hianalytics.module.a.a(ModuleConstants.SUB_MODULE_AUTO, 2, obj);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onFragmentResume(Object obj) {
        com.hihonor.hianalytics.module.a.a(ModuleConstants.SUB_MODULE_AUTO, 3, obj);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onPause(Context context) throws IllegalAccessException, InvocationTargetException {
        if (!SystemUtils.a()) {
            j2.g("HiAnalyticsInstanceImpl", "onPause haTag=" + this.f3710a + " with userUnLock");
            return;
        }
        if (context == null) {
            j2.g("HiAnalyticsInstanceImpl", "onPause haTag=" + this.f3710a + " with null context");
        } else if (!a(0)) {
            j2.g("HiAnalyticsInstanceImpl", "onPause haTag=" + this.f3710a + " with illegalOperUrl");
        } else {
            j2.a("HiAnalyticsInstanceImpl", "onPause haTag=" + this.f3710a);
            n1.a().a(this.f3710a, context);
        }
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onPause(Context context, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        if (!SystemUtils.a()) {
            j2.g("HiAnalyticsInstanceImpl", "onPause2 haTag=" + this.f3710a + " with userUnLock");
            return;
        }
        if (context == null) {
            j2.g("HiAnalyticsInstanceImpl", "onPause2 haTag=" + this.f3710a + " with null context");
            return;
        }
        if (!a(0)) {
            j2.g("HiAnalyticsInstanceImpl", "onPause2 haTag=" + this.f3710a + " with illegalOperUrl");
            return;
        }
        if (o.c(linkedHashMap)) {
            j2.c("HiAnalyticsInstanceImpl", "onPause2 haTag=" + this.f3710a);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "onPause2 haTag=" + this.f3710a + " with illegalMapValue");
            linkedHashMap = null;
        }
        n1.a().a(this.f3710a, context, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onPause(String str, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        if (!SystemUtils.a()) {
            j2.g("HiAnalyticsInstanceImpl", "onPause3 haTag=" + this.f3710a + ",viewName=" + str + " with userUnLock");
            return;
        }
        if (!a(0)) {
            j2.g("HiAnalyticsInstanceImpl", "onPause3 haTag=" + this.f3710a + ",viewName=" + str + " with illegalOperUrl");
            return;
        }
        if (TextUtils.isEmpty(str) || !o.a("viewName", str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
            j2.g("HiAnalyticsInstanceImpl", "onPause3 haTag=" + this.f3710a + ",illegalViewName=" + str);
            return;
        }
        if (o.c(linkedHashMap)) {
            j2.c("HiAnalyticsInstanceImpl", "onPause3 haTag=" + this.f3710a + ",viewName=" + str);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "onPause3 haTag=" + this.f3710a + ",viewName=" + str + " with illegalMapValue");
            linkedHashMap = null;
        }
        n1.a().a(this.f3710a, str, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onReport(int i) {
        j2.a("HiAnalyticsInstanceImpl", "onReport haTag=" + this.f3710a + ",type=" + i);
        p2.c().a(this.f3710a, i, 2);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    @Deprecated
    public void onReport(Context context, int i) {
        j2.a("HiAnalyticsInstanceImpl", "onReport2 haTag=" + this.f3710a + ",type=" + i);
        p2.c().a(this.f3710a, i, 2);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onReportNew(int i) {
        j2.a("HiAnalyticsInstanceImpl", "onReportNew haTag=" + this.f3710a + ",type=" + i);
        p2.c().a(this.f3710a, i, 2);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onResume(Context context) throws IllegalAccessException, InvocationTargetException {
        if (!SystemUtils.a()) {
            j2.g("HiAnalyticsInstanceImpl", "onResume haTag=" + this.f3710a + " with userUnLock");
            return;
        }
        if (context == null) {
            j2.g("HiAnalyticsInstanceImpl", "onResume haTag=" + this.f3710a + " with null context");
        } else if (!a(0)) {
            j2.g("HiAnalyticsInstanceImpl", "onResume haTag=" + this.f3710a + " with illegalOperUrl");
        } else {
            j2.c("HiAnalyticsInstanceImpl", "onResume haTag=" + this.f3710a);
            n1.a().b(this.f3710a, context);
        }
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onResume(Context context, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        if (!SystemUtils.a()) {
            j2.g("HiAnalyticsInstanceImpl", "onResume2 haTag=" + this.f3710a + " with userUnLock");
            return;
        }
        if (context == null) {
            j2.g("HiAnalyticsInstanceImpl", "onResume2 haTag=" + this.f3710a + " with null context");
            return;
        }
        if (!a(0)) {
            j2.g("HiAnalyticsInstanceImpl", "onResume2 haTag=" + this.f3710a + " with illegalOperUrl");
            return;
        }
        if (o.c(linkedHashMap)) {
            j2.c("HiAnalyticsInstanceImpl", "onResume2 haTag=" + this.f3710a);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "onResume2 haTag=" + this.f3710a + " with illegalMapValue");
            linkedHashMap = null;
        }
        n1.a().b(this.f3710a, context, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onResume(String str, LinkedHashMap<String, String> linkedHashMap) throws IllegalAccessException, InvocationTargetException {
        if (!SystemUtils.a()) {
            j2.g("HiAnalyticsInstanceImpl", "onResume3 haTag=" + this.f3710a + ",viewName=" + str + " with userUnLock");
            return;
        }
        if (!a(0)) {
            j2.g("HiAnalyticsInstanceImpl", "onResume3 haTag=" + this.f3710a + ",viewName=" + str + " with illegalOperUrl");
            return;
        }
        if (TextUtils.isEmpty(str) || !o.a("viewName", str, "[a-zA-Z_][a-zA-Z0-9. _-]{0,255}")) {
            j2.g("HiAnalyticsInstanceImpl", "onResume3 haTag=" + this.f3710a + ",illegalViewName=" + str);
            return;
        }
        if (o.c(linkedHashMap)) {
            j2.c("HiAnalyticsInstanceImpl", "onResume3 haTag=" + this.f3710a + ",viewName=" + str);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "onResume3 haTag=" + this.f3710a + ",viewName=" + str + " with illegalMapValue");
            linkedHashMap = null;
        }
        n1.a().b(this.f3710a, str, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onStreamEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        p2.c().b(this.f3710a, i, str, linkedHashMap);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onStreamEvent(int i, String str, LinkedHashMap<String, String> linkedHashMap, LinkedHashMap<String, String> linkedHashMap2, LinkedHashMap<String, String> linkedHashMap3) {
        p2.c().b(this.f3710a, i, str, linkedHashMap, linkedHashMap2, linkedHashMap3);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void onViewClick(View view, JSONObject jSONObject) {
        com.hihonor.hianalytics.module.a.a(ModuleConstants.SUB_MODULE_AUTO, 101, view, jSONObject);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void refresh(int i, HiAnalyticsConfig hiAnalyticsConfig) {
        HiAnalyticsConfig hiAnalyticsConfig2;
        if (hiAnalyticsConfig == null) {
            j2.g("HiAnalyticsInstanceImpl", "refresh haTag=" + this.f3710a + ",type=" + i + " with config null");
            hiAnalyticsConfig2 = null;
        } else {
            j2.a("HiAnalyticsInstanceImpl", "refresh haTag=" + this.f3710a + ",type=" + i + ",config=" + hiAnalyticsConfig);
            hiAnalyticsConfig2 = new HiAnalyticsConfig(hiAnalyticsConfig);
        }
        if (i == 0) {
            c(hiAnalyticsConfig2);
            k1.a().b(this.f3710a);
        } else if (i == 1) {
            b(hiAnalyticsConfig2);
        } else if (i == 2) {
            d(hiAnalyticsConfig2);
        } else if (i != 3) {
            j2.a("HiAnalyticsInstanceImpl", "refresh haTag=" + this.f3710a + ",illegalType=" + i);
        } else {
            a(hiAnalyticsConfig2);
        }
        b.a(this.f3710a, i);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void removeExposureView(View view) {
        com.hihonor.hianalytics.module.a.a(ModuleConstants.SUB_MODULE_AUTO, 202, view);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void removeExposureView(View view, String str) {
        com.hihonor.hianalytics.module.a.a(ModuleConstants.SUB_MODULE_AUTO, 202, view, str);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setAccountBrandId(String str) {
        if (o.b("accountBrandId", str, 256)) {
            j2.a("HiAnalyticsInstanceImpl", "setAccountBrandId haTag=" + this.f3710a + ",accountBrandId=" + str);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "setAccountBrandId haTag=" + this.f3710a + ",overLenAccountBrandId=" + str);
            str = "";
        }
        h.l(this.f3710a, str);
        b.c(this.f3710a);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setAppBrandId(String str) {
        if (o.b("appBrandId", str, 256)) {
            j2.a("HiAnalyticsInstanceImpl", "setAppBrandId haTag=" + this.f3710a + ",appBrandId=" + str);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "setAppBrandId haTag=" + this.f3710a + ",overLenAppBrandId=" + str);
            str = "";
        }
        h.m(this.f3710a, str);
        b.c(this.f3710a);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setAppid(String str) {
        j2.a("HiAnalyticsInstanceImpl", "setAppid haTag=" + this.f3710a + ",appid=" + str);
        h.n(this.f3710a, o.a(YFAdsConst.REPORT_APPID, str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", ""));
        b.c(this.f3710a);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setCommonProp(int i, Map<String, String> map) {
        if (!o.c(map)) {
            j2.e("HiAnalyticsInstanceImpl", "setCommonProp haTag=" + this.f3710a + ",type=" + i + " with illegalMapValue");
            return;
        }
        JSONObject jSONObject = new JSONObject(map);
        z0 z0VarA = this.b.a(i);
        if (z0VarA == null) {
            j2.e("HiAnalyticsInstanceImpl", "setCommonProp haTag=" + this.f3710a + ",type=" + i + " with cfgData null");
            return;
        }
        j2.d("HiAnalyticsInstanceImpl", "setCommonProp haTag=" + this.f3710a + ",type=" + i);
        z0VarA.f(String.valueOf(jSONObject));
        b.a(this.f3710a, i);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setExposureIdentifier(View view, String str) {
        com.hihonor.hianalytics.module.a.a(ModuleConstants.SUB_MODULE_AUTO, 203, view, str);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setHandsetManufacturer(String str) {
        if (o.b("handsetManufacturer", str, 256)) {
            j2.a("HiAnalyticsInstanceImpl", "setHandsetManufacturer haTag=" + this.f3710a + ",handsetManufacturer=" + str);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "setHandsetManufacturer haTag=" + this.f3710a + ",overLenHandsetManufacturer=" + str);
            str = "";
        }
        h.o(this.f3710a, str);
        b.c(this.f3710a);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setHansetBrandId(String str) {
        if (o.b("hansetBrandId", str, 256)) {
            j2.a("HiAnalyticsInstanceImpl", "setHansetBrandId haTag=" + this.f3710a + ",hansetBrandId=" + str);
        } else {
            j2.g("HiAnalyticsInstanceImpl", "setHansetBrandId haTag=" + this.f3710a + ",overLenHansetBrandId=" + str);
            str = "";
        }
        h.p(this.f3710a, str);
        b.c(this.f3710a);
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setHonorOAID(int i, String str) {
        boolean zD;
        z0 z0VarA = this.b.a(i);
        if (z0VarA == null) {
            j2.g("HiAnalyticsInstanceImpl", "setHonorOAID haTag=" + this.f3710a + ",type=" + i + ",oaid=" + SystemUtils.a(str) + " with config null");
            return;
        }
        if (o.b("oaid", str, 4096)) {
            zD = z0VarA.d(str);
            j2.a(zD ? 5 : 4, "HiAnalyticsInstanceImpl", "setHonorOAID haTag=" + this.f3710a + ",type=" + i + ",isChange=" + zD + ",oaid=" + SystemUtils.a(str));
        } else {
            zD = z0VarA.d("");
            j2.g("HiAnalyticsInstanceImpl", "setHonorOAID haTag=" + this.f3710a + ",type=" + i + ",isChange=" + zD + ",overLenOaid=" + SystemUtils.a(str));
        }
        if (zD) {
            b.a(this.f3710a, i);
        }
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setOAID(int i, String str) {
        boolean zG;
        z0 z0VarA = this.b.a(i);
        if (z0VarA == null) {
            j2.g("HiAnalyticsInstanceImpl", "setOAID haTag=" + this.f3710a + ",type=" + i + ",oaid=" + SystemUtils.a(str) + " with config null");
            return;
        }
        if (o.b("oaid", str, 4096)) {
            zG = z0VarA.g(str);
            j2.a(zG ? 5 : 4, "HiAnalyticsInstanceImpl", "setOAID haTag=" + this.f3710a + ",type=" + i + ",isChange=" + zG + ",oaid=" + SystemUtils.a(str));
        } else {
            zG = z0VarA.g("");
            j2.g("HiAnalyticsInstanceImpl", "setOAID haTag=" + this.f3710a + ",type=" + i + ",isChange=" + zG + ",overLenOaid=" + SystemUtils.a(str));
        }
        if (zG) {
            b.a(this.f3710a, i);
        }
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setOAIDTrackingFlag(int i, boolean z) {
        z0 z0VarA = this.b.a(i);
        if (z0VarA == null) {
            j2.g("HiAnalyticsInstanceImpl", "setOAIDTrackingFlag haTag=" + this.f3710a + ",type=" + i + ",isOAIDTracking=" + z + " with config null");
            return;
        }
        boolean zI = z0VarA.i(z ? ez.Code : ez.V);
        j2.a(zI ? 5 : 4, "HiAnalyticsInstanceImpl", "setOAIDTrackingFlag haTag=" + this.f3710a + ",type=" + i + ",isChange=" + zI + ",isOAIDTracking=" + z);
        if (zI) {
            b.a(this.f3710a, i);
        }
    }

    @Override // com.hihonor.hianalytics.process.HiAnalyticsInstance
    public void setUpid(int i, String str) {
        boolean zH;
        z0 z0VarA = this.b.a(i);
        if (z0VarA == null) {
            j2.g("HiAnalyticsInstanceImpl", "setUpid haTag=" + this.f3710a + ",type=" + i + ",upid=" + SystemUtils.a(str) + " with config null");
            return;
        }
        if (o.b("upid", str, 4096)) {
            zH = z0VarA.h(str);
            j2.a(zH ? 5 : 4, "HiAnalyticsInstanceImpl", "setUpid haTag=" + this.f3710a + ",type=" + i + ",isChange=" + zH + ",upid=" + SystemUtils.a(str));
        } else {
            zH = z0VarA.h("");
            j2.g("HiAnalyticsInstanceImpl", "setUpid haTag=" + this.f3710a + ",type=" + i + ",isChange=" + zH + ",overLenUpid=" + SystemUtils.a(str));
        }
        if (zH) {
            b.a(this.f3710a, i);
        }
    }
}
