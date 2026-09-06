package com.afollestad.materialdialogs.internal;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.R;
import com.afollestad.materialdialogs.util.DialogUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MDButton extends TextView {
    private Drawable mDefaultBackground;
    private boolean mStacked;
    private Drawable mStackedBackground;
    private int mStackedEndPadding;
    private GravityEnum mStackedGravity;

    public void setStackedGravity(GravityEnum gravityEnum) {
        this.mStackedGravity = gravityEnum;
    }

    public MDButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mStacked = false;
        init(context, attributeSet, 0, 0);
    }

    public MDButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mStacked = false;
        init(context, attributeSet, i, 0);
    }

    public MDButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mStacked = false;
        init(context, attributeSet, i, i2);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mStackedEndPadding = context.getResources().getDimensionPixelSize(R.dimen.md_dialog_frame_margin);
        this.mStackedGravity = GravityEnum.END;
    }

    void setStacked(boolean z, boolean z2) {
        if (this.mStacked != z || z2) {
            setGravity(z ? this.mStackedGravity.getGravityInt() | 16 : 17);
            setTextAlignment(z ? this.mStackedGravity.getTextAlignment() : 4);
            DialogUtils.setBackgroundCompat(this, z ? this.mStackedBackground : this.mDefaultBackground);
            if (z) {
                setPadding(this.mStackedEndPadding, getPaddingTop(), this.mStackedEndPadding, getPaddingBottom());
            }
            this.mStacked = z;
        }
    }

    public void setStackedSelector(Drawable drawable) {
        this.mStackedBackground = drawable;
        if (this.mStacked) {
            setStacked(true, true);
        }
    }

    public void setDefaultSelector(Drawable drawable) {
        this.mDefaultBackground = drawable;
        if (this.mStacked) {
            return;
        }
        setStacked(false, true);
    }

    public void setAllCapsCompat(boolean z) {
        setAllCaps(z);
    }
}
