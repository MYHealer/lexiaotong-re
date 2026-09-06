package client.android.yixiaotong.sdk.runnable.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Log;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.core.CommandUtilsWrapper;
import client.android.yixiaotong.sdk.runnable.DeviceBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.InitListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.IntegerUtils;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.sdk.utils.executor.AsyncQueueExecutor;
import client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor;
import com.alipay.sdk.data.a;
import com.alipay.sdk.widget.j;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class InitRunnable {
    private boolean isRunning;
    private BluetoothAdapter mBluetoothAdapter;
    private BluetoothGatt mBluetoothGatt;
    private Context mContext;
    private TimeOut mCurrentCheckTimeOut;
    private BluetoothDevice mCurrentHardware;
    private boolean mHasQrcode;
    private InitListener mInitListener;
    private String mF5Data = "";
    private String mLeftSendData = "";
    private String mSendData = "";
    private BluetoothGattCallback mBluetoothGattCallback = new BluetoothGattCallback() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.7
        public int leftCount = 0;
        private BluetoothGattCharacteristic mBluetoothGattCharacteristic;
        private int mCommandIndex;
        private String[] mCommands;
        private String mDeviceHexID;
        public StringBuilder stringBuilder;

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i, int i2) {
            super.onConnectionStateChange(bluetoothGatt, i, i2);
            if (i != 0 || i2 != 2) {
                InitRunnable initRunnable = InitRunnable.this;
                initRunnable.callOnFail(initRunnable.mCurrentHardware, TimeOut.Connect);
                return;
            }
            String address = bluetoothGatt.getDevice().getAddress();
            if (address == null || InitRunnable.this.mCurrentHardware == null || !address.equals(InitRunnable.this.mCurrentHardware.address) || InitRunnable.this.mCurrentHardware.isTimeout || !InitRunnable.this.isRunning) {
                return;
            }
            this.mBluetoothGattCharacteristic = null;
            InitRunnable.this.checkTimeOut(TimeOut.Discover, 5000);
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bluetoothGatt.discoverServices();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i) {
            String address;
            List<BluetoothGattDescriptor> descriptors;
            if (i == 0 && (address = bluetoothGatt.getDevice().getAddress()) != null && address.equals(InitRunnable.this.mCurrentHardware.address) && !InitRunnable.this.mCurrentHardware.isTimeout && InitRunnable.this.isRunning) {
                List<BluetoothGattService> services = bluetoothGatt.getServices();
                if (services != null) {
                    Iterator<BluetoothGattService> it = services.iterator();
                    while (it.hasNext()) {
                        List<BluetoothGattCharacteristic> characteristics = it.next().getCharacteristics();
                        if (characteristics != null) {
                            if (characteristics.size() == 1) {
                                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
                                    if (bluetoothGattCharacteristic != null && bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                        this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic;
                                        InitRunnable.this.mBluetoothGatt.setCharacteristicNotification(this.mBluetoothGattCharacteristic, true);
                                        for (UUID uuid : InitRunnable.this.mCurrentHardware.getBluetoothDeviceAdapter()) {
                                            BluetoothGattDescriptor descriptor = this.mBluetoothGattCharacteristic.getDescriptor(uuid);
                                            if (descriptor != null) {
                                                descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                InitRunnable.this.mBluetoothGatt.writeDescriptor(descriptor);
                                                break;
                                            }
                                        }
                                        break;
                                    }
                                }
                            } else if (characteristics.size() >= 2) {
                                for (BluetoothGattCharacteristic bluetoothGattCharacteristic2 : characteristics) {
                                    if (bluetoothGattCharacteristic2 != null && bluetoothGattCharacteristic2.getUuid().toString().toLowerCase().indexOf("0000ffe2") == 0) {
                                        this.mBluetoothGattCharacteristic = bluetoothGattCharacteristic2;
                                    } else if (bluetoothGattCharacteristic2 != null && bluetoothGattCharacteristic2.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                                        if (InitRunnable.this.mBluetoothGatt != null) {
                                            InitRunnable.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true);
                                        }
                                        if (InitRunnable.this.mBluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic2, true) && (descriptors = bluetoothGattCharacteristic2.getDescriptors()) != null && descriptors.size() > 0) {
                                            for (BluetoothGattDescriptor bluetoothGattDescriptor : descriptors) {
                                                bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                                                InitRunnable.this.mBluetoothGatt.writeDescriptor(bluetoothGattDescriptor);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this.mBluetoothGattCharacteristic != null) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InitRunnable.this.mCurrentHardware.isTimeout || !InitRunnable.this.isRunning) {
                                return;
                            }
                            InitRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSettingCommand, a.f1633a);
                            InitRunnable.this.writeGatt(AnonymousClass7.this.mBluetoothGattCharacteristic, CommandUtilsWrapper.getReturnSettingCommand());
                        }
                    }, 100L);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            String address = bluetoothGatt.getDevice().getAddress();
            if (address != null && address.equals(InitRunnable.this.mCurrentHardware.address) && !InitRunnable.this.mCurrentHardware.isTimeout && InitRunnable.this.isRunning) {
                readData(bluetoothGattCharacteristic.getValue());
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i) {
            super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i);
            if (StringUtils.isNotEmpty(InitRunnable.this.mLeftSendData)) {
                InitRunnable initRunnable = InitRunnable.this;
                initRunnable.writeGatt(this.mBluetoothGattCharacteristic, initRunnable.mLeftSendData);
            }
        }

        private void sendSettingParamsData(String str) {
            if (!StringUtils.isNotEmpty(InitRunnable.this.mF5Data) || InitRunnable.this.mF5Data.length() <= 74 || !InitRunnable.this.mF5Data.substring(70, 74).equalsIgnoreCase("5631")) {
                InitRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSetting, 3000);
                InitRunnable.this.writeGatt(this.mBluetoothGattCharacteristic, CommandUtilsWrapper.getSettingCommand(str.substring(0, 24) + "0001" + str.substring(28, 32), client.android.yixiaotong.util.bluetooth.BluetoothDevice.DEFAULT_DEVICEHEXNO));
            } else {
                InitRunnable.this.checkTimeOut(TimeOut.SendGetDeviceSetting, 3000);
                InitRunnable.this.writeGatt(this.mBluetoothGattCharacteristic, CommandUtilsWrapper.getSettingCommand(str.substring(0, 12) + "00" + new SimpleDateFormat("yyMMddHHmm").format(Calendar.getInstance().getTime()) + InitRunnable.this.mF5Data.substring(66, 68) + "01" + str.substring(20, 24), client.android.yixiaotong.util.bluetooth.BluetoothDevice.DEFAULT_DEVICEHEXNO));
            }
        }

        private void readData(byte[] bArr) {
            StringBuilder sb;
            String strBufferToHex = HexString.bufferToHex(bArr);
            Log.e("test", "初始化收到数据:" + strBufferToHex);
            if (strBufferToHex.startsWith("550001") && strBufferToHex.length() >= 8) {
                StringBuilder sb2 = new StringBuilder();
                this.stringBuilder = sb2;
                sb2.append(strBufferToHex);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(strBufferToHex.substring(6, 8));
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr2, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                this.leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) + 1) * 2) - (strBufferToHex.length() - 6);
            } else {
                StringBuilder sb3 = this.stringBuilder;
                if (sb3 != null && sb3.toString().length() >= 8) {
                    this.stringBuilder.append(strBufferToHex);
                    this.leftCount -= strBufferToHex.length();
                } else {
                    StringBuilder sb4 = this.stringBuilder;
                    if (sb4 != null && sb4.toString().length() < 8) {
                        this.stringBuilder.append(strBufferToHex);
                        if (this.stringBuilder.toString().length() >= 8) {
                            byte[] bArrHexToBuffer2 = HexString.hexToBuffer(this.stringBuilder.toString().substring(6, 8));
                            byte[] bArr3 = new byte[4];
                            System.arraycopy(bArrHexToBuffer2, 0, bArr3, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                            this.leftCount = ((IntegerUtils.bytesToInt2(bArr3, 0) + 1) * 2) - (this.stringBuilder.toString().length() - 6);
                        }
                    } else {
                        if (!strBufferToHex.startsWith("55") || strBufferToHex.length() >= 8) {
                            return;
                        }
                        StringBuilder sb5 = new StringBuilder();
                        this.stringBuilder = sb5;
                        sb5.append(strBufferToHex);
                        this.leftCount = 1;
                    }
                }
            }
            if (this.leftCount > 0 || (sb = this.stringBuilder) == null) {
                return;
            }
            byte[] bArrHexToBuffer3 = HexString.hexToBuffer(sb.toString());
            this.stringBuilder = null;
            if (CommandUtilsWrapper.isReturnSettingResult(bArrHexToBuffer3)) {
                InitRunnable.this.mF5Data = HexString.bufferToHex(bArrHexToBuffer3).toUpperCase();
                if (!CommandUtilsWrapper.getReturnSettingResultStatus(bArrHexToBuffer3)) {
                    InitRunnable initRunnable = InitRunnable.this;
                    initRunnable.callOnFail(initRunnable.mCurrentHardware, null);
                    return;
                } else {
                    String returnSettingDeviceIdResult = CommandUtilsWrapper.getReturnSettingDeviceIdResult(bArrHexToBuffer3);
                    String returnSettingResult = CommandUtilsWrapper.getReturnSettingResult(bArrHexToBuffer3);
                    this.mDeviceHexID = returnSettingDeviceIdResult;
                    sendSettingParamsData(returnSettingResult);
                    return;
                }
            }
            if (CommandUtilsWrapper.isSettingResult(bArrHexToBuffer3)) {
                if (CommandUtilsWrapper.getSettingResultStatus(bArrHexToBuffer3)) {
                    if (!InitRunnable.this.mHasQrcode) {
                        InitRunnable initRunnable2 = InitRunnable.this;
                        InitRunnable.this.writeGatt(this.mBluetoothGattCharacteristic, CommandUtilsWrapper.setAddressCommand(initRunnable2.callNeedName(initRunnable2.mCurrentHardware)));
                        return;
                    }
                    final DeviceBean deviceBean = new DeviceBean();
                    deviceBean.deviceHexId = this.mDeviceHexID;
                    deviceBean.macAddress = InitRunnable.this.mCurrentHardware.address;
                    deviceBean.name = InitRunnable.this.mCurrentHardware.name;
                    AsyncQueueExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.7.2
                        @Override // java.lang.Runnable
                        public void run() {
                            byte[] bArrCallNeedServerInit = InitRunnable.this.callNeedServerInit(InitRunnable.this.mCurrentHardware, deviceBean);
                            if (bArrCallNeedServerInit != null) {
                                InitRunnable.this.checkTimeOut(TimeOut.WriteQrcode, KSImageLoader.InnerImageLoadingListener.MAX_DURATION);
                                AnonymousClass7.this.mCommands = CommandUtilsWrapper.getSettingQRcodeCommands(bArrCallNeedServerInit);
                                AnonymousClass7.this.mCommandIndex = 0;
                                InitRunnable.this.writeGatt(AnonymousClass7.this.mBluetoothGattCharacteristic, AnonymousClass7.this.mCommands[AnonymousClass7.this.mCommandIndex]);
                            }
                        }
                    });
                    return;
                }
                InitRunnable initRunnable3 = InitRunnable.this;
                initRunnable3.callOnFail(initRunnable3.mCurrentHardware, null);
                return;
            }
            if (CommandUtilsWrapper.isSettingQRCodeResult(bArrHexToBuffer3)) {
                if (!CommandUtilsWrapper.getSettingRQCodeResultStatus(bArrHexToBuffer3)) {
                    InitRunnable initRunnable4 = InitRunnable.this;
                    initRunnable4.callOnFail(initRunnable4.mCurrentHardware, null);
                    return;
                }
                String[] strArr = this.mCommands;
                if (strArr == null) {
                    return;
                }
                int i = this.mCommandIndex + 1;
                this.mCommandIndex = i;
                if (i < strArr.length) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.7.3
                        @Override // java.lang.Runnable
                        public void run() {
                            InitRunnable.this.writeGatt(AnonymousClass7.this.mBluetoothGattCharacteristic, AnonymousClass7.this.mCommands[AnonymousClass7.this.mCommandIndex]);
                        }
                    }, 300L);
                    return;
                } else {
                    if (i == strArr.length) {
                        InitRunnable initRunnable5 = InitRunnable.this;
                        initRunnable5.callOnSuccess(initRunnable5.mCurrentHardware);
                        return;
                    }
                    return;
                }
            }
            if (CommandUtilsWrapper.isReturnSetDeviceName(bArrHexToBuffer3)) {
                if (CommandUtilsWrapper.getSettingnameResultStatus(bArrHexToBuffer3)) {
                    InitRunnable initRunnable6 = InitRunnable.this;
                    initRunnable6.callOnSuccess(initRunnable6.mCurrentHardware);
                } else {
                    InitRunnable initRunnable7 = InitRunnable.this;
                    initRunnable7.callOnFail(initRunnable7.mCurrentHardware, null);
                }
            }
        }
    };

    public boolean isRunning() {
        return this.isRunning;
    }

    public void setInitListener(InitListener initListener) {
        this.mInitListener = initListener;
    }

    public InitRunnable(Context context, BluetoothAdapter bluetoothAdapter, BluetoothDevice bluetoothDevice, boolean z) {
        this.mHasQrcode = false;
        this.mContext = context;
        this.mBluetoothAdapter = bluetoothAdapter;
        this.mCurrentHardware = bluetoothDevice;
        this.mHasQrcode = z;
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
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.1
                @Override // java.lang.Runnable
                public void run() {
                    InitRunnable.this.mCurrentHardware.isTimeout = false;
                    android.bluetooth.BluetoothDevice remoteDevice = InitRunnable.this.mBluetoothAdapter.getRemoteDevice(InitRunnable.this.mCurrentHardware.address);
                    InitRunnable.this.checkTimeOut(TimeOut.Connect, 5000);
                    InitRunnable initRunnable = InitRunnable.this;
                    initRunnable.mBluetoothGatt = remoteDevice.connectGatt(initRunnable.mContext, false, InitRunnable.this.mBluetoothGattCallback);
                }
            }, 1200L);
        } else {
            callOnBluetoothException(new ClientException("请打开蓝牙！"));
        }
    }

    public void stopAndRelease() {
        this.isRunning = false;
        this.mCurrentCheckTimeOut = null;
        this.mCurrentHardware.isTimeout = false;
        closeGatt();
    }

    private void closeGatt() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
        refreshDeviceCache();
        BluetoothGatt bluetoothGatt2 = this.mBluetoothGatt;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.close();
        }
        this.mBluetoothGatt = null;
    }

    private void refreshDeviceCache() {
        BluetoothGatt bluetoothGatt;
        try {
            Method method = BluetoothGatt.class.getMethod(j.l, new Class[0]);
            if (method == null || (bluetoothGatt = this.mBluetoothGatt) == null) {
                return;
            }
            ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeGatt(final BluetoothGattCharacteristic bluetoothGattCharacteristic, final String str) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.2
            @Override // java.lang.Runnable
            public void run() {
                BluetoothGattCharacteristic bluetoothGattCharacteristic2;
                if (InitRunnable.this.mBluetoothGatt == null || (bluetoothGattCharacteristic2 = bluetoothGattCharacteristic) == null) {
                    return;
                }
                bluetoothGattCharacteristic2.setValue(HexString.hexToBuffer(str));
                bluetoothGattCharacteristic.setWriteType(2);
                InitRunnable.this.mBluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
        }, 100L);
    }

    private void callOnStart(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.3
            @Override // java.lang.Runnable
            public void run() {
                if (!InitRunnable.this.isRunning || InitRunnable.this.mInitListener == null) {
                    return;
                }
                InitRunnable.this.mInitListener.onStart(bluetoothDevice);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnSuccess(final BluetoothDevice bluetoothDevice) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitRunnable.this.isRunning && InitRunnable.this.mInitListener != null) {
                        InitRunnable.this.mInitListener.onSuccess(bluetoothDevice);
                    }
                } finally {
                    InitRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callOnFail(final BluetoothDevice bluetoothDevice, final TimeOut timeOut) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitRunnable.this.isRunning && InitRunnable.this.mInitListener != null) {
                        InitRunnable.this.mInitListener.onFail(bluetoothDevice, timeOut);
                    }
                } finally {
                    InitRunnable.this.stopAndRelease();
                }
            }
        });
    }

    private void callOnBluetoothException(final ClientException clientException) {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.sdk.runnable.ble.InitRunnable.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (InitRunnable.this.isRunning && InitRunnable.this.mInitListener != null) {
                        InitRunnable.this.mInitListener.onBluetoothException(clientException);
                    }
                } finally {
                    InitRunnable.this.stopAndRelease();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] callNeedServerInit(BluetoothDevice bluetoothDevice, DeviceBean deviceBean) {
        InitListener initListener;
        try {
            if (this.isRunning && (initListener = this.mInitListener) != null) {
                return initListener.needServerInit(bluetoothDevice, deviceBean);
            }
        } catch (Exception unused) {
            callOnFail(this.mCurrentHardware, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String callNeedName(BluetoothDevice bluetoothDevice) {
        InitListener initListener;
        try {
            return (!this.isRunning || (initListener = this.mInitListener) == null) ? "" : initListener.needName(bluetoothDevice);
        } catch (Exception unused) {
            callOnFail(this.mCurrentHardware, null);
            return "";
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
            Log.e("test", "初始化：" + InitRunnable.this.isRunning + "  " + this.timeOut + "  " + InitRunnable.this.mCurrentCheckTimeOut);
            if (InitRunnable.this.isRunning && this.timeOut == InitRunnable.this.mCurrentCheckTimeOut) {
                InitRunnable.this.mCurrentHardware.isTimeout = true;
                InitRunnable initRunnable = InitRunnable.this;
                initRunnable.callOnFail(initRunnable.mCurrentHardware, this.timeOut);
            }
        }
    }
}
