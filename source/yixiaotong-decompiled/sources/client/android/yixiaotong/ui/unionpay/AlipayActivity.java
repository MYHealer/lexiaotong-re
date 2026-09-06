package client.android.yixiaotong.ui.unionpay;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.webkit.DownloadListener;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.masget.base.util.LogUtils;
import com.stub.StubApp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AlipayActivity extends BaseActivity {
    private static final String ENCODE = "UTF-8";
    private LocalPreferencesHelper localPreferencesHelper;
    TitleBar mTitleBar;
    ProgressWebView mWebView;
    private String mainUnionCompanyId;
    private String ordernumber;
    private String qrcode;
    private PayResultHandler resultHandler;
    private String unionAppKey;
    private String unionSession;
    WebViewClient webViewClient = new WebViewClient() { // from class: client.android.yixiaotong.ui.unionpay.AlipayActivity.2
        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (AlipayActivity.this.parseScheme(str)) {
                if ("0".equals(AlipayActivity.this.localPreferencesHelper.getString("paystate"))) {
                    AlipayActivity.this.localPreferencesHelper.saveOrUpdate("paystate", "1");
                    AlipayActivity.this.startAlipayApp(str);
                    return true;
                }
                if ("0".equals(AlipayActivity.this.localPreferencesHelper.getString("paystate")) || "2".equals(AlipayActivity.this.localPreferencesHelper.getString("payRespcode"))) {
                    return true;
                }
                AlipayActivity.this.startAlipayApp(str);
                return true;
            }
            if (str.contains("platformapi") && str.contains("startapp")) {
                String strGenerateAlipayUriStr = AlipayActivity.this.generateAlipayUriStr(str);
                if (strGenerateAlipayUriStr == null) {
                    return true;
                }
                if ("0".equals(AlipayActivity.this.localPreferencesHelper.getString("paystate"))) {
                    AlipayActivity.this.localPreferencesHelper.saveOrUpdate("paystate", "1");
                    AlipayActivity.this.startAlipayApp(strGenerateAlipayUriStr);
                    return true;
                }
                if ("0".equals(AlipayActivity.this.localPreferencesHelper.getString("paystate")) || "2".equals(AlipayActivity.this.localPreferencesHelper.getString("payRespcode"))) {
                    return true;
                }
                AlipayActivity.this.startAlipayApp(strGenerateAlipayUriStr);
                return true;
            }
            webView.loadUrl(str);
            return true;
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
        }
    };

    static {
        StubApp.interface11(7635);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mWebView = (ProgressWebView) findViewById(R.id.webView);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("支付宝支付");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void getIntentData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("ordernumber")) {
            this.ordernumber = extras.getString("ordernumber");
            if (extras != null && extras.containsKey("mainUnionCompanyId")) {
                this.mainUnionCompanyId = extras.getString("mainUnionCompanyId");
                if (extras != null && extras.containsKey("qrcode")) {
                    this.qrcode = extras.getString("qrcode");
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
        webViewSettings(this.mWebView);
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
        settings.setAllowFileAccess(true);
        webView.setWebViewClient(this.webViewClient);
        webView.setDownloadListener(new DownloadListener() { // from class: client.android.yixiaotong.ui.unionpay.AlipayActivity.1
            @Override // android.webkit.DownloadListener
            public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
                AlipayActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getData() {
        this.mWebView.loadUrl(this.qrcode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAlipayApp(String str) {
        try {
            Intent uri = Intent.parseUri(str, 1);
            uri.addCategory("android.intent.category.BROWSABLE");
            uri.setComponent(null);
            startActivity(uri);
            this.resultHandler.startQuery(false, 5L, 180L);
        } catch (Exception e) {
            LogUtils.e("启动支付宝失败，可能未安装或版本太低");
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String generateAlipayUriStr(String str) {
        String uRLDecoderString = getURLDecoderString(str);
        if (!uRLDecoderString.contains("platformapi/startapp")) {
            return null;
        }
        return "intent://" + uRLDecoderString.substring(uRLDecoderString.indexOf("platformapi/startapp"), uRLDecoderString.length()) + "#Intent;scheme=alipays;package=com.eg.android.AlipayGphone;end";
    }

    public String getURLDecoderString(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean parseScheme(String str) {
        return str.contains("platformapi/startapp");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LocalPreferencesHelper localPreferencesHelper = this.localPreferencesHelper;
        if (localPreferencesHelper == null || "0".equals(localPreferencesHelper.getString("paystate")) || "2".equals(this.localPreferencesHelper.getString("payRespcode"))) {
            return;
        }
        new MaterialDialog.Builder(getContext()).title("交易结果").content("交易失败，是否还要继续支付").positiveText("继续支付").negativeText("不再支付").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.unionpay.AlipayActivity.4
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                AlipayActivity.this.getData();
            }
        }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.unionpay.AlipayActivity.3
            @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
            public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                AlipayActivity.this.finish();
            }
        }).show();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        PayResultHandler payResultHandler = this.resultHandler;
        if (payResultHandler != null) {
            payResultHandler.stopQuery();
            this.resultHandler.release();
        }
    }
}
