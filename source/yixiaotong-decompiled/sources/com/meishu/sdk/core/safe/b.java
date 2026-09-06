package com.meishu.sdk.core.safe;

import android.content.DialogInterface;

/* JADX INFO: compiled from: SafeDialogOnClickListener.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class b implements DialogInterface.OnClickListener {
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            safeOnClick(dialogInterface, i);
        } catch (Throwable th) {
            th.printStackTrace();
            com.meishu.sdk.core.exception.a.a(th);
        }
    }

    public void safeOnClick(DialogInterface dialogInterface, int i) {
    }
}
