package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.MoneyBackListener;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MoneyBackRunnable {
    private short mBalance;
    private BluetoothDevice mCurrentHardware;
    private boolean mIsTwoVision;
    private MoneyBackListener mMoneyBackListener;
    private String mReceiveddata;
    private long mStudentNo;
    private iIOViewMessage miIOViewMessage = new iIOViewMessage() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnable.5
        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnNoneBond(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnStart(BluetoothDevice bluetoothDevice) {
            MoneyBackRunnable.this.callOnStart(bluetoothDevice);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnBluetoothException(BluetoothDevice bluetoothDevice, String str) {
            MoneyBackRunnable.this.callOnBluetoothException(new ClientException(-1, str));
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            MoneyBackRunnable.this.callOnFail(bluetoothDevice, timeOut, "");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnConnectSuccess(BluetoothDevice bluetoothDevice) {
            BluetoothManager.getInstance().sendData(TimeOut.SendGetDeviceSettingCommand, 3000, CommandUtilsWrapper.getReturnSettingCommand());
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str) {
            byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
            MoneyBackRunnable.this.mReceiveddata = str;
            if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
                if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                    CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                    MoneyBackRunnable.this.mIsTwoVision = CommandUtilsWrapper.getDeviceVersion() != 0;
                    if (MoneyBackRunnable.this.mIsTwoVision) {
                        MoneyBackRunnable.this.moneyBackRunnableV2 = new MoneyBackRunnableV2(MoneyBackRunnable.this.mCurrentHardware, MoneyBackRunnable.this.mStudentNo, MoneyBackRunnable.this.mBalance);
                        MoneyBackRunnable.this.moneyBackRunnableV2.setOpenListener(MoneyBackRunnable.this.mMoneyBackListener);
                    } else {
                        MoneyBackRunnable.this.moneyBackRunnableV1 = new MoneyBackRunnableV1(MoneyBackRunnable.this.mCurrentHardware, MoneyBackRunnable.this.mStudentNo, MoneyBackRunnable.this.mBalance);
                        MoneyBackRunnable.this.moneyBackRunnableV1.setOpenListener(MoneyBackRunnable.this.mMoneyBackListener);
                    }
                    MoneyBackRunnable.this.sendData();
                    return;
                }
                return;
            }
            MoneyBackRunnable.this.sendData();
        }
    };
    private MoneyBackRunnableV1 moneyBackRunnableV1;
    private MoneyBackRunnableV2 moneyBackRunnableV2;

    public void setOpenListener(MoneyBackListener moneyBackListener) {
        this.mMoneyBackListener = moneyBackListener;
    }

    public MoneyBackRunnable(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice, long j, short s) {
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
        this.mBalance = s;
    }

    public void start() {
        BluetoothManager.getInstance().startConnect(this.mCurrentHardware);
    }

    public void sendData() {
        MoneyBackRunnableV1 moneyBackRunnableV1;
        MoneyBackRunnableV2 moneyBackRunnableV2;
        boolean z = this.mIsTwoVision;
        if (z && (moneyBackRunnableV2 = this.moneyBackRunnableV2) != null) {
            moneyBackRunnableV2.receivedData(this.mReceiveddata);
        } else {
            if (z || (moneyBackRunnableV1 = this.moneyBackRunnableV1) == null) {
                return;
            }
            moneyBackRunnableV1.receivedData(this.mReceiveddata);
        }
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (MoneyBackRunnable.this.mMoneyBackListener != null) {
                    MoneyBackRunnable.this.mMoneyBackListener.onStart(bluetoothDevice);
                }
            }
        });
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnable.this.mMoneyBackListener != null) {
                        MoneyBackRunnable.this.mMoneyBackListener.onSuccess(bluetoothDevice, z);
                    }
                } finally {
                    MoneyBackRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnable.this.mMoneyBackListener != null) {
                        MoneyBackRunnable.this.mMoneyBackListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    MoneyBackRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (MoneyBackRunnable.this.mMoneyBackListener != null) {
                        MoneyBackRunnable.this.mMoneyBackListener.onBluetoothException(clientException);
                    }
                } finally {
                    MoneyBackRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private boolean callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
        try {
            MoneyBackListener moneyBackListener = this.mMoneyBackListener;
            if (moneyBackListener != null) {
                return moneyBackListener.needUploadOrder(bluetoothDevice, orderBean);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
