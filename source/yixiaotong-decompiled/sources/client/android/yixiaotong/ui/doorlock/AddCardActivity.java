package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
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
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.google.android.exoplayer2.ExoPlayer;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AddCardActivity extends BaseActivity {
    private static final String EXTRA_DEVICE = "bluetoothdevice";
    private static final int MAXCONNECYCOUNT = 2;
    private static final int MSG = 0;
    private static final int MSGDELAYEDTIME = 1000;
    private BluetoothDevice mBluetoothDevice;
    Button mBtnAddCard;
    ImageView mImgTip;
    TitleBar mTitleBar;
    TextView mTvSuccessTip;
    private WalletModel mWalletModel;
    private boolean mIsEnable = true;
    private State mState = State.none;
    private int mConnectCount = 0;
    private Handler mHandler = new Handler() { // from class: client.android.yixiaotong.ui.doorlock.AddCardActivity.5
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AddCardActivity.this.mHandler.sendEmptyMessageDelayed(0, 1000L);
            if (AddCardActivity.this.mBtnAddCard.getText().toString().contains("...")) {
                AddCardActivity.this.mBtnAddCard.setText(AddCardActivity.this.getResources().getString(R.string.doorlock_addcarding1));
            } else if (AddCardActivity.this.mBtnAddCard.getText().toString().contains("..")) {
                AddCardActivity.this.mBtnAddCard.setText(AddCardActivity.this.getResources().getString(R.string.doorlock_addcarding3));
            } else {
                AddCardActivity.this.mBtnAddCard.setText(AddCardActivity.this.getResources().getString(R.string.doorlock_addcarding2));
            }
        }
    };

    public enum State {
        none,
        connectfail,
        connected,
        end
    }

    static {
        StubApp.interface11(6885);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$208(AddCardActivity addCardActivity) {
        int i = addCardActivity.mConnectCount;
        addCardActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, BluetoothDevice bluetoothDevice) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AddCardActivity.class).putExtra("bluetoothdevice", bluetoothDevice));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mImgTip = (ImageView) findViewById(R.id.img_tip);
        this.mBtnAddCard = (Button) findViewById(R.id.btn_addcard);
        this.mTvSuccessTip = (TextView) findViewById(R.id.tv_bingsuccesstip);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.doorlock_addcard));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initBluetooth() {
        BluetoothConnectUtil.getInstance().init(getActivity());
        BluetoothConnectUtil.getInstance().setListener(new BluetoothConnectUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.AddCardActivity.1
            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (AddCardActivity.this.mIsEnable) {
                    AddCardActivity.this.mState = State.connectfail;
                    AddCardActivity.access$208(AddCardActivity.this);
                    if (AddCardActivity.this.mConnectCount < 2) {
                        AddCardActivity.this.mHandler.removeMessages(0);
                        AddCardActivity.this.connect();
                    } else {
                        AddCardActivity.this.showDialog("连接设备失败，请移开卡片再重新放到门锁感应区");
                    }
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onConnected(BluetoothDevice bluetoothDevice) {
                if (AddCardActivity.this.mIsEnable) {
                    AddCardActivity.this.mState = State.connected;
                    AddCardActivity.this.startAddCard();
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onReceivedData(String str) {
                if (AddCardActivity.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(str) && DoorLockCommandUtil.isCheckData(str)) {
                        DoorLockSyncInfoControllerUtil.getInstance().onReceivedData(str);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        AddCardActivity.this.showDialog("设备数据格式错误，请移开卡片再重新放到门锁感应区");
                    }
                }
            }
        });
        connect();
    }

    private void initBluetoothSendDataListener() {
        DoorLockSyncInfoControllerUtil.getInstance().setListener(new DoorLockSyncInfoControllerUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.AddCardActivity.2
            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSyncEnd() {
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSendData(String str) {
                if (AddCardActivity.this.mState == State.connected) {
                    if (StringUtils.isNotEmpty(str)) {
                        BluetoothConnectUtil.getInstance().sendData(str);
                        return;
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        AddCardActivity.this.finish();
                        return;
                    }
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                AddCardActivity.this.showDialog("设备已断开连接，请移开卡片再重新放到门锁感应区");
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onEnd() {
                AddCardActivity.this.mTvSuccessTip.setVisibility(0);
                AddCardActivity.this.mHandler.removeMessages(0);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.doorlock.AddCardActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AddCardActivity.this.finish();
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connect() {
        this.mHandler.sendEmptyMessageDelayed(0, 1000L);
        BluetoothConnectUtil.getInstance().connect(this.mBluetoothDevice);
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
        this.mHandler.removeCallbacksAndMessages(null);
        BluetoothConnectUtil.getInstance().disConnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        this.mConnectCount = 0;
        this.mState = State.none;
        this.mHandler.removeMessages(0);
        SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.doorlock.AddCardActivity.3
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                BluetoothConnectUtil.getInstance().disConnect();
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.doorlock.AddCardActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AddCardActivity.this.connect();
                    }
                }, 800L);
            }
        }, str);
    }

    private void initWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.doorlock.AddCardActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && list.size() > 0) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 10) {
                            AddCardActivity.this.mWalletModel = walletModel;
                            DoorLockSyncInfoControllerUtil.getInstance().initData(AddCardActivity.this.getActivity(), AddCardActivity.this.getLoginAccount(), AddCardActivity.this.mWalletModel);
                        }
                    }
                }
                if (AddCardActivity.this.mWalletModel == null) {
                    AddCardActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAddCard() {
        DoorLockSyncInfoControllerUtil.getInstance().setFunctionState(DoorLockSyncInfoControllerUtil.FunctionState.addcard, "房间卡", "");
    }
}
