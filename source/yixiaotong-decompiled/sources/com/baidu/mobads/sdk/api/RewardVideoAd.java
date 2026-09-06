package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.az;
import com.baidu.mobads.sdk.internal.bv;
import com.baidu.mobads.sdk.internal.dj;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RewardVideoAd {
    public static final int DOWNLOAD_APP_CONFIRM_NEVER = 3;
    public static final int DOWNLOAD_APP_CONFIRM_ONLY_MOBILE = 1;
    private static final String TAG = "RewardVideoAd";
    private dj mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    public interface RewardVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdLoaded();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        void onRewardVerify(boolean z, Map<String, Object> map);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener) {
        this(context, str, rewardVideoAdListener, false);
    }

    public RewardVideoAd(Context context, String str, RewardVideoAdListener rewardVideoAdListener, boolean z) {
        this.mContext = context;
        dj djVar = new dj(context, str, z);
        this.mAdProd = djVar;
        djVar.a(rewardVideoAdListener);
        if (TextUtils.isEmpty(str)) {
            az.c().e("RewardVideoAd初始化异常：广告位为空");
        }
    }

    @Deprecated
    public void setDownloadAppConfirmPolicy(int i) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(i);
        }
    }

    public void setUserId(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(str);
        }
    }

    public void setExtraInfo(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.j(str);
        }
    }

    public void setRequestParameters(RequestParameters requestParameters) {
        dj djVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (djVar = this.mAdProd) == null) {
            return;
        }
        djVar.a(requestParameters);
    }

    public synchronized void load() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a();
        }
    }

    public String getBiddingToken() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            return djVar.l();
        }
        return null;
    }

    public void loadBiddingAd(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.c(str);
        }
    }

    @Deprecated
    public void setBiddingData(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.b(str);
        }
    }

    public void setRewardInfo(RewardVideoRewardInfo rewardVideoRewardInfo) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(rewardVideoRewardInfo);
        }
    }

    public synchronized void show() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.e();
        }
    }

    public synchronized void show(Context context) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(context);
        }
    }

    public boolean isReady() {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            return djVar.f();
        }
        return false;
    }

    public void setAppSid(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.h(str);
        }
    }

    public void setShowDialogOnSkip(boolean z) {
        if (this.mAdProd != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("showDialogOnSkip", z);
                this.mAdProd.a(jSONObject);
            } catch (Throwable th) {
                bv.a().c(th);
            }
        }
    }

    public Object getAdDataForKey(String str) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            return djVar.k(str);
        }
        return null;
    }

    public String getECPMLevel() {
        dj djVar = this.mAdProd;
        return djVar != null ? djVar.g() : "";
    }

    public String getPECPM() {
        dj djVar = this.mAdProd;
        return djVar != null ? djVar.x() : "";
    }

    public void setBidFloor(int i) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.r = i;
        }
    }

    public void biddingSuccess(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(true, linkedHashMap, biddingListener);
        }
    }

    public void biddingFail(LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        dj djVar = this.mAdProd;
        if (djVar != null) {
            djVar.a(false, linkedHashMap, biddingListener);
        }
    }
}
