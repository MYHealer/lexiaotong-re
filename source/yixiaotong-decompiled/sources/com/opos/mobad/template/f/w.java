package com.opos.mobad.template.f;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.heytap.msp.mobad.api.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class w extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected a f7755a;
    protected com.opos.mobad.template.cmn.n b;
    protected LinearLayout c;
    protected com.opos.mobad.template.f.a.a d;
    protected TextView e;
    protected TextView f;
    private boolean g;

    public static class a {
        public static final int l = R.color.opos_mobad_interstitial_video_transparent_bg_color;
        public static final int m = R.color.opos_mobad_interstitial_video_vertical_bg_color;
        public static final int n = R.color.opos_mobad_interstitial_video_horizontal_bg_color;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.opos.mobad.template.f.a.a.EnumC1008a f7757a = com.opos.mobad.template.f.a.a.EnumC1008a.NONE;
        public final int b;
        public final int c;
        public int d;
        public final int e;
        public int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final boolean k;

        public a(int i, int i2, int i3, int i4, int i5, boolean z) {
            int i6;
            this.b = i;
            this.c = i2;
            this.e = i3;
            this.k = z;
            int i7 = z ? 12 : 8;
            this.g = i7;
            this.h = i7;
            this.j = i4;
            this.i = i5;
            if (i5 == l || i5 == n) {
                this.d = R.color.opos_mobad_interstitial_video_horizontal_title_color;
                i6 = R.color.opos_mobad_interstitial_video_horizontal_desc_color;
            } else {
                this.d = R.color.opos_mobad_interstitial_video_vertical_title_color;
                i6 = R.color.opos_mobad_interstitial_video_vertical_desc_color;
            }
            this.f = i6;
        }

        public int a() {
            boolean z = this.j == 1;
            int i = this.k ? 210 : 160;
            if (z) {
                return i;
            }
            return 72;
        }

        public a a(com.opos.mobad.template.f.a.a.EnumC1008a enumC1008a) {
            this.f7757a = enumC1008a;
            return this;
        }
    }

    public w(Context context, a aVar) {
        super(context);
        this.g = false;
        this.f7755a = aVar;
        setVisibility(4);
        h();
    }

    public static w a(Context context, int i, int i2, int i3, int i4) {
        return new w(context, new a(i, i2, i3, 0, i4, false).a(com.opos.mobad.template.f.a.a.EnumC1008a.FLASH));
    }

    private void a(int i) {
        if (this.g) {
            return;
        }
        if (i <= 0) {
            setVisibility(0);
            return;
        }
        final ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(180L);
        objectAnimatorOfFloat.setInterpolator(PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f));
        com.opos.mobad.d.c.c.a(new Runnable() { // from class: com.opos.mobad.template.f.w.1
            @Override // java.lang.Runnable
            public void run() {
                w.this.setVisibility(0);
                objectAnimatorOfFloat.start();
            }
        }, i);
        this.g = true;
    }

    public static w b(Context context, int i, int i2, int i3, int i4) {
        return new w(context, new a(i, i2, i3, 1, i4, false).a(com.opos.mobad.template.f.a.a.EnumC1008a.FINGER));
    }

    public static w c(Context context, int i, int i2, int i3, int i4) {
        return new w(context, new a(i, i2, i3, 0, i4, true).a(com.opos.mobad.template.f.a.a.EnumC1008a.FLASH));
    }

    public static w d(Context context, int i, int i2, int i3, int i4) {
        return new w(context, new a(i, i2, i3, 1, i4, true).a(com.opos.mobad.template.f.a.a.EnumC1008a.FINGER));
    }

    public static w e(Context context, int i, int i2, int i3, int i4) {
        return new w(context, new a(i, i2, i3, 0, i4, true).a(com.opos.mobad.template.f.a.a.EnumC1008a.FLASH));
    }

    private void h() {
        setBackgroundColor(getContext().getResources().getColor(this.f7755a.i));
        b();
        c();
        d();
        a();
    }

    protected void a() {
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), this.f7755a.a());
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), g() ? 44.0f : 28.0f);
        View viewA = this.d.a();
        if (!g()) {
            int iA3 = com.opos.cmn.an.h.f.a.a(getContext(), this.f7755a.b);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iA3, iA3);
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f7755a.h);
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            addView(this.b, layoutParams);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(iA, iA2);
            layoutParams2.addRule(15);
            layoutParams2.addRule(11);
            layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), this.f7755a.h);
            addView(viewA, layoutParams2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            layoutParams3.addRule(1, this.b.getId());
            layoutParams3.addRule(0, viewA.getId());
            addView(this.c, layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(iA, iA2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(getContext(), 24.0f);
        addView(viewA, layoutParams4);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.addRule(10);
        layoutParams5.addRule(14);
        layoutParams5.addRule(2, viewA.getId());
        layoutParams5.setMarginStart(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams5.setMarginEnd(com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        addView(relativeLayout, layoutParams5);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(13);
        relativeLayout.addView(relativeLayout2, layoutParams6);
        int iA4 = com.opos.cmn.an.h.f.a.a(getContext(), this.f7755a.b);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(iA4, iA4);
        layoutParams7.addRule(14);
        relativeLayout2.addView(this.b, layoutParams7);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(14);
        layoutParams8.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams8.addRule(3, this.b.getId());
        relativeLayout2.addView(this.c, layoutParams8);
    }

    public void a(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.b.setImageBitmap(bitmap);
    }

    public void a(String str, String str2, String str3, int i) {
        if (TextUtils.isEmpty(str)) {
            this.e.setVisibility(8);
        } else {
            this.e.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            this.f.setVisibility(8);
        } else {
            this.f.setText(str2);
        }
        this.d.a(str3);
        a(i);
    }

    protected void b() {
        com.opos.mobad.template.cmn.n nVar = new com.opos.mobad.template.cmn.n(getContext(), com.opos.cmn.an.h.f.a.a(getContext(), this.f7755a.b >= 60 ? 12 : 8));
        this.b = nVar;
        nVar.setId(View.generateViewId());
    }

    protected void c() {
        TextView textView;
        int i;
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.c = linearLayout;
        linearLayout.setId(View.generateViewId());
        this.c.setOrientation(1);
        TextView textView2 = new TextView(getContext());
        this.e = textView2;
        com.opos.mobad.template.h.a(textView2);
        this.e.setTextColor(getContext().getResources().getColor(this.f7755a.d));
        this.e.setTextSize(1, this.f7755a.c);
        this.e.setGravity(3);
        if (this.f7755a.j != 0 || this.f7755a.k) {
            textView = this.e;
            i = 6;
        } else {
            textView = this.e;
            i = 5;
        }
        textView.setMaxEms(i);
        this.e.setEllipsize(TextUtils.TruncateAt.END);
        this.e.setSingleLine();
        this.e.setMaxLines(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f7755a.j == 1) {
            layoutParams.gravity = 1;
        } else {
            layoutParams.gravity = 3;
        }
        this.c.addView(this.e, layoutParams);
        TextView textView3 = new TextView(getContext());
        this.f = textView3;
        textView3.setTextColor(getContext().getResources().getColor(this.f7755a.f));
        this.f.setTextSize(1, this.f7755a.e);
        this.f.setGravity(3);
        this.f.setSingleLine();
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        if (this.f7755a.j == 1) {
            layoutParams2.gravity = 1;
        } else {
            layoutParams2.gravity = 3;
        }
        layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.c.addView(this.f, layoutParams2);
    }

    protected void d() {
        com.opos.mobad.template.f.a.a aVar = new com.opos.mobad.template.f.a.a(getContext(), this.f7755a.f7757a);
        this.d = aVar;
        aVar.a(g() ? 16 : 12);
        this.d.b(g() ? 8 : 4);
    }

    public void e() {
        this.b.setVisibility(8);
        if (g()) {
            this.e.setTextSize(1, 20.0f);
            ((RelativeLayout.LayoutParams) this.c.getLayoutParams()).bottomMargin += com.opos.cmn.an.h.f.a.a(getContext(), 30.0f);
        } else {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
            layoutParams.removeRule(1);
            layoutParams.addRule(20);
        }
    }

    public com.opos.mobad.template.cmn.baseview.c f() {
        com.opos.mobad.template.f.a.a aVar = this.d;
        if (aVar != null) {
            return aVar.a();
        }
        return null;
    }

    protected boolean g() {
        return this.f7755a.j == 1;
    }
}
