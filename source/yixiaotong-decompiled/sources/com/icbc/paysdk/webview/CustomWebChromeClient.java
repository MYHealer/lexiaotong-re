package com.icbc.paysdk.webview;

import android.app.Activity;
import android.util.Log;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import com.icbc.paysdk.constants.Constants;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class CustomWebChromeClient extends WebChromeClient {
    private Activity mContext;
    private NativeWebViewCommonProxy nativeWebViewCoreProxy;

    public void setActivity(Activity activity) {
        this.mContext = activity;
    }

    public CustomWebChromeClient(Activity activity, NativeWebViewCommonProxy nativeWebViewCommonProxy) {
        this.mContext = activity;
        this.nativeWebViewCoreProxy = nativeWebViewCommonProxy;
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        try {
            if (webView instanceof CustomWebView) {
                if (((CustomWebView) webView).handleJsInterface(webView, str, str2, str3, jsPromptResult)) {
                    return true;
                }
                Log.i(Constants.LogFlag, "handleOldJsInterface () : message = " + str2 + "  defaultValue = " + str3);
                return handleOldJsInterface(webView, str2, str3, jsPromptResult);
            }
            return handleOldJsInterface(webView, str2, str3, jsPromptResult);
        } catch (Exception e) {
            System.out.println(e);
            jsPromptResult.cancel();
            return true;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        callback.invoke(str, true, false);
        super.onGeolocationPermissionsShowPrompt(str, callback);
    }

    @Override // android.webkit.WebChromeClient
    public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        super.onExceededDatabaseQuota(str, str2, j, j2, j3, quotaUpdater);
        quotaUpdater.updateQuota(j2 * 2);
    }

    protected boolean handleOldJsInterface(WebView webView, String str, String str2, JsPromptResult jsPromptResult) {
        Log.i(Constants.LogFlag, "-- handleOldJsInterface() ");
        return true;
    }
}
