package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.ClickEventType;
import com.miui.zeus.mimo.sdk.video.MimoMediaView;
import com.miui.zeus.mimo.sdk.view.MimoVideoTipsView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k2 implements MimoVideoTipsView.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j2 f5506a;

    public k2(j2 j2Var) {
        this.f5506a = j2Var;
    }

    @Override // com.miui.zeus.mimo.sdk.view.MimoVideoTipsView.d
    public void a(View view, ClickAreaType clickAreaType) {
        if (this.f5506a.f.a(clickAreaType) == ClickEventType.CLICK_AUTO_DOWNLOAD) {
            j2 j2Var = this.f5506a;
            j2Var.p.a(view, j2Var.f, false, null);
        }
        this.f5506a.onClick(view, clickAreaType);
    }

    @Override // com.miui.zeus.mimo.sdk.view.MimoVideoTipsView.d
    public void a() {
        MimoMediaView mimoMediaView = this.f5506a.b;
        if (mimoMediaView != null) {
            mimoMediaView.c();
        }
        this.f5506a.f();
    }
}
