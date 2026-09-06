package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r7 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o7 f5586a;

    public r7(o7 o7Var) {
        this.f5586a = o7Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o7 o7Var = this.f5586a;
        o7.d dVar = o7Var.g;
        if (dVar != null) {
            dVar.a(ClickAreaType.TYPE_MOD, o7Var.mViewEventInfo);
        }
    }
}
