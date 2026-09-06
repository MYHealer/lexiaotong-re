package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.command.VersionCommandV2;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.InitListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import com.alipay.sdk.widget.j;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class InitRunnableV2 {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.7
        public int leftCount = 0;
        private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
        public StringBuilder stringBuilder;

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            if (i != 0 || i2 != 2) {
                InitRunnableV2 initRunnableV2 = InitRunnableV2.this;
                initRunnableV2.callOnFail(initRunnableV2.mCurrentHardware, TimeOut.Connect);
                return;
            }
            String address = bluetoothGatt.getDevice().getAddress();
            if (address == null || InitRunnableV2.this.mCurrentHardware == null || !address.equals(InitRunnableV2.this.mCurrentHardware.address) || InitRunnableV2.this.mCurrentHardware.isTimeout || !InitRunnableV2.this.isRunning) {
                return;
            }
            this.mBluetoothGattCharacteristic = null;
            InitRunnableV2.this.checkTimeOut(TimeOut.Discover, 5000);
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
            if (i == 0 && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(InitRunnableV2.this.mCurrentHardware.address) && !InitRunnableV2.this.mCurrentHardware.isTimeout && InitRunnableV2.this.isRunning) {
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
                                        InitRunnableV2.this.mBluetoothGatt.setCharacteristicNotification(this.mBluetoothGattCharacteristic, true);
                                        for (UUID uuid : InitRunnableV2.this.mCurrentHardware.getBluetoothDeviceAdapter()) {
                                            BluetoothGattDescriptor descriptor = this.mBluetoothGattCharacteristic.getDescriptor(uuid);
                                            if (descriptor != null) {
                                                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                InitRunnableV2.this.mBluetoothGatt.writeDescriptor(descriptor);
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
                                        if (InitRunnableV2.this.mBluetoothGatt != null) {
                                            InitRunnableV2.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                                        }
                                        if (InitRunnableV2.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true) && (descriptors = bluetoothGattCharacteristic2.getDescriptors()) != null && descriptors.size() > 0) {
                                            for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                InitRunnableV2.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.mBluetoothGattCharacteristic != null) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InitRunnableV2.this.mCurrentHardware.isTimeout || !InitRunnableV2.this.isRunning) {
                                return;
                            }
                            InitRunnableV2.this.checkTimeOut(TimeOut.SendNewCommand, 5000);
                            InitRunnableV2.this.writeGatt(AnonymousClass7.this.mBluetoothGattCharacteristic, VersionCommandV2.selectInfoCommand());
                        }
                    }, 200L);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (address != null && address.equals(InitRunnableV2.this.mCurrentHardware.address) && !InitRunnableV2.this.mCurrentHardware.isTimeout && InitRunnableV2.this.isRunning) {
                readData(bluetoothGattCharacteristic.getValue());
            }
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
            String strBufferToHex = HexString.bufferToHex(bArr);
            Log.e("test", "初始化收到数据:" + strBufferToHex);
            if (strBufferToHex.startsWith("A5") && strBufferToHex.length() >= 4) {
                StringBuilder sb2 = new StringBuilder();
                this.stringBuilder = sb2;
                sb2.append(strBufferToHex);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex.substring(2, 4));
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                this.leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) + 1) * 2) - (strBufferToHex.length() - 4);
            } else {
                StringBuilder sb3 = this.stringBuilder;
                if (sb3 != null && sb3.toString().length() >= 4) {
                    this.stringBuilder.append(strBufferToHex);
                    this.leftCount -= strBufferToHex.length();
                } else {
                    StringBuilder sb4 = this.stringBuilder;
                    if (sb4 != null && sb4.toString().length() < 4) {
                        this.stringBuilder.append(strBufferToHex);
                        if (this.stringBuilder.toString().length() >= 4) {
                            byte[] bArrHexToBuffer2 = HexString.hexToBuffer(this.stringBuilder.toString().substring(2, 4));
                            byte[] bArr3 = new byte[4];
                            System.arraycopy(bArrHexToBuffer2, 0, bArr3, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                            this.leftCount = ((IntegerUtils.bytesToInt2(bArr3, 0) + 1) * 2) - (this.stringBuilder.toString().length() - 4);
                        }
                    } else {
                        if (!strBufferToHex.startsWith("A5") || strBufferToHex.length() >= 4) {
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
            if (!VersionCommandV2.isReceivedDataFormat(VersionCommandV2.receivedDataManage(sb.toString()))) {
                InitRunnableV2 initRunnableV2 = InitRunnableV2.this;
                initRunnableV2.callOnFail(initRunnableV2.mCurrentHardware, null);
            } else if (!VersionCommandV2.receivedControlState().equals("F1")) {
                InitRunnableV2 initRunnableV3 = InitRunnableV2.this;
                initRunnableV3.callOnSuccess(initRunnableV3.mCurrentHardware);
            } else {
                RandomUtil.getRandNumMaxString(2);
                RandomUtil.getRandNumMaxString(2);
            }
            this.stringBuilder = null;
        }
    };
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private String mData;
    private InitListener mInitListener;

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setInitListener(InitListener initListener) {
        this.mInitListener = initListener;
    }

    public InitRunnableV2(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice, String str) {
        this.mData = "";
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
        this.mData = str;
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
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.1
                @Override // java.lang.Runnable
                public void run() {
                    InitRunnableV2.this.mCurrentHardware.isTimeout = false;
                    android.bluetooth.BluetoothDevice remoteDevice = InitRunnableV2.this.mBluetoothAdapter.getRemoteDevice(InitRunnableV2.this.mCurrentHardware.address);
                    InitRunnableV2.this.checkTimeOut(TimeOut.Connect, 5000);
                    InitRunnableV2 initRunnableV2 = InitRunnableV2.this;
                    initRunnableV2.mBluetoothGatt = remoteDevice.connectGatt(initRunnableV2.mContext, false, InitRunnableV2.this.mBluetoothGattCallback);
                }
            }, 1200L);
        } else {
            callOnBluetoothException(new ClientException("请打开蓝牙！"));
        }
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
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.2
            @Override // java.lang.Runnable
            public void run() {
                BluetoothGattCharacteristic bluetoothGattCharacteristic2;
                if (InitRunnableV2.this.mBluetoothGatt == null || (bluetoothGattCharacteristic2 = bluetoothGattCharacteristic) == null) {
                    return;
                }
                bluetoothGattCharacteristic2.setValue(HexString.hexToBuffer(str));
                bluetoothGattCharacteristic.setWriteType(2);
                InitRunnableV2.this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
        }, 100L);
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.3
            @Override // java.lang.Runnable
            public void run() {
                if (!InitRunnableV2.this.isRunning || InitRunnableV2.this.mInitListener == null) {
                    return;
                }
                InitRunnableV2.this.mInitListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitRunnableV2.this.isRunning && InitRunnableV2.this.mInitListener != null) {
                        InitRunnableV2.this.mInitListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    InitRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitRunnableV2.this.isRunning && InitRunnableV2.this.mInitListener != null) {
                        InitRunnableV2.this.mInitListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    InitRunnableV2.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitRunnableV2.this.isRunning && InitRunnableV2.this.mInitListener != null) {
                        InitRunnableV2.this.mInitListener.onBluetoothException(clientException);
                    }
                } finally {
                    InitRunnableV2.this.stopAndRelease();
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
            Log.e("test", "初始化：" + InitRunnableV2.this.isRunning + "  " + this.timeOut + "  " + InitRunnableV2.this.mCurrentCheckTimeOut);
            if (InitRunnableV2.this.isRunning && this.timeOut == InitRunnableV2.this.mCurrentCheckTimeOut) {
                InitRunnableV2.this.mCurrentHardware.isTimeout = true;
                InitRunnableV2 initRunnableV2 = InitRunnableV2.this;
                initRunnableV2.callOnFail(initRunnableV2.mCurrentHardware, this.timeOut);
            }
        }
    }
}
