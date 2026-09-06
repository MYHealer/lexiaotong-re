package com.byazt.sm;

import android.content.Context;
import android.graphics.Canvas;
import android.text.Html;
import android.widget.TextView;
import com.byazt.rb.sp;
import com.byazt.rb.x;
import com.byazt.sa.uj;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5941276.dex */
@com.byazt.zqa.c(c = {0, 1, 40, 1803})
public class RichTextView extends TextView implements sp {
    public uj c;
    public x tt;

    public void c(uj ujVar) {
        this.c = ujVar;
    }

    public RichTextView(Context context) {
        super(context);
        this.tt = new x(this);
    }

    public void setRichText(String str) {
        setText(Html.fromHtml(str, 0));
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        uj ujVar = this.c;
        if (ujVar != null) {
            int[] iArrC = ujVar.c(i, i2);
            super.onMeasure(iArrC[0], iArrC[1]);
        } else {
            super.onMeasure(i, i2);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.n();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.c(z);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        uj ujVar = this.c;
        if (ujVar != null) {
            ujVar.tt(i, i2, i3, i4);
        }
    }

    public void setBorderRadius(float f) {
        x xVar = this.tt;
        if (xVar != null) {
            xVar.c(f);
        }
    }

    public float getBorderRadius() {
        return this.tt.c();
    }

    public void setRipple(float f) {
        x xVar = this.tt;
        if (xVar != null) {
            xVar.tt(f);
        }
    }

    @Override // com.byazt.rb.sp
    public float getRipple() {
        return this.tt.getRipple();
    }

    public void setShine(float f) {
        x xVar = this.tt;
        if (xVar != null) {
            xVar.ve(f);
        }
    }

    @Override // com.byazt.rb.sp
    public float getShine() {
        return this.tt.getShine();
    }

    public void setStretch(float f) {
        x xVar = this.tt;
        if (xVar != null) {
            xVar.uj(f);
        }
    }

    @Override // com.byazt.rb.sp
    public float getStretch() {
        return this.tt.getStretch();
    }

    public void setRubIn(float f) {
        x xVar = this.tt;
        if (xVar != null) {
            xVar.n(f);
        }
    }

    @Override // com.byazt.rb.sp
    public float getRubIn() {
        return this.tt.getRubIn();
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.tt.c(i);
    }
}
