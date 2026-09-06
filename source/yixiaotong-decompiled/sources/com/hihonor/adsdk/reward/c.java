package com.hihonor.adsdk.reward;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Video;
import com.hihonor.adsdk.base.callback.AdListener;
import com.hihonor.adsdk.base.g.j.d.f;
import com.hihonor.adsdk.base.j.j;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.widget.base.e;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.base.widget.web.WebPermissionsActivity;
import com.hihonor.adsdk.common.f.b0;
import com.hihonor.adsdk.common.f.u;
import java.text.MessageFormat;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f3559a = "RewardUtil";
    private static final String b = "00";
    private static final String c = ":";
    private static final String d = "v";
    private static final int e = 8;

    public static boolean a(Video video) {
        if (!Objects.isNull(video)) {
            return video.getVideoWidth() >= video.getVideoHeight();
        }
        com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "isHorizontalVideo,video is invalid", new Object[0]);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view, View view2) {
        b0.hnadsb(view.getResources().getString(R.string.ads_developer_not_provide_privacy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(View view, View view2) {
        b0.hnadsb(view.getResources().getString(R.string.ads_reserve_developer_not_provide_privacy));
    }

    public static void d(final View view, final BaseAd baseAd, boolean z) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initPrivacyText,rootView is null", new Object[0]);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ad_reward_privacy);
        if (textView == null || Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initPrivacyText,view or baseAd is null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(baseAd.getPrivacyAgreementUrl())) {
            textView.setVisibility(0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.a(1, baseAd);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "privacyAgreement is empty", new Object[0]);
        if (com.hihonor.adsdk.base.j.c.hnadsc(baseAd)) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.c(view, view2);
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.d(view, view2);
                }
            });
        }
    }

    public static void e(View view, BaseAd baseAd, boolean z) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initTitleView,context is null", new Object[0]);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ad_reward_title);
        if (textView == null || Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initTitleView,view or baseAd is null", new Object[0]);
        } else if (TextUtils.isEmpty(baseAd.getTitle())) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "title is empty", new Object[0]);
            textView.setVisibility(z ? 4 : 8);
        } else {
            textView.setVisibility(0);
            textView.setText(baseAd.getTitle());
        }
    }

    public static void f(View view, BaseAd baseAd, boolean z) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initVersionText,rootView is null", new Object[0]);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ad_reward_version);
        if (textView == null || Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initVersionText,view or baseAd is null", new Object[0]);
        } else if (TextUtils.isEmpty(baseAd.getAppVersion())) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "appVersion is empty", new Object[0]);
            textView.setVisibility(z ? 4 : 8);
        } else {
            textView.setVisibility(0);
            textView.setText(MessageFormat.format("{0}{1}", "v", baseAd.getAppVersion()));
        }
    }

    public static void b(View view, final BaseAd baseAd, boolean z) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initIntroduceText,rootView is null", new Object[0]);
            return;
        }
        final TextView textView = (TextView) view.findViewById(R.id.ad_reward_source);
        if (textView == null || Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initIntroduceText,view or baseAd is null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(baseAd.getIntroUrl())) {
            textView.setVisibility(0);
            textView.setText(textView.getContext().getText(com.hihonor.adsdk.base.R.string.ads_introduce_cn));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.a(4, baseAd);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "introUrl is empty", new Object[0]);
        if (baseAd.getPkgType() != 0) {
            textView.setVisibility(0);
            textView.setText(textView.getContext().getText(com.hihonor.adsdk.base.R.string.ads_introduce_cn));
            if (com.hihonor.adsdk.base.j.c.hnadsc(baseAd)) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        c.a(textView, view2);
                    }
                });
                return;
            } else {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda7
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        c.b(textView, view2);
                    }
                });
                return;
            }
        }
        if (TextUtils.isEmpty(baseAd.getHomePage())) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "homePage is empty", new Object[0]);
            textView.setVisibility(z ? 4 : 8);
        } else {
            textView.setVisibility(0);
            textView.setText(textView.getContext().getText(com.hihonor.adsdk.base.R.string.ads_source_cn));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.a(3, baseAd);
                }
            });
        }
    }

    public static void c(final View view, final BaseAd baseAd, boolean z) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initPermissionText,rootView is null", new Object[0]);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ad_reward_permissions);
        if (textView == null || Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initPermissionText,view or baseAd is null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(baseAd.getPermissionsUrl())) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.a(2, baseAd);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "permissionsUrl is empty", new Object[0]);
        if (com.hihonor.adsdk.base.j.c.hnadsc(baseAd)) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.a(view, view2);
                }
            });
        } else {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.b(view, view2);
                }
            });
        }
    }

    public static boolean a() {
        boolean zHnadsf = j.hnadsf(HnAds.get().getContext());
        com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "isLargeFoldingScreenFullOrPad,isPad:" + zHnadsf, new Object[0]);
        return j.hnadso() || zHnadsf;
    }

    public static void a(Window window) {
        com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "Set dialog window full screen.", new Object[0]);
        if (window == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "window is null.", new Object[0]);
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (Build.VERSION.SDK_INT >= 28) {
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        } else {
            window.setFlags(1024, 1024);
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            decorView.setSystemUiVisibility(5382);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(View view, View view2) {
        b0.hnadsb(view.getResources().getString(R.string.ads_developer_not_provide_privacy));
    }

    public static String a(long j, long j2) {
        long j3 = j2 - j;
        if (j3 >= 60000) {
            long j4 = j3 / 60000;
            long j5 = (j3 - (60000 * j4)) / 1000;
            return (j4 < 10 ? "0" + j4 : Long.valueOf(j4)) + ":" + (j5 < 10 ? "0" + j5 : Long.valueOf(j5));
        }
        long j6 = j3 / 1000;
        return "00:" + (j6 < 10 ? "0" + j6 : Long.valueOf(j6));
    }

    public static void a(Context context, String str, int i, int i2, View view) {
        try {
            if (Objects.isNull(view)) {
                com.hihonor.adsdk.common.b.b.hnadsb(f3559a, "setHwColumnSystem,view is null,return", new Object[0]);
                return;
            }
            float fHnadsb = u.hnadsb();
            com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "setColumnSystem,columnsDefine:" + str + ",width: " + i + ",height:" + i2 + ",density:" + fHnadsb + ",breakPointValue: " + (i / fHnadsb), new Object[0]);
            com.hihonor.adsdk.common.e.c.a.c cVar = new com.hihonor.adsdk.common.e.c.a.c(context, str, i, i2, fHnadsb);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                int iHnadsh = cVar.hnadsh();
                int iHnadsd = cVar.hnadsd();
                com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "setHwColumnSystem,suggestWidth: " + iHnadsh + ",margin: " + iHnadsd, new Object[0]);
                marginLayoutParams.width = iHnadsh;
                marginLayoutParams.setMarginStart(iHnadsd);
                marginLayoutParams.setMarginEnd(iHnadsd);
                view.setLayoutParams(marginLayoutParams);
            }
        } catch (Exception e2) {
            com.hihonor.adsdk.common.b.b.hnadsb(f3559a, "setHwColumnSystem,exception: " + e2.getMessage(), new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(TextView textView, View view) {
        b0.hnadsb(textView.getContext().getString(R.string.ads_developer_not_provide_introduce));
    }

    public static void a(View view, final BaseAd baseAd, final e eVar, final int i, final Point point, final Point point2, final AdListener adListener, final float f) {
        if (!Objects.isNull(view) && !Objects.isNull(baseAd)) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.reward.c$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    c.a(baseAd, eVar, i, point, point2, adListener, f);
                }
            });
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initPictureTextViewClick,view or baseAd is null", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(BaseAd baseAd, e eVar, int i, Point point, Point point2, AdListener adListener, float f) {
        Point point3;
        Point point4;
        if (Objects.nonNull(eVar)) {
            eVar.hnadsa(baseAd);
            eVar.hnadsd();
        }
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "triggerAndReportClickEvent,mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(point)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "triggerAndReportClickEvent,new downTouchPoint", new Object[0]);
            point3 = new Point();
        } else {
            point3 = point;
        }
        if (Objects.isNull(point2)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "triggerAndReportClickEvent,new upTouchPoint", new Object[0]);
            point4 = new Point();
        } else {
            point4 = point2;
        }
        new f(baseAd, baseAd.getAdUnitId(), com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd), i, 0).hnadse();
        com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "triggerAndReportClickEvent,clickType:" + i + ",downX:" + point3.x + ",downY:" + point3.y + ",upX:" + point4.x + ",upY:" + point4.y, new Object[0]);
        new com.hihonor.adsdk.base.g.k.c.b(point3.x, point3.y, point4.x, point4.y, i, f, 0).hnadsa(baseAd, baseAd.getTrackUrl().getClicks());
        if (Objects.nonNull(adListener)) {
            adListener.onAdClicked();
        }
    }

    public static void a(View view, BaseAd baseAd) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initDownLoadButton,rootView is null", new Object[0]);
            return;
        }
        HnDownloadButton hnDownloadButton = (HnDownloadButton) view.findViewById(R.id.ad_reward_download);
        if (hnDownloadButton != null && !Objects.isNull(baseAd)) {
            hnDownloadButton.setVisibility(0);
            hnDownloadButton.setBaseAd(baseAd, 1);
        } else {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initDownLoadButton,view or baseAd is null", new Object[0]);
        }
    }

    public static void a(Context context, View view, BaseAd baseAd, e eVar, Point point, Point point2, AdListener adListener, float f) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initLogo,rootView is null", new Object[0]);
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.ad_reward_image);
        if (imageView != null && !Objects.isNull(baseAd)) {
            int iHnadsa = com.hihonor.adsdk.common.f.j.hnadsa(HnAds.get().getContext(), 8.0f);
            String logo = baseAd.getLogo();
            if (TextUtils.isEmpty(logo) && baseAd.getImages() != null && baseAd.getImages().size() > 0) {
                logo = baseAd.getImages().get(0);
            }
            GlideLoadBuild.Builder imageView2 = new GlideLoadBuild.Builder().setContext(context).setNeedReport(true).setUrl(logo).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).setAdUnitId(baseAd.getAdUnitId()).setCornerRadius(iHnadsa).setImageView(imageView);
            if (baseAd.getTrackUrl() != null) {
                imageView2.setCommonTrackUrls(baseAd.getTrackUrl().getCommons());
            }
            imageView2.build().loadImage();
            a(imageView, baseAd, eVar, 0, point, point2, adListener, f);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initLogo,view or baseAd is null", new Object[0]);
    }

    public static void a(View view, BaseAd baseAd, e eVar, Point point, Point point2, AdListener adListener, boolean z, float f) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initBrand,rootView is null", new Object[0]);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ad_reward_brand);
        if (textView != null && !Objects.isNull(baseAd)) {
            if (TextUtils.isEmpty(baseAd.getBrand())) {
                com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "brand is empty", new Object[0]);
                textView.setVisibility(z ? 4 : 8);
                return;
            } else {
                textView.setVisibility(0);
                textView.setText(baseAd.getBrand());
                a(textView, baseAd, eVar, 2, point, point2, adListener, f);
                return;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initBrand,view or baseAd is null", new Object[0]);
    }

    public static void a(View view, BaseAd baseAd, boolean z) {
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initDeveloperText,rootView is null", new Object[0]);
            return;
        }
        TextView textView = (TextView) view.findViewById(R.id.ad_reward_company_name);
        if (textView != null && !Objects.isNull(baseAd)) {
            if (TextUtils.isEmpty(baseAd.getDeveloperName())) {
                com.hihonor.adsdk.common.b.b.hnadsc(f3559a, "developName is empty", new Object[0]);
                textView.setVisibility(z ? 4 : 8);
                return;
            } else {
                textView.setVisibility(0);
                textView.setText(baseAd.getDeveloperName());
                return;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadse(f3559a, "initDeveloperText,view or baseAd is null", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(View view, View view2) {
        b0.hnadsb(view.getResources().getString(R.string.ads_reserve_developer_not_provide_privacy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(TextView textView, View view) {
        b0.hnadsb(textView.getContext().getString(R.string.ads_reserve_developer_not_provide_introduce));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(int i, BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsa(f3559a, (Object) ("handleStartPage type = " + i));
        com.hihonor.adsdk.base.g.b.hnadsa(i, baseAd);
        WebPermissionsActivity.hnadsb(baseAd, i);
    }
}
