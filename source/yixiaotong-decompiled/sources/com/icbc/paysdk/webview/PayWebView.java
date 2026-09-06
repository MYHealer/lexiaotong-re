package com.icbc.paysdk.webview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.net.MailTo;
import com.alipay.sdk.app.statistic.c;
import com.icbc.paysdk.constants.Constants;
import com.icbc.paysdk.view.IndicatorView;
import com.stub.StubApp;
import java.net.URLEncoder;
import java.util.HashMap;
import org.apache.http.util.EncodingUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class PayWebView extends Activity {
    ImageView error_image;
    TextView error_msg;
    private LinearLayout mLoadingError;
    private LinearLayout mLoadingIndicator;
    private CustomWebView mWebView;
    NativeWebViewCommonProxy nativeProxy;
    Button returnButton;
    private HashMap<String, String> startB2CParams;
    private String startB2CType;
    String error_type = "";
    private String startB2CURL = new Constants().Start_B2C_URL;
    private ICBCWebViewClient webViewClient = new ICBCWebViewClient() { // from class: com.icbc.paysdk.webview.PayWebView.1
        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            return str.startsWith(MailTo.MAILTO_SCHEME) || str.startsWith("tel:");
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            Log.i(Constants.LogFlag, "WebView --- onPageStarted()");
            PayWebView.this.mLoadingIndicator.setVisibility(0);
        }

        @Override // com.icbc.paysdk.webview.ICBCWebViewClient, android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            Log.i(Constants.LogFlag, "WebView --- onPageFinished()");
            PayWebView.this.mLoadingIndicator.setVisibility(8);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (sslError.getUrl().contains(Constants.SERVER_URL)) {
                PayWebView.this.mLoadingIndicator.setVisibility(8);
                PayWebView.this.mWebView.setVisibility(8);
                PayWebView.this.error_type = c.r;
                Toast.makeText(PayWebView.this, "支付失败，请稍后再试。", 0).show();
                PayWebView payWebView = PayWebView.this;
                payWebView.back(payWebView.error_type);
                return;
            }
            sslErrorHandler.proceed();
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            PayWebView.this.mLoadingIndicator.setVisibility(8);
            PayWebView.this.mWebView.setVisibility(8);
            PayWebView.this.error_type = "ReceivedError";
            Toast.makeText(PayWebView.this, "支付失败，请稍后再试。", 0).show();
            PayWebView payWebView = PayWebView.this;
            payWebView.back(payWebView.error_type);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            PayWebView.this.mLoadingIndicator.setVisibility(8);
            PayWebView.this.mWebView.setVisibility(8);
            PayWebView.this.error_type = "HttpAuthRequestError";
            Toast.makeText(PayWebView.this, "支付失败，请稍后再试。", 0).show();
            PayWebView payWebView = PayWebView.this;
            payWebView.back(payWebView.error_type);
        }
    };
    private View.OnClickListener returnButtonOnClick = new View.OnClickListener() { // from class: com.icbc.paysdk.webview.PayWebView.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PayWebView payWebView = PayWebView.this;
            payWebView.back(payWebView.error_type);
        }
    };

    static {
        StubApp.interface11(36637);
    }

    @Override // android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void startFirstRequest() {
        if (!checkB2CData()) {
            finish();
        } else {
            startB2CTransaction();
        }
    }

    private void initViewAndData() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 112;
        frameLayout.setLayoutParams(layoutParams);
        frameLayout.setBackgroundColor(Color.parseColor("#00000000"));
        CustomWebView customWebView = new CustomWebView(this);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
        customWebView.setHorizontalScrollBarEnabled(false);
        customWebView.setVerticalScrollBarEnabled(false);
        customWebView.setLayoutParams(layoutParams2);
        LinearLayout linearLayout2 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams3.weight = 1.0f;
        linearLayout2.setLayoutParams(layoutParams3);
        linearLayout2.setBackgroundColor(Color.parseColor("#00000000"));
        linearLayout2.setClickable(true);
        linearLayout2.setFocusable(true);
        linearLayout2.setFocusableInTouchMode(true);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(112);
        linearLayout2.setVisibility(0);
        linearLayout2.addView(new IndicatorView(this).getIndicatorView());
        LinearLayout linearLayout3 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams4.weight = 1.0f;
        linearLayout3.setLayoutParams(layoutParams4);
        linearLayout3.setBackgroundColor(Color.parseColor("#00000000"));
        linearLayout3.setClickable(true);
        linearLayout3.setFocusable(true);
        linearLayout3.setFocusableInTouchMode(true);
        linearLayout3.setGravity(17);
        linearLayout3.setOrientation(112);
        linearLayout3.setVisibility(8);
        frameLayout.addView(customWebView);
        frameLayout.addView(linearLayout2);
        frameLayout.addView(linearLayout3);
        linearLayout.addView(frameLayout);
        setContentView(linearLayout);
        this.mWebView = customWebView;
        this.mLoadingIndicator = linearLayout2;
        this.nativeProxy = new NativeWebViewCommonProxy(this, this.mWebView, this.mLoadingIndicator);
        this.mWebView.setWebChromeClient(new ICBCWebChromeClient(this, this.nativeProxy));
        this.mWebView.setWebViewClient(this.webViewClient);
        this.mWebView.addJavascriptInterface(this.nativeProxy, "RequestService");
        this.mWebView.addJavascriptInterface(this.nativeProxy, "Native");
        this.mWebView.addJavascriptInterface(this.nativeProxy, "PortalRequestService");
        this.mWebView.addJavascriptInterface(this.nativeProxy, "androidNativeProxy");
    }

    private void startB2CTransaction() {
        startB2CWebViewRequest();
    }

    private void startB2CWebViewRequest() {
        this.mWebView.postUrl(this.startB2CURL, EncodingUtils.getBytes(makeParamsStringForPortal(this.startB2CParams), "BASE64"));
    }

    private boolean checkB2CData() {
        try {
            this.startB2CParams = (HashMap) getIntent().getSerializableExtra("startB2CParams");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String makeParamsStringForPortal(HashMap<String, String> map) {
        String str = "";
        int i = 0;
        for (String str2 : map.keySet()) {
            try {
                str = str + str2 + "=" + URLEncoder.encode(map.get(str2), "UTF-8");
            } catch (Exception unused) {
                str = str + str2 + "=" + map.get(str2);
            }
            i++;
            if (i != map.size()) {
                str = str + "&";
            }
        }
        return str;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        super.onKeyDown(i, keyEvent);
        if (i == 4 && keyEvent.getRepeatCount() == 0) {
            back(this.error_type);
        }
        return false;
    }

    public void back(String str) {
        if (str.equals("")) {
            return;
        }
        try {
            String packageName = getPackageName();
            ComponentName componentName = new ComponentName(packageName, packageName + ".icbcPay.PayResultHandler");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra("type", "onErr");
            intent.putExtra("errorType", str);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setAction("com.icbc.pay.PayResultHandler.SHOW_ACTIVITY");
            intent2.putExtra("type", "onErr");
            intent2.putExtra("errorType", str);
            intent2.addFlags(268435456);
            startActivity(intent2);
            finish();
        }
    }
}
