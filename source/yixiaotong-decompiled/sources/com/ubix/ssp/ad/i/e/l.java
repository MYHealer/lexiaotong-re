package com.ubix.ssp.ad.i.e;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class l extends a {
    private boolean l0;

    public l(Context context) {
        super(context);
        this.l0 = false;
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void a(String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length > 0) {
            super.a(strArr[0], (ImageView) findViewById(200024));
        }
        if (strArr2 != null && strArr2.length > 0) {
            super.b(strArr2);
        }
        ImageView imageView = (ImageView) findViewById(DoorLockCommandUtil.B4FAILCODE);
        if (imageView != null) {
            imageView.setImageDrawable(q.a("ubix/ic_logo.png", this.f0));
        }
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void c(Bundle bundle) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(r.b(11.0f), r.b(11.0f));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        this.c = new RelativeLayout.LayoutParams(-1, -2);
        this.d = new RelativeLayout.LayoutParams(-1, -2);
        this.i = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.rightMargin = r.b(5.0f);
        layoutParams.topMargin = r.b(5.0f);
        this.d.addRule(10);
        this.c.addRule(3, 2010003);
        if (TextUtils.isEmpty(this.w)) {
            this.n.setVisibility(8);
        } else {
            this.c.setMargins(r.b(3.0f), r.b(6.0f), r.b(3.0f), r.b(6.0f));
        }
        com.ubix.ssp.ad.d.f fVar = new com.ubix.ssp.ad.d.f(getContext(), bundle);
        fVar.setId(2060001);
        this.k.addView(this.l, this.d);
        this.k.addView(fVar, this.d);
        layoutParams2.addRule(13);
        addView(this.k);
        addView(this.n, this.c);
        if (i()) {
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
            this.j = layoutParams3;
            layoutParams3.addRule(10);
            this.j.addRule(0, 2000014);
            this.j.setMargins(r.b(2.0f), r.b(4.0f), r.b(2.0f), 0);
            this.k.addView(d(), this.j);
        }
        this.i.addRule(12);
        this.i.setMargins(r.b(4.0f), r.b(2.0f), r.b(4.0f), 0);
        this.k.addView(b(false), this.i);
        this.n.setTextSize(this.I);
        this.n.setSingleLine();
        this.o.setBackground(q.a("ubix/ic_close_gray.webp"));
        this.k.addView(this.o, layoutParams);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(2, 2010001);
        layoutParams4.addRule(3, 2000014);
        View view = new View(getContext());
        view.setId(200025);
        fVar.addView(view);
        fVar.addView(g(), layoutParams4);
        this.k.addView(h(), new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void l() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = this.l.getLayoutParams();
        int i = this.E;
        layoutParams2.width = i;
        layoutParams2.height = (i * 16) / 9;
        this.l.setLayoutParams(layoutParams2);
        this.l.invalidate();
        ViewGroup.LayoutParams layoutParams3 = this.k.getLayoutParams();
        int i2 = this.E;
        layoutParams3.width = i2;
        layoutParams3.height = (i2 * 16) / 9;
        this.k.setLayoutParams(layoutParams3);
        this.k.requestLayout();
        View viewFindViewById = findViewById(200100);
        if (viewFindViewById != null && (layoutParams = viewFindViewById.getLayoutParams()) != null) {
            layoutParams.width = this.E - r.b(20.0f);
        }
        ImageView imageView = (ImageView) findViewById(DoorLockCommandUtil.B4FAILCODE);
        if (imageView != null && imageView.getLayoutParams() != null) {
            imageView.getLayoutParams().width = r.b(15.0f);
            imageView.getLayoutParams().height = r.b(7.0f);
        }
        TextView textView = (TextView) findViewById(DoorLockCommandUtil.B80FAILCODE);
        if (textView != null) {
            textView.setTextColor(-1);
            textView.setShadowLayer(3.0f, 0.0f, 1.0f, 1711276032);
        }
        ImageView imageView2 = (ImageView) findViewById(200019);
        if (imageView2 != null && imageView2.getLayoutParams() != null) {
        }
        if (findViewById(2030001) != null) {
            findViewById(2030001).setBackgroundColor(0);
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setTextSize(TypedValue.applyDimension(0, Math.max(this.I, 12), getContext().getResources().getDisplayMetrics()));
        }
        View viewFindViewById2 = findViewById(200019);
        if (viewFindViewById2 != null) {
            viewFindViewById2.bringToFront();
        }
    }
}
