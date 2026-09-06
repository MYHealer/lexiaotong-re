package client.android.yixiaotong.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.LocalControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TelEdittext;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.about.LicenseV3Activity;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RegisterActivity extends BaseActivity implements TextWatcher {
    View mLicenseView;
    TextView mTvText;
    Button mVBtnNext;
    Button mVBtnVerify;
    ImageButton mVBtnViewPsw;
    EditText mVEtPassword;
    TelEdittext mVEtPhone;
    EditText mVEtVerify;
    TitleBar mVTitleBar;
    private long schoolId;
    private String schoolName;
    private boolean mSelectState = true;
    private boolean mIsEnable = true;

    static {
        StubApp.interface11(7470);
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVEtPhone = (TelEdittext) findViewById(R.id.v_et_phone);
        this.mVEtPassword = (EditText) findViewById(R.id.v_et_password);
        this.mVBtnViewPsw = (ImageButton) findViewById(R.id.btn_view_psw);
        this.mVEtVerify = (EditText) findViewById(R.id.v_et_verify);
        this.mVBtnVerify = (Button) findViewById(R.id.v_btn_verify);
        this.mVBtnNext = (Button) findViewById(R.id.v_btn_next);
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mLicenseView = findViewById(R.id.v_user_file);
        this.mTvText = (TextView) findViewById(R.id.tv_text);
    }

    private void initClickListeners() {
        findViewById(R.id.v_btn_verify).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.RegisterActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m162x1c6a69d1(view);
            }
        });
        findViewById(R.id.v_btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.RegisterActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m163xa9a51b52(view);
            }
        });
        findViewById(R.id.btn_view_psw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.RegisterActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m164x36dfccd3(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-login-RegisterActivity, reason: not valid java name */
    /* synthetic */ void m162x1c6a69d1(View view) {
        getVerifyCode();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-login-RegisterActivity, reason: not valid java name */
    /* synthetic */ void m163xa9a51b52(View view) {
        verifySMSCaptcha();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-login-RegisterActivity, reason: not valid java name */
    /* synthetic */ void m164x36dfccd3(View view) {
        if (this.mVEtPassword.getInputType() == 129) {
            this.mVEtPassword.setInputType(128);
            this.mVBtnViewPsw.setImageResource(R.mipmap.l_eye_open);
        } else {
            this.mVEtPassword.setInputType(129);
            this.mVEtPassword.setTypeface(Typeface.DEFAULT);
            this.mVBtnViewPsw.setImageResource(R.mipmap.l_eye_close);
        }
    }

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) RegisterActivity.class));
    }

    public static void launch(Activity activity, long j, String str) {
        activity.startActivity(new Intent(activity, (Class<?>) RegisterActivity.class).putExtra(FillInfoActivity.EXTRA_SCHOOLID, j).putExtra(FillInfoActivity.EXTRA_SCHOOLNAME, str));
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.login.RegisterActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LicenseV3Activity.launch(RegisterActivity.this.getActivity());
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

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("注册");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initListener() {
        this.mVEtPassword.addTextChangedListener(this);
        this.mVEtPhone.addTextChangedListener(this);
        this.mVEtVerify.addTextChangedListener(this);
    }

    private void getVerifyCode() {
        BusinessControllers.getInstance().sendSMSCaptcha(getLoginAccount(), this.mVEtPhone.getString(), 1, null, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.RegisterActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (RegisterActivity.this.mIsEnable) {
                    if (successBean.success != 1) {
                        SystemErrorTip.getInstance().showTipDialog(RegisterActivity.this.getActivity(), "验证码发送失败");
                    } else {
                        RegisterActivity.this.toast("验证码已发送");
                        RegisterActivity.this.countDown();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RegisterActivity.this.mIsEnable) {
                    SystemErrorTip.getInstance().showTipDialog(RegisterActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.ui.login.RegisterActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                RegisterActivity.this.mVBtnVerify.setText(localCountDownBean.time + " s");
                if (!localCountDownBean.complete) {
                    RegisterActivity.this.mVBtnVerify.setEnabled(false);
                } else {
                    RegisterActivity.this.mVBtnVerify.setEnabled(true);
                    RegisterActivity.this.mVBtnVerify.setText("重新获取");
                }
            }
        });
    }

    private void verifySMSCaptcha() {
        if (this.mSelectState) {
            BusinessControllers.getInstance().verifySMSCaptcha(getLoginAccount(), this.mVEtPhone.getString(), this.mVEtVerify.getText().toString(), 1, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.RegisterActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (RegisterActivity.this.mIsEnable) {
                        if (successBean.success != 1) {
                            SystemErrorTip.getInstance().showTipDialog(RegisterActivity.this.getActivity(), "验证码错误");
                        } else {
                            RegisterActivity.this.toast("验证通过，请填写个人资料");
                            FillInfoActivity.launch(RegisterActivity.this.getActivity(), RegisterActivity.this.mVEtPhone.getString(), RegisterActivity.this.mVEtPassword.getText().toString(), RegisterActivity.this.mVEtVerify.getText().toString(), RegisterActivity.this.schoolId, RegisterActivity.this.schoolName);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (RegisterActivity.this.mIsEnable) {
                        SystemErrorTip.getInstance().showTipDialog(RegisterActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
        } else {
            ToastUtils.show(getActivity(), "请选择勾选协议！");
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(this.mVEtPhone.getText().toString()) || TextUtils.isEmpty(this.mVEtPassword.getText().toString()) || TextUtils.isEmpty(this.mVEtVerify.getText().toString())) {
            this.mVBtnNext.setEnabled(false);
            this.mVBtnNext.setBackgroundResource(R.drawable.shape_dark_gray_button);
        } else {
            this.mVBtnNext.setEnabled(true);
            this.mVBtnNext.setBackgroundResource(R.drawable.shape_blue_button_radius_normal);
        }
    }
}
