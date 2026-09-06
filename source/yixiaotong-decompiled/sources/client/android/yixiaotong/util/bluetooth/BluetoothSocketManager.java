package client.android.yixiaotong.util.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.text.TextUtils;
import client.android.yixiaotong.sdk.bluetooth.socket.Device;
import client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth;
import client.android.yixiaotong.util.executor.AsyncExecutor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothSocketManager implements IBluetoothManager {
    private static final Map<String, Device> mBlueDeviceMap = new HashMap();
    private static final Map<String, BluetoothDevice> mDeviceMap = new HashMap();
    private BluetoothManager.Listener mBluetoothManagerListener;
    private Context mContext;
    private SmoothBluetooth mSmoothBluetooth;
    private SmoothBluetoothListener mSmoothBluetoothListener = new SmoothBluetoothListener(null);

    public BluetoothSocketManager(Context context, BluetoothManager.Listener listener) {
        this.mContext = context;
        this.mBluetoothManagerListener = listener;
        this.mSmoothBluetooth = new SmoothBluetooth(this.mContext, this.mSmoothBluetoothListener);
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void startScan(BluetoothAdapter bluetoothAdapter) {
        Iterator<String> it = mDeviceMap.keySet().iterator();
        while (it.hasNext()) {
            disConnect(mDeviceMap.get(it.next()).mAddress);
        }
        this.mSmoothBluetooth.cancelDiscovery();
        this.mSmoothBluetooth.startDiscovery();
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void stopScan(BluetoothAdapter bluetoothAdapter) {
        this.mSmoothBluetooth.cancelDiscovery();
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void restartBluetooth(final BluetoothAdapter bluetoothAdapter) {
        bluetoothAdapter.disable();
        AsyncExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothSocketManager.1
            @Override // java.lang.Runnable
            public void run() {
                bluetoothAdapter.enable();
            }
        }, 500L);
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void addBluetoothDevice(BluetoothAdapter bluetoothAdapter, String str, String str2) {
        Map<String, BluetoothDevice> map = mDeviceMap;
        if (!map.containsKey(str2)) {
            map.put(str2, new BluetoothDevice(str, str2));
        }
        Map<String, Device> map2 = mBlueDeviceMap;
        if (map2.containsKey(str2)) {
            return;
        }
        map2.put(str2, new Device(str, str2, isBond(bluetoothAdapter, map.get(str2))));
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void connect(BluetoothAdapter bluetoothAdapter, String str) {
        if (TextUtils.isEmpty(str) || bluetoothAdapter.getRemoteDevice(str) == null) {
            return;
        }
        this.mSmoothBluetooth.cancelDiscovery();
        Device device = mBlueDeviceMap.get(str);
        if (device != null) {
            SmoothBluetoothListener smoothBluetoothListener = new SmoothBluetoothListener(device);
            this.mSmoothBluetoothListener = smoothBluetoothListener;
            this.mSmoothBluetooth.setListener(smoothBluetoothListener);
            this.mSmoothBluetooth.connect(device);
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void disConnectAll() {
        this.mSmoothBluetooth.disconnect();
        this.mSmoothBluetoothListener = new SmoothBluetoothListener(null);
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void disConnect(String str) {
        this.mSmoothBluetooth.disconnect();
        this.mSmoothBluetoothListener = new SmoothBluetoothListener(null);
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public void sendData(String str, byte[] bArr) {
        SmoothBluetooth smoothBluetooth = this.mSmoothBluetooth;
        if (smoothBluetooth == null) {
            return;
        }
        smoothBluetooth.send(bArr);
    }

    @Override // client.android.yixiaotong.util.bluetooth.IBluetoothManager
    public BluetoothDevice getBluetoothDevice(String str) {
        return mDeviceMap.get(str);
    }

    public boolean isBond(BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
        android.bluetooth.BluetoothDevice remoteDevice;
        return (bluetoothDevice == null || bluetoothDevice.mAddress == null || (remoteDevice = bluetoothAdapter.getRemoteDevice(bluetoothDevice.mAddress)) == null || remoteDevice.getBondState() != 12) ? false : true;
    }

    private final class SmoothBluetoothListener implements SmoothBluetooth.Listener {
        public boolean isConnected;
        public final Device mCurrentDevice;

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotEnabled() {
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onBluetoothNotSupported() {
        }

        public SmoothBluetoothListener(Device device) {
            this.mCurrentDevice = device;
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnecting(Device device) {
            if (device == null) {
                device = this.mCurrentDevice;
            }
            if (device == null) {
                return;
            }
            this.isConnected = false;
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothSocketManager.this.mBluetoothManagerListener.onConnecting(device.getAddress());
            }
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnected(Device device) {
            if (device == null) {
                device = this.mCurrentDevice;
            }
            if (device == null) {
                return;
            }
            this.isConnected = true;
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothSocketManager.this.mBluetoothManagerListener.onConnected(device.getAddress());
            }
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDisconnected() {
            this.isConnected = false;
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothManager.Listener listener = BluetoothSocketManager.this.mBluetoothManagerListener;
                Device device = this.mCurrentDevice;
                listener.onDisconnected(device != null ? device.getAddress() : "");
            }
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onConnectionFailed(Device device) {
            if (device == null) {
                device = this.mCurrentDevice;
            }
            if (device == null) {
                return;
            }
            this.isConnected = false;
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothSocketManager.this.mBluetoothManagerListener.onConnectionFailed(device.getAddress());
            }
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryStarted() {
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothSocketManager.this.mBluetoothManagerListener.onDiscoveryStarted();
            }
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDiscoveryFinished() {
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothSocketManager.this.mBluetoothManagerListener.onDiscoveryFinished();
            }
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDeviceFound(Device device) {
            if (device == null) {
                return;
            }
            if (!BluetoothSocketManager.mDeviceMap.containsKey(device.getAddress())) {
                BluetoothSocketManager.mDeviceMap.put(device.getAddress(), new BluetoothDevice(device.getName(), device.getAddress()));
            }
            if (!BluetoothSocketManager.mBlueDeviceMap.containsKey(device.getAddress())) {
                BluetoothSocketManager.mBlueDeviceMap.put(device.getAddress(), device);
            }
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothSocketManager.this.mBluetoothManagerListener.onDeviceFound(device.getAddress());
            }
        }

        @Override // client.android.yixiaotong.sdk.bluetooth.socket.SmoothBluetooth.Listener
        public void onDataReceived(byte[] bArr) {
            if (BluetoothSocketManager.this.mBluetoothManagerListener != null) {
                BluetoothManager.Listener listener = BluetoothSocketManager.this.mBluetoothManagerListener;
                Device device = this.mCurrentDevice;
                listener.onDataReceived(device != null ? device.getAddress() : "", bArr);
            }
        }
    }
}
