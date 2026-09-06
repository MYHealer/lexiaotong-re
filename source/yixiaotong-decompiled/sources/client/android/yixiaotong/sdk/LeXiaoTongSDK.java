package client.android.yixiaotong.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.bluetooth.spp.SppScanDeviceServer;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.qrcode.CaptureActivity;
import client.android.yixiaotong.sdk.runnable.ble.AuthRunnable;
import client.android.yixiaotong.sdk.runnable.ble.CloseRunnable;
import client.android.yixiaotong.sdk.runnable.ble.CollectDataV4;
import client.android.yixiaotong.sdk.runnable.ble.ConnectManager;
import client.android.yixiaotong.sdk.runnable.ble.ConnectRunnable;
import client.android.yixiaotong.sdk.runnable.ble.InitRunnable;
import client.android.yixiaotong.sdk.runnable.ble.InitRunnableV2;
import client.android.yixiaotong.sdk.runnable.ble.MoneyBackRunnable;
import client.android.yixiaotong.sdk.runnable.ble.OpenRunnable;
import client.android.yixiaotong.sdk.runnable.ble.ReadSettingRunnable;
import client.android.yixiaotong.sdk.runnable.ble.ScanDeviceRunnable;
import client.android.yixiaotong.sdk.runnable.ble.SettingNameRunnable;
import client.android.yixiaotong.sdk.runnable.ble.SettingRunnable;
import client.android.yixiaotong.sdk.runnable.ble.SettingRunnableV4;
import client.android.yixiaotong.sdk.runnable.listener.AuthListener;
import client.android.yixiaotong.sdk.runnable.listener.CloseListener;
import client.android.yixiaotong.sdk.runnable.listener.CollectDataListener;
import client.android.yixiaotong.sdk.runnable.listener.ConnectListener;
import client.android.yixiaotong.sdk.runnable.listener.ConnectManagerListener;
import client.android.yixiaotong.sdk.runnable.listener.InitListener;
import client.android.yixiaotong.sdk.runnable.listener.MoneyBackListener;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.runnable.listener.SettingListener;
import client.android.yixiaotong.sdk.runnable.listener.SettingNameListener;
import client.android.yixiaotong.sdk.runnable.socket.CloseSocketRunnable;
import client.android.yixiaotong.sdk.runnable.socket.ConnectSocketRunnable;
import client.android.yixiaotong.sdk.runnable.socket.OpenSocketRunnable;
import client.android.yixiaotong.sdk.runnable.socket.ReadSettingSocketRunnable;
import client.android.yixiaotong.sdk.runnable.socket.ScanSocketDeviceRunnable;
import client.android.yixiaotong.sdk.runnable.socket.SettingNameSocketRunnable;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class LeXiaoTongSDK {
    public static final String DEVICEID_PREFIX = "0212";
    public static boolean ISBLE = true;
    private static final int REQUEST_CODE_SCAN_QRCODE = 256;
    private ConnectListener mConnectListener;
    private Context mContext;
    private QrcodeScanListener mQrcodeScanListener;
    private ScanDeviceRunnable mScanDeviceRunnable;
    private ScanSocketDeviceRunnable mScanSocketDeviceRunnable;
    private SppScanDeviceServer mSppScanDeviceServer;

    /* JADX INFO: renamed from: client.android.yixiaotong.sdk.LeXiaoTongSDK$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public interface QrcodeScanListener {
        void onScanQrcode(String str);
    }

    public interface QrcodeScanListener2 {
        void onScanQrcode(String str);
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void setMode(boolean z) {
        ISBLE = z;
    }

    /* synthetic */ LeXiaoTongSDK(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static class SingletonHolder {
        public static final LeXiaoTongSDK INSTANCE = new LeXiaoTongSDK(null);

        private SingletonHolder() {
        }
    }

    public static LeXiaoTongSDK getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private LeXiaoTongSDK() {
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 256) {
            if (i2 != -1 || intent == null) {
                this.mQrcodeScanListener = null;
                this.mConnectListener = null;
                return;
            }
            String stringExtra = intent.getStringExtra("data");
            QrcodeScanListener qrcodeScanListener = this.mQrcodeScanListener;
            if (qrcodeScanListener != null) {
                qrcodeScanListener.onScanQrcode(stringExtra);
            } else if (this.mConnectListener != null) {
                try {
                    getInstance().connectDevice(new BluetoothDevice("", BluetoothUtils.convertDeviceAddr(this.mContext, BluetoothUtils.getMac(BluetoothUtils.getTrimMac(stringExtra.split(",")[0]))), 0), this.mConnectListener);
                } catch (Exception unused) {
                }
            }
        }
    }

    public void scanQrCode(Activity activity, QrcodeScanListener qrcodeScanListener) {
        if (this.mContext == null || activity == null) {
            return;
        }
        this.mQrcodeScanListener = qrcodeScanListener;
        this.mConnectListener = null;
        CaptureActivity.launch(activity, 256);
    }

    public void scanQrCodeConnect(Activity activity, ConnectListener connectListener) {
        if (this.mContext == null || activity == null) {
            return;
        }
        this.mQrcodeScanListener = null;
        this.mConnectListener = connectListener;
        CaptureActivity.launch(activity, 256);
    }

    public void startScanBluetoothDevices(ScanListener scanListener) {
        if (this.mContext == null) {
            return;
        }
        stopScanBluetoothDevices();
        if (ISBLE) {
            Context context = this.mContext;
            ScanDeviceRunnable scanDeviceRunnable = new ScanDeviceRunnable(context, BluetoothUtils.getBluetoothAdapter(context));
            this.mScanDeviceRunnable = scanDeviceRunnable;
            scanDeviceRunnable.setScanListener(scanListener);
            this.mScanDeviceRunnable.start();
            return;
        }
        Context context2 = this.mContext;
        SppScanDeviceServer sppScanDeviceServer = new SppScanDeviceServer(context2, BluetoothUtils.getBluetoothAdapter(context2));
        this.mSppScanDeviceServer = sppScanDeviceServer;
        sppScanDeviceServer.setScanListener(scanListener);
        this.mSppScanDeviceServer.start();
    }

    public void stopScanBluetoothDevices() {
        if (this.mContext == null) {
            return;
        }
        if (ISBLE) {
            ScanDeviceRunnable scanDeviceRunnable = this.mScanDeviceRunnable;
            if (scanDeviceRunnable != null) {
                scanDeviceRunnable.stopAndRelease();
                this.mScanDeviceRunnable = null;
                return;
            }
            return;
        }
        SppScanDeviceServer sppScanDeviceServer = this.mSppScanDeviceServer;
        if (sppScanDeviceServer != null) {
            sppScanDeviceServer.stopAndRelease();
            this.mSppScanDeviceServer = null;
        }
    }

    public void startScanBluetoothDevices(ScanListener scanListener, boolean z) {
        if (this.mContext == null) {
            return;
        }
        stopScanBluetoothDevices();
        if (z) {
            Context context = this.mContext;
            ScanDeviceRunnable scanDeviceRunnable = new ScanDeviceRunnable(context, BluetoothUtils.getBluetoothAdapter(context));
            this.mScanDeviceRunnable = scanDeviceRunnable;
            scanDeviceRunnable.setScanListener(scanListener);
            this.mScanDeviceRunnable.start();
            return;
        }
        Context context2 = this.mContext;
        SppScanDeviceServer sppScanDeviceServer = new SppScanDeviceServer(context2, BluetoothUtils.getBluetoothAdapter(context2));
        this.mSppScanDeviceServer = sppScanDeviceServer;
        sppScanDeviceServer.setScanListener(scanListener);
        this.mSppScanDeviceServer.start();
    }

    public void stopScanBluetoothDevices(boolean z) {
        if (this.mContext == null) {
            return;
        }
        if (z) {
            ScanDeviceRunnable scanDeviceRunnable = this.mScanDeviceRunnable;
            if (scanDeviceRunnable != null) {
                scanDeviceRunnable.stopAndRelease();
                this.mScanDeviceRunnable = null;
                return;
            }
            return;
        }
        SppScanDeviceServer sppScanDeviceServer = this.mSppScanDeviceServer;
        if (sppScanDeviceServer != null) {
            sppScanDeviceServer.stopAndRelease();
            this.mSppScanDeviceServer = null;
        }
    }

    public void readSettingDevice(BluetoothDevice bluetoothDevice, ReadSettingListener readSettingListener) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            Context context2 = this.mContext;
            ReadSettingRunnable readSettingRunnable = new ReadSettingRunnable(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice);
            readSettingRunnable.setReadSettingListener(readSettingListener);
            readSettingRunnable.start();
            return;
        }
        ReadSettingSocketRunnable readSettingSocketRunnable = new ReadSettingSocketRunnable(this.mContext, bluetoothDevice);
        readSettingSocketRunnable.setReadSettingListener(readSettingListener);
        readSettingSocketRunnable.start();
    }

    public void settingDevice(BluetoothDevice bluetoothDevice, SettingListener settingListener, String str, long j) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !BluetoothUtils.isBluetoothLeSupported(context)) {
            return;
        }
        Context context2 = this.mContext;
        SettingRunnable settingRunnable = new SettingRunnable(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice, str, j);
        settingRunnable.setSettingListener(settingListener);
        settingRunnable.start();
    }

    public void initDevice(BluetoothDevice bluetoothDevice, InitListener initListener, boolean z) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !BluetoothUtils.isBluetoothLeSupported(context)) {
            return;
        }
        Context context2 = this.mContext;
        InitRunnable initRunnable = new InitRunnable(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice, z);
        initRunnable.setInitListener(initListener);
        initRunnable.start();
    }

    public void initDeviceV2(BluetoothDevice bluetoothDevice, InitListener initListener, String str) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !BluetoothUtils.isBluetoothLeSupported(context)) {
            return;
        }
        Context context2 = this.mContext;
        InitRunnableV2 initRunnableV2 = new InitRunnableV2(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice, str);
        initRunnableV2.setInitListener(initListener);
        initRunnableV2.start();
    }

    public void settingDeviceName(BluetoothDevice bluetoothDevice, SettingNameListener settingNameListener, String str) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            Context context2 = this.mContext;
            SettingNameRunnable settingNameRunnable = new SettingNameRunnable(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice, str);
            settingNameRunnable.setSettingNameListener(settingNameListener);
            settingNameRunnable.start();
            return;
        }
        SettingNameSocketRunnable settingNameSocketRunnable = new SettingNameSocketRunnable(this.mContext, bluetoothDevice, str);
        settingNameSocketRunnable.setSettingNameListener(settingNameListener);
        settingNameSocketRunnable.start();
    }

    public void connectDevice(BluetoothDevice bluetoothDevice, ConnectListener connectListener) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            Context context2 = this.mContext;
            ConnectRunnable connectRunnable = new ConnectRunnable(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice);
            connectRunnable.setConnectListener(connectListener);
            connectRunnable.start();
            return;
        }
        ConnectSocketRunnable connectSocketRunnable = new ConnectSocketRunnable(this.mContext, bluetoothDevice);
        connectSocketRunnable.setConnectListener(connectListener);
        connectSocketRunnable.start();
    }

    public void openDevice(BluetoothDevice bluetoothDevice, OpenListener openListener, long j, short s, boolean z) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            OpenRunnable.init(this.mContext, bluetoothDevice, j, s, z);
            OpenRunnable.getInstance().setOpenListener(openListener);
            OpenRunnable.getInstance().startConnect();
        } else {
            OpenSocketRunnable openSocketRunnable = new OpenSocketRunnable(this.mContext, bluetoothDevice, j, s, z);
            openSocketRunnable.setOpenListener(openListener);
            openSocketRunnable.start();
        }
    }

    public void openDevice(OpenListener openListener, boolean z) {
        OpenRunnable.getInstance().setOpenListener(openListener);
        OpenRunnable.getInstance().receivedData(z);
    }

    public void onCollectData(CollectDataListener collectDataListener, BluetoothDevice bluetoothDevice, boolean z) {
        CollectDataV4 collectDataV4 = new CollectDataV4(this.mContext, bluetoothDevice);
        collectDataV4.setOpenListener(collectDataListener);
        collectDataV4.receivedData("", z);
    }

    public void onSettingV4(SettingListener settingListener, BluetoothDevice bluetoothDevice, String str) {
        SettingRunnableV4 settingRunnableV4 = new SettingRunnableV4(this.mContext, bluetoothDevice, str);
        settingRunnableV4.setListener(settingListener);
        settingRunnableV4.receivedData("");
    }

    public void openUploadOrder(boolean z) {
        OpenRunnable.getInstance().openUploadOrder(z);
    }

    public void openForF1(String str) {
        OpenRunnable.getInstance().openForF1(str);
    }

    public void sendDataV3(String str) {
        OpenRunnable.getInstance().sendDataV3(str);
    }

    public void closeBLE() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    public void closeDevice(BluetoothDevice bluetoothDevice, CloseListener closeListener, long j, short s, boolean z) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            CloseRunnable.init(this.mContext, bluetoothDevice, j, s, z);
            CloseRunnable.getInstance().setCloseListener(closeListener);
            CloseRunnable.getInstance().startConnect();
        } else {
            CloseSocketRunnable closeSocketRunnable = new CloseSocketRunnable(this.mContext, bluetoothDevice, j, s, z);
            closeSocketRunnable.setCloseListener(closeListener);
            closeSocketRunnable.start();
        }
    }

    public void closeUploadOrder(boolean z) {
        CloseRunnable.getInstance().closeUploadOrder(z);
    }

    public void MoneyBackDevice(BluetoothDevice bluetoothDevice, MoneyBackListener moneyBackListener, long j, short s) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            Context context2 = this.mContext;
            MoneyBackRunnable moneyBackRunnable = new MoneyBackRunnable(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice, j, s);
            moneyBackRunnable.setOpenListener(moneyBackListener);
            moneyBackRunnable.start();
            return;
        }
        Toast.makeText(this.mContext, "手机不支持蓝牙4.0", 0).show();
    }

    public void ConnectManagerDevice(BluetoothDevice bluetoothDevice, ConnectManagerListener connectManagerListener) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            ConnectManager connectManager = ConnectManager.getInstance();
            Context context2 = this.mContext;
            connectManager.connect(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice);
            ConnectManager.getInstance().setOpenListener(connectManagerListener);
            ConnectManager.getInstance().start();
            return;
        }
        Toast.makeText(this.mContext, "手机不支持蓝牙4.0", 0).show();
    }

    public void SendDataManagerDevice(long j, short s, boolean z, ConnectManagerListener connectManagerListener) {
        ConnectManager.getInstance().setOpenListener(connectManagerListener);
        ConnectManager.getInstance().sendData(j, s, z);
    }

    public void closeBluetooth() {
        ConnectManager.getInstance().stopAndRelease();
    }

    public boolean isOpenBluetooth(Context context) {
        return BluetoothUtils.isOpenBluetooth(context);
    }

    public boolean isCloseBluetooth(Context context) {
        return BluetoothUtils.isCloseBluetooth(context);
    }

    public boolean isBondDevice(Context context, String str) {
        return BluetoothUtils.isBond(context, str);
    }

    public void writeSN(BluetoothDevice bluetoothDevice, AuthListener authListener) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !BluetoothUtils.isBluetoothLeSupported(context)) {
            return;
        }
        AuthRunnable.init(this.mContext, bluetoothDevice);
        AuthRunnable.getInstance().setAuthListener(authListener);
        AuthRunnable.getInstance().startConnect();
    }

    public void sendDataWriteSN(BluetoothDevice bluetoothDevice, AuthListener authListener, String str, String str2, String str3, String str4) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !BluetoothUtils.isBluetoothLeSupported(context)) {
            return;
        }
        AuthRunnable.getInstance().setAuthListener(authListener);
        AuthRunnable.getInstance().auth(str2, str3, str, str4);
    }

    public void setAuthListener(BluetoothDevice bluetoothDevice, AuthListener authListener) {
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !BluetoothUtils.isBluetoothLeSupported(context)) {
            return;
        }
        AuthRunnable.getInstance().setAuthListener(authListener);
    }
}
