package com.yfanads.android.db;

import android.text.TextUtils;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.callback.BaseEnsureListener;
import com.yfanads.android.callback.OnResultListener;
import com.yfanads.android.core.BaseChanelAdapter;
import com.yfanads.android.core.i;
import com.yfanads.android.libs.net.UrlConst;
import com.yfanads.android.libs.net.UrlHttpUtil;
import com.yfanads.android.libs.thirdpart.gson.Gson;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.StrategyModel;
import com.yfanads.android.model.YFAdType;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.utils.InitUtils;
import com.yfanads.android.utils.YFAdsConst;
import com.yfanads.android.utils.YFListUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: DataManager.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f9642a = new ConcurrentHashMap();
    public final ConcurrentHashMap b = new ConcurrentHashMap();

    /* JADX INFO: compiled from: DataManager.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f9643a = new d();
    }

    public static void c(final OnResultListener onResultListener, final StrategyModel strategyModel) {
        YFLog.high("DataManager onDataByNetSuccessOnMain in ");
        YFLog.enableUploadLogFile(strategyModel.isLogSwitch());
        YFUtil.switchMainThread("onDataByNetSuccessOnMain", new BaseEnsureListener() { // from class: com.yfanads.android.db.d$$ExternalSyntheticLambda2
            @Override // com.yfanads.android.callback.BaseEnsureListener
            public final void ensure() {
                onResultListener.onSuccess(strategyModel);
            }
        });
    }

    public final void a(String str, BaseChanelAdapter baseChanelAdapter, List<BaseChanelAdapter> list) {
        SdkSupplier sDKSupplier = baseChanelAdapter.getSDKSupplier();
        if (sDKSupplier == null || sDKSupplier.isCacheExpires()) {
            YFLog.high("DataManager [cache] expires, return.");
            boolean z = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(baseChanelAdapter.getSDKSupplier(), YFAdsConst.ReportETypeValue.ADS_CACHE_ADD_FAIL_EXPIRES.getValue(), "");
            return;
        }
        if (list.contains(baseChanelAdapter)) {
            boolean zRemove = list.remove(baseChanelAdapter);
            if (a(sDKSupplier)) {
                this.b.remove(sDKSupplier);
            }
            YFLog.high("[cache] has in remove " + zRemove);
        }
        sDKSupplier.index += 1000;
        sDKSupplier.setFromCache(true);
        baseChanelAdapter.setSDKSupplier(sDKSupplier);
        baseChanelAdapter.revertInterrupt();
        list.add(baseChanelAdapter);
        this.f9642a.put(str, list);
        if (a(sDKSupplier)) {
            this.b.put(sDKSupplier, baseChanelAdapter);
        }
        YFLog.high("add [cache] success i_" + sDKSupplier.index + "|p_" + sDKSupplier.ecpm);
        boolean z2 = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.a(baseChanelAdapter.getSDKSupplier(), YFAdsConst.ReportETypeValue.ADS_CACHE_ADD_SUCCESS.getValue(), "");
    }

    public static boolean a(SdkSupplier sdkSupplier) {
        return sdkSupplier != null && sdkSupplier.getCType() == YFAdType.INTR.getType();
    }

    public final BaseChanelAdapter a(String str) {
        SdkSupplier sDKSupplier;
        BaseChanelAdapter baseChanelAdapter = null;
        if (TextUtils.isEmpty(str)) {
            YFLog.high("DataManager this cacheId is null.");
            return null;
        }
        List list = (List) this.f9642a.get(str);
        if (YFListUtils.isEmpty(list)) {
            YFLog.high("DataManager cache has no");
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            BaseChanelAdapter baseChanelAdapter2 = (BaseChanelAdapter) it.next();
            SdkSupplier sDKSupplier2 = baseChanelAdapter2.getSDKSupplier();
            if (sDKSupplier2 != null) {
                if (sDKSupplier2.isCacheExpires()) {
                    YFLog.error("DataManager this channelAdapter is CacheExpires, remove " + sDKSupplier2.network);
                    baseChanelAdapter2.destroy("cache");
                    it.remove();
                    if (a(sDKSupplier2)) {
                        this.b.remove(sDKSupplier2);
                    }
                } else if (baseChanelAdapter == null || (sDKSupplier = baseChanelAdapter.getSDKSupplier()) == null || sDKSupplier2.ecpm >= sDKSupplier.ecpm) {
                    baseChanelAdapter = baseChanelAdapter2;
                }
            }
        }
        this.f9642a.put(str, list);
        return baseChanelAdapter;
    }

    public final SdkSupplier a(String str, String str2) {
        boolean z = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b bVar = com.yfanads.android.upload.b.a.f9685a;
        bVar.a(str, YFAdsConst.ReportETypeValue.ADS_CACHE_START.getValue(), str2);
        List list = (List) this.f9642a.get(str2);
        SdkSupplier sdkSupplier = null;
        if (YFListUtils.isEmpty(list)) {
            bVar.a(str, YFAdsConst.ReportETypeValue.ADS_CACHE_EMPTY.getValue(), str2);
            YFLog.high("DataManager cache has no");
            return null;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SdkSupplier sDKSupplier = ((BaseChanelAdapter) it.next()).getSDKSupplier();
            if (!sDKSupplier.isCacheExpires() && (sdkSupplier == null || sDKSupplier.ecpm >= sdkSupplier.ecpm)) {
                sdkSupplier = sDKSupplier;
            }
        }
        if (sdkSupplier != null) {
            String reqId = sdkSupplier.getReqId();
            YFLog.high("DataManager oldRId " + reqId);
            sdkSupplier.updateData(str);
            com.yfanads.android.upload.b.a.f9685a.a(sdkSupplier, YFAdsConst.ReportETypeValue.ADS_CACHE_SUCCESS.getValue(), reqId);
        } else {
            com.yfanads.android.upload.b.a.f9685a.a(str, YFAdsConst.ReportETypeValue.ADS_CACHE_EMPTY.getValue(), str2);
        }
        YFLog.high("DataManager getSdkSupplierCache " + sdkSupplier);
        return sdkSupplier;
    }

    public final boolean a(BaseChanelAdapter baseChanelAdapter, List list) {
        if (list.isEmpty()) {
            return true;
        }
        if (list.contains(baseChanelAdapter)) {
            boolean zRemove = list.remove(baseChanelAdapter);
            YFLog.high("DataManager old [cache] remove " + zRemove);
            return zRemove;
        }
        long ecpm = baseChanelAdapter.getEcpm();
        Iterator it = list.iterator();
        BaseChanelAdapter baseChanelAdapter2 = null;
        boolean z = false;
        while (it.hasNext()) {
            BaseChanelAdapter baseChanelAdapter3 = (BaseChanelAdapter) it.next();
            SdkSupplier sDKSupplier = baseChanelAdapter3.getSDKSupplier();
            if (sDKSupplier == null || sDKSupplier.isCacheExpires()) {
                baseChanelAdapter3.destroy("[cache] remove");
                it.remove();
                if (a(sDKSupplier)) {
                    this.b.remove(sDKSupplier);
                }
                z = true;
            }
            if (sDKSupplier != null && sDKSupplier.ecpm <= ecpm) {
                if (sDKSupplier.isBidding() && !baseChanelAdapter.isBidding() && sDKSupplier.ecpm == ecpm) {
                    YFLog.debug("DataManager 缓存中已经有相同价格的bidding，则同价格非bidding不写入缓存 " + baseChanelAdapter);
                    return false;
                }
                if (baseChanelAdapter2 == null || sDKSupplier.ecpm <= baseChanelAdapter2.getEcpm()) {
                    baseChanelAdapter2 = baseChanelAdapter3;
                }
            }
        }
        if (z) {
            return true;
        }
        if (baseChanelAdapter2 == null) {
            return false;
        }
        if (!baseChanelAdapter2.isBidSuccess()) {
            baseChanelAdapter2.destroy("[cache] ecpm lower");
        } else {
            YFLog.high("DataManager old [cache] remove " + baseChanelAdapter2);
        }
        SdkSupplier sDKSupplier2 = baseChanelAdapter2.getSDKSupplier();
        if (a(sDKSupplier2)) {
            this.b.remove(sDKSupplier2);
        }
        list.remove(baseChanelAdapter2);
        return true;
    }

    public final void a(final String str, final i.a aVar, final String str2, final YFAdsConfig yFAdsConfig) {
        Util.EXECUTOR.submit(new Runnable() { // from class: com.yfanads.android.db.d$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(str, aVar, str2, yFAdsConfig);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, OnResultListener onResultListener, String str2, YFAdsConfig yFAdsConfig) {
        com.yfanads.android.db.proxy.a aVar = new com.yfanads.android.db.proxy.a(new com.yfanads.android.db.imp.e(), new com.yfanads.android.db.imp.f());
        if (aVar.a(str, true)) {
            a("mem", aVar.c, onResultListener);
            boolean z = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(str2, YFAdsConst.ReportETypeValue.ADS_CONFIG_USE.getValue(), str);
            return;
        }
        if (aVar.b(str, true)) {
            a("sp", aVar.c, onResultListener);
            boolean z2 = com.yfanads.android.upload.b.e;
            com.yfanads.android.upload.b.a.f9685a.a(YFAdsConst.ReportETypeValue.ADS_CONFIG_USE.getValue(), 0, str2, "");
            return;
        }
        StrategyModel strategyModel = aVar.c;
        int ver = strategyModel != null ? strategyModel.getVer() : 0;
        String sectionID = strategyModel != null ? strategyModel.getSectionID() : "";
        YFLog.high("loadFromNet start.");
        boolean z3 = com.yfanads.android.upload.b.e;
        com.yfanads.android.upload.b.a.f9685a.a(str2, YFAdsConst.ReportETypeValue.ADS_CONFIG_START.getValue(), str);
        Map<String, Object> customDefine = yFAdsConfig == null ? null : yFAdsConfig.getCustomDefine();
        Map<String, Object> userDefine = yFAdsConfig == null ? null : yFAdsConfig.getUserDefine();
        b bVar = new b(this, aVar, str, onResultListener, str2);
        YFAdsPhone yFAdsPhone = YFAdsPhone.getInstance();
        YFAdsConfig yFAdsConfig2 = YFAdsManager.getInstance().getYFAdsConfig();
        HashMap map = new HashMap();
        String[] deviceIds = yFAdsPhone.getDeviceIds();
        map.put(YFAdsConst.REPORT_APPID, yFAdsConfig2.getAppId());
        if (deviceIds != null && deviceIds.length > 0) {
            map.put("deviceID", deviceIds[0]);
        }
        if (deviceIds != null && deviceIds.length > 1) {
            map.put("idfa", deviceIds[1]);
        }
        if (InitUtils.isQueryAllPackage()) {
            map.put("installedApp", Util.getAppSource() != null ? Util.getAppSource() : "");
        }
        map.put("adID", str);
        map.put("rID", str2);
        map.put("sID", sectionID);
        map.put("resourceVersion", Integer.valueOf(ver));
        map.put("sdkVersion", yFAdsPhone.getSDKVersion());
        map.put("appVersion", yFAdsConfig2.getAppVer());
        map.put("systemVersion", yFAdsPhone.os);
        map.put("deviceBrand", yFAdsPhone.brand);
        map.put("activationTime", Long.valueOf(yFAdsPhone.getActivationTime()));
        map.put("simCardStatus", Integer.valueOf(yFAdsPhone.getSimStatus()));
        if (!YFListUtils.isMapEmpty(customDefine)) {
            map.put("customDefine", customDefine);
        }
        if (!YFListUtils.isMapEmpty(userDefine)) {
            map.put("userDefine", userDefine);
        }
        String json = new Gson().toJson(map);
        if (UrlHttpUtil.IS_AES) {
            json = Util.encryptAES7(json, UrlConst.getKey());
        }
        UrlHttpUtil.postJson(UrlConst.getGetAds("/adsc", UrlHttpUtil.IS_AES), json, null, new c(this, UrlHttpUtil.IS_AES, bVar));
    }

    public static void a(String str, final StrategyModel strategyModel, final OnResultListener onResultListener) {
        YFLog.high("DataManager onDataSuccessOnMain in ".concat(str));
        YFLog.enableUploadLogFile(strategyModel.isLogSwitch());
        YFUtil.switchMainThread("onDataSuccessOnMain", new BaseEnsureListener() { // from class: com.yfanads.android.db.d$$ExternalSyntheticLambda3
            @Override // com.yfanads.android.callback.BaseEnsureListener
            public final void ensure() {
                onResultListener.onSuccess(strategyModel);
            }
        });
    }

    public static void a(String str, final int i, final String str2, final OnResultListener onResultListener) {
        YFLog.high("DataManager onDataFailOnMain in ".concat(str));
        YFUtil.switchMainThread(new BaseEnsureListener() { // from class: com.yfanads.android.db.d$$ExternalSyntheticLambda0
            @Override // com.yfanads.android.callback.BaseEnsureListener
            public final void ensure() {
                onResultListener.onFailed(i, str2);
            }
        });
    }
}
