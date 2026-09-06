package com.hihonor.adsdk.banner.api;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.hihonor.adsdk.banner.R;
import com.hihonor.adsdk.base.api.BaseAd;
import java.text.MessageFormat;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class i extends f {
    private static final String A = "·";
    private static final String z = "PictureTextBannerViewHolder";
    private final TextView y;

    public i(View view) {
        super(view);
        this.y = (TextView) view.findViewById(R.id.ad_flag_view);
    }

    @Override // com.hihonor.adsdk.banner.api.f, com.hihonor.adsdk.banner.api.e
    protected void a(BaseAd baseAd) {
        super.a(baseAd);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void b() {
        if (this.y == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(z, "baseAd or adFlag view is invalid,return", new Object[0]);
            return;
        }
        int adFlag = this.b.getAdFlag();
        com.hihonor.adsdk.common.b.b.hnadsc(z, "initAdFlagView,adFlag: " + adFlag, new Object[0]);
        if (TextUtils.isEmpty(this.b.getBrand()) || adFlag == 0) {
            this.y.setText(this.c.getResources().getString(R.string.ads_ad_flag));
        } else {
            this.y.setText(MessageFormat.format("{0}{1}", this.c.getResources().getString(R.string.ads_ad_flag), A));
        }
        this.y.setVisibility(adFlag == 0 ? 8 : 0);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void i() {
        super.i();
        if (this.g == null || !Objects.nonNull(this.b) || TextUtils.isEmpty(this.b.getTitle())) {
            return;
        }
        this.g.setTag(R.id.ad_common_click_type_tag, 2);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.i$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsa(view);
            }
        });
    }

    @Override // com.hihonor.adsdk.banner.api.f, com.hihonor.adsdk.banner.api.e
    protected void a() {
        if (this.hnadsb == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(z, "baseAd or adClose view is invalid,return", new Object[0]);
        } else {
            this.hnadsb.setVisibility(this.b.getCloseFlag() == 0 ? 8 : 0);
        }
    }
}
