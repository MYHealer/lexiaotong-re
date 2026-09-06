package com.yfanads.android.custom.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.yfanads.ads.R;
import com.yfanads.android.core.f;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.libs.utils.Util;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.DownloadAppInfo;
import com.yfanads.android.model.YFAdsPhone;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.model.template.SplashTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;
import com.yfanads.android.utils.YFLog;
import com.yfanads.android.utils.YFUtil;
import java.lang.ref.SoftReference;
import java.util.Arrays;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class AdSplashViewHolder extends AdBaseViewHolder {
    private static final String TAG = "AdxSplashViewHolder";
    public LottieAnimationView actionView;
    public View actionViewBig;
    public RelativeLayout actionViewBigArea;
    public ImageView actionViewIcon;
    public LottieAnimationView actionViewSlide;
    public TextView actionViewTitle;
    public TextView actonDes;
    public TextView actonTitle;
    public View adCloseDelay;
    public TextView adDes;
    public TextView adIconNameSmall;
    public ImageView adIconSmall;
    public View animationSlideView;
    private AnimatorSet animatorSet;
    public LottieAnimationView barView;
    public String closeTips;
    public RelativeLayout contentArea;
    public RelativeLayout contentResArea;
    public TextView tevCountdown;
    public RelativeLayout topArea;
    public View topViewBgV2;

    public static final class AnimationListener extends AnimatorListenerAdapter {
        private final SoftReference<AdSplashViewHolder> mSoftReference;

        public AnimationListener(AdSplashViewHolder adSplashViewHolder) {
            this.mSoftReference = new SoftReference<>(adSplashViewHolder);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.mSoftReference.get() != null) {
                this.mSoftReference.get().startAnimation();
            }
        }
    }

    public enum Style {
        TYPE_VIDEO,
        TYPE_IMG
    }

    public AdSplashViewHolder(View view, SplashTemplateData splashTemplateData) {
        super(view);
        this.adIconSmall = (ImageView) view.findViewById(R.id.ad_icon_small);
        this.adIconNameSmall = (TextView) view.findViewById(R.id.ad_icon_name_small);
        this.dyClickView = view.findViewById(R.id.dy_click_view);
        TextView textView = (TextView) view.findViewById(R.id.tev_countdown);
        this.tevCountdown = textView;
        textView.setVisibility(8);
        this.animationSlideView = view.findViewById(R.id.animation_slide_view);
        this.actionView = (LottieAnimationView) view.findViewById(R.id.animation_view2);
        this.barView = (LottieAnimationView) view.findViewById(R.id.animation_view);
        if (splashTemplateData.isTemplateV2()) {
            this.adCloseDelay = view.findViewById(R.id.ad_close_delay_area);
            this.adDes = (TextView) view.findViewById(R.id.ad_desc_small);
            this.actonTitle = (TextView) view.findViewById(R.id.action_text_title);
            this.actonDes = (TextView) view.findViewById(R.id.action_text_title2);
            this.topArea = (RelativeLayout) view.findViewById(R.id.inter_v2_small_style);
            this.contentArea = (RelativeLayout) view.findViewById(R.id.ad_content);
            this.contentResArea = (RelativeLayout) view.findViewById(R.id.content_resource);
            this.actionViewBigArea = (RelativeLayout) view.findViewById(R.id.animation_view_big_area);
            this.actionViewBig = view.findViewById(R.id.animation_view_big);
            this.actionViewIcon = (ImageView) view.findViewById(R.id.ad_action_icon);
            this.actionViewTitle = (TextView) view.findViewById(R.id.action_text_title_big);
            this.actionViewSlide = (LottieAnimationView) view.findViewById(R.id.action_animation_slide);
            this.topViewBgV2 = view.findViewById(R.id.top_background);
        }
    }

    private boolean hasSlide(BaseTemplateData.InteractiveStyle interactiveStyle) {
        return interactiveStyle == BaseTemplateData.InteractiveStyle.SLIDE || interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE;
    }

    private void hideView() {
        this.animationSlideView.setVisibility(8);
        this.barView.setVisibility(8);
        this.actionView.setVisibility(8);
    }

    private void startCloseDelay(BaseTemplateData baseTemplateData) {
        View view;
        baseTemplateData.setCloseShowTime(System.currentTimeMillis());
        if (!baseTemplateData.isSupportClose() || (view = this.adCloseDelay) == null) {
            return;
        }
        view.setVisibility(0);
        YFUtil.MAIN_HANDLER.postDelayed(new Runnable() { // from class: com.yfanads.android.custom.view.AdSplashViewHolder$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m1242xf0e68a50();
            }
        }, baseTemplateData.getCloseDelay());
    }

    private void updateAnimator(final Context context) {
        try {
            this.actionViewBigArea.setVisibility(0);
            this.actionViewBig.post(new Runnable() { // from class: com.yfanads.android.custom.view.AdSplashViewHolder$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1243x3de20371(context);
                }
            });
        } catch (Exception e) {
            f.a(e, new StringBuilder("updateAnimator : "));
        }
    }

    private void updateClickSize(Context context, BaseTemplateData baseTemplateData) {
        float clickRatio = baseTemplateData.getClickRatio();
        int screenWidth = (int) (ScreenUtil.getScreenWidth(context) * clickRatio);
        int screenHeight = (int) (ScreenUtil.getScreenHeight(context) * clickRatio);
        YFLog.debug("updateClickSize width = " + screenWidth + " , height = " + screenHeight + " , clickRatio " + clickRatio);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(screenWidth, screenHeight);
        layoutParams.addRule(13);
        this.dyClickView.setLayoutParams(layoutParams);
    }

    public void complianceView(final Context context, final DownloadAppInfo downloadAppInfo) {
        String str = String.format(context.getString(R.string.yf_compliance_content), downloadAppInfo.appName, downloadAppInfo.versionCode, downloadAppInfo.developerName);
        SpannableString spannableString = new SpannableString(str);
        String string = context.getString(R.string.yf_function);
        int iIndexOf = str.indexOf(string);
        String string2 = context.getString(R.string.yf_permission);
        int iIndexOf2 = str.indexOf(string2);
        String string3 = context.getString(R.string.yf_privacy);
        int iIndexOf3 = str.indexOf(string3);
        int length = spannableString.length();
        if (isInMaxLength(iIndexOf3, string.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.view.AdSplashViewHolder.1
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    Util.openLink(context, downloadAppInfo.functionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf, string.length() + iIndexOf, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf, string.length() + iIndexOf, 34);
        }
        if (isInMaxLength(iIndexOf2, string2.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.view.AdSplashViewHolder.2
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    Util.openLink(context, downloadAppInfo.appPermissionLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf2, string2.length() + iIndexOf2, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf2, string2.length() + iIndexOf2, 34);
        }
        if (isInMaxLength(iIndexOf3, string3.length(), length)) {
            spannableString.setSpan(new ClickableSpan() { // from class: com.yfanads.android.custom.view.AdSplashViewHolder.3
                @Override // android.text.style.ClickableSpan
                public void onClick(View view) {
                    Util.openLink(context, downloadAppInfo.appPrivacyLink);
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public void updateDrawState(TextPaint textPaint) {
                    textPaint.setUnderlineText(false);
                }
            }, iIndexOf3, string3.length() + iIndexOf3, 33);
            spannableString.setSpan(new UnderlineSpan(), iIndexOf3, string3.length() + iIndexOf3, 34);
        }
        setComplianceContent(spannableString);
    }

    public void destroy() {
        stopAnimation();
    }

    public int[] getActionBigRes(BaseTemplateData.InteractiveStyle interactiveStyle) {
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.SHAKE) {
            return new int[]{R.string.yf_big_shake, R.mipmap.yf_shake_icon};
        }
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SHAKE) {
            return new int[]{R.string.yf_big_shake_click, R.mipmap.yf_shake_icon};
        }
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.TWIST) {
            return new int[]{R.string.yf_big_twist, R.mipmap.yf_twist_icon};
        }
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_TWIST) {
            return new int[]{R.string.yf_big_twist_click, R.mipmap.yf_twist_icon};
        }
        if (interactiveStyle == BaseTemplateData.InteractiveStyle.SLIDE) {
            return new int[]{R.string.yf_big_slide, -1};
        }
        return interactiveStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE ? new int[]{R.string.yf_big_slide_click, -1} : new int[]{R.string.yf_click, -1};
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public View getCloseView(BaseTemplateData baseTemplateData) {
        startCloseDelay(baseTemplateData);
        return this.tevCountdown;
    }

    public boolean isInMaxLength(int i, int i2, int i3) {
        return i >= 0 && i + i2 <= i3;
    }

    /* JADX INFO: renamed from: lambda$startCloseDelay$0$com-yfanads-android-custom-view-AdSplashViewHolder, reason: not valid java name */
    /* synthetic */ void m1242xf0e68a50() {
        this.adCloseDelay.setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$updateAnimator$2$com-yfanads-android-custom-view-AdSplashViewHolder, reason: not valid java name */
    /* synthetic */ void m1243x3de20371(Context context) {
        float f = -ScreenUtil.dip2px(context, 30.0f);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.actionViewBig, "translationY", 0.0f, f);
        objectAnimatorOfFloat.setDuration(445L);
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.actionViewBig, "translationY", f, 0.0f);
        objectAnimatorOfFloat2.setDuration(355L);
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.actionViewBig, "translationY", 0.0f, 0.0f);
        objectAnimatorOfFloat3.setDuration(200L);
        objectAnimatorOfFloat3.setInterpolator(new LinearInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        this.animatorSet = animatorSet;
        animatorSet.playSequentially(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        this.animatorSet.addListener(new AnimationListener(this));
        startAnimation();
    }

    /* JADX INFO: renamed from: lambda$updateTopView$1$com-yfanads-android-custom-view-AdSplashViewHolder, reason: not valid java name */
    /* synthetic */ void m1244xee3e9a4b(Context context, SplashTemplateData splashTemplateData, boolean z) {
        int top = this.contentArea.getTop();
        int iDip2px = ScreenUtil.dip2px(context, 145.0f);
        boolean z2 = top > iDip2px && splashTemplateData.isShowTopArea(z);
        YFLog.high("updateTopView top = " + top + " , marginTB = " + iDip2px + " , isShowTop = " + z2);
        this.topArea.setVisibility(z2 ? 0 : 8);
        if (!YFAdsPhone.getInstance().isTablet()) {
            this.topViewBgV2.setVisibility(8);
        } else if (z) {
            this.topViewBgV2.setBackgroundResource(R.mipmap.yf_splash_bottom_bg);
        } else {
            this.topViewBgV2.setVisibility(8);
        }
    }

    public void setComplianceContent(SpannableString spannableString) {
        this.complianceContent.setVisibility(0);
        this.complianceContent.setText(spannableString);
        TextView textView = this.complianceContent;
        textView.setTextColor(textView.getResources().getColor(R.color.ad_color_66000000));
        this.complianceContent.setTextSize(6.0f);
        this.complianceContent.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void setComplianceContentColor(final int i) {
        YFOptional.ofNullable(this.complianceContent).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.android.custom.view.AdSplashViewHolder$$ExternalSyntheticLambda1
            @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
            public final void accept(Object obj) {
                ((TextView) obj).setTextColor(i);
            }
        });
    }

    public void setComplianceGone() {
        this.complianceContent.setVisibility(8);
    }

    public void setTevCountdown(String str) {
        this.tevCountdown.setVisibility(0);
        this.tevCountdown.setText(str);
    }

    public void showJumpStyle(Context context, SplashTemplateData splashTemplateData) {
        this.closeBtn.setVisibility(8);
        int closeLoc = splashTemplateData.getCloseLoc();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mClose.getLayoutParams();
        int iDip2px = ScreenUtil.dip2px(context, 15.0f);
        int iDip2px2 = ScreenUtil.dip2px(context, 35.0f);
        if (closeLoc == 1) {
            layoutParams.addRule(20);
            layoutParams.setMargins(iDip2px, iDip2px2, 0, 0);
        } else if (closeLoc == 2) {
            layoutParams.addRule(21);
            layoutParams.setMargins(0, iDip2px2, iDip2px, 0);
        }
        layoutParams.height = splashTemplateData.getV3CloseSize(context);
        int[] v3ClosePadding = splashTemplateData.getV3ClosePadding(context);
        this.tevCountdown.setPadding(v3ClosePadding[0], v3ClosePadding[1], v3ClosePadding[2], v3ClosePadding[3]);
        this.tevCountdown.setTextSize(splashTemplateData.getV3AutoCloseSP());
        int autoCloseTime = splashTemplateData.getAutoCloseTime(5);
        this.closeTips = context.getString(R.string.close_tips);
        this.tevCountdown.setText(context.getString(R.string.close_tips, Integer.valueOf(autoCloseTime)));
    }

    public void showStyleView(Style style) {
        showStyleView(style, true);
    }

    public void stopAnimation() {
        YFLog.debug("stopCountDown");
        this.barView.cancelAnimation();
        this.actionView.cancelAnimation();
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.animatorSet.removeAllListeners();
            this.animatorSet = null;
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updBgRadius() {
        ViewUtils.setRadius(this.showImageArea, 20);
        ViewUtils.setRadius(this.showImg, 20);
    }

    public void updateActionView(Context context, String str, SplashTemplateData splashTemplateData) {
        if (TextUtils.isEmpty(str)) {
            this.animationSlideView.setVisibility(4);
            this.actionView.setVisibility(4);
            if (splashTemplateData.isTemplateV2()) {
                this.actonTitle.setVisibility(4);
                this.actonDes.setVisibility(4);
                return;
            }
            return;
        }
        this.animationSlideView.setVisibility(0);
        this.actionView.setVisibility(0);
        this.actionView.setAnimation(str);
        this.actionView.setRepeatCount(-1);
        this.actionView.playAnimation();
        if (!hasSlide(splashTemplateData.getActiveStyle())) {
            BaseTemplateData.InteractiveStyle activeStyle = splashTemplateData.getActiveStyle();
            this.animationSlideView.setVisibility(4);
            if (splashTemplateData.isTemplateV2()) {
                this.actonTitle.setVisibility(0);
                this.actonTitle.setText(getActionRes(activeStyle));
                this.actonDes.setVisibility(0);
                return;
            }
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.getScreenHeight(context) / 3);
        if (splashTemplateData.isTemplateV2()) {
            layoutParams.addRule(2, R.id.feed_area);
        } else {
            layoutParams.addRule(8, R.id.animation_view2);
        }
        this.animationSlideView.setLayoutParams(layoutParams);
        this.animationSlideView.setVisibility(0);
        if (splashTemplateData.isTemplateV2()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ScreenUtil.dip2px(context, 47.0f), ScreenUtil.dip2px(context, 148.0f));
            this.actionView.setLayoutParams(layoutParams2);
            layoutParams2.addRule(2, R.id.action_text_title);
            layoutParams2.addRule(14);
            BaseTemplateData.InteractiveStyle activeStyle2 = splashTemplateData.getActiveStyle();
            this.actonTitle.setVisibility(0);
            this.actonTitle.setText(getActionRes(activeStyle2));
            this.actonDes.setVisibility(0);
        }
    }

    public void updateAnimaMargin(Context context, BaseTemplateData baseTemplateData) {
        int i;
        int i2 = 103;
        if (baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK) {
            i = 61;
        } else {
            if (baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_TWIST || baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.TWIST) {
                i = 75;
            } else if (baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_SHAKE || baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SHAKE) {
                i = 66;
            } else if (baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_SLIDE || baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SLIDE) {
                i = 90;
            } else if (baseTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER) {
                i = -1;
            } else {
                i = -1;
                i2 = -1;
            }
            i2 = 36;
        }
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.actionView.getLayoutParams();
            layoutParams.bottomMargin = ScreenUtil.dip2px(context, i);
            this.actionView.setLayoutParams(layoutParams);
        }
        if (i2 > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.barView.getLayoutParams();
            layoutParams2.bottomMargin = ScreenUtil.dip2px(context, i2);
            this.barView.setLayoutParams(layoutParams2);
        }
    }

    public void updateBarView(String str, boolean z) {
        if (TextUtils.isEmpty(str) || !z) {
            this.barView.setVisibility(8);
            return;
        }
        this.barView.setVisibility(0);
        this.barView.setAnimation(str);
        this.barView.setRepeatCount(-1);
        this.barView.playAnimation();
    }

    public void updateBigActionView(Context context, SplashTemplateData splashTemplateData) {
        int i;
        try {
            hideView();
            updateAnimator(context);
            BaseTemplateData.InteractiveStyle activeStyle = splashTemplateData.getActiveStyle();
            int[] actionBigRes = getActionBigRes(activeStyle);
            if (actionBigRes != null && actionBigRes.length >= 2) {
                TextView textView = this.actionViewTitle;
                if (textView != null) {
                    textView.setText(actionBigRes[0]);
                }
                if (activeStyle != BaseTemplateData.InteractiveStyle.SLIDE && activeStyle != BaseTemplateData.InteractiveStyle.CLICK_SLIDE) {
                    LottieAnimationView lottieAnimationView = this.actionViewSlide;
                    if (lottieAnimationView != null) {
                        lottieAnimationView.setVisibility(8);
                    }
                    ImageView imageView = this.actionViewIcon;
                    if (imageView == null || (i = actionBigRes[1]) == -1) {
                        return;
                    }
                    imageView.setImageResource(i);
                    return;
                }
                LottieAnimationView lottieAnimationView2 = this.actionViewSlide;
                if (lottieAnimationView2 != null) {
                    lottieAnimationView2.setVisibility(0);
                    this.actionViewSlide.setVisibility(0);
                    this.actionViewSlide.setAnimation("slide/action_splash_big.json");
                    this.actionViewSlide.setRepeatCount(-1);
                    this.actionViewSlide.playAnimation();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateClose(Context context, SplashTemplateData splashTemplateData, boolean z) {
        this.closeBtn.setVisibility(8);
        int closeLoc = splashTemplateData.getCloseLoc();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mClose.getLayoutParams();
        int iDip2px = z ? ScreenUtil.dip2px(context, 35.0f) : ScreenUtil.dip2px(context, 15.0f);
        int iDip2px2 = ScreenUtil.dip2px(context, 35.0f);
        if (closeLoc == 1) {
            layoutParams.addRule(20);
            layoutParams.setMargins(iDip2px, iDip2px2, 0, 0);
        } else if (closeLoc == 2) {
            layoutParams.addRule(21);
            layoutParams.setMargins(0, iDip2px2, iDip2px, 0);
        } else if (closeLoc == 6) {
            layoutParams.addRule(20);
            layoutParams.addRule(8, R.id.action_text_title2);
            layoutParams.setMarginStart(iDip2px);
        } else {
            layoutParams.addRule(21);
            layoutParams.addRule(8, R.id.action_text_title2);
            layoutParams.setMarginEnd(iDip2px);
        }
        int v3CloseSize = splashTemplateData.getV3CloseSize(context);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.tevCountdown.getLayoutParams();
        layoutParams2.height = v3CloseSize;
        layoutParams2.width = (int) (((double) v3CloseSize) * 2.55d);
        this.tevCountdown.setPadding(0, 0, 0, 0);
        this.tevCountdown.setTextSize(splashTemplateData.getV3AutoCloseSP());
        this.tevCountdown.setGravity(17);
        int autoCloseTime = splashTemplateData.getAutoCloseTime(5);
        this.closeTips = context.getString(R.string.yf_skip_tips);
        this.tevCountdown.setText(context.getString(R.string.yf_skip_tips, Integer.valueOf(autoCloseTime)));
    }

    public void updateContentView(Context context, boolean z) {
        boolean zIsTablet = YFAdsPhone.getInstance().isTablet();
        if (!zIsTablet) {
            int screenWidth = ScreenUtil.getScreenWidth(context);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.contentArea.getLayoutParams();
            int i = (int) (((double) screenWidth) * 0.86d);
            layoutParams.width = i;
            layoutParams.height = (i * 5) / 3;
            this.contentArea.setLayoutParams(layoutParams);
            int iDip2px = ScreenUtil.dip2px(context, 20.0f);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.contentResArea.getLayoutParams();
            int i2 = i - iDip2px;
            layoutParams2.height = i2;
            layoutParams2.width = i2;
            this.contentResArea.setLayoutParams(layoutParams2);
        } else if (z) {
            int screenHeight = ScreenUtil.getScreenHeight(context);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.contentArea.getLayoutParams();
            int i3 = (int) (((double) screenHeight) * 0.75d);
            int i4 = (int) (((double) i3) * 1.4d);
            layoutParams3.width = i4;
            layoutParams3.height = i3;
            this.contentArea.setLayoutParams(layoutParams3);
            int iDip2px2 = ScreenUtil.dip2px(context, 10.0f);
            RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.contentResArea.getLayoutParams();
            int i5 = i4 - iDip2px2;
            layoutParams4.width = i5;
            layoutParams4.height = (i5 * 9) / 16;
            this.contentResArea.setLayoutParams(layoutParams4);
        } else {
            int screenWidth2 = ScreenUtil.getScreenWidth(context);
            RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.contentArea.getLayoutParams();
            int i6 = (int) (((double) screenWidth2) * 0.86d);
            layoutParams5.width = i6;
            layoutParams5.height = (int) (((double) i6) * 1.6d);
            this.contentArea.setLayoutParams(layoutParams5);
            int iDip2px3 = ScreenUtil.dip2px(context, 20.0f);
            RelativeLayout.LayoutParams layoutParams6 = (RelativeLayout.LayoutParams) this.contentResArea.getLayoutParams();
            int i7 = i6 - iDip2px3;
            layoutParams6.height = i7;
            layoutParams6.width = i7;
            this.contentResArea.setLayoutParams(layoutParams6);
        }
        if (zIsTablet) {
            this.contentArea.setBackgroundResource(R.drawable.inter_v3_bg);
        }
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateInteraction(Context context, BaseTemplateData baseTemplateData) {
        if (baseTemplateData instanceof SplashTemplateData) {
            SplashTemplateData splashTemplateData = (SplashTemplateData) baseTemplateData;
            if (splashTemplateData.isTemplateV2() && splashTemplateData.isBigStyle()) {
                updateBigActionView(context, splashTemplateData);
                return;
            }
            String[] activeStylePath = splashTemplateData.getActiveStylePath();
            YFLog.info("updateInteraction " + Arrays.toString(activeStylePath));
            if (activeStylePath == null || activeStylePath.length < 2) {
                YFLog.debug("updateInteraction error activityPath==null || activityPath.length<2");
                hideView();
            } else {
                String str = activeStylePath[0];
                updateBarView(activeStylePath[1], splashTemplateData.isTemplateV2() || splashTemplateData.isShowBtn());
                updateActionView(context, str, splashTemplateData);
            }
        }
    }

    public void updateTopView(final SplashTemplateData splashTemplateData, final boolean z) {
        if (splashTemplateData.isTemplateV2()) {
            final Context context = this.convertView.getContext();
            this.contentArea.post(new Runnable() { // from class: com.yfanads.android.custom.view.AdSplashViewHolder$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.m1244xee3e9a4b(context, splashTemplateData, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAnimation() {
        AnimatorSet animatorSet = this.animatorSet;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void showStyleView(Style style, boolean z) {
        if (z) {
            updBgRadius();
        }
        boolean z2 = style == Style.TYPE_VIDEO;
        this.showImg.setVisibility(z2 ? 8 : 0);
        this.showImageArea.setVisibility(z2 ? 8 : 0);
        this.mediaViewFrame.setVisibility(z2 ? 0 : 8);
    }

    @Override // com.yfanads.android.custom.view.AdBaseViewHolder
    public void updateBarClickable(boolean z) {
        LottieAnimationView lottieAnimationView = this.barView;
        if (lottieAnimationView != null) {
            lottieAnimationView.setEnabled(z);
        }
        LottieAnimationView lottieAnimationView2 = this.actionView;
        if (lottieAnimationView2 != null) {
            lottieAnimationView2.setEnabled(z);
        }
        RelativeLayout relativeLayout = this.actionViewBigArea;
        if (relativeLayout != null) {
            relativeLayout.setEnabled(z);
        }
    }
}
