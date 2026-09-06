package client.android.yixiaotong.v4.ui.app.electricitymeter;

import android.app.Activity;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.NBDeviceCommand;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V44GOpenStatus;
import client.android.yixiaotong.v4.http.bean.V4BLEOpenBean;
import client.android.yixiaotong.v4.util.comman.V4DeviceCommand;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.google.android.exoplayer2.C;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4DeviceRechargeControlUtil {
    private static final String TAG = "V4PaySuccessControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private int mCount = 0;
    private FlowState mFlowState;
    private boolean mIsEnable;
    private String mMachineId;
    private String mMachineRand;
    private OnListener mOnListener;
    private int mProductId;
    private State mState;
    private String mStudentHex;
    private String mSysRandom;
    private String mTitleContent;

    private enum FlowState {
        openingtoble,
        openingtonbor4g,
        opened,
        collet,
        set
    }

    public interface OnListener {
        void onChargeSuccess();
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

    static /* synthetic */ int access$708(V4DeviceRechargeControlUtil v4DeviceRechargeControlUtil) {
        int i = v4DeviceRechargeControlUtil.mCount;
        v4DeviceRechargeControlUtil.mCount = i + 1;
        return i;
    }

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, int i, String str, String str2, OnListener onListener) {
        this.mAccount = account;
        this.mActivity = activity;
        this.mProductId = i;
        this.mStudentHex = V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId;
        this.mBluetoothDevice = bluetoothDevice;
        this.mMachineId = str;
        this.mFlowState = FlowState.openingtoble;
        this.mSysRandom = str2;
        this.mOnListener = onListener;
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.1
            @Override // java.lang.Runnable
            public void run() {
                V4DeviceRechargeControlUtil.this.getStatus();
            }
        }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
        NBDeviceCommand.setTransferredMeaning(false);
        initBluetooth();
    }

    public void onResume() {
        this.mIsEnable = true;
        BluetoothControlUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        BluetoothControlUtil.getInstance().onPause();
    }

    private void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    public void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void openStart() {
        LogUtil.log("--------开始执行开阀流程----------");
        connectDecice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf0() {
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
        this.mState = State.f06;
        sendData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf08() {
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

    private void sendData(String str) {
        V4DeviceCommand.setIs02Cmd(V4DeviceCommand.is02Command(str));
        BluetoothControlUtil.getInstance().setSendTimeOut(5000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receivedData(String str) {
        if (this.mIsEnable && StringUtils.isNotEmpty(str)) {
            if (this.mFlowState == FlowState.openingtoble) {
                if (this.mState == State.f0) {
                    if (str.substring(22, 38).equals(this.mMachineId)) {
                        sendf08();
                        return;
                    }
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.e(TAG, "studentid:" + this.mStudentHex);
                        authForBLE(this.mMachineRand);
                        return;
                    }
                    return;
                }
                if (this.mState != State.f06 || str.length() <= 24) {
                    return;
                }
                if (str.substring(22, 24).equals("00")) {
                    OnListener onListener = this.mOnListener;
                    if (onListener != null) {
                        onListener.onChargeSuccess();
                    }
                    this.mFlowState = FlowState.collet;
                    sendf0();
                    return;
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                disconnect();
                return;
            }
            if (this.mFlowState == FlowState.collet) {
                if (this.mState == State.f0) {
                    updateF0(str);
                    return;
                }
                if (this.mState == State.f08) {
                    if (str.length() > 30) {
                        this.mMachineRand = str.substring(22, 30);
                        LogUtil.e(TAG, "studentid:" + this.mStudentHex);
                        sendf02collect();
                        return;
                    }
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
                if (this.mState != State.f06 || str.length() <= 24) {
                    return;
                }
                if (str.substring(22, 24).equals("00")) {
                    sendf08();
                } else {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    disconnect();
                }
            }
        }
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().init(this.mActivity);
        BluetoothControlUtil.getInstance().setDeviceType(BluetoothControlUtil.DeviceType.nbdevice);
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.2
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.e(V4DeviceRechargeControlUtil.TAG, "onConnected:");
                V4DeviceRechargeControlUtil.this.sendf0();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.e(V4DeviceRechargeControlUtil.TAG, "onFail" + i + "  " + str + "  ");
                if (!str.equalsIgnoreCase("Discover")) {
                    str.equalsIgnoreCase("Connect");
                }
                V4DeviceRechargeControlUtil.this.disconnect();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(final String str) {
                super.onReceivedData(str);
                LogUtil.e(V4DeviceRechargeControlUtil.TAG, "onReceivedData:" + str);
                MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        V4DeviceRechargeControlUtil.this.receivedData(str);
                    }
                });
            }
        });
    }

    private void authForBLE(String str) {
        V4BusinessControllers.getInstance().btRecharge(this.mAccount, str, this.mMachineId, new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str2, Object... objArr) {
                if (V4DeviceRechargeControlUtil.this.mIsEnable && StringUtils.isNotEmpty(str2)) {
                    V4DeviceRechargeControlUtil.this.sendf06(str2);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = V4DeviceRechargeControlUtil.this.mIsEnable;
            }
        });
    }

    private void updateF0(String str) {
        V4BusinessControllers.getInstance().updateF0(this.mAccount, str, this.mMachineId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (V4DeviceRechargeControlUtil.this.mIsEnable) {
                    V4DeviceRechargeControlUtil.this.sendf08();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = V4DeviceRechargeControlUtil.this.mIsEnable;
            }
        });
    }

    private void collectForBLE(String str, String str2) {
        V4BusinessControllers.getInstance().postBLEClollect(this.mAccount, this.mMachineId, str, str2, new Listener<V4BLEOpenBean>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4BLEOpenBean v4BLEOpenBean, Object... objArr) {
                if (V4DeviceRechargeControlUtil.this.mIsEnable && StringUtils.isNotEmpty(v4BLEOpenBean.data)) {
                    V4DeviceRechargeControlUtil.this.sendf06(v4BLEOpenBean.data);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = V4DeviceRechargeControlUtil.this.mIsEnable;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getStatus() {
        if (StringUtils.isEmpty(this.mSysRandom)) {
            return;
        }
        V4BusinessControllers.getInstance().get4GOpenStatus(this.mAccount, this.mMachineId, this.mSysRandom, new Listener<V44GOpenStatus>() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V44GOpenStatus v44GOpenStatus, Object... objArr) {
                if (V4DeviceRechargeControlUtil.this.mIsEnable) {
                    if (v44GOpenStatus == null || !StringUtils.isNotEmpty(v44GOpenStatus.status) || (!v44GOpenStatus.status.equals("00") && !v44GOpenStatus.status.equals("03"))) {
                        if (V4DeviceRechargeControlUtil.this.mCount == 0) {
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.v4.ui.app.electricitymeter.V4DeviceRechargeControlUtil.6.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    V4DeviceRechargeControlUtil.this.getStatus();
                                }
                            }, C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS);
                        }
                        V4DeviceRechargeControlUtil.access$708(V4DeviceRechargeControlUtil.this);
                    } else if (V4DeviceRechargeControlUtil.this.mOnListener != null) {
                        V4DeviceRechargeControlUtil.this.mOnListener.onChargeSuccess();
                    }
                }
            }
        });
    }
}
