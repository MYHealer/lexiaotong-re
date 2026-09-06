package client.android.yixiaotong.util.bluetooth;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothDevice implements Serializable {
    public static final String DEFAULT_DEVICEHEXID = "00000000000000000000";
    public static final String DEFAULT_DEVICEHEXNO = "00000000";
    private static final long serialVersionUID = 1251002884245331218L;
    public String mAddress;
    private BluetoothGatt mBluetoothGatt;
    public String mName;
    private BluetoothGattCharacteristic mReadBluetoothGattCharacteristic;
    private BluetoothGattCharacteristic mReadWriteBluetoothGattCharacteristic;
    public int mRssi;
    public String mDeviceHexNo = DEFAULT_DEVICEHEXNO;
    public String mDeviceHexID = DEFAULT_DEVICEHEXID;
    public int mDeviceTypeId = -1;
    private final List<BluetoothGattCharacteristic> mBluetoothGattCharacteristics = new ArrayList();

    public BluetoothGatt getBluetoothGatt() {
        return this.mBluetoothGatt;
    }

    public BluetoothGattCharacteristic getReadBluetoothGattCharacteristic() {
        return this.mReadBluetoothGattCharacteristic;
    }

    public BluetoothGattCharacteristic getReadWriteBluetoothGattCharacteristic() {
        return this.mReadWriteBluetoothGattCharacteristic;
    }

    public void setBluetoothGatt(BluetoothGatt bluetoothGatt) {
        this.mBluetoothGatt = bluetoothGatt;
    }

    public void setReadBluetoothGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mReadBluetoothGattCharacteristic = bluetoothGattCharacteristic;
    }

    public void setReadWriteBluetoothGattCharacteristic(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.mReadWriteBluetoothGattCharacteristic = bluetoothGattCharacteristic;
    }

    public String toString() {
        String str = this.mAddress;
        return str == null ? "" : str;
    }

    public BluetoothDevice(String str, String str2) {
        this.mName = str;
        this.mAddress = str2;
    }

    public BluetoothDevice(String str, String str2, int i) {
        this.mName = str;
        this.mAddress = str2;
        this.mRssi = i;
    }

    public boolean isMe(String str) {
        String str2 = this.mAddress;
        return str2 != null && str2.equals(BluetoothManager.getInstance().convertDeviceAddr(str));
    }

    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }

    public void setAllBluetoothGattCharacteristic(List<BluetoothGattCharacteristic> list) {
        this.mBluetoothGattCharacteristics.clear();
        if (list == null || list.isEmpty()) {
            return;
        }
        this.mBluetoothGattCharacteristics.addAll(list);
    }

    public List<BluetoothGattCharacteristic> getAllBluetoothGattCharacteristic() {
        return new ArrayList(this.mBluetoothGattCharacteristics);
    }
}
