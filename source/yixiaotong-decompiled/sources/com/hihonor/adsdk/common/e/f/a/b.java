package com.hihonor.adsdk.common.e.f.a;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class b extends a {
    private Paint hnadsg;
    private MaskFilter hnadsh;
    private Path hnadsi;

    public b(d dVar) {
        super(dVar);
        this.hnadsg = new Paint();
        this.hnadsh = new BlurMaskFilter(50.0f, BlurMaskFilter.Blur.NORMAL);
        this.hnadsi = new Path();
        this.hnadsg.setColor(h.hnadsa(hnadsd()));
        this.hnadsg.setMaskFilter(this.hnadsh);
    }

    private void hnadsb(Canvas canvas) {
        float fHnadse = hnadse();
        this.hnadsi.reset();
        this.hnadsi.addCircle(hnadsf().centerX(), hnadsf().centerY(), fHnadse, Path.Direction.CCW);
        canvas.clipPath(this.hnadsi);
        canvas.drawCircle(hnadsf().centerX(), hnadsf().height(), fHnadse, this.hnadsg);
    }

    @Override // com.hihonor.adsdk.common.e.f.a.i
    public void hnadsa(Canvas canvas) {
        Rect clipBounds = canvas.getClipBounds();
        int i = clipBounds.left;
        if (i != 0 || clipBounds.top != 0) {
            canvas.translate(i, clipBounds.top);
        }
        canvas.save();
        hnadsb(canvas);
        canvas.restore();
        int i2 = clipBounds.left;
        if (i2 == 0 && clipBounds.top == 0) {
            return;
        }
        canvas.translate(-i2, -clipBounds.top);
    }
}
