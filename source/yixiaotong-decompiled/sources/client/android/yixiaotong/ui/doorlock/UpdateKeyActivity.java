package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.Editable;
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
import client.android.yixiaotong.controller.store.HttpBusinessStoreJava;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
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
public class UpdateKeyActivity extends BaseActivity {
    public static final String EXTRA_DEVICE = "bluetoothdevice";
    private static final String EXTRA_PSW = "psw";
    private static final int MAXCONNECYCOUNT = 2;
    private EditText et1;
    private EditText et10;
    private EditText et100;
    private EditText et11;
    private EditText et2;
    private EditText et22;
    private EditText et5;
    private EditText et55;
    private EditText et6;
    private EditText et66;
    private EditText et7;
    private EditText et77;
    private EditText et8;
    private EditText et88;
    private EditText et9;
    private EditText et99;
    private BluetoothDevice mBluetoothDevice;
    private Button mBtnUpdateKey;
    private String mPsw;
    private ScrollView mScrollView;
    private TitleBar mTitleBar;
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
        StubApp.interface11(7016);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$208(UpdateKeyActivity updateKeyActivity) {
        int i = updateKeyActivity.mConnectCount;
        updateKeyActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, BluetoothDevice bluetoothDevice, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) UpdateKeyActivity.class).putExtra("bluetoothdevice", bluetoothDevice).putExtra("psw", str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.et1 = (EditText) findViewById(R.id.et11);
        this.et2 = (EditText) findViewById(R.id.et22);
        this.et5 = (EditText) findViewById(R.id.et55);
        this.et6 = (EditText) findViewById(R.id.et66);
        this.et7 = (EditText) findViewById(R.id.et77);
        this.et8 = (EditText) findViewById(R.id.et88);
        this.et9 = (EditText) findViewById(R.id.et99);
        this.et10 = (EditText) findViewById(R.id.et100);
        this.et11 = (EditText) findViewById(R.id.et1);
        this.et22 = (EditText) findViewById(R.id.et2);
        this.et55 = (EditText) findViewById(R.id.et5);
        this.et66 = (EditText) findViewById(R.id.et6);
        this.et77 = (EditText) findViewById(R.id.et7);
        this.et88 = (EditText) findViewById(R.id.et8);
        this.et99 = (EditText) findViewById(R.id.et9);
        this.et100 = (EditText) findViewById(R.id.et10);
        this.mBtnUpdateKey = (Button) findViewById(R.id.btn_updatekey);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.doorlock_updatepsw));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initData() {
        String strDecryptData = HttpBusinessStoreJava.decryptData(this.mPsw);
        if (StringUtils.isNotEmpty(strDecryptData) && strDecryptData.length() == 8) {
            this.et11.setText(strDecryptData.substring(0, 1));
            this.et22.setText(strDecryptData.substring(1, 2));
            this.et55.setText(strDecryptData.substring(2, 3));
            this.et66.setText(strDecryptData.substring(3, 4));
            this.et77.setText(strDecryptData.substring(4, 5));
            this.et88.setText(strDecryptData.substring(5, 6));
            this.et99.setText(strDecryptData.substring(6, 7));
            this.et100.setText(strDecryptData.substring(7, 8));
            this.et1.setText(strDecryptData.substring(0, 1));
            this.et2.setText(strDecryptData.substring(1, 2));
        }
    }

    private void initBluetooth() {
        BluetoothConnectUtil.getInstance().init(getActivity());
        BluetoothConnectUtil.getInstance().connect(this.mBluetoothDevice);
        BluetoothConnectUtil.getInstance().setListener(new BluetoothConnectUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.1
            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (UpdateKeyActivity.this.mIsEnable) {
                    UpdateKeyActivity.this.mState = State.connectfail;
                    UpdateKeyActivity.access$208(UpdateKeyActivity.this);
                    if (UpdateKeyActivity.this.mConnectCount < 2) {
                        BluetoothConnectUtil.getInstance().connect(UpdateKeyActivity.this.mBluetoothDevice);
                    } else if (UpdateKeyActivity.this.mStateProgress != State.none) {
                        UpdateKeyActivity.this.showDialog("连接设备失败，请保持触亮门锁的感应区再提交密码");
                    }
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onConnected(BluetoothDevice bluetoothDevice) {
                if (UpdateKeyActivity.this.mIsEnable) {
                    UpdateKeyActivity.this.mState = State.connected;
                    if (UpdateKeyActivity.this.mStateProgress == State.setkeystart) {
                        UpdateKeyActivity.this.startAddKey();
                    }
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onReceivedData(String str) {
                if (UpdateKeyActivity.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(str) && DoorLockCommandUtil.isCheckData(str)) {
                        DoorLockSyncInfoControllerUtil.getInstance().onReceivedData(str);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        UpdateKeyActivity.this.showDialog("设备数据格式错误");
                    }
                }
            }
        });
    }

    private void initBluetoothSendDataListener() {
        DoorLockSyncInfoControllerUtil.getInstance().setListener(new DoorLockSyncInfoControllerUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.2
            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSyncEnd() {
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSendData(String str) {
                if (UpdateKeyActivity.this.mState == State.connected) {
                    if (StringUtils.isNotEmpty(str)) {
                        BluetoothConnectUtil.getInstance().sendData(str);
                        return;
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        return;
                    }
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                UpdateKeyActivity.this.showDialog("设备已断开连接，请保持触亮门锁的感应区再提交密码");
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onEnd() {
                ToastUtils.show(UpdateKeyActivity.this.getContext(), "修改钥匙成功");
                UpdateKeyActivity.this.finish();
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
        findViewById(R.id.btn_updatekey).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m116xe56b26c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-ui-doorlock-UpdateKeyActivity, reason: not valid java name */
    /* synthetic */ void m116xe56b26c(View view) {
        if (this.mIsEnableSetKey) {
            BaseMaterialDialog.showMaterialDialog(getActivity(), "开始修改密钥..", true);
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
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && list.size() > 0) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 10) {
                            UpdateKeyActivity.this.mWalletModel = walletModel;
                            DoorLockSyncInfoControllerUtil.getInstance().initData(UpdateKeyActivity.this.getActivity(), UpdateKeyActivity.this.getLoginAccount(), UpdateKeyActivity.this.mWalletModel);
                        }
                    }
                }
                if (UpdateKeyActivity.this.mWalletModel == null) {
                    UpdateKeyActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAddKey() {
        DoorLockSyncInfoControllerUtil.getInstance().setFunctionStateUpdate(DoorLockSyncInfoControllerUtil.FunctionState.changepsw, LocalBusinessStore.getDoorLockServerKeyID(getContext()), LocalBusinessStore.getDoorLockDeviceKeyID(getContext()), this.et1.getText().toString() + this.et2.getText().toString() + this.et5.getText().toString() + this.et6.getText().toString() + this.et7.getText().toString() + this.et8.getText().toString() + this.et9.getText().toString() + this.et10.getText().toString());
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
        String strSubstring = str.substring(str.length() - 2);
        this.et11.setText(strSubstring.substring(0, 1));
        this.et22.setText(strSubstring.substring(1, 2));
        this.et1.setText(strSubstring.substring(0, 1));
        this.et2.setText(strSubstring.substring(1, 2));
        this.et1.setEnabled(false);
        this.et2.setEnabled(false);
        this.et5.requestFocus();
        this.et5.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UpdateKeyActivity.this.mIndex = 5;
                UpdateKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et5.getText().toString())) {
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et6.getText().toString())) {
                        UpdateKeyActivity.this.et6.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et7.getText().toString())) {
                        UpdateKeyActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et8.getText().toString())) {
                        UpdateKeyActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et9.getText().toString())) {
                        UpdateKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(UpdateKeyActivity.this.et10.getText().toString())) {
                        UpdateKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        UpdateKeyActivity.this.et10.requestFocus();
                        UpdateKeyActivity.this.et10.setSelection(UpdateKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                UpdateKeyActivity.this.et5.requestFocus();
            }
        });
        this.et6.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.5
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UpdateKeyActivity.this.mIndex = 6;
                UpdateKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et6.getText().toString())) {
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et7.getText().toString())) {
                        UpdateKeyActivity.this.et7.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et8.getText().toString())) {
                        UpdateKeyActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et9.getText().toString())) {
                        UpdateKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(UpdateKeyActivity.this.et10.getText().toString())) {
                        UpdateKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        UpdateKeyActivity.this.et10.requestFocus();
                        UpdateKeyActivity.this.et10.setSelection(UpdateKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                UpdateKeyActivity.this.et5.requestFocus();
                UpdateKeyActivity.this.et5.setSelection(UpdateKeyActivity.this.et5.getText().toString().length());
            }
        });
        this.et7.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.6
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UpdateKeyActivity.this.mIndex = 7;
                UpdateKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et7.getText().toString())) {
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et8.getText().toString())) {
                        UpdateKeyActivity.this.et8.requestFocus();
                        return;
                    }
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et9.getText().toString())) {
                        UpdateKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(UpdateKeyActivity.this.et10.getText().toString())) {
                        UpdateKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        UpdateKeyActivity.this.et10.requestFocus();
                        UpdateKeyActivity.this.et10.setSelection(UpdateKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et6.getText().toString())) {
                    UpdateKeyActivity.this.et6.requestFocus();
                    UpdateKeyActivity.this.et6.setSelection(UpdateKeyActivity.this.et6.getText().toString().length());
                } else {
                    UpdateKeyActivity.this.et5.requestFocus();
                    UpdateKeyActivity.this.et5.setSelection(UpdateKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et8.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UpdateKeyActivity.this.mIndex = 8;
                UpdateKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et8.getText().toString())) {
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et9.getText().toString())) {
                        UpdateKeyActivity.this.et9.requestFocus();
                        return;
                    } else if (StringUtils.isEmpty(UpdateKeyActivity.this.et10.getText().toString())) {
                        UpdateKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        UpdateKeyActivity.this.et10.requestFocus();
                        UpdateKeyActivity.this.et10.setSelection(UpdateKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et7.getText().toString())) {
                    UpdateKeyActivity.this.et7.requestFocus();
                    UpdateKeyActivity.this.et7.setSelection(UpdateKeyActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et6.getText().toString())) {
                    UpdateKeyActivity.this.et6.requestFocus();
                    UpdateKeyActivity.this.et6.setSelection(UpdateKeyActivity.this.et6.getText().toString().length());
                } else {
                    UpdateKeyActivity.this.et5.requestFocus();
                    UpdateKeyActivity.this.et5.setSelection(UpdateKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et9.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.8
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UpdateKeyActivity.this.mIndex = 9;
                UpdateKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et9.getText().toString())) {
                    if (StringUtils.isEmpty(UpdateKeyActivity.this.et10.getText().toString())) {
                        UpdateKeyActivity.this.et10.requestFocus();
                        return;
                    } else {
                        UpdateKeyActivity.this.et10.requestFocus();
                        UpdateKeyActivity.this.et10.setSelection(UpdateKeyActivity.this.et10.getText().toString().length());
                        return;
                    }
                }
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et8.getText().toString())) {
                    UpdateKeyActivity.this.et8.requestFocus();
                    UpdateKeyActivity.this.et8.setSelection(UpdateKeyActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et7.getText().toString())) {
                    UpdateKeyActivity.this.et7.requestFocus();
                    UpdateKeyActivity.this.et7.setSelection(UpdateKeyActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et6.getText().toString())) {
                    UpdateKeyActivity.this.et6.requestFocus();
                    UpdateKeyActivity.this.et6.setSelection(UpdateKeyActivity.this.et6.getText().toString().length());
                } else {
                    UpdateKeyActivity.this.et5.requestFocus();
                    UpdateKeyActivity.this.et5.setSelection(UpdateKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        this.et10.addTextChangedListener(new TextWatcher() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                UpdateKeyActivity.this.mIndex = 10;
                UpdateKeyActivity.this.getBtnState();
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et10.getText().toString())) {
                    return;
                }
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et9.getText().toString())) {
                    UpdateKeyActivity.this.et9.requestFocus();
                    UpdateKeyActivity.this.et9.setSelection(UpdateKeyActivity.this.et9.getText().toString().length());
                    return;
                }
                if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et8.getText().toString())) {
                    UpdateKeyActivity.this.et8.requestFocus();
                    UpdateKeyActivity.this.et8.setSelection(UpdateKeyActivity.this.et8.getText().toString().length());
                } else if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et7.getText().toString())) {
                    UpdateKeyActivity.this.et7.requestFocus();
                    UpdateKeyActivity.this.et7.setSelection(UpdateKeyActivity.this.et7.getText().toString().length());
                } else if (StringUtils.isNotEmpty(UpdateKeyActivity.this.et6.getText().toString())) {
                    UpdateKeyActivity.this.et6.requestFocus();
                    UpdateKeyActivity.this.et6.setSelection(UpdateKeyActivity.this.et6.getText().toString().length());
                } else {
                    UpdateKeyActivity.this.et5.requestFocus();
                    UpdateKeyActivity.this.et5.setSelection(UpdateKeyActivity.this.et5.getText().toString().length());
                }
            }
        });
        final int[] iArr = {0};
        this.mScrollView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: client.android.yixiaotong.ui.doorlock.UpdateKeyActivity.10
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                UpdateKeyActivity updateKeyActivity = UpdateKeyActivity.this;
                updateKeyActivity.doScrollEvent(updateKeyActivity.mScrollView, iArr, UpdateKeyActivity.this.et5, UpdateKeyActivity.this.et6, UpdateKeyActivity.this.et7, UpdateKeyActivity.this.et8, UpdateKeyActivity.this.et9, UpdateKeyActivity.this.et10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBtnState() {
        if (StringUtils.isNotEmpty(this.et1.getText().toString()) && StringUtils.isNotEmpty(this.et2.getText().toString()) && StringUtils.isNotEmpty(this.et5.getText().toString()) && StringUtils.isNotEmpty(this.et6.getText().toString()) && StringUtils.isNotEmpty(this.et7.getText().toString()) && StringUtils.isNotEmpty(this.et8.getText().toString()) && StringUtils.isNotEmpty(this.et9.getText().toString()) && StringUtils.isNotEmpty(this.et10.getText().toString())) {
            this.mIsEnableSetKey = true;
            this.mBtnUpdateKey.setBackgroundResource(R.mipmap.l_btn_doorlock_background);
        } else {
            this.mIsEnableSetKey = false;
            this.mBtnUpdateKey.setBackgroundResource(R.drawable.round_radio_button_gray_background);
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
