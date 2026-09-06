package client.android.yixiaotong.v3.bluetoothutil;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import client.android.yixiaotong.R;
import client.android.yixiaotong.v3.comman.BluetoothDeviceCommand;
import client.android.yixiaotong.v3.comman.DSKReceivedDataUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.util.DeviceTypeVerUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.comman.V4DeviceCommand;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.listener.ConnectListener;
import com.lxt.bluetoothsdk.listener.DataListener;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.lxt.bluetoothsdk.utils.StringUtils;
import com.lxt.bluetoothsdk.utils.executor.MainThreadExecutor;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothControlUtil {
    public static final int MAXCONNECTCOUNT = 2;
    public static final int OPENBLUETOOTH_REQUESTCODE = 200;
    public static final int SCAN_TIMEOUT = 4000;
    public static final int SENDDATATIMEOUT = 10000;
    public static final int SEND_TIMEOUT = 5000;
    private static final String TAG = "BluetoothControlUtil";
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private int mConnectCount;
    private ConnectListener mConnectListener;
    private DataListener mDataListener;
    private DeviceType mDeviceType;
    private Handler mHandler;
    private boolean mIsNeedSend;
    private boolean mIsVisable;
    private Listener mListener;
    private String mSendData;
    private long mSendTime;
    private Status mStatus;
    private StringBuilder mStringBuilder;

    public enum DeviceType {
        none,
        batchdevice,
        offlinedevice,
        offlinedevice1,
        smalldevice,
        nbdevice,
        dskdevice,
        sellcard
    }

    public static abstract class Listener {
        public void onConnected() {
        }

        public void onFail(int i, String str) {
        }

        public void onReceivedData(String str) {
        }
    }

    public enum Status {
        none,
        connecting,
        connected,
        disconnect,
        senddataing,
        senddatadend,
        end
    }

    public DeviceType getDeviceType() {
        return this.mDeviceType;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public void init(Activity activity) {
        this.mActivity = activity;
    }

    public void onResume() {
        this.mIsVisable = true;
    }

    public void setDeviceType(DeviceType deviceType) {
        this.mDeviceType = deviceType;
    }

    static /* synthetic */ int access$608(BluetoothControlUtil bluetoothControlUtil) {
        int i = bluetoothControlUtil.mConnectCount;
        bluetoothControlUtil.mConnectCount = i + 1;
        return i;
    }

    private BluetoothControlUtil() {
        this.mConnectCount = 0;
        this.mDeviceType = DeviceType.none;
        this.mIsNeedSend = true;
        this.mSendData = "";
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (BluetoothControlUtil.this.mIsVisable) {
                    LogUtil.i(BluetoothControlUtil.TAG, "onConnectFail:2222");
                    BluetoothSDK.getInstance().connectDevice(BluetoothControlUtil.this.mActivity, BluetoothControlUtil.this.mBluetoothDevice);
                }
            }
        };
        this.mConnectListener = new ConnectListener() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.3
            @Override // com.lxt.bluetoothsdk.listener.ConnectListener
            public void onStartConnect(BluetoothDevice bluetoothDevice) {
                LogUtil.log("---开始连接蓝牙---");
                if (BluetoothControlUtil.this.mIsVisable) {
                    BluetoothControlUtil.this.mStringBuilder = null;
                    BluetoothControlUtil.access$608(BluetoothControlUtil.this);
                    BluetoothControlUtil.this.mStatus = Status.connecting;
                    LogUtil.e(BluetoothControlUtil.TAG, "onStartConnect");
                    LogUtil.log("开始连接蓝牙");
                }
            }

            @Override // com.lxt.bluetoothsdk.listener.ConnectListener
            public void onConnectException(BluetoothDevice bluetoothDevice, final String str, final int i) {
                if (BluetoothControlUtil.this.mIsVisable) {
                    BluetoothControlUtil.this.mStatus = Status.disconnect;
                    LogUtil.e(BluetoothControlUtil.TAG, "onConnectException:" + str + i);
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothControlUtil.this.mListener.onFail(i, str);
                        }
                    });
                    LogUtil.log("onConnectException:" + str);
                }
            }

            @Override // com.lxt.bluetoothsdk.listener.ConnectListener
            public void onConnectFail(BluetoothDevice bluetoothDevice, final String str, final int i) {
                if (!BluetoothControlUtil.this.mIsVisable || BluetoothControlUtil.this.mStatus == Status.end) {
                    return;
                }
                LogUtil.e(BluetoothControlUtil.TAG, "onConnectFail:" + str + i);
                LogUtil.log("onConnectFail:" + str + i);
                BluetoothControlUtil.this.mStatus = Status.disconnect;
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.3.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LogUtil.i(BluetoothControlUtil.TAG, "onConnectFail:" + BluetoothControlUtil.this.mConnectCount + "  2");
                        if (BluetoothControlUtil.this.mConnectCount >= 2) {
                            BluetoothControlUtil.this.mListener.onFail(i, str);
                            return;
                        }
                        LogUtil.i(BluetoothControlUtil.TAG, "onConnectFail:1111");
                        if (BluetoothControlUtil.this.mHandler != null) {
                            BluetoothControlUtil.this.mHandler.sendEmptyMessageDelayed(0, 1200L);
                        } else {
                            BluetoothControlUtil.this.mListener.onFail(i, str);
                        }
                    }
                });
            }

            @Override // com.lxt.bluetoothsdk.listener.ConnectListener
            public void onConnectSuccess(BluetoothDevice bluetoothDevice) {
                if (BluetoothControlUtil.this.mIsVisable) {
                    BluetoothControlUtil.this.mIsNeedSend = true;
                    BluetoothControlUtil.this.mStatus = Status.connected;
                    BluetoothControlUtil.this.mConnectCount = 2;
                    LogUtil.log("蓝牙连接成功");
                    LogUtil.e(BluetoothControlUtil.TAG, "蓝牙连接成功");
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.3.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BluetoothControlUtil.this.mListener != null) {
                                NBDeviceCommand.setStartReceivedFlag();
                                BluetoothControlUtil.this.mListener.onConnected();
                            }
                        }
                    });
                }
            }
        };
        this.mDataListener = new DataListener() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.4
            @Override // com.lxt.bluetoothsdk.listener.DataListener
            public void onSendDataFail(BluetoothDevice bluetoothDevice, final String str, final int i) {
                if (!BluetoothControlUtil.this.mIsVisable || BluetoothControlUtil.this.mStatus == Status.end) {
                    return;
                }
                LogUtil.log("onSendDataFail:" + str + i);
                if (BluetoothControlUtil.this.mListener != null) {
                    MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothControlUtil.this.mListener.onFail(i, str);
                        }
                    });
                }
            }

            @Override // com.lxt.bluetoothsdk.listener.DataListener
            public void onReceivedData(BluetoothDevice bluetoothDevice, String str) {
                if (BluetoothControlUtil.this.mIsVisable) {
                    BluetoothControlUtil.this.mIsNeedSend = false;
                    LogUtil.i(BluetoothControlUtil.TAG, "onReceivedData:" + BluetoothControlUtil.this.mDeviceType);
                    LogUtil.log("蓝牙收到数据:" + str);
                    if (BluetoothControlUtil.this.mDeviceType == DeviceType.none) {
                        String strOnManageReceivedData = BluetoothControlUtil.this.onManageReceivedData(str);
                        LogUtil.i(BluetoothControlUtil.TAG, "onReceivedData:" + BluetoothControlUtil.this.mDeviceType);
                        if (BluetoothControlUtil.this.mDeviceType == DeviceType.nbdevice) {
                            BluetoothControlUtil.this.manageNBDeviceData(strOnManageReceivedData);
                            return;
                        }
                        if (BluetoothControlUtil.this.mDeviceType == DeviceType.smalldevice) {
                            BluetoothControlUtil.this.manageSmallDeviceData(strOnManageReceivedData);
                            return;
                        } else {
                            if (BluetoothControlUtil.this.mDeviceType == DeviceType.batchdevice || BluetoothControlUtil.this.mDeviceType == DeviceType.offlinedevice || BluetoothControlUtil.this.mDeviceType == DeviceType.offlinedevice1) {
                                BluetoothControlUtil.this.manageBatchDeviceData(strOnManageReceivedData);
                                return;
                            }
                            return;
                        }
                    }
                    if (BluetoothControlUtil.this.mDeviceType == DeviceType.nbdevice) {
                        BluetoothControlUtil.this.manageNBDeviceData(str);
                        return;
                    }
                    if (BluetoothControlUtil.this.mDeviceType == DeviceType.dskdevice) {
                        BluetoothControlUtil.this.manageDSKDeviceData(str);
                        return;
                    }
                    if (BluetoothControlUtil.this.mDeviceType == DeviceType.smalldevice) {
                        BluetoothControlUtil.this.manageSmallDeviceData(str);
                        return;
                    }
                    if (BluetoothControlUtil.this.mDeviceType == DeviceType.batchdevice || BluetoothControlUtil.this.mDeviceType == DeviceType.offlinedevice || BluetoothControlUtil.this.mDeviceType == DeviceType.offlinedevice1) {
                        BluetoothControlUtil.this.manageBatchDeviceData(str);
                    } else if (BluetoothControlUtil.this.mDeviceType == DeviceType.sellcard) {
                        BluetoothControlUtil.this.manageSellCardDeviceData(str);
                    }
                }
            }
        };
    }

    private static final class SingleHolder {
        private static final BluetoothControlUtil INSTANCE = new BluetoothControlUtil();

        private SingleHolder() {
        }
    }

    public static BluetoothControlUtil getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            return;
        }
        this.mActivity.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
    }

    public void initDeviceType() {
        this.mDeviceType = DeviceType.none;
    }

    public void onPause() {
        this.mIsVisable = false;
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void connectBluetooth(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            LogUtil.e(TAG, bluetoothDevice.address + PPSLabelView.Code + bluetoothDevice.name);
            LogUtil.log("------开始连接蓝牙------");
            LogUtil.log(bluetoothDevice.address + PPSLabelView.Code + bluetoothDevice.name);
            this.mBluetoothDevice = bluetoothDevice;
        }
        this.mConnectCount = 0;
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.2
            @Override // java.lang.Runnable
            public void run() {
                BluetoothSDK.getInstance().connectDevice(BluetoothControlUtil.this.mActivity, BluetoothControlUtil.this.mBluetoothDevice);
            }
        }, 200L);
    }

    public void disconnect() {
        this.mStatus = Status.end;
        BluetoothSDK.getInstance().disconnectDevice();
        LogUtil.log("----------断开蓝牙连接-----------");
    }

    public void setListener(Listener listener) {
        BluetoothSDK.getInstance().setConnectListener(this.mConnectListener);
        BluetoothSDK.getInstance().setDataListener(this.mDataListener);
        this.mListener = listener;
    }

    public void setDeviceType(String str) {
        if (str.equalsIgnoreCase(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1)) {
            this.mDeviceType = DeviceType.batchdevice;
            return;
        }
        if (str.equalsIgnoreCase(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2)) {
            this.mDeviceType = DeviceType.offlinedevice;
            return;
        }
        if (str.equalsIgnoreCase(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
            this.mDeviceType = DeviceType.smalldevice;
        } else if (str.equalsIgnoreCase(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) {
            this.mDeviceType = DeviceType.offlinedevice1;
        } else if (str.equalsIgnoreCase("00,08")) {
            this.mDeviceType = DeviceType.sellcard;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageNBDeviceData(String str) {
        Activity activity = this.mActivity;
        if (activity != null && LocalDataUtil.getPlatformInfo(activity) == 4) {
            manageV4DeviceData(str);
            return;
        }
        final String strReceivedDataNew = NBDeviceCommand.receivedDataNew(str);
        LogUtil.e(TAG, "manageNBDeviceData:" + strReceivedDataNew);
        if (StringUtils.isNotEmpty(strReceivedDataNew)) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.5
                @Override // java.lang.Runnable
                public void run() {
                    String strReceivedDataManage = strReceivedDataNew;
                    if (NBDeviceCommand.getTransferredMeaning()) {
                        LogUtil.i(BluetoothControlUtil.TAG, "需要转义");
                        strReceivedDataManage = NBDeviceCommand.receivedDataManage(strReceivedDataNew);
                    }
                    if (BluetoothControlUtil.this.mListener != null) {
                        BluetoothControlUtil.this.mStatus = Status.senddatadend;
                        BluetoothControlUtil.this.mListener.onReceivedData(strReceivedDataManage);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageDSKDeviceData(String str) {
        final String resultData = DSKReceivedDataUtil.getResultData(str);
        if (StringUtils.isNotEmpty(resultData)) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.6
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothControlUtil.this.mListener != null) {
                        BluetoothControlUtil.this.mStatus = Status.senddatadend;
                        BluetoothControlUtil.this.mListener.onReceivedData(resultData);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageSmallDeviceData(final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.7
            @Override // java.lang.Runnable
            public void run() {
                if (BluetoothControlUtil.this.mListener != null) {
                    BluetoothControlUtil.this.mStatus = Status.senddatadend;
                    BluetoothControlUtil.this.mListener.onReceivedData(str);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageBatchDeviceData(String str) {
        final String strReceivedData = BluetoothDeviceCommand.receivedData(str);
        if (StringUtils.isNotEmpty(strReceivedData) && strReceivedData.startsWith("550001")) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.8
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothControlUtil.this.mListener != null) {
                        BluetoothControlUtil.this.mStatus = Status.senddatadend;
                        BluetoothControlUtil.this.mListener.onReceivedData(strReceivedData);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageSellCardDeviceData(final String str) {
        if (StringUtils.isNotEmpty(str)) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.9
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothControlUtil.this.mListener != null) {
                        BluetoothControlUtil.this.mStatus = Status.senddatadend;
                        BluetoothControlUtil.this.mListener.onReceivedData(str);
                    }
                }
            });
        }
    }

    private void manageV4DeviceData(String str) {
        final String strReceivedDataNew = V4DeviceCommand.receivedDataNew(str);
        LogUtil.e(TAG, "manageV4DeviceData:" + strReceivedDataNew);
        if (StringUtils.isNotEmpty(strReceivedDataNew)) {
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.10
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothControlUtil.this.mListener == null || !V4DeviceCommand.isCheckData(strReceivedDataNew)) {
                        return;
                    }
                    BluetoothControlUtil.this.mStatus = Status.senddatadend;
                    BluetoothControlUtil.this.mListener.onReceivedData(strReceivedDataNew);
                }
            });
        }
    }

    public void setSendTimeOut(int i) {
        this.mStatus = Status.senddataing;
        this.mSendTime = System.currentTimeMillis();
        MainThreadExecutor.getInstance().executeDelayed(new CheckTimeOut(i), i);
    }

    public void sendData(String str) {
        this.mSendData = str;
        LogUtil.log("蓝牙发送数据:" + str);
        V4DeviceCommand.reSetReceived();
        BluetoothSDK.getInstance().sendData(str);
    }

    public void sendDataInNeedSend(String str) {
        this.mIsNeedSend = true;
        this.mSendData = str;
        LogUtil.log("蓝牙发送数据:" + str);
        BluetoothSDK.getInstance().sendData(str);
    }

    private class CheckTimeOut implements Runnable {
        int time;

        public CheckTimeOut(int i) {
            this.time = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            LogUtil.i(BluetoothControlUtil.TAG, BluetoothControlUtil.this.mStatus + "  " + (System.currentTimeMillis() - BluetoothControlUtil.this.mSendTime) + "  " + this.time + "  " + (BluetoothControlUtil.this.mListener != null));
            if (BluetoothControlUtil.this.mStatus != Status.senddataing || System.currentTimeMillis() - BluetoothControlUtil.this.mSendTime < this.time) {
                return;
            }
            MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.CheckTimeOut.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothControlUtil.this.mIsNeedSend) {
                        BluetoothControlUtil.this.mIsNeedSend = false;
                        BluetoothControlUtil.this.setSendTimeOut(3000);
                        BluetoothControlUtil.this.sendData(BluetoothControlUtil.this.mSendData);
                    } else if (BluetoothControlUtil.this.mListener != null) {
                        BluetoothControlUtil.this.mListener.onFail(10000, BluetoothControlUtil.this.mActivity.getString(R.string.senddata_timeout));
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String onManageReceivedData(String str) {
        if (this.mStringBuilder == null) {
            this.mStringBuilder = new StringBuilder();
        }
        this.mStringBuilder.append(str.toUpperCase());
        if (this.mStringBuilder.toString().startsWith("A5") && this.mStringBuilder.length() > 2) {
            this.mDeviceType = DeviceType.nbdevice;
        } else if (this.mStringBuilder.toString().startsWith("A5") && this.mStringBuilder.length() == 2) {
            this.mDeviceType = DeviceType.smalldevice;
        } else if (this.mStringBuilder.toString().startsWith("550001") && this.mStringBuilder.length() >= 12 && this.mStringBuilder.toString().substring(10, 12).equalsIgnoreCase("f5")) {
            int i = Integer.parseInt(this.mStringBuilder.toString().substring(6, 8), 16);
            LogUtil.i("test", "长度：" + i);
            if (i >= 36) {
                if (this.mStringBuilder.length() > 74) {
                    String strSubstring = this.mStringBuilder.toString().substring(70, 74);
                    LogUtil.i("test", strSubstring);
                    if (strSubstring.equalsIgnoreCase("5631")) {
                        this.mDeviceType = DeviceType.offlinedevice1;
                    } else {
                        this.mDeviceType = DeviceType.offlinedevice;
                    }
                }
            } else {
                this.mDeviceType = DeviceType.batchdevice;
            }
        } else if (this.mStringBuilder.toString().startsWith("55") && this.mStringBuilder.length() == 40) {
            this.mDeviceType = DeviceType.smalldevice;
        }
        return this.mStringBuilder.toString();
    }
}
