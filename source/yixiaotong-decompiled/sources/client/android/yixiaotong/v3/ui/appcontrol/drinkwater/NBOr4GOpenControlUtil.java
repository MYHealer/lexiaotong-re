package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
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
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.DeviceControlUtil;
import client.android.yixiaotong.v3.comman.DeviceInfoUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.ErrorControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.me.ykt.YKTBindActivity;
import client.android.yixiaotong.v3.ui.order.NoPayOrderActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.C;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NBOr4GOpenControlUtil {
    private static final int FIRST_OPEN_BLE = 0;
    private static final int FIRST_OPEN_NBOR4G = 1;
    private static final String TAG = "NBOr4GOpenControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private ClientException mClientException;
    private int mCode;
    private String mCommunicationVal;
    private OpenControlListener mControlListener;
    private String mDeviceVer;
    private ErrorControlListener mErrorControlListener;
    private String mF0Data;
    private FlowState mFlowState;
    private int mHandleType;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private String mMachineType;
    private String mMachineVersion;
    private String mMsg;
    private String mOrderId;
    private State mState;
    private String mStudentHex;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mPreferredCommunicationType = 0;
    private int mCnFlag = 0;
    private int mCount = 0;
    private boolean mIsOffineOpen = false;
    private String mRechargeType = "A2";
    private String mCollectType = "A2";
    private int mPrepaymentType = 0;
    private boolean mIsEnableOfflineOpen = false;
    private String mParFlag = "";

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

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, TypeInfoBaseInfoBean typeInfoBaseInfoBean, int i, String str, String str2) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mBluetoothDevice = bluetoothDevice;
        this.mTypeInfoBaseInfoBean = typeInfoBaseInfoBean;
        this.mTypeId = i;
        this.mStudentHex = str;
        this.mTitleContent = str2;
        this.mIsOffineOpen = false;
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

    public void setHandleType(int i) {
        this.mHandleType = i;
    }

    public void setListener(OpenControlListener openControlListener) {
        this.mControlListener = openControlListener;
    }

    public void setOrderIdPulse(String str, int i) {
        this.mOrderId = str;
        this.mPrepaymentType = i;
    }

    static /* synthetic */ int access$908(NBOr4GOpenControlUtil nBOr4GOpenControlUtil) {
        int i = nBOr4GOpenControlUtil.mCount;
        nBOr4GOpenControlUtil.mCount = i + 1;
        return i;
    }

    public void setDeviceInfo(int i, int i2, int i3, String str, String str2) {
        this.mPreferredCommunicationType = i;
        this.mCnFlag = i3;
        this.mDeviceVer = str;
        this.mMachineId = str2;
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
        if (StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() >= 4) {
            if (DeviceControlUtil.isLiDeviceAndUnTransfereed(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3))) {
                LogUtil.i(TAG, "新设备1");
                NBDeviceCommand.setTransferredMeaning(false);
                return;
            } else {
                LogUtil.i(TAG, "旧设备1");
                NBDeviceCommand.setTransferredMeaning(true);
                return;
            }
        }
        showDialog("设备型号异常：[" + this.mMachineId + "][设备型号：" + this.mDeviceVer + "]");
    }

    public void connected() {
        sendf0();
    }

    public void connectedForOpened() {
        sendf08();
    }

    public void onBluetoothError(int i, String str) {
        LogUtil.log(str + i);
        this.mMsg = str;
        this.mCode = i;
        if (this.mPreferredCommunicationType == 0 && this.mFlowState == FlowState.openingtoble) {
            LogUtil.log("蓝牙开阀失败 开始转nb/4g通道");
            auth("", false, this.mHandleType);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void openStart() {
        LogUtil.log("--------开始执行开阀流程----------");
        this.mIsEnableOfflineOpen = LocalDataUtil.getIsEnableOffline(this.mActivity);
        this.mState = State.f0;
        this.mCommunicationVal = "";
        this.mMsg = "";
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

    public void openOffineStart(ClientException clientException) {
        this.mClientException = clientException;
        ErrorControlListener errorControlListener = this.mErrorControlListener;
        if (errorControlListener != null) {
            errorControlListener.onFail(clientException);
        }
        LogUtil.log("是否支持脱机：" + LocalDataUtil.getIsEnableOffline(this.mActivity) + "  " + (this.mClientException != null));
        LogUtil.log("openOffineStart:" + (!LocalDataUtil.getIsEnableOffline(this.mActivity)) + PPSLabelView.Code + this.mIsOffineOpen + "  " + (clientException != null) + PPSLabelView.Code + LocalDataUtil.getIsFirstOffline(this.mActivity));
        LogUtil.e(TAG, "openOffineStart:" + (!LocalDataUtil.getIsEnableOffline(this.mActivity)) + PPSLabelView.Code + this.mIsOffineOpen + "  " + (clientException != null) + PPSLabelView.Code + LocalDataUtil.getIsFirstOffline(this.mActivity));
        if ((!Error50XUtil.isInterrupt(this.mActivity) || this.mIsOffineOpen) && clientException != null) {
            onError(clientException);
            return;
        }
        disconnect();
        this.mIsOffineOpen = true;
        this.mState = State.f0;
        this.mCommunicationVal = "";
        this.mMsg = "";
        LogUtil.e(TAG, "蓝牙脱机开阀");
        LogUtil.log("蓝牙脱机开阀");
        this.mFlowState = FlowState.openingtoble;
        NBDeviceCommand.setTransferredMeaning(false);
        connectDecice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEnd(boolean z) {
        LogUtil.e(TAG, "openEnd:" + z + "  " + this.mFlowState);
        LogUtil.log("开阀成功:开阀方式：" + (z ? "蓝牙开阀" : "NB/4G开阀") + "  " + this.mFlowState);
        LogUtil.log("--------开阀流程结束----------");
        LogUtil.log("--------开始执行开阀成功后流程----------");
        LocalDataUtil.saveOpenDeviceForUser(this.mActivity, this.mStudentHex);
        if (this.mFlowState == FlowState.openingtonbor4g || this.mFlowState == FlowState.openingtoble) {
            this.mControlListener.onOpenEnd();
            if (this.mIsOffineOpen) {
                this.mFlowState = FlowState.opened;
                return;
            }
            postMachineRunInfo();
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
    public void sendf01() {
        LogUtil.i(TAG, "01");
        LogUtil.log("01");
        String strOpenOffineCommand = NBDeviceCommand.openOffineCommand(this.mStudentHex, LocalDataUtil.getCardId(this.mActivity), this.mMachineRand);
        this.mState = State.f01;
        sendData(strOpenOffineCommand);
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
            LogUtil.e(TAG, "onReceivedData:" + this.mFlowState + "  " + this.mState + "  " + this.mIsOffineOpen + "  " + str);
            if (this.mIsOffineOpen) {
                if (this.mState == State.f0) {
                    this.mF0Data = str;
                    BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
                    String type = DeviceInfoUtil.getInstance().getType(str);
                    String version = DeviceInfoUtil.getInstance().getVersion(str);
                    this.mMachineType = type;
                    this.mMachineVersion = version;
                    if (StringUtils.isEmpty(this.mMachineId)) {
                        this.mMachineId = DeviceInfoUtil.getInstance().getSN(this.mF0Data);
                    }
                    LogUtil.i(TAG, "type：" + type + "version:" + version);
                    if (DeviceControlUtil.isLiDeviceAndUnTransfereed(type, version)) {
                        LogUtil.i(TAG, "新设备1");
                        NBDeviceCommand.setTransferredMeaning(false);
                    } else {
                        NBDeviceCommand.setTransferredMeaning(true);
                    }
                    sendf08pro();
                    return;
                }
                if (this.mState == State.f08) {
                    this.mMachineRand = str.substring(22, 30);
                    sendf01();
                    return;
                }
                if (this.mState == State.f01) {
                    if (str.length() > 24) {
                        if (str.substring(22, 24).equals("00")) {
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
                        if (str.substring(22, 24).equals("02")) {
                            onError(0, "开阀失败，账号未绑定！");
                            return;
                        } else if (str.substring(22, 24).equals("01")) {
                            onError(0, "脱机开阀失败！");
                            return;
                        } else {
                            onError(0, "脱机开阀失败" + str.substring(22, 24));
                            return;
                        }
                    }
                    return;
                }
                if (this.mState == State.f08pro) {
                    this.mMachineRand = str.substring(22, 30);
                    openPro(this.mMachineId);
                    return;
                }
                if (this.mState == State.f06pro) {
                    if (str.length() > 24 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("03"))) {
                        openEnd(true);
                        return;
                    } else if (LocalDataUtil.getIsEnableOffline(this.mActivity)) {
                        sendf08();
                        return;
                    } else {
                        onError(0, "开阀失败" + str.substring(22, 24));
                        return;
                    }
                }
                return;
            }
            if (this.mFlowState == FlowState.openingtoble || this.mFlowState == FlowState.openingtonbor4g) {
                if (this.mState == State.f0) {
                    this.mF0Data = str;
                    LogUtil.e(TAG, "设备版本：" + this.mDeviceVer);
                    if (StringUtils.isEmpty(this.mDeviceVer) || (StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() != 5)) {
                        this.mDeviceVer = DeviceInfoUtil.getInstance().getTypeAndVersion(this.mF0Data);
                    }
                    LogUtil.e(TAG, "设备版本：：" + this.mDeviceVer);
                    saveIsEnableOffline(str);
                    sendf08();
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.i(TAG, "studentid:" + this.mStudentHex);
                        if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
                            auth("", true, this.mHandleType);
                            return;
                        } else {
                            sendf02(true);
                            return;
                        }
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
                        uploadOrder(str);
                        return;
                    } else {
                        auth("", true, this.mHandleType);
                        return;
                    }
                }
                if (this.mState == State.f06) {
                    if (str.length() > 24) {
                        if (str.substring(22, 24).equals("00") || (str.substring(22, 24).equalsIgnoreCase("AA") && DeviceControlUtil.isNeedSetPValue(this.mDeviceVer))) {
                            openEnd(true);
                            return;
                        }
                        if (str.substring(22, 24).equals("03")) {
                            if (str.length() >= 32) {
                                String strSubstring2 = str.substring(24, 32);
                                LogUtil.i(TAG, "已开阀ID：" + strSubstring2 + "  当前ID:" + this.mStudentHex);
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
                    saveIsEnableOffline(str);
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
                if (str.substring(22, 24).equals("00") || (str.substring(22, 24).equalsIgnoreCase("AA") && DeviceControlUtil.isNeedSetPValue(this.mDeviceVer))) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void sendData(String str) {
        if (this.mState == State.f02 && isZFBSDK()) {
            NBDeviceCommand.setIsAliSDKCommand(true);
        } else {
            NBDeviceCommand.setIsAliSDKCommand(false);
        }
        BluetoothControlUtil.getInstance().setSendTimeOut(5000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isZFBSDK() {
        return StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() > 3 && DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1;
    }

    private void uploadOrder(String str) {
        NBOr4GDevice nBOr4GDevice = new NBOr4GDevice();
        nBOr4GDevice.machineRandom = this.mMachineRand;
        String strSubstring = str.substring(42, 58);
        String strSubstring2 = str.substring(58, 70);
        String strReceivedResult = BathUtil.receivedResult(str.substring(20, 22), str.substring(4, 6), str.substring(6, 8));
        int i = Integer.parseInt(str.substring(70, 72), 16);
        if (DeviceControlUtil.getModeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1) {
            strSubstring = str.substring(42, 74);
            strSubstring2 = str.substring(74, 86);
            i = Integer.parseInt(str.substring(86, 88), 16);
        }
        nBOr4GDevice.machineData = strSubstring;
        nBOr4GDevice.posSystemTime = strSubstring2;
        nBOr4GDevice.statusInfo = strReceivedResult;
        int i2 = this.mTypeId;
        final int i3 = (i2 == 3 || i2 == 16) ? i : 0;
        nBOr4GDevice.handleType = i3;
        if (isZFBSDK() && str.length() > 78) {
            nBOr4GDevice.signatureFile = StringUtils.hexStringToStr(str.substring(78));
        }
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, Integer.parseInt(str.substring(24, 26), 16), new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (NBOr4GOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.i(NBOr4GOpenControlUtil.TAG, ifNull);
                    try {
                        CollectResultBean collectResultBean = (CollectResultBean) GsonUtils.getInstance().parse(new TypeToken<CollectResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.1.1
                        }.getType(), ifNull);
                        LogUtil.i(NBOr4GOpenControlUtil.TAG, NBOr4GOpenControlUtil.this.mFlowState + "");
                        if (NBOr4GOpenControlUtil.this.mFlowState != FlowState.collet && NBOr4GOpenControlUtil.this.mFlowState != FlowState.opened) {
                            NBOr4GOpenControlUtil.this.auth(collectResultBean.lastPosMoney + "," + collectResultBean.lastPosSerial, true, i3);
                            return;
                        }
                        String str2 = "02" + collectResultBean.systemData + collectResultBean.systemTime;
                        if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                            str2 = collectResultBean.systemType + collectResultBean.systemData + collectResultBean.systemTime;
                        }
                        NBOr4GOpenControlUtil.this.sendf06(str2);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NBOr4GOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(NBOr4GOpenControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        LogUtil.d(NBOr4GOpenControlUtil.TAG, ifNull);
                        NoPayOrderActivity.launch(NBOr4GOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), NBOr4GOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                            return;
                        }
                        NBOr4GOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    if (clientException.getCode() == -44 || clientException.getCode() == -50 || clientException.getCode() == -45) {
                        NBOr4GOpenControlUtil.this.onError(clientException);
                    } else if (NBOr4GOpenControlUtil.this.mFlowState == FlowState.collet || NBOr4GOpenControlUtil.this.mFlowState == FlowState.opened || DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                        NBOr4GOpenControlUtil.this.onError(clientException);
                    } else {
                        NBOr4GOpenControlUtil.this.openOffineStart(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x006f  */
    public void auth(final String str, final boolean z, int i) {
        int i2;
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        machineInfoJson.machineData = str;
        machineInfoJson.machineRandom = this.mMachineRand;
        int i3 = this.mTypeId;
        if (i3 == 3 || i3 == 16) {
            if (this.mFlowState == FlowState.openingtoble || this.mFlowState == FlowState.openingtonbor4g) {
                machineInfoJson.handleType = this.mHandleType;
            } else {
                machineInfoJson.handleType = i;
            }
        }
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
            int i4 = this.mCnFlag;
            if (i4 == 0) {
                machineInfoJson.lastPosSerial = "0000";
                machineInfoJson.lastPosMoney = "0000";
                i2 = 2;
            } else {
                i2 = 4;
                if (i4 == 4) {
                    machineInfoJson.lastPosSerial = "0000";
                    machineInfoJson.lastPosMoney = "0000";
                }
            }
            if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
                machineInfoJson.orderId = this.mOrderId;
                machineInfoJson.type = this.mPrepaymentType;
            }
            V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i2, this.mTypeId, this.mDeviceVer, this.mMachineId, DeviceInfoUtil.getInstance().getDeviceVer(this.mF0Data), machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, Object obj, Object... objArr) {
                    if (NBOr4GOpenControlUtil.this.mIsEnable) {
                        String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                        LogUtil.d(NBOr4GOpenControlUtil.TAG, ifNull);
                        try {
                            PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.2.1
                            }.getType(), ifNull);
                            NBOr4GOpenControlUtil.this.mCommunicationVal = postOpenAuthBean.communicationVal;
                            if (StringUtils.isEmpty(str) && !z) {
                                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        NBOr4GOpenControlUtil.this.mCount = 0;
                                        NBOr4GOpenControlUtil.this.getStatus();
                                    }
                                }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                            } else {
                                String str2 = "02" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                                if (NBOr4GOpenControlUtil.this.mFlowState == FlowState.openingtoble || NBOr4GOpenControlUtil.this.mFlowState == FlowState.openingtonbor4g) {
                                    str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                                    if (StringUtils.isNotEmpty(postOpenAuthBean.agreementNoHex) && NBOr4GOpenControlUtil.this.isZFBSDK()) {
                                        LogUtil.e(NBOr4GOpenControlUtil.TAG, "阿里加签数据：" + postOpenAuthBean.agreementNoHex);
                                        str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime + postOpenAuthBean.agreementNoHex;
                                    }
                                    if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                                        str2 = postOpenAuthBean.systemType + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                                        if (StringUtils.isNotEmpty(postOpenAuthBean.agreementNoHex) && NBOr4GOpenControlUtil.this.isZFBSDK()) {
                                            str2 = postOpenAuthBean.systemType + postOpenAuthBean.systemData + postOpenAuthBean.systemTime + postOpenAuthBean.agreementNoHex;
                                        }
                                    }
                                }
                                NBOr4GOpenControlUtil.this.sendf06(str2);
                            }
                            LogUtil.e(NBOr4GOpenControlUtil.TAG, "open:" + postOpenAuthBean.offlineDuration + PPSLabelView.Code + postOpenAuthBean.offline + PPSLabelView.Code + NBOr4GOpenControlUtil.this.mIsEnableOfflineOpen);
                            if (postOpenAuthBean.offlineDuration != null) {
                                LocalDataUtil.saveEnableOfflineTime(NBOr4GOpenControlUtil.this.mActivity, postOpenAuthBean.offlineDuration);
                            }
                            if ((postOpenAuthBean.offline == null || postOpenAuthBean.offline.intValue() != 0) && !NBOr4GOpenControlUtil.this.mIsEnableOfflineOpen) {
                                LocalDataUtil.saveIsEnableOffline(NBOr4GOpenControlUtil.this.mActivity, false);
                            } else {
                                NBOr4GOpenControlUtil.this.mIsEnableOfflineOpen = true;
                                LocalDataUtil.saveIsEnableOffline(NBOr4GOpenControlUtil.this.mActivity, true);
                            }
                        } catch (ClientException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (NBOr4GOpenControlUtil.this.mIsEnable) {
                        if (clientException.getCode() == -52) {
                            ToastUtils.show(NBOr4GOpenControlUtil.this.mActivity, clientException.getDetail());
                            String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                            LogUtil.e(NBOr4GOpenControlUtil.TAG, "onFail:" + ifNull);
                            NoPayOrderActivity.launch(NBOr4GOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), NBOr4GOpenControlUtil.this.mTypeInfoBaseInfoBean);
                            if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                                return;
                            }
                            NBOr4GOpenControlUtil.this.mActivity.finish();
                            return;
                        }
                        if (clientException.getCode() == -521) {
                            NBOr4GOpenControlUtil.this.bindDialog();
                            return;
                        }
                        if (clientException.getCode() == -44 || clientException.getCode() == -50 || clientException.getCode() == -45 || DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                            NBOr4GOpenControlUtil.this.onError(clientException);
                        } else {
                            NBOr4GOpenControlUtil.this.openOffineStart(clientException);
                        }
                    }
                }
            });
        }
        i2 = 1;
        if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
            machineInfoJson.orderId = this.mOrderId;
            machineInfoJson.type = this.mPrepaymentType;
        }
        V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i2, this.mTypeId, this.mDeviceVer, this.mMachineId, DeviceInfoUtil.getInstance().getDeviceVer(this.mF0Data), machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (NBOr4GOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.d(NBOr4GOpenControlUtil.TAG, ifNull);
                    try {
                        PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.2.1
                        }.getType(), ifNull);
                        NBOr4GOpenControlUtil.this.mCommunicationVal = postOpenAuthBean.communicationVal;
                        if (StringUtils.isEmpty(str) && !z) {
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    NBOr4GOpenControlUtil.this.mCount = 0;
                                    NBOr4GOpenControlUtil.this.getStatus();
                                }
                            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                        } else {
                            String str2 = "02" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                            if (NBOr4GOpenControlUtil.this.mFlowState == FlowState.openingtoble || NBOr4GOpenControlUtil.this.mFlowState == FlowState.openingtonbor4g) {
                                str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                                if (StringUtils.isNotEmpty(postOpenAuthBean.agreementNoHex) && NBOr4GOpenControlUtil.this.isZFBSDK()) {
                                    LogUtil.e(NBOr4GOpenControlUtil.TAG, "阿里加签数据：" + postOpenAuthBean.agreementNoHex);
                                    str2 = "01" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime + postOpenAuthBean.agreementNoHex;
                                }
                                if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                                    str2 = postOpenAuthBean.systemType + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                                    if (StringUtils.isNotEmpty(postOpenAuthBean.agreementNoHex) && NBOr4GOpenControlUtil.this.isZFBSDK()) {
                                        str2 = postOpenAuthBean.systemType + postOpenAuthBean.systemData + postOpenAuthBean.systemTime + postOpenAuthBean.agreementNoHex;
                                    }
                                }
                            }
                            NBOr4GOpenControlUtil.this.sendf06(str2);
                        }
                        LogUtil.e(NBOr4GOpenControlUtil.TAG, "open:" + postOpenAuthBean.offlineDuration + PPSLabelView.Code + postOpenAuthBean.offline + PPSLabelView.Code + NBOr4GOpenControlUtil.this.mIsEnableOfflineOpen);
                        if (postOpenAuthBean.offlineDuration != null) {
                            LocalDataUtil.saveEnableOfflineTime(NBOr4GOpenControlUtil.this.mActivity, postOpenAuthBean.offlineDuration);
                        }
                        if ((postOpenAuthBean.offline == null || postOpenAuthBean.offline.intValue() != 0) && !NBOr4GOpenControlUtil.this.mIsEnableOfflineOpen) {
                            LocalDataUtil.saveIsEnableOffline(NBOr4GOpenControlUtil.this.mActivity, false);
                        } else {
                            NBOr4GOpenControlUtil.this.mIsEnableOfflineOpen = true;
                            LocalDataUtil.saveIsEnableOffline(NBOr4GOpenControlUtil.this.mActivity, true);
                        }
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NBOr4GOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(NBOr4GOpenControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        LogUtil.e(NBOr4GOpenControlUtil.TAG, "onFail:" + ifNull);
                        NoPayOrderActivity.launch(NBOr4GOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), NBOr4GOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                            return;
                        }
                        NBOr4GOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    if (clientException.getCode() == -521) {
                        NBOr4GOpenControlUtil.this.bindDialog();
                        return;
                    }
                    if (clientException.getCode() == -44 || clientException.getCode() == -50 || clientException.getCode() == -45 || DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                        NBOr4GOpenControlUtil.this.onError(clientException);
                    } else {
                        NBOr4GOpenControlUtil.this.openOffineStart(clientException);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStatus() {
        if (this.mFlowState == FlowState.opened || StringUtils.isEmpty(this.mCommunicationVal)) {
            return;
        }
        V3BusinessControllers.getInstance().getNBOr4GStatus(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, 1, this.mCommunicationVal, new Listener<NBOr4GStatuBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NBOr4GStatuBean nBOr4GStatuBean, Object... objArr) {
                if (!NBOr4GOpenControlUtil.this.mIsEnable || nBOr4GStatuBean == null) {
                    return;
                }
                if (nBOr4GStatuBean.status == 0) {
                    NBOr4GOpenControlUtil.this.openEnd(false);
                    return;
                }
                if (NBOr4GOpenControlUtil.this.mCount != 0) {
                    if (NBOr4GOpenControlUtil.this.mPreferredCommunicationType == 0) {
                        NBOr4GOpenControlUtil nBOr4GOpenControlUtil = NBOr4GOpenControlUtil.this;
                        nBOr4GOpenControlUtil.onError(nBOr4GOpenControlUtil.mCode, NBOr4GOpenControlUtil.this.mMsg);
                    }
                } else {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NBOr4GOpenControlUtil.this.getStatus();
                        }
                    }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    if (NBOr4GOpenControlUtil.this.mPreferredCommunicationType != 0) {
                        NBOr4GOpenControlUtil.this.mFlowState = FlowState.openingtoble;
                        NBOr4GOpenControlUtil.this.connectDecice();
                    }
                }
                NBOr4GOpenControlUtil.access$908(NBOr4GOpenControlUtil.this);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NBOr4GOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -44 || clientException.getCode() == -50 || clientException.getCode() == -45 || DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                        NBOr4GOpenControlUtil.this.onError(clientException);
                    } else {
                        NBOr4GOpenControlUtil.this.openOffineStart(clientException);
                    }
                }
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
        V3BusinessControllers.getInstance().postMachineRunInfo(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, machineStatusData, new Listener<BluetoothSetBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.4
        });
    }

    private void uploadDeviceInfoResult() {
        if (StringUtils.isNotEmpty(this.mParFlag)) {
            V3BusinessControllers.getInstance().postBluetoothSetDataResult(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mParFlag, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.5
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
            V3BusinessControllers.getInstance().postBluetoothSetData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, setData, new Listener<BluetoothSetBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, BluetoothSetBean bluetoothSetBean, Object... objArr) {
                    if (NBOr4GOpenControlUtil.this.mIsEnable) {
                        if (bluetoothSetBean != null && StringUtils.isNotEmpty(bluetoothSetBean.parameterInfo) && bluetoothSetBean.parameterInfo.length() >= 18) {
                            LocalDataUtil.saveUseDeviceTimeoutAlert(NBOr4GOpenControlUtil.this.mActivity, Integer.parseInt(bluetoothSetBean.parameterInfo.substring(16, 18), 16));
                        }
                        if (bluetoothSetBean == null || bluetoothSetBean.statusFlag != 0 || !StringUtils.isNotEmpty(bluetoothSetBean.systemData)) {
                            NBOr4GOpenControlUtil.this.disconnect();
                            return;
                        }
                        NBOr4GOpenControlUtil.this.mParFlag = bluetoothSetBean.parFlag;
                        NBOr4GOpenControlUtil.this.mFlowState = FlowState.set;
                        NBOr4GOpenControlUtil.this.sendf07(bluetoothSetBean.systemData);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (NBOr4GOpenControlUtil.this.mIsEnable) {
                        NBOr4GOpenControlUtil.this.disconnect();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        openFail();
        V3ErrorTipActivity.launchBluetoothFailForOpen(this.mActivity, this.mTitleContent, str, i);
        if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
            return;
        }
        this.mActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (Error50XUtil.isInterrupt(this.mActivity) && LocalDataUtil.getIsEnableOffline(this.mActivity)) {
            openFail();
            onError(0, "蓝牙连接失败，尝试重启手机蓝牙再试！");
            return;
        }
        if (clientException.isNeedTip(clientException.getCode())) {
            openFail();
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.7
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                        return;
                    }
                    NBOr4GOpenControlUtil.this.mActivity.finish();
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")");
            return;
        }
        if (clientException.getCode() == -50 && this.mCnFlag != 1) {
            if (this.mPreferredCommunicationType == 0 && this.mFlowState == FlowState.openingtoble) {
                auth("", false, this.mHandleType);
                return;
            }
            if (this.mPreferredCommunicationType != 0 && this.mFlowState == FlowState.openingtonbor4g) {
                this.mFlowState = FlowState.openingtoble;
                connectDecice();
                return;
            }
            openFail();
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), this.mTypeId == 18 ? 2 : 4, clientException.getSerial());
            if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
                return;
            }
            this.mActivity.finish();
            return;
        }
        openFail();
        V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), this.mTypeId == 18 ? 2 : 4, clientException.getSerial());
        if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
            return;
        }
        this.mActivity.finish();
    }

    private void isNeedLogin() {
        openFail();
        V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, "学生ID异常,请重新登录", -44, this.mTypeId == 18 ? 2 : 4, System.currentTimeMillis() + "");
        if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
            return;
        }
        this.mActivity.finish();
    }

    private void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    private void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.8
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                if (DeviceControlUtil.isNeedSetPValue(NBOr4GOpenControlUtil.this.mDeviceVer)) {
                    return;
                }
                NBOr4GOpenControlUtil.this.mActivity.finish();
            }
        }, str);
    }

    private void saveIsEnableOffline(String str) {
        if (DeviceInfoUtil.getInstance().isEnableOffline(str) || this.mIsEnableOfflineOpen) {
            this.mIsEnableOfflineOpen = true;
            LocalDataUtil.saveIsEnableOffline(this.mActivity, true);
            LogUtil.log("设备支持脱机开阀");
            LogUtil.e(TAG, "设备支持脱机开阀");
            return;
        }
        LocalDataUtil.saveIsEnableOffline(this.mActivity, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindDialog() {
        TwoButtonDialog.getInstance().showDialog(this.mActivity, new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.9
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                YKTBindActivity.launch(NBOr4GOpenControlUtil.this.mActivity);
                NBOr4GOpenControlUtil.this.mActivity.finish();
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
                NBOr4GOpenControlUtil.this.mActivity.finish();
            }
        }, "提示", "您还未绑定一卡通账号，请绑定后再使用设备", "取消", "去绑定");
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0089  */
    private void openPro(String str) {
        int i;
        String str2;
        int code = LocalDataUtil.getCode(this.mActivity);
        LogUtil.e(TAG, "openPro:" + code + PPSLabelView.Code + LocalDataUtil.getOpenDeviceForUser(this.mActivity, this.mStudentHex) + PPSLabelView.Code + isUseTime());
        if (code < 500 || code >= 600) {
            sendf01();
            return;
        }
        if (!LocalDataUtil.getOpenDeviceForUser(this.mActivity, this.mStudentHex) && !isUseTime()) {
            sendf01();
            return;
        }
        LogUtil.e(TAG, "openPro:" + str);
        if (StringUtils.isEmpty(str)) {
            return;
        }
        if (StringUtils.isNotEmpty(this.mMachineType) && StringUtils.isNotEmpty(this.mMachineVersion)) {
            i = DeviceControlUtil.getModeForLi(this.mMachineType, this.mMachineVersion) != 1 ? 0 : 1;
        }
        int i2 = i;
        int i3 = this.mTypeId;
        if (i3 == 6) {
            str2 = "2";
        } else {
            str2 = i3 == 8 ? "3" : "1";
        }
        V3BusinessControllers.getInstance().postOpen(this.mAccount, str, InvestorInfoUtilControl.getInstance().getInvestorId(), this.mMachineRand, (StringUtils.isNotEmpty(this.mMachineType) && StringUtils.isNotEmpty(this.mMachineVersion) && this.mMachineType.equals("01") && (this.mMachineVersion.equals("04") || this.mMachineVersion.equals("06") || this.mMachineVersion.equals("07"))) ? "2" : str2, this.mStudentHex, i2, "Android(" + AppUtils.getVersion(this.mActivity) + ")  " + LocalDataUtil.getErrorUrl(this.mActivity) + "  (" + LocalDataUtil.getCode(this.mActivity) + ")", false, new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final String str3, Object... objArr) {
                if (NBOr4GOpenControlUtil.this.mIsEnable && StringUtils.isNotEmpty(NBOr4GOpenControlUtil.this.mMachineRand)) {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GOpenControlUtil.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            NBOr4GOpenControlUtil.this.mState = State.f06pro;
                            NBOr4GOpenControlUtil.this.sendData(str3);
                        }
                    }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NBOr4GOpenControlUtil.this.mIsEnable && StringUtils.isNotEmpty(NBOr4GOpenControlUtil.this.mMachineRand)) {
                    NBOr4GOpenControlUtil.this.sendf01();
                }
            }
        });
    }

    private boolean isUseTime() {
        LogUtil.e(TAG, "isUseTime:" + System.currentTimeMillis());
        if (System.currentTimeMillis() > 1788019200000L && System.currentTimeMillis() < 1789056000000L) {
            return true;
        }
        if (System.currentTimeMillis() <= 1791129600000L || System.currentTimeMillis() >= 1792166400000L) {
            return System.currentTimeMillis() > 1772985600000L && System.currentTimeMillis() < 1774368000000L;
        }
        return true;
    }
}
