package com.opos.mobad.video.player.g.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.template.d.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class b extends a {
    public b(Context context, int i, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar) {
        super(context, i, interfaceC1003a, aVar);
    }

    private void a(LinearLayout linearLayout) {
        this.e = new com.opos.cmn.module.ui.a.c(this.f8404a, 33.0f);
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        this.e.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 50.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 13.0f);
        linearLayout.addView(this.e, layoutParams);
    }

    private void b(LinearLayout linearLayout) {
        this.f = new TextView(this.f8404a);
        this.f.setGravity(17);
        this.f.setTextColor(Color.parseColor("#000000"));
        this.f.setTextSize(1, 15.0f);
        this.f.setTypeface(Typeface.defaultFromStyle(1));
        this.f.setMaxEms(9);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setSingleLine();
        this.f.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 5.0f);
        linearLayout.addView(this.f, layoutParams);
    }

    private void c(LinearLayout linearLayout) {
        this.g = new TextView(this.f8404a);
        this.g.setGravity(17);
        this.g.setTextColor(Color.parseColor("#000000"));
        this.g.setTextSize(1, 13.0f);
        this.g.setMaxEms(13);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setSingleLine();
        this.g.setVisibility(8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 52.0f);
        linearLayout.addView(this.g, layoutParams);
    }

    private void d(LinearLayout linearLayout) {
        this.c = new TextView(this.f8404a);
        this.c.setGravity(17);
        this.c.setTextColor(Color.parseColor("#ffffff"));
        this.c.setTextSize(1, 15.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#EB4B4F"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f8404a, 22.0f));
        h.a(this.c, gradientDrawable);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 120.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 30.0f));
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 3.0f);
        linearLayout.addView(this.c, layoutParams);
        this.n = new e(this.c, 1.0f, 1.2f, 1500L);
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.mobad.template.d.d dVarC = fVar.c();
        if (dVarC == null) {
            return;
        }
        h();
        j();
        if (this.s == null && dVarC.N != null && !TextUtils.isEmpty(dVarC.N.f7535a)) {
            com.opos.mobad.ui.c.e.a(dVarC.N.f7535a, dVarC.N.b, com.opos.cmn.an.h.f.a.a(this.f8404a, 50.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 50.0f), this.t, this.e, this.l, this.w);
        }
        if (this.f != null && !TextUtils.isEmpty(dVarC.P)) {
            a(this.f, dVarC.P);
            this.f.setVisibility(0);
        }
        if (this.g != null && !TextUtils.isEmpty(dVarC.Q)) {
            a(this.g, dVarC.Q);
            this.g.setVisibility(0);
        }
        a(dVarC.R);
        a(this.c, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT);
        a(this.i, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT);
        this.s = dVarC;
    }

    @Override // com.opos.mobad.video.player.g.a.a, com.opos.mobad.template.a
    public void d() {
        try {
            super.d();
            a(this.f, "");
            a(this.g, "");
            a((View) this.c);
            a((View) this.d);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b("GraphicMixFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.video.player.g.a.a
    public void g() {
        h.a(this.h, new ColorDrawable(Color.parseColor("#cfffffff")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.b(this.f8404a), com.opos.cmn.an.h.f.a.c(this.f8404a) / 3);
        layoutParams.addRule(13);
        LinearLayout linearLayout = new LinearLayout(this.f8404a);
        linearLayout.setOrientation(1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 144.0f), -2);
        layoutParams2.addRule(13);
        a(linearLayout);
        b(linearLayout);
        c(linearLayout);
        d(linearLayout);
        this.h.addView(linearLayout, layoutParams2);
        this.i.addView(this.h, layoutParams);
    }

    @Override // com.opos.mobad.video.player.g.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 30.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 30.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        boolean zD = com.opos.cmn.an.h.f.a.d(this.f8404a);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, zD ? 54 : 11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, zD ? 24 : 11);
        return layoutParams;
    }

    @Override // com.opos.mobad.template.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public RelativeLayout c() {
        return this.i;
    }
}
