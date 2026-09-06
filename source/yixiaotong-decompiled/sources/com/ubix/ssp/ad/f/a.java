package com.ubix.ssp.ad.f;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.q;
import com.ubix.ssp.ad.e.t.a.e;
import com.ubix.ssp.ad.g.k.d;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends com.ubix.ssp.ad.b {
    private int l;
    private int m;
    private int n;
    private int o;
    private double p;
    private d q;

    public a(Context context) {
        super(context);
    }

    private void s() {
        e eVar = new e(getContext());
        ImageView imageView = new ImageView(getContext());
        ImageView imageView2 = new ImageView(getContext());
        eVar.setId(600001);
        imageView.setId(600002);
        imageView2.setId(600004);
        eVar.setScaleType(ImageView.ScaleType.FIT_XY);
        eVar.setSupportRound(false);
        addView(eVar);
        addView(imageView);
        addView(imageView2);
    }

    @Override // com.ubix.ssp.ad.b
    protected void a(Context context, Bundle bundle) {
        int iMin;
        double d;
        double d2;
        this.n = r.a().h(context);
        this.o = r.a().c(context);
        int i = bundle.getInt("AD_WIDTH");
        int i2 = bundle.getInt("AD_HEIGHT");
        double dA = r.a().a(context);
        this.p = dA;
        if (i == -1 && i2 == -2) {
            int i3 = (int) (dA * 80.0d);
            this.m = i3;
            this.l = i3;
        } else {
            if (Math.min(i, i2) <= 60) {
                d = this.p;
                d2 = 60.0d;
            } else {
                if (Math.min(i, i2) >= 100) {
                    d = this.p;
                    d2 = 100.0d;
                } else {
                    this.l = (int) (((double) Math.min(i, i2)) * this.p);
                    iMin = (int) (((double) Math.min(i, i2)) * this.p);
                }
                this.m = iMin;
            }
            iMin = (int) (d * d2);
            this.l = iMin;
            this.m = iMin;
        }
        s();
    }

    @Override // com.ubix.ssp.ad.b
    public boolean b(Bundle bundle) {
        try {
            com.ubix.ssp.ad.e.v.e.b().a(bundle.getStringArray("IMAGE_URL")[0], (ImageView) findViewById(600001), -1, null);
            ImageView imageView = (ImageView) findViewById(600002);
            ImageView imageView2 = (ImageView) findViewById(600004);
            if (imageView != null) {
                imageView.setImageDrawable(q.a("ubix/ic_logo_dark_bg.webp", bundle.getBoolean("IS_UNNAMED")));
            }
            if (imageView2 == null) {
                return true;
            }
            imageView2.setImageDrawable(q.a("ubix/ic_close_gray.webp"));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.ubix.ssp.ad.b
    public com.ubix.ssp.ad.g.k.b getInterface() {
        return this.q;
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            switch (childAt.getId()) {
                case 600001:
                    childAt.layout(0, 0, this.l, this.m);
                    break;
                case 600002:
                    double bottom = findViewById(600001).getBottom();
                    double d = this.p;
                    childAt.layout(0, (int) (bottom - (6.36d * d)), (int) (d * 14.0d), findViewById(600001).getBottom());
                    break;
                case 600004:
                    childAt.layout((int) (((double) findViewById(600001).getRight()) - (this.p * 12.0d)), findViewById(600001).getTop(), findViewById(600001).getRight(), (int) (((double) findViewById(600001).getTop()) + (this.p * 12.0d)));
                    break;
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.l, this.m);
    }

    @Override // com.ubix.ssp.ad.b
    public <T extends com.ubix.ssp.ad.g.k.b> void setInnerListener(T t) {
        this.q = (d) t;
    }
}
