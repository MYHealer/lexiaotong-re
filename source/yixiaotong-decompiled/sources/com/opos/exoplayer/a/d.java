package com.opos.exoplayer.a;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import com.opos.exoplayer.core.f.j;
import com.opos.exoplayer.core.i.y;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public final class d extends View implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f6230a;
    private List<com.opos.exoplayer.core.f.b> b;
    private int c;
    private float d;
    private boolean e;
    private boolean f;
    private com.opos.exoplayer.core.f.a g;
    private float h;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6230a = new ArrayList();
        this.c = 0;
        this.d = 0.0533f;
        this.e = true;
        this.f = true;
        this.g = com.opos.exoplayer.core.f.a.f6412a;
        this.h = 0.08f;
    }

    private void a(int i, float f) {
        if (this.c == i && this.d == f) {
            return;
        }
        this.c = i;
        this.d = f;
        invalidate();
    }

    private float c() {
        return ((CaptioningManager) getContext().getSystemService("captioning")).getFontScale();
    }

    private com.opos.exoplayer.core.f.a d() {
        return com.opos.exoplayer.core.f.a.a(((CaptioningManager) getContext().getSystemService("captioning")).getUserStyle());
    }

    public void a() {
        a(((y.f6517a < 19 || isInEditMode()) ? 1.0f : c()) * 0.0533f);
    }

    public void a(float f) {
        a(f, false);
    }

    public void a(float f, boolean z) {
        a(z ? 1 : 0, f);
    }

    public void a(com.opos.exoplayer.core.f.a aVar) {
        if (this.g == aVar) {
            return;
        }
        this.g = aVar;
        invalidate();
    }

    @Override // com.opos.exoplayer.core.f.j
    public void a(List<com.opos.exoplayer.core.f.b> list) {
        b(list);
    }

    public void b() {
        a((y.f6517a < 19 || isInEditMode()) ? com.opos.exoplayer.core.f.a.f6412a : d());
    }

    public void b(List<com.opos.exoplayer.core.f.b> list) {
        if (this.b == list) {
            return;
        }
        this.b = list;
        int size = list == null ? 0 : list.size();
        while (this.f6230a.size() < size) {
            this.f6230a.add(new e(getContext()));
        }
        invalidate();
    }

    @Override // android.view.View
    public void dispatchDraw(Canvas canvas) {
        float f;
        List<com.opos.exoplayer.core.f.b> list = this.b;
        int i = 0;
        int size = list == null ? 0 : list.size();
        int top = getTop();
        int bottom = getBottom();
        int left = getLeft() + getPaddingLeft();
        int paddingTop = getPaddingTop() + top;
        int right = getRight() + getPaddingRight();
        int paddingBottom = bottom - getPaddingBottom();
        if (paddingBottom <= paddingTop || right <= left) {
            return;
        }
        int i2 = this.c;
        if (i2 == 2) {
            f = this.d;
        } else {
            f = (i2 == 0 ? paddingBottom - paddingTop : bottom - top) * this.d;
        }
        if (f <= 0.0f) {
            return;
        }
        while (i < size) {
            int i3 = paddingBottom;
            int i4 = right;
            this.f6230a.get(i).a(this.b.get(i), this.e, this.f, this.g, f, this.h, canvas, left, paddingTop, i4, i3);
            i++;
            paddingBottom = i3;
            right = i4;
        }
    }
}
