package android.client.bluetoothsdk;

import android.client.bluetoothsdk.bluetooth.BluetoothConnect;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.bluetooth.ScanBLEDevice;
import android.client.bluetoothsdk.bluetooth.SocketBluetoothConnect;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.listener.ScanListener;
import android.client.bluetoothsdk.util.BluetoothUtils;
import android.client.bluetoothsdk.util.LogUtil;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BluetoothSDK {
    public static String PACKAGENAME = "cn.anjjie.elec.zxxy";
    public static String PACKAGENAME1 = "com.warmcome.CSAJU";
    public static String PACKAGENAME2 = "com.ChaneyTechnology.XiaoXiao";
    public static String PACKAGENAME3 = "com.warmcome.huanong";
    public static String PACKAGENAMETEST = "android.client.yinshuidemo";
    public static String SIGN = "ec03755c628220929c4d15f69257fb8c";
    public static String SIGN1 = "ca1338b444d3ff9650cdd4229ab97142";
    public static String SIGN2 = "638c7d6f4a2724f7fe58ec174967324f";
    public static String SIGN3 = "a501a13b84120c99de4bb0ad836dac5b";
    public static String SIGNTEST = "8a5e46041dc0f0d4a1cf88072ab7495d";
    private boolean isRegisterApp;
    private Context mContext;

    /* JADX INFO: renamed from: android.client.bluetoothsdk.BluetoothSDK$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class SingletonHolder {
        public static final BluetoothSDK INSTANCE = new BluetoothSDK(null);

        private SingletonHolder() {
        }
    }

    /* synthetic */ BluetoothSDK(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static BluetoothSDK getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private BluetoothSDK() {
        this.isRegisterApp = false;
    }

    public void init(Context context) {
        this.mContext = context;
        registerApp(context);
    }

    public void startScanDevice(int i, ScanListener scanListener) {
        if (this.mContext == null) {
            return;
        }
        ScanBLEDevice.getInstance().init(this.mContext, i);
        ScanBLEDevice.getInstance().setScanListener(scanListener);
        ScanBLEDevice.getInstance().start();
    }

    public void stopScanDevice() {
        if (this.mContext == null) {
            return;
        }
        ScanBLEDevice.getInstance().stopAndRelease();
    }

    public void setListener(BluetoothConnectListener bluetoothConnectListener) {
        Context context = this.mContext;
        if (context == null || !this.isRegisterApp) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            BluetoothConnect.getInstance().setOpenListener(bluetoothConnectListener);
        } else {
            SocketBluetoothConnect.getInstance().setConnectListener(bluetoothConnectListener);
        }
    }

    public void ConnectManagerDevice(BluetoothDevice bluetoothDevice) {
        Log.e("test", (this.mContext == null) + "  " + (bluetoothDevice == null) + "  " + this.isRegisterApp);
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !this.isRegisterApp) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            BluetoothConnect bluetoothConnect = BluetoothConnect.getInstance();
            Context context2 = this.mContext;
            bluetoothConnect.connect(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice);
            BluetoothConnect.getInstance().startScan();
            return;
        }
        SocketBluetoothConnect.getInstance().connect(this.mContext, new BluetoothDevice(bluetoothDevice.name, bluetoothDevice.address.substring(0, 7) + ExifInterface.LONGITUDE_EAST + bluetoothDevice.address.substring(8)));
        SocketBluetoothConnect.getInstance().startScan();
    }

    public void ConnectDeviceNoScan(BluetoothDevice bluetoothDevice) {
        Log.e("test", (this.mContext == null) + "  " + (bluetoothDevice == null) + "  " + this.isRegisterApp);
        Context context = this.mContext;
        if (context == null || bluetoothDevice == null || !this.isRegisterApp) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            BluetoothConnect bluetoothConnect = BluetoothConnect.getInstance();
            Context context2 = this.mContext;
            bluetoothConnect.connect(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice);
            BluetoothConnect.getInstance().start();
            return;
        }
        SocketBluetoothConnect.getInstance().connect(this.mContext, new BluetoothDevice(bluetoothDevice.name, bluetoothDevice.address.substring(0, 7) + ExifInterface.LONGITUDE_EAST + bluetoothDevice.address.substring(8)));
        SocketBluetoothConnect.getInstance().startScan();
    }

    public void SendDataManagerDevice(String str) {
        Context context = this.mContext;
        if (context == null || !this.isRegisterApp) {
            return;
        }
        if (BluetoothUtils.isBluetoothLeSupported(context)) {
            BluetoothConnect.getInstance().sendData(str);
        } else {
            SocketBluetoothConnect.getInstance().sendData(str);
        }
    }

    public void closeBLE() {
        if (this.mContext == null || !this.isRegisterApp) {
            return;
        }
        Log.e("test", "closeBLE");
        if (BluetoothUtils.isBluetoothLeSupported(this.mContext)) {
            BluetoothConnect.getInstance().stopAndRelease();
        } else {
            SocketBluetoothConnect.getInstance().stopAndRelease();
        }
    }

    public void isOpenLog(boolean z) {
        LogUtil.setOpenLog(z);
    }

    public void registerApp(Context context) {
        String signMd5Str = getSignMd5Str(context);
        String packageName = context.getPackageName();
        if (!PACKAGENAME.equals(packageName) && !PACKAGENAME1.equals(packageName) && !PACKAGENAME2.equals(packageName) && !PACKAGENAME3.equals(packageName) && !PACKAGENAMETEST.equals(packageName)) {
            this.isRegisterApp = true;
            return;
        }
        if (signMd5Str == null || signMd5Str.length() <= 0) {
            this.isRegisterApp = true;
            return;
        }
        if (SIGN.equals(signMd5Str) || SIGN1.equals(signMd5Str) || SIGN2.equals(signMd5Str) || SIGN3.equals(signMd5Str) || SIGNTEST.equals(signMd5Str)) {
            this.isRegisterApp = true;
        } else {
            this.isRegisterApp = true;
        }
    }

    public String getSignMd5Str(Context context) {
        try {
            return encryptionMD5(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String encryptionMD5(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            for (int i = 0; i < bArrDigest.length; i++) {
                if (Integer.toHexString(bArrDigest[i] & 255).length() == 1) {
                    stringBuffer.append("0").append(Integer.toHexString(bArrDigest[i] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(bArrDigest[i] & 255));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
