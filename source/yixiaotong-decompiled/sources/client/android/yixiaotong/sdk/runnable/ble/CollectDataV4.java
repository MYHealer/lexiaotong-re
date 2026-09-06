package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.command.VersionCommandV2;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.CollectDataListener;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class CollectDataV4 {
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private CollectDataListener mListener;
    private String mRand;
    private String mStudentNo;
    private SendCommand mSendCommand = SendCommand.none;
    private boolean mIsCollectSelfData = true;
    private iIOViewMessage miIOViewMessage = new iIOViewMessage() { // from class: client.android.yixiaotong.sdk.runnable.ble.CollectDataV4.3
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
            CollectDataV4 collectDataV4 = CollectDataV4.this;
            collectDataV4.callOnFail(collectDataV4.mCurrentHardware, null, "发送数据超时" + timeOut);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str) {
            CollectDataV4.this.receivedData(str, true);
        }
    };

    private enum SendCommand {
        none,
        sendf0,
        send01,
        send08,
        send06,
        send02,
        send02after
    }

    public CollectDataV4(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    public void setOpenListener(CollectDataListener collectDataListener) {
        this.mListener = collectDataListener;
        BluetoothManager.getInstance().setIOViewMessage(this.miIOViewMessage);
    }

    private void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CollectDataV4.1
            @Override // java.lang.Runnable
            public void run() {
                if (CollectDataV4.this.mListener != null) {
                    CollectDataV4.this.mListener.onSuccess(bluetoothDevice, true);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.CollectDataV4.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (CollectDataV4.this.mListener != null) {
                        CollectDataV4.this.mListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    CollectDataV4.this.stopAndRelease();
                }
            }
        });
    }

    private boolean callUploadOrder(BluetoothDevice bluetoothDevice, String str, String str2) {
        try {
            CollectDataListener collectDataListener = this.mListener;
            if (collectDataListener != null) {
                return collectDataListener.needUploadOrder(bluetoothDevice, str, str2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private String callStudentId(BluetoothDevice bluetoothDevice) {
        try {
            CollectDataListener collectDataListener = this.mListener;
            return collectDataListener != null ? collectDataListener.onGetStudentId(bluetoothDevice) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private void callMachineRand(BluetoothDevice bluetoothDevice, String str) {
        try {
            CollectDataListener collectDataListener = this.mListener;
            if (collectDataListener != null) {
                collectDataListener.onMachineRand(bluetoothDevice, str);
            }
        } catch (Exception unused) {
        }
    }

    private String callOpenData(BluetoothDevice bluetoothDevice) {
        try {
            CollectDataListener collectDataListener = this.mListener;
            return collectDataListener != null ? collectDataListener.onGetOpenData(bluetoothDevice) : "";
        } catch (Exception unused) {
            return "";
        }
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
            this.mRand = str.substring(22, 30);
            Log.e("test", "随机数:" + this.mRand);
            callMachineRand(this.mCurrentHardware, this.mRand);
            if (z) {
                String randNumMaxString3 = RandomUtil.getRandNumMaxString(2);
                String randNumMaxString4 = RandomUtil.getRandNumMaxString(2);
                this.mSendCommand = SendCommand.send02;
                String strCallStudentId = callStudentId(this.mCurrentHardware);
                this.mStudentNo = strCallStudentId;
                BluetoothManager.getInstance().sendData(TimeOut.Send02Command, 3000, VersionCommandV2.collectOrderCommand(randNumMaxString3, randNumMaxString4, this.mIsCollectSelfData, strCallStudentId));
                return;
            }
            return;
        }
        if (this.mSendCommand != SendCommand.send02) {
            if (this.mSendCommand == SendCommand.send06) {
                this.mIsCollectSelfData = false;
                String randNumMaxString5 = RandomUtil.getRandNumMaxString(2);
                String randNumMaxString6 = RandomUtil.getRandNumMaxString(2);
                this.mSendCommand = SendCommand.send08;
                BluetoothManager.getInstance().sendData(TimeOut.Send08Command, 2000, VersionCommandV2.getRandCommand(randNumMaxString5, randNumMaxString6));
                return;
            }
            return;
        }
        if (this.mIsCollectSelfData) {
            if (str.length() > 70 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01"))) {
                if (callUploadOrder(this.mCurrentHardware, str, this.mRand)) {
                    String randNumMaxString7 = RandomUtil.getRandNumMaxString(2);
                    String randNumMaxString8 = RandomUtil.getRandNumMaxString(2);
                    this.mSendCommand = SendCommand.send06;
                    this.mStudentNo = callStudentId(this.mCurrentHardware);
                    BluetoothManager.getInstance().sendData(TimeOut.Send06Command, 3000, VersionCommandV2.openOnlineCommand(randNumMaxString7, randNumMaxString8, callOpenData(this.mCurrentHardware)));
                    return;
                }
                callOnFail(this.mCurrentHardware, null, "服务器异常，无法采集数据");
                return;
            }
            this.mIsCollectSelfData = false;
            String randNumMaxString9 = RandomUtil.getRandNumMaxString(2);
            String randNumMaxString10 = RandomUtil.getRandNumMaxString(2);
            this.mSendCommand = SendCommand.send08;
            BluetoothManager.getInstance().sendData(TimeOut.Send08Command, 2000, VersionCommandV2.getRandCommand(randNumMaxString9, randNumMaxString10));
            return;
        }
        if (str.length() > 70 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01"))) {
            if (callUploadOrder(this.mCurrentHardware, str, this.mRand)) {
                String randNumMaxString11 = RandomUtil.getRandNumMaxString(2);
                String randNumMaxString12 = RandomUtil.getRandNumMaxString(2);
                this.mSendCommand = SendCommand.send06;
                this.mStudentNo = callStudentId(this.mCurrentHardware);
                BluetoothManager.getInstance().sendData(TimeOut.Send06Command, 3000, VersionCommandV2.openOnlineCommand(randNumMaxString11, randNumMaxString12, callOpenData(this.mCurrentHardware)));
                return;
            }
            callOnFail(this.mCurrentHardware, null, "服务器异常，无法采集数据");
            return;
        }
        callOnSuccess(this.mCurrentHardware);
    }
}
