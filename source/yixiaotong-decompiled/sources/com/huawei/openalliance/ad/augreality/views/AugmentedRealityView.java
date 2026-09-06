package com.huawei.openalliance.ad.augreality.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.dj;
import com.huawei.hms.ads.dk;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.views.AutoScaleSizeRelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class AugmentedRealityView extends AutoScaleSizeRelativeLayout implements a {
    private static final String I = "AugmentedRealityView";
    private dj B;
    protected Context Code;
    protected AdContentData V;

    public AugmentedRealityView(Context context) {
        super(context);
        Code(context);
    }

    public AugmentedRealityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
    }

    public AugmentedRealityView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
    }

    private void Code(Context context) {
        this.Code = context;
        LayoutInflater.from(context).inflate(R.layout.hiad_ar_view, this);
        this.B = new dj(this.Code, this);
    }

    @Override // com.huawei.openalliance.ad.augreality.views.a
    public dk getPresenter() {
        return this.B;
    }

    @Override // com.huawei.openalliance.ad.augreality.views.a
    public void setAdContentData(AdContentData adContentData) {
        if (adContentData != null) {
            if (this.V == null) {
                this.V = adContentData;
            }
            this.B.Code(this.V);
        }
    }
}
