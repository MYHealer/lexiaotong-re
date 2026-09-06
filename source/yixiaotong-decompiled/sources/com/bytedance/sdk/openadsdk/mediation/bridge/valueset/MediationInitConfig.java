package com.bytedance.sdk.openadsdk.mediation.bridge.valueset;

import android.util.SparseArray;
import com.byazt.bog.a;
import com.byazt.op.tt;
import com.byazt.rl.ve;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomInitConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@c(c = {0, 80, 81, 82, 83, 265, AVMDLDataLoader.KeyIsIsTestSpeedVersion, 2009})
public class MediationInitConfig {
    private static String c = "MEDIATION_LOG";
    private ValueSet tt;
    private ValueSet uj;
    private ValueSet ve;

    public ValueSet getValueSet() {
        return this.tt;
    }

    private MediationInitConfig(ValueSet valueSet) {
        this.tt = valueSet;
        if (valueSet != null) {
            this.uj = ve.c((SparseArray<Object>) valueSet.objectValue(8457, SparseArray.class)).tt();
            this.ve = ve.c((SparseArray<Object>) this.tt.objectValue(8475, SparseArray.class)).tt();
        }
        c();
    }

    private void c() {
        ve();
        uj();
        tt();
    }

    private void tt() {
        a.ve(c, "---------  sdk 聚合信息 start ----");
        a.ve(c, "getHttps：" + getHttps());
        a.ve(c, "getWxAppId：" + getWxAppId());
        a.ve(c, "getPublisherDid：" + getPublisherDid());
        a.ve(c, "isOpenAdnTest：" + isOpenAdnTest());
        a.ve(c, "getMediationConfigUserInfoForSegment：" + getMediationConfigUserInfoForSegment());
        a.ve(c, "getLocalExtra：" + getLocalExtra());
        a.ve(c, "getCustomLocalConfig：" + getCustomLocalConfig());
        a.ve(c, "getOpensdkVer：" + getOpensdkVer());
        a.ve(c, "isWxInstalled：" + isWxInstalled());
        a.ve(c, "isSupportH265：" + isSupportH265());
        a.ve(c, "isSupportSplashZoomout：" + isSupportSplashZoomout());
        a.ve(c, "---------  sdk 聚合信息 end ----");
    }

