package client.android.yixiaotong.sdk.runnable.socket;

import android.content.Context;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.socket.Device;
import client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.DeviceBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.InitListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import com.kwad.sdk.core.imageloader.KSImageLoader;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class InitSocketRunnable {
    private boolean isRunning;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private InitListener mInitListener;
    private TextView mLogTextView;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.6
        public int leftCount = 0;
        private int mCommandIndex;
        private String[] mCommands;
        public StringBuilder stringBuilder;

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotEnabled() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotSupported() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnecting(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnectionFailed(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDeviceFound(Device device) {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDisconnected() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryFinished() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryStarted() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnected(Device device) {
            String address = device.getAddress();
            if (address == null || InitSocketRunnable.this.mCurrentHardware == null || !address.equals(InitSocketRunnable.this.mCurrentHardware.address) || InitSocketRunnable.this.mCurrentHardware.isTimeout || !InitSocketRunnable.this.isRunning) {
                return;
            }
            InitSocketRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
            InitSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(CommandUtilsWrapper.getReturnSettingCommand()));
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
            if (InitSocketRunnable.this.mCurrentHardware.isTimeout || !InitSocketRunnable.this.isRunning) {
                return;
            }
            readData(bArr);
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
            String strBufferToHex = HexString.bufferToHex(bArr);
            if (!strBufferToHex.startsWith("550001") || strBufferToHex.length() < 8) {
                StringBuilder sb2 = this.stringBuilder;
                if (sb2 == null) {
                    return;
                }
                sb2.append(strBufferToHex);
                this.leftCount -= strBufferToHex.length();
            } else {
                StringBuilder sb3 = new StringBuilder();
                this.stringBuilder = sb3;
                sb3.append(strBufferToHex);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex.substring(6, 8));
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                this.leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) - 1) * 2) - (strBufferToHex.length() - 6);
            }
            if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                return;
            }
            byte[] bArrHexToBuffer2 = HexString.hexToBuffer(sb.toString());
            this.stringBuilder = null;
            if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer2)) {
                if (!CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer2)) {
                    InitSocketRunnable initSocketRunnable = InitSocketRunnable.this;
                    initSocketRunnable.callOnFail(initSocketRunnable.mCurrentHardware, null);
                    return;
                }
                String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                final DeviceBean deviceBean = new DeviceBean();
                deviceBean.deviceHexId = returnSettingDeviceIdResult;
                deviceBean.macAddress = InitSocketRunnable.this.mCurrentHardware.address;
                deviceBean.name = InitSocketRunnable.this.mCurrentHardware.name;
                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        byte[] bArrCallNeedServerInit = InitSocketRunnable.this.callNeedServerInit(InitSocketRunnable.this.mCurrentHardware, deviceBean);
                        if (bArrCallNeedServerInit != null) {
                            InitSocketRunnable.this.checkTimeOut(TimeOut.WriteQrcode, KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                            AnonymousClass6.this.mCommands = CommandUtilsWrapper.getSettingQRcodeCommands(bArrCallNeedServerInit);
                            AnonymousClass6.this.mCommandIndex = 0;
                            InitSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(AnonymousClass6.this.mCommands[AnonymousClass6.this.mCommandIndex]));
                        }
                    }
                });
                return;
            }
            if (CommandUtilsWrapper.isSettingQRCodeResult(bArrHexToBuffer2)) {
                if (!CommandUtilsWrapper.getSettingRQCodeResultStatus(bArrHexToBuffer2)) {
                    InitSocketRunnable initSocketRunnable2 = InitSocketRunnable.this;
                    initSocketRunnable2.callOnFail(initSocketRunnable2.mCurrentHardware, null);
                    return;
                }
                String[] strArr = this.mCommands;
                if (strArr == null) {
                    return;
                }
                int i = this.mCommandIndex + 1;
                this.mCommandIndex = i;
                if (i < strArr.length) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            InitSocketRunnable.this.mSmoothBluetooth.send(HexString.hexToBuffer(AnonymousClass6.this.mCommands[AnonymousClass6.this.mCommandIndex]));
                        }
                    }, 300L);
                } else if (i == strArr.length) {
                    InitSocketRunnable initSocketRunnable3 = InitSocketRunnable.this;
                    initSocketRunnable3.callOnSuccess(initSocketRunnable3.mCurrentHardware);
                }
            }
        }
    };

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setInitListener(InitListener initListener) {
        this.mInitListener = initListener;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public InitSocketRunnable(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart(this.mCurrentHardware);
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBond(this.mContext, this.mCurrentHardware.address)) {
            closeGatt();
            this.mCurrentHardware.isTimeout = false;
            checkTimeOut(TimeOut.Connect, 5000);
            SmoothBluetooth smoothBluetooth = new SmoothBluetooth(this.mContext, this.mSmoothBluetoothListener);
            this.mSmoothBluetooth = smoothBluetooth;
            smoothBluetooth.connect(new Device(this.mCurrentHardware.name, this.mCurrentHardware.address, true));
            return;
        }
        callOnBluetoothException(new ClientException("蓝牙不可用或不支持BLE"));
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        this.mCurrentHardware.isTimeout = false;
        closeGatt();
    }

    private void closeGatt() {
        SmoothBluetooth smoothBluetooth = this.mSmoothBluetooth;
        if (smoothBluetooth != null) {
            try {
                smoothBluetooth.cancelDiscovery();
            } catch (Exception unused) {
            }
            try {
                this.mSmoothBluetooth.disconnect();
            } catch (Exception unused2) {
            }
            try {
                this.mSmoothBluetooth.stop();
            } catch (Exception unused3) {
            }
            this.mSmoothBluetooth = null;
        }
    }

    private void appendLog(final String str) {
        if (this.mLogTextView == null) {
            return;
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (InitSocketRunnable.this.mLogTextView == null) {
                    return;
                }
                InitSocketRunnable.this.mLogTextView.append(str);
                InitSocketRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!InitSocketRunnable.this.isRunning || InitSocketRunnable.this.mInitListener == null) {
                    return;
                }
                InitSocketRunnable.this.mInitListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitSocketRunnable.this.isRunning && InitSocketRunnable.this.mInitListener != null) {
                        InitSocketRunnable.this.mInitListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    InitSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitSocketRunnable.this.isRunning && InitSocketRunnable.this.mInitListener != null) {
                        InitSocketRunnable.this.mInitListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    InitSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.socket.InitSocketRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitSocketRunnable.this.isRunning && InitSocketRunnable.this.mInitListener != null) {
                        InitSocketRunnable.this.mInitListener.onBluetoothException(clientException);
                    }
                } finally {
                    InitSocketRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] callNeedServerInit(BluetoothDevice bluetoothDevice, DeviceBean deviceBean) {
        InitListener initListener;
        try {
            if (this.isRunning && (initListener = this.mInitListener) != null) {
                return initListener.needServerInit(bluetoothDevice, deviceBean);
            }
        } catch (Exception unused) {
            callOnFail(this.mCurrentHardware, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (InitSocketRunnable.this.isRunning && this.timeOut == InitSocketRunnable.this.mCurrentCheckTimeOut) {
                InitSocketRunnable.this.mCurrentHardware.isTimeout = true;
                InitSocketRunnable initSocketRunnable = InitSocketRunnable.this;
                initSocketRunnable.callOnFail(initSocketRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}
