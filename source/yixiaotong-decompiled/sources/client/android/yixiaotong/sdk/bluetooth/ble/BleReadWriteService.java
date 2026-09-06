package client.android.yixiaotong.sdk.bluetooth.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import com.alipay.sdk.widget.j;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BleReadWriteService {
    private static final int CONNECT_SUCCESS = 1;
    private iIOViewMessage ioMessage;
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback;
    private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private long mCurrentTime;
    private Handler mHandler;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private int mTimeOutTime;

    public static class SingletonHolder {
        public static final BleReadWriteService INSTANCE = new BleReadWriteService();
    }

    public void setIoViewMessage(iIOViewMessage iioviewmessage) {
        this.ioMessage = iioviewmessage;
    }

    public void setTimeOut() {
        this.mCurrentCheckTimeOut = null;
    }

    private BleReadWriteService() {
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    BleReadWriteService.this.checkTimeOut(TimeOut.Discover, 5000);
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BleReadWriteService.this.mBluetoothGatt != null) {
                                BleReadWriteService.this.mBluetoothGatt.discoverServices();
                            }
                        }
                    }, 600L);
                }
            }
        };
        this.mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.5
            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onConnectionStateChange(bluetoothGatt, i, i2);
                Log.e("test", "onConnectionStateChange:" + i + "   " + i2);
                if (i != 0) {
                    if (BleReadWriteService.this.isRunning) {
                        BleReadWriteService.this.ioMessage.IOLayerCallOnBluetoothException(BleReadWriteService.this.mCurrentHardware, "蓝牙匹配失败，请重新连接" + i2);
                    }
                    BleReadWriteService.this.stopAndRelease();
                    BleReadWriteService.this.closeGatt2();
                    return;
                }
                if (i2 == 2) {
                    String address = bluetoothGatt.getDevice().getAddress();
                    if (address == null || BleReadWriteService.this.mCurrentHardware == null || !address.equals(BleReadWriteService.this.mCurrentHardware.address) || BleReadWriteService.this.mCurrentHardware.isTimeout || !BleReadWriteService.this.isRunning) {
                        return;
                    }
                    BleReadWriteService.this.mBluetoothGattCharacteristic = null;
                    BleReadWriteService.this.mBluetoothGatt = bluetoothGatt;
                    BleReadWriteService.this.mHandler.sendEmptyMessage(1);
                    return;
                }
                if (i2 == 0) {
                    if (BleReadWriteService.this.isRunning) {
                        BleReadWriteService.this.ioMessage.IOLayerCallOnBluetoothException(BleReadWriteService.this.mCurrentHardware, "蓝牙信号不稳定");
                    }
                    BleReadWriteService.this.stopAndRelease();
                    BleReadWriteService.this.closeGatt2();
                    return;
                }
                if (BleReadWriteService.this.isRunning) {
                    BleReadWriteService.this.ioMessage.IOLayerCallOnBluetoothException(BleReadWriteService.this.mCurrentHardware, "蓝牙匹配失败，请重新连接" + i2);
                }
                BleReadWriteService.this.stopAndRelease();
                BleReadWriteService.this.closeGatt2();
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                String address;
                List<BluetoothGattDescriptor> descriptors;
                Log.e("test", "onServicesDiscovered:" + i + "");
                if (i == 0 && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(BleReadWriteService.this.mCurrentHardware.address) && !BleReadWriteService.this.mCurrentHardware.isTimeout && BleReadWriteService.this.isRunning) {
                    List<BluetoothGattService> services = bluetoothGatt.getServices();
                    if (services != null) {
                        Iterator<BluetoothGattService> it = services.iterator();
                        while (it.hasNext()) {
                            List<BluetoothGattCharacteristic> characteristics = it.next().getCharacteristics();
                            if (characteristics != null) {
                                if (characteristics.size() == 1) {
                                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                        if (bluetoothGattCharacteristic != null && bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                            BleReadWriteService.this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                            BleReadWriteService.this.mBluetoothGatt.setCharacteristicNotification(BleReadWriteService.this.mBluetoothGattCharacteristic, true);
                                            for (UUID uuid : BleReadWriteService.this.mCurrentHardware.getBluetoothDeviceAdapter()) {
                                                BluetoothGattDescriptor descriptor = BleReadWriteService.this.mBluetoothGattCharacteristic.getDescriptor(uuid);
                                                if (descriptor != null) {
                                                    descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                    BleReadWriteService.this.mBluetoothGatt.writeDescriptor(descriptor);
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                } else if (characteristics.size() >= 2) {
                                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics) {
                                        if (bluetoothGattCharacteristic2 != null && bluetoothGattCharacteristic2.getUuid().toString().toLowerCase().indexOf("0000ffe2") == 0) {
                                            BleReadWriteService.this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic2;
                                        } else if (bluetoothGattCharacteristic2 != null && bluetoothGattCharacteristic2.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                            if (BleReadWriteService.this.mBluetoothGatt != null) {
                                                BleReadWriteService.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                                            }
                                            if (BleReadWriteService.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true) && (descriptors = bluetoothGattCharacteristic2.getDescriptors()) != null && descriptors.size() > 0) {
                                                for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                    bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                    BleReadWriteService.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (BleReadWriteService.this.mBluetoothGattCharacteristic != null) {
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Log.e("test", "蓝牙连接成功!");
                                BleReadWriteService.this.ioMessage.IOLayerCallOnConnectSuccess(BleReadWriteService.this.mCurrentHardware);
                            }
                        }, 500L);
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                String address = bluetoothGatt.getDevice().getAddress();
                if (address != null && address.equals(BleReadWriteService.this.mCurrentHardware.address) && !BleReadWriteService.this.mCurrentHardware.isTimeout && BleReadWriteService.this.isRunning) {
                    BleReadWriteService.this.ioMessage.IOLayerCallOnReceivedData(BleReadWriteService.this.mCurrentHardware, HexString.bufferToHex(bluetoothGattCharacteristic.getValue()));
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            }
        };
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.6
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(android.bluetooth.BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (BleReadWriteService.this.mCurrentHardware.address.equals(bluetoothDevice.getAddress())) {
                    BleReadWriteService.this.stopScan();
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BleReadWriteService.this.start();
                        }
                    }, 100L);
                }
            }
        };
    }

    public static BleReadWriteService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
        Log.e("test", "开始连接蓝牙!" + Thread.currentThread().getName());
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
        startScan();
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        iIOViewMessage iioviewmessage = this.ioMessage;
        if (iioviewmessage != null) {
            iioviewmessage.IOLayerCallOnStart(this.mCurrentHardware);
        }
        closeGatt2();
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBluetoothLeSupported(this.mContext)) {
            if (this.ioMessage != null) {
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        BleReadWriteService.this.mCurrentHardware.isTimeout = false;
                        android.bluetooth.BluetoothDevice remoteDevice = BleReadWriteService.this.mBluetoothAdapter.getRemoteDevice(BleReadWriteService.this.mCurrentHardware.address);
                        BleReadWriteService.this.checkTimeOut(TimeOut.Connect, 5000);
                        BleReadWriteService bleReadWriteService = BleReadWriteService.this;
                        bleReadWriteService.mBluetoothGatt = remoteDevice.connectGatt(bleReadWriteService.mContext, false, BleReadWriteService.this.mBluetoothGattCallback);
                    }
                });
            }
        } else if (this.ioMessage != null) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.3
                @Override // java.lang.Runnable
                public void run() {
                    BleReadWriteService.this.ioMessage.IOLayerCallOnBluetoothException(BleReadWriteService.this.mCurrentHardware, "请打开蓝牙！");
                }
            });
        }
    }

    public void closeGatt() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
        refreshDeviceCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeGatt2() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.mBluetoothGatt = null;
            System.gc();
        }
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

    public void sendData(TimeOut timeOut, int i, String str) {
        if (this.mCurrentHardware.isTimeout || !this.isRunning) {
            this.ioMessage.IOLayerCallOnFail(this.mCurrentHardware, timeOut);
        } else if (StringUtils.isNotEmpty(str)) {
            checkTimeOut(timeOut, i);
            writeGatt(this.mBluetoothGattCharacteristic, str);
        } else {
            this.ioMessage.IOLayerCallOnFail(this.mCurrentHardware, timeOut);
            stopAndRelease();
        }
    }

    private void writeGatt(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final String str) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.4
            @Override // java.lang.Runnable
            public void run() {
                BluetoothGattCharacteristic bluetoothGattCharacteristic2;
                if (BleReadWriteService.this.mBluetoothGatt == null || (bluetoothGattCharacteristic2 = bluetoothGattCharacteristic) == null) {
                    return;
                }
                bluetoothGattCharacteristic2.setValue(HexString.hexToBuffer(str));
                bluetoothGattCharacteristic.setWriteType(2);
                BleReadWriteService.this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
        }, 100L);
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        BluetoothDevice bluetoothDevice = this.mCurrentHardware;
        if (bluetoothDevice != null) {
            bluetoothDevice.isTimeout = false;
        }
        closeGatt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        this.mCurrentTime = System.currentTimeMillis();
        this.mTimeOutTime = i;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis() - BleReadWriteService.this.mCurrentTime;
            Log.e("test", "isRunning" + BleReadWriteService.this.isRunning + "  " + this.timeOut + "  " + BleReadWriteService.this.mCurrentCheckTimeOut);
            if (this.timeOut == TimeOut.Scan && BleReadWriteService.this.mCurrentCheckTimeOut != null) {
                BleReadWriteService.this.stopScan();
                BleReadWriteService.this.start();
            }
            if (BleReadWriteService.this.isRunning && this.timeOut == BleReadWriteService.this.mCurrentCheckTimeOut && jCurrentTimeMillis > BleReadWriteService.this.mTimeOutTime - 1000) {
                BleReadWriteService.this.mCurrentHardware.isTimeout = true;
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BleReadWriteService.CheckRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (BleReadWriteService.this.isRunning && BleReadWriteService.this.ioMessage != null) {
                                BleReadWriteService.this.ioMessage.IOLayerCallOnFail(BleReadWriteService.this.mCurrentHardware, CheckRunnable.this.timeOut);
                            }
                        } finally {
                            Log.e("bluetooth", "CheckRunnable");
                            BleReadWriteService.this.stopAndRelease();
                        }
                    }
                });
            }
        }
    }

    public void startScan() {
        if (this.isRunning) {
            return;
        }
        Log.e("test", "开始搜索设备");
        if (this.mBluetoothAdapter != null) {
            checkTimeOut(TimeOut.Scan, 3000);
            this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
        }
    }

    public void stopScan() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.mLeScanCallback);
        }
    }
}
