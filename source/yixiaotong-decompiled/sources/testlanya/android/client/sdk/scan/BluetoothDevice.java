package testlanya.android.client.sdk.scan;

import java.io.Serializable;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class BluetoothDevice implements Serializable {
    public static final UUID DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb".toUpperCase());
    public String address;
    public String name;
    public int rssi;

    public String toString() {
        String str = this.address;
        return str == null ? "" : str;
    }

    public BluetoothDevice(String str, String str2, int i) {
        this.name = str;
        this.address = str2;
        this.rssi = i;
    }

    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }
}
