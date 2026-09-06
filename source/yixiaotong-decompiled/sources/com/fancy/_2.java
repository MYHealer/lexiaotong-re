package com.fancy;

import android.webkit.ValueCallback;
import com.fancy.mpsdk.widget.web.AdTemplateWebView;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6258816.dex */
public final class _2 implements Runnable {
    public final /* synthetic */ String _a;
    public final /* synthetic */ String _b;
    public final /* synthetic */ AdTemplateWebView _c;

    public class _a implements ValueCallback<String> {
        @Override // android.webkit.ValueCallback
        public final /* bridge */ /* synthetic */ void onReceiveValue(String str) {
        }
    }

    public _2(AdTemplateWebView adTemplateWebView, String str, String str2) {
        this._c = adTemplateWebView;
        this._a = str;
        this._b = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._c._a) {
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = this._a;
        String str = this._b;
        objArr[1] = (str == null || str.isEmpty()) ? "" : this._b;
        this._c.evaluateJavascript(String.format("javascript:%s(%s)", objArr), new _a());
    }
}
