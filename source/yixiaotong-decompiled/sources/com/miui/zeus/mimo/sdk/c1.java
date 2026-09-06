package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.view.MimoVideoTipsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class c1 implements MimoVideoTipsView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b1 f5382a;

    public c1(b1 b1Var) {
        this.f5382a = b1Var;
    }

    @Override // com.miui.zeus.mimo.sdk.view.MimoVideoTipsView.d
    public void a(View view, ClickAreaType clickAreaType) {
        if (this.f5382a.d.a(clickAreaType) == ClickEventType.CLICK_AUTO_DOWNLOAD) {
            b1 b1Var = this.f5382a;
            b1Var.r.a(view, b1Var.d, false, null);
        }
        this.f5382a.onClick(view, clickAreaType);
    }

    @Override // com.miui.zeus.mimo.sdk.view.MimoVideoTipsView.d
    public void a() {
        this.f5382a.b.c();
        b1 b1Var = this.f5382a;
        if (b1Var.y) {
            b1Var.q.setVisibility(0);
        }
    }
}
