package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.view.component.ImageICP;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class j8 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i8 f5502a;
    public final /* synthetic */ ImageICP b;

    public j8(ImageICP imageICP, i8 i8Var) {
        this.b = imageICP;
        this.f5502a = i8Var;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f5502a.onClick(view, this.b.getClickAreaType());
    }
}
