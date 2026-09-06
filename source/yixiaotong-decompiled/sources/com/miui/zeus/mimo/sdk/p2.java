package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class p2 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v2 f5560a;

    public p2(v2 v2Var) {
        this.f5560a = v2Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5560a.onClick(view, ClickAreaType.TYPE_END_PICTURE);
    }
}
