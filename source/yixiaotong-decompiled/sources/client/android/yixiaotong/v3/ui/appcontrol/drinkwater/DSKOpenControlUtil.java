package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

import android.app.Activity;
import android.util.Log;
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
import client.android.yixiaotong.v3.comman.DSKCommand;
import client.android.yixiaotong.v3.comman.DSKReceivedDataUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.NoPayOrderActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.C;
import com.google.gson.reflect.TypeToken;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DSKOpenControlUtil {
    private static final String TAG = "DSKOpenControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private int mCode;
    private String mCommunicationVal;
    private OpenControlListener mControlListener;
    private String mDeviceVer;
    private String mF0Data;
    private FlowState mFlowState;
    private int mHandleType;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachinePwdVer;
    private String mMsg;
    private State mState;
    private String mStudentHex;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mPreferredCommunicationType = 0;
    private int mCnFlag = 0;
    private int mCount = 0;
    private String mParFlag = "";
    private String mSetData = "";

    private enum FlowState {
        openingtoble,
        openingtonbor4g,
        opened,
        collet,
        set
    }

    private enum State {
        f0,
        f16,
        f12,
        f13,
        f11
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
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setListener(OpenControlListener openControlListener) {
        this.mControlListener = openControlListener;
    }

    static /* synthetic */ int access$708(DSKOpenControlUtil dSKOpenControlUtil) {
        int i = dSKOpenControlUtil.mCount;
        dSKOpenControlUtil.mCount = i + 1;
        return i;
    }

    public void setDeviceInfo(int i, int i2, int i3, String str, String str2) {
        this.mPreferredCommunicationType = i;
        this.mCnFlag = i3;
        this.mDeviceVer = str;
        this.mMachineId = str2;
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.dskdevice);
    }

    public void connected() {
        sendf0();
    }

    public void onBluetoothError(int i, String str) {
        this.mMsg = str;
        this.mCode = i;
        if (this.mPreferredCommunicationType == 0 && this.mFlowState == FlowState.openingtoble) {
            auth(false);
        } else {
            if (this.mPreferredCommunicationType == 0 || this.mFlowState != FlowState.openingtoble) {
                return;
            }
            onError(i, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectDecice() {
        this.mFlowState = FlowState.openingtoble;
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void openStart() {
        this.mState = State.f0;
        this.mCommunicationVal = "";
        this.mMsg = "";
        if (this.mPreferredCommunicationType == 1) {
            Log.e(TAG, "先NB或4G" + this.mPreferredCommunicationType);
            auth(false);
        } else {
            Log.e(TAG, "先蓝牙" + this.mPreferredCommunicationType);
            connectDecice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openEnd(boolean z) {
        this.mFlowState = FlowState.opened;
        this.mControlListener.onOpenEnd();
        postMachineRunInfo();
        if (z) {
            Log.e(TAG, "蓝牙开阀");
            this.mFlowState = FlowState.collet;
            sendf12(false);
        }
    }

    private void openFail() {
        this.mControlListener.onOpenFail();
    }

    private void sendf0() {
        Log.e("test", "f0");
        DSKReceivedDataUtil.setIsF0(true);
        String strSelectInfoCommand = NBDeviceCommand.selectInfoCommand();
        this.mState = State.f0;
        sendData(strSelectInfoCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf13(String str) {
        Log.e("test", BaseWrapper.ENTER_ID_GAME_CENTER);
        this.mState = State.f13;
        sendData(str);
    }

    private void sendf12(boolean z) {
        String collectData;
        Log.e("test", "12  " + z);
        if (z) {
            collectData = DSKCommand.getCollectData(this.mMachineId.substring(0, 4), this.mStudentHex);
        } else {
            collectData = DSKCommand.getCollectData(this.mMachineId.substring(0, 4), "0");
        }
        this.mState = State.f12;
        sendData(collectData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf16(String str) {
        Log.e("test", "16");
        this.mState = State.f16;
        sendData(str);
    }

    private void sendf11(String str) {
        Log.e("test", "11");
        String strSetMachineNoCommand = NBDeviceCommand.SetMachineNoCommand(str);
        this.mState = State.f11;
        sendData(strSetMachineNoCommand);
    }

    public void onReceivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str) && str.length() >= 54) {
            Log.e(TAG, "onReceivedData:" + this.mFlowState + "  " + this.mState);
            if (this.mFlowState == FlowState.openingtonbor4g || this.mFlowState == FlowState.openingtoble) {
                if (str.substring(18, 20).equalsIgnoreCase("EE")) {
                    onErrorForEE(str.substring(44, 46));
                    return;
                }
                if (this.mState == State.f0) {
                    this.mMachinePwdVer = str.substring(66, 70);
                    this.mF0Data = str;
                    Log.e("test", "studentid:" + this.mStudentHex);
                    sendf12(true);
                    return;
                }
                if (this.mState == State.f12) {
                    if (str.substring(18, 20).equals("12")) {
                        auth(true);
                        return;
                    } else if (str.substring(18, 20).equals("16") || str.substring(18, 20).equals("26")) {
                        uploadOrder(str);
                        return;
                    } else {
                        onError(0, "消费记录返回失败");
                        return;
                    }
                }
                if (this.mState == State.f16) {
                    if (str.substring(18, 20).equals("12")) {
                        auth(true);
                        return;
                    } else if (str.substring(18, 20).equals("16") || str.substring(18, 20).equals("26")) {
                        uploadOrder(str);
                        return;
                    } else {
                        onError(0, "消费记录返回失败");
                        return;
                    }
                }
                if (this.mState == State.f13) {
                    if (str.substring(18, 20).equals(BaseWrapper.ENTER_ID_GAME_CENTER)) {
                        openEnd(true);
                        return;
                    } else {
                        onError(0, "消费记录返回失败.");
                        return;
                    }
                }
                return;
            }
            if (this.mFlowState == FlowState.collet) {
                if (this.mState == State.f12) {
                    if (str.substring(18, 20).equals("12")) {
                        uploadDeviceInfo();
                        return;
                    } else {
                        if (str.substring(18, 20).equals("16") || str.substring(18, 20).equals("26")) {
                            uploadOrder(str);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.mFlowState == FlowState.set) {
                if (this.mState == State.f0) {
                    sendf11(this.mSetData);
                } else if (str.substring(18, 20).equals("11")) {
                    disconnect();
                    uploadDeviceInfoResult();
                }
            }
        }
    }

    private void sendData(String str) {
        if (this.mState != State.f0) {
            DSKReceivedDataUtil.setIsF0(false);
        }
        BluetoothControlUtil.getInstance().setSendTimeOut(3000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    private void uploadOrder(String str) {
        NBOr4GDevice nBOr4GDevice = new NBOr4GDevice();
        nBOr4GDevice.machineData = str;
        nBOr4GDevice.machinePwdVer = this.mMachinePwdVer;
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, 0, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (DSKOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    Log.e("text", ifNull);
                    try {
                        DSKOpenControlUtil.this.sendf16(((CollectResultBean) GsonUtils.getInstance().parse(new TypeToken<CollectResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.1.1
                        }.getType(), ifNull)).sendMachineData);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DSKOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(DSKOpenControlUtil.this.mActivity, clientException.getDetail());
                        NoPayOrderActivity.launch(DSKOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(GsonUtils.getInstance().parseIfNull(clientException.getObject()), NoPayOrderBean.class), DSKOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        DSKOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    DSKOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void auth(final boolean z) {
        int i;
        int i2;
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        if (z) {
            machineInfoJson.machinePwdVer = this.mMachinePwdVer;
        } else {
            this.mFlowState = FlowState.openingtonbor4g;
            int i3 = this.mCnFlag;
            if (i3 == 0) {
                machineInfoJson.machinePwdVer = "0000";
                i2 = 2;
                i = i2;
            } else {
                i = 4;
                if (i3 == 4) {
                    machineInfoJson.machinePwdVer = "0000";
                }
            }
            V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i, this.mTypeId, this.mDeviceVer, this.mMachineId, "", machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.2
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, Object obj, Object... objArr) {
                    if (DSKOpenControlUtil.this.mIsEnable) {
                        String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                        Log.e(DSKOpenControlUtil.TAG, ifNull);
                        try {
                            PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.2.1
                            }.getType(), ifNull);
                            DSKOpenControlUtil.this.mCommunicationVal = postOpenAuthBean.communicationVal;
                            if (z) {
                                DSKOpenControlUtil.this.sendf13(postOpenAuthBean.sendMachineData);
                            } else {
                                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.2.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        DSKOpenControlUtil.this.mCount = 0;
                                        DSKOpenControlUtil.this.getStatus();
                                    }
                                }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                            }
                        } catch (ClientException e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (DSKOpenControlUtil.this.mIsEnable) {
                        if (clientException.getCode() == -52) {
                            ToastUtils.show(DSKOpenControlUtil.this.mActivity, clientException.getDetail());
                            NoPayOrderActivity.launch(DSKOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(GsonUtils.getInstance().parseIfNull(clientException.getObject()), NoPayOrderBean.class), DSKOpenControlUtil.this.mTypeInfoBaseInfoBean);
                            DSKOpenControlUtil.this.mActivity.finish();
                            return;
                        }
                        DSKOpenControlUtil.this.onError(clientException);
                    }
                }
            });
        }
        i2 = 1;
        i = i2;
        V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, i, this.mTypeId, this.mDeviceVer, this.mMachineId, "", machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (DSKOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    Log.e(DSKOpenControlUtil.TAG, ifNull);
                    try {
                        PostOpenAuthBean postOpenAuthBean = (PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.2.1
                        }.getType(), ifNull);
                        DSKOpenControlUtil.this.mCommunicationVal = postOpenAuthBean.communicationVal;
                        if (z) {
                            DSKOpenControlUtil.this.sendf13(postOpenAuthBean.sendMachineData);
                        } else {
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    DSKOpenControlUtil.this.mCount = 0;
                                    DSKOpenControlUtil.this.getStatus();
                                }
                            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                        }
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DSKOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(DSKOpenControlUtil.this.mActivity, clientException.getDetail());
                        NoPayOrderActivity.launch(DSKOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(GsonUtils.getInstance().parseIfNull(clientException.getObject()), NoPayOrderBean.class), DSKOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        DSKOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    DSKOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStatus() {
        if (this.mFlowState == FlowState.opened || StringUtils.isEmpty(this.mCommunicationVal)) {
            return;
        }
        V3BusinessControllers.getInstance().getNBOr4GStatus(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, 1, this.mCommunicationVal, new Listener<NBOr4GStatuBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, NBOr4GStatuBean nBOr4GStatuBean, Object... objArr) {
                if (!DSKOpenControlUtil.this.mIsEnable || nBOr4GStatuBean == null) {
                    return;
                }
                if (nBOr4GStatuBean.status == 0) {
                    DSKOpenControlUtil.this.openEnd(false);
                    return;
                }
                if (DSKOpenControlUtil.this.mCount != 0) {
                    if (DSKOpenControlUtil.this.mPreferredCommunicationType == 0) {
                        DSKOpenControlUtil dSKOpenControlUtil = DSKOpenControlUtil.this;
                        dSKOpenControlUtil.onError(dSKOpenControlUtil.mCode, DSKOpenControlUtil.this.mMsg);
                    }
                } else {
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DSKOpenControlUtil.this.getStatus();
                        }
                    }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                    if (DSKOpenControlUtil.this.mPreferredCommunicationType != 0) {
                        DSKOpenControlUtil.this.connectDecice();
                    }
                }
                DSKOpenControlUtil.access$708(DSKOpenControlUtil.this);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DSKOpenControlUtil.this.mIsEnable) {
                    DSKOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void postMachineRunInfo() {
        MachineStatusData machineStatusData = new MachineStatusData();
        if (!StringUtils.isNotEmpty(this.mF0Data) || this.mF0Data.length() <= 70) {
            return;
        }
        machineStatusData.runStatus = BathUtil.receivedResult(this.mF0Data.substring(20, 22), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        machineStatusData.runPar = this.mF0Data.substring(22, 70);
        V3BusinessControllers.getInstance().postMachineRunInfo(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, machineStatusData, new Listener<BluetoothSetBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BluetoothSetBean bluetoothSetBean, Object... objArr) {
                boolean unused = DSKOpenControlUtil.this.mIsEnable;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = DSKOpenControlUtil.this.mIsEnable;
            }
        });
    }

    private void uploadDeviceInfoResult() {
        if (StringUtils.isNotEmpty(this.mParFlag)) {
            V3BusinessControllers.getInstance().postBluetoothSetDataResult(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mParFlag, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.5
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                }
            });
        }
    }

    private void uploadDeviceInfo() {
        V3BusinessControllers.getInstance().postBluetoothSetData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, new SetData(), new Listener<BluetoothSetBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BluetoothSetBean bluetoothSetBean, Object... objArr) {
                if (DSKOpenControlUtil.this.mIsEnable) {
                    DSKOpenControlUtil.this.disconnect();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DSKOpenControlUtil.this.mIsEnable) {
                    DSKOpenControlUtil.this.disconnect();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launchBluetoothFailForOpen(this.mActivity, this.mTitleContent, str, i);
        this.mActivity.finish();
    }

    private void onErrorForEE(String str) {
        String str2;
        int i = Integer.parseInt(str, 16);
        if (i == 1) {
            str2 = "帧头错";
        } else if (i == 2) {
            str2 = "客户代号错";
        } else if (i == 3) {
            str2 = "SN与本机不符合";
        } else if (i == 4) {
            str2 = "控制字错";
        } else if (i == 5) {
            str2 = "校验不通过";
        } else if (i == 6) {
            str2 = "解密错";
        } else if (i == 7) {
            str2 = "执行条件不符";
        } else if (i == 8) {
            str2 = "他人占用设备";
        } else if (i == 9) {
            str2 = "铁电错误";
        } else {
            str2 = i == 10 ? "电机错误" : "蓝牙通讯异常";
        }
        onError(i, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (this.mFlowState == FlowState.openingtonbor4g || this.mFlowState == FlowState.openingtoble) {
            if (clientException.isNeedTip(clientException.getCode())) {
                openFail();
                SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.7
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        DSKOpenControlUtil.this.mActivity.finish();
                    }
                }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")");
                return;
            }
            if (clientException.getCode() == -50 && this.mCnFlag != 1) {
                if (this.mPreferredCommunicationType == 0 && this.mFlowState == FlowState.openingtoble) {
                    auth(false);
                    return;
                } else if (this.mPreferredCommunicationType != 0 && this.mFlowState == FlowState.openingtonbor4g) {
                    connectDecice();
                    return;
                } else {
                    V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 4, clientException.getSerial());
                    this.mActivity.finish();
                    return;
                }
            }
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 4, clientException.getSerial());
            this.mActivity.finish();
        }
    }

    private void showDialog(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    private void showDialogNeedExit(String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKOpenControlUtil.8
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                DSKOpenControlUtil.this.mActivity.finish();
            }
        }, str);
    }
}
