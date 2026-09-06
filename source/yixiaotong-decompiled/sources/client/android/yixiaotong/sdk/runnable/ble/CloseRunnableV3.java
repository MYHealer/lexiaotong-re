package client.android.yixiaotong.sdk.runnable.ble;

import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.CloseListener;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CloseRunnableV3 {
    private CloseListener mCloseListener;
    private BluetoothDevice mCurrentHardware;
    private long mStudentNo;

    public void setCloseListener(CloseListener closeListener) {
        this.mCloseListener = closeListener;
    }

    public CloseRunnableV3(BluetoothDevice bluetoothDevice, long j) {
        this.mCurrentHardware = bluetoothDevice;
        this.mStudentNo = j;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV3.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnableV3.this.mCloseListener != null) {
                        CloseRunnableV3.this.mCloseListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    CloseRunnableV3.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CloseRunnableV3.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CloseRunnableV3.this.mCloseListener != null) {
                        CloseRunnableV3.this.mCloseListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    CloseRunnableV3.this.stopAndRelease();
                }
            }
        });
    }

    private void callData(BluetoothDevice bluetoothDevice, String str) {
        try {
            CloseListener closeListener = this.mCloseListener;
            if (closeListener != null) {
                closeListener.onDataV3(bluetoothDevice, str);
            }
        } catch (Exception unused) {
        }
    }

    public void sendData(String str) {
        BluetoothManager.getInstance().sendData(TimeOut.SendV3, 1500, str);
    }

    public void receivedData(String str) {
        if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || ((str.length() == 18 && str.toUpperCase().startsWith("AA")) || str.toUpperCase().equals("A5") || str.toUpperCase().equals("AC"))) {
            if (str.toUpperCase().equals("A5")) {
                callData(this.mCurrentHardware, str);
                return;
            }
            if (str.startsWith("55") && str.length() == 40) {
                callData(this.mCurrentHardware, str);
                stopAndRelease();
            } else if (str.toUpperCase().equals("AC")) {
                callData(this.mCurrentHardware, str);
            }
        }
    }
}
