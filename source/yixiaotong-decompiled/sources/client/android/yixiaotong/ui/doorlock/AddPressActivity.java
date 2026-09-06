package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.google.android.exoplayer2.ExoPlayer;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AddPressActivity extends BaseActivity {
    public static final String EXTRA_DEVICE = "bluetoothdevice";
    private static final int MAXCONNECYCOUNT = 2;
    private static final int MSG = 0;
    private static final int MSGDELAYEDTIME = 2000;
    private BluetoothDevice mBluetoothDevice;
    private Button mBtnAddPress;
    private ImageView mImgTip;
    private TitleBar mTitleBar;
    private TextView mTvSuccessTip;
    private WalletModel mWalletModel;
    private boolean mIsEnable = true;
    private State mState = State.none;
    private State mStateProgress = State.none;
    private int mConnectCount = 0;
    private int mPressCount = 0;

    public enum State {
        none,
        setkeystart,
        connectfail,
        connected,
        sending,
        end
    }

    static {
        StubApp.interface11(6908);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$208(AddPressActivity addPressActivity) {
        int i = addPressActivity.mConnectCount;
        addPressActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, BluetoothDevice bluetoothDevice) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AddPressActivity.class).putExtra("bluetoothdevice", bluetoothDevice));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mImgTip = (ImageView) findViewById(R.id.img_tip);
        this.mBtnAddPress = (Button) findViewById(R.id.btn_addpress);
        this.mTvSuccessTip = (TextView) findViewById(R.id.tv_bingsuccesstip);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.doorlock_addpress));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vibrator() {
        if (ClientDataManager.getInstance().getBooleanDefaultTrue(ClientDataManager.MESSAGE_VIBRATE)) {
            ((Vibrator) getSystemService("vibrator")).vibrate(300L);
        }
    }

    private void initBluetooth() {
        BluetoothConnectUtil.getInstance().init(getActivity());
        BluetoothConnectUtil.getInstance().setListener(new BluetoothConnectUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.AddPressActivity.1
            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (AddPressActivity.this.mIsEnable) {
                    AddPressActivity.this.mState = State.connectfail;
                    AddPressActivity.access$208(AddPressActivity.this);
                    if (AddPressActivity.this.mConnectCount < 2) {
                        AddPressActivity.this.connect();
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        AddPressActivity.this.showDialog("连接设备失败，请移开手指再重新放到门锁感应区");
                    }
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onConnected(BluetoothDevice bluetoothDevice) {
                if (AddPressActivity.this.mIsEnable) {
                    AddPressActivity.this.mState = State.connected;
                    BaseMaterialDialog.dissmisMaterialDialog();
                    AddPressActivity.this.mImgTip.setVisibility(0);
                    AddPressActivity.this.startAddPress();
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onReceivedData(final String str) {
                if (AddPressActivity.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(str) && DoorLockCommandUtil.isCheckData(str)) {
                        DoorLockSyncInfoControllerUtil.getInstance().onReceivedData(str);
                        Log.e("test", str);
                        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.doorlock.AddPressActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (str.toUpperCase().startsWith("D304B90001")) {
                                    AddPressActivity.this.vibrator();
                                    AddPressActivity.this.mImgTip.setImageResource(R.mipmap.l_doorlock_addpress1);
                                } else if (str.toUpperCase().startsWith("D304B90002")) {
                                    AddPressActivity.this.vibrator();
                                    AddPressActivity.this.mImgTip.setImageResource(R.mipmap.l_doorlock_addpress2);
                                } else if (str.toUpperCase().startsWith("D304B90003")) {
                                    AddPressActivity.this.vibrator();
                                    AddPressActivity.this.mImgTip.setImageResource(R.mipmap.l_doorlock_addpress3);
                                }
                            }
                        });
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        AddPressActivity.this.showDialog("设备数据格式错误，请移开手指再重新放到门锁感应区");
                    }
                }
            }
        });
        connect();
    }

    private void initBluetoothSendDataListener() {
        DoorLockSyncInfoControllerUtil.getInstance().setListener(new DoorLockSyncInfoControllerUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.AddPressActivity.2
            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSyncEnd() {
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSendData(String str) {
                if (AddPressActivity.this.mState == State.connected) {
                    if (StringUtils.isNotEmpty(str)) {
                        BluetoothConnectUtil.getInstance().sendData(str);
                        return;
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        AddPressActivity.this.finish();
                        return;
                    }
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                AddPressActivity.this.showDialog("设备已断开连接，请移开手指再重新放到门锁感应区");
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onEnd() {
                AddPressActivity.this.mImgTip.setImageResource(R.mipmap.l_doorlock_addpress4);
                AddPressActivity.this.mTvSuccessTip.setVisibility(0);
                AddPressActivity.this.vibrator();
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.doorlock.AddPressActivity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AddPressActivity.this.finish();
                    }
                }, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connect() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在连接设备中...", false);
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
        BluetoothConnectUtil.getInstance().disConnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        this.mConnectCount = 0;
        this.mState = State.none;
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.ui.doorlock.AddPressActivity.3
            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                BluetoothConnectUtil.getInstance().disConnect();
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.doorlock.AddPressActivity.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AddPressActivity.this.connect();
                    }
                }, 800L);
            }

            @Override // client.android.yixiaotong.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
                AddPressActivity.this.finish();
            }
        }, "温馨提示", str, "返回", "重连");
    }

    private void initWallet() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.doorlock.AddPressActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null && list.size() > 0) {
                    for (WalletModel walletModel : list) {
                        if (walletModel.typeId == 10) {
                            AddPressActivity.this.mWalletModel = walletModel;
                            DoorLockSyncInfoControllerUtil.getInstance().initData(AddPressActivity.this.getActivity(), AddPressActivity.this.getLoginAccount(), AddPressActivity.this.mWalletModel);
                        }
                    }
                }
                if (AddPressActivity.this.mWalletModel == null) {
                    AddPressActivity.this.finish();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startAddPress() {
        DoorLockSyncInfoControllerUtil.getInstance().setFunctionState(DoorLockSyncInfoControllerUtil.FunctionState.addpress, "指纹钥匙" + this.mPressCount, "");
    }
}
