package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.TimeOut;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.DoorLockInfoSyncEvent;
import client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import de.greenrobot.event.EventBus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DelectKeyController {
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private boolean mIsEnable;
    private Listener mListener;
    private int mSelectState;
    private State mState;
    private WalletModel mWalletModel;

    public interface Listener {
        void onFail(String str);

        void onSuccess();
    }

    public enum State {
        none,
        connectfail,
        connected,
        sending,
        end
    }

    public void setListener(Listener listener) {
        if (this.mListener != null) {
            this.mListener = null;
        }
        this.mListener = listener;
    }

    private DelectKeyController() {
        this.mState = State.none;
    }

    private static final class SingleHolder {
        private static final DelectKeyController INSTANCE = new DelectKeyController();

        private SingleHolder() {
        }
    }

    public static DelectKeyController getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void init(Activity activity, Account account, WalletModel walletModel, BluetoothDevice bluetoothDevice, int i) {
        this.mActivity = activity;
        this.mBluetoothDevice = bluetoothDevice;
        this.mSelectState = i;
        this.mAccount = account;
        this.mWalletModel = walletModel;
        initBluetooth();
        initBluetoothSendDataListener();
        DoorLockSyncInfoControllerUtil.getInstance().initData(activity, account, this.mWalletModel);
    }

    public void onResume() {
        this.mIsEnable = true;
        BluetoothConnectUtil.getInstance().onResume();
        DoorLockSyncInfoControllerUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        BluetoothConnectUtil.getInstance().onPause();
        DoorLockSyncInfoControllerUtil.getInstance().onPause();
    }

    private void initBluetooth() {
        BluetoothConnectUtil.getInstance().init(this.mActivity);
        BluetoothConnectUtil.getInstance().connect(this.mBluetoothDevice);
        BaseMaterialDialog.showMaterialDialog(this.mActivity, "正在连接设备中...", true);
        BluetoothConnectUtil.getInstance().setListener(new BluetoothConnectUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.DelectKeyController.1
            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (DelectKeyController.this.mIsEnable) {
                    Log.e("test", timeOut + "  " + str);
                    DelectKeyController.this.mState = State.connectfail;
                    BaseMaterialDialog.dissmisMaterialDialog();
                    DelectKeyController.this.showDialog("连接设备失败，请保持触亮门锁的感应区再试");
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onConnected(BluetoothDevice bluetoothDevice) {
                if (DelectKeyController.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    DelectKeyController.this.mState = State.connected;
                    DelectKeyController.this.startDeleteKey();
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onReceivedData(String str) {
                if (DelectKeyController.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(str) && DoorLockCommandUtil.isCheckData(str)) {
                        DoorLockSyncInfoControllerUtil.getInstance().onReceivedData(str);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        DelectKeyController.this.showDialog("设备数据格式错误");
                    }
                }
            }
        });
    }

    private void initBluetoothSendDataListener() {
        DoorLockSyncInfoControllerUtil.getInstance().setListener(new DoorLockSyncInfoControllerUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.DelectKeyController.2
            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSendData(String str) {
                if (DelectKeyController.this.mState == State.connected) {
                    if (StringUtils.isNotEmpty(str)) {
                        BluetoothConnectUtil.getInstance().sendData(str);
                        return;
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        return;
                    }
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                DelectKeyController.this.showDialog("设备已断开连接，请保持触亮门锁的感应区再试");
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onSyncEnd() {
                if (DelectKeyController.this.mSelectState == 14) {
                    ToastUtils.show(DelectKeyController.this.mActivity, "已成功解除安全隐患");
                    DelectKeyController.this.mActivity.finish();
                }
            }

            @Override // client.android.yixiaotong.ui.doorlock.DoorLockSyncInfoControllerUtil.Listener
            public void onEnd() {
                if (DelectKeyController.this.mSelectState == 8) {
                    ToastUtils.show(DelectKeyController.this.mActivity, "删除钥匙成功");
                } else if (DelectKeyController.this.mSelectState == 10) {
                    ToastUtils.show(DelectKeyController.this.mActivity, "删除卡片成功");
                } else if (DelectKeyController.this.mSelectState == 11) {
                    ToastUtils.show(DelectKeyController.this.mActivity, "删除指纹成功");
                } else if (DelectKeyController.this.mSelectState == 14) {
                    ToastUtils.show(DelectKeyController.this.mActivity, "同步数据成功");
                }
                BluetoothSDK.getInstance().closeBLE();
                if (!LocalBusinessStore.getDoorLockTip(DelectKeyController.this.mActivity)) {
                    DelectKeyController.this.mActivity.finish();
                } else {
                    EventBus.getDefault().post(new DoorLockInfoSyncEvent());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDeleteKey() {
        String doorLockServerKeyID = LocalBusinessStore.getDoorLockServerKeyID(this.mActivity);
        String doorLockDeviceKeyID = LocalBusinessStore.getDoorLockDeviceKeyID(this.mActivity);
        int i = this.mSelectState;
        if (i == 8) {
            DoorLockSyncInfoControllerUtil.getInstance().setFunctionStateDelete(DoorLockSyncInfoControllerUtil.FunctionState.delectpsw, doorLockServerKeyID, doorLockDeviceKeyID);
            return;
        }
        if (i == 10) {
            DoorLockSyncInfoControllerUtil.getInstance().setFunctionStateDelete(DoorLockSyncInfoControllerUtil.FunctionState.delectcard, doorLockServerKeyID, doorLockDeviceKeyID);
        } else if (i == 11) {
            DoorLockSyncInfoControllerUtil.getInstance().setFunctionStateDelete(DoorLockSyncInfoControllerUtil.FunctionState.delectpress, doorLockServerKeyID, doorLockDeviceKeyID);
        } else if (i == 14) {
            DoorLockSyncInfoControllerUtil.getInstance().setFunctionStateSyncData(DoorLockSyncInfoControllerUtil.FunctionState.syncdata);
        }
    }
}
