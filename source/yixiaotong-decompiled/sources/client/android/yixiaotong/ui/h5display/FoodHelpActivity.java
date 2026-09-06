package client.android.yixiaotong.ui.h5display;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.unionpay.ProgressWebView;
import client.android.yixiaotong.ui.widget.TitleBar;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FoodHelpActivity extends BaseActivity {
    public static final String FOODURL = "http://www.lexiaotong.cn:8090/page/food.html";
    public static final String PROBLEMURL = "http://lexiaotong.cn:8090/page/problem.html";
    public static final String USERURL = "http://www.lexiaotong.cn:8090/page/user.html";
    public static final String ZKURL = "http://lexiaotong.cn:8090/page/zk.html";
    private TitleBar mTitlebar;
    private ProgressWebView mWebView;

    static {
        StubApp.interface11(7202);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mTitlebar = (TitleBar) findViewById(R.id.titlebar);
        this.mWebView = (ProgressWebView) findViewById(R.id.wv_webview);
    }

    public static void launch(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) FoodHelpActivity.class);
        intent.putExtra("url", str);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mTitlebar.setTitleView("说明");
        this.mTitlebar.setLeftViewIsBack();
        this.mTitlebar.setLeftViewOnClickBack(this);
    }

    private void initData(String str) {
        this.mWebView.loadUrl(str);
    }
}
