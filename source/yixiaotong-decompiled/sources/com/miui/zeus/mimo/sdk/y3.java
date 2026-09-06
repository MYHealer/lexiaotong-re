package com.miui.zeus.mimo.sdk;

import android.app.Dialog;
import android.view.View;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class y3 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MimoAdInfo f5747a;
    public final /* synthetic */ a4 b;

    public y3(a4 a4Var, MimoAdInfo mimoAdInfo) {
        this.b = a4Var;
        this.f5747a = mimoAdInfo;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b.a(AdEvent.CUSTOM_POPUP_WINDOW_CANCEL, this.f5747a, (n6) null, (k6) null);
        Dialog dialog = this.b.c;
        if (dialog != null) {
            dialog.dismiss();
            this.b.c = null;
        }
    }
}
