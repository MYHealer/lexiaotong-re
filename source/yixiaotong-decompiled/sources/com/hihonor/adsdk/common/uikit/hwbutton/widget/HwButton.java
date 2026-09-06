package com.hihonor.adsdk.common.uikit.hwbutton.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.e.a.a.a;
import com.hihonor.adsdk.common.e.d.c.c;
import com.hihonor.adsdk.common.e.e.a.b;
import com.hihonor.adsdk.common.e.f.a.i;
import com.hihonor.adsdk.common.uikit.hwprogressbar.graphics.drawable.HwLoadingDrawableImpl;
import com.hihonor.adsdk.common.uikit.hwprogressbar.widget.HwProgressBar;
import com.hihonor.adsdk.common.uikit.hwtextview.widget.HwTextView;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@RemoteViews.RemoteView
public class HwButton extends HwTextView {
    private static final String e0 = "HwButton";
    private static final int f0 = 15;
    private static final int g0 = 24;
    private static final int h0 = 8;
    private static final int i0 = 2;
    private static final int j0 = 2;
    private static final int k0 = 0;
    private static final int l0 = 1;
    private static final int m0 = 2;
    private static final int n0 = 3;
    private static final int o0 = -1;
    private static final int p0 = -1;
    private static final int q0 = 0;
    private static final int r0 = 1;
    private static final int s0 = 2;
    private static final int t0 = 480;
    private static final int u0 = 0;
    private static final int v0 = 1;
    private Drawable A;
    private Drawable B;
    private Drawable C;
    private Drawable D;
    private ColorStateList E;
    private int F;
    private int G;
    private boolean H;
    private Rect I;
    private a J;
    private boolean K;
    private int L;
    private int M;
    private int N;
    private Drawable O;
    private boolean P;
    private boolean Q;
    private i R;
    private i S;
    private int[] T;
    private int[] U;
    private Paint V;
    private RectF W;
    private ColorStateList a0;
    private Outline b0;
    private Rect c0;
    private int d0;
    private int l;
    private HwProgressBar m;
    private int n;
    private int o;
    private int p;
    private int q;
    private String r;
    private float s;
    private String t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private int y;
    private int z;

    public HwButton(Context context) {
        this(context, null);
    }

    private int getEffectType() {
        return this.d0 != 1 ? 7 : 3;
    }

    private int getWaitingDrawablePadding() {
        return hnadsb(this.q);
    }

    private static Context hnadsa(Context context, int i) {
        return com.hihonor.adsdk.common.e.e.a.a.hnadsa(context, i, R.style.Honor_Ads_Theme_Magic_HwButton);
    }

