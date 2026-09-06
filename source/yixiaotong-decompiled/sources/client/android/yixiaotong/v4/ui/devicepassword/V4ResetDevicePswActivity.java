package client.android.yixiaotong.v4.ui.devicepassword;

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
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ResetDevicePswActivity extends BaseActivity {
    private static final String TAG = "V4ResetDevicePswActivity";
    EditText et10;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;
    EditText et9;
    RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    Button mBtnReset;
    private NativeUtil mNativeUtil;
    private String mOldPsw;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvInputTip;
    TextView mTvPswTip;
    private int mType;
    private boolean mIsEnable = true;
    private int mIndex = 0;
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(10915);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4ResetDevicePswActivity.class).putExtra("type", i).putExtra(SetPswSuccessActivity.EXTRA_PSW, str));
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
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m522x8a044eb4(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$client-android-yixiaotong-v4-ui-devicepassword-V4ResetDevicePswActivity, reason: not valid java name */
    /* synthetic */ void m522x8a044eb4(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        setPsw();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        getAdv();
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
        V4ErrorControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void setPsw() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            ToastUtils.show(getContext(), "请检查是否还有密钥未输入");
            return;
        }
        String str = this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString();
        String string = ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT);
        V4BusinessControllers.getInstance().postSetDevicePassword(getLoginAccount(), string.substring(string.length() - 4), str, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4ResetDevicePswActivity.this.getActivity(), "正在设置密码..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4ResetDevicePswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (V4ResetDevicePswActivity.this.mType == 0) {
                        ToastUtils.show(V4ResetDevicePswActivity.this.getContext(), "创建密钥成功");
                    } else {
                        ToastUtils.show(V4ResetDevicePswActivity.this.getContext(), "修改密钥成功");
                    }
                    V4ResetDevicePswActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ResetDevicePswActivity.this.mIsEnable) {
                    V4ResetDevicePswActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
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

    private void initView() {
        if (this.mType == 1) {
            this.mTvInputTip.setText(getString(R.string.inputnewdevicepass));
            this.mBtnReset.setText(getString(R.string.changedevicepass));
        }
        this.mTvPswTip.setText(String.format(getString(R.string.psw_combination_way_tip3), 4, 10));
        this.et5.requestFocus();
        this.et5.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                V4ResetDevicePswActivity.this.mIndex = 5;
                V4ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et5.getText().toString())) {
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et6.getText().toString())) {
                        V4ResetDevicePswActivity.this.et6.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et7.getText().toString())) {
                        V4ResetDevicePswActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et8.getText().toString())) {
                        V4ResetDevicePswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et9.getText().toString())) {
                        V4ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et10.getText().toString())) {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        V4ResetDevicePswActivity.this.et10.setSelection(V4ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                V4ResetDevicePswActivity.this.et5.requestFocus();
            }
        });
        this.et6.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                V4ResetDevicePswActivity.this.mIndex = 6;
                V4ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et6.getText().toString())) {
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et7.getText().toString())) {
                        V4ResetDevicePswActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et8.getText().toString())) {
                        V4ResetDevicePswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et9.getText().toString())) {
                        V4ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et10.getText().toString())) {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        V4ResetDevicePswActivity.this.et10.setSelection(V4ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                V4ResetDevicePswActivity.this.et5.requestFocus();
                V4ResetDevicePswActivity.this.et5.setSelection(V4ResetDevicePswActivity.this.et5.getText().toString().length());
            }
        });
        this.et7.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                V4ResetDevicePswActivity.this.mIndex = 7;
                V4ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et7.getText().toString())) {
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et8.getText().toString())) {
                        V4ResetDevicePswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et9.getText().toString())) {
                        V4ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et10.getText().toString())) {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        V4ResetDevicePswActivity.this.et10.setSelection(V4ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et6.getText().toString())) {
                    V4ResetDevicePswActivity.this.et6.requestFocus();
                    V4ResetDevicePswActivity.this.et6.setSelection(V4ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    V4ResetDevicePswActivity.this.et5.requestFocus();
                    V4ResetDevicePswActivity.this.et5.setSelection(V4ResetDevicePswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et8.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                V4ResetDevicePswActivity.this.mIndex = 8;
                V4ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et8.getText().toString())) {
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et9.getText().toString())) {
                        V4ResetDevicePswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et10.getText().toString())) {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        V4ResetDevicePswActivity.this.et10.setSelection(V4ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et7.getText().toString())) {
                    V4ResetDevicePswActivity.this.et7.requestFocus();
                    V4ResetDevicePswActivity.this.et7.setSelection(V4ResetDevicePswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et6.getText().toString())) {
                    V4ResetDevicePswActivity.this.et6.requestFocus();
                    V4ResetDevicePswActivity.this.et6.setSelection(V4ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    V4ResetDevicePswActivity.this.et5.requestFocus();
                    V4ResetDevicePswActivity.this.et5.setSelection(V4ResetDevicePswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et9.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                V4ResetDevicePswActivity.this.mIndex = 9;
                V4ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et9.getText().toString())) {
                    if (StringUtils.isEmpty(V4ResetDevicePswActivity.this.et10.getText().toString())) {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        V4ResetDevicePswActivity.this.et10.requestFocus();
                        V4ResetDevicePswActivity.this.et10.setSelection(V4ResetDevicePswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et8.getText().toString())) {
                    V4ResetDevicePswActivity.this.et8.requestFocus();
                    V4ResetDevicePswActivity.this.et8.setSelection(V4ResetDevicePswActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et7.getText().toString())) {
                    V4ResetDevicePswActivity.this.et7.requestFocus();
                    V4ResetDevicePswActivity.this.et7.setSelection(V4ResetDevicePswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et6.getText().toString())) {
                    V4ResetDevicePswActivity.this.et6.requestFocus();
                    V4ResetDevicePswActivity.this.et6.setSelection(V4ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    V4ResetDevicePswActivity.this.et5.requestFocus();
                    V4ResetDevicePswActivity.this.et5.setSelection(V4ResetDevicePswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et10.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                V4ResetDevicePswActivity.this.mIndex = 10;
                V4ResetDevicePswActivity.this.initButtonView();
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et10.getText().toString())) {
                    return;
                }
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et9.getText().toString())) {
                    V4ResetDevicePswActivity.this.et9.requestFocus();
                    V4ResetDevicePswActivity.this.et9.setSelection(V4ResetDevicePswActivity.this.et9.getText().toString().length());
                    return;
                }
                if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et8.getText().toString())) {
                    V4ResetDevicePswActivity.this.et8.requestFocus();
                    V4ResetDevicePswActivity.this.et8.setSelection(V4ResetDevicePswActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et7.getText().toString())) {
                    V4ResetDevicePswActivity.this.et7.requestFocus();
                    V4ResetDevicePswActivity.this.et7.setSelection(V4ResetDevicePswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(V4ResetDevicePswActivity.this.et6.getText().toString())) {
                    V4ResetDevicePswActivity.this.et6.requestFocus();
                    V4ResetDevicePswActivity.this.et6.setSelection(V4ResetDevicePswActivity.this.et6.getText().toString().length());
                } else {
                    V4ResetDevicePswActivity.this.et5.requestFocus();
                    V4ResetDevicePswActivity.this.et5.setSelection(V4ResetDevicePswActivity.this.et5.getText().toString().length());
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

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity.8
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                V4ResetDevicePswActivity.this.mIsShowAdv = true;
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            this.mNativeUtil.initNative(getActivity(), this.mAdvListener, 1);
            this.mNativeUtil.onNative(this.flContainer);
        }
    }
}
