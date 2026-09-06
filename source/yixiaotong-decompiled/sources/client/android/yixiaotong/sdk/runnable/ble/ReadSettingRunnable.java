package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import com.alipay.sdk.widget.j;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ReadSettingRunnable {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.6
        private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
        public StringBuilder stringBuilder;
        private byte[] mLastCharacteristicData = null;
        public int leftCount = 0;

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(final BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            if (i != 0 || i2 != 2) {
                ReadSettingRunnable readSettingRunnable = ReadSettingRunnable.this;
                readSettingRunnable.callOnFail(readSettingRunnable.mCurrentHardware, TimeOut.Connect);
                return;
            }
            String address = bluetoothGatt.getDevice().getAddress();
            if (address == null || ReadSettingRunnable.this.mCurrentHardware == null || !address.equals(ReadSettingRunnable.this.mCurrentHardware.address) || ReadSettingRunnable.this.mCurrentHardware.isTimeout || !ReadSettingRunnable.this.isRunning) {
                return;
            }
            this.mBluetoothGattCharacteristic = null;
            ReadSettingRunnable.this.checkTimeOut(TimeOut.Discover, 5000);
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.6.1
                @Override // java.lang.Runnable
                public void run() {
                    bluetoothGatt.discoverServices();
                }
            }, 500L);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            String address;
            List<BluetoothGattDescriptor> descriptors;
            if (i == 0 && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(ReadSettingRunnable.this.mCurrentHardware.address) && !ReadSettingRunnable.this.mCurrentHardware.isTimeout && ReadSettingRunnable.this.isRunning) {
                List<BluetoothGattService> services = bluetoothGatt.getServices();
                if (services != null) {
                    Iterator<BluetoothGattService> it = services.iterator();
                    while (it.hasNext()) {
                        List<BluetoothGattCharacteristic> characteristics = it.next().getCharacteristics();
                        if (characteristics != null) {
                            if (characteristics.size() == 1) {
                                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                    if (bluetoothGattCharacteristic != null && bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                        this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                        ReadSettingRunnable.this.mBluetoothGatt.setCharacteristicNotification(this.mBluetoothGattCharacteristic, true);
                                        for (UUID uuid : ReadSettingRunnable.this.mCurrentHardware.getBluetoothDeviceAdapter()) {
                                            BluetoothGattDescriptor descriptor = this.mBluetoothGattCharacteristic.getDescriptor(uuid);
                                            if (descriptor != null) {
                                                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                ReadSettingRunnable.this.mBluetoothGatt.writeDescriptor(descriptor);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                            } else if (characteristics.size() >= 2) {
                                for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics) {
                                    if (bluetoothGattCharacteristic2 != null && bluetoothGattCharacteristic2.getUuid().toString().toLowerCase().indexOf("0000ffe2") == 0) {
                                        this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic2;
                                    } else if (bluetoothGattCharacteristic2 != null && bluetoothGattCharacteristic2.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                        if (ReadSettingRunnable.this.mBluetoothGatt != null) {
                                            ReadSettingRunnable.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                                        }
                                        if (ReadSettingRunnable.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true) && (descriptors = bluetoothGattCharacteristic2.getDescriptors()) != null && descriptors.size() > 0) {
                                            for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                ReadSettingRunnable.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.mBluetoothGattCharacteristic != null) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ReadSettingRunnable.this.mCurrentHardware.isTimeout || !ReadSettingRunnable.this.isRunning) {
                                return;
                            }
                            ReadSettingRunnable.this.checkTimeOut(TimeOut.ReadSetting, 2500);
                            ReadSettingRunnable.this.writeGatt(AnonymousClass6.this.mBluetoothGattCharacteristic, CommandUtilsWrapper.getReturnSettingCommand());
                        }
                    }, 200L);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (address != null && address.equals(ReadSettingRunnable.this.mCurrentHardware.address) && !ReadSettingRunnable.this.mCurrentHardware.isTimeout && ReadSettingRunnable.this.isRunning) {
                readData(bluetoothGattCharacteristic.getValue());
            }
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
            byte[] bArr2 = this.mLastCharacteristicData;
            if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
                this.mLastCharacteristicData = bArr;
                String strBufferToHex = HexString.bufferToHex(bArr);
                Log.e("test", "读取设置信息：" + strBufferToHex);
                if (strBufferToHex.startsWith("550001") && strBufferToHex.length() >= 8) {
                    StringBuilder sb2 = new StringBuilder();
                    this.stringBuilder = sb2;
                    sb2.append(strBufferToHex);
                    byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex.substring(6, 8));
                    byte[] bArr3 = new byte[4];
                    System.arraycopy(bArrHexToBuffer, 0, bArr3, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                    this.leftCount = ((IntegerUtils.bytesToInt2(bArr3, 0) + 1) * 2) - (strBufferToHex.length() - 6);
                } else {
                    StringBuilder sb3 = this.stringBuilder;
                    if (sb3 != null && sb3.toString().length() >= 8) {
                        this.stringBuilder.append(strBufferToHex);
                        this.leftCount -= strBufferToHex.length();
                    } else {
                        StringBuilder sb4 = this.stringBuilder;
                        if (sb4 != null && sb4.toString().length() < 8) {
                            this.stringBuilder.append(strBufferToHex);
                            if (this.stringBuilder.toString().length() >= 8) {
                                byte[] bArrHexToBuffer2 = HexString.hexToBuffer(this.stringBuilder.toString().substring(6, 8));
                                byte[] bArr4 = new byte[4];
                                System.arraycopy(bArrHexToBuffer2, 0, bArr4, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                                this.leftCount = ((IntegerUtils.bytesToInt2(bArr4, 0) + 1) * 2) - (this.stringBuilder.toString().length() - 6);
                            }
                        } else {
                            if (!strBufferToHex.startsWith("55") || strBufferToHex.length() >= 8) {
                                return;
                            }
                            StringBuilder sb5 = new StringBuilder();
                            this.stringBuilder = sb5;
                            sb5.append(strBufferToHex);
                            this.leftCount = 1;
                        }
                    }
                }
                if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                    return;
                }
                byte[] bArrHexToBuffer3 = HexString.hexToBuffer(sb.toString());
                this.stringBuilder = null;
                if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer3)) {
                    if (!CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer3)) {
                        ReadSettingRunnable readSettingRunnable = ReadSettingRunnable.this;
                        readSettingRunnable.callOnFail(readSettingRunnable.mCurrentHardware, null);
                    } else {
                        CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer3);
                        ReadSettingRunnable readSettingRunnable2 = ReadSettingRunnable.this;
                        readSettingRunnable2.callOnSuccess(readSettingRunnable2.mCurrentHardware, CommandUtilsWrapper.getReturnSettingResult(bArrHexToBuffer3));
                    }
                }
            }
        }
    };
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;
    private ReadSettingListener mReadSettingListener;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public void setReadSettingListener(ReadSettingListener readSettingListener) {
        this.mReadSettingListener = readSettingListener;
    }

    public ReadSettingRunnable(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
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
            this.mCurrentHardware.isTimeout = false;
            android.bluetooth.BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(this.mCurrentHardware.address);
            checkTimeOut(TimeOut.Connect, 5000);
            this.mBluetoothGatt = remoteDevice.connectGatt(this.mContext, false, this.mBluetoothGattCallback);
            return;
        }
        callOnBluetoothException(new ClientException("请打开蓝牙！"));
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        this.mCurrentHardware.isTimeout = false;
        closeGatt();
    }

    private void closeGatt() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
        refreshDeviceCache();
        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.close();
        }
        this.mBluetoothGatt = null;
    }

    private void refreshDeviceCache() {
        BluetoothGatt bluetoothGatt;
        try {
            Method method = BluetoothGatt.class.getMethod(j.l, new Class[0]);
            if (method == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
                return;
            }
            ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeGatt(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final String str) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                BluetoothGattCharacteristic bluetoothGattCharacteristic2;
                if (ReadSettingRunnable.this.mBluetoothGatt == null || (bluetoothGattCharacteristic2 = bluetoothGattCharacteristic) == null) {
                    return;
                }
                bluetoothGattCharacteristic2.setValue(HexString.hexToBuffer(str));
                bluetoothGattCharacteristic.setWriteType(2);
                ReadSettingRunnable.this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
        }, 100L);
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (!ReadSettingRunnable.this.isRunning || ReadSettingRunnable.this.mReadSettingListener == null) {
                    return;
                }
                ReadSettingRunnable.this.mReadSettingListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ReadSettingRunnable.this.isRunning && ReadSettingRunnable.this.mReadSettingListener != null) {
                        ReadSettingRunnable.this.mReadSettingListener.onSuccess(bluetoothDevice, str);
                    }
                } finally {
                    ReadSettingRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ReadSettingRunnable.this.isRunning && ReadSettingRunnable.this.mReadSettingListener != null) {
                        ReadSettingRunnable.this.mReadSettingListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    ReadSettingRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ReadSettingRunnable.this.isRunning && ReadSettingRunnable.this.mReadSettingListener != null) {
                        ReadSettingRunnable.this.mReadSettingListener.onBluetoothException(clientException);
                    }
                } finally {
                    ReadSettingRunnable.this.stopAndRelease();
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
            if (ReadSettingRunnable.this.isRunning && this.timeOut == ReadSettingRunnable.this.mCurrentCheckTimeOut) {
                ReadSettingRunnable.this.mCurrentHardware.isTimeout = true;
                ReadSettingRunnable readSettingRunnable = ReadSettingRunnable.this;
                readSettingRunnable.callOnFail(readSettingRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}
