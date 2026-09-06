package com.meishu.sdk.core.webview;

import android.webkit.ValueCallback;
import com.meishu.sdk.core.utils.LogUtil;

/* JADX INFO: compiled from: WebViewUtil.java */
/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class r extends com.meishu.sdk.core.safe.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4992a;
    public final /* synthetic */ q b;

    /* JADX INFO: compiled from: WebViewUtil.java */
    public class a implements ValueCallback<String> {
        public a(r rVar) {
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            LogUtil.e("WebViewUtil", "onReceiveValue:" + str);
        }
    }

    public r(q qVar, String str) {
        this.b = qVar;
        this.f4992a = str;
    }

    @Override // com.meishu.sdk.core.safe.l
    public void safeRun() {
        try {
            this.b.f4990a.evaluateJavascript(String.format("javascript:window.ADMateJSBridge.updateTempState('%s')", this.f4992a), new a(this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
