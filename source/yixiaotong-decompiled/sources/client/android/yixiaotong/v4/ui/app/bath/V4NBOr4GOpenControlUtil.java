package client.android.yixiaotong.v4.ui.app.bath;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.DeviceInfoUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V44GOpenStatus;
import client.android.yixiaotong.v4.http.bean.V4BLEOpenBean;
import client.android.yixiaotong.v4.ui.app.listener.V4OpenControlListener;
import client.android.yixiaotong.v4.ui.order.V4NoPayOrderActivity;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import client.android.yixiaotong.v4.util.comman.V4DeviceCommand;
import client.android.yixiaotong.v4.util.comman.V4DeviceInfoUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4NBOr4GOpenControlUtil {
    private static final int FIRST_OPEN_BLE = 0;
    private static final int FIRST_OPEN_NBOR4G = 1;
    private static final String TAG = "V4NBOr4GOpenControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private ClientException mClientException;
    private int mCode;
    private V4OpenControlListener mControlListener;
    private ErrorControlListener mErrorControlListener;
    private String mF0Data;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private String mMachineType;
    private String mMachineVersion;
    private String mMode;
    private String mMsg;
    private int mProductId;
    private State mState;
    private StringBuilder mStringBuilderOffline;
    private String mStudentHex;
    private String mTitleContent;
    private String sysRandom;
    private int mPreferredCommunicationType = 1;
    private int mCount = 0;
    private boolean mIsOffineOpen = false;
    private boolean mWashModeUseAddLiquid = false;

    private enum FlowState {
        openingtoble,
        openingtonbor4g,
        opened,
        collet,
        set
    }

    private enum State {
        f0,
        f08,
        f02,
        f02collect,
        f06,
        f07,
        f01,
        f06pro,
        f08pro
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setErrorListener(ErrorControlListener errorControlListener) {
        this.mErrorControlListener = errorControlListener;
    }

    public void setListener(V4OpenControlListener v4OpenControlListener) {
        this.mControlListener = v4OpenControlListener;
    }

    static /* synthetic */ int access$608(V4NBOr4GOpenControlUtil v4NBOr4GOpenControlUtil) {
        int i = v4NBOr4GOpenControlUtil.mCount;
        v4NBOr4GOpenControlUtil.mCount = i + 1;
        return i;
    }

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, int i, String str, String str2, boolean z) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mBluetoothDevice = bluetoothDevice;
        this.mProductId = i;
        this.mTitleContent = str;
        this.mMode = str2;
        this.mWashModeUseAddLiquid = z;
        this.mIsOffineOpen = false;
        this.mStudentHex = V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId;
        this.mPreferredCommunicationType = V4HomeInfoUtil.getInstance().is4GPriority() ? 1 : 0;
    }

    public void setDeviceInfo(String str) {
        this.mMachineId = str;
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
    }

    public void connected() {
        sendf0();
    }

    public void onBluetoothError(int i, String str) {
        LogUtil.log(str + i);
        this.mMsg = str;
        this.mCode = i;
        if (this.mPreferredCommunicationType == 0 && this.mFlowState == FlowState.openingtoble) {
            LogUtil.log("蓝牙开阀失败 开始转nb/4g通道");
            authFor4G();
        } else {
            if (this.mPreferredCommunicationType == 0 || this.mFlowState != FlowState.openingtoble) {
                return;
            }
            onError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void openStart() {
        postUpdateCurrentDeductBank();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void opening() {
        LogUtil.log("--------开始执行开阀流程----------");
        this.mState = State.f0;
        if (this.mPreferredCommunicationType == 1) {
            LogUtil.e(TAG, "先NB或4G" + this.mPreferredCommunicationType);
            LogUtil.log("先NB或4G");
            this.mFlowState = FlowState.openingtonbor4g;
            authFor4G();
            return;
        }
        LogUtil.e(TAG, "先蓝牙" + this.mPreferredCommunicationType);
        LogUtil.log("先蓝牙");
        this.mFlowState = FlowState.openingtoble;
        connectDecice();
    }

    public void openOffineStart(ClientException clientException) {
        this.mClientException = clientException;
        ErrorControlListener errorControlListener = this.mErrorControlListener;
        if (errorControlListener != null) {
            errorControlListener.onFail(clientException);
        }
        disconnect();
        this.mIsOffineOpen = true;
        this.mState = State.f0;
        LogUtil.e(TAG, "蓝牙脱机开阀");
        LogUtil.log("蓝牙脱机开阀");
        this.mFlowState = FlowState.openingtoble;
        connectDecice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEnd(boolean z) {
        LogUtil.e(TAG, "openEnd:" + z + "  " + this.mFlowState);
        LogUtil.log("开阀成功:开阀方式：" + (z ? "蓝牙开阀" : "NB/4G开阀") + "  " + this.mFlowState);
        LogUtil.log("--------开阀流程结束----------");
        LogUtil.log("--------开始执行开阀成功后流程----------");
        V4LocalDataUtil.saveOpenDeviceForUser(this.mActivity, this.mStudentHex);
        if (this.mFlowState == FlowState.openingtonbor4g || this.mFlowState == FlowState.openingtoble) {
            this.mControlListener.onOpenEnd(!this.mIsOffineOpen ? 1 : 0);
            if (this.mIsOffineOpen) {
                this.mFlowState = FlowState.opened;
                return;
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void openFail() {
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

    private void sendf01() {
        LogUtil.i(TAG, "01");
        LogUtil.log("01");
        String strOpenOffineCommand = NBDeviceCommand.openOffineCommand(this.mStudentHex, "", this.mMachineRand);
        this.mState = State.f01;
        addOfflineLog("发送01:" + strOpenOffineCommand);
        sendData(strOpenOffineCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf06(String str) {
        LogUtil.i(TAG, "06");
        LogUtil.log("06");
        this.mState = State.f06;
        sendData(str);
    }

    private void sendf08() {
        LogUtil.i(TAG, "08");
        LogUtil.log("08");
        String randCommand = NBDeviceCommand.getRandCommand();
        this.mState = State.f08;
        addOfflineLog("发送08:" + randCommand);
        sendData(randCommand);
    }

    private void sendf08pro() {
        LogUtil.i(TAG, "08");
        LogUtil.log("08");
        String randCommand = NBDeviceCommand.getRandCommand();
        this.mState = State.f08pro;
        sendData(randCommand);
    }

    private void sendf02(boolean z) {
        LogUtil.i(TAG, "02  " + z);
        LogUtil.log("02".concat(z ? "采集本人" : "采集全部"));
        if (StringUtils.isNotEmpty(this.mStudentHex)) {
            String strCollectOrderCommand = NBDeviceCommand.collectOrderCommand(z, this.mStudentHex);
            this.mState = State.f02;
            sendData(strCollectOrderCommand);
            return;
        }
        isNeedLogin();
    }

    private void sendf02collect() {
        LogUtil.i(TAG, "02  ");
        LogUtil.log("02采集全部");
        String strCollectOrderCommand = NBDeviceCommand.collectOrderCommand(false, this.mStudentHex);
        this.mState = State.f02collect;
        sendData(strCollectOrderCommand);
    }

    private void sendf07(String str) {
        LogUtil.i(TAG, "07");
        LogUtil.log("07");
        String strSetMachineNoCommand = NBDeviceCommand.SetMachineNoCommand(str);
        this.mState = State.f07;
        sendData(strSetMachineNoCommand);
    }

    public void onReceivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str)) {
            LogUtil.e(TAG, "onReceivedData:" + this.mFlowState + "  " + this.mState + "  " + this.mIsOffineOpen + "  " + str);
            if (this.mIsOffineOpen) {
                if (this.mState == State.f0) {
                    this.mF0Data = str;
                    this.mMachineType = DeviceInfoUtil.getInstance().getType(this.mF0Data);
                    this.mMachineVersion = DeviceInfoUtil.getInstance().getVersion(this.mF0Data);
                    BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
                    if (StringUtils.isEmpty(this.mMachineId)) {
                        this.mMachineId = DeviceInfoUtil.getInstance().getSN(this.mF0Data);
                    }
                    sendf08();
                    return;
                }
                if (this.mState == State.f08 && str.length() > 30) {
                    addOfflineLog("接收08:" + str);
                    this.mMachineRand = str.substring(22, 30);
                    sendf01();
                    return;
                }
                if (this.mState == State.f01) {
                    addOfflineLog("接收01:" + str);
                    if (str.length() > 24) {
                        if (str.substring(22, 24).equals("00")) {
                            openEnd(true);
                            return;
                        }
                        if (str.substring(22, 24).equals("03") || str.substring(22, 24).equals("06")) {
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
                        sendf08pro();
                        return;
                    }
                    sendf08pro();
                    return;
                }
                if (this.mState == State.f08pro && str.length() > 30) {
                    this.mMachineRand = str.substring(22, 30);
                    openPro(this.mMachineId);
                    return;
                } else {
                    if (this.mState == State.f06pro) {
                        if (str.length() > 24 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("03"))) {
                            openEnd(true);
                            return;
                        } else {
                            onError(0, "开阀失败" + str.substring(22, 24));
                            return;
                        }
                    }
                    return;
                }
            }
            if (this.mFlowState == FlowState.openingtoble || this.mFlowState == FlowState.openingtonbor4g) {
                if (this.mState == State.f0) {
                    this.mF0Data = str;
                    this.mMachineId = DeviceInfoUtil.getInstance().getSN(this.mF0Data);
                    sendf08();
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.e(TAG, "studentid:" + this.mStudentHex);
                        sendf02(true);
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState == State.f02) {
                    if (str.length() > 24 && str.substring(22, 24).equals("06")) {
                        if (str.length() >= 32) {
                            if (str.substring(24, 32).equalsIgnoreCase(this.mStudentHex)) {
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
                    if (str.length() >= 72 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01"))) {
                        authForBLE(this.mMachineRand, str);
                        return;
                    } else {
                        authForBLE(this.mMachineRand, "");
                        return;
                    }
                }
                if (this.mState == State.f06) {
                    if (str.length() > 24) {
                        if (str.substring(22, 24).equals("00")) {
                            openEnd(true);
                            return;
                        }
                        if (str.substring(22, 24).equals("03")) {
                            if (str.length() >= 32) {
                                String strSubstring2 = str.substring(24, 32);
                                LogUtil.e(TAG, "已开阀ID：" + strSubstring2 + "  当前ID:" + this.mStudentHex);
                                if (strSubstring2.equalsIgnoreCase(this.mStudentHex)) {
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
                    sendf08();
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.e(TAG, "studentid:" + this.mStudentHex);
                        sendf02collect();
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState == State.f02collect) {
                    if (str.length() >= 72 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01"))) {
                        collectForBLE(this.mMachineRand, str);
                        return;
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        disconnect();
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
                    BaseMaterialDialog.dissmisMaterialDialog();
                    disconnect();
                    return;
                }
            }
            if (this.mFlowState == FlowState.set) {
                disconnect();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendData(String str) {
        V4DeviceCommand.setIs02Cmd(V4DeviceCommand.is02Command(str));
        BluetoothControlUtil.getInstance().setSendTimeOut(5000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    private void authFor4G() {
        V4BusinessControllers.getInstance().post4GOpen(this.mAccount, this.mMachineId, this.mProductId, this.mMode, this.mWashModeUseAddLiquid, new Listener<V4BLEOpenBean>() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BLEOpenBean v4BLEOpenBean, Object... objArr) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    V4NBOr4GOpenControlUtil.this.sysRandom = v4BLEOpenBean.sysRandom;
                    if (V4NBOr4GOpenControlUtil.this.mProductId == 1) {
                        V4LocalDataUtil.saveBathMacInfo(V4NBOr4GOpenControlUtil.this.mActivity, V4NBOr4GOpenControlUtil.this.mBluetoothDevice.address + "," + V4NBOr4GOpenControlUtil.this.mMachineId + "," + v4BLEOpenBean.deviceAddress);
                    }
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            V4NBOr4GOpenControlUtil.this.mCount = 0;
                            V4NBOr4GOpenControlUtil.this.getStatus();
                        }
                    }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    int code = LocalDataUtil.getCode(V4NBOr4GOpenControlUtil.this.mActivity);
                    if (code >= 500 && code < 600 && V4NBOr4GOpenControlUtil.this.mProductId != 4 && V4NBOr4GOpenControlUtil.this.mProductId != 11) {
                        V4NBOr4GOpenControlUtil.this.openOffineStart(clientException);
                    } else if (clientException.getCode() == 1004) {
                        V4NoPayOrderActivity.launch(V4NBOr4GOpenControlUtil.this.mActivity);
                        V4NBOr4GOpenControlUtil.this.mActivity.finish();
                    } else {
                        V4NBOr4GOpenControlUtil.this.onError(clientException);
                    }
                }
            }
        });
    }

    private void authForBLE(String str, String str2) {
        V4BusinessControllers.getInstance().postBLEOpen(this.mAccount, this.mMachineId, this.mMode, str, str2, this.mWashModeUseAddLiquid, new Listener<V4BLEOpenBean>() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BLEOpenBean v4BLEOpenBean, Object... objArr) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(v4BLEOpenBean.data)) {
                        if (V4NBOr4GOpenControlUtil.this.mProductId == 1) {
                            V4LocalDataUtil.saveBathMacInfo(V4NBOr4GOpenControlUtil.this.mActivity, V4NBOr4GOpenControlUtil.this.mBluetoothDevice.address + "," + V4NBOr4GOpenControlUtil.this.mMachineId + "," + v4BLEOpenBean.deviceAddress);
                        }
                        V4NBOr4GOpenControlUtil.this.sendf06(v4BLEOpenBean.data);
                        return;
                    }
                    V4NBOr4GOpenControlUtil.this.onError(0, "蓝牙授权失败!");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    int code = LocalDataUtil.getCode(V4NBOr4GOpenControlUtil.this.mActivity);
                    if (code >= 500 && code < 600 && V4NBOr4GOpenControlUtil.this.mProductId != 4 && V4NBOr4GOpenControlUtil.this.mProductId != 11) {
                        V4NBOr4GOpenControlUtil.this.openOffineStart(clientException);
                    } else if (clientException.getCode() == 1004) {
                        V4NoPayOrderActivity.launch(V4NBOr4GOpenControlUtil.this.mActivity);
                        V4NBOr4GOpenControlUtil.this.mActivity.finish();
                    } else {
                        V4NBOr4GOpenControlUtil.this.onError(clientException);
                    }
                }
            }
        });
    }

    private void collectForBLE(String str, String str2) {
        V4BusinessControllers.getInstance().postBLEClollect(this.mAccount, this.mMachineId, str, str2, new Listener<V4BLEOpenBean>() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BLEOpenBean v4BLEOpenBean, Object... objArr) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(v4BLEOpenBean.data)) {
                        V4NBOr4GOpenControlUtil.this.sendf06(v4BLEOpenBean.data);
                    } else {
                        V4NBOr4GOpenControlUtil.this.onError(0, "蓝牙采集失败!");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    V4NBOr4GOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStatus() {
        if (this.mFlowState == FlowState.opened) {
            return;
        }
        V4BusinessControllers.getInstance().get4GOpenStatus(this.mAccount, this.mMachineId, this.sysRandom, new Listener<V44GOpenStatus>() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V44GOpenStatus v44GOpenStatus, Object... objArr) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    if (v44GOpenStatus == null || !StringUtils.isNotEmpty(v44GOpenStatus.status) || (!v44GOpenStatus.status.equals("00") && !v44GOpenStatus.status.equals("03"))) {
                        if (V4NBOr4GOpenControlUtil.this.mCount != 0) {
                            if (V4NBOr4GOpenControlUtil.this.mPreferredCommunicationType == 0) {
                                V4NBOr4GOpenControlUtil v4NBOr4GOpenControlUtil = V4NBOr4GOpenControlUtil.this;
                                v4NBOr4GOpenControlUtil.onError(v4NBOr4GOpenControlUtil.mCode, V4NBOr4GOpenControlUtil.this.mMsg);
                            }
                        } else {
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    V4NBOr4GOpenControlUtil.this.getStatus();
                                }
                            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                            if (V4NBOr4GOpenControlUtil.this.mPreferredCommunicationType != 0) {
                                V4NBOr4GOpenControlUtil.this.mFlowState = FlowState.openingtoble;
                                V4NBOr4GOpenControlUtil.this.connectDecice();
                            }
                        }
                        V4NBOr4GOpenControlUtil.access$608(V4NBOr4GOpenControlUtil.this);
                        return;
                    }
                    V4NBOr4GOpenControlUtil.this.openEnd(false);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                    int code = LocalDataUtil.getCode(V4NBOr4GOpenControlUtil.this.mActivity);
                    if (code < 500 || code >= 600 || V4NBOr4GOpenControlUtil.this.mProductId == 4 || V4NBOr4GOpenControlUtil.this.mProductId == 11) {
                        V4NBOr4GOpenControlUtil.this.onError(clientException);
                    } else {
                        V4NBOr4GOpenControlUtil.this.openOffineStart(clientException);
                    }
                }
            }
        });
    }

    private void postUpdateCurrentDeductBank() {
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        V4ProjectInfoBean projectInfoV4 = V4ProjectConfigInfoUtil.getInstance().getProjectInfoV4();
        LogUtil.log("---postUpdateCurrentDeductBank---");
        if (loginAccountV4 == null || projectInfoV4 == null) {
            opening();
            return;
        }
        if (loginAccountV4.currentDeductBank != null && loginAccountV4.currentDeductBank.intValue() != 1 && projectInfoV4.projectPayConfigDTO != null && projectInfoV4.projectPayConfigDTO.consumePayBank != null && projectInfoV4.projectPayConfigDTO.consumePayBank.intValue() == 1) {
            V4BusinessControllers.getInstance().postUpdateCurrentDeductBank(this.mAccount, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.5
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    super.onComplete(controller, successBean, objArr);
                    if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                        V4NBOr4GOpenControlUtil.this.opening();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    super.onFail(controller, clientException);
                    if (V4NBOr4GOpenControlUtil.this.mIsEnable) {
                        if (clientException.isNeedExitAppV4(clientException.getCode())) {
                            ToastUtils.show(V4NBOr4GOpenControlUtil.this.mActivity, clientException.getDetail());
                            AccountManager.getInstance().clearLoginAccount();
                            LoginActivity.launch(V4NBOr4GOpenControlUtil.this.mActivity);
                            ActivitiesHelper.getInstance().closeAll();
                            return;
                        }
                        V4NBOr4GOpenControlUtil.this.openFail();
                        V4NBOr4GOpenControlUtil.this.showDialog(clientException.getDetail());
                    }
                }
            });
        } else {
            opening();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        openFail();
        showDialog(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        LogUtil.e(TAG, "onError:" + clientException.getCode() + "  " + this.mPreferredCommunicationType + "  " + this.mFlowState);
        if (clientException.isNeedExitAppV4(clientException.getCode())) {
            ToastUtils.show(this.mActivity, clientException.getDetail());
            AccountManager.getInstance().clearLoginAccount();
            LoginActivity.launch(this.mActivity);
            ActivitiesHelper.getInstance().closeAll();
            return;
        }
        if (this.mPreferredCommunicationType == 0 && this.mFlowState == FlowState.openingtoble) {
            this.mFlowState = FlowState.openingtonbor4g;
            authFor4G();
        } else if (this.mPreferredCommunicationType != 0 && this.mFlowState == FlowState.openingtonbor4g) {
            this.mFlowState = FlowState.openingtoble;
            connectDecice();
        } else {
            openFail();
            showDialog(clientException.getDetail());
        }
    }

    private void isNeedLogin() {
        openFail();
        showDialog("学生ID异常,请重新登录");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        LogUtil.e(TAG, "showDialog:" + this.mFlowState + PPSLabelView.Code + str);
        if (this.mFlowState == FlowState.openingtoble || this.mFlowState == FlowState.openingtonbor4g) {
            if (StringUtils.isEmpty(str)) {
                str = "出错啦,请稍后再试";
            }
            BaseMaterialDialog.dissmisMaterialDialog();
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, "提示", str, "我知道了", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil$$ExternalSyntheticLambda0
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public final void onConfirm() {
                    this.f$0.m474x65477529();
                }
            });
        }
    }

    /* JADX INFO: renamed from: lambda$showDialog$0$client-android-yixiaotong-v4-ui-app-bath-V4NBOr4GOpenControlUtil, reason: not valid java name */
    /* synthetic */ void m474x65477529() {
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError() {
        ClientException clientException = this.mClientException;
        if (clientException != null) {
            onError(clientException.getCode(), this.mClientException.getDetail());
        } else {
            onError(0, "开阀失败");
        }
    }

    private void addOfflineLog(String str) {
        LogUtil.e(TAG, "addOfflineLog:" + str);
        if (this.mIsOffineOpen) {
            if (this.mStringBuilderOffline == null) {
                this.mStringBuilderOffline = new StringBuilder();
            }
            this.mStringBuilderOffline.append(TimeUtils.formatDateTime(System.currentTimeMillis()) + x.bQ + str + "    ");
            V4LocalDataUtil.saveOfflineLog(this.mActivity, this.mMachineId, TimeUtils.formatDateTime(System.currentTimeMillis()) + x.bQ + str + "    ");
        }
    }

    public void openPro(String str) {
        int code = LocalDataUtil.getCode(this.mActivity);
        LogUtil.e(TAG, "openPro:" + code);
        if (code < 500 || code >= 600) {
            sendf01();
        } else if (!V4LocalDataUtil.getOpenDeviceForUser(this.mActivity, this.mStudentHex)) {
            showError();
        } else {
            V3BusinessControllers.getInstance().postOpen(this.mAccount, str, V4UserInfoUtil.getInstance().getLoginAccountV4().projectId, this.mMachineRand, this.mProductId + "", this.mStudentHex, (StringUtils.isNotEmpty(this.mMachineType) && StringUtils.isNotEmpty(this.mMachineVersion) && V4DeviceInfoUtil.contains(new StringBuilder().append(this.mMachineType).append(this.mMachineVersion).toString())) ? 1 : 0, "Android(" + AppUtils.getVersion(this.mActivity) + ")  " + LocalDataUtil.getErrorUrl(this.mActivity) + "  (" + LocalDataUtil.getCode(this.mActivity) + ")", true, new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, final String str2, Object... objArr) {
                    if (V4NBOr4GOpenControlUtil.this.mIsEnable && StringUtils.isNotEmpty(V4NBOr4GOpenControlUtil.this.mMachineRand)) {
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GOpenControlUtil.6.1
                            @Override // java.lang.Runnable
                            public void run() {
                                V4NBOr4GOpenControlUtil.this.mState = State.f06pro;
                                V4NBOr4GOpenControlUtil.this.sendData(str2);
                            }
                        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V4NBOr4GOpenControlUtil.this.mIsEnable && StringUtils.isNotEmpty(V4NBOr4GOpenControlUtil.this.mMachineRand)) {
                        V4NBOr4GOpenControlUtil.this.showError();
                    }
                }
            });
        }
    }
}
