package client.android.yixiaotong.ui.deviceinit;

import android.app.Activity;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthNewBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderNewBean;
import client.android.yixiaotong.controller.bean.init.NBMachineInfo;
import client.android.yixiaotong.controller.bean.init.SetNBDrinkWaterBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.spp.ClsUtils;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.CollectDataListener;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.runnable.listener.SettingListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.bluetoothtwo.BathOpenActivity;
import client.android.yixiaotong.ui.bluetoothtwo.InitDeviceNewTwoActivity;
import client.android.yixiaotong.ui.bluetoothtwo.InitDeviceTwoActivity;
import client.android.yixiaotong.ui.bluetoothtwo.SetBluetoothDeviceActivity;
import client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity;
import client.android.yixiaotong.ui.dialog.AuthDetailDialog;
import client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog;
import client.android.yixiaotong.ui.dialog.InitDialogTip;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.dialog.UnInitDeviceDialog;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceInitBathActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_ISINIT = "extra_isinit";
    public static final String EXTRA_WALLET = "extra_wallet";
    private String mAuthData;
    private BluetoothDevice mBluetoothDevice;
    private int mConsumptionTimes;
    private CountDownLatch mCountDownLatch;
    private State mCurrentBluetoothState;
    private String mDeviceAddress;
    private String mDeviceHexID;
    private int mDeviceTypeId;
    private DevicesAdapter mDevicesAdapter;
    private String mF0Data;
    private String mF5Data;
    private ImageView mImgRefreshDevices;
    private boolean mIsInit;
    private ListView mList;
    private String mMachineRand;
    private MaterialDialog mMaterialDialog;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean mIsConnected = false;
    private int mConnectCount = 0;
    private boolean mIsEnable = true;
    private boolean mIsBLEMode = true;
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.2
        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onBluetoothException(ClientException clientException) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onStart() {
            DeviceInitBathActivity.this.mCurrentBluetoothState = State.scaning;
            DeviceInitBathActivity.this.mImgRefreshDevices.setVisibility(8);
            DeviceInitBathActivity.this.mBluetoothDevices.clear();
            DeviceInitBathActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (!DeviceInitBathActivity.this.mIsBLEMode) {
                if (DeviceInitBathActivity.this.mBluetoothDevices.contains(bluetoothDevice) || bluetoothDevice.address.startsWith("00:0E:0B")) {
                    return;
                }
                DeviceInitBathActivity.this.mBluetoothDevices.add(bluetoothDevice);
                Collections.sort(DeviceInitBathActivity.this.mBluetoothDevices, new TestComparator());
                DeviceInitBathActivity.this.mDevicesAdapter.notifyDataSetChanged();
                return;
            }
            if (DeviceInitBathActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                return;
            }
            DeviceInitBathActivity.this.mBluetoothDevices.add(bluetoothDevice);
            Collections.sort(DeviceInitBathActivity.this.mBluetoothDevices, new TestComparator());
            DeviceInitBathActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onComplete() {
            DeviceInitBathActivity.this.mImgRefreshDevices.setVisibility(0);
            DeviceInitBathActivity.this.mCurrentBluetoothState = State.scanend;
        }
    };
    private OpenListener openListener = new AnonymousClass4();
    private boolean mIsOpen = true;
    private long mCurrentTime = 0;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.10
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e("test", "action:" + action);
            if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                android.bluetooth.BluetoothDevice remoteDevice = BluetoothUtils.getBluetoothAdapter(DeviceInitBathActivity.this.getContext()).getRemoteDevice(DeviceInitBathActivity.this.mBluetoothDevice.address);
                try {
                    DeviceInitBathActivity.this.mReceiver.abortBroadcast();
                    ClsUtils.setPin(remoteDevice.getClass(), remoteDevice, "1234");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
                android.bluetooth.BluetoothDevice remoteDevice2 = BluetoothUtils.getBluetoothAdapter(DeviceInitBathActivity.this.getContext()).getRemoteDevice(DeviceInitBathActivity.this.mBluetoothDevice.address);
                Log.e("test", remoteDevice2.getBondState() + PPSLabelView.Code);
                int bondState = remoteDevice2.getBondState();
                if (bondState == 10) {
                    DeviceInitBathActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "配对失败，请重试或者请到手机本地设置中找到设备蓝牙后进行配对，配对成功后返回APP点击配对设备即可连接使用");
                } else {
                    if (bondState != 12) {
                        return;
                    }
                    if (DeviceInitBathActivity.this.isShowingDialog()) {
                        DeviceInitBathActivity.this.mMaterialDialog.setContent("配对完成，开始连接设备");
                    }
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DeviceInitBathActivity.this.openDevice();
                        }
                    }, 800L);
                }
            }
        }
    };
    private int mTypeid = 0;
    private boolean mIsUploadSuccess = false;
    private CollectDataListener collectDataListener = new CollectDataListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.15
        @Override // client.android.yixiaotong.sdk.runnable.listener.CollectDataListener
        public boolean needUploadOrder(BluetoothDevice bluetoothDevice, String str, String str2) {
            if (DeviceInitBathActivity.this.mIsEnable) {
                DeviceInitBathActivity.this.mCountDownLatch = new CountDownLatch(1);
                DeviceInitBathActivity.this.newDeviceUploadOrder(str, str2);
                try {
                    DeviceInitBathActivity.this.mCountDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return DeviceInitBathActivity.this.mIsUploadSuccess;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CollectDataListener
        public void onMachineRand(BluetoothDevice bluetoothDevice, String str) {
            if (DeviceInitBathActivity.this.mIsEnable) {
                DeviceInitBathActivity.this.mMachineRand = str;
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CollectDataListener
        public String onGetStudentId(BluetoothDevice bluetoothDevice) {
            if (DeviceInitBathActivity.this.mIsEnable) {
                String str = DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().stId;
                if (StringUtils.isNotEmpty(str)) {
                    return str;
                }
            }
            return "5551C4B8";
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CollectDataListener
        public String onGetOpenData(BluetoothDevice bluetoothDevice) {
            return DeviceInitBathActivity.this.mAuthData;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CollectDataListener
        public void onSuccess(BluetoothDevice bluetoothDevice, boolean z) {
            if (DeviceInitBathActivity.this.mIsEnable) {
                String strSubstring = DeviceInitBathActivity.this.mF0Data.substring(22, 38);
                DeviceInitBathActivity deviceInitBathActivity = DeviceInitBathActivity.this;
                deviceInitBathActivity.newdeviceUnbind(strSubstring, deviceInitBathActivity.mTypeid);
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.CollectDataListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            if (DeviceInitBathActivity.this.mIsEnable) {
                DeviceInitBathActivity.this.dismissDialog();
                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), str);
            }
        }
    };

    private enum State {
        scaning,
        scansuccess,
        scanend,
        connecting,
        connected,
        senddata
    }

    static {
        StubApp.interface11(6714);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    static /* synthetic */ int access$1508(DeviceInitBathActivity deviceInitBathActivity) {
        int i = deviceInitBathActivity.mConnectCount;
        deviceInitBathActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DeviceInitBathActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_isinit", z));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.tb_name);
        this.mList = (ListView) findViewById(R.id.recycler_view);
        this.mImgRefreshDevices = (ImageView) findViewById(R.id.img_refresh);
    }

    private void initView() {
        this.mList.setOnItemClickListener(this);
        ListView listView = this.mList;
        DevicesAdapter devicesAdapter = new DevicesAdapter();
        this.mDevicesAdapter = devicesAdapter;
        listView.setAdapter((ListAdapter) devicesAdapter);
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceInitBathActivity.this.mScanListener, DeviceInitBathActivity.this.mIsBLEMode);
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.setPriority(1000);
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        getActivity().registerReceiver(this.mReceiver, intentFilter);
        this.mIsEnable = true;
        if (BluetoothManager.getInstance().isBluetoothOn()) {
            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener, this.mIsBLEMode);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    DeviceInitBathActivity.this.finish();
                }
            }, "请打开蓝牙！");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        dismissDialog();
        stopScan();
        getActivity().unregisterReceiver(this.mReceiver);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        if (this.mIsInit) {
            this.mTitleBar.setTitleView("设备初始化");
        } else {
            this.mTitleBar.setTitleView("设置参数");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopScan() {
        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(this.mIsBLEMode);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity$4, reason: invalid class name */
    class AnonymousClass4 extends OpenListener {
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
        public void onDataV4(BluetoothDevice bluetoothDevice, String str, String str2) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onOpenDate(BluetoothDevice bluetoothDevice) {
            return null;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onf1(BluetoothDevice bluetoothDevice, String str, String str2) {
            return null;
        }

        AnonymousClass4() {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onStart(BluetoothDevice bluetoothDevice) {
            Log.e("test", "开始连接蓝牙！");
            DeviceInitBathActivity.this.mCurrentBluetoothState = State.connecting;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onNoneBond(BluetoothDevice bluetoothDevice) {
            Log.e("test", "蓝牙未配对");
            if (DeviceInitBathActivity.this.isShowingDialog()) {
                DeviceInitBathActivity.this.mMaterialDialog.setContent("设备未配对，设备正在请求与设备配对");
            }
            android.bluetooth.BluetoothDevice remoteDevice = BluetoothUtils.getBluetoothAdapter(DeviceInitBathActivity.this.getContext()).getRemoteDevice(DeviceInitBathActivity.this.mBluetoothDevice.address);
            try {
                ClsUtils.createBond(remoteDevice.getClass(), remoteDevice);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectBLESuccess(BluetoothDevice bluetoothDevice) {
            DeviceInitBathActivity.this.mCurrentBluetoothState = State.connected;
            if (DeviceInitBathActivity.this.mMaterialDialog != null) {
                DeviceInitBathActivity.this.mMaterialDialog.setContent("蓝牙配对成功...");
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccess(BluetoothDevice bluetoothDevice, String str) {
            LocalBusinessStore.saveLastBathVersion(DeviceInitBathActivity.this.getContext(), 1, bluetoothDevice.address, 1);
            if (DeviceInitBathActivity.this.mIsEnable) {
                DeviceInitBathActivity.this.mCurrentBluetoothState = State.senddata;
                DeviceInitBathActivity.this.mF5Data = str;
                DeviceInitBathActivity.this.mIsConnected = true;
                DeviceInitBathActivity.this.mConnectCount = 3;
                String strSubstring = str.substring(44, 64);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(str.substring(36, 40));
                byte[] bArr = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                short sBytesToInt2 = (short) IntegerUtils.bytesToInt2(bArr, 0);
                DeviceInitBathActivity.this.mDeviceHexID = strSubstring;
                DeviceInitBathActivity.this.mDeviceTypeId = sBytesToInt2;
                if (DeviceInitBathActivity.this.mBluetoothDevice != null && !TextUtils.isEmpty(strSubstring)) {
                    if (!NetworkUtils.isNetworkAvailable(DeviceInitBathActivity.this.getContext())) {
                        DeviceInitBathActivity.this.dismissDialog();
                        ToastUtils.show(DeviceInitBathActivity.this.getContext(), "请检查网络后重试");
                    }
                    if (sBytesToInt2 != 1 && str.length() == 68) {
                        DeviceInitBathActivity.this.dismissDialog();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        if (DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                            if (!DeviceInitBathActivity.this.mIsBLEMode) {
                                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "该通道不支持初始化功能，请点击帮助按钮切换通道再试");
                                return;
                            } else if (DeviceInitBathActivity.this.mF5Data.length() == 68) {
                                InitDeviceTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mDeviceHexID);
                                return;
                            } else {
                                InitDeviceNewTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mWalletModel, DeviceInitBathActivity.this.mDeviceHexID);
                                return;
                            }
                        }
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "此设备无对应的应用,请联系维修人员->" + ((int) sBytesToInt2));
                        return;
                    }
                    if (str.length() == 68) {
                        DeviceInitBathActivity.this.getDeviceInfo();
                        return;
                    } else {
                        DeviceInitBathActivity.this.getIsBindRoomStatus();
                        return;
                    }
                }
                LeXiaoTongSDK.getInstance().closeBLE();
                DeviceInitBathActivity.this.dismissDialog();
                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "水控设备连接失败,设备码为空,请检查设备或报修");
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            DeviceInitBathActivity.this.mIsConnected = false;
            if (!DeviceInitBathActivity.this.mIsEnable || DeviceInitBathActivity.this.mCurrentBluetoothState == State.senddata || DeviceInitBathActivity.this.mCurrentBluetoothState == State.scaning || DeviceInitBathActivity.this.mCurrentBluetoothState == State.scanend) {
                return;
            }
            DeviceInitBathActivity.this.dismissDialog();
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
            if (timeOut == TimeOut.SendOpenGetDeviceSettingCommand) {
                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), str);
                return;
            }
            if (timeOut == TimeOut.SendAA) {
                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), str);
                return;
            }
            if (timeOut == TimeOut.SendNewCommand) {
                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), str);
                return;
            }
            if (!DeviceInitBathActivity.this.mIsBLEMode) {
                if (DeviceInitBathActivity.this.mBluetoothDevice.rssi > -85) {
                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), str);
                    return;
                } else {
                    new ConnectDeviceFailDialog().showTipDialog(DeviceInitBathActivity.this.getActivity(), new ConnectDeviceFailDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.2
                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onMoreHelp() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onQiehuan() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onConnect() {
                            DeviceInitBathActivity.this.mConnectCount = 0;
                            DeviceInitBathActivity.this.showDialog();
                            if (DeviceInitBathActivity.this.mMaterialDialog != null) {
                                DeviceInitBathActivity.this.mMaterialDialog.setContent("正在匹配蓝牙...");
                            }
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DeviceInitBathActivity.this.openDevice();
                                }
                            }, 800L);
                        }
                    }, DeviceInitBathActivity.this.mBluetoothDevice.rssi, false);
                    return;
                }
            }
            new ConnectDeviceFailDialog().showTipDialog(DeviceInitBathActivity.this.getActivity(), new ConnectDeviceFailDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.1
                @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                public void onMoreHelp() {
                }

                @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                public void onConnect() {
                    DeviceInitBathActivity.this.mConnectCount = 0;
                    DeviceInitBathActivity.this.showDialog();
                    if (DeviceInitBathActivity.this.mMaterialDialog != null) {
                        DeviceInitBathActivity.this.mMaterialDialog.setContent("正在匹配蓝牙...");
                    }
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DeviceInitBathActivity.this.openDevice();
                        }
                    }, 800L);
                }

                @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                public void onQiehuan() {
                    DeviceInitBathActivity.this.stopScan();
                    DeviceInitBathActivity.this.mIsBLEMode = false;
                    client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DeviceInitBathActivity.this.mBluetoothDevices.clear();
                            DeviceInitBathActivity.this.mDevicesAdapter.notifyDataSetChanged();
                            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceInitBathActivity.this.mScanListener, false);
                        }
                    }, 500L);
                }
            }, DeviceInitBathActivity.this.mBluetoothDevice.rssi, false);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onBluetoothException(ClientException clientException) {
            DeviceInitBathActivity.this.mIsConnected = false;
            if (!DeviceInitBathActivity.this.mIsEnable || DeviceInitBathActivity.this.mCurrentBluetoothState == State.senddata) {
                return;
            }
            if (!clientException.getDetail().equals("蓝牙信号不稳定") || DeviceInitBathActivity.this.mConnectCount >= 3) {
                DeviceInitBathActivity.this.dismissDialog();
                if (DeviceInitBathActivity.this.mIsBLEMode) {
                    new ConnectDeviceFailDialog().showTipDialog(DeviceInitBathActivity.this.getActivity(), new ConnectDeviceFailDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.4
                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onMoreHelp() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onConnect() {
                            DeviceInitBathActivity.this.mConnectCount = 0;
                            DeviceInitBathActivity.this.showDialog();
                            if (DeviceInitBathActivity.this.mMaterialDialog != null) {
                                DeviceInitBathActivity.this.mMaterialDialog.setContent("正在匹配蓝牙...");
                            }
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DeviceInitBathActivity.this.openDevice();
                                }
                            }, 800L);
                        }

                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onQiehuan() {
                            DeviceInitBathActivity.this.stopScan();
                            DeviceInitBathActivity.this.mIsBLEMode = false;
                            client.android.yixiaotong.sdk.utils.executor.MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.4.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    DeviceInitBathActivity.this.mBluetoothDevices.clear();
                                    DeviceInitBathActivity.this.mDevicesAdapter.notifyDataSetChanged();
                                    LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceInitBathActivity.this.mScanListener, false);
                                }
                            }, 500L);
                        }
                    }, DeviceInitBathActivity.this.mBluetoothDevice.rssi, false);
                } else {
                    new ConnectDeviceFailDialog().showTipDialog(DeviceInitBathActivity.this.getActivity(), new ConnectDeviceFailDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.5
                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onMoreHelp() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onQiehuan() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.ConnectDeviceFailDialog.TipDialogListener
                        public void onConnect() {
                            DeviceInitBathActivity.this.mConnectCount = 0;
                            DeviceInitBathActivity.this.showDialog();
                            if (DeviceInitBathActivity.this.mMaterialDialog != null) {
                                DeviceInitBathActivity.this.mMaterialDialog.setContent("正在匹配蓝牙...");
                            }
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.5.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    DeviceInitBathActivity.this.openDevice();
                                }
                            }, 800L);
                        }
                    }, DeviceInitBathActivity.this.mBluetoothDevice.rssi, false);
                }
            } else {
                if (DeviceInitBathActivity.this.mMaterialDialog != null) {
                    DeviceInitBathActivity.this.mMaterialDialog.setContent("正在匹配蓝牙...");
                }
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.4.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DeviceInitBathActivity.this.openDevice();
                    }
                }, 800L);
            }
            DeviceInitBathActivity.access$1508(DeviceInitBathActivity.this);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessV3(BluetoothDevice bluetoothDevice, String str) {
            if (DeviceInitBathActivity.this.mIsEnable) {
                DeviceInitBathActivity.this.mIsConnected = true;
                DeviceInitBathActivity.this.mConnectCount = 3;
                DeviceInitBathActivity.this.mCurrentBluetoothState = State.senddata;
                LocalBusinessStore.saveLastBathVersion(DeviceInitBathActivity.this.getContext(), 1, bluetoothDevice.address, 3);
                if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || str.toUpperCase().equals("A5")) {
                    if (str.toUpperCase().equals("A5")) {
                        DeviceInitBathActivity.this.dismissDialog();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        ToastUtils.show(DeviceInitBathActivity.this.getContext(), "设备忙");
                    } else {
                        DeviceInitBathActivity deviceInitBathActivity = DeviceInitBathActivity.this;
                        deviceInitBathActivity.bathSmallApp(str, deviceInitBathActivity.mBluetoothDevice);
                    }
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessNew(BluetoothDevice bluetoothDevice, String str) {
            Log.e("test", "onConnectSuccessNew");
            if (DeviceInitBathActivity.this.mIsEnable) {
                DeviceInitBathActivity.this.mF0Data = str;
                if (DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                    DeviceInitBathActivity.this.getNBDeviceInfo(str);
                } else {
                    ToastUtils.show(DeviceInitBathActivity.this.getContext(), "暂未开通，敬请期待");
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onGetStudentId(BluetoothDevice bluetoothDevice) {
            if (DeviceInitBathActivity.this.mIsEnable) {
                String str = DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().stId;
                if (StringUtils.isNotEmpty(str)) {
                    return str;
                }
            }
            return "5551C4B8";
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public String onGetAuthDataV4(BluetoothDevice bluetoothDevice) {
            return LocalBusinessStore.getBathKey(DeviceInitBathActivity.this.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openDevice() {
        if (this.mWalletModel.getBalance() > 30000) {
            LeXiaoTongSDK.getInstance().openDevice(this.mBluetoothDevice, this.openListener, getLoginAccount().getUid(), (short) -27680, true);
        } else {
            LeXiaoTongSDK.getInstance().openDevice(this.mBluetoothDevice, this.openListener, getLoginAccount().getUid(), (short) this.mWalletModel.getBalance(), true);
        }
    }

    static class TestComparator implements Comparator<BluetoothDevice> {
        TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
            return bluetoothDevice2.rssi - bluetoothDevice.rssi;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2001) {
            if (i2 == -1) {
                this.mIsOpen = true;
            } else {
                if (i2 != 0) {
                    return;
                }
                this.mIsOpen = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getIsBindRoomStatus() {
        long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
        long bindRoom = PreferenceUtil.getBindRoom(getContext(), "bindRoom" + getLoginAccount().getUid(), 0L);
        if (bindRoom != 0 || getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            getNewDeviceInfo(bindRoom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("蓝牙正在配对中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.5
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                }
            }).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        try {
            if (isShowingDialog()) {
                this.mMaterialDialog.dismiss();
                this.mMaterialDialog = null;
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowingDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    private class DevicesAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private DevicesAdapter() {
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return DeviceInitBathActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) DeviceInitBathActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DeviceInitBathActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_new_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BluetoothDevice item = getItem(i);
            if (item != null) {
                if (DeviceInitBathActivity.this.mIsInit) {
                    viewHolder.open.setText("初始设备");
                } else {
                    viewHolder.open.setText("设置参数");
                }
                viewHolder.name.setText(item.name);
                viewHolder.introduce.setText(item.address);
                viewHolder.rssi.setText(item.rssi + "");
                if (item.mIsBond) {
                    viewHolder.name.setTextColor(-11890462);
                    viewHolder.introduce.setTextColor(-11890462);
                    viewHolder.mactext.setTextColor(-11890462);
                } else {
                    viewHolder.name.setTextColor(-14540254);
                    viewHolder.introduce.setTextColor(-6710887);
                    viewHolder.mactext.setTextColor(-6710887);
                }
                if (!DeviceInitBathActivity.this.mIsBLEMode && DeviceInitBathActivity.this.mBluetoothDevice != null && StringUtils.isNotEmpty(DeviceInitBathActivity.this.mBluetoothDevice.address) && (DeviceInitBathActivity.this.mBluetoothDevice.address.substring(3).equals(item.address.substring(3)) || (DeviceInitBathActivity.this.mBluetoothDevice.address.startsWith("00:0E") && DeviceInitBathActivity.this.mBluetoothDevice.address.substring(9).equals(item.address.substring(9))))) {
                    viewHolder.name.setTextColor(SupportMenu.CATEGORY_MASK);
                    viewHolder.introduce.setTextColor(SupportMenu.CATEGORY_MASK);
                    viewHolder.mactext.setTextColor(SupportMenu.CATEGORY_MASK);
                }
            }
            return view;
        }

        class ViewHolder {
            public TextView introduce;
            public TextView mactext;
            public TextView name;
            public TextView open;
            public TextView rssi;

            public ViewHolder(View view) {
                this.mactext = (TextView) view.findViewById(R.id.tv_addresstext);
                this.name = (TextView) view.findViewById(R.id.tv_name);
                this.introduce = (TextView) view.findViewById(R.id.tv_address);
                this.rssi = (TextView) view.findViewById(R.id.rssi);
                this.open = (TextView) view.findViewById(R.id.connect);
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (System.currentTimeMillis() - this.mCurrentTime < 1000) {
            return;
        }
        this.mCurrentTime = System.currentTimeMillis();
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            ToastUtils.show(getContext(), "请检查网络后重试");
            return;
        }
        this.mConnectCount = 0;
        BluetoothDevice item = this.mDevicesAdapter.getItem(i);
        this.mBluetoothDevice = item;
        if (item != null) {
            if (LocalBusinessStore.getConnectCountToday(getContext(), getLoginAccount().getUid()) >= 6 && getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                if (LocalBusinessStore.getConnectDeviceToday(getContext(), this.mBluetoothDevice.address.replace(x.bQ, ""), getLoginAccount().getUid()).equals(this.mBluetoothDevice.address.replace(x.bQ, ""))) {
                    showDialog();
                    this.mImgRefreshDevices.setVisibility(0);
                    LeXiaoTongSDK.getInstance().setMode(this.mIsBLEMode);
                    openDevice();
                    return;
                }
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "一台手机一天只能在三台水控设备上使用");
                return;
            }
            showDialog();
            this.mImgRefreshDevices.setVisibility(0);
            LeXiaoTongSDK.getInstance().setMode(this.mIsBLEMode);
            openDevice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo() {
        BusinessControllers.getInstance().getDeviceInfo(getLoginAccount(), this.mDeviceHexID, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceInitBathActivity.this.mIsEnable && DeviceInitBathActivity.this.isShowingDialog()) {
                    DeviceInitBathActivity.this.mMaterialDialog.setContent("正在获取设备信息..");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                if (!DeviceInitBathActivity.this.mIsEnable || deviceInfoBean == null) {
                    return;
                }
                DeviceInitBathActivity.this.dismissDialog();
                LocalBusinessStore.saveOfflineCount(DeviceInitBathActivity.this.getContext(), 0);
                DeviceInitBathActivity.this.mDeviceAddress = deviceInfoBean.installLocation;
                DeviceInitBathActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                DeviceInitBathActivity deviceInitBathActivity = DeviceInitBathActivity.this;
                deviceInitBathActivity.getDeviceInfoOnComplete(deviceInitBathActivity.mBluetoothDevice.address, deviceInfoBean);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    DeviceInitBathActivity.this.dismissDialog();
                    LeXiaoTongSDK.getInstance().closeBLE();
                    if (clientException.getCode() == 5000 && DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                        if (!DeviceInitBathActivity.this.mIsBLEMode) {
                            SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "该通道不支持初始化功能，请点击帮助按钮切换通道再试");
                            return;
                        } else {
                            InitDeviceTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mDeviceHexID);
                            return;
                        }
                    }
                    if (clientException.getCode() == 5003) {
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "您没有访问此设备的权限,设备号:" + DeviceInitBathActivity.this.mDeviceHexID);
                    } else if (clientException.getCode() == clientException.getLocalCode()) {
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "系统正在维护中，请稍后再试");
                    } else {
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            }
        });
    }

    private void getNewDeviceInfo(long j) {
        BusinessControllers.getInstance().getNewDeviceInfo(getLoginAccount(), this.mDeviceHexID, j, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceInitBathActivity.this.mIsEnable && DeviceInitBathActivity.this.isShowingDialog()) {
                    DeviceInitBathActivity.this.mMaterialDialog.setContent("正在获取设备信息中...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                if (!DeviceInitBathActivity.this.mIsEnable || deviceInfoBean == null) {
                    return;
                }
                DeviceInitBathActivity.this.dismissDialog();
                DeviceInitBathActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                DeviceInitBathActivity.this.mDeviceAddress = deviceInfoBean.installLocation;
                PreferenceUtil.putBingdRoomMac(DeviceInitBathActivity.this.getContext(), "bindRoommac" + DeviceInitBathActivity.this.getLoginAccount().getUid(), DeviceInitBathActivity.this.mBluetoothDevice.address);
                DeviceInitBathActivity deviceInitBathActivity = DeviceInitBathActivity.this;
                deviceInitBathActivity.getDeviceInfoOnComplete(deviceInitBathActivity.mBluetoothDevice.address, deviceInfoBean);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    DeviceInitBathActivity.this.dismissDialog();
                    if (clientException.getCode() == clientException.getLocalCode()) {
                        return;
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    if ((clientException.getCode() == 5000 || clientException.getCode() == 5004) && DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                        if (!DeviceInitBathActivity.this.mIsBLEMode) {
                            SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "该通道不支持初始化功能，请点击帮助按钮切换通道再试");
                            return;
                        }
                        LocalBusinessStore.saveLastConnectBluetoothDeviceMac(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.address);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mDeviceHexID);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceName(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.name);
                        LocalBusinessStore.saveLastConnectIsBLE(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mIsBLEMode);
                        InitDeviceNewTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mWalletModel, DeviceInitBathActivity.this.mDeviceHexID);
                        return;
                    }
                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfoOnComplete(final String str, DeviceInfoBean deviceInfoBean) {
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            if (this.mIsInit) {
                InitDialogTip.getInstance().showTipDialog3(getActivity(), getLoginAccount().getAccountManagetStore().getUserInfo().SchoolName, this.mWalletModel.name, deviceInfoBean.Name, StringUtils.isEmpty(this.mDeviceAddress) ? "无" : this.mDeviceAddress, this.mIsInit, new InitDialogTip.InitDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.8
                    @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                    public void onDismiss() {
                    }

                    @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                    public void onInit() {
                        LocalBusinessStore.saveLastConnectBluetoothDeviceMac(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.address);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mDeviceHexID);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceName(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.name);
                        LocalBusinessStore.saveLastConnectIsBLE(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mIsBLEMode);
                        if (DeviceInitBathActivity.this.mIsBLEMode) {
                            if (DeviceInitBathActivity.this.mF5Data.length() == 68) {
                                InitDeviceTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mDeviceHexID);
                            } else {
                                InitDeviceNewTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mWalletModel, DeviceInitBathActivity.this.mDeviceHexID);
                            }
                            LeXiaoTongSDK.getInstance().closeBLE();
                            return;
                        }
                        LeXiaoTongSDK.getInstance().closeBLE();
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "该通道不支持初始化功能，请点击帮助按钮切换通道再试");
                    }

                    @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                    public void onSet() {
                        LocalBusinessStore.saveLastConnectBluetoothDeviceMac(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.address);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mDeviceHexID);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceName(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.name);
                        LocalBusinessStore.saveLastConnectIsBLE(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mIsBLEMode);
                        if (DeviceInitBathActivity.this.mIsBLEMode) {
                            if (DeviceInitBathActivity.this.mF5Data.length() == 68) {
                                SettingDeviceTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), str, DeviceInitBathActivity.this.mDeviceHexID, 1, DeviceInitBathActivity.this.mF5Data);
                            } else if (DeviceInitBathActivity.this.mF5Data.length() <= 74 || !DeviceInitBathActivity.this.mF5Data.substring(70, 74).equalsIgnoreCase("5631")) {
                                SettingDeviceTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), str, DeviceInitBathActivity.this.mDeviceHexID, 2, DeviceInitBathActivity.this.mF5Data);
                            } else {
                                SetBluetoothDeviceActivity.launch(DeviceInitBathActivity.this.getActivity(), str, DeviceInitBathActivity.this.mDeviceHexID, 2, DeviceInitBathActivity.this.mF5Data);
                            }
                            LeXiaoTongSDK.getInstance().closeBLE();
                            return;
                        }
                        LeXiaoTongSDK.getInstance().closeBLE();
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "该通道不支持设置参数功能，请点击帮助按钮切换通道再试");
                    }

                    @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                    public void onDeviceDetail() {
                        if (DeviceInitBathActivity.this.mIsConnected) {
                            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.address);
                            LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mDeviceHexID);
                            LocalBusinessStore.saveLastConnectBluetoothDeviceName(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mDeviceTypeId, DeviceInitBathActivity.this.mBluetoothDevice.name);
                            LocalBusinessStore.saveLastConnectIsBLE(DeviceInitBathActivity.this.getContext(), DeviceInitBathActivity.this.mIsBLEMode);
                            BathOpenActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mBluetoothDevice.name, DeviceInitBathActivity.this.mConsumptionTimes, DeviceInitBathActivity.this.mDeviceHexID, DeviceInitBathActivity.this.mF5Data);
                        }
                    }

                    @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                    public void onHelpMore() {
                        LeXiaoTongSDK.getInstance().closeBLE();
                    }
                });
                return;
            }
            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(getContext(), this.mDeviceTypeId, this.mBluetoothDevice.address);
            LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(getContext(), this.mDeviceTypeId, this.mDeviceHexID);
            LocalBusinessStore.saveLastConnectBluetoothDeviceName(getContext(), this.mDeviceTypeId, this.mBluetoothDevice.name);
            LocalBusinessStore.saveLastConnectIsBLE(getContext(), this.mIsBLEMode);
            if (!this.mIsBLEMode) {
                LeXiaoTongSDK.getInstance().closeBLE();
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "该通道不支持设置参数功能，请点击帮助按钮切换通道再试");
                return;
            }
            if (this.mF5Data.length() == 68) {
                SettingDeviceTwoActivity.launch(getActivity(), str, this.mDeviceHexID, 1, this.mF5Data);
            } else if (this.mF5Data.length() > 74 && this.mF5Data.substring(70, 74).equalsIgnoreCase("5631")) {
                SetBluetoothDeviceActivity.launch(getActivity(), str, this.mDeviceHexID, 2, this.mF5Data);
            } else {
                SettingDeviceTwoActivity.launch(getActivity(), str, this.mDeviceHexID, 2, this.mF5Data);
            }
            LeXiaoTongSDK.getInstance().closeBLE();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bathSmallApp(String str, BluetoothDevice bluetoothDevice) {
        if (this.mIsInit) {
            getDeviceInfo(str);
            return;
        }
        dismissDialog();
        ToastUtils.show(getContext(), "小程序水控暂不支持设置参数");
        LeXiaoTongSDK.getInstance().closeBLE();
    }

    private void getDeviceInfo(final String str) {
        BusinessControllers.getInstance().getSmpDeviceInfo(getLoginAccount(), str.substring(2, 10), new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceInitBathActivity.this.mIsEnable && DeviceInitBathActivity.this.isShowingDialog()) {
                    DeviceInitBathActivity.this.mMaterialDialog.setContent("正在获取设备信息...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final DeviceInfoBean deviceInfoBean, Object... objArr) {
                if (DeviceInitBathActivity.this.mIsEnable && deviceInfoBean != null && DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                    DeviceInitBathActivity.this.mDeviceAddress = deviceInfoBean.installLocation;
                    DeviceInitBathActivity.this.dismissDialog();
                    InitDialogTip.getInstance().showTipDialog4(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().SchoolName, DeviceInitBathActivity.this.mWalletModel.name, deviceInfoBean.Name, StringUtils.isEmpty(DeviceInitBathActivity.this.mDeviceAddress) ? "无" : DeviceInitBathActivity.this.mDeviceAddress, new InitDialogTip.InitDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.9.1
                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onDismiss() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onSet() {
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onInit() {
                            LocalBusinessStore.saveLastConnectBluetoothDeviceName(DeviceInitBathActivity.this.getContext(), 1, DeviceInitBathActivity.this.mBluetoothDevice.name);
                            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(DeviceInitBathActivity.this.getContext(), 1, DeviceInitBathActivity.this.mBluetoothDevice.address);
                            InitDeviceNewTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mWalletModel, DeviceInitBathActivity.this.mDeviceHexID, str.substring(2, 10));
                            LeXiaoTongSDK.getInstance().closeBLE();
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onDeviceDetail() {
                            DeviceInitBathActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                        }

                        @Override // client.android.yixiaotong.ui.dialog.InitDialogTip.InitDialogListener
                        public void onHelpMore() {
                            LeXiaoTongSDK.getInstance().closeBLE();
                        }
                    });
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    if (clientException.getCode() != 5000 || DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                        DeviceInitBathActivity.this.dismissDialog();
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), clientException.getDetail());
                        LeXiaoTongSDK.getInstance().closeBLE();
                    } else {
                        DeviceInitBathActivity.this.dismissDialog();
                        LocalBusinessStore.saveLastConnectBluetoothDeviceName(DeviceInitBathActivity.this.getContext(), 1, DeviceInitBathActivity.this.mBluetoothDevice.name);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceMac(DeviceInitBathActivity.this.getContext(), 1, DeviceInitBathActivity.this.mBluetoothDevice.address);
                        InitDeviceNewTwoActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mWalletModel, DeviceInitBathActivity.this.mDeviceHexID, str.substring(2, 10));
                        LeXiaoTongSDK.getInstance().closeBLE();
                    }
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNBDeviceInfo(String str) {
        this.mCurrentBluetoothState = State.senddata;
        if (StringUtils.isNotEmpty(str) && str.length() > 40) {
            final String strSubstring = str.substring(22, 38);
            if (strSubstring.equals("0000000000000000")) {
                dismissDialog();
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "生产未给设备授权");
                return;
            }
            String strReceivedResult = BathUtil.receivedResult(str.substring(14, 16), str.substring(4, 6), str.substring(6, 8));
            String strReceivedResult2 = BathUtil.receivedResult(str.substring(16, 18), str.substring(4, 6), str.substring(6, 8));
            final String strReceivedResult3 = BathUtil.receivedResult(str.substring(18, 20), str.substring(4, 6), str.substring(6, 8));
            if (strReceivedResult.equalsIgnoreCase("01")) {
                this.mTypeid = 1;
            }
            if (strReceivedResult.equalsIgnoreCase("02")) {
                this.mTypeid = 6;
            }
            final String binaryString = Integer.toBinaryString(Integer.parseInt(BathUtil.receivedResult(str.substring(20, 22), str.substring(4, 6), str.substring(6, 8)), 16));
            BathUtil.HexStringToInt(strReceivedResult);
            BathUtil.HexStringToInt(strReceivedResult2);
            final String strSubstring2 = str.substring(50, 65);
            BusinessControllers.getInstance().getNBMachineInfo(getLoginAccount(), strSubstring, getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId + "", this.mTypeid, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, new Listener<NBMachineInfo>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.11
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    if (DeviceInitBathActivity.this.mIsEnable && DeviceInitBathActivity.this.isShowingDialog()) {
                        DeviceInitBathActivity.this.mMaterialDialog.setContent("正在获取设备信息....");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, NBMachineInfo nBMachineInfo, Object... objArr) {
                    if (DeviceInitBathActivity.this.mIsEnable) {
                        DeviceInitBathActivity.this.dismissDialog();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        if (DeviceInitBathActivity.this.mIsInit) {
                            String byteString = DeviceInitBathActivity.this.getByteString(binaryString);
                            if (!StringUtils.isNotEmpty(byteString) || byteString.length() < 8) {
                                return;
                            }
                            if (byteString.substring(6, 8).equals("11")) {
                                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备正忙且存在消费数据，无法初始化");
                                return;
                            }
                            if (byteString.substring(7, 8).equals("1")) {
                                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备正忙，无法初始化");
                                return;
                            } else if (byteString.substring(6, 7).equals("1")) {
                                SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备中存在消费数据，无法初始化");
                                return;
                            } else {
                                InitDeviceV1Activity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mBluetoothDevice.name, DeviceInitBathActivity.this.mWalletModel, strSubstring, strReceivedResult3, strSubstring2);
                                DeviceInitBathActivity.this.finish();
                                return;
                            }
                        }
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备未初始化，请初始化再设置参数！");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (DeviceInitBathActivity.this.mIsEnable) {
                        DeviceInitBathActivity.this.dismissDialog();
                        if (clientException.getCode() == 5001) {
                            if (DeviceInitBathActivity.this.mIsInit) {
                                if (clientException.getObject() != null) {
                                    new UnInitDeviceDialog().showTipDialog(DeviceInitBathActivity.this.getActivity(), new AuthDetailDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.11.1
                                        @Override // client.android.yixiaotong.ui.dialog.AuthDetailDialog.TipDialogListener
                                        public void onMoreHelp() {
                                        }

                                        @Override // client.android.yixiaotong.ui.dialog.AuthDetailDialog.TipDialogListener
                                        public void onUnBind() {
                                            DeviceInitBathActivity.this.showDialog();
                                            if (DeviceInitBathActivity.this.isShowingDialog()) {
                                                DeviceInitBathActivity.this.mMaterialDialog.setContent("正在注销设备...");
                                            }
                                            LeXiaoTongSDK.getInstance().onCollectData(DeviceInitBathActivity.this.collectDataListener, DeviceInitBathActivity.this.mBluetoothDevice, true);
                                        }
                                    }, ((NBMachineInfo) clientException.getObject()).installLocation, strSubstring);
                                    return;
                                } else {
                                    DeviceInitBathActivity.this.finish();
                                    return;
                                }
                            }
                            LeXiaoTongSDK.getInstance().closeBLE();
                            DeviceSetNBBathActivity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mWalletModel, DeviceInitBathActivity.this.mF0Data, "", DeviceInitBathActivity.this.mBluetoothDevice.address);
                            DeviceInitBathActivity.this.finish();
                            return;
                        }
                        if (clientException.getCode() == 5014) {
                            LeXiaoTongSDK.getInstance().closeBLE();
                            if (DeviceInitBathActivity.this.mIsInit) {
                                String byteString = DeviceInitBathActivity.this.getByteString(binaryString);
                                if (!StringUtils.isNotEmpty(byteString) || byteString.length() < 8) {
                                    return;
                                }
                                if (byteString.substring(6, 8).equals("11")) {
                                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备正忙且存在消费数据，无法初始化");
                                }
                                if (byteString.substring(7, 8).equals("1")) {
                                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备正忙，无法初始化");
                                    return;
                                } else if (byteString.substring(6, 7).equals("1")) {
                                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备中存在消费数据，无法初始化");
                                    return;
                                } else {
                                    InitDeviceV1Activity.launch(DeviceInitBathActivity.this.getActivity(), DeviceInitBathActivity.this.mBluetoothDevice.address, DeviceInitBathActivity.this.mBluetoothDevice.name, DeviceInitBathActivity.this.mWalletModel, strSubstring, strReceivedResult3, strSubstring2);
                                    DeviceInitBathActivity.this.finish();
                                    return;
                                }
                            }
                            SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设备已注销，请重新初始化再设置参数！");
                            return;
                        }
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.11.2
                            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                            public void onConfirm() {
                                LeXiaoTongSDK.getInstance().closeBLE();
                            }
                        }, clientException.getDetail());
                    }
                }
            });
            return;
        }
        dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void newdeviceUnbind(String str, int i) {
        BusinessControllers.getInstance().postCancelNBMachine(getLoginAccount(), str, getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId + "", i, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceInitBathActivity.this.isShowingDialog()) {
                    DeviceInitBathActivity.this.mMaterialDialog.setContent("正在注销设备");
                }
                LeXiaoTongSDK.getInstance().closeBLE();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    DeviceInitBathActivity.this.dismissDialog();
                    if (successBean == null || successBean.success != 1) {
                        ToastUtils.show(DeviceInitBathActivity.this.getContext(), "注销失败");
                    } else {
                        ToastUtils.show(DeviceInitBathActivity.this.getContext(), "注销成功");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    DeviceInitBathActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void newDeviceUploadOrder(String str, final String str2) {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1 ? 1 : 0;
        if (!StringUtils.isNotEmpty(str) || str.length() <= 24) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        String binaryString = Integer.toBinaryString(Integer.parseInt(str.substring(22, 24), 16));
        for (int i2 = 0; i2 < 8 - binaryString.length(); i2++) {
            sb.append("0");
        }
        sb.append(binaryString);
        if (StringUtils.isNotEmpty(this.mF0Data) && this.mF0Data.length() > 40 && StringUtils.isNotEmpty(str) && str.length() > 70) {
            String strSubstring = this.mF0Data.substring(22, 38);
            if (strSubstring.equals("0000000000000000")) {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "生产未给设备授权");
                return;
            }
            String strReceivedResult = BathUtil.receivedResult(this.mF0Data.substring(14, 16), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
            String strReceivedResult2 = BathUtil.receivedResult(this.mF0Data.substring(16, 18), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
            BathUtil.receivedResult(this.mF0Data.substring(18, 20), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
            BathUtil.receivedResult(this.mF0Data.substring(20, 22), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
            boolean zEqualsIgnoreCase = strReceivedResult.equalsIgnoreCase("02") ? 6 : strReceivedResult.equalsIgnoreCase("01");
            BusinessControllers.getInstance().postBatheAuthAnalysis(getLoginAccount(), zEqualsIgnoreCase ? 1 : 0, i, strSubstring, BathUtil.HexStringToInt(strReceivedResult), BathUtil.HexStringToInt(strReceivedResult2), str.substring(42, 58), str2, str.substring(58, 70), 0, RandomUtil.getRandNumMaxString(6), "1", new Listener<BathUploadOrderNewBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.13
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    DeviceInitBathActivity.this.mIsUploadSuccess = false;
                    if (DeviceInitBathActivity.this.isShowingDialog()) {
                        DeviceInitBathActivity.this.mMaterialDialog.setContent("正在注销设备..");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, BathUploadOrderNewBean bathUploadOrderNewBean, Object... objArr) {
                    String str3;
                    if (DeviceInitBathActivity.this.mIsEnable) {
                        if (bathUploadOrderNewBean == null || !StringUtils.isNotEmpty(bathUploadOrderNewBean.next_open_pos_money) || !StringUtils.isNotEmpty(bathUploadOrderNewBean.next_open_pos_serial)) {
                            DeviceInitBathActivity.this.dismissDialog();
                            DeviceInitBathActivity.this.mCountDownLatch.countDown();
                            ToastUtils.show(DeviceInitBathActivity.this.getContext(), "上传订单失败");
                            return;
                        }
                        DeviceInitBathActivity.this.mIsUploadSuccess = true;
                        if (StringUtils.isNotEmpty(bathUploadOrderNewBean.app_key)) {
                            LocalBusinessStore.saveBathKey(DeviceInitBathActivity.this.getContext(), bathUploadOrderNewBean.app_key);
                        }
                        if (StringUtils.isNotEmpty(bathUploadOrderNewBean.pos_studentid)) {
                            str3 = bathUploadOrderNewBean.pos_studentid;
                        } else {
                            str3 = DeviceInitBathActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().stId;
                        }
                        DeviceInitBathActivity.this.newDeviceAuth(bathUploadOrderNewBean.next_open_pos_serial, bathUploadOrderNewBean.next_open_pos_money, str2, str3);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (DeviceInitBathActivity.this.mIsEnable) {
                        DeviceInitBathActivity.this.dismissDialog();
                        DeviceInitBathActivity.this.mCountDownLatch.countDown();
                        SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
            return;
        }
        if (StringUtils.isNotEmpty(this.mF0Data) && this.mF0Data.length() > 40) {
            newdeviceUnbind(this.mF0Data.substring(22, 38), this.mTypeid);
        } else {
            ToastUtils.show(getContext(), "设备参数异常！");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [client.android.yixiaotong.controller.BusinessControllers] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /* JADX WARN: Type inference failed for: r6v8 */
    public void newDeviceAuth(String str, String str2, String str3, String str4) {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        if (!StringUtils.isNotEmpty(this.mF0Data) || this.mF0Data.length() <= 40) {
            return;
        }
        String strSubstring = this.mF0Data.substring(22, 38);
        if (strSubstring.equals("0000000000000000")) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "生产未给设备授权");
            return;
        }
        String strReceivedResult = BathUtil.receivedResult(this.mF0Data.substring(14, 16), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        String strReceivedResult2 = BathUtil.receivedResult(this.mF0Data.substring(16, 18), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(18, 20), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BusinessControllers.getInstance().postBatheAuth(getLoginAccount(), str4, strReceivedResult.equalsIgnoreCase("02") ? 6 : strReceivedResult.equalsIgnoreCase("01"), i, strSubstring, BathUtil.HexStringToInt(strReceivedResult), BathUtil.HexStringToInt(strReceivedResult2), str3, str2, str, 0, RandomUtil.getRandNumMaxString(6), "1", new Listener<BathAuthNewBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceInitBathActivity.this.isShowingDialog()) {
                    DeviceInitBathActivity.this.mMaterialDialog.setContent("正在注销设备.");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathAuthNewBean bathAuthNewBean, Object... objArr) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    if (bathAuthNewBean == null || !StringUtils.isNotEmpty(bathAuthNewBean.systemdata) || !StringUtils.isNotEmpty(bathAuthNewBean.systemtime)) {
                        DeviceInitBathActivity.this.dismissDialog();
                        ToastUtils.show(DeviceInitBathActivity.this.getContext(), "服务器返回数据异常");
                    } else {
                        LocalBusinessStore.saveBathKey(DeviceInitBathActivity.this.getContext(), bathAuthNewBean.app_key);
                        DeviceInitBathActivity.this.mAuthData = "02" + bathAuthNewBean.systemdata + bathAuthNewBean.systemtime;
                    }
                    DeviceInitBathActivity.this.mCountDownLatch.countDown();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    DeviceInitBathActivity.this.dismissDialog();
                    DeviceInitBathActivity.this.mCountDownLatch.countDown();
                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getByteString(String str) {
        if (!StringUtils.isNotEmpty(str)) {
            return str;
        }
        switch (str.length()) {
            case 1:
                return "0000000" + str;
            case 2:
                return "000000" + str;
            case 3:
                return "00000" + str;
            case 4:
                return "0000" + str;
            case 5:
                return Constant.DEFAULT_CVN2 + str;
            case 6:
                return "00" + str;
            case 7:
                return "0" + str;
            default:
                return str;
        }
    }

    private void getSetData() {
        String strSubstring = this.mF0Data.substring(22, 38);
        String str = this.mF0Data.substring(74, 84) + "00" + this.mF0Data.substring(84, 88) + "01";
        BusinessControllers.getInstance().postDeviceConfiguration(getLoginAccount(), this.mWalletModel.typeId, strSubstring, BathUtil.HexStringToInt(BathUtil.receivedResult(this.mF0Data.substring(14, 16), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8))), BathUtil.HexStringToInt(BathUtil.receivedResult(this.mF0Data.substring(16, 18), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8))), this.mMachineRand, str.toUpperCase(), RandomUtil.getRandNumMaxString(6), "1", new Listener<SetNBDrinkWaterBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.16
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                DeviceInitBathActivity.this.mMaterialDialog.setContent("正在获取参数..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SetNBDrinkWaterBean setNBDrinkWaterBean, Object... objArr) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    if (setNBDrinkWaterBean == null || !StringUtils.isNotEmpty(setNBDrinkWaterBean.systemdata)) {
                        ToastUtils.show(DeviceInitBathActivity.this.getContext(), "获取服务器参数异常");
                    } else {
                        Log.e("test", "授权参数：" + setNBDrinkWaterBean.systemdata);
                        DeviceInitBathActivity.this.sendf07(setNBDrinkWaterBean.systemdata);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    DeviceInitBathActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendf07(String str) {
        LeXiaoTongSDK.getInstance().onSettingV4(new SettingListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceInitBathActivity.17
            @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
            public void onBluetoothException(ClientException clientException) {
            }

            @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
            public void onStart(BluetoothDevice bluetoothDevice) {
            }

            @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
            public void onSuccess(BluetoothDevice bluetoothDevice) {
                String strSubstring = DeviceInitBathActivity.this.mF0Data.substring(22, 38);
                DeviceInitBathActivity deviceInitBathActivity = DeviceInitBathActivity.this;
                deviceInitBathActivity.newdeviceUnbind(strSubstring, deviceInitBathActivity.mTypeid);
            }

            @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
            public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
                if (DeviceInitBathActivity.this.mIsEnable) {
                    if (DeviceInitBathActivity.this.mMaterialDialog != null && DeviceInitBathActivity.this.mMaterialDialog.isShowing()) {
                        DeviceInitBathActivity.this.mMaterialDialog.dismiss();
                    }
                    SystemErrorTip.getInstance().showTipDialog(DeviceInitBathActivity.this.getActivity(), "设置参数失败" + timeOut);
                }
            }
        }, this.mBluetoothDevice, str);
    }
}
