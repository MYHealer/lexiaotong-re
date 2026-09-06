package com.hihonor.adsdk.interstitial.adapter.b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.bean.TrackUrl;
import com.hihonor.adsdk.base.net.glide.GlideLoadBuild;
import com.hihonor.adsdk.common.f.j;
import com.hihonor.adsdk.interstitial.R;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class a extends com.hihonor.adsdk.interstitial.adapter.a {
    private static final String i = "InterstitialImageBaseAdapter";
    protected ImageView h;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(i, "initCloseViewTwo closeFlagClose onClick", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(i, "displayPictureTextView adCloseLayout setOnClickListener", new Object[0]);
        b();
    }

    private int i() {
        if (!Objects.isNull(this.b)) {
            return j.hnadsa((Context) this.b, 12.0f);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(i, "getCornerRadius mContext is null", new Object[0]);
        return 0;
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.a
    public void a(BaseAd baseAd, Activity activity) {
        super.a(baseAd, activity);
        m();
    }

    @Override // com.hihonor.adsdk.interstitial.adapter.a
    public void f() {
        super.f();
        n();
    }

    protected abstract Boolean[] j();

    protected void k() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "initCloseViewOne mContext is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.f3528a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "initCloseViewOne mBaseAd is null", new Object[0]);
            return;
        }
        ImageView imageView = (ImageView) this.b.findViewById(R.id.ad_close);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.b.a$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.a(view);
            }
        });
        this.b.findViewById(R.id.ad_close_view).setVisibility(this.f3528a.getCloseFlag() == 0 ? 4 : 0);
        ((LinearLayout) this.b.findViewById(R.id.ad_view_interstitial_close)).setBackgroundResource(R.drawable.shape_honor_ads_close_bg);
        imageView.setVisibility(0);
    }

    protected void l() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "initCloseViewOne mContext is null", new Object[0]);
            return;
        }
        if (Objects.isNull(this.f3528a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "initCloseViewOne mBaseAd is null", new Object[0]);
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.ad_flag_close_view);
        ImageView imageView = (ImageView) this.b.findViewById(R.id.ad_close);
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.b.a$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                a.b(view);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.interstitial.adapter.b.a$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.c(view);
            }
        });
    }

    protected void m() {
        if (Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "initView mContext is null", new Object[0]);
        } else if (Objects.isNull(this.f3528a)) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "initView mBaseAd is null", new Object[0]);
        } else {
            this.h = (ImageView) this.b.findViewById(R.id.ad_img_container);
            n();
        }
    }

    protected void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        com.hihonor.adsdk.common.b.b.hnadsc(i, "displayPictureTextView adCloseImage setOnClickListener", new Object[0]);
        b();
    }

    protected void a(Context context, List<String> list, int i2, ImageView imageView, TrackUrl trackUrl) {
        com.hihonor.adsdk.common.b.b.hnadsc(i, "Call load image.", new Object[0]);
        if (this.f3528a != null && imageView != null) {
            com.hihonor.adsdk.common.b.b.hnadsc(i, "###### Call load adImageView height  " + imageView.getLayoutParams().height, new Object[0]);
            GlideLoadBuild.Builder imageView2 = new GlideLoadBuild.Builder().setContext(context).setNeedReport(true).setUrl((list == null || list.size() <= i2) ? null : list.get(i2)).setBaseEventBean(com.hihonor.adsdk.base.g.j.g.b.hnadsa(this.f3528a)).setAdUnitId(this.f3528a.getAdUnitId()).setPartCornerRadiuss(j()).setCornerRadius(i()).setDefaultDrawableColorId(R.color.honor_ads_magic_card_bg).setImageView(imageView);
            imageView2.setCommonTrackUrls(trackUrl.getCommons());
            imageView2.build().loadImage();
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(i, "baseAd or adImageView is null!", new Object[0]);
    }
}
