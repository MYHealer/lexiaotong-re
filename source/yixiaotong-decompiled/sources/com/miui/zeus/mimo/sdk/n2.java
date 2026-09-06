package com.miui.zeus.mimo.sdk;

import android.content.DialogInterface;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.MimoVideoTipsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n2 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2 f5534a;

    public n2(j2 j2Var) {
        this.f5534a = j2Var;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        MimoMediaView mimoMediaView;
        h7 h7Var = this.f5534a.n;
        boolean z = h7Var != null && h7Var.isShowing();
        MimoVideoTipsView mimoVideoTipsView = this.f5534a.d;
        boolean z2 = mimoVideoTipsView != null && mimoVideoTipsView.getVisibility() == 0;
        if (z || z2 || (mimoMediaView = this.f5534a.b) == null) {
            return;
        }
        mimoMediaView.c();
    }
}
