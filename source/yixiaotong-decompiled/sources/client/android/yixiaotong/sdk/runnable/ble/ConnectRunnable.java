package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.ConnectListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ConnectRunnable {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.7
        private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
        public StringBuilder stringBuilder;
        private byte[] mLastCharacteristicData = null;
        public int leftCount = 0;

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            if (i != 0) {
                ConnectRunnable.this.closeGatt();
                return;
            }
            if (i2 != 2) {
                if (i2 == 0) {
                    ConnectRunnable.this.closeGatt();
                    return;
                } else {
                    ConnectRunnable.this.closeGatt();
                    return;
                }
            }
            String address = bluetoothGatt.getDevice().getAddress();
            if (address == null || ConnectRunnable.this.mCurrentHardware == null || !address.equals(ConnectRunnable.this.mCurrentHardware.address) || ConnectRunnable.this.mCurrentHardware.isTimeout || !ConnectRunnable.this.isRunning) {
                return;
            }
            this.mBluetoothGattCharacteristic = null;
            ConnectRunnable.this.checkTimeOut(TimeOut.Discover, 6000);
            bluetoothGatt.discoverServices();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            String address;
            if (i == 0 && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(ConnectRunnable.this.mCurrentHardware.address) && !ConnectRunnable.this.mCurrentHardware.isTimeout && ConnectRunnable.this.isRunning) {
                List<BluetoothGattService> services = bluetoothGatt.getServices();
                if (services != null) {
                    Iterator<BluetoothGattService> it = services.iterator();
                    while (it.hasNext()) {
                        List<BluetoothGattCharacteristic> characteristics = it.next().getCharacteristics();
                        if (characteristics != null) {
                            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                if (bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                    this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                    break;
                                }
                            }
                        }
                    }
                }
                if (this.mBluetoothGattCharacteristic != null) {
                    ConnectRunnable.this.mBluetoothGatt.setCharacteristicNotification(this.mBluetoothGattCharacteristic, true);
                    BluetoothGattDescriptor descriptor = this.mBluetoothGattCharacteristic.getDescriptor(BluetoothDevice.DESCRIPTOR_UUID);
                    if (descriptor != null) {
                        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                        ConnectRunnable.this.mBluetoothGatt.writeDescriptor(descriptor);
                    }
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConnectRunnable.this.mCurrentHardware.isTimeout || !ConnectRunnable.this.isRunning) {
                                return;
                            }
                            ConnectRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
                            ConnectRunnable.this.writeGatt(AnonymousClass7.this.mBluetoothGattCharacteristic, CommandUtilsWrapper.getReturnSettingCommand());
                        }
                    }, 500L);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (address != null && address.equals(ConnectRunnable.this.mCurrentHardware.address) && !ConnectRunnable.this.mCurrentHardware.isTimeout && ConnectRunnable.this.isRunning) {
                readData(bluetoothGattCharacteristic.getValue());
            }
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
            byte[] bArr2 = this.mLastCharacteristicData;
            if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
                this.mLastCharacteristicData = bArr;
                String strBufferToHex = HexString.bufferToHex(bArr);
                Log.e("test", strBufferToHex);
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
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArrHexToBuffer, 0, bArr3, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                    this.leftCount = ((IntegerUtils.bytesToInt2(bArr3, 0) - 1) * 2) - (strBufferToHex.length() - 6);
                }
                if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                    return;
                }
                byte[] bArrHexToBuffer2 = HexString.hexToBuffer(sb.toString());
                this.stringBuilder = null;
                if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer2)) {
                    if (!CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer2)) {
                        ConnectRunnable connectRunnable = ConnectRunnable.this;
                        connectRunnable.callOnFail(connectRunnable.mCurrentHardware, null);
                        return;
                    }
                    String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                    if (TextUtils.isEmpty(returnSettingDeviceIdResult) || !returnSettingDeviceIdResult.startsWith("0212")) {
                        ConnectRunnable connectRunnable2 = ConnectRunnable.this;
                        connectRunnable2.callOnFail(connectRunnable2.mCurrentHardware, null);
                    } else {
                        ConnectRunnable connectRunnable3 = ConnectRunnable.this;
                        connectRunnable3.callOnSuccess(connectRunnable3.mCurrentHardware, returnSettingDeviceIdResult);
                    }
                }
            }
        }
    };
    private ConnectListener mConnectListener;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setConnectListener(ConnectListener connectListener) {
        this.mConnectListener = connectListener;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public ConnectRunnable(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart(this.mCurrentHardware);
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBluetoothLeSupported(this.mContext)) {
            closeGatt();
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectRunnable.this.mCurrentHardware.isTimeout = false;
                    android.bluetooth.BluetoothDevice remoteDevice = ConnectRunnable.this.mBluetoothAdapter.getRemoteDevice(ConnectRunnable.this.mCurrentHardware.address);
                    ConnectRunnable.this.checkTimeOut(TimeOut.Connect, 5000);
                    ConnectRunnable connectRunnable = ConnectRunnable.this;
                    connectRunnable.mBluetoothGatt = remoteDevice.connectGatt(connectRunnable.mContext, false, ConnectRunnable.this.mBluetoothGattCallback);
                }
            }, 1500L);
        } else {
            callOnBluetoothException(new ClientException("蓝牙不可用或不支持BLE"));
        }
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        this.mCurrentHardware.isTimeout = false;
        closeGatt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeGatt() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            try {
                bluetoothGatt.disconnect();
            } catch (Exception unused) {
            }
            try {
                this.mBluetoothGatt.close();
            } catch (Exception unused2) {
            }
            this.mBluetoothGatt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeGatt(BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) {
        if (this.mBluetoothGatt == null || bluetoothGattCharacteristic == null) {
            return;
        }
        bluetoothGattCharacteristic.setValue(HexString.hexToBuffer(str));
        bluetoothGattCharacteristic.setWriteType(2);
        this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    private void appendLog(final String str) {
        if (this.mLogTextView == null) {
            return;
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (ConnectRunnable.this.mLogTextView == null) {
                    return;
                }
                ConnectRunnable.this.mLogTextView.append(str);
                ConnectRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                if (!ConnectRunnable.this.isRunning || ConnectRunnable.this.mConnectListener == null) {
                    return;
                }
                ConnectRunnable.this.mConnectListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectRunnable.this.isRunning && ConnectRunnable.this.mConnectListener != null) {
                        ConnectRunnable.this.mConnectListener.onSuccess(bluetoothDevice, str);
                    }
                } finally {
                    ConnectRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectRunnable.this.isRunning && ConnectRunnable.this.mConnectListener != null) {
                        ConnectRunnable.this.mConnectListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    ConnectRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectRunnable.this.isRunning && ConnectRunnable.this.mConnectListener != null) {
                        ConnectRunnable.this.mConnectListener.onBluetoothException(clientException);
                    }
                } finally {
                    ConnectRunnable.this.stopAndRelease();
                }
            }
        });
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
            if (ConnectRunnable.this.isRunning && this.timeOut == ConnectRunnable.this.mCurrentCheckTimeOut) {
                ConnectRunnable.this.mCurrentHardware.isTimeout = true;
                ConnectRunnable connectRunnable = ConnectRunnable.this;
                connectRunnable.callOnFail(connectRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}
