package android.client.bluetoothsdk.bluetooth;

import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.socket.Device;
import android.client.bluetoothsdk.socket.SmoothBluetooth;
import android.client.bluetoothsdk.util.BluetoothUtils;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.HexString;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.Context;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SocketBluetoothConnect {
    private boolean connectState;
    private boolean isRunning;
    private boolean isSendData;
    private BluetoothConnectListener mConnectListener;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetooth.Listener mSmoothBluetoothListener;
    private String sendData;

    public static class SingletonHolder {
        public static final SocketBluetoothConnect INSTANCE = new SocketBluetoothConnect();
    }

    public void connect(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void setConnectListener(BluetoothConnectListener bluetoothConnectListener) {
        this.mConnectListener = bluetoothConnectListener;
    }

    private SocketBluetoothConnect() {
        this.connectState = false;
        this.isSendData = false;
        this.sendData = "";
        this.mSmoothBluetoothListener = new SmoothBluetooth.Listener() { // from class: android.client.bluetoothsdk.bluetooth.SocketBluetoothConnect.6
            private byte[] mLastCharacteristicData = null;

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onBluetoothNotEnabled() {
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onBluetoothNotSupported() {
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onConnecting(Device device) {
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onConnectionFailed(Device device) {
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onDisconnected() {
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onDiscoveryFinished() {
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onDiscoveryStarted() {
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onConnected(Device device) {
                String address = device.getAddress();
                if (address == null || SocketBluetoothConnect.this.mCurrentHardware == null || !address.equals(SocketBluetoothConnect.this.mCurrentHardware.address) || SocketBluetoothConnect.this.mCurrentHardware.isTimeout || !SocketBluetoothConnect.this.isRunning) {
                    return;
                }
                SocketBluetoothConnect.this.connectState = true;
                SocketBluetoothConnect.this.mCurrentCheckTimeOut = null;
                SocketBluetoothConnect socketBluetoothConnect = SocketBluetoothConnect.this;
                socketBluetoothConnect.callOnSuccessConnect(socketBluetoothConnect.mCurrentHardware);
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onDeviceFound(Device device) {
                if (!(device == null && device.getAddress().isEmpty()) && SocketBluetoothConnect.this.mCurrentHardware.address.equals(device.getAddress())) {
                    SocketBluetoothConnect.this.closeGatt();
                    SocketBluetoothConnect.this.start();
                }
            }

            @Override // android.client.bluetoothsdk.socket.SmoothBluetooth.Listener
            public void onDataReceived(byte[] bArr) {
                if (SocketBluetoothConnect.this.mCurrentHardware.isTimeout || !SocketBluetoothConnect.this.isRunning) {
                    return;
                }
                readData(bArr);
            }

            private void readData(byte[] bArr) {
                String strBufferToHex = HexString.bufferToHex(bArr);
                SocketBluetoothConnect socketBluetoothConnect = SocketBluetoothConnect.this;
                socketBluetoothConnect.callOnSuccessSendData(socketBluetoothConnect.mCurrentHardware, strBufferToHex);
            }
        };
    }

    public static SocketBluetoothConnect getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart(this.mCurrentHardware);
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBond(this.mContext, this.mCurrentHardware.address)) {
            this.mCurrentHardware.isTimeout = false;
            checkTimeOut(TimeOut.Connect, 6000);
            if (this.mSmoothBluetooth == null) {
                this.mSmoothBluetooth = new SmoothBluetooth(this.mContext, this.mSmoothBluetoothListener);
            }
            this.mSmoothBluetooth.connect(new Device(this.mCurrentHardware.name, this.mCurrentHardware.address, true));
            return;
        }
        callOnBluetoothException(new ClientException("蓝牙不可用或没有绑定设备,请在手机本地先配对蓝牙"));
    }

    public void sendData(String str) {
        this.isSendData = true;
        this.sendData = str;
        if (this.connectState && this.isRunning) {
            this.isSendData = false;
            this.mSmoothBluetooth.send(HexString.hexToBuffer(str));
        } else {
            if (this.isRunning) {
                return;
            }
            this.isRunning = false;
            startScan();
        }
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        BluetoothDevice bluetoothDevice = this.mCurrentHardware;
        if (bluetoothDevice != null) {
            bluetoothDevice.isTimeout = false;
        }
        this.connectState = false;
        this.isSendData = false;
        closeGatt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeGatt() {
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

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.SocketBluetoothConnect.1
            @Override // java.lang.Runnable
            public void run() {
                if (!SocketBluetoothConnect.this.isRunning || SocketBluetoothConnect.this.mConnectListener == null) {
                    return;
                }
                SocketBluetoothConnect.this.mConnectListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccessSendData(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.SocketBluetoothConnect.2
            @Override // java.lang.Runnable
            public void run() {
                if (!SocketBluetoothConnect.this.isRunning || SocketBluetoothConnect.this.mConnectListener == null) {
                    return;
                }
                SocketBluetoothConnect.this.mConnectListener.onSuccessSendData(bluetoothDevice, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccessConnect(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.SocketBluetoothConnect.3
            @Override // java.lang.Runnable
            public void run() {
                if (!SocketBluetoothConnect.this.isRunning || SocketBluetoothConnect.this.mConnectListener == null) {
                    return;
                }
                SocketBluetoothConnect.this.mConnectListener.onSuccessConnect(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.SocketBluetoothConnect.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SocketBluetoothConnect.this.isRunning && SocketBluetoothConnect.this.mConnectListener != null) {
                        SocketBluetoothConnect.this.mConnectListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    SocketBluetoothConnect.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.SocketBluetoothConnect.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SocketBluetoothConnect.this.isRunning && SocketBluetoothConnect.this.mConnectListener != null) {
                        SocketBluetoothConnect.this.mConnectListener.onBluetoothException(clientException);
                    }
                } finally {
                    SocketBluetoothConnect.this.stopAndRelease();
                }
            }
        });
    }

    private void checkTimeOut(TimeOut timeOut, int i) {
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
            if (this.timeOut == TimeOut.Scan) {
                SocketBluetoothConnect.this.closeGatt();
                SocketBluetoothConnect.this.start();
            }
            if (SocketBluetoothConnect.this.isRunning && this.timeOut == SocketBluetoothConnect.this.mCurrentCheckTimeOut && this.timeOut != TimeOut.Scan) {
                SocketBluetoothConnect.this.mCurrentHardware.isTimeout = true;
                SocketBluetoothConnect socketBluetoothConnect = SocketBluetoothConnect.this;
                socketBluetoothConnect.callOnFail(socketBluetoothConnect.mCurrentHardware, this.timeOut, null);
            }
        }
    }

    public void startScan() {
        if (BluetoothUtils.isBluetoothOn(this.mContext)) {
            closeGatt();
            checkTimeOut(TimeOut.Scan, 3000);
            SmoothBluetooth smoothBluetooth = new SmoothBluetooth(this.mContext, this.mSmoothBluetoothListener);
            this.mSmoothBluetooth = smoothBluetooth;
            smoothBluetooth.doDiscovery();
            return;
        }
        callOnBluetoothException(new ClientException("蓝牙不可用或不支持BLE"));
    }
}
