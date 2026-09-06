package client.android.yixiaotong.util.bluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.huawei.openalliance.ad.constant.x;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothManager {
    public static BluetoothManager INSTANCE = null;
    public static final int REQUEST_ENABLE_BT = 2001;
    private BluetoothAdapter mBluetoothAdapter;
    private IBluetoothManager mBluetoothManager;
    private Context mContext;
    private Listener mDelegleListener;
    private Set<String> mWaitResponseCommands = new HashSet();
    private Listener mListener = new Listener() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3
        public int leftCount = 0;
        public StringBuilder stringBuilder;

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onConnecting(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onConnecting(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onConnected(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.2
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onConnected(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onDisconnected(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.3
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onDisconnected(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onConnectionFailed(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onConnectionFailed(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onDiscoveryStarted() {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onDiscoveryStarted();
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onDiscoveryFinished() {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onDiscoveryFinished();
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onDeviceFound(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.7
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onDeviceFound(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
        public void onDataReceived(final String str, byte[] bArr) {
            StringBuilder sb;
            String strBufferToHex = HexString.bufferToHex(bArr);
            if ((strBufferToHex.startsWith("55") && strBufferToHex.length() == 40 && !strBufferToHex.startsWith("550001")) || ((strBufferToHex.length() == 18 && strBufferToHex.toUpperCase().startsWith("AA")) || strBufferToHex.toUpperCase().equals("A5") || strBufferToHex.toUpperCase().equals("AC"))) {
                final byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex);
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.8
                    @Override // java.lang.Runnable
                    public void run() {
                        if (BluetoothManager.this.mDelegleListener != null) {
                            BluetoothManager.this.mDelegleListener.onDataReceived(str, bArrHexToBuffer);
                        }
                    }
                });
                return;
            }
            if (strBufferToHex.startsWith("550001") && strBufferToHex.length() >= 8) {
                StringBuilder sb2 = new StringBuilder();
                this.stringBuilder = sb2;
                sb2.append(strBufferToHex);
                byte[] bArrHexToBuffer2 = HexString.hexToBuffer(strBufferToHex.substring(6, 8));
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArrHexToBuffer2, 0, bArr2, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                this.leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) + 1) * 2) - (strBufferToHex.length() - 6);
            } else {
                StringBuilder sb3 = this.stringBuilder;
                if (sb3 != null && sb3.toString().length() >= 8) {
                    this.stringBuilder.append(strBufferToHex);
                    this.leftCount -= strBufferToHex.length();
                } else {
                    StringBuilder sb4 = this.stringBuilder;
                    if (sb4 != null && sb4.toString().length() < 8) {
                        this.stringBuilder.append(strBufferToHex);
                        if (this.stringBuilder.toString().length() >= 8) {
                            byte[] bArrHexToBuffer3 = HexString.hexToBuffer(this.stringBuilder.toString().substring(6, 8));
                            byte[] bArr3 = new byte[4];
                            System.arraycopy(bArrHexToBuffer3, 0, bArr3, 4 - bArrHexToBuffer3.length, bArrHexToBuffer3.length);
                            this.leftCount = ((IntegerUtils.bytesToInt2(bArr3, 0) + 1) * 2) - (this.stringBuilder.toString().length() - 6);
                        }
                    } else {
                        if (!strBufferToHex.startsWith("55") || strBufferToHex.length() >= 8) {
                            return;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        this.stringBuilder = sb5;
                        sb5.append(strBufferToHex);
                        this.leftCount = 1;
                    }
                }
            }
            if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                return;
            }
            String string = sb.toString();
            this.stringBuilder = null;
            final byte[] bArrHexToBuffer4 = HexString.hexToBuffer(string);
            if (CommandUtils.isConnectResult(bArrHexToBuffer4)) {
                if (!BluetoothManager.this.mWaitResponseCommands.contains("f0")) {
                    return;
                } else {
                    BluetoothManager.this.mWaitResponseCommands.remove("f0");
                }
            } else if (CommandUtils.isConfirmResult(bArrHexToBuffer4)) {
                if (!BluetoothManager.this.mWaitResponseCommands.contains("f1")) {
                    return;
                } else {
                    BluetoothManager.this.mWaitResponseCommands.remove("f1");
                }
            } else if (CommandUtils.isAbortResult(bArrHexToBuffer4)) {
                if (!BluetoothManager.this.mWaitResponseCommands.contains("f2")) {
                    return;
                } else {
                    BluetoothManager.this.mWaitResponseCommands.remove("f2");
                }
            } else if (CommandUtils.isSwitchResult(bArrHexToBuffer4)) {
                if (!BluetoothManager.this.mWaitResponseCommands.contains("f3")) {
                    return;
                } else {
                    BluetoothManager.this.mWaitResponseCommands.remove("f3");
                }
            } else if (CommandUtils.isSettingResult(bArrHexToBuffer4)) {
                if (!BluetoothManager.this.mWaitResponseCommands.contains("f4")) {
                    return;
                } else {
                    BluetoothManager.this.mWaitResponseCommands.remove("f4");
                }
            } else if (CommandUtils.isReturnSettingResult(bArrHexToBuffer4)) {
                if (!BluetoothManager.this.mWaitResponseCommands.contains("f5")) {
                    return;
                } else {
                    BluetoothManager.this.mWaitResponseCommands.remove("f5");
                }
            } else if (CommandUtils.isReturnSettingResult(bArrHexToBuffer4)) {
                if (!BluetoothManager.this.mWaitResponseCommands.contains("ff")) {
                    return;
                } else {
                    BluetoothManager.this.mWaitResponseCommands.remove("ff");
                }
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.3.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothManager.this.mDelegleListener != null) {
                        BluetoothManager.this.mDelegleListener.onDataReceived(str, bArrHexToBuffer4);
                    }
                }
            });
        }
    };

    public interface Listener {
        void onConnected(String str);

        void onConnecting(String str);

        void onConnectionFailed(String str);

        void onDataReceived(String str, byte[] bArr);

        void onDeviceFound(String str);

        void onDisconnected(String str);

        void onDiscoveryFinished();

        void onDiscoveryStarted();
    }

    public void setListener(Listener listener) {
        this.mDelegleListener = listener;
    }

    private BluetoothManager(Context context) {
        this.mContext = context;
        if (isBluetoothLeSupported(this.mContext)) {
            android.bluetooth.BluetoothManager bluetoothManager = (android.bluetooth.BluetoothManager) this.mContext.getSystemService("bluetooth");
            this.mBluetoothManager = new BLEManager(this.mContext, this.mListener);
            this.mBluetoothAdapter = bluetoothManager.getAdapter();
        } else {
            this.mBluetoothManager = new BluetoothSocketManager(this.mContext, this.mListener);
            this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
    }

    public static BluetoothManager getInstance() {
        BluetoothManager bluetoothManager = INSTANCE;
        if (bluetoothManager != null) {
            return bluetoothManager;
        }
        throw new RuntimeException("must call init()");
    }

    public static void init(Context context) {
        INSTANCE = new BluetoothManager(context);
    }

    public void startScan() {
        this.mBluetoothManager.startScan(this.mBluetoothAdapter);
    }

    public void stopScan() {
        this.mBluetoothManager.stopScan(this.mBluetoothAdapter);
    }

    public void restartBluetooth() {
        if (isBluetoothLeMode()) {
            this.mBluetoothManager.restartBluetooth(this.mBluetoothAdapter);
        }
    }

    public static String getMac(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 12) {
            return str;
        }
        String[] strArr = new String[6];
        for (int i = 0; i <= 5; i++) {
            int i2 = i * 2;
            strArr[i] = str.substring(i2, i2 + 2);
        }
        String str2 = strArr[0];
        for (int i3 = 1; i3 < 6; i3++) {
            str2 = str2 + x.bQ + strArr[i3];
        }
        return str2.toUpperCase();
    }

    public static String getTrimMac(String str) {
        return TextUtils.isEmpty(str) ? str : str.replaceAll(x.bQ, "").toUpperCase();
    }

    public String convertDeviceAddr(String str) {
        if (str.toLowerCase().startsWith("00:0E:0B".toLowerCase())) {
            return this.mBluetoothManager instanceof BLEManager ? str : "00:0E:0E" + str.substring(8);
        }
        return (str.toLowerCase().startsWith("00:0E:0E".toLowerCase()) && (this.mBluetoothManager instanceof BLEManager)) ? "00:0E:0B" + str.substring(8) : str;
    }

    public void addBluetoothDevice(String str, String str2) {
        this.mBluetoothManager.addBluetoothDevice(this.mBluetoothAdapter, str, str2);
    }

    public BluetoothDevice getBluetoothDevice(String str) {
        return this.mBluetoothManager.getBluetoothDevice(str);
    }

    public void connect(final String str) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.1
            @Override // java.lang.Runnable
            public void run() {
                BluetoothManager.this.mBluetoothManager.connect(BluetoothManager.this.mBluetoothAdapter, str);
            }
        }, 10L);
    }

    public void disConnect(String str) {
        this.mBluetoothManager.disConnect(str);
    }

    public void disConnectAll() {
        this.mBluetoothManager.disConnectAll();
    }

    public void sendData(String str, final String str2, final byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mWaitResponseCommands.add(str);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.util.bluetooth.BluetoothManager.2
            @Override // java.lang.Runnable
            public void run() {
                BluetoothManager.this.mBluetoothManager.sendData(str2, bArr);
            }
        }, 100L);
    }

    public boolean isBond(BluetoothDevice bluetoothDevice) {
        if (isBluetoothLeMode()) {
            return false;
        }
        return ((BluetoothSocketManager) this.mBluetoothManager).isBond(this.mBluetoothAdapter, bluetoothDevice);
    }

    public void askUserToEnableBluetoothIfNeeded(Activity activity) {
        if (isBluetoothOn()) {
            return;
        }
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
    }

    public boolean isBluetoothOn() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            return false;
        }
        return bluetoothAdapter.isEnabled();
    }

    public boolean bluetoothClose() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            return false;
        }
        return bluetoothAdapter.disable();
    }

    public boolean isBluetoothLeMode() {
        return this.mBluetoothManager instanceof BLEManager;
    }

    private static boolean isBluetoothLeSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
}
