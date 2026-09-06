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
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FindPasswordTwoActivity extends BaseActivity {
    public static final String EXTRA_CAPTCACODE = "extra_captcacode";
    public static final String EXTRA_LAUNCH_MODE = "extra_launch_mode";
    public static final String EXTRA_MOBILE = "extra_mobile";
    public static final int LAUNCH_MODIFY_MODE = 1;
    public static final int LAUNCH_MODIFY_PAY_MODE = 2;
    public static final int LAUNCH_MODIFY_SHOUQUAN_MODE = 3;
    public static final int LAUNCH_RESET_MODE = 0;
    private String mCaptcaCode;
    private boolean mIsEnable = true;
    private int mLaunchMode;
    private String mMobile;
    Button mVBtnFinish;
    EditText mVEtOldPassword;
    EditText mVEtPassword;
    EditText mVEtPasswordAgain;
    TitleBar mVTitleBar;

    static {
        StubApp.interface11(7428);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mVEtOldPassword = (EditText) findViewById(R.id.v_et_old_password);
        this.mVEtPassword = (EditText) findViewById(R.id.v_et_password);
        this.mVEtPasswordAgain = (EditText) findViewById(R.id.v_et_password_again);
        this.mVBtnFinish = (Button) findViewById(R.id.v_btn_finish);
    }

    private void initClickListeners() {
        findViewById(R.id.v_btn_finish).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FindPasswordTwoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m145xe94f3588(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-login-FindPasswordTwoActivity, reason: not valid java name */
    /* synthetic */ void m145xe94f3588(View view) {
        if (check()) {
            int i = this.mLaunchMode;
            if (i == 0) {
                resetPassword();
                return;
            }
            if (i == 1) {
                modifyPassword();
            } else if (i == 2) {
                modifyPayPassword();
            } else if (i == 3) {
                modifyShouQuanPassword();
            }
        }
    }

    public static void launch(Activity activity, String str, String str2, int i) {
        Intent intent = new Intent(activity, (Class<?>) FindPasswordTwoActivity.class);
        intent.putExtra("extra_launch_mode", i);
        intent.putExtra("extra_captcacode", str2);
        intent.putExtra("extra_mobile", str);
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
        this.mCaptcaCode = getIntent().getStringExtra("extra_captcacode");
        this.mMobile = getIntent().getStringExtra("extra_mobile");
        int intExtra = getIntent().getIntExtra("extra_launch_mode", 0);
        this.mLaunchMode = intExtra;
        if (intExtra == 0 || intExtra == 3) {
            this.mVEtOldPassword.setVisibility(8);
        }
    }

    private void initTitleBar() {
        int i = this.mLaunchMode;
        if (i == 0) {
            this.mVTitleBar.setTitleView("找回密码");
        } else if (i == 1) {
            this.mVTitleBar.setTitleView("修改密码");
        } else if (i == 2) {
            this.mVTitleBar.setTitleView("修改支付密码");
        } else if (i == 3) {
            this.mVTitleBar.setTitleView("重置授权密码");
            this.mVEtPassword.setHint("输入6位新授权密码");
            this.mVEtPassword.setInputType(2);
            this.mVEtPasswordAgain.setInputType(2);
        }
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private boolean check() {
        int i = this.mLaunchMode;
        if ((i == 1 || i == 2) && StringUtils.isTrimEmpty(this.mVEtOldPassword.getText().toString())) {
            toast("请输入旧密码");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtPassword.getText().toString())) {
            toast("请输入新密码");
            return false;
        }
        if (this.mLaunchMode == 3 && this.mVEtPassword.getText().toString().length() != 6) {
            toast("密码必须是6位");
            return false;
        }
        if (this.mVEtPassword.getText().toString().length() < 6) {
            toast("密码必须大于6位");
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

    private void resetPassword() {
        BusinessControllers.getInstance().resetLoginPassword(getLoginAccount(), this.mMobile, this.mVEtPassword.getText().toString(), this.mCaptcaCode, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordTwoActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    FindPasswordTwoActivity.this.toast("重置登录密码成功");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPasswordTwoActivity.this.getActivity(), FindPasswordTwoActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    private void modifyPassword() {
        BusinessControllers.getInstance().modifyLoginPassword(getLoginAccount(), this.mVEtOldPassword.getText().toString(), this.mVEtPassword.getText().toString(), this.mCaptcaCode, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordTwoActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    FindPasswordTwoActivity.this.toast("修改登录密码成功");
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(BaseApplication.app);
                    ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPasswordTwoActivity.this.getActivity(), FindPasswordTwoActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    private void modifyPayPassword() {
        BusinessControllers.getInstance().modifyPayPassword(getLoginAccount(), this.mVEtOldPassword.getText().toString(), this.mVEtPassword.getText().toString(), this.mCaptcaCode, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordTwoActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    FindPasswordTwoActivity.this.toast("修改支付密码成功");
                    ActivitiesHelper.getInstance().closeTarget(FindPasswordOneActivity.class);
                    FindPasswordTwoActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FindPasswordTwoActivity.this.getActivity(), FindPasswordTwoActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    private void modifyShouQuanPassword() {
        BusinessControllers.getInstance().chongzhiShouQuanPassword(getLoginAccount(), this.mVEtPassword.getText().toString(), this.mCaptcaCode, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FindPasswordTwoActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    FindPasswordTwoActivity.this.toast("重置授权密码成功");
                    LocalBusinessStore.saveAuthorizedPassword(FindPasswordTwoActivity.this.getContext(), FindPasswordTwoActivity.this.getLoginAccount().getUid(), FindPasswordTwoActivity.this.mVEtPassword.getText().toString());
                    ActivitiesHelper.getInstance().closeTarget(FindPasswordOneActivity.class);
                    FindPasswordTwoActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FindPasswordTwoActivity.this.mIsEnable) {
                    if (clientException.getCode() != 3001) {
                        ErrorUtil.onFailResult(FindPasswordTwoActivity.this.getActivity(), FindPasswordTwoActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                    } else {
                        FindPasswordTwoActivity.this.finish();
                    }
                }
            }
        });
    }
}
