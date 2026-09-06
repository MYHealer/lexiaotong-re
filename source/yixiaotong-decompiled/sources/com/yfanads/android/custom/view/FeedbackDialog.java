package com.yfanads.android.custom.view;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.yfanads.ads.libs.R;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class FeedbackDialog extends DialogFragment implements View.OnClickListener {
    private OnFeedClickListener mOnFeedClickListener;

    private WindowManager.LayoutParams getLayoutParams(WindowManager.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return new WindowManager.LayoutParams();
        }
        layoutParams.width = -1;
        layoutParams.height = -2;
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private void onInflated(View view) {
        view.findViewById(R.id.feed_back_reason1).setOnClickListener(this);
        view.findViewById(R.id.feed_back_reason2).setOnClickListener(this);
        view.findViewById(R.id.feed_back_reason3).setOnClickListener(this);
        view.findViewById(R.id.feed_back_reason4).setOnClickListener(this);
        view.findViewById(R.id.feed_back_reason41).setOnClickListener(this);
        view.findViewById(R.id.feed_back_reason42).setOnClickListener(this);
        view.findViewById(R.id.feed_back_reason43).setOnClickListener(this);
        view.findViewById(R.id.feed_back_reason44).setOnClickListener(this);
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

    private void setDialogAttributes(Dialog dialog) {
        if (dialog != null) {
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
            setWindowStyle(dialog.getWindow());
        }
    }

    private void setWindowStyle(Window window) {
        if (window == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.getDecorView().setPadding(80, 0, 80, 0);
        window.setAttributes(getLayoutParams(window.getAttributes()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        OnFeedClickListener onFeedClickListener = this.mOnFeedClickListener;
        if (onFeedClickListener != null) {
            onFeedClickListener.onTraceFeed();
        }
        dismiss();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.feed_back_dialog);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.yf_feed_dialog, viewGroup, false);
        setDialogAttributes(getDialog());
        onInflated(viewInflate);
        return viewInflate;
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public void onDestroyView() {
        Dialog dialog = getDialog();
        if (dialog != null && getRetainInstance()) {
            dialog.setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        OnFeedClickListener onFeedClickListener = this.mOnFeedClickListener;
        if (onFeedClickListener != null) {
            onFeedClickListener.onDismiss();
            this.mOnFeedClickListener = null;
        }
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
    }

    public void setOnFeedClickListener(OnFeedClickListener onFeedClickListener) {
        this.mOnFeedClickListener = onFeedClickListener;
    }

    @Override // android.app.DialogFragment
    public void show(FragmentManager fragmentManager, String str) {
        if (isAdded() || isResumed()) {
            return;
        }
        setBooleanField("mDismissed", false);
        setBooleanField("mShownByMe", true);
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(this, str);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
