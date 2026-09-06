package com.yfanads.android.core.render.impl;

import android.app.FragmentManager;
import android.view.View;
import android.view.ViewGroup;
import com.yfanads.android.core.render.YFNativeAdView;
import com.yfanads.android.core.render.api.YFNativeAd;
import com.yfanads.android.core.render.api.YFNativeCall;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public abstract class YFAbsNativeAd implements YFNativeAd {
    private int index;
    protected YFNativeCall nativeCall;

    public YFAbsNativeAd(YFNativeCall yFNativeCall) {
        this.nativeCall = yFNativeCall;
    }

    public int getIndex() {
        return this.index;
    }

    public void handleClick(YFNativeAd.AdInteractionListener adInteractionListener) {
        handleClick();
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked(this);
        }
    }

    public void handleClose(YFNativeAd.AdInteractionListener adInteractionListener) {
        handleClose();
        if (adInteractionListener != null) {
            adInteractionListener.onAdClose(this);
        }
    }

    public void handleExposure(YFNativeAd.AdInteractionListener adInteractionListener) {
        handleExposure();
        if (adInteractionListener != null) {
            adInteractionListener.onAdShow(this);
        }
    }

    /* JADX INFO: renamed from: lambda$handleClose$1$com-yfanads-android-core-render-impl-YFAbsNativeAd, reason: not valid java name */
    /* synthetic */ void m1217x814f1c00(YFNativeAd.AdInteractionListener adInteractionListener, View view) {
        handleClose(adInteractionListener);
    }

    /* JADX INFO: renamed from: lambda$onFeedBack$0$com-yfanads-android-core-render-impl-YFAbsNativeAd, reason: not valid java name */
    /* synthetic */ void m1218x181bd213(FragmentManager fragmentManager, View view) {
        showFeedBackDialog(fragmentManager);
    }

    public void onFeedBack(final FragmentManager fragmentManager, View view) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.core.render.impl.YFAbsNativeAd$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m1218x181bd213(fragmentManager, view2);
            }
        });
    }

    @Override // com.yfanads.android.core.render.api.YFNativeAd
    public void renderAdContainer(YFNativeAdView yFNativeAdView, View view) {
        if (yFNativeAdView == null || view == null) {
            return;
        }
        try {
            YFNativeAdView yFNativeAdView2 = new YFNativeAdView(yFNativeAdView.getContext());
            yFNativeAdView.removeAllViews();
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            if (yFNativeAdView2.getParent() != null) {
                ((ViewGroup) yFNativeAdView2.getParent()).removeView(yFNativeAdView2);
            }
            yFNativeAdView2.addView(view);
            yFNativeAdView.addView(yFNativeAdView2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void handleFailed(String str, String str2) {
        YFNativeCall yFNativeCall = this.nativeCall;
        if (yFNativeCall != null) {
            yFNativeCall.handleFailed(str, str2);
        }
    }

    public void showFeedBackDialog(FragmentManager fragmentManager) {
        YFNativeCall yFNativeCall = this.nativeCall;
        if (yFNativeCall != null) {
            yFNativeCall.showFeedBackDialog(fragmentManager, "feed");
        }
    }

    public YFAbsNativeAd(YFNativeCall yFNativeCall, int i) {
        this.nativeCall = yFNativeCall;
        this.index = i;
    }

    public void handleClose(View view, final YFNativeAd.AdInteractionListener adInteractionListener) {
        view.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.core.render.impl.YFAbsNativeAd$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m1217x814f1c00(adInteractionListener, view2);
            }
        });
    }

    public void handleClick() {
        YFNativeCall yFNativeCall = this.nativeCall;
        if (yFNativeCall != null) {
            yFNativeCall.handleClickByIndex(false, this.index);
        }
    }

    public void handleExposure() {
        YFNativeCall yFNativeCall = this.nativeCall;
        if (yFNativeCall != null) {
            yFNativeCall.handleExposureByIndex(this.index);
        }
    }

    public void handleClose() {
        YFNativeCall yFNativeCall = this.nativeCall;
        if (yFNativeCall != null) {
            yFNativeCall.handleClose();
        }
    }
}
