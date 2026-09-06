package client.android.yixiaotong.v3.ui.appcontrol.consumer;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bean.deviceinfo.BluetoothSetBean;
import client.android.yixiaotong.v3.bean.deviceinfo.CollectResultBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineInfoJson;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineStatusData;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GDevice;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GStatuBean;
import client.android.yixiaotong.v3.bean.deviceinfo.PostOpenAuthBean;
import client.android.yixiaotong.v3.bean.deviceinfo.SetData;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.DeviceControlUtil;
import client.android.yixiaotong.v3.comman.DeviceInfoUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.util.LogUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.C;
import com.google.gson.reflect.TypeToken;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class Consumer4GOpenControlUtil {
    private static final int FIRST_OPEN_BLE = 0;
    private static final int FIRST_OPEN_NBOR4G = 1;
    private static final String TAG = "Consumer4GOpenControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private String mCommunicationVal;
    private OpenControlListener mControlListener;
    private String mDeviceVer;
    private String mF0Data;
    private FlowState mFlowState;
    private int mHandleType;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private String mOrderId;
    private State mState;
    private String mStudentHex;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mPreferredCommunicationType = 1;
    private int mCnFlag = 0;
    private int mCount = 0;
    private String mParFlag = "";

    private enum FlowState {
        openingtoble,
        openingtonbor4g,
        collet,
        set,
        opened
    }

    private enum State {
        f0,
        f08,
        f02,
        f02collect,
        f06,
        f07,
        f01
    }

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, TypeInfoBaseInfoBean typeInfoBaseInfoBean, int i, String str, String str2) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mBluetoothDevice = bluetoothDevice;
        this.mTypeInfoBaseInfoBean = typeInfoBaseInfoBean;
        this.mTypeId = i;
        this.mStudentHex = str;
        this.mOrderId = str2;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setHandleType(int i) {
        this.mHandleType = i;
    }

    public void setListener(OpenControlListener openControlListener) {
        this.mControlListener = openControlListener;
    }

    static /* synthetic */ int access$508(Consumer4GOpenControlUtil consumer4GOpenControlUtil) {
        int i = consumer4GOpenControlUtil.mCount;
        consumer4GOpenControlUtil.mCount = i + 1;
        return i;
    }

    public void onPause() {
        this.mIsEnable = false;
        disconnect();
    }

    public void setDeviceInfo(int i, int i2, int i3, String str, String str2) {
        this.mPreferredCommunicationType = i;
        this.mCnFlag = i3;
        this.mDeviceVer = str;
        this.mMachineId = str2;
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
        if (StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() >= 4) {
            if (DeviceControlUtil.isLiDeviceAndUnTransfereed(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3))) {
                LogUtil.e(TAG, "新设备1");
                NBDeviceCommand.setTransferredMeaning(false);
                return;
            } else {
                NBDeviceCommand.setTransferredMeaning(true);
                return;
            }
        }
        showDialog("设备型号异常：[" + this.mMachineId + "][设备型号：" + this.mDeviceVer + "]");
    }

    public void connected() {
        sendf0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    public void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void openStart() {
        LogUtil.log("--------开始执行开阀流程----------");
        this.mCommunicationVal = "";
        if (this.mPreferredCommunicationType == 1) {
            LogUtil.e(TAG, "先NB或4G" + this.mPreferredCommunicationType);
            LogUtil.log("先NB或4G");
            auth("", false, this.mHandleType);
        } else {
            LogUtil.e(TAG, "先蓝牙" + this.mPreferredCommunicationType);
            LogUtil.log("先蓝牙");
            this.mFlowState = FlowState.openingtoble;
            connectDecice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEnd(boolean z) {
        LogUtil.e(TAG, "openEnd:" + z + "  " + this.mFlowState);
        LogUtil.log("开阀成功:开阀方式：" + (z ? "蓝牙开阀" : "NB/4G开阀") + "  " + this.mFlowState);
        LogUtil.log("--------开阀流程结束----------");
        LogUtil.log("--------开始执行开阀成功后流程----------");
        if (this.mFlowState == FlowState.openingtonbor4g || this.mFlowState == FlowState.openingtoble) {
            this.mControlListener.onOpenEnd();
            if (z) {
                LogUtil.i(TAG, "蓝牙开阀");
                this.mFlowState = FlowState.collet;
                sendf08();
            } else {
                LogUtil.i(TAG, "nb或4g开阀");
                if (this.mFlowState != FlowState.openingtoble) {
                    this.mFlowState = FlowState.collet;
                    connectDecice();
                } else {
                    this.mFlowState = FlowState.opened;
                }
            }
        }
    }

    private void openFail() {
        if (this.mFlowState == FlowState.openingtoble || this.mFlowState == FlowState.openingtonbor4g) {
            this.mControlListener.onOpenFail();
        }
    }

    private void sendf0() {
        LogUtil.i(TAG, "f0");
        LogUtil.log("f0");
        String strSelectInfoCommand = NBDeviceCommand.selectInfoCommand();
        this.mState = State.f0;
        sendData(strSelectInfoCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf06(String str) {
        LogUtil.i(TAG, "06");
        LogUtil.log("06");
        String strOpenOnlineCommand = NBDeviceCommand.openOnlineCommand(str);
        if (DeviceControlUtil.isAuthTotalMoney(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3))) {
            LogUtil.i(TAG, BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP);
            LogUtil.log(BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP);
            strOpenOnlineCommand = NBDeviceCommand.openOnlineCommand1(str);
        }
        this.mState = State.f06;
        sendData(strOpenOnlineCommand);
    }

    private void sendf08() {
        LogUtil.i(TAG, "08");
        LogUtil.log("08");
        String randCommand = NBDeviceCommand.getRandCommand();
        this.mState = State.f08;
        sendData(randCommand);
    }

    private void sendf02collect() {
        LogUtil.i(TAG, "02  ");
        LogUtil.log("02采集全部");
        String strCollectOrderCommand = NBDeviceCommand.collectOrderCommand(false, this.mStudentHex);
        this.mState = State.f02collect;
        sendData(strCollectOrderCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf07(String str) {
        LogUtil.i(TAG, "07");
        LogUtil.log("07");
        String strSetMachineNoCommand = NBDeviceCommand.SetMachineNoCommand(str);
        this.mState = State.f07;
        sendData(strSetMachineNoCommand);
    }

    public void onReceivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str)) {
            LogUtil.e(TAG, "onReceivedData:" + this.mFlowState + "  " + this.mState + "    " + str);
            if (this.mFlowState == FlowState.openingtoble || this.mFlowState == FlowState.openingtonbor4g) {
                if (this.mState == State.f0) {
                    this.mF0Data = str;
                    postMachineRunInfo();
                    sendf08();
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.i(TAG, "studentid:" + this.mStudentHex);
                        auth("", true, this.mHandleType);
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState == State.f06) {
                    if (str.length() > 24) {
                        if (str.substring(22, 24).equals("00") || (str.substring(22, 24).equalsIgnoreCase("AA") && DeviceControlUtil.isNeedSetPValue(this.mDeviceVer))) {
                            openEnd(true);
                            return;
                        }
                        if (str.substring(22, 24).equals("03")) {
                            if (str.length() >= 32) {
                                String strSubstring = str.substring(24, 32);
                                LogUtil.i(TAG, "已开阀ID：" + strSubstring + "  当前ID:" + this.mStudentHex);
                                if (strSubstring.equalsIgnoreCase(this.mStudentHex)) {
                                    openEnd(true);
                                    return;
                                } else {
                                    onError(0, "设备正忙,无法使用！");
                                    return;
                                }
                            }
                            openEnd(true);
                            return;
                        }
                        if (str.substring(22, 24).equals("01")) {
                            onError(0, "开阀失败");
                            return;
                        } else {
                            onError(0, "消费记录返回失败");
                            return;
                        }
                    }
                    onError(0, "开阀失败，数据异常");
                    return;
                }
                return;
            }
            if (this.mFlowState == FlowState.collet || this.mFlowState == FlowState.opened) {
                if (this.mState == State.f0) {
                    postMachineRunInfo();
                    sendf08();
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.i(TAG, "studentid:" + this.mStudentHex);
                        sendf02collect();
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState == State.f02collect) {
                    if (str.length() >= 72 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01"))) {
                        uploadOrder(str);
                        return;
                    } else {
                        uploadDeviceInfo();
                        return;
                    }
                }
                if (this.mState == State.f02) {
                    sendf08();
                    return;
                }
                if (this.mState != State.f06 || str.length() <= 24) {
                    return;
                }
                if (str.substring(22, 24).equals("00")) {
                    sendf08();
                    return;
                } else {
                    uploadDeviceInfo();
                    return;
                }
            }
            if (this.mFlowState == FlowState.set) {
                disconnect();
                if (str.substring(22, 24).equals("00")) {
                    uploadDeviceInfoResult();
                }
            }
        }
    }

    private void sendData(String str) {
        if (this.mState == State.f02 && StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() > 3 && DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1) {
            NBDeviceCommand.setIsAliSDKCommand(true);
        } else {
            NBDeviceCommand.setIsAliSDKCommand(false);
        }
        BluetoothControlUtil.getInstance().setSendTimeOut(5000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    private void uploadOrder(String str) {
        NBOr4GDevice nBOr4GDevice = new NBOr4GDevice();
        nBOr4GDevice.machineRandom = this.mMachineRand;
        String strSubstring = str.substring(42, 58);
        String strSubstring2 = str.substring(58, 70);
        String strReceivedResult = BathUtil.receivedResult(str.substring(20, 22), str.substring(4, 6), str.substring(6, 8));
        final int i = Integer.parseInt(str.substring(70, 72), 16);
        if (DeviceControlUtil.getModeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1) {
            strSubstring = str.substring(42, 74);
            strSubstring2 = str.substring(74, 86);
            i = Integer.parseInt(str.substring(86, 88), 16);
        }
        nBOr4GDevice.machineData = strSubstring;
        nBOr4GDevice.posSystemTime = strSubstring2;
        nBOr4GDevice.statusInfo = strReceivedResult;
        int i2 = this.mTypeId;
        if (i2 != 3 && i2 != 16 && i2 != 2) {
            i = 0;
        }
        nBOr4GDevice.handleType = i;
        if (DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1 && str.length() > 78) {
            nBOr4GDevice.signatureFile = StringUtils.hexStringToStr(str.substring(78));
        }
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, Integer.parseInt(str.substring(24, 26), 16), new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (Consumer4GOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.i(Consumer4GOpenControlUtil.TAG, ifNull);
                    try {
                        CollectResultBean collectResultBean = (CollectResultBean) GsonUtils.getInstance().parse(new TypeToken<CollectResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.1.1
                        }.getType(), ifNull);
                        LogUtil.i(Consumer4GOpenControlUtil.TAG, Consumer4GOpenControlUtil.this.mFlowState + "");
                        if (Consumer4GOpenControlUtil.this.mFlowState != FlowState.collet && Consumer4GOpenControlUtil.this.mFlowState != FlowState.opened) {
                            Consumer4GOpenControlUtil.this.auth(collectResultBean.lastPosMoney + "," + collectResultBean.lastPosSerial, true, i);
                        } else {
                            Consumer4GOpenControlUtil.this.sendf06("02" + collectResultBean.systemData + collectResultBean.systemTime);
                        }
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auth(final String str, final boolean z, int i) {
        int i2;
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        machineInfoJson.machineData = str;
        machineInfoJson.machineRandom = this.mMachineRand;
        if (!z) {
            this.mFlowState = FlowState.openingtonbor4g;
        }
        if (!StringUtils.isEmpty(str) || z) {
            if (StringUtils.isEmpty(str)) {
                machineInfoJson.lastPosSerial = "0000";
                machineInfoJson.lastPosMoney = "0000";
            } else {
                String[] strArrSplit = str.split(",");
                machineInfoJson.lastPosMoney = strArrSplit[0];
                machineInfoJson.lastPosSerial = strArrSplit[1];
            }
        } else {
            int i3 = this.mCnFlag;
            if (i3 == 0) {
                machineInfoJson.lastPosSerial = "0000";
                machineInfoJson.lastPosMoney = "0000";
                i2 = 2;
            } else {
                i2 = 4;
                if (i3 == 4) {
                    machineInfoJson.lastPosSerial = "0000";
                    machineInfoJson.lastPosMoney = "0000";
                }
            }
            machineInfoJson.orderId = this.mOrderId;
            V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i2, this.mTypeId, this.mDeviceVer, this.mMachineId, DeviceInfoUtil.getInstance().getDeviceVer(this.mF0Data), machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, Object obj, Object... objArr) {
                    if (Consumer4GOpenControlUtil.this.mIsEnable) {
                        String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                        LogUtil.d(Consumer4GOpenControlUtil.TAG, ifNull);
                        try {
                            PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.2.1
                            }.getType(), ifNull);
                            Consumer4GOpenControlUtil.this.mCommunicationVal = postOpenAuthBean.communicationVal;
                            if (StringUtils.isEmpty(str) && !z) {
                                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Consumer4GOpenControlUtil.this.mCount = 0;
                                        Consumer4GOpenControlUtil.this.getStatus();
                                    }
                                }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                                return;
                            }
                            String str2 = "02" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                            if (Consumer4GOpenControlUtil.this.mFlowState == FlowState.openingtoble || Consumer4GOpenControlUtil.this.mFlowState == FlowState.openingtonbor4g) {
                                str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                                if (StringUtils.isNotEmpty(postOpenAuthBean.agreementNoHex) && Consumer4GOpenControlUtil.this.isZFBSDK()) {
                                    str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime + postOpenAuthBean.agreementNoHex;
                                }
                            }
                            Consumer4GOpenControlUtil.this.sendf06(str2);
                        } catch (ClientException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (!Consumer4GOpenControlUtil.this.mIsEnable || Consumer4GOpenControlUtil.this.mPreferredCommunicationType == 0 || Consumer4GOpenControlUtil.this.mFlowState == FlowState.openingtoble) {
                        return;
                    }
                    Consumer4GOpenControlUtil.this.mFlowState = FlowState.openingtoble;
                    Consumer4GOpenControlUtil.this.connectDecice();
                }
            });
        }
        i2 = 1;
        machineInfoJson.orderId = this.mOrderId;
        V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i2, this.mTypeId, this.mDeviceVer, this.mMachineId, DeviceInfoUtil.getInstance().getDeviceVer(this.mF0Data), machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (Consumer4GOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.d(Consumer4GOpenControlUtil.TAG, ifNull);
                    try {
                        PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.2.1
                        }.getType(), ifNull);
                        Consumer4GOpenControlUtil.this.mCommunicationVal = postOpenAuthBean.communicationVal;
                        if (StringUtils.isEmpty(str) && !z) {
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    Consumer4GOpenControlUtil.this.mCount = 0;
                                    Consumer4GOpenControlUtil.this.getStatus();
                                }
                            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                            return;
                        }
                        String str2 = "02" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                        if (Consumer4GOpenControlUtil.this.mFlowState == FlowState.openingtoble || Consumer4GOpenControlUtil.this.mFlowState == FlowState.openingtonbor4g) {
                            str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                            if (StringUtils.isNotEmpty(postOpenAuthBean.agreementNoHex) && Consumer4GOpenControlUtil.this.isZFBSDK()) {
                                str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime + postOpenAuthBean.agreementNoHex;
                            }
                        }
                        Consumer4GOpenControlUtil.this.sendf06(str2);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (!Consumer4GOpenControlUtil.this.mIsEnable || Consumer4GOpenControlUtil.this.mPreferredCommunicationType == 0 || Consumer4GOpenControlUtil.this.mFlowState == FlowState.openingtoble) {
                    return;
                }
                Consumer4GOpenControlUtil.this.mFlowState = FlowState.openingtoble;
                Consumer4GOpenControlUtil.this.connectDecice();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStatus() {
        if (this.mFlowState == FlowState.opened || this.mFlowState == FlowState.collet || StringUtils.isEmpty(this.mCommunicationVal)) {
            return;
        }
        V3BusinessControllers.getInstance().getNBOr4GStatus(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, 1, this.mCommunicationVal, new Listener<NBOr4GStatuBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NBOr4GStatuBean nBOr4GStatuBean, Object... objArr) {
                if (!Consumer4GOpenControlUtil.this.mIsEnable || nBOr4GStatuBean == null) {
                    return;
                }
                if (nBOr4GStatuBean.status == 0) {
                    Consumer4GOpenControlUtil.this.openEnd(false);
                    return;
                }
                if (Consumer4GOpenControlUtil.this.mCount != 0) {
                    if (Consumer4GOpenControlUtil.this.mPreferredCommunicationType == 0) {
                        Consumer4GOpenControlUtil.this.onError(0, "蓝牙启动失败");
                    }
                } else {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Consumer4GOpenControlUtil.this.getStatus();
                        }
                    }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    if (Consumer4GOpenControlUtil.this.mPreferredCommunicationType != 0) {
                        Consumer4GOpenControlUtil.this.mFlowState = FlowState.openingtoble;
                        Consumer4GOpenControlUtil.this.connectDecice();
                    }
                }
                Consumer4GOpenControlUtil.access$508(Consumer4GOpenControlUtil.this);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                if (!Consumer4GOpenControlUtil.this.mIsEnable || Consumer4GOpenControlUtil.this.mPreferredCommunicationType == 0 || Consumer4GOpenControlUtil.this.mFlowState == FlowState.openingtoble) {
                    return;
                }
                Consumer4GOpenControlUtil.this.mFlowState = FlowState.openingtoble;
                Consumer4GOpenControlUtil.this.connectDecice();
            }
        });
    }

    private void postMachineRunInfo() {
        MachineStatusData machineStatusData = new MachineStatusData();
        if (!StringUtils.isNotEmpty(this.mF0Data) || this.mF0Data.length() <= 68) {
            return;
        }
        machineStatusData.runStatus = BathUtil.receivedResult(this.mF0Data.substring(20, 22), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        String str = this.mF0Data;
        machineStatusData.runPar = str.substring(66, str.length() - 2);
        V3BusinessControllers.getInstance().postMachineRunInfo(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, machineStatusData, new Listener<BluetoothSetBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.4
        });
    }

    private void uploadDeviceInfoResult() {
        if (StringUtils.isNotEmpty(this.mParFlag)) {
            V3BusinessControllers.getInstance().postBluetoothSetDataResult(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mParFlag, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.5
            });
        }
    }

    private void uploadDeviceInfo() {
        if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
            BaseMaterialDialog.dissmisMaterialDialog();
            disconnect();
        } else {
            SetData setData = new SetData();
            setData.machineRandom = this.mMachineRand;
            V3BusinessControllers.getInstance().postBluetoothSetData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, setData, new Listener<BluetoothSetBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.Consumer4GOpenControlUtil.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, BluetoothSetBean bluetoothSetBean, Object... objArr) {
                    if (Consumer4GOpenControlUtil.this.mIsEnable) {
                        if (bluetoothSetBean != null && bluetoothSetBean.statusFlag == 0 && StringUtils.isNotEmpty(bluetoothSetBean.systemData)) {
                            Consumer4GOpenControlUtil.this.mParFlag = bluetoothSetBean.parFlag;
                            Consumer4GOpenControlUtil.this.mFlowState = FlowState.set;
                            Consumer4GOpenControlUtil.this.sendf07(bluetoothSetBean.systemData);
                            return;
                        }
                        Consumer4GOpenControlUtil.this.disconnect();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (Consumer4GOpenControlUtil.this.mIsEnable) {
                        Consumer4GOpenControlUtil.this.disconnect();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        openFail();
    }

    private void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isZFBSDK() {
        return StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() > 3 && DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1;
    }
}