    private void ve() {
        a.ve(c, "---------  sdk 初始化信息 start ----");
        a.ve(c, "isDebug：" + isDebug());
        a.ve(c, "getClassName：" + getClassName());
        a.ve(c, "getAppId：" + getAppId());
        a.ve(c, "getAppName：" + getAppName());
        a.ve(c, "getADNName：" + getADNName());
        a.ve(c, "getAppKey：" + getAppKey());
        a.ve(c, "getInitCallback：" + getInitCallback());
        a.ve(c, "getAgeGroup：" + getAgeGroup());
        a.ve(c, "isCustom：" + isCustom());
        a.ve(c, "getCustomInitConfig：" + getCustomInitConfig());
        a.ve(c, "getCustomInitMap：" + getCustomInitMap());
        a.ve(c, "getCustomGMConfiguration：" + getCustomGMConfiguration());
        a.ve(c, "getKsAdapterVersion：" + getKsAdapterVersion());
        a.ve(c, "getGromoreVersion：" + getGromoreVersion());
        a.ve(c, "getAdmobAdapterVersion：" + getAdmobAdapterVersion());
        a.ve(c, "getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        a.ve(c, "getGdtAdapterVersion：" + getGdtAdapterVersion());
        a.ve(c, "getKlevinAdapterVersion：" + getKlevinAdapterVersion());
        a.ve(c, "getMintegralAdapterVersion：" + getMintegralAdapterVersion());
        a.ve(c, "getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        a.ve(c, "getUnityAdapterVersion：" + getUnityAdapterVersion());
        a.ve(c, "getMap：" + getInitAdnMap());
        a.ve(c, "---------  sdk 初始化信息 end ----");
    }

    private void uj() {
        a.ve(c, "---------  sdk 隐私设置 start ----");
        a.ve(c, "isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            a.ve(c, "getLocation getLatitude：" + location.getLatitude());
            a.ve(c, "getLocation getLongitude：" + location.getLongitude());
        } else {
            a.ve(c, "getLocation is null");
        }
        a.ve(c, "appList：" + appList());
        a.ve(c, "isCanUsePhoneState：" + isCanUsePhoneState());
        a.ve(c, "isLimitPersonalAds：" + isLimitPersonalAds());
        a.ve(c, "getDevImei：" + getDevImei());
        a.ve(c, "isCanUseWifiState：" + isCanUseWifiState());
        a.ve(c, "getMacAddress：" + getMacAddress());
        a.ve(c, "isCanUseWriteExternal：" + isCanUseWriteExternal());
        a.ve(c, "isCanUseAndroidId：" + isCanUseAndroidId());
        a.ve(c, "getAndroidId：" + getAndroidId());
        a.ve(c, "isCanUseMessage：" + isCanUseMessage());
        List<String> appList = getAppList();
        a.ve(c, "getAppList：".concat(String.valueOf(appList)));
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                a.ve(c, "getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> devImeis = getDevImeis();
        a.ve(c, "getDevImeis：".concat(String.valueOf(devImeis)));
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                a.ve(c, "getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        a.ve(c, "getDevOaid：" + getDevOaid());
        a.ve(c, "isCanUseOaid：" + isCanUseOaid());
        a.ve(c, "isCanUseMacAddress：" + isCanUseMacAddress());
        a.ve(c, "isProgrammaticRecommend：" + isProgrammaticRecommend());
        a.ve(c, "isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        a.ve(c, "---------  sdk 隐私设置 end ----");
    }

    public static MediationInitConfig create(ValueSet valueSet) {
        return new MediationInitConfig(valueSet);
    }

    public void setMediationCustomControllerValueSet(ValueSet valueSet) {
        this.ve = valueSet;
        uj();
    }

    private boolean n() {
        ValueSet valueSet = this.tt;
        return (valueSet == null || valueSet.isEmpty()) ? false : true;
    }

    public String getClassName() {
        return n() ? this.tt.stringValue(AVMDLDataLoader.KeyIsLiveMobileUploadAllow) : "";
    }

    public String getAppId() {
        if (n()) {
            return this.tt.stringValue(3);
        }
        return null;
    }

    public String getAppName() {
        return n() ? this.tt.stringValue(8) : "";
    }

    public String getADNName() {
        return n() ? this.tt.stringValue(8003) : "";
    }

    public String getAppKey() {
        return n() ? this.tt.stringValue(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold) : "";
    }

    public Function getInitCallback() {
        if (n()) {
            return tt.covertToFunction(this.tt.objectValue(8300, Object.class));
        }
        return null;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.ve;
        if (valueSet == null || (functionCovertToFunction = tt.covertToFunction(valueSet.objectValue(8311, Object.class))) == null) {
            return false;
        }
        Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8027), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return false;
    }

    public boolean isCanUsePhoneState() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean isCanUseLocation() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean appList() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseAndroidId() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.ve;
        if (valueSet == null || (functionCovertToFunction = tt.covertToFunction(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8028), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.ve;
        if (valueSet != null && (functionCovertToFunction = tt.covertToFunction(valueSet.objectValue(8312, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                SparseArray sparseArray = (SparseArray) obj;
                final double dDoubleValue = ((Double) MediationValueUtil.objectValue(sparseArray.get(8481), Double.class, Double.valueOf(0.0d))).doubleValue();
                final double dDoubleValue2 = ((Double) MediationValueUtil.objectValue(sparseArray.get(8482), Double.class, Double.valueOf(0.0d))).doubleValue();
                return new IMediationLocation() { // from class: com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationInitConfig.1
                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLatitude() {
                        return dDoubleValue;
                    }

                    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.IMediationLocation
                    public double getLongitude() {
                        return dDoubleValue2;
                    }
                };
            }
        }
        return null;
    }

    public String getDevImei() {
        ValueSet valueSet = this.ve;
        return valueSet != null ? valueSet.stringValue(8484) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.ve;
        if (valueSet != null && (functionCovertToFunction = tt.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAndroidId() {
        ValueSet valueSet = this.ve;
        return valueSet != null ? valueSet.stringValue(8485) : "";
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.ve;
        if (valueSet == null || (functionCovertToFunction = tt.covertToFunction(valueSet.objectValue(8311, Object.class))) == null) {
            return true;
        }
        Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
        if (obj instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) obj).get(8478), Boolean.class, Boolean.FALSE)).booleanValue();
        }
        return true;
    }

    public String getDevOaid() {
        ValueSet valueSet = this.ve;
        return valueSet != null ? valueSet.stringValue(8486) : "";
    }

    public String getMacAddress() {
        ValueSet valueSet = this.ve;
        return valueSet != null ? valueSet.stringValue(8487) : "";
    }

    public boolean isCanUseWifiState() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8480);
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8549);
        }
        return true;
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        ValueSet valueSet = this.ve;
        if (valueSet != null && (functionCovertToFunction = tt.covertToFunction(valueSet.objectValue(8311, Object.class))) != null) {
            Object obj = functionCovertToFunction instanceof Supplier ? ((Supplier) functionCovertToFunction).get() : null;
            if (obj instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) obj).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public Map<String, Object> userPrivacyConfig() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean isCanUseMessage() {
        ValueSet valueSet = this.ve;
        if (valueSet != null) {
            return valueSet.booleanValue(8562);
        }
        return true;
    }

    public int getAgeGroup() {
        if (n()) {
            return this.tt.intValue(7);
        }
        return 0;
    }

    public boolean isCustom() {
        if (n()) {
            return this.tt.booleanValue(8098);
        }
        return false;
    }

    public MediationCustomInitConfig getCustomInitConfig() {
        if (n()) {
            return (MediationCustomInitConfig) this.tt.objectValue(8099, MediationCustomInitConfig.class);
        }
        return null;
    }

    public ValueSet getCustomInitConfigValueSet() {
        if (n()) {
            return ve.c((SparseArray<Object>) this.tt.objectValue(8545, SparseArray.class)).tt();
        }
        return null;
    }

    public Map getCustomInitMap() {
        if (n()) {
            return (Map) this.tt.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function getCustomGMConfiguration() {
        if (n()) {
            return tt.covertToFunction(this.tt.objectValue(8401, Object.class));
        }
        return null;
    }

    public boolean isDebug() {
        ValueSet valueSet = this.tt;
        if (valueSet != null) {
            return valueSet.booleanValue(1);
        }
        return false;
    }

    public String getKsAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8410) : "";
    }

    public String getGromoreVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8411) : "";
    }

    public String getAdmobAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8412) : "";
    }

    public String getBaiduAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8413) : "";
    }

    public String getGdtAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8414) : "";
    }

    public String getKlevinAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8415) : "";
    }

    public String getMintegralAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8416) : "";
    }

    public String getSigmobAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8417) : "";
    }

    public String getUnityAdapterVersion() {
        ValueSet valueSet = this.tt;
        return valueSet != null ? valueSet.stringValue(8418) : "";
    }

    public Map getInitAdnMap() {
        ValueSet valueSet = this.tt;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean getHttps() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return valueSet.booleanValue(8458);
        }
        return false;
    }

    public String getWxAppId() {
        ValueSet valueSet = this.uj;
        return valueSet != null ? valueSet.stringValue(8459) : "";
    }

    public String getPublisherDid() {
        ValueSet valueSet = this.uj;
        return valueSet != null ? valueSet.stringValue(8460) : "";
    }

    public boolean isOpenAdnTest() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return valueSet.booleanValue(8461);
        }
        return false;
    }

    public Function getMediationConfigUserInfoForSegment() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return tt.covertToFunction(valueSet.objectValue(8310, Object.class));
        }
        return null;
    }

    public Map getLocalExtra() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return (Map) valueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject getCustomLocalConfig() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return (JSONObject) valueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String getOpensdkVer() {
        ValueSet valueSet = this.uj;
        return valueSet != null ? valueSet.stringValue(8464) : "";
    }

    public boolean isWxInstalled() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return valueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean isSupportH265() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return valueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        ValueSet valueSet = this.uj;
        if (valueSet != null) {
            return valueSet.booleanValue(8467);
        }
        return false;
    }

    public String getAdapterManagerClassName() {
        ValueSet valueSet = this.tt;
        if (valueSet != null) {
            return valueSet.stringValue(8560);
        }
        return null;
    }
}
