package com.hihonor.adsdk.banner.api;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.hihonor.adsdk.banner.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.AutoScaleSizeRelativeLayout;
import com.hihonor.adsdk.common.f.k;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends e {
    private static final String s = "PictureBannerViewHolder";
    private final AutoScaleSizeRelativeLayout p;
    private int q;
    private int r;

    public g(View view) {
        super(view);
        this.p = (AutoScaleSizeRelativeLayout) view.findViewById(R.id.hiad_banner_ad);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    public void a(int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(s, "setAdSize,width=%s,height=%s", Integer.valueOf(i), Integer.valueOf(i2));
        this.q = i;
        this.r = i2;
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void l() {
        BaseAd baseAd = this.b;
        if (baseAd == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(s, "setLayoutSize,ad is null,return", new Object[0]);
            return;
        }
        int imgWidth = baseAd.getImgWidth();
        int imgHeight = this.b.getImgHeight();
        if (this.q * this.r <= 0) {
            com.hihonor.adsdk.common.b.b.hnadsc(s, "setAdSize,invalid size param and use size from cloud!!!", new Object[0]);
            this.q = imgWidth;
            this.r = imgHeight;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(s, "setLayoutSize,baseAd imageWidth=%d,imageHeight=%d", Integer.valueOf(imgWidth), Integer.valueOf(imgHeight));
        if (imgHeight != 0) {
            this.p.setRatio(imgWidth / imgHeight);
        }
        ViewGroup.LayoutParams layoutParams = this.p.getLayoutParams();
        layoutParams.width = -2;
        layoutParams.height = -2;
        this.p.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(layoutParams);
        layoutParams2.width = this.q;
        layoutParams2.height = this.r;
        layoutParams2.addRule(4);
        this.p.setGravity(17);
        this.p.setLayoutParams(layoutParams2);
        this.p.setRectCornerRadius(this.f3503a);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void a(BaseAd baseAd) {
        super.a(baseAd);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void a() {
        if (this.hnadsb != null && !Objects.isNull(this.b)) {
            int dimension = (int) this.c.getResources().getDimension(R.dimen.honor_ads_magic_dimens_element_horizontal_small);
            this.hnadsb.setViewPadding(dimension, dimension, dimension, dimension);
            this.hnadsb.setCloseIconDrawable(k.hnadsa(this.c, R.drawable.ic_honor_ads_banner_close));
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(s, "baseAd or adClose view is invalid,return", new Object[0]);
    }
}
