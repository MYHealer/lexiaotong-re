package com.hihonor.adsdk.picturetextad.h;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.base.widget.RadiusConstrainLayout;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.video.AdVideoSize;
import com.hihonor.adsdk.picturetextad.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class g extends h {
    private static final String F = "VerticalVideoViewHolder";
    private final RadiusConstrainLayout E;

    public g(View view) {
        super(view);
        this.E = (RadiusConstrainLayout) hnadsa(R.id.layout_radius);
    }

    private void i() {
        View view = this.t;
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "adVideoVolumeTimeLayout is null", new Object[0]);
            return;
        }
        Drawable background = view.getBackground();
        if (!(background instanceof GradientDrawable) || this.c <= 0.0f) {
            return;
        }
        GradientDrawable gradientDrawable = (GradientDrawable) background;
        if (u.hnadsk()) {
            float f = this.c;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, 0.0f, 0.0f});
        } else {
            float f2 = this.c;
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f2, f2});
        }
    }

    @Override // com.hihonor.adsdk.picturetextad.h.h, com.hihonor.adsdk.picturetextad.h.d
    public void a(BaseAd baseAd) {
        super.a(baseAd);
        RadiusConstrainLayout radiusConstrainLayout = this.E;
        if (radiusConstrainLayout != null) {
            float f = this.c;
            if (f > 0.0f) {
                radiusConstrainLayout.setRadius(f);
            }
        }
        i();
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    protected void e(BaseAd baseAd) {
        if (this.h == null) {
            return;
        }
        if (TextUtils.isEmpty(baseAd.getBrand())) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "brand is null", new Object[0]);
            this.h.setVisibility(4);
        } else {
            this.h.setVisibility(0);
            this.h.setText(baseAd.getBrand());
        }
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    protected void f(BaseAd baseAd) {
        if (this.m == null) {
            return;
        }
        if (TextUtils.isEmpty(baseAd.getDeveloperName())) {
            com.hihonor.adsdk.common.b.b.hnadsc(F, "developName is null", new Object[0]);
            this.m.setVisibility(4);
        } else {
            this.m.setVisibility(0);
            this.m.setText(baseAd.getDeveloperName());
        }
    }

    @Override // com.hihonor.adsdk.picturetextad.h.h
    protected boolean h() {
        return false;
    }

    @Override // com.hihonor.adsdk.picturetextad.h.h
    protected void a(AdVideoSize adVideoSize) {
        this.r.setVideoViewSize(adVideoSize, 2, u.hnadsa(192.0f));
    }
}
