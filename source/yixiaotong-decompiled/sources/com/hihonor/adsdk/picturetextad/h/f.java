package com.hihonor.adsdk.picturetextad.h;

import android.view.View;
import android.widget.ImageView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class f extends d {
    private static final String u = "ThreePictureAdViewHolder";
    private static final String v = "3:2";
    private final ImageView r;
    private final ImageView s;
    private final ImageView t;

    public f(View view) {
        super(view);
        this.r = (ImageView) hnadsa(R.id.ad_image);
        this.s = (ImageView) hnadsa(R.id.ad_image2);
        this.t = (ImageView) hnadsa(R.id.ad_image3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(BaseAd baseAd) {
        a(this.b, baseAd, baseAd.getImages(), 0, this.r, baseAd.getTrackUrl());
        a(this.b, baseAd, baseAd.getImages(), 1, this.s, baseAd.getTrackUrl());
        a(this.b, baseAd, baseAd.getImages(), 2, this.t, baseAd.getTrackUrl());
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    public void a(final BaseAd baseAd) {
        super.a(baseAd);
        if (baseAd == null) {
            return;
        }
        String str = baseAd.getImgWidth() + x.bQ + baseAd.getImgHeight();
        if (baseAd.getProportion() <= 0.0f) {
            str = v;
        }
        a(this.r, str);
        a(this.s, str);
        a(this.t, str);
        this.hnadsa.post(new Runnable() { // from class: com.hihonor.adsdk.picturetextad.h.f$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n(baseAd);
            }
        });
        c();
    }
}
