package com.opos.cmn.module.ui.a;

import android.animation.ArgbEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class e extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f6191a;
    private final com.opos.cmn.module.ui.b.b.c b;
    private boolean c;
    private int[] d;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        d dVar = new d();
        this.f6191a = dVar;
        super.setBackground(dVar);
        this.c = true;
        dVar.a(com.opos.cmn.an.h.f.a.a(context, 20.0f));
        this.b = new com.opos.cmn.module.ui.b.b.c(this) { // from class: com.opos.cmn.module.ui.a.e.1
            private final ArgbEvaluator b = new ArgbEvaluator();

            @Override // com.opos.cmn.module.ui.b.b.c
            protected void a(float f) {
                ColorStateList colorStateListB;
                int[] iArr = e.this.d;
                if ((iArr == null || iArr.length != 2) && (colorStateListB = e.this.f6191a.b()) != null) {
                    e.this.f6191a.setTint(com.opos.cmn.module.ui.d.a.a(colorStateListB.getDefaultColor(), f));
                }
            }

            @Override // com.opos.cmn.module.ui.b.b.c
            protected void a(boolean z, float f) {
                int[] iArr = e.this.d;
                if (iArr == null || iArr.length != 2) {
                    return;
                }
                e.this.f6191a.a(((Integer) this.b.evaluate(f, Integer.valueOf(z ? iArr[0] : iArr[1]), Integer.valueOf(z ? iArr[1] : iArr[0]))).intValue());
            }
        };
    }

    public void a(int... iArr) {
        this.d = iArr;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.c) {
            this.b.a(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f6191a.a(ColorStateList.valueOf(i));
    }
}
