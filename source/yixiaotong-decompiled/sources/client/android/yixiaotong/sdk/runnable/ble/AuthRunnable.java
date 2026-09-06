package client.android.yixiaotong.sdk.runnable.ble;

import android.content.Context;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.ble.BluetoothManager;
import client.android.yixiaotong.sdk.command.VersionCommandV2;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.AuthListener;
import client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class AuthRunnable {
    public static AuthRunnable INSTANCE;
    private AuthListener mAuthListener;
    private AuthState mAuthState;
    private Context mContext;
    private BluetoothDevice mCurrentHardware;
    private String mF0;
    public StringBuilder stringBuilder;
    public int leftCount = 0;
    private iIOViewMessage miIOViewMessage = new iIOViewMessage() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.7
        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnNoneBond(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnStart(BluetoothDevice bluetoothDevice) {
            AuthRunnable.this.callOnStart(bluetoothDevice);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnBluetoothException(BluetoothDevice bluetoothDevice, String str) {
            AuthRunnable.this.callOnBluetoothException(new ClientException(-1, str));
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            AuthRunnable.this.callOnFail(bluetoothDevice, timeOut, "");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnConnectSuccess(BluetoothDevice bluetoothDevice) {
            AuthRunnable.this.callOnConnectSuccess(bluetoothDevice);
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.7.1
                @Override // java.lang.Runnable
                public void run() {
                    String strSelectInfoCommand = VersionCommandV2.selectInfoCommand();
                    AuthRunnable.this.mAuthState = AuthState.f0;
                    BluetoothManager.getInstance().sendData(TimeOut.AuthF0Command, 3000, strSelectInfoCommand);
                }
            }, 500L);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.iIOViewMessage
        public void IOLayerCallOnReceivedData(BluetoothDevice bluetoothDevice, String str) {
            if (str.startsWith("A5")) {
                AuthRunnable.this.stringBuilder = null;
                AuthRunnable.this.stringBuilder = new StringBuilder();
                AuthRunnable.this.stringBuilder.append(str);
            } else if (AuthRunnable.this.stringBuilder != null) {
                AuthRunnable.this.stringBuilder.append(str);
            }
            if (AuthRunnable.this.stringBuilder != null && AuthRunnable.this.stringBuilder.length() >= 4) {
                String strReceivedDataManage = VersionCommandV2.receivedDataManage(AuthRunnable.this.stringBuilder.toString());
                AuthRunnable.this.stringBuilder.delete(0, AuthRunnable.this.stringBuilder.length());
                AuthRunnable.this.stringBuilder.append(strReceivedDataManage);
                int i = Integer.parseInt(AuthRunnable.this.stringBuilder.substring(2, 4), 16);
                AuthRunnable authRunnable = AuthRunnable.this;
                authRunnable.leftCount = ((i * 2) + 6) - authRunnable.stringBuilder.length();
            }
            if (AuthRunnable.this.leftCount > 0 || AuthRunnable.this.stringBuilder == null) {
                return;
            }
            AuthRunnable.this.stringBuilder.toString();
            if (AuthRunnable.this.leftCount > 0 || AuthRunnable.this.stringBuilder == null) {
                return;
            }
            String string = AuthRunnable.this.stringBuilder.toString();
            if (!VersionCommandV2.isReceivedDataFormat(string)) {
                AuthRunnable authRunnable2 = AuthRunnable.this;
                authRunnable2.callOnFail(authRunnable2.mCurrentHardware, null, "数据格式错误2");
            } else if (VersionCommandV2.receivedControlState().equals("00")) {
                if (AuthRunnable.this.mAuthState == AuthState.f0) {
                    AuthRunnable.this.mF0 = string;
                    String strCollectOrderCommand = VersionCommandV2.collectOrderCommand(RandomUtil.getRandNumMaxString(2), RandomUtil.getRandNumMaxString(2), false, client.android.yixiaotong.util.bluetooth.BluetoothDevice.DEFAULT_DEVICEHEXNO);
                    AuthRunnable.this.mAuthState = AuthState.f02;
                    BluetoothManager.getInstance().sendData(TimeOut.Send02Command, 3000, strCollectOrderCommand);
                } else if (AuthRunnable.this.mAuthState != AuthState.f02) {
                    if (AuthRunnable.this.mAuthState == AuthState.f2) {
                        AuthRunnable authRunnable3 = AuthRunnable.this;
                        authRunnable3.callOnData(authRunnable3.mCurrentHardware, AuthRunnable.this.mF0, "f2");
                        AuthRunnable authRunnable4 = AuthRunnable.this;
                        authRunnable4.callOnSuccess(authRunnable4.mCurrentHardware);
                    }
                } else if (string.length() < 70) {
                    AuthRunnable authRunnable5 = AuthRunnable.this;
                    authRunnable5.callOnData(authRunnable5.mCurrentHardware, AuthRunnable.this.mF0, "f0");
                    BluetoothManager.getInstance().setTimeOut();
                } else {
                    AuthRunnable authRunnable6 = AuthRunnable.this;
                    authRunnable6.callOnFail(authRunnable6.mCurrentHardware, null, "设备里存在消费记录，不允许写机号");
                }
            } else {
                AuthRunnable authRunnable7 = AuthRunnable.this;
                authRunnable7.callOnFail(authRunnable7.mCurrentHardware, null, "校验码错误1");
            }
            AuthRunnable.this.stringBuilder = null;
        }
    };

    private enum AuthState {
        f0,
        f2,
        f02
    }

    public static AuthRunnable getInstance() {
        AuthRunnable authRunnable = INSTANCE;
        if (authRunnable != null) {
            return authRunnable;
        }
        throw new RuntimeException("must call init()");
    }

    public static void init(Context context, BluetoothDevice bluetoothDevice) {
        INSTANCE = new AuthRunnable(context, bluetoothDevice);
    }

    public void setMode(boolean z) {
        BluetoothManager.getInstance().setMode(z);
    }

    public AuthRunnable(Context context, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mCurrentHardware = bluetoothDevice;
        BluetoothManager.init(context);
    }

    public void startConnect() {
        BluetoothManager.getInstance().startConnect(this.mCurrentHardware);
    }

    public void stopAndRelease() {
        BluetoothManager.getInstance().closeBluetooth();
    }

    public void setAuthListener(AuthListener authListener) {
        BluetoothManager.getInstance().setIOViewMessage(this.miIOViewMessage);
        this.mAuthListener = authListener;
    }

    public void auth(String str, String str2, String str3, String str4) {
        String strAuthAndSetNoRateCommand = VersionCommandV2.AuthAndSetNoRateCommand(str, str2, str3, str4);
        this.mAuthState = AuthState.f2;
        BluetoothManager.getInstance().sendData(TimeOut.AuthCommand, 3000, strAuthAndSetNoRateCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.1
            @Override // java.lang.Runnable
            public void run() {
                if (AuthRunnable.this.mAuthListener != null) {
                    AuthRunnable.this.mAuthListener.onStart(bluetoothDevice);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnConnectSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                if (AuthRunnable.this.mAuthListener != null) {
                    AuthRunnable.this.mAuthListener.onConnectSuccess(bluetoothDevice);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnData(final BluetoothDevice bluetoothDevice, final String str, final String str2) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                if (AuthRunnable.this.mAuthListener != null) {
                    AuthRunnable.this.mAuthListener.onData(bluetoothDevice, str, str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AuthRunnable.this.mAuthListener != null) {
                        AuthRunnable.this.mAuthListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    AuthRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AuthRunnable.this.mAuthListener != null) {
                        AuthRunnable.this.mAuthListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    AuthRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.AuthRunnable.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (AuthRunnable.this.mAuthListener != null) {
                        AuthRunnable.this.mAuthListener.onBluetoothException(clientException);
                    }
                } finally {
                    AuthRunnable.this.stopAndRelease();
                }
            }
        });
    }
}
