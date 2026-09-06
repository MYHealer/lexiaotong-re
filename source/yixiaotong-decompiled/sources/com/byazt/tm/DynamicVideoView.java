package com.byazt.tm;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.byazt.aq.x;
import com.google.android.material.badge.BadgeDrawable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 48, 504})
public class DynamicVideoView extends DynamicBaseWidgetImp implements com.byazt.kn.n {
    public TextView c;
    public boolean gt;
    public FrameLayout tt;

    @Override // com.byazt.tm.DynamicBaseWidget
    public boolean uj() {
        return true;
    }

    public DynamicVideoView(Context context, DynamicRootView dynamicRootView, x xVar) {
        super(context, dynamicRootView, xVar);
        this.gt = false;
        this.z = new View(context);
        this.z.setTag(Integer.valueOf(getClickArea()));
        this.c = new TextView(context);
        this.tt = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) com.byazt.or.x.c(context, 40.0f), (int) com.byazt.or.x.c(context, 15.0f));
        layoutParams.gravity = BadgeDrawable.BOTTOM_END;
        layoutParams.rightMargin = 20;
        layoutParams.bottomMargin = 20;
        this.c.setLayoutParams(layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(25.0f);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.c.setBackground(gradientDrawable);
        this.c.setTextSize(10.0f);
        this.c.setGravity(17);
        this.c.setTextColor(-1);
        this.c.setVisibility(8);
        if (com.byazt.sr.uj.c()) {
            addView(this.tt, new FrameLayout.LayoutParams(-1, -1));
        }
        addView(this.c);
        addView(this.z, getWidgetLayoutParams());
        if (!com.byazt.sr.uj.c()) {
            addView(this.tt, getWidgetLayoutParams());
        }
        dynamicRootView.ve = this.tt;
        dynamicRootView.setVideoListener(this);
    }

    @Override // com.byazt.tm.DynamicBaseWidgetImp, com.byazt.tm.uj
    public boolean x() {
        super.x();
        double dN = 0.0d;
        double dUj = 0.0d;
        for (x xVarT = this.u; xVarT != null; xVarT = xVarT.t()) {
            double dA = dUj + ((double) xVarT.a());
            double dSp = dN + ((double) xVarT.sp());
            dUj = dA - ((double) xVarT.uj());
            dN = dSp - ((double) xVarT.n());
        }
        try {
            float f = (float) dUj;
            int iC = (int) com.byazt.or.x.c(getContext(), f);
            int iC2 = (int) com.byazt.or.x.c(getContext(), f + this.n);
            if (com.byazt.or.ve.c(getContext())) {
                DynamicRoot dynamicRoot = (DynamicRoot) this.yp.getChildAt(0);
                int dynamicWidth = dynamicRoot.getDynamicWidth();
                int i = dynamicWidth - iC2;
                iC2 = dynamicWidth - iC;
                iC = i;
            }
            if (!"open_ad".equals(this.yp.getRenderRequest().a())) {
                DynamicRoot dynamicRoot2 = (DynamicRoot) this.yp.getChildAt(0);
                float f2 = (float) dN;
                dynamicRoot2.c.update(iC, (int) com.byazt.or.x.c(getContext(), f2), iC2, (int) com.byazt.or.x.c(getContext(), f2 + this.f2748a));
            } else {
                this.yp.ve = this.tt;
            }
        } catch (Exception unused) {
        }
        this.yp.c(dUj, dN, this.n, this.f2748a, this.t.z());
        return true;
    }

    @Override // com.byazt.kn.n
    public void setTimeUpdate(int i) {
        String str;
        if (this.u.da().n().w() && i > 0 && !this.gt) {
            String str2 = (i >= 60 ? "0" + (i / 60) : "00") + com.huawei.openalliance.ad.constant.x.bQ;
            int i2 = i % 60;
            if (i2 > 9) {
                str = str2 + i2;
            } else {
                str = str2 + "0" + i2;
            }
            this.c.setText(str);
            this.c.setVisibility(0);
            return;
        }
        this.gt = true;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            ve(getChildAt(i3));
        }
        this.c.setVisibility(8);
    }

    private void ve(View view) {
        if (view == this.c || view == this.my) {
            return;
        }
        try {
            if (((Integer) view.getTag(com.byazt.kn.c.f2418a)).intValue() == 1) {
                return;
            }
        } catch (Throwable unused) {
        }
        int i = 0;
        view.setVisibility(0);
        if (!(view instanceof ViewGroup)) {
            return;
        }
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            ve(viewGroup.getChildAt(i));
            i++;
        }
    }
}
