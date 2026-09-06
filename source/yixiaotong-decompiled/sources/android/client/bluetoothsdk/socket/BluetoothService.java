package android.client.bluetoothsdk.socket;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
class BluetoothService {
    public static final int MESSAGE_DEVICE_NAME = 4;
    public static final int MESSAGE_READ = 2;
    public static final int MESSAGE_STATE_CHANGE = 1;
    public static final int MESSAGE_TOAST = 5;
    public static final int MESSAGE_WRITE = 3;
    private static final String NAME_SECURE = "Bluetooth Secure";
    public static final int STATE_CONNECTED = 3;
    public static final int STATE_CONNECTING = 2;
    public static final int STATE_LISTEN = 1;
    public static final int STATE_NONE = 0;
    public static final int STATE_NULL = -1;
    private static final String TAG = "BluetoothService";
    private static final UUID UUID_ANDROID_DEVICE = UUID.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");
    private static final UUID UUID_OTHER_DEVICE = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private boolean isAndroid;
    private ConnectThread mConnectThread;
    private ConnectedThread mConnectedThread;
    private final Handler mHandler;
    private AcceptThread mSecureAcceptThread;
    private boolean mIsSecure = true;
    private final BluetoothAdapter mAdapter = BluetoothAdapter.getDefaultAdapter();
    private int mState = 0;

    public BluetoothService(Handler handler) {
        this.mHandler = handler;
    }

    private synchronized void setState(int i) {
        Log.d(TAG, "setState() " + this.mState + " -> " + i);
        this.mState = i;
        this.mHandler.obtainMessage(1, i, -1).sendToTarget();
    }

    public synchronized int getState() {
        return this.mState;
    }

    public synchronized void start(boolean z, boolean z2) {
        this.isAndroid = z;
        this.mIsSecure = z2;
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        setState(1);
        if (this.mSecureAcceptThread == null) {
            AcceptThread acceptThread = new AcceptThread(this.isAndroid, this.mIsSecure);
            this.mSecureAcceptThread = acceptThread;
            acceptThread.start();
        }
    }

