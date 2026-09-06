package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.RefundBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RefundProgressActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    ImageView mImg2;
    private boolean mIsEnable;
    private MaterialDialog mMaterialDialog;
    TextView mTvBalance;
    TextView mTvContent;
    TextView mTvContent2;
    TextView mTvDate;
    TextView mTvDate2;
    TextView mTvDate3;
    TextView mTvSuccess;
    TextView mTvTime;
    TextView mTvTime2;
    TextView mTvTime3;
    View mVLine2;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    ImageView viewEnd;

    static {
        StubApp.interface11(6049);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvDate = (TextView) findViewById(R.id.tv_date);
        this.mTvTime = (TextView) findViewById(R.id.tv_time);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.mTvDate2 = (TextView) findViewById(R.id.tv_date2);
        this.mTvTime2 = (TextView) findViewById(R.id.tv_time2);
        this.mTvDate3 = (TextView) findViewById(R.id.tv_date3);
        this.mTvTime3 = (TextView) findViewById(R.id.tv_time3);
        this.viewEnd = (ImageView) findViewById(R.id.view3);
        this.mImg2 = (ImageView) findViewById(R.id.img2);
        this.mTvSuccess = (TextView) findViewById(R.id.tv_text3);
        this.mVLine2 = findViewById(R.id.view2);
        this.mTvContent = (TextView) findViewById(R.id.tv_content);
        this.mTvContent2 = (TextView) findViewById(R.id.tv_content2);
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        Intent intent = new Intent(activity, (Class<?>) RefundProgressActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        activity.startActivity(intent);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.RefundProgressActivity$1, reason: invalid class name */
    class AnonymousClass1 extends Listener<RefundBean> {
        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
            RefundProgressActivity.this.showDialog();
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, RefundBean refundBean, Object... objArr) {
            if (RefundProgressActivity.this.mIsEnable) {
                RefundProgressActivity.this.dismissDialog();
                if (refundBean != null) {
                    if (refundBean.Status == 0) {
                        if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                            RefundProgressActivity.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                        }
                        RefundProgressActivity.this.mTvBalance.setText(refundBean.refund + "");
                        return;
                    }
                    if (refundBean.Status == 1) {
                        if (refundBean.isRefundToAccount == 1) {
                            RefundProgressActivity.this.mTvBalance.setText(refundBean.refund + "");
                            if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                                RefundProgressActivity.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                                RefundProgressActivity.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                            }
                            if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                                RefundProgressActivity.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                                RefundProgressActivity.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                            }
                            RefundProgressActivity.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                            RefundProgressActivity.this.mTvContent.setVisibility(0);
                            RefundProgressActivity.this.mTvContent2.setVisibility(0);
                            return;
                        }
                        RefundProgressActivity.this.mTvBalance.setText(refundBean.refund + "");
                        RefundProgressActivity.this.mTvSuccess.setVisibility(0);
                        RefundProgressActivity.this.mTvSuccess.setText("审核成功");
                        if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                            RefundProgressActivity.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            RefundProgressActivity.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            RefundProgressActivity.this.mTvDate3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        RefundProgressActivity.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                        RefundProgressActivity.this.viewEnd.setImageResource(R.mipmap.l_refund_start);
                        RefundProgressActivity.this.mVLine2.setBackgroundColor(RefundProgressActivity.this.getResources().getColor(R.color.theme_title_color1));
                        RefundProgressActivity.this.mTvContent2.setVisibility(0);
                        return;
                    }
                    if (refundBean.Status == 2) {
                        RefundProgressActivity.this.mTvSuccess.setVisibility(0);
                        RefundProgressActivity.this.mTvSuccess.setText("退款失败");
                        RefundProgressActivity.this.mTvBalance.setText(refundBean.refund + "");
                        if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                            RefundProgressActivity.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            RefundProgressActivity.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            RefundProgressActivity.this.mTvDate3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        RefundProgressActivity.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                        RefundProgressActivity.this.viewEnd.setImageResource(R.mipmap.l_refundfail);
                        RefundProgressActivity.this.mVLine2.setBackgroundColor(RefundProgressActivity.this.getResources().getColor(R.color.theme_title_color1));
                        RefundProgressActivity.this.mTvContent.setVisibility(0);
                        RefundProgressActivity.this.mTvContent.setText("请前去“充值中心”退款记录查看具体详情");
                        return;
                    }
                    if (refundBean.Status == 3) {
                        RefundProgressActivity.this.mTvSuccess.setVisibility(0);
                        if (refundBean.isRefundToAccount == 1) {
                            RefundProgressActivity.this.mTvSuccess.setText("成功到账");
                            RefundProgressActivity.this.mTvContent.setVisibility(0);
                            RefundProgressActivity.this.mTvContent.setText("您提交的退款已成功到账");
                        } else {
                            RefundProgressActivity.this.mTvSuccess.setText("退款成功");
                            RefundProgressActivity.this.mTvContent.setVisibility(0);
                            RefundProgressActivity.this.mTvContent.setText("已退款，请及时关注账户资金变化（约3至7个工作日到账）");
                            RefundProgressActivity.this.mTvContent2.setVisibility(0);
                        }
                        RefundProgressActivity.this.mTvBalance.setText(refundBean.refund + "");
                        if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                            RefundProgressActivity.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            RefundProgressActivity.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.refundCompletionTime)) {
                            RefundProgressActivity.this.mTvDate3.setText(refundBean.refundCompletionTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime3.setText(refundBean.refundCompletionTime.split(PPSLabelView.Code)[1]);
                        }
                        RefundProgressActivity.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                        RefundProgressActivity.this.viewEnd.setImageResource(R.mipmap.l_refund_start);
                        RefundProgressActivity.this.mVLine2.setBackgroundColor(RefundProgressActivity.this.getResources().getColor(R.color.theme_title_color1));
                        return;
                    }
                    if (refundBean.Status == 4) {
                        RefundProgressActivity.this.mTvSuccess.setVisibility(0);
                        RefundProgressActivity.this.mTvSuccess.setText("退款失败");
                        RefundProgressActivity.this.mTvBalance.setText(refundBean.refund + "");
                        if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                            RefundProgressActivity.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            RefundProgressActivity.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            RefundProgressActivity.this.mTvDate3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            RefundProgressActivity.this.mTvTime3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        RefundProgressActivity.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                        RefundProgressActivity.this.viewEnd.setImageResource(R.mipmap.l_refundfail);
                        RefundProgressActivity.this.mVLine2.setBackgroundColor(RefundProgressActivity.this.getResources().getColor(R.color.theme_title_color1));
                        RefundProgressActivity.this.mTvContent.setVisibility(0);
                        RefundProgressActivity.this.mTvContent.setText("请前去“充值中心”退款记录查看具体详情");
                    }
                }
            }
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, ClientException clientException) {
            if (RefundProgressActivity.this.mIsEnable) {
                RefundProgressActivity.this.dismissDialog();
                ErrorUtil.onFailResult(RefundProgressActivity.this.getActivity(), RefundProgressActivity.this.mVTitleBar.getTitleViewContent(), clientException, true);
            }
        }
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("退款信息");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog == null) {
                MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("连接中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.RefundProgressActivity.2
                    @Override // android.content.DialogInterface.OnDismissListener
                    public void onDismiss(DialogInterface dialogInterface) {
                        BluetoothManager.getInstance().disConnectAll();
                    }
                }).show();
                this.mMaterialDialog = materialDialogShow;
                materialDialogShow.setCanceledOnTouchOutside(false);
            } else if (!materialDialog.isShowing()) {
                this.mMaterialDialog.show();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        try {
            if (isDialogShowing()) {
                this.mMaterialDialog.dismiss();
                this.mMaterialDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    private boolean isDialogShowing() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }
}
