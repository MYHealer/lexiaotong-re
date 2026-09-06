package com.hihonor.adsdk.common.uikit.hweffect.engine;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.hihonor.adsdk.base.R;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class a implements com.hihonor.adsdk.common.uikit.hweffect.engine.b {
    private Context hnadsd;
    private View hnadse;
    private float hnadsf;
    private float hnadsg;
    private float hnadsh;
    private float hnadsi;
    private boolean hnadsj;
    private int hnadsk;
    private int hnadsl;
    private int hnadsm;
    private boolean hnadsn;
    private int hnadso;
    private HnShadowDrawable hnadsp;
    private boolean hnadsq;

    class b implements Drawable.Callback {
        b() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            a.this.hnadse.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }
    }

    public a(View view, AttributeSet attributeSet, int i, int i2) {
        this(view, attributeSet, i, i2, true);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getCornerRadius() {
        return this.hnadsp.getCornerRadius();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowElevation() {
        return this.hnadsp.getShadowElevation();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowOffsetX() {
        return this.hnadsp.getShadowOffsetX();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public float getShadowOffsetY() {
        return this.hnadsp.getShadowOffsetY();
    }

    public HnShadowDrawable hnadsb() {
        return this.hnadsp;
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public boolean isShowShadow() {
        return this.hnadsp.isShowShadow();
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setCornerRadius(float f) {
        this.hnadsp.setCornerRadius(f);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowBaseType(int i) {
        this.hnadsp.setShadowBaseType(i);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowColor(int i) {
        this.hnadsp.setShadowColor(i);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowElevation(float f) {
        this.hnadsp.setShadowElevation(f);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowLevel(int i) {
        this.hnadsp.setShadowLevel(i);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowOffsetX(float f) {
        this.hnadsp.setShadowOffsetX(f);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowOffsetY(float f) {
        this.hnadsp.setShadowOffsetY(f);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShadowType(int i) {
        this.hnadsp.setShadowType(i);
    }

    @Override // com.hihonor.adsdk.common.uikit.hweffect.engine.b
    public void setShowShadow(boolean z) {
        this.hnadsp.setShowShadow(z);
    }

    /* JADX INFO: renamed from: com.hihonor.adsdk.common.uikit.hweffect.engine.a$a, reason: collision with other inner class name */
    class ViewOnAttachStateChangeListenerC0460a implements View.OnAttachStateChangeListener {
        ViewOnAttachStateChangeListenerC0460a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup.getClipToPadding() || viewGroup.getClipChildren()) {
                    viewGroup.setClipChildren(false);
                    viewGroup.setClipToPadding(false);
                }
            }
            a.this.hnadse.removeOnAttachStateChangeListener(this);
        }
    }

    public a(View view, AttributeSet attributeSet, int i, int i2, boolean z) {
        this.hnadsj = true;
        this.hnadsk = 0;
        this.hnadsl = -1;
        this.hnadse = view;
        Context context = view.getContext();
        this.hnadsd = context;
        this.hnadsq = z;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHnShadowLayout, i, i2);
        hnadsa(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            this.hnadse.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0460a());
        } else {
            int shadowElevation = (int) getShadowElevation();
            int iAbs = Math.abs((int) getShadowOffsetX());
            int iAbs2 = Math.abs((int) getShadowOffsetY());
            this.hnadse.setPadding(this.hnadsp.isDrawLeft() ? shadowElevation + iAbs : 0, this.hnadsp.isDrawTop() ? shadowElevation + iAbs2 : 0, this.hnadsp.isDrawRight() ? iAbs + shadowElevation : 0, this.hnadsp.isDrawBottom() ? shadowElevation + iAbs2 : 0);
        }
        this.hnadsp.setCallback(new b());
    }

    private void hnadsb(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.hnadsd.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHnShadowLayout);
        if (typedArrayObtainStyledAttributes == null) {
            return;
        }
        try {
            hnadsb(typedArrayObtainStyledAttributes);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void hnadsa(int i, int i2) {
        if (this.hnadsq) {
            this.hnadsp.setBounds((int) (-getShadowElevation()), (int) (-getShadowElevation()), i + ((int) getShadowElevation()), i2 + ((int) getShadowElevation()));
        } else {
            this.hnadsp.setBounds(0, 0, i, i2);
        }
    }

    private void hnadsa(AttributeSet attributeSet) {
        hnadsb(attributeSet);
        hnadsa();
    }

    private void hnadsa(TypedArray typedArray) {
        hnadsb(typedArray);
        hnadsa();
    }

    private void hnadsb(TypedArray typedArray) {
        if (typedArray == null) {
            return;
        }
        this.hnadsg = typedArray.getDimension(R.styleable.HonorAdsHnShadowLayout_honorAdsCornerRadius, 0.0f);
        int i = typedArray.getInt(R.styleable.HonorAdsHnShadowLayout_honorAdsShadowBaseType, 0);
        this.hnadsk = i;
        if (i == 2) {
            this.hnadsi = typedArray.getDimension(R.styleable.HonorAdsHnShadowLayout_honorAdsShadowOffsetY, 0.0f);
            this.hnadsf = typedArray.getDimension(R.styleable.HonorAdsHnShadowLayout_honorAdsShadowElevation, 0.0f);
            this.hnadsm = typedArray.getColor(R.styleable.HonorAdsHnShadowLayout_honorAdsShadowColor, 0);
        } else {
            int i2 = typedArray.getInt(R.styleable.HonorAdsHnShadowLayout_honorAdsShadowLevel, -1);
            if (i2 != -1) {
                this.hnadsl = i2;
            } else {
                this.hnadsl = typedArray.getInt(R.styleable.HonorAdsHnShadowLayout_honorAdsShadowType, 0);
            }
            hnadsa(this.hnadsl);
        }
        this.hnadsj = typedArray.getBoolean(R.styleable.HonorAdsHnShadowLayout_honorAdsShowShadow, true);
        this.hnadsn = typedArray.getBoolean(R.styleable.HonorAdsHnShadowLayout_honorAdsUseRoundCorner, true);
        this.hnadso = typedArray.getInt(R.styleable.HonorAdsHnShadowLayout_honorAdsShadowDrawnSide, 15);
    }

    private void hnadsa() {
        this.hnadsp = new HnShadowDrawable.b(this.hnadsd).hnadsb(this.hnadsk).hnadsd(this.hnadsl).hnadsd(this.hnadsf).hnadsa(this.hnadsg).hnadsb(this.hnadsh).hnadsc(this.hnadsi).hnadsb(this.hnadsj).hnadsa(this.hnadsn).hnadsc(this.hnadsm).hnadsa(this.hnadso).hnadsa();
    }

    private void hnadsa(int i) {
        int i2 = this.hnadsk;
        boolean z = i2 == 0 && i >= HnShadowDrawable.BLUR_CONFIG.length;
        boolean z2 = i2 == 1 && i >= HnShadowDrawable.SOLID_CONFIG.length;
        if (i >= 0 && !z && !z2) {
            float f = this.hnadsd.getResources().getDisplayMetrics().density;
            if (this.hnadsk != 1) {
                int[][] iArr = HnShadowDrawable.BLUR_CONFIG;
                int[] iArr2 = iArr[i];
                this.hnadsi = iArr2[0] * f;
                this.hnadsf = iArr2[1] * f;
                this.hnadsm = this.hnadsd.getResources().getColor(iArr[i][2]);
                return;
            }
            int[][] iArr3 = HnShadowDrawable.SOLID_CONFIG;
            int[] iArr4 = iArr3[i];
            this.hnadsi = iArr4[0] * f;
            this.hnadsf = iArr4[1] * f;
            this.hnadsm = this.hnadsd.getResources().getColor(iArr3[i][2]);
            return;
        }
        throw new IllegalArgumentException("Shadow's type or level is out of range!");
    }

    public a(Context context, AttributeSet attributeSet) {
        this.hnadsj = true;
        this.hnadsk = 0;
        this.hnadsl = -1;
        this.hnadsd = context;
        this.hnadsq = false;
        hnadsa(attributeSet);
    }
}
