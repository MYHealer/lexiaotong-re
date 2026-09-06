package com.miui.zeus.mimo.sdk;

import com.miui.zeus.mimo.sdk.ad.template.TemplateAdWebView;
import com.miui.zeus.mimo.sdk.ad.template.TemplateUIController;
import com.miui.zeus.mimo.sdk.click.ClickAreaType;
import com.miui.zeus.mimo.sdk.click.CommonActionHandler;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class l3 implements CommonActionHandler.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClickAreaType f5517a;
    public final /* synthetic */ TemplateAdWebView b;

    public l3(TemplateAdWebView templateAdWebView, ClickAreaType clickAreaType) {
        this.b = templateAdWebView;
        this.f5517a = clickAreaType;
    }

    @Override // com.miui.zeus.mimo.sdk.click.CommonActionHandler.c
    public void a(boolean z) {
        i3 i3Var;
        TemplateAdWebView templateAdWebView = this.b;
        TemplateAdWebView.a(templateAdWebView, AdEvent.CLICK, z ? ClickAreaType.TYPE_CPM_BUTTON : this.f5517a, templateAdWebView.getRootAdView());
        TemplateUIController.a aVar = this.b.c;
        if (aVar != null) {
            TemplateUIController templateUIController = ((o3) aVar).f5546a;
            if (templateUIController.b == null || (i3Var = templateUIController.h) == null) {
                return;
            }
            i3Var.onAdClick();
        }
    }
}
