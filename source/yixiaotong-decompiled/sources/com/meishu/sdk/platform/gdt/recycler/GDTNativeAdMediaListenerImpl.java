package com.meishu.sdk.platform.gdt.recycler;

import android.os.Handler;
import com.meishu.sdk.core.ad.recycler.RecyclerAdMediaListener;
import com.meishu.sdk.core.safe.l;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class GDTNativeAdMediaListenerImpl implements NativeADMediaListener {
    private static final String TAG = "GDTNativeAdMediaListene";
    private RecyclerAdMediaListener nativeRecyclerAdMediaListener;
    private NativeUnifiedADData nativeUnifiedADData;
    private Runnable updateTime = new l() { // from class: com.meishu.sdk.platform.gdt.recycler.GDTNativeAdMediaListenerImpl.1
        @Override // com.meishu.sdk.core.safe.l
        public void safeRun() {
            if (GDTNativeAdMediaListenerImpl.this.nativeUnifiedADData != null) {
                GDTNativeAdMediaListenerImpl.this.mHandler.postDelayed(GDTNativeAdMediaListenerImpl.this.updateTime, 500L);
                int videoDuration = GDTNativeAdMediaListenerImpl.this.nativeUnifiedADData.getVideoDuration();
                int videoCurrentPosition = GDTNativeAdMediaListenerImpl.this.nativeUnifiedADData.getVideoCurrentPosition();
                if (videoDuration <= 0 || videoCurrentPosition <= 0 || GDTNativeAdMediaListenerImpl.this.nativeRecyclerAdMediaListener == null) {
                    return;
                }
                GDTNativeAdMediaListenerImpl.this.nativeRecyclerAdMediaListener.onProgressUpdate(videoCurrentPosition, videoDuration);
            }
        }
    };
    private final Handler mHandler = new Handler();

    public GDTNativeAdMediaListenerImpl(RecyclerAdMediaListener recyclerAdMediaListener, NativeUnifiedADData nativeUnifiedADData) {
        this.nativeRecyclerAdMediaListener = recyclerAdMediaListener;
        this.nativeUnifiedADData = nativeUnifiedADData;
    }

    public void destroy() {
        try {
            this.mHandler.removeCallbacks(this.updateTime);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoClicked() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoError(AdError adError) {
        try {
            this.nativeRecyclerAdMediaListener.onVideoError();
            this.mHandler.removeCallbacks(this.updateTime);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoInit() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoaded(int i) {
        try {
            this.nativeRecyclerAdMediaListener.onVideoLoaded();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoLoading() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoPause() {
        try {
            this.nativeRecyclerAdMediaListener.onVideoPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoReady() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoResume() {
        try {
            this.nativeRecyclerAdMediaListener.onVideoResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStart() {
        try {
            this.nativeRecyclerAdMediaListener.onVideoStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.post(this.updateTime);
        }
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoStop() {
    }

    @Override // com.qq.e.ads.nativ.NativeADMediaListener
    public void onVideoCompleted() {
        int videoDuration;
        if (this.nativeRecyclerAdMediaListener != null && (videoDuration = this.nativeUnifiedADData.getVideoDuration()) > 0) {
            long j = videoDuration;
            this.nativeRecyclerAdMediaListener.onProgressUpdate(j, j);
        }
        RecyclerAdMediaListener recyclerAdMediaListener = this.nativeRecyclerAdMediaListener;
        if (recyclerAdMediaListener != null) {
            recyclerAdMediaListener.onVideoCompleted();
        }
        this.mHandler.removeCallbacks(this.updateTime);
    }
}
