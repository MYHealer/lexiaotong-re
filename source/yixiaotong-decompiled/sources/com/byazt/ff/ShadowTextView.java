package com.byazt.ff;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;
import com.byazt.zqa.c;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\5766332.dex */
@c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 1951})
public class ShadowTextView extends TextView {
    public Paint c;
    public RectF tt;
    public int ve;

    public ShadowTextView(Context context) {
        this(context, null);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ve = 0;
        c();
    }

    private void c() {
        setTextColor(-1);
        Paint paint = new Paint();
        this.c = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.c.setColor(Color.parseColor("#99333333"));
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth(0.0f);
        this.tt = new RectF();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            int iMeasureText = (int) getPaint().measureText("00");
            this.ve = iMeasureText;
            if (measuredWidth < iMeasureText) {
                measuredWidth = iMeasureText;
            }
            int i3 = measuredWidth + ((measuredHeight / 2) * 2);
            setMeasuredDimension(i3, measuredHeight);
            this.tt.set(0.0f, 0.0f, i3, measuredHeight);
            return;
        }
        this.tt.set(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.tt;
        canvas.drawRoundRect(rectF, rectF.bottom / 2.0f, this.tt.bottom / 2.0f, this.c);
        canvas.translate((this.tt.right / 2.0f) - (getPaint().measureText(getText().toString()) / 2.0f), 0.0f);
        super.onDraw(canvas);
    }
}
