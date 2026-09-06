package client.android.yixiaotong.ui.drinkwater;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.orderhamam.SetPswSuccessActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ResetDevicePswOldActivity extends BaseActivity {
    private EditText et1;
    private EditText et10;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private EditText et5;
    private EditText et6;
    private EditText et7;
    private EditText et8;
    private EditText et9;
    private Button mBtnReset;
    private String mOldPsw;
    private TitleBar mTitleBar;
    private TextView mTvInputTip;
    private int mType;
    private boolean mIsEnable = true;
    private int mIndex = 0;

    static {
        StubApp.interface11(7136);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, int i, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ResetDevicePswOldActivity.class).putExtra("type", i).putExtra(SetPswSuccessActivity.EXTRA_PSW, str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvInputTip = (TextView) findViewById(R.id.tv_inputtip);
        this.et1 = (EditText) findViewById(R.id.et1);
        this.et2 = (EditText) findViewById(R.id.et2);
        this.et3 = (EditText) findViewById(R.id.et3);
        this.et4 = (EditText) findViewById(R.id.et4);
        this.et5 = (EditText) findViewById(R.id.et5);
        this.et6 = (EditText) findViewById(R.id.et6);
        this.et7 = (EditText) findViewById(R.id.et7);
        this.et8 = (EditText) findViewById(R.id.et8);
        this.et9 = (EditText) findViewById(R.id.et9);
        this.et10 = (EditText) findViewById(R.id.et10);
        this.mBtnReset = (Button) findViewById(R.id.btn_reset);
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

    private void initClickListeners() {
        findViewById(R.id.btn_reset).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m127x340f0794(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-drinkwater-ResetDevicePswOldActivity, reason: not valid java name */
    /* synthetic */ void m127x340f0794(View view) {
        if (this.mType == 0) {
            setPsw();
        } else {
            changePsw();
        }
    }

    private void setPsw() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            ToastUtils.show(getContext(), "请检查是否还有密钥未输入");
        } else {
            BusinessControllers.getInstance().addPassword(getLoginAccount(), this.et1.getText().toString() + this.et2.getText().toString() + this.et3.getText().toString() + this.et4.getText().toString() + this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(ResetDevicePswOldActivity.this.getActivity(), "正在设置密码..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (ResetDevicePswOldActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        if (successBean != null) {
                            if (ResetDevicePswOldActivity.this.mType == 0) {
                                ToastUtils.show(ResetDevicePswOldActivity.this.getContext(), "创建密钥成功");
                            } else {
                                ToastUtils.show(ResetDevicePswOldActivity.this.getContext(), "修改密钥成功");
                            }
                            ResetDevicePswOldActivity.this.finish();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (ResetDevicePswOldActivity.this.mIsEnable) {
                        ResetDevicePswOldActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    private void changePsw() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            ToastUtils.show(getContext(), "请检查是否还有密钥未输入");
        } else {
            BusinessControllers.getInstance().updatePassword(getLoginAccount(), this.mOldPsw, this.et1.getText().toString() + this.et2.getText().toString() + this.et3.getText().toString() + this.et4.getText().toString() + this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(ResetDevicePswOldActivity.this.getActivity(), "正在修改密码..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (ResetDevicePswOldActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        if (successBean != null) {
                            if (ResetDevicePswOldActivity.this.mType == 0) {
                                ToastUtils.show(ResetDevicePswOldActivity.this.getContext(), "创建密钥成功");
                            } else {
                                ToastUtils.show(ResetDevicePswOldActivity.this.getContext(), "修改密钥成功");
                            }
                            ResetDevicePswOldActivity.this.finish();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (ResetDevicePswOldActivity.this.mIsEnable) {
                        ResetDevicePswOldActivity.this.onError(clientException);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        ErrorUtil.onFailResult(getActivity(), this.mTitleBar.getTitleViewContent(), clientException, false);
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
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().LoginAccount;
        String strSubstring = str.substring(str.length() - 4);
        this.et1.setText(strSubstring.substring(0, 1));
        this.et2.setText(strSubstring.substring(1, 2));
        this.et3.setText(strSubstring.substring(2, 3));
        this.et4.setText(strSubstring.substring(3, 4));
        this.et1.setEnabled(false);
        this.et2.setEnabled(false);
        this.et3.setEnabled(false);
        this.et4.setEnabled(false);
        this.et5.requestFocus();
        this.et5.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswOldActivity.this.mIndex = 5;
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et5.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et6.getText().toString())) {
                        ResetDevicePswOldActivity.this.et6.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et7.getText().toString())) {
                        ResetDevicePswOldActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et8.getText().toString())) {
                        ResetDevicePswOldActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et9.getText().toString())) {
                        ResetDevicePswOldActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et10.getText().toString())) {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        ResetDevicePswOldActivity.this.et10.setSelection(ResetDevicePswOldActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                ResetDevicePswOldActivity.this.et5.requestFocus();
            }
        });
        this.et6.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswOldActivity.this.mIndex = 6;
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et6.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et7.getText().toString())) {
                        ResetDevicePswOldActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et8.getText().toString())) {
                        ResetDevicePswOldActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et9.getText().toString())) {
                        ResetDevicePswOldActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et10.getText().toString())) {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        ResetDevicePswOldActivity.this.et10.setSelection(ResetDevicePswOldActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                ResetDevicePswOldActivity.this.et5.requestFocus();
                ResetDevicePswOldActivity.this.et5.setSelection(ResetDevicePswOldActivity.this.et5.getText().toString().length());
            }
        });
        this.et7.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswOldActivity.this.mIndex = 7;
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et7.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et8.getText().toString())) {
                        ResetDevicePswOldActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et9.getText().toString())) {
                        ResetDevicePswOldActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et10.getText().toString())) {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        ResetDevicePswOldActivity.this.et10.setSelection(ResetDevicePswOldActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et6.getText().toString())) {
                    ResetDevicePswOldActivity.this.et6.requestFocus();
                    ResetDevicePswOldActivity.this.et6.setSelection(ResetDevicePswOldActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswOldActivity.this.et5.requestFocus();
                    ResetDevicePswOldActivity.this.et5.setSelection(ResetDevicePswOldActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et8.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswOldActivity.this.mIndex = 8;
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et8.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et9.getText().toString())) {
                        ResetDevicePswOldActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et10.getText().toString())) {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        ResetDevicePswOldActivity.this.et10.setSelection(ResetDevicePswOldActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et7.getText().toString())) {
                    ResetDevicePswOldActivity.this.et7.requestFocus();
                    ResetDevicePswOldActivity.this.et7.setSelection(ResetDevicePswOldActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et6.getText().toString())) {
                    ResetDevicePswOldActivity.this.et6.requestFocus();
                    ResetDevicePswOldActivity.this.et6.setSelection(ResetDevicePswOldActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswOldActivity.this.et5.requestFocus();
                    ResetDevicePswOldActivity.this.et5.setSelection(ResetDevicePswOldActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et9.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswOldActivity.this.mIndex = 9;
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et9.getText().toString())) {
                    if (StringUtils.isEmpty(ResetDevicePswOldActivity.this.et10.getText().toString())) {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        return;
                    } else {
                        ResetDevicePswOldActivity.this.et10.requestFocus();
                        ResetDevicePswOldActivity.this.et10.setSelection(ResetDevicePswOldActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et8.getText().toString())) {
                    ResetDevicePswOldActivity.this.et8.requestFocus();
                    ResetDevicePswOldActivity.this.et8.setSelection(ResetDevicePswOldActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et7.getText().toString())) {
                    ResetDevicePswOldActivity.this.et7.requestFocus();
                    ResetDevicePswOldActivity.this.et7.setSelection(ResetDevicePswOldActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et6.getText().toString())) {
                    ResetDevicePswOldActivity.this.et6.requestFocus();
                    ResetDevicePswOldActivity.this.et6.setSelection(ResetDevicePswOldActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswOldActivity.this.et5.requestFocus();
                    ResetDevicePswOldActivity.this.et5.setSelection(ResetDevicePswOldActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et10.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.drinkwater.ResetDevicePswOldActivity.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ResetDevicePswOldActivity.this.mIndex = 10;
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et10.getText().toString())) {
                    return;
                }
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et9.getText().toString())) {
                    ResetDevicePswOldActivity.this.et9.requestFocus();
                    ResetDevicePswOldActivity.this.et9.setSelection(ResetDevicePswOldActivity.this.et9.getText().toString().length());
                    return;
                }
                if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et8.getText().toString())) {
                    ResetDevicePswOldActivity.this.et8.requestFocus();
                    ResetDevicePswOldActivity.this.et8.setSelection(ResetDevicePswOldActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et7.getText().toString())) {
                    ResetDevicePswOldActivity.this.et7.requestFocus();
                    ResetDevicePswOldActivity.this.et7.setSelection(ResetDevicePswOldActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(ResetDevicePswOldActivity.this.et6.getText().toString())) {
                    ResetDevicePswOldActivity.this.et6.requestFocus();
                    ResetDevicePswOldActivity.this.et6.setSelection(ResetDevicePswOldActivity.this.et6.getText().toString().length());
                } else {
                    ResetDevicePswOldActivity.this.et5.requestFocus();
                    ResetDevicePswOldActivity.this.et5.setSelection(ResetDevicePswOldActivity.this.et5.getText().toString().length());
                }
            }
        });
    }
}
