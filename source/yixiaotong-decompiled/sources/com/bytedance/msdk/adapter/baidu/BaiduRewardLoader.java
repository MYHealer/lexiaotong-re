package com.bytedance.msdk.adapter.baidu;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.RewardVideoRewardInfo;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.JProtect;
import com.bytedance.msdk.adapter.baidu.base.config.MediationAdSlotValueSet;
import com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterValueSetBuilder;
import com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationApiLog;
import com.bytedance.msdk.adapter.baidu.base.utils.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
public class BaiduRewardLoader extends BaiduBaseLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MediationAdSlotValueSet f3031a;
    private Function<SparseArray<Object>, Object> b;
    private RewardVideoRewardInfo c;

    class BaiduRewardVideoAd extends MediationBaseAdBridge implements RewardVideoAd.RewardVideoAdListener {
        private RewardVideoAd b;

        BaiduRewardVideoAd() {
            super(BaiduRewardLoader.this.f3031a, BaiduRewardLoader.this.b);
        }

        private String a() {
            try {
                RewardVideoAd rewardVideoAd = this.b;
                if (rewardVideoAd != null) {
                    return (String) rewardVideoAd.getAdDataForKey("request_id");
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        @JProtect
        void a(Context context) {
            RewardVideoAd rewardVideoAd = new RewardVideoAd(context, BaiduRewardLoader.this.getAdnId(), this, BaiduRewardLoader.this.f3031a.isUseSurfaceView());
            this.b = rewardVideoAd;
            rewardVideoAd.setShowDialogOnSkip(BaiduRewardLoader.this.f3031a.getBaiduShowDialogOnSkip());
            RequestParameters requestParametersBuild = new RequestParameters.Builder().build();
            BaiduRewardLoader baiduRewardLoader = BaiduRewardLoader.this;
            baiduRewardLoader.setBiddingResult(baiduRewardLoader.getAdnId(), BaiduRewardLoader.this.isClientBidding(), requestParametersBuild);
            this.b.setRequestParameters(requestParametersBuild);
            String baiduAppSid = BaiduRewardLoader.this.f3031a.getBaiduAppSid();
            if (!TextUtils.isEmpty(baiduAppSid)) {
                this.b.setAppSid(baiduAppSid);
            }
            String userId = BaiduRewardLoader.this.f3031a.getUserId();
            if (userId != null) {
                this.b.setUserId(userId);
            }
            Map<String, Object> extraObject = BaiduRewardLoader.this.f3031a.getExtraObject();
            if (extraObject != null && extraObject.get("baidu") != null) {
                this.b.setExtraInfo(String.valueOf(extraObject.get("baidu")));
            }
            if (extraObject != null && extraObject.get("baidu_reward_info") != null && (extraObject.get("baidu_reward_info") instanceof JSONObject)) {
                JSONObject jSONObject = (JSONObject) extraObject.get("baidu_reward_info");
                try {
                    BaiduRewardLoader.this.c = RewardVideoRewardInfo.builder().setRewardType(jSONObject.getInt("reward_type")).setBasicReward(jSONObject.getString("basic_reward")).setBasicUnit(jSONObject.getString("basic_unit")).setAdvancedReward(jSONObject.getString("advanced_reward")).setAdvancedUnit(jSONObject.getString("advanced_unit")).setMultiple(jSONObject.getString("multiple")).create();
                } catch (JSONException unused) {
                }
            }
            this.b.load();
        }

        /* JADX WARN: Type inference failed for: r2v7, types: [T, java.util.HashMap, java.util.Map] */
        @Override // com.bytedance.msdk.adapter.baidu.base.proto.AdnAdapterBaseFunction
        public <T> T applyFunction(int i, SparseArray<Object> sparseArray, Class<T> cls) {
            RewardVideoAd rewardVideoAd;
            if (i == 8113) {
                Activity activity = (Activity) MediationValueUtil.objectValue(sparseArray.get(20033), Activity.class, null);
                if (activity != null) {
                    showAd(activity);
                }
            } else if (i == 8109) {
                onDestroy();
            } else {
                if (i == 8120) {
                    return (T) Boolean.valueOf(hasDestroyed());
                }
                if (i == 8121) {
                    return (T) isReadyStatusForProto2(isReadyStatus(), sparseArray, cls);
                }
                if (i == 8147) {
                    return (T) a();
                }
                if (i == 8142) {
                    if (BaiduAdapterUtil.hasMethodBiddingSuccess(this.b)) {
                        Map<? extends String, ? extends Object> map = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------baidu_bid_win --------- map = " + map);
                        if (map != null) {
                            LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
                            linkedHashMap.putAll(map);
                            RewardVideoAd rewardVideoAd2 = this.b;
                            if (rewardVideoAd2 != null) {
                                rewardVideoAd2.biddingSuccess(linkedHashMap, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduRewardLoader.BaiduRewardVideoAd.1
                                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                                    public void onBiddingResult(boolean z, String str, HashMap<String, Object> map2) {
                                        MediationApiLog.i("baidu-onBiddingResult-win: " + z + "msg: " + str);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 8144) {
                    if (BaiduAdapterUtil.hasMethodBiddingFail(this.b)) {
                        Map<? extends String, ? extends Object> map2 = (Map) MediationValueUtil.objectValue(sparseArray.get(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p), Map.class, null);
                        MediationApiLog.i("-------baidu_bid_lose --------- map = " + map2);
                        if (map2 != null) {
                            LinkedHashMap<String, Object> linkedHashMap2 = new LinkedHashMap<>();
                            linkedHashMap2.putAll(map2);
                            RewardVideoAd rewardVideoAd3 = this.b;
                            if (rewardVideoAd3 != null) {
                                rewardVideoAd3.biddingFail(linkedHashMap2, new BiddingListener() { // from class: com.bytedance.msdk.adapter.baidu.BaiduRewardLoader.BaiduRewardVideoAd.2
                                    @Override // com.baidu.mobads.sdk.api.BiddingListener
                                    public void onBiddingResult(boolean z, String str, HashMap<String, Object> map3) {
                                        MediationApiLog.i("baidu-onBiddingResult-loss: " + z + "msg: " + str);
                                    }
                                });
                            }
                        }
                    }
                } else if (i == 8239 && (rewardVideoAd = this.b) != null) {
                    try {
                        Object adDataForKey = rewardVideoAd.getAdDataForKey("act_url");
                        Object adDataForKey2 = this.b.getAdDataForKey(OapsKey.KEY_PAGEKEY);
                        ?? r2 = (T) new HashMap();
                        r2.put("act_url", adDataForKey);
                        r2.put(OapsKey.KEY_PAGEKEY, adDataForKey2);
                        return r2;
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
            return (T) MediationValueUtil.checkClassType(cls);
        }

        @Override // com.bykv.vk.openvk.api.proto.Caller
        public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
            return (T) applyFunction(i, AdnAdapterValueSetBuilder.converToSparseArray(valueSet), cls);
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public boolean hasDestroyed() {
            return this.b == null;
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public Integer isReadyStatus() {
            RewardVideoAd rewardVideoAd = this.b;
            return Integer.valueOf((rewardVideoAd == null || !rewardVideoAd.isReady()) ? 3 : 2);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClick() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 8115);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdClose(float f) {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 8116);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdFailed(String str) {
            BaiduRewardLoader.this.notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, str);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdLoaded() {
            MediationApiLog.i("-------baidu_onAdLoaded:" + this.b + "  isClientBidding:" + BaiduRewardLoader.this.isClientBidding());
            if (this.b != null) {
                if (BaiduRewardLoader.this.isClientBidding()) {
                    double dDoubleValue = 0.0d;
                    try {
                        MediationApiLog.i("-------baidu_ getECPMLevel:" + this.b.getECPMLevel());
                        if (!TextUtils.isEmpty(this.b.getECPMLevel())) {
                            dDoubleValue = Double.valueOf(this.b.getECPMLevel()).doubleValue();
                        }
                    } catch (Exception e) {
                        MediationApiLog.i("-------baidu_ getECPMLevel e:" + e.toString());
                        e.printStackTrace();
                    }
                    setCpm(dDoubleValue);
                } else if (BaiduRewardLoader.this.isMultiBidding()) {
                    setLevelTag(this.b.getECPMLevel());
                }
            }
            BaiduRewardLoader.this.notifyAdSuccess(this, this.mGMAd);
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdShow() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 8230);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onAdSkip(float f) {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 8119);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.bytedance.msdk.adapter.baidu.base.proto.MediationBaseAdBridge
        public void onDestroy() {
            this.b = null;
        }

        @JProtect
        public void onRewardVerify(boolean z) {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 8231);
                sparseArray.put(-99999985, Void.class);
                sparseArray.put(8017, true);
                sparseArray.put(8018, Integer.valueOf(BaiduRewardLoader.this.f3031a.getRewardAmount()));
                sparseArray.put(8019, BaiduRewardLoader.this.f3031a.getRewardName());
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener
        @JProtect
        public void onRewardVerify(boolean z, Map<String, Object> map) {
            if (this.mGMAd != null) {
                MediationApiLog.i("-------baidu_onreward_verify --------- map = " + map);
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 8231);
                sparseArray.put(-99999985, Void.class);
                sparseArray.put(8017, true);
                sparseArray.put(8018, Integer.valueOf(BaiduRewardLoader.this.f3031a.getRewardAmount()));
                sparseArray.put(8019, BaiduRewardLoader.this.f3031a.getRewardName());
                sparseArray.put(8020, map);
                this.mGMAd.apply(sparseArray);
            }
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        public void onVideoDownloadFailed() {
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void onVideoDownloadSuccess() {
            BaiduRewardLoader.this.notifyAdCache(this.mGMAd, -1, "");
        }

        @Override // com.baidu.mobads.sdk.api.RewardVideoAd.RewardVideoAdListener, com.baidu.mobads.sdk.api.ScreenVideoAdListener
        @JProtect
        public void playCompletion() {
            if (this.mGMAd != null) {
                SparseArray<Object> sparseArray = new SparseArray<>();
                sparseArray.put(-99999987, 8118);
                sparseArray.put(-99999985, Void.class);
                this.mGMAd.apply(sparseArray);
            }
        }

        @JProtect
        public void showAd(Activity activity) {
            if (this.b != null) {
                if (BaiduRewardLoader.this.c != null) {
                    this.b.setRewardInfo(BaiduRewardLoader.this.c);
                }
                this.b.show();
            }
        }

        @Override // com.bykv.vk.openvk.api.proto.Bridge
        public ValueSet values() {
            return null;
        }
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction
    public void realLoader(Context context, MediationAdSlotValueSet mediationAdSlotValueSet) {
        if (context == null || mediationAdSlotValueSet == null) {
            notifyAdFailed(MediationConstant.ErrorCode.ADN_AD_LOAD_FAIL, "context is null or adSlotValueSet is null");
            return;
        }
        this.f3031a = mediationAdSlotValueSet;
        this.b = getGMBridge();
        new BaiduRewardVideoAd().a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
    }

    @Override // com.bytedance.msdk.adapter.baidu.base.MediationAdLoaderBaseFunction, com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return null;
    }
}
