package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.hamam.BathHousePasswordBean;
import client.android.yixiaotong.controller.bean.hamam.HamamIsBindBean;
import client.android.yixiaotong.controller.bean.hamam.HamamVerifyAuthPasswordSecurity;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.BindhamamDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamSetPswActivity extends BaseActivity {
    public static final String EXTRA_WALLET = "extra_wallet";
    EditText et1;
    EditText et10;
    EditText et2;
    EditText et3;
    EditText et4;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;
    EditText et9;
    Button mBtnNext;
    private int mIndex = 0;
    private boolean mIsEnable = true;
    TitleBar mTitleBar;
    private WalletModel mWalletModel;

    static {
        StubApp.interface11(7383);
    }

    private void initDialog() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamSetPswActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mBtnNext = (Button) findViewById(R.id.v_btn_next);
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
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设置密钥");
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
        this.et5.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HamamSetPswActivity.this.mIndex = 5;
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et5.getText().toString())) {
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et6.getText().toString())) {
                        HamamSetPswActivity.this.et6.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et7.getText().toString())) {
                        HamamSetPswActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et8.getText().toString())) {
                        HamamSetPswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et9.getText().toString())) {
                        HamamSetPswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(HamamSetPswActivity.this.et10.getText().toString())) {
                        HamamSetPswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        HamamSetPswActivity.this.et10.requestFocus();
                        HamamSetPswActivity.this.et10.setSelection(HamamSetPswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                HamamSetPswActivity.this.et5.requestFocus();
            }
        });
        this.et6.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HamamSetPswActivity.this.mIndex = 6;
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et6.getText().toString())) {
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et7.getText().toString())) {
                        HamamSetPswActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et8.getText().toString())) {
                        HamamSetPswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et9.getText().toString())) {
                        HamamSetPswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(HamamSetPswActivity.this.et10.getText().toString())) {
                        HamamSetPswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        HamamSetPswActivity.this.et10.requestFocus();
                        HamamSetPswActivity.this.et10.setSelection(HamamSetPswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                HamamSetPswActivity.this.et5.requestFocus();
                HamamSetPswActivity.this.et5.setSelection(HamamSetPswActivity.this.et5.getText().toString().length());
            }
        });
        this.et7.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HamamSetPswActivity.this.mIndex = 7;
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et7.getText().toString())) {
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et8.getText().toString())) {
                        HamamSetPswActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et9.getText().toString())) {
                        HamamSetPswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(HamamSetPswActivity.this.et10.getText().toString())) {
                        HamamSetPswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        HamamSetPswActivity.this.et10.requestFocus();
                        HamamSetPswActivity.this.et10.setSelection(HamamSetPswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et6.getText().toString())) {
                    HamamSetPswActivity.this.et6.requestFocus();
                    HamamSetPswActivity.this.et6.setSelection(HamamSetPswActivity.this.et6.getText().toString().length());
                } else {
                    HamamSetPswActivity.this.et5.requestFocus();
                    HamamSetPswActivity.this.et5.setSelection(HamamSetPswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et8.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HamamSetPswActivity.this.mIndex = 8;
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et8.getText().toString())) {
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et9.getText().toString())) {
                        HamamSetPswActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(HamamSetPswActivity.this.et10.getText().toString())) {
                        HamamSetPswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        HamamSetPswActivity.this.et10.requestFocus();
                        HamamSetPswActivity.this.et10.setSelection(HamamSetPswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et7.getText().toString())) {
                    HamamSetPswActivity.this.et7.requestFocus();
                    HamamSetPswActivity.this.et7.setSelection(HamamSetPswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et6.getText().toString())) {
                    HamamSetPswActivity.this.et6.requestFocus();
                    HamamSetPswActivity.this.et6.setSelection(HamamSetPswActivity.this.et6.getText().toString().length());
                } else {
                    HamamSetPswActivity.this.et5.requestFocus();
                    HamamSetPswActivity.this.et5.setSelection(HamamSetPswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et9.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HamamSetPswActivity.this.mIndex = 9;
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et9.getText().toString())) {
                    if (StringUtils.isEmpty(HamamSetPswActivity.this.et10.getText().toString())) {
                        HamamSetPswActivity.this.et10.requestFocus();
                        return;
                    } else {
                        HamamSetPswActivity.this.et10.requestFocus();
                        HamamSetPswActivity.this.et10.setSelection(HamamSetPswActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et8.getText().toString())) {
                    HamamSetPswActivity.this.et8.requestFocus();
                    HamamSetPswActivity.this.et8.setSelection(HamamSetPswActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et7.getText().toString())) {
                    HamamSetPswActivity.this.et7.requestFocus();
                    HamamSetPswActivity.this.et7.setSelection(HamamSetPswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et6.getText().toString())) {
                    HamamSetPswActivity.this.et6.requestFocus();
                    HamamSetPswActivity.this.et6.setSelection(HamamSetPswActivity.this.et6.getText().toString().length());
                } else {
                    HamamSetPswActivity.this.et5.requestFocus();
                    HamamSetPswActivity.this.et5.setSelection(HamamSetPswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et10.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                HamamSetPswActivity.this.mIndex = 10;
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et10.getText().toString())) {
                    return;
                }
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et9.getText().toString())) {
                    HamamSetPswActivity.this.et9.requestFocus();
                    HamamSetPswActivity.this.et9.setSelection(HamamSetPswActivity.this.et9.getText().toString().length());
                    return;
                }
                if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et8.getText().toString())) {
                    HamamSetPswActivity.this.et8.requestFocus();
                    HamamSetPswActivity.this.et8.setSelection(HamamSetPswActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et7.getText().toString())) {
                    HamamSetPswActivity.this.et7.requestFocus();
                    HamamSetPswActivity.this.et7.setSelection(HamamSetPswActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(HamamSetPswActivity.this.et6.getText().toString())) {
                    HamamSetPswActivity.this.et6.requestFocus();
                    HamamSetPswActivity.this.et6.setSelection(HamamSetPswActivity.this.et6.getText().toString().length());
                } else {
                    HamamSetPswActivity.this.et5.requestFocus();
                    HamamSetPswActivity.this.et5.setSelection(HamamSetPswActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.mBtnNext.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HamamSetPswActivity.this.setPswNew();
            }
        });
    }

    private void setPsw() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            ToastUtils.show(getContext(), "请检查是否还有密钥未输入");
        } else {
            final String str = this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString();
            BusinessControllers.getInstance().setShouQuanPassword(getLoginAccount(), str, new Listener<HamamVerifyAuthPasswordSecurity>() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.8
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, HamamVerifyAuthPasswordSecurity hamamVerifyAuthPasswordSecurity, Object... objArr) {
                    if (HamamSetPswActivity.this.mIsEnable) {
                        if (hamamVerifyAuthPasswordSecurity == null || hamamVerifyAuthPasswordSecurity.result != 1) {
                            SystemErrorTip.getInstance().showTipDialog(HamamSetPswActivity.this.getActivity(), "设置密钥失败，请重试！");
                            return;
                        }
                        ToastUtils.show(HamamSetPswActivity.this.getContext(), "设置密钥成功");
                        LocalBusinessStore.saveAuthorizedPassword(HamamSetPswActivity.this.getContext(), HamamSetPswActivity.this.getLoginAccount().getUid(), str);
                        HamamSetPswActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (!HamamSetPswActivity.this.mIsEnable || clientException.getCode() == 2005) {
                        return;
                    }
                    SystemErrorTip.getInstance().showTipDialog(HamamSetPswActivity.this.getActivity(), clientException.getDetail());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPswNew() {
        if (StringUtils.isEmpty(this.et5.getText().toString()) || StringUtils.isEmpty(this.et6.getText().toString()) || StringUtils.isEmpty(this.et7.getText().toString()) || StringUtils.isEmpty(this.et10.getText().toString()) || StringUtils.isEmpty(this.et8.getText().toString()) || StringUtils.isEmpty(this.et9.getText().toString())) {
            ToastUtils.show(getContext(), "请检查是否还有密钥未输入");
            return;
        }
        BusinessControllers.getInstance().postSetAuthorizedPassword(getLoginAccount(), this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString(), 11, RandomUtil.getRandNumMaxString(6), new Listener<BathHousePasswordBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(HamamSetPswActivity.this.getActivity(), "正在设密钥..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathHousePasswordBean bathHousePasswordBean, Object... objArr) {
                String strDecrypt;
                if (!HamamSetPswActivity.this.mIsEnable || bathHousePasswordBean == null) {
                    return;
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                ToastUtils.show(HamamSetPswActivity.this.getContext(), "设置密钥成功");
                try {
                    strDecrypt = AESHelper.decrypt(bathHousePasswordBean.typePassword, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                } catch (Exception e) {
                    e.printStackTrace();
                    strDecrypt = "";
                }
                if (StringUtils.isNotEmpty(strDecrypt) && strDecrypt.length() == 10) {
                    LocalBusinessStore.saveAuthorizedPassword(HamamSetPswActivity.this.getContext(), HamamSetPswActivity.this.getLoginAccount().getUid(), strDecrypt);
                }
                HamamSetPswActivity.this.isbind();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamSetPswActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(HamamSetPswActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isbind() {
        BusinessControllers.getInstance().hamamIsBind(getLoginAccount(), "", new Listener<HamamIsBindBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, HamamIsBindBean hamamIsBindBean, Object... objArr) {
                if (hamamIsBindBean == null || !HamamSetPswActivity.this.mIsEnable) {
                    return;
                }
                if (hamamIsBindBean.isbind == 1) {
                    LocalBusinessStore.saveHamamRoomId(HamamSetPswActivity.this.getContext(), HamamSetPswActivity.this.getLoginAccount().getUid(), hamamIsBindBean.bathhouseareaid);
                    HamamMainActivity.launch(HamamSetPswActivity.this.getActivity(), HamamSetPswActivity.this.mWalletModel);
                    HamamSetPswActivity.this.finish();
                } else {
                    LocalBusinessStore.saveHamamRoomId(HamamSetPswActivity.this.getContext(), HamamSetPswActivity.this.getLoginAccount().getUid(), "");
                    HamamSetPswActivity.this.bindDialog();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HamamSetPswActivity.this.mIsEnable) {
                    LocalBusinessStore.saveHamamRoomId(HamamSetPswActivity.this.getContext(), HamamSetPswActivity.this.getLoginAccount().getUid(), "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDialog() {
        new BindhamamDialogTip().showBindDialog(getActivity(), new BindhamamDialogTip.BindDialogListener() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.11
            @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
            public void onCanle() {
                HamamSetPswActivity.this.finish();
            }

            @Override // client.android.yixiaotong.ui.dialog.BindhamamDialogTip.BindDialogListener
            public void onConfirm() {
                HamamBindActivity.launch(HamamSetPswActivity.this.getActivity(), HamamSetPswActivity.this.mWalletModel, true);
                HamamSetPswActivity.this.finish();
            }
        }, "亲～您还未绑定浴室，绑定后", "需等待5分钟才会生效", "暂不", "绑定");
    }

    private void getLocalWalletModels() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.hamam.HamamSetPswActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                for (WalletModel walletModel : list) {
                    if (walletModel.typeId == 11) {
                        HamamSetPswActivity.this.mWalletModel = walletModel;
                    }
                }
            }
        });
    }
}
