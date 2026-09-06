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
public class g extends a {
    public g(Context context) {
        super(context);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void a(String[] strArr, String[] strArr2) {
        super.a(strArr[0]);
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void c(Bundle bundle) {
        this.i = new RelativeLayout.LayoutParams(-2, -2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.y, this.z);
        this.d = layoutParams;
        layoutParams.addRule(10);
        this.c.addRule(10);
        this.c.addRule(1, DoorLockCommandUtil.AUTHFAILCODE);
        this.c.setMargins(r.b(6.0f), 0, 0, 0);
        this.i.addRule(1, DoorLockCommandUtil.AUTHFAILCODE);
        this.i.addRule(8, DoorLockCommandUtil.AUTHFAILCODE);
        this.i.setMargins(r.b(6.0f), 0, 0, 0);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setId(2050001);
        this.k.addView(this.l, this.d);
        this.k.addView(relativeLayout, this.d);
        this.k.addView(this.n, this.c);
        this.k.addView(e(), this.i);
        addView(this.k);
        if (i()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
            this.j = layoutParams2;
            layoutParams2.addRule(3, 2010003);
            this.j.addRule(9);
            this.j.setMargins(0, r.b(2.0f), 0, 0);
            addView(c(), this.j);
        }
    }

    @Override // com.ubix.ssp.ad.i.e.a
    protected void l() {
        TextView textView;
        double dA = r.a().a(getContext());
        this.n.setMaxLines(2);
        if (this.n.getLayoutParams() != null) {
            this.n.getLayoutParams().width = this.E - (this.y + r.b(6.0f));
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(2010001);
        if (relativeLayout != null && relativeLayout.getLayoutParams() != null) {
            relativeLayout.getLayoutParams().width = this.E - (this.y + r.b(6.0f));
        }
        this.l.getLayoutParams().width = this.y;
        this.l.getLayoutParams().height = this.z;
        this.k.getLayoutParams().width = this.E;
        this.k.getLayoutParams().height = this.z;
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(2010002);
        if (relativeLayout2 != null && (textView = (TextView) findViewById(920101)) != null) {
            relativeLayout2.getLayoutParams().height = (textView.getLineCount() + 1) * textView.getLineHeight();
        }
        ImageView imageView = (ImageView) findViewById(910101);
        if (imageView != null && imageView.getLayoutParams() != null) {
            int iMin = (int) Math.min(34.0d * dA, ((double) this.l.getMeasuredHeight()) * 0.85d);
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
        relativeLayout3.getLayoutParams().height = (int) Math.min(dA * 36.0d, ((double) this.l.getMeasuredHeight()) * 0.95d);
    }
}
