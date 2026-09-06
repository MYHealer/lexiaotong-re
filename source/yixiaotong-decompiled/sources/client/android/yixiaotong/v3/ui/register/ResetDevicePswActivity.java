package client.android.yixiaotong.v3.ui.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.DevicePswRuleBean;
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ResetDevicePswActivity extends BaseActivity {
    private static final int PSWFIXEDLENGTH = 6;
    private EditText et10;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;
    private EditText et9;
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private Button mBtnReset;
    private String mLeftPsw;
    private NativeUtil mNativeUtil;
    private String mOldPsw;
    private int mPswLength;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvInputTip;
    private TextView mTvPswTip;
    private int mType;
    private boolean mIsEnable = true;
    private int mIndex = 0;
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(10145);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ResetDevicePswActivity.class).putExtra("type", i).putExtra(SetPswSuccessActivity.EXTRA_PSW, str));
        }
    }

    public static void launch(Activity activity, int i, int i2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ResetDevicePswActivity.class).putExtra("type", i).putExtra("pswlength", i2));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvInputTip = (TextView) findViewById(R.id.tv_inputtip);
        this.et5 = (EditText) findViewById(R.id.et5);
        this.et6 = (EditText) findViewById(R.id.et6);
        this.et7 = (EditText) findViewById(R.id.et7);
        this.et8 = (EditText) findViewById(R.id.et8);
        this.et9 = (EditText) findViewById(R.id.et9);
        this.et10 = (EditText) findViewById(R.id.et10);
        this.mTvPswTip = (TextView) findViewById(R.id.tv_pwstip);
        this.mBtnReset = (Button) findViewById(R.id.btn_reset);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        if (this.mType == 1) {
            this.mTitleBar.setTitleView(getString(R.string.reset_psw));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.createpass));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getAdv();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m405x46510381(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-register-ResetDevicePswActivity, reason: not valid java name */
    /* synthetic */ void m405x46510381(View view) {
        handleResetAction();
    }

    private void handleResetAction() {
        if (this.mType == 0) {
            setPsw();
        } else {
            changePsw();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity$1, reason: invalid class name */
    class AnonymousClass1 extends Listener<DevicePswRuleBean> {
        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
            super.onStart(controller);
            BaseMaterialDialog.showMaterialDialog(ResetDevicePswActivity.this.getActivity(), "正在加载中", false);
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, DevicePswRuleBean devicePswRuleBean, Object... objArr) {
            super.onComplete(controller, devicePswRuleBean, objArr);
            if (ResetDevicePswActivity.this.mIsEnable) {
                BaseMaterialDialog.dissmisMaterialDialog();
                ResetDevicePswActivity.this.mPswLength = devicePswRuleBean.prefixNum + 6;
                ResetDevicePswActivity.this.initView();
            }
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, ClientException clientException) {
            super.onFail(controller, clientException);
            if (ResetDevicePswActivity.this.mIsEnable) {
                ErrorUtil.onFailResult(ResetDevicePswActivity.this.getActivity(), ResetDevicePswActivity.this.mTitleBar.getTitleViewContent(), clientException, true);
            }
        }
    }

    private void getPswRule() {
        this.mPswLength = 10;
        initView();
    }

    private void setPsw() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            ToastUtils.show(getContext(), "请检查是否还有密钥未输入");
            return;
        }
        V3BusinessControllers.getInstance().postSetMachinePWD(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), this.mLeftPsw + this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString(), new Listener<PswBean>() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ResetDevicePswActivity.this.getActivity(), "正在设置密码..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PswBean pswBean, Object... objArr) {
                if (ResetDevicePswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (pswBean != null) {
                        if (ResetDevicePswActivity.this.mType == 0) {
                            ToastUtils.show(ResetDevicePswActivity.this.getContext(), "创建密钥成功");
                        } else {
                            ToastUtils.show(ResetDevicePswActivity.this.getContext(), "修改密钥成功");
                        }
                        ResetDevicePswActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ResetDevicePswActivity.this.mIsEnable) {
                    ResetDevicePswActivity.this.onError(clientException);
                }
            }
        });
    }

    private void changePsw() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            ToastUtils.show(getContext(), "请检查是否还有密钥未输入");
            return;
        }
        V3BusinessControllers.getInstance().postUpdateMachinePWD(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", this.mLeftPsw + this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString(), this.mOldPsw, new Listener<PswBean>() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(ResetDevicePswActivity.this.getActivity(), "正在修改密码..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PswBean pswBean, Object... objArr) {
                if (ResetDevicePswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (pswBean != null) {
                        if (ResetDevicePswActivity.this.mType == 0) {
                            ToastUtils.show(ResetDevicePswActivity.this.getContext(), "创建密钥成功");
                        } else {
                            ToastUtils.show(ResetDevicePswActivity.this.getContext(), "修改密钥成功");
                        }
                        ResetDevicePswActivity.this.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (ResetDevicePswActivity.this.mIsEnable) {
                    ResetDevicePswActivity.this.onError(clientException);
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

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 67) {
            if (keyEvent.getAction() == 0) {
                this.mIndex = 0;
            } else if (keyEvent.getAction() == 1) {
                switch (this.mIndex) {
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                        break;
                    default:
                        if (StringUtils.isNotEmpty(this.et10.getText().toString())) {
                            this.et10.requestFocus();
                            EditText editText = this.et10;
                            editText.setSelection(editText.getText().toString().length());
                        } else if (StringUtils.isNotEmpty(this.et9.getText().toString())) {
                            this.et9.requestFocus();
                            EditText editText2 = this.et9;
                            editText2.setSelection(editText2.getText().toString().length());
                        } else if (StringUtils.isNotEmpty(this.et8.getText().toString())) {
                            this.et8.requestFocus();
                            EditText editText3 = this.et8;
                            editText3.setSelection(editText3.getText().toString().length());
                        } else if (StringUtils.isNotEmpty(this.et7.getText().toString())) {
                            this.et7.requestFocus();
                            EditText editText4 = this.et7;
                            editText4.setSelection(editText4.getText().toString().length());
                        } else if (StringUtils.isNotEmpty(this.et6.getText().toString())) {
                            this.et6.requestFocus();
                            EditText editText5 = this.et6;
                            editText5.setSelection(editText5.getText().toString().length());
                        } else {
                            this.et5.requestFocus();
                            EditText editText6 = this.et5;
                            editText6.setSelection(editText6.getText().toString().length());
                        }
                        break;
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        if (this.mType == 1) {
            this.mTvInputTip.setText(getString(R.string.inputnewdevicepass));
            this.mBtnReset.setText(getString(R.string.changedevicepass));
        }
        this.mTvPswTip.setText(String.format(getString(R.string.psw_combination_way_tip3), Integer.valueOf(this.mPswLength - 6), Integer.valueOf(this.mPswLength)));
        if (this.mPswLength == 6) {
            this.mTvPswTip.setText(getString(R.string.psw_combination_way_tip2));
        }
        String str = UserInfoUtil.getInstance().getLoginAccountV3().studentMobile;
        this.mLeftPsw = str.substring((str.length() - this.mPswLength) + 6);
        this.et5.requestFocus();
        this.et5.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswActivity.this.mIndex = 5;
                ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et5.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et6.getText().toString())) {
                        ResetDevicePswActivity.this.et6.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et7.getText().toString())) {
                        ResetDevicePswActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et8.getText().toString())) {
                        ResetDevicePswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et9.getText().toString())) {
                        ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswActivity.this.et10.getText().toString())) {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        ResetDevicePswActivity.this.et10.setSelection(ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                ResetDevicePswActivity.this.et5.requestFocus();
            }
        });
        this.et6.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswActivity.this.mIndex = 6;
                ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et6.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et7.getText().toString())) {
                        ResetDevicePswActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et8.getText().toString())) {
                        ResetDevicePswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et9.getText().toString())) {
                        ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswActivity.this.et10.getText().toString())) {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        ResetDevicePswActivity.this.et10.setSelection(ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                ResetDevicePswActivity.this.et5.requestFocus();
                ResetDevicePswActivity.this.et5.setSelection(ResetDevicePswActivity.this.et5.getText().toString().length());
            }
        });
        this.et7.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswActivity.this.mIndex = 7;
                ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et7.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et8.getText().toString())) {
                        ResetDevicePswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et9.getText().toString())) {
                        ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswActivity.this.et10.getText().toString())) {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        ResetDevicePswActivity.this.et10.setSelection(ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et6.getText().toString())) {
                    ResetDevicePswActivity.this.et6.requestFocus();
                    ResetDevicePswActivity.this.et6.setSelection(ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswActivity.this.et5.requestFocus();
                    ResetDevicePswActivity.this.et5.setSelection(ResetDevicePswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et8.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswActivity.this.mIndex = 8;
                ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et8.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et9.getText().toString())) {
                        ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswActivity.this.et10.getText().toString())) {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        ResetDevicePswActivity.this.et10.setSelection(ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et7.getText().toString())) {
                    ResetDevicePswActivity.this.et7.requestFocus();
                    ResetDevicePswActivity.this.et7.setSelection(ResetDevicePswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et6.getText().toString())) {
                    ResetDevicePswActivity.this.et6.requestFocus();
                    ResetDevicePswActivity.this.et6.setSelection(ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswActivity.this.et5.requestFocus();
                    ResetDevicePswActivity.this.et5.setSelection(ResetDevicePswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et9.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswActivity.this.mIndex = 9;
                ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et9.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswActivity.this.et10.getText().toString())) {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswActivity.this.et10.requestFocus();
                        ResetDevicePswActivity.this.et10.setSelection(ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et8.getText().toString())) {
                    ResetDevicePswActivity.this.et8.requestFocus();
                    ResetDevicePswActivity.this.et8.setSelection(ResetDevicePswActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et7.getText().toString())) {
                    ResetDevicePswActivity.this.et7.requestFocus();
                    ResetDevicePswActivity.this.et7.setSelection(ResetDevicePswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et6.getText().toString())) {
                    ResetDevicePswActivity.this.et6.requestFocus();
                    ResetDevicePswActivity.this.et6.setSelection(ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswActivity.this.et5.requestFocus();
                    ResetDevicePswActivity.this.et5.setSelection(ResetDevicePswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et10.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswActivity.this.mIndex = 10;
                ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et10.getText().toString())) {
                    return;
                }
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et9.getText().toString())) {
                    ResetDevicePswActivity.this.et9.requestFocus();
                    ResetDevicePswActivity.this.et9.setSelection(ResetDevicePswActivity.this.et9.getText().toString().length());
                    return;
                }
                if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et8.getText().toString())) {
                    ResetDevicePswActivity.this.et8.requestFocus();
                    ResetDevicePswActivity.this.et8.setSelection(ResetDevicePswActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et7.getText().toString())) {
                    ResetDevicePswActivity.this.et7.requestFocus();
                    ResetDevicePswActivity.this.et7.setSelection(ResetDevicePswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswActivity.this.et6.getText().toString())) {
                    ResetDevicePswActivity.this.et6.requestFocus();
                    ResetDevicePswActivity.this.et6.setSelection(ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswActivity.this.et5.requestFocus();
                    ResetDevicePswActivity.this.et5.setSelection(ResetDevicePswActivity.this.et5.getText().toString().length());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initButtonView() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            this.mBtnReset.setBackgroundResource(R.drawable.shape_dark_gray_button);
        } else {
            this.mBtnReset.setBackgroundResource(R.drawable.shape_6f32fd_round_background);
        }
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity.10
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    ResetDevicePswActivity.this.mNativeUtil.initNative(ResetDevicePswActivity.this.getActivity(), ResetDevicePswActivity.this.mAdvListener, 1);
                    ResetDevicePswActivity.this.mNativeUtil.onNative(ResetDevicePswActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                ResetDevicePswActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
