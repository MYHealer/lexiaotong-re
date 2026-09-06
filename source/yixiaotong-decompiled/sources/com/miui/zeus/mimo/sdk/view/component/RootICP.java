package com.miui.zeus.mimo.sdk.view.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.h8;
import com.miui.zeus.mimo.sdk.i8;
import com.miui.zeus.mimo.sdk.n6;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class RootICP extends FrameLayout implements h8 {
    private i8 mClickAreaListener;
    private long mInitTime;
    private float mLastX;
    private float mLastY;
    private boolean mNeedUniversalSlide;
    private int mScaledTouchSlop;
    private double mTotalDistance;
    private float mTouchMoveSlop;
    private double mUSDistance;
    public n6 mViewEventInfo;
    private boolean needSwipeUp;

    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i8 f5706a;

        public a(i8 i8Var) {
            this.f5706a = i8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i8 i8Var = this.f5706a;
            if (i8Var != null) {
                i8Var.onClick(view, RootICP.this.getClickAreaType());
            }
        }
    }

    public RootICP(Context context) {
        this(context, null);
    }

    public RootICP(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RootICP(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScaledTouchSlop = -1;
        this.mViewEventInfo = new n6();
        this.needSwipeUp = false;
        this.mTouchMoveSlop = 0.12f;
        this.mNeedUniversalSlide = false;
    }

    public ClickAreaType getClickAreaType() {
        return ClickAreaType.TYPE_OTHER;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        i8 i8Var;
        i8 i8Var2;
        if (motionEvent == null) {
            return false;
        }
        if (this.mScaledTouchSlop < 0) {
            this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 0) {
            this.mInitTime = System.currentTimeMillis();
            n6 n6Var = new n6();
            this.mViewEventInfo = n6Var;
            n6Var.f5538a = (int) motionEvent.getX();
            this.mViewEventInfo.b = (int) motionEvent.getY();
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mTotalDistance = 0.0d;
        } else if (motionEvent.getAction() == 1) {
            this.mViewEventInfo.c = (int) motionEvent.getX();
            this.mViewEventInfo.d = (int) motionEvent.getY();
            this.mViewEventInfo.e = getWidth();
            this.mViewEventInfo.f = getHeight();
            n6 n6Var2 = this.mViewEventInfo;
            float fAbs = Math.abs(n6Var2.c - n6Var2.f5538a);
            n6 n6Var3 = this.mViewEventInfo;
            float fAbs2 = Math.abs(n6Var3.d - n6Var3.b);
            float fAbs3 = Math.abs(System.currentTimeMillis() - this.mInitTime);
            float f = this.mScaledTouchSlop;
            if (fAbs < f && fAbs2 < f && fAbs3 < 200.0f) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                n6 n6Var4 = this.mViewEventInfo;
                n6Var4.g = iArr[0];
                n6Var4.h = iArr[1];
            }
            if (this.needSwipeUp && fAbs2 > getHeight() * this.mTouchMoveSlop && (i8Var2 = this.mClickAreaListener) != null) {
                i8Var2.onClick(this, ClickAreaType.TYPE_SWIPEUP);
            }
            if (this.mNeedUniversalSlide && this.mTotalDistance > this.mUSDistance && (i8Var = this.mClickAreaListener) != null) {
                i8Var.onClick(this, ClickAreaType.TYPE_UNIVERSAL_SLIDE);
            }
        } else if (motionEvent.getAction() == 2 && this.mNeedUniversalSlide) {
            float x = motionEvent.getX() - this.mLastX;
            float y = motionEvent.getY() - this.mLastY;
            this.mLastX = motionEvent.getX();
            this.mLastY = motionEvent.getY();
            this.mTotalDistance += Math.sqrt((x * x) + (y * y));
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setCLickAreaListener(i8 i8Var) {
        this.mClickAreaListener = i8Var;
        setOnClickListener(new a(i8Var));
    }

    public void setTouchMoveSlop(boolean z, float f) {
        this.needSwipeUp = z;
        this.mTouchMoveSlop = f;
    }

    public void setUniversalSlideSlop(boolean z, double d) {
        this.mNeedUniversalSlide = z;
        this.mUSDistance = d;
    }
}
