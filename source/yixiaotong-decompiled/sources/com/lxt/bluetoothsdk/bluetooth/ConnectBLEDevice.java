package com.lxt.bluetoothsdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.alipay.sdk.widget.j;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.TimeOut;
import com.lxt.bluetoothsdk.UUIDUtil;
import com.lxt.bluetoothsdk.listener.ConnectListener;
import com.lxt.bluetoothsdk.listener.DataListener;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.lxt.bluetoothsdk.utils.HexString;
import com.lxt.bluetoothsdk.utils.LogUtil;
import com.lxt.bluetoothsdk.utils.StringUtils;
import com.lxt.bluetoothsdk.utils.executor.MainThreadExecutor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class ConnectBLEDevice {
    private static final int CONNECT_FAIL = 2;
    private static final int CONNECT_SUCCESS = 1;
    private static final int DETAILTIME = 60;
    private static final int FIND_SERVER = 4;
    private static final int MTU = 100;
    private static final int SENDDATA = 3;
    private static final int SENDDATA_LENGTH = 160;
    private static final int SETMTU = 5;
    private static final int START_CONNECT = 0;
    private String TAG;
    private ConnectListener connectListener;
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback;
    private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
    private int mConnectTimeOut;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private int mDisvoverTimeOut;
    private Handler mHandler;
    private int mIndex;
    private boolean mIsStartScan;
    private BluetoothAdapter.LeScanCallback mLeScanCallback;
    private int mLeftCount;
    private int mMTU;
    private String mSendData;
    private int mSendDataLength;
    private DataListener receiveDataListener;

    public static class SingletonHolder {
        public static final ConnectBLEDevice INSTANCE = new ConnectBLEDevice();
    }

    public void setConnectListener(ConnectListener connectListener) {
        this.connectListener = connectListener;
    }

    public void setDataListener(DataListener dataListener) {
        this.receiveDataListener = dataListener;
    }

    public void setTime(int i, int i2) {
        this.mConnectTimeOut = i;
        this.mDisvoverTimeOut = i2;
    }

    public void unRegisterListener() {
        this.connectListener = null;
        this.receiveDataListener = null;
    }

    private ConnectBLEDevice() {
        this.TAG = "ConnectBLEDevice";
        this.mSendData = "";
        this.mSendDataLength = 40;
        this.mConnectTimeOut = 5000;
        this.mDisvoverTimeOut = 5000;
        this.mMTU = 160;
        this.mIsStartScan = true;
        this.mHandler = new Handler() { // from class: com.lxt.bluetoothsdk.bluetooth.ConnectBLEDevice.1
            @Override // android.os.Handler
            public void handleMessage(final Message message) {
                if (ConnectBLEDevice.this.isRunning) {
                    if (message.what == 0) {
                        if (ConnectBLEDevice.this.mBluetoothAdapter.getState() == 12) {
                            ConnectBLEDevice.this.connectListener.onStartConnect(ConnectBLEDevice.this.mCurrentHardware);
                            android.bluetooth.BluetoothDevice remoteDevice = ConnectBLEDevice.this.mBluetoothAdapter.getRemoteDevice(ConnectBLEDevice.this.mCurrentHardware.address);
                            ConnectBLEDevice.this.checkTimeOut(TimeOut.Connect, ConnectBLEDevice.this.mConnectTimeOut);
                            ConnectBLEDevice connectBLEDevice = ConnectBLEDevice.this;
                            connectBLEDevice.mBluetoothGatt = remoteDevice.connectGatt(connectBLEDevice.mContext, false, ConnectBLEDevice.this.mBluetoothGattCallback);
                            return;
                        }
                        ConnectBLEDevice.this.connectListener.onConnectException(ConnectBLEDevice.this.mCurrentHardware, "请打开蓝牙！", 10001);
                        return;
                    }
                    if (message.what == 4) {
                        if (ConnectBLEDevice.this.mBluetoothGatt != null) {
                            ConnectBLEDevice.this.mBluetoothGatt.discoverServices();
                        }
                        ConnectBLEDevice.this.checkTimeOut(TimeOut.Discover, ConnectBLEDevice.this.mDisvoverTimeOut);
                        return;
                    }
                    if (message.what == 5) {
                        boolean zRequestMtu = ConnectBLEDevice.this.mBluetoothGatt.requestMtu(ConnectBLEDevice.this.mMTU);
                        LogUtil.log_i(ConnectBLEDevice.this.TAG, "onMtuChanged" + zRequestMtu);
                        if (zRequestMtu) {
                            ConnectBLEDevice.this.mSendDataLength = 160;
                            return;
                        }
                        return;
                    }
                    if (message.what == 1) {
                        LogUtil.log_i(ConnectBLEDevice.this.TAG, "蓝牙连接成功!");
                        ConnectBLEDevice.this.connectListener.onConnectSuccess(ConnectBLEDevice.this.mCurrentHardware);
                    } else if (message.what == 2) {
                        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: com.lxt.bluetoothsdk.bluetooth.ConnectBLEDevice.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ConnectBLEDevice.this.connectListener.onConnectFail(ConnectBLEDevice.this.mCurrentHardware, message.obj.toString(), 10006);
                            }
                        });
                    } else {
                        int i = message.what;
                    }
                }
            }
        };
        this.mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.lxt.bluetoothsdk.bluetooth.ConnectBLEDevice.2
            @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
            public void onLeScan(android.bluetooth.BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
                if (ConnectBLEDevice.this.mCurrentHardware.address.equals(bluetoothDevice.getAddress()) && ConnectBLEDevice.this.mIsStartScan) {
                    ConnectBLEDevice.this.mIsStartScan = false;
                    ConnectBLEDevice.this.stopScan();
                    ConnectBLEDevice.this.startconnect();
                }
            }
        };
        this.mBluetoothGattCallback = new BluetoothGattCallback() { // from class: com.lxt.bluetoothsdk.bluetooth.ConnectBLEDevice.3
            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onConnectionStateChange(bluetoothGatt, i, i2);
                LogUtil.log_i(ConnectBLEDevice.this.TAG, "onConnectionStateChange:" + i + "   " + i2 + "  " + ConnectBLEDevice.this.isRunning);
                if (ConnectBLEDevice.this.isRunning) {
                    if (i != 0) {
                        Message message = new Message();
                        message.what = 2;
                        message.obj = "连接异常，请重启手机蓝牙或重启设备蓝牙后再试" + i2;
                        ConnectBLEDevice.this.mHandler.handleMessage(message);
                        ConnectBLEDevice.this.stopAndRelease();
                        return;
                    }
                    if (i2 == 2) {
                        String address = bluetoothGatt.getDevice().getAddress();
                        if (address == null || ConnectBLEDevice.this.mCurrentHardware == null || !address.equals(ConnectBLEDevice.this.mCurrentHardware.address)) {
                            return;
                        }
                        ConnectBLEDevice.this.mBluetoothGattCharacteristic = null;
                        ConnectBLEDevice.this.mBluetoothGatt = bluetoothGatt;
                        ConnectBLEDevice.this.mHandler.sendEmptyMessageDelayed(4, 300L);
                        return;
                    }
                    if (i2 == 0) {
                        if (bluetoothGatt != ConnectBLEDevice.this.mBluetoothGatt) {
                            bluetoothGatt.close();
                            return;
                        }
                        Message message2 = new Message();
                        message2.what = 2;
                        message2.obj = "蓝牙信号不稳定" + i2;
                        ConnectBLEDevice.this.mHandler.handleMessage(message2);
                        ConnectBLEDevice.this.stopAndRelease();
                        return;
                    }
                    Message message3 = new Message();
                    message3.what = 2;
                    message3.obj = "蓝牙匹配失败，请重新连接" + i2;
                    ConnectBLEDevice.this.mHandler.handleMessage(message3);
                    ConnectBLEDevice.this.stopAndRelease();
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                String address;
                List<BluetoothGattDescriptor> descriptors;
                LogUtil.log_i(ConnectBLEDevice.this.TAG, "onServicesDiscovered:" + i + "");
                if (ConnectBLEDevice.this.isRunning && i == 0 && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(ConnectBLEDevice.this.mCurrentHardware.address)) {
                    List<BluetoothGattService> services = bluetoothGatt.getServices();
                    if (services != null) {
                        Iterator<BluetoothGattService> it = services.iterator();
                        while (it.hasNext()) {
                            List<BluetoothGattCharacteristic> characteristics = it.next().getCharacteristics();
                            if (characteristics != null) {
                                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                    if (bluetoothGattCharacteristic != null && UUIDUtil.isWriteUuid(bluetoothGattCharacteristic.getUuid().toString())) {
                                        ConnectBLEDevice.this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                    } else if (bluetoothGattCharacteristic != null && UUIDUtil.isReadUuid(bluetoothGattCharacteristic.getUuid().toString())) {
                                        if (characteristics.size() == 1) {
                                            ConnectBLEDevice.this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                        }
                                        if (ConnectBLEDevice.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, true) && (descriptors = bluetoothGattCharacteristic.getDescriptors()) != null && descriptors.size() > 0) {
                                            for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                if (bluetoothGattDescriptor != null) {
                                                    if ((bluetoothGattCharacteristic.getProperties() & 16) != 0) {
                                                        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                    } else if ((bluetoothGattCharacteristic.getProperties() & 32) != 0) {
                                                        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                                                    }
                                                }
                                                ConnectBLEDevice.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (ConnectBLEDevice.this.mBluetoothGattCharacteristic != null) {
                        MainThreadExecutor.getInstance().removeRunnable();
                        ConnectBLEDevice.this.mHandler.sendEmptyMessageDelayed(1, 200L);
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                String address;
                LogUtil.log_i(ConnectBLEDevice.this.TAG, "onCharacteristicChanged");
                if (ConnectBLEDevice.this.isRunning && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(ConnectBLEDevice.this.mCurrentHardware.address)) {
                    String strBufferToHex = HexString.bufferToHex(bluetoothGattCharacteristic.getValue());
                    LogUtil.log_w(ConnectBLEDevice.this.TAG, "receiveddata：" + strBufferToHex);
                    if (ConnectBLEDevice.this.receiveDataListener == null) {
                        return;
                    }
                    ConnectBLEDevice.this.receiveDataListener.onReceivedData(ConnectBLEDevice.this.mCurrentHardware, strBufferToHex);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onReadRemoteRssi(bluetoothGatt, i, i2);
                LogUtil.log_i(ConnectBLEDevice.this.TAG, "onReadRemoteRssi" + i + "  " + i2);
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
                super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
                LogUtil.log_i(ConnectBLEDevice.this.TAG, "onCharacteristicWrite" + i);
                ConnectBLEDevice.this.sendata();
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onMtuChanged(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onMtuChanged(bluetoothGatt, i, i2);
                LogUtil.log_i(ConnectBLEDevice.this.TAG, "onMtuChanged" + i + PPSLabelView.Code + i2);
                if (ConnectBLEDevice.this.mMTU > i) {
                    ConnectBLEDevice.this.mMTU = i;
                    ConnectBLEDevice.this.mHandler.sendEmptyMessageDelayed(5, 10L);
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
                super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i);
                LogUtil.log_i(ConnectBLEDevice.this.TAG, "onDescriptorWrite" + i + PPSLabelView.Code);
            }
        };
        this.mLeftCount = 0;
        this.mIndex = 1;
    }

    public static ConnectBLEDevice getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start(Context context, BluetoothDevice bluetoothDevice) {
        LogUtil.log_i(this.TAG, "开始连接蓝牙!");
        this.mContext = context;
        this.mBluetoothAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        this.mCurrentHardware = bluetoothDevice;
        if (this.connectListener == null) {
            return;
        }
        startScan();
    }

    private void startScan() {
        if (this.isRunning) {
            if (this.mBluetoothAdapter.getState() != 12) {
                this.connectListener.onConnectException(this.mCurrentHardware, "请打开蓝牙！", 10001);
                return;
            }
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        LogUtil.log_i(this.TAG, "开始搜索设备");
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            if (bluetoothAdapter.getState() == 12) {
                checkTimeOut(TimeOut.Scan, 2000);
                this.mIsStartScan = true;
                this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
                return;
            }
            this.connectListener.onConnectException(this.mCurrentHardware, "请打开蓝牙！", 10001);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopScan() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.stopLeScan(this.mLeScanCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startconnect() {
        this.mHandler.sendEmptyMessageDelayed(0, 200L);
    }

    public void sendData(String str) {
        DataListener dataListener = this.receiveDataListener;
        if (dataListener == null) {
            return;
        }
        if (!this.isRunning) {
            dataListener.onSendDataFail(this.mCurrentHardware, "设备蓝牙已断开,请重新连接", 10006);
            return;
        }
        if (StringUtils.isNotEmpty(str)) {
            this.mSendData = str;
            LogUtil.log_w(this.TAG, "发送数据" + str);
            this.mLeftCount = 0;
            this.mIndex = 0;
            if (this.mSendData.length() > this.mSendDataLength) {
                this.mLeftCount = this.mSendData.length() / this.mSendDataLength;
                if (this.mSendData.length() % this.mSendDataLength != 0) {
                    this.mLeftCount++;
                }
                sendata();
                return;
            }
            writeGatt(this.mBluetoothGattCharacteristic, this.mSendData);
            return;
        }
        this.receiveDataListener.onSendDataFail(this.mCurrentHardware, "发送数据不能为空", 201);
        stopAndRelease();
    }

    private void writeGatt(BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) {
        if (this.mBluetoothGatt == null || bluetoothGattCharacteristic == null) {
            return;
        }
        LogUtil.log_w(this.TAG, "senddada:" + str);
        bluetoothGattCharacteristic.setValue(HexString.hexToBuffer(str));
        this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
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
            LogUtil.log_w(ConnectBLEDevice.this.TAG, "isRunning" + ConnectBLEDevice.this.isRunning + "  " + this.timeOut + "  " + ConnectBLEDevice.this.mCurrentCheckTimeOut);
            if (ConnectBLEDevice.this.isRunning) {
                if (this.timeOut == TimeOut.Scan) {
                    ConnectBLEDevice.this.stopScan();
                    ConnectBLEDevice.this.startconnect();
                } else if (this.timeOut == ConnectBLEDevice.this.mCurrentCheckTimeOut) {
                    ConnectBLEDevice.this.mCurrentHardware.isTimeout = true;
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: com.lxt.bluetoothsdk.bluetooth.ConnectBLEDevice.CheckRunnable.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (ConnectBLEDevice.this.connectListener != null) {
                                    ConnectBLEDevice.this.connectListener.onConnectFail(ConnectBLEDevice.this.mCurrentHardware, CheckRunnable.this.timeOut + "", 10009);
                                }
                            } finally {
                                LogUtil.log_w(ConnectBLEDevice.this.TAG, "CheckRunnable");
                                ConnectBLEDevice.this.stopAndRelease();
                            }
                        }
                    });
                }
            }
        }
    }

    public void stopAndRelease() {
        LogUtil.log_e(this.TAG, "stopAndRelease");
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        BluetoothDevice bluetoothDevice = this.mCurrentHardware;
        if (bluetoothDevice != null) {
            bluetoothDevice.isTimeout = false;
        }
        this.mContext = null;
        this.mHandler.removeCallbacksAndMessages(null);
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
        MainThreadExecutor.getInstance().removeRunnable();
        System.gc();
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
    public void sendata() {
        int i = this.mLeftCount;
        if (i >= 2) {
            this.mLeftCount = i - 1;
            int i2 = this.mIndex;
            this.mIndex = i2 + 1;
            BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mBluetoothGattCharacteristic;
            String str = this.mSendData;
            int i3 = this.mSendDataLength;
            writeGatt(bluetoothGattCharacteristic, str.substring(i3 * i2, (i2 * i3) + i3));
        } else if (i == 1) {
            this.mLeftCount = i - 1;
            int i4 = this.mIndex;
            this.mIndex = i4 + 1;
            writeGatt(this.mBluetoothGattCharacteristic, this.mSendData.substring(this.mSendDataLength * i4));
        }
        if (this.mLeftCount == 0) {
            this.mSendData = "";
        }
    }
}
