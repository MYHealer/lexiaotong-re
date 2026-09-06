package client.android.yixiaotong.util.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BLEManager implements IBluetoothManager {
    private static final Map<String, BluetoothDevice> mDeviceMap = new HashMap();
    private BluetoothManager.Listener mBluetoothManagerListener;
    private Context mContext;
    private Status mStatus = Status.DisConnect;
    StringBuilder stringBuilder = new StringBuilder();
    private byte[] mLastCharacteristicData = null;
    private BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.util.bluetooth.BLEManager.2
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (BLEManager.this.mBluetoothManagerListener != null) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                if (BLEManager.this.mLastCharacteristicData == null || !Arrays.equals(BLEManager.this.mLastCharacteristicData, value)) {
                    BLEManager.this.mLastCharacteristicData = value;
                    BLEManager.this.mBluetoothManagerListener.onDataReceived(bluetoothGatt.getDevice().getAddress(), value);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            Log.e("onConnectionStateChange", "status:" + i + "     newState:" + i2 + "  mState:" + BLEManager.this.mStatus);
            if (i != 0) {
                BLEManager.this.disConnectAll();
                if (BLEManager.this.mBluetoothManagerListener != null) {
                    BLEManager.this.mBluetoothManagerListener.onConnectionFailed(bluetoothGatt.getDevice().getAddress());
                    return;
                }
                return;
            }
            if (i2 == 1) {
                if (BLEManager.this.mStatus == Status.DisConnect) {
                    BLEManager.this.mStatus = Status.Connecting;
                    if (BLEManager.this.mBluetoothManagerListener != null) {
                        BLEManager.this.mBluetoothManagerListener.onConnecting(bluetoothGatt.getDevice().getAddress());
                        return;
                    }
                    return;
                }
                return;
            }
            if (i2 == 2) {
                if (BLEManager.this.mStatus == Status.Connecting) {
                    BLEManager.this.mStatus = Status.Discover;
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bluetoothGatt.discoverServices();
                    return;
                }
                return;
            }
            if (i2 == 0) {
                if (BLEManager.this.mStatus == Status.Discover || BLEManager.this.mStatus == Status.Connected) {
                    bluetoothGatt.disconnect();
                    bluetoothGatt.close();
                    BLEManager.this.mStatus = Status.DisConnect;
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) BLEManager.mDeviceMap.get(bluetoothGatt.getDevice().getAddress());
                    if (bluetoothDevice != null) {
                        bluetoothDevice.setBluetoothGatt(null);
                        bluetoothDevice.setAllBluetoothGattCharacteristic(null);
                    }
                    if (BLEManager.this.mBluetoothManagerListener != null) {
                        BLEManager.this.mBluetoothManagerListener.onDisconnected(bluetoothGatt.getDevice().getAddress());
                    }
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            Log.e("onServicesDiscovered", "status:" + i + "  mState:" + BLEManager.this.mStatus);
            if (BLEManager.this.mStatus == Status.Connected || BLEManager.this.mStatus == Status.DisConnect) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (i != 0) {
                if (i == 257) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) BLEManager.mDeviceMap.get(bluetoothGatt.getDevice().getAddress());
                    if (bluetoothDevice != null) {
                        bluetoothDevice.setBluetoothGatt(null);
                        bluetoothDevice.setAllBluetoothGattCharacteristic(null);
                    }
                    BLEManager.this.mStatus = Status.DisConnect;
                    if (BLEManager.this.mBluetoothManagerListener != null) {
                        BLEManager.this.mBluetoothManagerListener.onConnectionFailed(bluetoothGatt.getDevice().getAddress());
                        return;
                    }
                    return;
                }
                return;
            }
            List<BluetoothGattService> services = bluetoothGatt.getServices();
            if (services != null) {
                Iterator<BluetoothGattService> it = services.iterator();
                while (it.hasNext()) {
                    arrayList.addAll(it.next().getCharacteristics());
                }
            }
            if (!BLEManager.mDeviceMap.containsKey(bluetoothGatt.getDevice().getAddress())) {
                BLEManager.this.mStatus = Status.DisConnect;
                if (BLEManager.this.mBluetoothManagerListener != null) {
                    BLEManager.this.mBluetoothManagerListener.onConnectionFailed(bluetoothGatt.getDevice().getAddress());
                    return;
                }
                return;
            }
            BluetoothDevice bluetoothDevice2 = (BluetoothDevice) BLEManager.mDeviceMap.get(bluetoothGatt.getDevice().getAddress());
            bluetoothDevice2.setBluetoothGatt(bluetoothGatt);
            bluetoothDevice2.setAllBluetoothGattCharacteristic(arrayList);
            BLEManager.this.mStatus = Status.Connected;
            if (BLEManager.this.mBluetoothManagerListener != null) {
                BLEManager.this.mBluetoothManagerListener.onConnected(bluetoothGatt.getDevice().getAddress());
            }
        }
    };
    private int count = 0;
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: client.android.yixiaotong.util.bluetooth.BLEManager.3
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(android.bluetooth.BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (BLEManager.this.mBluetoothManagerListener != null) {
                if (!BLEManager.mDeviceMap.containsKey(bluetoothDevice.getAddress())) {
                    BLEManager.access$408(BLEManager.this);
                    BLEManager.mDeviceMap.put(bluetoothDevice.getAddress(), new BluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), i));
                }
                BLEManager.this.mBluetoothManagerListener.onDeviceFound(bluetoothDevice.getAddress());
            }
        }
    };

    private enum Status {
        Connecting,
        Discover,
        Connected,
        DisConnect
    }

    static /* synthetic */ int access$408(BLEManager bLEManager) {
        int i = bLEManager.count;
        bLEManager.count = i + 1;
        return i;
    }

    public BLEManager(Context context, BluetoothManager.Listener listener) {
        this.mContext = context;
        this.mBluetoothManagerListener = listener;
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void startScan(BluetoothAdapter bluetoothAdapter) {
        stopScan(bluetoothAdapter);
        mDeviceMap.clear();
        bluetoothAdapter.startLeScan(this.mLeScanCallback);
        BluetoothManager.Listener listener = this.mBluetoothManagerListener;
        if (listener != null) {
            listener.onDiscoveryStarted();
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void stopScan(BluetoothAdapter bluetoothAdapter) {
        bluetoothAdapter.stopLeScan(this.mLeScanCallback);
        BluetoothManager.Listener listener = this.mBluetoothManagerListener;
        if (listener != null) {
            listener.onDiscoveryFinished();
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void restartBluetooth(final BluetoothAdapter bluetoothAdapter) {
        bluetoothAdapter.disable();
        AsyncExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BLEManager.1
            @Override // java.lang.Runnable
            public void run() {
                bluetoothAdapter.enable();
            }
        }, 500L);
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void addBluetoothDevice(BluetoothAdapter bluetoothAdapter, String str, String str2) {
        Map<String, BluetoothDevice> map = mDeviceMap;
        if (map.containsKey(str2)) {
            return;
        }
        map.put(str2, new BluetoothDevice(str, str2));
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void connect(BluetoothAdapter bluetoothAdapter, String str) {
        BluetoothDevice bluetoothDevice;
        if (TextUtils.isEmpty(str) || (bluetoothDevice = mDeviceMap.get(str)) == null) {
            return;
        }
        stopScan(bluetoothAdapter);
        bluetoothDevice.mAddress = str;
        android.bluetooth.BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(bluetoothDevice.mAddress);
        if (remoteDevice != null) {
            this.mStatus = Status.Connecting;
            remoteDevice.connectGatt(this.mContext, false, this.mBluetoothGattCallback);
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void disConnectAll() {
        Iterator<String> it = mDeviceMap.keySet().iterator();
        while (it.hasNext()) {
            disConnect(mDeviceMap.get(it.next()).mAddress);
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void disConnect(String str) {
        BluetoothDevice bluetoothDevice;
        if (TextUtils.isEmpty(str) || (bluetoothDevice = mDeviceMap.get(str)) == null || bluetoothDevice.getBluetoothGatt() == null) {
            return;
        }
        this.mStatus = Status.DisConnect;
        try {
            bluetoothDevice.getBluetoothGatt().disconnect();
        } catch (Exception unused) {
        }
        try {
            bluetoothDevice.getBluetoothGatt().close();
        } catch (Exception unused2) {
        }
        bluetoothDevice.setBluetoothGatt(null);
        bluetoothDevice.setAllBluetoothGattCharacteristic(null);
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void sendData(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        BluetoothDevice bluetoothDevice = mDeviceMap.get(str);
        BluetoothGattCharacteristic readWriteBluetoothGattCharacteristic = bluetoothDevice.getReadWriteBluetoothGattCharacteristic();
        BluetoothGattCharacteristic readBluetoothGattCharacteristic = bluetoothDevice.getReadBluetoothGattCharacteristic();
        if (bluetoothDevice == null || bluetoothDevice.getBluetoothGatt() == null) {
            return;
        }
        this.mLastCharacteristicData = null;
        if (readWriteBluetoothGattCharacteristic != null) {
            bluetoothDevice.getBluetoothGatt().setCharacteristicNotification(readWriteBluetoothGattCharacteristic, true);
        }
        if (readBluetoothGattCharacteristic != null) {
            bluetoothDevice.getBluetoothGatt().setCharacteristicNotification(readBluetoothGattCharacteristic, true);
        }
        if (readWriteBluetoothGattCharacteristic != null) {
            readWriteBluetoothGattCharacteristic.setWriteType(2);
            readWriteBluetoothGattCharacteristic.setValue(bArr);
            bluetoothDevice.getBluetoothGatt().writeCharacteristic(readWriteBluetoothGattCharacteristic);
        } else if (readBluetoothGattCharacteristic != null) {
            readBluetoothGattCharacteristic.setWriteType(2);
            readBluetoothGattCharacteristic.setValue(bArr);
            bluetoothDevice.getBluetoothGatt().writeCharacteristic(readBluetoothGattCharacteristic);
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public BluetoothDevice getBluetoothDevice(String str) {
        return mDeviceMap.get(str);
    }
}
