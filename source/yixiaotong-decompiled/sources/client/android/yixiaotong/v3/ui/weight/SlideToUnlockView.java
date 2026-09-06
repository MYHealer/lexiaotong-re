package client.android.yixiaotong.v3.ui.weight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SlideToUnlockView extends View {
    private int height;
    private String hintText;
    private boolean isUnlocked;
    private OnUnlockListener listener;
    private Paint paint;
    private float sliderPosition;
    private float sliderRadius;
    private RectF sliderRect;
    private Paint textPaint;
    private Paint textPaint1;
    private int width;

    public interface OnUnlockListener {
        void onUnlock();
    }

    public void setOnUnlockListener(OnUnlockListener onUnlockListener) {
        this.listener = onUnlockListener;
    }

    public SlideToUnlockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sliderRadius = 50.0f;
        this.isUnlocked = false;
        this.hintText = "向右滑动开阀";
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.sliderRect = new RectF();
        Paint paint2 = new Paint();
        this.textPaint = paint2;
        paint2.setAntiAlias(true);
        this.textPaint.setColor(-12303292);
        this.textPaint.setTextSize(40.0f);
        this.textPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint();
        this.textPaint1 = paint3;
        paint3.setTextSize(60.0f);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        this.sliderPosition = this.sliderRadius;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.paint.setColor(275146342);
        canvas.drawRect(0.0f, 0.0f, this.width, this.height, this.paint);
        canvas.drawText(this.hintText, this.width / 2, (this.height / 2) - ((this.textPaint.ascent() + this.textPaint.descent()) / 2.0f), this.textPaint);
        this.paint.setColor(this.isUnlocked ? -13710223 : -16741633);
        RectF rectF = this.sliderRect;
        float f = this.sliderPosition;
        float f2 = this.sliderRadius;
        rectF.set(f - f2, 0.0f, f + f2 + 20.0f, this.height);
        canvas.drawRect(this.sliderRect, this.paint);
        float f3 = this.sliderPosition - 10.0f;
        float fAscent = (this.height / 2) - ((this.textPaint1.ascent() + this.textPaint1.descent()) / 2.0f);
        this.textPaint1.setColor(-1);
        canvas.drawText(">>", f3, fAscent, this.textPaint1);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                float f = this.sliderPosition;
                float f2 = this.width;
                float f3 = this.sliderRadius;
                if (f >= f2 - (2.0f * f3)) {
                    this.isUnlocked = true;
                    OnUnlockListener onUnlockListener = this.listener;
                    if (onUnlockListener != null) {
                        onUnlockListener.onUnlock();
                    }
                } else {
                    this.sliderPosition = f3;
                }
                invalidate();
            } else if (action == 2) {
                float f4 = this.sliderRadius;
                if (x >= f4 && x <= this.width - f4) {
                    this.sliderPosition = x;
                    invalidate();
                }
            }
        }
        return true;
    }
}
