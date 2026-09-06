package client.android.yixiaotong.v4.ui.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4RefundDetailBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4WalletRefundDetailActivity extends BaseActivity {
    private Button mBtnRefund;
    private TitleBar mTitleBar;
    private TextView mTvReason;
    private TextView mTvRefundMoney;
    private TextView mTvRefundReason;
    private TextView mTvState;
    private TextView mTvTime;
    private V4RefundDetailBean mV4RefundDetailBean;
    private int mType = 1;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(10995);
    }

    private String getContent(int i) {
        if (i == 0) {
            return "待审核";
        }
        if (i == 1) {
            return "已退款";
        }
        if (i == 2) {
            return "审核不通过";
        }
        return i == 3 ? "退款中" : "";
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, V4RefundDetailBean v4RefundDetailBean, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4WalletRefundDetailActivity.class).putExtra("bean", v4RefundDetailBean).putExtra("type", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvRefundMoney = (TextView) findViewById(R.id.tv_refundmoney);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvState = (TextView) findViewById(R.id.tv_state);
        this.mTvRefundReason = (TextView) findViewById(R.id.tv_refundreason);
        this.mTvReason = (TextView) findViewById(R.id.tv_reason);
        this.mBtnRefund = (Button) findViewById(R.id.btn_refund);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.refunddetails));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        if (this.mType == 2) {
            this.mTvRefundMoney.setText(this.mTvRefundMoney.getText().toString() + formatRefundAmount(this.mV4RefundDetailBean));
            this.mTvTime.setText(this.mV4RefundDetailBean.createTime);
            this.mTvRefundReason.setText(this.mV4RefundDetailBean.rejectReason);
            this.mTvReason.setText(this.mV4RefundDetailBean.reason);
            this.mTvState.setText(this.mV4RefundDetailBean.statusName);
        } else {
            this.mTvRefundMoney.setText(this.mTvRefundMoney.getText().toString() + this.mV4RefundDetailBean.amount);
            this.mTvTime.setText(this.mV4RefundDetailBean.submitTime);
            this.mTvRefundReason.setText(this.mV4RefundDetailBean.rejectReason);
            this.mTvReason.setText(this.mV4RefundDetailBean.reason);
            this.mTvState.setText(this.mV4RefundDetailBean.statusName);
        }
        if (this.mV4RefundDetailBean.status == 0) {
            this.mBtnRefund.setText("取消退款");
        } else if (this.mV4RefundDetailBean.status == 2 && this.mType != 2) {
            this.mBtnRefund.setText("再次提交");
        } else {
            this.mBtnRefund.setVisibility(8);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.order.V4WalletRefundDetailActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtil.isFastDoubleClick()) {
                    return;
                }
                if (V4WalletRefundDetailActivity.this.mV4RefundDetailBean.status != 0) {
                    if (V4WalletRefundDetailActivity.this.mV4RefundDetailBean.status == 2) {
                        V4WalletRefundDetailActivity.this.postAgainSubmitRefund();
                        return;
                    }
                    return;
                }
                V4WalletRefundDetailActivity.this.postCancelRefund();
            }
        });
    }

    public void postAgainSubmitRefund() {
        V4BusinessControllers.getInstance().postAgainSubmitRefund(getLoginAccount(), this.mV4RefundDetailBean.refId, new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.order.V4WalletRefundDetailActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4WalletRefundDetailActivity.this.getActivity(), "提交中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                super.onComplete(controller, str, objArr);
                if (V4WalletRefundDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4WalletRefundDetailActivity.this.getActivity(), "提交成功");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4WalletRefundDetailActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4WalletRefundDetailActivity.this.getActivity(), false);
                }
            }
        });
    }

    public void postCancelRefund() {
        String str = this.mV4RefundDetailBean.rejectReason;
        if (StringUtils.isEmpty(str)) {
            str = "无";
        }
        String str2 = str;
        String str3 = this.mV4RefundDetailBean.refId;
        if (this.mType == 2) {
            str3 = this.mV4RefundDetailBean.refundId;
        }
        V4BusinessControllers.getInstance().postCancelRefund(getLoginAccount(), str3, str2, this.mType, new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.order.V4WalletRefundDetailActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(V4WalletRefundDetailActivity.this.getActivity(), "取消退款中", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str4, Object... objArr) {
                super.onComplete(controller, str4, objArr);
                if (V4WalletRefundDetailActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4WalletRefundDetailActivity.this.getActivity(), "取消成功");
                    V4WalletRefundDetailActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4WalletRefundDetailActivity.this.mIsEnable) {
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4WalletRefundDetailActivity.this.getActivity(), false);
                }
            }
        });
    }

    private String formatRefundAmount(V4RefundDetailBean v4RefundDetailBean) {
        if (v4RefundDetailBean.refundAmount > 0.0d) {
            return String.valueOf(v4RefundDetailBean.refundAmount);
        }
        return v4RefundDetailBean.amount == null ? "" : v4RefundDetailBean.amount;
    }
}
