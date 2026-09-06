package com.hihonor.adsdk.banner.api;

import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.banner.R;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.u;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public abstract class f extends e {
    private static final String t = "BasePictureTextBannerViewHolder";
    private static final int u = 360;
    private static final int v = 60;
    private static final int w = 225;
    private static final int x = 150;
    private int p;
    private int q;
    private int r;
    private final View s;

    public f(View view) {
        super(view);
        this.s = view.findViewById(R.id.hiad_banner_ad);
    }

    private void m() {
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            com.hihonor.adsdk.common.b.b.hnadse(t, "setImageViewSize,layoutParams cast error!", new Object[0]);
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        float f = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
        com.hihonor.adsdk.common.b.b.hnadsc(t, "setImageViewSize,verticalMargin = %s", Float.valueOf(f));
        int i = (int) (this.p - f);
        int i2 = (int) (i * 1.5f);
        com.hihonor.adsdk.common.b.b.hnadsc(t, "final image size : width = %s,height = %s", Integer.valueOf(i2), Integer.valueOf(i));
        marginLayoutParams.width = i2;
        marginLayoutParams.height = i;
        this.d.setLayoutParams(marginLayoutParams);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void a() {
    }

    @Override // com.hihonor.adsdk.banner.api.e
    public void a(int i, int i2) {
        com.hihonor.adsdk.common.b.b.hnadsc(t, "setAdSize,width=%s,height=%s", Integer.valueOf(i), Integer.valueOf(i2));
        int iHnadsa = u.hnadsa(360.0f);
        int iHnadsa2 = u.hnadsa(60.0f);
        com.hihonor.adsdk.common.b.b.hnadsc(t, "setAdSize,minimumWidthPxValue=%s,minimumHeightPxValue=%s", Integer.valueOf(iHnadsa), Integer.valueOf(iHnadsa2));
        this.q = Math.max(i, iHnadsa);
        this.r = Math.max(i2, iHnadsa2);
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void l() {
        com.hihonor.adsdk.common.b.b.hnadsc(t, "setLayoutSize : mSetupWidth = %s,mSetupHeight = %s", Integer.valueOf(this.q), Integer.valueOf(this.r));
        int i = this.q;
        float f = i;
        int i2 = this.r;
        float f2 = i2;
        if (f / f2 > 6.0f) {
            this.p = i2;
            i = (int) (f2 * 6.0f);
        } else {
            this.p = (int) (f / 6.0f);
        }
        com.hihonor.adsdk.common.b.b.hnadsc(t, "final banner size : width = %s,height = %s", Integer.valueOf(i), Integer.valueOf(this.p));
        ViewGroup.LayoutParams layoutParams = this.s.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = this.p;
        this.s.setLayoutParams(layoutParams);
        m();
    }

    @Override // com.hihonor.adsdk.banner.api.e
    protected void a(BaseAd baseAd) {
        super.a(baseAd);
    }
}
