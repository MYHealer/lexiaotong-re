package client.android.yixiaotong.v4.ui.app.electricitymeter.refund;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.DeviceControlUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CollectAndSetEmptyControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4BLEOpenBean;
import client.android.yixiaotong.v4.util.comman.V4DeviceInfoUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4CollectAndSetEmptyControlUtil {
    private static final int COLLECTFAIL = 1;
    private static final int SETEMPTYFAIL = 2;
    private static final String TAG = "V4CollectAndSetEmptyControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private CollectAndSetEmptyControlListener mControlListener;
    private String mDeviceVer;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private State mState;
    private String mStudentHex;
    private String mTitleContent;

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

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, String str, String str2, String str3) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mBluetoothDevice = bluetoothDevice;
        this.mStudentHex = str;
        this.mTitleContent = str2;
        LogUtil.e(TAG, "init");
        if (this.mBluetoothDevice != null) {
            LogUtil.e(TAG, this.mBluetoothDevice.address + PPSLabelView.Code + this.mBluetoothDevice.name);
        }
        this.mFlowState = FlowState.none;
        this.mMachineId = str3;
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
        NBDeviceCommand.setTransferredMeaning(false);
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
        sendf08();
    }

    public void startSetEmpty() {
        this.mFlowState = FlowState.setempty;
        this.mState = State.f0;
        connectDecice();
    }

    private void collectEnd() {
        LogUtil.e(TAG, "collectEnd:");
        disconnect();
        this.mControlListener.onCollectEnd();
    }

    private void setEmptyEnd() {
        LogUtil.e(TAG, "setEmptyEnd:");
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
        this.mState = State.f06;
        sendData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf08() {
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

    public void onReceivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str)) {
            LogUtil.e(TAG, "onReceivedData:  " + this.mState + "  " + this.mFlowState + "  " + str);
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
                        collectForBLE(this.mMachineRand, str);
                        return;
                    } else if (V4DeviceInfoUtil.isHasOrder(str)) {
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4CollectAndSetEmptyControlUtil.1
                            @Override // java.lang.Runnable
                            public void run() {
                                V4CollectAndSetEmptyControlUtil.this.sendf08();
                            }
                        }, 1000L);
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
            if (this.mFlowState == FlowState.setempty) {
                if (this.mState == State.f0) {
                    sendf08();
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.i(TAG, "studentid:" + this.mStudentHex);
                        btReturnToZeroKwh(this.mMachineRand);
                        return;
                    }
                    onError(0, "设备通讯数据异常");
                    return;
                }
                if (this.mState != State.f06 || str.length() <= 24) {
                    return;
                }
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
        BluetoothControlUtil.getInstance().setSendTimeOut(5000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    private void collectForBLE(String str, String str2) {
        V4BusinessControllers.getInstance().postBLEClollect(this.mAccount, this.mMachineId, str, str2, new Listener<V4BLEOpenBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4CollectAndSetEmptyControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BLEOpenBean v4BLEOpenBean, Object... objArr) {
                if (V4CollectAndSetEmptyControlUtil.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(v4BLEOpenBean.data)) {
                        V4CollectAndSetEmptyControlUtil.this.sendf06(v4BLEOpenBean.data);
                    } else {
                        V4CollectAndSetEmptyControlUtil.this.onError(0, "蓝牙采集失败!");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4CollectAndSetEmptyControlUtil.this.mIsEnable) {
                    V4CollectAndSetEmptyControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void btReturnToZeroKwh(String str) {
        V4BusinessControllers.getInstance().btReturnToZeroKwh(this.mAccount, str, this.mMachineId, new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4CollectAndSetEmptyControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str2, Object... objArr) {
                if (V4CollectAndSetEmptyControlUtil.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(str2)) {
                        V4CollectAndSetEmptyControlUtil.this.sendf06(str2);
                    } else {
                        V4CollectAndSetEmptyControlUtil.this.onError(0, "蓝牙授权失败!");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4CollectAndSetEmptyControlUtil.this.mIsEnable) {
                    V4CollectAndSetEmptyControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
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
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.refund.V4CollectAndSetEmptyControlUtil.4
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
}
