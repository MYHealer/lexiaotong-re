package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.kwad.sdk.R;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.al;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class KSRelativeLayout extends RelativeLayout implements k {
    private final al.a baL;
    private i btg;
    private k bth;
    private final AtomicBoolean cb;
    private float mRatio;
    private j mViewRCHelper;

    public al.a getTouchCoords() {
        return this.baL;
    }

    public void setRatio(float f) {
        this.mRatio = f;
    }

    public void setViewVisibleListener(k kVar) {
        this.bth = kVar;
    }

    public KSRelativeLayout(Context context) {
        super(context);
        this.cb = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.baL = new al.a();
        init(context, null);
    }

    public KSRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cb = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.baL = new al.a();
        init(context, attributeSet);
    }

    public KSRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cb = new AtomicBoolean(true);
        this.mRatio = 0.0f;
        this.baL = new al.a();
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            int i = R.attr.ksad_ratio;
            int[] iArr = {i};
            Arrays.sort(iArr);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
            this.mRatio = typedArrayObtainStyledAttributes.getFloat(Arrays.binarySearch(iArr, i), 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        i iVar = new i(this, this);
        this.btg = iVar;
        iVar.cG(true);
        j jVar = new j();
        this.mViewRCHelper = jVar;
        jVar.initAttrs(context, attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        zP();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        zP();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        zQ();
    }

    @Override // android.view.ViewGroup, android.view.View
    @Deprecated
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        zQ();
    }

    private void zP() {
        if (this.cb.getAndSet(false)) {
            ae();
        }
    }

    private void zQ() {
        if (this.cb.getAndSet(true)) {
            return;
        }
        af();
    }

    protected void ae() {
        this.btg.onAttachedToWindow();
    }

    protected void af() {
        this.btg.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.btg.d(i, i2, i3, i4);
        super.onSizeChanged(i, i2, i3, i4);
        this.btg.XM();
        this.mViewRCHelper.onSizeChanged(i, i2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        this.mViewRCHelper.beforeDraw(canvas);
        super.draw(canvas);
        this.mViewRCHelper.afterDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.mViewRCHelper.beforeDispatchDraw(canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        this.mViewRCHelper.afterDispatchDraw(canvas);
    }

    public void setVisiblePercent(float f) {
        this.btg.setVisiblePercent(f);
    }

    public float getVisiblePercent() {
        return this.btg.getVisiblePercent();
    }

    @Override // com.kwad.sdk.widget.k
    public final void H(View view) {
        k kVar = this.bth;
        if (kVar != null) {
            kVar.H(view);
        }
    }

    public void setRadius(float f) {
        this.mViewRCHelper.setRadius(f);
        postInvalidate();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mRatio != 0.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) (View.MeasureSpec.getSize(i) * this.mRatio), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.baL.H(getWidth(), getHeight());
            this.baL.j(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1) {
            this.baL.k(motionEvent.getX(), motionEvent.getY());
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
