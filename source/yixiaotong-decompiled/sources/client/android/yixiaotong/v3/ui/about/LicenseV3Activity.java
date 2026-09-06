package client.android.yixiaotong.v3.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LicenseV3Activity extends BaseActivity {
    public static final String URL = "https://answer.lxt6.cn/html/userAgreement.html";
    private TitleBar mTitleBar;
    private WebView mWebView;

    static {
        StubApp.interface11(8916);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mWebView = (WebView) findViewById(R.id.web_view);
    }

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) LicenseV3Activity.class));
        }
    }

    private void initWebView() {
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setCacheMode(1);
        this.mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.mWebView.getSettings().setSupportMultipleWindows(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        onLoad(URL);
    }

    public void onLoad(String str) {
        try {
            this.mWebView.setWebViewClient(new WebViewClient() { // from class: client.android.yixiaotong.v3.ui.about.LicenseV3Activity.1
                @Override // android.webkit.WebViewClient
                public void onLoadResource(WebView webView, String str2) {
                    Log.e("tag", "onLoadResource url=" + str2);
                    super.onLoadResource(webView, str2);
                }

                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str2) {
                    Log.e("tag", "intercept url=" + str2);
                    webView.loadUrl(str2);
                    return true;
                }

                @Override // android.webkit.WebViewClient
                public void onPageFinished(WebView webView, String str2) {
                    Log.e("tag", "onPageFinished WebView title=" + webView.getTitle());
                }

                @Override // android.webkit.WebViewClient
                public void onReceivedError(WebView webView, int i, String str2, String str3) {
                    ToastUtils.show(LicenseV3Activity.this.getContext(), "加载错误");
                }
            });
            this.mWebView.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mWebView.removeAllViews();
        this.mWebView.destroy();
    }
}
