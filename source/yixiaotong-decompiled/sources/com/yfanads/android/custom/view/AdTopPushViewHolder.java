package com.yfanads.android.custom.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.yfanads.ads.R;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.TopPushTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdTopPushViewHolder extends AdBaseViewHolder {
    private static final String TAG = "AdTopPushViewHolder";
    public View adCloseDelay;
    public ImageView adIcon;
    public TextView mDownload;
    public ViewGroup nativeAdContainer;
    public RelativeLayout showArea;
    public TextView titleDes;

    public AdTopPushViewHolder(View view, TopPushTemplateData topPushTemplateData, ViewGroup viewGroup) {
        super(view);
        this.nativeAdContainer = viewGroup;
        this.adDes = (TextView) view.findViewById(R.id.ad_desc);
        this.mDownload = (TextView) view.findViewById(R.id.download);
        this.showArea = (RelativeLayout) view.findViewById(R.id.show_area);
        this.adCloseDelay = view.findViewById(R.id.ad_close_delay_bottom_area);
        updateShowView(view.getContext(), topPushTemplateData);
        initCustomViews(view, topPushTemplateData);
    }

    private void initCustomViews(View view, TopPushTemplateData topPushTemplateData) {
        this.adIcon = (ImageView) view.findViewById(R.id.ad_icon);
        this.titleDes = (TextView) view.findViewById(R.id.ad_icon_name);
    }

    static /* synthetic */ void lambda$startCloseDelay$0(View view) {
    }

    private void showCloseStyle(Context context, TopPushTemplateData topPushTemplateData) {
        updateCloseLoc(context, topPushTemplateData);
    }

    private void startCloseDelay(BaseTemplateData baseTemplateData) {
        baseTemplateData.setCloseShowTime(System.currentTimeMillis());
        YFLog.debug("startCloseDelay " + baseTemplateData.isSupportClose() + PPSLabelView.Code + this.adCloseDelay);
        if (!baseTemplateData.isSupportClose() || this.adCloseDelay == null) {
            return;
        }
        YFLog.debug("startCloseDelay " + baseTemplateData.getCloseDelay());
        this.adCloseDelay.setVisibility(0);
        this.adCloseDelay.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.custom.view.AdTopPushViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdTopPushViewHolder.lambda$startCloseDelay$0(view);
            }
        });
        YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdTopPushViewHolder$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1246x8f5c64c9();
            }
        }, baseTemplateData.getCloseDelay());
    }

    private void updateCloseLoc(Context context, TopPushTemplateData topPushTemplateData) {
        if (topPushTemplateData == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.closeBtn.getLayoutParams();
        int v3CloseSize = topPushTemplateData.getV3CloseSize(context);
        layoutParams.width = v3CloseSize;
        layoutParams.height = v3CloseSize;
        int closeLoc = topPushTemplateData.getCloseLoc();
        String str = topPushTemplateData.type;
        str.getClass();
        if (str.equals(TemplateRes.TOP_PUSH_1) || str.equals(TemplateRes.TOP_PUSH_2)) {
            layoutParams.addRule(closeLoc == 2 ? 10 : 12);
        }
        this.closeBtn.setLayoutParams(layoutParams);
    }

    private void updateFeedView(BannerTemplateData bannerTemplateData) {
        int i = bannerTemplateData.adLogo;
        if (i > 0) {
            this.adLogoIcon.setImageResource(i);
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public View getCloseView(BaseTemplateData baseTemplateData) {
        startCloseDelay(baseTemplateData);
        return this.closeBtn;
    }

    /* JADX INFO: renamed from: lambda$startCloseDelay$1$com-yfanads-android-custom-view-AdTopPushViewHolder, reason: not valid java name */
    /* synthetic */ void m1246x8f5c64c9() {
        this.adCloseDelay.setVisibility(8);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public boolean startCountDown(BaseTemplateData baseTemplateData) {
        return true;
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updBgRadius() {
        super.updBgRadius();
        RelativeLayout relativeLayout = this.showArea;
        if (relativeLayout != null) {
            ViewUtils.setRadius(relativeLayout, 20);
        }
    }

    public void updateShowView(Context context, TopPushTemplateData topPushTemplateData) {
        showCloseStyle(context, topPushTemplateData);
        updateFeedView(topPushTemplateData);
    }
}
