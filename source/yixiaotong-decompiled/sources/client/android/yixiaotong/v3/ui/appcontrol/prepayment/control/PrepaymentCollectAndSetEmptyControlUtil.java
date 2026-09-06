package client.android.yixiaotong.v3.ui.appcontrol.prepayment.control;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
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
import client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.NoPayOrderActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class PrepaymentCollectAndSetEmptyControlUtil {
    private static final int COLLECTFAIL = 1;
    private static final int SETEMPTYFAIL = 2;
    private static final String TAG = "PrepaymentCollectAndSetEmptyControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private CollectAndSetEmptyControlListener mControlListener;
    private String mDeviceVer;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private String mMachineRand0;
    private String mMachineRand1;
    private String mRechargeType = "A5";
    private State mState;
    private String mStudentHex;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;

    private enum FlowState {
        none,
        collect,
        setempty
    }

    private enum State {
        f0,
        f08,
        f02,
        f06,
        f07,
        f01
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setListener(CollectAndSetEmptyControlListener collectAndSetEmptyControlListener) {
        this.mControlListener = collectAndSetEmptyControlListener;
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
        LogUtil.e(TAG, "init");
        if (this.mBluetoothDevice != null) {
            LogUtil.e(TAG, this.mBluetoothDevice.address + PPSLabelView.Code + this.mBluetoothDevice.name);
        }
        this.mFlowState = FlowState.none;
    }

    public void setDeviceInfo(String str, String str2) {
        this.mDeviceVer = str;
        this.mMachineId = str2;
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
        if (StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() >= 4) {
            if (DeviceControlUtil.isLiDeviceAndUnTransfereed(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3))) {
                LogUtil.i(TAG, "新设备1");
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

    private void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void startCollect() {
        this.mFlowState = FlowState.collect;
        this.mState = State.f0;
        connectDecice();
    }

    public void startSetEmpty() {
        this.mFlowState = FlowState.setempty;
        auth();
    }

    private void collectEnd() {
        LogUtil.e(TAG, "collectEnd:");
        this.mControlListener.onCollectEnd();
    }

    private void setEmptyEnd() {
        LogUtil.e(TAG, "setEmptyEnd:");
        disconnect();
        this.mControlListener.onSetEmpty();
    }

    private void sendf0() {
        LogUtil.i(TAG, "f0");
        String strSelectInfoCommand = NBDeviceCommand.selectInfoCommand();
        this.mState = State.f0;
        sendData(strSelectInfoCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf06(String str) {
        LogUtil.i(TAG, "06");
        String strOpenOnlineCommand = NBDeviceCommand.openOnlineCommand(str);
        if (DeviceControlUtil.isAuthTotalMoney(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3))) {
            LogUtil.i(TAG, BaseWrapper.ENTER_ID_OAPS_HEYTAPMULTIAPP);
            strOpenOnlineCommand = NBDeviceCommand.openOnlineCommand1(str);
        }
        this.mState = State.f06;
        sendData(strOpenOnlineCommand);
    }

    private void sendf06clear(String str) {
        LogUtil.i(TAG, "06");
        this.mState = State.f06;
        sendData(str);
    }

    private void sendf08() {
        LogUtil.i(TAG, "08");
        String randCommand = NBDeviceCommand.getRandCommand();
        this.mState = State.f08;
        sendData(randCommand);
    }

    private void sendf02(boolean z) {
        LogUtil.i(TAG, "02  " + z);
        String strCollectOrderCommand = NBDeviceCommand.collectOrderCommand(z, this.mStudentHex);
        this.mState = State.f02;
        sendData(strCollectOrderCommand);
    }

    private void sendf07(String str) {
        LogUtil.i(TAG, "07");
        String strSetMachineNoCommand = NBDeviceCommand.SetMachineNoCommand(str);
        this.mState = State.f07;
        sendData(strSetMachineNoCommand);
    }

    public void onReceivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str)) {
            LogUtil.e(TAG, "onReceivedData:  " + this.mState + "  " + this.mFlowState + "  " + str);
            this.mMachineRand1 = str.substring(4, 6);
            this.mMachineRand0 = str.substring(6, 8);
            if (this.mFlowState == FlowState.collect) {
                if (this.mState == State.f0) {
                    sendf08();
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.i(TAG, "studentid:" + this.mStudentHex);
                        sendf02(false);
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
                        collectEnd();
                        return;
                    }
                }
                if (this.mState != State.f06 || str.length() <= 24) {
                    return;
                }
                if (str.substring(22, 24).equals("00") || (str.substring(22, 24).equalsIgnoreCase("AA") && DeviceControlUtil.isNeedSetPValue(this.mDeviceVer))) {
                    sendf08();
                    return;
                } else {
                    ToastUtils.show(this.mActivity, "采集失败" + str.substring(22, 24));
                    onError(0, "采集失败");
                    return;
                }
            }
            if (this.mFlowState == FlowState.setempty && this.mState == State.f06 && str.length() > 24) {
                if (str.substring(22, 24).equals("00") || (str.substring(22, 24).equalsIgnoreCase("AA") && DeviceControlUtil.isNeedSetPValue(this.mDeviceVer))) {
                    setEmptyEnd();
                } else {
                    ToastUtils.show(this.mActivity, "清空水量失败" + str.substring(22, 24));
                    onError(0, "清空水量失败");
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
        BluetoothControlUtil.getInstance().sendData(str);
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
        nBOr4GDevice.posSystemTime = strSubstring2.toUpperCase();
        nBOr4GDevice.statusInfo = strReceivedResult;
        int i2 = this.mTypeId;
        if (i2 != 3 && i2 != 16) {
            i = 0;
        }
        nBOr4GDevice.handleType = i;
        if (DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1 && str.length() > 78) {
            nBOr4GDevice.signatureFile = StringUtils.hexStringToStr(str.substring(78));
        }
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, Integer.parseInt(str.substring(24, 26), 16), new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentCollectAndSetEmptyControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (PrepaymentCollectAndSetEmptyControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.i(PrepaymentCollectAndSetEmptyControlUtil.TAG, ifNull);
                    try {
                        CollectResultBean collectResultBean = (CollectResultBean) GsonUtils.getInstance().parse(new TypeToken<CollectResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentCollectAndSetEmptyControlUtil.1.1
                        }.getType(), ifNull);
                        String str2 = "02" + collectResultBean.systemData + collectResultBean.systemTime;
                        if (DeviceControlUtil.isNeedSetPValue(PrepaymentCollectAndSetEmptyControlUtil.this.mDeviceVer)) {
                            str2 = collectResultBean.systemType + collectResultBean.systemData + collectResultBean.systemTime;
                        }
                        PrepaymentCollectAndSetEmptyControlUtil.this.sendf06(str2);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentCollectAndSetEmptyControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(PrepaymentCollectAndSetEmptyControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        LogUtil.d(PrepaymentCollectAndSetEmptyControlUtil.TAG, ifNull);
                        NoPayOrderActivity.launch(PrepaymentCollectAndSetEmptyControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), PrepaymentCollectAndSetEmptyControlUtil.this.mTypeInfoBaseInfoBean);
                        PrepaymentCollectAndSetEmptyControlUtil.this.mActivity.finish();
                        return;
                    }
                    PrepaymentCollectAndSetEmptyControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void auth() {
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        machineInfoJson.machineData = "";
        machineInfoJson.machineRandom = this.mMachineRand;
        machineInfoJson.lastPosSerial = "0000";
        machineInfoJson.lastPosMoney = "0000";
        if (DeviceControlUtil.isNeedSetPValue(this.mDeviceVer)) {
            machineInfoJson.orderId = null;
            machineInfoJson.type = 1;
        }
        V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, 1, this.mTypeId, this.mDeviceVer, this.mMachineId, "", machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentCollectAndSetEmptyControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (PrepaymentCollectAndSetEmptyControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    LogUtil.d(PrepaymentCollectAndSetEmptyControlUtil.TAG, ifNull);
                    try {
                        PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentCollectAndSetEmptyControlUtil.2.1
                        }.getType(), ifNull);
                        String str = "";
                        if (DeviceControlUtil.isNeedSetPValue(PrepaymentCollectAndSetEmptyControlUtil.this.mDeviceVer)) {
                            str = postOpenAuthBean.systemType + postOpenAuthBean.systemData + postOpenAuthBean.systemTime;
                            if (StringUtils.isNotEmpty(postOpenAuthBean.agreementNoHex) && PrepaymentCollectAndSetEmptyControlUtil.this.isZFBSDK()) {
                                str = postOpenAuthBean.systemType + postOpenAuthBean.systemData + postOpenAuthBean.systemTime + postOpenAuthBean.agreementNoHex;
                            }
                        }
                        PrepaymentCollectAndSetEmptyControlUtil.this.sendf06(str);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (PrepaymentCollectAndSetEmptyControlUtil.this.mIsEnable) {
                    PrepaymentCollectAndSetEmptyControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void onError(int i, String str) {
        disconnect();
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mControlListener != null) {
            if (this.mFlowState == FlowState.setempty) {
                this.mControlListener.onFail(2);
            } else {
                this.mControlListener.onFail(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        disconnect();
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.prepayment.control.PrepaymentCollectAndSetEmptyControlUtil.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")");
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private void showDialog(String str) {
        disconnect();
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mControlListener != null) {
            if (this.mFlowState == FlowState.setempty) {
                this.mControlListener.onFail(2);
            } else {
                this.mControlListener.onFail(1);
            }
        }
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isZFBSDK() {
        return StringUtils.isNotEmpty(this.mDeviceVer) && this.mDeviceVer.length() > 3 && DeviceControlUtil.sdkTypeForLi(this.mDeviceVer.substring(0, 2), this.mDeviceVer.substring(3)) == 1;
    }
}
