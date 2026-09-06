package com.opos.mobad.template.i;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import com.opos.mobad.template.cmn.baseview.BaseTextView;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class a extends BaseTextView implements com.opos.mobad.template.e {
    public a(Context context) {
        this(context, null);
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setGravity(17);
        setTextColor(-1);
        setTextSize(1, 14.0f);
        int iA = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int i2 = iA * 3;
        setPadding(i2, iA, i2, iA);
        com.opos.mobad.template.h.a(this);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(60.0f);
        gradientDrawable.setColor(-1975368116);
        com.opos.mobad.d.c.e.a(this, gradientDrawable);
    }

    @Override // com.opos.mobad.template.e
    public View a() {
        return this;
    }

    @Override // com.opos.mobad.template.e
    public void a(int i) {
        setText(String.format(Locale.getDefault(), "%1$d 跳过", Integer.valueOf(i)));
    }

    @Override // com.opos.mobad.template.e
    public void a(final com.opos.mobad.template.e.a aVar) {
        com.opos.mobad.template.cmn.p pVar = new com.opos.mobad.template.cmn.p() { // from class: com.opos.mobad.template.i.a.1
            @Override // com.opos.mobad.template.cmn.p
            public void b(View view, int[] iArr) {
                aVar.a(view, iArr);
            }
        };
        setOnClickListener(pVar);
        setOnTouchListener(pVar);
    }
}
