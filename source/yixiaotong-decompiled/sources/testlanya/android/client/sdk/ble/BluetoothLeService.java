package testlanya.android.client.sdk.ble;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import java.util.List;
import java.util.UUID;
import testlanya.android.client.sdk.util.HexString;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class BluetoothLeService extends Service {
    public static final String ACTION_DATA_AVAILABLE = "com.example.bluetooth.le.ACTION_DATA_AVAILABLE";
    public static final String ACTION_GATT_CONNECTED = "com.example.bluetooth.le.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_DISCONNECTED = "com.example.bluetooth.le.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_SERVICES_DISCOVERED = "com.example.bluetooth.le.ACTION_GATT_SERVICES_DISCOVERED";
    public static final String EXTRA_DATA = "com.example.bluetooth.le.EXTRA_DATA";
    private static final String TAG = "BluetoothLeService";
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothManager mBluetoothManager;
    public BluetoothGattCharacteristic mNotifyCharacteristic;
    public static final UUID UUID_SERVICE = UUID.fromString("0000fff0-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_NOTIFYREAD = UUID.fromString("0000fff1-0000-1000-8000-00805f9b34fb");
    public static final UUID UUID_NOTIFYWRITE = UUID.fromString("0000fff2-0000-1000-8000-00805f9b34fb");
    private UUID mServerUUID = UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb");
    private UUID mRread = UUID.fromString("0000ffe1-0000-1000-8000-00805f9b34fb");
    private UUID mWrite = UUID.fromString("0000ffe2-0000-1000-8000-00805f9b34fb");
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() { // from class: testlanya.android.client.sdk.ble.BluetoothLeService.1
        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            Log.i(BluetoothLeService.TAG, "oldStatus=" + i + " NewStates=" + i2);
            if (i == 0) {
                if (i2 != 2) {
                    if (i2 == 0) {
                        BluetoothLeService.this.mBluetoothGatt.close();
                        BluetoothLeService.this.mBluetoothGatt = null;
                        Log.i(BluetoothLeService.TAG, "Disconnected from GATT server.");
                        BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_GATT_DISCONNECTED);
                        return;
                    }
                    return;
                }
                BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_GATT_CONNECTED);
                Log.i(BluetoothLeService.TAG, "Connected to GATT server." + Thread.currentThread().getId() + "  " + Thread.currentThread().getName());
                Log.i(BluetoothLeService.TAG, "Attempting to start service discovery:");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                BluetoothLeService.this.mBluetoothGatt.discoverServices();
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            if (i != 0) {
                if (BluetoothLeService.this.mBluetoothGatt.getDevice().getUuids() == null) {
                    Log.w(BluetoothLeService.TAG, "onServicesDiscovered received: " + i);
                }
            } else {
                Log.w(BluetoothLeService.TAG, "onServicesDiscovered received: " + i);
                BluetoothLeService.this.findService(bluetoothGatt.getServices());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Log.e(BluetoothLeService.TAG, "onCharacteristicRead");
            if (i == 0) {
                BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_DATA_AVAILABLE, bluetoothGattCharacteristic);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            Log.e(BluetoothLeService.TAG, "onCharacteristicChanged");
            BluetoothLeService.this.broadcastUpdate(BluetoothLeService.ACTION_DATA_AVAILABLE, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            Log.e(BluetoothLeService.TAG, "OnCharacteristicWrite");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            Log.e(BluetoothLeService.TAG, "onDescriptorRead");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i) {
            Log.e(BluetoothLeService.TAG, "onDescriptorWrite");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i, int i2) {
            Log.e(BluetoothLeService.TAG, "onReadRemoteRssi");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i) {
            Log.e(BluetoothLeService.TAG, "onReliableWriteCompleted");
        }
    };
    private final IBinder mBinder = new LocalBinder();

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    public void setReadUUIDAndWriteUUID(String str, String str2, String str3) {
        this.mServerUUID = UUID.fromString(str);
        this.mRread = UUID.fromString(str2);
        this.mWrite = UUID.fromString(str3);
    }

    public void WriteValue(String str) {
        BluetoothGattCharacteristic bluetoothGattCharacteristic = this.mNotifyCharacteristic;
        if (bluetoothGattCharacteristic == null || this.mBluetoothGatt == null) {
            return;
        }
        bluetoothGattCharacteristic.setValue(hex2byte(str.getBytes()));
        this.mBluetoothGatt.writeCharacteristic(this.mNotifyCharacteristic);
    }

    public static byte[] hex2byte(byte[] bArr) {
        if (bArr.length % 2 != 0) {
            throw new IllegalArgumentException("长度不是偶数");
        }
        byte[] bArr2 = new byte[bArr.length / 2];
        for (int i = 0; i < bArr.length; i += 2) {
            bArr2[i / 2] = (byte) Integer.parseInt(new String(bArr, i, 2), 16);
        }
        return bArr2;
    }

    public void findService(List<BluetoothGattService> list) {
        Log.i(TAG, "Count is:" + list.size());
        for (BluetoothGattService bluetoothGattService : list) {
            String str = TAG;
            Log.i(str, bluetoothGattService.getUuid().toString());
            Log.e(str, this.mServerUUID.toString());
            if (bluetoothGattService.getUuid().toString().equalsIgnoreCase(this.mServerUUID.toString())) {
                List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
                Log.i(str, "Count is:" + characteristics.size());
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                    if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(this.mWrite.toString())) {
                        String str2 = TAG;
                        Log.i(str2, bluetoothGattCharacteristic.getUuid().toString());
                        Log.e(str2, this.mWrite.toString() + "  " + this.mRread);
                        this.mNotifyCharacteristic = bluetoothGattCharacteristic;
                        setCharacteristicNotification(bluetoothGattCharacteristic, true);
                        broadcastUpdate(ACTION_GATT_SERVICES_DISCOVERED);
                    } else if (bluetoothGattCharacteristic.getUuid().toString().equalsIgnoreCase(this.mRread.toString())) {
                        Log.e(TAG, "  " + this.mRread);
                        setCharacteristicNotification(bluetoothGattCharacteristic, true);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastUpdate(String str) {
        sendBroadcast(new Intent(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void broadcastUpdate(String str, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        Intent intent = new Intent(str);
        byte[] value = bluetoothGattCharacteristic.getValue();
        if (value != null && value.length > 0) {
            intent.putExtra(EXTRA_DATA, HexString.bufferToHex(value));
        }
        sendBroadcast(intent);
    }

    public class LocalBinder extends Binder {
        BluetoothLeService getService() {
            return BluetoothLeService.this;
        }

        public LocalBinder() {
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        close();
        return super.onUnbind(intent);
    }

    public boolean initialize() {
        if (this.mBluetoothManager == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.mBluetoothManager = bluetoothManager;
            if (bluetoothManager == null) {
                Log.e(TAG, "Unable to initialize BluetoothManager.");
                return false;
            }
        }
        BluetoothAdapter adapter = this.mBluetoothManager.getAdapter();
        this.mBluetoothAdapter = adapter;
        if (adapter != null) {
            return true;
        }
        Log.e(TAG, "Unable to obtain a BluetoothAdapter.");
        return false;
    }

    public boolean connect(String str) {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null || str == null) {
            Log.w(TAG, "BluetoothAdapter not initialized or unspecified address.");
            return false;
        }
        BluetoothDevice remoteDevice = bluetoothAdapter.getRemoteDevice(str);
        if (remoteDevice == null) {
            Log.w(TAG, "Device not found.  Unable to connect.");
            return false;
        }
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.mBluetoothGatt = null;
        }
        this.mBluetoothGatt = remoteDevice.connectGatt(this, false, this.mGattCallback);
        Log.e(TAG, "Trying to create a new connection.");
        return true;
    }

    public void disconnect() {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.disconnect();
        }
    }

    public void close() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return;
        }
        bluetoothGatt.close();
        this.mBluetoothGatt = null;
    }

    public void readCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGatt bluetoothGatt;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
        } else {
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
        }
    }

    public void setCharacteristicNotification(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        BluetoothGatt bluetoothGatt;
        List<BluetoothGattDescriptor> descriptors;
        if (this.mBluetoothAdapter == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
            Log.w(TAG, "BluetoothAdapter not initialized");
            return;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        if (!this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z) || (descriptors = bluetoothGattCharacteristic.getDescriptors()) == null || descriptors.size() <= 0) {
            return;
        }
        for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
            bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
        }
    }

    public List<BluetoothGattService> getSupportedGattServices() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }
}
