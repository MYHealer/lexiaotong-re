package com.opos.mobad.template.i.b;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.ae;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import com.opos.mobad.template.cmn.baseview.c;
import com.opos.mobad.template.cmn.x;
import com.opos.mobad.template.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends c implements com.opos.mobad.template.e.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8163a;
    private x b;
    private BaseTextView c;
    private int d;
    private int e;
    private int f;
    private String g;
    private Animator h;
    private Animator i;

    public a(Context context) {
        super(context);
        this.f8163a = false;
        this.d = 312;
        this.e = 60;
        this.f = 18;
        this.g = "";
        c();
    }

    private void c() {
        setId(View.generateViewId());
        setMinimumHeight(com.opos.cmn.an.h.f.a.a(getContext(), 22.0f));
        x xVar = new x(getContext());
        this.b = xVar;
        xVar.setOrientation(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.d), com.opos.cmn.an.h.f.a.a(getContext(), this.e));
        layoutParams.addRule(13);
        layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        this.b.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_splash_click));
        this.b.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 13.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f), 0);
        this.b.setGravity(17);
        addView(this.b, layoutParams);
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.c = baseTextView;
        baseTextView.setText(this.g);
        this.c.setTextSize(0, com.opos.cmn.an.h.f.a.a(getContext(), this.f));
        this.c.setTextColor(-1);
        this.c.setGravity(17);
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        this.c.setSingleLine();
        Drawable drawable = getContext().getResources().getDrawable(R.drawable.opos_mobad_splash_right_side_arrow);
        drawable.setBounds(com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 15.0f), com.opos.cmn.an.h.f.a.a(getContext(), 17.0f));
        this.c.setCompoundDrawables(null, null, drawable, null);
        this.c.setPadding(0, 0, com.opos.cmn.an.h.f.a.a(getContext(), 9.0f), 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 16;
        this.b.addView(this.c, layoutParams2);
    }

    public View a() {
        return this.b;
    }

    public void a(com.opos.mobad.template.e.c.a aVar) {
        View viewC;
        if (aVar == null || this.c == null || (viewC = aVar.c()) == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.c.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 16;
        }
        this.b.removeView(this.c);
        if (viewC.getParent() != null) {
            ((ViewGroup) viewC.getParent()).removeView(viewC);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 26.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
        layoutParams2.gravity = 16;
        this.b.addView(viewC, layoutParams2);
        this.b.addView(this.c, layoutParams);
        this.b.setClipChildren(false);
    }

    public void a(String str) {
        this.g = str;
        this.c.setText(str);
    }

    public void b() {
        if (h.a()) {
            Animator animator = this.h;
            if (animator == null || !animator.isRunning()) {
                Animator animator2 = this.i;
                if (animator2 == null || !animator2.isRunning()) {
                    if (this.i == null) {
                        this.i = ae.c((View) this);
                    }
                    this.i.start();
                }
            }
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void g() {
        if (h.a() && !this.f8163a) {
            this.f8163a = true;
            Animator animatorB = ae.b((View) this);
            this.h = animatorB;
            animatorB.start();
        }
    }

    @Override // com.opos.mobad.template.e.c.c
    public void h() {
    }

    @Override // com.opos.mobad.template.e.c.c
    public void i() {
    }

    @Override // com.opos.mobad.template.e.c.c
    public void j() {
    }
}
