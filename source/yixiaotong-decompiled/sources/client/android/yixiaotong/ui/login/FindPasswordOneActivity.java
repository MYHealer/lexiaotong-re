package client.android.yixiaotong.ui.login;

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
import client.android.yixiaotong.ui.widget.TelEdittext;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FindPasswordOneActivity extends BaseActivity {
    public static final String EXTRA_LAUNCH_MODE = "extra_launch_mode";
    public static final int LAUNCH_MODIFY_PAY_MODE = 2;
    public static final int LAUNCH_MODIFY_SHOUQUAN_MODE = 3;
    public static final int LAUNCH_RESET_MODE = 0;
    private int mLaunchMode;
    Button mVBtnNext;
    Button mVBtnVerify;
    EditText mVEtPassword;
    EditText mVEtPasswordAgain;
    TelEdittext mVEtPhone;
    EditText mVEtVerify;
    TitleBar mVTitleBar;
    int type = 2;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7422);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mVEtPhone = (TelEdittext) findViewById(R.id.v_et_phone);
        this.mVBtnVerify = (Button) findViewById(R.id.v_btn_verify);
        this.mVEtVerify = (EditText) findViewById(R.id.v_et_verify);
        this.mVBtnNext = (Button) findViewById(R.id.v_btn_next);
        this.mVEtPassword = (EditText) findViewById(R.id.v_et_password);
        this.mVEtPasswordAgain = (EditText) findViewById(R.id.v_et_password_again);
    }

    private void initClickListeners() {
        findViewById(R.id.v_btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FindPasswordOneActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m143x9f9667a2(view);
            }
        });
        findViewById(R.id.v_btn_verify).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FindPasswordOneActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m144xa59a3301(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-login-FindPasswordOneActivity, reason: not valid java name */
    /* synthetic */ void m143x9f9667a2(View view) {
        if (check()) {
            verifySMSCaptcha();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-login-FindPasswordOneActivity, reason: not valid java name */
    /* synthetic */ void m144xa59a3301(View view) {
        if (checkPhone()) {
            LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(BaseApplication.app, "localserveraddress");
            String string = localPreferencesHelper.getString("localnetserver");
            String string2 = localPreferencesHelper.getString("localjavaserver");
            if (!StringUtils.isNotEmpty(string) || !StringUtils.isNotEmpty(string2)) {
                getSecondHost();
            } else {
                getVerifyCode();
            }
        }
    }

    public static void launch(Activity activity, int i) {
        Intent intent = new Intent(activity, (Class<?>) FindPasswordOneActivity.class);
        intent.putExtra("extra_launch_mode", i);
        activity.startActivity(intent);
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

    private void initData() {
        int intExtra = getIntent().getIntExtra("extra_launch_mode", 0);
        this.mLaunchMode = intExtra;
        if (intExtra == 0) {
            this.type = 2;
        } else {
            this.type = 3;
        }
    }

    private void initTitleBar() {
        int i = this.mLaunchMode;
        if (i == 0) {
            this.mVTitleBar.setTitleView("找回密码");
        } else if (i == 2) {
            this.mVTitleBar.setTitleView("修改支付密码");
        } else if (i == 3) {
            this.mVTitleBar.setTitleView("重置授权密码");
        }
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerifyCode() {
        BusinessControllers.getInstance().sendSMSCaptcha(getLoginAccount(), this.mVEtPhone.getString(), this.type, null, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordOneActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    FindPasswordOneActivity.this.toast("验证码已发送");
                    FindPasswordOneActivity.this.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    if (clientException.getCode() == 7006) {
                        FindPasswordOneActivity.this.getSecondHost();
                    } else {
                        ErrorUtil.onFailResult(FindPasswordOneActivity.this.getActivity(), FindPasswordOneActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSecondHost() {
        BusinessControllers.getInstance().loginBeforeGetServerAddress(getLoginAccount(), this.mVEtPhone.getString(), new Listener<LoginBefore>() { // from class: client.android.yixiaotong.ui.login.FindPasswordOneActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LoginBefore loginBefore, Object... objArr) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    FindPasswordOneActivity.this.getVerifyCode();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPasswordOneActivity.this.getActivity(), FindPasswordOneActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordOneActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                FindPasswordOneActivity.this.mVBtnVerify.setText(localCountDownBean.time + " s");
                if (!localCountDownBean.complete) {
                    FindPasswordOneActivity.this.mVBtnVerify.setBackground(FindPasswordOneActivity.this.getResources().getDrawable(R.drawable.round_radio_button_gray_background));
                    FindPasswordOneActivity.this.mVBtnVerify.setEnabled(false);
                } else {
                    FindPasswordOneActivity.this.mVBtnVerify.setBackground(FindPasswordOneActivity.this.getResources().getDrawable(R.drawable.round_radius_button_background));
                    FindPasswordOneActivity.this.mVBtnVerify.setEnabled(true);
                    FindPasswordOneActivity.this.mVBtnVerify.setText("重新获取");
                }
            }
        });
    }

    private void verifySMSCaptcha() {
        BusinessControllers.getInstance().verifySMSCaptcha(getLoginAccount(), this.mVEtPhone.getString(), this.mVEtVerify.getText().toString(), this.type, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordOneActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    if (successBean.success == 1) {
                        if (FindPasswordOneActivity.this.mLaunchMode == 0) {
                            FindPasswordOneActivity.this.resetPassword();
                            return;
                        } else {
                            if (FindPasswordOneActivity.this.mLaunchMode != 2) {
                                if (FindPasswordOneActivity.this.mLaunchMode == 3) {
                                    FindPasswordTwoActivity.launch(FindPasswordOneActivity.this.getActivity(), FindPasswordOneActivity.this.mVEtPhone.getString(), FindPasswordOneActivity.this.mVEtVerify.getText().toString(), 3);
                                    return;
                                }
                                return;
                            }
                            FindPasswordTwoActivity.launch(FindPasswordOneActivity.this.getActivity(), FindPasswordOneActivity.this.mVEtPhone.getString(), FindPasswordOneActivity.this.mVEtVerify.getText().toString(), 2);
                            return;
                        }
                    }
                    FindPasswordOneActivity.this.toast("验证码错误");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPasswordOneActivity.this.getActivity(), FindPasswordOneActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetPassword() {
        BusinessControllers.getInstance().resetLoginPassword(getLoginAccount(), this.mVEtPhone.getString(), this.mVEtPassword.getText().toString(), this.mVEtVerify.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordOneActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    FindPasswordOneActivity.this.toast("重置登录密码成功");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordOneActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPasswordOneActivity.this.getActivity(), FindPasswordOneActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    private boolean check() {
        if (StringUtils.isTrimEmpty(this.mVEtPhone.getText().toString())) {
            toast("请输入手机号码");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtVerify.getText().toString())) {
            toast("请输入验证码");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtPhone.getText().toString())) {
            toast("手机号码必须11位数字");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtPassword.getText().toString())) {
            toast("请输入新密码");
            return false;
        }
        if (!StringUtils.isNotEmpty(this.mVEtPasswordAgain.getText().toString())) {
            toast("请输入确认密码");
            return false;
        }
        if (this.mVEtPasswordAgain.getText().toString().equals(this.mVEtPassword.getText().toString())) {
            return true;
        }
        toast("新密码与确认密码不一致");
        return false;
    }

    private boolean checkPhone() {
        if (!StringUtils.isTrimEmpty(this.mVEtPhone.getText().toString())) {
            return true;
        }
        toast("请输入手机号码");
        return false;
    }
}
