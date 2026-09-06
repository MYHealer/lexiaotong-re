package com.afollestad.materialdialogs.color;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.afollestad.materialdialogs.commons.R;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;
import com.google.android.material.timepicker.TimeModel;
import com.huawei.openalliance.ad.constant.x;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ColorChooserDialog extends DialogFragment implements View.OnClickListener, View.OnLongClickListener {
    public static final String TAG_ACCENT = "[MD_COLOR_CHOOSER]";
    public static final String TAG_CUSTOM = "[MD_COLOR_CHOOSER]";
    public static final String TAG_PRIMARY = "[MD_COLOR_CHOOSER]";
    private ColorCallback mCallback;
    private int mCircleSize;
    private View mColorChooserCustomFrame;
    private int[][] mColorsSub;
    private int[] mColorsTop;
    private EditText mCustomColorHex;
    private View mCustomColorIndicator;
    private SeekBar.OnSeekBarChangeListener mCustomColorRgbListener;
    private TextWatcher mCustomColorTextWatcher;
    private SeekBar mCustomSeekA;
    private TextView mCustomSeekAValue;
    private SeekBar mCustomSeekB;
    private TextView mCustomSeekBValue;
    private SeekBar mCustomSeekG;
    private TextView mCustomSeekGValue;
    private SeekBar mCustomSeekR;
    private TextView mCustomSeekRValue;
    private GridView mGrid;
    private int mSelectedCustomColor;

    public interface ColorCallback {
        void onColorSelection(ColorChooserDialog colorChooserDialog, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorChooserTag {
    }

    private void generateColors() {
        Builder builder = getBuilder();
        if (builder.mColorsTop != null) {
            this.mColorsTop = builder.mColorsTop;
            this.mColorsSub = builder.mColorsSub;
        } else if (builder.mAccentMode) {
            this.mColorsTop = ColorPalette.ACCENT_COLORS;
            this.mColorsSub = ColorPalette.ACCENT_COLORS_SUB;
        } else {
            this.mColorsTop = ColorPalette.PRIMARY_COLORS;
            this.mColorsSub = ColorPalette.PRIMARY_COLORS_SUB;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("top_index", topIndex());
        bundle.putBoolean("in_sub", isInSub());
        bundle.putInt("sub_index", subIndex());
        View view = this.mColorChooserCustomFrame;
        bundle.putBoolean("in_custom", view != null && view.getVisibility() == 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof ColorCallback)) {
            throw new IllegalStateException("ColorChooserDialog needs to be shown from an Activity implementing ColorCallback.");
        }
        this.mCallback = (ColorCallback) activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isInSub() {
        return getArguments().getBoolean("in_sub", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isInSub(boolean z) {
        getArguments().putBoolean("in_sub", z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int topIndex() {
        return getArguments().getInt("top_index", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void topIndex(int i) {
        if (i > -1) {
            findSubIndexForColor(i, this.mColorsTop[i]);
        }
        getArguments().putInt("top_index", i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int subIndex() {
        if (this.mColorsSub == null) {
            return -1;
        }
        return getArguments().getInt("sub_index", -1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void subIndex(int i) {
        if (this.mColorsSub == null) {
            return;
        }
        getArguments().putInt("sub_index", i);
    }

    public int getTitle() {
        Builder builder = getBuilder();
        int i = isInSub() ? builder.mTitleSub : builder.mTitle;
        return i == 0 ? builder.mTitle : i;
    }

    public String tag() {
        Builder builder = getBuilder();
        if (builder.mTag != null) {
            return builder.mTag;
        }
        return super.getTag();
    }

    public boolean isAccentMode() {
        return getBuilder().mAccentMode;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getTag() != null) {
            int i = Integer.parseInt(((String) view.getTag()).split(x.bQ)[0]);
            MaterialDialog materialDialog = (MaterialDialog) getDialog();
            Builder builder = getBuilder();
            if (isInSub()) {
                subIndex(i);
            } else {
                topIndex(i);
                int[][] iArr = this.mColorsSub;
                if (iArr != null && i < iArr.length) {
                    materialDialog.setActionButton(DialogAction.NEGATIVE, builder.mBackBtn);
                    isInSub(true);
                }
            }
            if (builder.mAllowUserCustom) {
                this.mSelectedCustomColor = getSelectedColor();
            }
            invalidateDynamicButtonColors();
            invalidate();
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getTag() == null) {
            return false;
        }
        ((CircleView) view).showHint(Integer.parseInt(((String) view.getTag()).split(x.bQ)[1]));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateDynamicButtonColors() {
        MaterialDialog materialDialog = (MaterialDialog) getDialog();
        if (materialDialog != null && getBuilder().mDynamicButtonColor) {
            int selectedColor = getSelectedColor();
            if (Color.alpha(selectedColor) < 64 || (Color.red(selectedColor) > 247 && Color.green(selectedColor) > 247 && Color.blue(selectedColor) > 247)) {
                selectedColor = Color.parseColor("#DEDEDE");
            }
            if (getBuilder().mDynamicButtonColor) {
                materialDialog.getActionButton(DialogAction.POSITIVE).setTextColor(selectedColor);
                materialDialog.getActionButton(DialogAction.NEGATIVE).setTextColor(selectedColor);
                materialDialog.getActionButton(DialogAction.NEUTRAL).setTextColor(selectedColor);
            }
            if (this.mCustomSeekR != null) {
                if (this.mCustomSeekA.getVisibility() == 0) {
                    MDTintHelper.setTint(this.mCustomSeekA, selectedColor);
                }
                MDTintHelper.setTint(this.mCustomSeekR, selectedColor);
                MDTintHelper.setTint(this.mCustomSeekG, selectedColor);
                MDTintHelper.setTint(this.mCustomSeekB, selectedColor);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSelectedColor() {
        int i;
        View view = this.mColorChooserCustomFrame;
        if (view != null && view.getVisibility() == 0) {
            return this.mSelectedCustomColor;
        }
        if (subIndex() > -1) {
            i = this.mColorsSub[topIndex()][subIndex()];
        } else {
            i = topIndex() > -1 ? this.mColorsTop[topIndex()] : 0;
        }
        if (i == 0) {
            return DialogUtils.resolveColor(getActivity(), R.attr.colorAccent, DialogUtils.resolveColor(getActivity(), android.R.attr.colorAccent));
        }
        return i;
    }

    private void findSubIndexForColor(int i, int i2) {
        int[][] iArr = this.mColorsSub;
        if (iArr == null || iArr.length - 1 < i) {
            return;
        }
        int[] iArr2 = iArr[i];
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            if (iArr2[i3] == i2) {
                subIndex(i3);
                return;
            }
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        int selectedColor;
        int i;
        if (getArguments() == null || !getArguments().containsKey("builder")) {
            throw new IllegalStateException("ColorChooserDialog should be created using its Builder interface.");
        }
        generateColors();
        if (bundle != null) {
            i = !bundle.getBoolean("in_custom", false) ? 1 : 0;
            selectedColor = getSelectedColor();
        } else {
            if (getBuilder().mSetPreselectionColor) {
                selectedColor = getBuilder().mPreselect;
                i = 0;
                if (selectedColor != 0) {
                    int i2 = 0;
                    while (true) {
                        int[] iArr = this.mColorsTop;
                        if (i < iArr.length) {
                            if (iArr[i] == selectedColor) {
                                topIndex(i);
                                if (getBuilder().mAccentMode) {
                                    subIndex(2);
                                } else if (this.mColorsSub != null) {
                                    findSubIndexForColor(i, selectedColor);
                                } else {
                                    subIndex(5);
                                }
                            } else {
                                if (this.mColorsSub != null) {
                                    int i3 = 0;
                                    while (true) {
                                        int[] iArr2 = this.mColorsSub[i];
                                        if (i3 >= iArr2.length) {
                                            break;
                                        }
                                        if (iArr2[i3] == selectedColor) {
                                            topIndex(i);
                                            subIndex(i3);
                                            i2 = 1;
                                            break;
                                        }
                                        i3++;
                                    }
                                    if (i2 != 0) {
                                    }
                                }
                                i++;
                            }
                        }
                        i = i2;
                    }
                }
            } else {
                selectedColor = -16777216;
            }
            i = 1;
        }
        this.mCircleSize = getResources().getDimensionPixelSize(R.dimen.md_colorchooser_circlesize);
        Builder builder = getBuilder();
        MaterialDialog.Builder builderShowListener = new MaterialDialog.Builder(getActivity()).title(getTitle()).autoDismiss(false).customView(R.layout.md_dialog_colorchooser, false).negativeText(builder.mCancelBtn).positiveText(builder.mDoneBtn).neutralText(builder.mAllowUserCustom ? builder.mCustomBtn : 0).onPositive(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.color.ColorChooserDialog.4
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                ColorCallback colorCallback = ColorChooserDialog.this.mCallback;
                ColorChooserDialog colorChooserDialog = ColorChooserDialog.this;
                colorCallback.onColorSelection(colorChooserDialog, colorChooserDialog.getSelectedColor());
                ColorChooserDialog.this.dismiss();
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.color.ColorChooserDialog.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                if (ColorChooserDialog.this.isInSub()) {
                    materialDialog.setActionButton(DialogAction.NEGATIVE, ColorChooserDialog.this.getBuilder().mCancelBtn);
                    ColorChooserDialog.this.isInSub(false);
                    ColorChooserDialog.this.subIndex(-1);
                    ColorChooserDialog.this.invalidate();
                    return;
                }
                materialDialog.cancel();
            }
        }).onNeutral(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.color.ColorChooserDialog.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                ColorChooserDialog.this.toggleCustom(materialDialog);
            }
        }).showListener(new DialogInterface.OnShowListener() { // from class: com.afollestad.materialdialogs.color.ColorChooserDialog.1
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                ColorChooserDialog.this.invalidateDynamicButtonColors();
            }
        });
        if (builder.mTheme != null) {
            builderShowListener.theme(builder.mTheme);
        }
        MaterialDialog materialDialogBuild = builderShowListener.build();
        View customView = materialDialogBuild.getCustomView();
        this.mGrid = (GridView) customView.findViewById(R.id.md_grid);
        if (builder.mAllowUserCustom) {
            this.mSelectedCustomColor = selectedColor;
            this.mColorChooserCustomFrame = customView.findViewById(R.id.md_colorChooserCustomFrame);
            this.mCustomColorHex = (EditText) customView.findViewById(R.id.md_hexInput);
            this.mCustomColorIndicator = customView.findViewById(R.id.md_colorIndicator);
            this.mCustomSeekA = (SeekBar) customView.findViewById(R.id.md_colorA);
            this.mCustomSeekAValue = (TextView) customView.findViewById(R.id.md_colorAValue);
            this.mCustomSeekR = (SeekBar) customView.findViewById(R.id.md_colorR);
            this.mCustomSeekRValue = (TextView) customView.findViewById(R.id.md_colorRValue);
            this.mCustomSeekG = (SeekBar) customView.findViewById(R.id.md_colorG);
            this.mCustomSeekGValue = (TextView) customView.findViewById(R.id.md_colorGValue);
            this.mCustomSeekB = (SeekBar) customView.findViewById(R.id.md_colorB);
            this.mCustomSeekBValue = (TextView) customView.findViewById(R.id.md_colorBValue);
            if (!builder.mAllowUserCustomAlpha) {
                customView.findViewById(R.id.md_colorALabel).setVisibility(8);
                this.mCustomSeekA.setVisibility(8);
                this.mCustomSeekAValue.setVisibility(8);
                this.mCustomColorHex.setHint("2196F3");
                this.mCustomColorHex.setFilters(new InputFilter[]{new InputFilter.LengthFilter(6)});
            } else {
                this.mCustomColorHex.setHint("FF2196F3");
                this.mCustomColorHex.setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
            }
            if (i == 0) {
                toggleCustom(materialDialogBuild);
            }
        }
        invalidate();
        return materialDialogBuild;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void toggleCustom(MaterialDialog materialDialog) {
        if (materialDialog == null) {
            materialDialog = (MaterialDialog) getDialog();
        }
        if (this.mGrid.getVisibility() == 0) {
            materialDialog.setTitle(getBuilder().mCustomBtn);
            materialDialog.setActionButton(DialogAction.NEUTRAL, getBuilder().mPresetsBtn);
            materialDialog.setActionButton(DialogAction.NEGATIVE, getBuilder().mCancelBtn);
            this.mGrid.setVisibility(4);
            this.mColorChooserCustomFrame.setVisibility(0);
            TextWatcher textWatcher = new TextWatcher() { // from class: com.afollestad.materialdialogs.color.ColorChooserDialog.5
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable editable) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    try {
                        ColorChooserDialog.this.mSelectedCustomColor = Color.parseColor("#" + charSequence.toString());
                    } catch (IllegalArgumentException unused) {
                        ColorChooserDialog.this.mSelectedCustomColor = -16777216;
                    }
                    ColorChooserDialog.this.mCustomColorIndicator.setBackgroundColor(ColorChooserDialog.this.mSelectedCustomColor);
                    if (ColorChooserDialog.this.mCustomSeekA.getVisibility() == 0) {
                        int iAlpha = Color.alpha(ColorChooserDialog.this.mSelectedCustomColor);
                        ColorChooserDialog.this.mCustomSeekA.setProgress(iAlpha);
                        ColorChooserDialog.this.mCustomSeekAValue.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(iAlpha)));
                    }
                    if (ColorChooserDialog.this.mCustomSeekA.getVisibility() == 0) {
                        ColorChooserDialog.this.mCustomSeekA.setProgress(Color.alpha(ColorChooserDialog.this.mSelectedCustomColor));
                    }
                    ColorChooserDialog.this.mCustomSeekR.setProgress(Color.red(ColorChooserDialog.this.mSelectedCustomColor));
                    ColorChooserDialog.this.mCustomSeekG.setProgress(Color.green(ColorChooserDialog.this.mSelectedCustomColor));
                    ColorChooserDialog.this.mCustomSeekB.setProgress(Color.blue(ColorChooserDialog.this.mSelectedCustomColor));
                    ColorChooserDialog.this.isInSub(false);
                    ColorChooserDialog.this.topIndex(-1);
                    ColorChooserDialog.this.subIndex(-1);
                    ColorChooserDialog.this.invalidateDynamicButtonColors();
                }
            };
            this.mCustomColorTextWatcher = textWatcher;
            this.mCustomColorHex.addTextChangedListener(textWatcher);
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.afollestad.materialdialogs.color.ColorChooserDialog.6
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    if (z) {
                        if (ColorChooserDialog.this.getBuilder().mAllowUserCustomAlpha) {
                            ColorChooserDialog.this.mCustomColorHex.setText(String.format("%08X", Integer.valueOf(Color.argb(ColorChooserDialog.this.mCustomSeekA.getProgress(), ColorChooserDialog.this.mCustomSeekR.getProgress(), ColorChooserDialog.this.mCustomSeekG.getProgress(), ColorChooserDialog.this.mCustomSeekB.getProgress()))));
                        } else {
                            ColorChooserDialog.this.mCustomColorHex.setText(String.format("%06X", Integer.valueOf(Color.rgb(ColorChooserDialog.this.mCustomSeekR.getProgress(), ColorChooserDialog.this.mCustomSeekG.getProgress(), ColorChooserDialog.this.mCustomSeekB.getProgress()) & ViewCompat.MEASURED_SIZE_MASK)));
                        }
                    }
                    ColorChooserDialog.this.mCustomSeekAValue.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(ColorChooserDialog.this.mCustomSeekA.getProgress())));
                    ColorChooserDialog.this.mCustomSeekRValue.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(ColorChooserDialog.this.mCustomSeekR.getProgress())));
                    ColorChooserDialog.this.mCustomSeekGValue.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(ColorChooserDialog.this.mCustomSeekG.getProgress())));
                    ColorChooserDialog.this.mCustomSeekBValue.setText(String.format(TimeModel.NUMBER_FORMAT, Integer.valueOf(ColorChooserDialog.this.mCustomSeekB.getProgress())));
                }
            };
            this.mCustomColorRgbListener = onSeekBarChangeListener;
            this.mCustomSeekR.setOnSeekBarChangeListener(onSeekBarChangeListener);
            this.mCustomSeekG.setOnSeekBarChangeListener(this.mCustomColorRgbListener);
            this.mCustomSeekB.setOnSeekBarChangeListener(this.mCustomColorRgbListener);
            if (this.mCustomSeekA.getVisibility() == 0) {
                this.mCustomSeekA.setOnSeekBarChangeListener(this.mCustomColorRgbListener);
                this.mCustomColorHex.setText(String.format("%08X", Integer.valueOf(this.mSelectedCustomColor)));
                return;
            } else {
                this.mCustomColorHex.setText(String.format("%06X", Integer.valueOf(16777215 & this.mSelectedCustomColor)));
                return;
            }
        }
        materialDialog.setTitle(getBuilder().mTitle);
        materialDialog.setActionButton(DialogAction.NEUTRAL, getBuilder().mCustomBtn);
        if (isInSub()) {
            materialDialog.setActionButton(DialogAction.NEGATIVE, getBuilder().mBackBtn);
        } else {
            materialDialog.setActionButton(DialogAction.NEGATIVE, getBuilder().mCancelBtn);
        }
        this.mGrid.setVisibility(0);
        this.mColorChooserCustomFrame.setVisibility(8);
        this.mCustomColorHex.removeTextChangedListener(this.mCustomColorTextWatcher);
        this.mCustomColorTextWatcher = null;
        this.mCustomSeekR.setOnSeekBarChangeListener(null);
        this.mCustomSeekG.setOnSeekBarChangeListener(null);
        this.mCustomSeekB.setOnSeekBarChangeListener(null);
        this.mCustomColorRgbListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidate() {
        if (this.mGrid.getAdapter() == null) {
            this.mGrid.setAdapter((ListAdapter) new ColorGridAdapter());
            this.mGrid.setSelector(ResourcesCompat.getDrawable(getResources(), R.drawable.md_transparent, null));
        } else {
            ((BaseAdapter) this.mGrid.getAdapter()).notifyDataSetChanged();
        }
        if (getDialog() != null) {
            getDialog().setTitle(getTitle());
        }
    }

    private class ColorGridAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        public ColorGridAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return ColorChooserDialog.this.isInSub() ? ColorChooserDialog.this.mColorsSub[ColorChooserDialog.this.topIndex()].length : ColorChooserDialog.this.mColorsTop.length;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return ColorChooserDialog.this.isInSub() ? Integer.valueOf(ColorChooserDialog.this.mColorsSub[ColorChooserDialog.this.topIndex()][i]) : Integer.valueOf(ColorChooserDialog.this.mColorsTop[i]);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = new CircleView(ColorChooserDialog.this.getContext());
                view.setLayoutParams(new AbsListView.LayoutParams(ColorChooserDialog.this.mCircleSize, ColorChooserDialog.this.mCircleSize));
            }
            CircleView circleView = (CircleView) view;
            int i2 = ColorChooserDialog.this.isInSub() ? ColorChooserDialog.this.mColorsSub[ColorChooserDialog.this.topIndex()][i] : ColorChooserDialog.this.mColorsTop[i];
            circleView.setBackgroundColor(i2);
            if (ColorChooserDialog.this.isInSub()) {
                circleView.setSelected(ColorChooserDialog.this.subIndex() == i);
            } else {
                circleView.setSelected(ColorChooserDialog.this.topIndex() == i);
            }
            circleView.setTag(String.format("%d:%d", Integer.valueOf(i), Integer.valueOf(i2)));
            circleView.setOnClickListener(ColorChooserDialog.this);
            circleView.setOnLongClickListener(ColorChooserDialog.this);
            return view;
        }
    }

    public static class Builder implements Serializable {
        protected int[][] mColorsSub;
        protected int[] mColorsTop;
        protected final transient AppCompatActivity mContext;
        protected int mPreselect;
        protected String mTag;
        protected Theme mTheme;
        protected final int mTitle;
        protected int mTitleSub;
        protected int mDoneBtn = R.string.md_done_label;
        protected int mBackBtn = R.string.md_back_label;
        protected int mCancelBtn = R.string.md_cancel_label;
        protected int mCustomBtn = R.string.md_custom_label;
        protected int mPresetsBtn = R.string.md_presets_label;
        protected boolean mAccentMode = false;
        protected boolean mDynamicButtonColor = true;
        protected boolean mAllowUserCustom = true;
        protected boolean mAllowUserCustomAlpha = true;
        protected boolean mSetPreselectionColor = false;

        public Builder accentMode(boolean z) {
            this.mAccentMode = z;
            return this;
        }

        public Builder allowUserColorInput(boolean z) {
            this.mAllowUserCustom = z;
            return this;
        }

        public Builder allowUserColorInputAlpha(boolean z) {
            this.mAllowUserCustomAlpha = z;
            return this;
        }

        public Builder backButton(int i) {
            this.mBackBtn = i;
            return this;
        }

        public Builder cancelButton(int i) {
            this.mCancelBtn = i;
            return this;
        }

        public Builder customButton(int i) {
            this.mCustomBtn = i;
            return this;
        }

        public Builder customColors(int[] iArr, int[][] iArr2) {
            this.mColorsTop = iArr;
            this.mColorsSub = iArr2;
            return this;
        }

        public Builder doneButton(int i) {
            this.mDoneBtn = i;
            return this;
        }

        public Builder dynamicButtonColor(boolean z) {
            this.mDynamicButtonColor = z;
            return this;
        }

        public Builder preselect(int i) {
            this.mPreselect = i;
            this.mSetPreselectionColor = true;
            return this;
        }

        public Builder presetsButton(int i) {
            this.mPresetsBtn = i;
            return this;
        }

        public Builder tag(String str) {
            this.mTag = str;
            return this;
        }

        public Builder theme(Theme theme) {
            this.mTheme = theme;
            return this;
        }

        public Builder titleSub(int i) {
            this.mTitleSub = i;
            return this;
        }

        public <ActivityType extends AppCompatActivity & ColorCallback> Builder(ActivityType activitytype, int i) {
            this.mContext = activitytype;
            this.mTitle = i;
        }

        public Builder customColors(int i, int[][] iArr) {
            this.mColorsTop = DialogUtils.getColorArray(this.mContext, i);
            this.mColorsSub = iArr;
            return this;
        }

        public ColorChooserDialog build() {
            ColorChooserDialog colorChooserDialog = new ColorChooserDialog();
            Bundle bundle = new Bundle();
            bundle.putSerializable("builder", this);
            colorChooserDialog.setArguments(bundle);
            return colorChooserDialog;
        }

        public ColorChooserDialog show() {
            ColorChooserDialog colorChooserDialogBuild = build();
            colorChooserDialogBuild.show(this.mContext);
            return colorChooserDialogBuild;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Builder getBuilder() {
        if (getArguments() == null || !getArguments().containsKey("builder")) {
            return null;
        }
        return (Builder) getArguments().getSerializable("builder");
    }

    private void dismissIfNecessary(AppCompatActivity appCompatActivity, String str) {
        Fragment fragmentFindFragmentByTag = appCompatActivity.getSupportFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag != null) {
            ((DialogFragment) fragmentFindFragmentByTag).dismiss();
            appCompatActivity.getSupportFragmentManager().beginTransaction().remove(fragmentFindFragmentByTag).commit();
        }
    }

    public static ColorChooserDialog findVisible(AppCompatActivity appCompatActivity, String str) {
        Fragment fragmentFindFragmentByTag = appCompatActivity.getSupportFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null || !(fragmentFindFragmentByTag instanceof ColorChooserDialog)) {
            return null;
        }
        return (ColorChooserDialog) fragmentFindFragmentByTag;
    }

    public ColorChooserDialog show(AppCompatActivity appCompatActivity) {
        Builder builder = getBuilder();
        if (builder.mColorsTop == null) {
            boolean z = builder.mAccentMode;
        }
        dismissIfNecessary(appCompatActivity, "[MD_COLOR_CHOOSER]");
        show(appCompatActivity.getSupportFragmentManager(), "[MD_COLOR_CHOOSER]");
        return this;
    }
}
