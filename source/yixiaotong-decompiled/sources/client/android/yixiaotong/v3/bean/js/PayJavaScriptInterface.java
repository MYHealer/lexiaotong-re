package client.android.yixiaotong.v3.bean.js;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PayJavaScriptInterface {
    private static final String TAG = "PayJavaScriptInterface";
    private Activity mActivity;

    @JavascriptInterface
    public String getName() {
        return "Home";
    }

    public PayJavaScriptInterface() {
    }

    public PayJavaScriptInterface(Activity activity) {
        this.mActivity = activity;
    }

    @JavascriptInterface
    public void finish() {
        LogUtil.e(TAG, "finish");
        this.mActivity.finish();
    }
}
