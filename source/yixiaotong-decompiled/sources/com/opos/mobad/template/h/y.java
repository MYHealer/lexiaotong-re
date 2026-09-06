package com.opos.mobad.template.h;

import android.content.Context;
import android.graphics.Color;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class y extends z implements a {
    public y(Context context, com.opos.mobad.d.a aVar, com.opos.mobad.d.d.a aVar2, boolean z) {
        super(context, aVar, aVar2, z);
    }

    public y(Context context, com.opos.mobad.d.a aVar, com.opos.mobad.d.d.a aVar2, boolean z, int i) {
        super(context, aVar, aVar2, z, i);
    }

    @Override // com.opos.mobad.template.h.z, com.opos.mobad.template.h.a
    public a a(com.opos.mobad.template.cmn.p pVar) {
        this.y = pVar;
        return this;
    }

    @Override // com.opos.mobad.template.h.z
    protected void b() {
        super.b();
        this.f.setBackgroundColor(Color.parseColor("#00000000"));
        this.f.setLayoutParams(new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f8153a, 44.0f)));
        int iA = com.opos.cmn.an.h.f.a.a(this.f8153a, 24.0f);
        this.l.leftMargin = iA;
        this.o.rightMargin = iA;
        this.l.bottomMargin = 0;
        this.o.bottomMargin = 0;
        this.m.setLayoutParams(this.l);
        this.n.setLayoutParams(this.o);
        if (this.v != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f8153a, 82.0f), com.opos.cmn.an.h.f.a.a(this.f8153a, 60.0f));
            layoutParams.addRule(11);
            this.v.setLayoutParams(layoutParams);
        }
    }

    @Override // com.opos.mobad.template.h.z
    protected void c() {
        if (this.x) {
            return;
        }
        this.p = this.s ? new i(this.f8153a, this.b) : new h(this.f8153a, this.b);
        this.q.addView(this.p);
        this.x = true;
    }

    @Override // com.opos.mobad.template.h.z
    protected void d() {
        this.t = u.b(this.f8153a);
        addView(this.t);
    }

    @Override // com.opos.mobad.template.h.z
    protected void e() {
        com.opos.mobad.template.cmn.m.a(this.f8153a, this, false);
    }
}
