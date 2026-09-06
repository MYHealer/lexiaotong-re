package client.android.yixiaotong.v3.ui.weight;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.alipay.sdk.app.H5PayCallback;
import com.alipay.sdk.app.PayTask;
import com.alipay.sdk.util.H5PayResultModel;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class MyWebClient extends WebViewClient {
    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(final WebView webView, String str) {
        if ((str.startsWith("http") || str.startsWith("https")) && !new PayTask(this.activity).payInterceptorWithUrl(str, true, new H5PayCallback() { // from class: client.android.yixiaotong.v3.ui.weight.MyWebClient.1
            @Override // com.alipay.sdk.app.H5PayCallback
            public void onPayResult(H5PayResultModel h5PayResultModel) {
                final String returnUrl = h5PayResultModel.getReturnUrl();
                if (TextUtils.isEmpty(returnUrl)) {
                    return;
                }
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.ui.weight.MyWebClient.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        webView.loadUrl(returnUrl);
                    }
                });
            }
        })) {
            webView.loadUrl(str);
        }
        return true;
    }
}
