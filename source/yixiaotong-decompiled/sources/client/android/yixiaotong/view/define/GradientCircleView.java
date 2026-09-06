package client.android.yixiaotong.view.define;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class GradientCircleView extends View {
    private float centerX;
    private float centerY;
    private int endColor;
    private Paint paint;
    private float radius;
    private int startColor;

    public int getEndColor() {
        return this.endColor;
    }

    public int getStartColor() {
        return this.startColor;
    }

    public GradientCircleView(Context context) {
        super(context);
        this.startColor = Color.parseColor("#E0FFF7");
        this.endColor = -1;
        init();
    }

    public GradientCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.startColor = Color.parseColor("#E0FFF7");
        this.endColor = -1;
        init();
    }

    public GradientCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.startColor = Color.parseColor("#E0FFF7");
        this.endColor = -1;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.centerX = i / 2.0f;
        this.centerY = i2 / 2.0f;
        this.radius = Math.min(i, i2) / 2.0f;
        this.paint.setShader(new RadialGradient(this.centerX, this.centerY, this.radius, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(this.centerX, this.centerY, this.radius, this.paint);
    }

    public void setStartColor(int i) {
        this.startColor = i;
        updateGradient();
        invalidate();
    }

    public void setEndColor(int i) {
        this.endColor = i;
        updateGradient();
        invalidate();
    }

    public void setGradientColors(int i, int i2) {
        this.startColor = i;
        this.endColor = i2;
        updateGradient();
        invalidate();
    }

    private void updateGradient() {
        if (this.radius > 0.0f) {
            this.paint.setShader(new RadialGradient(this.centerX, this.centerY, this.radius, this.startColor, this.endColor, Shader.TileMode.CLAMP));
        }
    }
}
