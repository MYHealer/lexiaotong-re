package com.ubix.ssp.ad.i.e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class k extends a {
    private boolean l0;

    public k(Context context) {
        super(context);
        this.l0 = false;
    }

    @Override // com.ubix.ssp.ad.i.e.a
    public void a() {
        com.ubix.ssp.ad.d.f fVar = (com.ubix.ssp.ad.d.f) findViewById(2060001);
        if (fVar != null) {
            fVar.a();
        }
        super.a();
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
        this.c = new RelativeLayout.LayoutParams(-1, -2);
        this.d = new RelativeLayout.LayoutParams(-1, -2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.i = new RelativeLayout.LayoutParams(-1, -2);
        this.d.addRule(10);
        this.c.addRule(3, 2010003);
        this.c.setMargins(0, r.b(2.0f), 0, 0);
        com.ubix.ssp.ad.d.f fVar = new com.ubix.ssp.ad.d.f(getContext(), bundle);
        fVar.setId(2060001);
        this.k.addView(this.l, this.d);
        this.k.addView(fVar, this.d);
        layoutParams.addRule(13);
        addView(this.k);
        addView(this.n, this.c);
        if (TextUtils.isEmpty(this.w)) {
            this.n.setVisibility(8);
        }
        if (i()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, Math.min(150, this.E / 7));
            this.j = layoutParams2;
            layoutParams2.addRule(3, DoorLockCommandUtil.DELECTUSERIDCODE);
            this.i.addRule(3, 2010002);
            this.j.setMargins(0, r.b(2.0f), 0, 0);
            addView(c(), this.j);
        } else {
            this.i.addRule(3, DoorLockCommandUtil.DELECTUSERIDCODE);
        }
        this.i.setMargins(0, r.b(2.0f), 0, 0);
        addView(e(), this.i);
        this.k.addView(h(), new ViewGroup.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        fVar.addView(g(), layoutParams3);
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
