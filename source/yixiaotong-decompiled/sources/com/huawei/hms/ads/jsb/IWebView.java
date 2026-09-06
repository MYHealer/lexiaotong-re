package com.huawei.hms.ads.jsb;

import android.content.Context;
import android.webkit.ValueCallback;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public interface IWebView {
    void addJavascriptInterface(Object obj, String str);

    void evaluateJavascript(String str, ValueCallback<String> valueCallback);

    Context getContext();

    String getUrl();

    void loadUrl(String str);

    void removeJavascriptInterface(String str);
}
