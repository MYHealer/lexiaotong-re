package com.opos.mobad.template.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.p;
import com.opos.mobad.template.h;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class f extends com.opos.mobad.template.cmn.baseview.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    p f7410a;
    private TextView b;
    private View c;
    private TextView d;
    private TextView e;
    private FrameLayout f;
    private com.opos.mobad.template.a.InterfaceC1003a g;
    private a h;
    private com.opos.mobad.d.a i;

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7413a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final float g;
        public final int h;
        public final boolean i;
        public final int j;
        public final float k;
        public final float l;

        public a(int i, int i2, int i3, int i4, int i5, int i6, float f, int i7, boolean z, int i8, float f2, float f3) {
            this.f7413a = i;
            this.d = i4;
            this.b = i2;
            this.c = i3;
            this.e = i5;
            this.f = i6;
            this.g = f;
            this.h = i7;
            this.i = z;
            this.j = i8;
            this.k = f2;
            this.l = f3;
        }
    }

    public f(Context context, a aVar, com.opos.mobad.d.a aVar2) {
        super(context);
        this.f7410a = new p() { // from class: com.opos.mobad.template.a.f.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                com.opos.cmn.an.f.a.b("LogoTipBar", "onFeedBackClick");
                if (f.this.g != null) {
                    f.this.g.a(view, iArr);
                }
            }
        };
        this.h = aVar;
        this.i = aVar2;
        b();
    }

    public static f a(Context context, int i, com.opos.mobad.d.a aVar) {
        return new f(context, new a(10, 21, 30, 14, 4, 0, 3.0f, i, false, 12, 6.36f, 3.56f), aVar);
    }

    public static f a(Context context, com.opos.mobad.d.a aVar) {
        f fVar = new f(context, new a(14, 28, 41, 20, 12, 12, 14.0f, Color.parseColor("#8A42464C"), true, 14, 7.42f, 4.15f), aVar);
        fVar.a();
        return fVar;
    }

    private void a(com.opos.mobad.template.d.e eVar, final String str) {
        h.a(this.g, eVar.f7535a, this.i, eVar.b, new com.opos.mobad.template.b() { // from class: com.opos.mobad.template.a.f.1
            @Override // com.opos.mobad.template.b
            public void a(Bitmap bitmap) {
                int iA;
                BitmapDrawable bitmapDrawableA = bitmap != null ? h.a(f.this.getContext(), bitmap) : null;
                com.opos.cmn.an.f.a.b("LogoTipBar", "getLogoDrawable=" + (bitmapDrawableA != null ? bitmapDrawableA : "null"));
                ViewGroup.LayoutParams layoutParams = f.this.d.getLayoutParams();
                if (bitmapDrawableA != null) {
                    h.a(f.this.d, bitmapDrawableA);
                    iA = com.opos.cmn.an.h.f.a.a(f.this.getContext(), f.this.h.c);
                } else {
                    f.this.d.setText(str);
                    f.this.d.setMinWidth(com.opos.cmn.an.h.f.a.a(f.this.getContext(), f.this.h.b));
                    iA = -2;
                }
                layoutParams.width = iA;
                layoutParams.height = com.opos.cmn.an.h.f.a.a(f.this.getContext(), f.this.h.d);
                f.this.d.setVisibility(0);
            }
        });
    }

    public static f b(Context context, com.opos.mobad.d.a aVar) {
        return new f(context, new a(10, 21, 30, 14, 4, 0, 14.0f, 637534208, false, 12, 6.36f, 3.56f), aVar);
    }

    private void b() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(this.h.h);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), this.h.g));
        h.a(this, gradientDrawable);
        setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.h.e), 0, com.opos.cmn.an.h.f.a.a(getContext(), this.h.f), 0);
        setOrientation(0);
        TextView textView = new TextView(getContext());
        this.d = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.d.setTextSize(1, this.h.f7413a);
        this.d.setGravity(17);
        this.d.setMaxEms(6);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        this.d.setSingleLine();
        this.d.setVisibility(8);
        h.a(this.d);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        addView(this.d, layoutParams);
        this.f = new FrameLayout(getContext());
        TextView textView2 = new TextView(getContext());
        this.e = textView2;
        textView2.setBackgroundResource(R.drawable.opos_mobad_feedback_down_vector);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), this.h.k), com.opos.cmn.an.h.f.a.a(getContext(), this.h.l));
        layoutParams2.gravity = 17;
        this.f.addView(this.e, layoutParams2);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), this.h.j);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(iA, iA);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 2.0f);
        layoutParams3.gravity = 16;
        addView(this.f, layoutParams3);
        if (this.h.i) {
            TextView textView3 = new TextView(getContext());
            this.c = textView3;
            textView3.setBackgroundColor(-1);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
            layoutParams4.setMargins(com.opos.cmn.an.h.f.a.a(getContext(), 8.0f), com.opos.cmn.an.h.f.a.a(getContext(), 8.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 8.0f));
            layoutParams4.gravity = 16;
            addView(this.c, layoutParams4);
            TextView textView4 = new TextView(getContext());
            this.b = textView4;
            textView4.setTextSize(1, this.h.f7413a);
            this.b.setTextColor(-1);
            this.b.setGravity(17);
            this.b.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
            layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams5.gravity = 16;
            addView(this.b, layoutParams5);
        }
    }

    public void a() {
        TextView textView = this.b;
        if (textView != null) {
            textView.setMaxEms(4);
            this.b.setEllipsize(TextUtils.TruncateAt.END);
            this.b.setSingleLine();
        }
    }

    public void a(int i) {
        try {
            View view = this.c;
            if (view != null) {
                view.setBackgroundColor(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            View view2 = this.c;
            if (view2 != null) {
                view2.setBackgroundColor(-1);
            }
        }
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        com.opos.cmn.an.f.a.b("LogoTipBar", "setListener " + interfaceC1003a);
        this.g = interfaceC1003a;
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.template.d.e eVar, String str2) {
        if (this.b != null) {
            if (TextUtils.isEmpty(str)) {
                this.b.setVisibility(8);
                this.c.setVisibility(8);
            } else {
                this.b.setText(str);
                this.b.setVisibility(0);
                if (!TextUtils.isEmpty(str)) {
                    this.c.setVisibility(0);
                }
            }
        }
        a(z, z2, eVar, str2);
    }

    public void a(boolean z, boolean z2, com.opos.mobad.template.d.e eVar, String str) {
        p pVar;
        TextView textView;
        if (z) {
            this.f.setVisibility(0);
            this.f.setOnClickListener(this.f7410a);
            this.f.setOnTouchListener(this.f7410a);
            this.d.setOnClickListener(this.f7410a);
            textView = this.d;
            pVar = this.f7410a;
        } else {
            if (this.h.f == 0) {
                setPadding(com.opos.cmn.an.h.f.a.a(getContext(), this.h.e), 0, com.opos.cmn.an.h.f.a.a(getContext(), this.h.e), 0);
            }
            this.f.setVisibility(8);
            pVar = null;
            this.d.setOnClickListener(null);
            textView = this.d;
        }
        textView.setOnTouchListener(pVar);
        if (!z2 || this.d.getVisibility() == 0) {
            return;
        }
        if (eVar != null && !TextUtils.isEmpty(eVar.f7535a)) {
            a(eVar, str);
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        this.d.setText(str);
        this.d.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), this.h.b));
        layoutParams.width = -2;
        layoutParams.height = com.opos.cmn.an.h.f.a.a(getContext(), this.h.d);
        this.d.setVisibility(0);
    }
}
