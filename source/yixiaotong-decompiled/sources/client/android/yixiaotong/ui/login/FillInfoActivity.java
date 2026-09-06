package client.android.yixiaotong.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AppAccountManager;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.LocalControllers;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.UserInfoBean;
import client.android.yixiaotong.controller.bean.local.LocalCountDownBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.PrivacyPolicyActivity;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.qrcode.BindingSchoolActivity;
import client.android.yixiaotong.ui.widget.TelEdittext;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.about.LicenseV3Activity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class FillInfoActivity extends BaseActivity {
    public static final int BINDING_SCHOOL_RESULT = 101;
    public static final String EXTRA_CAPTCHACODE = "extra_captchacode";
    public static final String EXTRA_PASSWORD = "extra_password";
    public static final String EXTRA_SCHOOLID = "schoolId";
    public static final String EXTRA_SCHOOLNAME = "schoolName";
    public static final String EXTRA_TELEPHONE = "extra_telephone";
    private Uri imageUri;
    private List<AreasBean> mAreasBeans;
    private String mCaptchaCode;
    ImageView mImgAgree;
    private MaterialDialog mMaterialDialog;
    private String mPassword;
    private AreasBean mSelectAreasBean;
    RadioButton mSexBoyButton;
    RadioButton mSexGrilButton;
    private String mTelePhone;
    TextView mTvSchBinding;
    TextView mTvText;
    Button mVBtnVerify;
    EditText mVEtName;
    EditText mVEtNum;
    EditText mVEtPassword;
    TelEdittext mVEtPhone;
    EditText mVEtVerify;
    TitleBar mVTitleBar;
    private long schoolId;
    private String schoolName;
    ScrollView scrollview;
    EditText vEtAuthorizedPassword;
    EditText vEtIdentification;
    private boolean mIsVerifySuccess = false;
    private boolean mIsEnable = true;
    private boolean mIsAgree = false;

    static {
        StubApp.interface11(7414);
    }

    private void initView() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mVEtName = (EditText) findViewById(R.id.v_et_name);
        this.mVEtNum = (EditText) findViewById(R.id.v_et_num);
        this.mSexBoyButton = (RadioButton) findViewById(R.id.sex_boy);
        this.mSexGrilButton = (RadioButton) findViewById(R.id.sex_girl);
        this.vEtIdentification = (EditText) findViewById(R.id.v_et_identification_id);
        this.mTvSchBinding = (TextView) findViewById(R.id.tv_binding_sch);
        this.vEtAuthorizedPassword = (EditText) findViewById(R.id.v_et_authorizedPassword);
        this.mTvText = (TextView) findViewById(R.id.tv_text);
        this.mVEtPhone = (TelEdittext) findViewById(R.id.v_et_phone);
        this.mVEtPassword = (EditText) findViewById(R.id.v_et_password);
        this.mVEtVerify = (EditText) findViewById(R.id.v_et_verify);
        this.mVBtnVerify = (Button) findViewById(R.id.v_btn_verify);
        this.scrollview = (ScrollView) findViewById(R.id.scrollview);
        this.mImgAgree = (ImageView) findViewById(R.id.iv_agree);
    }

    public static void launch(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) FillInfoActivity.class);
        intent.putExtra(EXTRA_TELEPHONE, str);
        intent.putExtra(EXTRA_PASSWORD, str2);
        intent.putExtra(EXTRA_CAPTCHACODE, str3);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, String str, String str2, String str3, long j, String str4) {
        Intent intent = new Intent(activity, (Class<?>) FillInfoActivity.class);
        intent.putExtra(EXTRA_TELEPHONE, str);
        intent.putExtra(EXTRA_PASSWORD, str2);
        intent.putExtra(EXTRA_CAPTCHACODE, str3);
        intent.putExtra(EXTRA_SCHOOLID, j);
        intent.putExtra(EXTRA_SCHOOLNAME, str4);
        activity.startActivity(intent);
    }

    public static void launch(Activity activity, long j, String str) {
        activity.startActivity(new Intent(activity, (Class<?>) FillInfoActivity.class).putExtra(EXTRA_SCHOOLID, j).putExtra(EXTRA_SCHOOLNAME, str));
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("注册");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    public void initExtraData() {
        this.mTelePhone = getIntent().getStringExtra(EXTRA_TELEPHONE);
        this.mPassword = getIntent().getStringExtra(EXTRA_PASSWORD);
        this.mCaptchaCode = getIntent().getStringExtra(EXTRA_CAPTCHACODE);
    }

    private void initClickListeners() {
        findViewById(R.id.v_btn_next).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m137x9cda81ff(view);
            }
        });
        findViewById(R.id.tv_binding_sch).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m138x2a153380(view);
            }
        });
        findViewById(R.id.v_btn_verify).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m139xb74fe501(view);
            }
        });
        findViewById(R.id.tv_agree1).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m140x448a9682(view);
            }
        });
        findViewById(R.id.tv_agree2).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m141xd1c54803(view);
            }
        });
        findViewById(R.id.iv_agree).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m142x5efff984(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-login-FillInfoActivity, reason: not valid java name */
    /* synthetic */ void m137x9cda81ff(View view) {
        if (check()) {
            MaterialDialog materialDialogBuild = new MaterialDialog.Builder(getActivity()).customView(R.layout.view_confirm_info, true).cancelable(false).positiveText("确定").neutralText("取消").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity.1
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    FillInfoActivity.this.verifySMSCaptcha();
                }
            }).build();
            View customView = materialDialogBuild.getCustomView();
            ((TextView) customView.findViewById(R.id.tv_info_school)).setText(this.mSelectAreasBean.Name);
            ((TextView) customView.findViewById(R.id.tv_info_sid)).setText(this.mVEtNum.getText().toString());
            ((TextView) customView.findViewById(R.id.tv_info_sex)).setText(this.mSexBoyButton.isChecked() ? "男" : "女");
            materialDialogBuild.show();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-login-FillInfoActivity, reason: not valid java name */
    /* synthetic */ void m138x2a153380(View view) {
        startActivityForResult(new Intent(getActivity(), (Class<?>) BindingSchoolActivity.class), 101);
        this.mTvSchBinding.setText("点击扫描绑定学校");
        this.mSelectAreasBean = null;
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-login-FillInfoActivity, reason: not valid java name */
    /* synthetic */ void m139xb74fe501(View view) {
        if (checkPhone()) {
            getVerifyCode();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-ui-login-FillInfoActivity, reason: not valid java name */
    /* synthetic */ void m140x448a9682(View view) {
        LicenseV3Activity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-ui-login-FillInfoActivity, reason: not valid java name */
    /* synthetic */ void m141xd1c54803(View view) {
        PrivacyPolicyActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-ui-login-FillInfoActivity, reason: not valid java name */
    /* synthetic */ void m142x5efff984(View view) {
        if (this.mIsAgree) {
            this.mIsAgree = false;
            this.mImgAgree.setImageResource(R.mipmap.wxz);
        } else {
            this.mIsAgree = true;
            this.mImgAgree.setImageResource(R.mipmap.xz1);
        }
    }

    private void setScroll() {
        final int[] iArr = {0};
        this.scrollview.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                FillInfoActivity fillInfoActivity = FillInfoActivity.this;
                fillInfoActivity.doScrollEvent(fillInfoActivity.scrollview, iArr, FillInfoActivity.this.mVEtNum, FillInfoActivity.this.mVEtPhone, FillInfoActivity.this.mVEtVerify, FillInfoActivity.this.mVEtPassword);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doScrollEvent(ScrollView scrollView, int[] iArr, EditText... editTextArr) {
        Rect rect = new Rect();
        scrollView.getWindowVisibleDisplayFrame(rect);
        int height = scrollView.getHeight() - rect.bottom;
        int scrollY = scrollView.getScrollY();
        for (EditText editText : editTextArr) {
            if (editText.isFocused()) {
                if (height > 100) {
                    int[] iArr2 = new int[2];
                    iArr[0] = scrollY;
                    editText.getLocationInWindow(iArr2);
                    int height2 = editText.getHeight();
                    if (iArr2[1] + height2 > rect.bottom) {
                        scrollView.scrollBy(0, (iArr2[1] + height2) - rect.bottom);
                        return;
                    }
                    return;
                }
                int i = iArr[0];
                if (i != scrollY) {
                    scrollView.scrollTo(0, i);
                }
                iArr[0] = scrollView.getScrollY();
                return;
            }
        }
    }

    private void getVerifyCode() {
        BusinessControllers.getInstance().sendSMSCaptcha(getLoginAccount(), this.mVEtPhone.getString(), 1, null, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FillInfoActivity.this.mIsEnable) {
                    if (successBean.success != 1) {
                        SystemErrorTip.getInstance().showTipDialog(FillInfoActivity.this.getActivity(), "验证码发送失败");
                    } else {
                        FillInfoActivity.this.toast("验证码已发送");
                        FillInfoActivity.this.countDown();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FillInfoActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FillInfoActivity.this.getActivity(), FillInfoActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void countDown() {
        LocalControllers.getInstance().timeCountDown(getLoginAccount(), new Listener<LocalCountDownBean>() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, LocalCountDownBean localCountDownBean, Object... objArr) {
                super.onComplete(controller, localCountDownBean, objArr);
                FillInfoActivity.this.mVBtnVerify.setText(localCountDownBean.time + " s");
                if (!localCountDownBean.complete) {
                    FillInfoActivity.this.mVBtnVerify.setBackground(FillInfoActivity.this.getResources().getDrawable(R.drawable.round_radio_button_gray_background));
                    FillInfoActivity.this.mVBtnVerify.setEnabled(false);
                } else {
                    FillInfoActivity.this.mVBtnVerify.setBackground(FillInfoActivity.this.getResources().getDrawable(R.drawable.round_radius_button_background));
                    FillInfoActivity.this.mVBtnVerify.setEnabled(true);
                    FillInfoActivity.this.mVBtnVerify.setText("重新获取");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifySMSCaptcha() {
        BusinessControllers.getInstance().verifySMSCaptcha(getLoginAccount(), this.mVEtPhone.getString(), this.mVEtVerify.getText().toString(), 1, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (FillInfoActivity.this.mIsEnable) {
                    if (successBean.success == 1) {
                        FillInfoActivity.this.mIsVerifySuccess = true;
                        FillInfoActivity.this.register();
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(FillInfoActivity.this.getActivity(), "验证码错误");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FillInfoActivity.this.mIsEnable) {
                    ErrorUtil.onFailResult(FillInfoActivity.this.getActivity(), FillInfoActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    private boolean check() {
        if (StringUtils.isTrimEmpty(this.mVEtName.getText().toString())) {
            toast("请输入您的姓名");
            return false;
        }
        if (this.mSelectAreasBean == null) {
            toast("请扫描校区二维码");
            return false;
        }
        if (!this.mSexBoyButton.isChecked() && !this.mSexGrilButton.isChecked()) {
            toast("请选择性别");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtNum.getText().toString())) {
            toast("请输入学号");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtPhone.getText().toString())) {
            toast("请输入手机号");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtVerify.getText().toString())) {
            toast("请输入验证码");
            return false;
        }
        if (StringUtils.isTrimEmpty(this.mVEtPassword.getText().toString())) {
            toast("请输入登录密码");
            return false;
        }
        if (this.mVEtPassword.getText().toString().trim().length() < 6) {
            toast("请设置6-16位密码");
            return false;
        }
        if (this.mIsAgree) {
            return true;
        }
        ToastUtils.show(getContext(), "请勾选同意协议后注册");
        return false;
    }

    private boolean checkPhone() {
        if (!StringUtils.isTrimEmpty(this.mVEtPhone.getText().toString())) {
            return true;
        }
        toast("请输入手机号");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void register() {
        this.mTelePhone = this.mVEtPhone.getText().toString().trim().replace(PPSLabelView.Code, "");
        this.mPassword = this.mVEtPassword.getText().toString().trim();
        this.mCaptchaCode = this.mVEtVerify.getText().toString().trim();
        BusinessControllers businessControllers = BusinessControllers.getInstance();
        Account loginAccount = getLoginAccount();
        String str = this.mTelePhone;
        String str2 = this.mPassword;
        businessControllers.register(loginAccount, str, str2, str2, this.mVEtName.getText().toString(), this.mVEtNum.getText().toString(), this.mSexBoyButton.isChecked() ? 1 : 2, "", this.mSelectAreasBean.ID, this.mTelePhone, this.vEtIdentification.getText().toString(), "", this.mCaptchaCode, this.vEtAuthorizedPassword.getText().toString(), new Listener<UserInfoBean>() { // from class: client.android.yixiaotong.ui.login.FillInfoActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                FillInfoActivity.this.mMaterialDialog = new MaterialDialog.Builder(FillInfoActivity.this.getActivity()).content("正在处理中,请稍候...").cancelable(false).progress(true, 0).show();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UserInfoBean userInfoBean, Object... objArr) {
                if (FillInfoActivity.this.mIsEnable) {
                    FillInfoActivity.this.mMaterialDialog.dismiss();
                    ClientDataManager.getInstance().saveOrUpdate(ClientDataManager.LOGIN_ACCOUNT, FillInfoActivity.this.mTelePhone);
                    AppAccountManager.getInstance().initAppAccount();
                    LocalDataUtil.savePlatformSchoolName(FillInfoActivity.this.getActivity(), FillInfoActivity.this.schoolName);
                    LocalDataUtil.savePlatformInfo(BaseApplication.app, 0);
                    ToastUtils.show(FillInfoActivity.this.getContext(), "注册成功");
                    LoginActivity.launch(FillInfoActivity.this.getActivity());
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (FillInfoActivity.this.mIsEnable) {
                    FillInfoActivity.this.mMaterialDialog.dismiss();
                    ErrorUtil.onFailResult(FillInfoActivity.this.getActivity(), FillInfoActivity.this.mVTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            if (i2 == 0 && i == 101) {
                Toast.makeText(getActivity(), "请扫描学校信息二维码", 0).show();
                return;
            }
            return;
        }
        if (i == 101) {
            String stringExtra = intent.getStringExtra(EXTRA_SCHOOLNAME);
            long longExtra = intent.getLongExtra(EXTRA_SCHOOLID, -1L);
            if (longExtra != -1) {
                AreasBean areasBean = new AreasBean();
                this.mSelectAreasBean = areasBean;
                areasBean.ID = longExtra;
                this.mSelectAreasBean.Name = stringExtra;
                this.mTvSchBinding.setText(this.mSelectAreasBean.Name);
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
