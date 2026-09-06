package com.miui.zeus.mimo.sdk;

import android.webkit.ValueCallback;
import com.google.common.base.Ascii;
import com.miui.zeus.mimo.sdk.ad.template.TemplateAdWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class k3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5507a;
    public final /* synthetic */ TemplateAdWebView b;

    public class a implements ValueCallback<String> {
        public a(k3 k3Var) {
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
        }
    }

    public k3(TemplateAdWebView templateAdWebView, int i) {
        this.b = templateAdWebView;
        this.f5507a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.b.f5354a != null) {
            this.b.f5354a.evaluateJavascript(ijiami_1011.s.s.s.d(new byte[]{88, 87, Ascii.DC4, 3, 70, 80, 19, 13, Ascii.SYN, Ascii.SYN, 11, 6, 83, 90, 14, 0, 84, 80, 10, 59, 16, 13, 93, 16, 95, 83, 74}, "26bb53") + this.f5507a + ijiami_1011.s.s.s.d(new byte[]{79}, "fea391"), new a(this));
        }
    }
}
