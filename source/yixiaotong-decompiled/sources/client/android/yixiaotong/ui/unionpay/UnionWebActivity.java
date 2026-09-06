package client.android.yixiaotong.ui.unionpay;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.fancy.adsdk.lib.constants.BiddingConst;
import com.masget.base.AppConfig;
import com.masget.base.bean.User;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class UnionWebActivity extends BaseActivity {
    TitleBar mTitleBar;
    private String mainUnionCompanyId;
    private String ordernumber;
    private PayResultHandler resultHandler;
    private String unionAppKey;
    private String unionSession;
    private String url;
    private User user;
    ProgressWebView webView;
    WebViewClient webViewClient = new WebViewClient() { // from class: client.android.yixiaotong.ui.unionpay.UnionWebActivity.1
        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            Log.e(BiddingConst.ADN_ID.MM, "....onReceivedSslError.....");
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
            Log.e(BiddingConst.ADN_ID.MM, "....onReceivedError.....");
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Log.e(BiddingConst.ADN_ID.MM, "....shouldOverrideUrlLoading.....");
            UnionWebActivity unionWebActivity = UnionWebActivity.this;
            UnionWebActivity unionWebActivity2 = UnionWebActivity.this;
            unionWebActivity.resultHandler = new PayResultHandler(unionWebActivity2, unionWebActivity2.ordernumber, UnionWebActivity.this.mainUnionCompanyId, UnionWebActivity.this.unionSession, UnionWebActivity.this.unionAppKey);
            UnionWebActivity.this.resultHandler.startQuery(false, 20L, 180L);
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) throws Throwable {
            String str2 = AppConfig.getAppConfig(UnionWebActivity.this).get("operatorname");
            String str3 = AppConfig.getAppConfig(UnionWebActivity.this).get("departmentcode");
            String str4 = AppConfig.getAppConfig(UnionWebActivity.this).get("departmentname");
            JSONObject jSONObject = new JSONObject();
            if (str2 == null) {
                str2 = "";
            }
            jSONObject.put("operatorname", (Object) str2);
            if (str3 == null) {
                str3 = "";
            }
            jSONObject.put("departmentcode", (Object) str3);
            if (str4 == null) {
                str4 = "";
            }
            jSONObject.put("departmentname", (Object) str4);
            webView.loadUrl("javascript:loginInfo(" + jSONObject.toJSONString() + ")");
            webView.loadUrl("javascript:companyid(" + UnionWebActivity.this.user.getCompanyid() + ")");
        }
    };

    static {
        StubApp.interface11(7646);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.webView = (ProgressWebView) findViewById(R.id.web_view);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("银联在线支付");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void getIntentData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("url")) {
            this.url = extras.getString("url");
            if (extras != null && extras.containsKey("ordernumber")) {
                this.ordernumber = extras.getString("ordernumber");
                if (extras != null && extras.containsKey("mainUnionCompanyId")) {
                    this.mainUnionCompanyId = extras.getString("mainUnionCompanyId");
                    if (extras != null && extras.containsKey("unionSession")) {
                        this.unionSession = extras.getString("unionSession");
                        if (extras != null && extras.containsKey("unionAppKey")) {
                            this.unionAppKey = extras.getString("unionAppKey");
                            return;
                        } else {
                            finish();
                            return;
                        }
                    }
                    finish();
                    return;
                }
                finish();
                return;
            }
            finish();
            return;
        }
        finish();
    }

    private void initView() {
        this.user = BaseApplication.getInstance().getUserDate();
        webViewSettings(this.webView);
        this.webView.setWebViewClient(this.webViewClient);
        if (StringUtils.isNotEmpty(this.url)) {
            if (this.url.contains(AppConfig.alipay)) {
                startActivityForResult(new Intent("android.intent.action.VIEW", Uri.parse(this.url)), 30001);
            } else {
                this.webView.loadUrl(this.url);
            }
        }
    }

    private void webViewSettings(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(false);
        settings.setDefaultTextEncodingName("UTF-8");
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        PayResultHandler payResultHandler = this.resultHandler;
        if (payResultHandler != null) {
            payResultHandler.stopQuery();
        }
        ProgressWebView progressWebView = this.webView;
        if (progressWebView != null) {
            progressWebView.destroy();
        }
        super.onDestroy();
    }
}
