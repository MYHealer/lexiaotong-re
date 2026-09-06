package client.android.yixiaotong.sdk.bluetooth.ble;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.LocalBusinessStore;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.VersionUtil;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class BluetoothManager {
    public static BluetoothManager INSTANCE;
    private Context mContext;
    private long mCurrentTime;
    private String mReceivedData;
    private iIOViewMessage miIOViewMessage;
    public StringBuilder stringBuilder;
    public StringBuilder stringBuilder1;
    public StringBuilder stringBuilder2;
    public StringBuilder stringBuilderAll;
    private TimeOut timeOut;
    private boolean mMode = true;
    private boolean mIsSendIng = false;
    private int mSendCount = 0;
    private String mSendData = "";
    private Handler mHandler = new Handler(Looper.getMainLooper());
    public int leftCount = 0;
    private iIOViewMessage iIOViewMessage = new iIOViewMessage() { // from class: client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager.1
        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnStart(BluetoothDevice bluetoothDevice) {
            BluetoothManager.this.stringBuilder = null;
            BluetoothManager.this.stringBuilder1 = null;
            BluetoothManager.this.stringBuilder2 = null;
            BluetoothManager.this.stringBuilderAll = null;
            BluetoothManager.this.leftCount = 0;
            BluetoothManager.this.mIsSendIng = false;
            BluetoothManager.this.miIOViewMessage.IOLayerCallOnStart(bluetoothDevice);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnBluetoothException(BluetoothDevice bluetoothDevice, String str) {
            BluetoothManager.this.mIsSendIng = false;
            BluetoothManager.this.miIOViewMessage.IOLayerCallOnBluetoothException(bluetoothDevice, str);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            BluetoothManager.this.mIsSendIng = false;
            BluetoothManager.this.miIOViewMessage.IOLayerCallOnFail(bluetoothDevice, timeOut);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnConnectSuccess(BluetoothDevice bluetoothDevice) {
            BluetoothManager.this.mIsSendIng = false;
            BluetoothManager.this.miIOViewMessage.IOLayerCallOnConnectSuccess(bluetoothDevice);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str) {
            BluetoothManager.this.mReceivedData += str;
            if (StringUtils.isNotEmpty(BluetoothManager.this.mReceivedData) && !BluetoothManager.this.mReceivedData.startsWith("5500")) {
                if (VersionUtil.IsSmallAppVersion(str)) {
                    BluetoothManager.this.stringBuilder1 = null;
                    BluetoothManager.this.stringBuilder2 = null;
                    BluetoothManager.this.mIsSendIng = false;
                    LocalBusinessStore.saveVersion(BluetoothManager.this.mContext, bluetoothDevice.address, 3);
                    BluetoothManager.this.miIOViewMessage.IOLayerCallOnReceivedData(bluetoothDevice, str);
                    return;
                }
                if (str.startsWith("AA") || BluetoothManager.this.stringBuilder1 != null) {
                    if (BluetoothManager.this.stringBuilder1 == null) {
                        BluetoothManager.this.stringBuilder1 = new StringBuilder();
                    }
                    BluetoothManager.this.stringBuilder1.append(str);
                    if (BluetoothManager.this.stringBuilder1.toString().length() == 18) {
                        BluetoothManager.this.mIsSendIng = false;
                        LocalBusinessStore.saveVersion(BluetoothManager.this.mContext, bluetoothDevice.address, 3);
                        BluetoothManager.this.miIOViewMessage.IOLayerCallOnReceivedData(bluetoothDevice, BluetoothManager.this.stringBuilder1.toString());
                        BluetoothManager.this.stringBuilder1 = null;
                        return;
                    }
                }
                if ((str.length() >= 2 && str.startsWith("55") && !str.startsWith("5500")) || BluetoothManager.this.stringBuilder2 != null) {
                    if (BluetoothManager.this.stringBuilder2 == null) {
                        BluetoothManager.this.stringBuilder2 = new StringBuilder();
                    }
                    BluetoothManager.this.stringBuilder2.append(str);
                    if (!BluetoothManager.this.stringBuilder2.toString().startsWith("5500") && BluetoothManager.this.stringBuilder2.toString().length() == 40) {
                        BluetoothManager.this.mIsSendIng = false;
                        LocalBusinessStore.saveVersion(BluetoothManager.this.mContext, bluetoothDevice.address, 3);
                        BluetoothManager.this.miIOViewMessage.IOLayerCallOnReceivedData(bluetoothDevice, BluetoothManager.this.stringBuilder2.toString());
                        BluetoothManager.this.stringBuilder2 = null;
                        return;
                    }
                }
            }
            if (str.startsWith("550001") && str.length() >= 8) {
                BluetoothManager.this.stringBuilder = new StringBuilder();
                BluetoothManager.this.stringBuilder.append(str);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(str.substring(6, 8));
                byte[] bArr = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                BluetoothManager.this.leftCount = ((IntegerUtils.bytesToInt2(bArr, 0) + 1) * 2) - (str.length() - 6);
            } else if (BluetoothManager.this.stringBuilder != null && BluetoothManager.this.stringBuilder.toString().length() >= 8) {
                BluetoothManager.this.stringBuilder.append(str);
                BluetoothManager.this.leftCount -= str.length();
            } else if (BluetoothManager.this.stringBuilder != null && BluetoothManager.this.stringBuilder.toString().length() < 8) {
                BluetoothManager.this.stringBuilder.append(str);
                if (BluetoothManager.this.stringBuilder.toString().length() >= 8) {
                    byte[] bArrHexToBuffer2 = HexString.hexToBuffer(BluetoothManager.this.stringBuilder.toString().substring(6, 8));
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(bArrHexToBuffer2, 0, bArr2, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                    int iBytesToInt2 = IntegerUtils.bytesToInt2(bArr2, 0);
                    BluetoothManager bluetoothManager = BluetoothManager.this;
                    bluetoothManager.leftCount = ((iBytesToInt2 + 1) * 2) - (bluetoothManager.stringBuilder.toString().length() - 6);
                }
            } else {
                if (!str.startsWith("55") || str.length() >= 8) {
                    return;
                }
                BluetoothManager.this.stringBuilder = new StringBuilder();
                BluetoothManager.this.stringBuilder.append(str);
                BluetoothManager.this.leftCount = 1;
            }
            if (BluetoothManager.this.leftCount > 0 || BluetoothManager.this.stringBuilder == null) {
                return;
            }
            BluetoothManager.this.mIsSendIng = false;
            BluetoothManager.this.miIOViewMessage.IOLayerCallOnReceivedData(bluetoothDevice, BluetoothManager.this.stringBuilder.toString());
            BluetoothManager.this.stringBuilder = null;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnNoneBond(BluetoothDevice bluetoothDevice) {
            BluetoothManager.this.miIOViewMessage.IOLayerCallOnNoneBond(bluetoothDevice);
        }
    };

    public void setMode(boolean z) {
        this.mMode = z;
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

    private BluetoothManager(Context context) {
        this.mContext = context;
    }

    public void setIOViewMessage(iIOViewMessage iioviewmessage) {
        this.mMode = LeXiaoTongSDK.ISBLE;
        this.miIOViewMessage = iioviewmessage;
    }

    public void setTimeOut() {
        if (this.mMode) {
            BleReadWriteService.getInstance().setTimeOut();
        } else {
            SppReadWriteService.getInstance().setTimeOut();
        }
    }

    public void startConnect(BluetoothDevice bluetoothDevice) {
        if (this.mMode) {
            BleReadWriteService.getInstance().setIoViewMessage(this.iIOViewMessage);
            BleReadWriteService bleReadWriteService = BleReadWriteService.getInstance();
            Context context = this.mContext;
            bleReadWriteService.start(context, BluetoothUtils.getBluetoothAdapter(context), bluetoothDevice);
            return;
        }
        SppReadWriteService.getInstance().setIoViewMessage(this.iIOViewMessage);
        SppReadWriteService sppReadWriteService = SppReadWriteService.getInstance();
        Context context2 = this.mContext;
        sppReadWriteService.start(context2, BluetoothUtils.getBluetoothAdapter(context2), bluetoothDevice);
    }

    public void sendData(TimeOut timeOut, int i, String str) {
        this.mSendCount = 0;
        this.mIsSendIng = true;
        this.timeOut = timeOut;
        this.mReceivedData = "";
        this.mSendData = str;
        this.mCurrentTime = System.currentTimeMillis();
        if (this.mMode) {
            BleReadWriteService.getInstance().sendData(timeOut, i, str);
        } else {
            SppReadWriteService.getInstance().sendData(timeOut, i, str);
        }
        sendDataAgain(timeOut, i, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendDataAgain(TimeOut timeOut, int i, String str) {
        if (i >= 3000) {
            this.mSendCount++;
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.postDelayed(new CheckRunnable(timeOut, str, i), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
            }
        }
    }

    private class CheckRunnable implements Runnable {
        private TimeOut bluetoothTimeOut;
        private String senddata;
        private int time;

        public CheckRunnable(TimeOut timeOut, String str, int i) {
            this.bluetoothTimeOut = timeOut;
            this.senddata = str;
            this.time = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.e("test", this.bluetoothTimeOut + "  " + BluetoothManager.this.timeOut + "  " + (!BluetoothManager.this.mIsSendIng) + "  " + BluetoothManager.this.mSendCount + "  " + (System.currentTimeMillis() - BluetoothManager.this.mCurrentTime < 1000));
            if (this.bluetoothTimeOut == BluetoothManager.this.timeOut && BluetoothManager.this.mIsSendIng && BluetoothManager.this.mSendCount <= 2 && BluetoothManager.this.mSendData.equals(this.senddata)) {
                if (BluetoothManager.this.mMode) {
                    BleReadWriteService.getInstance().sendData(this.bluetoothTimeOut, this.time, this.senddata);
                } else {
                    SppReadWriteService.getInstance().sendData(this.bluetoothTimeOut, this.time, this.senddata);
                }
                BluetoothManager.this.sendDataAgain(this.bluetoothTimeOut, this.time, this.senddata);
            }
        }
    }

    public void closeBluetooth() {
        if (this.mMode) {
            BleReadWriteService.getInstance().stopAndRelease();
        } else {
            SppReadWriteService.getInstance().stopAndRelease();
        }
    }

    private void receivedDataNew(String str) {
        if (str.startsWith("A5") && str.length() >= 4) {
            StringBuilder sb = new StringBuilder();
            this.stringBuilderAll = sb;
            sb.append(str);
            byte[] bArrHexToBuffer = HexString.hexToBuffer(str.substring(2, 4));
            byte[] bArr = new byte[4];
            System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
            this.leftCount = ((IntegerUtils.bytesToInt2(bArr, 0) + 1) * 2) - (str.length() - 4);
            return;
        }
        StringBuilder sb2 = this.stringBuilderAll;
        if (sb2 != null && sb2.toString().length() >= 4) {
            this.stringBuilderAll.append(str);
            this.leftCount -= str.length();
            return;
        }
        StringBuilder sb3 = this.stringBuilderAll;
        if (sb3 != null && sb3.toString().length() < 4) {
            this.stringBuilderAll.append(str);
            if (this.stringBuilderAll.toString().length() >= 4) {
                byte[] bArrHexToBuffer2 = HexString.hexToBuffer(this.stringBuilderAll.toString().substring(2, 4));
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArrHexToBuffer2, 0, bArr2, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                this.leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) + 1) * 2) - (this.stringBuilderAll.toString().length() - 4);
                return;
            }
            return;
        }
        if (!str.startsWith("A5") || str.length() >= 4) {
            return;
        }
        StringBuilder sb4 = new StringBuilder();
        this.stringBuilderAll = sb4;
        sb4.append(str);
        this.leftCount = 1;
    }
}
