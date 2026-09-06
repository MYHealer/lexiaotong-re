package com.yfanads.android.custom.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdInterV2ViewHolder extends AdBaseViewHolder {
    public LottieAnimationView actionView;
    public RelativeLayout adFillBgArea;
    public ImageView adIcon;
    public TextView adIconName;
    public View animationClickView;
    public View animationSlideView;
    public LottieAnimationView barView;
    public RelativeLayout bigArea;
    public TextView countTextView;
    public ViewGroup nativeAdContainer;
    public View noClickView;
    public RelativeLayout smallArea;

    public enum ImageStyle {
        TYPE_BIG,
        TYPE_SMALL
    }

    public AdInterV2ViewHolder(View view) {
        this(view, null);
    }

    private boolean hasSlide(BaseTemplateData.InteractiveStyle interactiveStyle) {
        return interactiveStyle == BaseTemplateData.InteractiveStyle.SLIDE || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE;
    }

    private void updateActionView(String str) {
        if (TextUtils.isEmpty(str)) {
            this.actionView.setVisibility(4);
            this.animationSlideView.setVisibility(4);
        } else {
            this.actionView.setVisibility(0);
            this.actionView.setAnimation(str);
            this.actionView.setRepeatCount(-1);
            this.actionView.playAnimation();
        }
    }

    private void updateAnimaMargin(Context context, InterTemplateData interTemplateData) {
        int[] iArr;
        if (interTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_TWIST || interTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.TWIST || interTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_SHAKE || interTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SHAKE) {
            iArr = new int[]{163, 75};
        } else {
            iArr = (interTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_SLIDE || interTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SLIDE) ? new int[]{100, 100} : null;
        }
        if (iArr != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, ScreenUtil.dip2px(context, 75.0f));
            layoutParams.addRule(14);
            layoutParams.addRule(12);
            this.barView.setLayoutParams(layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(context, iArr[0]), ScreenUtil.dip2px(context, iArr[1]));
            layoutParams2.addRule(14);
            layoutParams2.addRule(2, R.id.bar_lottie_view);
            this.actionView.setLayoutParams(layoutParams2);
            if (!hasSlide(interTemplateData.getActiveStyle())) {
                this.animationSlideView.setVisibility(8);
                return;
            }
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, interTemplateData.popHeight / 3);
            layoutParams3.addRule(8, R.id.action_lottie_view);
            this.animationSlideView.setLayoutParams(layoutParams3);
            this.animationSlideView.setVisibility(0);
        }
    }

    private void updateBarView(String str, boolean z) {
        if (TextUtils.isEmpty(str) || !z) {
            this.barView.setVisibility(8);
            this.animationClickView.setVisibility(8);
            return;
        }
        this.barView.setVisibility(0);
        this.barView.setAnimation(str);
        this.barView.setRepeatCount(-1);
        this.barView.playAnimation();
        this.animationClickView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.dip2px(this.animationClickView.getContext(), 50.0f));
        layoutParams.addRule(8, R.id.bar_lottie_view);
        layoutParams.bottomMargin = ScreenUtil.dip2px(this.animationClickView.getContext(), 30.0f);
        this.animationClickView.setLayoutParams(layoutParams);
    }

    private void updateCountdown(Context context, InterTemplateData interTemplateData, int i) {
        this.closeBtn.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.countTextView.getLayoutParams();
        layoutParams.addRule(i == 1 ? 20 : 21);
        this.countTextView.setLayoutParams(layoutParams);
        this.countTextView.setTextSize(interTemplateData.getAutoCloseSP());
        this.countTextView.setVisibility(0);
        this.countTextView.setText(context.getString(R.string.close_tips, Integer.valueOf(interTemplateData.getAutoCloseTime())));
    }

    private void updateViewSize(Context context, InterTemplateData.InteractiveSize interactiveSize) {
        if (interactiveSize == InterTemplateData.InteractiveSize.BIG || interactiveSize == InterTemplateData.InteractiveSize.BIGGEST) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.adIcon.getLayoutParams();
            layoutParams.width = (int) (((double) layoutParams.width) * 1.16d);
            layoutParams.height = (int) (((double) layoutParams.height) * 1.16d);
            this.adIcon.setLayoutParams(layoutParams);
            this.adDes.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.big_des_size));
            this.adIconName.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.big_title_size));
            return;
        }
        if (interactiveSize != InterTemplateData.InteractiveSize.SMALL) {
            YFLog.debug("updateViewSize normal");
            return;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.adIcon.getLayoutParams();
        layoutParams2.width = (int) (((double) layoutParams2.width) * 0.8d);
        layoutParams2.height = (int) (((double) layoutParams2.height) * 0.8d);
        this.adIcon.setLayoutParams(layoutParams2);
        this.adDes.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.small_des_size));
        this.adIconName.setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.small_title_size));
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public View getCloseView(BaseTemplateData baseTemplateData) {
        return ((baseTemplateData instanceof InterTemplateData) && ((InterTemplateData) baseTemplateData).isAutoClose()) ? this.countTextView : this.closeBtn;
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void setInteractionVisible(int i) {
        this.actionView.setVisibility(i);
        this.animationSlideView.setVisibility(i);
    }

    public void showImageStyle(ImageStyle imageStyle) {
        boolean z = imageStyle == ImageStyle.TYPE_BIG;
        this.smallArea.setVisibility(z ? 8 : 0);
        this.bigArea.setVisibility(z ? 0 : 8);
        this.adFillBgArea.setVisibility(z ? 0 : 8);
        if (z) {
            this.adIconName = (TextView) this.convertView.findViewById(R.id.ad_icon_name);
            this.adIcon = (ImageView) this.convertView.findViewById(R.id.ad_icon);
            this.adDes = (TextView) this.convertView.findViewById(R.id.ad_desc);
        } else {
            this.adIconName = (TextView) this.convertView.findViewById(R.id.ad_icon_name_small);
            this.adIcon = (ImageView) this.convertView.findViewById(R.id.ad_icon_small);
            this.adDes = (TextView) this.convertView.findViewById(R.id.ad_desc_small);
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public boolean startCountDown(BaseTemplateData baseTemplateData) {
        if (!(baseTemplateData instanceof InterTemplateData)) {
            this.countTextView.setVisibility(8);
            return false;
        }
        boolean zIsAutoClose = ((InterTemplateData) baseTemplateData).isAutoClose();
        this.countTextView.setVisibility(zIsAutoClose ? 0 : 8);
        return zIsAutoClose;
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateBarClickable(boolean z) {
        this.barView.setEnabled(z);
        this.animationClickView.setEnabled(z);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateCountDown(BaseTemplateData baseTemplateData, int i) {
        TextView textView = this.countTextView;
        textView.setText(textView.getContext().getString(R.string.close_tips, Integer.valueOf(i)));
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateInteraction(Context context, BaseTemplateData baseTemplateData) {
        if (baseTemplateData instanceof InterTemplateData) {
            InterTemplateData interTemplateData = (InterTemplateData) baseTemplateData;
            String[] activeStylePath = interTemplateData.getActiveStylePath();
            if (activeStylePath == null || activeStylePath.length < 2) {
                this.barView.setVisibility(8);
                this.actionView.setVisibility(8);
                this.animationClickView.setVisibility(8);
                this.animationSlideView.setVisibility(8);
                return;
            }
            String str = activeStylePath[0];
            String str2 = activeStylePath[1];
            updateActionView(str);
            updateBarView(str2, interTemplateData.isShowBtn());
            updateAnimaMargin(context, interTemplateData);
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateShowView(Context context, BaseTemplateData baseTemplateData) {
        if (baseTemplateData instanceof InterTemplateData) {
            InterTemplateData interTemplateData = (InterTemplateData) baseTemplateData;
            updateViewSize(context, interTemplateData.size);
            int closeLoc = interTemplateData.getCloseLoc();
            if (interTemplateData.isAutoClose()) {
                updateCountdown(context, interTemplateData, closeLoc);
            } else {
                this.countTextView.setVisibility(8);
                showCloseStyle(interTemplateData.getCloseSize(context), closeLoc);
            }
            updateFeedView(baseTemplateData);
            showFeedArea(closeLoc);
            updateClickSize(baseTemplateData);
            updateInteraction(context, interTemplateData);
        }
    }

    public AdInterV2ViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        this.nativeAdContainer = viewGroup;
        this.adIcon = (ImageView) view.findViewById(R.id.ad_icon);
        this.smallArea = (RelativeLayout) view.findViewById(R.id.inter_v2_small_style);
        this.bigArea = (RelativeLayout) view.findViewById(R.id.inter_v2_big_style);
        this.barView = (LottieAnimationView) view.findViewById(R.id.bar_lottie_view);
        this.actionView = (LottieAnimationView) view.findViewById(R.id.action_lottie_view);
        this.animationClickView = view.findViewById(R.id.bar_click_view);
        this.animationSlideView = view.findViewById(R.id.action_click_view);
        this.adFillBgArea = (RelativeLayout) view.findViewById(R.id.ad_fill_bg);
        this.noClickView = view.findViewById(R.id.no_click_view);
        this.countTextView = (TextView) view.findViewById(R.id.tev_countdown);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void setInteractionVisible(int i, int i2) {
        this.barView.setVisibility(i2);
        this.actionView.setVisibility(i);
        this.animationClickView.setVisibility(i2);
        this.animationSlideView.setVisibility(i);
    }
}
