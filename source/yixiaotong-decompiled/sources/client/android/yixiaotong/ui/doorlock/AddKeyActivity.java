package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AddKeyActivity extends BaseActivity {
    public static final String EXTRA_DEVICE = "bluetoothdevice";
    private static final int MAXCONNECYCOUNT = 2;
    private static final int MAXLENGTH = 6;
    EditText et1;
    EditText et10;
    EditText et2;
    EditText et5;
    EditText et6;
    EditText et7;
    EditText et8;
    EditText et9;
    private BluetoothDevice mBluetoothDevice;
    Button mBtnSetKey;
    EditText mEtName;
    ScrollView mScrollView;
    TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private int mIndex = 0;
    private boolean mIsEnable = true;
    private State mState = State.none;
    private State mStateProgress = State.none;
    private int mConnectCount = 0;
    private boolean mIsEnableSetKey = false;

    public enum State {
        none,
        setkeystart,
        connectfail,
        connected,
        sending,
        end
    }

    static {
        StubApp.interface11(6899);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$208(AddKeyActivity addKeyActivity) {
        int i = addKeyActivity.mConnectCount;
        addKeyActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, BluetoothDevice bluetoothDevice) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AddKeyActivity.class).putExtra("bluetoothdevice", bluetoothDevice));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.et1 = (EditText) findViewById(R.id.et1);
        this.et2 = (EditText) findViewById(R.id.et2);
        this.et5 = (EditText) findViewById(R.id.et5);
        this.et6 = (EditText) findViewById(R.id.et6);
        this.et7 = (EditText) findViewById(R.id.et7);
        this.et8 = (EditText) findViewById(R.id.et8);
        this.et9 = (EditText) findViewById(R.id.et9);
        this.et10 = (EditText) findViewById(R.id.et10);
        this.mBtnSetKey = (Button) findViewById(R.id.btn_setkey);
        this.mEtName = (EditText) findViewById(R.id.et_name);
        this.mScrollView = (ScrollView) findViewById(R.id.srrollview);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setTitleView("添加密码");
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initBluetooth() {
        BluetoothConnectUtil.getInstance().init(getActivity());
        BluetoothConnectUtil.getInstance().connect(this.mBluetoothDevice);
        BluetoothConnectUtil.getInstance().setListener(new BluetoothConnectUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.1
            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (AddKeyActivity.this.mIsEnable) {
                    AddKeyActivity.this.mState = State.connectfail;
                    AddKeyActivity.access$208(AddKeyActivity.this);
                    if (AddKeyActivity.this.mConnectCount < 2) {
                        BluetoothConnectUtil.getInstance().connect(AddKeyActivity.this.mBluetoothDevice);
                    } else if (AddKeyActivity.this.mStateProgress != State.none) {
                        AddKeyActivity.this.showDialog("连接设备失败，请保持触亮门锁的感应区再提交密码");
                    }
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onConnected(BluetoothDevice bluetoothDevice) {
                if (AddKeyActivity.this.mIsEnable) {
                    AddKeyActivity.this.mState = State.connected;
                    if (AddKeyActivity.this.mStateProgress == State.setkeystart) {
                        AddKeyActivity.this.startAddKey();
                    }
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onReceivedData(String str) {
                if (AddKeyActivity.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(str) || !DoorLockCommandUtil.isCheckData(str)) {
                        AddKeyActivity.this.showDialog("设备数据格式错误");
                    } else {
                        DoorLockSyncInfoControllerUtil.getInstance().onReceivedData(str);
                    }
                }
            }
        });
    }

    private void initBluetoothSendDataListener() {
        DoorLockSyncInfoControllerUtil.getInstance().setListener(new DoorLockSyncInfoControllerUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.2
            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSyncEnd() {
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSendData(String str) {
                if (AddKeyActivity.this.mState != State.connected) {
                    AddKeyActivity.this.showDialog("设备已断开连接，请保持触亮门锁的感应区再提交密码");
                } else if (StringUtils.isNotEmpty(str)) {
                    BluetoothConnectUtil.getInstance().sendData(str);
                } else {
                    BaseMaterialDialog.dissmisMaterialDialog();
                }
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onEnd() {
                ToastUtils.show(AddKeyActivity.this.getContext(), "添加钥匙成功");
                AddKeyActivity.this.finish();
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BluetoothConnectUtil.getInstance().onPause();
        DoorLockSyncInfoControllerUtil.getInstance().onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothConnectUtil.getInstance().onResume();
        DoorLockSyncInfoControllerUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothConnectUtil.getInstance().disConnect();
    }

    private void initClickListeners() {
        findViewById(R.id.btn_setkey).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m95xef88c426(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-AddKeyActivity, reason: not valid java name */
    /* synthetic */ void m95xef88c426(View view) {
        if (this.mIsEnableSetKey) {
            BaseMaterialDialog.showMaterialDialog(getActivity(), "开始添加密钥..", true);
            this.mConnectCount = 0;
            this.mStateProgress = State.setkeystart;
            if (this.mState == State.connected) {
                startAddKey();
            } else if (this.mState == State.connectfail) {
                BluetoothConnectUtil.getInstance().connect(this.mBluetoothDevice);
            }
        }
    }

    private void initWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && list.size() > 0) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 10) {
                            AddKeyActivity.this.mWalletModel = walletModel;
                            DoorLockSyncInfoControllerUtil.getInstance().initData(AddKeyActivity.this.getActivity(), AddKeyActivity.this.getLoginAccount(), AddKeyActivity.this.mWalletModel);
                        }
                    }
                }
                if (AddKeyActivity.this.mWalletModel == null) {
                    AddKeyActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAddKey() {
        DoorLockSyncInfoControllerUtil.getInstance().setFunctionState(DoorLockSyncInfoControllerUtil.FunctionState.addpswkey, this.mEtName.getText().toString(), this.et1.getText().toString() + this.et2.getText().toString() + this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString());
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
                        if (StringUtils.isEmpty(this.mEtName.getText().toString())) {
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
                        }
                        break;
                }
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    private void initView() {
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().LoginAccount;
        String strSubstring = str.substring(str.length() - 2);
        this.et1.setText(strSubstring.substring(0, 1));
        this.et2.setText(strSubstring.substring(1, 2));
        this.et1.setEnabled(false);
        this.et2.setEnabled(false);
        this.et5.requestFocus();
        this.et5.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddKeyActivity.this.mIndex = 5;
                AddKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et5.getText().toString())) {
                    if (StringUtils.isEmpty(AddKeyActivity.this.et6.getText().toString())) {
                        AddKeyActivity.this.et6.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(AddKeyActivity.this.et7.getText().toString())) {
                        AddKeyActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(AddKeyActivity.this.et8.getText().toString())) {
                        AddKeyActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(AddKeyActivity.this.et9.getText().toString())) {
                        AddKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(AddKeyActivity.this.et10.getText().toString())) {
                        AddKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        AddKeyActivity.this.et10.requestFocus();
                        AddKeyActivity.this.et10.setSelection(AddKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                AddKeyActivity.this.et5.requestFocus();
            }
        });
        this.et6.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddKeyActivity.this.mIndex = 6;
                AddKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et6.getText().toString())) {
                    if (StringUtils.isEmpty(AddKeyActivity.this.et7.getText().toString())) {
                        AddKeyActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(AddKeyActivity.this.et8.getText().toString())) {
                        AddKeyActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(AddKeyActivity.this.et9.getText().toString())) {
                        AddKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(AddKeyActivity.this.et10.getText().toString())) {
                        AddKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        AddKeyActivity.this.et10.requestFocus();
                        AddKeyActivity.this.et10.setSelection(AddKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                AddKeyActivity.this.et5.requestFocus();
                AddKeyActivity.this.et5.setSelection(AddKeyActivity.this.et5.getText().toString().length());
            }
        });
        this.et7.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddKeyActivity.this.mIndex = 7;
                AddKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et7.getText().toString())) {
                    if (StringUtils.isEmpty(AddKeyActivity.this.et8.getText().toString())) {
                        AddKeyActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(AddKeyActivity.this.et9.getText().toString())) {
                        AddKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(AddKeyActivity.this.et10.getText().toString())) {
                        AddKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        AddKeyActivity.this.et10.requestFocus();
                        AddKeyActivity.this.et10.setSelection(AddKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et6.getText().toString())) {
                    AddKeyActivity.this.et6.requestFocus();
                    AddKeyActivity.this.et6.setSelection(AddKeyActivity.this.et6.getText().toString().length());
                } else {
                    AddKeyActivity.this.et5.requestFocus();
                    AddKeyActivity.this.et5.setSelection(AddKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et8.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddKeyActivity.this.mIndex = 8;
                AddKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et8.getText().toString())) {
                    if (StringUtils.isEmpty(AddKeyActivity.this.et9.getText().toString())) {
                        AddKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(AddKeyActivity.this.et10.getText().toString())) {
                        AddKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        AddKeyActivity.this.et10.requestFocus();
                        AddKeyActivity.this.et10.setSelection(AddKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et7.getText().toString())) {
                    AddKeyActivity.this.et7.requestFocus();
                    AddKeyActivity.this.et7.setSelection(AddKeyActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(AddKeyActivity.this.et6.getText().toString())) {
                    AddKeyActivity.this.et6.requestFocus();
                    AddKeyActivity.this.et6.setSelection(AddKeyActivity.this.et6.getText().toString().length());
                } else {
                    AddKeyActivity.this.et5.requestFocus();
                    AddKeyActivity.this.et5.setSelection(AddKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et9.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddKeyActivity.this.mIndex = 9;
                AddKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et9.getText().toString())) {
                    if (StringUtils.isEmpty(AddKeyActivity.this.et10.getText().toString())) {
                        AddKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        AddKeyActivity.this.et10.requestFocus();
                        AddKeyActivity.this.et10.setSelection(AddKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et8.getText().toString())) {
                    AddKeyActivity.this.et8.requestFocus();
                    AddKeyActivity.this.et8.setSelection(AddKeyActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(AddKeyActivity.this.et7.getText().toString())) {
                    AddKeyActivity.this.et7.requestFocus();
                    AddKeyActivity.this.et7.setSelection(AddKeyActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(AddKeyActivity.this.et6.getText().toString())) {
                    AddKeyActivity.this.et6.requestFocus();
                    AddKeyActivity.this.et6.setSelection(AddKeyActivity.this.et6.getText().toString().length());
                } else {
                    AddKeyActivity.this.et5.requestFocus();
                    AddKeyActivity.this.et5.setSelection(AddKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et10.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddKeyActivity.this.mIndex = 10;
                AddKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et10.getText().toString())) {
                    if (StringUtils.isEmpty(AddKeyActivity.this.mEtName.getText().toString())) {
                        AddKeyActivity.this.mEtName.requestFocus();
                        return;
                    } else {
                        AddKeyActivity.this.mEtName.requestFocus();
                        AddKeyActivity.this.mEtName.setSelection(AddKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et9.getText().toString())) {
                    AddKeyActivity.this.et9.requestFocus();
                    AddKeyActivity.this.et9.setSelection(AddKeyActivity.this.et9.getText().toString().length());
                    return;
                }
                if (StringUtils.isNotEmpty(AddKeyActivity.this.et8.getText().toString())) {
                    AddKeyActivity.this.et8.requestFocus();
                    AddKeyActivity.this.et8.setSelection(AddKeyActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(AddKeyActivity.this.et7.getText().toString())) {
                    AddKeyActivity.this.et7.requestFocus();
                    AddKeyActivity.this.et7.setSelection(AddKeyActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(AddKeyActivity.this.et6.getText().toString())) {
                    AddKeyActivity.this.et6.requestFocus();
                    AddKeyActivity.this.et6.setSelection(AddKeyActivity.this.et6.getText().toString().length());
                } else {
                    AddKeyActivity.this.et5.requestFocus();
                    AddKeyActivity.this.et5.setSelection(AddKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.mEtName.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.10
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                AddKeyActivity.this.getBtnState();
            }
        });
        this.mEtName.setFilters(new InputFilter[]{new EmojiExcludeFilter(), new InputFilter.LengthFilter(6)});
        final int[] iArr = {0};
        this.mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.ui.doorlock.AddKeyActivity.11
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                AddKeyActivity addKeyActivity = AddKeyActivity.this;
                addKeyActivity.doScrollEvent(addKeyActivity.mScrollView, iArr, AddKeyActivity.this.et5, AddKeyActivity.this.et6, AddKeyActivity.this.et7, AddKeyActivity.this.et8, AddKeyActivity.this.et9, AddKeyActivity.this.et10, AddKeyActivity.this.mEtName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBtnState() {
        if (StringUtils.isNotEmpty(this.et1.getText().toString()) && StringUtils.isNotEmpty(this.et2.getText().toString()) && StringUtils.isNotEmpty(this.et5.getText().toString()) && StringUtils.isNotEmpty(this.et6.getText().toString()) && StringUtils.isNotEmpty(this.et7.getText().toString()) && StringUtils.isNotEmpty(this.et8.getText().toString()) && StringUtils.isNotEmpty(this.et9.getText().toString()) && StringUtils.isNotEmpty(this.et10.getText().toString()) && StringUtils.isNotEmpty(this.mEtName.getText().toString())) {
            this.mIsEnableSetKey = true;
            this.mBtnSetKey.setBackgroundResource(R.mipmap.l_btn_doorlock_background);
        } else {
            this.mIsEnableSetKey = false;
            this.mBtnSetKey.setBackgroundResource(R.drawable.round_radio_button_gray_background);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
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
}
