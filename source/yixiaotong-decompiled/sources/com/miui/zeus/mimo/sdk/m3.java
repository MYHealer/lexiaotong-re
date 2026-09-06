package com.miui.zeus.mimo.sdk;

import android.view.View;
import com.miui.zeus.mimo.sdk.ad.template.TemplateAdWebView;
import com.miui.zeus.mimo.sdk.track.info.AdEvent;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class m3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f5527a;
    public final /* synthetic */ TemplateAdWebView b;

    public m3(TemplateAdWebView templateAdWebView, View view) {
        this.b = templateAdWebView;
        this.f5527a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        TemplateAdWebView.a(this.b, AdEvent.CLOSE, null, this.f5527a);
    }
}
