package client.android.yixiaotong.ui.wallet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SubAppBean;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BalanceDetailActivity extends BaseActivity {
    private static final String EXTRA_WALLET = "extra_wallet";
    TitleBar mTitleBar;
    TextView mTvBalance1;
    TextView mTvBalance2;
    TextView mTvBalance3;
    TextView mTvTime;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(7647);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BalanceDetailActivity.class).putExtra("extra_wallet", walletModel));
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
        this.mTitleBar.setTitleView("账户余额");
    }

    private void initView() {
        List<SubAppBean> subAccounts = this.mWalletModel.getSubAccounts();
        if (subAccounts != null) {
            for (SubAppBean subAppBean : subAccounts) {
                if (subAppBean.WalletType == 3 && StringUtils.isNotEmpty(subAppBean.endTime) && StringUtils.isNotEmpty(subAppBean.startTime)) {
                    this.mTvTime.setText("有效期" + subAppBean.startTime + "至" + subAppBean.endTime);
                }
            }
        }
        this.mTvBalance1.setText(DecimalUtil.twoDecimal(this.mWalletModel.getBaseWallet()));
        this.mTvBalance2.setText(DecimalUtil.twoDecimal(this.mWalletModel.getGiveWallet()));
        this.mTvBalance3.setText(DecimalUtil.twoDecimal(this.mWalletModel.getPeriodWallet()));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
