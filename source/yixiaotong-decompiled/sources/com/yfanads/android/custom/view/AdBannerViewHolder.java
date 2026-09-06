package com.yfanads.android.custom.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.model.template.BannerTemplateData;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.template.TemplateRes;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdBannerViewHolder extends AdBaseViewHolder {
    private static final String TAG = "AdBannerViewHolder";
    public View adCloseDelay;
    public ImageView adIcon;
    public TextView mDownload;
    public LottieAnimationView mDownloadBar;
    public ViewGroup nativeAdContainer;
    public RelativeLayout showArea;
    public RelativeLayout titleBtnArea;
    public TextView titleDes;

    public AdBannerViewHolder(View view, BannerTemplateData bannerTemplateData, ViewGroup viewGroup) {
        super(view);
        this.nativeAdContainer = viewGroup;
        this.adDes = (TextView) view.findViewById(R.id.ad_desc);
        this.mDownload = (TextView) view.findViewById(R.id.download);
        this.showArea = (RelativeLayout) view.findViewById(R.id.show_area);
        initCustomViews(view, bannerTemplateData);
    }

    private void initCustomViews(View view, BannerTemplateData bannerTemplateData) {
        if (bannerTemplateData.isView(TemplateRes.BANNER_WH640)) {
            this.titleBtnArea = (RelativeLayout) view.findViewById(R.id.bottom_area);
            return;
        }
        if (bannerTemplateData.isView(TemplateRes.BANNER_VTB)) {
            this.titleDes = (TextView) view.findViewById(R.id.ad_icon_name);
            this.titleBtnArea = (RelativeLayout) view.findViewById(R.id.bottom_area);
            return;
        }
        if (bannerTemplateData.isView(TemplateRes.BANNER_WH626) || bannerTemplateData.isView(TemplateRes.BANNER_WH615) || bannerTemplateData.isView(TemplateRes.BANNER_WH610)) {
            this.titleDes = (TextView) view.findViewById(R.id.ad_icon_name);
            this.titleBtnArea = (RelativeLayout) view.findViewById(R.id.right_area);
            return;
        }
        if (bannerTemplateData.isView(TemplateRes.BANNER_WH641)) {
            this.adIcon = (ImageView) view.findViewById(R.id.ad_icon);
            this.titleDes = (TextView) view.findViewById(R.id.ad_icon_name);
            this.titleBtnArea = (RelativeLayout) view.findViewById(R.id.bottom_area);
        } else if (bannerTemplateData.isTemplateV3()) {
            this.adIcon = (ImageView) view.findViewById(R.id.ad_icon);
            this.titleDes = (TextView) view.findViewById(R.id.ad_icon_name);
            if (bannerTemplateData.isTemplateV3_W615() || bannerTemplateData.isTemplateV3_W610() || bannerTemplateData.isTemplateV3_W626()) {
                this.titleBtnArea = (RelativeLayout) view.findViewById(R.id.right_area);
            } else {
                this.titleBtnArea = (RelativeLayout) view.findViewById(R.id.bottom_area);
            }
            this.mDownloadBar = (LottieAnimationView) view.findViewById(R.id.download_action);
            this.adCloseDelay = view.findViewById(R.id.ad_close_delay_area);
        }
    }

    private void showCloseStyle(Context context, BannerTemplateData bannerTemplateData) {
        if (bannerTemplateData.isTemplateV3()) {
            this.closeBtn.setImageResource(bannerTemplateData.getCloseResV3());
            updateCloseLoc(bannerTemplateData);
            return;
        }
        if (bannerTemplateData.isClose2()) {
            this.closeBtn.setImageResource(R.mipmap.yf_ad_close2);
        } else if (bannerTemplateData.isClose3()) {
            this.closeBtn.setImageResource(R.mipmap.yf_ad_close3);
        } else {
            this.closeBtn.setImageResource(R.mipmap.yf_ad_close);
        }
        showCloseStyle(bannerTemplateData.getCloseSize(context));
    }

    private void startCloseDelay(BaseTemplateData baseTemplateData) {
        View view;
        baseTemplateData.setCloseShowTime(System.currentTimeMillis());
        if (!baseTemplateData.isSupportClose() || (view = this.adCloseDelay) == null) {
            return;
        }
        view.setVisibility(0);
        YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdBannerViewHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1234xf7f66cd5();
            }
        }, baseTemplateData.getCloseDelay());
    }

    private void updateClickSize(BannerTemplateData bannerTemplateData) {
        if (bannerTemplateData.isTemplateV3()) {
            return;
        }
        float clickRatio = bannerTemplateData.getClickRatio();
        int i = (int) (bannerTemplateData.popWidth * clickRatio);
        int i2 = (int) (bannerTemplateData.popHeight * clickRatio);
        YFLog.debug("updateClickSize width = " + i + " , height = " + i2 + " , clickRatio " + clickRatio);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(13);
        this.dyClickView.setLayoutParams(layoutParams);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private void updateCloseLoc(BannerTemplateData bannerTemplateData) {
        if (bannerTemplateData == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mClose.getLayoutParams();
        int closeLoc = bannerTemplateData.getCloseLoc();
        String str = bannerTemplateData.type;
        str.getClass();
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -2077740373:
                if (str.equals(TemplateRes.BANNER_WH610_ZT_YW)) {
                    b = 0;
                }
                break;
            case 14557959:
                if (str.equals(TemplateRes.BANNER_WH610_ZW_YT)) {
                    b = 1;
                }
                break;
            case 759515336:
                if (str.equals(TemplateRes.BANNER_WH615_ZW_YT)) {
                    b = 2;
                }
                break;
            case 759546088:
                if (str.equals(TemplateRes.BANNER_WH626_ZW_YT)) {
                    b = 3;
                }
                break;
            case 2102710474:
                if (str.equals(TemplateRes.BANNER_WH615_ZT_YW)) {
                    b = 4;
                }
                break;
            case 2102711466:
                if (str.equals(TemplateRes.BANNER_WH626_ZT_YW)) {
                    b = 5;
                }
                break;
        }
        switch (b) {
            case 0:
            case 3:
            case 4:
            case 5:
                layoutParams.addRule(closeLoc != 2 ? 12 : 10);
                break;
            case 1:
            case 2:
                layoutParams.addRule(closeLoc != 8 ? 12 : 10);
                break;
        }
        this.mClose.setLayoutParams(layoutParams);
    }

    private void updateFeedView(BannerTemplateData bannerTemplateData) {
        int i = bannerTemplateData.adLogo;
        if (i > 0) {
            this.adLogoIcon.setImageResource(i);
        }
    }

    private void updateShowViewArea(BannerTemplateData bannerTemplateData) {
        if (TemplateRes.BANNER_WH640.equals(bannerTemplateData.type)) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, bannerTemplateData.height);
            layoutParams.addRule(2, R.id.bottom_area);
            this.showArea.setLayoutParams(layoutParams);
            return;
        }
        if (TemplateRes.BANNER_WH626.equals(bannerTemplateData.type)) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((bannerTemplateData.height * 3) / 2, bannerTemplateData.height);
            layoutParams2.addRule(10, -1);
            this.showArea.setLayoutParams(layoutParams2);
            return;
        }
        if (TemplateRes.BANNER_WH615.equals(bannerTemplateData.type) || TemplateRes.BANNER_WH610.equals(bannerTemplateData.type)) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((bannerTemplateData.height * 16) / 9, bannerTemplateData.height);
            layoutParams3.addRule(10, -1);
            this.showArea.setLayoutParams(layoutParams3);
            return;
        }
        if (TemplateRes.BANNER_VTB.equals(bannerTemplateData.type)) {
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, bannerTemplateData.height);
            layoutParams4.addRule(2, R.id.bottom_area);
            this.showArea.setLayoutParams(layoutParams4);
            return;
        }
        if (TemplateRes.BANNER_WH641.equals(bannerTemplateData.type) || TemplateRes.BANNER_WH640_SW_XT.equals(bannerTemplateData.type)) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(bannerTemplateData.popWidth, (bannerTemplateData.popWidth * 9) / 16);
            layoutParams5.addRule(12, -1);
            this.showArea.setLayoutParams(layoutParams5);
            if (TemplateRes.BANNER_WH640_SW_XT.equals(bannerTemplateData.type)) {
                updateTextArea(bannerTemplateData);
                return;
            }
            return;
        }
        if (bannerTemplateData.isTemplateV3_W640()) {
            int i = (bannerTemplateData.popWidth * 9) / 16;
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.showArea.getLayoutParams();
            layoutParams6.width = bannerTemplateData.popWidth;
            layoutParams6.height = i;
            this.showArea.setLayoutParams(layoutParams6);
            updateTextArea(bannerTemplateData);
            return;
        }
        if (bannerTemplateData.isTemplateV3_W615() || bannerTemplateData.isTemplateV3_W610()) {
            int i2 = (bannerTemplateData.height * 16) / 9;
            RelativeLayout.LayoutParams layoutParams7 = (RelativeLayout.LayoutParams) this.showArea.getLayoutParams();
            layoutParams7.width = i2;
            layoutParams7.height = bannerTemplateData.popHeight;
            this.showArea.setLayoutParams(layoutParams7);
            return;
        }
        if (bannerTemplateData.isTemplateV3_W626()) {
            int i3 = (bannerTemplateData.height * 10) / 7;
            RelativeLayout.LayoutParams layoutParams8 = (RelativeLayout.LayoutParams) this.showArea.getLayoutParams();
            layoutParams8.width = i3;
            layoutParams8.height = bannerTemplateData.popHeight;
            this.showArea.setLayoutParams(layoutParams8);
        }
    }

    private void updateTextArea(BannerTemplateData bannerTemplateData) {
        try {
            if (bannerTemplateData.scale >= 100) {
                return;
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.adIcon.getLayoutParams();
            int i = (layoutParams.width * bannerTemplateData.scale) / 100;
            layoutParams.width = i;
            layoutParams.height = i;
            this.adIcon.setLayoutParams(layoutParams);
            this.mDownload.setTextSize((bannerTemplateData.scale * 11) / 100.0f);
            if (this.mDownload.getContext() != null) {
                int iDip2px = (ScreenUtil.dip2px(this.mDownload.getContext(), 4.0f) * bannerTemplateData.scale) / 100;
                int iDip2px2 = (ScreenUtil.dip2px(this.mDownload.getContext(), 12.0f) * bannerTemplateData.scale) / 100;
                this.mDownload.setPadding(iDip2px2, iDip2px, iDip2px2, iDip2px);
            }
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mDownloadBar.getLayoutParams();
            int i2 = layoutParams2.width;
            int i3 = bannerTemplateData.scale;
            int i4 = (layoutParams2.height * i3) / 100;
            layoutParams2.width = (i2 * i3) / 100;
            layoutParams2.height = i4;
            this.mDownloadBar.setLayoutParams(layoutParams2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public View getCloseView(BaseTemplateData baseTemplateData) {
        startCloseDelay(baseTemplateData);
        return this.closeBtn;
    }

    /* JADX INFO: renamed from: lambda$startCloseDelay$0$com-yfanads-android-custom-view-AdBannerViewHolder, reason: not valid java name */
    /* synthetic */ void m1234xf7f66cd5() {
        this.adCloseDelay.setVisibility(8);
    }

    public void updateShowView(Context context, BannerTemplateData bannerTemplateData) {
        updateShowViewArea(bannerTemplateData);
        showCloseStyle(context, bannerTemplateData);
        updateClickSize(bannerTemplateData);
        updateFeedView(bannerTemplateData);
    }
}
