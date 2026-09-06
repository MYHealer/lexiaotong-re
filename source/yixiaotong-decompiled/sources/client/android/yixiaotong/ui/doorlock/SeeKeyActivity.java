package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.store.HttpBusinessStoreJava;
import client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SeeKeyActivity extends BaseActivity {
    private TextView et1;
    private TextView et10;
    private TextView et2;
    private TextView et5;
    private TextView et6;
    private TextView et7;
    private TextView et8;
    private TextView et9;
    private String mPsw;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(7003);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SeeKeyActivity.class).putExtra(SetPswSuccessActivity.EXTRA_PSW, str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.et1 = (TextView) findViewById(R.id.et1);
        this.et2 = (TextView) findViewById(R.id.et2);
        this.et5 = (TextView) findViewById(R.id.et5);
        this.et6 = (TextView) findViewById(R.id.et6);
        this.et7 = (TextView) findViewById(R.id.et7);
        this.et8 = (TextView) findViewById(R.id.et8);
        this.et9 = (TextView) findViewById(R.id.et9);
        this.et10 = (TextView) findViewById(R.id.et10);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView(getResources().getString(R.string.doorlock_psw));
    }

    private void initView() {
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().LoginAccount;
        String strSubstring = str.substring(str.length() - 2);
        this.et1.setText(strSubstring.substring(0, 1));
        this.et2.setText(strSubstring.substring(1, 2));
        this.et1.setEnabled(false);
        this.et2.setEnabled(false);
    }

    private void initData() {
        String strDecryptData = HttpBusinessStoreJava.decryptData(this.mPsw);
        if (StringUtils.isNotEmpty(strDecryptData) && strDecryptData.length() == 8) {
            this.et1.setText(strDecryptData.substring(0, 1));
            this.et2.setText(strDecryptData.substring(1, 2));
            this.et5.setText(strDecryptData.substring(2, 3));
            this.et6.setText(strDecryptData.substring(3, 4));
            this.et7.setText(strDecryptData.substring(4, 5));
            this.et8.setText(strDecryptData.substring(5, 6));
            this.et9.setText(strDecryptData.substring(6, 7));
            this.et10.setText(strDecryptData.substring(7, 8));
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
