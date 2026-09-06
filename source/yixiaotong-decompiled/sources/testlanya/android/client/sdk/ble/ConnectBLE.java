package testlanya.android.client.sdk.ble;

import android.client.bluetoothsdk.BluetoothErrorCode;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import testlanya.android.client.sdk.util.MainThreadExecutor;
import testlanya.android.client.sdk.util.TimeOut;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\7497320.dex */
public class ConnectBLE {
    private BluetoothLeService mBluetoothLeService;
    private ConnectListener mConnectListener;
    private Context mContext;
    TimeOut mCurrentCheckTimeOut;
    private final BroadcastReceiver mGattUpdateReceiver;
    private boolean mIsBind;
    private boolean mIsRunning;
    private String mRead;
    private String mServerUUID;
    private final ServiceConnection mServiceConnection;
    private String mWrite;

    public void setConnectListener(ConnectListener connectListener) {
        this.mConnectListener = connectListener;
    }

    public void setReadUUIDAndWriteUUID(String str, String str2, String str3) {
        this.mServerUUID = str;
        this.mRead = str2;
        this.mWrite = str3;
    }

    private ConnectBLE() {
        this.mIsBind = false;
        this.mIsRunning = false;
        this.mServiceConnection = new ServiceConnection() { // from class: testlanya.android.client.sdk.ble.ConnectBLE.1
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                ConnectBLE.this.mBluetoothLeService = ((BluetoothLeService.LocalBinder) iBinder).getService();
                if (!ConnectBLE.this.mBluetoothLeService.initialize()) {
                    Log.e("test", "Unable to initialize Bluetooth");
                }
                ConnectBLE.this.mIsBind = true;
                Log.e("test", "mBluetoothLeService is okay" + ConnectBLE.this.mServerUUID + "  " + ConnectBLE.this.mRead + "  " + ConnectBLE.this.mWrite);
                ConnectBLE.this.mBluetoothLeService.setReadUUIDAndWriteUUID(ConnectBLE.this.mServerUUID, ConnectBLE.this.mRead, ConnectBLE.this.mWrite);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Log.e("test", "onServiceDisconnected:" + ConnectBLE.this.mBluetoothLeService = null);
                ConnectBLE.this.mBluetoothLeService = null;
            }
        };
        this.mGattUpdateReceiver = new BroadcastReceiver() { // from class: testlanya.android.client.sdk.ble.ConnectBLE.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                Log.e("test", action);
                if (BluetoothLeService.ACTION_GATT_CONNECTED.equals(action)) {
                    ConnectBLE.this.mIsRunning = false;
                    return;
                }
                if (BluetoothLeService.ACTION_GATT_DISCONNECTED.equals(action)) {
                    ConnectBLE.this.mIsRunning = false;
                    ConnectBLE.this.mConnectListener.onConnectFail("蓝牙已断开");
                } else if (BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED.equals(action)) {
                    ConnectBLE.this.mIsRunning = false;
                    ConnectBLE.this.mCurrentCheckTimeOut = null;
                    ConnectBLE.this.mConnectListener.onConnectSuccess();
                } else if (BluetoothLeService.ACTION_DATA_AVAILABLE.equals(action)) {
                    ConnectBLE.this.mConnectListener.onReceivedData(intent.getStringExtra(BluetoothLeService.EXTRA_DATA));
                }
            }
        };
    }

    public static ConnectBLE getInstance() {
        return SingleHolder.INSTANCE;
    }

    private static class SingleHolder {
        private static ConnectBLE INSTANCE = new ConnectBLE();

        private SingleHolder() {
        }
    }

    public void init(Context context, String str, String str2, String str3) {
        this.mContext = context;
        Intent intent = new Intent(this.mContext, (Class<?>) BluetoothLeService.class);
        Log.e("test", (this.mServiceConnection != null) + "");
        this.mContext.bindService(intent, this.mServiceConnection, 1);
        this.mContext.registerReceiver(this.mGattUpdateReceiver, makeGattUpdateIntentFilter());
        this.mServerUUID = str;
        this.mRead = str2;
        this.mWrite = str3;
    }

    public void connect(String str) {
        Log.e("test", "开始连接" + (this.mBluetoothLeService != null));
        if (this.mBluetoothLeService == null || this.mIsRunning) {
            return;
        }
        this.mIsRunning = true;
        checkTimeOut(TimeOut.Connect, 10000);
        this.mBluetoothLeService.connect(str);
    }

    public void sendData(String str) {
        if (str.trim() == null || str.trim().length() == 0 || this.mBluetoothLeService == null) {
            return;
        }
        int length = str.length() / 40;
        int length2 = str.length() % 40;
        for (int i = 0; i < length; i++) {
            try {
                Thread.sleep(30L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i2 = i * 40;
            int i3 = i2 + 40;
            Log.e("test", "发送数据1:" + str.substring(i2, i3));
            this.mBluetoothLeService.WriteValue(str.substring(i2, i3));
        }
        if (length2 != 0) {
            try {
                Thread.sleep(30L);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
            int i4 = length * 40;
            Log.e("test", "发送数据2:" + str.substring(i4, str.length()));
            this.mBluetoothLeService.WriteValue(str.substring(i4, str.length()));
        }
    }

    public void disConnect() {
        this.mIsRunning = false;
        this.mCurrentCheckTimeOut = null;
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            bluetoothLeService.disconnect();
        }
    }

    public void closeBLE() {
        this.mIsRunning = false;
        this.mCurrentCheckTimeOut = null;
        ServiceConnection serviceConnection = this.mServiceConnection;
        if (serviceConnection != null && this.mGattUpdateReceiver != null && this.mIsBind) {
            this.mIsBind = false;
            this.mContext.unbindService(serviceConnection);
            this.mContext.unregisterReceiver(this.mGattUpdateReceiver);
        }
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            bluetoothLeService.close();
            this.mBluetoothLeService = null;
            Log.e("test", "closeBLE:null");
            this.mBluetoothLeService = null;
        }
    }

    private static IntentFilter makeGattUpdateIntentFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_CONNECTED);
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_DISCONNECTED);
        intentFilter.addAction(BluetoothLeService.ACTION_GATT_SERVICES_DISCOVERED);
        intentFilter.addAction(BluetoothLeService.ACTION_DATA_AVAILABLE);
        intentFilter.addAction("android.bluetooth.device.action.UUID");
        return intentFilter;
    }

    private void checkTimeOut(TimeOut timeOut, int i) {
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
            Log.e("test", BluetoothErrorCode.CONNECTTIMEOUTMSG + ConnectBLE.this.mCurrentCheckTimeOut);
            if (TimeOut.Connect == ConnectBLE.this.mCurrentCheckTimeOut) {
                ConnectBLE.this.disConnect();
                ConnectBLE.this.mConnectListener.onConnectFail(BluetoothErrorCode.CONNECTTIMEOUTMSG);
            }
        }
    }
}
