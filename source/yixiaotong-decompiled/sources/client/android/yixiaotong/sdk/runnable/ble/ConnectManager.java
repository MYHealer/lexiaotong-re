package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.text.TextUtils;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.ConnectManagerListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.LocalBusinessStore;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import client.android.yixiaotong.util.TimeUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class ConnectManager {
    private boolean connectState;
    private boolean isNetworkStatus;
    private boolean isRunning;
    private short mBalance;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private BluetoothGattCallback mBluetoothGattCallback;
    private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private String mDeviceHexNo;
    private ConnectManagerListener mOpenListener;
    private long mStudentNo;

    public static class SingletonHolder {
        public static final ConnectManager INSTANCE = new ConnectManager();
    }

    public void connect(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice) {
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
    }

    public void setOpenListener(ConnectManagerListener connectManagerListener) {
        this.mOpenListener = connectManagerListener;
    }

    private ConnectManager() {
        this.connectState = false;
        this.mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.8
            public StringBuilder stringBuilder;
            private byte[] mLastCharacteristicData = null;
            public int leftCount = 0;

            @Override // android.bluetooth.BluetoothGattCallback
            public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
                super.onConnectionStateChange(bluetoothGatt, i, i2);
                if (i != 0) {
                    ConnectManager.this.connectState = false;
                    ConnectManager.this.closeGatt();
                    return;
                }
                if (i2 != 2) {
                    if (i2 == 0) {
                        ConnectManager.this.connectState = false;
                        ConnectManager.this.closeGatt();
                        return;
                    } else {
                        ConnectManager.this.connectState = false;
                        ConnectManager.this.closeGatt();
                        return;
                    }
                }
                String address = bluetoothGatt.getDevice().getAddress();
                if (address == null || ConnectManager.this.mCurrentHardware == null || !address.equals(ConnectManager.this.mCurrentHardware.address) || ConnectManager.this.mCurrentHardware.isTimeout || !ConnectManager.this.isRunning) {
                    return;
                }
                ConnectManager.this.mBluetoothGattCharacteristic = null;
                ConnectManager.this.checkTimeOut(TimeOut.Discover, 6000);
                bluetoothGatt.discoverServices();
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
                if (i != 0) {
                    if (i == 257) {
                        ConnectManager.this.connectState = false;
                        return;
                    }
                    return;
                }
                String address = bluetoothGatt.getDevice().getAddress();
                if (address != null && address.equals(ConnectManager.this.mCurrentHardware.address) && !ConnectManager.this.mCurrentHardware.isTimeout && ConnectManager.this.isRunning) {
                    List<BluetoothGattService> services = bluetoothGatt.getServices();
                    if (services != null) {
                        Iterator<BluetoothGattService> it = services.iterator();
                        while (it.hasNext()) {
                            List<BluetoothGattCharacteristic> characteristics = it.next().getCharacteristics();
                            if (characteristics != null) {
                                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                    if (bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                        ConnectManager.this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if (ConnectManager.this.mBluetoothGattCharacteristic != null) {
                        ConnectManager.this.mBluetoothGatt.setCharacteristicNotification(ConnectManager.this.mBluetoothGattCharacteristic, true);
                        BluetoothGattDescriptor descriptor = ConnectManager.this.mBluetoothGattCharacteristic.getDescriptor(BluetoothDevice.DESCRIPTOR_UUID);
                        if (descriptor != null) {
                            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            ConnectManager.this.mBluetoothGatt.writeDescriptor(descriptor);
                        }
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (ConnectManager.this.mCurrentHardware.isTimeout || !ConnectManager.this.isRunning) {
                                    return;
                                }
                                ConnectManager.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
                                ConnectManager.this.writeGatt(ConnectManager.this.mBluetoothGattCharacteristic, CommandUtilsWrapper.getReturnSettingCommand());
                            }
                        }, 100L);
                    }
                }
            }

            @Override // android.bluetooth.BluetoothGattCallback
            public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
                String address = bluetoothGatt.getDevice().getAddress();
                if (address != null && address.equals(ConnectManager.this.mCurrentHardware.address) && !ConnectManager.this.mCurrentHardware.isTimeout && ConnectManager.this.isRunning) {
                    readData(bluetoothGattCharacteristic.getValue());
                }
            }

            private void readData(byte[] bArr) {
                StringBuilder sb;
                String str;
                byte[] bArr2 = this.mLastCharacteristicData;
                if (bArr2 == null || !Arrays.equals(bArr2, bArr)) {
                    this.mLastCharacteristicData = bArr;
                    String strBufferToHex = HexString.bufferToHex(bArr);
                    if (!strBufferToHex.startsWith("550001") || strBufferToHex.length() < 8) {
                        StringBuilder sb2 = this.stringBuilder;
                        if (sb2 == null) {
                            return;
                        }
                        sb2.append(strBufferToHex);
                        this.leftCount -= strBufferToHex.length();
                    } else {
                        StringBuilder sb3 = new StringBuilder();
                        this.stringBuilder = sb3;
                        sb3.append(strBufferToHex);
                        byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex.substring(6, 8));
                        byte[] bArr3 = new byte[4];
                        System.arraycopy(bArrHexToBuffer, 0, bArr3, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                        this.leftCount = ((IntegerUtils.bytesToInt2(bArr3, 0) - 1) * 2) - (strBufferToHex.length() - 6);
                    }
                    if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                        return;
                    }
                    byte[] bArrHexToBuffer2 = HexString.hexToBuffer(sb.toString());
                    this.stringBuilder = null;
                    if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer2)) {
                        if (!CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer2)) {
                            ConnectManager connectManager = ConnectManager.this;
                            connectManager.callOnFail(connectManager.mCurrentHardware, null, "终止消费失败");
                            return;
                        }
                        String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer2);
                        if (TextUtils.isEmpty(returnSettingDeviceIdResult) || !returnSettingDeviceIdResult.startsWith("0212")) {
                            ConnectManager connectManager2 = ConnectManager.this;
                            connectManager2.callOnFail(connectManager2.mCurrentHardware, null, "终止消费失败");
                            return;
                        } else {
                            ConnectManager.this.connectState = true;
                            ConnectManager connectManager3 = ConnectManager.this;
                            connectManager3.callOnSuccessConnect(connectManager3.mCurrentHardware);
                            return;
                        }
                    }
                    if (CommandUtilsWrapper.isConnectResult(bArrHexToBuffer2)) {
                        short connectResultStatus = CommandUtilsWrapper.getConnectResultStatus(bArrHexToBuffer2);
                        if (connectResultStatus == 0) {
                            if (ConnectManager.this.isNetworkStatus) {
                                ConnectManager.this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer2);
                                long connectResultUserId = CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer2);
                                short sMax = (short) Math.max(0, (int) CommandUtilsWrapper.getConnectResultBalance(bArrHexToBuffer2));
                                try {
                                    str = String.valueOf(Calendar.getInstance().get(1)) + new SimpleDateFormat("-MM-dd HH:mm:ss").format(new SimpleDateFormat("MMddHHmmss").parse(CommandUtilsWrapper.getConnectResultTime(bArrHexToBuffer2)));
                                } catch (ParseException unused) {
                                    str = new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date());
                                }
                                final OrderBean orderBean = new OrderBean();
                                orderBean.studentNo = connectResultUserId;
                                orderBean.money = sMax;
                                orderBean.time = str;
                                AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.8.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (!ConnectManager.this.callNeedUploadOrder(ConnectManager.this.mCurrentHardware, orderBean)) {
                                            ConnectManager.this.callOnFail(ConnectManager.this.mCurrentHardware, null, "不允许脱网使用");
                                            return;
                                        }
                                        ConnectManager.this.mBalance = ConnectManager.this.callBalance(ConnectManager.this.mCurrentHardware);
                                        if (ConnectManager.this.mBalance > 0) {
                                            LocalBusinessStore.saveOfflineCount(ConnectManager.this.mContext, ConnectManager.this.mStudentNo, 0);
                                            ConnectManager.this.sendConfirmData();
                                        } else {
                                            ConnectManager.this.callOnFail(ConnectManager.this.mCurrentHardware, null, "余额不足");
                                        }
                                    }
                                });
                                return;
                            }
                            ConnectManager.this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer2);
                            ConnectManager.this.sendConfirmData();
                            return;
                        }
                        if (connectResultStatus == 1) {
                            ConnectManager connectManager4 = ConnectManager.this;
                            connectManager4.callOnFail(connectManager4.mCurrentHardware, null, "连接失败");
                            return;
                        }
                        if (connectResultStatus == 2) {
                            if (ConnectManager.this.isNetworkStatus) {
                                LocalBusinessStore.saveOfflineCount(ConnectManager.this.mContext, ConnectManager.this.mStudentNo, 0);
                                ConnectManager.this.mDeviceHexNo = CommandUtilsWrapper.getConnectResultDeviceHexNo(bArrHexToBuffer2);
                                ConnectManager.this.sendConfirmData();
                                return;
                            } else {
                                ConnectManager connectManager5 = ConnectManager.this;
                                connectManager5.callOnFail(connectManager5.mCurrentHardware, null, "余额不足");
                                return;
                            }
                        }
                        if (connectResultStatus != 15) {
                            ConnectManager connectManager6 = ConnectManager.this;
                            connectManager6.callOnFail(connectManager6.mCurrentHardware, null, "连接失败");
                            return;
                        }
                        String hexString = Long.toHexString(CommandUtilsWrapper.getConnectResultUserId(bArrHexToBuffer2));
                        String hexString2 = Long.toHexString(ConnectManager.this.mStudentNo);
                        if (hexString.length() > 6) {
                            hexString = hexString.substring(5);
                        }
                        if (hexString2.length() > 6) {
                            hexString2 = hexString2.substring(5);
                        }
                        if (hexString.equals(hexString2)) {
                            ConnectManager.this.sendAbortData();
                            return;
                        } else {
                            ConnectManager connectManager7 = ConnectManager.this;
                            connectManager7.callOnFail(connectManager7.mCurrentHardware, null, "设备正忙,无法使用");
                            return;
                        }
                    }
                    if (CommandUtilsWrapper.isConfirmResult(bArrHexToBuffer2)) {
                        short confirmResultStatus = CommandUtilsWrapper.getConfirmResultStatus(bArrHexToBuffer2);
                        if (confirmResultStatus == 0) {
                            ConnectManager connectManager8 = ConnectManager.this;
                            connectManager8.callOnSuccessSendData(connectManager8.mCurrentHardware, ConnectManager.this.isNetworkStatus);
                            return;
                        }
                        if (confirmResultStatus == 1) {
                            ConnectManager connectManager9 = ConnectManager.this;
                            connectManager9.callOnFail(connectManager9.mCurrentHardware, null, "连接失败,确认订单上传失败");
                            return;
                        }
                        if (confirmResultStatus == 2) {
                            ConnectManager connectManager10 = ConnectManager.this;
                            connectManager10.callOnFail(connectManager10.mCurrentHardware, null, "连接失败,余额不足");
                            return;
                        }
                        if (confirmResultStatus == 3) {
                            ConnectManager connectManager11 = ConnectManager.this;
                            connectManager11.callOnSuccessSendData(connectManager11.mCurrentHardware, ConnectManager.this.isNetworkStatus);
                            return;
                        }
                        if (confirmResultStatus == 5) {
                            AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.8.3
                                @Override // java.lang.Runnable
                                public void run() {
                                    String strCallOnOpenDate = ConnectManager.this.callOnOpenDate(ConnectManager.this.mCurrentHardware);
                                    if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                                        ConnectManager.this.sendConnectData(strCallOnOpenDate);
                                    }
                                }
                            });
                            return;
                        }
                        if (confirmResultStatus == 13) {
                            ConnectManager connectManager12 = ConnectManager.this;
                            connectManager12.callOnFail(connectManager12.mCurrentHardware, null, "空间不足,不允许脱网消费");
                            return;
                        } else if (confirmResultStatus == 14) {
                            ConnectManager connectManager13 = ConnectManager.this;
                            connectManager13.callOnFail(connectManager13.mCurrentHardware, null, "写存储器失败");
                            return;
                        } else if (confirmResultStatus == 15) {
                            ConnectManager connectManager14 = ConnectManager.this;
                            connectManager14.callOnFail(connectManager14.mCurrentHardware, null, "设备正忙,无法使用");
                            return;
                        } else {
                            ConnectManager connectManager15 = ConnectManager.this;
                            connectManager15.callOnFail(connectManager15.mCurrentHardware, null, "连接失败,确认订单上传失败");
                            return;
                        }
                    }
                    if (CommandUtilsWrapper.isAbortResult(bArrHexToBuffer2)) {
                        if (!CommandUtilsWrapper.getAbortResultStatus(bArrHexToBuffer2)) {
                            ConnectManager connectManager16 = ConnectManager.this;
                            connectManager16.callOnFail(connectManager16.mCurrentHardware, null, "连接失败,请重启设备");
                        } else {
                            AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.8.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    String strCallOnOpenDate = ConnectManager.this.callOnOpenDate(ConnectManager.this.mCurrentHardware);
                                    if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                                        ConnectManager.this.sendConnectData(strCallOnOpenDate);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        };
    }

    public static ConnectManager getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.mCurrentCheckTimeOut = null;
        callOnStart(this.mCurrentHardware);
        if (BluetoothUtils.isBluetoothOn(this.mContext) && BluetoothUtils.isBluetoothLeSupported(this.mContext)) {
            closeGatt();
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.1
                @Override // java.lang.Runnable
                public void run() {
                    ConnectManager.this.mCurrentHardware.isTimeout = false;
                    android.bluetooth.BluetoothDevice remoteDevice = ConnectManager.this.mBluetoothAdapter.getRemoteDevice(ConnectManager.this.mCurrentHardware.address);
                    ConnectManager.this.checkTimeOut(TimeOut.Connect, 5000);
                    ConnectManager connectManager = ConnectManager.this;
                    connectManager.mBluetoothGatt = remoteDevice.connectGatt(connectManager.mContext, false, ConnectManager.this.mBluetoothGattCallback);
                }
            }, 1500L);
        } else {
            callOnBluetoothException(new ClientException("蓝牙不可用或不支持BLE"));
        }
    }

    public void sendData(long j, short s, boolean z) {
        this.isNetworkStatus = z;
        this.isRunning = true;
        this.mStudentNo = j;
        this.mBalance = s;
        if (this.connectState) {
            callOnStart(this.mCurrentHardware);
            AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.2
                @Override // java.lang.Runnable
                public void run() {
                    ConnectManager connectManager = ConnectManager.this;
                    String strCallOnOpenDate = connectManager.callOnOpenDate(connectManager.mCurrentHardware);
                    if (StringUtils.isNotEmpty(strCallOnOpenDate)) {
                        ConnectManager.this.sendConnectData(strCallOnOpenDate);
                    }
                }
            });
        } else {
            this.isRunning = false;
            start();
        }
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        BluetoothDevice bluetoothDevice = this.mCurrentHardware;
        if (bluetoothDevice != null) {
            bluetoothDevice.isTimeout = false;
        }
        this.connectState = false;
        closeGatt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeGatt() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            try {
                bluetoothGatt.disconnect();
            } catch (Exception unused) {
            }
            try {
                this.mBluetoothGatt.close();
            } catch (Exception unused2) {
            }
            this.mBluetoothGatt = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeGatt(BluetoothGattCharacteristic bluetoothGattCharacteristic, String str) {
        if (this.mBluetoothGatt == null || bluetoothGattCharacteristic == null) {
            return;
        }
        bluetoothGattCharacteristic.setValue(HexString.hexToBuffer(str));
        bluetoothGattCharacteristic.setWriteType(2);
        this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.3
            @Override // java.lang.Runnable
            public void run() {
                if (!ConnectManager.this.isRunning || ConnectManager.this.mOpenListener == null) {
                    return;
                }
                ConnectManager.this.mOpenListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccessConnect(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectManager.this.isRunning && ConnectManager.this.mOpenListener != null) {
                        ConnectManager.this.mOpenListener.onSuccessConnect(bluetoothDevice);
                    }
                } finally {
                    ConnectManager.this.isRunning = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String callOnOpenDate(BluetoothDevice bluetoothDevice) {
        ConnectManagerListener connectManagerListener;
        try {
            return (!this.isRunning || (connectManagerListener = this.mOpenListener) == null) ? "" : connectManagerListener.onOpenDate(bluetoothDevice);
        } catch (Exception unused) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccessSendData(final BluetoothDevice bluetoothDevice, final boolean z) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectManager.this.isRunning && ConnectManager.this.mOpenListener != null) {
                        ConnectManager.this.mOpenListener.onSuccessSendData(bluetoothDevice, z);
                    }
                } finally {
                    ConnectManager.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectManager.this.isRunning && ConnectManager.this.mOpenListener != null) {
                        ConnectManager.this.mOpenListener.onFail(bluetoothDevice, timeOut, str);
                    }
                } finally {
                    ConnectManager.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.ConnectManager.7
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (ConnectManager.this.isRunning && ConnectManager.this.mOpenListener != null) {
                        ConnectManager.this.mOpenListener.onBluetoothException(clientException);
                    }
                } finally {
                    ConnectManager.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean callNeedUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
        ConnectManagerListener connectManagerListener;
        try {
            if (!this.isRunning || (connectManagerListener = this.mOpenListener) == null) {
                return false;
            }
            return connectManagerListener.needUploadOrder(bluetoothDevice, orderBean);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public short callBalance(BluetoothDevice bluetoothDevice) {
        ConnectManagerListener connectManagerListener;
        try {
            if (!this.isRunning || (connectManagerListener = this.mOpenListener) == null) {
                return (short) 0;
            }
            return connectManagerListener.callBalance(bluetoothDevice);
        } catch (Exception unused) {
            return (short) 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ConnectManager.this.isRunning && this.timeOut == ConnectManager.this.mCurrentCheckTimeOut) {
                ConnectManager.this.mCurrentHardware.isTimeout = true;
                ConnectManager connectManager = ConnectManager.this;
                connectManager.callOnFail(connectManager.mCurrentHardware, this.timeOut, null);
            }
        }
    }

    private void sendSettingData() {
        String returnSettingCommand = CommandUtilsWrapper.getReturnSettingCommand();
        checkTimeOut(TimeOut.SendGetDeviceSettingCommand, 1500);
        writeGatt(this.mBluetoothGattCharacteristic, returnSettingCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConnectData(String str) {
        if (this.isNetworkStatus) {
            String onlineConnectCommand = CommandUtilsWrapper.getOnlineConnectCommand(this.mStudentNo, str);
            checkTimeOut(TimeOut.SendConnect, 15000);
            writeGatt(this.mBluetoothGattCharacteristic, onlineConnectCommand);
        } else {
            String offlineConnectCommand = CommandUtilsWrapper.getOfflineConnectCommand(this.mStudentNo, str);
            checkTimeOut(TimeOut.SendConnect, 15000);
            writeGatt(this.mBluetoothGattCharacteristic, offlineConnectCommand);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendConfirmData() {
        if (this.isNetworkStatus) {
            String onlineConfirmCommand = CommandUtilsWrapper.getOnlineConfirmCommand(this.mStudentNo, this.mBalance, this.mDeviceHexNo);
            checkTimeOut(TimeOut.SendConfirm, 10000);
            writeGatt(this.mBluetoothGattCharacteristic, onlineConfirmCommand);
        } else {
            String offlineConfirmCommand = CommandUtilsWrapper.getOfflineConfirmCommand(this.mStudentNo, this.mBalance, this.mDeviceHexNo);
            checkTimeOut(TimeOut.SendConfirm, 10000);
            writeGatt(this.mBluetoothGattCharacteristic, offlineConfirmCommand);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAbortData() {
        String abortCommand = CommandUtilsWrapper.getAbortCommand();
        checkTimeOut(TimeOut.SendAbort, 1500);
        writeGatt(this.mBluetoothGattCharacteristic, abortCommand);
    }
}
