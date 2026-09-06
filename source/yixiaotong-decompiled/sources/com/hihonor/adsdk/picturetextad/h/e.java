package com.hihonor.adsdk.picturetextad.h;

import android.view.View;
import android.widget.ImageView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class e extends d {
    private static final String s = "SmallPictureViewHolder";
    private static final String t = "3:2";
    private static final float u = 1.0f;
    private final ImageView r;

    public e(View view) {
        super(view);
        this.r = (ImageView) hnadsa(R.id.ad_image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(BaseAd baseAd) {
        a(this.b, baseAd, baseAd.getImages(), 0, this.r, baseAd.getTrackUrl());
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    public void a(final BaseAd baseAd) {
        super.a(baseAd);
        if (baseAd == null) {
            return;
        }
        String str = baseAd.getImgWidth() + x.bQ + baseAd.getImgHeight();
        if (baseAd.getProportion() <= 0.0f) {
            str = t;
        }
        a(this.r, str);
        o(baseAd);
        this.hnadsa.post(new Runnable() { // from class: com.hihonor.adsdk.picturetextad.h.e$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n(baseAd);
            }
        });
        c();
    }

    protected void o(BaseAd baseAd) {
        if (this.d == null) {
            return;
        }
        float f = this.b.getResources().getConfiguration().fontScale;
        com.hihonor.adsdk.common.b.b.hnadsc(s, "fontScale:" + f, new Object[0]);
        if (f <= 1.0f || baseAd.getPromotionPurpose() == 0 || baseAd.getPromotionPurpose() == 4) {
            this.d.setMaxLines(2);
        } else {
            this.d.setMaxLines(1);
        }
    }
}
