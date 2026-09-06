package client.android.yixiaotong.v3.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import com.huawei.hms.mlplugin.card.bcr.MLBcrCaptureConfig;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangeLoginPswActivity extends BaseActivity {
    private EditText mEtNewPsw1;
    private EditText mEtNewPsw2;
    private EditText mEtOldPsw;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(MLBcrCaptureConfig.ERROR_CODE_INIT_CAMERA_FAILED);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangeLoginPswActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtOldPsw = (EditText) findViewById(R.id.et_oldpsw);
        this.mEtNewPsw1 = (EditText) findViewById(R.id.et_newpsw1);
        this.mEtNewPsw2 = (EditText) findViewById(R.id.et_newpsw2);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.changeloginpsw));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.ChangeLoginPswActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m395x82b645ed(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-ChangeLoginPswActivity, reason: not valid java name */
    /* synthetic */ void m395x82b645ed(View view) {
        if (isCheckInfo()) {
            resetPsw();
        }
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
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    private boolean isCheckInfo() {
        if (StringUtils.isEmpty(this.mEtOldPsw.getText().toString())) {
            ToastUtils.show(getContext(), "请输入旧密码");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtNewPsw1.getText().toString())) {
            ToastUtils.show(getContext(), "请输入新密码");
            return false;
        }
        if (this.mEtNewPsw1.getText().toString().length() < 6) {
            ToastUtils.show(getContext(), "密码长度是6-18位");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtNewPsw2.getText().toString())) {
            ToastUtils.show(getContext(), "请输入确认密码");
            return false;
        }
        if (this.mEtNewPsw2.getText().toString().length() < 6) {
            ToastUtils.show(getContext(), "密码长度是6-18位");
            return false;
        }
        if (this.mEtNewPsw1.getText().toString().equals(this.mEtNewPsw2.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "密码与确认密码不一致");
        return false;
    }

    private void resetPsw() {
        V3BusinessControllers.getInstance().postResetLoginPassword(getLoginAccount(), this.mEtNewPsw1.getText().toString(), this.mEtOldPsw.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.ChangeLoginPswActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ChangeLoginPswActivity.this.getActivity(), "正在修改密码中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (ChangeLoginPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(ChangeLoginPswActivity.this.getContext(), "修改密码成功，请重新登录");
                    ChangeLoginPswActivity.this.finish();
                    ChangeLoginPswActivity.this.exitLogin();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ChangeLoginPswActivity.this.mIsEnable) {
                    ChangeLoginPswActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }
}
