package com.bytedance.msdk.adapter.ks.base.config;

import android.util.SparseArray;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.msdk.adapter.ks.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.ks.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.ks.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class MediationAdSlotValueSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SparseArray<Object> f3082a;
    private SparseArray<Object> b;
    private SparseArray<Object> c;
    private int d;
    private String e;

    /* JADX WARN: Code duplicated, block: B:12:0x0046 A[PHI: r4
  0x0046: PHI (r4v8 android.util.SparseArray<java.lang.Object>) = (r4v7 android.util.SparseArray<java.lang.Object>), (r4v14 android.util.SparseArray<java.lang.Object>) binds: [B:11:0x0044, B:8:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    private MediationAdSlotValueSet(SparseArray<Object> sparseArray) {
        SparseArray<Object> sparseArrayConverToSparseArray;
        if (sparseArray == null) {
            return;
        }
        this.f3082a = sparseArray;
        SparseArray<Object> sparseArrayConverToSparseArray2 = AdnAdapterValueSetBuilder.converToSparseArray(MediationValueUtil.objectValue(sparseArray.get(8090), Object.class, null));
        if (sparseArrayConverToSparseArray2 != null) {
            sparseArrayConverToSparseArray = AdnAdapterValueSetBuilder.converToSparseArray(MediationValueUtil.objectValue(sparseArrayConverToSparseArray2.get(8089), Object.class, null));
            this.b = sparseArrayConverToSparseArray;
            if (sparseArrayConverToSparseArray != null) {
                this.c = AdnAdapterValueSetBuilder.converToSparseArray(MediationValueUtil.objectValue(sparseArrayConverToSparseArray.get(8443), Object.class, null));
            }
        } else {
            sparseArrayConverToSparseArray = AdnAdapterValueSetBuilder.converToSparseArray(MediationValueUtil.objectValue(this.f3082a.get(8089), Object.class, null));
            this.b = sparseArrayConverToSparseArray;
            if (sparseArrayConverToSparseArray != null) {
                this.c = AdnAdapterValueSetBuilder.converToSparseArray(MediationValueUtil.objectValue(sparseArrayConverToSparseArray.get(8443), Object.class, null));
            }
        }
        a();
    }

    private void a() {
        MediationApiLog.i("---------  sdk MediationAdSlotValueSet start ----");
        MediationApiLog.i("getAdLoaderCallback：" + getAdLoaderCallback());
        MediationApiLog.i("getADNId：" + getADNId());
        MediationApiLog.i("getRitId：" + getRitId());
        MediationApiLog.i("getUserId：" + getUserId());
        MediationApiLog.i("getAdCount：" + getAdCount());
        MediationApiLog.i("getWidth：" + getWidth());
        MediationApiLog.i("getHeight：" + getHeight());
        MediationApiLog.i("getExpressWidth：" + getExpressWidth());
        MediationApiLog.i("getExpressHeight：" + getExpressHeight());
        MediationApiLog.i("isMuted：" + isMuted());
        MediationApiLog.i("isSplashShakeButton：" + isSplashShakeButton());
        MediationApiLog.i("isSplashPreLoad：" + isSplashPreLoad());
        MediationApiLog.i("getVolume：" + getVolume());
        MediationApiLog.i("isUseSurfaceView：" + isUseSurfaceView());
        MediationApiLog.i("getExtraObject：" + getExtraObject());
        MediationApiLog.i("isBidNotify：" + isBidNotify());
        MediationApiLog.i("getScenarioId：" + getScenarioId());
        MediationApiLog.i("getRewardName：" + getRewardName());
        MediationApiLog.i("getRewardAmount：" + getRewardAmount());
        MediationApiLog.i("isAllowShowCloseBtn：" + isAllowShowCloseBtn());
        MediationApiLog.i("isExpress：" + isExpress());
        MediationApiLog.i("getOrientation：" + getOrientation());
        MediationApiLog.i("getContentUrl：" + getContentUrl());
        MediationApiLog.i("getDevices：" + getDevices());
        MediationApiLog.i("getOriginType：" + getOriginType());
        MediationApiLog.i("getAdSubType：" + getAdSubType());
        MediationApiLog.i("getBaiduAppSid：" + getBaiduAppSid());
        MediationApiLog.i("getBaiduDownloadAppConfirmPolicy：" + getBaiduDownloadAppConfirmPolicy());
        MediationApiLog.i("getBaiduUseRewardCountdown：" + getBaiduUseRewardCountdown());
        MediationApiLog.i("getBaiduShowDialogOnSkip：" + getBaiduShowDialogOnSkip());
        MediationApiLog.i("getBaiduCacheVideoOnlyWifi：" + getBaiduCacheVideoOnlyWifi());
        MediationApiLog.i("getBaiduRequestParameters：" + getBaiduRequestParameters());
        MediationApiLog.i("getBaiduNativeSmartOptStyleParams：" + getBaiduNativeSmartOptStyleParams());
        MediationApiLog.i("getGdtMinVideoDuration：" + getGdtMinVideoDuration());
        MediationApiLog.i("getGdtMaxVideoDuration：" + getGdtMaxVideoDuration());
        MediationApiLog.i("getGdtVideoOption：" + getGdtVideoOption());
        MediationApiLog.i("getGdtDownAPPConfirmPolicy：" + getGdtDownAPPConfirmPolicy());
        MediationApiLog.i("getGdtNativeLogoParams：" + getGdtNativeLogoParams());
        MediationApiLog.i("getAdLoadTimeOut：" + getAdLoadTimeOut());
        MediationApiLog.i("getShakeViewWidth：" + getShakeViewWidth());
        MediationApiLog.i("getShakeViewHeight：" + getShakeViewHeight());
        MediationApiLog.i("getAdloadSeq：" + getAdloadSeq());
        MediationApiLog.i("getAdUnitId：" + getAdUnitId());
        MediationApiLog.i("isSupportDeepLink：" + isSupportDeepLink());
        MediationApiLog.i("getParams：" + getParams());
        MediationApiLog.i("---------  初始化adn sdk MediationAdSlotValueSet end ----");
    }

    private boolean b() {
        SparseArray<Object> sparseArray = this.f3082a;
        return sparseArray != null && sparseArray.size() > 0;
    }

    public static MediationAdSlotValueSet create(SparseArray<Object> sparseArray) {
        return new MediationAdSlotValueSet(sparseArray);
    }

    public String getADNId() {
        if (b()) {
            return (String) MediationValueUtil.objectValue(this.f3082a.get(AVMDLDataLoader.KeyIsLiveCacheThresholdP2pToHttp), String.class, null);
        }
        return null;
    }

    public int getAdCount() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Integer) MediationValueUtil.objectValue(sparseArray.get(13), Integer.class, 0)).intValue();
        }
        return 1;
    }

    public int getAdLoadTimeOut() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Integer) MediationValueUtil.objectValue(sparseArray.get(17), Integer.class, 3000)).intValue();
        }
        return 3000;
    }

    public Object getAdLoaderCallback() {
        if (b()) {
            return MediationValueUtil.objectValue(this.f3082a.get(AVMDLDataLoader.KeyIsLiveMobileDownloadAllow), Object.class, null);
        }
        return null;
    }

    public int getAdSubType() {
        if (b()) {
            return ((Integer) MediationValueUtil.objectValue(this.f3082a.get(8094), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public String getAdUnitId() {
        return this.e;
    }

    public int getAdloadSeq() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        if (b()) {
            return ((Integer) MediationValueUtil.objectValue(this.f3082a.get(20), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public String getBaiduAppSid() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return "";
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_APPSID);
        return obj instanceof String ? (String) obj : "";
    }

    public boolean getBaiduCacheVideoOnlyWifi() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return false;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_CACHE_VIDEO_ONLY_WIFI);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public int getBaiduDownloadAppConfirmPolicy() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return 0;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_DOWN_APP_CONFIG_POLICY);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public Object getBaiduNativeSmartOptStyleParams() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_BAIDU_NATIVE_SMART_OPT_STYLE_PARAMS);
        }
        return null;
    }

    public Object getBaiduRequestParameters() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_BAIDU_REQUEST_PARAMETERS);
        }
        return null;
    }

    public boolean getBaiduShowDialogOnSkip() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return false;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_SHOW_DIALOG_ON_SKIP);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public boolean getBaiduUseRewardCountdown() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return false;
        }
        Object obj = extraObject.get(MediationConstant.KEY_BAIDU_USE_REWARD_COUNTDOWN);
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return false;
    }

    public String getClientReqId() {
        return b() ? (String) MediationValueUtil.objectValue(this.f3082a.get(8430), String.class, null) : "";
    }

    public String getContentUrl() {
        return b() ? (String) MediationValueUtil.objectValue(this.f3082a.get(8083), String.class, null) : "";
    }

    public String getDevices() {
        return b() ? (String) MediationValueUtil.objectValue(this.f3082a.get(8084), String.class, null) : "";
    }

    public float getExpressHeight() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Float) MediationValueUtil.objectValue(sparseArray.get(9), Float.class, Float.valueOf(0.0f))).floatValue();
        }
        return 0.0f;
    }

    public float getExpressWidth() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Float) MediationValueUtil.objectValue(sparseArray.get(10), Float.class, Float.valueOf(0.0f))).floatValue();
        }
        return 0.0f;
    }

    public Map<String, Object> getExtraObject() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return (Map) MediationValueUtil.objectValue(sparseArray.get(8449), Map.class, null);
        }
        return null;
    }

    public Object getGdtDownAPPConfirmPolicy() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_DOWN_APP_CONFIG_POLICY);
        }
        return null;
    }

    public int getGdtMaxVideoDuration() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return 0;
        }
        Object obj = extraObject.get(MediationConstant.KEY_GDT_MAX_VIDEO_DURATION);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public int getGdtMinVideoDuration() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject == null) {
            return 0;
        }
        Object obj = extraObject.get(MediationConstant.KEY_GDT_MIN_VIDEO_DURATION);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public Object getGdtNativeLogoParams() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_NATIVE_LOGO_PARAMS);
        }
        return null;
    }

    public Object getGdtVideoOption() {
        Map<String, Object> extraObject = getExtraObject();
        if (extraObject != null) {
            return extraObject.get(MediationConstant.KEY_GDT_VIDEO_OPTION);
        }
        return null;
    }

    public int getHeight() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Integer) MediationValueUtil.objectValue(sparseArray.get(8), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public int getOrientation() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Integer) MediationValueUtil.objectValue(sparseArray.get(16), Integer.class, 0)).intValue();
        }
        return 2;
    }

    public int getOriginType() {
        if (b()) {
            return ((Integer) MediationValueUtil.objectValue(this.f3082a.get(8085), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public Map<String, Object> getParams() {
        return b() ? (Map) MediationValueUtil.objectValue(this.f3082a.get(8044), Map.class, null) : new HashMap();
    }

    public int getRenderControl() {
        if (b()) {
            return ((Integer) MediationValueUtil.objectValue(this.f3082a.get(8553), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public int getRewardAmount() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Integer) MediationValueUtil.objectValue(sparseArray.get(8453), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public String getRewardName() {
        SparseArray<Object> sparseArray = this.c;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8452), String.class, null) : "";
    }

    public String getRitId() {
        if (b()) {
            return (String) MediationValueUtil.objectValue(this.f3082a.get(4), String.class, null);
        }
        return null;
    }

    public String getScenarioId() {
        SparseArray<Object> sparseArray = this.c;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(8451), String.class, null) : "";
    }

    public float getShakeViewHeight() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Float) MediationValueUtil.objectValue(sparseArray.get(8456), Float.class, Float.valueOf(0.0f))).floatValue();
        }
        return 0.0f;
    }

    public float getShakeViewWidth() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Float) MediationValueUtil.objectValue(sparseArray.get(8455), Float.class, Float.valueOf(0.0f))).floatValue();
        }
        return 0.0f;
    }

    public String getUserId() {
        SparseArray<Object> sparseArray = this.b;
        return sparseArray != null ? (String) MediationValueUtil.objectValue(sparseArray.get(15), String.class, null) : "";
    }

    public float getVolume() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Float) MediationValueUtil.objectValue(sparseArray.get(8447), Float.class, Float.valueOf(0.0f))).floatValue();
        }
        return 1.0f;
    }

    public String getWaterfallABTest() {
        return b() ? (String) MediationValueUtil.objectValue(this.f3082a.get(8429), String.class, null) : "";
    }

    public int getWidth() {
        SparseArray<Object> sparseArray = this.b;
        if (sparseArray != null) {
            return ((Integer) MediationValueUtil.objectValue(sparseArray.get(7), Integer.class, 0)).intValue();
        }
        return 0;
    }

    public boolean isAllowShowCloseBtn() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8454), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isBidNotify() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8450), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isExpress() {
        return b() && ((Boolean) MediationValueUtil.objectValue(this.f3082a.get(8033), Boolean.class, false)).booleanValue();
    }

    public boolean isMuted() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8444), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isSplashPreLoad() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8446), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isSplashShakeButton() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8445), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isSupportDeepLink() {
        if (b()) {
            return ((Boolean) MediationValueUtil.objectValue(this.f3082a.get(11), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public boolean isUseSurfaceView() {
        SparseArray<Object> sparseArray = this.c;
        if (sparseArray != null) {
            return ((Boolean) MediationValueUtil.objectValue(sparseArray.get(8448), Boolean.class, false)).booleanValue();
        }
        return false;
    }

    public void setAdUnitId(String str) {
        this.e = str;
    }

    public void setAdloadSeq(int i) {
        this.d = i;
    }
}
