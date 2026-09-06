package com.bytedance.msdk.adapter.gdt.base.config;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterBridgeWrapper;
import com.bytedance.msdk.adapter.gdt.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.gdt.base.utils.MediationValueUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class MediationInitConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<Object> f3069a;
    private SparseArray<Object> b;
    private SparseArray<Object> c;

    private MediationInitConfig(SparseArray<Object> sparseArray) {
        if (sparseArray != null) {
            this.f3069a = sparseArray;
            Object objObjectValue = MediationValueUtil.objectValue(sparseArray.get(8457), Object.class, null);
            if (objObjectValue != null) {
                this.c = AdnAdapterValueSetBuilder.converToSparseArray(objObjectValue);
            }
            a(MediationValueUtil.objectValue(sparseArray.get(8475), Object.class, null));
        }
        a();
    }

    private void a() {
        MediationApiLog.setDebug(Boolean.valueOf(isDebug()));
        c();
        d();
        b();
    }

    private void a(Object obj) {
        if (obj != null) {
            this.b = AdnAdapterValueSetBuilder.converToSparseArray(obj);
        }
    }

    private void b() {
        MediationApiLog.i("---------  sdk 聚合信息 start ----");
        MediationApiLog.i("getHttps：" + getHttps());
        MediationApiLog.i("getWxAppId：" + getWxAppId());
        MediationApiLog.i("getPublisherDid：" + getPublisherDid());
        MediationApiLog.i("isOpenAdnTest：" + isOpenAdnTest());
        MediationApiLog.i("getLocalExtra：" + getLocalExtra());
        MediationApiLog.i("getCustomLocalConfig：" + getCustomLocalConfig());
        MediationApiLog.i("getOpensdkVer：" + getOpensdkVer());
        MediationApiLog.i("isWxInstalled：" + isWxInstalled());
        MediationApiLog.i("isSupportH265：" + isSupportH265());
        MediationApiLog.i("isSupportSplashZoomout：" + isSupportSplashZoomout());
        MediationApiLog.i("---------  sdk 聚合信息 end ----");
    }

    private void c() {
        MediationApiLog.i("---------  sdk 初始化信息 start ----");
        MediationApiLog.i("isDebug：" + isDebug());
        MediationApiLog.i("getClassName：" + getClassName());
        MediationApiLog.i("getAppId：" + getAppId());
        MediationApiLog.i("getAppName：" + getAppName());
        MediationApiLog.i("getADNName：" + getADNName());
        MediationApiLog.i("getAppKey：" + getAppKey());
        MediationApiLog.i("getInitCallback：" + getInitCallback());
        MediationApiLog.i("getAgeGroup：" + getAgeGroup());
        MediationApiLog.i("isCustom：false");
        MediationApiLog.i("getKsAdapterVersion：" + getKsAdapterVersion());
        MediationApiLog.i("getGromoreVersion：" + getGromoreVersion());
        MediationApiLog.i("getBaiduAdapterVersion：" + getBaiduAdapterVersion());
        MediationApiLog.i("getGdtAdapterVersion：" + getGdtAdapterVersion());
        MediationApiLog.i("getSigmobAdapterVersion：" + getSigmobAdapterVersion());
        MediationApiLog.i("getMap：" + getInitAdnMap());
        MediationApiLog.i("---------  sdk 初始化信息 end ----");
    }

    public static MediationInitConfig create(SparseArray sparseArray) {
        return new MediationInitConfig(sparseArray);
    }

    private void d() {
        String str;
        MediationApiLog.i("---------  sdk 隐私设置 start ----");
        MediationApiLog.i("isCanUseLocation：" + isCanUseLocation());
        IMediationLocation location = getLocation();
        if (location != null) {
            MediationApiLog.i("getLocation getLatitude：" + location.getLatitude());
            str = "getLocation getLongitude：" + location.getLongitude();
        } else {
            str = "getLocation is null";
        }
        MediationApiLog.i(str);
        MediationApiLog.i("appList：" + appList());
        MediationApiLog.i("isCanUsePhoneState：" + isCanUsePhoneState());
        MediationApiLog.i("isLimitPersonalAds：" + isLimitPersonalAds());
        MediationApiLog.i("getDevImei：" + getDevImei());
        MediationApiLog.i("isCanUseWifiState：" + isCanUseWifiState());
        MediationApiLog.i("getMacAddress：" + getMacAddress());
        MediationApiLog.i("isCanUseWriteExternal：" + isCanUseWriteExternal());
        MediationApiLog.i("isCanUseAndroidId：" + isCanUseAndroidId());
        MediationApiLog.i("getAndroidId：" + getAndroidId());
        List<String> appList = getAppList();
        MediationApiLog.i("getAppList：" + appList);
        if (appList != null) {
            Iterator<String> it = appList.iterator();
            while (it.hasNext()) {
                MediationApiLog.i("getAppList item: " + it.next());
            }
        }
        List<String> devImeis = getDevImeis();
        MediationApiLog.i("getDevImeis：" + devImeis);
        if (devImeis != null) {
            Iterator<String> it2 = devImeis.iterator();
            while (it2.hasNext()) {
                MediationApiLog.i("getDevImeis item: " + it2.next());
            }
        }
        MediationApiLog.i("getDevOaid：" + getDevOaid());
        MediationApiLog.i("isCanUseOaid：" + isCanUseOaid());
        MediationApiLog.i("isCanUseMacAddress：" + isCanUseMacAddress());
        MediationApiLog.i("isProgrammaticRecommend：" + isProgrammaticRecommend());
        MediationApiLog.i("isCanUsePermissionRecordAudio：" + isCanUsePermissionRecordAudio());
        MediationApiLog.i("---------  sdk 隐私设置 end ----");
    }

    private boolean e() {
        SparseArray<Object> sparseArray = this.f3069a;
        return sparseArray != null && sparseArray.size() > 0;
    }

    public boolean appList() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8026), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public String getADNName() {
        return e() ? (String) MediationValueUtil.objectValue(this.f3069a.get(8003), String.class, null) : "";
    }

    public int getAgeGroup() {
        if (e()) {
            return ((Integer) MediationValueUtil.objectValue(this.f3069a.get(7), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public String getAndroidId() {
        SparseArray<Object> sparseArray = this.b;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8485), String.class, null) : "";
    }

    public String getAppId() {
        if (e()) {
            return (String) MediationValueUtil.objectValue(this.f3069a.get(3), String.class, null);
        }
        return null;
    }

    public String getAppKey() {
        return e() ? (String) MediationValueUtil.objectValue(this.f3069a.get(AVMDLDataLoader.KeyIsLiveWatchDurationThreshold), String.class, null) : "";
    }

    public List<String> getAppList() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null && (functionCovertToFunction = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8311), Object.class, null))) != null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(-99999987, -99999986);
            sparseArray2.put(-99999985, SparseArray.class);
            Object objApply = functionCovertToFunction.apply(sparseArray2);
            if (objApply instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) objApply).get(8476), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getAppName() {
        return e() ? (String) MediationValueUtil.objectValue(this.f3069a.get(8), String.class, null) : "";
    }

    public String getBaiduAdapterVersion() {
        SparseArray<Object> sparseArray = this.f3069a;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8413), String.class, null) : "";
    }

    public String getClassName() {
        return e() ? (String) MediationValueUtil.objectValue(this.f3069a.get(AVMDLDataLoader.KeyIsLiveMobileUploadAllow), String.class, null) : "";
    }

    public JSONObject getCustomLocalConfig() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return (JSONObject) MediationValueUtil.objectValue(sparseArray.get(8463), JSONObject.class, null);
        }
        return null;
    }

    public String getDevImei() {
        SparseArray<Object> sparseArray = this.b;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8484), String.class, null) : "";
    }

    public List<String> getDevImeis() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null && (functionCovertToFunction = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8311), Object.class, null))) != null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(-99999987, -99999986);
            sparseArray2.put(-99999985, SparseArray.class);
            Object objApply = functionCovertToFunction.apply(sparseArray2);
            if (objApply instanceof SparseArray) {
                return (List) MediationValueUtil.objectValue(((SparseArray) objApply).get(8477), List.class, null);
            }
        }
        return new LinkedList();
    }

    public String getDevOaid() {
        SparseArray<Object> sparseArray = this.b;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8486), String.class, null) : "";
    }

    public String getGdtAdapterVersion() {
        SparseArray<Object> sparseArray = this.f3069a;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8414), String.class, null) : "";
    }

    public String getGromoreVersion() {
        SparseArray<Object> sparseArray = this.f3069a;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8411), String.class, null) : "";
    }

    public boolean getHttps() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8458), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public Map getInitAdnMap() {
        SparseArray<Object> sparseArray = this.f3069a;
        return sparseArray != null ? (Map) MediationValueUtil.objectValue(sparseArray.get(8425), Map.class, null) : new HashMap();
    }

    public Function<SparseArray<Object>, Object> getInitCallback() {
        if (e()) {
            return AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(this.f3069a.get(8300), Object.class, null));
        }
        return null;
    }

    public String getKsAdapterVersion() {
        SparseArray<Object> sparseArray = this.f3069a;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8410), String.class, null) : "";
    }

    public Map getLocalExtra() {
        SparseArray<Object> sparseArray = this.c;
        return sparseArray != null ? (Map) MediationValueUtil.objectValue(sparseArray.get(8462), Map.class, null) : new HashMap();
    }

    public IMediationLocation getLocation() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null && (functionCovertToFunction = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8312), Object.class, null))) != null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(-99999987, -99999986);
            sparseArray2.put(-99999985, SparseArray.class);
            Object objApply = functionCovertToFunction.apply(sparseArray2);
            if (objApply instanceof SparseArray) {
                SparseArray sparseArray3 = (SparseArray) objApply;
                final double dDoubleValue = ((Double) MediationValueUtil.objectValue(sparseArray3.get(8481), Double.class, Double.valueOf(0.0d))).doubleValue();
                final double dDoubleValue2 = ((Double) MediationValueUtil.objectValue(sparseArray3.get(8482), Double.class, Double.valueOf(0.0d))).doubleValue();
                return new IMediationLocation() { // from class: com.bytedance.msdk.adapter.gdt.base.config.MediationInitConfig.1
                    @Override // com.bytedance.msdk.adapter.gdt.base.config.IMediationLocation
                    public double getLatitude() {
                        return dDoubleValue;
                    }

                    @Override // com.bytedance.msdk.adapter.gdt.base.config.IMediationLocation
                    public double getLongitude() {
                        return dDoubleValue2;
                    }
                };
            }
        }
        return null;
    }

    public String getMacAddress() {
        SparseArray<Object> sparseArray = this.b;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8487), String.class, null) : "";
    }

    public String getOpensdkVer() {
        SparseArray<Object> sparseArray = this.c;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8464), String.class, null) : "";
    }

    public String getPublisherDid() {
        SparseArray<Object> sparseArray = this.c;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8460), String.class, null) : "";
    }

    public String getSigmobAdapterVersion() {
        SparseArray<Object> sparseArray = this.f3069a;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8417), String.class, null) : "";
    }

    public SparseArray getValueSet() {
        return this.f3069a;
    }

    public String getWxAppId() {
        SparseArray<Object> sparseArray = this.c;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8459), String.class, null) : "";
    }

    public boolean isCanUseAndroidId() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8479), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isCanUseLocation() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8024), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isCanUseMacAddress() {
        return isCanUseWifiState();
    }

    public boolean isCanUseOaid() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray == null || (functionCovertToFunction = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8311), Object.class, null))) == null) {
            return true;
        }
        SparseArray<Object> sparseArray2 = new SparseArray<>();
        sparseArray2.put(-99999987, -99999986);
        sparseArray2.put(-99999985, SparseArray.class);
        Object objApply = functionCovertToFunction.apply(sparseArray2);
        if (objApply instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) objApply).get(8478), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isCanUsePermissionRecordAudio() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8549), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isCanUsePhoneState() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8023), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isCanUseWifiState() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8480), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isCanUseWriteExternal() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8025), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isDebug() {
        SparseArray<Object> sparseArray = this.f3069a;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(1), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isLimitPersonalAds() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null && (functionCovertToFunction = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8311), Object.class, null))) != null) {
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            sparseArray2.put(-99999987, -99999986);
            sparseArray2.put(-99999985, SparseArray.class);
            Object objApply = functionCovertToFunction.apply(sparseArray2);
            if (objApply instanceof SparseArray) {
                return ((Boolean) MediationValueUtil.objectValue(((SparseArray) objApply).get(8027), Boolean.class, false)).booleanValue();
            }
        }
        return false;
    }

    public boolean isOpenAdnTest() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8461), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isProgrammaticRecommend() {
        Function<SparseArray<Object>, Object> functionCovertToFunction;
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray == null || (functionCovertToFunction = AdnAdapterBridgeWrapper.covertToFunction(MediationValueUtil.objectValue(sparseArray.get(8311), Object.class, null))) == null) {
            return true;
        }
        SparseArray<Object> sparseArray2 = new SparseArray<>();
        sparseArray2.put(-99999987, -99999986);
        sparseArray2.put(-99999985, SparseArray.class);
        Object objApply = functionCovertToFunction.apply(sparseArray2);
        if (objApply instanceof SparseArray) {
            return ((Boolean) MediationValueUtil.objectValue(((SparseArray) objApply).get(8028), Boolean.class, false)).booleanValue();
        }
        return true;
    }

    public boolean isSupportH265() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8466), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isSupportSplashZoomout() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8467), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isWxInstalled() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8465), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public void setMediationCustomControllerValueSet(Object obj) {
        a(obj);
        d();
    }

    public Map<String, Object> userPrivacyConfig() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return (Map) MediationValueUtil.objectValue(sparseArray.get(8554), Map.class, null);
        }
        return null;
    }
}
