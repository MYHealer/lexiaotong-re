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
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.util.ClickUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ChangePhoneGetVerifyActivity extends BaseActivity {
    private Button mBtnGetVerification;
    private EditText mEtVerification;
    private boolean mIsEnable = true;
    private TitleBar mTitleBar;
    private TextView mTvPhone;
    private UserInfo mUserInfo;

    static {
        StubApp.interface11(10109);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ChangePhoneGetVerifyActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvPhone = (TextView) findViewById(R.id.tv_phone);
        this.mEtVerification = (EditText) findViewById(R.id.et_verification);
        this.mBtnGetVerification = (Button) findViewById(R.id.btn_getverifica);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.changephone));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public void initView() {
        this.mTvPhone.setText(this.mUserInfo.studentMobile);
    }

    private void initClickListeners() {
        findViewById(R.id.btn_getverifica).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m397xecc838a3(view);
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m398xcff3ebe4(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-ChangePhoneGetVerifyActivity, reason: not valid java name */
    /* synthetic */ void m397xecc838a3(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        showVerificationCodeDialog();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-register-ChangePhoneGetVerifyActivity, reason: not valid java name */
    /* synthetic */ void m398xcff3ebe4(View view) {
        if (isCheckVerifica()) {
            proceedToNextStep();
        }
    }

    private void showVerificationCodeDialog() {
        VerificationCodeDialog.getInstance().showDialog(getLoginAccount(), this.mTvPhone.getText().toString(), getActivity(), new VerificationCodeDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
            public void onConfirm(String str) {
                ChangePhoneGetVerifyActivity.this.getVerification(str);
            }
        });
    }

    private void proceedToNextStep() {
        ChangePhoneGetVerifyNewActivity.launch(getActivity(), this.mEtVerification.getText().toString());
        finish();
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

    private boolean isCheckVerifica() {
        if (!StringUtils.isEmpty(this.mEtVerification.getText().toString())) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入验证码");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), 120L, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                ChangePhoneGetVerifyActivity.this.mBtnGetVerification.setText("还剩" + localCountDownBean.time + "s");
                if (localCountDownBean.complete) {
                    ChangePhoneGetVerifyActivity.this.mBtnGetVerification.setEnabled(true);
                    ChangePhoneGetVerifyActivity.this.mBtnGetVerification.setText("重新获取");
                } else {
                    ChangePhoneGetVerifyActivity.this.mBtnGetVerification.setEnabled(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerification(String str) {
        V3BusinessControllers.getInstance().getMoblieMessage(getLoginAccount(), this.mTvPhone.getText().toString(), 3, str, new Listener<MobileMessageBean>() { // from class: client.android.yixiaotong.v3.ui.register.ChangePhoneGetVerifyActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ChangePhoneGetVerifyActivity.this.getActivity(), "正在获取验证码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MobileMessageBean mobileMessageBean, Object... objArr) {
                super.onComplete(controller, mobileMessageBean, objArr);
                if (ChangePhoneGetVerifyActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(ChangePhoneGetVerifyActivity.this.getContext(), "验证码已发送");
                    ChangePhoneGetVerifyActivity.this.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (ChangePhoneGetVerifyActivity.this.mIsEnable) {
                    ChangePhoneGetVerifyActivity.this.onError(clientException);
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
