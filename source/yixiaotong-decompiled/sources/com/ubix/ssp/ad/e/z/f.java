package com.ubix.ssp.ad.e.z;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ubix.ssp.ad.e.a0.l;
import com.ubix.ssp.ad.e.a0.r;
import com.ubix.ssp.ad.e.a0.u;
import com.ubix.ssp.ad.e.q;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends h implements View.OnClickListener {
    private TextView h;
    private ImageView i;
    private View j;
    private com.ubix.ssp.ad.e.c0.c k;
    private WindowManager l;
    private int m;
    private int n;
    private int o;
    private float p;

    public f(Context context) {
        super(context);
        this.m = 0;
        this.n = r.a().h(context);
        this.o = r.a().c(context);
        this.p = r.a().a(context);
        setBackgroundColor(-1);
        setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        d();
    }

    private void d() {
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.i = new ImageView(getContext());
        this.h = new TextView(getContext());
        this.j = new View(getContext());
        com.ubix.ssp.ad.e.c0.c cVar = new com.ubix.ssp.ad.e.c0.c(getContext());
        this.k = cVar;
        cVar.setWebChromeClient(new com.ubix.ssp.ad.e.c0.b(getContext(), null));
        this.k.setWebViewClient(new com.ubix.ssp.ad.e.c0.d(getContext(), null));
        this.i.setImageDrawable(q.a("ubix/ic_web_back.png"));
        this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.h.setTextColor(-13421773);
        relativeLayout.setId(20000);
        this.i.setId(20003);
        this.h.setId(20001);
        this.j.setId(20002);
        this.k.setId(20004);
        this.j.setBackgroundColor(-921103);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (this.p * 36.0f));
        int i = (int) (this.p * 22.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(13);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(Math.max(this.n, this.o), (((int) (((double) Math.max(this.n, this.o)) * 0.8d)) - ((int) (this.p * 36.0f))) - 2);
        layoutParams5.addRule(3, 20002);
        int i2 = (int) (this.p * 12.0f);
        layoutParams2.leftMargin = i2;
        layoutParams3.rightMargin = i2;
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, 2);
        layoutParams6.addRule(3, 20000);
        this.i.setPadding(10, 10, 10, 10);
        relativeLayout.addView(this.i, layoutParams2);
        relativeLayout.addView(this.h, layoutParams4);
        this.h.setGravity(17);
        addView(relativeLayout, layoutParams);
        addView(this.j, layoutParams6);
        addView(this.k, layoutParams5);
        setBackgroundColor(-1);
        this.i.setOnClickListener(this);
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(Dialog dialog, h.c cVar, h.b bVar) {
        this.d = dialog;
        this.e = cVar;
        this.f = bVar;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void a(l lVar, h.c cVar, h.b bVar) {
        this.c = lVar;
        this.e = cVar;
        this.f = bVar;
    }

    @Override // com.ubix.ssp.ad.e.z.h
    protected int getPopupType() {
        return 6;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != 20003) {
            return;
        }
        l lVar = this.c;
        if (lVar != null && lVar.b()) {
            this.c.a();
        }
        Dialog dialog = this.d;
        if (dialog != null && dialog.isShowing()) {
            this.d.dismiss();
        }
        h.c cVar = this.e;
        if (cVar != null) {
            cVar.a(null);
        }
        h.c cVar2 = this.e;
        if (cVar2 != null) {
            cVar2.b(null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            com.ubix.ssp.ad.e.c0.c cVar = this.k;
            if (cVar != null) {
                cVar.loadUrl("about:blank");
                this.k.destroy();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int iMin;
        super.onMeasure(i, i2);
        if (this.l == null) {
            this.l = (WindowManager) getContext().getSystemService("window");
        }
        this.m = this.l.getDefaultDisplay().getOrientation();
        this.n = r.a().h(getContext());
        this.o = r.a().c(getContext());
        u.e("rotation=" + this.m + ";width=" + this.n + ";height=" + this.o);
        int i4 = this.m;
        if (i4 == 1 || i4 == 3) {
            i3 = this.n;
            iMin = Math.min(i3, this.o);
        } else {
            i3 = this.n;
            iMin = Math.max(i3, this.o);
        }
        setMeasuredDimension(i3, (int) (((double) iMin) * 0.8d));
        this.h.requestLayout();
        this.k.requestLayout();
    }

    @Override // com.ubix.ssp.ad.e.z.h
    public void setData(Bundle bundle) {
        String string = bundle.getString("TARGET_URL");
        String string2 = bundle.getString("TITLE");
        if (this.k != null && !TextUtils.isEmpty(string)) {
            this.k.loadUrl(string);
        }
        if (this.h == null || TextUtils.isEmpty(string2)) {
            return;
        }
        this.h.setText(string2);
    }
}
