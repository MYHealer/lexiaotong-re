package client.android.yixiaotong.ui.drinkwater;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import client.android.yixiaotong.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DragView extends FrameLayout {
    private View autoTextView;
    ViewDragHelper dragHelper;
    Point initPoint;
    ImageView iv;

    public DragView(Context context) {
        this(context, null);
    }

    public DragView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DragView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.initPoint = new Point();
        this.dragHelper = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback() { // from class: client.android.yixiaotong.ui.drinkwater.DragView.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i2) {
                return true;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i2, int i3) {
                int paddingLeft = DragView.this.getPaddingLeft();
                return Math.min(Math.max(i2, paddingLeft), (DragView.this.getWidth() - view.getWidth()) - paddingLeft);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i2, int i3) {
                int paddingTop = DragView.this.getPaddingTop();
                return Math.min(Math.max(i2, paddingTop), (DragView.this.getHeight() - view.getHeight()) - paddingTop);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                super.onViewReleased(view, f, f2);
                if (view != DragView.this.autoTextView || view.getLeft() >= DragView.this.getWidth() / 2) {
                    return;
                }
                DragView.this.dragHelper.smoothSlideViewTo(view, DragView.this.initPoint.x, DragView.this.initPoint.y);
                ViewCompat.postInvalidateOnAnimation(DragView.this);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewHorizontalDragRange(View view) {
                if (view == DragView.this.iv) {
                    return (DragView.this.getWidth() - DragView.this.getPaddingLeft()) - view.getWidth();
                }
                return super.getViewHorizontalDragRange(view);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                if (view == DragView.this.iv) {
                    return (DragView.this.getHeight() - DragView.this.getTop()) - view.getHeight();
                }
                return super.getViewVerticalDragRange(view);
            }
        });
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.iv = (ImageView) findViewById(R.id.play_soundwave);
        this.autoTextView = getChildAt(0);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.dragHelper.processTouchEvent(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (this.dragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.dragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.initPoint.x = this.autoTextView.getLeft();
        this.initPoint.y = this.autoTextView.getTop();
    }
}
