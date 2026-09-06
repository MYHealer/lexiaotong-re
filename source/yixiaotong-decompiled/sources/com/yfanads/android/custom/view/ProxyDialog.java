package com.yfanads.android.custom.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ProxyDialog extends Dialog {
    public ProxyDialog(Context context) {
        super(context);
    }

    public ProxyDialog(Context context, int i) {
        super(context, i);
    }

    public ProxyDialog(Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
    }

    @Override // android.app.Dialog
    public void setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        super.setOnCancelListener(DialogInterfaceProxy.proxy(onCancelListener));
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        super.setOnDismissListener(DialogInterfaceProxy.proxy(onDismissListener));
    }

    @Override // android.app.Dialog
    public void setOnShowListener(DialogInterface.OnShowListener onShowListener) {
        super.setOnShowListener(DialogInterfaceProxy.proxy(onShowListener));
    }
}
