package client.android.yixiaotong.util.ammeterbluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterBluetoothUtils {
    private static final String UUIDDes = "00002902-0000-1000-8000-00805f9b34fb";
    private static final int qppServerBufferSize = 20;
    private static BluetoothGattCharacteristic writeCharacteristic;
    private static ArrayList<BluetoothGattCharacteristic> arrayNtfCharList = new ArrayList<>();
    private static String uuidQppService = "0000fee9-0000-1000-8000-00805f9b34fb";
    private static String uuidQppCharWrite = "d44bc439-abfd-45a2-b575-925416129600";
    private static byte notifyCharaIndex = 0;
    private static String TAG = "AmmeterBluetoothUtils";

    private static void resetQppField() {
        writeCharacteristic = null;
        arrayNtfCharList.clear();
        notifyCharaIndex = (byte) 0;
    }

    public static boolean qppEnable(BluetoothGatt bluetoothGatt, String str, String str2) {
        resetQppField();
        if (str != null) {
            uuidQppService = str;
        }
        if (str2 != null) {
            uuidQppCharWrite = str2;
        }
        if (bluetoothGatt == null || str.isEmpty() || str2.isEmpty()) {
            Log.e(TAG, "invalid arguments");
            return false;
        }
        BluetoothGattService service = bluetoothGatt.getService(UUID.fromString(str));
        if (service == null) {
            return false;
        }
        List<BluetoothGattCharacteristic> characteristics = service.getCharacteristics();
        for (int i = 0; i < characteristics.size(); i++) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = characteristics.get(i);
            if (bluetoothGattCharacteristic.getUuid().toString().equals(str2)) {
                writeCharacteristic = bluetoothGattCharacteristic;
            } else if (bluetoothGattCharacteristic.getProperties() == 16) {
                arrayNtfCharList.add(bluetoothGattCharacteristic);
            }
        }
        if (!setCharacteristicNotification(bluetoothGatt, arrayNtfCharList.get(0), true)) {
            return false;
        }
        notifyCharaIndex = (byte) (notifyCharaIndex + 1);
        return true;
    }

    public static boolean qppSendData(BluetoothGatt bluetoothGatt, byte[] bArr) {
        if (bluetoothGatt == null) {
            Log.e(TAG, "qppSendData BluetoothAdapter not initialized !");
            return false;
        }
        if (bArr == null) {
            Log.e(TAG, "qppSendData qppData = null !");
            return false;
        }
        int length = bArr.length;
        if (length <= 20) {
            return writeValue(bluetoothGatt, writeCharacteristic, bArr);
        }
        int i = 0;
        boolean z = false;
        while (i < length) {
            int i2 = length - i;
            if (i2 >= 20) {
                i2 = 20;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            boolean zWriteValue = writeValue(bluetoothGatt, writeCharacteristic, bArr2);
            if (!zWriteValue) {
                return zWriteValue;
            }
            i += i2;
            z = zWriteValue;
        }
        return z;
    }

    private static boolean writeValue(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        if (bluetoothGatt == null) {
            Log.e(TAG, "BluetoothAdapter not initialized");
            return false;
        }
        if (bluetoothGattCharacteristic == null) {
            Log.e(TAG, "characteristic not initialized");
            return false;
        }
        bluetoothGattCharacteristic.setValue(bArr);
        return bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    public static boolean setQppNextNotify(BluetoothGatt bluetoothGatt, boolean z) {
        if (notifyCharaIndex == arrayNtfCharList.size()) {
            return true;
        }
        ArrayList<BluetoothGattCharacteristic> arrayList = arrayNtfCharList;
        byte b = notifyCharaIndex;
        notifyCharaIndex = (byte) (b + 1);
        return setCharacteristicNotification(bluetoothGatt, arrayList.get(b), z);
    }

    private static boolean setCharacteristicNotification(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        if (bluetoothGatt == null) {
            Log.e(TAG, "BluetoothAdapter not initialized");
            return false;
        }
        bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z);
        try {
            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(UUIDDes));
            if (descriptor != null) {
                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                return bluetoothGatt.writeDescriptor(descriptor);
            }
            Log.e(TAG, "descriptor is null");
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return true;
        } catch (NullPointerException e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
