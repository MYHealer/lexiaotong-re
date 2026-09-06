package com.hihonor.adsdk.base.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.hihonor.adsdk.base.j.k;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class RadiusConstrainLayout extends ConstraintLayout {
    private final k hnadsd;

    public RadiusConstrainLayout(Context context) {
        super(context);
        this.hnadsd = new k();
        hnadsa(context, null, 0);
    }

    private void hnadsa(Context context, AttributeSet attributeSet, int i) {
        this.hnadsd.hnadsa(this, context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.hnadsd.hnadsa(this, canvas);
        super.dispatchDraw(canvas);
    }

    public void setLeftRadius(float f) {
        this.hnadsd.hnadsa(f);
    }

    public void setRadius(float f) {
        this.hnadsd.hnadsb(f);
    }

    public void setRightRadius(float f) {
        this.hnadsd.hnadsc(f);
    }

    public void setTopRadius(float f) {
        this.hnadsd.hnadsd(f);
    }

    public void setRadius(float[] fArr) {
        this.hnadsd.hnadsa(fArr);
    }

    public RadiusConstrainLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.hnadsd = new k();
        hnadsa(context, attributeSet, 0);
    }

    public RadiusConstrainLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.hnadsd = new k();
        hnadsa(context, attributeSet, i);
    }
}
