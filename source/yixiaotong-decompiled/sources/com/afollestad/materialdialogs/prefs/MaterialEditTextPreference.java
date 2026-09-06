package com.afollestad.materialdialogs.prefs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.commons.R;
import com.afollestad.materialdialogs.internal.MDTintHelper;
import com.afollestad.materialdialogs.util.DialogUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MaterialEditTextPreference extends EditTextPreference {
    private int mColor;
    private MaterialDialog mDialog;
    private EditText mEditText;

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.mDialog;
    }

    @Override // android.preference.EditTextPreference
    public EditText getEditText() {
        return this.mEditText;
    }

    public MaterialEditTextPreference(Context context) {
        super(context);
        this.mColor = 0;
        init(context, null);
    }

    public MaterialEditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mColor = 0;
        init(context, attributeSet);
    }

    public MaterialEditTextPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mColor = 0;
        init(context, attributeSet);
    }

    public MaterialEditTextPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mColor = 0;
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        PrefUtil.setLayoutResource(context, this, attributeSet);
        this.mColor = DialogUtils.resolveColor(context, R.attr.md_widget_color, DialogUtils.resolveColor(context, R.attr.colorAccent, DialogUtils.resolveColor(context, android.R.attr.colorAccent)));
        AppCompatEditText appCompatEditText = new AppCompatEditText(context, attributeSet);
        this.mEditText = appCompatEditText;
        appCompatEditText.setId(android.R.id.edit);
        this.mEditText.setEnabled(true);
    }

    @Override // android.preference.EditTextPreference
    protected void onAddEditTextToDialogView(View view, EditText editText) {
        ((ViewGroup) view).addView(editText, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    protected void onBindDialogView(View view) {
        EditText editText = this.mEditText;
        editText.setText(getText());
        if (editText.getText().length() > 0) {
            editText.setSelection(editText.length());
        }
        ViewParent parent = editText.getParent();
        if (parent != view) {
            if (parent != null) {
                ((ViewGroup) parent).removeView(editText);
            }
            onAddEditTextToDialogView(view, editText);
        }
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    protected void onDialogClosed(boolean z) {
        if (z) {
            String string = this.mEditText.getText().toString();
            if (callChangeListener(string)) {
                setText(string);
            }
        }
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        MaterialDialog.Builder builderDismissListener = new MaterialDialog.Builder(getContext()).title(getDialogTitle()).icon(getDialogIcon()).positiveText(getPositiveButtonText()).negativeText(getNegativeButtonText()).dismissListener(this).onAny(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.prefs.MaterialEditTextPreference.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                int i = AnonymousClass2.$SwitchMap$com$afollestad$materialdialogs$DialogAction[dialogAction.ordinal()];
                if (i == 1) {
                    MaterialEditTextPreference.this.onClick(materialDialog, -3);
                } else if (i != 2) {
                    MaterialEditTextPreference.this.onClick(materialDialog, -1);
                } else {
                    MaterialEditTextPreference.this.onClick(materialDialog, -2);
                }
            }
        }).dismissListener(this);
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.md_stub_inputpref, (ViewGroup) null);
        onBindDialogView(viewInflate);
        MDTintHelper.setTint(this.mEditText, this.mColor);
        TextView textView = (TextView) viewInflate.findViewById(android.R.id.message);
        if (getDialogMessage() != null && getDialogMessage().toString().length() > 0) {
            textView.setVisibility(0);
            textView.setText(getDialogMessage());
        } else {
            textView.setVisibility(8);
        }
        builderDismissListener.customView(viewInflate, false);
        PrefUtil.registerOnActivityDestroyListener(this, this);
        MaterialDialog materialDialogBuild = builderDismissListener.build();
        this.mDialog = materialDialogBuild;
        if (bundle != null) {
            materialDialogBuild.onRestoreInstanceState(bundle);
        }
        requestInputMethod(this.mDialog);
        this.mDialog.show();
    }

    /* JADX INFO: renamed from: com.afollestad.materialdialogs.prefs.MaterialEditTextPreference$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$afollestad$materialdialogs$DialogAction;

        static {
            int[] iArr = new int[DialogAction.values().length];
            $SwitchMap$com$afollestad$materialdialogs$DialogAction = iArr;
            try {
                iArr[DialogAction.NEUTRAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$afollestad$materialdialogs$DialogAction[DialogAction.NEGATIVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    @Override // android.preference.DialogPreference, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        PrefUtil.unregisterOnActivityDestroyListener(this, this);
    }

    private void requestInputMethod(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    @Override // android.preference.DialogPreference, android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        MaterialDialog materialDialog = this.mDialog;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference, android.preference.Preference
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Dialog dialog = getDialog();
        if (dialog == null || !dialog.isShowing()) {
            return parcelableOnSaveInstanceState;
        }
        SavedState savedState = new SavedState(parcelableOnSaveInstanceState);
        savedState.isDialogShowing = true;
        savedState.dialogBundle = dialog.onSaveInstanceState();
        return savedState;
    }

    @Override // android.preference.EditTextPreference, android.preference.DialogPreference, android.preference.Preference
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (savedState.isDialogShowing) {
            showDialog(savedState.dialogBundle);
        }
    }

    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.afollestad.materialdialogs.prefs.MaterialEditTextPreference.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        Bundle dialogBundle;
        boolean isDialogShowing;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.isDialogShowing = parcel.readInt() == 1;
            this.dialogBundle = parcel.readBundle();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.isDialogShowing ? 1 : 0);
            parcel.writeBundle(this.dialogBundle);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
