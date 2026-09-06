package com.baidu.mobads.sdk.api;

import android.content.Context;
import com.baidu.mobads.sdk.internal.dh;
import com.baidu.mobads.sdk.internal.dj;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FullScreenVideoAd {
    private static final String TAG = "FullScreenVideoAd";
    private dj mAdProd;
    private final Context mContext;
    private RequestParameters mRequestParameters;

    public interface FullScreenVideoAdListener extends ScreenVideoAdListener {
        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClick();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdClose(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdFailed(String str);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdShow();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onAdSkip(float f);

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadFailed();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void onVideoDownloadSuccess();

        @Override // com.baidu.mobads.sdk.api.ScreenVideoAdListener
        void playCompletion();
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener) {
        this(context, str, fullScreenVideoAdListener, false);
    }

    public FullScreenVideoAd(Context context, String str, FullScreenVideoAdListener fullScreenVideoAdListener, boolean z) {
        this.mContext = context;
        dh dhVar = new dh(context, str, z);
        this.mAdProd = dhVar;
        dhVar.a(fullScreenVideoAdListener);
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

    public void setRequestParameters(RequestParameters requestParameters) {
        dj djVar;
        this.mRequestParameters = requestParameters;
        if (requestParameters == null || (djVar = this.mAdProd) == null) {
            return;
        }
        djVar.a(requestParameters);
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
