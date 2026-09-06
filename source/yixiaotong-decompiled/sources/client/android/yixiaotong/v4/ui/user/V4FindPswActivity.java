package client.android.yixiaotong.v4.ui.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.LocalControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4FindPswActivity extends BaseActivity {
    private Button mBtnGetVerification;
    private EditText mEtPhone;
    private EditText mEtPsw1;
    private EditText mEtPsw2;
    private EditText mEtVerification;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(11055);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4FindPswActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
        this.mEtVerification = (EditText) findViewById(R.id.et_verification);
        this.mBtnGetVerification = (Button) findViewById(R.id.btn_getverifica);
        this.mEtPsw1 = (EditText) findViewById(R.id.et_psw1);
        this.mEtPsw2 = (EditText) findViewById(R.id.et_psw2);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.forgotpass));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_getverifica).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4FindPswActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m547xbff07e72(view);
            }
        });
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4FindPswActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m548xc126d151(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-user-V4FindPswActivity, reason: not valid java name */
    /* synthetic */ void m547xbff07e72(View view) {
        if (isCheckVerifica()) {
            V4VerificationCodeDialog.getInstance().showDialog(getLoginAccount(), this.mEtPhone.getText().toString(), getActivity(), new V4VerificationCodeDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.user.V4FindPswActivity.1
                @Override // client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.Listener
                public void onConfirm(String str, String str2) {
                    V4FindPswActivity.this.getVerification(str, str2);
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-user-V4FindPswActivity, reason: not valid java name */
    /* synthetic */ void m548xc126d151(View view) {
        if (isCheckInfo()) {
            resetPsw();
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), 120L, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4FindPswActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                V4FindPswActivity.this.mBtnGetVerification.setText(V4FindPswActivity.this.getString(R.string.remaining) + localCountDownBean.time + "s");
                if (localCountDownBean.complete) {
                    V4FindPswActivity.this.mBtnGetVerification.setEnabled(true);
                    V4FindPswActivity.this.mBtnGetVerification.setText(V4FindPswActivity.this.getString(R.string.reget));
                } else {
                    V4FindPswActivity.this.mBtnGetVerification.setEnabled(false);
                }
            }
        });
    }

    private boolean isCheckVerifica() {
        if (!StringUtils.isEmpty(this.mEtPhone.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入手机号");
        return false;
    }

    private boolean isCheckInfo() {
        if (StringUtils.isEmpty(this.mEtPhone.getText().toString())) {
            ToastUtils.show(getContext(), "请输入手机号");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtVerification.getText().toString())) {
            ToastUtils.show(getContext(), "请输入验证码");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtPsw1.getText().toString())) {
            ToastUtils.show(getContext(), "请输入密码");
            return false;
        }
        if (this.mEtPsw1.getText().toString().length() < 6) {
            ToastUtils.show(getContext(), "密码长度是6-18位");
            return false;
        }
        if (StringUtils.isEmpty(this.mEtPsw2.getText().toString())) {
            ToastUtils.show(getContext(), "请输入确认密码");
            return false;
        }
        if (this.mEtPsw2.getText().toString().length() < 6) {
            ToastUtils.show(getContext(), "密码长度是6-18位");
            return false;
        }
        if (this.mEtPsw1.getText().toString().equals(this.mEtPsw2.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "密码与确认密码不一致");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerification(String str, String str2) {
        V4BusinessControllers.getInstance().postSendSmsCode(getLoginAccount(), this.mEtPhone.getText().toString(), str, str2, "", new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4FindPswActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4FindPswActivity.this.getActivity(), "正在获取验证码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (V4FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4FindPswActivity.this.getContext(), "验证码已发送");
                    V4FindPswActivity.this.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4FindPswActivity.this.mIsEnable) {
                    V4FindPswActivity.this.onError(clientException);
                }
            }
        });
    }

    private void resetPsw() {
        V4BusinessControllers.getInstance().postResetPassword(getLoginAccount(), this.mEtPhone.getText().toString(), this.mEtVerification.getText().toString(), this.mEtPsw1.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4FindPswActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4FindPswActivity.this.getActivity(), "正在修改中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4FindPswActivity.this.getContext(), "修改密码成功");
                    V4FindPswActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4FindPswActivity.this.mIsEnable) {
                    V4FindPswActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }
}
