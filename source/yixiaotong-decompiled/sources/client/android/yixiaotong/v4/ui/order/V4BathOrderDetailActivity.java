package client.android.yixiaotong.v4.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4BathConsumeDetailBean;
import client.android.yixiaotong.v4.http.bean.V4BathRecordBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BathOrderDetailActivity extends BaseActivity {
    private static final String TAG = "OrderDetailActivity";
    private boolean mIsEnable = true;
    private V4BathRecordBean mOrderDetailBean;
    private String mOrderId;
    RelativeLayout mRelAlipayDiscount;
    RelativeLayout mRelDeviceName;
    RelativeLayout mRelDiscount;
    RelativeLayout mRelMode;
    TitleBar mTitleBar;
    TextView mTvAddress;
    TextView mTvAlipayDiscount;
    TextView mTvConsumeMoney;
    TextView mTvConsumeTime;
    TextView mTvDeviceMac;
    TextView mTvDeviceName;
    TextView mTvDiscountAmount;
    TextView mTvMode;
    TextView mTvModeText;
    TextView mTvOrderId;
    TextView mTvPayMoney;
    TextView mTvPayTime;
    TextView mTvPayway;

    static {
        StubApp.interface11(10945);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4BathRecordBean v4BathRecordBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4BathOrderDetailActivity.class).putExtra("bean", v4BathRecordBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvOrderId = (TextView) findViewById(R.id.tv_orderid);
        this.mTvConsumeTime = (TextView) findViewById(R.id.tv_consumetime);
        this.mRelDeviceName = (RelativeLayout) findViewById(R.id.rel_devicename);
        this.mTvDeviceName = (TextView) findViewById(R.id.tv_devicename);
        this.mTvDeviceMac = (TextView) findViewById(R.id.tv_devicemac);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mRelMode = (RelativeLayout) findViewById(R.id.rel_mode);
        this.mTvModeText = (TextView) findViewById(R.id.tv_modetext);
        this.mTvMode = (TextView) findViewById(R.id.tv_mode);
        this.mTvConsumeMoney = (TextView) findViewById(R.id.tv_consumemoney);
        this.mRelDiscount = (RelativeLayout) findViewById(R.id.rel_discount);
        this.mTvDiscountAmount = (TextView) findViewById(R.id.tv_discountamount);
        this.mTvPayMoney = (TextView) findViewById(R.id.paymoney);
        this.mRelAlipayDiscount = (RelativeLayout) findViewById(R.id.rel_alipay_discount);
        this.mTvAlipayDiscount = (TextView) findViewById(R.id.tv_alipay_discount);
        this.mTvPayTime = (TextView) findViewById(R.id.tv_paytime);
        this.mTvPayway = (TextView) findViewById(R.id.tv_payway);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.orderdetails));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        V4BathRecordBean v4BathRecordBean = this.mOrderDetailBean;
        if (v4BathRecordBean != null) {
            this.mOrderId = v4BathRecordBean.consumeOrderId;
            this.mTvOrderId.setText(this.mOrderId + "  " + this.mOrderDetailBean.payName);
            this.mTvConsumeTime.setText(this.mOrderDetailBean.useTime);
            this.mTvConsumeMoney.setText(getString(R.string.renminbi) + this.mOrderDetailBean.consume);
            this.mTvPayMoney.setText(getString(R.string.renminbi) + this.mOrderDetailBean.consume);
            this.mTvPayTime.setText(this.mOrderDetailBean.useTime);
            this.mTvDeviceName.setText(this.mOrderDetailBean.deviceName);
            this.mTvDeviceMac.setText(this.mOrderDetailBean.mac);
            this.mTvAddress.setText(this.mOrderDetailBean.address);
            if (StringUtils.isNotEmpty(this.mOrderDetailBean.consumeDeductBankName)) {
                this.mTvPayway.setText(this.mOrderDetailBean.consumeDeductBankName);
            }
            if (this.mOrderDetailBean.hasAlipayTap) {
                getConsumeDetail();
            }
        }
    }

    private void getConsumeDetail() {
        V4BusinessControllers.getInstance().getConsumeDetail(getLoginAccount(), this.mOrderId, new Listener<V4BathConsumeDetailBean>() { // from class: client.android.yixiaotong.v4.ui.order.V4BathOrderDetailActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BathConsumeDetailBean v4BathConsumeDetailBean, Object... objArr) {
                if (!V4BathOrderDetailActivity.this.mIsEnable || v4BathConsumeDetailBean == null) {
                    return;
                }
                V4BathOrderDetailActivity.this.mTvPayMoney.setText(V4BathOrderDetailActivity.this.getString(R.string.renminbi) + v4BathConsumeDetailBean.amount);
                V4BathOrderDetailActivity.this.mRelAlipayDiscount.setVisibility(0);
                V4BathOrderDetailActivity.this.mTvAlipayDiscount.setText("-¥ " + v4BathConsumeDetailBean.discountAmount);
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }
}
