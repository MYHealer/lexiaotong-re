package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
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
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.IntegerUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.BillOrderBean;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.bath.BathAuthBean;
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
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.pay.PayOrderActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothListTwoActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private BluetoothDevice mBluetoothDevice;
    private int mConsumptionTimes;
    private String mDeviceHexID;
    private int mDeviceTypeId;
    private DevicesAdapter mDevicesAdapter;
    private String mF5Data;
    private ListView mList;
    private LoadMoreFooter mLoadMoreFootView;
    private MaterialDialog mMaterialDialog;
    private MaterialDialog mMaterialDialog1;
    private MultiStateView mMultiStateView;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean isScanning = false;
    private boolean mIsConnected = false;
    private boolean mIsConnectSuccess = false;
    private boolean mIsEnable = true;
    private boolean mIsClosing = false;
    private boolean mIsNoTipBLE = false;
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.4
        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onStart() {
            BluetoothListTwoActivity.this.isScanning = true;
            BluetoothListTwoActivity.this.initTitleBarWithStopScan();
            BluetoothListTwoActivity.this.mBluetoothDevices.clear();
            BluetoothListTwoActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (BluetoothListTwoActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                return;
            }
            BluetoothListTwoActivity.this.mMultiStateView.setViewState(0);
            BluetoothListTwoActivity.this.mSwipeRefreshLayout.setRefreshing(false);
            BluetoothListTwoActivity.this.mBluetoothDevices.add(bluetoothDevice);
            Collections.sort(BluetoothListTwoActivity.this.mBluetoothDevices, new TestComparator());
            BluetoothListTwoActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onComplete() {
            BluetoothListTwoActivity.this.isScanning = false;
            BluetoothListTwoActivity.this.initTitleBarWithScan();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onBluetoothException(ClientException clientException) {
            BluetoothListTwoActivity.this.isScanning = false;
            BluetoothListTwoActivity.this.initTitleBarWithScan();
        }
    };
    private OpenListener openListener = new OpenListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.8
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
        public void onConnectSuccess(BluetoothDevice bluetoothDevice, String str) {
            LocalBusinessStore.saveLastBathVersion(BluetoothListTwoActivity.this.getContext(), 1, bluetoothDevice.address, 1);
            if (BluetoothListTwoActivity.this.mIsEnable) {
                if (BluetoothListTwoActivity.this.mMaterialDialog != null) {
                    BluetoothListTwoActivity.this.mMaterialDialog.setContent("蓝牙配对成功...");
                }
                BluetoothListTwoActivity.this.mF5Data = str;
                BluetoothListTwoActivity.this.mIsConnected = true;
                BluetoothListTwoActivity.this.mIsConnectSuccess = true;
                String strSubstring = str.substring(44, 64);
                byte[] bArrHexToBuffer = HexString.hexToBuffer(str.substring(36, 40));
                byte[] bArr = new byte[4];
                System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                short sBytesToInt2 = (short) IntegerUtils.bytesToInt2(bArr, 0);
                BluetoothListTwoActivity.this.mDeviceHexID = strSubstring;
                BluetoothListTwoActivity.this.mDeviceTypeId = sBytesToInt2;
                if (BluetoothListTwoActivity.this.mBluetoothDevice == null || TextUtils.isEmpty(strSubstring)) {
                    BluetoothListTwoActivity.this.dismissDialog();
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "水控设备连接失败,设备码为空,请检查设备或报修");
                    BluetoothListTwoActivity.this.initTitleBarWithStopScan();
                    return;
                }
                if (!NetworkUtils.isNetworkAvailable(BluetoothListTwoActivity.this.getContext())) {
                    BluetoothListTwoActivity.this.dismissDialog();
                    BluetoothListTwoActivity.this.initTitleBarWithStopScan();
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "请检查网络后重试");
                }
                if (sBytesToInt2 != 1) {
                    BluetoothListTwoActivity.this.dismissDialog();
                    if (BluetoothListTwoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                        ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "此设备无对应的应用,请重新初始化->" + ((int) sBytesToInt2));
                        if (BluetoothListTwoActivity.this.mF5Data.length() == 68) {
                            InitDeviceTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mBluetoothDevice.address, BluetoothListTwoActivity.this.mDeviceHexID);
                        } else {
                            InitDeviceNewTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mBluetoothDevice.address, BluetoothListTwoActivity.this.mWalletModel, BluetoothListTwoActivity.this.mDeviceHexID);
                        }
                        BluetoothListTwoActivity.this.initTitleBarWithStopScan();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        BluetoothListTwoActivity.this.finish();
                        return;
                    }
                    BluetoothListTwoActivity.this.initTitleBarWithStopScan();
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "此设备无对应的应用,请联系维修人员->" + ((int) sBytesToInt2));
                    return;
                }
                if (str.length() == 68) {
                    BluetoothListTwoActivity.this.getDeviceInfo();
                } else {
                    BluetoothListTwoActivity.this.getIsBindRoomStatus();
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            BluetoothListTwoActivity.this.mIsConnected = false;
            if (!BluetoothListTwoActivity.this.mIsEnable || BluetoothListTwoActivity.this.mIsNoTipBLE) {
                return;
            }
            BluetoothListTwoActivity.this.dismissDialog();
            if (BluetoothListTwoActivity.this.mMaterialDialog1 != null && BluetoothListTwoActivity.this.mMaterialDialog1.isShowing()) {
                BluetoothListTwoActivity.this.mMaterialDialog1.dismiss();
            }
            ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "水控蓝牙信号不稳定，请靠近水控设备后重试");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onBluetoothException(ClientException clientException) {
            BluetoothListTwoActivity.this.mIsConnected = false;
            if (!BluetoothListTwoActivity.this.mIsEnable || BluetoothListTwoActivity.this.mIsNoTipBLE) {
                return;
            }
            if (BluetoothListTwoActivity.this.mMaterialDialog1 != null && BluetoothListTwoActivity.this.mMaterialDialog1.isShowing()) {
                BluetoothListTwoActivity.this.mMaterialDialog1.dismiss();
            }
            if (!clientException.getDetail().equals("蓝牙信号不稳定") || BluetoothListTwoActivity.this.mIsConnectSuccess) {
                BluetoothListTwoActivity.this.dismissDialog();
                ToastUtils.show(BluetoothListTwoActivity.this.getContext(), clientException.getDetail());
            } else {
                if (BluetoothListTwoActivity.this.mMaterialDialog != null) {
                    BluetoothListTwoActivity.this.mMaterialDialog.setContent("正在匹配蓝牙...");
                }
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        LeXiaoTongSDK.getInstance().openDevice(BluetoothListTwoActivity.this.mBluetoothDevice, BluetoothListTwoActivity.this.openListener, BluetoothListTwoActivity.this.getLoginAccount().getUid(), (short) BluetoothListTwoActivity.this.mWalletModel.getBalance(), true);
                    }
                }, 800L);
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.OpenListener
        public void onConnectSuccessV3(BluetoothDevice bluetoothDevice, String str) {
            BluetoothListTwoActivity.this.mIsConnected = true;
            BluetoothListTwoActivity.this.mIsConnectSuccess = true;
            LocalBusinessStore.saveLastBathVersion(BluetoothListTwoActivity.this.getContext(), 1, bluetoothDevice.address, 3);
            if ((str.startsWith("55") && str.length() == 40 && !str.startsWith("550001")) || str.toUpperCase().equals("A5")) {
                if (str.toUpperCase().equals("A5")) {
                    String lastBathStudentId = LocalBusinessStore.getLastBathStudentId(BluetoothListTwoActivity.this.getContext(), 1);
                    if (StringUtils.isNotEmpty(lastBathStudentId)) {
                        BluetoothListTwoActivity.this.mIsClosing = true;
                        LeXiaoTongSDK.getInstance().sendDataV3("AC" + BathUtil.getStudentId(lastBathStudentId));
                        return;
                    } else {
                        BluetoothListTwoActivity.this.dismissDialog();
                        LeXiaoTongSDK.getInstance().closeBLE();
                        ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "设备忙");
                        return;
                    }
                }
                if (BluetoothListTwoActivity.this.mIsClosing) {
                    BluetoothListTwoActivity.this.mIsClosing = false;
                    BluetoothListTwoActivity.this.uploadOrder(str.substring(2, 10), str);
                } else {
                    BluetoothListTwoActivity bluetoothListTwoActivity = BluetoothListTwoActivity.this;
                    bluetoothListTwoActivity.bathSmallApp(str, bluetoothListTwoActivity.mBluetoothDevice);
                }
            }
        }
    };
    private boolean mIsOpen = true;
    private boolean mIsOfflineUse = false;

    static {
        StubApp.interface11(6535);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BluetoothListTwoActivity.class).putExtra(LocalSqliteHelper.TABLE_NAME_WALLET, walletModel));
        }
    }

    private void initViewNew() {
        this.mSwipeRefreshLayout = (PullRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.mMultiStateView = (MultiStateView) findViewById(R.id.multiStateView);
    }

    private void initFooterView() {
        LoadMoreFooter loadMoreFooter = new LoadMoreFooter(getContext());
        this.mLoadMoreFootView = loadMoreFooter;
        loadMoreFooter.setVisibility(8);
    }

    private void initListener() {
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BluetoothListTwoActivity.this.mMultiStateView.setViewState(3);
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                BluetoothListTwoActivity.this.initTitleBarWithScan();
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothListTwoActivity.this.mScanListener);
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener);
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
        this.mTitleBar.setTitleView("设备列表");
        this.mTitleBar.setLeftView("扫描二维码");
        this.mTitleBar.setLeftViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().closeBLE();
                BluetoothListTwoActivity.this.finish();
            }
        });
        initTitleBarWithScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTitleBarWithScan() {
        this.mTitleBar.setRightView("扫描");
        this.mTitleBar.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!BluetoothListTwoActivity.this.isScanning) {
                    LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothListTwoActivity.this.mScanListener);
                } else {
                    BluetoothListTwoActivity.this.stopScan();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTitleBarWithStopScan() {
        this.mTitleBar.setRightView("停止扫描");
        this.mTitleBar.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BluetoothListTwoActivity.this.initTitleBarWithScan();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopScan() {
        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices();
        this.isScanning = false;
        initTitleBarWithScan();
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
                    this.mIsNoTipBLE = false;
                    showDialog();
                    LeXiaoTongSDK.getInstance().openDevice(this.mBluetoothDevice, this.openListener, getLoginAccount().getUid(), (short) this.mWalletModel.getBalance(), true);
                    return;
                }
                ToastUtils.show(getContext(), "一台手机一天只能在三台水控设备上使用");
                return;
            }
            this.mIsNoTipBLE = false;
            showDialog();
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
        if (i == 2001 && i2 == 0) {
            this.mIsOpen = false;
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getIsBindRoomStatus() {
        long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
        long bindRoom = PreferenceUtil.getBindRoom(getContext(), "bindRoom" + getLoginAccount().getUid(), 0L);
        if (bindRoom != 0 || getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            getNewDeviceInfo(bindRoom);
        } else {
            BusinessControllers.getInstance().ammeterIsBindRoomNew(getLoginAccount(), this.mWalletModel.typeId + "", j + "", new Listener<AmmeterBindingRoom>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.9
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BluetoothListTwoActivity.this.showDialog();
                    BluetoothListTwoActivity.this.mMaterialDialog.setContent("加载中...");
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterBindingRoom ammeterBindingRoom, Object... objArr) {
                    BluetoothListTwoActivity.this.dismissDialog();
                    PreferenceUtil.putBingdRoom(BluetoothListTwoActivity.this.getContext(), "bindRoom" + BluetoothListTwoActivity.this.getLoginAccount().getUid(), ammeterBindingRoom.roomId.longValue());
                    BluetoothListTwoActivity.this.getNewDeviceInfo(ammeterBindingRoom.roomId.longValue());
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    BluetoothListTwoActivity.this.dismissDialog();
                    if (clientException.getCode() == 7503) {
                        SelectAmmeterAddressActivity.launch(BluetoothListTwoActivity.this.getActivity(), 2, BluetoothListTwoActivity.this.mWalletModel);
                    } else {
                        ToastUtils.show(BluetoothListTwoActivity.this.getActivity(), clientException.getDetail());
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    BluetoothListTwoActivity.this.finish();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo() {
        BusinessControllers.getInstance().getDeviceInfo(getLoginAccount(), this.mDeviceHexID, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                BluetoothListTwoActivity.this.dismissDialog();
                LocalBusinessStore.saveOfflineCount(BluetoothListTwoActivity.this.getContext(), 0);
                BluetoothListTwoActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                BluetoothListTwoActivity bluetoothListTwoActivity = BluetoothListTwoActivity.this;
                bluetoothListTwoActivity.getDeviceInfoOnComplete(bluetoothListTwoActivity.mBluetoothDevice.address);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                BluetoothListTwoActivity.this.dismissDialog();
                if (clientException.getCode() == clientException.getLocalCode()) {
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "系统正在维护中，请稍后再试");
                    return;
                }
                if (clientException.getCode() == 5000 && BluetoothListTwoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
                    InitDeviceTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mBluetoothDevice.address, BluetoothListTwoActivity.this.mDeviceHexID);
                    LeXiaoTongSDK.getInstance().closeBLE();
                    BluetoothListTwoActivity.this.finish();
                } else if (clientException.getCode() == 5003) {
                    BluetoothListTwoActivity.this.initTitleBarWithStopScan();
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "您没有访问此设备的权限,设备号:" + BluetoothListTwoActivity.this.mDeviceHexID);
                } else {
                    BluetoothListTwoActivity.this.initTitleBarWithStopScan();
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNewDeviceInfo(long j) {
        this.mIsOfflineUse = true;
        offlineuse(j);
        BusinessControllers.getInstance().getNewDeviceInfo(getLoginAccount(), this.mDeviceHexID, j, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.11
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                BluetoothListTwoActivity.this.mIsOfflineUse = false;
                BluetoothListTwoActivity.this.dismissDialog();
                BluetoothListTwoActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
                PreferenceUtil.putBingdRoomMac(BluetoothListTwoActivity.this.getContext(), "bindRoommac" + BluetoothListTwoActivity.this.getLoginAccount().getUid(), BluetoothListTwoActivity.this.mBluetoothDevice.address);
                BluetoothListTwoActivity bluetoothListTwoActivity = BluetoothListTwoActivity.this;
                bluetoothListTwoActivity.getDeviceInfoOnComplete(bluetoothListTwoActivity.mBluetoothDevice.address);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                BluetoothListTwoActivity.this.dismissDialog();
                if (clientException.getCode() == clientException.getLocalCode()) {
                    return;
                }
                BluetoothListTwoActivity.this.mIsOfflineUse = false;
                if (clientException.getCode() != 5004 || BluetoothListTwoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), clientException.getDetail());
                    return;
                }
                LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.address);
                LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mDeviceHexID);
                LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                InitDeviceNewTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mBluetoothDevice.address, BluetoothListTwoActivity.this.mWalletModel, BluetoothListTwoActivity.this.mDeviceHexID);
                LeXiaoTongSDK.getInstance().closeBLE();
                BluetoothListTwoActivity.this.finish();
            }
        });
    }

    private void offlineuse(final long j) {
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.12
            @Override // java.lang.Runnable
            public void run() {
                if (BluetoothListTwoActivity.this.mIsOfflineUse) {
                    NetworkUtils.isNetwork = false;
                    BusinessControllers.getInstance().getRelationWallet(BluetoothListTwoActivity.this.getLoginAccount(), BluetoothListTwoActivity.this.mDeviceTypeId, new Listener<WalletModel>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.12.1
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, WalletModel walletModel, Object... objArr) {
                            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.address);
                            LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mDeviceHexID);
                            LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                            if (j != 0) {
                                if ((!BluetoothListTwoActivity.this.mIsConnected || !PreferenceUtil.getBindRoomMac(BluetoothListTwoActivity.this.getContext(), "bindRoommac" + BluetoothListTwoActivity.this.getLoginAccount().getUid(), "0").equals(BluetoothListTwoActivity.this.mBluetoothDevice.address)) && BluetoothListTwoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "请使用绑定房间的水控设备");
                                    return;
                                } else {
                                    BluetoothListTwoActivity.this.finish();
                                    return;
                                }
                            }
                            ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "未绑定房间，无法使用设备");
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                            BluetoothListTwoActivity.this.initTitleBarWithStopScan();
                            ToastUtils.show(BluetoothListTwoActivity.this.getContext(), clientException.getDetail());
                        }
                    });
                }
            }
        }, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfoOnComplete(final String str) {
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            this.mMaterialDialog1 = new MaterialDialog.Builder(getContext()).title("选项").content("请选择您要做的操作").positiveText("设备详情").positiveText("设备详情").negativeText("设备初始化").neutralText("参数设置").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.15
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    if (BluetoothListTwoActivity.this.mIsConnected) {
                        LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.address);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mDeviceHexID);
                        LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                        BluetoothListTwoActivity.this.finish();
                    }
                }
            }).onNeutral(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.14
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.address);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mDeviceHexID);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                    if (BluetoothListTwoActivity.this.mF5Data.length() == 68) {
                        SettingDeviceTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), str, BluetoothListTwoActivity.this.mDeviceHexID, 1);
                    } else {
                        SettingDeviceTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), str, BluetoothListTwoActivity.this.mDeviceHexID, 2);
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    BluetoothListTwoActivity.this.finish();
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.13
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.address);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mDeviceHexID);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), BluetoothListTwoActivity.this.mDeviceTypeId, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                    if (BluetoothListTwoActivity.this.mF5Data.length() == 68) {
                        InitDeviceTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mBluetoothDevice.address, BluetoothListTwoActivity.this.mDeviceHexID);
                    } else {
                        InitDeviceNewTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mBluetoothDevice.address, BluetoothListTwoActivity.this.mWalletModel, BluetoothListTwoActivity.this.mDeviceHexID);
                    }
                    LeXiaoTongSDK.getInstance().closeBLE();
                    BluetoothListTwoActivity.this.finish();
                }
            }).show();
        } else if (this.mIsConnected) {
            LocalBusinessStore.saveLastConnectBluetoothDeviceMac(getContext(), this.mDeviceTypeId, this.mBluetoothDevice.address);
            LocalBusinessStore.saveLastConnectBluetoothDeviceHexId(getContext(), this.mDeviceTypeId, this.mDeviceHexID);
            LocalBusinessStore.saveLastConnectBluetoothDeviceName(getContext(), this.mDeviceTypeId, this.mBluetoothDevice.name);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("蓝牙正在配对中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.16
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
            return BluetoothListTwoActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) BluetoothListTwoActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BluetoothListTwoActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_item, (ViewGroup) null);
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
            public TextView rssi;

            public ViewHolder(View view) {
                this.name = (TextView) view.findViewById(R.id.name);
                this.introduce = (TextView) view.findViewById(R.id.introduce);
                this.rssi = (TextView) view.findViewById(R.id.rssi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uploadOrder(String str, String str2) {
        int i = getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1 ? 0 : 1;
        BusinessControllers.getInstance().postBathUploadOrder(getLoginAccount(), i, str, str2, 1, RandomUtils.getRandNumMaxStringNonO(6), new Listener<BathUploadOrderBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.17
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathUploadOrderBean bathUploadOrderBean, Object... objArr) {
                BluetoothListTwoActivity.this.dismissDialog();
                if (StringUtils.isNotEmpty(bathUploadOrderBean.pay)) {
                    ArrayList arrayList = new ArrayList();
                    BillOrderBean billOrderBean = new BillOrderBean();
                    billOrderBean.applicationType = BluetoothListTwoActivity.this.mWalletModel.typeId;
                    billOrderBean.consumeAmount = Integer.parseInt(bathUploadOrderBean.pay);
                    billOrderBean.consumeTime = bathUploadOrderBean.settleTime;
                    arrayList.add(billOrderBean);
                    PayOrderActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mWalletModel.typeId, arrayList);
                }
                LeXiaoTongSDK.getInstance().closeBLE();
                BluetoothListTwoActivity.this.finish();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                ToastUtils.show(BluetoothListTwoActivity.this.getContext(), clientException.getDetail());
                BluetoothListTwoActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bathSmallApp(final String str, final BluetoothDevice bluetoothDevice) {
        if (getLoginAccount().getAccountManagetStore().getUserInfo().UserType == 1) {
            this.mMaterialDialog1 = new MaterialDialog.Builder(getContext()).title("选项").content("请选择您要做的操作").positiveText("设备详情").negativeText("设备初始化").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.19
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    BluetoothListTwoActivity.this.getDeviceInfo(str);
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.18
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), 1, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), 1, bluetoothDevice.address);
                    InitDeviceNewTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), bluetoothDevice.address, BluetoothListTwoActivity.this.mWalletModel, BluetoothListTwoActivity.this.mDeviceHexID, str.substring(2, 10));
                    LeXiaoTongSDK.getInstance().closeBLE();
                    BluetoothListTwoActivity.this.finish();
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
        BusinessControllers.getInstance().postBathAuth(getLoginAccount(), i, str, str2, 1, randNumMaxStringNonO, new Listener<BathAuthBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.20
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathAuthBean bathAuthBean, Object... objArr) {
                BluetoothListTwoActivity.this.dismissDialog();
                if (!bathAuthBean.rand.equals(randNumMaxStringNonO) || !StringUtils.isNotEmpty(bathAuthBean.systemData) || !StringUtils.isNotEmpty(bathAuthBean.systemTime)) {
                    BluetoothListTwoActivity.this.mIsNoTipBLE = true;
                    LeXiaoTongSDK.getInstance().closeBLE();
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), "授权数据出错！");
                } else {
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), 1, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), 1, BluetoothListTwoActivity.this.mBluetoothDevice.address);
                    BluetoothListTwoActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                BluetoothListTwoActivity.this.mIsNoTipBLE = true;
                BluetoothListTwoActivity.this.dismissDialog();
                ToastUtils.show(BluetoothListTwoActivity.this.getContext(), clientException.getDetail());
                LeXiaoTongSDK.getInstance().closeBLE();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDeviceInfo(final String str) {
        BusinessControllers.getInstance().getSmpDeviceInfo(getLoginAccount(), str.substring(2, 10), new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoActivity.21
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                BluetoothListTwoActivity.this.bathAuth(str.substring(2, 10), str);
                BluetoothListTwoActivity.this.mConsumptionTimes = deviceInfoBean.ConsumptionTimes;
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                BluetoothListTwoActivity.this.mIsNoTipBLE = true;
                if (clientException.getCode() != 5000 || BluetoothListTwoActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                    BluetoothListTwoActivity.this.dismissDialog();
                    ToastUtils.show(BluetoothListTwoActivity.this.getContext(), clientException.getDetail());
                    LeXiaoTongSDK.getInstance().closeBLE();
                } else {
                    BluetoothListTwoActivity.this.dismissDialog();
                    LocalBusinessStore.saveLastConnectBluetoothDeviceName(BluetoothListTwoActivity.this.getContext(), 1, BluetoothListTwoActivity.this.mBluetoothDevice.name);
                    LocalBusinessStore.saveLastConnectBluetoothDeviceMac(BluetoothListTwoActivity.this.getContext(), 1, BluetoothListTwoActivity.this.mBluetoothDevice.address);
                    InitDeviceNewTwoActivity.launch(BluetoothListTwoActivity.this.getActivity(), BluetoothListTwoActivity.this.mBluetoothDevice.address, BluetoothListTwoActivity.this.mWalletModel, str.substring(2, 10));
                    LeXiaoTongSDK.getInstance().closeBLE();
                    BluetoothListTwoActivity.this.finish();
                }
            }
        });
    }
}
