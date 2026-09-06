package client.android.yixiaotong.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LvListView extends ListView implements AbsListView.OnScrollListener {
    private int itemHeight;
    private boolean lastFlag;
    private int scaleFlagIndex;
    private int showItemCount;
    private int step;
    private int stepCount;

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public LvListView(Context context) {
        this(context, null);
    }

    public LvListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LvListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.scaleFlagIndex = 1;
        this.lastFlag = false;
        this.step = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LvListView);
        this.showItemCount = typedArrayObtainStyledAttributes.getInt(R.styleable.LvListView_showViewCount, 0);
        typedArrayObtainStyledAttributes.recycle();
        setOnScrollListener(this);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.itemHeight = getHeight() / this.showItemCount;
            for (int i5 = 0; i5 < getChildCount(); i5++) {
                ((LinearLayout) getChildAt(i5)).setLayoutParams(new AbsListView.LayoutParams(-1, this.itemHeight));
            }
            this.stepCount = getAdapter().getCount() - 2;
        }
    }

    public void startScaleAnimator(final View view, float f, float f2) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f, f2);
        valueAnimatorOfFloat.setDuration(500L);
        valueAnimatorOfFloat.start();
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: client.android.yixiaotong.ui.widget.LvListView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                view.setScaleX(fFloatValue);
                view.setScaleY((fFloatValue * 0.6f) + 0.4f);
            }
        });
    }

    public void scrollToItem() {
        int i = this.step + 1;
        this.step = i;
        if (i == this.stepCount) {
            this.step = 0;
            this.lastFlag = true;
            startScaleAnimator(getChildAt(this.scaleFlagIndex), 1.0f, 0.6f);
            smoothScrollToPositionFromTop(this.step, 0, 1000);
            return;
        }
        smoothScrollToPositionFromTop(i, 0, 500);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Log.e("onScrollStateChanged", "scrollState--" + i);
        if (i == 2) {
            if (this.lastFlag) {
                return;
            }
            startScaleAnimator(absListView.getChildAt(this.scaleFlagIndex), 1.0f, 0.6f);
            startScaleAnimator(absListView.getChildAt(this.scaleFlagIndex + 1), 0.6f, 1.0f);
            this.scaleFlagIndex = 2;
            return;
        }
        if (i == 0 && this.lastFlag) {
            this.lastFlag = false;
            this.scaleFlagIndex = 1;
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Log.e("onScroll", "firstVisibleItem--" + i);
    }
}
