package com.yfanads.android.adx.components.base;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alipay.sdk.widget.j;
import com.stub.StubApp;
import com.yfanads.android.adx.R;
import com.yfanads.android.adx.components.rewardvideo.AdxRewardVideoActivity;
import com.yfanads.android.adx.core.impl.AbstractNativeAd;
import com.yfanads.android.adx.player.yfplayer.IPlayVideo;
import com.yfanads.android.custom.view.BaseDialogFragment;
import com.yfanads.android.custom.view.CustomDialog;
import com.yfanads.android.custom.view.FeedbackDialog;
import com.yfanads.android.custom.view.OnFeedClickListener;
import com.yfanads.android.libs.thirdpart.lottie.LottieAnimationView;
import com.yfanads.android.libs.utils.YFOptional;
import com.yfanads.android.model.template.BaseTemplateData;
import com.yfanads.android.utils.ScreenUtil;
import com.yfanads.android.utils.ViewUtils;

/* JADX INFO: compiled from: BaseViewHolder.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ViewGroup f9572a;
    public final ImageView b;
    public final FrameLayout c;
    public final ImageView d;
    public final View e;
    public final View f;
    public final ImageView g;
    public final TextView h;
    public final ImageView i;
    public final ImageView j;
    public final TextView k;
    public final TextView l;
    public final LottieAnimationView m;
    public final LottieAnimationView n;
    public final View o;
    public final RelativeLayout p;
    public CustomDialog q;
    public boolean r;

    /* JADX INFO: compiled from: BaseViewHolder.java */
    public interface a {
    }

    public i(View view) {
        this.f9572a = (ViewGroup) view.findViewById(R.id.ad_container);
        this.b = (ImageView) view.findViewById(R.id.ad_image_blur);
        this.c = (FrameLayout) view.findViewById(R.id.media_view_frame);
        this.d = (ImageView) view.findViewById(R.id.imv_video_cover_image);
        this.e = view.findViewById(R.id.ad_image_click);
        this.f = view.findViewById(R.id.dy_click_view);
        this.g = (ImageView) view.findViewById(R.id.imv_close);
        this.h = (TextView) view.findViewById(R.id.compliance_content);
        this.i = (ImageView) view.findViewById(R.id.ad_log);
        this.j = (ImageView) view.findViewById(R.id.imv_app);
        this.k = (TextView) view.findViewById(R.id.tev_app_name);
        this.l = (TextView) view.findViewById(R.id.tev_app_introduce);
        this.m = (LottieAnimationView) view.findViewById(R.id.animation_view2);
        this.n = (LottieAnimationView) view.findViewById(R.id.animation_view);
        this.o = view.findViewById(R.id.animation_slide_view);
        this.p = (RelativeLayout) view.findViewById(R.id.feed_area);
    }

    public static void b(CustomDialog customDialog, a aVar, View view) {
        if (com.yfanads.android.adx.utils.b.b()) {
            customDialog.dismiss();
            AdxRewardVideoActivity adxRewardVideoActivity = ((com.yfanads.android.adx.components.rewardvideo.d) aVar).f9584a;
            int i = AdxRewardVideoActivity.w;
            adxRewardVideoActivity.k();
        }
    }

    public final void a(final FragmentManager fragmentManager, final OnFeedClickListener onFeedClickListener) {
        if (com.yfanads.android.adx.utils.b.b()) {
            YFOptional.ofNullable(fragmentManager).ifPresentRun(new YFOptional.Consumer() { // from class: com.yfanads.android.adx.components.base.i$$ExternalSyntheticLambda2
                @Override // com.yfanads.android.libs.utils.YFOptional.Consumer
                public final void accept(Object obj) {
                    this.f$0.a(onFeedClickListener, fragmentManager, (FragmentManager) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final OnFeedClickListener onFeedClickListener, final FragmentManager fragmentManager, FragmentManager fragmentManager2) {
        this.p.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.base.i$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.a(onFeedClickListener, fragmentManager, view);
            }
        });
    }

    public static /* synthetic */ void a(OnFeedClickListener onFeedClickListener, FragmentManager fragmentManager, View view) {
        FeedbackDialog feedbackDialog = new FeedbackDialog();
        feedbackDialog.setOnFeedClickListener(onFeedClickListener);
        feedbackDialog.show(fragmentManager, "com/yfanads/ads/channel/adx");
    }

    public static void a(ImageView imageView, int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        if (i2 == 0) {
            i2 = 1;
        }
        if ((i * 100) / i2 > (i3 * 100) / i4) {
            ViewUtils.setViewSize(imageView, (int) ((((double) i3) / ((double) i4)) * ((double) i2)), i2);
        } else {
            ViewUtils.setViewSize(imageView, i, (int) ((((double) i4) / ((double) i3)) * ((double) i)));
        }
    }

    public final void a(AbstractNativeAd abstractNativeAd) {
        if (abstractNativeAd != null) {
            String productName = TextUtils.isEmpty(abstractNativeAd.getTitle()) ? abstractNativeAd.getProductName() : abstractNativeAd.getTitle();
            String title = TextUtils.isEmpty(abstractNativeAd.getAdDescription()) ? abstractNativeAd.getTitle() : abstractNativeAd.getAdDescription();
            String appIconUrl = abstractNativeAd.getAppIconUrl();
            if (!TextUtils.isEmpty(productName)) {
                this.k.setText(productName);
            }
            if (!TextUtils.isEmpty(appIconUrl)) {
                ViewUtils.loadCircleImage(appIconUrl, this.j, 8);
            }
            if (!TextUtils.isEmpty(title)) {
                this.l.setText(title);
            }
            this.i.setImageResource(abstractNativeAd.getAdSourceLogoUrl(1));
        }
    }

    public final void a(Context context, AbstractNativeAd abstractNativeAd) {
        if (abstractNativeAd != null) {
            int interactionType = abstractNativeAd.getInteractionType();
            String appName = abstractNativeAd.getAppName();
            String appVersion = abstractNativeAd.getAppVersion();
            String corporationName = abstractNativeAd.getCorporationName();
            String introductionInfoUrl = abstractNativeAd.getIntroductionInfoUrl();
            String permissionInfoUrl = abstractNativeAd.getPermissionInfoUrl();
            String appPrivacyUrl = abstractNativeAd.getAppPrivacyUrl();
            if (interactionType == 1) {
                com.yfanads.android.adx.components.model.b bVar = new com.yfanads.android.adx.components.model.b(appName, appVersion, corporationName, introductionInfoUrl, permissionInfoUrl, appPrivacyUrl);
                String str = String.format(context.getString(R.string.yf_compliance_content), appName, appVersion, corporationName);
                SpannableString spannableString = new SpannableString(str);
                String string = context.getString(R.string.yf_function);
                int iIndexOf = str.indexOf(string);
                String string2 = context.getString(R.string.yf_permission);
                int iIndexOf2 = str.indexOf(string2);
                String string3 = context.getString(R.string.yf_privacy);
                int iIndexOf3 = str.indexOf(string3);
                int length = spannableString.length();
                com.yfanads.android.adx.utils.a.a(" complianceView index = " + iIndexOf + " , " + iIndexOf2 + " , " + iIndexOf3 + " , maxLength = " + length);
                int length2 = string.length();
                if (iIndexOf3 >= 0 && length2 + iIndexOf3 <= length) {
                    spannableString.setSpan(new f(context, bVar), iIndexOf, string.length() + iIndexOf, 33);
                    spannableString.setSpan(new UnderlineSpan(), iIndexOf, string.length() + iIndexOf, 34);
                }
                int length3 = string2.length();
                if (iIndexOf2 >= 0 && length3 + iIndexOf2 <= length) {
                    spannableString.setSpan(new g(context, bVar), iIndexOf2, string2.length() + iIndexOf2, 33);
                    spannableString.setSpan(new UnderlineSpan(), iIndexOf2, string2.length() + iIndexOf2, 34);
                }
                int length4 = string3.length();
                if (iIndexOf3 >= 0 && length4 + iIndexOf3 <= length) {
                    spannableString.setSpan(new h(context, bVar), iIndexOf3, string3.length() + iIndexOf3, 33);
                    spannableString.setSpan(new UnderlineSpan(), iIndexOf3, string3.length() + iIndexOf3, 34);
                }
                this.h.setVisibility(0);
                this.h.setText(spannableString);
                this.h.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            this.h.setVisibility(8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:50:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:54:? A[RETURN, SYNTHETIC] */
    public final void a(Context context, BaseVideoTemplateData baseVideoTemplateData) {
        int i;
        String[] activeStylePath = baseVideoTemplateData.getActiveStylePath();
        if (activeStylePath != null && activeStylePath.length >= 2) {
            String str = activeStylePath[0];
            String str2 = activeStylePath[1];
            int i2 = -1;
            if (!TextUtils.isEmpty(str2)) {
                this.n.setVisibility(0);
                this.n.setAnimation(str2);
                this.n.setRepeatCount(-1);
                this.n.playAnimation();
            } else {
                this.n.setVisibility(8);
            }
            if (!TextUtils.isEmpty(str)) {
                this.o.setVisibility(0);
                this.m.setVisibility(0);
                this.m.setAnimation(str);
                this.m.setRepeatCount(-1);
                this.m.playAnimation();
                BaseTemplateData.InteractiveStyle activeStyle = baseVideoTemplateData.getActiveStyle();
                if (activeStyle == BaseTemplateData.InteractiveStyle.SLIDE || activeStyle == BaseTemplateData.InteractiveStyle.CLICK_SLIDE) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.getScreenHeight(context) / 3);
                    layoutParams.addRule(8, R.id.animation_view2);
                    this.o.setLayoutParams(layoutParams);
                    this.o.setVisibility(0);
                } else {
                    this.o.setVisibility(8);
                }
            } else {
                this.o.setVisibility(4);
                this.m.setVisibility(4);
            }
            if (baseVideoTemplateData.getActiveStyle() != BaseTemplateData.InteractiveStyle.CLICK) {
                i = 66;
                if (baseVideoTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_TWIST || baseVideoTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.TWIST) {
                    i2 = 105;
                } else if (baseVideoTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_SHAKE || baseVideoTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SHAKE) {
                    i2 = 96;
                } else if (baseVideoTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.CLICK_SLIDE || baseVideoTemplateData.getActiveStyle() == BaseTemplateData.InteractiveStyle.SLIDE) {
                    i2 = 120;
                } else if (baseVideoTemplateData.getActiveStyle() != BaseTemplateData.InteractiveStyle.CLICK_NOT_HAS_FINGER) {
                    i = -1;
                }
                if (i2 > 0) {
                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                    layoutParams2.bottomMargin = ScreenUtil.dip2px(context, i2);
                    this.m.setLayoutParams(layoutParams2);
                }
                if (i > 0) {
                    RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                    layoutParams3.bottomMargin = ScreenUtil.dip2px(context, i);
                    this.n.setLayoutParams(layoutParams3);
                    return;
                }
                return;
            }
            i2 = 91;
            i = 133;
            if (i2 > 0) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
                layoutParams4.bottomMargin = ScreenUtil.dip2px(context, i2);
                this.m.setLayoutParams(layoutParams4);
            }
            if (i > 0) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams5.bottomMargin = ScreenUtil.dip2px(context, i);
                this.n.setLayoutParams(layoutParams5);
                return;
            }
            return;
        }
        this.o.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(8);
    }

    public final void a() {
        this.g.setVisibility(0);
    }

    public final void a(final Activity activity, final long j, final com.yfanads.android.adx.components.rewardvideo.d dVar) {
        CustomDialog customDialogBindData = new CustomDialog.CustomDialogBuilder().setLayoutId(R.layout.dialog_exit_layout).setSize(-2, -2).setGravity(17).build().bindData(new BaseDialogFragment.DialogBindData() { // from class: com.yfanads.android.adx.components.base.i$$ExternalSyntheticLambda1
            @Override // com.yfanads.android.custom.view.BaseDialogFragment.DialogBindData
            public final void bindViewData(View view) {
                this.f$0.a(activity, j, dVar, view);
            }
        });
        this.q = customDialogBindData;
        customDialogBindData.setCancelable(true);
        this.q.show(activity.getFragmentManager(), j.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, long j, a aVar, View view) {
        a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), view, this.q, j, aVar);
    }

    public static void a(Context context, View view, final CustomDialog customDialog, long j, final a aVar) {
        TextView textView = (TextView) view.findViewById(R.id.tev_content);
        TextView textView2 = (TextView) view.findViewById(R.id.tev_cancel);
        TextView textView3 = (TextView) view.findViewById(R.id.tev_determine);
        textView.setText(String.format(context.getString(R.string.adx_jump_receive_reward_tips2), Long.valueOf(j)));
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.base.i$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.a(customDialog, aVar, view2);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.yfanads.android.adx.components.base.i$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                i.b(customDialog, aVar, view2);
            }
        });
    }

    public static void a(CustomDialog customDialog, a aVar, View view) {
        if (com.yfanads.android.adx.utils.b.b()) {
            customDialog.dismiss();
            AdxRewardVideoActivity adxRewardVideoActivity = ((com.yfanads.android.adx.components.rewardvideo.d) aVar).f9584a;
            int i = AdxRewardVideoActivity.w;
            adxRewardVideoActivity.getClass();
            try {
                AbstractNativeAd abstractNativeAd = adxRewardVideoActivity.c;
                if (abstractNativeAd != null) {
                    abstractNativeAd.reStartInteraction();
                }
            } catch (Exception e) {
                e.a(e, new StringBuilder("reStartTwistOrShake "));
            }
            com.yfanads.android.adx.utils.b.j -= 1000;
            adxRewardVideoActivity.b(adxRewardVideoActivity.g);
            adxRewardVideoActivity.a(adxRewardVideoActivity.h);
            IPlayVideo iPlayVideo = adxRewardVideoActivity.k;
            if (iPlayVideo != null) {
                iPlayVideo.reStart();
            }
        }
    }
}
