package com.ubix.ssp.ad.i.e;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class d extends a {
    public d(Context context) {
        super(context);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void a(String[] strArr, String[] strArr2) {
        super.a(strArr[0]);
        ImageView imageView = (ImageView) findViewById(DoorLockCommandUtil.B4FAILCODE);
        if (imageView != null) {
            imageView.setImageDrawable(q.a("ubix/ic_logo.png", this.f0));
        }
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void c(Bundle bundle) {
        this.i = new RelativeLayout.LayoutParams(-1, -2);
        this.d.addRule(10);
        this.c.addRule(12);
        this.k.addView(this.l, this.d);
        this.i.addRule(10);
        this.i.setMargins(r.b(6.0f), r.b(6.0f), r.b(6.0f), 0);
        this.k.addView(e(), this.i);
        this.k.addView(this.n, this.c);
        if (i()) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            this.j = layoutParams;
            layoutParams.addRule(3, 2010001);
            this.j.addRule(5, 2010001);
            this.j.addRule(7, 2010001);
            this.j.addRule(15);
            this.j.setMargins(0, 0, 0, 0);
            this.k.addView(d(), this.j);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.addRule(2, DoorLockCommandUtil.DELECTUSERIDCODE);
        layoutParams2.addRule(3, 2010001);
        this.k.addView(g(), layoutParams2);
        addView(this.k);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void l() {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
        if (layoutParams2 != null) {
            int i = this.E;
            layoutParams2.width = i;
            layoutParams2.height = (i * 9) / 16;
            this.k.setLayoutParams(layoutParams2);
        }
        com.ubix.ssp.ad.e.t.a.e eVar = this.l;
        if (eVar != null && eVar.getLayoutParams() != null) {
            this.l.getLayoutParams().width = this.E;
            this.l.getLayoutParams().height = (this.E * 9) / 16;
        }
        this.n.setMaxLines(1);
        this.n.setTextSize(this.K);
        this.n.setTextColor(-1);
        this.n.setPadding(r.b(6.0f), r.b(8.0f), r.b(6.0f), r.b(8.0f));
        this.n.setBackground(com.ubix.ssp.ad.e.a0.c.a(0, -1291845632, 8));
        TextView textView = (TextView) findViewById(DoorLockCommandUtil.B80FAILCODE);
        if (textView != null) {
            textView.setTextColor(-1);
            textView.setShadowLayer(3.0f, 0.0f, 3.0f, 1711276032);
        }
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setImageDrawable(q.a("ubix/ic_close_gray.webp"));
        }
        ImageView imageView2 = (ImageView) findViewById(DoorLockCommandUtil.B4FAILCODE);
        if (imageView2 != null) {
            imageView2.getLayoutParams().width = (int) (((double) ((this.E / 3) / 7)) * 1.4d);
            imageView2.getLayoutParams().height = (int) (((double) ((this.E / 6) / 7)) * 1.5d);
        }
        if (findViewById(2030001) != null) {
            findViewById(2030001).setBackgroundColor(0);
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(200100);
        if (viewGroup == null || (layoutParams = viewGroup.getLayoutParams()) == null) {
            return;
        }
        TextView textView2 = (TextView) findViewById(200018);
        TextView textView3 = (TextView) findViewById(200012);
        if (textView2 == null || textView3 == null) {
            return;
        }
        int measuredWidth = viewGroup.getMeasuredWidth();
        int iMeasureText = (int) textView3.getPaint().measureText("|权限");
        int iMeasureText2 = (int) textView2.getPaint().measureText(((Object) textView2.getText()) + "");
        if (measuredWidth > 0) {
            int i2 = iMeasureText * 2;
            int i3 = iMeasureText2 + i2;
            if (i3 >= measuredWidth) {
                textView2.getLayoutParams().width = measuredWidth - i2;
                layoutParams.width = measuredWidth;
            } else {
                textView2.getLayoutParams().width = iMeasureText2;
                layoutParams.width = i3;
            }
        }
    }
}
