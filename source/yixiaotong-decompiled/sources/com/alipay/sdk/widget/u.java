package com.alipay.sdk.widget;

import java.util.Iterator;
import java.util.Stack;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Stack<WebViewWindow> f1688a = new Stack<>();

    public WebViewWindow a() {
        return this.f1688a.pop();
    }

    public void a(WebViewWindow webViewWindow) {
        this.f1688a.push(webViewWindow);
    }

    public boolean b() {
        return this.f1688a.isEmpty();
    }

    public void c() {
        if (b()) {
            return;
        }
        Iterator<WebViewWindow> it = this.f1688a.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f1688a.clear();
    }
}
