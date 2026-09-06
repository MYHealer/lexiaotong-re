package client.android.yixiaotong.v4.ui.user;

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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ChangePhoneGetVerifyNewActivity extends BaseActivity {
    private Button mBtnGetVerification;
    private EditText mEtPhone;
    private EditText mEtVerification;
    private boolean mIsEnable = true;
    private String mOldVerify;
    private TitleBar mTitleBar;
    private TextView mTvTip;

    static {
        StubApp.interface11(11035);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ChangePhoneGetVerifyNewActivity.class));
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
        findViewById(R.id.btn_getverifica).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangePhoneGetVerifyNewActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m543xbd0c1686(view);
            }
        });
        findViewById(R.id.btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangePhoneGetVerifyNewActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m544x3f56cb65(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-user-V4ChangePhoneGetVerifyNewActivity, reason: not valid java name */
    /* synthetic */ void m543xbd0c1686(View view) {
        if (!isCheckPhone() || ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4VerificationCodeDialog.getInstance().showDialog(getLoginAccount(), this.mEtPhone.getText().toString(), getActivity(), new V4VerificationCodeDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangePhoneGetVerifyNewActivity.1
            @Override // client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.Listener
            public void onConfirm(String str, String str2) {
                V4ChangePhoneGetVerifyNewActivity.this.getVerification(str, str2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-user-V4ChangePhoneGetVerifyNewActivity, reason: not valid java name */
    /* synthetic */ void m544x3f56cb65(View view) {
        if (isCheckVerifica()) {
            changePhone();
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
        V4ErrorControlUtil.getInstance().onPause();
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
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), 120L, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangePhoneGetVerifyNewActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                V4ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setText(V4ChangePhoneGetVerifyNewActivity.this.getString(R.string.remaining) + localCountDownBean.time + "s");
                if (localCountDownBean.complete) {
                    V4ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setEnabled(true);
                    V4ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setText(V4ChangePhoneGetVerifyNewActivity.this.getString(R.string.reget));
                } else {
                    V4ChangePhoneGetVerifyNewActivity.this.mBtnGetVerification.setEnabled(false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerification(String str, String str2) {
        V4BusinessControllers.getInstance().postSendSmsCode(getLoginAccount(), this.mEtPhone.getText().toString(), str, str2, V4UserInfoUtil.getInstance().getLoginAccountV4().token, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangePhoneGetVerifyNewActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4ChangePhoneGetVerifyNewActivity.this.getActivity(), "正在获取验证码.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                super.onComplete(controller, successBean, objArr);
                if (V4ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4ChangePhoneGetVerifyNewActivity.this.getContext(), "验证码已发送");
                    V4ChangePhoneGetVerifyNewActivity.this.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (V4ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    V4ChangePhoneGetVerifyNewActivity.this.onError(clientException);
                }
            }
        });
    }

    private void changePhone() {
        V4BusinessControllers.getInstance().postUpdateMobile(getLoginAccount(), this.mEtPhone.getText().toString(), this.mEtVerification.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4ChangePhoneGetVerifyNewActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4ChangePhoneGetVerifyNewActivity.this.getActivity(), "正在更换中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V4ChangePhoneGetVerifyNewActivity.this.getContext(), "更换成功，请重新登录");
                    V4ChangePhoneGetVerifyNewActivity.this.exitLogin();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ChangePhoneGetVerifyNewActivity.this.mIsEnable) {
                    V4ChangePhoneGetVerifyNewActivity.this.onError(clientException);
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
