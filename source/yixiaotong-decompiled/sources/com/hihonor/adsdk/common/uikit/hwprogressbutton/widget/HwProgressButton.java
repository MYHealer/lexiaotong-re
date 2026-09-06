package com.hihonor.adsdk.common.uikit.hwprogressbutton.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.hihonor.adsdk.base.R;
import com.hihonor.adsdk.common.b.b;
import com.hihonor.adsdk.common.uikit.hwprogressbar.widget.HwProgressBar;
import com.hihonor.adsdk.common.uikit.hwtextview.widget.HwTextView;
import java.util.Locale;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\3873424.dex */
public class HwProgressButton extends FrameLayout {
    public static final int STATE_IDLE = 0;
    public static final int STATE_PAUSE = 2;
    public static final int STATE_START = 1;
    private static final String TAG = "HwProgressButton";
    private float hnHoverCornerRadius;
    private int hnhoverColor;
    private boolean mIsHighLight;
    private LayerDrawable mLayerDrawable;
    private String mPauseText;
    private HwTextView mPercentage;
    private ColorStateList mPercentageDynamicTextColorIds;
    private ColorStateList mPercentageStaticTextColors;
    private HwProgressBar mProgressBar;
    private int mProgressDrawableId;
    private Drawable mProgressStyleBackground;
    private String mProgressType;
    private int mState;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        int hnadsd;
        int hnadse;

        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: hnadsa, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (parcel == null) {
                b.hnadse(HwProgressButton.TAG, "writeToParcel, parcel is null", new Object[0]);
                return;
            }
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.hnadsd);
            parcel.writeInt(this.hnadse);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.hnadsd = parcel.readInt();
            this.hnadse = parcel.readInt();
        }
    }

    static /* synthetic */ class a {
    }

    public HwProgressButton(Context context) {
        this(context, null);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        try {
            Object systemService = getContext().getSystemService("layout_inflater");
            if (systemService instanceof LayoutInflater) {
                ((LayoutInflater) systemService).inflate(i, (ViewGroup) this, true);
            }
            this.mProgressBar = (HwProgressBar) findViewById(R.id.honor_ads_hwprogressbutton_progress_bar);
            this.mPercentage = (HwTextView) findViewById(R.id.honor_ads_hwprogressbutton_percentage_text_view);
            this.mProgressDrawableId = R.drawable.honor_ads_hwprogressbutton_widget_progress_layer;
            if (this.mProgressBar == null || this.mPercentage == null) {
                b.hnadsb(TAG, "init: mProgressBar is " + this.mProgressBar + " mPercentage is " + this.mPercentage + " layoutResId: " + i, new Object[0]);
                return;
            }
            Drawable drawable = ContextCompat.getDrawable(context, R.drawable.honor_ads_hwprogressbutton_selector_btn_normal_bg_tint);
            Drawable drawableMutate = DrawableCompat.wrap(ContextCompat.getDrawable(context, R.drawable.honor_ads_hwprogressbutton_selector_btn_disable_bg_tint)).mutate();
            DrawableCompat.setTint(drawableMutate, ContextCompat.getColor(context, R.color.honor_ads_hwprogressbutton_color));
            this.mLayerDrawable = new LayerDrawable(new Drawable[]{drawableMutate, drawable});
            this.mPauseText = "";
            Resources.Theme theme = context.getTheme();
            if (theme == null || (typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, R.styleable.HonorAdsHwProgressButton, R.attr.honorAdsHwProgressButtonStyle, R.style.Honor_Ads_Widget_Magic_HwProgressButton_Normal_Light)) == null) {
                return;
            }
            this.hnhoverColor = typedArrayObtainStyledAttributes.getColor(R.styleable.HonorAdsHwProgressButton_honorAdsHnhoverColor, 0);
            this.hnHoverCornerRadius = typedArrayObtainStyledAttributes.getDimension(R.styleable.HonorAdsHwProgressButton_honorAdsHnhoverConerRadius, 8.0f);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(R.styleable.HonorAdsHwProgressButton_honorAdsHwProgressButtonBackground);
            this.mProgressStyleBackground = drawable2;
            this.mProgressBar.setProgressDrawable(drawable2);
            boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.HonorAdsHwProgressButton_honorAdsHwProgressButtonIsHighlight, true);
            this.mIsHighLight = z;
            if (z) {
                this.mProgressBar.setProgressDrawable(this.mLayerDrawable);
            }
            this.mPercentageStaticTextColors = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.HonorAdsHwProgressButton_honorAdsHwProgressButtonStaticTextColor);
            this.mPercentageDynamicTextColorIds = typedArrayObtainStyledAttributes.getColorStateList(R.styleable.HonorAdsHwProgressButton_honorAdsHwProgressButtonDynamicTextColor);
            setPercentageTextColor(this.mPercentageStaticTextColors);
            typedArrayObtainStyledAttributes.recycle();
        } catch (Exception e) {
            b.hnadsb(TAG, "init error msg = " + e.getMessage(), new Object[0]);
        }
    }

    private static Context wrapContext(Context context, int i) {
        return com.hihonor.adsdk.common.e.e.a.a.hnadsa(context, i, R.style.Honor_Ads_Theme_Magic_HwProgressButton);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (getState() == 1) {
            setContentDescription(this.mProgressType + String.format(Locale.ROOT, "%2d", Integer.valueOf(getProgress())) + "%");
            return View.class.getName();
        }
        if (getState() == 2) {
            setContentDescription(this.mPauseText);
        } else {
            HwTextView hwTextView = this.mPercentage;
            if (hwTextView != null) {
                setContentDescription(hwTextView.getText());
            }
        }
        return Button.class.getName();
    }

    public HwTextView getPercentage() {
        return this.mPercentage;
    }

    public int getProgress() {
        return this.mProgressBar.getProgress();
    }

    protected Drawable getProgressButtonDrawable(int i) {
        return ContextCompat.getDrawable(getContext(), i);
    }

    public int getState() {
        return this.mState;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        HwProgressBar hwProgressBar = this.mProgressBar;
        if (hwProgressBar != null) {
            hwProgressBar.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        HwProgressBar hwProgressBar;
        if (!(parcelable instanceof SavedState)) {
            b.hnadse(TAG, "onRestoreInstanceState, state = " + parcelable, new Object[0]);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setState(savedState.hnadse);
        if (this.mState == 0 || (hwProgressBar = this.mProgressBar) == null) {
            b.hnadse(TAG, "onRestoreInstanceState mState = " + this.mState + " , mProgressBar = " + this.mProgressBar, new Object[0]);
            return;
        }
        hwProgressBar.setProgressDrawable(getProgressButtonDrawable(R.drawable.honor_ads_hwprogressbutton_widget_progress_layer));
        setProgress(savedState.hnadsd);
        setPercentage(savedState.hnadsd);
        setPercentageTextColor(this.mPercentageDynamicTextColorIds);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.hnadsd = this.mProgressBar.getProgress();
        savedState.hnadse = this.mState;
        return savedState;
    }

    public void resetUpdate() {
        this.mProgressBar.setBackground(null);
        if (this.mIsHighLight) {
            this.mProgressBar.setProgressDrawable(this.mLayerDrawable);
        } else {
            this.mProgressBar.setProgressDrawable(this.mProgressStyleBackground);
        }
        setPercentageTextColor(this.mPercentageStaticTextColors);
        setState(0);
    }

    public void setIdleText(String str) {
        if (str == null) {
            b.hnadse(TAG, "setIdleText, idleText is null", new Object[0]);
        } else if (this.mState != 0) {
            b.hnadse(TAG, "setIdleText, mState = " + this.mState, new Object[0]);
        } else {
            this.mPercentage.setText(str);
        }
    }

    public void setPauseText(String str) {
        if (str == null) {
            b.hnadse(TAG, "setPauseText, pauseText is null", new Object[0]);
        } else {
            this.mPauseText = str;
        }
    }

    public void setProgress(int i) {
        this.mProgressBar.setProgress(i);
    }

    public void stop() {
        setState(2);
        setPercentage(this.mProgressBar.getProgress());
    }

    public HwProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.honorAdsHwProgressButtonStyle);
    }

    private void setPercentage(int i) {
        HwTextView hwTextView = this.mPercentage;
        if (hwTextView == null) {
            b.hnadse(TAG, "setPercentage, mPercentage is null", new Object[0]);
        } else if (this.mState == 2) {
            hwTextView.setText(this.mPauseText);
        } else {
            hwTextView.setText(String.format(Locale.ROOT, "%2d", Integer.valueOf(i)) + "%");
        }
    }

    private void setPercentageTextColor(ColorStateList colorStateList) {
        HwTextView hwTextView = this.mPercentage;
        if (hwTextView == null || colorStateList == null) {
            return;
        }
        hwTextView.setTextColor(colorStateList);
    }

    public void incrementProgressBy(int i) {
        if (this.mProgressBar == null) {
            b.hnadse(TAG, "incrementProgressBy, mProgressBar is null", new Object[0]);
            return;
        }
        if (this.mState != 1) {
            setState(1);
            this.mProgressBar.setBackground(null);
            this.mProgressBar.setProgressDrawable(getProgressButtonDrawable(this.mProgressDrawableId));
            setPercentageTextColor(this.mPercentageDynamicTextColorIds);
        }
        this.mProgressBar.incrementProgressBy(i);
        setPercentage(this.mProgressBar.getProgress());
    }

    public HwProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(wrapContext(context, i), attributeSet, i);
        this.mProgressBar = null;
        this.mPercentage = null;
        this.mState = 0;
        this.mIsHighLight = true;
        this.mProgressType = "";
        init(super.getContext(), attributeSet, R.layout.honor_ads_hnprogressbutton_layout);
        com.hihonor.adsdk.common.e.d.c.a.hnadsa(this, this.hnHoverCornerRadius, this.hnhoverColor);
    }

    protected void setState(int i) {
        if (this.mState == i) {
            return;
        }
        if (i < 0 || i > 2) {
            b.hnadse(TAG, "setState: invalid state: " + i, new Object[0]);
        } else {
            this.mState = i;
        }
    }
}
