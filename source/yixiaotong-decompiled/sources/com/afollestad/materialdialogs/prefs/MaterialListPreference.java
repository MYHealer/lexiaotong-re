package com.afollestad.materialdialogs.prefs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.preference.ListPreference;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MaterialListPreference extends ListPreference {
    private Context context;
    private MaterialDialog mDialog;

    @Override // android.preference.DialogPreference
    public Dialog getDialog() {
        return this.mDialog;
    }

    public MaterialListPreference(Context context) {
        super(context);
        init(context, null);
    }

    public MaterialListPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MaterialListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    public MaterialListPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        this.context = context;
        PrefUtil.setLayoutResource(context, this, attributeSet);
    }

    @Override // android.preference.ListPreference
    public void setEntries(CharSequence[] charSequenceArr) {
        super.setEntries(charSequenceArr);
        MaterialDialog materialDialog = this.mDialog;
        if (materialDialog != null) {
            materialDialog.setItems(charSequenceArr);
        }
    }

    public RecyclerView getRecyclerView() {
        if (getDialog() == null) {
            return null;
        }
        return ((MaterialDialog) getDialog()).getRecyclerView();
    }

    @Override // android.preference.DialogPreference
    protected void showDialog(Bundle bundle) {
        if (getEntries() == null || getEntryValues() == null) {
            throw new IllegalStateException("ListPreference requires an entries array and an entryValues array.");
        }
        MaterialDialog.Builder builderItemsCallbackSingleChoice = new MaterialDialog.Builder(this.context).title(getDialogTitle()).icon(getDialogIcon()).dismissListener(this).onAny(new MaterialDialog.SingleButtonCallback() { // from class: com.afollestad.materialdialogs.prefs.MaterialListPreference.2
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                int i = AnonymousClass3.$SwitchMap$com$afollestad$materialdialogs$DialogAction[dialogAction.ordinal()];
                if (i == 1) {
                    MaterialListPreference.this.onClick(materialDialog, -3);
                } else if (i != 2) {
                    MaterialListPreference.this.onClick(materialDialog, -1);
                } else {
                    MaterialListPreference.this.onClick(materialDialog, -2);
                }
            }
        }).negativeText(getNegativeButtonText()).items(getEntries()).autoDismiss(true).itemsCallbackSingleChoice(findIndexOfValue(getValue()), new MaterialDialog.ListCallbackSingleChoice() { // from class: com.afollestad.materialdialogs.prefs.MaterialListPreference.1
            @Override // com.afollestad.materialdialogs.MaterialDialog.ListCallbackSingleChoice
            public boolean onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                MaterialListPreference.this.onClick(null, -1);
                if (i >= 0 && MaterialListPreference.this.getEntryValues() != null) {
                    try {
                        Field declaredField = ListPreference.class.getDeclaredField("mClickedDialogEntryIndex");
                        declaredField.setAccessible(true);
                        declaredField.set(MaterialListPreference.this, Integer.valueOf(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return true;
            }
        });
        View viewOnCreateDialogView = onCreateDialogView();
        if (viewOnCreateDialogView != null) {
            onBindDialogView(viewOnCreateDialogView);
            builderItemsCallbackSingleChoice.customView(viewOnCreateDialogView, false);
        } else {
            builderItemsCallbackSingleChoice.content(getDialogMessage());
        }
        PrefUtil.registerOnActivityDestroyListener(this, this);
        MaterialDialog materialDialogBuild = builderItemsCallbackSingleChoice.build();
        this.mDialog = materialDialogBuild;
        if (bundle != null) {
            materialDialogBuild.onRestoreInstanceState(bundle);
        }
        onClick(this.mDialog, -2);
        this.mDialog.show();
    }

    /* JADX INFO: renamed from: com.afollestad.materialdialogs.prefs.MaterialListPreference$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
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

    @Override // android.preference.DialogPreference, android.preference.PreferenceManager.OnActivityDestroyListener
    public void onActivityDestroy() {
        super.onActivityDestroy();
        MaterialDialog materialDialog = this.mDialog;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    @Override // android.preference.ListPreference, android.preference.DialogPreference, android.preference.Preference
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

    @Override // android.preference.ListPreference, android.preference.DialogPreference, android.preference.Preference
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
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.afollestad.materialdialogs.prefs.MaterialListPreference.SavedState.1
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
