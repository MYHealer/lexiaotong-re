package com.yfanads.android.custom.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.InterV3TemplateData;
import com.yfanads.android.model.template.TemplateV3Size;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdInterV3ViewHolder extends AdBaseViewHolder {
    private static final int ANIMATION_COUNT = 3;
    private static final int ANIMATION_DURATION = 1000;
    public static final float SCALE_SIZE = 1.5f;
    public LottieAnimationView actionView;
    private final TextView actonDes;
    private final TextView actonTitle;
    public View adCloseDelay;
    public ImageView adIcon;
    public TextView adIconName;
    public final RelativeLayout animationArea;
    public View animationClickView;
    private int animationEndCount;
    public View animationSlideView;
    public LottieAnimationView barView;
    public final RelativeLayout bottomArea;
    public TextView countTextView;
    public ViewGroup nativeAdContainer;
    public View noClickView;
    private final ImageView overAdClose;
    private final RelativeLayout overCloseArea;
    private final TextView overTevCountDown;
    public final RelativeLayout showArea;

    /* JADX INFO: renamed from: com.yfanads.android.custom.view.AdInterV3ViewHolder$1, reason: invalid class name */
    public class AnonymousClass1 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorSet val$animatorSet;

        public AnonymousClass1(AnimatorSet animatorSet) {
            this.val$animatorSet = animatorSet;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AdInterV3ViewHolder.access$008(AdInterV3ViewHolder.this);
            if (AdInterV3ViewHolder.this.animationEndCount >= 6) {
                return;
            }
            if (AdInterV3ViewHolder.this.animationEndCount % 2 != 0) {
                this.val$animatorSet.start();
                return;
            }
            RelativeLayout relativeLayout = AdInterV3ViewHolder.this.animationArea;
            final AnimatorSet animatorSet = this.val$animatorSet;
            Objects.requireNonNull(animatorSet);
            relativeLayout.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdInterV3ViewHolder$1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    animatorSet.start();
                }
            }, 1000L);
        }
    }

    public AdInterV3ViewHolder(View view) {
        this(view, null);
    }

    public static /* synthetic */ int access$008(AdInterV3ViewHolder adInterV3ViewHolder) {
        int i = adInterV3ViewHolder.animationEndCount;
        adInterV3ViewHolder.animationEndCount = i + 1;
        return i;
    }

    private boolean hasSlide(BaseTemplateData.InteractiveStyle interactiveStyle) {
        return interactiveStyle == BaseTemplateData.InteractiveStyle.SLIDE || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE;
    }

    private void startCloseDelay(BaseTemplateData baseTemplateData) {
        View view;
        baseTemplateData.setCloseShowTime(System.currentTimeMillis());
        if (!baseTemplateData.isSupportClose() || (view = this.adCloseDelay) == null) {
            return;
        }
        view.setVisibility(0);
        YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdInterV3ViewHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1236x19e0ad32();
            }
        }, baseTemplateData.getCloseDelay());
    }

    private void updTextColor(InterV3TemplateData interV3TemplateData) {
        TextView textView = this.complianceContent;
        if (textView != null) {
            textView.setTextColor(interV3TemplateData.getComplianceColor(textView.getContext()));
            this.complianceContent.setLineSpacing(1.0f, 0.8f);
            this.complianceContent.setTextSize(interV3TemplateData.getTextSizeSP());
        }
        LinearLayout linearLayout = this.comlianceArea;
        if (linearLayout != null) {
            ((RelativeLayout.LayoutParams) linearLayout.getLayoutParams()).bottomMargin = interV3TemplateData.templateSize.complianceBottom;
        }
    }

    private void updateActionView(String str, InterV3TemplateData interV3TemplateData) {
        if (TextUtils.isEmpty(str)) {
            this.actionView.setVisibility(8);
            this.animationSlideView.setVisibility(8);
            this.actonTitle.setVisibility(8);
            this.actonDes.setVisibility(8);
            return;
        }
        this.actionView.setVisibility(0);
        this.actionView.setAnimation(str);
        this.actionView.setRepeatCount(-1);
        this.actionView.playAnimation();
        BaseTemplateData.InteractiveStyle activeStyle = interV3TemplateData.getActiveStyle();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.actionView.getLayoutParams();
        boolean zHasSlide = hasSlide(activeStyle);
        layoutParams.width = zHasSlide ? interV3TemplateData.templateSize.actionSlideWidth : interV3TemplateData.templateSize.actionSize;
        layoutParams.height = zHasSlide ? interV3TemplateData.templateSize.actionSlideHeight : interV3TemplateData.templateSize.actionSize;
        if (zHasSlide) {
            this.animationSlideView.setVisibility(0);
            return;
        }
        layoutParams.topMargin = interV3TemplateData.templateSize.actionTop;
        this.actonTitle.setVisibility(0);
        this.actonTitle.setText(getActionRes(activeStyle));
        this.actonTitle.setTextSize(interV3TemplateData.templateSize.actionTitleSP);
        this.actonDes.setVisibility(0);
        this.actonDes.setTextSize(interV3TemplateData.templateSize.actionDesSP);
    }

    private void updateAnimation(InterV3TemplateData interV3TemplateData) {
        if (interV3TemplateData.hasAnimation()) {
            float f = interV3TemplateData.conf.ts == 3 ? 7.5f : 6.0f;
            Context context = this.animationArea.getContext();
            if (!interV3TemplateData.isPortrait()) {
                f = 4.8f;
            }
            float fDip2px = ScreenUtil.dip2px(context, f);
            YFLog.debug("updateAnimation: " + fDip2px);
            float f2 = -fDip2px;
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.animationArea, "translationY", 0.0f, f2);
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.animationArea, "translationY", f2, 0.0f);
            final AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2);
            animatorSet.setDuration(180L);
            animatorSet.addListener(new AnonymousClass1(animatorSet));
            YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdInterV3ViewHolder$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    animatorSet.start();
                }
            }, 1000L);
        }
    }

    private void updateBarView(String str, InterV3TemplateData interV3TemplateData) {
        if (TextUtils.isEmpty(str)) {
            this.barView.setVisibility(8);
            this.animationClickView.setVisibility(8);
            return;
        }
        this.barView.setVisibility(0);
        this.barView.setAnimation(str);
        this.barView.setRepeatCount(-1);
        this.barView.playAnimation();
        this.animationClickView.setVisibility(0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.barView.getLayoutParams();
        TemplateV3Size templateV3Size = interV3TemplateData.templateSize;
        layoutParams.width = templateV3Size.barWidth;
        layoutParams.height = templateV3Size.barHeight;
        layoutParams.bottomMargin = templateV3Size.barBottom;
    }

    private void updateClose(Context context, InterV3TemplateData interV3TemplateData) {
        if (interV3TemplateData.isCloseBottom()) {
            this.mClose.setVisibility(8);
            updOverClose(interV3TemplateData.getBottomHeight(context, interV3TemplateData.templateSize.templateScale));
            this.adCloseDelay = this.convertView.findViewById(R.id.ad_close_delay_bottom_area);
            if (!interV3TemplateData.isAutoClose()) {
                this.overAdClose.setVisibility(0);
                this.overTevCountDown.setVisibility(8);
                this.overAdClose.setImageResource(interV3TemplateData.getBlackCloseRes());
                return;
            }
            this.overAdClose.setVisibility(8);
            this.overTevCountDown.setVisibility(0);
            ((RelativeLayout.LayoutParams) this.overTevCountDown.getLayoutParams()).height = interV3TemplateData.getV3CloseSize(context);
            int[] v3ClosePadding = interV3TemplateData.getV3ClosePadding(context);
            this.overTevCountDown.setPadding(v3ClosePadding[0], v3ClosePadding[1], v3ClosePadding[2], v3ClosePadding[3]);
            this.overTevCountDown.setTextSize(interV3TemplateData.getV3AutoCloseSP());
            this.overTevCountDown.setText(context.getString(R.string.close_tips, Integer.valueOf(interV3TemplateData.getAutoCloseTime())));
            return;
        }
        this.mClose.setVisibility(0);
        updOverClose(0);
        this.adCloseDelay = this.convertView.findViewById(R.id.ad_close_delay_area);
        int closeLoc = interV3TemplateData.getCloseLoc();
        if (closeLoc == 1) {
            ((RelativeLayout.LayoutParams) this.mClose.getLayoutParams()).addRule(20);
        } else if (closeLoc == 2) {
            ((RelativeLayout.LayoutParams) this.mClose.getLayoutParams()).addRule(21);
        } else if (closeLoc == 4) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mClose.getLayoutParams();
            layoutParams.addRule(20);
            layoutParams.addRule(6, R.id.inter_item_fill);
        } else if (closeLoc == 5) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mClose.getLayoutParams();
            layoutParams2.addRule(21);
            layoutParams2.addRule(6, R.id.inter_item_fill);
        }
        if (!interV3TemplateData.isAutoClose()) {
            this.closeBtn.setVisibility(0);
            this.countTextView.setVisibility(8);
            this.closeBtn.setImageResource(interV3TemplateData.getBlackCloseRes());
            return;
        }
        this.closeBtn.setVisibility(8);
        this.countTextView.setVisibility(0);
        ((RelativeLayout.LayoutParams) this.countTextView.getLayoutParams()).height = interV3TemplateData.getV3CloseSize(context);
        this.countTextView.setTextSize(interV3TemplateData.getV3AutoCloseSP());
        int[] v3ClosePadding2 = interV3TemplateData.getV3ClosePadding(context);
        this.countTextView.setPadding(v3ClosePadding2[0], v3ClosePadding2[1], v3ClosePadding2[2], v3ClosePadding2[3]);
        this.countTextView.setText(context.getString(R.string.close_tips, Integer.valueOf(interV3TemplateData.getAutoCloseTime())));
    }

    private void updateViewSize(InterV3TemplateData interV3TemplateData) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bottomArea.getLayoutParams();
        int i = interV3TemplateData.popWidth;
        layoutParams.width = i;
        layoutParams.height = (int) (((double) i) * 0.65d);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.animationArea.getLayoutParams();
        int i2 = (int) (((double) interV3TemplateData.popWidth) * 0.95d);
        int i3 = (int) (((double) i2) * 1.62d);
        layoutParams2.width = i2;
        layoutParams2.height = i3;
        layoutParams2.bottomMargin = interV3TemplateData.templateSize.animationBottom;
        int i4 = (int) (((double) i3) * 0.3d);
        RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.showArea.getLayoutParams();
        layoutParams3.width = i2;
        layoutParams3.height = (i2 * 9) / 16;
        layoutParams3.topMargin = i4;
        ((RelativeLayout.LayoutParams) this.showImageArea.getLayoutParams()).height = layoutParams3.height;
        ((RelativeLayout.LayoutParams) this.showImg.getLayoutParams()).height = layoutParams3.height;
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.adIcon.getLayoutParams();
        TemplateV3Size templateV3Size = interV3TemplateData.templateSize;
        int i5 = templateV3Size.logoSize;
        layoutParams4.width = i5;
        layoutParams4.height = i5;
        layoutParams4.topMargin = templateV3Size.iconTopMargin;
        this.adIcon.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.adIconName.getLayoutParams();
        layoutParams5.topMargin = interV3TemplateData.templateSize.titleTopMargin;
        this.adIconName.setLayoutParams(layoutParams5);
        this.adIconName.setTextSize(interV3TemplateData.templateSize.titleSP);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.adDes.getLayoutParams();
        layoutParams6.topMargin = interV3TemplateData.templateSize.desTopMargin;
        this.adDes.setLayoutParams(layoutParams6);
        this.adDes.setTextSize(interV3TemplateData.templateSize.desSP);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public View getCloseView(BaseTemplateData baseTemplateData) {
        startCloseDelay(baseTemplateData);
        if (!(baseTemplateData instanceof InterV3TemplateData)) {
            return this.closeBtn;
        }
        InterV3TemplateData interV3TemplateData = (InterV3TemplateData) baseTemplateData;
        if (interV3TemplateData.isCloseBottom()) {
            return interV3TemplateData.isAutoClose() ? this.overTevCountDown : this.overAdClose;
        }
        return interV3TemplateData.isAutoClose() ? this.countTextView : this.closeBtn;
    }

    /* JADX INFO: renamed from: lambda$startCloseDelay$0$com-yfanads-android-custom-view-AdInterV3ViewHolder, reason: not valid java name */
    /* synthetic */ void m1236x19e0ad32() {
        this.adCloseDelay.setVisibility(8);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void setInteractionVisible(int i) {
        this.actionView.setVisibility(i);
        this.animationSlideView.setVisibility(i);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void showStyleView(AdBaseViewHolder.Style style) {
        boolean z = style == AdBaseViewHolder.Style.TYPE_VIDEO;
        this.showImg.setVisibility(z ? 8 : 0);
        this.showImageArea.setVisibility(z ? 8 : 0);
        this.mediaViewFrame.setVisibility(z ? 0 : 8);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public boolean startCountDown(BaseTemplateData baseTemplateData) {
        if (baseTemplateData instanceof InterV3TemplateData) {
            return ((InterV3TemplateData) baseTemplateData).isAutoClose();
        }
        return false;
    }

    public void updOverClose(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.overCloseArea.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = i;
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateBarClickable(boolean z) {
        this.barView.setEnabled(z);
        this.animationClickView.setEnabled(z);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateCountDown(BaseTemplateData baseTemplateData, int i) {
        if ((baseTemplateData instanceof InterV3TemplateData) && ((InterV3TemplateData) baseTemplateData).isCloseBottom()) {
            TextView textView = this.overTevCountDown;
            textView.setText(textView.getContext().getString(R.string.close_tips, Integer.valueOf(i)));
        } else {
            TextView textView2 = this.countTextView;
            textView2.setText(textView2.getContext().getString(R.string.close_tips, Integer.valueOf(i)));
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateFeedView(BaseTemplateData baseTemplateData) {
        super.updateFeedView(baseTemplateData);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateInteraction(Context context, BaseTemplateData baseTemplateData) {
        if (baseTemplateData instanceof InterV3TemplateData) {
            InterV3TemplateData interV3TemplateData = (InterV3TemplateData) baseTemplateData;
            String[] activeStylePath = interV3TemplateData.getActiveStylePath();
            if (activeStylePath != null && activeStylePath.length >= 2) {
                updateBarView(activeStylePath[1], interV3TemplateData);
                updateActionView(activeStylePath[0], interV3TemplateData);
            } else {
                this.barView.setVisibility(8);
                this.actionView.setVisibility(8);
                this.animationClickView.setVisibility(8);
                this.animationSlideView.setVisibility(8);
            }
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateShowView(Context context, BaseTemplateData baseTemplateData) {
        try {
            if (baseTemplateData instanceof InterV3TemplateData) {
                InterV3TemplateData interV3TemplateData = (InterV3TemplateData) baseTemplateData;
                updateViewSize(interV3TemplateData);
                updateClose(context, interV3TemplateData);
                updateFeedView(interV3TemplateData);
                updateInteraction(context, interV3TemplateData);
                updateAnimation(interV3TemplateData);
                updTextColor(interV3TemplateData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AdInterV3ViewHolder(View view, ViewGroup viewGroup) {
        super(view);
        this.nativeAdContainer = viewGroup;
        this.animationArea = (RelativeLayout) view.findViewById(R.id.animator_area);
        this.bottomArea = (RelativeLayout) view.findViewById(R.id.bottom_area);
        this.showArea = (RelativeLayout) view.findViewById(R.id.inter_item_fill);
        this.overCloseArea = (RelativeLayout) view.findViewById(R.id.ad_close_over_area);
        this.overTevCountDown = (TextView) view.findViewById(R.id.over_tev_countdown);
        this.overAdClose = (ImageView) view.findViewById(R.id.over_ad_close);
        this.actonTitle = (TextView) view.findViewById(R.id.action_text_title);
        this.actonDes = (TextView) view.findViewById(R.id.action_text_title2);
        this.adIcon = (ImageView) view.findViewById(R.id.ad_icon);
        this.barView = (LottieAnimationView) view.findViewById(R.id.bar_lottie_view);
        this.actionView = (LottieAnimationView) view.findViewById(R.id.action_lottie_view);
        this.animationClickView = view.findViewById(R.id.bar_click_view);
        this.animationSlideView = view.findViewById(R.id.action_click_view);
        this.noClickView = view.findViewById(R.id.no_click_view);
        this.countTextView = (TextView) view.findViewById(R.id.tev_countdown);
        this.adIconName = (TextView) view.findViewById(R.id.ad_icon_name);
        this.adDes = (TextView) view.findViewById(R.id.ad_desc);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void setInteractionVisible(int i, int i2) {
        this.barView.setVisibility(i2);
        this.actionView.setVisibility(i);
        this.animationClickView.setVisibility(i2);
        this.animationSlideView.setVisibility(i);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateNativeView(BaseTemplateData baseTemplateData) {
        ViewGroup viewGroup = this.nativeAdContainer;
        if (viewGroup == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        layoutParams.width = baseTemplateData.popWidth;
        layoutParams.height = baseTemplateData.popHeight;
        ViewGroup.LayoutParams layoutParams2 = this.viewGroup.getLayoutParams();
        layoutParams2.width = baseTemplateData.popWidth;
        layoutParams2.height = baseTemplateData.popHeight;
    }
}
