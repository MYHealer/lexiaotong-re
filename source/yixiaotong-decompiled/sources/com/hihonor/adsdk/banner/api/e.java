package com.hihonor.adsdk.banner.api;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.banner.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.widget.base.AdFlagCloseView;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.base.widget.web.WebPermissionsActivity;
import com.hihonor.adsdk.common.f.b0;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class e extends com.hihonor.adsdk.base.widget.a.c.a {
    private static final String n = "BaseBannerViewHolder";
    private static final String o = "v";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected float f3503a;
    protected BaseAd b;
    protected Context c;
    protected ImageView d;
    protected final HnDownloadButton e;
    protected final TextView f;
    protected final TextView g;
    protected final TextView h;
    protected final TextView i;
    protected final TextView j;
    protected final TextView k;
    protected final TextView l;
    protected final TextView m;

    public e(View view) {
        super(view);
        this.hnadsb = (AdFlagCloseView) hnadsa(R.id.ad_close_view);
        this.d = (ImageView) hnadsa(R.id.ad_image);
        this.e = (HnDownloadButton) hnadsa(R.id.ad_download);
        this.f = (TextView) hnadsa(R.id.ad_brand_name);
        this.g = (TextView) hnadsa(R.id.ad_title);
        this.h = (TextView) hnadsa(R.id.ad_flag_view);
        this.i = (TextView) hnadsa(R.id.ad_company_name);
        this.j = (TextView) hnadsa(R.id.ad_privacy);
        this.k = (TextView) hnadsa(R.id.ad_permissions);
        this.l = (TextView) hnadsa(R.id.ad_source);
        this.m = (TextView) hnadsa(R.id.ad_version);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        com.hihonor.adsdk.base.g.b.hnadsa(1, this.b);
        WebPermissionsActivity.hnadsb(this.b, 1);
    }

    private void g() {
        if (this.j == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or privacy view is invalid,return", new Object[0]);
            return;
        }
        this.j.setVisibility(0);
        if (!TextUtils.isEmpty(this.b.getPrivacyAgreementUrl())) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.f(view);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(n, "privacyAgreementUrl is empty", new Object[0]);
        if (com.hihonor.adsdk.base.j.c.hnadsc(this.b)) {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.d(view);
                }
            });
        } else {
            this.j.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.e(view);
                }
            });
        }
    }

    private void h() {
        if (this.l == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or source view is invalid,return", new Object[0]);
            return;
        }
        if (!TextUtils.isEmpty(this.b.getIntroUrl())) {
            this.l.setVisibility(0);
            this.l.setText(this.c.getText(com.hihonor.adsdk.base.R.string.ads_introduce_cn));
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.j(view);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(n, "introUrl is empty", new Object[0]);
        if (this.b.getPkgType() != 0) {
            this.l.setVisibility(0);
            this.l.setText(this.c.getText(com.hihonor.adsdk.base.R.string.ads_introduce_cn));
            if (com.hihonor.adsdk.base.j.c.hnadsc(this.b)) {
                this.l.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.h(view);
                    }
                });
                return;
            } else {
                this.l.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.i(view);
                    }
                });
                return;
            }
        }
        if (TextUtils.isEmpty(this.b.getHomePage())) {
            com.hihonor.adsdk.common.b.b.hnadsc(n, "setSourceView,homePage is empty", new Object[0]);
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setText(this.c.getText(com.hihonor.adsdk.base.R.string.ads_source_cn));
            this.l.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.g(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(View view) {
        com.hihonor.adsdk.base.g.b.hnadsa(4, this.b);
        WebPermissionsActivity.hnadsb(this.b, 4);
    }

    protected void a() {
    }

    public abstract void a(int i, int i2);

    protected void b() {
        if (this.h == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or flag is invalid,return", new Object[0]);
        } else {
            com.hihonor.adsdk.common.b.b.hnadsc(n, "initAdFlagView,adFlag: " + this.b.getAdFlag(), new Object[0]);
            this.h.setVisibility(this.b.getAdFlag() == 0 ? 8 : 0);
        }
    }

    protected void c() {
        if (this.f == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or brand view is invalid,return", new Object[0]);
        } else if (TextUtils.isEmpty(this.b.getBrand())) {
            com.hihonor.adsdk.common.b.b.hnadsc(n, "brand is empty", new Object[0]);
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.f.setText(this.b.getBrand());
        }
    }

    protected void d() {
        if (this.i == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or developer view is invalid,return", new Object[0]);
        } else if (TextUtils.isEmpty(this.b.getDeveloperName())) {
            com.hihonor.adsdk.common.b.b.hnadsc(n, "developerName is empty", new Object[0]);
            this.i.setVisibility(8);
        } else {
            this.i.setVisibility(0);
            this.i.setText(this.b.getDeveloperName());
        }
    }

    protected void i() {
        if (this.g == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or title view is invalid,return", new Object[0]);
        } else if (TextUtils.isEmpty(this.b.getTitle())) {
            com.hihonor.adsdk.common.b.b.hnadsc(n, "title is empty", new Object[0]);
            this.g.setVisibility(8);
        } else {
            this.g.setVisibility(0);
            this.g.setText(this.b.getTitle());
        }
    }

    protected void k() {
        if (Objects.isNull(this.d) || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or image view is invalid,return", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(n, "get image size : width = %d,height = %d", Integer.valueOf(this.b.getImgWidth()), Integer.valueOf(this.b.getImgHeight()));
        GlideLoadBuild.Builder imageView = new GlideLoadBuild.Builder().setContext(this.c).setNeedReport(true).setUrl((String) com.hihonor.adsdk.common.f.f.hnadsa((List) this.b.getImages())).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.b)).setAdUnitId(this.b.getAdUnitId()).setCornerRadius((int) this.f3503a).setImageView(this.d);
        if (this.b.getTrackUrl() != null) {
            imageView.setCommonTrackUrls(this.b.getTrackUrl().getCommons());
        }
        imageView.build().loadImage();
    }

    protected abstract void l();

    protected void a(BaseAd baseAd) {
        if (baseAd == null) {
            return;
        }
        this.b = baseAd;
        Context context = this.hnadsa.getContext();
        this.c = context;
        this.f3503a = context.getResources().getDimension(R.dimen.honor_ads_magic_corner_radius_small);
        Style style = this.b.getStyle();
        if (style != null) {
            this.f3503a = com.hihonor.adsdk.common.f.j.hnadsa(this.c, style.getBorderRadius());
        }
        b();
        a();
        k();
        e();
        l();
        c();
        i();
        b();
        d();
        g();
        f();
        h();
        j();
    }

    protected void e() {
        HnDownloadButton hnDownloadButton = this.e;
        if (hnDownloadButton == null) {
            com.hihonor.adsdk.common.b.b.hnadse(n, "mDownLoadButton is invalid,return", new Object[0]);
        } else {
            hnDownloadButton.setBaseAd(this.b, 1);
        }
    }

    private void f() {
        if (this.k != null && !Objects.isNull(this.b)) {
            this.k.setVisibility(0);
            if (TextUtils.isEmpty(this.b.getPermissionsUrl())) {
                com.hihonor.adsdk.common.b.b.hnadsc(n, "permissionsUrl is empty", new Object[0]);
                if (com.hihonor.adsdk.base.j.c.hnadsc(this.b)) {
                    this.k.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.a(view);
                        }
                    });
                    return;
                } else {
                    this.k.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            this.f$0.b(view);
                        }
                    });
                    return;
                }
            }
            this.k.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.e$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.c(view);
                }
            });
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or permission view is invalid,return", new Object[0]);
    }

    protected void j() {
        if (this.m != null && !Objects.isNull(this.b)) {
            if (TextUtils.isEmpty(this.b.getAppVersion())) {
                com.hihonor.adsdk.common.b.b.hnadsc(n, "appVersion is empty", new Object[0]);
                this.m.setVisibility(8);
                return;
            } else {
                this.m.setVisibility(0);
                this.m.setText(MessageFormat.format("{0}{1}", "v", this.b.getAppVersion()));
                return;
            }
        }
        com.hihonor.adsdk.common.b.b.hnadse(n, "baseAd or version view is invalid,return", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        b0.hnadsb(this.c.getString(R.string.ads_developer_not_provide_privacy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        b0.hnadsb(this.c.getString(R.string.ads_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        com.hihonor.adsdk.base.g.b.hnadsa(2, this.b);
        WebPermissionsActivity.hnadsb(this.b, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        b0.hnadsb(this.c.getString(R.string.ads_reserve_developer_not_provide_privacy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(View view) {
        b0.hnadsb(this.c.getString(R.string.ads_developer_not_provide_introduce));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(View view) {
        com.hihonor.adsdk.base.g.b.hnadsa(3, this.b);
        WebPermissionsActivity.hnadsb(this.b, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b0.hnadsb(this.c.getString(R.string.ads_reserve_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(View view) {
        b0.hnadsb(this.c.getString(R.string.ads_reserve_developer_not_provide_introduce));
    }
}
