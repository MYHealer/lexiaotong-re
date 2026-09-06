package com.hihonor.adsdk.common.uikit.hweffect.engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnShadowLayout extends FrameLayout implements b {
    public static final int REGULAR = 2;
    public static final int THICK = 3;
    public static final int THIN = 1;
    public static final int ULTRA_THIN = 0;
    private final RectF mChildRect;
    private a mHnShadow;
    private boolean mIsLocationDependOnChild;
    private Path mRoundCornerPath;

    public HnShadowLayout(Context context) {
        this(context, null);
    }

    private void initView(Context context, AttributeSet attributeSet) {
        a aVar = new a(context, attributeSet);
        this.mHnShadow = aVar;
        setBackground(aVar.hnadsb());
    }

    private void resetPadding() {
        int shadowElevation = (int) getShadowElevation();
        int iAbs = Math.abs((int) getShadowOffsetX());
        int iAbs2 = Math.abs((int) getShadowOffsetY());
        setPadding(this.mHnShadow.hnadsb().isDrawLeft() ? shadowElevation + iAbs : 0, this.mHnShadow.hnadsb().isDrawTop() ? shadowElevation + iAbs2 : 0, this.mHnShadow.hnadsb().isDrawRight() ? iAbs + shadowElevation : 0, this.mHnShadow.hnadsb().isDrawBottom() ? shadowElevation + iAbs2 : 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int height = ((getHeight() - getPaddingTop()) - getPaddingBottom()) >>> 1;
        int width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) >>> 1;
        if (getChildAt(0) == null) {
            super.dispatchDraw(canvas);
            return;
        }
        this.mRoundCornerPath.reset();
        this.mChildRect.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        com.hihonor.adsdk.common.e.b.a.a.hnadsa(getContext(), this.mRoundCornerPath, 1, this.mChildRect, Math.min(this.mHnShadow.getCornerRadius(), Math.min(height, width)));
        int iSave = canvas.save();
        canvas.clipPath(this.mRoundCornerPath);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getCornerRadius() {
        return this.mHnShadow.getCornerRadius();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowElevation() {
        return this.mHnShadow.getShadowElevation();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowOffsetX() {
        return this.mHnShadow.getShadowOffsetX();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowOffsetY() {
        return this.mHnShadow.getShadowOffsetY();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public boolean isShowShadow() {
        return this.mHnShadow.isShowShadow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!this.mIsLocationDependOnChild || getChildAt(0) == null) {
            return;
        }
        View childAt = getChildAt(0);
        this.mChildRect.set(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
        this.mHnShadow.hnadsb().updateContentRect(this.mChildRect);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.mHnShadow.hnadsa(i, i2);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setCornerRadius(float f) {
        this.mHnShadow.setCornerRadius(f);
    }

    public void setLocationDependOnChild(boolean z) {
        this.mIsLocationDependOnChild = z;
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowBaseType(int i) {
        this.mHnShadow.setShadowBaseType(i);
        resetPadding();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowColor(int i) {
        this.mHnShadow.setShadowColor(i);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowElevation(float f) {
        this.mHnShadow.setShadowElevation(f);
        resetPadding();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowLevel(int i) {
        this.mHnShadow.setShadowLevel(i);
        resetPadding();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowOffsetX(float f) {
        this.mHnShadow.setShadowOffsetX(f);
        resetPadding();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowOffsetY(float f) {
        this.mHnShadow.setShadowOffsetY(f);
        resetPadding();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowType(int i) {
        this.mHnShadow.setShadowType(i);
        resetPadding();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShowShadow(boolean z) {
        this.mHnShadow.setShowShadow(z);
        resetPadding();
    }

    public HnShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HnShadowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mChildRect = new RectF();
        this.mRoundCornerPath = new Path();
        setLayerType(2, null);
        initView(context, attributeSet);
    }
}
