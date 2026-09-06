package com.yfanads.android.custom.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class CustomDialog extends BaseDialogFragment {
    public static final String CLOSE_ID = "closeId";
    public static final String LAYOUT_ID = "layoutId";
    public static final String TABLET_ID = "isTablet";
    private static final String TAG = "YFAds";
    private boolean isTablet;
    protected DialogDismiss mDialogDismiss;
    private int oldRequestedOrientation;

    public static class CustomDialogBuilder extends BaseDialogFragment.Builder<CustomDialogBuilder, CustomDialog> {
        public int closeId;
        public boolean isTablet;
        public int layoutId;

        @Override // com.yfanads.android.custom.view.BaseDialogFragment.Builder
        public CustomDialog build() {
            return CustomDialog.newInstance(this);
        }

        public CustomDialogBuilder setCloseId(int i) {
            this.closeId = i;
            return this;
        }

        public CustomDialogBuilder setIsTablet(boolean z) {
            this.isTablet = z;
            return this;
        }

        public CustomDialogBuilder setLayoutId(int i) {
            this.layoutId = i;
            return this;
        }
    }

    public interface DialogDismiss {
        void onDismiss();
    }

    public interface NewDialogBindData extends BaseDialogFragment.DialogBindData {
        void onConfigurationChanged(Context context, int i);
    }

    private void autoOrientationChanged() {
        if (!(this.mDialogBindData instanceof NewDialogBindData) || getActivity() == null) {
            return;
        }
        ((NewDialogBindData) this.mDialogBindData).onConfigurationChanged(getActivity(), this.oldRequestedOrientation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CustomDialog newInstance(CustomDialogBuilder customDialogBuilder) {
        CustomDialog customDialog = new CustomDialog();
        Bundle argumentBundle = BaseDialogFragment.getArgumentBundle(customDialogBuilder);
        argumentBundle.putInt("layoutId", customDialogBuilder.layoutId);
        argumentBundle.putInt("closeId", customDialogBuilder.closeId);
        argumentBundle.putBoolean(TABLET_ID, customDialogBuilder.isTablet);
        customDialog.setArguments(argumentBundle);
        return customDialog;
    }

    private void setBooleanField(String str, boolean z) {
        try {
            Field declaredField = DialogFragment.class.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(this, Boolean.valueOf(z));
        } catch (Exception e) {
            Log.d("FeedbackDialog", "setBooleanField error " + e.getMessage());
        }
    }

    public CustomDialog bindData(BaseDialogFragment.DialogBindData dialogBindData) {
        this.mDialogBindData = dialogBindData;
        return this;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.d("YFAds", "onConfigurationChanged no:" + configuration.orientation + "|oo:" + this.oldRequestedOrientation + "|tt:" + this.isTablet);
        this.oldRequestedOrientation = configuration.orientation;
        autoOrientationChanged();
    }

    @Override // android.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        return new ProxyDialog(getActivity(), getTheme());
    }

    @Override // com.yfanads.android.custom.view.BaseDialogFragment, android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogDismiss dialogDismiss = this.mDialogDismiss;
        if (dialogDismiss != null) {
            dialogDismiss.onDismiss();
            this.mDialogDismiss = null;
        }
        if (this.mDialogBindData != null) {
            this.mDialogBindData = null;
        }
    }

    public CustomDialog setDismiss(DialogDismiss dialogDismiss) {
        this.mDialogDismiss = dialogDismiss;
        return this;
    }

    @Override // com.yfanads.android.custom.view.BaseDialogFragment
    public View setView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getActivity() == null) {
            return null;
        }
        this.oldRequestedOrientation = getActivity().getResources().getConfiguration().orientation;
        Bundle arguments = getArguments();
        View viewInflate = LayoutInflater.from(getActivity()).inflate(arguments.getInt("layoutId"), viewGroup, false);
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().setCancelable(false);
        int i = arguments.getInt("mWidth");
        int i2 = arguments.getInt("mHeight");
        this.isTablet = arguments.getBoolean(TABLET_ID);
        viewInflate.setLayoutParams(new RelativeLayout.LayoutParams(i, i2));
        BaseDialogFragment.DialogBindData dialogBindData = this.mDialogBindData;
        if (dialogBindData == null) {
            return viewInflate;
        }
        dialogBindData.bindViewData(viewInflate);
        return viewInflate;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        setBooleanField("mDismissed", false);
        setBooleanField("mShownByMe", true);
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(this, str);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
