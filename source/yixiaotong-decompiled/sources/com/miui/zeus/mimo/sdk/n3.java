package com.miui.zeus.mimo.sdk;

import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.ad.template.TemplateUIController;
import com.miui.zeus.mimo.sdk.bean.MimoAdInfo;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class n3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MimoAdInfo f5535a;
    public final /* synthetic */ TemplateUIController b;

    public n3(TemplateUIController templateUIController, MimoAdInfo mimoAdInfo) {
        this.b = templateUIController;
        this.f5535a = mimoAdInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        m.a(ijiami_1011.s.s.s.d(new byte[]{100, 1, 94, 68, 88, 84, Ascii.NAK, 1, 51, 43, 114, 10, 94, 16, 65, 91, 88, 89, 4, Ascii.SYN}, "0d3445"), ijiami_1011.s.s.s.d(new byte[]{76, 69, 80, 2, 16, 84, 32, 0}, "954cd1"));
        TemplateUIController templateUIController = this.b;
        templateUIController.b = this.f5535a;
        templateUIController.a();
    }
}
