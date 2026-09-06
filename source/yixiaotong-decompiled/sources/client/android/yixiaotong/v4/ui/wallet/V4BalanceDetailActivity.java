package client.android.yixiaotong.v4.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BalanceDetailActivity extends BaseActivity {
    private String mBalance;
    private String mGift;
    private TitleBar mTitleBar;
    private TextView mTvBalance1;
    private TextView mTvBalance2;
    private TextView mTvBalance3;
    private TextView mTvTime;

    static {
        StubApp.interface11(11105);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4BalanceDetailActivity.class));
        }
    }

    public static void launch(Activity activity, String str, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4BalanceDetailActivity.class).putExtra("balance", str).putExtra("gift", str2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvBalance1 = (TextView) findViewById(R.id.tv_balance1);
        this.mTvBalance2 = (TextView) findViewById(R.id.tv_balance2);
        this.mTvBalance3 = (TextView) findViewById(R.id.tv_balance3);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView(getString(R.string.accountbalance));
    }

    private void initView() {
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        if (loginAccountV4 == null) {
            finish();
        }
        if (StringUtils.isNotEmpty(loginAccountV4.balance)) {
            this.mTvBalance1.setText(loginAccountV4.balance);
        }
        if (StringUtils.isNotEmpty(loginAccountV4.giftBalance)) {
            this.mTvBalance2.setText(loginAccountV4.giftBalance);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
