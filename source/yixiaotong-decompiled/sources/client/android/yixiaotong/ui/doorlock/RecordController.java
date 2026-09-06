package client.android.yixiaotong.ui.doorlock;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.util.TimeOut;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.doorlock.DLHACBean;
import client.android.yixiaotong.controller.bean.doorlock.RecordBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.DoorLockRecordEvent;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.doorlock.DoorLockCommandUtil;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.gson.Gson;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class RecordController {
    public static final int RESULTCODE = 2000;
    private String EAC;
    private String HAC;
    private String R1;
    private String R2;
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private String mDeviceUserID;
    private boolean mIsEnable;
    private String mMachineId;
    private State mState;
    private int mTypeID;
    private String mUserID;

    public enum State {
        none,
        connectfail,
        connected,
        sending,
        end
    }

    private RecordController() {
        this.mState = State.none;
        this.mMachineId = "";
        this.R1 = "";
        this.R2 = "";
        this.mDeviceUserID = "";
        this.EAC = "";
        this.HAC = "";
        this.mTypeID = 10;
    }

    private static final class SingleHolder {
        private static final RecordController INSTANCE = new RecordController();

        private SingleHolder() {
        }
    }

    public static RecordController getInstance() {
        return SingleHolder.INSTANCE;
    }

    public void init(Account account, Activity activity, BluetoothDevice bluetoothDevice) {
        this.mAccount = account;
        this.mActivity = activity;
        this.mBluetoothDevice = bluetoothDevice;
        this.mUserID = account.getAccountManagetStore().getUserInfo().stId;
        initBluetooth();
    }

    public void onResume() {
        this.mIsEnable = true;
        BluetoothConnectUtil.getInstance().onResume();
    }

    public void onPause() {
        this.mIsEnable = false;
        BluetoothConnectUtil.getInstance().onPause();
    }

    private void initBluetooth() {
        BluetoothConnectUtil.getInstance().init(this.mActivity);
        BluetoothConnectUtil.getInstance().setListener(new BluetoothConnectUtil.Listener() { // from class: client.android.yixiaotong.ui.doorlock.RecordController.1
            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
                if (RecordController.this.mIsEnable) {
                    Log.e("test", timeOut + "  " + str);
                    RecordController.this.mState = State.connectfail;
                    BaseMaterialDialog.dissmisMaterialDialog();
                    RecordController.this.showDialog("连接设备失败，请保持触亮门锁的感应区再试");
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onConnected(BluetoothDevice bluetoothDevice) {
                if (RecordController.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    RecordController.this.mState = State.connected;
                    RecordController.this.startGetRecord();
                }
            }

            @Override // client.android.yixiaotong.ui.bluetoothutil.BluetoothConnectUtil.Listener
            public void onReceivedData(String str) {
                if (RecordController.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(str) && DoorLockCommandUtil.isCheckData(str)) {
                        RecordController.this.onReceivedDataResult(str);
                    } else {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        RecordController.this.showDialog("设备数据格式错误");
                    }
                }
            }
        });
        BaseMaterialDialog.showMaterialDialog(this.mActivity, "正在连接设备中...", true);
        BluetoothConnectUtil.getInstance().connect(this.mBluetoothDevice);
    }

    public void onReceivedDataResult(String str) {
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B0")) {
            this.mMachineId = DoorLockCommandUtil.getSmallFormatData(str.substring(6, 14));
            this.R1 = str.substring(20, 36);
            if (Integer.parseInt(DoorLockCommandUtil.getSmallFormatData(str.substring(16, 20)), 16) == 0) {
                ToastUtils.show(this.mActivity, "开门记录已提取完毕");
                end();
                return;
            } else {
                this.R2 = RandomUtil.getRandNumMaxString(8) + RandomUtil.getRandNumMaxString(8);
                getHAC();
                return;
            }
        }
        if (str.length() > 6 && str.substring(4, 6).equalsIgnoreCase("B1")) {
            if (str.substring(6, 8).equals("00") && str.length() >= 18) {
                String strSubstring = str.substring(8, 16);
                this.mDeviceUserID = str.substring(16, 18);
                if (this.EAC.equals(strSubstring)) {
                    sendBB();
                    return;
                } else {
                    showDialog("授权失败！200005");
                    return;
                }
            }
            showDialog("授权失败！200002");
            return;
        }
        if (!str.substring(4, 6).equalsIgnoreCase("BB") || str.length() < 8) {
            return;
        }
        if (Integer.parseInt(str.substring(6, 8), 16) == 7 && str.length() < 10) {
            ToastUtils.show(this.mActivity, "开门记录已提取完毕");
            end();
            return;
        }
        if (str.length() >= 24) {
            uploadRecords(str.substring(8, 10), (BaseWrapper.ENTER_ID_SYSTEM_HELPER + DoorLockCommandUtil.getLenString(Integer.parseInt(str.substring(10, 12), 16) + "", 2)) + (x.A + DoorLockCommandUtil.getLenString(Integer.parseInt(str.substring(12, 14), 16) + "", 2)) + (x.A + DoorLockCommandUtil.getLenString(Integer.parseInt(str.substring(14, 16), 16) + "", 2)) + (PPSLabelView.Code + DoorLockCommandUtil.getLenString(Integer.parseInt(str.substring(16, 18), 16) + "", 2)) + (x.bQ + DoorLockCommandUtil.getLenString(Integer.parseInt(str.substring(18, 20), 16) + "", 2)) + (x.bQ + DoorLockCommandUtil.getLenString(Integer.parseInt(str.substring(20, 22), 16) + "", 2)), Integer.parseInt(str.substring(22, 24), 16));
            return;
        }
        showDialog("开门记录异常");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGetRecord() {
        if (StringUtils.isNotEmpty(LocalBusinessStore.getDoorLockRecord(this.mActivity))) {
            uploadOldRecords();
        } else {
            sendB0();
        }
    }

    private void sendB0() {
        BluetoothConnectUtil.getInstance().sendData(DoorLockCommandUtil.getB0Command(this.mUserID));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendB1() {
        BluetoothConnectUtil.getInstance().sendData(DoorLockCommandUtil.getB1Command(this.R2, this.HAC));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendBB() {
        BluetoothConnectUtil.getInstance().sendData(DoorLockCommandUtil.getBBOpenRecordCommand(1));
    }

    private void getHAC() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers businessControllers = BusinessControllers.getInstance();
        Account account = this.mAccount;
        businessControllers.getDLHAC(account, this.mTypeID, randNumMaxString, this.mMachineId, account.getAccountManagetStore().getUserInfo().stId, this.R1, this.R2, new Listener<DLHACBean>() { // from class: client.android.yixiaotong.ui.doorlock.RecordController.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DLHACBean dLHACBean, Object... objArr) {
                if (RecordController.this.mIsEnable) {
                    if (dLHACBean == null || !randNumMaxString.equals(dLHACBean.random) || !StringUtils.isNotEmpty(dLHACBean.hac) || !StringUtils.isNotEmpty(dLHACBean.eac)) {
                        RecordController.this.showDialog("获取后台数据HAC异常!");
                        return;
                    }
                    RecordController.this.HAC = dLHACBean.hac;
                    RecordController.this.EAC = dLHACBean.eac;
                    RecordController.this.sendB1();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                RecordController.this.manageError(clientException);
            }
        });
    }

    private void uploadRecords(String str, String str2, int i) {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        final String dataStr = getDataStr(str, str2, i);
        BusinessControllers.getInstance().getDoorLockUploadRecords(this.mAccount, this.mTypeID, randNumMaxString, dataStr, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.RecordController.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (RecordController.this.mIsEnable) {
                    if (successBean == null || !randNumMaxString.equals(successBean.random)) {
                        LocalBusinessStore.saveDoorLockRrcord(RecordController.this.mActivity, dataStr);
                        RecordController.this.showDialog("上传开门记录失败");
                    } else {
                        RecordController.this.sendBB();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RecordController.this.mIsEnable) {
                    LocalBusinessStore.saveDoorLockRrcord(RecordController.this.mActivity, dataStr);
                    RecordController.this.manageError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void manageError(ClientException clientException) {
        if (this.mIsEnable) {
            BaseMaterialDialog.dissmisMaterialDialog();
            ErrorUtil.onFailResult(this.mActivity, "门禁提取记录", clientException, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog(String str) {
        SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
    }

    private String getDataStr(String str, String str2, int i) {
        ArrayList arrayList = new ArrayList();
        RecordBean recordBean = new RecordBean();
        recordBean.dateTime = str2;
        recordBean.keyflag = i;
        recordBean.keyid = str;
        recordBean.hardwareUserid = DoorLockCommandUtil.getLenString(Integer.toHexString(Integer.parseInt(str, 16) / 10), 2);
        recordBean.machineid = this.mMachineId;
        recordBean.roomId = LocalBusinessStore.getDoorLockRoomid(this.mActivity);
        recordBean.systemtime = System.currentTimeMillis() + "";
        arrayList.add(recordBean);
        return new Gson().toJson(arrayList);
    }

    private void uploadOldRecords() {
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().getDoorLockUploadRecords(this.mAccount, this.mTypeID, randNumMaxString, LocalBusinessStore.getDoorLockRecord(this.mActivity), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.doorlock.RecordController.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (RecordController.this.mIsEnable) {
                    if (successBean == null || !randNumMaxString.equals(successBean.random)) {
                        LocalBusinessStore.saveDoorLockRrcord(RecordController.this.mActivity, "");
                        RecordController.this.startGetRecord();
                    } else {
                        LocalBusinessStore.saveDoorLockRrcord(RecordController.this.mActivity, "");
                        RecordController.this.startGetRecord();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (RecordController.this.mIsEnable) {
                    LocalBusinessStore.saveDoorLockRrcord(RecordController.this.mActivity, "");
                    RecordController.this.startGetRecord();
                }
            }
        });
    }

    private void end() {
        BluetoothSDK.getInstance().closeBLE();
        EventBus.getDefault().post(new DoorLockRecordEvent());
        if (LocalBusinessStore.getDoorLockTip(this.mActivity)) {
            return;
        }
        this.mActivity.finish();
    }
}
