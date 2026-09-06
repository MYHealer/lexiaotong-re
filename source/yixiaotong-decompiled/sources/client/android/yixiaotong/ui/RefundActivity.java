package client.android.yixiaotong.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.CrossEditText;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class RefundActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    CrossEditText mAliAccount;
    private MaterialDialog mMaterialDialog;
    CrossEditText mTelePhone;
    TitleBar mVTitleBar;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(6046);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mAliAccount = (CrossEditText) findViewById(R.id.et_aliaccount);
        this.mTelePhone = (CrossEditText) findViewById(R.id.et_phone);
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        Intent intent = new Intent(activity, (Class<?>) RefundActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        activity.startActivity(intent);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("申请退款");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public void refund(View view) {
        if (!StringUtils.isNotEmpty(this.mAliAccount.getText().toString())) {
            ToastUtils.show(getContext(), "请填写支付宝账户");
        } else if (!StringUtils.isNotEmpty(this.mTelePhone.getText().toString())) {
            ToastUtils.show(getContext(), "请填写联系电话");
        } else {
            BusinessControllers.getInstance().refund1(getLoginAccount(), this.mTelePhone.getText().toString(), this.mWalletModel.typeId, 0, this.mAliAccount.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.RefundActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    RefundActivity.this.showDialog();
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    RefundActivity.this.dismissDialog();
                    if (successBean.success != 1) {
                        ToastUtils.show(RefundActivity.this.getContext(), "提交失败,请稍候再试");
                    } else {
                        ToastUtils.show(RefundActivity.this.getContext(), "提交成功");
                        RefundActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    RefundActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(RefundActivity.this.getActivity(), clientException.getDetail());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog == null) {
                MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("连接中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.RefundActivity.2
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mMaterialDialog = null;
    }
}
