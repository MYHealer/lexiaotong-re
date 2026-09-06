package android.client.bluetoothsdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.client.bluetoothsdk.BluetoothErrorCode;
import android.client.bluetoothsdk.UUIDUtil;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.listener.ConnectListener;
import android.client.bluetoothsdk.listener.DataListener;
import android.client.bluetoothsdk.util.BluetoothUtils;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.HexString;
import android.client.bluetoothsdk.util.LogUtil;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.Context;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BluetoothConnect {
    private static final int SENDDATA_LENGTH = 40;
    private static final String TAG = "BluetoothConnect";
    private boolean connectState;
    private boolean isRunning;
    private boolean isSendData;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback;
    private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private int mIndex;
    private boolean mIsOpenSPP;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private int mLeftCount;
    private BluetoothConnectListener mOpenListener;
    private String mSendData;
    private long mTimeOutTime;

    public static class SingletonHolder {
        public static final BluetoothConnect INSTANCE = new BluetoothConnect();
    }

    public void connect(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void setOpenListener(BluetoothConnectListener bluetoothConnectListener) {
        this.mOpenListener = bluetoothConnectListener;
    }

    private BluetoothConnect() {
        this.connectState = false;
        this.isSendData = false;
        this.mSendData = "";
        this.mLeftCount = 0;
        this.mIndex = 1;
        this.mBluetoothGattCallback = new BluetoothGattCallback() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.6
            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onConnectionStateChange(bluetoothGatt, i, i2);
                Log.e(BluetoothConnect.TAG, "onConnectionStateChange:" + BluetoothConnect.this.isRunning + "  " + i + "   " + i2);
                if (i != 0) {
                    BluetoothConnect.this.connectState = false;
                    if (BluetoothConnect.this.isRunning) {
                        BluetoothConnect bluetoothConnect = BluetoothConnect.this;
                        bluetoothConnect.callOnFail(bluetoothConnect.mCurrentHardware, TimeOut.DisConnect, "连接失败" + i);
                        return;
                    }
                    return;
                }
                if (i2 != 2) {
                    if (i2 == 0) {
                        BluetoothConnect.this.connectState = false;
                        if (BluetoothConnect.this.isRunning) {
                            BluetoothConnect bluetoothConnect2 = BluetoothConnect.this;
                            bluetoothConnect2.callOnFail(bluetoothConnect2.mCurrentHardware, TimeOut.DisConnect, "蓝牙信号不稳定,请重试" + i);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String address = bluetoothGatt.getDevice().getAddress();
                if (address == null || BluetoothConnect.this.mCurrentHardware == null || !address.equals(BluetoothConnect.this.mCurrentHardware.address) || BluetoothConnect.this.mCurrentHardware.isTimeout || !BluetoothConnect.this.isRunning) {
                    return;
                }
                BluetoothConnect.this.mBluetoothGattCharacteristic = null;
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BluetoothConnect.this.checkTimeOut(TimeOut.Discover, 5000);
                bluetoothGatt.discoverServices();
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                List<BluetoothGattDescriptor> descriptors;
                Log.e(BluetoothConnect.TAG, "onServicesDiscovered:" + BluetoothConnect.this.isRunning + "  " + i);
                if (i != 0) {
                    if (i == 257) {
                        BluetoothConnect.this.connectState = false;
                        if (BluetoothConnect.this.isRunning) {
                            BluetoothConnect bluetoothConnect = BluetoothConnect.this;
                            bluetoothConnect.callOnFail(bluetoothConnect.mCurrentHardware, TimeOut.DisConnect, "获取特征值失败" + i);
                            return;
                        }
                        return;
                    }
                    return;
                }
                String address = bluetoothGatt.getDevice().getAddress();
                if (address != null && address.equals(BluetoothConnect.this.mCurrentHardware.address)) {
                    List<BluetoothGattService> services = bluetoothGatt.getServices();
                    if (services != null) {
                        Iterator<BluetoothGattService> it = services.iterator();
                        while (it.hasNext()) {
                            List<BluetoothGattCharacteristic> characteristics = it.next().getCharacteristics();
                            if (characteristics != null) {
                                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                    if (bluetoothGattCharacteristic != null && UUIDUtil.isWriteUuid(bluetoothGattCharacteristic.getUuid().toString())) {
                                        BluetoothConnect.this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                    } else if (bluetoothGattCharacteristic != null && UUIDUtil.isReadUuid(bluetoothGattCharacteristic.getUuid().toString())) {
                                        if (characteristics.size() == 1) {
                                            BluetoothConnect.this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                        }
                                        if (BluetoothConnect.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true) && (descriptors = bluetoothGattCharacteristic.getDescriptors()) != null && descriptors.size() > 0) {
                                            for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                BluetoothConnect.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (BluetoothConnect.this.mBluetoothGattCharacteristic != null) {
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LogUtil.log_e(BluetoothConnect.TAG, "BLE蓝牙连接成功!");
                                BluetoothConnect.this.connectState = true;
                                BluetoothConnect.this.callOnSuccessConnect(BluetoothConnect.this.mCurrentHardware);
                            }
                        }, 200L);
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                String address = bluetoothGatt.getDevice().getAddress();
                if (address != null && address.equals(BluetoothConnect.this.mCurrentHardware.address) && !BluetoothConnect.this.mCurrentHardware.isTimeout && BluetoothConnect.this.isRunning) {
                    String strBufferToHex = HexString.bufferToHex(bluetoothGattCharacteristic.getValue());
                    LogUtil.log_e(BluetoothConnect.TAG, "收到数据：" + strBufferToHex);
                    BluetoothConnect bluetoothConnect = BluetoothConnect.this;
                    bluetoothConnect.callOnSuccessSendData(bluetoothConnect.mCurrentHardware, strBufferToHex);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                LogUtil.log_i(BluetoothConnect.TAG, "onCharacteristicWrite" + i);
                BluetoothConnect.this.sendata();
            }
        };
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.7
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(android.bluetooth.BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (BluetoothConnect.this.mCurrentHardware.address.equals(bluetoothDevice.getAddress())) {
                    BluetoothConnect.this.stopScan();
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothConnect.this.start();
                        }
                    }, 200L);
                }
            }
        };
        this.mIsOpenSPP = false;
    }

    public static BluetoothConnect getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void startScan() {
        LogUtil.log_e(TAG, "开始搜索设备" + this.isRunning + "  ");
        if (this.isRunning) {
            return;
        }
        callOnStart(this.mCurrentHardware);
        if (this.mBluetoothAdapter != null) {
            checkTimeOut(TimeOut.Scan, 2000);
            this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
        }
    }

    public void stopScan() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.mLeScanCallback);
        }
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.mIsOpenSPP = false;
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart(this.mCurrentHardware);
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBluetoothLeSupported(this.mContext)) {
            this.mCurrentHardware.isTimeout = false;
            android.bluetooth.BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(this.mCurrentHardware.address);
            LogUtil.log_e(TAG, "开始连接设备");
            checkTimeOut(TimeOut.Connect, 8000);
            this.mBluetoothGatt = remoteDevice.connectGatt(this.mContext, false, this.mBluetoothGattCallback);
            return;
        }
        callOnBluetoothException(new ClientException("请打开蓝牙"));
    }

    public void sendData(String str) {
        this.isSendData = true;
        this.mSendData = str;
        if (!this.connectState || !this.isRunning) {
            if (this.isRunning) {
                return;
            }
            this.isRunning = false;
            startScan();
            return;
        }
        LogUtil.log_e(TAG, "发送数据" + this.mSendData);
        this.mLeftCount = 0;
        this.mIndex = 0;
        if (this.mSendData.length() > 40) {
            this.mLeftCount = this.mSendData.length() / 40;
            if (this.mSendData.length() % 40 != 0) {
                this.mLeftCount++;
            }
            sendata();
            return;
        }
        writeGatt(this.mBluetoothGattCharacteristic, this.mSendData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendata() {
        int i = this.mLeftCount;
        if (i >= 2) {
            this.mLeftCount = i - 1;
            int i2 = this.mIndex;
            this.mIndex = i2 + 1;
            writeGatt(this.mBluetoothGattCharacteristic, this.mSendData.substring(i2 * 40, (i2 * 40) + 40));
        } else if (i == 1) {
            this.mLeftCount = i - 1;
            int i3 = this.mIndex;
            this.mIndex = i3 + 1;
            writeGatt(this.mBluetoothGattCharacteristic, this.mSendData.substring(i3 * 40));
        }
        if (this.mLeftCount == 0) {
            this.mSendData = "";
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
        if (this.mIsOpenSPP) {
            this.mIsOpenSPP = false;
            closeBLE();
        }
    }

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

    private void writeGatt(BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) {
        if (this.mBluetoothGatt == null || bluetoothGattCharacteristic == null || !this.isSendData) {
            if (this.mIsOpenSPP) {
                if (this.mLeftCount <= 1) {
                    this.isSendData = false;
                }
                LogUtil.log_e(TAG, "spp发了数据：" + str);
                ConnectSppDevice.getInstance().sendData(str);
                return;
            }
            return;
        }
        if (this.mLeftCount <= 1) {
            this.isSendData = false;
        }
        LogUtil.log_e(TAG, "发了数据：" + str);
        bluetoothGattCharacteristic.setValue(HexString.hexToBuffer(str));
        bluetoothGattCharacteristic.setWriteType(2);
        this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.1
            @Override // java.lang.Runnable
            public void run() {
                if (!BluetoothConnect.this.isRunning || BluetoothConnect.this.mOpenListener == null) {
                    return;
                }
                BluetoothConnect.this.mOpenListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccessSendData(final BluetoothDevice bluetoothDevice, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.2
            @Override // java.lang.Runnable
            public void run() {
                if (!BluetoothConnect.this.isRunning || BluetoothConnect.this.mOpenListener == null) {
                    return;
                }
                BluetoothConnect.this.mOpenListener.onSuccessSendData(bluetoothDevice, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccessConnect(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.3
            @Override // java.lang.Runnable
            public void run() {
                if (!BluetoothConnect.this.isRunning || BluetoothConnect.this.mOpenListener == null) {
                    return;
                }
                BluetoothConnect.this.mOpenListener.onSuccessConnect(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.4
            @Override // java.lang.Runnable
            public void run() {
                LogUtil.log_e(BluetoothConnect.TAG, bluetoothDevice.address + "  " + BluetoothConnect.this.isRunning + "  " + (BluetoothConnect.this.mOpenListener != null));
                if (!bluetoothDevice.address.startsWith("00:0E:0B") || BluetoothConnect.this.mIsOpenSPP) {
                    try {
                        if (BluetoothConnect.this.isRunning && BluetoothConnect.this.mOpenListener != null) {
                            BluetoothConnect.this.mOpenListener.onFail(BluetoothConnect.this.mCurrentHardware, timeOut, str);
                        }
                        return;
                    } finally {
                        Log.e(BluetoothConnect.TAG, "callOnFail");
                        BluetoothConnect.this.stopAndRelease();
                    }
                }
                BluetoothConnect.this.connectSpp(bluetoothDevice, timeOut, str);
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (BluetoothConnect.this.isRunning && BluetoothConnect.this.mOpenListener != null) {
                        BluetoothConnect.this.mOpenListener.onBluetoothException(clientException);
                    }
                } finally {
                    LogUtil.log_e(BluetoothConnect.TAG, "callOnBluetoothException");
                    BluetoothConnect.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        this.mTimeOutTime = i;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private long mCurrentTime = System.currentTimeMillis();
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.log_e(BluetoothConnect.TAG, this.timeOut + "  " + BluetoothConnect.this.isRunning + "  " + BluetoothConnect.this.mCurrentCheckTimeOut + "  " + BluetoothConnect.this.mCurrentHardware.address + "  " + (System.currentTimeMillis() - this.mCurrentTime));
            if (this.timeOut == TimeOut.Scan) {
                BluetoothConnect.this.stopScan();
                BluetoothConnect.this.start();
            }
            if (BluetoothConnect.this.isRunning && this.timeOut == BluetoothConnect.this.mCurrentCheckTimeOut && this.timeOut != TimeOut.Scan && System.currentTimeMillis() - this.mCurrentTime >= BluetoothConnect.this.mTimeOutTime - 100) {
                BluetoothConnect.this.mCurrentHardware.isTimeout = true;
                BluetoothConnect bluetoothConnect = BluetoothConnect.this;
                bluetoothConnect.callOnFail(bluetoothConnect.mCurrentHardware, this.timeOut, BluetoothErrorCode.CONNECTTIMEOUTMSG);
            }
        }
    }

    private void setSppListener(BluetoothDevice bluetoothDevice, final TimeOut timeOut, String str) {
        ConnectSppDevice.getInstance().setConnectListener(new ConnectListener() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.8
            @Override // android.client.bluetoothsdk.listener.ConnectListener
            public void onConnectException(BluetoothDevice bluetoothDevice2, String str2, int i) {
            }

            @Override // android.client.bluetoothsdk.listener.ConnectListener
            public void onStartConnect(BluetoothDevice bluetoothDevice2) {
            }

            @Override // android.client.bluetoothsdk.listener.ConnectListener
            public void onConnectFail(BluetoothDevice bluetoothDevice2, String str2, int i) {
                BluetoothConnect.this.callOnFail(bluetoothDevice2, timeOut, str2);
            }

            @Override // android.client.bluetoothsdk.listener.ConnectListener
            public void onConnectSuccess(BluetoothDevice bluetoothDevice2) {
                LogUtil.log_i(BluetoothConnect.TAG, "spp连接成功");
                BluetoothConnect.this.connectState = true;
                BluetoothConnect.this.callOnSuccessConnect(bluetoothDevice2);
            }
        });
        ConnectSppDevice.getInstance().setDataListener(new DataListener() { // from class: android.client.bluetoothsdk.bluetooth.BluetoothConnect.9
            @Override // android.client.bluetoothsdk.listener.DataListener
            public void onSendDataFail(BluetoothDevice bluetoothDevice2, String str2, int i) {
                BluetoothConnect.this.callOnFail(bluetoothDevice2, TimeOut.Send, str2);
            }

            @Override // android.client.bluetoothsdk.listener.DataListener
            public void onReceivedData(BluetoothDevice bluetoothDevice2, String str2) {
                BluetoothConnect.this.callOnSuccessSendData(bluetoothDevice2, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectSpp(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
        this.mIsOpenSPP = true;
        LogUtil.log_i(TAG, "开始链接spp");
        setSppListener(bluetoothDevice, timeOut, str);
        ConnectSppDevice.getInstance().start(this.mContext, new BluetoothDevice(bluetoothDevice.name, bluetoothDevice.address.substring(0, 7) + ExifInterface.LONGITUDE_EAST + bluetoothDevice.address.substring(8)));
    }

    public void closeBLE() {
        ConnectSppDevice.getInstance().stopAndRelease();
    }
}
