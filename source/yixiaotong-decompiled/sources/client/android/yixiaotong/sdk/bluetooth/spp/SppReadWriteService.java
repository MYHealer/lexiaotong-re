package client.android.yixiaotong.sdk.bluetooth.spp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class SppReadWriteService {
    public static final int CONNECT_MASSAGE = 1;
    public static final int CONNECT_SUCCESS_MASSAGE = 2;
    public static final int DISCONNECT_MASSAGE = 3;
    public static String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    private Boolean bConnect;
    private BluetoothSocket btSocket;
    private iIOViewMessage ioMessage;
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private Thread mConnectThread;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private long mCurrentTiem;
    private long mCurrentTime;
    private Handler mHandler;
    private Thread mReceivedDataThread;
    private int mTimeOutTime;
    private InputStream mmInStream;
    private OutputStream mmOutStream;

    public static class SingletonHolder {
        public static final SppReadWriteService INSTANCE = new SppReadWriteService(null);
    }

    public void setIoViewMessage(iIOViewMessage iioviewmessage) {
        this.ioMessage = iioviewmessage;
    }

    public void setTimeOut() {
        this.mCurrentCheckTimeOut = null;
    }

    /* synthetic */ SppReadWriteService(AnonymousClass1 anonymousClass1) {
        this();
    }

    private SppReadWriteService() {
        this.btSocket = null;
        this.bConnect = false;
        this.mHandler = new AnonymousClass1();
    }

    public static SppReadWriteService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService$1, reason: invalid class name */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0093 A[DONT_GENERATE] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                SppReadWriteService.this.mConnectThread = new Thread(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService.1.1
                    /* JADX WARN: Code duplicated, block: B:9:0x008f  */
                    @Override // java.lang.Runnable
                    public void run() {
                        InputStream inputStream;
                        OutputStream outputStream;
                        SppReadWriteService.this.mCurrentTiem = System.currentTimeMillis();
                        SppReadWriteService.this.checkTimeOut(TimeOut.Connect, 15000);
                        Log.e("test", "开始连接 " + SppReadWriteService.this.mCurrentHardware.address);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            UUID uuidFromString = UUID.fromString(SppReadWriteService.SPP_UUID);
                            android.bluetooth.BluetoothDevice remoteDevice = SppReadWriteService.this.mBluetoothAdapter.getRemoteDevice(SppReadWriteService.this.mCurrentHardware.address);
                            if (remoteDevice != null) {
                                SppReadWriteService.this.btSocket = remoteDevice.createInsecureRfcommSocketToServiceRecord(uuidFromString);
                                if (SppReadWriteService.this.btSocket != null) {
                                    SppReadWriteService.this.btSocket.connect();
                                    inputStream = SppReadWriteService.this.btSocket.getInputStream();
                                    outputStream = SppReadWriteService.this.btSocket.getOutputStream();
                                } else {
                                    inputStream = null;
                                    outputStream = null;
                                }
                            } else {
                                inputStream = null;
                                outputStream = null;
                            }
                            Log.e("test", "连接时长：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                            SppReadWriteService.this.mmInStream = inputStream;
                            SppReadWriteService.this.mmOutStream = outputStream;
                            SppReadWriteService.this.mHandler.sendEmptyMessage(2);
                        } catch (Exception e) {
                            Log.e("test", "Error connected to: " + e.getMessage());
                            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!SppReadWriteService.this.isRunning || SppReadWriteService.this.ioMessage == null) {
                                        return;
                                    }
                                    SppReadWriteService.this.ioMessage.IOLayerCallOnBluetoothException(SppReadWriteService.this.mCurrentHardware, "连接异常，请重启手机蓝牙或重启设备蓝牙后再试");
                                }
                            });
                            e.printStackTrace();
                            SppReadWriteService.this.stopAndRelease();
                        }
                    }
                });
                SppReadWriteService.this.mConnectThread.start();
                return;
            }
            if (i == 2) {
                SppReadWriteService.this.bConnect = true;
                Log.e("test", "连接成功");
                SppReadWriteService.this.ioMessage.IOLayerCallOnConnectSuccess(SppReadWriteService.this.mCurrentHardware);
                SppReadWriteService.this.mReceivedDataThread = new Thread(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        while (SppReadWriteService.this.bConnect.booleanValue()) {
                            try {
                                int iAvailable = SppReadWriteService.this.mmInStream.available();
                                if (iAvailable > 0) {
                                    byte[] bArr = new byte[iAvailable];
                                    if (SppReadWriteService.this.mmInStream.read(bArr) > 0) {
                                        String strBufferToHex = HexString.bufferToHex(bArr);
                                        Log.e("test", "收到数据：" + strBufferToHex);
                                        if (StringUtils.isNotEmpty(strBufferToHex)) {
                                            SppReadWriteService.this.ioMessage.IOLayerCallOnReceivedData(SppReadWriteService.this.mCurrentHardware, strBufferToHex);
                                        }
                                    }
                                    Thread.sleep(100L);
                                }
                            } catch (Exception e) {
                                Log.e("test", "Recv thread:" + e.getMessage());
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                });
                SppReadWriteService.this.mReceivedDataThread.start();
                return;
            }
            if (i != 3) {
                return;
            }
            try {
                if (SppReadWriteService.this.mmInStream != null) {
                    SppReadWriteService.this.mmInStream.close();
                }
                if (SppReadWriteService.this.mmOutStream != null) {
                    SppReadWriteService.this.mmOutStream.close();
                }
                if (SppReadWriteService.this.btSocket != null) {
                    SppReadWriteService.this.btSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                SppReadWriteService.this.mmInStream = null;
                SppReadWriteService.this.mmOutStream = null;
                SppReadWriteService.this.btSocket = null;
                SppReadWriteService.this.bConnect = false;
                SppReadWriteService.this.isRunning = false;
                if (SppReadWriteService.this.mCurrentHardware != null) {
                    SppReadWriteService.this.mCurrentHardware.isTimeout = false;
                }
                Runtime runtime = Runtime.getRuntime();
                System.gc();
                runtime.runFinalization();
            }
        }
    }

    public void start(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
        if (this.isRunning) {
            return;
        }
        if (bluetoothAdapter.isDiscovering()) {
            this.mBluetoothAdapter.cancelDiscovery();
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService.2
            @Override // java.lang.Runnable
            public void run() {
                SppReadWriteService.this.ioMessage.IOLayerCallOnStart(SppReadWriteService.this.mCurrentHardware);
            }
        });
        if (!this.mCurrentHardware.address.startsWith("00:0E:0E") && this.mBluetoothAdapter.getRemoteDevice(this.mCurrentHardware.address).getBondState() != 12) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService.3
                @Override // java.lang.Runnable
                public void run() {
                    SppReadWriteService.this.ioMessage.IOLayerCallOnNoneBond(SppReadWriteService.this.mCurrentHardware);
                }
            });
        } else {
            this.isRunning = true;
            this.mHandler.sendEmptyMessageDelayed(1, 20L);
        }
    }

    public void send(final String str) {
        if (this.bConnect.booleanValue()) {
            new Thread(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (SppReadWriteService.this.mmOutStream == null) {
                            return;
                        }
                        SppReadWriteService.this.mmOutStream.write(HexString.hexToBuffer(str));
                    } catch (Exception unused) {
                        SppReadWriteService.this.ioMessage.IOLayerCallOnBluetoothException(SppReadWriteService.this.mCurrentHardware, "发送数据失败！");
                    }
                }
            }).start();
        }
    }

    public void sendData(TimeOut timeOut, int i, String str) {
        if (this.mCurrentHardware.isTimeout || !this.isRunning) {
            return;
        }
        if (StringUtils.isNotEmpty(str)) {
            checkTimeOut(timeOut, i);
            try {
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            send(str);
            return;
        }
        this.ioMessage.IOLayerCallOnFail(this.mCurrentHardware, timeOut);
        stopAndRelease();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        this.mCurrentTime = System.currentTimeMillis();
        this.mTimeOutTime = i;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            long jCurrentTimeMillis = System.currentTimeMillis() - SppReadWriteService.this.mCurrentTime;
            Log.e("test", this.timeOut + "  " + SppReadWriteService.this.mCurrentCheckTimeOut + "  " + jCurrentTimeMillis);
            if (SppReadWriteService.this.isRunning && this.timeOut == SppReadWriteService.this.mCurrentCheckTimeOut && jCurrentTimeMillis > SppReadWriteService.this.mTimeOutTime - 1000) {
                SppReadWriteService.this.mCurrentHardware.isTimeout = true;
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.bluetooth.spp.SppReadWriteService.CheckRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (SppReadWriteService.this.isRunning && SppReadWriteService.this.ioMessage != null) {
                                SppReadWriteService.this.ioMessage.IOLayerCallOnFail(SppReadWriteService.this.mCurrentHardware, CheckRunnable.this.timeOut);
                            }
                        } finally {
                            SppReadWriteService.this.stopAndRelease();
                        }
                    }
                });
            }
        }
    }

    public void stopAndRelease() {
        this.bConnect = false;
        this.mHandler.sendEmptyMessageDelayed(3, 100L);
    }
}
