package com.hihonor.adsdk.picturetextad.h;

import android.view.View;
import android.widget.ImageView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;
import com.huawei.openalliance.ad.constant.x;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends d {
    private static final String s = "BigPictureAdViewHolder";
    private static final String t = "16:9";
    private final ImageView r;

    public b(View view) {
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
            com.hihonor.adsdk.common.b.b.hnadse(s, "baseAd is null.", new Object[0]);
            return;
        }
        String str = baseAd.getImgWidth() + x.bQ + baseAd.getImgHeight();
        if (baseAd.getProportion() <= 0.0f) {
            str = t;
        }
        a(this.r, str);
        this.hnadsa.post(new Runnable() { // from class: com.hihonor.adsdk.picturetextad.h.b$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n(baseAd);
            }
        });
        c();
    }
}
