package client.android.yixiaotong.v3.ui.appcontrol.bath;

import android.app.Activity;
import android.util.Log;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.GsonUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.bean.deviceinfo.BluetoothSetBean;
import client.android.yixiaotong.v3.bean.deviceinfo.CollectResultBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineInfoJson;
import client.android.yixiaotong.v3.bean.deviceinfo.NBOr4GDevice;
import client.android.yixiaotong.v3.bean.deviceinfo.PostOpenAuthBean;
import client.android.yixiaotong.v3.bean.deviceinfo.PostPrepareBathBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBaseInfoBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.comman.BluetoothDeviceCommand;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.appcontrol.listener.OpenControlListener;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.NoPayOrderActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.DeviceTypeVerUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.google.gson.reflect.TypeToken;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.model.BluetoothDevice;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathBluetoothOpenControlUtil {
    private static final String TAG = "BathBleOpenControlUtil";
    private Account mAccount;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private CloseControlListener mCloseControlListener;
    private OpenControlListener mControlListener;
    private String mDeviceVer;
    private boolean mIsEnable;
    private String mMachineId;
    private String mQrcode;
    private String mStudentHex;
    private String mStudentNo;
    private String mTitleContent;
    private int mTypeId;
    private TypeInfoBaseInfoBean mTypeInfoBaseInfoBean;
    private int mChannelWay = 1;
    private FlowState mFlowState = FlowState.none;
    private State mState = State.none;
    private String mParFlag = "";

    private enum FlowState {
        none,
        opening,
        opened,
        closeing,
        closeed,
        offineopening
    }

    private enum State {
        none,
        connecting,
        connected,
        connectfail,
        senddata,
        f5,
        f0,
        f2,
        opendata,
        uploaddata,
        closef2,
        set,
        aa
    }

    public void init(Activity activity, Account account, BluetoothDevice bluetoothDevice, TypeInfoBaseInfoBean typeInfoBaseInfoBean, int i, String str, String str2) {
        this.mIsEnable = true;
        this.mActivity = activity;
        this.mAccount = account;
        this.mBluetoothDevice = bluetoothDevice;
        this.mTypeInfoBaseInfoBean = typeInfoBaseInfoBean;
        this.mTypeId = i;
        this.mTitleContent = str;
        this.mQrcode = str2;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setDeviceInfo(String str, String str2) {
        this.mDeviceVer = str;
        this.mMachineId = str2;
    }

    public void setListener(CloseControlListener closeControlListener) {
        this.mCloseControlListener = closeControlListener;
    }

    public void setListener(OpenControlListener openControlListener) {
        this.mControlListener = openControlListener;
    }

    private void connectDecice() {
        BluetoothControlUtil.getInstance().connectBluetooth(this.mBluetoothDevice);
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    public void openStart() {
        this.mFlowState = FlowState.opening;
        connectDecice();
    }

    public void openOffineStart() {
        this.mState = State.none;
        this.mFlowState = FlowState.offineopening;
    }

    public void closeStart() {
        this.mFlowState = FlowState.closeing;
        connectDecice();
    }

    private void openEnd() {
        this.mFlowState = FlowState.opened;
        this.mControlListener.onOpenEnd();
    }

    private void openFail() {
        this.mControlListener.onOpenFail();
    }

    private void closeEnd() {
        CloseControlListener closeControlListener = this.mCloseControlListener;
        if (closeControlListener != null) {
            closeControlListener.onCloseEnd();
        } else {
            ToastUtils.show(this.mActivity, "关阀成功");
            this.mActivity.finish();
        }
    }

    public void connected() {
        if (this.mFlowState == FlowState.opening) {
            open();
        } else if (this.mFlowState == FlowState.closeing) {
            close();
        }
    }

    private void open() {
        if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1)) {
            sendAbortData();
            return;
        }
        if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) {
            String f5Var = BluetoothDeviceCommand.getf5();
            this.mState = State.f5;
            sendData(f5Var);
        } else {
            if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
                String aa = BluetoothDeviceCommand.getAA();
                this.mState = State.aa;
                sendData(aa);
                return;
            }
            onError(0, "无法识别该设备！");
        }
    }

    private void close() {
        if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) {
            String f2Var = BluetoothDeviceCommand.getf2();
            this.mState = State.closef2;
            sendData(f2Var);
        } else if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
            String smallClose = BluetoothDeviceCommand.getSmallClose(UserInfoUtil.getInstance().getLoginAccountV3().studentHex);
            this.mState = State.closef2;
            sendData(smallClose);
        }
    }

    public void receivedData(String str) {
        manageData(str);
    }

    private void sendf5() {
        String f5Var = BluetoothDeviceCommand.getf5();
        this.mState = State.f5;
        sendData(f5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPar(String str) {
        this.mState = State.set;
        sendData(str);
    }

    private void sendAbortData() {
        String f2Var = BluetoothDeviceCommand.getf2();
        this.mState = State.f2;
        sendData(f2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendUploadData(String str) {
        this.mState = State.uploaddata;
        sendData(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAuthData(String str) {
        this.mState = State.opendata;
        sendData(str);
    }

    private void sendCollectData() {
        if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) {
            getF0();
        } else if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
            String aa = BluetoothDeviceCommand.getAA();
            this.mState = State.aa;
            sendData(aa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendData(String str) {
        BluetoothControlUtil.getInstance().setSendTimeOut(3000);
        BluetoothControlUtil.getInstance().sendData(str);
    }

    private void manageData(String str) {
        LogUtil.e(TAG, "flowstate:" + this.mFlowState + "  state:" + this.mState + PPSLabelView.Code + this.mDeviceVer);
        LogUtil.log("flowstate:" + this.mFlowState + "  state:" + this.mState + PPSLabelView.Code + this.mDeviceVer);
        if (this.mFlowState == FlowState.offineopening) {
            if (this.mState == State.none) {
                if (BluetoothControlUtil.getInstance().getDeviceType().equals(BluetoothControlUtil.DeviceType.batchdevice) || BluetoothControlUtil.getInstance().getDeviceType().equals(BluetoothControlUtil.DeviceType.offlinedevice) || BluetoothControlUtil.getInstance().getDeviceType().equals(BluetoothControlUtil.DeviceType.offlinedevice1)) {
                    this.mMachineId = str.substring(44, 64);
                    return;
                }
                if (BluetoothControlUtil.getInstance().getDeviceType().equals(BluetoothControlUtil.DeviceType.smalldevice)) {
                    this.mDeviceVer = DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3;
                    if (str.toUpperCase().equals("A5")) {
                        openEnd();
                        return;
                    } else {
                        if (str.startsWith("55") && str.length() == 40) {
                            if (!str.substring(10, 20).equals("0000000000")) {
                                LocalDataUtil.saveBLEUseRecord(this.mActivity, this.mTypeId, str.substring(2, 10), this.mDeviceVer, str);
                            }
                            openPro(str.substring(2, 10));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (this.mState == State.f0) {
                int i = Integer.parseInt(str.substring(8, 10), 16);
                if (i == 0) {
                    if (BluetoothControlUtil.getInstance().getDeviceType().equals(BluetoothControlUtil.DeviceType.batchdevice)) {
                        this.mDeviceVer = DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1;
                    } else if (BluetoothControlUtil.getInstance().getDeviceType().equals(BluetoothControlUtil.DeviceType.offlinedevice)) {
                        this.mDeviceVer = DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2;
                    } else if (BluetoothControlUtil.getInstance().getDeviceType().equals(BluetoothControlUtil.DeviceType.offlinedevice1)) {
                        this.mDeviceVer = DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4;
                    }
                    LocalDataUtil.saveBLEUseRecord(this.mActivity, this.mTypeId, this.mMachineId, this.mDeviceVer, str);
                    openPro(this.mMachineId);
                    return;
                }
                if (i == 1) {
                    onError(0, "连接失败");
                    return;
                }
                if (i == 2) {
                    openPro(this.mMachineId);
                    return;
                }
                if (i != 15) {
                    if (i == 13) {
                        onError(0, "没有绑定，不能进行脱机消费");
                        return;
                    } else if (i == 14) {
                        onError(0, "该设备已经绑满账号了");
                        return;
                    } else {
                        onError(0, "连接失败" + i);
                        return;
                    }
                }
                LogUtil.e(TAG, "manageData mStudentNo:" + this.mStudentNo);
                String strSubstring = str.substring(30, 46);
                LogUtil.e(TAG, "manageData userId:" + strSubstring);
                if (strSubstring.equalsIgnoreCase(this.mStudentNo)) {
                    this.mFlowState = FlowState.opened;
                    openEnd();
                    return;
                } else {
                    onError(0, "设备正忙，无法使用");
                    return;
                }
            }
            if (this.mState == State.opendata) {
                if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
                    if (str.toUpperCase().startsWith("AA") && str.length() == 18) {
                        BluetoothControlUtil.getInstance().disconnect();
                        this.mFlowState = FlowState.opened;
                        openEnd();
                        return;
                    }
                    onError(0, "开阀失败");
                    return;
                }
                if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) {
                    int i2 = Integer.parseInt(str.substring(8, 10), 16);
                    if (i2 == 0) {
                        this.mFlowState = FlowState.opened;
                        openEnd();
                        return;
                    }
                    if (i2 == 1) {
                        onError(0, "连接失败,确认订单上传失败");
                        return;
                    }
                    if (i2 == 2) {
                        onError(0, "授信金额不足");
                        return;
                    }
                    if (i2 == 3) {
                        BluetoothControlUtil.getInstance().disconnect();
                        this.mFlowState = FlowState.opened;
                        openEnd();
                        return;
                    } else {
                        if (i2 == 5) {
                            openEnd();
                            return;
                        }
                        if (i2 == 13) {
                            onError(0, "空间不足,不允许脱网消费");
                            return;
                        }
                        if (i2 == 14) {
                            onError(0, "写存储器失败");
                            return;
                        } else if (i2 == 15) {
                            onError(0, "设备正忙,无法使用");
                            return;
                        } else {
                            onError(0, "开阀失败" + i2);
                            return;
                        }
                    }
                }
                return;
            }
            return;
        }
        if (this.mFlowState == FlowState.opening) {
            if (this.mState == State.f2) {
                sendf5();
                return;
            }
            if (this.mState == State.f5) {
                getF0();
                return;
            }
            if (this.mState == State.f0) {
                int i3 = Integer.parseInt(str.substring(8, 10), 16);
                if (i3 == 0) {
                    uploadOrder(str);
                    return;
                }
                if (i3 == 1) {
                    onError(0, "连接失败");
                    return;
                }
                if (i3 == 2) {
                    auth(str);
                    return;
                }
                if (i3 != 15) {
                    if (i3 == 13) {
                        onError(0, "没有绑定，不能进行脱机消费");
                        return;
                    } else if (i3 == 14) {
                        onError(0, "该设备已经绑满账号了");
                        return;
                    } else {
                        onError(0, "连接失败" + i3);
                        return;
                    }
                }
                LogUtil.e(TAG, "manageData mStudentNo:" + this.mStudentNo);
                if ((this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) && StringUtils.isNotEmpty(this.mStudentNo) && str.length() > 46) {
                    String strSubstring2 = str.substring(30, 46);
                    LogUtil.e(TAG, "manageData userId:" + strSubstring2);
                    if (strSubstring2.equalsIgnoreCase(this.mStudentNo)) {
                        this.mFlowState = FlowState.opened;
                        openEnd();
                        uploadDeviceInfo();
                        return;
                    }
                    onError(0, "设备正忙，无法使用");
                    return;
                }
                sendAbortData();
                return;
            }
            if (this.mState == State.opendata || this.mState == State.uploaddata) {
                if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
                    if (str.toUpperCase().startsWith("AA") && str.length() == 18) {
                        BluetoothControlUtil.getInstance().disconnect();
                        this.mFlowState = FlowState.opened;
                        openEnd();
                        return;
                    }
                    onError(0, "开阀失败");
                    return;
                }
                if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) {
                    int i4 = Integer.parseInt(str.substring(8, 10), 16);
                    if (i4 == 0) {
                        this.mFlowState = FlowState.opened;
                        openEnd();
                        uploadDeviceInfo();
                        return;
                    }
                    if (i4 == 1) {
                        onError(0, "连接失败,确认订单上传失败");
                        return;
                    }
                    if (i4 == 2) {
                        onError(0, "授信金额不足");
                        return;
                    }
                    if (i4 == 3) {
                        BluetoothControlUtil.getInstance().disconnect();
                        this.mFlowState = FlowState.opened;
                        openEnd();
                        return;
                    } else {
                        if (i4 == 5) {
                            getF0();
                            return;
                        }
                        if (i4 == 13) {
                            onError(0, "空间不足,不允许脱网消费");
                            return;
                        }
                        if (i4 == 14) {
                            onError(0, "写存储器失败");
                            return;
                        } else if (i4 == 15) {
                            onError(0, "设备正忙,无法使用");
                            return;
                        } else {
                            onError(0, "开阀失败" + i4);
                            return;
                        }
                    }
                }
                return;
            }
            if (this.mState == State.f2) {
                getF0();
                return;
            }
            if (this.mState == State.aa) {
                if (str.toUpperCase().equals("A5")) {
                    openEnd();
                    return;
                }
                if (str.startsWith("55") && str.length() == 40) {
                    if (str.substring(10, 20).equals("0000000000")) {
                        auth(str);
                        return;
                    } else {
                        uploadOrder(str);
                        return;
                    }
                }
                return;
            }
            return;
        }
        if (this.mFlowState == FlowState.opened) {
            if (this.mState == State.set) {
                BluetoothControlUtil.getInstance().disconnect();
                uploadDeviceInfoResult();
                return;
            }
            return;
        }
        if (this.mFlowState == FlowState.closeing && this.mState == State.closef2) {
            if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
                if (str.equalsIgnoreCase("A5")) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    ToastUtils.show(this.mActivity, "关阀失败,请在设备上关阀");
                    return;
                } else {
                    closeEnd();
                    return;
                }
            }
            if (this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath1) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath2) || this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath4)) {
                closeEnd();
            } else {
                BaseMaterialDialog.dissmisMaterialDialog();
                ToastUtils.show(this.mActivity, "关阀失败");
            }
        }
    }

    private void getF0() {
        V3BusinessControllers.getInstance().postPrepareBath(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mDeviceVer, this.mMachineId, null, new Listener<PostPrepareBathBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PostPrepareBathBean postPrepareBathBean, Object... objArr) {
                super.onComplete(controller, postPrepareBathBean, objArr);
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    BathBluetoothOpenControlUtil.this.mState = State.f0;
                    if (StringUtils.isNotEmpty(postPrepareBathBean.sendMachineData) && postPrepareBathBean.sendMachineData.length() > 26) {
                        BathBluetoothOpenControlUtil.this.mStudentNo = postPrepareBathBean.sendMachineData.substring(10, 26);
                    }
                    BathBluetoothOpenControlUtil.this.sendData(postPrepareBathBean.sendMachineData);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    BathBluetoothOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void uploadOrder(final String str) {
        NBOr4GDevice nBOr4GDevice = new NBOr4GDevice();
        nBOr4GDevice.machineData = str;
        V3BusinessControllers.getInstance().postHandleData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, nBOr4GDevice, 0, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    Log.e("text", ifNull);
                    try {
                        CollectResultBean collectResultBean = (CollectResultBean) GsonUtils.getInstance().parse(new TypeToken<CollectResultBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.2.1
                        }.getType(), ifNull);
                        if (BathBluetoothOpenControlUtil.this.mDeviceVer.equals(DeviceTypeVerUtil.Bluetooth_Device_Ver_Bath3)) {
                            BathBluetoothOpenControlUtil.this.auth(str);
                        } else {
                            BathBluetoothOpenControlUtil.this.sendUploadData(collectResultBean.sendMachineData);
                        }
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(BathBluetoothOpenControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        Log.e("test", ifNull);
                        NoPayOrderActivity.launch(BathBluetoothOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), BathBluetoothOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        BathBluetoothOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    BathBluetoothOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auth(String str) {
        MachineInfoJson machineInfoJson = new MachineInfoJson();
        machineInfoJson.netFlag = "0000";
        if (str.length() > 30) {
            machineInfoJson.machineRandom = str.substring(22, 30);
        }
        machineInfoJson.machineData = str;
        V3BusinessControllers.getInstance().postOpenAuth(this.mAccount, this.mChannelWay, this.mTypeInfoBaseInfoBean.typeId, this.mDeviceVer, this.mMachineId, "", machineInfoJson, new Listener<Object>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, Object obj, Object... objArr) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    String ifNull = GsonUtils.getInstance().parseIfNull(obj);
                    Log.e("text", ifNull);
                    try {
                        BathBluetoothOpenControlUtil.this.sendAuthData(((PostOpenAuthBean) GsonUtils.getInstance().parse(new TypeToken<PostOpenAuthBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.3.1
                        }.getType(), ifNull)).sendMachineData);
                    } catch (ClientException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    if (clientException.getCode() == -52) {
                        ToastUtils.show(BathBluetoothOpenControlUtil.this.mActivity, clientException.getDetail());
                        String ifNull = GsonUtils.getInstance().parseIfNull(clientException.getObject());
                        Log.e("test", ifNull);
                        NoPayOrderActivity.launch(BathBluetoothOpenControlUtil.this.mActivity, GsonUtils.getInstance().parseString2List(ifNull, NoPayOrderBean.class), BathBluetoothOpenControlUtil.this.mTypeInfoBaseInfoBean);
                        BathBluetoothOpenControlUtil.this.mActivity.finish();
                        return;
                    }
                    BathBluetoothOpenControlUtil.this.onError(clientException);
                }
            }
        });
    }

    private void uploadDeviceInfoResult() {
        if (StringUtils.isNotEmpty(this.mParFlag)) {
            V3BusinessControllers.getInstance().postBluetoothSetDataResult(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mParFlag, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.4
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
        V3BusinessControllers.getInstance().postBluetoothSetData(this.mAccount, this.mTypeInfoBaseInfoBean.typeId, this.mMachineId, this.mDeviceVer, null, new Listener<BluetoothSetBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BluetoothSetBean bluetoothSetBean, Object... objArr) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    if (bluetoothSetBean != null && bluetoothSetBean.statusFlag == 0 && StringUtils.isNotEmpty(bluetoothSetBean.sendMachineData)) {
                        BathBluetoothOpenControlUtil.this.mParFlag = bluetoothSetBean.parFlag;
                        BathBluetoothOpenControlUtil.this.setPar(bluetoothSetBean.sendMachineData);
                        return;
                    }
                    BluetoothControlUtil.getInstance().disconnect();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    BluetoothControlUtil.getInstance().disconnect();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            openFail();
            showDialog(true, true, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(this.mActivity, this.mTitleContent, clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            this.mActivity.finish();
        }
    }

    private void showDialog(boolean z, boolean z2, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(this.mActivity) + ")";
        }
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.6
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BathBluetoothOpenControlUtil.this.mActivity.finish();
                }
            }, str);
        } else {
            SystemErrorTip.getInstance().showTipDialog(this.mActivity, str);
        }
    }

    private void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launchBluetoothFail(this.mActivity, this.mTitleContent, str, i);
        this.mActivity.finish();
    }

    private void getF0Pro(String str) {
        String str2;
        int i = this.mTypeId;
        if (i == 6) {
            str2 = "2";
        } else {
            str2 = i == 8 ? "3" : "1";
        }
        V3BusinessControllers.getInstance().postOpen(this.mAccount, str, InvestorInfoUtilControl.getInstance().getInvestorId(), "mMachineRand", str2, this.mStudentHex, 0, "Android(" + AppUtils.getVersion(this.mActivity) + ")  " + LocalDataUtil.getErrorUrl(this.mActivity) + "  (" + LocalDataUtil.getCode(this.mActivity) + ")", false, new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str3, Object... objArr) {
                if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                    BathBluetoothOpenControlUtil.this.mState = State.f0;
                    if (StringUtils.isNotEmpty(str3) && str3.length() > 26) {
                        BathBluetoothOpenControlUtil.this.mStudentNo = str3.substring(10, 26);
                    }
                    BathBluetoothOpenControlUtil.this.sendData(str3);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = BathBluetoothOpenControlUtil.this.mIsEnable;
            }
        });
    }

    private void openPro(String str) {
        String str2;
        LogUtil.e(TAG, "openPro:" + LocalDataUtil.getCode(this.mActivity) + PPSLabelView.Code + LocalDataUtil.getOpenDeviceForUser(this.mActivity, this.mStudentHex) + PPSLabelView.Code + isUseTime());
        if (LocalDataUtil.getOpenDeviceForUser(this.mActivity, this.mStudentHex) || isUseTime()) {
            LogUtil.e(TAG, "openPro:" + str);
            if (StringUtils.isEmpty(str)) {
                return;
            }
            int i = this.mTypeId;
            if (i == 6) {
                str2 = "2";
            } else {
                str2 = i == 8 ? "3" : "1";
            }
            V3BusinessControllers.getInstance().postOpen(this.mAccount, str, InvestorInfoUtilControl.getInstance().getInvestorId(), "mMachineRand", str2, this.mStudentHex, 0, "Android(" + AppUtils.getVersion(this.mActivity) + ")  " + LocalDataUtil.getErrorUrl(this.mActivity) + "  (" + LocalDataUtil.getCode(this.mActivity) + ")", false, new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathBluetoothOpenControlUtil.8
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, String str3, Object... objArr) {
                    if (BathBluetoothOpenControlUtil.this.mIsEnable) {
                        BathBluetoothOpenControlUtil.this.sendAuthData(str3);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    boolean unused = BathBluetoothOpenControlUtil.this.mIsEnable;
                }
            });
        }
    }

    private boolean isUseTime() {
        LogUtil.e(TAG, "isUseTime:" + System.currentTimeMillis());
        if (System.currentTimeMillis() <= 1756483200000L || System.currentTimeMillis() >= 1757519999000L) {
            return System.currentTimeMillis() > 1759593600000L && System.currentTimeMillis() < 1760543999000L;
        }
        return true;
    }
}
