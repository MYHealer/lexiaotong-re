package com.ubixnow.adtype.splash.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.google.android.exoplayer2.C;
import com.ubixnow.core.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6464928.dex */
public class CountdownView extends View {
    private static final String OooO00o = "CountdownView";
    private int OooO;
    private final int OooO0O0;
    private final int OooO0OO;
    private final int OooO0Oo;
    private Paint OooO0o;
    private final int OooO0o0;
    private int OooO0oO;
    private Paint OooO0oo;
    private Paint OooOO0;
    private int OooOO0O;
    private Paint OooOO0o;
    private float OooOOO;
    private int OooOOO0;
    private String OooOOOO;
    private int OooOOOo;
    private long OooOOo;
    private int OooOOo0;
    private long OooOOoo;
    private OooO0O0 OooOo0;
    private boolean OooOo00;

    public class OooO00o implements ValueAnimator.AnimatorUpdateListener {
        public OooO00o() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            CountdownView.this.OooOOo0 = 100 - ((Integer) valueAnimator.getAnimatedValue()).intValue();
            CountdownView countdownView = CountdownView.this;
            countdownView.OooOOoo = countdownView.OooOOo - valueAnimator.getCurrentPlayTime();
            if (CountdownView.this.OooOo0 != null) {
                CountdownView.this.OooOo0.OooO00o(CountdownView.this.OooOOo0, CountdownView.this.OooOOo0 == 0);
            }
            CountdownView.this.invalidate();
        }
    }

    public interface OooO0O0 {
        void OooO00o(int i, boolean z);
    }

    public CountdownView(Context context) {
        super(context);
        this.OooO0O0 = -1118482;
        this.OooO0OO = SupportMenu.CATEGORY_MASK;
        this.OooO0Oo = -14606047;
        this.OooO0o0 = 855638016;
        this.OooO0oO = 855638016;
        this.OooO = -1118482;
        this.OooOO0O = SupportMenu.CATEGORY_MASK;
        this.OooOOO0 = -14606047;
        this.OooOOO = 12.0f;
        this.OooOOOO = "";
        this.OooOOo = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        this.OooOOoo = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        this.OooOo00 = true;
        OooO00o();
    }

    public CountdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.OooO0O0 = -1118482;
        this.OooO0OO = SupportMenu.CATEGORY_MASK;
        this.OooO0Oo = -14606047;
        this.OooO0o0 = 855638016;
        this.OooO0oO = 855638016;
        this.OooO = -1118482;
        this.OooOO0O = SupportMenu.CATEGORY_MASK;
        this.OooOOO0 = -14606047;
        this.OooOOO = 12.0f;
        this.OooOOOO = "";
        this.OooOOo = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        this.OooOOoo = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        this.OooOo00 = true;
        OooO00o(attributeSet);
        OooO00o();
    }

    public CountdownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.OooO0O0 = -1118482;
        this.OooO0OO = SupportMenu.CATEGORY_MASK;
        this.OooO0Oo = -14606047;
        this.OooO0o0 = 855638016;
        this.OooO0oO = 855638016;
        this.OooO = -1118482;
        this.OooOO0O = SupportMenu.CATEGORY_MASK;
        this.OooOOO0 = -14606047;
        this.OooOOO = 12.0f;
        this.OooOOOO = "";
        this.OooOOo = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        this.OooOOoo = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
        this.OooOo00 = true;
        OooO00o(attributeSet);
        OooO00o();
    }

    public static int OooO00o(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void OooO00o() {
        Paint paint = new Paint();
        this.OooO0oo = paint;
        int iOooO00o = OooO00o(getContext(), 2.0f);
        this.OooOOOo = iOooO00o;
        paint.setStrokeWidth(iOooO00o);
        this.OooO0oo.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.OooOO0 = paint2;
        int iOooO00o2 = OooO00o(getContext(), 2.0f);
        this.OooOOOo = iOooO00o2;
        paint2.setStrokeWidth(iOooO00o2);
        this.OooOO0.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.OooOO0o = paint3;
        paint3.setStyle(Paint.Style.FILL);
        Paint paint4 = new Paint();
        this.OooO0o = paint4;
        paint4.setStyle(Paint.Style.FILL);
    }

    private void OooO00o(Canvas canvas) {
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - this.OooOOOo, this.OooO0oo);
    }

    private void OooO00o(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.UMNCountdownView);
        this.OooOOo = (long) (typedArrayObtainStyledAttributes.getFloat(R.styleable.UMNCountdownView_umn_duration, 3.0f) * 1000.0f);
        this.OooO = typedArrayObtainStyledAttributes.getColor(R.styleable.UMNCountdownView_umn_progress_color, -1118482);
        this.OooOO0O = typedArrayObtainStyledAttributes.getColor(R.styleable.UMNCountdownView_umn_progress_light_color, SupportMenu.CATEGORY_MASK);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.UMNCountdownView_umn_center_text)) {
            this.OooOOOO = typedArrayObtainStyledAttributes.getString(R.styleable.UMNCountdownView_umn_center_text);
            this.OooOo00 = false;
        }
        this.OooOOO0 = typedArrayObtainStyledAttributes.getColor(R.styleable.UMNCountdownView_umn_center_text_color, -14606047);
        this.OooOOO = typedArrayObtainStyledAttributes.getDimension(R.styleable.UMNCountdownView_umn_center_text_size, OooO0O0(getContext(), 12.0f));
        typedArrayObtainStyledAttributes.recycle();
    }

    private float OooO0O0() {
        return this.OooOOo0 / 100.0f;
    }

    public static int OooO0O0(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    private void OooO0O0(Canvas canvas) {
        canvas.save();
        canvas.rotate(-90.0f, getWidth() / 2, getHeight() / 2);
        float f = this.OooOOOo;
        canvas.drawArc(new RectF(f, f, getWidth() - this.OooOOOo, getHeight() - this.OooOOOo), 0.0f, OooO0O0() * 360.0f, false, this.OooOO0);
        canvas.restore();
    }

    private void OooO0OO(Canvas canvas) {
        Rect rect = new Rect();
        Paint paint = this.OooOO0o;
        String str = this.OooOOOO;
        paint.getTextBounds(str, 0, str.length(), rect);
        Paint.FontMetrics fontMetrics = this.OooOO0o.getFontMetrics();
        String str2 = this.OooOOOO;
        float width = (getWidth() / 2) - (rect.width() / 2);
        float height = getHeight() / 2;
        float f = fontMetrics.descent;
        canvas.drawText(str2, width, (height - f) + ((f - fontMetrics.ascent) / 2.0f), this.OooOO0o);
    }

    private void OooO0Oo() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 100);
        valueAnimatorOfInt.setDuration(this.OooOOo);
        valueAnimatorOfInt.setInterpolator(new LinearInterpolator());
        valueAnimatorOfInt.addUpdateListener(new OooO00o());
        valueAnimatorOfInt.start();
    }

    public void OooO0OO() {
        OooO0Oo();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.OooO0oo.setColor(this.OooO);
        this.OooOO0.setColor(this.OooOO0O);
        this.OooOO0o.setColor(this.OooOOO0);
        this.OooOO0o.setTextSize(this.OooOOO);
        this.OooO0o.setColor(this.OooO0oO);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (getWidth() / 2) - this.OooOOOo, this.OooO0o);
        if (this.OooOOOO == null) {
            this.OooOo00 = true;
        }
        if (this.OooOo00) {
            long j = this.OooOOoo;
            String strValueOf = String.valueOf((j / 1000) + ((long) (j == this.OooOOo ? 0 : 1)));
            if (this.OooOOoo <= 0) {
                strValueOf = "0";
            }
            this.OooOOOO = strValueOf + "s";
        }
        OooO0OO(canvas);
        OooO0O0(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        if (mode != 1073741824) {
            size = OooO00o(getContext(), 50.0f);
        }
        if (mode2 != 1073741824) {
            size2 = OooO00o(getContext(), 50.0f);
        }
        if (size != size2) {
            size = Math.max(size, size2);
            size2 = size;
        }
        setMeasuredDimension(size, size2);
    }

    public void setBgColor(int i) {
        this.OooO0oO = i;
    }

    public void setCountdownListener(OooO0O0 oooO0O0) {
        this.OooOo0 = oooO0O0;
    }

    public void setDuration(long j) {
        this.OooOOo = j;
    }

    public void setProgressColor(int i) {
        this.OooO = i;
    }

    public void setProgressLightColor(int i) {
        this.OooOO0O = i;
    }

    public void setText(String str) {
        this.OooOOOO = str;
        this.OooOo00 = false;
    }

    public void setTextColor(int i) {
        this.OooOOO0 = i;
    }

    public void setTextSize(float f) {
        this.OooOOO = OooO0O0(getContext(), f);
    }
}
