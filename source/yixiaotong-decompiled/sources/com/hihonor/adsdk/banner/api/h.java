package com.hihonor.adsdk.banner.api;

import android.view.View;
import android.widget.TextView;
import com.hihonor.adsdk.banner.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.k;
import com.hihonor.adsdk.common.f.w;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class h extends g {
    private static final String u = "PictureDownloadBannerViewHolder";
    private final TextView t;

    public h(View view) {
        super(view);
        this.t = (TextView) view.findViewById(R.id.ad_flag_view);
    }

    private void m() {
        w.hnadsa(this.t, hnadsa(R.id.factor_dividing_0), this.i, hnadsa(R.id.factor_dividing_1), this.j, hnadsa(R.id.factor_dividing_2), this.k, hnadsa(R.id.factor_dividing_3), this.l, hnadsa(R.id.factor_dividing_4), this.m);
    }

    @Override // com.hihonor.adsdk.banner.api.g, com.hihonor.adsdk.banner.api.e
    protected void a(BaseAd baseAd) {
        super.a(baseAd);
        m();
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void b() {
        if (this.t == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(u, "baseAd or adFlag view is invalid,return", new Object[0]);
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadsc(u, "initAdFlagView,adFlag: " + this.b.getAdFlag(), new Object[0]);
        this.t.setText(this.c.getResources().getString(R.string.ads_ad_flag));
    }

    @Override // com.hihonor.adsdk.banner.api.g, com.hihonor.adsdk.banner.api.e
    protected void a() {
        if (this.hnadsb != null && !Objects.isNull(this.b)) {
            int dimension = (int) this.c.getResources().getDimension(R.dimen.honor_ads_magic_dimens_element_horizontal_small);
            this.hnadsb.setViewPadding(dimension, dimension, dimension, dimension);
            this.hnadsb.setCloseIconDrawable(k.hnadsa(this.c, R.drawable.ic_honor_ads_banner_close));
            return;
        }
        com.hihonor.adsdk.common.b.b.hnadse(u, "baseAd or adClose view is invalid,return", new Object[0]);
    }
}
