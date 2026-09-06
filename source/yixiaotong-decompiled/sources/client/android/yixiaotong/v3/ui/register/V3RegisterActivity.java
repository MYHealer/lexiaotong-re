package client.android.yixiaotong.v3.ui.register;

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
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.FillInfoActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.register.MobileMessageBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.about.LicenseV3Activity;
import client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3RegisterActivity extends BaseActivity {
    private Button mBtnGetVerification;
    private EditText mEtPhone;
    private EditText mEtPsw1;
    private EditText mEtStudentName;
    private EditText mEtVerification;
    private ImageView mImgAgree;
    private String mSchoolId;
    private String mSchoolName;
    private TitleBar mTitleBar;
    private TextView mTvSchoolName;
    private boolean mIsEnable = true;
    private boolean mIsAgree = false;

    static {
        StubApp.interface11(10158);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V3RegisterActivity.class).putExtra("schoolname", str).putExtra(FillInfoActivity.EXTRA_SCHOOLID, str2));
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
        this.mTitleBar.setTitleView("注册");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initClickListeners() {
        findViewById(R.id.iv_back).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m406x25583032(view);
            }
        });
        findViewById(R.id.btn_getverifica).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m407xdfcdd0b3(view);
            }
        });
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m408x9a437134(view);
            }
        });
        findViewById(R.id.btn_hasaccount).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m409x54b911b5(view);
            }
        });
        findViewById(R.id.tv_agree1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m410xf2eb236(view);
            }
        });
        findViewById(R.id.tv_agree2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m411xc9a452b7(view);
            }
        });
        findViewById(R.id.iv_agree).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m412x8419f338(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-V3RegisterActivity, reason: not valid java name */
    /* synthetic */ void m406x25583032(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-register-V3RegisterActivity, reason: not valid java name */
    /* synthetic */ void m407xdfcdd0b3(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        showVerificationCodeDialog();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-register-V3RegisterActivity, reason: not valid java name */
    /* synthetic */ void m408x9a437134(View view) {
        register();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-register-V3RegisterActivity, reason: not valid java name */
    /* synthetic */ void m409x54b911b5(View view) {
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-register-V3RegisterActivity, reason: not valid java name */
    /* synthetic */ void m410xf2eb236(View view) {
        LicenseV3Activity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-register-V3RegisterActivity, reason: not valid java name */
    /* synthetic */ void m411xc9a452b7(View view) {
        PrivacyPolicyActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v3-ui-register-V3RegisterActivity, reason: not valid java name */
    /* synthetic */ void m412x8419f338(View view) {
        toggleAgreement();
    }

    private void showVerificationCodeDialog() {
        VerificationCodeDialog.getInstance().showDialog(getLoginAccount(), this.mEtPhone.getText().toString(), getActivity(), new VerificationCodeDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity.1
            @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.VerificationCodeDialog.Listener
            public void onConfirm(String str) {
                V3RegisterActivity.this.getVerification(str);
            }
        });
    }

    private void toggleAgreement() {
        boolean z = !this.mIsAgree;
        this.mIsAgree = z;
        this.mImgAgree.setImageResource(z ? R.mipmap.xz1 : R.mipmap.wxz);
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
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), 120L, new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                V3RegisterActivity.this.mBtnGetVerification.setText("还剩" + localCountDownBean.time + "s");
                if (localCountDownBean.complete) {
                    V3RegisterActivity.this.mBtnGetVerification.setEnabled(true);
                    V3RegisterActivity.this.mBtnGetVerification.setText("重新获取");
                } else {
                    V3RegisterActivity.this.mBtnGetVerification.setEnabled(false);
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
    public void getVerification(String str) {
        if (isCheckVerifica()) {
            V3BusinessControllers.getInstance().getMoblieMessage(getLoginAccount(), this.mEtPhone.getText().toString(), 1, str, new Listener<MobileMessageBean>() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity.3
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V3RegisterActivity.this.getActivity(), "正在获取验证码.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, MobileMessageBean mobileMessageBean, Object... objArr) {
                    if (V3RegisterActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(V3RegisterActivity.this.getContext(), "验证码已发送");
                        V3RegisterActivity.this.countDown();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3RegisterActivity.this.mIsEnable) {
                        if (clientException.isNeedTip(clientException.getCode())) {
                            V3RegisterActivity.this.showDialog(clientException.getDetail());
                        } else {
                            V3RegisterActivity.this.onError(clientException);
                        }
                    }
                }
            });
        }
    }

    private void register() {
        if (isCheckInfo()) {
            V3BusinessControllers.getInstance().postMoblieRegisterUser(getLoginAccount(), this.mEtVerification.getText().toString(), this.mEtPsw1.getText().toString(), this.mEtPhone.getText().toString(), this.mEtStudentName.getText().toString(), this.mSchoolId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(V3RegisterActivity.this.getActivity(), "正在注册中.", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (V3RegisterActivity.this.mIsEnable) {
                        LocalDataUtil.savePlatformInfo(V3RegisterActivity.this.getActivity(), 1);
                        LocalDataUtil.savePlatformSchoolName(V3RegisterActivity.this.getActivity(), V3RegisterActivity.this.mSchoolName);
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(V3RegisterActivity.this.getContext(), "注册成功");
                        V3RegisterActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3RegisterActivity.this.mIsEnable) {
                        if (clientException.isNeedTip(clientException.getCode())) {
                            V3RegisterActivity.this.showDialog(clientException.getDetail());
                        } else {
                            V3RegisterActivity.this.onError(clientException);
                        }
                    }
                }
            });
        }
    }

    private void bindSchool(String str, String str2) {
        V3BusinessControllers.getInstance().postBindSchoolInfo(getLoginAccount(), str, str2, true, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.register.V3RegisterActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V3RegisterActivity.this.getActivity(), "绑定学校.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V3RegisterActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(V3RegisterActivity.this.getActivity(), "绑定学校成功！");
                    V3RegisterActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V3RegisterActivity.this.mIsEnable) {
                    V3RegisterActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
    }
}
