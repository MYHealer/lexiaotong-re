package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

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
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.CollectResultBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineInfoJson;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GDevice;
import client.android.yixiaotong.v3.bean.deviceinfo.PostOpenAuthBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.DeviceControlUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.NoPayOrderActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.gson.reflect.TypeToken;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class NBOr4GCloseControlUtil {
    private static final String TAG = "NBOr4GCloseControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private CloseControlListener mControlListener;
    private String mDeviceVer;
    private String mF0Data;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private State mState;
    private String mStudentHex;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mCnFlag = 0;
    private boolean mIsClose = false;

    private enum FlowState {
        closeing,
        closed
    }

    private enum State {
        f0,
        f08,
        f02,
        f06,
        f14
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
        this.mIsClose = false;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setCloseDevice() {
        this.mIsClose = true;
    }

    public void setDeviceInfo(int i, String str, String str2) {
        this.mCnFlag = i;
        this.mDeviceVer = str;
        this.mMachineId = str2;
    }

    public void setListener(CloseControlListener closeControlListener) {
        this.mControlListener = closeControlListener;
    }

    public void connected() {
        sendf0();
    }

    private void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void closeStart() {
        LogUtil.log("--------开始执行关阀流程----------");
        this.mState = State.f0;
        this.mFlowState = FlowState.closeing;
        connectDecice();
    }

    public void closeEnd() {
        this.mFlowState = FlowState.closed;
        this.mControlListener.onCloseEnd();
        LogUtil.log("--------关阀流程结束----------");
    }

    private void sendf0() {
        String strSelectInfoCommand = NBDeviceCommand.selectInfoCommand();
        this.mState = State.f0;
        LogUtil.log("f0");
        sendData(strSelectInfoCommand);
    }

    private void sendf14() {
        LogUtil.d(TAG, BaseWrapper.ENTER_ID_AD_SDK);
        LogUtil.log(BaseWrapper.ENTER_ID_AD_SDK);
        String strCloseCommand = NBDeviceCommand.closeCommand("00" + this.mStudentHex);
        this.mState = State.f14;
        sendData(strCloseCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf06(String str) {
        LogUtil.d(TAG, "06");
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
        LogUtil.d(TAG, "08");
        LogUtil.log("08");
        String randCommand = NBDeviceCommand.getRandCommand();
        this.mState = State.f08;
        sendData(randCommand);
    }

    private void sendf02(boolean z) {
        LogUtil.d(TAG, "02");
        LogUtil.log("02");
        String strCollectOrderCommand = NBDeviceCommand.collectOrderCommand(z, this.mStudentHex);
        this.mState = State.f02;
        sendData(strCollectOrderCommand);
    }

    public void onReceivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str)) {
            LogUtil.e(TAG, "onReceivedData:" + this.mFlowState + "  " + this.mState);
            if (this.mFlowState == FlowState.closeing) {
                if (this.mState == State.f0) {
                    this.mF0Data = str;
                    sendf14();
                    return;
                }
                if (this.mState == State.f14) {
                    if ((str.length() <= 24 || !str.substring(22, 24).equals("00")) && str.length() > 24) {
                        if (this.mIsClose) {
                            closeEnd();
                            return;
                        } else {
                            onError(0, "关阀失败，请在设备上关阀");
                            return;
                        }
                    }
                    if (StringUtils.isEmpty(this.mMachineId) || StringUtils.isEmpty(this.mDeviceVer) || this.mIsClose) {
                        closeEnd();
                        return;
                    } else {
                        sendf08();
                        return;
                    }
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.d(TAG, "studentid:" + this.mStudentHex);
                        sendf02(true);
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState == State.f02) {
                    if (str.length() >= 72 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01"))) {
                        uploadOrder(str);
                        return;
                    } else {
                        updateStatus(str);
                        closeEnd();
                        return;
                    }
                }
                if (this.mState == State.f06) {
                    closeEnd();
                    return;
                }
                return;
            }
            if (this.mFlowState == FlowState.closed) {
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.d(TAG, "studentid:" + this.mStudentHex);
                        sendf02(false);
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState == State.f02) {
                    if (str.length() >= 72) {
                        if (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01")) {
                            uploadOrder(str);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.mState == State.f06) {
                    sendf08();
                }
            }
        }
    }

    private void sendData(String str) {
        if (this.mState == State.f02 && DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1) {
            NBDeviceCommand.setIsAliSDKCommand(true);
        } else {
            NBDeviceCommand.setIsAliSDKCommand(false);
        }
        BluetoothControlUtil.getInstance().setSendTimeOut(5000);
        BluetoothControlUtil.getInstance().sendDataInNeedSend(str);
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
        if (i2 != 3 && i2 != 16) {
            i = 0;
        }
        nBOr4GDevice.handleType = i;
        if (DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1 && str.length() > 78) {
            str.substring(78);
            nBOr4GDevice.signatureFile = StringUtils.hexStringToStr(str.substring(78));
        }
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, Integer.parseInt(str.substring(24, 26), 16), new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (NBOr4GCloseControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.d(NBOr4GCloseControlUtil.TAG, ifNull);
                    try {
                        CollectResultBean collectResultBean = (CollectResultBean) GsonUtils.getInstance().parse(new TypeToken<CollectResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.1.1
                        }.getType(), ifNull);
                        NBOr4GCloseControlUtil.this.sendf06("02" + collectResultBean.systemData + collectResultBean.systemTime);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NBOr4GCloseControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(NBOr4GCloseControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        LogUtil.d(NBOr4GCloseControlUtil.TAG, ifNull);
                        NoPayOrderActivity.launch(NBOr4GCloseControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), NBOr4GCloseControlUtil.this.mTypeInfoBaseInfoBean);
                        NBOr4GCloseControlUtil.this.mActivity.finish();
                        return;
                    }
                    NBOr4GCloseControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void auth(String str, int i) {
        int i2;
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        machineInfoJson.machineData = str;
        machineInfoJson.machineRandom = this.mMachineRand;
        int i3 = this.mTypeId;
        if (i3 == 3 || i3 == 16) {
            machineInfoJson.handleType = i;
        }
        if (!StringUtils.isEmpty(str)) {
            String[] strArrSplit = str.split(",");
            machineInfoJson.lastPosMoney = strArrSplit[0];
            machineInfoJson.lastPosSerial = strArrSplit[1];
        } else {
            int i4 = this.mCnFlag;
            if (i4 == 0) {
                machineInfoJson.lastPosSerial = "0000";
                machineInfoJson.lastPosMoney = "0000";
                i2 = 2;
            } else if (i4 == 4) {
                machineInfoJson.lastPosSerial = "0000";
                machineInfoJson.lastPosMoney = "0000";
                i2 = 4;
            }
            V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i2, this.mTypeId, this.mDeviceVer, this.mMachineId, "", machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, Object obj, Object... objArr) {
                    if (NBOr4GCloseControlUtil.this.mIsEnable) {
                        String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                        LogUtil.d(NBOr4GCloseControlUtil.TAG, ifNull);
                        try {
                            PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.2.1
                            }.getType(), ifNull);
                            NBOr4GCloseControlUtil.this.sendf06("02" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime);
                        } catch (ClientException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (NBOr4GCloseControlUtil.this.mIsEnable) {
                        if (clientException.getCode() == -52) {
                            ToastUtils.show(NBOr4GCloseControlUtil.this.mActivity, clientException.getDetail());
                            String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                            LogUtil.d(NBOr4GCloseControlUtil.TAG, ifNull);
                            NoPayOrderActivity.launch(NBOr4GCloseControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), NBOr4GCloseControlUtil.this.mTypeInfoBaseInfoBean);
                            NBOr4GCloseControlUtil.this.mActivity.finish();
                            return;
                        }
                        NBOr4GCloseControlUtil.this.onError(clientException);
                    }
                }
            });
        }
        i2 = 1;
        V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i2, this.mTypeId, this.mDeviceVer, this.mMachineId, "", machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (NBOr4GCloseControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.d(NBOr4GCloseControlUtil.TAG, ifNull);
                    try {
                        PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.2.1
                        }.getType(), ifNull);
                        NBOr4GCloseControlUtil.this.sendf06("02" + postOpenAuthBean.systemData + postOpenAuthBean.systemTime);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (NBOr4GCloseControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(NBOr4GCloseControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        LogUtil.d(NBOr4GCloseControlUtil.TAG, ifNull);
                        NoPayOrderActivity.launch(NBOr4GCloseControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), NBOr4GCloseControlUtil.this.mTypeInfoBaseInfoBean);
                        NBOr4GCloseControlUtil.this.mActivity.finish();
                        return;
                    }
                    NBOr4GCloseControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void updateStatus(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() <= 22) {
            return;
        }
        V3BusinessControllers.getInstance().getUpdateStatus(this.mAccount, this.mMachineId, this.mTypeId, BathUtil.receivedResult(str.substring(20, 22), str.substring(4, 6), str.substring(6, 8)), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                boolean unused = NBOr4GCloseControlUtil.this.mIsEnable;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = NBOr4GCloseControlUtil.this.mIsEnable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil.4
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    NBOr4GCloseControlUtil.this.mActivity.finish();
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")");
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            this.mActivity.finish();
        }
    }

    private void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launchBluetoothFail(this.mActivity, this.mTitleContent, str, i);
        this.mActivity.finish();
    }
}
