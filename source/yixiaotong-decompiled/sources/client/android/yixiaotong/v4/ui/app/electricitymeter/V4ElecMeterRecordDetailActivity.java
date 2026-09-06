package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v4.http.bean.V4ElecRechargeRecordDetailBean;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ElecMeterRecordDetailActivity extends BaseActivity {
    private static final String EXTRA_REFUND_BEAN = "refundBean";
    private V4ElecRechargeRecordDetailBean mElecRechargeRecordBean;
    private V4RefundDetailBean mRefundDetailBean;
    TitleBar mTitleBar;
    TextView mTvApplicant;
    TextView mTvApplicantAccount;
    TextView mTvCompletionTime;
    TextView mTvCreateTime;
    TextView mTvDeviceAddress;
    TextView mTvDeviceNo;
    TextView mTvOrderId;
    TextView mTvPayTime;
    TextView mTvPayWay;
    TextView mTvReason;
    TextView mTvRechargeMoney;
    TextView mTvRefundMoney;
    TextView mTvState;
    TextView mTvUserNo;

    static {
        StubApp.interface11(10774);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4ElecRechargeRecordDetailBean v4ElecRechargeRecordDetailBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ElecMeterRecordDetailActivity.class).putExtra("bean", v4ElecRechargeRecordDetailBean));
        }
    }

    public static void launchRefund(Activity activity, V4RefundDetailBean v4RefundDetailBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ElecMeterRecordDetailActivity.class).putExtra(EXTRA_REFUND_BEAN, v4RefundDetailBean));
        }
    }

    private void initRechargeView() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvUserNo = (TextView) findViewById(R.id.tv_userno);
        this.mTvDeviceNo = (TextView) findViewById(R.id.tv_deviceno);
        this.mTvDeviceAddress = (TextView) findViewById(R.id.tv_deviceaddress);
        this.mTvRechargeMoney = (TextView) findViewById(R.id.tv_rechargemoney);
        this.mTvCreateTime = (TextView) findViewById(R.id.tv_createtime);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_paytime);
        this.mTvPayWay = (TextView) findViewById(R.id.tv_payway);
        this.mTvCompletionTime = (TextView) findViewById(R.id.tv_completiontime);
    }

    private void initRefundView() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvRefundMoney = (TextView) findViewById(R.id.tv_refundmoney);
        this.mTvCreateTime = (TextView) findViewById(R.id.tv_createtime);
        this.mTvApplicant = (TextView) findViewById(R.id.tv_applicant);
        this.mTvApplicantAccount = (TextView) findViewById(R.id.tv_applicantaccount);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mTvReason = (TextView) findViewById(R.id.tv_reason);
    }

    private void initTitleBar(boolean z) {
        this.mTitleBar.setTitleView(getString(z ? R.string.refunddetails : R.string.rechargedetails));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void bindRechargeData() {
        this.mTvOrderId.setText(this.mElecRechargeRecordBean.orderId);
        this.mTvDeviceNo.setText(this.mElecRechargeRecordBean.mac);
        this.mTvDeviceAddress.setText(this.mElecRechargeRecordBean.address);
        this.mTvRechargeMoney.setText(getString(R.string.renminbi) + PPSLabelView.Code + this.mElecRechargeRecordBean.amount);
        this.mTvCreateTime.setText(this.mElecRechargeRecordBean.createTime);
        this.mTvPayWay.setText(this.mElecRechargeRecordBean.payMentName);
    }

    private void bindRefundData() {
        String strValueOf;
        String str = this.mRefundDetailBean.refundNo;
        if (StringUtils.isEmpty(str)) {
            str = this.mRefundDetailBean.orderId;
        }
        this.mTvOrderId.setText(str);
        if (this.mRefundDetailBean.refundAmount > 0.0d) {
            strValueOf = String.valueOf(this.mRefundDetailBean.refundAmount);
        } else {
            strValueOf = this.mRefundDetailBean.amount;
        }
        TextView textView = this.mTvRefundMoney;
        StringBuilder sbAppend = new StringBuilder().append(getString(R.string.renminbi));
        if (strValueOf == null) {
            strValueOf = "";
        }
        textView.setText(sbAppend.append(strValueOf).toString());
        this.mTvCreateTime.setText(this.mRefundDetailBean.createTime);
        this.mTvApplicant.setText(this.mRefundDetailBean.leaderName);
        this.mTvApplicantAccount.setText(this.mRefundDetailBean.leaderMobile);
        this.mTvState.setText(this.mRefundDetailBean.statusName);
        this.mTvReason.setText(this.mRefundDetailBean.reason);
    }
}
