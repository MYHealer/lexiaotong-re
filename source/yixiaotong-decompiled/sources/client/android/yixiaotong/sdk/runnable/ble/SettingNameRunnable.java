package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.widget.TextView;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.SettingNameListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import com.alipay.sdk.widget.j;
import com.huawei.openalliance.ad.constant.x;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SettingNameRunnable {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.7
        private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
        public StringBuilder stringBuilder;
        private byte[] mLastCharacteristicData = null;
        public int leftCount = 0;

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            if (i != 0 || i2 != 2) {
                SettingNameRunnable settingNameRunnable = SettingNameRunnable.this;
                settingNameRunnable.callOnFail(settingNameRunnable.mCurrentHardware, TimeOut.Connect);
                return;
            }
            String address = bluetoothGatt.getDevice().getAddress();
            if (address == null || SettingNameRunnable.this.mCurrentHardware == null || !address.equals(SettingNameRunnable.this.mCurrentHardware.address) || SettingNameRunnable.this.mCurrentHardware.isTimeout || !SettingNameRunnable.this.isRunning) {
                return;
            }
            this.mBluetoothGattCharacteristic = null;
            SettingNameRunnable.this.checkTimeOut(TimeOut.Discover, 5000);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bluetoothGatt.discoverServices();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            String address;
            List<BluetoothGattDescriptor> descriptors;
            if (i == 0 && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(SettingNameRunnable.this.mCurrentHardware.address) && !SettingNameRunnable.this.mCurrentHardware.isTimeout && SettingNameRunnable.this.isRunning) {
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
                                        SettingNameRunnable.this.mBluetoothGatt.setCharacteristicNotification(this.mBluetoothGattCharacteristic, true);
                                        for (UUID uuid : SettingNameRunnable.this.mCurrentHardware.getBluetoothDeviceAdapter()) {
                                            BluetoothGattDescriptor descriptor = this.mBluetoothGattCharacteristic.getDescriptor(uuid);
                                            if (descriptor != null) {
                                                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                SettingNameRunnable.this.mBluetoothGatt.writeDescriptor(descriptor);
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
                                        if (SettingNameRunnable.this.mBluetoothGatt != null) {
                                            SettingNameRunnable.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                                        }
                                        if (SettingNameRunnable.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true) && (descriptors = bluetoothGattCharacteristic2.getDescriptors()) != null && descriptors.size() > 0) {
                                            for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                SettingNameRunnable.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.mBluetoothGattCharacteristic != null) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (SettingNameRunnable.this.mCurrentHardware.isTimeout || !SettingNameRunnable.this.isRunning) {
                                return;
                            }
                            SettingNameRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 2500);
                            SettingNameRunnable.this.writeGatt(AnonymousClass7.this.mBluetoothGattCharacteristic, CommandUtilsWrapper.getReturnSettingCommand());
                        }
                    }, 100L);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (address != null && address.equals(SettingNameRunnable.this.mCurrentHardware.address) && !SettingNameRunnable.this.mCurrentHardware.isTimeout && SettingNameRunnable.this.isRunning) {
                readData(bluetoothGattCharacteristic.getValue());
            }
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
            byte[] bArr2 = this.mLastCharacteristicData;
            if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
                this.mLastCharacteristicData = bArr;
                String strBufferToHex = HexString.bufferToHex(bArr);
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
                        SettingNameRunnable settingNameRunnable = SettingNameRunnable.this;
                        settingNameRunnable.callOnFail(settingNameRunnable.mCurrentHardware, null);
                        return;
                    }
                    CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer3);
                    SettingNameRunnable.this.checkTimeOut(TimeOut.WriteSetting, 2500);
                    if (StringUtils.isNotEmpty(SettingNameRunnable.this.mName) && SettingNameRunnable.this.mName.contains(x.A)) {
                        SettingNameRunnable.this.writeGatt(this.mBluetoothGattCharacteristic, CommandUtilsWrapper.setAddressCommand(SettingNameRunnable.this.mName));
                        return;
                    }
                    return;
                }
                if (CommandUtilsWrapper.isReturnSetDeviceName(bArrHexToBuffer3)) {
                    if (CommandUtilsWrapper.getSettingnameResultStatus(bArrHexToBuffer3)) {
                        SettingNameRunnable settingNameRunnable2 = SettingNameRunnable.this;
                        settingNameRunnable2.callOnSuccess(settingNameRunnable2.mCurrentHardware);
                    } else {
                        SettingNameRunnable settingNameRunnable3 = SettingNameRunnable.this;
                        settingNameRunnable3.callOnFail(settingNameRunnable3.mCurrentHardware, null);
                    }
                }
            }
        }
    };
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private TextView mLogTextView;
    private String mName;
    private SettingNameListener mSettingNameListener;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setLogTextView(TextView textView) {
        this.mLogTextView = textView;
    }

    public void setSettingNameListener(SettingNameListener settingNameListener) {
        this.mSettingNameListener = settingNameListener;
    }

    public SettingNameRunnable(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice, String str) {
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
        this.mName = str;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart(this.mCurrentHardware);
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBluetoothLeSupported(this.mContext)) {
            this.mCurrentHardware.isTimeout = false;
            android.bluetooth.BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(this.mCurrentHardware.address);
            checkTimeOut(TimeOut.Connect, 5000);
            this.mBluetoothGatt = remoteDevice.connectGatt(this.mContext, false, this.mBluetoothGattCallback);
            return;
        }
        callOnBluetoothException(new ClientException("请打开蓝牙"));
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
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                BluetoothGattCharacteristic bluetoothGattCharacteristic2;
                if (SettingNameRunnable.this.mBluetoothGatt == null || (bluetoothGattCharacteristic2 = bluetoothGattCharacteristic) == null) {
                    return;
                }
                bluetoothGattCharacteristic2.setValue(HexString.hexToBuffer(str));
                bluetoothGattCharacteristic.setWriteType(2);
                SettingNameRunnable.this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
        }, 100L);
    }

    private void appendLog(final String str) {
        if (this.mLogTextView == null) {
            return;
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (SettingNameRunnable.this.mLogTextView == null) {
                    return;
                }
                SettingNameRunnable.this.mLogTextView.append(str);
                SettingNameRunnable.this.mLogTextView.append("\n\n");
            }
        });
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                if (!SettingNameRunnable.this.isRunning || SettingNameRunnable.this.mSettingNameListener == null) {
                    return;
                }
                SettingNameRunnable.this.mSettingNameListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingNameRunnable.this.isRunning && SettingNameRunnable.this.mSettingNameListener != null) {
                        SettingNameRunnable.this.mSettingNameListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    SettingNameRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingNameRunnable.this.isRunning && SettingNameRunnable.this.mSettingNameListener != null) {
                        SettingNameRunnable.this.mSettingNameListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    SettingNameRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (SettingNameRunnable.this.isRunning && SettingNameRunnable.this.mSettingNameListener != null) {
                        SettingNameRunnable.this.mSettingNameListener.onBluetoothException(clientException);
                    }
                } finally {
                    SettingNameRunnable.this.stopAndRelease();
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
            if (SettingNameRunnable.this.isRunning && this.timeOut == SettingNameRunnable.this.mCurrentCheckTimeOut) {
                SettingNameRunnable.this.mCurrentHardware.isTimeout = true;
                SettingNameRunnable settingNameRunnable = SettingNameRunnable.this;
                settingNameRunnable.callOnFail(settingNameRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}
