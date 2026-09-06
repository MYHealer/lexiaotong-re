package client.android.yixiaotong.v3.ui.wallet;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.v3.bean.js.PayJavaScriptInterface;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ToH5PayActivity extends BaseActivity {
    private static String H5URL = "https://zl-isv-h5.lxt6.cn/test/#/appPayForAli";
    private static String TAG = "ToH5PayActivity";
    private WebView mWebView;
    private boolean mIsEnable = true;
    private String mUrl = "";
    private boolean mIsLoaded = false;

    static {
        StubApp.interface11(10296);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ToH5PayActivity.class).putExtra("url", str));
        }
    }

    private class MyWebViewClient extends WebViewClient {
        private MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            final Activity activity = ToH5PayActivity.this.getActivity();
            if (str.startsWith("alipays:") || str.startsWith("alipay")) {
                try {
                    activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                } catch (Exception unused) {
                    new AlertDialog.Builder(activity).setMessage("未检测到支付宝客户端，请安装后重试。").setPositiveButton("立即安装", new DialogInterface.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.wallet.ToH5PayActivity.MyWebViewClient.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i) {
                            activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://d.alipay.com")));
                        }
                    }).setNegativeButton("取消", (DialogInterface.OnClickListener) null).show();
                }
                return true;
            }
            if (!str.startsWith("http") && !str.startsWith("https")) {
                return true;
            }
            webView.loadUrl(str);
            return true;
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        WebView webView = this.mWebView;
        if (webView != null) {
            webView.removeAllViews();
            try {
                this.mWebView.destroy();
            } catch (Throwable unused) {
            }
            this.mWebView = null;
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    private void initWebView() {
        this.mWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setCacheMode(2);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.mWebView.getSettings().setSupportMultipleWindows(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        PayJavaScriptInterface payJavaScriptInterface = new PayJavaScriptInterface(getActivity());
        this.mWebView.addJavascriptInterface(payJavaScriptInterface, payJavaScriptInterface.getName());
        onLoad(H5URL);
    }

    public void onLoad(String str) {
        try {
            this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: client.android.yixiaotong.v3.ui.wallet.ToH5PayActivity.1
                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    String str2;
                    super.onProgressChanged(webView, i);
                    LogUtil.e(ToH5PayActivity.TAG, "onProgressChanged:" + i);
                    if (i != 100 || ToH5PayActivity.this.mIsLoaded) {
                        return;
                    }
                    ToH5PayActivity.this.mIsLoaded = true;
                    try {
                        str2 = "alipays://platformapi/startapp?appId=20000067&url=" + URLEncoder.encode(ToH5PayActivity.this.mUrl, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        str2 = null;
                    }
                    ToH5PayActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
                }

                @Override // android.webkit.WebChromeClient
                public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    LogUtil.e(ToH5PayActivity.TAG, "onShowFileChooser");
                    return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
                }
            });
            this.mWebView.loadUrl(str);
        } catch (Exception unused) {
        }
    }
}
