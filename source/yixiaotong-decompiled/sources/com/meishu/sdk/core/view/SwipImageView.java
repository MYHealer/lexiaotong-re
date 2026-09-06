package com.meishu.sdk.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class SwipImageView extends ImageView {
    private static final String TAG = "SwipImageView";
    private Bitmap bitmap;
    private int clkType;
    private int distance;
    private float downloadX;
    private float downloadY;
    private float endMoveX;
    private float endMoveY;
    private OnSwipeListener mListener;
    private float maxMoveX;
    private float maxMoveY;

    public interface OnSwipeListener {
        void onSwipe(int i);
    }

    public SwipImageView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downloadX = motionEvent.getRawX();
            this.downloadY = motionEvent.getRawY();
            motionEvent.getX();
            motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                motionEvent.getX();
                motionEvent.getY();
                invalidate();
                float f = rawY - this.downloadY;
                if (f < 0.0f && this.maxMoveY < Math.abs(f)) {
                    this.maxMoveY = Math.abs(rawY - this.downloadY);
                }
                float f2 = this.maxMoveX;
                float f3 = rawX - this.downloadX;
                if (f2 < f3) {
                    this.maxMoveX = f3;
                }
                this.endMoveX = f3;
                this.endMoveY = rawY - this.downloadY;
            }
        } else {
            if ((this.clkType & 2) == 2 && this.maxMoveY < 10.0f && this.maxMoveX < 10.0f && Math.abs(this.endMoveX) < 10.0f && Math.abs(this.endMoveY) < 10.0f) {
                OnSwipeListener onSwipeListener = this.mListener;
                if (onSwipeListener != null) {
                    onSwipeListener.onSwipe(2);
                }
                return super.onTouchEvent(motionEvent);
            }
            if ((this.clkType & 32) == 32 && this.maxMoveY > this.distance && Math.abs(this.endMoveX) / Math.abs(this.endMoveY) < 1.0f) {
                OnSwipeListener onSwipeListener2 = this.mListener;
                if (onSwipeListener2 != null) {
                    onSwipeListener2.onSwipe(32);
                }
                this.maxMoveX = 0.0f;
                this.maxMoveY = 0.0f;
                return true;
            }
            if ((this.clkType & 128) == 128 && this.maxMoveX > this.distance && Math.abs(this.endMoveX) / Math.abs(this.endMoveY) > 1.0f) {
                OnSwipeListener onSwipeListener3 = this.mListener;
                if (onSwipeListener3 != null) {
                    onSwipeListener3.onSwipe(128);
                }
                this.maxMoveX = 0.0f;
                this.maxMoveY = 0.0f;
                return true;
            }
        }
        return true;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.mListener = onSwipeListener;
    }

    public SwipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setMoveDistance(int i, int i2) {
        this.clkType = i;
        this.distance = (getResources().getDisplayMetrics().widthPixels * i2) / 100;
    }

    public SwipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
