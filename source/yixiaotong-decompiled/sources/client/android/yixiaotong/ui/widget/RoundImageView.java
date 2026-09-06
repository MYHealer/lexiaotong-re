package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RoundImageView extends AppCompatImageView {
    private float height;
    private int round;
    private float width;

    public RoundImageView(Context context) {
        this(context, null);
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.round = 12;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.width = getWidth();
        this.height = getHeight();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        float f = this.width;
        int i = this.round;
        if (f > i && this.height > i) {
            Path path = new Path();
            path.moveTo(this.round, 0.0f);
            path.lineTo(this.width - this.round, 0.0f);
            float f2 = this.width;
            path.quadTo(f2, 0.0f, f2, this.round);
            path.lineTo(this.width, this.height - this.round);
            float f3 = this.width;
            float f4 = this.height;
            path.quadTo(f3, f4, f3 - this.round, f4);
            path.lineTo(this.round, this.height);
            float f5 = this.height;
            path.quadTo(0.0f, f5, 0.0f, f5 - this.round);
            path.lineTo(0.0f, this.round);
            path.quadTo(0.0f, 0.0f, this.round, 0.0f);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
    }
}
