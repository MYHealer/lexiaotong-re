package client.android.yixiaotong.v3.ui.appcontrol.drinkwater;

import android.app.Activity;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
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
import client.android.yixiaotong.v3.comman.DSKCommand;
import client.android.yixiaotong.v3.comman.DSKReceivedDataUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.NoPayOrderActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.gson.reflect.TypeToken;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DSKCloseControlUtil {
    private static final String TAG = "DSKCloseControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private int mCnFlag = 0;
    private CloseControlListener mControlListener;
    private String mDeviceVer;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachinePwdVer;
    private State mState;
    private String mStudentHex;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;

    private enum FlowState {
        closeing,
        collect,
        closed
    }

    private enum State {
        f0,
        f14,
        f12,
        f16
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
        this.mState = State.f0;
        this.mFlowState = FlowState.closeing;
        connectDecice();
    }

    public void closeEnd() {
        this.mFlowState = FlowState.closed;
        this.mControlListener.onCloseEnd();
    }

    private void sendf0() {
        DSKReceivedDataUtil.setIsF0(true);
        String strSelectInfoCommand = NBDeviceCommand.selectInfoCommand();
        this.mState = State.f0;
        sendData(strSelectInfoCommand);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf14(String str) {
        Log.e("test", BaseWrapper.ENTER_ID_AD_SDK);
        this.mState = State.f14;
        sendData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf16(String str) {
        Log.e("test", "16");
        this.mState = State.f16;
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

    public void onReceivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str)) {
            Log.e(TAG, "onReceivedData:" + this.mFlowState);
            if (this.mFlowState == FlowState.closeing) {
                if (str.substring(18, 20).equalsIgnoreCase("EE")) {
                    onErrorForEE(str.substring(44, 46));
                    return;
                }
                if (this.mState == State.f0) {
                    this.mMachinePwdVer = str.substring(66, 70);
                    auth();
                    return;
                }
                if (this.mState == State.f14) {
                    sendf12(true);
                    return;
                }
                if (this.mState == State.f12) {
                    if (str.substring(18, 20).equalsIgnoreCase("12")) {
                        closeEnd();
                        return;
                    } else {
                        uploadOrder(str);
                        return;
                    }
                }
                if (this.mState == State.f16) {
                    if (str.substring(18, 20).equalsIgnoreCase("12")) {
                        closeEnd();
                    } else {
                        uploadOrder(str);
                    }
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
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, 0, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKCloseControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (DSKCloseControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    Log.e("text", ifNull);
                    try {
                        DSKCloseControlUtil.this.sendf16(((CollectResultBean) GsonUtils.getInstance().parse(new TypeToken<CollectResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKCloseControlUtil.1.1
                        }.getType(), ifNull)).sendMachineData);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DSKCloseControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(DSKCloseControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        Log.e("test", ifNull);
                        NoPayOrderActivity.launch(DSKCloseControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), DSKCloseControlUtil.this.mTypeInfoBaseInfoBean);
                        DSKCloseControlUtil.this.mActivity.finish();
                        return;
                    }
                    DSKCloseControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void auth() {
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        machineInfoJson.machinePwdVer = this.mMachinePwdVer;
        V3BusinessControllers.getInstance().postCloseAuth(this.mAccount, 1, this.mTypeId, this.mDeviceVer, this.mMachineId, machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKCloseControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (DSKCloseControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    Log.e(DSKCloseControlUtil.TAG, ifNull);
                    try {
                        DSKCloseControlUtil.this.sendf14(((PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKCloseControlUtil.2.1
                        }.getType(), ifNull)).sendMachineData);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DSKCloseControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(DSKCloseControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        Log.e("test", ifNull);
                        NoPayOrderActivity.launch(DSKCloseControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), DSKCloseControlUtil.this.mTypeInfoBaseInfoBean);
                        DSKCloseControlUtil.this.mActivity.finish();
                        return;
                    }
                    DSKCloseControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.drinkwater.DSKCloseControlUtil.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DSKCloseControlUtil.this.mActivity.finish();
                }
            }, clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")");
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            this.mActivity.finish();
        }
    }

    private void onErrorForEE(String str) {
        String str2;
        BaseMaterialDialog.dissmisMaterialDialog();
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
            str2 = "–执行条件不符";
        } else if (i == 8) {
            str2 = "他人占用设备";
        } else if (i == 9) {
            str2 = "铁电错误";
        } else {
            str2 = i == 10 ? "电机错误" : "蓝牙通讯异常";
        }
        V3ErrorTipActivity.launchBluetoothFail(this.mActivity, this.mTitleContent, str2, i);
        this.mActivity.finish();
    }
}