    private void hnadsb(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHwButton, i, 0);
        this.y = typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwButton_honorAdsHwButtonWaitTextColor, 0);
        this.z = typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwButton_honorAdsHwButtonWaitIconColor, 0);
        this.F = typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwButton_honorAdsHwFocusedPathColor, 0);
        this.H = typedArrayObtainStyledAttributes.getBoolean(R.styleable.HonorAdsHwButton_honorAdsHwIsVibrationEnabled, false);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R.styleable.HonorAdsHwButton_honorAdsHnEnableGradient, false);
        this.d0 = typedArrayObtainStyledAttributes.getInt(R.styleable.HonorAdsHwButton_honorAdsHnEffectType, 0);
        this.T = new int[]{typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwButton_honorAdsHnLightColorA, getResources().getColor(R.color.honor_ads_hwbutton_light_color_A)), typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwButton_honorAdsHnLightColorB, getResources().getColor(R.color.honor_ads_hwbutton_light_color_B))};
        this.U = new int[]{typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwButton_honorAdsHnGradientStartColor, getResources().getColor(R.color.honor_ads_hwbutton_gradient_start_color)), typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwButton_honorAdsHnGradientEndColor, getResources().getColor(R.color.honor_ads_hwbutton_gradient_end_color))};
        this.s = getTextSize();
        this.M = typedArrayObtainStyledAttributes.getInt(R.styleable.HonorAdsHwButton_honorAdsHnButtonStyleType, 1);
        typedArrayObtainStyledAttributes.recycle();
        this.Q = hnadse();
        if (this.P) {
            hnadsc();
        }
        this.N = hnadsb(getContext());
    }

    public static HwButton hnadsc(Context context) {
        Object objHnadsa = b.hnadsa(context, b.hnadsa(context, (Class<?>) HwButton.class, b.hnadsa(context, 15, 1)), (Class<?>) HwButton.class);
        if (objHnadsa instanceof HwButton) {
            return (HwButton) objHnadsa;
        }
        return null;
    }

    private boolean hnadse() {
        Class cls = Integer.TYPE;
        Object objHnadsa = com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, "isColorInThemes", new Class[]{Resources.class, cls}, new Object[]{getResources(), Integer.valueOf(R.color.honor_ads_magic_color_fg_inverse)}, "com.hihonor.android.content.res.ResourcesEx");
        Object objHnadsa2 = com.hihonor.adsdk.common.e.d.c.b.hnadsa((Object) null, "isColorInThemes", new Class[]{Resources.class, cls}, new Object[]{getResources(), Integer.valueOf(R.color.honor_ads_magic_accent)}, "com.hihonor.android.content.res.ResourcesEx");
        if ((objHnadsa instanceof Boolean) && (objHnadsa2 instanceof Boolean)) {
            return ((Boolean) objHnadsa).booleanValue() || ((Boolean) objHnadsa2).booleanValue();
        }
        return false;
    }

    private void setOriDrawableVisible(boolean z) {
        if (z) {
            setCompoundDrawables(this.A, this.C, this.B, this.D);
            return;
        }
        Drawable[] compoundDrawables = getCompoundDrawables();
        if (compoundDrawables.length > 3) {
            this.A = compoundDrawables[0];
            this.C = compoundDrawables[1];
            this.B = compoundDrawables[2];
            this.D = compoundDrawables[3];
        }
        setCompoundDrawables(null, null, null, null);
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    public int getFocusPathColor() {
        return this.F;
    }

    protected int getIconSize() {
        return hnadsb(this.n);
    }

    public boolean hnadsd() {
        return false;
    }

    protected boolean hnadsf() {
        return true;
    }

    public boolean hnadsg() {
        return this.P;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.P || this.Q) {
            return;
        }
        hnadsa(getParent());
    }

    @Override // com.hihonor.adsdk.common.uikit.hwtextview.widget.HwTextView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        hnadsh();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.u) {
            hnadsb();
        }
    }

    @Override // com.hihonor.adsdk.common.uikit.hwtextview.widget.HwTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.M != 2 || this.N < hnadsb(t0)) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.honor_ads_hwbutton_large_button_resize_height);
        if (measuredHeight < dimensionPixelSize) {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(dimensionPixelSize, 1073741824));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getAction() == 0 && isEnabled() && isClickable() && isHapticFeedbackEnabled() && this.H) {
            c.hnadsc(this, this.G, 0);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setBlurGrade(int i) {
        if (100 > i || i > 107) {
            this.l = -1;
        } else {
            this.l = i;
        }
    }

    public void setClickAnimationEnabled(boolean z) {
    }

    public void setCustmizeBlurTextColor(boolean z) {
        this.K = z;
    }

    public void setFocusPathColor(int i) {
        this.F = i;
    }

    public void setGradientColors(int[] iArr) {
        this.U = iArr;
    }

    public void setLightColors(int[] iArr) {
        this.T = iArr;
    }

    @Override // com.hihonor.adsdk.common.uikit.hwtextview.widget.HwTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        requestLayout();
        invalidate();
    }

    public void setVibrationEnabled(boolean z) {
        this.H = z;
    }

    @Override // com.hihonor.adsdk.common.uikit.hwtextview.widget.HwTextView
    public void setViewBlurEnable(boolean z) {
        if (!a.hnadsa(getContext())) {
            if (z) {
                this.L = getTextColors().getDefaultColor();
                this.O = getBackground();
                setTextColor(getContext().getResources().getColor(R.color.honor_ads_magic_color_text_primary_blur));
                setBackground(getContext().getResources().getDrawable(R.drawable.honor_ads_hwbutton_default_magic_drawable_translucent));
                com.hihonor.adsdk.common.b.b.hnadsb(e0, "setViewBlurEnable: Device has no blur capability, use standard style", new Object[0]);
                return;
            }
            int i = this.L;
            if (i != -1) {
                setTextColor(i);
            }
            Drawable drawable = this.O;
            if (drawable != null) {
                setBackground(drawable);
            }
        }
        if (this.l == -1) {
            int i2 = getContext().getResources().getConfiguration().uiMode;
            getContext().getResources().getConfiguration();
            if ((i2 & 48) == 32) {
                this.l = 107;
            } else {
                this.l = 103;
            }
        }
        this.J = new a(getContext(), this, this.l);
        if (z) {
            this.L = getTextColors().getDefaultColor();
            com.hihonor.adsdk.common.b.b.hnadsc(e0, "Current blur grade is ：" + this.l, new Object[0]);
            if (!this.K) {
                int i3 = this.l;
                if (i3 == 103 || i3 == 107) {
                    setTextColor(getContext().getResources().getColor(R.color.honor_ads_magic_color_text_primary_blur));
                } else {
                    setTextColor(getContext().getResources().getColor(R.color.honor_ads_magic_color_text_primary));
                }
            }
        } else {
            int i4 = this.L;
            if (i4 != -1) {
                setTextColor(i4);
            }
        }
        this.J.hnadsf(z);
    }

    public void setWaitIconColor(int i) {
        this.z = i;
    }

    public void setWaitTextColor(int i) {
        this.y = i;
    }

    public HwButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.honorAdsHwButtonStyle);
    }

    private void hnadsa(ViewParent viewParent) {
        if (viewParent != null && (viewParent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) viewParent;
            viewGroup.setClipChildren(false);
            viewGroup.setClipToPadding(false);
        }
    }

    private void hnadsh() {
        ViewGroup viewGroup;
        HwProgressBar hwProgressBar = this.m;
        if (hwProgressBar != null) {
            ViewParent parent = hwProgressBar.getParent();
            if ((parent instanceof ViewGroup) && (viewGroup = (ViewGroup) parent) != null) {
                viewGroup.removeView(this.m);
            }
            this.m = null;
        }
    }

    @Override // com.hihonor.adsdk.common.uikit.hwtextview.widget.HwTextView, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.P && !this.Q) {
            getBackground().getOutline(this.b0);
            this.b0.getRect(this.c0);
            float radius = this.b0.getRadius();
            i iVar = this.R;
            if (iVar != null && this.S != null) {
                iVar.hnadsa(radius);
                this.S.hnadsa(radius);
                if (isEnabled()) {
                    this.R.hnadsa(getWidth(), getHeight());
                    this.R.hnadsa(canvas);
                } else {
                    this.S.hnadsa(getWidth(), getHeight());
                    this.S.hnadsa(canvas);
                }
            }
            this.W.right = getWidth();
            this.W.bottom = getHeight();
            this.V.setColor(this.a0.getColorForState(getDrawableState(), 0));
            canvas.drawRoundRect(this.W, radius, radius, this.V);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (getAutoSizeTextType() == 0) {
            this.s = f;
        }
        super.setTextSize(i, f);
    }

    public HwButton(Context context, AttributeSet attributeSet, int i) {
        super(hnadsa(context, i), attributeSet, i);
        this.l = -1;
        this.n = 24;
        this.q = 8;
        this.E = null;
        this.G = 13;
        this.I = new Rect();
        this.K = false;
        this.L = -1;
        hnadsb(super.getContext(), attributeSet, i);
    }

    private void hnadsc() {
        this.a0 = getResources().getColorStateList(R.color.honor_ads_hwbutton_selector_gradient_state_color);
        this.V = new Paint();
        this.W = new RectF();
        this.b0 = new Outline();
        this.c0 = new Rect();
        com.hihonor.adsdk.common.e.f.a.c cVarHnadsc = new com.hihonor.adsdk.common.e.f.a.c().hnadsa(getEffectType()).hnadsa(new RoundRectShape(new float[8], null, null)).hnadsa(this.U).hnadsc(getResources());
        if (this.d0 == 0) {
            cVarHnadsc.hnadsb(this.T);
        }
        com.hihonor.adsdk.common.e.f.a.c cVarHnadsc2 = new com.hihonor.adsdk.common.e.f.a.c().hnadsa(2).hnadsa(new RoundRectShape(new float[8], null, null)).hnadsa(this.U).hnadsc(getResources());
        this.R = cVarHnadsc.hnadsa();
        this.S = cVarHnadsc2.hnadsa();
    }

    public void hnadsa(boolean z, String str) {
        if (!z) {
            if (this.u) {
                this.t = null;
                hnadsh();
                setOriDrawableVisible(true);
                setText(this.r);
                ColorStateList colorStateList = this.E;
                if (colorStateList != null) {
                    setTextColor(colorStateList);
                    this.E = null;
                }
                setPadding(this.w, 0, this.x, 0);
                hnadsa(false, this.o, this.p);
                this.u = false;
                return;
            }
            return;
        }
        this.t = str;
        if (!this.u) {
            this.w = getPaddingStart();
            this.x = getPaddingEnd();
            this.E = getTextColors();
            this.o = getWidth();
            this.p = getHeight();
            this.v = isEnabled();
            this.r = getText().toString();
            setOriDrawableVisible(false);
        }
        if (str != null) {
            if (getLayoutDirection() == 1) {
                setPadding(this.w, 0, this.x + getIconSize() + getWaitingDrawablePadding(), 0);
            } else {
                setPadding(this.w + getIconSize() + getWaitingDrawablePadding(), 0, this.x, 0);
            }
        } else {
            setPadding(this.w, 0, this.x, 0);
        }
        setText(str);
        int i = this.y;
        if (i != 0) {
            setTextColor(i);
        }
        hnadsa(true, this.o, this.p);
        this.u = true;
    }

    public void hnadsc(boolean z) {
        this.P = z;
        if (z) {
            hnadsc();
        }
        invalidate();
    }

    private void hnadsb() {
        if (this.u) {
            if (this.m == null) {
                HwProgressBar hwProgressBarHnadsa = HwProgressBar.hnadsa(getContext());
                this.m = hwProgressBarHnadsa;
                if (hwProgressBarHnadsa == null) {
                    com.hihonor.adsdk.common.b.b.hnadsb(e0, "createProgressbar: HwProgressBar instantiate null!", new Object[0]);
                    return;
                }
            }
            int iconSize = getIconSize();
            this.m.measure(getWidth(), getHeight());
            int iHnadsb = hnadsb(this.t);
            int i = this.w + iHnadsb + this.x;
            getHitRect(this.I);
            int iHeight = this.I.height() / 2;
            int i2 = iconSize / 2;
            int iHnadsa = hnadsa(i, iHnadsb);
            this.m.layout(iHnadsa, iHeight - i2, iconSize + iHnadsa, iHeight + i2);
            ViewParent parent = getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup == null) {
                com.hihonor.adsdk.common.b.b.hnadse(e0, "HwButton::create progressbar fail", new Object[0]);
                return;
            }
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            getLocationOnScreen(iArr);
            viewGroup.getLocationOnScreen(iArr2);
            int i3 = iArr[0] - iArr2[0];
            int iWidth = this.I.width();
            if (getLayoutDirection() == 1) {
                i3 += iWidth;
            }
            int i4 = iArr[1] - iArr2[1];
            this.m.offsetLeftAndRight(i3);
            this.m.offsetTopAndBottom(i4);
            Drawable indeterminateDrawable = this.m.getIndeterminateDrawable();
            if (indeterminateDrawable instanceof HwLoadingDrawableImpl) {
                ((HwLoadingDrawableImpl) indeterminateDrawable).hnadsc(this.z);
            }
            viewGroup.getOverlay().add(this.m);
        }
    }

    protected int hnadsa(int i, int i2) {
        int i3;
        int iconSize;
        int width = getWidth();
        if (getLayoutDirection() != 1) {
            int i4 = this.o;
            return (i > i4 || width > i4) ? this.w : (width / 2) - (i2 / 2);
        }
        int i5 = this.o;
        if (i <= i5 && width <= i5) {
            i3 = 0 - ((width / 2) - (i2 / 2));
            iconSize = getIconSize();
        } else {
            i3 = 0 - this.x;
            iconSize = getIconSize();
        }
        return i3 - iconSize;
    }

    protected void hnadsa(boolean z, int i, int i2) {
        if (z) {
            setEnabled(false);
        } else {
            setEnabled(this.v);
        }
    }

    private int hnadsb(String str) {
        int textSize = 0;
        if (str != null) {
            String string = getText().toString();
            if (Build.VERSION.SDK_INT >= 28 && isAllCaps()) {
                string = string.toUpperCase(Locale.ENGLISH);
            }
            int iMeasureText = (int) getPaint().measureText(string);
            if (getTextSize() != 0.0f && this.s != 0.0f) {
                textSize = (int) ((iMeasureText / getTextSize()) * this.s);
            } else {
                com.hihonor.adsdk.common.b.b.hnadse(e0, "getButtonContentWidth: wrong para!", new Object[0]);
                textSize = iMeasureText;
            }
        }
        if (textSize != 0) {
            return getIconSize() + getWaitingDrawablePadding() + textSize;
        }
        return getIconSize();
    }

    private int hnadsb(Context context) {
        WindowManager windowManager;
        if (context == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 30 && (windowManager = (WindowManager) context.getSystemService("window")) != null) {
                return windowManager.getCurrentWindowMetrics().getBounds().height();
            }
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(e0, "getDisplayHeight error msg = " + e.getMessage(), new Object[0]);
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    protected static int hnadsb(int i) {
        return (int) TypedValue.applyDimension(1, i, Resources.getSystem().getDisplayMetrics());
    }
}
