package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenRunnableV3 {
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private OpenListener mOpenListener;

    public void setOpenListener(OpenListener openListener) {
        this.mOpenListener = openListener;
    }

    public OpenRunnableV3(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV3.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV3.this.mOpenListener != null) {
                        OpenRunnableV3.this.mOpenListener.onSuccess(bluetoothDevice, true);
                    }
                } finally {
                    OpenRunnableV3.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV3.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV3.this.mOpenListener != null) {
                        OpenRunnableV3.this.mOpenListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    OpenRunnableV3.this.stopAndRelease();
                }
            }
        });
    }

    private void callData(BluetoothDevice bluetoothDevice, String str) {
        try {
            OpenListener openListener = this.mOpenListener;
            if (openListener != null) {
                openListener.onDataV3(bluetoothDevice, str);
            }
        } catch (Exception unused) {
        }
    }

    public void sendData(String str) {
        BluetoothManager.getInstance().sendData(TimeOut.SendV3, 2500, str);
    }

    public void receivedData(String str) {
        if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || ((str.length() == 18 && str.toUpperCase().startsWith("AA")) || str.toUpperCase().equals("A5") || str.toUpperCase().equals("AC"))) {
            if (str.toUpperCase().equals("A5")) {
                callData(this.mCurrentHardware, str);
                return;
            }
            if (str.toUpperCase().startsWith("AA") && str.length() == 18) {
                callOnSuccess(this.mCurrentHardware);
                return;
            }
            if (str.startsWith("55") && str.length() == 40) {
                callData(this.mCurrentHardware, str);
            } else if (str.toUpperCase().equals("AC")) {
                callData(this.mCurrentHardware, str);
            }
        }
    }
}
