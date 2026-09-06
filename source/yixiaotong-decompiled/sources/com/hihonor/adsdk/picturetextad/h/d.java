package com.hihonor.adsdk.picturetextad.h;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hihonor.adsdk.base.HnAds;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.Style;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.base.widget.base.AdFlagCloseView;
import com.hihonor.adsdk.base.widget.download.HnDownloadButton;
import com.hihonor.adsdk.base.widget.web.WebPermissionsActivity;
import com.hihonor.adsdk.common.f.b0;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.common.f.w;
import com.hihonor.adsdk.picturetextad.R;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class d extends com.hihonor.adsdk.base.widget.a.c.a {
    private static final String o = "PictureDownloadViewHolder";
    private static final String p = "v";
    private static final int q = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected BaseAd f3547a;
    protected final Context b;
    protected float c;
    protected final TextView d;
    protected final TextView e;
    protected final HnDownloadButton f;
    protected final ImageView g;
    protected final TextView h;
    protected final TextView i;
    protected final TextView j;
    protected final TextView k;
    protected final TextView l;
    protected final TextView m;
    protected final TextView n;

    public d(View view) {
        super(view);
        this.b = view.getContext();
        this.f = (HnDownloadButton) hnadsa(R.id.ad_download);
        this.d = (TextView) hnadsa(R.id.ad_title);
        this.h = (TextView) hnadsa(R.id.ad_brand_name);
        this.g = (ImageView) hnadsa(R.id.ad_brand_logo);
        this.e = (TextView) hnadsa(R.id.ad_flag_view);
        this.hnadsb = (AdFlagCloseView) hnadsa(R.id.ad_close_view);
        this.i = (TextView) hnadsa(R.id.ad_privacy_view);
        this.j = (TextView) hnadsa(R.id.ad_permissions_view);
        this.k = (TextView) hnadsa(R.id.ad_introduce_view);
        this.l = (TextView) hnadsa(R.id.ad_version_view);
        this.m = (TextView) hnadsa(R.id.ad_developer_view);
        this.n = (TextView) hnadsa(R.id.ad_dot);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        b0.hnadsb(this.b.getString(R.string.ads_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        b0.hnadsb(this.b.getString(R.string.ads_reserve_developer_not_provide_introduce));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        b0.hnadsb(this.b.getString(R.string.ads_reserve_developer_not_provide_privacy));
    }

    public void a(BaseAd baseAd) {
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "bindData baseAd is null", new Object[0]);
            return;
        }
        this.f3547a = baseAd;
        this.c = this.b.getResources().getDimension(R.dimen.honor_ads_magic_corner_radius_small);
        Style style = baseAd.getStyle();
        if (style != null) {
            this.c = j.hnadsa(this.b, style.getBorderRadius());
        }
        l(baseAd);
        h(baseAd);
        c(baseAd);
        b(baseAd);
        e(baseAd);
        j(baseAd);
        k(baseAd);
        i(baseAd);
        d(baseAd);
        m(baseAd);
        f(baseAd);
        g(baseAd);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(BaseAd baseAd, View view) {
        WebPermissionsActivity.hnadsb(baseAd, 3);
        com.hihonor.adsdk.base.g.b.hnadsa(3, baseAd);
    }

    private void h(BaseAd baseAd) {
        HnDownloadButton hnDownloadButton = this.f;
        if (hnDownloadButton != null) {
            hnDownloadButton.setVisibility(0);
            this.f.setBaseAd(baseAd, 1);
        }
    }

    private void j(BaseAd baseAd) {
        if (this.g != null) {
            GlideLoadBuild.Builder imageView = new GlideLoadBuild.Builder().setContext(this.b).setNeedReport(true).setUrl(baseAd.getLogo()).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).setAdUnitId(baseAd.getAdUnitId()).setCornerRadius(j.hnadsa(HnAds.get().getContext(), 8.0f)).setImageView(this.g);
            if (baseAd.getTrackUrl() != null) {
                imageView.setCommonTrackUrls(baseAd.getTrackUrl().getCommons());
            }
            imageView.build().loadImage();
        }
    }

    private void l(BaseAd baseAd) {
        if (this.d != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "title：" + baseAd.getTitle(), new Object[0]);
            this.d.setText(baseAd.getTitle());
            this.d.setTag(R.id.ad_common_click_type_tag, 2);
            this.d.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.hnadsa(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(BaseAd baseAd, View view) {
        WebPermissionsActivity.hnadsb(baseAd, 4);
        com.hihonor.adsdk.base.g.b.hnadsa(4, baseAd);
    }

    private void b(BaseAd baseAd) {
        if (this.hnadsb != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "adFlagClose :" + baseAd.getCloseFlag(), new Object[0]);
            this.hnadsb.setVisibility(baseAd.getCloseFlag() == 0 ? 8 : 0);
        }
    }

    private void d(final BaseAd baseAd) {
        if (this.j == null) {
            return;
        }
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "initAuthorityText#baseAd is null", new Object[0]);
            return;
        }
        this.j.setVisibility(0);
        if (TextUtils.isEmpty(baseAd.getPermissionsUrl())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "permissionsUrl is null", new Object[0]);
            if (com.hihonor.adsdk.base.j.c.hnadsc(this.f3547a)) {
                this.j.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda4
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.a(view);
                    }
                });
                return;
            } else {
                this.j.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda5
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.b(view);
                    }
                });
                return;
            }
        }
        this.j.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.a(baseAd, view);
            }
        });
    }

    private void i(final BaseAd baseAd) {
        if (this.k == null) {
            return;
        }
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "initIntroduceText#baseAd is null", new Object[0]);
            return;
        }
        if (TextUtils.isEmpty(baseAd.getIntroUrl())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "introUrl is null", new Object[0]);
            if (baseAd.getPkgType() == 0) {
                if (TextUtils.isEmpty(baseAd.getHomePage())) {
                    com.hihonor.adsdk.common.b.b.hnadsc(o, "homePage is null", new Object[0]);
                    this.k.setVisibility(8);
                    return;
                } else {
                    this.k.setVisibility(0);
                    this.k.setText(this.b.getText(com.hihonor.adsdk.base.R.string.ads_source_cn));
                    this.k.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda7
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            d.b(baseAd, view);
                        }
                    });
                    return;
                }
            }
            this.k.setVisibility(0);
            this.k.setText(this.b.getText(com.hihonor.adsdk.base.R.string.ads_introduce_cn));
            if (com.hihonor.adsdk.base.j.c.hnadsc(baseAd)) {
                this.k.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda8
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.c(view);
                    }
                });
                return;
            } else {
                this.k.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda9
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.d(view);
                    }
                });
                return;
            }
        }
        this.k.setVisibility(0);
        this.k.setText(this.b.getText(com.hihonor.adsdk.base.R.string.ads_introduce_cn));
        this.k.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.c(baseAd, view);
            }
        });
    }

    private void k(final BaseAd baseAd) {
        if (this.i == null) {
            return;
        }
        if (Objects.isNull(baseAd)) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "initPrivacyText#baseAd is null", new Object[0]);
            return;
        }
        this.i.setVisibility(0);
        if (TextUtils.isEmpty(baseAd.getPrivacyAgreementUrl())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "privacyAgreement is null", new Object[0]);
            if (com.hihonor.adsdk.base.j.c.hnadsc(baseAd)) {
                this.i.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.e(view);
                    }
                });
                return;
            } else {
                this.i.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.f$0.f(view);
                    }
                });
                return;
            }
        }
        this.i.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.picturetextad.h.d$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.d(baseAd, view);
            }
        });
    }

    private void m(BaseAd baseAd) {
        if (this.l == null) {
            return;
        }
        if (TextUtils.isEmpty(baseAd.getAppVersion())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "appVersion is null", new Object[0]);
            this.l.setVisibility(8);
        } else {
            this.l.setVisibility(0);
            this.l.setText(MessageFormat.format("{0}{1}", "v", baseAd.getAppVersion()));
        }
    }

    protected void f(BaseAd baseAd) {
        if (this.m == null) {
            return;
        }
        if (TextUtils.isEmpty(baseAd.getDeveloperName())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "developName is null", new Object[0]);
            this.m.setVisibility(8);
        } else {
            this.m.setVisibility(0);
            this.m.setText(baseAd.getDeveloperName());
        }
    }

    protected void g(BaseAd baseAd) {
        if (this.n == null) {
            return;
        }
        if (baseAd.getPromotionPurpose() != 0 && baseAd.getPromotionPurpose() != 4) {
            if (baseAd.getAdFlag() != 0 && !TextUtils.isEmpty(baseAd.getTitle())) {
                this.n.setVisibility(0);
                return;
            } else {
                this.n.setVisibility(8);
                return;
            }
        }
        if (baseAd.getAdFlag() != 0 && !TextUtils.isEmpty(baseAd.getDeveloperName())) {
            this.n.setVisibility(0);
        } else {
            this.n.setVisibility(8);
        }
    }

    protected void e(BaseAd baseAd) {
        if (this.h == null) {
            return;
        }
        if (TextUtils.isEmpty(baseAd.getBrand())) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "brand is null", new Object[0]);
            this.h.setVisibility(8);
        } else {
            this.h.setVisibility(0);
            this.h.setText(baseAd.getBrand());
        }
    }

    private void c(BaseAd baseAd) {
        if (this.e != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(o, "adFlag :" + baseAd.getAdFlag(), new Object[0]);
            this.e.setVisibility(baseAd.getAdFlag() == 0 ? 8 : 0);
        }
    }

    protected void b(View view, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(o, "Call set view width.", new Object[0]);
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadse(o, "target view is null!", new Object[0]);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(View view) {
        b0.hnadsb(this.b.getString(R.string.ads_developer_not_provide_privacy));
    }

    protected void c() {
        TextView textView = this.h;
        if (textView != null) {
            textView.requestLayout();
        }
    }

    protected void b() {
        TextView textView = this.m;
        if (textView != null) {
            textView.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        b0.hnadsb(this.b.getString(R.string.ads_developer_not_provide_introduce));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(BaseAd baseAd, View view) {
        WebPermissionsActivity.hnadsb(baseAd, 1);
        com.hihonor.adsdk.base.g.b.hnadsa(1, baseAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b0.hnadsb(this.b.getString(R.string.ads_reserve_developer_not_provide_permission));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(BaseAd baseAd, View view) {
        WebPermissionsActivity.hnadsb(baseAd, 2);
        com.hihonor.adsdk.base.g.b.hnadsa(2, baseAd);
    }

    protected void a(View view, int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(o, "Call set view height.", new Object[0]);
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadse(o, "target view is null!", new Object[0]);
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    protected void a(View view, String str) {
        com.hihonor.adsdk.common.b.b.hnadsc(o, "Call set view width.", new Object[0]);
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadse(o, "target view is null!", new Object[0]);
        } else if (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
            layoutParams.dimensionRatio = str;
            view.setLayoutParams(layoutParams);
        }
    }

    protected void a(Context context, BaseAd baseAd, List<String> list, int i, ImageView imageView, TrackUrl trackUrl) {
        com.hihonor.adsdk.common.b.b.hnadsc(o, "Call load image.", new Object[0]);
        if (baseAd != null && imageView != null) {
            GlideLoadBuild.Builder imageView2 = new GlideLoadBuild.Builder().setContext(context).setNeedReport(true).setUrl((list == null || list.size() <= i) ? null : list.get(i)).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(baseAd)).setAdUnitId(baseAd.getAdUnitId()).setCornerRadius((int) this.c).setImageView(imageView);
            imageView2.setCommonTrackUrls(trackUrl.getCommons());
            imageView2.build().loadImage();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(o, "baseAd or adImageView is null!", new Object[0]);
    }

    private void a() {
        View viewHnadsa = hnadsa(R.id.honor_ads_message_dividing_0);
        View viewHnadsa2 = hnadsa(R.id.honor_ads_message_dividing_1);
        View viewHnadsa3 = hnadsa(R.id.honor_ads_message_dividing_2);
        View viewHnadsa4 = hnadsa(R.id.honor_ads_message_dividing_3);
        View viewHnadsa5 = hnadsa(R.id.honor_ads_message_dividing_4);
        if (viewHnadsa == null) {
            return;
        }
        if (viewHnadsa5 != null) {
            w.hnadsa(this.e, viewHnadsa, this.m, viewHnadsa2, this.i, viewHnadsa3, this.j, viewHnadsa4, this.k, viewHnadsa5, this.l);
        } else {
            w.hnadsa(this.m, viewHnadsa, this.i, viewHnadsa2, this.j, viewHnadsa3, this.k, viewHnadsa4, this.l);
        }
    }
}
