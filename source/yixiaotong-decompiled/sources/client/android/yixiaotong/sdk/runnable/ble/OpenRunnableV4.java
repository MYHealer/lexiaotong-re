package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.command.VersionCommandV2;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenRunnableV4 {
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private OpenListener mOpenListener;
    private SendCommand mSendCommand = SendCommand.none;
    private String mStudentNo;

    private enum SendCommand {
        none,
        sendf0,
        send01,
        send08,
        send06,
        send02,
        send02after
    }

    public void setOpenListener(OpenListener openListener) {
        this.mOpenListener = openListener;
    }

    public OpenRunnableV4(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV4.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV4.this.mOpenListener != null) {
                        OpenRunnableV4.this.mOpenListener.onSuccess(bluetoothDevice, true);
                    }
                } finally {
                    OpenRunnableV4.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnableV4.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnableV4.this.mOpenListener != null) {
                        OpenRunnableV4.this.mOpenListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    OpenRunnableV4.this.stopAndRelease();
                }
            }
        });
    }

    private String callStudentId(BluetoothDevice bluetoothDevice) {
        try {
            OpenListener openListener = this.mOpenListener;
            return openListener != null ? openListener.onGetStudentId(bluetoothDevice) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private String callAuthData(BluetoothDevice bluetoothDevice) {
        try {
            OpenListener openListener = this.mOpenListener;
            return openListener != null ? openListener.onGetAuthDataV4(bluetoothDevice) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private void callData(BluetoothDevice bluetoothDevice, String str, String str2) {
        try {
            OpenListener openListener = this.mOpenListener;
            if (openListener != null) {
                openListener.onDataV4(bluetoothDevice, str, str2);
            }
        } catch (Exception unused) {
        }
    }

    private void sendData(String str) {
        BluetoothManager.getInstance().sendData(TimeOut.Send08Command, 2000, str);
    }

    public void receivedData(String str, boolean z) {
        if (this.mSendCommand == SendCommand.none) {
            String randNumMaxString = RandomUtil.getRandNumMaxString(2);
            String randNumMaxString2 = RandomUtil.getRandNumMaxString(2);
            this.mSendCommand = SendCommand.send08;
            BluetoothManager.getInstance().sendData(TimeOut.Send08Command, 2000, VersionCommandV2.getRandCommand(randNumMaxString, randNumMaxString2));
            return;
        }
        if (this.mSendCommand == SendCommand.send08) {
            callData(this.mCurrentHardware, str, this.mSendCommand + "");
            String randNumMaxString3 = RandomUtil.getRandNumMaxString(2);
            String randNumMaxString4 = RandomUtil.getRandNumMaxString(2);
            String strCallStudentId = callStudentId(this.mCurrentHardware);
            this.mStudentNo = strCallStudentId;
            if (StringUtils.isNotEmpty(strCallStudentId)) {
                this.mSendCommand = SendCommand.send02;
                BluetoothManager.getInstance().sendData(TimeOut.Send02Command, 15000, VersionCommandV2.collectOrderCommand(randNumMaxString3, randNumMaxString4, true, this.mStudentNo));
                return;
            }
            callOnFail(this.mCurrentHardware, null, "学生ID不能为空!");
            return;
        }
        if (this.mSendCommand == SendCommand.send02) {
            callData(this.mCurrentHardware, str, this.mSendCommand + "");
            this.mSendCommand = SendCommand.send02after;
            return;
        }
        if (this.mSendCommand == SendCommand.send02after) {
            String randNumMaxString5 = RandomUtil.getRandNumMaxString(2);
            String randNumMaxString6 = RandomUtil.getRandNumMaxString(2);
            if (z) {
                String strCallAuthData = callAuthData(this.mCurrentHardware);
                this.mSendCommand = SendCommand.send06;
                BluetoothManager.getInstance().sendData(TimeOut.Send06Command, 2000, VersionCommandV2.openOnlineCommand(randNumMaxString5, randNumMaxString6, strCallAuthData));
                return;
            }
            String strCallAuthData2 = callAuthData(this.mCurrentHardware);
            this.mSendCommand = SendCommand.send01;
            BluetoothManager.getInstance().sendData(TimeOut.Send01Command, 2000, VersionCommandV2.openOffineCommand(randNumMaxString5, randNumMaxString6, this.mStudentNo, client.android.yixiaotong.util.bluetooth.BluetoothDevice.DEFAULT_DEVICEHEXNO, strCallAuthData2));
            return;
        }
        if (this.mSendCommand == SendCommand.send06 || this.mSendCommand == SendCommand.send01) {
            callOnSuccess(this.mCurrentHardware);
        }
    }
}
