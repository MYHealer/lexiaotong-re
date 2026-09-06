package client.android.yixiaotong.ui.bluetoothutil;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.TimeOut;
import android.util.Log;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.google.android.exoplayer2.C;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothConnectUtil {
    public static final int TIMEOUT = 3000;
    private Activity mActivity;
    private long mCurrentTime;
    private boolean mIsEnable;
    private boolean mIsSending;
    private Listener mListener;

    public interface Listener {
        void onConnected(BluetoothDevice bluetoothDevice);

        void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str);

        void onReceivedData(String str);

        void onStart(BluetoothDevice bluetoothDevice);
    }

    public void init(Activity activity) {
        this.mActivity = activity;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    private BluetoothConnectUtil() {
        this.mIsSending = false;
    }

    private static final class SingleHolder {
        private static final BluetoothConnectUtil INSTANCE = new BluetoothConnectUtil();

        private SingleHolder() {
        }
    }

    public static BluetoothConnectUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void setListener(Listener listener) {
        this.mListener = listener;
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.1
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                boolean unused = BluetoothConnectUtil.this.mIsEnable;
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (!BluetoothConnectUtil.this.mIsEnable || BluetoothConnectUtil.this.mListener == null) {
                    return;
                }
                BluetoothConnectUtil.this.mListener.onFail(bluetoothDevice, timeOut, str);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
                if (!BluetoothConnectUtil.this.mIsEnable || BluetoothConnectUtil.this.mListener == null) {
                    return;
                }
                Log.e("test", "onSuccessSendData:" + str);
                BluetoothConnectUtil.this.mListener.onReceivedData(str);
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                if (!BluetoothConnectUtil.this.mIsEnable || BluetoothConnectUtil.this.mListener == null) {
                    return;
                }
                BluetoothConnectUtil.this.mListener.onConnected(bluetoothDevice);
            }
        });
    }

    public void connect(final BluetoothDevice bluetoothDevice) {
        BluetoothSDK.getInstance().closeBLE();
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.2
            @Override // java.lang.Runnable
            public void run() {
                BluetoothSDK.getInstance().ConnectDeviceNoScan(bluetoothDevice);
            }
        }, 500L);
    }

    public void disConnect() {
        Log.e("test", "disConnect");
        BluetoothSDK.getInstance().closeBLE();
    }

    public void sendData(String str) {
        Log.e("test", "senddata:" + str);
        checkRunnable();
        this.mCurrentTime = System.currentTimeMillis();
        BluetoothSDK.getInstance().SendDataManagerDevice(str);
    }

    private void checkRunnable() {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.3
            @Override // java.lang.Runnable
            public void run() {
                if (!BluetoothConnectUtil.this.mIsSending || System.currentTimeMillis() - BluetoothConnectUtil.this.mCurrentTime <= 2900) {
                    return;
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                Log.e("checkRunnable", "closeBLE");
                BluetoothSDK.getInstance().closeBLE();
                SystemErrorTip.getInstance().showTipDialog(BluetoothConnectUtil.this.mActivity, "发送数据超时！");
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
    }
}
