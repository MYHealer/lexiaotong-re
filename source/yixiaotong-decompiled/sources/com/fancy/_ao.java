package com.fancy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public class _ao extends Dialog {
    public Context _a;
    public View _b;

    public _ao(Activity activity, int i) {
        super(activity, i);
        _a(activity);
    }

    public final void _a(Activity activity) {
        this._a = activity;
        requestWindowFeature(1);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        InputMethodManager inputMethodManager = (InputMethodManager) this._a.getSystemService("input_method");
        if (inputMethodManager != null && getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null) {
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
        }
        super.dismiss();
        View view = this._b;
        if (view != null) {
            view.clearAnimation();
        }
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        super.onBackPressed();
        dismiss();
    }

    @Override // android.app.Dialog
    public final void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        _c5 _c5Var = new _c5(onDismissListener);
        super.setOnDismissListener(_c5Var);
        _c5Var._a(this);
    }

    @Override // android.app.Dialog
    public final void show() {
        Context context = this._a;
        if (context == null) {
            return;
        }
        Activity activity = (Activity) context;
        if (activity.isDestroyed() || activity.isFinishing()) {
            return;
        }
        super.show();
    }
}
