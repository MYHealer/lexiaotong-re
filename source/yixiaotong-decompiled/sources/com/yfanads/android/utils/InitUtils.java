package com.yfanads.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.openalliance.ad.constant.x;
import com.yfanads.android.YFAdsConfig;
import com.yfanads.android.YFAdsManager;
import com.yfanads.android.core.f;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.impl.YFAbsNativeAd;
import com.yfanads.android.libs.utils.DeviceUtils;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.model.AdInfo;
import com.yfanads.android.model.AdsInitBean;
import com.yfanads.android.model.SdkConfModel;
import com.yfanads.android.model.SdkSupplier;
import com.yfanads.android.model.YFAdError;
import com.yfanads.android.upload.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class InitUtils {
    private static final String APP_LIST_SPLIT = ",";
    public static final String REQUEST_ID = "request_id";
    private static final String TAG = "InitUtils";
    public static boolean isDebug = true;
    private static int shakeStatue = -1;
    private static final List<String> LAST_ADS_LIST = new CopyOnWriteArrayList();
    private static final Map<Integer, YFAdsConst.AdSource> CHANNELS = new ConcurrentHashMap();
    private static final Map<String, List<InitListener>> INIT_ADAPTER_LIST = new ConcurrentHashMap();
    private static final AtomicReference<SdkConfModel> sdkConfModel = new AtomicReference<>();

    public interface InitListener {
        void fail(String str, String str2);

        void success();
    }

    public static boolean canQueryJdPackage() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        return atomicReference.get() != null && atomicReference.get().canQueryJdPackage();
    }

    private static void clearCache() {
        CHANNELS.clear();
        Util.getVersion().clear();
        LAST_ADS_LIST.clear();
        INIT_ADAPTER_LIST.clear();
    }

    public static void closeULF() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            atomicReference.get().setULF(0);
        }
    }

    public static AdInfo getAdInfo(YFAbsNativeAd yFAbsNativeAd, String str) {
        if (yFAbsNativeAd == null) {
            return null;
        }
        return new AdInfo(yFAbsNativeAd.getAdTitle(), yFAbsNativeAd.getBrandName(), str);
    }

    public static Map<Integer, YFAdsConst.AdSource> getAdSource() {
        return CHANNELS;
    }

    public static Map<String, Object> getAds() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            return YFUtil.jsonToMap(atomicReference.get().getAds());
        }
        return null;
    }

    public static List<Integer> getChannels() {
        return new ArrayList(CHANNELS.keySet());
    }

    public static int getClickRatio(SdkSupplier sdkSupplier) {
        int iIntValue;
        if (sdkSupplier == null || sdkSupplier.network == null) {
            return 100;
        }
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() == null) {
            return getDefaultValue(sdkSupplier);
        }
        try {
            Map<String, Object> mapJsonToMap = YFUtil.jsonToMap(atomicReference.get().getXcc());
            String strValueOf = String.valueOf(sdkSupplier.network.networkId);
            if (mapJsonToMap == null) {
                return getDefaultValue(sdkSupplier);
            }
            if (!mapJsonToMap.containsKey(strValueOf)) {
                return getDefaultValue(sdkSupplier);
            }
            int defaultValue = getDefaultValue(sdkSupplier);
            Object obj = mapJsonToMap.get(strValueOf);
            if (obj instanceof Integer) {
                iIntValue = ((Integer) obj).intValue();
            } else {
                if (!(obj instanceof String)) {
                    return obj instanceof Double ? (int) ((Double) obj).doubleValue() : defaultValue;
                }
                iIntValue = Integer.parseInt((String) obj);
            }
            return iIntValue;
        } catch (Exception e) {
            YFLog.debug("getClickRatio error: " + e.getMessage());
            return getDefaultValue(sdkSupplier);
        }
    }

    public static SdkConfModel getConfModel() {
        return sdkConfModel.get();
    }

    private static int getDefaultValue(SdkSupplier sdkSupplier) {
        return sdkSupplier.getChannel() == 12 ? 30 : 100;
    }

    public static int getElun() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            return atomicReference.get().getElun();
        }
        return 20;
    }

    public static float getFactors() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            return atomicReference.get().getEr();
        }
        return 1.0f;
    }

    public static boolean getLimitPersonal(YFAdsConst.ReportAdnIdValue reportAdnIdValue, YFAdsConfig yFAdsConfig) {
        int[] permissionValues = getPermissionValues(reportAdnIdValue.getValue());
        int permissionKey = getPermissionKey(YFAdsConst.LP);
        return isPermissionForce(permissionValues, permissionKey) ? isPermissionOpen(permissionValues, permissionKey) : yFAdsConfig.isLimitPersonal();
    }

    public static String getOaID(YFAdsConfig yFAdsConfig) {
        String devOaid = yFAdsConfig.getDevOaid();
        if (TextUtils.isEmpty(devOaid)) {
            return TextUtils.isEmpty(DeviceUtils.getCacheOAID()) ? DeviceUtils.getClientId() : DeviceUtils.getCacheOAID();
        }
        return devOaid;
    }

    public static int getPermissionKey(String str) {
        str.getClass();
        str.hashCode();
        switch (str) {
            case "lp":
                return 8;
            case "car":
                return 7;
            case "cua":
                return 1;
            case "cul":
                return 3;
            case "cuo":
                return 4;
            case "cup":
                return 5;
            case "cuw":
                return 6;
            case "cwe":
                return 0;
            case "cuaid":
                return 2;
            default:
                return -1;
        }
    }

    public static int getPermissionValue(int i, String str) {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() == null) {
            return -1;
        }
        atomicReference.get().getPermissionValue(i, str);
        return -1;
    }

    public static int[] getPermissionValues(int i) {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            return atomicReference.get().getPermissionValues(i);
        }
        return null;
    }

    public static String getReqId(Map<String, Object> map) {
        if (YFListUtils.isMapEmpty(map)) {
            return "";
        }
        try {
            Object obj = map.get("request_id");
            if (obj != null) {
                return String.valueOf(obj);
            }
        } catch (Exception e) {
            f.a(e, new StringBuilder("getReqId "));
        }
        return "";
    }

    public static int getVideoType() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            return atomicReference.get().getVideoType();
        }
        return 0;
    }

    public static boolean hasImpSDK(int i) {
        return CHANNELS.containsKey(Integer.valueOf(i));
    }

    public static void impSdkAdapter(Context context, String str) {
        AdsInitBean adsInitBean;
        try {
            SdkConfModel sdkConfModel2 = sdkConfModel.get();
            if (sdkConfModel2 != null) {
                sdkConfModel2.covertSdkInit();
            }
            for (YFAdsConst.AdSource adSource : YFAdsConst.CLASS_VALUES_ADS) {
                if (sdkConfModel2 != null) {
                    adsInitBean = sdkConfModel2.adsInitBeans.get(Integer.valueOf(adSource.channel));
                    if (adsInitBean != null) {
                        adsInitBean.updData(adSource);
                    }
                } else {
                    adsInitBean = null;
                }
                ReflectionUtils.checkImpInit(context, adSource, CHANNELS, Util.getVersion(), adsInitBean, str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initCache() {
        try {
            YFLog.info("initCache start");
            clearCache();
            preLoader();
            YFLog.info("initCache end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initReport(SdkSupplier sdkSupplier, int i) {
        if (i >= YFAdsConst.ReportETypeValue.NEW_EVENT_TYPE.getValue()) {
            return;
        }
        boolean z = b.e;
        b.a.f9685a.a(sdkSupplier, i, "");
    }

    public static boolean isCrashUpd() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            return atomicReference.get().isCrashUpd();
        }
        return false;
    }

    public static boolean isEpsOpen() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        return atomicReference.get() != null && atomicReference.get().isEpsOpen();
    }

    public static boolean isEventOpen() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            return atomicReference.get().isEventOpen();
        }
        return false;
    }

    public static boolean isFactoryChannel(int i) {
        return i == 6 || i == 10 || i == 8 || i == 13 || i == 7;
    }

    public static boolean isInQueue(InitListener initListener, String str) {
        return isInQueue(TAG, initListener, str);
    }

    public static boolean isInitSuc(String str) {
        return isInitSuc(str, null);
    }

    private static boolean isMbsOpen() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        return atomicReference.get() != null && atomicReference.get().isMbsOpen();
    }

    public static boolean isPermissionForce(int[] iArr, int i) {
        return iArr != null && i >= 0 && i < iArr.length && iArr[i] >= 0;
    }

    public static boolean isPermissionOpen(int[] iArr, int i) {
        return iArr[i] == 1;
    }

    public static boolean isQueryAllPackage() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        return atomicReference.get() != null && atomicReference.get().isQueryAllPackage();
    }

    public static boolean isRTReport(int i) {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        return atomicReference.get() != null && atomicReference.get().isRTReport(i);
    }

    public static boolean isULFOpen() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        return atomicReference.get() != null && atomicReference.get().getULF() == 1;
    }

    public static boolean isUserGM() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        return atomicReference.get() != null && atomicReference.get().getUg() == 1;
    }

    public static void policyGrantResult(Context context) {
    }

    private static void printLog(YFAdsConst.ReportAdnIdValue reportAdnIdValue, int[] iArr, boolean z, int i, boolean z2, int i2, boolean z3, int i3, boolean z4, int i4, boolean z5, int i5, boolean z6, int i6, boolean z7, int i7, boolean z8, int i8, boolean z9, int i9) {
        String str;
        try {
            StringBuilder sbAppend = new StringBuilder("updateConfig service adnId:").append(reportAdnIdValue).append("|");
            if (iArr == null || iArr.length <= 0) {
                str = "empty";
            } else {
                str = "cwe:" + (z3 ? Boolean.valueOf(isPermissionOpen(iArr, i3)) : "no") + ",cua:" + (z4 ? Boolean.valueOf(isPermissionOpen(iArr, i4)) : "no") + ",cuaid:" + (z6 ? Boolean.valueOf(isPermissionOpen(iArr, i6)) : "no") + ",cul:" + (z2 ? Boolean.valueOf(isPermissionOpen(iArr, i2)) : "no") + ",cuo:" + (z5 ? Boolean.valueOf(isPermissionOpen(iArr, i5)) : "no") + ",cup:" + (z ? Boolean.valueOf(isPermissionOpen(iArr, i)) : "no") + ",cuw:" + (z7 ? Boolean.valueOf(isPermissionOpen(iArr, i7)) : "no") + ",car:" + (z8 ? Boolean.valueOf(isPermissionOpen(iArr, i8)) : "no") + ",lp:" + (z9 ? Boolean.valueOf(isPermissionOpen(iArr, i9)) : "no");
            }
            YFLog.debug(sbAppend.append(str).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printPCConfigLog() {
        AtomicReference<SdkConfModel> atomicReference = sdkConfModel;
        if (atomicReference.get() != null) {
            atomicReference.get().printPCLog();
        }
    }

    public static void queueFail(String str, String str2) {
        queueFail(TAG, str, str2);
    }

    public static void queueSuccess(String str) {
        queueSuccess(TAG, str);
    }

    public static void setConfModel(SdkConfModel sdkConfModel2) {
        sdkConfModel.set(sdkConfModel2);
    }

    private static void setPInoList(SdkConfModel sdkConfModel2) {
        YFLog.debug("setPInoList start");
        String pnl = sdkConfModel2.getPnl();
        if (TextUtils.isEmpty(pnl)) {
            YFLog.debug("setPInoList empty end");
            return;
        }
        String[] strArrSplit = pnl.split(",");
        if (strArrSplit.length > 0) {
            DeviceUtils.setPInoList(Arrays.asList(strArrSplit));
        }
        YFLog.debug("setPInoList end " + strArrSplit.length);
    }

    private static void updateInitSuc(String str) {
        List<String> list = LAST_ADS_LIST;
        if (list.contains(str)) {
            return;
        }
        list.add(str);
    }

    public static AdInfo getAdInfo(YFNativeAd yFNativeAd, String str) {
        String appName;
        if (yFNativeAd == null) {
            return null;
        }
        String adDescription = TextUtils.isEmpty(yFNativeAd.getAdTitle()) ? yFNativeAd.getAdDescription() : yFNativeAd.getAdTitle();
        if (TextUtils.isEmpty(yFNativeAd.getAppName())) {
            appName = TextUtils.isEmpty(yFNativeAd.getCorporationName()) ? "" : yFNativeAd.getCorporationName();
        } else {
            appName = yFNativeAd.getAppName();
        }
        return new AdInfo(adDescription, appName, str);
    }

    public static boolean isInQueue(String str, InitListener initListener, String str2) {
        if (initListener == null) {
            YFLog.error(str + "isInQueue initListener is not null");
        }
        Map<String, List<InitListener>> map = INIT_ADAPTER_LIST;
        List<InitListener> list = map.get(str2);
        if (list == null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            copyOnWriteArrayList.add(initListener);
            map.put(str2, copyOnWriteArrayList);
            return false;
        }
        if (list.size() <= 0) {
            list.add(initListener);
            map.put(str2, list);
            return false;
        }
        list.add(initListener);
        map.put(str2, list);
        YFLog.high(str + " isInQueue " + str2 + " size " + list.size());
        return true;
    }

    public static boolean isInitSuc(String str, InitListener initListener) {
        if (!LAST_ADS_LIST.contains(str)) {
            return false;
        }
        if (initListener == null) {
            return true;
        }
        initListener.success();
        return true;
    }

    public static boolean isShake() {
        if (shakeStatue == -1) {
            shakeStatue = YFConfigUtils.getBooleanValue(YFConfigUtils.ConfigType.EXT, "is_shake_action", true) ? 1 : 0;
        }
        return shakeStatue == 1;
    }

    private static void preLoader() {
        SdkConfModel sdkConfModelCovertModel = SdkConfModel.covertModel(YFAdsManager.getInstance().getContext().getSharedPreferences("adsConfig", 0).getString("sdkConf", ""));
        if (sdkConfModelCovertModel == null) {
            sdkConfModelCovertModel = new SdkConfModel();
        }
        YFLog.isDebug = sdkConfModelCovertModel.isLogOpen();
        setPInoList(sdkConfModelCovertModel);
        sdkConfModel.set(sdkConfModelCovertModel);
        String[] strArr = {Util.APP_SOURCE_KEY, Util.APP_HASH_KEY};
        SharedPreferences sharedPreferences = YFAdsManager.getInstance().getContext().getSharedPreferences("adsConfig", 0);
        String[] strArr2 = new String[2];
        for (int i = 0; i < 2; i++) {
            strArr2[i] = sharedPreferences.getString(strArr[i], "");
        }
        Util.setAppHash(strArr2[0], strArr2[1]);
    }

    public static void queueFail(String str, String str2, String str3) {
        List<InitListener> listRemove = INIT_ADAPTER_LIST.remove(str3);
        if (listRemove == null || listRemove.isEmpty()) {
            return;
        }
        YFLog.high(str + " queueFail callback " + str3 + " adapter = " + listRemove.size());
        Iterator<InitListener> it = listRemove.iterator();
        while (it.hasNext()) {
            it.next().fail(YFAdError.ERROR_INIT_FAILED, str2);
        }
    }

    public static void queueSuccess(String str, String str2) {
        List<InitListener> listRemove = INIT_ADAPTER_LIST.remove(str2);
        if (listRemove != null && !listRemove.isEmpty()) {
            YFLog.high(str + " queueSuccess callback " + str2 + " adapter = " + listRemove.size());
            Iterator<InitListener> it = listRemove.iterator();
            while (it.hasNext()) {
                it.next().success();
            }
        }
        updateInitSuc(str2);
    }

    public static boolean getPermissionValue(boolean[] zArr, String str, boolean z) {
        int permissionKey = getPermissionKey(str);
        return (permissionKey < 0 || permissionKey >= zArr.length) ? z : zArr[permissionKey];
    }

    public static boolean[] getPermissionValues(YFAdsConst.ReportAdnIdValue reportAdnIdValue, YFAdsConfig yFAdsConfig, boolean z) {
        int[] permissionValues = getPermissionValues(reportAdnIdValue.getValue());
        int permissionKey = getPermissionKey(YFAdsConst.CWE);
        boolean zIsPermissionForce = isPermissionForce(permissionValues, permissionKey);
        boolean zIsPermissionOpen = zIsPermissionForce ? isPermissionOpen(permissionValues, permissionKey) : yFAdsConfig.isCanUseWriteExternal();
        int permissionKey2 = getPermissionKey(YFAdsConst.CUA);
        boolean zIsPermissionForce2 = isPermissionForce(permissionValues, permissionKey2);
        boolean zIsPermissionOpen2 = zIsPermissionForce2 ? isPermissionOpen(permissionValues, permissionKey2) : yFAdsConfig.isCanUseAppList();
        int permissionKey3 = getPermissionKey(YFAdsConst.CUAID);
        boolean zIsPermissionForce3 = isPermissionForce(permissionValues, permissionKey3);
        boolean zIsPermissionOpen3 = zIsPermissionForce3 ? isPermissionOpen(permissionValues, permissionKey3) : yFAdsConfig.isCanUseAndroidId();
        int permissionKey4 = getPermissionKey(YFAdsConst.CUL);
        boolean zIsPermissionForce4 = isPermissionForce(permissionValues, permissionKey4);
        boolean zIsPermissionOpen4 = zIsPermissionForce4 ? isPermissionOpen(permissionValues, permissionKey4) : yFAdsConfig.isCanUseLocation();
        int permissionKey5 = getPermissionKey(YFAdsConst.CUO);
        boolean zIsPermissionForce5 = isPermissionForce(permissionValues, permissionKey5);
        boolean zIsPermissionOpen5 = zIsPermissionForce5 ? isPermissionOpen(permissionValues, permissionKey5) : yFAdsConfig.isCanUseOaid();
        int permissionKey6 = getPermissionKey(YFAdsConst.CUP);
        boolean zIsPermissionForce6 = isPermissionForce(permissionValues, permissionKey6);
        boolean zIsPermissionOpen6 = zIsPermissionForce6 ? isPermissionOpen(permissionValues, permissionKey6) : yFAdsConfig.isCanUsePhoneState();
        int permissionKey7 = getPermissionKey(YFAdsConst.CUW);
        boolean zIsPermissionForce7 = isPermissionForce(permissionValues, permissionKey7);
        boolean zIsPermissionOpen7 = zIsPermissionForce7 ? isPermissionOpen(permissionValues, permissionKey7) : yFAdsConfig.isCanUseWifiState();
        int permissionKey8 = getPermissionKey(YFAdsConst.CAR);
        boolean zIsPermissionForce8 = isPermissionForce(permissionValues, permissionKey8);
        boolean zIsPermissionOpen8 = zIsPermissionForce8 ? isPermissionOpen(permissionValues, permissionKey8) : yFAdsConfig.isCloseAppReceiver();
        boolean z2 = zIsPermissionOpen;
        int permissionKey9 = getPermissionKey(YFAdsConst.LP);
        boolean zIsPermissionForce9 = isPermissionForce(permissionValues, permissionKey9);
        boolean zIsPermissionOpen9 = zIsPermissionForce9 ? isPermissionOpen(permissionValues, permissionKey9) : yFAdsConfig.isLimitPersonal();
        if (z) {
            printLog(reportAdnIdValue, permissionValues, zIsPermissionForce6, permissionKey6, zIsPermissionForce4, permissionKey4, zIsPermissionForce, permissionKey, zIsPermissionForce2, permissionKey2, zIsPermissionForce5, permissionKey5, zIsPermissionForce3, permissionKey3, zIsPermissionForce7, permissionKey7, zIsPermissionForce8, permissionKey8, zIsPermissionForce9, permissionKey9);
        }
        return new boolean[]{z2, zIsPermissionOpen2, zIsPermissionOpen3, zIsPermissionOpen4, zIsPermissionOpen5, zIsPermissionOpen6, zIsPermissionOpen7, zIsPermissionOpen8, zIsPermissionOpen9};
    }

    public static boolean isInitSuc(String str, String str2, InitListener initListener) {
        if (!LAST_ADS_LIST.contains(str2)) {
            return false;
        }
        YFLog.high(str + " init has success");
        if (initListener == null) {
            return true;
        }
        initListener.success();
        return true;
    }

    public static void printLog(YFAdsConst.ReportAdnIdValue reportAdnIdValue, String[] strArr, boolean... zArr) {
        try {
            YFLog.debug("updateConfig init adnId:" + reportAdnIdValue + "|" + Arrays.toString(strArr) + x.bQ + Arrays.toString(zArr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printLog(int i, String str, boolean z) {
        try {
            YFLog.debug("updateConfig change adnId:" + i + "|" + str + x.bQ + z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean[] getPermissionValues(int i, YFAdsConfig yFAdsConfig) {
        int[] permissionValues = getPermissionValues(i);
        int permissionKey = getPermissionKey(YFAdsConst.CWE);
        boolean zIsPermissionOpen = isPermissionForce(permissionValues, permissionKey) ? isPermissionOpen(permissionValues, permissionKey) : yFAdsConfig.isCanUseWriteExternal();
        int permissionKey2 = getPermissionKey(YFAdsConst.CUA);
        boolean zIsPermissionOpen2 = isPermissionForce(permissionValues, permissionKey2) ? isPermissionOpen(permissionValues, permissionKey2) : yFAdsConfig.isCanUseAppList();
        int permissionKey3 = getPermissionKey(YFAdsConst.CUAID);
        boolean zIsPermissionOpen3 = isPermissionForce(permissionValues, permissionKey3) ? isPermissionOpen(permissionValues, permissionKey3) : yFAdsConfig.isCanUseAndroidId();
        int permissionKey4 = getPermissionKey(YFAdsConst.CUL);
        boolean zIsPermissionOpen4 = isPermissionForce(permissionValues, permissionKey4) ? isPermissionOpen(permissionValues, permissionKey4) : yFAdsConfig.isCanUseLocation();
        int permissionKey5 = getPermissionKey(YFAdsConst.CUO);
        boolean zIsPermissionOpen5 = isPermissionForce(permissionValues, permissionKey5) ? isPermissionOpen(permissionValues, permissionKey5) : yFAdsConfig.isCanUseOaid();
        int permissionKey6 = getPermissionKey(YFAdsConst.CUP);
        boolean zIsPermissionOpen6 = isPermissionForce(permissionValues, permissionKey6) ? isPermissionOpen(permissionValues, permissionKey6) : yFAdsConfig.isCanUsePhoneState();
        int permissionKey7 = getPermissionKey(YFAdsConst.CUW);
        boolean zIsPermissionOpen7 = isPermissionForce(permissionValues, permissionKey7) ? isPermissionOpen(permissionValues, permissionKey7) : yFAdsConfig.isCanUseWifiState();
        int permissionKey8 = getPermissionKey(YFAdsConst.CAR);
        boolean zIsPermissionOpen8 = isPermissionForce(permissionValues, permissionKey8) ? isPermissionOpen(permissionValues, permissionKey8) : yFAdsConfig.isCloseAppReceiver();
        int permissionKey9 = getPermissionKey(YFAdsConst.LP);
        return new boolean[]{zIsPermissionOpen, zIsPermissionOpen2, zIsPermissionOpen3, zIsPermissionOpen4, zIsPermissionOpen5, zIsPermissionOpen6, zIsPermissionOpen7, zIsPermissionOpen8, isPermissionForce(permissionValues, permissionKey9) ? isPermissionOpen(permissionValues, permissionKey9) : yFAdsConfig.isLimitPersonal()};
    }
}
