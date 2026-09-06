package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.command.VersionCommandV2;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.SettingListener;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SettingRunnableV4 {
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private SettingListener mListener;
    private String mSetData;
    private SendCommand mSendCommand = SendCommand.none;
    private iIOViewMessage miIOViewMessage = new iIOViewMessage() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingRunnableV4.3
        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnBluetoothException(BluetoothDevice bluetoothDevice, String str) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnConnectSuccess(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnNoneBond(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnStart(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            SettingRunnableV4 settingRunnableV4 = SettingRunnableV4.this;
            settingRunnableV4.callOnFail(settingRunnableV4.mCurrentHardware, timeOut);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str) {
            SettingRunnableV4.this.receivedData(str);
        }
    };

    private enum SendCommand {
        none,
        send07
    }

    public SettingRunnableV4(Context context, BluetoothDevice bluetoothDevice, String str) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
        this.mSetData = str;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    public void setListener(SettingListener settingListener) {
        this.mListener = settingListener;
        BluetoothManager.getInstance().setIOViewMessage(this.miIOViewMessage);
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingRunnableV4.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingRunnableV4.this.mListener != null) {
                        SettingRunnableV4.this.mListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    SettingRunnableV4.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingRunnableV4.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingRunnableV4.this.mListener != null) {
                        SettingRunnableV4.this.mListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    SettingRunnableV4.this.stopAndRelease();
                }
            }
        });
    }

    public void receivedData(String str) {
        if (this.mSendCommand == SendCommand.none) {
            this.mSendCommand = SendCommand.send07;
            BluetoothManager.getInstance().sendData(TimeOut.Send08Command, 2000, VersionCommandV2.SetMachineNoCommand(this.mSetData));
        } else if (this.mSendCommand == SendCommand.send07 && StringUtils.isNotEmpty(str) && str.length() > 24) {
            if ("00".equals(str.substring(22, 24))) {
                callOnSuccess(this.mCurrentHardware);
            } else {
                callOnFail(this.mCurrentHardware, TimeOut.Send07Command);
            }
        }
    }
}
