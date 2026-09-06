package com.icbc.paysdk.webview;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.LinearLayout;
import com.icbc.paysdk.constants.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6253208.dex */
public class NativeWebViewCommonProxy {
    private Context context;
    private LinearLayout mLoadingIndicator;
    private CustomWebView mWebView;

    public NativeWebViewCommonProxy(Context context, CustomWebView customWebView, LinearLayout linearLayout) {
        this.context = context;
        this.mWebView = customWebView;
        this.mLoadingIndicator = linearLayout;
    }

    @JavascriptInterface
    public void showIndicator() {
        Log.i(Constants.LogFlag, "WebView --- showIndicator()");
        this.mLoadingIndicator.setVisibility(0);
    }

    @JavascriptInterface
    public void returnBack() {
        Log.i(Constants.LogFlag, "WebView --- returnBack()");
        ((Activity) this.context).setResult(-1);
        ((Activity) this.context).finish();
    }

    @JavascriptInterface
    public void hideIndicator() {
        Log.i(Constants.LogFlag, "WebView --- hideIndicator()");
        this.mLoadingIndicator.setVisibility(8);
    }

    @JavascriptInterface
    public void returnToMerchant(String str) throws JSONException {
        String string;
        String string2;
        Log.i(Constants.LogFlag, "WebView --- returnToMerchant(String result) -- " + str);
        String str2 = "";
        String strReplaceAll = str.replaceAll("\\\\", "");
        String strSubstring = strReplaceAll.substring(1, strReplaceAll.length() - 1);
        Log.i(Constants.LogFlag, "WebView --- fresult -- " + strSubstring);
        try {
            JSONObject jSONObject = new JSONObject(strSubstring);
            String string3 = jSONObject.getString("tranCode");
            string2 = jSONObject.getString("tranMsg");
            str2 = string3;
            string = jSONObject.getString("orderNo");
        } catch (JSONException e) {
            e.printStackTrace();
            string = "";
            string2 = string;
        }
        Log.i(Constants.LogFlag, "tranCode = " + str2 + "--tranMsg = " + string2 + "--orderNo = " + string);
        try {
            String packageName = ((Activity) this.context).getPackageName();
            ComponentName componentName = new ComponentName(packageName, packageName + ".icbcPay.PayResultHandler");
            Intent intent = new Intent();
            intent.setComponent(componentName);
            intent.putExtra("type", "onResp");
            intent.putExtra("tranCode", str2);
            intent.putExtra("tranMsg", string2);
            intent.putExtra("orderNo", string);
            this.context.startActivity(intent);
            ((Activity) this.context).finish();
        } catch (Exception e2) {
            e2.printStackTrace();
            Intent intent2 = new Intent();
            intent2.setAction("com.icbc.pay.PayResultHandler.SHOW_ACTIVITY");
            intent2.putExtra("type", "onResp");
            intent2.putExtra("tranCode", str2);
            intent2.putExtra("tranMsg", string2);
            intent2.putExtra("orderNo", string);
            intent2.addFlags(268435456);
            this.context.startActivity(intent2);
            ((Activity) this.context).finish();
        }
    }
}
