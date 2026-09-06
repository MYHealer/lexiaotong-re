package com.meishu.sdk.platform.csj.recycler;

import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class CSJVideoAdListenerImpl implements TTFeedAd.VideoAdListener {
    private static final String TAG = "CSJVideoAdListenerImpl";
    private RecyclerAdMediaListener meishuRecyclerAdMediaListener;

    public CSJVideoAdListenerImpl(RecyclerAdMediaListener recyclerAdMediaListener) {
        this.meishuRecyclerAdMediaListener = recyclerAdMediaListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onProgressUpdate(long j, long j2) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdContinuePlay(TTFeedAd tTFeedAd) {
        LogUtil.d(TAG, "onVideoAdContinuePlay: ");
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdComplete(TTFeedAd tTFeedAd) {
        RecyclerAdMediaListener recyclerAdMediaListener = this.meishuRecyclerAdMediaListener;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoCompleted();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdPaused(TTFeedAd tTFeedAd) {
        RecyclerAdMediaListener recyclerAdMediaListener = this.meishuRecyclerAdMediaListener;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoPause();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoAdStartPlay(TTFeedAd tTFeedAd) {
        RecyclerAdMediaListener recyclerAdMediaListener = this.meishuRecyclerAdMediaListener;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoStart();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoError(int i, int i2) {
        RecyclerAdMediaListener recyclerAdMediaListener = this.meishuRecyclerAdMediaListener;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoError();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.VideoAdListener
    public void onVideoLoad(TTFeedAd tTFeedAd) {
        RecyclerAdMediaListener recyclerAdMediaListener = this.meishuRecyclerAdMediaListener;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoLoaded();
        }
    }
}
