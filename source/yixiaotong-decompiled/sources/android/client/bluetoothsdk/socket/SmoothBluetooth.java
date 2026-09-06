package android.client.bluetoothsdk.socket;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.huawei.openalliance.ad.views.PPSLabelView;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SmoothBluetooth {
    private static final String TAG = "BluetoothManager";
    private boolean isConnected;
    private boolean isConnecting;
    private boolean isServiceRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothService mBluetoothService;
    private final Context mContext;
    private Device mCurrentDevice;
    private ArrayList<Device> mDevices;
    private final Handler mHandler;
    private boolean mIsAndroid;
    private boolean mIsSecure;
    private Listener mListener;
    private final BroadcastReceiver mReceiver;

    public enum Connection {
        SECURE,
        INSECURE
    }

    public interface ConnectionCallback {
        void connectTo(Device device);
    }

    public enum ConnectionTo {
        ANDROID_DEVICE,
        OTHER_DEVICE
    }

    public interface Listener {
        void onBluetoothNotEnabled();

        void onBluetoothNotSupported();

        void onConnected(Device device);

        void onConnecting(Device device);

        void onConnectionFailed(Device device);

        void onDataReceived(byte[] bArr);

        void onDeviceFound(Device device);

        void onDisconnected();

        void onDiscoveryFinished();

        void onDiscoveryStarted();
    }

    public BluetoothAdapter getBluetoothAdapter() {
        return this.mBluetoothAdapter;
    }

    public boolean isConnected() {
        return this.mCurrentDevice != null;
    }

    public boolean isServiceAvailable() {
        return this.mBluetoothService != null;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
    }

    public SmoothBluetooth(Context context) {
        this(context, ConnectionTo.OTHER_DEVICE, Connection.SECURE, null);
    }

    public SmoothBluetooth(Context context, Listener listener) {
        this(context, ConnectionTo.OTHER_DEVICE, Connection.SECURE, listener);
    }

    public SmoothBluetooth(Context context, ConnectionTo connectionTo, Connection connection, Listener listener) {
        this.mDevices = new ArrayList<>();
        this.mReceiver = new BroadcastReceiver() { // from class: android.client.bluetoothsdk.socket.SmoothBluetooth.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                if ("android.bluetooth.device.action.FOUND".equals(action)) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                    Log.d(SmoothBluetooth.TAG, "Device found: " + bluetoothDevice.getName() + PPSLabelView.Code + bluetoothDevice.getAddress());
                    if (SmoothBluetooth.this.deviceExist(bluetoothDevice)) {
                        return;
                    }
                    Device device = new Device(bluetoothDevice.getName(), bluetoothDevice.getAddress(), false);
                    SmoothBluetooth.this.mDevices.add(device);
                    SmoothBluetooth.this.connectAction(device);
                    return;
                }
                if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                    Log.d(SmoothBluetooth.TAG, "Discovery finished: " + SmoothBluetooth.this.mDevices.size());
                    SmoothBluetooth.this.mContext.unregisterReceiver(SmoothBluetooth.this.mReceiver);
                    if (SmoothBluetooth.this.mListener != null) {
                        SmoothBluetooth.this.mListener.onDiscoveryFinished();
                    }
                }
            }
        };
        this.mHandler = new Handler() { // from class: android.client.bluetoothsdk.socket.SmoothBluetooth.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i != 1) {
                    if (i == 2) {
                        byte[] bArr = (byte[]) message.obj;
                        if (SmoothBluetooth.this.mListener != null) {
                            SmoothBluetooth.this.mListener.onDataReceived(bArr);
                            return;
                        }
                        return;
                    }
                    if (i != 4) {
                        return;
                    }
                    if (SmoothBluetooth.this.mListener != null) {
                        SmoothBluetooth.this.mListener.onConnected(SmoothBluetooth.this.mCurrentDevice);
                    }
                    SmoothBluetooth.this.isConnected = true;
                    return;
                }
                if (SmoothBluetooth.this.isConnected && message.arg1 != 3) {
                    SmoothBluetooth.this.isConnected = false;
                    if (SmoothBluetooth.this.mListener != null) {
                        SmoothBluetooth.this.mListener.onDisconnected();
                        SmoothBluetooth.this.mCurrentDevice = null;
                    }
                }
                if (SmoothBluetooth.this.isConnecting || message.arg1 != 2) {
                    if (SmoothBluetooth.this.isConnecting) {
                        SmoothBluetooth.this.isConnecting = false;
                        if (message.arg1 == 3 || SmoothBluetooth.this.mListener == null) {
                            return;
                        }
                        SmoothBluetooth.this.mListener.onConnectionFailed(SmoothBluetooth.this.mCurrentDevice);
                        SmoothBluetooth.this.mCurrentDevice = null;
                        return;
                    }
                    return;
                }
                SmoothBluetooth.this.isConnecting = true;
            }
        };
        this.mContext = context;
        this.mListener = listener;
        this.mIsAndroid = connectionTo == ConnectionTo.ANDROID_DEVICE;
        this.mIsSecure = connection == Connection.SECURE;
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    private boolean checkBluetooth() {
        if (!isBluetoothAvailable()) {
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onBluetoothNotSupported();
            }
            return false;
        }
        if (isBluetoothEnabled()) {
            return true;
        }
        Listener listener2 = this.mListener;
        if (listener2 != null) {
            listener2.onBluetoothNotEnabled();
        }
        return false;
    }

    public boolean isBluetoothAvailable() {
        try {
            BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
            return (bluetoothAdapter == null || bluetoothAdapter.getAddress().equals(null)) ? false : true;
        } catch (NullPointerException unused) {
            return false;
        }
    }

    public boolean isBluetoothEnabled() {
        return this.mBluetoothAdapter.isEnabled();
    }

    public boolean startDiscovery() {
        return this.mBluetoothAdapter.startDiscovery();
    }

    public boolean isDiscovery() {
        return this.mBluetoothAdapter.isDiscovering();
    }

    public boolean cancelDiscovery() {
        return this.mBluetoothAdapter.cancelDiscovery();
    }

    public void connect(Device device) {
        connect(device, this.mIsAndroid, this.mIsSecure);
    }

    private void connect(Device device, boolean z, boolean z2) {
        this.mCurrentDevice = device;
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onConnecting(device);
        }
        connect(device.getAddress(), z, z2);
    }

    public void doDiscovery() {
        if (checkBluetooth()) {
            this.mCurrentDevice = null;
            this.mDevices.clear();
            Listener listener = this.mListener;
            if (listener != null) {
                listener.onDiscoveryStarted();
            }
            Log.d(TAG, "doDiscovery()");
            if (isDiscovery()) {
                this.mContext.unregisterReceiver(this.mReceiver);
                cancelDiscovery();
            }
            this.mContext.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.device.action.FOUND"));
            this.mContext.registerReceiver(this.mReceiver, new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED"));
            startDiscovery();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectAction(Device device) {
        Listener listener = this.mListener;
        if (listener != null) {
            listener.onDeviceFound(device);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean deviceExist(BluetoothDevice bluetoothDevice) {
        Iterator<Device> it = this.mDevices.iterator();
        while (it.hasNext()) {
            if (it.next().getAddress().contains(bluetoothDevice.getAddress())) {
                return true;
            }
        }
        return false;
    }

    private void setupService() {
        this.mBluetoothService = new BluetoothService(this.mHandler);
    }

    private void startService(boolean z, boolean z2) {
        if (isServiceAvailable() && this.mBluetoothService.getState() == 0) {
            this.isServiceRunning = true;
            this.mBluetoothService.start(z, z2);
        }
    }

    public void stop() {
        this.mCurrentDevice = null;
        if (isServiceAvailable()) {
            this.isServiceRunning = false;
            this.mBluetoothService.stop();
        }
        new Handler().postDelayed(new Runnable() { // from class: android.client.bluetoothsdk.socket.SmoothBluetooth.2
            @Override // java.lang.Runnable
            public void run() {
                if (SmoothBluetooth.this.isServiceAvailable()) {
                    SmoothBluetooth.this.isServiceRunning = false;
                    SmoothBluetooth.this.mBluetoothService.stop();
                }
            }
        }, 500L);
    }

    private void connect(String str, boolean z, boolean z2) {
        if (this.isConnecting) {
            return;
        }
        if (!isServiceAvailable()) {
            setupService();
        }
        startService(z, z2);
        if (BluetoothAdapter.checkBluetoothAddress(str)) {
            this.mBluetoothService.connect(this.mBluetoothAdapter.getRemoteDevice(str));
        }
    }

    public void disconnect() {
        this.mCurrentDevice = null;
        if (isServiceAvailable()) {
            this.isServiceRunning = false;
            this.mBluetoothService.stop();
            if (this.mBluetoothService.getState() == 0) {
                this.isServiceRunning = true;
                this.mBluetoothService.start(this.mIsAndroid, this.mIsSecure);
            }
        }
    }

    public void send(String str) {
        send(str, false);
    }

    public void send(byte[] bArr) {
        send(bArr, false);
    }

    public void send(byte[] bArr, boolean z) {
        if (isServiceAvailable() && this.mBluetoothService.getState() == 3) {
            if (z) {
                int length = bArr.length + 2;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr2[length] = 10;
                bArr2[length] = 13;
                this.mBluetoothService.write(bArr2);
                return;
            }
            this.mBluetoothService.write(bArr);
        }
    }

    public void send(String str, boolean z) {
        if (isServiceAvailable() && this.mBluetoothService.getState() == 3) {
            if (z) {
                str = str + IOUtils.LINE_SEPARATOR_WINDOWS;
            }
            this.mBluetoothService.write(str.getBytes());
        }
    }
}