    public synchronized void connect(BluetoothDevice bluetoothDevice) {
        ConnectThread connectThread;
        if (this.mState == 2 && (connectThread = this.mConnectThread) != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        ConnectThread connectThread2 = new ConnectThread(bluetoothDevice);
        this.mConnectThread = connectThread2;
        connectThread2.start();
        setState(2);
    }

    public synchronized void connected(BluetoothSocket bluetoothSocket, BluetoothDevice bluetoothDevice, String str) {
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        AcceptThread acceptThread = this.mSecureAcceptThread;
        if (acceptThread != null) {
            acceptThread.cancel();
            this.mSecureAcceptThread = null;
        }
        ConnectedThread connectedThread2 = new ConnectedThread(bluetoothSocket, str);
        this.mConnectedThread = connectedThread2;
        connectedThread2.start();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4));
        setState(3);
    }

    public synchronized void stop() {
        ConnectThread connectThread = this.mConnectThread;
        if (connectThread != null) {
            connectThread.cancel();
            this.mConnectThread = null;
        }
        ConnectedThread connectedThread = this.mConnectedThread;
        if (connectedThread != null) {
            connectedThread.cancel();
            this.mConnectedThread = null;
        }
        AcceptThread acceptThread = this.mSecureAcceptThread;
        if (acceptThread != null) {
            acceptThread.cancel();
            this.mSecureAcceptThread.kill();
            this.mSecureAcceptThread = null;
        }
        setState(0);
    }

    public void write(byte[] bArr) {
        synchronized (this) {
            if (this.mState != 3) {
                return;
            }
            this.mConnectedThread.write(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionFailed() {
        start(this.isAndroid, this.mIsSecure);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectionLost() {
        start(this.isAndroid, this.mIsSecure);
    }

    private class AcceptThread extends Thread {
        boolean isRunning = true;
        private String mSocketType;
        private BluetoothServerSocket mmServerSocket;

        public void kill() {
            this.isRunning = false;
        }

        public AcceptThread(boolean z, boolean z2) {
            BluetoothServerSocket bluetoothServerSocketListenUsingRfcommWithServiceRecord;
            try {
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = z2 ? z ? BluetoothService.this.mAdapter.listenUsingRfcommWithServiceRecord(BluetoothService.NAME_SECURE, BluetoothService.UUID_ANDROID_DEVICE) : BluetoothService.this.mAdapter.listenUsingRfcommWithServiceRecord(BluetoothService.NAME_SECURE, BluetoothService.UUID_OTHER_DEVICE) : z ? BluetoothService.this.mAdapter.listenUsingInsecureRfcommWithServiceRecord(BluetoothService.NAME_SECURE, BluetoothService.UUID_ANDROID_DEVICE) : BluetoothService.this.mAdapter.listenUsingInsecureRfcommWithServiceRecord(BluetoothService.NAME_SECURE, BluetoothService.UUID_OTHER_DEVICE);
            } catch (IOException unused) {
                bluetoothServerSocketListenUsingRfcommWithServiceRecord = null;
            }
            this.mmServerSocket = bluetoothServerSocketListenUsingRfcommWithServiceRecord;
        }

        /* JADX WARN: Code duplicated, block: B:32:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("AcceptThread" + this.mSocketType);
            while (BluetoothService.this.mState != 3 && this.isRunning) {
                try {
                    BluetoothSocket bluetoothSocketAccept = this.mmServerSocket.accept();
                    if (bluetoothSocketAccept != null) {
                        synchronized (BluetoothService.this) {
                            int i = BluetoothService.this.mState;
                            if (i == 0) {
                                try {
                                    bluetoothSocketAccept.close();
                                } catch (IOException unused) {
                                }
                            } else if (i == 1 || i == 2) {
                                BluetoothService.this.connected(bluetoothSocketAccept, bluetoothSocketAccept.getRemoteDevice(), this.mSocketType);
                            } else if (i == 3) {
                                bluetoothSocketAccept.close();
                            }
                        }
                    }
                } catch (Exception unused2) {
                    return;
                }
            }
        }

        public void cancel() {
            try {
                this.mmServerSocket.close();
                this.mmServerSocket = null;
            } catch (Exception unused) {
            }
        }
    }

    private class ConnectThread extends Thread {
        private String mSocketType;
        private final BluetoothDevice mmDevice;
        private final BluetoothSocket mmSocket;

        public ConnectThread(BluetoothDevice bluetoothDevice) {
            BluetoothSocket bluetoothSocketCreateInsecureRfcommSocketToServiceRecord;
            this.mmDevice = bluetoothDevice;
            try {
                if (BluetoothService.this.mIsSecure) {
                    if (BluetoothService.this.isAndroid) {
                        bluetoothSocketCreateInsecureRfcommSocketToServiceRecord = bluetoothDevice.createRfcommSocketToServiceRecord(BluetoothService.UUID_ANDROID_DEVICE);
                    } else {
                        bluetoothSocketCreateInsecureRfcommSocketToServiceRecord = bluetoothDevice.createRfcommSocketToServiceRecord(BluetoothService.UUID_OTHER_DEVICE);
                    }
                } else if (BluetoothService.this.isAndroid) {
                    bluetoothSocketCreateInsecureRfcommSocketToServiceRecord = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(BluetoothService.UUID_ANDROID_DEVICE);
                } else {
                    bluetoothSocketCreateInsecureRfcommSocketToServiceRecord = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(BluetoothService.UUID_OTHER_DEVICE);
                }
            } catch (IOException unused) {
                bluetoothSocketCreateInsecureRfcommSocketToServiceRecord = null;
            }
            this.mmSocket = bluetoothSocketCreateInsecureRfcommSocketToServiceRecord;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            BluetoothService.this.mAdapter.cancelDiscovery();
            try {
                try {
                    this.mmSocket.connect();
                    synchronized (BluetoothService.this) {
                        BluetoothService.this.mConnectThread = null;
                    }
                    BluetoothService.this.connected(this.mmSocket, this.mmDevice, this.mSocketType);
                } catch (IOException unused) {
                    this.mmSocket.close();
                    BluetoothService.this.connectionFailed();
                }
            } catch (IOException unused2) {
                BluetoothService.this.connectionFailed();
            }
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException unused) {
            }
        }
    }

    private class ConnectedThread extends Thread {
        private final InputStream mmInStream;
        private final OutputStream mmOutStream;
        private final BluetoothSocket mmSocket;

        public ConnectedThread(BluetoothSocket bluetoothSocket, String str) {
            InputStream inputStream;
            this.mmSocket = bluetoothSocket;
            OutputStream outputStream = null;
            try {
                inputStream = bluetoothSocket.getInputStream();
                try {
                    outputStream = bluetoothSocket.getOutputStream();
                } catch (IOException unused) {
                }
            } catch (IOException unused2) {
                inputStream = null;
            }
            this.mmInStream = inputStream;
            this.mmOutStream = outputStream;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    byte[] bArr = new byte[16];
                    int i = this.mmInStream.read(bArr);
                    byte[] bArr2 = new byte[i];
                    System.arraycopy(bArr, 0, bArr2, 0, i);
                    BluetoothService.this.mHandler.obtainMessage(2, bArr2).sendToTarget();
                } catch (IOException unused) {
                    BluetoothService.this.connectionLost();
                    BluetoothService bluetoothService = BluetoothService.this;
                    bluetoothService.start(bluetoothService.isAndroid, BluetoothService.this.mIsSecure);
                    return;
                }
            }
        }

        public void write(byte[] bArr) {
            try {
                this.mmOutStream.write(bArr);
                BluetoothService.this.mHandler.obtainMessage(3, -1, -1, bArr).sendToTarget();
            } catch (IOException unused) {
            }
        }

        public void cancel() {
            try {
                this.mmSocket.close();
            } catch (IOException unused) {
            }
        }
    }
}
