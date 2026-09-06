package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.command.VersionCommandV2;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.LocalBusinessStore;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class OpenRunnable {
    public static OpenRunnable INSTANCE;
    private boolean isNetworkStatus;
    private short mBalance;
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private boolean mIsTwoVision;
    private OpenListener mOpenListener;
    private String mReceiveddata;
    private SendCommand mSendCommand;
    private long mStudentNo;
    private OpenRunnableV1 openRunnable;
    private OpenRunnableV2 openRunnableV2;
    private OpenRunnableV3 openRunnableV3;
    private OpenRunnableV4 openRunnableV4;
    private boolean mIsBind = true;
    private boolean mIsReceivedSuccess = false;
    private iIOViewMessage miIOViewMessage = new AnonymousClass9();

    private enum SendCommand {
        f0,
        none
    }

    public static OpenRunnable getInstance() {
        OpenRunnable openRunnable = INSTANCE;
        if (openRunnable != null) {
            return openRunnable;
        }
        throw new RuntimeException("must call init()");
    }

    public static void init(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
        INSTANCE = new OpenRunnable(context, bluetoothDevice, j, s, z);
    }

    public void setMode(boolean z) {
        BluetoothManager.getInstance().setMode(z);
    }

    public OpenRunnable(Context context, BluetoothDevice bluetoothDevice, long j, short s, boolean z) {
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

    public void receivedData(boolean z) {
        OpenRunnableV1 openRunnableV1;
        OpenRunnableV2 openRunnableV2;
        this.isNetworkStatus = z;
        if (LocalBusinessStore.getVersion(this.mContext, this.mCurrentHardware.address) == 3) {
            this.openRunnableV3.receivedData(this.mReceiveddata);
            return;
        }
        if (LocalBusinessStore.getVersion(this.mContext, this.mCurrentHardware.address) == 4) {
            this.openRunnableV4.receivedData(this.mReceiveddata, z);
            return;
        }
        boolean z2 = this.mIsTwoVision;
        if (z2 && (openRunnableV2 = this.openRunnableV2) != null) {
            openRunnableV2.receivedData(this.mReceiveddata, this.isNetworkStatus);
        } else {
            if (z2 || (openRunnableV1 = this.openRunnable) == null) {
                return;
            }
            openRunnableV1.receivedData(this.mReceiveddata);
        }
    }

    public void openUploadOrder(boolean z) {
        OpenRunnableV1 openRunnableV1;
        OpenRunnableV2 openRunnableV2;
        boolean z2 = this.mIsTwoVision;
        if (z2 && (openRunnableV2 = this.openRunnableV2) != null) {
            openRunnableV2.uploadOrder(z);
        } else {
            if (z2 || (openRunnableV1 = this.openRunnable) == null) {
                return;
            }
            openRunnableV1.uploadOrder(z);
        }
    }

    public void openForF1(String str) {
        OpenRunnableV2 openRunnableV2;
        if (!this.mIsTwoVision || (openRunnableV2 = this.openRunnableV2) == null) {
            return;
        }
        openRunnableV2.openForF1(str);
    }

    public void sendDataV3(String str) {
        this.openRunnableV3.sendData(str);
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    public void setOpenListener(OpenListener openListener) {
        OpenRunnableV1 openRunnableV1;
        OpenRunnableV2 openRunnableV2;
        BluetoothManager.getInstance().setIOViewMessage(this.miIOViewMessage);
        this.mOpenListener = openListener;
        if (LocalBusinessStore.getVersion(this.mContext, this.mCurrentHardware.address) == 3) {
            OpenRunnableV3 openRunnableV3 = this.openRunnableV3;
            if (openRunnableV3 != null) {
                openRunnableV3.setOpenListener(this.mOpenListener);
                return;
            }
            return;
        }
        boolean z = this.mIsTwoVision;
        if (z && (openRunnableV2 = this.openRunnableV2) != null) {
            openRunnableV2.setOpenListener(this.mOpenListener);
        } else {
            if (z || (openRunnableV1 = this.openRunnable) == null) {
                return;
            }
            openRunnableV1.setOpenListener(this.mOpenListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (OpenRunnable.this.mOpenListener != null) {
                    OpenRunnable.this.mOpenListener.onStart(bluetoothDevice);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnConnectBLESuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (OpenRunnable.this.mOpenListener != null) {
                    OpenRunnable.this.mOpenListener.onConnectBLESuccess(bluetoothDevice);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnConnectSuccess(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                if (OpenRunnable.this.mOpenListener != null) {
                    OpenRunnable.this.mOpenListener.onConnectSuccess(bluetoothDevice, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnConnectSuccessV3(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                if (OpenRunnable.this.mOpenListener != null) {
                    OpenRunnable.this.mOpenListener.onConnectSuccessV3(bluetoothDevice, str);
                }
            }
        });
    }

    private void callOnConnectSuccessNew(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                if (OpenRunnable.this.mOpenListener != null) {
                    OpenRunnable.this.mOpenListener.onConnectSuccessNew(bluetoothDevice, str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnable.this.mOpenListener != null) {
                        OpenRunnable.this.mOpenListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    OpenRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnable.this.mOpenListener != null) {
                        OpenRunnable.this.mOpenListener.onBluetoothException(clientException);
                    }
                } finally {
                    OpenRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnNoneBond(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.8
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (OpenRunnable.this.mOpenListener != null) {
                        OpenRunnable.this.mOpenListener.onNoneBond(bluetoothDevice);
                    }
                } finally {
                    OpenRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable$9, reason: invalid class name */
    class AnonymousClass9 implements iIOViewMessage {
        AnonymousClass9() {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnStart(BluetoothDevice bluetoothDevice) {
            OpenRunnable.this.callOnStart(bluetoothDevice);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnBluetoothException(BluetoothDevice bluetoothDevice, String str) {
            OpenRunnable.this.callOnBluetoothException(new ClientException(-1, str));
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            OpenRunnable.this.callOnFail(bluetoothDevice, timeOut, "");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnConnectSuccess(BluetoothDevice bluetoothDevice) {
            OpenRunnable.this.callOnConnectBLESuccess(bluetoothDevice);
            OpenRunnable.this.mIsReceivedSuccess = false;
            OpenRunnable.this.mSendCommand = SendCommand.none;
            if (LocalBusinessStore.getVersion(OpenRunnable.this.mContext, bluetoothDevice.address) != 1 && LocalBusinessStore.getVersion(OpenRunnable.this.mContext, bluetoothDevice.address) != 2) {
                if (LocalBusinessStore.getVersion(OpenRunnable.this.mContext, bluetoothDevice.address) == 3) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.9.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothManager.getInstance().sendData(TimeOut.SendAA, 10000, "AA");
                        }
                    }, 100L);
                    return;
                } else {
                    MainThreadExecutor.getInstance().executeDelayed(new AnonymousClass3(), 100L);
                    return;
                }
            }
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.9.1
                @Override // java.lang.Runnable
                public void run() {
                    BluetoothManager.getInstance().sendData(TimeOut.SendOpenGetDeviceSettingCommand, 15000, CommandUtilsWrapper.getReturnSettingCommand());
                }
            }, 500L);
        }

        /* JADX INFO: renamed from: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable$9$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                BluetoothManager.getInstance().sendData(TimeOut.SendAA, 15000, "AA");
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.9.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (OpenRunnable.this.mIsReceivedSuccess) {
                            return;
                        }
                        BluetoothManager.getInstance().sendData(TimeOut.SendOpenGetDeviceSettingCommand, 15000, CommandUtilsWrapper.getReturnSettingCommand());
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.OpenRunnable.9.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (OpenRunnable.this.mIsReceivedSuccess) {
                                    return;
                                }
                                OpenRunnable.this.mSendCommand = SendCommand.f0;
                                BluetoothManager.getInstance().sendData(TimeOut.SendNewCommand, 15000, VersionCommandV2.selectInfoCommand());
                            }
                        }, 500L);
                    }
                }, 500L);
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str) {
            byte[] bArrHexToBuffer = HexString.hexToBuffer(str);
            OpenRunnable.this.mReceiveddata = str;
            OpenRunnable.this.mIsReceivedSuccess = true;
            if (LocalBusinessStore.getVersion(OpenRunnable.this.mContext, bluetoothDevice.address) == 3) {
                if ((!str.startsWith("55") || str.length() != 40) && !str.equals("A5")) {
                    OpenRunnable openRunnable = OpenRunnable.this;
                    openRunnable.receivedData(openRunnable.isNetworkStatus);
                    return;
                } else {
                    OpenRunnable.this.openRunnableV3 = new OpenRunnableV3(OpenRunnable.this.mContext, OpenRunnable.this.mCurrentHardware);
                    OpenRunnable.this.openRunnableV3.setOpenListener(OpenRunnable.this.mOpenListener);
                    OpenRunnable openRunnable2 = OpenRunnable.this;
                    openRunnable2.callOnConnectSuccessV3(openRunnable2.mCurrentHardware, str);
                    return;
                }
            }
            if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer)) {
                OpenRunnable.this.mIsReceivedSuccess = true;
                if (CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer)) {
                    OpenRunnable openRunnable3 = OpenRunnable.this;
                    openRunnable3.callOnConnectSuccess(openRunnable3.mCurrentHardware, str);
                    CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer);
                    OpenRunnable.this.mIsTwoVision = CommandUtilsWrapper.getDeviceVersion() != 0;
                    if (OpenRunnable.this.mIsTwoVision) {
                        LocalBusinessStore.saveVersion(OpenRunnable.this.mContext, bluetoothDevice.address, 2);
                        OpenRunnable.this.openRunnableV2 = new OpenRunnableV2(OpenRunnable.this.mContext, OpenRunnable.this.mCurrentHardware, OpenRunnable.this.mStudentNo, OpenRunnable.this.mBalance, OpenRunnable.this.isNetworkStatus, OpenRunnable.this.mIsBind);
                        OpenRunnable.this.openRunnableV2.setOpenListener(OpenRunnable.this.mOpenListener);
                        return;
                    } else {
                        LocalBusinessStore.saveVersion(OpenRunnable.this.mContext, bluetoothDevice.address, 1);
                        OpenRunnable.this.openRunnable = new OpenRunnableV1(OpenRunnable.this.mContext, OpenRunnable.this.mCurrentHardware, OpenRunnable.this.mStudentNo, OpenRunnable.this.mBalance, OpenRunnable.this.isNetworkStatus);
                        OpenRunnable.this.openRunnable.setOpenListener(OpenRunnable.this.mOpenListener);
                        return;
                    }
                }
                return;
            }
            OpenRunnable openRunnable4 = OpenRunnable.this;
            openRunnable4.receivedData(openRunnable4.isNetworkStatus);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnNoneBond(BluetoothDevice bluetoothDevice) {
            OpenRunnable.this.callOnNoneBond(bluetoothDevice);
        }
    }
}
