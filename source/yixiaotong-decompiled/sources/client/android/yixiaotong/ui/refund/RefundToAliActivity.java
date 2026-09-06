package client.android.yixiaotong.ui.refund;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.RefundDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RefundToAliActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    EditText mEtAliAccount;
    EditText mEtName;
    EditText mEtPhone;
    private boolean mIsEnable = true;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(7564);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
        this.mEtName = (EditText) findViewById(R.id.et_name);
        this.mEtAliAccount = (EditText) findViewById(R.id.et_aliaccount);
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        Intent intent = new Intent(activity, (Class<?>) RefundToAliActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("申请退款");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
        this.mVTitleBar.setRightView("退款规则");
        this.mVTitleBar.setRightViewTextColor(getResources().getColor(R.color.ff222222));
        this.mVTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.refund.RefundToAliActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                RefundDialog.getInstance().showTipTimeOutDialog(RefundToAliActivity.this.getActivity());
            }
        });
    }

    private void initView() {
        this.mEtPhone.setText(getLoginAccount().getAccountManagetStore().getUserInfo().LoginAccount);
        this.mEtName.requestFocus();
        this.mEtName.setFocusable(true);
    }

    private void initClickListeners() {
        findViewById(R.id.btn_refund).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.refund.RefundToAliActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m173x92210640(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-refund-RefundToAliActivity, reason: not valid java name */
    /* synthetic */ void m173x92210640(View view) {
        refund();
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private boolean check() {
        if (!StringUtils.isNotEmpty(this.mEtPhone.getText().toString())) {
            ToastUtils.show(getContext(), "请输入手机号");
            return false;
        }
        if (!StringUtils.isNotEmpty(this.mEtName.getText().toString())) {
            ToastUtils.show(getContext(), "请输入姓名");
            return false;
        }
        if (StringUtils.isNotEmpty(this.mEtAliAccount.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入支付宝账号");
        return false;
    }

    public void refund() {
        if (check()) {
            BusinessControllers.getInstance().refund2(getLoginAccount(), getLoginAccount().getAccountManagetStore().getUserInfo().LoginAccount, this.mWalletModel.typeId, 0, this.mEtAliAccount.getText().toString(), "", this.mEtName.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.refund.RefundToAliActivity.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (RefundToAliActivity.this.mIsEnable) {
                        if (successBean.success != 1) {
                            SystemErrorTip.getInstance().showTipDialog(RefundToAliActivity.this.getActivity(), "提交失败,请稍候再试");
                        } else {
                            SystemErrorTip.getInstance().showTipDialog(RefundToAliActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.refund.RefundToAliActivity.2.1
                                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                                public void onConfirm() {
                                    RefundToAliActivity.this.finish();
                                }
                            }, "提交成功");
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (RefundToAliActivity.this.mIsEnable) {
                        ErrorUtil.onFailResult(RefundToAliActivity.this.getActivity(), RefundToAliActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            });
        }
    }
}
