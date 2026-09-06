package com.lxt.bluetoothsdk.model;

import java.io.Serializable;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6393804.dex */
public class BluetoothDevice implements Serializable {
    public static final UUID DESCRIPTOR_UUID = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb".toUpperCase());
    private static final long serialVersionUID = 1251002884245331218L;
    public String address;
    public boolean isTimeout;
    public boolean mIsBond;
    public String name;
    public int rssi;
    private UUID[] uuidArrays;

    public String toString() {
        String str = this.address;
        return str == null ? "" : str;
    }

    public BluetoothDevice(String str, String str2, int i) {
        this.uuidArrays = new UUID[1];
        this.name = str;
        this.address = str2;
        this.rssi = i;
    }

    public BluetoothDevice(String str, String str2, int i, boolean z) {
        this.uuidArrays = new UUID[1];
        this.name = str;
        this.address = str2;
        this.rssi = i;
        this.mIsBond = z;
    }

    public boolean equals(Object obj) {
        return toString().equals(obj.toString());
    }

    public UUID[] getBluetoothDeviceAdapter() {
        UUID[] uuidArr = this.uuidArrays;
        uuidArr[0] = DESCRIPTOR_UUID;
        return uuidArr;
    }
}
