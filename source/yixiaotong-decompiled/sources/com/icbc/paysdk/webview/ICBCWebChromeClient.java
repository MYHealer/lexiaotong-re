package com.icbc.paysdk.webview;

import android.app.Activity;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.WebView;
import com.icbc.paysdk.constants.Constants;
import org.json.JSONException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class ICBCWebChromeClient extends CustomWebChromeClient {
    public static final String JAVASCRIPT_COMMON_VALUE_ARGS = "args";
    public static final String JAVASCRIPT_COMMON_VALUE_FUNCTION = "func";
    public static final String JAVASCRIPT_COMMON_VALUE_OBJECT = "obj";
    private Activity mContext;
    private NativeWebViewCommonProxy nativeWebViewCommonProxy;

    public ICBCWebChromeClient(Activity activity, NativeWebViewCommonProxy nativeWebViewCommonProxy) {
        super(activity, nativeWebViewCommonProxy);
        this.mContext = activity;
        this.nativeWebViewCommonProxy = nativeWebViewCommonProxy;
    }

    @Override // com.icbc.paysdk.webview.CustomWebChromeClient
    protected boolean handleOldJsInterface(WebView webView, String str, String str2, JsPromptResult jsPromptResult) throws JSONException {
        Log.i(Constants.LogFlag, "override -- handleOldJsInterface() ");
        if (this.nativeWebViewCommonProxy == null) {
            return true;
        }
        if ("Native.returnToMerchant".equals(str)) {
            this.nativeWebViewCommonProxy.returnToMerchant(str2);
        }
        jsPromptResult.confirm();
        return true;
    }
}
