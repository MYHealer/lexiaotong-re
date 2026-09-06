package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.internal.view.SupportMenu;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RedTipTextView extends AppCompatTextView {
    public static final int RED_TIP_GONE = 2;
    public static final int RED_TIP_INVISIBLE = 0;
    public static final int RED_TIP_VISIBLE = 1;
    private int tipVisibility;

    public RedTipTextView(Context context) {
        super(context);
        this.tipVisibility = 0;
        init(null);
    }

    public RedTipTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tipVisibility = 0;
        init(attributeSet);
    }

    public RedTipTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tipVisibility = 0;
        init(attributeSet);
    }

    public void init(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.RedTipTextView);
            this.tipVisibility = typedArrayObtainStyledAttributes.getInt(R.styleable.RedTipTextView_redTipsVisibility, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.tipVisibility == 1) {
            int width = getWidth();
            int paddingRight = getPaddingRight();
            Paint paint = new Paint();
            paint.setColor(SupportMenu.CATEGORY_MASK);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            float f = paddingRight / 2;
            canvas.drawCircle(width - (getPaddingRight() / 2), f, f, paint);
        }
    }

    public void setVisibility1(int i) {
        this.tipVisibility = i;
        invalidate();
    }
}
