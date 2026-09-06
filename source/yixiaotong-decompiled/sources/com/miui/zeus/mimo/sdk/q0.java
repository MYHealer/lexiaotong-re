package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class q0 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r0 f5567a;

    public q0(r0 r0Var) {
        this.f5567a = r0Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5567a.onClick(view, ClickAreaType.TYPE_OTHER);
    }
}
