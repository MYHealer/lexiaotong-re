package com.hihonor.adsdk.interstitial.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.base.widget.web.WebPermissionsActivity;
import com.hihonor.adsdk.common.f.b0;
import com.hihonor.adsdk.common.f.j;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a {
    private static final String m = "BaseTextArea";
    private static final String n = "v";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3537a;
    protected BaseAd b;
    private ImageView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private TextView i;
    private HnDownloadButton j;
    private TextView k;
    private View l;

    private void b() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initBrandView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.d)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initBrandView adBrand is null", new Object[0]);
        } else if (TextUtils.isEmpty(this.b.getBrand())) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initBrandView brand is empty", new Object[0]);
            this.d.setVisibility(8);
        } else {
            this.d.setVisibility(0);
            this.d.setText(this.b.getBrand());
        }
    }

    private void c() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initCompanyNameView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.e)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initCompanyNameView adCompanyName is null", new Object[0]);
        } else if (TextUtils.isEmpty(this.b.getDeveloperName())) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initCompanyNameView developerName is empty", new Object[0]);
            this.e.setVisibility(8);
        } else {
            this.e.setVisibility(0);
            this.e.setText(this.b.getDeveloperName());
        }
    }

    private void d() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initImageView baseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.c)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initImageView adImageView is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.f3537a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initImageView mContext is null", new Object[0]);
            return;
        }
        int iHnadsa = j.hnadsa(this.f3537a, 5.0f);
        Context context = this.f3537a;
        BaseAd baseAd = this.b;
        a(context, baseAd, this.c, baseAd.getTrackUrl(), iHnadsa);
    }

    private void e() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initPermissionsView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.f)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initPermissionsView permissionsView is null", new Object[0]);
            return;
        }
        this.f.setVisibility(0);
        if (!TextUtils.isEmpty(this.b.getPermissionsUrl())) {
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.c(view);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(m, "initPermissionsView permissionsUrl is empty", new Object[0]);
        if (com.hihonor.adsdk.base.j.c.hnadsc(this.b)) {
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.a(view);
                }
            });
        } else {
            this.f.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.b(view);
                }
            });
        }
    }

    private void f() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initPrivacyView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.g)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initPrivacyView privacyView is null", new Object[0]);
            return;
        }
        this.g.setVisibility(0);
        if (!TextUtils.isEmpty(this.b.getPrivacyAgreementUrl())) {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.f(view);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(m, "initPrivacyView privacyAgreementUrl is empty", new Object[0]);
        if (com.hihonor.adsdk.base.j.c.hnadsc(this.b)) {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.d(view);
                }
            });
        } else {
            this.g.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.e(view);
                }
            });
        }
    }

    private void g() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initSourceView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.h)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initSourceView sourceView is null", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(this.b.getIntroUrl())) {
            this.h.setVisibility(0);
            TextView textView = this.h;
            textView.setText(textView.getContext().getText(R.string.ads_introduce_cn));
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.j(view);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(m, "initSourceView introUrl is empty", new Object[0]);
        if (this.b.getPkgType() != 0) {
            this.h.setVisibility(0);
            TextView textView2 = this.h;
            textView2.setText(textView2.getContext().getText(R.string.ads_introduce_cn));
            if (com.hihonor.adsdk.base.j.c.hnadsc(this.b)) {
                this.h.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.h(view);
                    }
                });
                return;
            } else {
                this.h.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.i(view);
                    }
                });
                return;
            }
        }
        if (TextUtils.isEmpty(this.b.getHomePage())) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "homePage is empty", new Object[0]);
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            TextView textView3 = this.h;
            textView3.setText(textView3.getContext().getText(R.string.ads_source_cn));
            this.h.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.g.a$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.g(view);
                }
            });
        }
    }

    private void i() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initVersionView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.i)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initVersionView versionView is null", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(this.b.getAppVersion())) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initVersionView appVersion is empty", new Object[0]);
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.i.setText("v" + this.b.getAppVersion());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        a(4, this.b);
    }

    public abstract int a(BaseAd baseAd);

    public void a(FrameLayout frameLayout, View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        b0.hnadsb(this.h.getContext().getString(com.hihonor.adsdk.interstitial.R.string.ads_reserve_developer_not_provide_introduce));
    }

    private void h() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initTitleView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.k)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initTitleView adTitle is null", new Object[0]);
        } else if (TextUtils.isEmpty(this.b.getTitle())) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initTitleView title is empty", new Object[0]);
            this.k.setVisibility(8);
        } else {
            this.k.setVisibility(0);
            this.k.setText(this.b.getTitle());
        }
    }

    public void a(Context context, BaseAd baseAd, boolean z, View view) {
        this.f3537a = context;
        this.b = baseAd;
        this.l = view;
        if (Objects.isNull(view)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initTextAreaView rootView is null", new Object[0]);
            return;
        }
        this.c = (ImageView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_image);
        this.d = (TextView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_brand);
        this.e = (TextView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_company_name);
        this.f = (TextView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_permissions);
        this.g = (TextView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_privacy);
        this.h = (TextView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_source);
        this.i = (TextView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_version);
        this.j = (HnDownloadButton) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_download);
        this.k = (TextView) view.findViewById(com.hihonor.adsdk.interstitial.R.id.ad_title);
        d();
        b();
        c();
        e();
        f();
        g();
        i();
        a(z);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (Objects.nonNull(this.l)) {
            b0.hnadsb(this.l.getResources().getString(com.hihonor.adsdk.interstitial.R.string.ads_developer_not_provide_permission));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        a(2, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (Objects.nonNull(this.l)) {
            b0.hnadsb(this.l.getResources().getString(com.hihonor.adsdk.interstitial.R.string.ads_reserve_developer_not_provide_privacy));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        b0.hnadsb(this.h.getContext().getString(com.hihonor.adsdk.interstitial.R.string.ads_developer_not_provide_introduce));
    }

    protected void b(View view, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(m, "setViewWidth width = %d", Integer.valueOf(i));
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadse(m, "setViewWidth target view is null!", new Object[0]);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (Objects.nonNull(this.l)) {
            b0.hnadsb(this.l.getResources().getString(com.hihonor.adsdk.interstitial.R.string.ads_reserve_developer_not_provide_permission));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        a(1, this.b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        if (Objects.nonNull(this.l)) {
            b0.hnadsb(this.l.getResources().getString(com.hihonor.adsdk.interstitial.R.string.ads_developer_not_provide_privacy));
        }
    }

    private void a(boolean z) {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initDownloadView mBaseAd is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.j)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "initDownloadView adTitle is null", new Object[0]);
        } else if (!z) {
            this.j.setBaseAd(this.b, 1);
        } else {
            this.j.setBaseAd(this.b, 0);
        }
    }

    private void a(int i, BaseAd baseAd) {
        com.hihonor.adsdk.common.b.b.hnadsa(m, (Object) ("handleStartPage type = " + i));
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "handleStartPage baseAd is null", new Object[0]);
        } else {
            com.hihonor.adsdk.base.g.b.hnadsa(i, baseAd);
            WebPermissionsActivity.hnadsb(baseAd, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        a(3, this.b);
    }

    private void a(Context context, BaseAd baseAd, ImageView imageView, TrackUrl trackUrl, int i) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(m, "InterstitialAdViewFactory#loadImage, baseAd is null", new Object[0]);
            return;
        }
        String logo = baseAd.getLogo();
        if (TextUtils.isEmpty(logo) && baseAd.getImages() != null && baseAd.getImages().size() > 0) {
            logo = baseAd.getImages().get(0);
        }
        GlideLoadBuild.Builder imageView2 = new GlideLoadBuild.Builder().setContext(context).setNeedReport(true).setUrl(logo).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).setAdUnitId(baseAd.getAdUnitId()).setCornerRadius(i).setImageView(imageView);
        if (Objects.nonNull(trackUrl)) {
            imageView2.setCommonTrackUrls(trackUrl.getCommons());
        }
        imageView2.build().loadImage();
    }

    protected void a(View view, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(m, "setViewHeight height = %d", Integer.valueOf(i));
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadse(m, "setViewHeight target view is null!", new Object[0]);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public FrameLayout.LayoutParams a() {
        return new FrameLayout.LayoutParams(-1, -2);
    }
}
