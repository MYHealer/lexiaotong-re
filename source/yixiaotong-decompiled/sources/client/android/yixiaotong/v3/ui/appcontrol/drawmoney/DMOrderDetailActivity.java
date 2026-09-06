package client.android.yixiaotong.v3.ui.appcontrol.drawmoney;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bean.drawmoney.DMOrderDetailBean;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DMOrderDetailActivity extends BaseActivity {
    private static final int RECHARGE = 0;
    private static final int REFUND = 1;
    private DMOrderDetailBean mDMOrderDetailBean;
    private RelativeLayout mRelPayPlan;
    private RelativeLayout mRelPayTime;
    private RelativeLayout mRelPayWay;
    private TitleBar mTitleBar;
    private TextView mTvCurrentState;
    private TextView mTvMoney;
    private TextView mTvMoneyText;
    private TextView mTvOrderId;
    private TextView mTvPayFlag;
    private TextView mTvPayTime;
    private TextView mTvPayWay;
    private TextView mTvTime;
    private TextView mTvTimeText;
    private int mType;

    static {
        StubApp.interface11(9133);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, DMOrderDetailBean dMOrderDetailBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DMOrderDetailActivity.class).putExtra("bean", dMOrderDetailBean).putExtra("type", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvCurrentState = (TextView) findViewById(R.id.tv_currentstate);
        this.mTvTimeText = (TextView) findViewById(R.id.tv_ordettimetext);
        this.mTvTime = (TextView) findViewById(R.id.tv_ordertime);
        this.mTvMoneyText = (TextView) findViewById(R.id.tv_moneytext);
        this.mTvMoney = (TextView) findViewById(R.id.tv_money);
        this.mRelPayTime = (RelativeLayout) findViewById(R.id.rel_paytime);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_paytime);
        this.mRelPayWay = (RelativeLayout) findViewById(R.id.rel_payway);
        this.mTvPayWay = (TextView) findViewById(R.id.tv_payway);
        this.mTvPayFlag = (TextView) findViewById(R.id.tv_payflag);
        this.mRelPayPlan = (RelativeLayout) findViewById(R.id.rel_payplan);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.orderdetails));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvOrderId.setText(((Object) this.mTvOrderId.getText()) + this.mDMOrderDetailBean.orderId);
        if (this.mType == 1) {
            if (this.mDMOrderDetailBean.statusFlag == 2) {
                this.mTvCurrentState.setText(getResources().getString(R.string.orderrefundsuccessful));
            } else if (this.mDMOrderDetailBean.statusFlag == 1) {
                this.mTvCurrentState.setText(getResources().getString(R.string.createorder));
            } else if (this.mDMOrderDetailBean.statusFlag == 3) {
                this.mTvCurrentState.setText(getResources().getString(R.string.orderrefundfailed));
            } else {
                this.mTvCurrentState.setText(getResources().getString(R.string.unknown));
            }
            if (StringUtils.isEmpty(this.mDMOrderDetailBean.payDateTime)) {
                this.mTvTimeText.setText(getResources().getString(R.string.createtime));
                this.mTvTime.setText(this.mDMOrderDetailBean.createDateTime);
            } else {
                this.mTvTimeText.setText(getResources().getString(R.string.refundtime2));
                this.mTvTime.setText(this.mDMOrderDetailBean.payDateTime);
            }
            this.mTvMoneyText.setText(getResources().getString(R.string.refundmoney));
            this.mTvMoney.setText("¥" + DecimalUtil.divide(this.mDMOrderDetailBean.chargeMoney + "", "100"));
            this.mRelPayPlan.setVisibility(8);
            this.mRelPayTime.setVisibility(8);
            this.mRelPayWay.setVisibility(8);
            return;
        }
        if (this.mDMOrderDetailBean.statusFlag == 3) {
            this.mTvCurrentState.setText(getResources().getString(R.string.orderhasbeenrecharged));
        } else if (this.mDMOrderDetailBean.statusFlag == 1) {
            this.mTvCurrentState.setText(getResources().getString(R.string.createorder));
        } else if (this.mDMOrderDetailBean.statusFlag == 2) {
            this.mTvCurrentState.setText(getResources().getString(R.string.orderpaid));
        } else if (this.mDMOrderDetailBean.statusFlag == 4) {
            this.mTvCurrentState.setText(getResources().getString(R.string.orderrechangefailed));
        } else if (this.mDMOrderDetailBean.statusFlag == 5) {
            this.mTvCurrentState.setText(getResources().getString(R.string.ordercancelled));
        } else if (this.mDMOrderDetailBean.statusFlag == 6) {
            this.mTvCurrentState.setText(getResources().getString(R.string.orderlocked));
        } else if (this.mDMOrderDetailBean.statusFlag == 7) {
            this.mTvCurrentState.setText(getResources().getString(R.string.orderrefund));
        } else {
            this.mTvCurrentState.setText(getResources().getString(R.string.unknown));
        }
        if (StringUtils.isEmpty(this.mDMOrderDetailBean.rechargeDateTime)) {
            this.mTvTimeText.setText(getResources().getString(R.string.createtime));
            this.mTvTime.setText(this.mDMOrderDetailBean.createDateTime);
        } else {
            this.mTvTimeText.setText(getResources().getString(R.string.rechargetime));
            this.mTvTime.setText(this.mDMOrderDetailBean.rechargeDateTime);
        }
        this.mTvMoney.setText("¥" + DecimalUtil.divide(this.mDMOrderDetailBean.chargeMoney + "", "100"));
        if (StringUtils.isEmpty(this.mDMOrderDetailBean.payDateTime)) {
            this.mRelPayTime.setVisibility(8);
        } else {
            this.mTvPayTime.setText(this.mDMOrderDetailBean.payDateTime);
        }
        if (this.mDMOrderDetailBean.payFlagType == 0) {
            this.mTvPayWay.setText(getResources().getString(R.string.walletpay));
        } else if (this.mDMOrderDetailBean.payFlagType == 1) {
            this.mTvPayWay.setText(getResources().getString(R.string.weixin));
        } else if (this.mDMOrderDetailBean.payFlagType == 2) {
            this.mTvPayWay.setText(getResources().getString(R.string.alipay));
        } else if (this.mDMOrderDetailBean.payFlagType == 3) {
            this.mTvPayWay.setText(getResources().getString(R.string.unionpay));
        } else if (this.mDMOrderDetailBean.payFlagType == 4) {
            this.mTvPayWay.setText(getResources().getString(R.string.longpay));
        } else {
            this.mTvPayWay.setText(getResources().getString(R.string.unknown));
        }
        DMOrderDetailBean dMOrderDetailBean = this.mDMOrderDetailBean;
        if (dMOrderDetailBean != null) {
            switch (dMOrderDetailBean.paymentFlag) {
                case -2:
                    this.mTvPayFlag.setText(getResources().getString(R.string.freeuse));
                    break;
                case -1:
                    this.mTvPayFlag.setText(getResources().getString(R.string.fullpaydiscounts));
                    break;
                case 0:
                    this.mTvPayFlag.setText(getResources().getString(R.string.walletpay));
                    break;
                case 1:
                    this.mTvPayFlag.setText("单笔第三方支付");
                    this.mRelPayWay.setVisibility(0);
                    break;
                case 2:
                    this.mTvPayFlag.setText(getResources().getString(R.string.aggregatedpayment));
                    break;
                case 3:
                    this.mTvPayFlag.setText("一付一享");
                    this.mRelPayWay.setVisibility(0);
                    break;
                case 4:
                    this.mTvPayFlag.setText("一享一付");
                    this.mRelPayWay.setVisibility(0);
                    break;
                case 5:
                    this.mTvPayFlag.setText("支付宝水票");
                    break;
            }
        }
    }
}
