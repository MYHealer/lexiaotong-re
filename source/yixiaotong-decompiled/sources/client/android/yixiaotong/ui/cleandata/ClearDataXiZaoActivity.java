package client.android.yixiaotong.ui.cleandata;

import android.app.Activity;
import android.app.Dialog;
import android.client.bluetoothsdk.util.HexString;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.DialogInterface;
import android.content.Intent;
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
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.BillOrderBean;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.SoundWaveDrinkWaterCleanData;
import client.android.yixiaotong.controller.bean.bath.BathAuthBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoListBean;
import client.android.yixiaotong.controller.bean.bath.BathUploadOrderBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.OrderBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.OpenListener;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.BathUtil;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.bluetoothtwo.InitDeviceNewTwoActivity;
import client.android.yixiaotong.ui.bluetoothtwo.InitDeviceTwoActivity;
import client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity;
import client.android.yixiaotong.ui.pay.PayOrderActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.zksoundwave.SWCommandUtil;
import client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ClearDataXiZaoActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private BluetoothDevice mBluetoothDevice;
    private int mConsumptionTimes;
    private String mDeviceHexID;
    private int mDeviceTypeId;
    private DevicesAdapter mDevicesAdapter;
    private Dialog mDialog;
    private String mF5Data;
    private String mId;
    private ImageView mImgRefreshDevices;
    private ImageView mImgResetQuYu;
    private boolean mIsClearData;
    private ListView mList;
    private MaterialDialog mMaterialDialog;
    private MaterialDialog mMaterialDialog1;
    private TitleBar mTitleBar;
    private TextView mTvQuYu;
    private TextView mTvSetQuYu;
    private WalletModel mWalletModel;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean isScanning = false;
    private boolean mIsConnected = false;
    private boolean mIsConnectSuccess = false;
    private boolean mIsEnable = true;
    private boolean mIsClosing = false;
    private boolean mIsNoTipBLE = false;
    private boolean mIsScanQuYuDevice = false;
    private String mQuYuMAC = "";
    private String mQuYuDeviceName = "";
    private boolean mIsBLEMode = true;
    private List<BathDevicesInfoBean> mBathDevicesInfoList = new ArrayList();
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.9
        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onStart() {
            ClearDataXiZaoActivity.this.mImgRefreshDevices.setVisibility(8);
            ClearDataXiZaoActivity.this.isScanning = true;
            ClearDataXiZaoActivity.this.mBluetoothDevices.clear();
            ClearDataXiZaoActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (!ClearDataXiZaoActivity.this.mIsBLEMode) {
                ClearDataXiZaoActivity.this.mBluetoothDevices.add(bluetoothDevice);
                ClearDataXiZaoActivity.this.mDevicesAdapter.notifyDataSetChanged();
                return;
            }
            if (ClearDataXiZaoActivity.this.mIsScanQuYuDevice) {
                if (ClearDataXiZaoActivity.this.mBathDevicesInfoList.size() <= 0 || ClearDataXiZaoActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                    return;
                }
                for (int i = 0; i < ClearDataXiZaoActivity.this.mBathDevicesInfoList.size(); i++) {
                    if (bluetoothDevice.address.replace(x.bQ, "").toUpperCase().equals(((BathDevicesInfoBean) ClearDataXiZaoActivity.this.mBathDevicesInfoList.get(i)).Mac.replace(x.bQ, "").toUpperCase())) {
                        ClearDataXiZaoActivity.this.mBluetoothDevices.add(new BluetoothDevice(((BathDevicesInfoBean) ClearDataXiZaoActivity.this.mBathDevicesInfoList.get(i)).machineName, bluetoothDevice.address, bluetoothDevice.rssi));
                        ClearDataXiZaoActivity.this.mDevicesAdapter.notifyDataSetChanged();
                    }
                }
                return;
            }
            if (ClearDataXiZaoActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                return;
            }
            ClearDataXiZaoActivity.this.mBluetoothDevices.add(bluetoothDevice);
            Collections.sort(ClearDataXiZaoActivity.this.mBluetoothDevices, new TestComparator());
            ClearDataXiZaoActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onComplete() {
            ClearDataXiZaoActivity.this.mImgRefreshDevices.setVisibility(0);
            ClearDataXiZaoActivity.this.isScanning = false;
            if (ClearDataXiZaoActivity.this.mIsBLEMode || ClearDataXiZaoActivity.this.mBluetoothDevices.size() != 0) {
                if (ClearDataXiZaoActivity.this.mIsScanQuYuDevice && ClearDataXiZaoActivity.this.mBluetoothDevices.size() == 0) {
                    ToastUtils.show(ClearDataXiZaoActivity.this.getActivity(), "无法扫描到设备！");
                    return;
                }
                return;
            }
            new MaterialDialog.Builder(ClearDataXiZaoActivity.this.getContext()).title("提示").content("无法获取到已经配对设备，请在手机本地《设置》>>《蓝牙》,找到设备后对蓝牙设备进行配对！").positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.9.1
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                }
            }).show();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onBluetoothException(ClientException clientException) {
            ClearDataXiZaoActivity.this.isScanning = false;
        }
    };
    private OpenListener openListener = new OpenListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.11
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
            return null;
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
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectBLESuccess(BluetoothDevice bluetoothDevice) {
            if (ClearDataXiZaoActivity.this.mMaterialDialog != null) {
                ClearDataXiZaoActivity.this.mMaterialDialog.setContent("蓝牙配对成功...");
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccess(BluetoothDevice bluetoothDevice, String str) {
            LocalBusinessStore.saveLastBathVersion(ClearDataXiZaoActivity.this.getContext(), 1, bluetoothDevice.address, 1);
            if (ClearDataXiZaoActivity.this.mIsEnable) {
                ClearDataXiZaoActivity.this.mF5Data = str;
                ClearDataXiZaoActivity.this.mIsConnected = true;
                ClearDataXiZaoActivity.this.mIsConnectSuccess = true;
                String strSubstring = str.substring(44, 64);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(str.substring(36, 40));
                byte[] bArr = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                short sBytesToInt2 = (short) IntegerUtils.bytesToInt2(bArr, 0);
                ClearDataXiZaoActivity.this.mDeviceHexID = strSubstring;
                ClearDataXiZaoActivity.this.mDeviceTypeId = sBytesToInt2;
                if (ClearDataXiZaoActivity.this.mBluetoothDevice == null || TextUtils.isEmpty(strSubstring)) {
                    ClearDataXiZaoActivity.this.dismissDialog();
                    ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "水控设备连接失败,设备码为空,请检查设备或报修");
                    return;
                }
                if (!NetworkUtils.isNetworkAvailable(ClearDataXiZaoActivity.this.getContext())) {
                    ClearDataXiZaoActivity.this.dismissDialog();
                    ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "请检查网络后重试");
                }
                if (sBytesToInt2 != 1) {
                    ClearDataXiZaoActivity.this.dismissDialog();
                    if (ClearDataXiZaoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                        ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "此设备无对应的应用,请重新初始化->" + ((int) sBytesToInt2));
                        if (ClearDataXiZaoActivity.this.mF5Data.length() == 68) {
                            InitDeviceTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mBluetoothDevice.address, ClearDataXiZaoActivity.this.mDeviceHexID);
                        } else {
                            InitDeviceNewTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mBluetoothDevice.address, ClearDataXiZaoActivity.this.mWalletModel, ClearDataXiZaoActivity.this.mDeviceHexID);
                        }
                        LeXiaoTongSDK.getInstance().closeBLE();
                        ClearDataXiZaoActivity.this.finish();
                        return;
                    }
                    ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "此设备无对应的应用,请联系维修人员->" + ((int) sBytesToInt2));
                    return;
                }
                if (str.length() == 68) {
                    ClearDataXiZaoActivity.this.getDeviceInfo();
                } else {
                    ClearDataXiZaoActivity.this.getIsBindRoomStatus();
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            Log.e("test", "onFail；" + timeOut + "  " + str);
            ClearDataXiZaoActivity.this.mIsConnected = false;
            if (!ClearDataXiZaoActivity.this.mIsEnable || ClearDataXiZaoActivity.this.mIsNoTipBLE) {
                return;
            }
            ClearDataXiZaoActivity.this.dismissDialog();
            if (ClearDataXiZaoActivity.this.mMaterialDialog1 != null && ClearDataXiZaoActivity.this.mMaterialDialog1.isShowing()) {
                ClearDataXiZaoActivity.this.mMaterialDialog1.dismiss();
            }
            ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "水控蓝牙信号不稳定，请靠近水控设备后重试");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onBluetoothException(ClientException clientException) {
            Log.e("test", "onFail；" + clientException.getDetail() + "  ");
            ClearDataXiZaoActivity.this.mIsConnected = false;
            if (!ClearDataXiZaoActivity.this.mIsEnable || ClearDataXiZaoActivity.this.mIsNoTipBLE) {
                return;
            }
            if (ClearDataXiZaoActivity.this.mMaterialDialog1 != null && ClearDataXiZaoActivity.this.mMaterialDialog1.isShowing()) {
                ClearDataXiZaoActivity.this.mMaterialDialog1.dismiss();
            }
            if (!clientException.getDetail().equals("蓝牙信号不稳定") || ClearDataXiZaoActivity.this.mIsConnectSuccess) {
                ClearDataXiZaoActivity.this.dismissDialog();
                if (ClearDataXiZaoActivity.this.mMaterialDialog1 != null && ClearDataXiZaoActivity.this.mMaterialDialog1.isShowing()) {
                    ClearDataXiZaoActivity.this.mMaterialDialog1.dismiss();
                }
                ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), clientException.getDetail());
                return;
            }
            if (ClearDataXiZaoActivity.this.mMaterialDialog != null) {
                ClearDataXiZaoActivity.this.mMaterialDialog.setContent("正在匹配蓝牙...");
            }
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.11.1
                @Override // java.lang.Runnable
                public void run() {
                    LeXiaoTongSDK.getInstance().openDevice(ClearDataXiZaoActivity.this.mBluetoothDevice, ClearDataXiZaoActivity.this.openListener, ClearDataXiZaoActivity.this.getLoginAccount().getUid(), (short) ClearDataXiZaoActivity.this.mWalletModel.getBalance(), true);
                }
            }, 800L);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessV3(BluetoothDevice bluetoothDevice, String str) {
            ClearDataXiZaoActivity.this.mIsConnected = true;
            ClearDataXiZaoActivity.this.mIsConnectSuccess = true;
            Log.e("test", "onConnectSuccessV3:" + str);
            LocalBusinessStore.saveLastBathVersion(ClearDataXiZaoActivity.this.getContext(), 1, bluetoothDevice.address, 3);
            if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || str.toUpperCase().equals("A5")) {
                if (str.toUpperCase().equals("A5")) {
                    String lastBathStudentId = LocalBusinessStore.getLastBathStudentId(ClearDataXiZaoActivity.this.getContext(), 1);
                    if (StringUtils.isNotEmpty(lastBathStudentId)) {
                        ClearDataXiZaoActivity.this.mIsClosing = true;
                        LeXiaoTongSDK.getInstance().sendDataV3("AC" + BathUtil.getStudentId(lastBathStudentId));
                        return;
                    } else {
                        ClearDataXiZaoActivity.this.dismissDialog();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "设备忙");
                        return;
                    }
                }
                if (ClearDataXiZaoActivity.this.mIsClosing) {
                    ClearDataXiZaoActivity.this.mIsClosing = false;
                    ClearDataXiZaoActivity.this.uploadOrder(str.substring(2, 10), str);
                } else {
                    ClearDataXiZaoActivity.this.dismissDialog();
                    BusinessControllers.getInstance().xiZaoCleanData(ClearDataXiZaoActivity.this.getLoginAccount(), ClearDataXiZaoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId, ClearDataXiZaoActivity.this.mWalletModel.typeId + "", "1", str.substring(2, 10), str, "0", "1", new Listener<SoundWaveDrinkWaterCleanData>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.11.2
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                            try {
                                ClearDataXiZaoActivity.this.mMaterialDialog = new MaterialDialog.Builder(ClearDataXiZaoActivity.this.getActivity()).content("正在请求服务器中,请稍候...").cancelable(false).progress(true, 0).show();
                            } catch (Exception unused) {
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, SoundWaveDrinkWaterCleanData soundWaveDrinkWaterCleanData, Object... objArr) {
                            ClearDataXiZaoActivity.this.mMaterialDialog.dismiss();
                            if (soundWaveDrinkWaterCleanData.type.equals("0")) {
                                ToastUtils.show(ClearDataXiZaoActivity.this.getActivity(), "设备上没有数据");
                                ClearDataXiZaoActivity.this.finish();
                            } else {
                                LeXiaoTongSDK.getInstance().sendDataV3(soundWaveDrinkWaterCleanData.systemdata);
                                client.android.yixiaotong.util.executor.MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.11.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        LeXiaoTongSDK.getInstance().sendDataV3("AA");
                                    }
                                }, 1000L);
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                            ClearDataXiZaoActivity.this.mMaterialDialog.dismiss();
                            ToastUtils.show(ClearDataXiZaoActivity.this.getActivity(), clientException.getDetail());
                            ClearDataXiZaoActivity.this.getActivity().finish();
                        }
                    });
                }
            }
        }
    };
    private boolean mIsOpen = true;
    private boolean mIsOfflineUse = false;

    static {
        StubApp.interface11(6677);
    }

    private void offlineuse(long j) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ClearDataXiZaoActivity.class).putExtra(LocalSqliteHelper.TABLE_NAME_WALLET, walletModel));
        }
    }

    public static void launch(Activity activity, WalletModel walletModel, boolean z) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ClearDataXiZaoActivity.class).putExtra(LocalSqliteHelper.TABLE_NAME_WALLET, walletModel).putExtra("cleardata", z));
        }
    }

    private void initView() {
        ListView listView = (ListView) findViewById(R.id.recycler_view);
        this.mList = listView;
        listView.setOnItemClickListener(this);
        ListView listView2 = this.mList;
        DevicesAdapter devicesAdapter = new DevicesAdapter();
        this.mDevicesAdapter = devicesAdapter;
        listView2.setAdapter((ListAdapter) devicesAdapter);
        this.mTvQuYu = (TextView) findViewById(R.id.tv_quyu);
        this.mTvSetQuYu = (TextView) findViewById(R.id.tv_setquyu);
        this.mImgResetQuYu = (ImageView) findViewById(R.id.img_reset);
        this.mImgRefreshDevices = (ImageView) findViewById(R.id.img_refresh);
        this.mTvSetQuYu.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(ClearDataXiZaoActivity.this.mIsBLEMode);
                ClearDataXiZaoActivity.this.mBluetoothDevices.clear();
                ClearDataXiZaoActivity.this.mDevicesAdapter.notifyDataSetChanged();
                ClearDataXiZaoActivity.this.mId = "";
                SelectAmmeterAddressActivity.launch(ClearDataXiZaoActivity.this.getActivity(), 0);
            }
        });
        this.mImgResetQuYu.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClearDataXiZaoActivity.this.showAlertDialog();
            }
        });
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(ClearDataXiZaoActivity.this.mScanListener, ClearDataXiZaoActivity.this.mIsBLEMode);
            }
        });
    }

    private void initData() {
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.4
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(String str) {
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
            }
        });
        SWCommandUtil.getInstance().initDataManage();
        SWCommandUtil.getInstance().setDataListener(new SoundWaveDataListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.5
            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onQrcodeData(String str, String str2, int i) {
            }

            @Override // client.android.yixiaotong.zksoundwave.soundwavedatamanage.SoundWaveDataListener
            public void onGetQrcodeData(String str) {
                Log.d("--s", str);
                Log.e("test", "onGetQrcodeData:");
                if (!StringUtils.isNotEmpty(str)) {
                    ToastUtils.show(ClearDataXiZaoActivity.this.getActivity(), "数据为空");
                } else {
                    Log.e("清数据", "APP发送授权数据给硬件:" + str);
                    LeXiaoTongSDK.getInstance().sendDataV3(str);
                }
            }
        });
    }

    public void showAlertDialog() {
        Dialog dialog = new Dialog(this, R.style.mydialog);
        this.mDialog = dialog;
        dialog.getWindow();
        View viewInflate = getLayoutInflater().inflate(R.layout.xizao_dialog_tip, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_cancel);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_positive);
        this.mDialog.setContentView(viewInflate);
        textView.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClearDataXiZaoActivity.this.mDialog.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClearDataXiZaoActivity.this.mDialog.dismiss();
                ClearDataXiZaoActivity.this.mTvQuYu.setText("目前未设置区域，只显示附近设备");
                ClearDataXiZaoActivity.this.mImgResetQuYu.setVisibility(8);
                ClearDataXiZaoActivity.this.mTvSetQuYu.setVisibility(0);
                ClearDataXiZaoActivity.this.mIsScanQuYuDevice = false;
                ClearDataXiZaoActivity.this.mId = "";
                LocalBusinessStore.saveLastXiZaoQuYu(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mWalletModel.typeId, "");
                LocalBusinessStore.saveLastXiZaoId(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mWalletModel.typeId, "");
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(ClearDataXiZaoActivity.this.mScanListener, ClearDataXiZaoActivity.this.mIsBLEMode);
            }
        });
        this.mDialog.show();
    }

    private void initSelectQuYuView(final String str) {
        this.mTvQuYu.setText(str);
        this.mTvSetQuYu.setVisibility(8);
        this.mImgResetQuYu.setVisibility(0);
        this.mImgRefreshDevices.setVisibility(8);
        this.mIsScanQuYuDevice = true;
        LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener, this.mIsBLEMode);
        BusinessControllers.getInstance().GetEquipmentSerialNumbers(getLoginAccount(), this.mId, this.mWalletModel.typeId, new Listener<BathDevicesInfoListBean>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                ClearDataXiZaoActivity.this.mQuYuMAC = "";
                ClearDataXiZaoActivity.this.mBathDevicesInfoList.clear();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathDevicesInfoListBean bathDevicesInfoListBean, Object... objArr) {
                if (bathDevicesInfoListBean == null || bathDevicesInfoListBean.objList.size() <= 0) {
                    return;
                }
                ClearDataXiZaoActivity.this.mBathDevicesInfoList = bathDevicesInfoListBean.objList;
                LocalBusinessStore.saveLastXiZaoQuYu(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mWalletModel.typeId, str);
                LocalBusinessStore.saveLastXiZaoId(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mWalletModel.typeId, ClearDataXiZaoActivity.this.mId);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                LocalBusinessStore.saveLastXiZaoQuYu(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mWalletModel.typeId, "");
                LocalBusinessStore.saveLastXiZaoId(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mWalletModel.typeId, "");
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(ClearDataXiZaoActivity.this.mIsBLEMode);
                ToastUtils.show(ClearDataXiZaoActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        if (!BluetoothManager.getInstance().isBluetoothOn()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
        } else {
            if (StringUtils.isNotEmpty(this.mId) || !this.mIsOpen) {
                return;
            }
            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener, this.mIsBLEMode);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("更换设备");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setRightView("帮助");
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new MaterialDialog.Builder(ClearDataXiZaoActivity.this.getContext()).title("温馨提示").content("是否需要更换连接方式来连接设备").positiveText("是").negativeText("否").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.10.2
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(ClearDataXiZaoActivity.this.mIsBLEMode);
                        ClearDataXiZaoActivity.this.mIsBLEMode = false;
                        ClearDataXiZaoActivity.this.mBluetoothDevices.clear();
                        ClearDataXiZaoActivity.this.mDevicesAdapter.notifyDataSetChanged();
                        LeXiaoTongSDK.getInstance().startScanBluetoothDevices(ClearDataXiZaoActivity.this.mScanListener, false);
                    }
                }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.10.1
                    @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                    public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        ClearDataXiZaoActivity.this.mIsBLEMode = true;
                    }
                }).show();
            }
        });
    }

    private void stopScan() {
        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(this.mIsBLEMode);
        this.isScanning = false;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        dismissDialog();
        MaterialDialog materialDialog = this.mMaterialDialog1;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.mMaterialDialog1.dismiss();
        }
        stopScan();
        LeXiaoTongSDK.getInstance().closeBLE();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            ToastUtils.show(getContext(), "请检查网络后重试");
            return;
        }
        this.mBluetoothDevice = this.mDevicesAdapter.getItem(i);
        if (this.mWalletModel.max > this.mWalletModel.getBalance()) {
            ToastUtils.show(getContext(), "余额不足，请充值后再使用");
            return;
        }
        if (this.mBluetoothDevice != null) {
            if (LocalBusinessStore.getConnectCountToday(getContext(), getLoginAccount().getUid()) >= 3 && getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                if (LocalBusinessStore.getConnectDeviceToday(getContext(), this.mBluetoothDevice.address.replace(x.bQ, ""), getLoginAccount().getUid()).equals(this.mBluetoothDevice.address.replace(x.bQ, ""))) {
                    showDialog();
                    this.mImgRefreshDevices.setVisibility(0);
                    LeXiaoTongSDK.getInstance().setMode(this.mIsBLEMode);
                    LeXiaoTongSDK.getInstance().openDevice(this.mBluetoothDevice, this.openListener, getLoginAccount().getUid(), (short) this.mWalletModel.getBalance(), true);
                    return;
                }
                ToastUtils.show(getContext(), "一台手机一天只能在三台水控设备上使用");
                return;
            }
            showDialog();
            this.mImgRefreshDevices.setVisibility(0);
            LeXiaoTongSDK.getInstance().setMode(this.mIsBLEMode);
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
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2001) {
            if (i2 != 0) {
                return;
            }
            this.mIsOpen = false;
            finish();
            return;
        }
        if (intent != null) {
            String stringExtra = intent.getStringExtra(a.G0);
            this.mId = intent.getStringExtra("id");
            initSelectQuYuView(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getIsBindRoomStatus() {
        long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
        long bindRoom = PreferenceUtil.getBindRoom(getContext(), "bindRoom" + getLoginAccount().getUid(), 0L);
        if (bindRoom != 0 || getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            getNewDeviceInfo(bindRoom);
        } else {
            BusinessControllers.getInstance().ammeterIsBindRoomNew(getLoginAccount(), this.mWalletModel.typeId + "", j + "", new Listener<AmmeterBindingRoom>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.12
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    ClearDataXiZaoActivity.this.showDialog();
                    ClearDataXiZaoActivity.this.mMaterialDialog.setContent("加载中...");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterBindingRoom ammeterBindingRoom, Object... objArr) {
                    ClearDataXiZaoActivity.this.dismissDialog();
                    PreferenceUtil.putBingdRoom(ClearDataXiZaoActivity.this.getContext(), "bindRoom" + ClearDataXiZaoActivity.this.getLoginAccount().getUid(), ammeterBindingRoom.roomId.longValue());
                    ClearDataXiZaoActivity.this.getNewDeviceInfo(ammeterBindingRoom.roomId.longValue());
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    ClearDataXiZaoActivity.this.dismissDialog();
                    if (clientException.getCode() == 7503) {
                        SelectAmmeterAddressActivity.launch(ClearDataXiZaoActivity.this.getActivity(), 2, ClearDataXiZaoActivity.this.mWalletModel);
                    } else {
                        ToastUtils.show(ClearDataXiZaoActivity.this.getActivity(), clientException.getDetail());
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ClearDataXiZaoActivity.this.finish();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo() {
        BusinessControllers.getInstance().getDeviceInfo(getLoginAccount(), this.mDeviceHexID, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                ClearDataXiZaoActivity.this.dismissDialog();
                LocalBusinessStore.saveOfflineCount(ClearDataXiZaoActivity.this.getContext(), 0);
                ClearDataXiZaoActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                ClearDataXiZaoActivity clearDataXiZaoActivity = ClearDataXiZaoActivity.this;
                clearDataXiZaoActivity.getDeviceInfoOnComplete(clearDataXiZaoActivity.mBluetoothDevice.address);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                ClearDataXiZaoActivity.this.dismissDialog();
                if (clientException.getCode() <= 0) {
                    ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "不能脱网使用设备");
                    return;
                }
                if (clientException.getCode() == 5000 && ClearDataXiZaoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                    InitDeviceTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mBluetoothDevice.address, ClearDataXiZaoActivity.this.mDeviceHexID);
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ClearDataXiZaoActivity.this.finish();
                } else if (clientException.getCode() == 5003) {
                    ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "您没有访问此设备的权限,设备号:" + ClearDataXiZaoActivity.this.mDeviceHexID);
                } else {
                    ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNewDeviceInfo(long j) {
        this.mIsOfflineUse = true;
        offlineuse(j);
        BusinessControllers.getInstance().getNewDeviceInfo(getLoginAccount(), this.mDeviceHexID, j, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                ClearDataXiZaoActivity.this.mIsOfflineUse = false;
                ClearDataXiZaoActivity.this.dismissDialog();
                ClearDataXiZaoActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                PreferenceUtil.putBingdRoomMac(ClearDataXiZaoActivity.this.getContext(), "bindRoommac" + ClearDataXiZaoActivity.this.getLoginAccount().getUid(), ClearDataXiZaoActivity.this.mBluetoothDevice.address);
                ClearDataXiZaoActivity clearDataXiZaoActivity = ClearDataXiZaoActivity.this;
                clearDataXiZaoActivity.getDeviceInfoOnComplete(clearDataXiZaoActivity.mBluetoothDevice.address);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                ClearDataXiZaoActivity.this.dismissDialog();
                if (clientException.getCode() < 0) {
                    return;
                }
                ClearDataXiZaoActivity.this.mIsOfflineUse = false;
                if ((clientException.getCode() == 5000 || clientException.getCode() == 5004) && ClearDataXiZaoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.address);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mDeviceHexID);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectIsBLE(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mIsBLEMode);
                    InitDeviceNewTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mBluetoothDevice.address, ClearDataXiZaoActivity.this.mWalletModel, ClearDataXiZaoActivity.this.mDeviceHexID);
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ClearDataXiZaoActivity.this.finish();
                    return;
                }
                ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfoOnComplete(final String str) {
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            this.mMaterialDialog1 = new MaterialDialog.Builder(getContext()).title("选项").content("请选择您要做的操作").positiveText("设备详情").positiveText("设备详情").negativeText("设备初始化").neutralText("参数设置").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.17
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    if (ClearDataXiZaoActivity.this.mIsConnected) {
                        LocalBusinessStore.saveLastConnectBluetoothDeviceMac(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.address);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mDeviceHexID);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceName(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.name);
                        LocalBusinessStore.saveLastConnectIsBLE(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mIsBLEMode);
                        ClearDataXiZaoActivity.this.finish();
                    }
                }
            }).onNeutral(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.16
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.address);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mDeviceHexID);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectIsBLE(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mIsBLEMode);
                    if (ClearDataXiZaoActivity.this.mF5Data.length() == 68) {
                        SettingDeviceTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), str, ClearDataXiZaoActivity.this.mDeviceHexID, 1);
                    } else {
                        SettingDeviceTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), str, ClearDataXiZaoActivity.this.mDeviceHexID, 2);
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ClearDataXiZaoActivity.this.finish();
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.15
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.address);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mDeviceHexID);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mDeviceTypeId, ClearDataXiZaoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectIsBLE(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mIsBLEMode);
                    if (ClearDataXiZaoActivity.this.mF5Data.length() == 68) {
                        InitDeviceTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mBluetoothDevice.address, ClearDataXiZaoActivity.this.mDeviceHexID);
                    } else {
                        InitDeviceNewTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mBluetoothDevice.address, ClearDataXiZaoActivity.this.mWalletModel, ClearDataXiZaoActivity.this.mDeviceHexID);
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ClearDataXiZaoActivity.this.finish();
                }
            }).show();
            return;
        }
        if (this.mIsConnected) {
            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(getContext(), this.mDeviceTypeId, this.mBluetoothDevice.address);
            LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(getContext(), this.mDeviceTypeId, this.mDeviceHexID);
            LocalBusinessStore.saveLastConnectBluetoothDeviceName(getContext(), this.mDeviceTypeId, this.mBluetoothDevice.name);
            LocalBusinessStore.saveLastConnectIsBLE(getContext(), this.mIsBLEMode);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrder(String str, String str2) {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        BusinessControllers.getInstance().postBathUploadOrder(getLoginAccount(), i, str, str2, 1, RandomUtils.getRandNumMaxStringNonO(6), new Listener<BathUploadOrderBean>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.18
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathUploadOrderBean bathUploadOrderBean, Object... objArr) {
                ClearDataXiZaoActivity.this.dismissDialog();
                if (StringUtils.isNotEmpty(bathUploadOrderBean.pay)) {
                    ArrayList arrayList = new ArrayList();
                    BillOrderBean billOrderBean = new BillOrderBean();
                    billOrderBean.applicationType = ClearDataXiZaoActivity.this.mWalletModel.typeId;
                    billOrderBean.consumeAmount = Integer.parseInt(bathUploadOrderBean.pay);
                    billOrderBean.consumeTime = bathUploadOrderBean.settleTime;
                    arrayList.add(billOrderBean);
                    PayOrderActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mWalletModel.typeId, arrayList);
                }
                LeXiaoTongSDK.getInstance().closeBLE();
                ClearDataXiZaoActivity.this.finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), clientException.getDetail());
                ClearDataXiZaoActivity.this.finish();
            }
        });
    }

    private void bathSmallApp(final String str, final BluetoothDevice bluetoothDevice) {
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            this.mMaterialDialog1 = new MaterialDialog.Builder(getContext()).title("选项").content("请选择您要做的操作").positiveText("设备详情").negativeText("设备初始化").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.20
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    ClearDataXiZaoActivity.this.getDeviceInfo(str);
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.19
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(ClearDataXiZaoActivity.this.getContext(), 1, ClearDataXiZaoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(ClearDataXiZaoActivity.this.getContext(), 1, bluetoothDevice.address);
                    LocalBusinessStore.saveLastConnectIsBLE(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mIsBLEMode);
                    InitDeviceNewTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), bluetoothDevice.address, ClearDataXiZaoActivity.this.mWalletModel, ClearDataXiZaoActivity.this.mDeviceHexID, str.substring(2, 10));
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ClearDataXiZaoActivity.this.finish();
                }
            }).show();
        } else {
            getDeviceInfo(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bathAuth(String str, String str2) {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().postBathAuth(getLoginAccount(), i, str, str2, 1, randNumMaxStringNonO, new Listener<BathAuthBean>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.21
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathAuthBean bathAuthBean, Object... objArr) {
                ClearDataXiZaoActivity.this.dismissDialog();
                if (bathAuthBean.rand.equals(randNumMaxStringNonO) && StringUtils.isNotEmpty(bathAuthBean.systemData) && StringUtils.isNotEmpty(bathAuthBean.systemTime)) {
                    ClearDataXiZaoActivity.this.mIsNoTipBLE = true;
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(ClearDataXiZaoActivity.this.getContext(), 1, ClearDataXiZaoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(ClearDataXiZaoActivity.this.getContext(), 1, ClearDataXiZaoActivity.this.mBluetoothDevice.address);
                    LocalBusinessStore.saveLastConnectIsBLE(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mIsBLEMode);
                    ClearDataXiZaoActivity.this.finish();
                    return;
                }
                LeXiaoTongSDK.getInstance().closeBLE();
                ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), "授权数据出错！");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                ClearDataXiZaoActivity.this.dismissDialog();
                ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), clientException.getDetail());
                LeXiaoTongSDK.getInstance().closeBLE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(final String str) {
        BusinessControllers.getInstance().getSmpDeviceInfo(getLoginAccount(), str.substring(2, 10), new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.22
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                ClearDataXiZaoActivity.this.bathAuth(str.substring(2, 10), str);
                ClearDataXiZaoActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (clientException.getCode() != 5000 || ClearDataXiZaoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                    ClearDataXiZaoActivity.this.dismissDialog();
                    ToastUtils.show(ClearDataXiZaoActivity.this.getContext(), clientException.getDetail());
                    LeXiaoTongSDK.getInstance().closeBLE();
                    return;
                }
                ClearDataXiZaoActivity.this.mIsNoTipBLE = true;
                ClearDataXiZaoActivity.this.dismissDialog();
                LocalBusinessStore.saveLastConnectBluetoothDeviceName(ClearDataXiZaoActivity.this.getContext(), 1, ClearDataXiZaoActivity.this.mBluetoothDevice.name);
                LocalBusinessStore.saveLastConnectBluetoothDeviceMac(ClearDataXiZaoActivity.this.getContext(), 1, ClearDataXiZaoActivity.this.mBluetoothDevice.address);
                InitDeviceNewTwoActivity.launch(ClearDataXiZaoActivity.this.getActivity(), ClearDataXiZaoActivity.this.mBluetoothDevice.address, ClearDataXiZaoActivity.this.mWalletModel, str.substring(2, 10));
                LocalBusinessStore.saveLastConnectIsBLE(ClearDataXiZaoActivity.this.getContext(), ClearDataXiZaoActivity.this.mIsBLEMode);
                LeXiaoTongSDK.getInstance().closeBLE();
                ClearDataXiZaoActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("蓝牙正在配对中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.cleandata.ClearDataXiZaoActivity.23
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

    private boolean isShowingDialog() {
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
            return ClearDataXiZaoActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) ClearDataXiZaoActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(ClearDataXiZaoActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_new_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BluetoothDevice item = getItem(i);
            if (item != null) {
                viewHolder.name.setText(item.name);
                viewHolder.introduce.setText(item.address);
                viewHolder.rssi.setText(item.rssi + "");
            }
            return view;
        }

        class ViewHolder {
            public TextView introduce;
            public TextView name;
            public TextView open;
            public TextView rssi;

            public ViewHolder(View view) {
                this.name = (TextView) view.findViewById(R.id.tv_name);
                this.introduce = (TextView) view.findViewById(R.id.tv_address);
                this.rssi = (TextView) view.findViewById(R.id.rssi);
                this.open = (TextView) view.findViewById(R.id.connect);
            }
        }
    }
}
