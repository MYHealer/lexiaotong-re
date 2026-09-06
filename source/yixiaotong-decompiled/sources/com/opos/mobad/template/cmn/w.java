package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class w extends com.opos.mobad.template.cmn.baseview.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7529a;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7529a = 0.0f;
        setWillNotDraw(false);
    }

    public void a() {
        setLayerType(1, null);
    }

    public void a(float f) {
        this.f7529a = f;
        invalidate();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int iSave = canvas.save();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        Path path = new Path();
        float f = this.f7529a;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        canvas.clipPath(path);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }
}
