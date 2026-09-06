package com.hihonor.adsdk.picturetextad.h;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.common.f.u;
import com.hihonor.adsdk.common.video.AdVideoSize;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class c extends h {
    private static final String E = "HorizontalVideoViewHolder";

    public c(View view) {
        super(view);
    }

    private void i() {
        View view = this.t;
        if (view == null) {
            com.hihonor.adsdk.common.b.b.hnadsc(E, "adVideoVolumeTimeLayout is null", new Object[0]);
            return;
        }
        Drawable background = view.getBackground();
        if (background instanceof GradientDrawable) {
            float f = this.c;
            if (f > 0.0f) {
                ((GradientDrawable) background).setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f});
            }
        }
    }

    @Override // com.hihonor.adsdk.picturetextad.h.h, com.hihonor.adsdk.picturetextad.h.d
    public void a(BaseAd baseAd) {
        super.a(baseAd);
        i();
        c();
    }

    @Override // com.hihonor.adsdk.picturetextad.h.h
    protected void a(AdVideoSize adVideoSize) {
        int measuredWidth = this.hnadsa.getMeasuredWidth();
        int paddingStart = this.hnadsa.getPaddingStart();
        int paddingEnd = this.hnadsa.getPaddingEnd();
        com.hihonor.adsdk.common.b.b.hnadsc(E, "rootVMesWidth :" + measuredWidth + ",rootPaddingStart: " + paddingStart + ",rootPaddingEnd: " + paddingEnd, new Object[0]);
        if (measuredWidth == 0) {
            measuredWidth = u.hnadsg();
        }
        this.r.setVideoViewSize(adVideoSize, 1, (measuredWidth - paddingStart) - paddingEnd);
    }
}
