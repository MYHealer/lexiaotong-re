package com.hihonor.adsdk.base.widget.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class AdRootView<Ad extends BaseAd> extends BaseAdView<Ad> {
    private static final String LOG_TAG = "AdRootView";

    class a extends com.hihonor.adsdk.common.f.e.b {
        a() {
        }

        @Override // com.hihonor.adsdk.common.f.e.b, android.view.View.OnClickListener
        public void onClick(View view) {
            AdRootView.this.triggerClick(view);
            super.onClick(view);
        }
    }

    public AdRootView(Context context) {
        super(context);
    }

    @Override // com.hihonor.adsdk.base.widget.base.BaseAdView
    protected void initView() {
    }

    /* JADX INFO: renamed from: lambda$registerStartButtonClickListener$0$com-hihonor-adsdk-base-widget-base-AdRootView, reason: not valid java name */
    /* synthetic */ void m902xab819d43(View.OnClickListener onClickListener, View view) {
        triggerClick(view);
        onClickListener.onClick(view);
    }

    public void registerStartButtonClickListener(View view, final View.OnClickListener onClickListener) {
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "#registerStartButtonClickListener#view is null.", new Object[0]);
            return;
        }
        view.setTag(R.id.ad_common_click_type_tag, 1);
        if (onClickListener != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.AdRootView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.m902xab819d43(onClickListener, view2);
                }
            });
        } else {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.base.AdRootView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f$0.triggerClick(view2);
                }
            });
            com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, "#registerStartButtonClickListener#onClickListener is null.", new Object[0]);
        }
    }

    public void registerViewForInteraction(List<View> list) {
        if (com.hihonor.adsdk.common.f.f.hnadsa((Collection<?>) list)) {
            com.hihonor.adsdk.common.b.b.hnadse(LOG_TAG, "The view list cannot be empty.", new Object[0]);
            return;
        }
        for (View view : list) {
            if (!g.hnadsa(view)) {
                if (view.hasOnClickListeners()) {
                    View.OnClickListener onClickListenerHnadsb = g.hnadsb(view);
                    if (onClickListenerHnadsb != null) {
                        a aVar = new a();
                        aVar.hnadsa(onClickListenerHnadsb);
                        view.setOnClickListener(aVar);
                    }
                } else {
                    com.hihonor.adsdk.common.b.b.hnadsc(LOG_TAG, view.getClass().getSimpleName() + " no listener is set, No registration required.", new Object[0]);
                }
            }
        }
    }

    public void setDownLoadButton(HnDownloadButton hnDownloadButton) {
        if (!hasAd() || (getAd().getPromotionPurpose() != 0 && getAd().getPromotionPurpose() != 4)) {
            hnDownloadButton.setVisibility(8);
        } else {
            hnDownloadButton.setVisibility(0);
            hnDownloadButton.setBaseAd(getAd(), 1);
        }
    }

    public AdRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AdRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
