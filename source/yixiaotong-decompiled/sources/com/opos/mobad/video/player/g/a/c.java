package com.opos.mobad.video.player.g.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.cmn.func.b.h;
import com.opos.mobad.template.d.f;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class c extends a {
    public c(Context context, int i, com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a, com.opos.mobad.d.a aVar) {
        super(context, i, interfaceC1003a, aVar);
    }

    private void a(RelativeLayout relativeLayout) {
        if (this.s != null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 68.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 68.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(2, this.p);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 12.0f);
        relativeLayout.addView(this.e, layoutParams);
    }

    private void a(RelativeLayout relativeLayout, com.opos.mobad.template.d.d dVar, boolean z) {
        if (this.s == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.q);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 8);
            relativeLayout.addView(this.f, layoutParams);
        }
        a(this.f, dVar.P);
        this.f.setVisibility(0);
    }

    private void b(RelativeLayout relativeLayout) {
        if (this.s != null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#0066FF"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f8404a, 22.0f));
        h.a(this.c, gradientDrawable);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 220.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 44.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(14);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 50.0f);
        relativeLayout.addView(this.c, layoutParams);
    }

    private void b(RelativeLayout relativeLayout, com.opos.mobad.template.d.d dVar, boolean z) {
        if (this.s == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14);
            layoutParams.addRule(2, this.r);
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, z ? 42 : 82);
            relativeLayout.addView(this.g, layoutParams);
        }
        a(this.g, dVar.Q);
        this.g.setVisibility(0);
    }

    private void c(com.opos.mobad.template.d.d dVar) {
        if (this.s == null && dVar.d != null && dVar.d.size() > 0 && dVar.d.get(0) != null) {
            final com.opos.mobad.template.d.e eVar = dVar.d.get(0);
            this.i.setTag(eVar.f7535a);
            com.opos.mobad.ui.c.e.a(eVar.f7535a, eVar.b, com.opos.cmn.an.h.f.a.b(this.f8404a) / 3, com.opos.cmn.an.h.f.a.c(this.f8404a), this.t, this.l, new com.opos.mobad.ui.c.e.b() { // from class: com.opos.mobad.video.player.g.a.c.1
                @Override // com.opos.mobad.ui.c.e.b
                public void a(Bitmap bitmap) {
                    if (c.this.u || c.this.i == null) {
                        return;
                    }
                    Object tag = c.this.i.getTag();
                    if ((tag instanceof String) && ((String) tag).equals(eVar.f7535a)) {
                        BitmapDrawable bitmapDrawableA = h.a(c.this.f8404a, h.a(3, bitmap));
                        if (bitmapDrawableA != null) {
                            h.a(c.this.i, bitmapDrawableA);
                        }
                    }
                }
            }, this.w);
        }
    }

    private boolean d(com.opos.mobad.template.d.d dVar) {
        if (this.s != null || dVar == null || dVar.N == null || TextUtils.isEmpty(dVar.N.f7535a)) {
            return false;
        }
        com.opos.mobad.ui.c.e.a(dVar.N.f7535a, dVar.N.b, com.opos.cmn.an.h.f.a.a(this.f8404a, 68.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 68.0f), this.t, this.e, this.l, this.w);
        return true;
    }

    public void a(com.opos.mobad.template.d.d dVar) {
        this.j = new com.opos.mobad.template.a.c(this.f8404a);
        this.j.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 174.0f), -2);
        layoutParams.addRule(12);
        float f = 24;
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, f);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, f);
        com.opos.mobad.template.d.a aVar = dVar.u;
        if (this.j == null || aVar == null) {
            return;
        }
        this.j.a(aVar.f7533a, aVar.b);
        this.j.setVisibility(0);
        this.j.a(this.l);
        this.h.addView(this.j, layoutParams);
    }

    @Override // com.opos.mobad.template.a
    public void a(f fVar) {
        com.opos.mobad.template.d.d dVarC = fVar.c();
        if (dVarC == null) {
            return;
        }
        h();
        j();
        c(dVarC);
        a(dVarC);
        b(dVarC);
        boolean zD = d(dVarC);
        if (zD) {
            a(this.h);
        }
        a(this.h, dVarC, zD);
        b(this.h, dVarC, zD);
        b(this.h);
        a(dVarC.R);
        a(this.c, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_CLICK_BT);
        a(this.i, com.opos.mobad.cmn.func.b.a.FLOAT_LAYER_NON_CLICK_BT);
        this.s = dVarC;
    }

    protected void b(com.opos.mobad.template.d.d dVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        float f = 24;
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, f);
        this.k = com.opos.mobad.template.k.c.a(dVar, this.i, layoutParams, this.t, this.l);
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
            com.opos.cmn.an.f.a.b("LandModelAFloatLayer", "");
        }
    }

    @Override // com.opos.mobad.video.player.g.a.a
    public void g() {
        this.i.setBackgroundColor(Color.parseColor("#1F000000"));
        this.e = new com.opos.cmn.module.ui.a.c(this.f8404a, 28.0f);
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        this.e.setVisibility(8);
        this.e.setId(this.o);
        this.f = new TextView(this.f8404a);
        this.f.setGravity(17);
        this.f.setTextColor(-1);
        this.f.setTextSize(1, 16.0f);
        this.f.setMaxEms(9);
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setMaxLines(1);
        this.f.setVisibility(8);
        this.f.setId(this.p);
        a(this.f);
        this.g = new TextView(this.f8404a);
        this.g.setGravity(17);
        this.g.setTextColor(Color.parseColor("#66FFFFFF"));
        this.g.setTextSize(1, 14.0f);
        this.g.setMaxEms(13);
        this.g.setEllipsize(TextUtils.TruncateAt.END);
        this.g.setVisibility(8);
        this.g.setMaxLines(1);
        this.g.setId(this.q);
        this.c = new TextView(this.f8404a);
        this.c.setGravity(17);
        this.c.setTextColor(Color.parseColor("#ffffff"));
        this.c.setTextSize(1, 16.0f);
        this.c.setId(this.r);
        a(this.c);
        this.n = new e(this.c, 1.0f, 1.05f, 1500L);
        h.a(this.h, new ColorDrawable(Color.parseColor("#8A42464C")));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 268.0f), com.opos.cmn.an.h.f.a.b(this.f8404a));
        layoutParams.addRule(11);
        this.i.addView(this.h, layoutParams);
    }

    @Override // com.opos.mobad.video.player.g.a.a
    protected void h() {
        super.h();
        h.a(this.d, com.opos.cmn.an.e.a.a.c(this.f8404a, "opos_module_biz_ui_reward_video_float_layer_close_bn_new.png"));
    }

    @Override // com.opos.mobad.video.player.g.a.a
    public RelativeLayout.LayoutParams i() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8404a, 44.0f), com.opos.cmn.an.h.f.a.a(this.f8404a, 28.0f));
        layoutParams.addRule(10);
        layoutParams.addRule(11);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 24.0f);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f8404a, 24.0f);
        return layoutParams;
    }

    @Override // com.opos.mobad.template.a
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public RelativeLayout c() {
        return this.i;
    }
}
