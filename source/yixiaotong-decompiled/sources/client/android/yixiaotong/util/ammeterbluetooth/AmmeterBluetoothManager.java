package client.android.yixiaotong.util.ammeterbluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterDes;
import client.android.yixiaotong.util.ammeterutil.IntegerUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.washutil.WashBluetoothUtil;
import client.android.yixiaotong.util.washutil.WashDes;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterBluetoothManager {
    public static AmmeterBluetoothManager INSTANCE = null;
    private static final int REQUEST_ENABLE_BT = 1;
    protected static final String TAG = "AmmeterBluetoothManager";
    private BluetoothAdapter mBluetoothAdapter;
    private Context mContext;
    private Listener mDelegleListener;
    private IAmmeterBluetoothManager mDianBiaoBluetoothManager;
    private int mAppType = 7;
    private Listener mListener = new AnonymousClass2();

    public interface Listener {
        void onBLEState(boolean z);

        void onConnectState(String str, boolean z);

        void onConnected(String str, boolean z);

        void onConnecting(String str);

        void onConnectionFailed(String str);

        void onDataReceived(String str, byte[] bArr);

        void onDeviceFound(String str);

        void onDisconnected(String str);

        void onDiscoveryFinished();

        void onDiscoveryStarted();

        void onSendDataFailed();
    }

    public int getAppType() {
        return this.mAppType;
    }

    public void setAppType(int i) {
        this.mAppType = i;
    }

    public void setListener(Listener listener) {
        this.mDelegleListener = listener;
    }

    public static AmmeterBluetoothManager getInstance() {
        AmmeterBluetoothManager ammeterBluetoothManager = INSTANCE;
        if (ammeterBluetoothManager != null) {
            return ammeterBluetoothManager;
        }
        throw new RuntimeException("must call init()");
    }

    public void BLEConnectState() {
        this.mDianBiaoBluetoothManager.bleConnectState();
    }

    public static void init(Context context) {
        INSTANCE = new AmmeterBluetoothManager(context);
    }

    public AmmeterBluetoothManager(Context context) {
        this.mContext = context;
        this.mDianBiaoBluetoothManager = new AmmeterBLEManager(this.mContext, this.mListener);
        this.mBluetoothAdapter = ((BluetoothManager) this.mContext.getSystemService("bluetooth")).getAdapter();
    }

    public void startScan() {
        this.mDianBiaoBluetoothManager.startScan(this.mBluetoothAdapter);
    }

    public void stopScan() {
        this.mDianBiaoBluetoothManager.stopScan(this.mBluetoothAdapter);
    }

    public void restartBluetooth() {
        this.mDianBiaoBluetoothManager.restartBluetooth(this.mBluetoothAdapter);
    }

    public void addAmmeterBluetoothDevice(String str, String str2, int i) {
        this.mDianBiaoBluetoothManager.addBluetoothDevice(this.mBluetoothAdapter, str, str2, i);
    }

    public AmmeterBluetoothDevice getAmmeterBluetoothDevice(String str) {
        return this.mDianBiaoBluetoothManager.getBluetoothDevice(str);
    }

    public void connect(final String str) {
        this.mDianBiaoBluetoothManager.disConnect(str);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.1
            @Override // java.lang.Runnable
            public void run() {
                AmmeterBluetoothManager.this.mDianBiaoBluetoothManager.connect(AmmeterBluetoothManager.this.mBluetoothAdapter, str);
            }
        }, 800L);
    }

    public void disConnect(String str) {
        this.mDianBiaoBluetoothManager.disConnect(str);
    }

    public void disConnectAll() {
        this.mDianBiaoBluetoothManager.disConnectAll();
    }

    public void sendData(String str, byte[] bArr) {
        this.mDianBiaoBluetoothManager.sendData(str, bArr);
    }

    public void askUserToEnableBluetoothIfNeeded(Activity activity) {
        if (isBluetoothOn()) {
            return;
        }
        activity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 1);
    }

    public boolean isBluetoothOn() {
        BluetoothAdapter bluetoothAdapter = this.mBluetoothAdapter;
        if (bluetoothAdapter == null) {
            return false;
        }
        return bluetoothAdapter.isEnabled();
    }

    private static boolean isBluetoothLeSupported(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager$2, reason: invalid class name */
    class AnonymousClass2 implements Listener {
        public int leftCount = 0;
        public StringBuilder stringBuilder;

        AnonymousClass2() {
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onConnecting(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.1
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onConnecting(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onConnected(final String str, final boolean z) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.2
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onConnected(str, z);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onDisconnected(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.3
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onDisconnected(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onConnectionFailed(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.4
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onConnectionFailed(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onDiscoveryStarted() {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.5
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onDiscoveryStarted();
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onDiscoveryFinished() {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.6
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onDiscoveryFinished();
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onDeviceFound(final String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.7
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onDeviceFound(str);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onDataReceived(final String str, byte[] bArr) {
            StringBuilder sb;
            String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
            Log.e("test", AmmeterBluetoothManager.this.mAppType + "msg:" + strBufferToHex);
            if (AmmeterBluetoothManager.this.mAppType != 7) {
                if (AmmeterBluetoothManager.this.mAppType == 3) {
                    if (strBufferToHex.toUpperCase().startsWith("A1") || strBufferToHex.toUpperCase().startsWith("A2") || strBufferToHex.toUpperCase().startsWith("A3") || (strBufferToHex.toUpperCase().startsWith("A5") && strBufferToHex.length() >= 4 && this.leftCount == 0)) {
                        StringBuilder sb2 = new StringBuilder();
                        this.stringBuilder = sb2;
                        sb2.append(strBufferToHex);
                        byte[] bArrHexToBuffer = AmmeterBluetoothDevice.HexString.hexToBuffer(strBufferToHex.substring(2, 4));
                        byte[] bArr2 = new byte[4];
                        System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                        this.leftCount = (IntegerUtils.bytesToInt2(bArr2, 0) * 2) - (strBufferToHex.length() - 4);
                    } else {
                        StringBuilder sb3 = this.stringBuilder;
                        if (sb3 == null) {
                            return;
                        }
                        sb3.append(strBufferToHex);
                        this.leftCount -= strBufferToHex.length();
                    }
                    if (this.leftCount > 0 || this.stringBuilder == null || TextUtils.isEmpty(str)) {
                        return;
                    }
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.9
                        @Override // java.lang.Runnable
                        public void run() {
                            if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                                if (!WashBluetoothUtil.isReceiveDataFormat(HexString.hexToBuffer(AnonymousClass2.this.stringBuilder.toString()))) {
                                    AmmeterBluetoothManager.this.mDelegleListener.onDataReceived(str, HexString.hexToBuffer("00"));
                                    return;
                                }
                                String strSubstring = AnonymousClass2.this.stringBuilder.substring(4, AnonymousClass2.this.stringBuilder.length() - 2);
                                String strDeDes = WashDes.deDes(strSubstring);
                                Log.e("test", ((Object) AnonymousClass2.this.stringBuilder) + "  " + strSubstring + "  " + strDeDes);
                                AmmeterBluetoothManager.this.mDelegleListener.onDataReceived(str, AmmeterBluetoothDevice.HexString.hexToBuffer(AnonymousClass2.this.stringBuilder.substring(0, 2) + strDeDes));
                            }
                        }
                    });
                    return;
                }
                return;
            }
            if (!strBufferToHex.toUpperCase().startsWith("A5") || strBufferToHex.length() < 4) {
                StringBuilder sb4 = this.stringBuilder;
                if (sb4 == null) {
                    return;
                }
                sb4.append(strBufferToHex);
                this.leftCount -= strBufferToHex.length();
            } else {
                StringBuilder sb5 = new StringBuilder();
                this.stringBuilder = sb5;
                sb5.append(strBufferToHex);
                byte[] bArrHexToBuffer2 = AmmeterBluetoothDevice.HexString.hexToBuffer(strBufferToHex.substring(2, 4));
                byte[] bArr3 = new byte[4];
                System.arraycopy(bArrHexToBuffer2, 0, bArr3, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                this.leftCount = (IntegerUtils.bytesToInt2(bArr3, 0) * 2) - (strBufferToHex.length() - 4);
            }
            if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                return;
            }
            String string = sb.toString();
            this.stringBuilder = null;
            final String strSubstring = string.substring(4, string.length() - 2);
            final byte[] bArrHexToBuffer3 = AmmeterBluetoothDevice.HexString.hexToBuffer(string);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.8
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        if (!AmmeterCommandUtils.isReceiveDataFormat(bArrHexToBuffer3)) {
                            ToastUtils.show(AmmeterBluetoothManager.this.mContext, "电表传给APP的数据有问题");
                            return;
                        }
                        String strDeDes = AmmeterDes.deDes(strSubstring);
                        if (StringUtils.isNotEmpty(strDeDes)) {
                            AmmeterBluetoothManager.this.mDelegleListener.onDataReceived(str, AmmeterBluetoothDevice.HexString.hexToBuffer(strDeDes));
                        }
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onConnectState(final String str, final boolean z) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.2.10
                @Override // java.lang.Runnable
                public void run() {
                    if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                        AmmeterBluetoothManager.this.mDelegleListener.onConnectState(str, z);
                    }
                }
            });
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onSendDataFailed() {
            if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                AmmeterBluetoothManager.this.mDelegleListener.onSendDataFailed();
            }
        }

        @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
        public void onBLEState(boolean z) {
            Log.e("test", "onBLEState");
            if (AmmeterBluetoothManager.this.mDelegleListener != null) {
                AmmeterBluetoothManager.this.mDelegleListener.onBLEState(z);
            }
        }
    }
}
