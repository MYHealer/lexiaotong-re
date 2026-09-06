package com.baidu.mobads.sdk.api;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ad;
import com.baidu.mobads.sdk.internal.ak;
import com.baidu.mobads.sdk.internal.dg;
import com.baidu.mobads.sdk.internal.g;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BaiduNativeManager {
    private static final int FEED_TIMEOUT = 8000;
    private static final String TAG = "BaiduNativeManager";
    private boolean isCacheVideo;
    private boolean isCacheVideoOnlyWifi;
    private final String mAdPlacementId;
    private boolean mAdReward;
    private String mAppSid;
    private int mBidFloor;
    private final Context mContext;
    private RequestParameters mRequestParameters;
    private boolean mRewardOnDownloaded;
    private int mTimeoutMillis;

    public interface EntryAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str);

        void onNativeLoad(List<EntryResponse> list);

        void onNoAd(int i, String str);
    }

    public interface ExpressAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str, ExpressResponse expressResponse);

        void onNativeLoad(List<ExpressResponse> list);

        void onNoAd(int i, String str, ExpressResponse expressResponse);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    public interface FeedAdListener {
        void onLpClosed();

        void onNativeFail(int i, String str, NativeResponse nativeResponse);

        void onNativeLoad(List<NativeResponse> list);

        void onNoAd(int i, String str, NativeResponse nativeResponse);

        void onVideoDownloadFailed();

        void onVideoDownloadSuccess();
    }

    @Deprecated
    public interface PortraitVideoAdListener extends FeedAdListener {
        void onAdClick();
    }

    public void setAdReward(boolean z) {
        this.mAdReward = z;
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBidFloor(int i) {
        this.mBidFloor = i;
    }

    public void setCacheVideoOnlyWifi(boolean z) {
        this.isCacheVideoOnlyWifi = z;
    }

    public void setRewardOnDownloaded(boolean z) {
        this.mRewardOnDownloaded = z;
    }

    public BaiduNativeManager(Context context, String str) {
        this(context, str, 8000);
    }

    public BaiduNativeManager(Context context, String str, int i) {
        this(context, str, true, i);
    }

    public BaiduNativeManager(Context context, String str, boolean z) {
        this(context, str, z, 8000);
    }

    public BaiduNativeManager(Context context, String str, boolean z, int i) {
        this.isCacheVideoOnlyWifi = false;
        this.mBidFloor = -1;
        this.mAdReward = false;
        this.mRewardOnDownloaded = false;
        this.mContext = context;
        this.mAdPlacementId = str;
        this.isCacheVideo = z;
        this.mTimeoutMillis = i;
    }

    public void loadFeedAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(this.mRewardOnDownloaded);
        gVar.b(requestParameters);
    }

    public void loadContentAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, new ad(feedAdListener), new dg(this.mContext, getAdPlacemenId(requestParameters), "content", this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(this.mRewardOnDownloaded);
        gVar.b(requestParameters);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, PortraitVideoAdListener portraitVideoAdListener) {
        loadPortraitVideoAd(requestParameters, (FeedAdListener) portraitVideoAdListener);
    }

    public void loadPortraitVideoAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, new ad(feedAdListener), new dg(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(this.mRewardOnDownloaded);
        gVar.b(requestParameters);
    }

    public void loadFeedEntryAd(RequestParameters requestParameters, EntryAdListener entryAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), entryAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.b(requestParameters);
    }

    public void loadInsiteAd(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, new ad(feedAdListener), new dg(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_INSITE, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(this.mRewardOnDownloaded);
        gVar.b(requestParameters);
    }

    public void loadPrerollVideo(RequestParameters requestParameters, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, 8000, IAdInterListener.AdProdType.PRODUCT_PREROLL);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.b(this.mRewardOnDownloaded);
        gVar.b(requestParameters);
    }

    public void loadExpressAd(RequestParameters requestParameters, ExpressAdListener expressAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(requestParameters);
    }

    public String getFeedBiddingToken(RequestParameters requestParameters) {
        dg dgVar = new dg(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters requestParametersBuild = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dgVar.h(this.mAppSid);
        }
        dgVar.r = getBidFloor(requestParameters);
        dgVar.c(this.mAdReward);
        dgVar.d(this.mRewardOnDownloaded);
        dgVar.a(requestParametersBuild);
        this.mRequestParameters = requestParametersBuild;
        return dgVar.l();
    }

    public String getExpressFeedBiddingToken(RequestParameters requestParameters) {
        dg dgVar = new dg(this.mContext, getAdPlacemenId(requestParameters), "feed", this.isCacheVideo, this.mTimeoutMillis);
        dgVar.a(1);
        RequestParameters requestParametersBuild = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dgVar.h(this.mAppSid);
        }
        dgVar.r = getBidFloor(requestParameters);
        dgVar.d(this.mRewardOnDownloaded);
        dgVar.c(this.mAdReward);
        dgVar.a(requestParametersBuild);
        this.mRequestParameters = requestParametersBuild;
        return dgVar.l();
    }

    public void loadBidAdForFeed(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, feedAdListener, null);
    }

    public void loadBidAdForExpress(String str, ExpressAdListener expressAdListener) {
        loadBiddingAd(this.mRequestParameters, "feed", str, null, expressAdListener);
    }

    @Deprecated
    public void setFeedBiddingData(RequestParameters requestParameters, String str, FeedAdListener feedAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), new ad(feedAdListener), this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(this.mRewardOnDownloaded);
        gVar.a(requestParameters);
        gVar.a(str);
    }

    @Deprecated
    public void setExpressFeedBiddingData(RequestParameters requestParameters, String str, ExpressAdListener expressAdListener) {
        g gVar = new g(this.mContext, getAdPlacemenId(requestParameters), expressAdListener, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(this.mRewardOnDownloaded);
        gVar.a(requestParameters);
        gVar.a(str);
    }

    public String getPortraitVideoBiddingToken(RequestParameters requestParameters) {
        dg dgVar = new dg(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis);
        RequestParameters requestParametersBuild = requestParameters == null ? new RequestParameters.Builder().build() : requestParameters;
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dgVar.h(this.mAppSid);
        }
        dgVar.r = getBidFloor(requestParameters);
        dgVar.d(this.mRewardOnDownloaded);
        dgVar.c(this.mAdReward);
        dgVar.a(requestParametersBuild);
        this.mRequestParameters = requestParametersBuild;
        return dgVar.l();
    }

    @Deprecated
    public void loadBidAdForPortraitVideo(String str, PortraitVideoAdListener portraitVideoAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, portraitVideoAdListener, null);
    }

    public void loadBidAdForPortraitVideo(String str, FeedAdListener feedAdListener) {
        loadBiddingAd(this.mRequestParameters, IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, str, feedAdListener, null);
    }

    @Deprecated
    public void setPortraitVideoBiddingData(RequestParameters requestParameters, String str, PortraitVideoAdListener portraitVideoAdListener) {
        g gVar = new g(this.mContext, new ad(portraitVideoAdListener), new dg(this.mContext, getAdPlacemenId(requestParameters), IAdInterListener.AdProdType.PRODUCT_PORTRAITVIDEO, this.isCacheVideo, this.mTimeoutMillis));
        if (!TextUtils.isEmpty(this.mAppSid)) {
            gVar.b(this.mAppSid);
        }
        gVar.a(getBidFloor(requestParameters));
        gVar.a(this.mAdReward);
        gVar.c(this.isCacheVideoOnlyWifi);
        gVar.a(new ak());
        gVar.b(this.mRewardOnDownloaded);
        gVar.a(requestParameters);
        gVar.a(str);
    }

    private void loadBiddingAd(RequestParameters requestParameters, String str, String str2, FeedAdListener feedAdListener, ExpressAdListener expressAdListener) {
        dg dgVar = new dg(this.mContext, getAdPlacemenId(requestParameters), str, this.isCacheVideo, this.mTimeoutMillis);
        if (!TextUtils.isEmpty(this.mAppSid)) {
            dgVar.h(this.mAppSid);
        }
        dgVar.r = getBidFloor(requestParameters);
        dgVar.c(this.mAdReward);
        dgVar.d(this.mRewardOnDownloaded);
        dgVar.b(this.isCacheVideoOnlyWifi);
        if (feedAdListener != null) {
            dgVar.a(new ad(feedAdListener));
        } else if (expressAdListener != null) {
            dgVar.a(expressAdListener);
            dgVar.a(1);
        }
        dgVar.a(new ak());
        if (requestParameters == null) {
            requestParameters = new RequestParameters.Builder().build();
        }
        dgVar.a(requestParameters);
        dgVar.l();
        dgVar.c(str2);
    }

    private String getAdPlacemenId(RequestParameters requestParameters) {
        if (requestParameters != null) {
            String adPlacementId = requestParameters.getAdPlacementId();
            if (!TextUtils.isEmpty(adPlacementId)) {
                return adPlacementId;
            }
        }
        return this.mAdPlacementId;
    }

    private int getBidFloor(RequestParameters requestParameters) {
        int bidFloor;
        return (requestParameters == null || (bidFloor = requestParameters.getBidFloor()) <= 0) ? this.mBidFloor : bidFloor;
    }
}
