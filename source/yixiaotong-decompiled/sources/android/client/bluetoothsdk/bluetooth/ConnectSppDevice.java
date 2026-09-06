package android.client.bluetoothsdk.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothSocket;
import android.client.bluetoothsdk.BluetoothErrorCode;
import android.client.bluetoothsdk.listener.ConnectListener;
import android.client.bluetoothsdk.listener.DataListener;
import android.client.bluetoothsdk.util.ClsUtils;
import android.client.bluetoothsdk.util.HexString;
import android.client.bluetoothsdk.util.LogUtil;
import android.client.bluetoothsdk.util.StringUtils;
import android.client.bluetoothsdk.util.TimeOut;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ConnectSppDevice {
    public static final int CONNECT_MASSAGE = 1;
    public static final int CONNECT_SUCCESS_MASSAGE = 2;
    public static final int DISCONNECT_MASSAGE = 3;
    public static String SPP_UUID = "00001101-0000-1000-8000-00805F9B34FB";
    private String TAG;
    private Boolean bConnect;
    private BluetoothSocket btSocket;
    private ConnectListener connectListener;
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
    private BroadcastReceiver mReceiver;
    private boolean mReceiverTag;
    private int mTimeOutTime;
    private InputStream mmInStream;
    private OutputStream mmOutStream;
    private DataListener receiveDataListener;

    public static class SingletonHolder {
        public static final ConnectSppDevice INSTANCE = new ConnectSppDevice(null);
    }

    public void setConnectListener(ConnectListener connectListener) {
        this.connectListener = connectListener;
    }

    public void setDataListener(DataListener dataListener) {
        this.receiveDataListener = dataListener;
    }

    public void unRegisterListener() {
        this.connectListener = null;
        this.receiveDataListener = null;
    }

    /* synthetic */ ConnectSppDevice(AnonymousClass1 anonymousClass1) {
        this();
    }

    private ConnectSppDevice() {
        this.TAG = "BluetoothConnect SPP";
        this.btSocket = null;
        this.bConnect = false;
        this.mHandler = new AnonymousClass1();
        this.mReceiverTag = false;
        this.mReceiver = new BroadcastReceiver() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.4
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                    android.bluetooth.BluetoothDevice remoteDevice = ConnectSppDevice.this.mBluetoothAdapter.getRemoteDevice(ConnectSppDevice.this.mCurrentHardware.address);
                    try {
                        ConnectSppDevice.this.mReceiver.abortBroadcast();
                        ClsUtils.setPin(remoteDevice.getClass(), remoteDevice, "1234");
                        return;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
                    int bondState = ConnectSppDevice.this.mBluetoothAdapter.getRemoteDevice(ConnectSppDevice.this.mCurrentHardware.address).getBondState();
                    if (bondState == 10) {
                        ConnectSppDevice.this.connectListener.onConnectFail(ConnectSppDevice.this.mCurrentHardware, "配对失败，请重试或者请到手机本地设置中找到设备蓝牙后进行配对", 210);
                    } else {
                        if (bondState != 12) {
                            return;
                        }
                        ConnectSppDevice connectSppDevice = ConnectSppDevice.this;
                        connectSppDevice.start(connectSppDevice.mContext, ConnectSppDevice.this.mCurrentHardware);
                    }
                }
            }
        };
    }

    public static ConnectSppDevice getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: renamed from: android.client.bluetoothsdk.bluetooth.ConnectSppDevice$1, reason: invalid class name */
    class AnonymousClass1 extends Handler {
        AnonymousClass1() {
        }

        /* JADX WARN: Code duplicated, block: B:28:0x0093 A[DONT_GENERATE] */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                ConnectSppDevice.this.mConnectThread = new Thread(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.1.1
                    /* JADX WARN: Code duplicated, block: B:9:0x0095  */
                    @Override // java.lang.Runnable
                    public void run() {
                        InputStream inputStream;
                        OutputStream outputStream;
                        ConnectSppDevice.this.mCurrentTiem = System.currentTimeMillis();
                        ConnectSppDevice.this.checkTimeOut(TimeOut.Connect, 8000);
                        LogUtil.log_i(ConnectSppDevice.this.TAG, "开始连接 " + ConnectSppDevice.this.mCurrentHardware.address);
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        try {
                            UUID uuidFromString = UUID.fromString(ConnectSppDevice.SPP_UUID);
                            android.bluetooth.BluetoothDevice remoteDevice = ConnectSppDevice.this.mBluetoothAdapter.getRemoteDevice(ConnectSppDevice.this.mCurrentHardware.address);
                            if (remoteDevice != null) {
                                ConnectSppDevice.this.btSocket = remoteDevice.createInsecureRfcommSocketToServiceRecord(uuidFromString);
                                if (ConnectSppDevice.this.btSocket != null) {
                                    ConnectSppDevice.this.btSocket.connect();
                                    inputStream = ConnectSppDevice.this.btSocket.getInputStream();
                                    outputStream = ConnectSppDevice.this.btSocket.getOutputStream();
                                } else {
                                    inputStream = null;
                                    outputStream = null;
                                }
                            } else {
                                inputStream = null;
                                outputStream = null;
                            }
                            LogUtil.log_i(ConnectSppDevice.this.TAG, "连接时长：" + (System.currentTimeMillis() - jCurrentTimeMillis));
                            ConnectSppDevice.this.mmInStream = inputStream;
                            ConnectSppDevice.this.mmOutStream = outputStream;
                            ConnectSppDevice.this.mHandler.sendEmptyMessage(2);
                        } catch (Exception e) {
                            LogUtil.log_e(ConnectSppDevice.this.TAG, "Error connected to: " + e.getMessage());
                            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!ConnectSppDevice.this.isRunning || ConnectSppDevice.this.connectListener == null) {
                                        return;
                                    }
                                    ConnectSppDevice.this.connectListener.onConnectFail(ConnectSppDevice.this.mCurrentHardware, "连接异常，请重启手机蓝牙或重启设备蓝牙后再试", 205);
                                }
                            });
                            e.printStackTrace();
                            ConnectSppDevice.this.stopAndRelease();
                        }
                    }
                });
                ConnectSppDevice.this.mConnectThread.start();
                return;
            }
            if (i == 2) {
                ConnectSppDevice.this.bConnect = true;
                LogUtil.log_i(ConnectSppDevice.this.TAG, "连接成功");
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConnectSppDevice.this.connectListener.onConnectSuccess(ConnectSppDevice.this.mCurrentHardware);
                    }
                }, 200L);
                ConnectSppDevice.this.mReceivedDataThread = new Thread(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        while (ConnectSppDevice.this.bConnect.booleanValue()) {
                            try {
                                int iAvailable = ConnectSppDevice.this.mmInStream.available();
                                if (iAvailable > 0) {
                                    byte[] bArr = new byte[iAvailable];
                                    if (ConnectSppDevice.this.mmInStream.read(bArr) > 0) {
                                        final String strBufferToHex = HexString.bufferToHex(bArr);
                                        LogUtil.log_w(ConnectSppDevice.this.TAG, "收到数据：" + strBufferToHex);
                                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.1.3.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                if (StringUtils.isNotEmpty(strBufferToHex)) {
                                                    ConnectSppDevice.this.receiveDataListener.onReceivedData(ConnectSppDevice.this.mCurrentHardware, strBufferToHex);
                                                }
                                            }
                                        }, 10L);
                                    }
                                    Thread.sleep(100L);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    }
                });
                ConnectSppDevice.this.mReceivedDataThread.start();
                return;
            }
            if (i != 3) {
                return;
            }
            try {
                if (ConnectSppDevice.this.mmInStream != null) {
                    ConnectSppDevice.this.mmInStream.close();
                }
                if (ConnectSppDevice.this.mmOutStream != null) {
                    ConnectSppDevice.this.mmOutStream.close();
                }
                if (ConnectSppDevice.this.btSocket != null) {
                    ConnectSppDevice.this.btSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                ConnectSppDevice.this.mmInStream = null;
                ConnectSppDevice.this.mmOutStream = null;
                ConnectSppDevice.this.btSocket = null;
                ConnectSppDevice.this.bConnect = false;
                ConnectSppDevice.this.isRunning = false;
                if (ConnectSppDevice.this.mCurrentHardware != null) {
                    ConnectSppDevice.this.mCurrentHardware.isTimeout = false;
                }
                Runtime runtime = Runtime.getRuntime();
                System.gc();
                runtime.runFinalization();
            }
        }
    }

    public void start(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mBluetoothAdapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter();
        this.mCurrentHardware = bluetoothDevice;
        if (this.isRunning) {
            return;
        }
        regReceiver();
        if (this.mBluetoothAdapter.isDiscovering()) {
            this.mBluetoothAdapter.cancelDiscovery();
        }
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.2
            @Override // java.lang.Runnable
            public void run() {
                ConnectSppDevice.this.connectListener.onStartConnect(ConnectSppDevice.this.mCurrentHardware);
            }
        });
        if (this.mBluetoothAdapter.getRemoteDevice(this.mCurrentHardware.address).getBondState() != 12 && !this.mCurrentHardware.address.startsWith("00:0E:0E")) {
            android.bluetooth.BluetoothDevice remoteDevice = this.mBluetoothAdapter.getRemoteDevice(bluetoothDevice.address);
            try {
                ClsUtils.createBond(remoteDevice.getClass(), remoteDevice);
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.isRunning = true;
        this.mHandler.sendEmptyMessageDelayed(1, 20L);
    }

    private void send(final String str) {
        if (!this.bConnect.booleanValue()) {
            this.receiveDataListener.onSendDataFail(this.mCurrentHardware, "设备蓝牙已断开,请重新连接", 200);
        } else {
            new Thread(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (ConnectSppDevice.this.mmOutStream == null) {
                            return;
                        }
                        ConnectSppDevice.this.mmOutStream.write(HexString.hexToBuffer(str));
                    } catch (Exception unused) {
                        ConnectSppDevice.this.receiveDataListener.onSendDataFail(ConnectSppDevice.this.mCurrentHardware, "发送数据失败！", 202);
                    }
                }
            }).start();
        }
    }

    public void sendData(String str) {
        if (this.isRunning) {
            if (StringUtils.isNotEmpty(str)) {
                LogUtil.log_w(this.TAG, "BluetoothConnect 发送数据" + str);
                checkTimeOut(TimeOut.Send, 3000);
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                send(str);
                return;
            }
            this.receiveDataListener.onSendDataFail(this.mCurrentHardware, "发送数据不能为空", 201);
            stopAndRelease();
        }
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
            long jCurrentTimeMillis = System.currentTimeMillis() - ConnectSppDevice.this.mCurrentTime;
            if (ConnectSppDevice.this.isRunning && this.timeOut == ConnectSppDevice.this.mCurrentCheckTimeOut && jCurrentTimeMillis > ConnectSppDevice.this.mTimeOutTime - 1000) {
                ConnectSppDevice.this.mCurrentHardware.isTimeout = true;
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: android.client.bluetoothsdk.bluetooth.ConnectSppDevice.CheckRunnable.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (ConnectSppDevice.this.isRunning && ConnectSppDevice.this.connectListener != null) {
                                ConnectSppDevice.this.connectListener.onConnectFail(ConnectSppDevice.this.mCurrentHardware, BluetoothErrorCode.CONNECTTIMEOUTMSG + CheckRunnable.this.timeOut, 204);
                            }
                        } finally {
                            ConnectSppDevice.this.stopAndRelease();
                        }
                    }
                });
            }
        }
    }

    public void stopAndRelease() {
        this.bConnect = false;
        if (this.mReceiverTag) {
            this.mContext.unregisterReceiver(this.mReceiver);
        }
        this.mReceiverTag = false;
        this.mHandler.sendEmptyMessageDelayed(3, 100L);
    }

    private void regReceiver() {
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.setPriority(1000);
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        this.mContext.registerReceiver(this.mReceiver, intentFilter);
        this.mReceiverTag = true;
    }
}
