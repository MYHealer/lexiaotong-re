package client.android.yixiaotong.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.R;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PickerView extends ScrollView {
    private Context context;
    private List<String> mData;
    private float mDensity;
    private int mHeight;
    private Paint mLinePaint;
    private LinearLayout mTextGroup;
    private int mTextHeight;
    private float mTextSize;
    private int mWidth;
    private float mWrapContentHeight;
    private int position;
    private int scrollY;
    private int tempPosition;

    public int getPosition() {
        return this.position;
    }

    public PickerView(Context context) {
        this(context, null);
    }

    public PickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.tempPosition = -1;
        this.context = context;
        setOverScrollMode(2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PickerView, i, 0);
        try {
            this.mTextSize = typedArrayObtainStyledAttributes.getDimension(R.styleable.PickerView_textSize, 16.0f);
            float f = getResources().getDisplayMetrics().density;
            this.mDensity = f;
            int i2 = (int) ((((double) f) + 0.5d) * ((double) this.mTextSize));
            this.mTextHeight = i2;
            this.mWrapContentHeight = i2 * 6;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private void init() {
        LinearLayout linearLayout = new LinearLayout(this.context);
        this.mTextGroup = linearLayout;
        linearLayout.setOrientation(1);
        this.mTextGroup.setGravity(17);
        addView(this.mTextGroup);
        this.mTextGroup.addView(createTextView(""));
        for (int i = 0; i < this.mData.size(); i++) {
            this.mTextGroup.addView(createTextView("" + this.mData.get(i)));
        }
        this.mTextGroup.addView(createTextView(""));
        setBackground(new Drawable() { // from class: client.android.yixiaotong.ui.widget.PickerView.1
            @Override // android.graphics.drawable.Drawable
            public int getOpacity() {
                return 0;
            }

            @Override // android.graphics.drawable.Drawable
            public void setAlpha(int i2) {
            }

            @Override // android.graphics.drawable.Drawable
            public void setColorFilter(ColorFilter colorFilter) {
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas canvas) {
                canvas.drawLine(PickerView.this.mWidth * 0.1f, (PickerView.this.mHeight / 2) - PickerView.this.mTextHeight, PickerView.this.mWidth * 0.9f, (PickerView.this.mHeight / 2) - PickerView.this.mTextHeight, PickerView.this.mLinePaint);
                canvas.drawLine(PickerView.this.mWidth * 0.1f, (PickerView.this.mHeight / 2) + PickerView.this.mTextHeight, PickerView.this.mWidth * 0.9f, (PickerView.this.mHeight / 2) + PickerView.this.mTextHeight, PickerView.this.mLinePaint);
            }
        });
        Paint paint = new Paint();
        this.mLinePaint = paint;
        paint.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth(1.0f);
        this.mLinePaint.setColor(-6710887);
        setPosition(0);
    }

    private TextView createTextView(String str) {
        TextView textView = new TextView(this.context);
        textView.setText(str);
        textView.setTextColor(-14540254);
        textView.setTextSize(this.mTextSize);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, this.mTextHeight);
        layoutParams.bottomMargin = this.mTextHeight / 2;
        layoutParams.topMargin = this.mTextHeight / 2;
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    @Override // android.widget.ScrollView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int iMeasureWidth = measureWidth(i);
        this.mWidth = iMeasureWidth;
        float f = this.mWrapContentHeight;
        this.mHeight = (int) f;
        setMeasuredDimension(iMeasureWidth, (int) f);
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 0) ? (int) this.mWrapContentHeight : View.MeasureSpec.getSize(i);
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        int i5 = this.mTextHeight;
        int i6 = (i2 + i5) / (i5 * 2);
        this.position = i6;
        if (this.tempPosition != i6) {
            int childCount = this.mTextGroup.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                TextView textView = (TextView) this.mTextGroup.getChildAt(i7);
                if (this.position + 1 == i7) {
                    textView.setTextColor(-14540254);
                    textView.setTextSize(16.0f);
                } else {
                    textView.setTextColor(-6710887);
                    textView.setTextSize(13.0f);
                }
            }
        }
        this.tempPosition = this.position;
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.scrollY = getScrollY();
            postDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.widget.PickerView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PickerView.this.scrollY == PickerView.this.getScrollY()) {
                        int i = PickerView.this.scrollY % (PickerView.this.mTextHeight * 2);
                        if (i > PickerView.this.mTextHeight) {
                            PickerView pickerView = PickerView.this;
                            pickerView.smoothScrollTo(0, (pickerView.scrollY - i) + (PickerView.this.mTextHeight * 2));
                            return;
                        } else {
                            PickerView pickerView2 = PickerView.this;
                            pickerView2.smoothScrollTo(0, pickerView2.scrollY - i);
                            return;
                        }
                    }
                    PickerView pickerView3 = PickerView.this;
                    pickerView3.scrollY = pickerView3.getScrollY();
                    PickerView.this.post(this);
                }
            }, 30L);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.ScrollView
    public void fling(int i) {
        super.fling(i / 3);
    }

    public void setData(List<String> list) {
        this.mData = list;
        init();
    }

    public void setPosition(int i) {
        this.position = i;
        if (i == 0) {
            post(new Runnable() { // from class: client.android.yixiaotong.ui.widget.PickerView.3
                @Override // java.lang.Runnable
                public void run() {
                    PickerView.this.scrollTo(0, 1);
                }
            });
        } else {
            post(new Runnable() { // from class: client.android.yixiaotong.ui.widget.PickerView.4
                @Override // java.lang.Runnable
                public void run() {
                    PickerView pickerView = PickerView.this;
                    pickerView.scrollTo(0, pickerView.position * PickerView.this.mTextHeight * 2);
                }
            });
        }
    }
}
