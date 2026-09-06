package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.CloseListener;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.LocalBusinessStore;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CloseRunnable {
    public static CloseRunnable INSTANCE;
    private CloseRunnableV1 closeRunnableV1;
    private CloseRunnableV2 closeRunnableV2;
    public CloseRunnableV3 closeRunnableV3;
    private boolean isNetworkStatus;
    private short mBalance;
    private CloseListener mCloseListener;
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private String mF5Data;
    private boolean mIsTwoVision;
    private long mStudentNo;
    private boolean mIsBind = true;
    private iIOViewMessage miIOViewMessage = new iIOViewMessage() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnable.5
        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnStart(BluetoothDevice bluetoothDevice) {
            CloseRunnable.this.callOnStart(bluetoothDevice);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnBluetoothException(BluetoothDevice bluetoothDevice, String str) {
            CloseRunnable.this.callOnBluetoothException(new ClientException(-1, str));
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            CloseRunnable.this.callOnFail(bluetoothDevice, timeOut, "");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnConnectSuccess(BluetoothDevice bluetoothDevice) {
            if (LocalBusinessStore.getVersion(CloseRunnable.this.mContext, bluetoothDevice.address) == 3) {
                BluetoothManager.getInstance().sendData(TimeOut.SendCloseAA, 3000, "AA");
            } else {
                BluetoothManager.getInstance().sendData(TimeOut.SendCloseGetDeviceSetting, 3000, CommandUtilsWrapper.getReturnSettingCommand());
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str) {
            CloseRunnable.this.mF5Data = str;
            if (LocalBusinessStore.getVersion(CloseRunnable.this.mContext, bluetoothDevice.address) == 3) {
                CloseRunnable.this.closeRunnableV3 = new CloseRunnableV3(CloseRunnable.this.mCurrentHardware, CloseRunnable.this.mStudentNo);
                CloseRunnable.this.closeRunnableV3.setCloseListener(CloseRunnable.this.mCloseListener);
                CloseRunnable.this.sendData();
                return;
            }
            byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
            if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
                if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                    CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                    CloseRunnable.this.mIsTwoVision = CommandUtilsWrapper.getDeviceVersion() != 0;
                    if (CloseRunnable.this.mIsTwoVision) {
                        CloseRunnable.this.closeRunnableV2 = new CloseRunnableV2(CloseRunnable.this.mCurrentHardware, CloseRunnable.this.mStudentNo, CloseRunnable.this.mBalance, CloseRunnable.this.isNetworkStatus, CloseRunnable.this.mIsBind);
                        CloseRunnable.this.closeRunnableV2.setCloseListener(CloseRunnable.this.mCloseListener);
                    } else {
                        CloseRunnable.this.closeRunnableV1 = new CloseRunnableV1(CloseRunnable.this.mCurrentHardware, CloseRunnable.this.mStudentNo, CloseRunnable.this.mBalance, CloseRunnable.this.isNetworkStatus);
                        CloseRunnable.this.closeRunnableV1.setCloseListener(CloseRunnable.this.mCloseListener);
                    }
                    CloseRunnable.this.sendData();
                    return;
                }
                return;
            }
            CloseRunnable.this.sendData();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnNoneBond(BluetoothDevice bluetoothDevice) {
            CloseRunnable.this.callOnNoneBond(bluetoothDevice);
        }
    };

    public static CloseRunnable getInstance() {
        CloseRunnable closeRunnable = INSTANCE;
        if (closeRunnable != null) {
            return closeRunnable;
        }
        throw new RuntimeException("must call init()");
    }

    public static void init(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
        INSTANCE = new CloseRunnable(context, bluetoothDevice, j, s, z);
    }

    public CloseRunnable(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
        this.isNetworkStatus = z;
        BluetoothManager.init(context);
    }

    public void startConnect() {
        BluetoothManager.getInstance().startConnect(this.mCurrentHardware);
    }

    public void sendData() {
        CloseRunnableV1 closeRunnableV1;
        CloseRunnableV2 closeRunnableV2;
        if (LocalBusinessStore.getVersion(this.mContext, this.mCurrentHardware.address) == 3) {
            this.closeRunnableV3.receivedData(this.mF5Data);
            return;
        }
        boolean z = this.mIsTwoVision;
        if (z && (closeRunnableV2 = this.closeRunnableV2) != null) {
            closeRunnableV2.receivedData(this.mF5Data);
        } else {
            if (z || (closeRunnableV1 = this.closeRunnableV1) == null) {
                return;
            }
            closeRunnableV1.receivedData(this.mF5Data);
        }
    }

    public void closeUploadOrder(boolean z) {
        CloseRunnableV1 closeRunnableV1;
        CloseRunnableV2 closeRunnableV2;
        boolean z2 = this.mIsTwoVision;
        if (z2 && (closeRunnableV2 = this.closeRunnableV2) != null) {
            closeRunnableV2.uploadOrder(z);
        } else {
            if (z2 || (closeRunnableV1 = this.closeRunnableV1) == null) {
                return;
            }
            closeRunnableV1.uploadOrder(z);
        }
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    public void setCloseListener(CloseListener closeListener) {
        BluetoothManager.getInstance().setIOViewMessage(this.miIOViewMessage);
        this.mCloseListener = closeListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (CloseRunnable.this.mCloseListener != null) {
                    CloseRunnable.this.mCloseListener.onStart(bluetoothDevice);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnable.this.mCloseListener != null) {
                        CloseRunnable.this.mCloseListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    CloseRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnable.this.mCloseListener != null) {
                        CloseRunnable.this.mCloseListener.onBluetoothException(clientException);
                    }
                } finally {
                    CloseRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnNoneBond(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnable.this.mCloseListener != null) {
                        CloseRunnable.this.mCloseListener.onNoneBond(bluetoothDevice);
                    }
                } finally {
                    CloseRunnable.this.stopAndRelease();
                }
            }
        });
    }
}
