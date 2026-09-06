package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.doorlock.SubmitUserInformationBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AuthenticationActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "rxtra_wallet";
    private Button mBtnVerify;
    private EditText mEtIdentfication;
    private EditText mEtName;
    private ImageView mImgBoy;
    private ImageView mImgGirl;
    private String mMsg;
    private RelativeLayout mRelBoy;
    private RelativeLayout mRelGirl;
    private RelativeLayout mRelIdentity;
    private RelativeLayout mRelStudentNo;
    private TitleBar mTitleBar;
    private TextView mTvOtherWay;
    private WalletModel mWalletModel;
    private int mSelectIndex = -1;
    private boolean mIsEnableBtn = false;
    private boolean mIsEnable = true;
    private int mUsedCount = 0;

    static {
        StubApp.interface11(6919);
    }

    static /* synthetic */ void lambda$initClickListeners$3(View view) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$308(AuthenticationActivity authenticationActivity) {
        int i = authenticationActivity.mUsedCount;
        authenticationActivity.mUsedCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AuthenticationActivity.class).putExtra(EXTRA_WALLET, walletModel));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mEtName = (EditText) findViewById(R.id.et_name);
        this.mRelBoy = (RelativeLayout) findViewById(R.id.rel_boy);
        this.mRelGirl = (RelativeLayout) findViewById(R.id.rel_girl);
        this.mImgBoy = (ImageView) findViewById(R.id.img_boy);
        this.mImgGirl = (ImageView) findViewById(R.id.img_girl);
        this.mEtIdentfication = (EditText) findViewById(R.id.et_identification);
        this.mBtnVerify = (Button) findViewById(R.id.btn_verify);
        this.mTvOtherWay = (TextView) findViewById(R.id.tv_otherway);
        this.mRelIdentity = (RelativeLayout) findViewById(R.id.rel_identity);
        this.mRelStudentNo = (RelativeLayout) findViewById(R.id.rel_studentno);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("验证身份");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        this.mEtName.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AuthenticationActivity.this.setBtnBackground();
            }
        });
        this.mEtName.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity.2
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
        this.mEtIdentfication.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AuthenticationActivity.this.setBtnBackground();
            }
        });
        this.mEtIdentfication.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity.4
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        });
    }

    private void initClickListeners() {
        findViewById(R.id.btn_verify).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m96x78b7a5a0(view);
            }
        });
        findViewById(R.id.rel_boy).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m97xcf6153f(view);
            }
        });
        findViewById(R.id.rel_girl).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m98xa13484de(view);
            }
        });
        findViewById(R.id.tv_otherway).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AuthenticationActivity.lambda$initClickListeners$3(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-AuthenticationActivity, reason: not valid java name */
    /* synthetic */ void m96x78b7a5a0(View view) {
        if (isCkeckInput()) {
            postInfo();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-ui-doorlock-AuthenticationActivity, reason: not valid java name */
    /* synthetic */ void m97xcf6153f(View view) {
        this.mSelectIndex = 1;
        this.mImgBoy.setImageResource(R.drawable.radio_check);
        this.mImgGirl.setImageResource(R.drawable.radio_uncheck);
        setBtnBackground();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-ui-doorlock-AuthenticationActivity, reason: not valid java name */
    /* synthetic */ void m98xa13484de(View view) {
        this.mSelectIndex = 2;
        this.mImgGirl.setImageResource(R.drawable.radio_check);
        this.mImgBoy.setImageResource(R.drawable.radio_uncheck);
        setBtnBackground();
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private boolean isEnableBtn() {
        if (StringUtils.isNotEmpty(this.mEtIdentfication.getText().toString()) && StringUtils.isNotEmpty(this.mEtName.getText().toString()) && this.mSelectIndex != -1) {
            this.mIsEnableBtn = true;
        } else {
            this.mIsEnableBtn = false;
        }
        return this.mIsEnableBtn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBtnBackground() {
        if (isEnableBtn()) {
            this.mBtnVerify.setBackgroundResource(R.mipmap.l_btn_doorlock_background);
        } else {
            this.mBtnVerify.setBackgroundResource(R.drawable.round_radio_button_gray_background);
        }
    }

    private boolean isCkeckInput() {
        if (StringUtils.isEmpty(this.mEtName.getText().toString().replace(PPSLabelView.Code, ""))) {
            ToastUtils.show(getContext(), "请输入姓名");
            return false;
        }
        if (this.mSelectIndex == -1) {
            ToastUtils.show(getContext(), "请选择性别");
            return false;
        }
        if (!StringUtils.isEmpty(this.mEtIdentfication.getText().toString().replace(PPSLabelView.Code, ""))) {
            return true;
        }
        ToastUtils.show(getContext(), "请输入身份证");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCountDialog(int i) {
        if (this.mUsedCount >= i) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "验证失败", this.mMsg, "确定", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity.5
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    AuthenticationActivity.this.finish();
                }
            });
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "验证失败", this.mMsg, "确定");
        }
    }

    private void postInfo() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().postSubmitUserInformation(getLoginAccount(), this.mWalletModel.typeId, randNumMaxString, this.mEtName.getText().toString().replace(PPSLabelView.Code, ""), this.mEtIdentfication.getText().toString().replace(PPSLabelView.Code, ""), this.mSelectIndex, this.mUsedCount + 1, new Listener<SubmitUserInformationBean>() { // from class: client.android.yixiaotong.ui.doorlock.AuthenticationActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(AuthenticationActivity.this.getActivity(), "正在提交..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SubmitUserInformationBean submitUserInformationBean, Object... objArr) {
                if (AuthenticationActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (submitUserInformationBean == null || !submitUserInformationBean.random.equals(randNumMaxString)) {
                        SystemErrorTip.getInstance().showTipDialog(AuthenticationActivity.this.getActivity(), "提交信息失败");
                        return;
                    }
                    AuthenticationActivity.access$308(AuthenticationActivity.this);
                    LocalBusinessStore.saveDoorLockAuthCount(AuthenticationActivity.this.getContext(), AuthenticationActivity.this.mUsedCount);
                    LocalBusinessStore.saveDoorLockMaxAuthCount(AuthenticationActivity.this.getContext(), submitUserInformationBean.size);
                    if (submitUserInformationBean.type == 2) {
                        AuthenticationSuccessActivity.launch(AuthenticationActivity.this.getActivity(), AuthenticationActivity.this.mWalletModel, submitUserInformationBean.info);
                        AuthenticationActivity.this.finish();
                    } else if (submitUserInformationBean.type == 0) {
                        AuthenticationActivity.this.mMsg = StringUtils.isNotEmpty(submitUserInformationBean.message) ? submitUserInformationBean.message : "身份证不匹配";
                        AuthenticationActivity.this.showCountDialog(submitUserInformationBean.size);
                    } else if (submitUserInformationBean.type == 1) {
                        AuthenticationActivity.this.mMsg = StringUtils.isNotEmpty(submitUserInformationBean.message) ? submitUserInformationBean.message : "身份证正确，其他项错误";
                        AuthenticationActivity.this.showCountDialog(submitUserInformationBean.size);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AuthenticationActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ErrorUtil.onFailResult(AuthenticationActivity.this.getActivity(), AuthenticationActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
                }
            }
        });
    }
}
