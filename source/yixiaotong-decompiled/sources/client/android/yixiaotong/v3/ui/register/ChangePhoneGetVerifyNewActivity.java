package client.android.yixiaotong.v3.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.LocalControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.register.MobileMessageBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangePhoneGetVerifyNewActivity extends BaseActivity {
    private Button mBtnGetVerification;
    private EditText mEtPhone;
    private EditText mEtVerification;
    private boolean mIsEnable = true;
    private String mOldVerify;
    private TitleBar mTitleBar;
    private TextView mTvTip;

    static {
        StubApp.interface11(10116);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangePhoneGetVerifyNewActivity.class).putExtra("verify", str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvTip = (TextView) findViewById(R.id.tv_tip);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
        this.mEtVerification = (EditText) findViewById(R.id.et_verification);
        this.mBtnGetVerification = (Button) findViewById(R.id.btn_getverifica);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.changephone));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.btn_getverifica).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyNewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m399xb6d942bb(view);
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyNewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m400xd14a3bda(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-ChangePhoneGetVerifyNewActivity, reason: not valid java name */
    /* synthetic */ void m399xb6d942bb(View view) {
        handleVerificationCodeRequest();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-register-ChangePhoneGetVerifyNewActivity, reason: not valid java name */
    /* synthetic */ void m400xd14a3bda(View view) {
        handleNextStep();
    }

    private void handleVerificationCodeRequest() {
        if (!isCheckPhone() || ClickUtil.isFastDoubleClick()) {
            return;
        }
        showVerificationCodeDialog();
    }

    private void showVerificationCodeDialog() {
        VerificationCodeDialog.getInstance().showDialog(getLoginAccount(), this.mEtPhone.getText().toString(), getActivity(), new VerificationCodeDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyNewActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
            public void onConfirm(String str) {
                ChangePhoneGetVerifyNewActivity.this.getVerification(str);
            }
        });
    }

    private void handleNextStep() {
        if (isCheckVerifica()) {
            changePhone();
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
    }

    private boolean isCheckPhone() {
        if (!StringUtils.isEmpty(this.mEtPhone.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入手机号码");
        return false;
    }

    private boolean isCheckVerifica() {
        if (StringUtils.isEmpty(this.mEtPhone.getText().toString())) {
            ToastUtils.show(getContext(), "请输入手机号码");
            return false;
        }
        if (!StringUtils.isEmpty(this.mEtVerification.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入验证码");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), 120L, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyNewActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setText(ChangePhoneGetVerifyNewActivity.this.getString(R.string.remaining) + localCountDownBean.time + "s");
                if (localCountDownBean.complete) {
                    ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setEnabled(true);
                    ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setText(ChangePhoneGetVerifyNewActivity.this.getString(R.string.reget));
                } else {
                    ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setEnabled(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerification(String str) {
        V3BusinessControllers.getInstance().getMoblieMessage(getLoginAccount(), this.mEtPhone.getText().toString(), 3, str, new Listener<MobileMessageBean>() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyNewActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ChangePhoneGetVerifyNewActivity.this.getActivity(), "正在获取验证码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MobileMessageBean mobileMessageBean, Object... objArr) {
                super.onComplete(controller, mobileMessageBean, objArr);
                if (ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(ChangePhoneGetVerifyNewActivity.this.getContext(), "验证码已发送");
                    ChangePhoneGetVerifyNewActivity.this.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    ChangePhoneGetVerifyNewActivity.this.onError(clientException);
                }
            }
        });
    }

    private void changePhone() {
        V3BusinessControllers.getInstance().postStudentMobileByAuthenticationMessage(getLoginAccount(), this.mEtVerification.getText().toString(), this.mOldVerify, this.mEtPhone.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyNewActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ChangePhoneGetVerifyNewActivity.this.getActivity(), "正在更换中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(ChangePhoneGetVerifyNewActivity.this.getContext(), "更换成功，请重新登录");
                    ChangePhoneGetVerifyNewActivity.this.exitLogin();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    ChangePhoneGetVerifyNewActivity.this.onError(clientException);
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
