package client.android.yixiaotong.v4.ui.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.LocalControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.PrivacyPolicyActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.about.LicenseV3Activity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4UserRegisterActivity extends BaseActivity {
    private Button mBtnGetVerification;
    private EditText mEtPhone;
    private EditText mEtPsw1;
    private EditText mEtStudentName;
    private EditText mEtVerification;
    private ImageView mImgAgree;
    private TitleBar mTitleBar;
    private TextView mTvSchoolName;
    private boolean mIsEnable = true;
    private boolean mIsAgree = false;
    private String mCustomerId = "";
    private String mCustomerName = "";

    static {
        StubApp.interface11(11104);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4UserRegisterActivity.class).putExtra("customerid", str).putExtra("cistomername", str2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvSchoolName = (TextView) findViewById(R.id.tv_schoolname);
        this.mEtPhone = (EditText) findViewById(R.id.et_phone);
        this.mEtVerification = (EditText) findViewById(R.id.et_verification);
        this.mBtnGetVerification = (Button) findViewById(R.id.btn_getverifica);
        this.mEtPsw1 = (EditText) findViewById(R.id.et_psw1);
        this.mEtStudentName = (EditText) findViewById(R.id.et_psw2);
        this.mImgAgree = (ImageView) findViewById(R.id.iv_agree);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.login_register));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m554x2e2429d5(view);
            }
        });
        findViewById(R.id.btn_getverifica).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m555xe899ca56(view);
            }
        });
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m556xa30f6ad7(view);
            }
        });
        findViewById(R.id.btn_hasaccount).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m557x5d850b58(view);
            }
        });
        findViewById(R.id.tv_agree1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m558x17faabd9(view);
            }
        });
        findViewById(R.id.tv_agree2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m559xd2704c5a(view);
            }
        });
        findViewById(R.id.iv_agree).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m560x8ce5ecdb(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-user-V4UserRegisterActivity, reason: not valid java name */
    /* synthetic */ void m554x2e2429d5(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-user-V4UserRegisterActivity, reason: not valid java name */
    /* synthetic */ void m555xe899ca56(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4VerificationCodeDialog.getInstance().showDialog(getLoginAccount(), this.mEtPhone.getText().toString(), getActivity(), new V4VerificationCodeDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity.1
            @Override // client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v4.ui.dialog.V4VerificationCodeDialog.Listener
            public void onConfirm(String str, String str2) {
                V4UserRegisterActivity.this.getVerification(str, str2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-user-V4UserRegisterActivity, reason: not valid java name */
    /* synthetic */ void m556xa30f6ad7(View view) {
        register();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-user-V4UserRegisterActivity, reason: not valid java name */
    /* synthetic */ void m557x5d850b58(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v4-ui-user-V4UserRegisterActivity, reason: not valid java name */
    /* synthetic */ void m558x17faabd9(View view) {
        LicenseV3Activity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v4-ui-user-V4UserRegisterActivity, reason: not valid java name */
    /* synthetic */ void m559xd2704c5a(View view) {
        PrivacyPolicyActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v4-ui-user-V4UserRegisterActivity, reason: not valid java name */
    /* synthetic */ void m560x8ce5ecdb(View view) {
        if (this.mIsAgree) {
            this.mIsAgree = false;
            this.mImgAgree.setImageResource(R.mipmap.wxz);
        } else {
            this.mIsAgree = true;
            this.mImgAgree.setImageResource(R.mipmap.xz1);
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
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), 120L, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                V4UserRegisterActivity.this.mBtnGetVerification.setText(V4UserRegisterActivity.this.getString(R.string.remaining) + localCountDownBean.time + "s");
                if (localCountDownBean.complete) {
                    V4UserRegisterActivity.this.mBtnGetVerification.setEnabled(true);
                    V4UserRegisterActivity.this.mBtnGetVerification.setText(V4UserRegisterActivity.this.getString(R.string.reget));
                } else {
                    V4UserRegisterActivity.this.mBtnGetVerification.setEnabled(false);
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
        if (StringUtils.isEmpty(this.mEtStudentName.getText().toString())) {
            ToastUtils.show(getContext(), "请输入姓名");
            return false;
        }
        if (this.mIsAgree) {
            return true;
        }
        ToastUtils.show(getContext(), "请勾选同意协议后注册");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerification(String str, String str2) {
        if (isCheckVerifica()) {
            V4BusinessControllers.getInstance().postSendSmsCode(getLoginAccount(), this.mEtPhone.getText().toString(), str, str2, "", new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity.3
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V4UserRegisterActivity.this.getActivity(), "正在获取验证码.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    super.onComplete(controller, successBean, objArr);
                    if (V4UserRegisterActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(V4UserRegisterActivity.this.getContext(), "验证码已发送");
                        V4UserRegisterActivity.this.countDown();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (V4UserRegisterActivity.this.mIsEnable) {
                        V4UserRegisterActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    private void register() {
        if (isCheckInfo()) {
            V4BusinessControllers.getInstance().register(getLoginAccount(), this.mEtPhone.getText().toString(), this.mEtPsw1.getText().toString(), this.mEtStudentName.getText().toString(), this.mCustomerId, this.mEtVerification.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.user.V4UserRegisterActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V4UserRegisterActivity.this.getActivity(), "正在注册中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (V4UserRegisterActivity.this.mIsEnable) {
                        LocalDataUtil.savePlatformInfo(V4UserRegisterActivity.this.getActivity(), 4);
                        LocalDataUtil.savePlatformSchoolName(V4UserRegisterActivity.this.getActivity(), V4UserRegisterActivity.this.mCustomerName);
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(V4UserRegisterActivity.this.getContext(), "注册成功");
                        V4UserRegisterActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V4UserRegisterActivity.this.mIsEnable) {
                        V4UserRegisterActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }
}
