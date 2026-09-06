package client.android.yixiaotong.v3.ui.appcontrol.electricitymeter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.v3.bean.elecmeter.ElecRechargeRecordBean;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ElecMeterRecordDetailActivity extends BaseActivity {
    private static final String TAG = "ElecMeterRecordDetailActivity";
    private ElecRechargeRecordBean mElecRechargeRecordBean;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;
    private TextView mTvCompletionTime;
    private TextView mTvCreateTime;
    private TextView mTvDeviceNo;
    private TextView mTvOrderId;
    private TextView mTvPayTime;
    private TextView mTvPayWay;
    private TextView mTvRechargeMoney;
    private TextView mTvState;
    private TextView mTvUserNo;

    static {
        StubApp.interface11(9348);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, ElecRechargeRecordBean elecRechargeRecordBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ElecMeterRecordDetailActivity.class).putExtra("bean", elecRechargeRecordBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mTvUserNo = (TextView) findViewById(R.id.tv_userno);
        this.mTvDeviceNo = (TextView) findViewById(R.id.tv_deviceno);
        this.mTvRechargeMoney = (TextView) findViewById(R.id.tv_rechargemoney);
        this.mTvCreateTime = (TextView) findViewById(R.id.tv_createtime);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_paytime);
        this.mTvPayWay = (TextView) findViewById(R.id.tv_payway);
        this.mTvCompletionTime = (TextView) findViewById(R.id.tv_completiontime);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.detail1));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mTvOrderId.setText(this.mElecRechargeRecordBean.id);
        this.mTvState.setText(getString(R.string.payed));
        if (this.mElecRechargeRecordBean.appendStatus == 4) {
            this.mTvState.setText(getString(R.string.refunding));
        } else if (this.mElecRechargeRecordBean.appendStatus == 5) {
            this.mTvState.setText(getString(R.string.refundsuccessful));
        }
        this.mTvUserNo.setText(this.mElecRechargeRecordBean.houseHoldId);
        this.mTvDeviceNo.setText(this.mElecRechargeRecordBean.machineId);
        this.mTvRechargeMoney.setText(getString(R.string.renminbi) + PPSLabelView.Code + DecimalUtil.divide(this.mElecRechargeRecordBean.price + "", "100"));
        this.mTvCreateTime.setText(this.mElecRechargeRecordBean.createDatetime);
        this.mTvPayTime.setText(this.mElecRechargeRecordBean.paySuccessDatetime);
        this.mTvCompletionTime.setText(this.mElecRechargeRecordBean.appendSuccessDatetime);
        if (this.mElecRechargeRecordBean.payFlagType == 1) {
            this.mTvPayWay.setText(getString(R.string.weixin));
            return;
        }
        if (this.mElecRechargeRecordBean.payFlagType == 2) {
            this.mTvPayWay.setText(getString(R.string.alipay));
            return;
        }
        if (this.mElecRechargeRecordBean.payFlagType == 3) {
            this.mTvPayWay.setText(getString(R.string.unionpay));
            return;
        }
        if (this.mElecRechargeRecordBean.payFlagType == 4) {
            this.mTvPayWay.setText(getString(R.string.longpay));
            return;
        }
        if (this.mElecRechargeRecordBean.payFlagType == 12) {
            this.mTvPayWay.setText(getString(R.string.icbc));
        } else if (this.mElecRechargeRecordBean.payFlagType == 21) {
            this.mTvPayWay.setText(getString(R.string.yulinonecard));
        } else {
            this.mTvPayWay.setText(getString(R.string.unknown));
        }
    }
}
