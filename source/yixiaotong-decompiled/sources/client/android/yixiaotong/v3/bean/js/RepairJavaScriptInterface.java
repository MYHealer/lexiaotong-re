package client.android.yixiaotong.v3.bean.js;

import android.app.Activity;
import android.webkit.JavascriptInterface;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RepairJavaScriptInterface {
    private static final String TAG = "RepairJavaScriptInterface";
    private Activity mActivity;

    @JavascriptInterface
    public String getName() {
        return "Home";
    }

    public RepairJavaScriptInterface() {
    }

    public RepairJavaScriptInterface(Activity activity) {
        this.mActivity = activity;
    }

    @JavascriptInterface
    public void scanQRCode() {
        LogUtil.e(TAG, "scanQRCode");
        if (AppUtils.isUserHuaWeiScan()) {
            ScanQrcodeActivity.launch(this.mActivity, 14);
        } else {
            ZxingScanV3Activity.launch(this.mActivity, 14);
        }
    }

    @JavascriptInterface
    public void appLogout() {
        LogUtil.e(TAG, "appLogout");
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(this.mActivity);
        this.mActivity.finish();
    }

    @JavascriptInterface
    public void finish() {
        LogUtil.e(TAG, "finish");
        this.mActivity.finish();
    }
}
