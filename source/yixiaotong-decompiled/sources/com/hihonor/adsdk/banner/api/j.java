package com.hihonor.adsdk.banner.api;

import android.text.TextUtils;
import android.view.View;
import com.hihonor.adsdk.banner.R;
import com.hihonor.adsdk.base.api.BaseAd;
import java.text.MessageFormat;
import java.util.Objects;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class j extends f {
    private static final double A = 0.75d;
    private static final String y = "PictureTextDownloadBannerViewHolder";
    private static final String z = "·";

    public j(View view) {
        super(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        int measuredWidth = view.getMeasuredWidth();
        com.hihonor.adsdk.common.b.b.hnadsc(y, "renderDownloadTextView#containerMeasuredWidth = %s", Integer.valueOf(measuredWidth));
        this.f.setMaxWidth((int) (((double) measuredWidth) * A));
    }

    @Override // com.hihonor.adsdk.banner.api.f, com.hihonor.adsdk.banner.api.e
    protected void a(BaseAd baseAd) {
        super.a(baseAd);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void b() {
        if (this.h == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(y, "baseAd or adFlag view is invalid,return", new Object[0]);
            return;
        }
        int adFlag = this.b.getAdFlag();
        com.hihonor.adsdk.common.b.b.hnadsc(y, "initAdFlagView,adFlag: " + adFlag, new Object[0]);
        if (TextUtils.isEmpty(this.b.getBrand()) || adFlag == 0) {
            this.h.setText(this.c.getResources().getString(R.string.ads_ad_flag));
        } else {
            this.h.setText(MessageFormat.format("{0}{1}", this.c.getResources().getString(R.string.ads_ad_flag), z));
        }
        this.h.setVisibility(adFlag == 0 ? 8 : 0);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void c() {
        super.c();
        if (this.f == null || !Objects.nonNull(this.b) || TextUtils.isEmpty(this.b.getBrand())) {
            return;
        }
        this.f.setTag(R.id.ad_common_click_type_tag, 2);
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.hihonor.adsdk.banner.api.j$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.hnadsa(view);
            }
        });
        final View viewHnadsa = hnadsa(R.id.banner_text);
        if (viewHnadsa != null) {
            viewHnadsa.post(new Runnable() { // from class: com.hihonor.adsdk.banner.api.j$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.k(viewHnadsa);
                }
            });
        }
    }

    @Override // com.hihonor.adsdk.banner.api.f, com.hihonor.adsdk.banner.api.e
    protected void a() {
        if (this.hnadsb == null || Objects.isNull(this.b)) {
            com.hihonor.adsdk.common.b.b.hnadse(y, "baseAd or adClose view is invalid,return", new Object[0]);
        } else {
            this.hnadsb.setVisibility(this.b.getCloseFlag() == 0 ? 8 : 0);
        }
    }
}
