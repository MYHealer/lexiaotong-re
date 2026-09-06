package com.opos.mobad.template.h;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.template.cmn.baseview.BaseImageView;
import com.opos.mobad.template.cmn.baseview.BaseTextView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class x extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TextView f8149a;
    private View b;
    private BaseImageView c;
    private BaseTextView d;
    private int e;
    private int f;
    private com.opos.mobad.template.a.InterfaceC1003a g;
    private a h;

    public interface a {
        void a(int i);
    }

    public x(Context context, int i) {
        super(context);
        this.e = 0;
        this.f = i;
        c();
    }

    public static x a(Context context) {
        return a(context, 0);
    }

    public static x a(Context context, int i) {
        return new x(context, i);
    }

    private void b(int i) {
        Resources resources;
        int i2;
        TextView textView = this.f8149a;
        if (textView == null || this.e == i) {
            return;
        }
        this.e = i;
        if (i == 0) {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_off;
        } else if (i == 2) {
            textView.setVisibility(8);
            this.b.setVisibility(8);
            return;
        } else {
            resources = getContext().getResources();
            i2 = R.drawable.opos_mobad_drawable_block_sound_on;
        }
        textView.setBackground(resources.getDrawable(i2));
    }

    private void c() {
        int i;
        setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        int i2 = this.f;
        if (i2 == 2) {
            i = -1975368116;
        } else {
            i = i2 == 1 ? -1305333198 : -1288555982;
        }
        gradientDrawable.setColor(i);
        setBackground(gradientDrawable);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int iA2 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(iA2, iA, iA2, iA);
        this.f8149a = new TextView(getContext());
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.x.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                if (x.this.g != null) {
                    x.this.g.a(view, iArr, x.this.e == 1);
                }
            }
        };
        this.f8149a.setOnClickListener(pVar);
        this.f8149a.setOnTouchListener(pVar);
        this.f8149a.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_block_sound_off));
        addView(this.f8149a, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f)));
        View view = new View(getContext());
        this.b = view;
        view.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.b.setVisibility(8);
        addView(this.b, layoutParams);
        if (this.f != 2) {
            BaseImageView baseImageView = new BaseImageView(getContext());
            this.c = baseImageView;
            baseImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            this.c.setImageResource(R.drawable.opos_mobad_drawable_block_close);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 20.0f), com.opos.cmn.an.h.f.a.a(getContext(), 20.0f));
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
            this.c.setVisibility(8);
            addView(this.c, layoutParams2);
            com.opos.mobad.template.cmn.p pVar2 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.x.3
                @Override // com.opos.mobad.template.cmn.p
                public void b(View view2, int[] iArr) {
                    if (x.this.g != null) {
                        x.this.g.e(view2, iArr);
                    }
                }
            };
            this.c.setOnTouchListener(pVar2);
            this.c.setOnClickListener(pVar2);
            return;
        }
        BaseTextView baseTextView = new BaseTextView(getContext());
        this.d = baseTextView;
        baseTextView.setTextSize(1, 14.0f);
        this.d.setTextColor(Color.parseColor("#E5FFFFFF"));
        this.d.setText("关闭广告");
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.d.setVisibility(8);
        addView(this.d, layoutParams3);
        com.opos.mobad.template.cmn.p pVar3 = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.h.x.2
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view2, int[] iArr) {
                if (x.this.g != null) {
                    x.this.g.e(view2, iArr);
                }
            }
        };
        this.d.setOnTouchListener(pVar3);
        this.d.setOnClickListener(pVar3);
    }

    public void a() {
        this.b.setVisibility(0);
        BaseImageView baseImageView = this.c;
        if (baseImageView != null) {
            baseImageView.setVisibility(0);
        }
        BaseTextView baseTextView = this.d;
        if (baseTextView != null) {
            baseTextView.setVisibility(0);
        }
    }

    public void a(int i) {
        if (this.e == i) {
            return;
        }
        a aVar = this.h;
        if (aVar != null) {
            aVar.a(i);
        }
        b(i);
    }

    public void a(com.opos.mobad.template.a.InterfaceC1003a interfaceC1003a) {
        this.g = interfaceC1003a;
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    public void b() {
        this.f8149a.setVisibility(8);
        this.b.setVisibility(8);
        BaseImageView baseImageView = this.c;
        if (baseImageView != null) {
            baseImageView.setVisibility(0);
            ((LinearLayout.LayoutParams) this.c.getLayoutParams()).leftMargin = 0;
        }
    }
}
