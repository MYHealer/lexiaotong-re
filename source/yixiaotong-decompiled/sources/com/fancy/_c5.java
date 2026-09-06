package com.fancy;

import android.app.Dialog;
import android.content.DialogInterface;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _c5 implements DialogInterface.OnDismissListener {
    public DialogInterface.OnDismissListener _a;

    public class _a implements ViewTreeObserver.OnWindowAttachListener {
        public final /* synthetic */ Dialog _a;

        public _a(Dialog dialog) {
            this._a = dialog;
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public final void onWindowAttached() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public final void onWindowDetached() {
            DialogInterface.OnDismissListener onDismissListener = _c5.this._a;
            if (onDismissListener != null) {
                onDismissListener.onDismiss(this._a);
            }
            _c5.this._a = null;
        }
    }

    public _c5(DialogInterface.OnDismissListener onDismissListener) {
        this._a = onDismissListener;
    }

    public final void _a(Dialog dialog) {
        dialog.getWindow().getDecorView().getViewTreeObserver().addOnWindowAttachListener(new _a(dialog));
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        DialogInterface.OnDismissListener onDismissListener = this._a;
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialogInterface);
        }
    }
}
