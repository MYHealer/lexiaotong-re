package client.android.yixiaotong.v3.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.js.RepairJavaScriptInterface;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RepairRecordH5Activity extends BaseActivity {
    private static final String DEBUG_URL = "https://zl-isv-h5.lxt6.cn/lxt_pro_repair/test/#/?";
    private static final String RELEASE_URL = "https://zl-isv-h5.lxt6.cn/lxt_pro_repair/#/?";
    private static final int RESULT_CODE = 1011;
    private static final String TAG = "RepairRecordH5Activity";
    public static final String URL = "https://zl-isv-h5.lxt6.cn/lxt_pro_repair/#/?";
    private WebView mWebView;
    private ValueCallback<Uri> valueCallback;
    private ValueCallback<Uri[]> valueCallbackArray;
    private boolean mIsEnable = true;
    private String mUrl = "https://zl-isv-h5.lxt6.cn/lxt_pro_repair/#/?";
    private final int REQUEST_CODE = 1010;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.repair.RepairRecordH5Activity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 2) {
                PermissionUtil.requestPerssion(RepairRecordH5Activity.this.getActivity(), 3, RepairRecordH5Activity.this.permissionGrant);
            } else {
                if (i != 3) {
                    return;
                }
                PermissionUtil.requestPerssion(RepairRecordH5Activity.this.getActivity(), 0, RepairRecordH5Activity.this.permissionGrant);
            }
        }
    };

    static {
        StubApp.interface11(10184);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) RepairRecordH5Activity.class));
        }
    }

    private void initViewNew() {
        this.mWebView = (WebView) findViewById(R.id.web_view);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.repair.RepairRecordH5Activity$1, reason: invalid class name */
    class AnonymousClass1 implements SystemErrorTip.SystemErrorDialogListener {
        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
        public void onConfirm() {
            LocalDataUtil.savePermissIndex(RepairRecordH5Activity.this.getActivity(), 4);
            PermissionUtil.requestPerssion(RepairRecordH5Activity.this.getActivity(), 2, RepairRecordH5Activity.this.permissionGrant);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume");
        this.mIsEnable = true;
        releaseWebFile(0, null);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        LogUtil.e(TAG, "onPause");
        this.mIsEnable = false;
    }

    private void initWebView() {
        this.mWebView.getSettings().setBuiltInZoomControls(true);
        this.mWebView.getSettings().setUseWideViewPort(true);
        this.mWebView.getSettings().setLoadWithOverviewMode(true);
        this.mWebView.getSettings().setCacheMode(2);
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        this.mWebView.getSettings().setSupportMultipleWindows(true);
        this.mWebView.getSettings().setDomStorageEnabled(true);
        RepairJavaScriptInterface repairJavaScriptInterface = new RepairJavaScriptInterface(getActivity());
        this.mWebView.addJavascriptInterface(repairJavaScriptInterface, repairJavaScriptInterface.getName());
        onLoad(this.mUrl);
    }

    public void onLoad(String str) {
        try {
            this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: client.android.yixiaotong.v3.ui.repair.RepairRecordH5Activity.2
                @Override // android.webkit.WebChromeClient
                public void onProgressChanged(WebView webView, int i) {
                    super.onProgressChanged(webView, i);
                    LogUtil.e(RepairRecordH5Activity.TAG, "onProgressChanged:" + i);
                }

                @Override // android.webkit.WebChromeClient
                public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
                    LogUtil.e(RepairRecordH5Activity.TAG, "onShowFileChooser");
                    if (RepairRecordH5Activity.this.valueCallbackArray != null) {
                        RepairRecordH5Activity.this.valueCallbackArray.onReceiveValue(null);
                        RepairRecordH5Activity.this.valueCallbackArray = null;
                    }
                    RepairRecordH5Activity.this.valueCallbackArray = valueCallback;
                    try {
                        RepairRecordH5Activity.this.startActivityForResult(fileChooserParams.createIntent(), 1010);
                        return true;
                    } catch (Exception unused) {
                        RepairRecordH5Activity.this.valueCallbackArray = null;
                        return false;
                    }
                }
            });
            this.mWebView.loadUrl(str);
        } catch (Exception unused) {
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mWebView.removeAllViews();
        this.mWebView.destroy();
        LogUtil.e(TAG, "onDestroy");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            LogUtil.e(TAG, "onActivityResult:" + i2 + "  " + i);
            if (i2 != 14) {
                if (i == 1010) {
                    releaseWebFile(i2, intent);
                }
            } else {
                String stringExtra = intent.getStringExtra("qrcode");
                LogUtil.e(TAG, "onActivityResult:" + stringExtra);
                if (StringUtils.isNotEmpty(stringExtra)) {
                    this.mWebView.evaluateJavascript("javascript:scanResule('" + stringExtra + "')", new ValueCallback<String>() { // from class: client.android.yixiaotong.v3.ui.repair.RepairRecordH5Activity.3
                        @Override // android.webkit.ValueCallback
                        public void onReceiveValue(String str) {
                            LogUtil.e(RepairRecordH5Activity.TAG, "onReceiveValue:" + str);
                        }
                    });
                }
            }
        }
    }

    private void releaseWebFile(int i, Intent intent) {
        if (this.valueCallbackArray == null) {
            return;
        }
        LogUtil.e(TAG, "releaseWebFile:" + i);
        if (intent == null) {
            this.valueCallbackArray.onReceiveValue(null);
        } else {
            this.valueCallbackArray.onReceiveValue(WebChromeClient.FileChooserParams.parseResult(i, intent));
        }
        this.valueCallbackArray = null;
    }
}
