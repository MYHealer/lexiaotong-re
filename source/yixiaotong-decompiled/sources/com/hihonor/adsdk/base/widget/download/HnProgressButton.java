package com.hihonor.adsdk.base.widget.download;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.uikit.phone.hwprogressbar.widget.HwProgressBar;
import com.hihonor.adsdk.common.uikit.phone.hwtextview.widget.HwTextView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HnProgressButton extends FrameLayout {
    public static final int PROGRESS_MIN = 0;
    public static final int STATE_DONE = 4;
    public static final int STATE_IDLE = 0;
    public static final int STATE_INSTALL = 3;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_RESERVED = 5;
    public static final int STATE_START = 1;
    private static final String TAG = "HnProgressButton";
    private Drawable mDoneBackground;
    private ColorStateList mDoneColor;
    private float mDoneSize;
    private CharSequence mDoneText;
    private Drawable mIdleBackground;
    private ColorStateList mIdleColor;
    private float mIdleSize;
    private CharSequence mIdleText;
    private HwTextView mIndicatingTv;
    private Drawable mInstallBackground;
    private ColorStateList mInstallColor;
    private float mInstallSize;
    private CharSequence mInstallText;
    private Drawable mPauseBackground;
    private ColorStateList mPauseColor;
    private float mPauseSize;
    private CharSequence mPauseText;
    private HwProgressBar mProgressBar;
    private IProgressConvert mProgressConvert;
    private Drawable mReservedBackground;
    private ColorStateList mReservedColor;
    private float mReservedSize;
    private CharSequence mReservedText;
    private Drawable mStartBackground;
    private ColorStateList mStartColor;
    private float mStartSize;
    private int mState;

    @Retention(RetentionPolicy.SOURCE)
    @interface a {
    }

    public HnProgressButton(Context context) {
        this(context, null);
    }

    private void changeParentAttribute() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        com.hihonor.adsdk.common.b.b.hnadsa(TAG, "padding left:%d,top:%d,right:%d,bottom:%d", Integer.valueOf(paddingLeft), Integer.valueOf(paddingTop), Integer.valueOf(paddingRight), Integer.valueOf(paddingBottom));
        setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i2) {
        try {
            Object systemService = getContext().getSystemService("layout_inflater");
            if (systemService instanceof LayoutInflater) {
                ((LayoutInflater) systemService).inflate(i2, (ViewGroup) this, true);
            }
            this.mProgressBar = (HwProgressBar) findViewById(R.id.honor_ads_progressbutton_progress_bar);
            this.mIndicatingTv = (HwTextView) findViewById(R.id.honor_ads_progressbutton_percentage_text_view);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadsb(TAG, "init error msg = " + e.getMessage(), new Object[0]);
        }
        if (this.mProgressBar == null || this.mIndicatingTv == null) {
            com.hihonor.adsdk.common.b.b.hnadsb(TAG, "init: mProgressBar is " + this.mProgressBar + " mPercentage is " + this.mIndicatingTv + " layoutResId: " + i2, new Object[0]);
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.HnProgressButton, i, 0);
        try {
            try {
                this.mIdleBackground = typedArrayObtainStyledAttributes.getDrawable(R.styleable.HnProgressButton_android_background);
                this.mIdleText = getString(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_android_text);
                this.mIdleColor = getColorStateList(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_android_textColor, ColorStateList.valueOf(-16777216));
                int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnProgressButton_android_textSize, sp2px(14.0f));
                this.mIdleSize = dimensionPixelSize;
                int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnProgressButton_android_maxWidth, -1);
                if (dimensionPixelSize2 >= 0) {
                    this.mIndicatingTv.setMaxWidth(dimensionPixelSize2);
                }
                this.mIndicatingTv.setUseAndroidAutoSize(typedArrayObtainStyledAttributes.getBoolean(R.styleable.HnProgressButton_hn_ads_disable_text_auto_size, false));
                this.mStartBackground = typedArrayObtainStyledAttributes.getDrawable(R.styleable.HnProgressButton_hn_ads_start_progress_background);
                this.mStartColor = getColorStateList(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_start_textColor, this.mIdleColor);
                this.mStartSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnProgressButton_hn_ads_start_textSize, dimensionPixelSize);
                this.mPauseBackground = getDrawable(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_pause_progress_background, this.mStartBackground);
                this.mPauseText = getString(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_pause_text);
                this.mPauseColor = getColorStateList(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_pause_textColor, this.mStartColor);
                this.mPauseSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnProgressButton_hn_ads_pause_textSize, dimensionPixelSize);
                this.mInstallBackground = getDrawable(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_install_background, this.mIdleBackground);
                this.mInstallText = getString(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_install_text, R.string.ads_download_button_installing);
                this.mInstallColor = getColorStateList(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_install_textColor, this.mIdleColor);
                this.mInstallSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnProgressButton_hn_ads_install_textSize, dimensionPixelSize);
                this.mReservedBackground = getDrawable(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_reserved_background, this.mIdleBackground);
                this.mReservedText = getString(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_reserved_text, R.string.ads_reserved);
                this.mReservedColor = getColorStateList(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_reserved_textColor, this.mIdleColor);
                this.mReservedSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnProgressButton_hn_ads_reserved_textSize, dimensionPixelSize);
                this.mDoneBackground = getDrawable(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_done_background, this.mIdleBackground);
                this.mDoneText = getString(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_done_text);
                this.mDoneColor = getColorStateList(typedArrayObtainStyledAttributes, R.styleable.HnProgressButton_hn_ads_done_textColor, this.mIdleColor);
                this.mDoneSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HnProgressButton_hn_ads_done_textSize, dimensionPixelSize);
            } catch (Resources.NotFoundException unused) {
                com.hihonor.adsdk.common.b.b.hnadsb(TAG, "Resource not found in initialize.", new Object[0]);
            }
            typedArrayObtainStyledAttributes.recycle();
            changeParentAttribute();
            initData(context, attributeSet, i);
            reset();
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private void setDisplayInfo(Drawable drawable, ColorStateList colorStateList, float f, CharSequence charSequence) {
        setDisplayStyle(drawable, colorStateList, f);
        setIndicatingText(charSequence);
    }

    private void setState(int i) {
        com.hihonor.adsdk.common.b.b.hnadsc(TAG, "setState current state %s, setup state %s", Integer.valueOf(this.mState), Integer.valueOf(i));
        if (i < 0 || i > 5) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "setState: invalid state: " + i, new Object[0]);
            return;
        }
        this.mState = i;
        if (this.mProgressBar == null || this.mIndicatingTv == null) {
            return;
        }
        setEnabled((i == 3 || i == 5) ? false : true);
        this.mProgressBar.setBackground(null);
        this.mProgressBar.setEnabled(isEnabled());
        this.mIndicatingTv.setEnabled(isEnabled());
        if (i == 0) {
            this.mProgressBar.setProgress(0);
            setDisplayInfo(this.mIdleBackground, this.mIdleColor, this.mIdleSize, this.mIdleText);
            return;
        }
        if (i == 1) {
            setDisplayInfo(this.mStartBackground, this.mStartColor, this.mStartSize, "");
            return;
        }
        if (i == 2) {
            setDisplayInfo(this.mPauseBackground, this.mPauseColor, this.mPauseSize, this.mPauseText);
            return;
        }
        if (i == 3) {
            setDisplayInfo(this.mInstallBackground, this.mInstallColor, this.mInstallSize, this.mInstallText);
        } else if (i == 4) {
            setDisplayInfo(this.mDoneBackground, this.mDoneColor, this.mDoneSize, this.mDoneText);
        } else {
            if (i != 5) {
                return;
            }
            setDisplayInfo(this.mReservedBackground, this.mReservedColor, this.mReservedSize, this.mReservedText);
        }
    }

    private static Context wrapContext(Context context, int i) {
        return com.hihonor.adsdk.common.e.e.a.a.hnadsa(context, i, R.style.Honor_Ads_Theme_HnProgressButton);
    }

    public void complete() {
        setState(4);
    }

    protected ColorStateList getColorStateList(TypedArray typedArray, int i, ColorStateList colorStateList) {
        ColorStateList colorStateList2;
        try {
            colorStateList2 = typedArray.getColorStateList(i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "Resource not found in initialize." + e.getMessage(), new Object[0]);
            colorStateList2 = null;
        }
        return colorStateList2 == null ? colorStateList : colorStateList2;
    }

    public Drawable getDoneBackground() {
        return this.mDoneBackground;
    }

    public ColorStateList getDoneColor() {
        return this.mDoneColor;
    }

    public float getDoneSize() {
        return px2sp(this.mDoneSize);
    }

    public CharSequence getDoneText() {
        return this.mDoneText;
    }

    protected Drawable getDrawable(TypedArray typedArray, int i, Drawable drawable) {
        Drawable drawable2;
        try {
            drawable2 = typedArray.getDrawable(i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "Resource not found in initialize." + e.getMessage(), new Object[0]);
            drawable2 = null;
        }
        return drawable2 == null ? drawable : drawable2;
    }

    public Drawable getIdleBackground() {
        return this.mIdleBackground;
    }

    public ColorStateList getIdleColor() {
        return this.mIdleColor;
    }

    public float getIdleSize() {
        return px2sp(this.mIdleSize);
    }

    public CharSequence getIdleText() {
        return this.mIdleText;
    }

    public HwTextView getIndicatingTextView() {
        return this.mIndicatingTv;
    }

    public Drawable getInstallBackground() {
        return this.mInstallBackground;
    }

    public ColorStateList getInstallColor() {
        return this.mInstallColor;
    }

    public float getInstallSize() {
        return px2sp(this.mInstallSize);
    }

    public CharSequence getInstallText() {
        return this.mInstallText;
    }

    protected int getInt(TypedArray typedArray, int i, int i2) {
        try {
            return typedArray.getInt(i, i2);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "Resource not found in initialize." + e.getMessage(), new Object[0]);
            return i2;
        }
    }

    public Drawable getPauseBackground() {
        return this.mPauseBackground;
    }

    public ColorStateList getPauseColor() {
        return this.mPauseColor;
    }

    public float getPauseSize() {
        return px2sp(this.mPauseSize);
    }

    public CharSequence getPauseText() {
        return this.mPauseText;
    }

    public IProgressConvert getProgressConvert() {
        return this.mProgressConvert;
    }

    public Drawable getStartBackground() {
        return this.mStartBackground;
    }

    public ColorStateList getStartColor() {
        return this.mStartColor;
    }

    public float getStartSize() {
        return px2sp(this.mStartSize);
    }

    public int getState() {
        return this.mState;
    }

    protected CharSequence getString(TypedArray typedArray, int i, int i2) {
        String string;
        try {
            string = typedArray.getString(i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "Resource not found in initialize." + e.getMessage(), new Object[0]);
            string = null;
        }
        if (!TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            return getResources().getString(i2);
        } catch (Resources.NotFoundException e2) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "default resource not found in initialize." + e2.getMessage(), new Object[0]);
            return string;
        }
    }

    public CharSequence getText() {
        return getIdleText();
    }

    public ColorStateList getTextColor() {
        return getIdleColor();
    }

    protected void initData(Context context, AttributeSet attributeSet, int i) {
    }

    public void installing() {
        setState(3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        HwProgressBar hwProgressBar = this.mProgressBar;
        if (hwProgressBar != null) {
            hwProgressBar.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
    }

    public void onReserveComplete() {
        setState(5);
    }

    public void pause(int i) {
        setProgress(i);
        setState(2);
        setPercentage(i);
    }

    protected int px2sp(float f) {
        return (int) ((f / resources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void reset(CharSequence charSequence) {
        reset();
        setIndicatingText(charSequence);
    }

    protected Resources resources() {
        Resources resources = super.getResources();
        return resources == null ? Resources.getSystem() : resources;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setIdleBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        setIdleBackground(new ColorDrawable(i));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        setIdleBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        setIdleBackgroundResource(i);
    }

    public void setDoneBackgroundResource(int i) {
        setDoneBackground(getDrawable(i));
    }

    public void setDoneColor(int i) {
        setDoneColor(ColorStateList.valueOf(i));
    }

    public void setDoneSize(float f) {
        this.mDoneSize = sp2px(f);
        updateStageStyle(4);
    }

    public void setDoneText(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsa(TAG, (Object) "setDoneText, doneText is null");
        } else {
            this.mDoneText = charSequence;
            updateStageText(4, charSequence);
        }
    }

    public void setIdleBackgroundResource(int i) {
        setIdleBackground(getDrawable(i));
    }

    public void setIdleColor(int i) {
        setIdleColor(ColorStateList.valueOf(i));
    }

    public void setIdleSize(float f) {
        this.mIdleSize = sp2px(f);
        updateStageStyle(0);
    }

    public void setIdleText(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsa(TAG, (Object) "setIdleText, idleText is null");
        } else {
            this.mIdleText = charSequence;
            updateStageText(0, charSequence);
        }
    }

    public void setInstallBackgroundResource(int i) {
        setInstallBackground(getDrawable(i));
    }

    public void setInstallColor(int i) {
        setInstallColor(ColorStateList.valueOf(i));
    }

    public void setInstallSize(float f) {
        this.mInstallSize = sp2px(f);
        updateStageStyle(3);
    }

    public void setInstallText(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsa(TAG, (Object) "setInstallText, installText is null");
        } else {
            this.mInstallText = charSequence;
            updateStageText(3, charSequence);
        }
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(0, 0, 0, 0);
        HwTextView hwTextView = this.mIndicatingTv;
        if (hwTextView != null) {
            hwTextView.setPadding(i, i2, i3, i4);
        }
    }

    public void setPauseBackgroundResource(int i) {
        setPauseBackground(getDrawable(i));
    }

    public void setPauseColor(int i) {
        setPauseColor(ColorStateList.valueOf(i));
    }

    public void setPauseSize(float f) {
        this.mPauseSize = sp2px(f);
        updateStageStyle(2);
    }

    public void setPauseText(CharSequence charSequence) {
        if (charSequence == null) {
            com.hihonor.adsdk.common.b.b.hnadsa(TAG, (Object) "setPauseText, pauseText is null");
        } else {
            this.mPauseText = charSequence;
            updateStageText(2, charSequence);
        }
    }

    public void setProgressConvert(IProgressConvert iProgressConvert) {
        this.mProgressConvert = iProgressConvert;
    }

    public void setStartBackgroundResource(int i) {
        setStartBackground(getDrawable(i));
    }

    public void setStartColor(int i) {
        setStartColor(ColorStateList.valueOf(i));
    }

    public void setStartSize(float f) {
        this.mStartSize = sp2px(f);
        updateStageStyle(1);
    }

    public void setText(CharSequence charSequence) {
        setIdleText(charSequence);
    }

    public void setTextColor(int i) {
        setIdleColor(i);
    }

    public void setTextSize(float f) {
        setIdleSize(f);
        setStartSize(f);
        setPauseSize(f);
        setInstallSize(f);
        setDoneSize(f);
    }

    protected int sp2px(float f) {
        return (int) ((f * resources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void start() {
        setState(1);
        setPercentage(this.mProgressBar.getProgress());
    }

    public void waiting(CharSequence charSequence, int i) {
        setProgress(i);
        setState(2);
        setIndicatingText(charSequence);
    }

    public HnProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.honorAdsHnProgressButtonStyle);
    }

    private CharSequence getPercentageText(int i) {
        IProgressConvert iProgressConvert = this.mProgressConvert;
        return iProgressConvert == null ? String.format(Locale.ROOT, "%2d", Integer.valueOf(i)) + "%" : iProgressConvert.convert(i);
    }

    private void setPercentage(int i) {
        if (this.mIndicatingTv == null) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "setPercentage, mPercentage is null", new Object[0]);
        } else if (this.mState == 2) {
            setIndicatingText(this.mPauseText);
        } else {
            setIndicatingText(getPercentageText(i));
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        HwTextView hwTextView = this.mIndicatingTv;
        if (hwTextView != null) {
            setContentDescription(hwTextView.getText());
        }
        return Button.class.getName();
    }

    public int getMaxWidth() {
        HwTextView hwTextView = this.mIndicatingTv;
        if (hwTextView != null) {
            return hwTextView.getMaxWidth();
        }
        return -1;
    }

    public void incrementProgressBy(int i) {
        if (this.mProgressBar == null) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "incrementProgressBy, mProgressBar is null", new Object[0]);
            return;
        }
        if (this.mState != 1) {
            setState(1);
        }
        this.mProgressBar.incrementProgressBy(i);
        setPercentage(this.mProgressBar.getProgress());
    }

    public void setDoneBackground(Drawable drawable) {
        this.mDoneBackground = drawable;
        updateStageStyle(4);
    }

    public void setIdleBackground(Drawable drawable) {
        this.mIdleBackground = drawable;
        updateStageStyle(0);
    }

    public void setIndicatingText(CharSequence charSequence) {
        HwTextView hwTextView = this.mIndicatingTv;
        if (hwTextView == null) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "setIndicatingText, text is null", new Object[0]);
        } else {
            hwTextView.setText(charSequence);
        }
    }

    public void setInstallBackground(Drawable drawable) {
        this.mInstallBackground = drawable;
        updateStageStyle(3);
    }

    public void setMaxWidth(int i) {
        if (i < 0) {
            i = Integer.MAX_VALUE;
        }
        HwTextView hwTextView = this.mIndicatingTv;
        if (hwTextView != null) {
            hwTextView.setMaxWidth(i);
        }
    }

    public void setPauseBackground(Drawable drawable) {
        this.mPauseBackground = drawable;
        updateStageStyle(2);
    }

    public void setProgress(int i) {
        HwProgressBar hwProgressBar = this.mProgressBar;
        if (hwProgressBar == null) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "incrementProgressBy, mProgressBar is null", new Object[0]);
        } else {
            hwProgressBar.setProgress(i);
        }
    }

    public void setStartBackground(Drawable drawable) {
        this.mStartBackground = drawable;
        updateStageStyle(1);
    }

    public void setTextColor(ColorStateList colorStateList) {
        setIdleColor(colorStateList);
    }

    public void updateProgressBy(int i) {
        if (this.mProgressBar == null) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "incrementProgressBy, mProgressBar is null", new Object[0]);
            return;
        }
        if (this.mState != 1) {
            setState(1);
        }
        this.mProgressBar.setProgress(i);
        setPercentage(i);
    }

    public HnProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(wrapContext(context, i), attributeSet, i);
        this.mProgressBar = null;
        this.mIndicatingTv = null;
        this.mState = -1;
        this.mProgressConvert = null;
        init(super.getContext(), attributeSet, i, R.layout.honor_ads_progress_button_layout);
    }

    public void reset() {
        setState(0);
    }

    public void setDoneColor(ColorStateList colorStateList) {
        this.mDoneColor = colorStateList;
        updateStageStyle(4);
    }

    public void setIdleColor(ColorStateList colorStateList) {
        this.mIdleColor = colorStateList;
        updateStageStyle(0);
    }

    public void setInstallColor(ColorStateList colorStateList) {
        this.mInstallColor = colorStateList;
        updateStageStyle(3);
    }

    public void setPauseColor(ColorStateList colorStateList) {
        this.mPauseColor = colorStateList;
        updateStageStyle(2);
    }

    public void setStartColor(ColorStateList colorStateList) {
        this.mStartColor = colorStateList;
        updateStageStyle(1);
    }

    private void setDisplayStyle(Drawable drawable, ColorStateList colorStateList, float f) {
        HwProgressBar hwProgressBar = this.mProgressBar;
        if (hwProgressBar == null || this.mIndicatingTv == null) {
            return;
        }
        hwProgressBar.setProgressDrawable(drawable != null ? drawable.mutate() : null);
        if (colorStateList != null) {
            this.mIndicatingTv.setTextColor(colorStateList);
        }
        this.mIndicatingTv.hnadsa(0, f);
    }

    protected Drawable getDrawable(int i) {
        if (i != 0) {
            return AppCompatResources.getDrawable(getContext(), i);
        }
        return null;
    }

    public int getProgress() {
        HwProgressBar hwProgressBar = this.mProgressBar;
        if (hwProgressBar == null) {
            return 0;
        }
        return hwProgressBar.getProgress();
    }

    protected void updateStageText(int i, CharSequence charSequence) {
        if (i != this.mState) {
            return;
        }
        setIndicatingText(charSequence);
    }

    protected CharSequence getString(TypedArray typedArray, int i) {
        String string;
        try {
            string = typedArray.getString(i);
        } catch (Exception e) {
            com.hihonor.adsdk.common.b.b.hnadse(TAG, "Resource not found in initialize." + e.getMessage(), new Object[0]);
            string = null;
        }
        return TextUtils.isEmpty(string) ? "" : string;
    }

    protected void updateStageStyle(int i) {
        int i2 = this.mState;
        if (i != i2 || i2 < 0) {
            return;
        }
        if (i == 0) {
            setDisplayStyle(this.mIdleBackground, this.mIdleColor, this.mIdleSize);
            return;
        }
        if (i == 1) {
            setDisplayStyle(this.mStartBackground, this.mStartColor, this.mStartSize);
            return;
        }
        if (i == 2) {
            setDisplayStyle(this.mPauseBackground, this.mPauseColor, this.mPauseSize);
            return;
        }
        if (i == 3) {
            setDisplayStyle(this.mInstallBackground, this.mInstallColor, this.mInstallSize);
        } else if (i == 4) {
            setDisplayStyle(this.mDoneBackground, this.mDoneColor, this.mDoneSize);
        } else {
            if (i != 5) {
                return;
            }
            setDisplayStyle(this.mReservedBackground, this.mReservedColor, this.mReservedSize);
        }
    }
}
