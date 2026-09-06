package client.android.yixiaotong.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.ManagerBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.getserveraddress.LoginBefore;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.MainActivity;
import client.android.yixiaotong.ui.PrivacyPolicyActivity;
import client.android.yixiaotong.ui.activitycontrol.WelcomeControlUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.LicenseTipDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.UpdateAppDialog;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.CrossEditText;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.Base64;
import client.android.yixiaotong.util.BaseInitControlUtil;
import client.android.yixiaotong.util.BitmapUtil;
import client.android.yixiaotong.util.ClickUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.util.update.UpdateAppUtil;
import client.android.yixiaotong.v3.bean.login.LoginSeccessBean;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.V3MainActivity;
import client.android.yixiaotong.v3.ui.about.LicenseV3Activity;
import client.android.yixiaotong.v3.ui.demo.V3MainDemoActivity;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.register.FindPswActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ImageCodeBean;
import client.android.yixiaotong.v4.http.bean.V4LoginBean;
import client.android.yixiaotong.v4.ui.V4MainActivity;
import client.android.yixiaotong.v4.ui.user.V4FindPswActivity;
import client.android.yixiaotong.v4.ui.user.V4SelectPlatformActivity;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    private static final String TYPE_ISHINT = "type_ishint";
    private static final String TYPE_SERVERVERSION = "type_serverversion";
    Button btn_login;
    TextView btn_registe;
    CrossEditText ed_password;
    CrossEditText ed_userName;
    private String mCaptchaKey;
    EditText mEtCode;
    ImageView mImgAgree;
    ImageView mImgChangeLanguage;
    ImageView mIvCode;
    RadioGroup mRadioServer;
    RadioButton mRbBeta;
    RadioButton mRbDevelop;
    RadioButton mRbRelease;
    RadioButton mRbTest;
    RelativeLayout mRelPlatform;
    RelativeLayout mRelWarningError;
    TextView mTvGetCode;
    TextView mTvSchoolName;
    TextView mTvText;
    ImageButton mVBtnViewPsw;
    TextView tv_forgetPassword;
    private boolean isHint = false;
    private boolean mIsEnable = true;
    private State mState = State.onne;
    private boolean mIsGetCodeed = false;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.login.LoginActivity.8
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(LoginActivity.TAG, "onPermissionGranted:" + i + "");
            if (i != 0) {
                return;
            }
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeOrBarcodeActivity.launch(LoginActivity.this.getActivity(), 100);
            } else {
                ZxingScanActivity.launch(LoginActivity.this.getActivity(), 100);
            }
        }
    };
    private boolean isStart = false;
    private boolean mIsInit = false;

    private enum State {
        login,
        register,
        findpsw,
        onne
    }

    static {
        StubApp.interface11(7462);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) LoginActivity.class));
        activity.finish();
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, (Class<?>) LoginActivity.class);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    private void initViewNew() {
        this.mRelPlatform = (RelativeLayout) findViewById(R.id.rel_platform);
        this.mTvSchoolName = (TextView) findViewById(R.id.tv_platformschoolname);
        this.mRelWarningError = (RelativeLayout) findViewById(R.id.rel_warningerror);
        this.mRadioServer = (RadioGroup) findViewById(R.id.radiogroup_server);
        this.mRbDevelop = (RadioButton) findViewById(R.id.radio_develop);
        this.mRbTest = (RadioButton) findViewById(R.id.radio_test);
        this.mRbBeta = (RadioButton) findViewById(R.id.radio_beta);
        this.mRbRelease = (RadioButton) findViewById(R.id.radio_release);
        this.mImgChangeLanguage = (ImageView) findViewById(R.id.img_changelanguage);
        this.ed_userName = (CrossEditText) findViewById(R.id.login_photo_number_text);
        this.ed_password = (CrossEditText) findViewById(R.id.login_pass_word_text);
        this.tv_forgetPassword = (TextView) findViewById(R.id.forget_password);
        this.btn_login = (Button) findViewById(R.id.login_btn);
        this.btn_registe = (TextView) findViewById(R.id.register_btn);
        this.mTvText = (TextView) findViewById(R.id.tv_text);
        this.mVBtnViewPsw = (ImageButton) findViewById(R.id.btn_view_psw);
        this.mEtCode = (EditText) findViewById(R.id.et_code);
        this.mIvCode = (ImageView) findViewById(R.id.iv_code);
        this.mTvGetCode = (TextView) findViewById(R.id.tv_getcode);
        this.mImgAgree = (ImageView) findViewById(R.id.iv_agree);
    }

    private void initView() {
        this.mRadioServer.setVisibility(8);
        this.mRelPlatform.setVisibility(0);
        this.ed_userName.setText(ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT));
        if (StringUtils.isNotEmpty(this.ed_userName.getText().toString())) {
            CrossEditText crossEditText = this.ed_userName;
            crossEditText.setSelection(crossEditText.getText().toString().length());
        }
        this.ed_password.setPasword(true);
        this.ed_password.setInputType(129);
        this.ed_password.setTypeface(Typeface.DEFAULT);
        this.mVBtnViewPsw.setImageResource(R.mipmap.l_eye_close);
        this.mTvText.getPaint().setFakeBoldText(true);
        this.ed_userName.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.login.LoginActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (StringUtils.isNotEmpty(editable.toString()) && editable.toString().length() == 11) {
                    LoginActivity.this.getV3Code(false);
                }
            }
        });
        this.ed_password.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.login.LoginActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                if (LoginActivity.this.mIsGetCodeed || !StringUtils.isNotEmpty(LoginActivity.this.ed_userName.getText().toString())) {
                    return;
                }
                LoginActivity.this.getV3Code(false);
            }
        });
        this.mEtCode.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity.3
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View view, boolean z) {
                LogUtil.e("Login", "onFocusChange:" + z);
                if (!z || LocalBusinessStore.getLoginLicenseTip(LoginActivity.this.getContext())) {
                    if (!LoginActivity.this.mIsGetCodeed && z && StringUtils.isNotEmpty(LoginActivity.this.ed_userName.getText().toString())) {
                        LoginActivity.this.getV3Code(true);
                        return;
                    }
                    return;
                }
                LoginActivity.this.mState = State.onne;
                LoginActivity.this.showLicenseDialog(false);
            }
        });
        String lanuage = LocalDataUtil.getLanuage(getActivity());
        if (StringUtils.isNotEmpty(lanuage) && lanuage.equalsIgnoreCase(BaseActivity.LANGUAGEEN)) {
            this.mImgChangeLanguage.setImageResource(R.mipmap.englishtochina);
        } else {
            this.mImgChangeLanguage.setImageResource(R.mipmap.chinatoenginsh);
        }
    }

    private void initClickListeners() {
        findViewById(R.id.rel_platform).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m146x3eb40ef9(view);
            }
        });
        findViewById(R.id.radio_develop).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m147x305db518(view);
            }
        });
        findViewById(R.id.radio_test).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m154x22075b37(view);
            }
        });
        findViewById(R.id.radio_beta).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m155x13b10156(view);
            }
        });
        findViewById(R.id.radio_release).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m156x55aa775(view);
            }
        });
        findViewById(R.id.img_changelanguage).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m157xf7044d94(view);
            }
        });
        findViewById(R.id.login_btn).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m158xe8adf3b3(view);
            }
        });
        findViewById(R.id.register_btn).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m159xda5799d2(view);
            }
        });
        findViewById(R.id.forget_password).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m160xcc013ff1(view);
            }
        });
        findViewById(R.id.btn_view_psw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m161xbdaae610(view);
            }
        });
        findViewById(R.id.iv_code).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m148xc885912a(view);
            }
        });
        findViewById(R.id.tv_getcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m149xba2f3749(view);
            }
        });
        findViewById(R.id.tv_agree1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m150xabd8dd68(view);
            }
        });
        findViewById(R.id.tv_agree2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m151x9d828387(view);
            }
        });
        findViewById(R.id.iv_agree).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m152x8f2c29a6(view);
            }
        });
        findViewById(R.id.tv_passlogin).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m153x80d5cfc5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m146x3eb40ef9(View view) {
        if (ClickUtils.isFastDoubleClick()) {
            return;
        }
        if (LocalBusinessStore.getLoginLicenseTip(getActivity())) {
            V4SelectPlatformActivity.launch(getActivity());
        } else {
            ToastUtils.show(getActivity(), "勾选同意协议后才能继续");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m147x305db518(View view) {
        LocalDataUtil.saveTestMode(getActivity(), -1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m154x22075b37(View view) {
        LocalDataUtil.saveTestMode(getActivity(), 0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m155x13b10156(View view) {
        LocalDataUtil.saveTestMode(getActivity(), 1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m156x55aa775(View view) {
        LocalDataUtil.saveTestMode(getActivity(), 2);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m157xf7044d94(View view) {
        if (ClickUtils.isFastDoubleClick()) {
            return;
        }
        String lanuage = LocalDataUtil.getLanuage(getActivity());
        boolean zIsNotEmpty = StringUtils.isNotEmpty(lanuage);
        String str = BaseActivity.LANGUAGEEN;
        if (zIsNotEmpty && lanuage.equalsIgnoreCase(BaseActivity.LANGUAGEEN)) {
            str = RedirectReqWrapper.KEY_CHANNEL;
        }
        LocalDataUtil.saveLanuage(getActivity(), str);
        switchLang(str);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m158xe8adf3b3(View view) {
        this.mState = State.login;
        if (ClickUtils.isFastDoubleClick()) {
            return;
        }
        if (StringUtils.isEmpty(this.ed_userName.getText().toString())) {
            ToastUtils.show(getContext(), "请输入您的手机号/账号");
            return;
        }
        if (StringUtils.isEmpty(this.ed_password.getText().toString())) {
            ToastUtils.show(getContext(), "请输入您的密码");
        } else if (StringUtils.isEmpty(this.mEtCode.getText().toString())) {
            ToastUtils.show(getContext(), "请输入验证码");
        } else {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mEtCode.getWindowToken(), 0);
            showLicenseDialog(false);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m159xda5799d2(View view) {
        this.mState = State.register;
        showLicenseDialog(false);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$8$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m160xcc013ff1(View view) {
        this.mState = State.findpsw;
        showLicenseDialog(false);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$9$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m161xbdaae610(View view) {
        if (this.ed_password.getInputType() == 129) {
            this.ed_password.setInputType(128);
            this.mVBtnViewPsw.setImageResource(R.mipmap.l_eye_open);
            CrossEditText crossEditText = this.ed_password;
            crossEditText.setSelection(crossEditText.getText().length());
            return;
        }
        this.ed_password.setInputType(129);
        this.ed_password.setTypeface(Typeface.DEFAULT);
        this.mVBtnViewPsw.setImageResource(R.mipmap.l_eye_close);
        CrossEditText crossEditText2 = this.ed_password;
        crossEditText2.setSelection(crossEditText2.getText().length());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$10$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m148xc885912a(View view) {
        if (ClickUtils.isFastDoubleClick()) {
            return;
        }
        getV3Code(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$11$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m149xba2f3749(View view) {
        if (ClickUtils.isFastDoubleClick()) {
            return;
        }
        getV3Code(true);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$12$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m150xabd8dd68(View view) {
        LicenseV3Activity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$13$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m151x9d828387(View view) {
        PrivacyPolicyActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$14$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m152x8f2c29a6(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.iv_agree);
        if (LocalBusinessStore.getLoginLicenseTip(getActivity())) {
            LocalBusinessStore.saveLoginLicenseTip(getActivity(), false);
            imageView.setImageResource(R.mipmap.unselectradio);
        } else {
            if (LocalBusinessStore.getLicenseTip(getContext())) {
                LocalBusinessStore.saveLoginLicenseTip(getActivity(), true);
                imageView.setImageResource(R.mipmap.selectradio);
                initLaunchAppData();
                return;
            }
            showLicenseDialog(true);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$15$client-android-yixiaotong-ui-login-LoginActivity, reason: not valid java name */
    /* synthetic */ void m153x80d5cfc5(View view) {
        if (LocalBusinessStore.getLoginLicenseTip(getActivity())) {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.login.LoginActivity.4
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    V3MainDemoActivity.launch(LoginActivity.this.getActivity());
                }
            }, "提示", "跳过登录只能查看功能，将无法使用实时设备，确认跳过登录吗", "取消", "确认");
        } else {
            ToastUtils.show(getActivity(), "勾选同意协议后才能继续");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (StringUtils.isNotEmpty(this.ed_userName.getText().toString()) && this.ed_userName.getText().toString().length() == 11) {
            getV3Code(false);
        }
        String platformSchoolName = LocalDataUtil.getPlatformSchoolName(getActivity());
        if (StringUtils.isNotEmpty(platformSchoolName)) {
            this.mTvSchoolName.setText(platformSchoolName);
        } else if (LocalDataUtil.getPlatformInfo(getActivity()) != -1) {
            this.mTvSchoolName.setText("云平台学校");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        UpdateAppDialog.getInstance().dismiss(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void getSecondHost() {
        BusinessControllers.getInstance().loginBeforeGetServerAddress(getLoginAccount(), this.ed_userName.getText().toString().replace(PPSLabelView.Code, ""), new Listener<LoginBefore>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(LoginActivity.this.getActivity(), "正在处理中,请稍候..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LoginBefore loginBefore, Object... objArr) {
                if (LoginActivity.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(loginBefore.javaServer) && StringUtils.isNotEmpty(loginBefore.netServer)) {
                        LoginActivity.this.login();
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        SystemErrorTip.getInstance().showTipDialog(LoginActivity.this.getActivity(), "获取服务器域名失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (LoginActivity.this.mIsEnable) {
                    if (clientException.getCode() == 7006) {
                        LoginActivity.this.v3login();
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        SystemErrorTip.getInstance().showTipDialog(LoginActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        BusinessControllers.getInstance().login(getLoginAccount(), this.ed_userName.getText().toString().replace(PPSLabelView.Code, ""), this.ed_password.getText().toString(), new Listener<UserInfoBean>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.setConnectMaterialDialog("正在获取用户信息中,请稍候..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UserInfoBean userInfoBean, Object... objArr) {
                if (LoginActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (userInfoBean == null) {
                        ToastUtils.show(LoginActivity.this.getContext(), "登录异常，请重新登录");
                        return;
                    }
                    LocalDataUtil.savePlatformInfo(BaseApplication.app, 0);
                    ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.LOGIN_ACCOUNT, LoginActivity.this.ed_userName.getText().toString());
                    ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.LOGIN_PASSWORD, LoginActivity.this.ed_password.getText().toString());
                    LoginActivity.this.getVerSion();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (LoginActivity.this.mIsEnable) {
                    if (clientException.getCode() == 1999) {
                        LoginActivity.this.v3login();
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        SystemErrorTip.getInstance().showTipDialog(LoginActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getVerSion() {
        final String version = AppUtils.getVersion(getContext());
        LocalDataUtil.saveAppUpdateUrl(getActivity(), "");
        V3BusinessControllers.getInstance().getAppVerInfo2(getLoginAccount(), version, "1", "202206280001", new Listener<AppVersionBean>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppVersionBean appVersionBean, Object... objArr) {
                if (LoginActivity.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(appVersionBean.ver) || (appVersionBean.status != 1 && appVersionBean.status != 2)) {
                        LoginActivity.this.isManager();
                        MainActivity.launch(LoginActivity.this.getActivity());
                        return;
                    }
                    if (StringUtils.isNotEmpty(appVersionBean.url)) {
                        LocalDataUtil.saveAppUpdateUrl(LoginActivity.this.getActivity(), appVersionBean.url);
                    }
                    LocalDataUtil.saveAppVerOld(LoginActivity.this.getContext(), appVersionBean.ver);
                    if (appVersionBean.ver.equals(PreferenceUtil.getServerVersionString(LoginActivity.this.getContext(), "type_serverversion", appVersionBean.ver))) {
                        PreferenceUtil.putServerVersionString(LoginActivity.this.getContext(), "type_serverversion", appVersionBean.ver);
                    }
                    if (StringUtils.stringToInt(appVersionBean.ver) <= StringUtils.stringToInt(version)) {
                        LoginActivity.this.isManager();
                        MainActivity.launch(LoginActivity.this.getActivity());
                    } else if (appVersionBean.status == 2) {
                        new UpdateAppUtil().showMustUpdateApkDialog(LoginActivity.this.getActivity(), appVersionBean.msg);
                    } else if (appVersionBean.status == 1) {
                        new UpdateAppUtil().showUpdateApkDialog(LoginActivity.this.isHint, LoginActivity.this.getActivity(), appVersionBean.ver, appVersionBean.msg);
                    } else {
                        LoginActivity.this.isManager();
                        MainActivity.launch(LoginActivity.this.getActivity());
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (LoginActivity.this.mIsEnable) {
                    LoginActivity.this.isManager();
                    MainActivity.launch(LoginActivity.this.getActivity());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLicenseDialog(boolean z) {
        if (LocalBusinessStore.getLicenseTip(getContext()) && LocalBusinessStore.getLoginLicenseTip(getActivity())) {
            checkPermissionResult();
            return;
        }
        if (!LocalBusinessStore.getLicenseTip(getContext()) && z) {
            new LicenseTipDialog().show(getActivity(), new LicenseTipDialog.Listener() { // from class: client.android.yixiaotong.ui.login.LoginActivity.9
                @Override // client.android.yixiaotong.ui.dialog.LicenseTipDialog.Listener
                public void onComfirt() {
                    LocalBusinessStore.saveLicenseTip(LoginActivity.this.getContext(), true);
                    String strReplace = LoginActivity.this.ed_userName.getText().toString().replace(PPSLabelView.Code, "");
                    if (!LoginActivity.this.mIsGetCodeed && StringUtils.isNotEmpty(strReplace) && strReplace.length() >= 11) {
                        LoginActivity.this.getV3Code(true);
                    }
                    LoginActivity.this.initLaunchAppData();
                }

                @Override // client.android.yixiaotong.ui.dialog.LicenseTipDialog.Listener
                public void onLicense() {
                    LicenseV3Activity.launch(LoginActivity.this.getActivity());
                }

                @Override // client.android.yixiaotong.ui.dialog.LicenseTipDialog.Listener
                public void onPrivacyPolicy() {
                    PrivacyPolicyActivity.launch(LoginActivity.this.getActivity());
                }
            });
        } else {
            if (z) {
                return;
            }
            ToastUtils.show(getContext(), "勾选同意协议后才能继续");
        }
    }

    private void checkPermissionResult() {
        if (this.mState == State.login) {
            if (LocalDataUtil.getPlatformInfo(getActivity()) == 4) {
                v4login();
                return;
            } else {
                getSecondHost();
                return;
            }
        }
        if (this.mState == State.register) {
            if (LocalBusinessStore.getPerssionTip(getActivity(), 1)) {
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.login.LoginActivity.10
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        LocalBusinessStore.savePerssionTip(LoginActivity.this.getActivity(), 1);
                        LocalDataUtil.savePermissIndex(LoginActivity.this.getActivity(), 1);
                        PermissionUtil.requestPerssion(LoginActivity.this.getActivity(), 0, LoginActivity.this.permissionGrant);
                    }
                }, "需要开启相机权限，用于扫描学校二维码后注册");
                return;
            }
        }
        if (this.mState == State.findpsw) {
            int platformInfo = LocalDataUtil.getPlatformInfo(getActivity());
            LogUtil.e(TAG, "findpsw:" + platformInfo);
            if (platformInfo == -1) {
                toSelectSchool();
            } else if (platformInfo == 4) {
                V4FindPswActivity.launch(getActivity());
            } else {
                FindPswActivity.launch(getActivity());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isManager() {
        BusinessControllers.getInstance().getIsManager(getLoginAccount(), new Listener<ManagerBean>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.11
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v3login() {
        final String strReplace = this.ed_userName.getText().toString().replace(PPSLabelView.Code, "");
        V3BusinessControllers.getInstance().postUserLogin(getLoginAccount(), strReplace, this.ed_password.getText().toString(), this.mEtCode.getText().toString(), new Listener<LoginSeccessBean>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.setConnectMaterialDialog("正在获取用户信息中,请稍候...");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LoginSeccessBean loginSeccessBean, Object... objArr) {
                if (LoginActivity.this.mIsEnable) {
                    LoginActivity.this.showError50XTip();
                    LocalDataUtil.saveIsNeedTipSignZKT(LoginActivity.this.getActivity(), true);
                    if (!StringUtils.isNotEmpty(LocalDataUtil.getLonginAccount(LoginActivity.this.getContext())) || !LocalDataUtil.getLonginAccount(LoginActivity.this.getContext()).equals(strReplace)) {
                        UserInfoUtil.getInstance().saveSchoolInfosIndex(0);
                        InvestorInfoUtil.getInstance().saveInvestorInfosIndex(0);
                        LocalDataUtil.saveLonginAccount(LoginActivity.this.getContext(), strReplace);
                    }
                    LocalDataUtil.saveAccoutPsw(LoginActivity.this.getContext(), strReplace, LoginActivity.this.ed_password.getText().toString());
                    LocalDataUtil.saveFirstLogin(LoginActivity.this.getContext(), true);
                    LocalDataUtil.savePlatformInfo(BaseApplication.app, 1);
                    ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.LOGIN_ACCOUNT, LoginActivity.this.ed_userName.getText().toString());
                    ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.LOGIN_PASSWORD, LoginActivity.this.ed_password.getText().toString());
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V3MainActivity.launch(LoginActivity.this.getActivity());
                    if (loginSeccessBean.state >= 90) {
                        LocalDataUtil.saveIsNeedChangePsw(LoginActivity.this.getActivity(), true);
                    } else {
                        LocalDataUtil.saveIsNeedChangePsw(LoginActivity.this.getActivity(), false);
                    }
                    LocalDataUtil.saveLoginDeviceInfo(LoginActivity.this.getActivity());
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (LoginActivity.this.mIsEnable) {
                    LoginActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getV3Code(boolean z) {
        LogUtil.e(TAG, "getV3code");
        if (LocalBusinessStore.getLoginLicenseTip(getContext())) {
            String strReplace = this.ed_userName.getText().toString().replace(PPSLabelView.Code, "");
            if (this.isStart) {
                return;
            }
            int platformInfo = LocalDataUtil.getPlatformInfo(getActivity());
            LogUtil.e(TAG, "getV3Code:" + platformInfo);
            if (platformInfo == -1) {
                toSelectSchool();
                return;
            } else if (platformInfo == 4) {
                getV4Code(z);
                return;
            } else {
                getV3Code(strReplace, z);
                return;
            }
        }
        ToastUtils.show(getActivity(), "勾选同意协议后才能继续");
    }

    private void getV3Code(String str, final boolean z) {
        V3BusinessControllers.getInstance().getCode(getLoginAccount(), str, new Listener<String>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                LoginActivity.this.isStart = true;
                LoginActivity.this.mTvGetCode.setVisibility(8);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str2, Object... objArr) {
                LoginActivity.this.isStart = false;
                if (LoginActivity.this.mIsEnable && StringUtils.isNotEmpty(str2)) {
                    LoginActivity.this.showError50XTip();
                    String[] strArrSplit = str2.split(",");
                    if (strArrSplit == null || strArrSplit.length <= 1) {
                        return;
                    }
                    LoginActivity.this.mIsGetCodeed = true;
                    byte[] bArrDecode = Base64.decode(strArrSplit[1], 0);
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                    float appScreenDensity = AppUtils.getAppScreenDensity(LoginActivity.this.getActivity());
                    int i = (int) (80.0f * appScreenDensity);
                    LogUtil.e(LoginActivity.TAG, appScreenDensity + "  " + i);
                    LoginActivity.this.mIvCode.setImageBitmap(BitmapUtil.scaleBitmap(bitmapDecodeByteArray, i, (int) (appScreenDensity * 40.0f)));
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                LoginActivity.this.isStart = false;
                if (LoginActivity.this.mIsEnable) {
                    LoginActivity.this.mTvGetCode.setVisibility(0);
                    LoginActivity.this.showError50XTip();
                    if (z) {
                        if (clientException.getCode() == -53) {
                            ToastUtils.show(LoginActivity.this.getActivity(), "请下载最新版本APP");
                        } else {
                            LoginActivity.this.onError(clientException);
                        }
                    }
                }
            }
        });
    }

    private void getV4Code(final boolean z) {
        V4BusinessControllers.getInstance().getLoginCodeImage(getLoginAccount(), new Listener<V4ImageCodeBean>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                LoginActivity.this.isStart = true;
                LoginActivity.this.mTvGetCode.setVisibility(8);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ImageCodeBean v4ImageCodeBean, Object... objArr) {
                LoginActivity.this.isStart = false;
                if (LoginActivity.this.mIsEnable && StringUtils.isNotEmpty(v4ImageCodeBean.captcha)) {
                    LoginActivity.this.showError50XTip();
                    LoginActivity.this.mIsGetCodeed = true;
                    LoginActivity.this.mCaptchaKey = v4ImageCodeBean.captchaKey;
                    byte[] bArrDecode = Base64.decode(v4ImageCodeBean.captcha, 0);
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                    float appScreenDensity = AppUtils.getAppScreenDensity(LoginActivity.this.getActivity());
                    int i = (int) (80.0f * appScreenDensity);
                    LogUtil.e(LoginActivity.TAG, appScreenDensity + "  " + i);
                    LoginActivity.this.mIvCode.setImageBitmap(BitmapUtil.scaleBitmap(bitmapDecodeByteArray, i, (int) (appScreenDensity * 40.0f)));
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                LoginActivity.this.isStart = false;
                if (LoginActivity.this.mIsEnable) {
                    LoginActivity.this.mTvGetCode.setVisibility(0);
                    LoginActivity.this.showError50XTip();
                    if (z) {
                        LoginActivity.this.onError(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError50XTip() {
        if (Error50XUtil.isInterrupt(getActivity())) {
            this.mRelWarningError.setVisibility(0);
        } else {
            this.mRelWarningError.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        showError50XTip();
        BaseMaterialDialog.dissmisMaterialDialog();
        LogUtil.e(TAG, "onError:" + clientException.getCode());
        if (clientException.isNeedTip(clientException.getCode()) || clientException.isNeedExitApp(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), "登录", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initLaunchAppData() {
        if (this.mIsInit) {
            return;
        }
        this.mIsInit = true;
        new BaseInitControlUtil().init(BaseApplication.app);
        WelcomeControlUtil.getInstance().userActiveInfo(getLoginAccount(), getActivity());
    }

    private void v4login() {
        V4BusinessControllers.getInstance().login(getLoginAccount(), this.ed_userName.getText().toString().replace(PPSLabelView.Code, ""), this.ed_password.getText().toString(), this.mEtCode.getText().toString(), this.mCaptchaKey, new Listener<V4LoginBean>() { // from class: client.android.yixiaotong.ui.login.LoginActivity.15
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
                BaseMaterialDialog.showMaterialDialog(LoginActivity.this.getActivity(), "正在获取用户信息中,请稍候....", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4LoginBean v4LoginBean, Object... objArr) {
                if (LoginActivity.this.mIsEnable) {
                    ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.LOGIN_ACCOUNT, LoginActivity.this.ed_userName.getText().toString());
                    ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.LOGIN_PASSWORD, LoginActivity.this.ed_password.getText().toString());
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LocalDataUtil.savePlatformInfo(BaseApplication.app, 4);
                    V4MainActivity.launch(LoginActivity.this.getActivity());
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (LoginActivity.this.mIsEnable) {
                    LoginActivity.this.onError(clientException);
                }
            }
        });
    }

    private void toSelectSchool() {
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.login.LoginActivity.16
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                if (ClickUtils.isFastDoubleClick()) {
                    return;
                }
                if (LocalBusinessStore.getLoginLicenseTip(LoginActivity.this.getActivity())) {
                    V4SelectPlatformActivity.launch(LoginActivity.this.getActivity());
                } else {
                    ToastUtils.show(LoginActivity.this.getActivity(), "勾选同意协议后才能继续");
                }
            }
        }, "提示", "请先选择学校再登录", "#ff6f32fd", "取消", "去选择");
    }
}
