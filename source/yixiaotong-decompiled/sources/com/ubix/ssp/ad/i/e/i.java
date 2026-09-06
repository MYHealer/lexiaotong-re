package com.ubix.ssp.ad.i.e;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.ubix.ssp.ad.e.a0.r;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class i extends a {
    public i(Context context) {
        super(context);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void a(String[] strArr, String[] strArr2) {
        super.a(strArr);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void c(Bundle bundle) {
        this.i = new RelativeLayout.LayoutParams(-1, -2);
        com.ubix.ssp.ad.e.t.a.e eVar = new com.ubix.ssp.ad.e.t.a.e(getContext());
        eVar.setId(DoorLockCommandUtil.SELECTKEYFAILCODE);
        com.ubix.ssp.ad.e.t.a.e eVar2 = new com.ubix.ssp.ad.e.t.a.e(getContext());
        eVar2.setId(DoorLockCommandUtil.RESETKEYFAILCODE);
        com.ubix.ssp.ad.e.t.a.e eVar3 = new com.ubix.ssp.ad.e.t.a.e(getContext());
        eVar3.setId(DoorLockCommandUtil.EACERRORCODE);
        eVar.setScaleType(ImageView.ScaleType.FIT_XY);
        eVar2.setScaleType(ImageView.ScaleType.FIT_XY);
        eVar3.setScaleType(ImageView.ScaleType.FIT_XY);
        eVar.setSupportRound(true);
        eVar2.setSupportRound(true);
        eVar3.setSupportRound(true);
        eVar.setBackgroundColor(-13421773);
        eVar2.setBackgroundColor(-13421773);
        eVar3.setBackgroundColor(-13421773);
        com.ubix.ssp.ad.e.t.a.e[] eVarArr = this.m;
        eVarArr[0] = eVar;
        eVarArr[1] = eVar2;
        eVarArr[2] = eVar3;
        this.c.addRule(10);
        double d = ((double) this.E) / 3.3d;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) d, (int) (d * 0.5625d));
        this.e = layoutParams;
        layoutParams.addRule(9);
        double d2 = ((double) this.E) / 3.3d;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) d2, (int) (d2 * 0.5625d));
        this.f = layoutParams2;
        layoutParams2.addRule(14);
        double d3 = ((double) this.E) / 3.3d;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) d3, (int) (d3 * 0.5625d));
        this.g = layoutParams3;
        layoutParams3.addRule(11);
        addView(this.n, this.c);
        this.k.addView(eVar, this.e);
        this.k.addView(eVar2, this.f);
        this.k.addView(eVar3, this.g);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2050001);
        this.k.addView(relativeLayout, this.f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        this.h = layoutParams4;
        layoutParams4.addRule(3, DoorLockCommandUtil.DELECTUSERIDCODE);
        this.h.setMargins(0, r.b(4.0f), 0, r.b(4.0f));
        addView(this.k, this.h);
        if (i()) {
            RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -2);
            this.j = layoutParams5;
            layoutParams5.addRule(3, 2010003);
            this.i.addRule(3, 2010002);
            addView(c(), this.j);
        } else {
            this.i.addRule(3, 2010003);
        }
        this.i.setMargins(0, r.b(2.0f), 0, 0);
        addView(e(), this.i);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void l() {
        TextView textView;
        double dA = r.a().a(getContext());
        this.m[0].getLayoutParams().width = this.A;
        this.m[0].getLayoutParams().height = this.B;
        this.m[1].getLayoutParams().width = this.A;
        this.m[1].getLayoutParams().height = this.B;
        this.m[2].getLayoutParams().width = this.A;
        this.m[2].getLayoutParams().height = this.B;
        this.k.getLayoutParams().width = this.E;
        this.k.getLayoutParams().height = this.B;
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2010001);
        if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
            relativeLayout.getLayoutParams().width = this.E;
        }
        this.n.getLayoutParams().width = this.E;
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2010002);
        if (relativeLayout2 != null && (textView = (TextView) findViewById(920101)) != null) {
            relativeLayout2.getLayoutParams().height = (textView.getLineCount() + 1) * textView.getLineHeight();
        }
        ImageView imageView = (ImageView) findViewById(910101);
        if (imageView != null && imageView.getLayoutParams() != null) {
            int iMin = (int) Math.min(34.0d * dA, ((double) this.B) * 0.85d);
            imageView.getLayoutParams().width = iMin;
            imageView.getLayoutParams().height = iMin;
            ViewGroup viewGroup = (ViewGroup) imageView.getParent();
            if (viewGroup != null) {
                viewGroup.getLayoutParams().width = iMin;
                viewGroup.getLayoutParams().height = iMin;
            }
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(2030001);
        if (relativeLayout3 == null || relativeLayout3.getLayoutParams() == null) {
            return;
        }
        findViewById(2030001).setBackgroundColor(0);
        relativeLayout3.getLayoutParams().height = (int) Math.min(dA * 36.0d, ((double) this.B) * 0.95d);
    }
}
