package com.hihonor.adsdk.picturetextad.h;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hihonor.adsdk.base.api.BaseAd;
import com.hihonor.adsdk.picturetextad.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a extends d {
    private static final int s = 4;
    private final ImageView r;

    public a(View view) {
        super(view);
        this.r = (ImageView) view.findViewById(R.id.ad_image);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(BaseAd baseAd) {
        a(this.b, baseAd, baseAd.getImages(), 0, this.r, baseAd.getTrackUrl());
    }

    private void o(final BaseAd baseAd) {
        this.hnadsa.post(new Runnable() { // from class: com.hihonor.adsdk.picturetextad.h.a$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.n(baseAd);
            }
        });
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    public void a(BaseAd baseAd) {
        super.a(baseAd);
        o(baseAd);
        b();
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    protected void e(BaseAd baseAd) {
        TextView textView = this.h;
        if (textView == null || baseAd == null) {
            return;
        }
        textView.setText(baseAd.getBrand());
    }

    @Override // com.hihonor.adsdk.picturetextad.h.d
    protected void g(BaseAd baseAd) {
        if (this.n == null) {
            return;
        }
        if (baseAd.getAdFlag() == 0 || TextUtils.isEmpty(baseAd.getTitle())) {
            this.n.setVisibility(8);
        } else {
            this.n.setVisibility(0);
        }
    }
}
