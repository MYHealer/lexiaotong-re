package client.android.yixiaotong.v3.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.LocalControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.getserveraddress.LoginBefore;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.register.MobileMessageBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FindPswActivity extends BaseActivity {
    private Button mBtnGetVerification;
    private String mCode;
    private EditText mEtPhone;
    private EditText mEtPsw1;
    private EditText mEtPsw2;
    private EditText mEtVerification;
    private boolean mIsEnable = true;
    private int mPlatform = -1;
    private TitleBar mTitleBar;

    static {
        StubApp.interface11(10128);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) FindPswActivity.class));
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
        findViewById(R.id.btn_getverifica).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m401x8dbeb4a7(view);
            }
        });
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m402x1aabcbc6(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-FindPswActivity, reason: not valid java name */
    /* synthetic */ void m401x8dbeb4a7(View view) {
        handleVerificationCode();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-register-FindPswActivity, reason: not valid java name */
    /* synthetic */ void m402x1aabcbc6(View view) {
        handleReset();
    }

    private void handleVerificationCode() {
        if (isCheckVerifica()) {
            this.mCode = "";
            VerificationCodeDialog.getInstance().showDialog(getLoginAccount(), this.mEtPhone.getText().toString(), getActivity(), new VerificationCodeDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.1
                @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
                public void onConfirm(String str) {
                    FindPswActivity.this.mCode = str;
                    FindPswActivity.this.getSecondHost();
                }
            });
        }
    }

    private void handleReset() {
        if (isCheckInfo()) {
            int i = this.mPlatform;
            if (i == 0) {
                verifySMSCaptcha();
            } else if (i == 1) {
                resetPsw();
            } else {
                ToastUtils.show(getActivity(), "请先获取验证码");
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), 120L, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                FindPswActivity.this.mBtnGetVerification.setText("还剩" + localCountDownBean.time + "s");
                if (localCountDownBean.complete) {
                    FindPswActivity.this.mBtnGetVerification.setEnabled(true);
                    FindPswActivity.this.mBtnGetVerification.setText("重新获取");
                } else {
                    FindPswActivity.this.mBtnGetVerification.setEnabled(false);
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
    public void getNewVerification() {
        V3BusinessControllers.getInstance().getMoblieMessage(getLoginAccount(), this.mEtPhone.getText().toString(), 2, this.mCode, new Listener<MobileMessageBean>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(FindPswActivity.this.getActivity(), "正在获取验证码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MobileMessageBean mobileMessageBean, Object... objArr) {
                super.onComplete(controller, mobileMessageBean, objArr);
                if (FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(FindPswActivity.this.getContext(), "验证码已发送");
                    FindPswActivity.this.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (FindPswActivity.this.mIsEnable) {
                    FindPswActivity.this.onError(clientException);
                }
            }
        });
    }

    private void resetPsw() {
        V3BusinessControllers.getInstance().postLoginPasswordByAuthenticationMessage(getLoginAccount(), this.mEtVerification.getText().toString(), this.mEtPsw1.getText().toString(), this.mEtPhone.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(FindPswActivity.this.getActivity(), "正在修改中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(FindPswActivity.this.getContext(), "修改密码成功");
                    FindPswActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPswActivity.this.mIsEnable) {
                    FindPswActivity.this.onError(clientException);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void getSecondHost() {
        BusinessControllers.getInstance().loginBeforeGetServerAddress(getLoginAccount(), this.mEtPhone.getText().toString(), new Listener<LoginBefore>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(FindPswActivity.this.getActivity(), "正在加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LoginBefore loginBefore, Object... objArr) {
                if (FindPswActivity.this.mIsEnable) {
                    FindPswActivity.this.encryptedLoginToV3();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.getCode() == 7006) {
                        FindPswActivity.this.mPlatform = 1;
                        FindPswActivity.this.getNewVerification();
                    } else {
                        ErrorUtil.onFailResult(FindPswActivity.this.getActivity(), FindPswActivity.this.mTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void encryptedLoginToV3() {
        BusinessControllers.getInstance().encryptedLoginToV3(getLoginAccount(), this.mEtPhone.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPswActivity.this.mIsEnable) {
                    FindPswActivity.this.mPlatform = 0;
                    FindPswActivity.this.getVerifyCode();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.getCode() == 1999) {
                        FindPswActivity.this.mPlatform = 1;
                        FindPswActivity.this.getNewVerification();
                    } else {
                        ErrorUtil.onFailResult(FindPswActivity.this.getActivity(), FindPswActivity.this.mTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerifyCode() {
        BusinessControllers.getInstance().sendSMSCaptcha(getLoginAccount(), this.mEtPhone.getText().toString(), 2, null, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    FindPswActivity.this.toast("验证码已发送");
                    FindPswActivity.this.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (clientException.getCode() == 7006) {
                        FindPswActivity.this.getSecondHost();
                    } else {
                        ErrorUtil.onFailResult(FindPswActivity.this.getActivity(), FindPswActivity.this.mTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            }
        });
    }

    private void verifySMSCaptcha() {
        BusinessControllers.getInstance().verifySMSCaptcha(getLoginAccount(), this.mEtPhone.getText().toString(), this.mEtVerification.getText().toString(), 2, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPswActivity.this.mIsEnable) {
                    if (successBean.success == 1) {
                        FindPswActivity.this.resetPassword();
                    } else {
                        FindPswActivity.this.toast("验证码错误");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPswActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPswActivity.this.getActivity(), FindPswActivity.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPassword() {
        BusinessControllers.getInstance().resetLoginPassword(getLoginAccount(), this.mEtPhone.getText().toString(), this.mEtPsw1.getText().toString(), this.mEtVerification.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.FindPswActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPswActivity.this.mIsEnable) {
                    FindPswActivity.this.toast("重置登录密码成功");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPswActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPswActivity.this.getActivity(), FindPswActivity.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }
}
