package com.opos.mobad.template.cmn;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class v extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7528a;

    public v(Context context, float f) {
        super(context);
        this.f7528a = f;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float width = getWidth();
        float height = getHeight();
        Path path = new Path();
        path.moveTo(this.f7528a, 0.0f);
        path.lineTo(width - this.f7528a, 0.0f);
        path.quadTo(width, 0.0f, width, this.f7528a);
        path.lineTo(width, height - this.f7528a);
        path.quadTo(width, height, width - this.f7528a, height);
        path.lineTo(this.f7528a, height);
        path.quadTo(0.0f, height, 0.0f, height - this.f7528a);
        path.lineTo(0.0f, this.f7528a);
        path.quadTo(0.0f, 0.0f, this.f7528a, 0.0f);
        canvas.clipPath(path);
        super.onDraw(canvas);
    }
}
