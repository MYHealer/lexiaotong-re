package me.zhanghai.android.materialprogressbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import androidx.core.graphics.ColorUtils;
import me.zhanghai.android.materialprogressbar.internal.ThemeUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class HorizontalProgressDrawable extends LayerDrawable implements IntrinsicPaddingDrawable, ShowBackgroundDrawable, TintableDrawable {
    private static final String TAG = "HorizontalProgressDrawable";
    private float mBackgroundAlpha;
    private HorizontalProgressBackgroundDrawable mBackgroundDrawable;
    private boolean mHasSecondaryProgressTint;
    private boolean mHasSecondaryProgressTintColor;
    private SingleHorizontalProgressDrawable mProgressDrawable;
    private SingleHorizontalProgressDrawable mSecondaryProgressDrawable;
    private ColorStateList mSecondaryProgressTint;
    private int mSecondaryProgressTintColor;

    private float compositeAlpha(float f, float f2) {
        return f + (f2 * (1.0f - f));
    }

    public HorizontalProgressDrawable(Context context) {
        super(new Drawable[]{new HorizontalProgressBackgroundDrawable(context), new SingleHorizontalProgressDrawable(context), new SingleHorizontalProgressDrawable(context)});
        this.mBackgroundAlpha = ThemeUtils.getFloatFromAttrRes(android.R.attr.disabledAlpha, context);
        setId(0, android.R.id.background);
        this.mBackgroundDrawable = (HorizontalProgressBackgroundDrawable) getDrawable(0);
        setId(1, android.R.id.secondaryProgress);
        this.mSecondaryProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(1);
        setId(2, android.R.id.progress);
        this.mProgressDrawable = (SingleHorizontalProgressDrawable) getDrawable(2);
        setTint(ThemeUtils.getColorFromAttrRes(R.attr.colorControlActivated, context));
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public boolean getShowBackground() {
        return this.mBackgroundDrawable.getShowBackground();
    }

    @Override // me.zhanghai.android.materialprogressbar.ShowBackgroundDrawable
    public void setShowBackground(boolean z) {
        if (this.mBackgroundDrawable.getShowBackground() != z) {
            this.mBackgroundDrawable.setShowBackground(z);
            updateSecondaryProgressTint();
        }
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public boolean getUseIntrinsicPadding() {
        return this.mBackgroundDrawable.getUseIntrinsicPadding();
    }

    @Override // me.zhanghai.android.materialprogressbar.IntrinsicPaddingDrawable
    public void setUseIntrinsicPadding(boolean z) {
        this.mBackgroundDrawable.setUseIntrinsicPadding(z);
        this.mSecondaryProgressDrawable.setUseIntrinsicPadding(z);
        this.mProgressDrawable.setUseIntrinsicPadding(z);
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTint(int i) {
        int alphaComponent = ColorUtils.setAlphaComponent(i, Math.round(Color.alpha(i) * this.mBackgroundAlpha));
        this.mBackgroundDrawable.setTint(alphaComponent);
        setSecondaryProgressTint(alphaComponent);
        this.mProgressDrawable.setTint(i);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintList(ColorStateList colorStateList) {
        ColorStateList colorStateListWithAlpha;
        if (colorStateList != null) {
            if (!colorStateList.isOpaque()) {
                Log.w(TAG, "setTintList() called with a non-opaque ColorStateList, its original alpha will be discarded");
            }
            colorStateListWithAlpha = colorStateList.withAlpha(Math.round(this.mBackgroundAlpha * 255.0f));
        } else {
            colorStateListWithAlpha = null;
        }
        this.mBackgroundDrawable.setTintList(colorStateListWithAlpha);
        setSecondaryProgressTintList(colorStateListWithAlpha);
        this.mProgressDrawable.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable, me.zhanghai.android.materialprogressbar.TintableDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mBackgroundDrawable.setTintMode(mode);
        this.mSecondaryProgressDrawable.setTintMode(mode);
        this.mProgressDrawable.setTintMode(mode);
    }

    private void setSecondaryProgressTint(int i) {
        this.mHasSecondaryProgressTintColor = true;
        this.mSecondaryProgressTintColor = i;
        this.mHasSecondaryProgressTint = false;
        updateSecondaryProgressTint();
    }

    private void setSecondaryProgressTintList(ColorStateList colorStateList) {
        this.mHasSecondaryProgressTintColor = false;
        this.mHasSecondaryProgressTint = true;
        this.mSecondaryProgressTint = colorStateList;
        updateSecondaryProgressTint();
    }

    private void updateSecondaryProgressTint() {
        if (this.mHasSecondaryProgressTintColor) {
            int alphaComponent = this.mSecondaryProgressTintColor;
            if (!getShowBackground()) {
                float fAlpha = Color.alpha(alphaComponent) / 255.0f;
                alphaComponent = ColorUtils.setAlphaComponent(alphaComponent, Math.round(compositeAlpha(fAlpha, fAlpha) * 255.0f));
            }
            this.mSecondaryProgressDrawable.setTint(alphaComponent);
            return;
        }
        if (this.mHasSecondaryProgressTint) {
            ColorStateList colorStateListWithAlpha = this.mSecondaryProgressTint;
            if (!getShowBackground()) {
                float f = this.mBackgroundAlpha;
                colorStateListWithAlpha = colorStateListWithAlpha.withAlpha(Math.round(compositeAlpha(f, f) * 255.0f));
            }
            this.mSecondaryProgressDrawable.setTintList(colorStateListWithAlpha);
        }
    }
}
