package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.text.TextUtils;
import android.util.Log;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.account.Account;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.BillOrderBean;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.ChangeModeEvent;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.spp.ClsUtils;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.utils.BathUtil;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.ui.pay.PayOrderActivity;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class OpenController {
    private static final int MAX_CONNECT_COUNT = 3;
    private Account mAccout;
    private Activity mActivity;
    private BluetoothDevice mBluetoothDevice;
    private int mConsumptionTimes;
    private State mCurrentBluetoothState;
    private String mDeviceHexID;
    private int mDeviceTypeId;
    private String mF5Data;
    private WalletModel mWalletModel;
    private boolean mIsEnable = true;
    private boolean mIsConnected = false;
    private int mConnectCount = 0;
    private boolean mIsBLEMode = true;
    private boolean mIsClosing = false;
    private OpenListener openListener = new OpenListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.1
        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public short callBalance(BluetoothDevice bluetoothDevice) {
            return (short) 0;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public int callConsumptionTime(BluetoothDevice bluetoothDevice) {
            return 0;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public boolean needUploadOrder(BluetoothDevice bluetoothDevice, OrderBean orderBean) {
            return false;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onGetAuthDataV4(BluetoothDevice bluetoothDevice) {
            return null;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onGetStudentId(BluetoothDevice bluetoothDevice) {
            return "5551C4B8";
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onOpenDate(BluetoothDevice bluetoothDevice) {
            return null;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onf1(BluetoothDevice bluetoothDevice, String str, String str2) {
            return null;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onStart(BluetoothDevice bluetoothDevice) {
            Log.e("test", "开始连接蓝牙！");
            OpenController.this.mCurrentBluetoothState = State.connecting;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onNoneBond(BluetoothDevice bluetoothDevice) {
            Log.e("test", "蓝牙未配对");
            BaseMaterialDialog.setConnectMaterialDialog("设备未配对，设备正在请求与设备配对");
            android.bluetooth.BluetoothDevice remoteDevice = BluetoothUtils.getBluetoothAdapter(OpenController.this.mActivity).getRemoteDevice(OpenController.this.mBluetoothDevice.address);
            try {
                ClsUtils.createBond(remoteDevice.getClass(), remoteDevice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectBLESuccess(BluetoothDevice bluetoothDevice) {
            BaseMaterialDialog.setConnectMaterialDialog("蓝牙配对成功...");
            OpenController.this.mCurrentBluetoothState = State.connected;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccess(BluetoothDevice bluetoothDevice, String str) {
            LocalBusinessStore.saveLastBathVersion(OpenController.this.mActivity, 1, bluetoothDevice.address, 1);
            if (OpenController.this.mIsEnable) {
                OpenController.this.mCurrentBluetoothState = State.senddata;
                OpenController.this.mF5Data = str;
                OpenController.this.mIsConnected = true;
                OpenController.this.mConnectCount = 3;
                String strSubstring = str.substring(44, 64);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(str.substring(36, 40));
                byte[] bArr = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                short sBytesToInt2 = (short) IntegerUtils.bytesToInt2(bArr, 0);
                OpenController.this.mDeviceHexID = strSubstring;
                OpenController.this.mDeviceTypeId = sBytesToInt2;
                if (OpenController.this.mBluetoothDevice != null && !TextUtils.isEmpty(strSubstring)) {
                    if (!NetworkUtils.isNetworkAvailable(OpenController.this.mActivity)) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(OpenController.this.mActivity, "请打开网络后重试");
                    }
                    if (sBytesToInt2 != 1 && str.length() == 68) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        SystemErrorTip.getInstance().showTipDialog(OpenController.this.mActivity, "此设备无对应的应用,请联系维修人员->" + ((int) sBytesToInt2));
                        return;
                    } else if (str.length() == 68) {
                        OpenController.this.getDeviceInfo();
                        return;
                    } else {
                        OpenController.this.getIsBindRoomStatus();
                        return;
                    }
                }
                LeXiaoTongSDK.getInstance().closeBLE();
                BaseMaterialDialog.dissmisMaterialDialog();
                SystemErrorTip.getInstance().showTipDialog(OpenController.this.mActivity, "水控设备连接失败,设备码为空,请检查设备或报修");
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            OpenController.this.mIsConnected = false;
            if (!OpenController.this.mIsEnable || OpenController.this.mCurrentBluetoothState == State.senddata || OpenController.this.mCurrentBluetoothState == State.scaning || OpenController.this.mCurrentBluetoothState == State.scanend) {
                return;
            }
            BaseMaterialDialog.dissmisMaterialDialog();
            if (!StringUtils.isNotEmpty(str)) {
                str = "水控连接超时";
                if (timeOut != TimeOut.Connect) {
                    if (timeOut == TimeOut.Discover) {
                        str = "查找水控超时";
                    } else if (timeOut == TimeOut.SendOpenGetDeviceSettingCommand) {
                        str = "获取参数超时";
                    } else if (timeOut == TimeOut.SendAA) {
                        str = "获取数据超时";
                    } else {
                        str = timeOut == TimeOut.SendNewCommand ? "获取设备数据超时" : "水控连接超时" + timeOut;
                    }
                }
            }
            if (timeOut == TimeOut.SendOpenGetDeviceSettingCommand || timeOut == TimeOut.SendAA || timeOut == TimeOut.SendNewCommand) {
                SystemErrorTip.getInstance().showTipDialog(OpenController.this.mActivity, str);
            } else {
                OpenController.this.onFailMessage();
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onBluetoothException(ClientException clientException) {
            OpenController.this.mIsConnected = false;
            if (!OpenController.this.mIsEnable || OpenController.this.mCurrentBluetoothState == State.senddata) {
                return;
            }
            OpenController.access$608(OpenController.this);
            if (clientException.getDetail().equals("蓝牙信号不稳定") && OpenController.this.mConnectCount < 3) {
                BaseMaterialDialog.setConnectMaterialDialog("正在匹配蓝牙...");
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenController.this.openDevice();
                    }
                }, 800L);
            } else {
                BaseMaterialDialog.dissmisMaterialDialog();
                OpenController.this.onFailMessage();
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessV3(BluetoothDevice bluetoothDevice, String str) {
            if (OpenController.this.mIsEnable) {
                OpenController.this.mIsConnected = true;
                OpenController.this.mConnectCount = 3;
                OpenController.this.mCurrentBluetoothState = State.senddata;
                LocalBusinessStore.saveLastBathVersion(OpenController.this.mActivity, 1, bluetoothDevice.address, 3);
                if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || str.toUpperCase().equals("A5")) {
                    if (str.toUpperCase().equals("A5")) {
                        String lastBathStudentId = LocalBusinessStore.getLastBathStudentId(OpenController.this.mActivity, 1);
                        if (StringUtils.isNotEmpty(lastBathStudentId) && !OpenController.this.mIsClosing) {
                            OpenController.this.mIsClosing = true;
                            LeXiaoTongSDK.getInstance().sendDataV3("AC" + BathUtil.getStudentId(lastBathStudentId));
                            return;
                        } else {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            LeXiaoTongSDK.getInstance().closeBLE();
                            ToastUtils.show(OpenController.this.mActivity, "设备忙");
                            return;
                        }
                    }
                    if (OpenController.this.mIsClosing) {
                        OpenController.this.mIsClosing = false;
                        OpenController.this.uploadOrder(str.substring(2, 10), str);
                    } else {
                        OpenController.this.bathSmallGetDeviceInfo(str);
                    }
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessNew(BluetoothDevice bluetoothDevice, String str) {
            if (OpenController.this.mIsEnable) {
                BaseMaterialDialog.dissmisMaterialDialog();
                Log.e("test", "onConnectSuccessNew");
                OpenController.this.mCurrentBluetoothState = State.senddata;
                ToastUtils.show(OpenController.this.mActivity, "暂未开通，敬请期待");
                LeXiaoTongSDK.getInstance().closeBLE();
            }
        }
    };
    private boolean mIsOfflineUse = false;

    private enum State {
        scaning,
        scansuccess,
        scanend,
        connecting,
        connected,
        senddata
    }

    public void initData(Activity activity, Account account, WalletModel walletModel) {
        this.mActivity = activity;
        this.mAccout = account;
        this.mWalletModel = walletModel;
    }

    public void onPause() {
        this.mIsEnable = false;
    }

    public void onResume() {
        this.mIsEnable = true;
    }

    public void setBLEMode(boolean z) {
        this.mIsBLEMode = z;
    }

    public void setBluetoothDevice(BluetoothDevice bluetoothDevice) {
        this.mConnectCount = 0;
        this.mBluetoothDevice = bluetoothDevice;
    }

    public void setWalletModel(WalletModel walletModel) {
        this.mWalletModel = walletModel;
    }

    static /* synthetic */ int access$608(OpenController openController) {
        int i = openController.mConnectCount;
        openController.mConnectCount = i + 1;
        return i;
    }

    public void startScan() {
        this.mCurrentBluetoothState = State.scaning;
    }

    public void stopScan() {
        this.mCurrentBluetoothState = State.scanend;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailMessage() {
        new ConnectDeviceFailDialog().showTipDialog(this.mActivity, new ConnectDeviceFailDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.2
            @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
            public void onMoreHelp() {
            }

            @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
            public void onConnect() {
                OpenController.this.mConnectCount = 0;
                BaseMaterialDialog.showMaterialDialog(OpenController.this.mActivity, "正在匹配蓝牙...", false);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OpenController.this.openDevice();
                    }
                }, 800L);
            }

            @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
            public void onQiehuan() {
                EventBus.getDefault().post(new ChangeModeEvent());
            }
        }, this.mBluetoothDevice.rssi, !this.mActivity.getLocalClassName().contains("BathMainActivity") && this.mBluetoothDevice.address.startsWith("00:0E:0"));
    }

    public void openDevice() {
        if (this.mWalletModel.getBalance() > 30000) {
            LeXiaoTongSDK.getInstance().openDevice(this.mBluetoothDevice, this.openListener, this.mAccout.getUid(), (short) -27680, true);
        } else {
            LeXiaoTongSDK.getInstance().openDevice(this.mBluetoothDevice, this.openListener, this.mAccout.getUid(), (short) this.mWalletModel.getBalance(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo() {
        BusinessControllers.getInstance().getDeviceInfo(this.mAccout, this.mDeviceHexID, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.setConnectMaterialDialog("正在获取设备信息..");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                if (!OpenController.this.mIsEnable || deviceInfoBean == null) {
                    return;
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                LocalBusinessStore.saveOfflineCount(OpenController.this.mActivity, 0);
                OpenController.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                OpenController.this.getDeviceInfoOnComplete();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LeXiaoTongSDK.getInstance().closeBLE();
                    if (clientException.getCode() == 5003) {
                        SystemErrorTip.getInstance().showTipDialog(OpenController.this.mActivity, "您没有访问此设备的权限,设备号:" + OpenController.this.mDeviceHexID);
                    } else {
                        ErrorUtil.onFailResult(OpenController.this.mActivity, "更换设备", clientException, false);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNewDeviceInfo(long j) {
        this.mIsOfflineUse = true;
        offlineuse(j);
        BusinessControllers.getInstance().getNewDeviceInfo(this.mAccout, this.mDeviceHexID, j, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.setConnectMaterialDialog("正在获取设备信息中...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                if (!OpenController.this.mIsEnable || deviceInfoBean == null) {
                    return;
                }
                OpenController.this.mIsOfflineUse = false;
                BaseMaterialDialog.dissmisMaterialDialog();
                OpenController.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                PreferenceUtil.putBingdRoomMac(OpenController.this.mActivity, "bindRoommac" + OpenController.this.mAccout.getUid(), OpenController.this.mBluetoothDevice.address);
                OpenController.this.getDeviceInfoOnComplete();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (!OpenController.this.mIsEnable || clientException.getCode() == -1000) {
                    return;
                }
                BaseMaterialDialog.dissmisMaterialDialog();
                OpenController.this.mIsOfflineUse = false;
                LeXiaoTongSDK.getInstance().closeBLE();
                ErrorUtil.onFailResult(OpenController.this.mActivity, "更换设备", clientException, false);
            }
        });
    }

    private void offlineuse(final long j) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.5
            @Override // java.lang.Runnable
            public void run() {
                if (OpenController.this.mIsEnable && OpenController.this.mIsOfflineUse) {
                    if ((System.currentTimeMillis() / 1000) - LocalBusinessStore.getWalletTime(OpenController.this.mActivity) > 259200) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ToastUtils.show(OpenController.this.mActivity, "登录信息已过期，请重新登录！");
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(BaseApplication.app);
                        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
                        return;
                    }
                    NetworkUtils.isNetwork = false;
                    BusinessControllers.getInstance().getRelationWallet(OpenController.this.mAccout, OpenController.this.mDeviceTypeId, new Listener<WalletModel>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.5.1
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, WalletModel walletModel, Object... objArr) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(OpenController.this.mActivity, OpenController.this.mDeviceTypeId, OpenController.this.mBluetoothDevice.address);
                            LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(OpenController.this.mActivity, OpenController.this.mDeviceTypeId, OpenController.this.mDeviceHexID);
                            LocalBusinessStore.saveLastConnectBluetoothDeviceName(OpenController.this.mActivity, OpenController.this.mDeviceTypeId, OpenController.this.mBluetoothDevice.name);
                            LocalBusinessStore.saveLastConnectIsBLE(OpenController.this.mActivity, OpenController.this.mIsBLEMode);
                            if (j != 0 || OpenController.this.mAccout.getAccountManagetStore().getUserInfo().UserType == 1) {
                                if ((OpenController.this.mIsConnected && PreferenceUtil.getBindRoomMac(OpenController.this.mActivity, "bindRoommac" + OpenController.this.mAccout.getUid(), "0").equals(OpenController.this.mBluetoothDevice.address)) || OpenController.this.mAccout.getAccountManagetStore().getUserInfo().UserType == 1) {
                                    BathOpenActivity.launch(OpenController.this.mActivity, OpenController.this.mBluetoothDevice.address, OpenController.this.mBluetoothDevice.name, 0, OpenController.this.mDeviceHexID, OpenController.this.mF5Data);
                                    if (OpenController.this.mActivity.getLocalClassName().contains("BluetoothListTwoNewActivity")) {
                                        OpenController.this.mActivity.finish();
                                        return;
                                    }
                                    return;
                                }
                                LeXiaoTongSDK.getInstance().closeBLE();
                                SystemErrorTip.getInstance().showTipDialog(OpenController.this.mActivity, "网络异常，请使用绑定房间的水控设备");
                                return;
                            }
                            LeXiaoTongSDK.getInstance().closeBLE();
                            SystemErrorTip.getInstance().showTipDialog(OpenController.this.mActivity, "未绑定房间，无法使用设备");
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                            BaseMaterialDialog.dissmisMaterialDialog();
                            LeXiaoTongSDK.getInstance().closeBLE();
                            SystemErrorTip.getInstance().showTipDialog(OpenController.this.mActivity, clientException.getDetail());
                        }
                    });
                }
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfoOnComplete() {
        if (this.mIsConnected) {
            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(this.mActivity, this.mDeviceTypeId, this.mBluetoothDevice.address);
            LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(this.mActivity, this.mDeviceTypeId, this.mDeviceHexID);
            LocalBusinessStore.saveLastConnectBluetoothDeviceName(this.mActivity, this.mDeviceTypeId, this.mBluetoothDevice.name);
            LocalBusinessStore.saveLastConnectIsBLE(this.mActivity, this.mIsBLEMode);
            BathOpenActivity.launch(this.mActivity, this.mBluetoothDevice.address, this.mBluetoothDevice.name, this.mConsumptionTimes, this.mDeviceHexID, this.mF5Data);
            if (this.mActivity.getLocalClassName().contains("BluetoothListTwoNewActivity")) {
                this.mActivity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getIsBindRoomStatus() {
        long j = this.mAccout.getAccountManagetStore().getUserInfo().AreaId;
        long bindRoom = PreferenceUtil.getBindRoom(this.mActivity, "bindRoom" + this.mAccout.getUid(), 0L);
        if (bindRoom != 0 || this.mAccout.getAccountManagetStore().getUserInfo().UserType == 1) {
            getNewDeviceInfo(bindRoom);
        } else {
            BusinessControllers.getInstance().ammeterIsBindRoomNew(this.mAccout, this.mWalletModel.typeId + "", j + "", new Listener<AmmeterBindingRoom>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    if (OpenController.this.mIsEnable) {
                        BaseMaterialDialog.setConnectMaterialDialog("加载中...");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterBindingRoom ammeterBindingRoom, Object... objArr) {
                    if (OpenController.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        PreferenceUtil.putBingdRoom(OpenController.this.mActivity, "bindRoom" + OpenController.this.mAccout.getUid(), ammeterBindingRoom.roomId.longValue());
                        OpenController.this.getNewDeviceInfo(ammeterBindingRoom.roomId.longValue());
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (OpenController.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        if (clientException.getCode() == 7503) {
                            SelectAmmeterAddressActivity.launch(OpenController.this.mActivity, 2, OpenController.this.mWalletModel);
                        } else {
                            ErrorUtil.onFailResult(OpenController.this.mActivity, "更换设备", clientException, false);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrder(String str, String str2) {
        int i = this.mAccout.getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        BusinessControllers.getInstance().postBathUploadOrder(this.mAccout, i, str, str2, 1, RandomUtils.getRandNumMaxStringNonO(6), new Listener<BathUploadOrderBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathUploadOrderBean bathUploadOrderBean, Object... objArr) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (StringUtils.isNotEmpty(bathUploadOrderBean.pay)) {
                        ArrayList arrayList = new ArrayList();
                        BillOrderBean billOrderBean = new BillOrderBean();
                        billOrderBean.applicationType = OpenController.this.mWalletModel.typeId;
                        billOrderBean.consumeAmount = Integer.parseInt(bathUploadOrderBean.pay);
                        billOrderBean.consumeTime = bathUploadOrderBean.settleTime;
                        arrayList.add(billOrderBean);
                        PayOrderActivity.launch(OpenController.this.mActivity, OpenController.this.mWalletModel.typeId, arrayList);
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    if (OpenController.this.mActivity.getLocalClassName().contains("BluetoothListTwoNewActivity")) {
                        OpenController.this.mActivity.finish();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (OpenController.this.mIsEnable) {
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ErrorUtil.onFailResult(OpenController.this.mActivity, "更换设备", clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bathSmallGetDeviceInfo(final String str) {
        BusinessControllers.getInstance().getSmpDeviceInfo(this.mAccout, str.substring(2, 10), new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.setConnectMaterialDialog("正在获取设备信息...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                if (OpenController.this.mIsEnable) {
                    OpenController.this.bathAuth(str.substring(2, 10), str);
                    OpenController.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ErrorUtil.onFailResult(OpenController.this.mActivity, "更换设备", clientException, false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bathAuth(String str, String str2) {
        int i = this.mAccout.getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().postBathAuth(this.mAccout, i, str, str2, 1, randNumMaxStringNonO, new Listener<BathAuthBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.OpenController.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathAuthBean bathAuthBean, Object... objArr) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (bathAuthBean != null && bathAuthBean.rand.equals(randNumMaxStringNonO) && StringUtils.isNotEmpty(bathAuthBean.systemData) && StringUtils.isNotEmpty(bathAuthBean.systemTime)) {
                        LocalBusinessStore.saveLastConnectBluetoothDeviceName(OpenController.this.mActivity, 1, OpenController.this.mBluetoothDevice.name);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceMac(OpenController.this.mActivity, 1, OpenController.this.mBluetoothDevice.address);
                        LocalBusinessStore.saveLastConnectIsBLE(OpenController.this.mActivity, OpenController.this.mIsBLEMode);
                        BathOpenActivity.launch(OpenController.this.mActivity, OpenController.this.mBluetoothDevice.address, OpenController.this.mBluetoothDevice.name, 1, bathAuthBean.systemData, bathAuthBean.systemTime, bathAuthBean.studentId, OpenController.this.mConsumptionTimes);
                        if (OpenController.this.mActivity.getLocalClassName().contains("BluetoothListTwoNewActivity")) {
                            OpenController.this.mActivity.finish();
                            return;
                        }
                        return;
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ToastUtils.show(OpenController.this.mActivity, "授权数据出错！");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (OpenController.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ErrorUtil.onFailResult(OpenController.this.mActivity, "更换设备", clientException, false);
                }
            }
        });
    }
}
