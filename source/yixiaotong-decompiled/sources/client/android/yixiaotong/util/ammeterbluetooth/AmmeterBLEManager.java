package client.android.yixiaotong.util.ammeterbluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import com.alipay.sdk.widget.j;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterBLEManager implements IAmmeterBluetoothManager {
    private Context mContext;
    private AmmeterBluetoothManager.Listener mListener;
    protected static final String TAG = "AmmeterBluetoothManager";
    protected static String uuidQppService = "0000fee9-0000-1000-8000-00805f9b34fb";
    protected static String uuidQppCharWrite = "d44bc439-abfd-45a2-b575-925416129600";
    private static final Map<String, AmmeterBluetoothDevice> mDeviceMap = new HashMap();
    public static BluetoothGatt mBluetoothGatt = null;
    private boolean mConnected1 = false;
    private boolean mConnected2 = false;
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBLEManager.2
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            Log.e(AmmeterBLEManager.TAG, "onConnectionStateChange : " + i + "  newState : " + i2);
            if (i != 0) {
                AmmeterBLEManager.this.disConnectAll();
                if (AmmeterBLEManager.this.mListener != null) {
                    AmmeterBLEManager.this.mConnected1 = false;
                    AmmeterBLEManager.this.mListener.onConnectionFailed(bluetoothGatt.getDevice().getAddress());
                    return;
                }
                return;
            }
            if (i2 == 1) {
                if (AmmeterBLEManager.this.mListener != null) {
                    AmmeterBLEManager.this.mListener.onConnecting(bluetoothGatt.getDevice().getAddress());
                }
            } else if (i2 == 2) {
                bluetoothGatt.discoverServices();
                AmmeterBLEManager.this.mConnected1 = true;
                AmmeterBLEManager.this.mListener.onConnected(bluetoothGatt.getDevice().getAddress(), true);
            } else if (i2 == 0) {
                AmmeterBLEManager.this.mListener.onDisconnected(bluetoothGatt.getDevice().getAddress());
                AmmeterBLEManager.this.mConnected1 = false;
                AmmeterBLEManager.this.mListener.onConnected(bluetoothGatt.getDevice().getAddress(), false);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            Log.e(AmmeterBLEManager.TAG, "onServicesDiscovered:status" + i);
            if (AmmeterBluetoothUtils.qppEnable(bluetoothGatt, AmmeterBLEManager.uuidQppService, AmmeterBLEManager.uuidQppCharWrite)) {
                AmmeterBLEManager.this.mConnected2 = true;
                AmmeterBLEManager.this.mListener.onConnectState(bluetoothGatt.getDevice().getAddress(), true);
            } else {
                AmmeterBLEManager.this.disConnectAll();
                AmmeterBLEManager.this.mConnected2 = false;
                AmmeterBLEManager.this.mListener.onConnectState(bluetoothGatt.getDevice().getAddress(), false);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (AmmeterBLEManager.this.mListener != null) {
                AmmeterBLEManager.this.mListener.onDataReceived(bluetoothGatt.getDevice().getAddress(), bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            AmmeterBluetoothUtils.setQppNextNotify(bluetoothGatt, true);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            if (i == 0) {
                return;
            }
            Log.e(AmmeterBLEManager.TAG, "Send failed!!!!");
        }
    };
    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBLEManager.3
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            if (AmmeterBLEManager.this.mListener != null) {
                if (!AmmeterBLEManager.mDeviceMap.containsKey(bluetoothDevice.getAddress())) {
                    AmmeterBLEManager.mDeviceMap.put(bluetoothDevice.getAddress(), new AmmeterBluetoothDevice(bluetoothDevice.getName(), bluetoothDevice.getAddress(), i));
                }
                AmmeterBLEManager.this.mListener.onDeviceFound(bluetoothDevice.getAddress());
            }
        }
    };

    public AmmeterBLEManager(Context context, AmmeterBluetoothManager.Listener listener) {
        this.mContext = context;
        this.mListener = listener;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void startScan(BluetoothAdapter bluetoothAdapter) {
        stopScan(bluetoothAdapter);
        mDeviceMap.clear();
        bluetoothAdapter.startLeScan(this.mLeScanCallback);
        AmmeterBluetoothManager.Listener listener = this.mListener;
        if (listener != null) {
            listener.onDiscoveryStarted();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void stopScan(BluetoothAdapter bluetoothAdapter) {
        bluetoothAdapter.stopLeScan(this.mLeScanCallback);
        AmmeterBluetoothManager.Listener listener = this.mListener;
        if (listener != null) {
            listener.onDiscoveryFinished();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void restartBluetooth(final BluetoothAdapter bluetoothAdapter) {
        bluetoothAdapter.disable();
        AsyncExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBLEManager.1
            @Override // java.lang.Runnable
            public void run() {
                bluetoothAdapter.enable();
            }
        }, 500L);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void addBluetoothDevice(BluetoothAdapter bluetoothAdapter, String str, String str2, int i) {
        Map<String, AmmeterBluetoothDevice> map = mDeviceMap;
        if (map.containsKey(str2)) {
            return;
        }
        map.put(str2, new AmmeterBluetoothDevice(str, str2, i));
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void connect(BluetoothAdapter bluetoothAdapter, String str) {
        AmmeterBluetoothDevice ammeterBluetoothDevice;
        if (TextUtils.isEmpty(str) || (ammeterBluetoothDevice = mDeviceMap.get(str)) == null) {
            return;
        }
        stopScan(bluetoothAdapter);
        BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(ammeterBluetoothDevice.mAddress);
        if (remoteDevice != null) {
            Log.e(TAG, "init  mBluetoothGatt!");
            mBluetoothGatt = remoteDevice.connectGatt(this.mContext, false, this.mGattCallback);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void sendData(String str, byte[] bArr) {
        AmmeterBluetoothManager.Listener listener;
        if (AmmeterBluetoothUtils.qppSendData(mBluetoothGatt, bArr) || (listener = this.mListener) == null) {
            return;
        }
        listener.onSendDataFailed();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void disConnectAll() {
        Iterator<String> it = mDeviceMap.keySet().iterator();
        while (it.hasNext()) {
            disConnect(mDeviceMap.get(it.next()).mAddress);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void disConnect(String str) {
        BluetoothGatt bluetoothGatt = mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
            mBluetoothGatt.close();
            mBluetoothGatt = null;
            this.mConnected1 = false;
            this.mConnected2 = false;
        }
    }

    public boolean refreshDeviceCache(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            try {
                Method method = bluetoothGatt.getClass().getMethod(j.l, new Class[0]);
                if (method != null) {
                    return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public AmmeterBluetoothDevice getBluetoothDevice(String str) {
        return mDeviceMap.get(str);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.IAmmeterBluetoothManager
    public void bleConnectState() {
        if (this.mConnected1 && this.mConnected2) {
            this.mListener.onBLEState(true);
        } else {
            this.mListener.onBLEState(false);
        }
    }
}
