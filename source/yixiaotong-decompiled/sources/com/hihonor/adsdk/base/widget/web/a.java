package com.hihonor.adsdk.base.widget.web;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.j.c;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.f.b0;
import com.hihonor.adsdk.common.f.j;
import java.text.MessageFormat;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a {
    private static final String hnadsa = "WebFloatViewFactory";
    private static final String hnadsb = "v";

    public static View hnadsa(final Activity activity, final BaseAd baseAd) {
        View viewHnadsa = hnadsa(activity);
        final ImageView imageView = (ImageView) viewHnadsa.findViewById(R.id.ad_image);
        HnDownloadButton hnDownloadButton = (HnDownloadButton) viewHnadsa.findViewById(R.id.ad_download);
        TextView textView = (TextView) viewHnadsa.findViewById(R.id.ad_brand);
        TextView textView2 = (TextView) viewHnadsa.findViewById(R.id.ad_company_name);
        final View viewFindViewById = viewHnadsa.findViewById(R.id.ad_permissions);
        final View viewFindViewById2 = viewHnadsa.findViewById(R.id.ad_privacy);
        TextView textView3 = (TextView) viewHnadsa.findViewById(R.id.ad_source);
        TextView textView4 = (TextView) viewHnadsa.findViewById(R.id.ad_version);
        if (TextUtils.isEmpty(baseAd.getDeveloperName())) {
            b.hnadse(hnadsa, "H5 landingPage bottom float view ##DeveloperName is null", new Object[0]);
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(baseAd.getDeveloperName());
        }
        viewFindViewById.setVisibility(0);
        if (TextUtils.isEmpty(baseAd.getPermissionsUrl())) {
            b.hnadse(hnadsa, "H5 landingPage bottom float view ##PermissionsUrl is null", new Object[0]);
            if (c.hnadsc(baseAd)) {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.hnadsa(viewFindViewById, view);
                    }
                });
            } else {
                viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda6
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.hnadsb(viewFindViewById, view);
                    }
                });
            }
        } else {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.hnadsa(baseAd, view);
                }
            });
        }
        viewFindViewById2.setVisibility(0);
        if (TextUtils.isEmpty(baseAd.getPrivacyAgreementUrl())) {
            b.hnadse(hnadsa, "H5 landingPage bottom float view ##PrivacyAgreementUrl is null", new Object[0]);
            if (c.hnadsc(baseAd)) {
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.hnadsc(viewFindViewById2, view);
                    }
                });
            } else {
                viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.hnadsd(viewFindViewById2, view);
                    }
                });
            }
        } else {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a.hnadsb(baseAd, view);
                }
            });
        }
        if (TextUtils.isEmpty(baseAd.getAppVersion())) {
            b.hnadse(hnadsa, "H5 landingPage bottom float view ##AppVersion is null", new Object[0]);
            textView4.setVisibility(8);
        } else {
            textView4.setVisibility(0);
            textView4.setText(MessageFormat.format("{0}{1}", "v", baseAd.getAppVersion()));
        }
        hnadsa(textView3, baseAd);
        textView.setText(baseAd.getBrand());
        hnDownloadButton.setBaseAd(baseAd, 0);
        viewHnadsa.post(new Runnable() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                a.hnadsa(activity, baseAd, imageView);
            }
        });
        return viewHnadsa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsb(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsc(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_reserve_developer_not_provide_privacy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsd(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_developer_not_provide_privacy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsb(BaseAd baseAd, View view) {
        hnadsa(1, baseAd, baseAd.getPrivacyAgreementUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsd(BaseAd baseAd, View view) {
        hnadsa(3, baseAd, baseAd.getHomePage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsb(TextView textView, View view) {
        b0.hnadsb(textView.getContext().getString(R.string.ads_developer_not_provide_introduce));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsc(BaseAd baseAd, View view) {
        hnadsa(4, baseAd, baseAd.getIntroUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(View view, View view2) {
        b0.hnadsb(view.getContext().getString(R.string.ads_reserve_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(BaseAd baseAd, View view) {
        hnadsa(2, baseAd, baseAd.getPermissionsUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(Activity activity, BaseAd baseAd, ImageView imageView) {
        hnadsa(activity, baseAd, imageView, baseAd.getTrackUrl(), j.hnadsa((Context) activity, 5.0f));
    }

    private static void hnadsa(final TextView textView, final BaseAd baseAd) {
        if (TextUtils.isEmpty(baseAd.getIntroUrl())) {
            if (baseAd.getPkgType() == 0) {
                if (TextUtils.isEmpty(baseAd.getHomePage())) {
                    textView.setVisibility(8);
                    b.hnadse(hnadsa, "H5 landingPage bottom float view ##IntroUrl&HomePage is null", new Object[0]);
                    return;
                } else {
                    textView.setVisibility(0);
                    textView.setText(textView.getContext().getText(R.string.ads_source_cn));
                    textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            a.hnadsd(baseAd, view);
                        }
                    });
                    return;
                }
            }
            textView.setVisibility(0);
            textView.setText(textView.getContext().getText(R.string.ads_introduce_cn));
            if (c.hnadsc(baseAd)) {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.hnadsa(textView, view);
                    }
                });
                return;
            } else {
                textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        a.hnadsb(textView, view);
                    }
                });
                return;
            }
        }
        textView.setVisibility(0);
        textView.setText(textView.getContext().getText(R.string.ads_introduce_cn));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.base.widget.web.a$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.hnadsc(baseAd, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void hnadsa(TextView textView, View view) {
        b0.hnadsb(textView.getContext().getString(R.string.ads_reserve_developer_not_provide_introduce));
    }

    private static void hnadsa(int i, BaseAd baseAd, String str) {
        b.hnadsa(hnadsa, (Object) ("handleStartPage type = " + i));
        com.hihonor.adsdk.base.g.b.hnadsa(i, baseAd);
        WebPermissionsActivity.hnadsb(baseAd, i);
    }

    private static View hnadsa(Activity activity) {
        return LayoutInflater.from(activity).inflate(R.layout.honor_ads_web_common_landingpage_bottom, (ViewGroup) null);
    }

    public static void hnadsa(Context context, BaseAd baseAd, ImageView imageView, TrackUrl trackUrl, int i) {
        if (baseAd == null) {
            b.hnadsc(hnadsa, "WebFloatViewFactory#loadImage, baseAd is null", new Object[0]);
            return;
        }
        String logo = baseAd.getLogo();
        if (TextUtils.isEmpty(logo) && baseAd.getImages() != null && baseAd.getImages().size() > 0) {
            logo = baseAd.getImages().get(0);
        }
        GlideLoadBuild.Builder imageView2 = new GlideLoadBuild.Builder().setContext(context).setNeedReport(true).setUrl(logo).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).setAdUnitId(baseAd.getAdUnitId()).setCornerRadius(i).setImageView(imageView);
        imageView2.setCommonTrackUrls(trackUrl.getCommons());
        imageView2.build().loadImage();
    }
}
