package com.hihonor.adsdk.common.uikit.hwtextview.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.b.b;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
@RemoteViews.RemoteView
public class HwTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f3520a = 1;
    private static final int b = 0;
    private static final String c = "HwTextView";
    private static final int d = 400;
    private static final String e = "hniconfont.ttf";
    private static final String f = "system/fonts/";
    private static final int g = 16;
    private static final int h = 3000;
    private static final int hnadsy = 15;
    private static final int hnadsz = -1;
    private static final int i = 2;
    private static final int j = 2;
    private static final int k = 5;
    private int hnadsd;
    private int hnadse;
    private boolean hnadsf;
    private StaticLayout hnadsg;
    private com.hihonor.adsdk.common.uikit.hwtextview.widget.a hnadsh;
    private TextPaint hnadsi;
    private int hnadsj;
    private com.hihonor.adsdk.common.e.a.a.a hnadsk;
    private LinearGradient hnadsl;
    private Matrix hnadsm;
    private boolean hnadsn;
    protected boolean hnadso;
    protected float hnadsp;
    protected float hnadsq;
    protected float hnadsr;
    private boolean hnadss;
    private boolean hnadst;
    private float hnadsu;
    private int[] hnadsv;
    private long hnadsw;
    private final Runnable hnadsx;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            HwTextView.this.hnadsw = System.currentTimeMillis();
            HwTextView.this.postInvalidate();
        }
    }

    public HwTextView(Context context) {
        this(context, null);
    }

    private float getFontHeight() {
        TextPaint paint = getPaint();
        if (paint == null) {
            return 0.0f;
        }
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return fontMetrics.bottom - fontMetrics.top;
    }

    private float getMeasuredTextWidth() {
        TextPaint paint = getPaint();
        Layout layout = getLayout();
        if (paint == null || layout == null) {
            return 0.0f;
        }
        return layout.getEllipsisCount(0) > 0 ? getMeasuredWidth() : paint.measureText(getText().toString());
    }

    public com.hihonor.adsdk.common.uikit.hwtextview.widget.a getTextCopyFinishedListener() {
        return this.hnadsh;
    }

    public void hnadsa(com.hihonor.adsdk.common.uikit.hwtextview.widget.a aVar) {
        this.hnadsh = aVar;
    }

    public void hnadsc(int i2, int i3, int i4) {
        Context context = getContext();
        Resources system = context == null ? Resources.getSystem() : context.getResources();
        this.hnadsq = TypedValue.applyDimension(i4, i2, system.getDisplayMetrics());
        this.hnadsr = TypedValue.applyDimension(i4, i3, system.getDisplayMetrics());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.hnadst = false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        float measuredTextWidth = getMeasuredTextWidth();
        float f2 = (measuredTextWidth * 2.0f) / 5.0f;
        float f3 = measuredTextWidth + f2;
        if (this.hnadss) {
            this.hnadsm.setTranslate((((-measuredTextWidth) / 2.0f) - (f2 / 2.0f)) + this.hnadsu, 0.0f);
            LinearGradient linearGradient = this.hnadsl;
            if (linearGradient != null) {
                linearGradient.setLocalMatrix(this.hnadsm);
            }
        }
        super.onDraw(canvas);
        if (this.hnadss && this.hnadst) {
            float fCeil = (float) (((double) this.hnadsu) + Math.ceil(f3 / 187));
            this.hnadsu = fCeil;
            if (fCeil > f3) {
                this.hnadsu = 0.0f;
                hnadsb(false);
            } else {
                long jCurrentTimeMillis = System.currentTimeMillis() - this.hnadsw;
                postDelayed(this.hnadsx, jCurrentTimeMillis < 16 ? (int) (16 - jCurrentTimeMillis) : 0);
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (this.hnadss) {
            hnadsa();
        }
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i2) {
        com.hihonor.adsdk.common.uikit.hwtextview.widget.a aVar;
        boolean zOnTextContextMenuItem = super.onTextContextMenuItem(i2);
        if (i2 == 16908321 && (aVar = this.hnadsh) != null) {
            aVar.hnadsa();
        }
        b.hnadsc(c, "onTextContextMenuItem default", new Object[0]);
        return zOnTextContextMenuItem;
    }

    public void setAutoTextSize(float f2) {
        hnadsa(2, f2);
    }

    public void setHighLightColor(int i2) {
        this.hnadsj = i2;
    }

    public void setIsEnableColorfulGradient(boolean z) {
        this.hnadss = z;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.hnadsq <= 0.0f || this.hnadsr <= 0.0f) {
            return;
        }
        requestLayout();
    }

    public void setViewBlurEnable(boolean z) {
        if (com.hihonor.adsdk.common.e.a.a.a.hnadsa(getContext())) {
            int i2 = getContext().getResources().getConfiguration().uiMode;
            getContext().getResources().getConfiguration();
            if ((i2 & 48) == 32) {
                this.hnadsd = 305;
            } else {
                this.hnadsd = 304;
            }
            if (this.hnadsk == null) {
                this.hnadsk = new com.hihonor.adsdk.common.e.a.a.a(getContext(), this, this.hnadsd);
            }
            if (z) {
                this.hnadse = getCurrentTextColor();
                setTextColor(R.color.honor_ads_textview_blur_color);
            } else {
                int i3 = this.hnadse;
                if (i3 != 0) {
                    setTextColor(i3);
                }
            }
            this.hnadsk.hnadsf(z);
        }
    }

    public HwTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.honorAdsHwTextViewStyle);
    }

    public static HwTextView hnadsa(Context context) {
        Object objHnadsa = com.hihonor.adsdk.common.e.e.a.b.hnadsa(context, com.hihonor.adsdk.common.e.e.a.b.hnadsa(context, (Class<?>) HwTextView.class, com.hihonor.adsdk.common.e.e.a.b.hnadsa(context, 15, 1)), (Class<?>) HwTextView.class);
        if (objHnadsa instanceof HwTextView) {
            return (HwTextView) objHnadsa;
        }
        return null;
    }

    public void hnadsb(boolean z) {
        if (!this.hnadss) {
            b.hnadsc(c, "startColorfulGradient,the colorful gradient is disabled.", new Object[0]);
            return;
        }
        if (z && this.hnadst) {
            b.hnadsc(c, "startColorfulGradient,the colorful gradient already started.", new Object[0]);
            return;
        }
        this.hnadsu = 0.0f;
        this.hnadst = z;
        hnadsa();
        invalidate();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i2, int i3) {
        if (!this.hnadso) {
            hnadsa(View.MeasureSpec.getSize(i2), View.MeasureSpec.getSize(i3), View.MeasureSpec.getMode(i3));
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i2) {
        super.setTextAppearance(i2);
    }

    public HwTextView(Context context, AttributeSet attributeSet, int i2) {
        super(hnadsa(context, i2), attributeSet, i2);
        this.hnadsn = true;
        this.hnadss = false;
        this.hnadsx = new a();
        hnadsa(super.getContext(), attributeSet, i2);
    }

    public void setUseAndroidAutoSize(boolean z) {
        if (this.hnadso == z) {
            return;
        }
        this.hnadso = z;
        if (!z) {
            setAutoSizeTextTypeWithDefaults(0);
        }
        if (this.hnadsq <= 0.0f || this.hnadsr <= 0.0f) {
            return;
        }
        requestLayout();
    }

    public void hnadsa(int i2, float f2) {
        Resources resources;
        Context context = getContext();
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        this.hnadsp = TypedValue.applyDimension(i2, f2, resources.getDisplayMetrics());
        super.setTextSize(i2, f2);
    }

    private void hnadsb(int i2, int i3, int i4) {
        int maxLines;
        if (i4 != 0 && (maxLines = getMaxLines()) > 1) {
            int totalPaddingLeft = (i3 - getTotalPaddingLeft()) - getTotalPaddingRight();
            int extendedPaddingBottom = (i2 - getExtendedPaddingBottom()) - getExtendedPaddingTop();
            if (extendedPaddingBottom <= 0) {
                return;
            }
            StaticLayout staticLayout = new StaticLayout(getText(), this.hnadsi, totalPaddingLeft, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
            this.hnadsg = staticLayout;
            int lineCount = staticLayout.getLineCount();
            if (this.hnadsg.getHeight() <= extendedPaddingBottom || lineCount <= 1 || lineCount > maxLines + 1) {
                return;
            }
            setMaxLines(lineCount - 1);
        }
    }

    public void hnadsa(boolean z) {
        this.hnadsn = z;
        requestLayout();
    }

    public float hnadsa(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence.toString());
    }

    private void hnadsa() {
        float measuredTextWidth = getMeasuredTextWidth();
        float fontHeight = getFontHeight();
        if (measuredTextWidth <= 0.0f || fontHeight <= 0.0f) {
            return;
        }
        this.hnadsl = new LinearGradient(0.0f, 0.0f, measuredTextWidth, fontHeight, this.hnadsv, (float[]) null, Shader.TileMode.CLAMP);
        getPaint().setShader(this.hnadsl);
    }

    private static Context hnadsa(Context context, int i2) {
        return com.hihonor.adsdk.common.e.e.a.a.hnadsa(context, i2, R.style.Honor_Ads_Theme_Magic_HwTextView, true);
    }

    private void hnadsa(Context context, AttributeSet attributeSet, int i2) {
        this.hnadsm = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHwTextView, i2, R.style.Honor_Ads_Widget_Magic_HwTextView);
        this.hnadso = typedArrayObtainStyledAttributes.getBoolean(R.styleable.HonorAdsHwTextView_honorAdsUseAndroidAutoSize, false);
        this.hnadsq = typedArrayObtainStyledAttributes.getDimension(R.styleable.HonorAdsHwTextView_honorAdsHwAutoSizeMinTextSize, 0.0f);
        this.hnadsr = typedArrayObtainStyledAttributes.getDimension(R.styleable.HonorAdsHwTextView_honorAdsHwAutoSizeStepGranularity, 0.0f);
        int[] iArr = {R.color.honor_ads_searchview_gradient_text_color_three, R.color.honor_ads_searchview_gradient_text_color_second, R.color.honor_ads_searchview_gradient_text_color_first, R.color.honor_ads_searchview_gradient_text_color_second, R.color.honor_ads_searchview_gradient_text_color_three};
        this.hnadsv = new int[5];
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.hnadsv;
            if (i3 >= iArr2.length) {
                break;
            }
            iArr2[i3] = getResources().getColor(iArr[i3]);
            i3++;
        }
        this.hnadsf = typedArrayObtainStyledAttributes.getInt(R.styleable.HonorAdsHwTextView_honorAdsHwAutoSizeTextType, 0) == 1;
        typedArrayObtainStyledAttributes.recycle();
        if (this.hnadsq == 0.0f && this.hnadsr == 0.0f) {
            this.hnadsq = getAutoSizeMinTextSize();
            this.hnadsr = getAutoSizeStepGranularity();
        }
        if (!this.hnadso) {
            setAutoSizeTextTypeWithDefaults(0);
        }
        TextPaint textPaint = new TextPaint();
        this.hnadsi = textPaint;
        textPaint.set(getPaint());
        this.hnadsp = getTextSize();
        this.hnadsj = getResources().getColor(R.color.honor_ads_magic_accent);
    }

    private void hnadsa(int i2, int i3, int i4) {
        int maxWidth = getMaxWidth();
        int maxHeight = getMaxHeight();
        if (maxWidth != -1 && maxWidth < i2) {
            i2 = maxWidth;
        }
        if (maxHeight != -1 && maxHeight < i3) {
            i3 = maxHeight;
        }
        int totalPaddingLeft = (i2 - getTotalPaddingLeft()) - getTotalPaddingRight();
        if (totalPaddingLeft < 0) {
            return;
        }
        if (this.hnadsi == null) {
            this.hnadsi = new TextPaint();
        }
        this.hnadsi.set(getPaint());
        hnadsa(i2, i3, totalPaddingLeft, i4);
    }

    private void hnadsa(int i2, int i3, int i4, int i5) {
        if (!(this.hnadsf && getMaxLines() == Integer.MAX_VALUE) && this.hnadsq > 0.0f && this.hnadsr > 0.0f) {
            float f2 = this.hnadsp;
            CharSequence text = getText();
            TransformationMethod transformationMethod = getTransformationMethod();
            if (transformationMethod != null) {
                text = transformationMethod.getTransformation(text, this);
            }
            this.hnadsi.setTextSize(f2);
            float fHnadsa = hnadsa(this.hnadsi, text);
            while (hnadsa(fHnadsa, i4, f2)) {
                f2 -= this.hnadsr;
                this.hnadsi.setTextSize(f2);
                fHnadsa = hnadsa(this.hnadsi, text);
            }
            float f3 = this.hnadsq;
            if (f2 < f3) {
                f2 = f3;
            }
            setTextSize(0, f2);
            if (this.hnadsn) {
                hnadsb(i3, i2, i5);
            }
        }
    }

    private boolean hnadsa(float f2, int i2, float f3) {
        if (!this.hnadsf || getMaxLines() == 1) {
            return f2 > ((float) i2) && f3 > this.hnadsq;
        }
        return hnadsa(i2) > getMaxLines() && f3 > this.hnadsq;
    }

    private int hnadsa(int i2) {
        CharSequence text = getText();
        if (text == null) {
            return 0;
        }
        return StaticLayout.Builder.obtain(text, 0, text.length(), this.hnadsi, i2).build().getLineCount();
    }

    public void hnadsa(String str) {
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            setText(getText().toString());
        } else {
            setText(hnadsa(getText().toString(), str, this.hnadsj));
        }
    }

    public void hnadsa(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            setText(getText().toString());
        } else {
            setText(hnadsa(str.toLowerCase(), str2.toLowerCase(), this.hnadsj));
        }
    }

    private SpannableString hnadsa(String str, String str2, int i2) {
        SpannableString spannableString = new SpannableString(getText().toString());
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int iIndexOf = str.indexOf(str2);
            int length = str2.length();
            while (iIndexOf >= 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(i2);
                int length2 = iIndexOf + length;
                if (length2 > str.length()) {
                    length2 = str.length();
                }
                try {
                    spannableString.setSpan(foregroundColorSpan, iIndexOf, length2, 33);
                    iIndexOf = str.indexOf(str2, length2);
                } catch (IndexOutOfBoundsException unused) {
                    b.hnadsb(c, "getHighLightText IndexOutOfBoundsException", new Object[0]);
                }
            }
        }
        return spannableString;
    }
}
