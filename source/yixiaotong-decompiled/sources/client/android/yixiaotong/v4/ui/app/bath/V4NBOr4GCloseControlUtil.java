package client.android.yixiaotong.v4.ui.app.bath;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.DeviceInfoUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4BLEOpenBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.comman.V4DeviceCommand;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4NBOr4GCloseControlUtil {
    private static final String TAG = "V4NBOr4GCloseControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private CloseControlListener mControlListener;
    private String mF0Data;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private State mState;
    private String mStudentHex;
    private String mTitleContent;
    private boolean mIsClose = false;
    private boolean mIsOffineOpen = false;

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

    public void setCloseDevice() {
        this.mIsClose = true;
    }

    public void setDeviceInfo(String str) {
        this.mMachineId = str;
    }

    public void setListener(CloseControlListener closeControlListener) {
        this.mControlListener = closeControlListener;
    }

    public void setOpenWay(int i) {
        if (i == 0) {
            this.mIsOffineOpen = true;
        } else {
            this.mIsOffineOpen = false;
        }
    }

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, int i, String str) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mBluetoothDevice = bluetoothDevice;
        this.mTitleContent = str;
        this.mIsClose = false;
        this.mIsOffineOpen = false;
        this.mStudentHex = V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId;
    }

    public void onResume() {
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
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
        this.mState = State.f06;
        sendData(str);
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
                    this.mMachineId = DeviceInfoUtil.getInstance().getSN(this.mF0Data);
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
                    if (this.mIsOffineOpen || this.mIsClose) {
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
                        LogUtil.e(TAG, "studentid:" + this.mStudentHex);
                        sendf02(true);
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState == State.f02) {
                    if (str.length() >= 72 && (str.substring(22, 24).equals("00") || str.substring(22, 24).equals("01"))) {
                        collectForBLE(this.mMachineRand, str);
                        return;
                    } else {
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
                            collectForBLE(this.mMachineRand, str);
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
        V4DeviceCommand.setIs02Cmd(V4DeviceCommand.is02Command(str));
        BluetoothControlUtil.getInstance().setSendTimeOut(5000);
        BluetoothControlUtil.getInstance().sendDataInNeedSend(str);
    }

    private void collectForBLE(String str, String str2) {
        V4BusinessControllers.getInstance().postBLEClollect(this.mAccount, this.mMachineId, str, str2, new Listener<V4BLEOpenBean>() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GCloseControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BLEOpenBean v4BLEOpenBean, Object... objArr) {
                if (V4NBOr4GCloseControlUtil.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(v4BLEOpenBean.data)) {
                        V4NBOr4GCloseControlUtil.this.sendf06(v4BLEOpenBean.data);
                    } else {
                        V4NBOr4GCloseControlUtil.this.onError(0, "蓝牙采集失败!");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4NBOr4GCloseControlUtil.this.mIsEnable) {
                    V4NBOr4GCloseControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, this.mActivity, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4NBOr4GCloseControlUtil.2
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public void onConfirm() {
                V4NBOr4GCloseControlUtil.this.mActivity.finish();
            }
        }, str);
    }
}
