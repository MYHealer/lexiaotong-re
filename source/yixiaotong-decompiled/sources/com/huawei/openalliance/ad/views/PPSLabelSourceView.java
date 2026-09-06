package com.huawei.openalliance.ad.views;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.ads.base.R;
import com.huawei.hms.ads.gc;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.utils.z;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PPSLabelSourceView extends RelativeLayout {
    private boolean B;
    private boolean C;
    private PPSLabelView Code;
    private TextView I;
    private TextView V;

    public PPSLabelSourceView(Context context) {
        super(context, null);
        this.B = false;
        this.C = false;
    }

    public PPSLabelSourceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.B = false;
        this.C = false;
    }

    public PPSLabelSourceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.B = false;
        this.C = false;
    }

    public PPSLabelSourceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.B = false;
        this.C = false;
    }

    private void Code(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.Code.getParent();
        this.I.setBackgroundColor(getResources().getColor(R.color.hiad_transparent));
        Resources resources = getResources();
        if (z) {
            viewGroup.setBackgroundColor(resources.getColor(R.color.hiad_transparent));
            this.Code.setBackground(getResources().getDrawable(R.drawable.hiad_bg_ad_source));
            this.V.setBackground(getResources().getDrawable(R.drawable.hiad_bg_ad_source));
        } else {
            viewGroup.setBackground(resources.getDrawable(R.drawable.hiad_bg_ad_source));
            this.Code.setBackgroundColor(getResources().getColor(R.color.hiad_transparent));
            this.V.setBackgroundColor(getResources().getColor(R.color.hiad_transparent));
        }
        int iV = z.V(getContext(), getResources().getDimension(R.dimen.hiad_1_dp));
        viewGroup.setPadding(0, 0, 0, 0);
        this.Code.setPadding(iV, 0, z ? iV : 0, 0);
        this.I.setPadding(0, 0, iV, 0);
        this.V.setPadding(z ? iV : 0, 0, iV, 0);
        this.I.setTextAlignment(5);
    }

    private int V(boolean z) {
        return z ? R.layout.hiad_ad_label_source_with_click : R.layout.hiad_ad_label_source;
    }

    public void Code(Context context, boolean z) {
        if (!this.B) {
            this.C = z;
        }
        V(context, z);
        if (this.C != z) {
            this.C = z;
            Code(z);
        }
    }

    public void Code(PPSLabelView.a aVar, gc gcVar, AdContentData adContentData, boolean z) {
        PPSLabelView pPSLabelView = this.Code;
        if (pPSLabelView != null) {
            pPSLabelView.Code(aVar, gcVar, adContentData, z);
        }
    }

    public void V(Context context, boolean z) {
        if (!this.B) {
            inflate(context, V(z), this);
        }
        this.B = true;
        this.Code = (PPSLabelView) findViewById(R.id.hiad_ad_label);
        this.V = (TextView) findViewById(R.id.hiad_ad_source);
        this.I = (TextView) findViewById(R.id.hiad_ad_jump_text);
    }

    public TextView getAdJumpText() {
        return this.I;
    }

    public PPSLabelView getAdLabel() {
        return this.Code;
    }

    public TextView getAdSource() {
        return this.V;
    }
}
