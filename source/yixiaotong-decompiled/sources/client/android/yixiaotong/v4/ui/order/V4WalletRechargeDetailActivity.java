package client.android.yixiaotong.v4.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4WalletRechargeDetailActivity extends BaseActivity {
    private V4RefundDetailBean mBean;
    private TitleBar mTitleBar;
    private TextView mTvGiftAmount;
    private TextView mTvOrderId;
    private TextView mTvPayway;
    private TextView mTvPrice;
    private TextView mTvTime;
    private TextView mTvUsername;

    static {
        StubApp.interface11(10991);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4RefundDetailBean v4RefundDetailBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4WalletRechargeDetailActivity.class).putExtra("bean", v4RefundDetailBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvUsername = (TextView) findViewById(R.id.tv_username);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvPayway = (TextView) findViewById(R.id.tv_payway);
        this.mTvPrice = (TextView) findViewById(R.id.tv_price);
        this.mTvGiftAmount = (TextView) findViewById(R.id.tv_giftamount);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.rechargedetail));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvOrderId.setText(this.mBean.rechargeId);
        this.mTvUsername.setText(this.mBean.toUserName);
        this.mTvTime.setText(this.mBean.createTime);
        this.mTvPayway.setText(this.mBean.payMentName);
        this.mTvPrice.setText("¥ " + this.mBean.price);
        this.mTvGiftAmount.setText("¥ " + this.mBean.giftAmount);
    }
}
