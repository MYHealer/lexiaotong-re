package com.meishu.sdk.platform.bd.draw;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.meishu.sdk.core.MSAdConfig;
import com.meishu.sdk.core.ad.draw.DrawAd;
import com.meishu.sdk.core.ad.draw.a;
import com.meishu.sdk.core.loader.d;
import com.meishu.sdk.core.safe.l;
import com.meishu.sdk.core.safe.o;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BDDrawAd extends DrawAd {
    private d adWrapper;
    private boolean hasExposed;
    private a loaderListener;
    private FeedPortraitVideoView mFeedVideoView;
    private NativeResponse nativeResponse;

    public BDDrawAd(d dVar, NativeResponse nativeResponse, a aVar) {
        super(dVar, MSAdConfig.PLATFORM_BD);
        this.adWrapper = dVar;
        this.nativeResponse = nativeResponse;
        this.loaderListener = aVar;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void showAd(ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeAllViews();
        FeedPortraitVideoView feedPortraitVideoView = new FeedPortraitVideoView(viewGroup.getContext());
        this.mFeedVideoView = feedPortraitVideoView;
        feedPortraitVideoView.setUseDownloadFrame(true);
        this.mFeedVideoView.setShowProgress(true);
        this.mFeedVideoView.setProgressBackgroundColor(-16777216);
        this.mFeedVideoView.setProgressBarColor(-1);
        this.mFeedVideoView.setProgressHeightInDp(1);
        this.mFeedVideoView.setFeedPortraitListener(new IFeedPortraitListener() { // from class: com.meishu.sdk.platform.bd.draw.BDDrawAd.1
            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void pauseBtnClick() {
                if (BDDrawAd.this.listener != null) {
                    BDDrawAd.this.listener.pauseBtnClick();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playCompletion() {
                if (BDDrawAd.this.listener != null) {
                    BDDrawAd.this.listener.playCompletion();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playError() {
                if (BDDrawAd.this.listener != null) {
                    BDDrawAd.this.listener.playError();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playPause() {
                if (BDDrawAd.this.listener != null) {
                    BDDrawAd.this.listener.playPause();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playRenderingStart() {
                if (BDDrawAd.this.listener != null) {
                    BDDrawAd.this.listener.playRenderingStart();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playResume() {
                if (BDDrawAd.this.listener != null) {
                    BDDrawAd.this.listener.playResume();
                }
            }
        });
        viewGroup.addView(this.mFeedVideoView, new RelativeLayout.LayoutParams(-1, -1));
        ((Activity) viewGroup.getContext()).runOnUiThread(new l() { // from class: com.meishu.sdk.platform.bd.draw.BDDrawAd.2
            @Override // com.meishu.sdk.core.safe.l
            public void safeRun() {
                BDDrawAd.this.mFeedVideoView.setAdData((XAdNativeResponse) BDDrawAd.this.nativeResponse);
                BDDrawAd.this.mFeedVideoView.play();
                if (!BDDrawAd.this.hasExposed && BDDrawAd.this.loaderListener != null) {
                    BDDrawAd.this.hasExposed = true;
                    BDDrawAd.this.loaderListener.onAdExposure();
                }
                BDDrawAd.this.mFeedVideoView.setOnClickListener(new o() { // from class: com.meishu.sdk.platform.bd.draw.BDDrawAd.2.1
                    @Override // com.meishu.sdk.core.safe.o
                    public void safeOnClick(View view) {
                    }
                });
            }
        });
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void destroy() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
        this.nativeResponse = null;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public long getCurrentPosition() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            return feedPortraitVideoView.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public long getDuration() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            return feedPortraitVideoView.getDuration();
        }
        return 0L;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public boolean isPlaying() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            return feedPortraitVideoView.isPlaying();
        }
        return false;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public boolean isShowEndFrame() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            return feedPortraitVideoView.isShowEndFrame();
        }
        return false;
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void pause() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.pause();
        }
    }

    public void play() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setAdData((XAdNativeResponse) this.nativeResponse);
            this.mFeedVideoView.play();
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void resume() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.resume();
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void setCanClickVideo(boolean z) {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setCanClickVideo(z);
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void setVideoMute(boolean z) {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.setVideoMute(z);
        }
    }

    @Override // com.meishu.sdk.core.ad.draw.DrawAd, com.meishu.sdk.core.ad.draw.IDrawAd
    public void stop() {
        FeedPortraitVideoView feedPortraitVideoView = this.mFeedVideoView;
        if (feedPortraitVideoView != null) {
            feedPortraitVideoView.stop();
        }
    }
}
