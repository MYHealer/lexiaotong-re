package com.ubix.ssp.ad.i.e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends a {
    private boolean l0;

    public c(Context context) {
        super(context);
        this.l0 = false;
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void a(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length > 0) {
            super.a(strArr[0], (ImageView) findViewById(200024));
        }
        if (strArr2 == null || strArr2.length <= 0) {
            return;
        }
        super.b(strArr2);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void c(Bundle bundle) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, this.n.getId());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 0, 0, r.b(2.0f));
        layoutParams3.setMargins(0, 0, 0, r.b(2.0f));
        layoutParams5.addRule(3, this.n.getId());
        layoutParams4.addRule(13);
        com.ubix.ssp.ad.d.f fVar = new com.ubix.ssp.ad.d.f(getContext(), bundle);
        fVar.setId(2060001);
        this.k.addView(this.l, layoutParams5);
        this.k.addView(fVar, layoutParams5);
        addView(this.n, layoutParams2);
        if (TextUtils.isEmpty(this.w)) {
            this.n.setVisibility(8);
        }
        addView(this.k, layoutParams3);
        if (i()) {
            RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams6.addRule(3, 2010003);
            layoutParams.addRule(3, 2010002);
            layoutParams6.setMargins(0, 0, 0, r.b(2.0f));
            addView(c(), layoutParams6);
        } else {
            layoutParams.addRule(3, this.k.getId());
        }
        layoutParams.setMargins(0, r.b(2.0f), 0, 0);
        addView(e(), layoutParams);
        this.k.addView(h(), new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams7.addRule(12);
        fVar.addView(g(), layoutParams7);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void l() {
        TextView textView;
        ViewGroup.LayoutParams layoutParams = this.l.getLayoutParams();
        int i = this.E;
        layoutParams.width = i;
        layoutParams.height = (i * 9) / 16;
        this.l.setLayoutParams(layoutParams);
        this.l.invalidate();
        ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
        int i2 = this.E;
        layoutParams2.width = i2;
        layoutParams2.height = (i2 * 9) / 16;
        this.k.setLayoutParams(layoutParams2);
        this.k.requestLayout();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2010001);
        if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
            relativeLayout.getLayoutParams().width = this.E;
        }
        this.n.getLayoutParams().width = this.E;
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2010002);
        if (relativeLayout2 != null && (textView = (TextView) findViewById(920101)) != null) {
            relativeLayout2.getLayoutParams().height = (textView.getLineCount() + 1) * textView.getLineHeight();
        }
        View viewFindViewById = findViewById(200019);
        if (viewFindViewById != null) {
            viewFindViewById.bringToFront();
        }
    }
}
