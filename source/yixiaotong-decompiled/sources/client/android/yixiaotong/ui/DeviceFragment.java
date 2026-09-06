package client.android.yixiaotong.ui;

import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.RefundBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.ChangeModeEvent;
import client.android.yixiaotong.event.WalletSyncEvent;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.spp.ClsUtils;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.bluetoothtwo.OpenController;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.qrcodeutil.QrcodeDataUtil;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.alipay.sdk.app.statistic.c;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class DeviceFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private BluetoothDevice mBluetoothDevice;
    private DevicesAdapter mDevicesAdapter;
    private String mId;
    ImageView mImg2;
    ImageView mImgRefreshDevices;
    ImageView mImgResetAddreaa;
    LinearLayout mLinDevice;
    LinearLayout mLinRefund;
    ListView mList;
    private OpenController mOpenController;
    RelativeLayout mRelAddress;
    TitleBar mTitleBar;
    TextView mTvAddress;
    TextView mTvBalance;
    TextView mTvContent;
    TextView mTvContent2;
    TextView mTvDate;
    TextView mTvDate2;
    TextView mTvDate3;
    TextView mTvSetAddress;
    TextView mTvSuccess;
    TextView mTvTime;
    TextView mTvTime2;
    TextView mTvTime3;
    View mVLine2;
    private WalletModel mWalletModel;
    ImageView viewEnd;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean mIsEnable = true;
    private boolean mIsScanAddressDevice = false;
    private boolean mIsBLEMode = true;
    private boolean mIsFromSetSelectAddress = false;
    private List<BathDevicesInfoBean> mBathDevicesInfoList = new ArrayList();
    private long mCurrentTime = 0;
    private AppTipDialog.TipDialogListener tipDialogListener = new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.DeviceFragment.5
        @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
        public void onCanle() {
        }

        @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
        public void onConfirt() {
            DeviceFragment.this.mTvAddress.setText("目前未设置区域，只显示附近设备");
            DeviceFragment.this.mImgResetAddreaa.setVisibility(8);
            DeviceFragment.this.mTvSetAddress.setVisibility(0);
            DeviceFragment.this.mIsScanAddressDevice = false;
            DeviceFragment.this.mId = "";
            LocalBusinessStore.saveLastXiZaoQuYu(DeviceFragment.this.getContext(), DeviceFragment.this.mWalletModel.typeId, "");
            LocalBusinessStore.saveLastXiZaoId(DeviceFragment.this.getContext(), DeviceFragment.this.mWalletModel.typeId, "");
            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceFragment.this.mScanListener, DeviceFragment.this.mIsBLEMode);
        }
    };
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.DeviceFragment.7
        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onBluetoothException(ClientException clientException) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onStart() {
            DeviceFragment.this.mOpenController.startScan();
            DeviceFragment.this.mImgRefreshDevices.setVisibility(8);
            DeviceFragment.this.mBluetoothDevices.clear();
            DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
            Log.e("onStart", "onStart");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (!DeviceFragment.this.mIsBLEMode) {
                if (DeviceFragment.this.mBluetoothDevices.contains(bluetoothDevice) || bluetoothDevice.address.startsWith("00:0E:0B")) {
                    return;
                }
                DeviceFragment.this.mBluetoothDevices.add(bluetoothDevice);
                Collections.sort(DeviceFragment.this.mBluetoothDevices, new TestComparator());
                DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
                return;
            }
            if (DeviceFragment.this.mIsScanAddressDevice) {
                if (DeviceFragment.this.mBathDevicesInfoList.size() <= 0 || DeviceFragment.this.mBluetoothDevices.contains(bluetoothDevice)) {
                    return;
                }
                for (int i = 0; i < DeviceFragment.this.mBathDevicesInfoList.size(); i++) {
                    if (bluetoothDevice.address.replace(x.bQ, "").toUpperCase().equals(((BathDevicesInfoBean) DeviceFragment.this.mBathDevicesInfoList.get(i)).Mac.replace(x.bQ, "").toUpperCase()) && !DeviceFragment.this.mBluetoothDevices.contains(bluetoothDevice)) {
                        DeviceFragment.this.mBluetoothDevices.add(new BluetoothDevice(((BathDevicesInfoBean) DeviceFragment.this.mBathDevicesInfoList.get(i)).machineName, bluetoothDevice.address, bluetoothDevice.rssi));
                        DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
                    }
                }
                return;
            }
            if (DeviceFragment.this.mBluetoothDevices.contains(bluetoothDevice)) {
                return;
            }
            DeviceFragment.this.mBluetoothDevices.add(bluetoothDevice);
            Collections.sort(DeviceFragment.this.mBluetoothDevices, new TestComparator());
            DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onComplete() {
            DeviceFragment.this.mImgRefreshDevices.setVisibility(0);
            if (DeviceFragment.this.mBluetoothDevices.size() == 0 && DeviceFragment.this.mIsEnable && LocalBusinessStore.getDeviceFragmentVisable(DeviceFragment.this.getContext())) {
                ToastUtils.show(DeviceFragment.this.getActivity(), "无法扫描到设备！");
                SystemErrorTip.getInstance().showTipDialog(DeviceFragment.this.getActivity(), "无法扫描到设备，尝试打开定位/GPS再试");
            }
            DeviceFragment.this.mOpenController.stopScan();
        }
    };
    private boolean mIsOpen = true;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: client.android.yixiaotong.ui.DeviceFragment.12
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.e("test", "action:" + action);
            if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                android.bluetooth.BluetoothDevice remoteDevice = BluetoothUtils.getBluetoothAdapter(DeviceFragment.this.getContext()).getRemoteDevice(DeviceFragment.this.mBluetoothDevice.address);
                try {
                    DeviceFragment.this.mReceiver.abortBroadcast();
                    ClsUtils.setPin(remoteDevice.getClass(), remoteDevice, "1234");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
                android.bluetooth.BluetoothDevice remoteDevice2 = BluetoothUtils.getBluetoothAdapter(DeviceFragment.this.getContext()).getRemoteDevice(DeviceFragment.this.mBluetoothDevice.address);
                Log.e("test", remoteDevice2.getBondState() + PPSLabelView.Code);
                int bondState = remoteDevice2.getBondState();
                if (bondState == 10) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(DeviceFragment.this.getActivity(), "配对失败，请重试或者请到手机本地设置中找到设备蓝牙后进行配对，配对成功后返回APP点击配对设备即可连接使用");
                } else {
                    if (bondState != 12) {
                        return;
                    }
                    BaseMaterialDialog.setConnectMaterialDialog("配对完成，开始连接设备");
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.DeviceFragment.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DeviceFragment.this.mOpenController.openDevice();
                        }
                    }, 800L);
                }
            }
        }
    };

    private void initViewNew(View view) {
        this.mRelAddress = (RelativeLayout) view.findViewById(R.id.rel_quyu);
        this.mTitleBar = (TitleBar) view.findViewById(R.id.tb_name);
        this.mList = (ListView) view.findViewById(R.id.recycler_view);
        this.mTvAddress = (TextView) view.findViewById(R.id.tv_quyu);
        this.mTvSetAddress = (TextView) view.findViewById(R.id.tv_setquyu);
        this.mImgResetAddreaa = (ImageView) view.findViewById(R.id.img_reset);
        this.mImgRefreshDevices = (ImageView) view.findViewById(R.id.img_refresh);
        this.mLinRefund = (LinearLayout) view.findViewById(R.id.lin_refund);
        this.mLinDevice = (LinearLayout) view.findViewById(R.id.lin_device);
        this.mTvDate = (TextView) view.findViewById(R.id.tv_date);
        this.mTvTime = (TextView) view.findViewById(R.id.tv_time);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mTvDate2 = (TextView) view.findViewById(R.id.tv_date2);
        this.mTvTime2 = (TextView) view.findViewById(R.id.tv_time2);
        this.mTvDate3 = (TextView) view.findViewById(R.id.tv_date3);
        this.mTvTime3 = (TextView) view.findViewById(R.id.tv_time3);
        this.viewEnd = (ImageView) view.findViewById(R.id.view3);
        this.mImg2 = (ImageView) view.findViewById(R.id.img2);
        this.mTvSuccess = (TextView) view.findViewById(R.id.tv_text3);
        this.mVLine2 = view.findViewById(R.id.view2);
        this.mTvContent = (TextView) view.findViewById(R.id.tv_content);
        this.mTvContent2 = (TextView) view.findViewById(R.id.tv_content2);
    }

    public static DeviceFragment newInstance() {
        return new DeviceFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_device, (ViewGroup) null);
        initViewNew(viewInflate);
        this.mIsBLEMode = true;
        NetworkUtils.isNetwork = true;
        initTitleBar();
        initView();
        EventBus.getDefault().register(this);
        OpenController openController = new OpenController();
        this.mOpenController = openController;
        openController.initData(getActivity(), getLoginAccount(), this.mWalletModel);
        return viewInflate;
    }

    private void initView() {
        this.mList.setOnItemClickListener(this);
        ListView listView = this.mList;
        DevicesAdapter devicesAdapter = new DevicesAdapter();
        this.mDevicesAdapter = devicesAdapter;
        listView.setAdapter((ListAdapter) devicesAdapter);
        this.mTvSetAddress.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DeviceFragment.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(DeviceFragment.this.mIsBLEMode);
                DeviceFragment.this.mBluetoothDevices.clear();
                DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
                DeviceFragment.this.mId = "";
                Intent intent = new Intent(DeviceFragment.this.getActivity(), (Class<?>) SelectAmmeterAddressActivity.class);
                intent.putExtra("from", 0);
                DeviceFragment.this.startActivityForResult(intent, 2);
            }
        });
        this.mImgResetAddreaa.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DeviceFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new AppTipDialog().showTipDialog(DeviceFragment.this.getActivity(), DeviceFragment.this.tipDialogListener, "是否重置区域，重置之后默认显示附近设备", "取消", "重置");
            }
        });
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DeviceFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceFragment.this.mScanListener, DeviceFragment.this.mIsBLEMode);
            }
        });
    }

    private void initData() {
        BusinessControllers.getInstance().getWalletModels(getLoginAccount(), new Listener<List<WalletModel>>() { // from class: client.android.yixiaotong.ui.DeviceFragment.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<WalletModel> list, Object... objArr) {
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).typeId == 1) {
                            DeviceFragment.this.mWalletModel = list.get(i);
                            DeviceFragment.this.mOpenController.setWalletModel(DeviceFragment.this.mWalletModel);
                            if (list.get(i).refund == 1) {
                                DeviceFragment.this.mLinRefund.setVisibility(0);
                                DeviceFragment.this.mLinDevice.setVisibility(8);
                                DeviceFragment.this.refund();
                            } else {
                                DeviceFragment.this.mLinRefund.setVisibility(8);
                                DeviceFragment.this.mLinDevice.setVisibility(0);
                                if (StringUtils.isNotEmpty(LocalBusinessStore.getLastXiZaoQuYu(DeviceFragment.this.getContext(), DeviceFragment.this.mWalletModel.typeId))) {
                                    DeviceFragment deviceFragment = DeviceFragment.this;
                                    deviceFragment.mId = LocalBusinessStore.getLastXiZaoId(deviceFragment.getContext(), DeviceFragment.this.mWalletModel.typeId);
                                    DeviceFragment deviceFragment2 = DeviceFragment.this;
                                    deviceFragment2.initSelectQuYuView(LocalBusinessStore.getLastXiZaoQuYu(deviceFragment2.getContext(), DeviceFragment.this.mWalletModel.typeId));
                                }
                            }
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                SystemErrorTip.getInstance().showTipDialog(DeviceFragment.this.getActivity(), clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initSelectQuYuView(final String str) {
        this.mTvAddress.setText(str);
        this.mTvSetAddress.setVisibility(8);
        this.mImgResetAddreaa.setVisibility(0);
        this.mImgRefreshDevices.setVisibility(8);
        this.mIsScanAddressDevice = true;
        LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener, this.mIsBLEMode);
        this.mBathDevicesInfoList.clear();
        if (this.mWalletModel != null) {
            BusinessControllers.getInstance().GetEquipmentSerialNumbers(getLoginAccount(), this.mId, this.mWalletModel.typeId, new Listener<BathDevicesInfoListBean>() { // from class: client.android.yixiaotong.ui.DeviceFragment.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, BathDevicesInfoListBean bathDevicesInfoListBean, Object... objArr) {
                    if (!DeviceFragment.this.mIsEnable || bathDevicesInfoListBean == null || bathDevicesInfoListBean.objList.size() <= 0) {
                        return;
                    }
                    DeviceFragment.this.mBathDevicesInfoList = bathDevicesInfoListBean.objList;
                    LocalBusinessStore.saveLastXiZaoQuYu(DeviceFragment.this.getContext(), DeviceFragment.this.mWalletModel.typeId, str);
                    LocalBusinessStore.saveLastXiZaoId(DeviceFragment.this.getContext(), DeviceFragment.this.mWalletModel.typeId, DeviceFragment.this.mId);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (DeviceFragment.this.mIsEnable) {
                        LocalBusinessStore.saveLastXiZaoQuYu(DeviceFragment.this.getContext(), DeviceFragment.this.mWalletModel.typeId, "");
                        LocalBusinessStore.saveLastXiZaoId(DeviceFragment.this.getContext(), DeviceFragment.this.mWalletModel.typeId, "");
                        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(DeviceFragment.this.mIsBLEMode);
                        ErrorUtil.onFailResult(DeviceFragment.this.getActivity(), DeviceFragment.this.mTitleBar.getTitleViewContent(), clientException, false);
                    }
                }
            });
        }
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        intentFilter.setPriority(1000);
        intentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
        intentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
        getActivity().registerReceiver(this.mReceiver, intentFilter);
        this.mIsEnable = true;
        this.mOpenController.onResume();
        if (this.mIsFromSetSelectAddress) {
            return;
        }
        this.mTvAddress.setText("目前未设置区域，只显示附近设备");
        this.mImgResetAddreaa.setVisibility(8);
        this.mTvSetAddress.setVisibility(0);
        this.mIsScanAddressDevice = false;
        this.mId = "";
        initData();
        if (BluetoothManager.getInstance().isBluetoothOn() && StringUtils.isEmpty(this.mId) && this.mIsOpen) {
            if (!this.mIsBLEMode) {
                this.mRelAddress.setVisibility(0);
                this.mIsBLEMode = true;
                this.mOpenController.setBLEMode(true);
                this.mBluetoothDevices.clear();
                this.mDevicesAdapter.notifyDataSetChanged();
            }
            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener, this.mIsBLEMode);
        }
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        this.mOpenController.onPause();
        this.mIsFromSetSelectAddress = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        stopScan();
        getActivity().unregisterReceiver(this.mReceiver);
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("查找设备");
        this.mTitleBar.setRightView(R.mipmap.l_qrcode_saomiao);
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.DeviceFragment.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DeviceFragment.this.mWalletModel == null || DeviceFragment.this.mWalletModel.refund == 1) {
                    return;
                }
                DeviceFragment.this.startActivityForResult(new Intent(DeviceFragment.this.getActivity(), (Class<?>) ScanQrcodeOrBarcodeActivity.class).putExtra(c.d, 3), 3);
            }
        });
        this.mTitleBar.setLeftView("帮助");
        this.mTitleBar.setLeftViewTextColor(-14385452);
        this.mTitleBar.setLeftViewOnClick(new AnonymousClass9());
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.DeviceFragment$9, reason: invalid class name */
    class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (DeviceFragment.this.mWalletModel == null || DeviceFragment.this.mWalletModel.refund == 1) {
                return;
            }
            LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(DeviceFragment.this.mIsBLEMode);
            new MaterialDialog.Builder(DeviceFragment.this.getContext()).title("温馨提示").content(!DeviceFragment.this.mIsBLEMode ? "如果经常连接不上洗澡设备，可以更换第一个通道来连接设备" : "如果经常连接不上洗澡设备，可以更换第二个通道来连接设备").positiveText("更换").negativeText("不更换").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.DeviceFragment.9.2
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    if (DeviceFragment.this.mIsBLEMode) {
                        DeviceFragment.this.mRelAddress.setVisibility(8);
                        DeviceFragment.this.mIsBLEMode = false;
                        DeviceFragment.this.mOpenController.setBLEMode(DeviceFragment.this.mIsBLEMode);
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.DeviceFragment.9.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                DeviceFragment.this.mBluetoothDevices.clear();
                                DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
                                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceFragment.this.mScanListener, DeviceFragment.this.mIsBLEMode);
                            }
                        }, 500L);
                        return;
                    }
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.DeviceFragment.9.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DeviceFragment.this.mRelAddress.setVisibility(0);
                            DeviceFragment.this.mIsBLEMode = true;
                            DeviceFragment.this.mOpenController.setBLEMode(DeviceFragment.this.mIsBLEMode);
                            DeviceFragment.this.mBluetoothDevices.clear();
                            DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
                            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceFragment.this.mScanListener, DeviceFragment.this.mIsBLEMode);
                        }
                    }, 300L);
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.DeviceFragment.9.1
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                }
            }).show();
        }
    }

    private void stopScan() {
        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(this.mIsBLEMode);
    }

    static class TestComparator implements Comparator<BluetoothDevice> {
        TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
            return bluetoothDevice2.rssi - bluetoothDevice.rssi;
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2001) {
            if (i2 == -1) {
                this.mIsOpen = true;
                return;
            } else {
                if (i2 != 0) {
                    return;
                }
                this.mIsOpen = false;
                return;
            }
        }
        if (i != 3) {
            if (intent != null) {
                this.mIsFromSetSelectAddress = true;
                String stringExtra = intent.getStringExtra(a.G0);
                this.mId = intent.getStringExtra("id");
                initSelectQuYuView(stringExtra);
                return;
            }
            return;
        }
        if (intent != null) {
            String stringExtra2 = intent.getStringExtra("qrcode");
            if (StringUtils.isNotEmpty(stringExtra2) && stringExtra2.length() > 17) {
                String strSubstring = stringExtra2.substring(0, 17);
                if (!QrcodeDataUtil.macFormat(strSubstring) || !strSubstring.substring(2, 3).equalsIgnoreCase(x.bQ)) {
                    ToastUtils.show(getContext(), "不合法的设备码");
                    return;
                }
                if (!NetworkUtils.isNetworkAvailable(getContext())) {
                    ToastUtils.show(getContext(), "请检查网络后重试");
                    return;
                }
                if (this.mWalletModel == null) {
                    ToastUtils.show(getContext(), "暂不支持使用该设备");
                    return;
                }
                BluetoothDevice bluetoothDevice = new BluetoothDevice(strSubstring, strSubstring, 0);
                this.mBluetoothDevice = bluetoothDevice;
                this.mOpenController.setBluetoothDevice(bluetoothDevice);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.DeviceFragment.10
                    @Override // java.lang.Runnable
                    public void run() {
                        DeviceFragment.this.startOpenDevice();
                    }
                }, 300L);
                return;
            }
            ToastUtils.show(getContext(), "不合法的设备码");
        }
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
            return DeviceFragment.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) DeviceFragment.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(DeviceFragment.this.getContext()).inflate(R.layout.bluetooth_devices_list_new_item, (ViewGroup) null);
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
                if (item.mIsBond) {
                    viewHolder.name.setTextColor(-11890462);
                    viewHolder.introduce.setTextColor(-11890462);
                    viewHolder.mactext.setTextColor(-11890462);
                } else {
                    viewHolder.name.setTextColor(-14540254);
                    viewHolder.introduce.setTextColor(-6710887);
                    viewHolder.mactext.setTextColor(-6710887);
                }
                if (!DeviceFragment.this.mIsBLEMode && DeviceFragment.this.mBluetoothDevice != null && StringUtils.isNotEmpty(DeviceFragment.this.mBluetoothDevice.address) && (DeviceFragment.this.mBluetoothDevice.address.substring(3).equals(item.address.substring(3)) || (DeviceFragment.this.mBluetoothDevice.address.startsWith("00:0E") && DeviceFragment.this.mBluetoothDevice.address.substring(9).equals(item.address.substring(9))))) {
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
            public TextView rssi;

            public ViewHolder(View view) {
                this.mactext = (TextView) view.findViewById(R.id.tv_addresstext);
                this.name = (TextView) view.findViewById(R.id.tv_name);
                this.introduce = (TextView) view.findViewById(R.id.tv_address);
                this.rssi = (TextView) view.findViewById(R.id.rssi);
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
        if (this.mWalletModel == null) {
            ToastUtils.show(getContext(), "暂不支持使用该设备");
            return;
        }
        BluetoothDevice item = this.mDevicesAdapter.getItem(i);
        this.mBluetoothDevice = item;
        this.mOpenController.setBluetoothDevice(item);
        startOpenDevice();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onEventMainThread(WalletSyncEvent walletSyncEvent) {
        if (this.mIsEnable) {
            initData();
        }
    }

    public void onEventMainThread(ChangeModeEvent changeModeEvent) {
        this.mRelAddress.setVisibility(8);
        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(this.mIsBLEMode);
        this.mIsBLEMode = false;
        this.mOpenController.setBLEMode(false);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.DeviceFragment.11
            @Override // java.lang.Runnable
            public void run() {
                DeviceFragment.this.mBluetoothDevices.clear();
                DeviceFragment.this.mDevicesAdapter.notifyDataSetChanged();
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(DeviceFragment.this.mScanListener, false);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOpenDevice() {
        stopScan();
        if (this.mWalletModel.max > this.mWalletModel.getBalance()) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), "余额不足，请充值后再使用");
            return;
        }
        if (this.mBluetoothDevice != null) {
            if (LocalBusinessStore.getConnectCountToday(getContext(), getLoginAccount().getUid()) >= 6 && getLoginAccount().getAccountManagetStore().getUserInfo().UserType != 1) {
                if (LocalBusinessStore.getConnectDeviceToday(getContext(), this.mBluetoothDevice.address.replace(x.bQ, ""), getLoginAccount().getUid()).equals(this.mBluetoothDevice.address.replace(x.bQ, ""))) {
                    BaseMaterialDialog.showMaterialDialog(getActivity(), "开始连接设备.", false);
                    this.mImgRefreshDevices.setVisibility(0);
                    LeXiaoTongSDK.getInstance().setMode(this.mIsBLEMode);
                    this.mOpenController.openDevice();
                    return;
                }
                SystemErrorTip.getInstance().showTipDialog(getActivity(), "一台手机一天只能在三台水控设备上使用");
                return;
            }
            BaseMaterialDialog.showMaterialDialog(getActivity(), "开始连接设备.", false);
            this.mImgRefreshDevices.setVisibility(0);
            LeXiaoTongSDK.getInstance().setMode(this.mIsBLEMode);
            this.mOpenController.openDevice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refund() {
        BusinessControllers.getInstance().getRefundProgress(getLoginAccount(), this.mWalletModel.typeId, new Listener<RefundBean>() { // from class: client.android.yixiaotong.ui.DeviceFragment.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, RefundBean refundBean, Object... objArr) {
                if (!DeviceFragment.this.mIsEnable || refundBean == null) {
                    return;
                }
                if (refundBean.Status == 0) {
                    if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                        DeviceFragment.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                    }
                    DeviceFragment.this.mTvBalance.setText(refundBean.refund + "");
                    return;
                }
                if (refundBean.Status == 1) {
                    if (refundBean.isRefundToAccount == 1) {
                        DeviceFragment.this.mTvBalance.setText(refundBean.refund + "");
                        if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                            DeviceFragment.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                            DeviceFragment.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                        }
                        if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                            DeviceFragment.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                            DeviceFragment.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                        }
                        DeviceFragment.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                        DeviceFragment.this.mTvContent.setVisibility(0);
                        DeviceFragment.this.mTvContent2.setVisibility(0);
                        return;
                    }
                    DeviceFragment.this.mTvBalance.setText(refundBean.refund + "");
                    DeviceFragment.this.mTvSuccess.setVisibility(0);
                    DeviceFragment.this.mTvSuccess.setText("审核成功");
                    if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                        DeviceFragment.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                        DeviceFragment.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                        DeviceFragment.this.mTvDate3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                    }
                    DeviceFragment.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                    DeviceFragment.this.viewEnd.setImageResource(R.mipmap.l_refund_start);
                    DeviceFragment.this.mVLine2.setBackgroundColor(DeviceFragment.this.getResources().getColor(R.color.theme_title_color1));
                    DeviceFragment.this.mTvContent2.setVisibility(0);
                    return;
                }
                if (refundBean.Status == 2) {
                    DeviceFragment.this.mTvSuccess.setVisibility(0);
                    DeviceFragment.this.mTvSuccess.setText("退款失败");
                    DeviceFragment.this.mTvBalance.setText(refundBean.refund + "");
                    if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                        DeviceFragment.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                        DeviceFragment.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                        DeviceFragment.this.mTvDate3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                    }
                    DeviceFragment.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                    DeviceFragment.this.viewEnd.setImageResource(R.mipmap.l_refundfail);
                    DeviceFragment.this.mVLine2.setBackgroundColor(DeviceFragment.this.getResources().getColor(R.color.theme_title_color1));
                    DeviceFragment.this.mTvContent.setVisibility(0);
                    DeviceFragment.this.mTvContent.setText("请前去“充值中心”退款记录查看具体详情");
                    return;
                }
                if (refundBean.Status == 3) {
                    DeviceFragment.this.mTvSuccess.setVisibility(0);
                    if (refundBean.isRefundToAccount == 1) {
                        DeviceFragment.this.mTvSuccess.setText("成功到账");
                        DeviceFragment.this.mTvContent.setVisibility(0);
                        DeviceFragment.this.mTvContent.setText("您提交的退款已成功到账");
                    } else {
                        DeviceFragment.this.mTvSuccess.setText("退款成功");
                        DeviceFragment.this.mTvContent.setVisibility(0);
                        DeviceFragment.this.mTvContent.setText("已退款，请及时关注账户资金变化（约3至7个工作日到账）");
                        DeviceFragment.this.mTvContent2.setVisibility(0);
                    }
                    DeviceFragment.this.mTvBalance.setText(refundBean.refund + "");
                    if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                        DeviceFragment.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                        DeviceFragment.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.refundCompletionTime)) {
                        DeviceFragment.this.mTvDate3.setText(refundBean.refundCompletionTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime3.setText(refundBean.refundCompletionTime.split(PPSLabelView.Code)[1]);
                    }
                    DeviceFragment.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                    DeviceFragment.this.viewEnd.setImageResource(R.mipmap.l_refund_start);
                    DeviceFragment.this.mVLine2.setBackgroundColor(DeviceFragment.this.getResources().getColor(R.color.theme_title_color1));
                    return;
                }
                if (refundBean.Status == 4) {
                    DeviceFragment.this.mTvSuccess.setVisibility(0);
                    DeviceFragment.this.mTvSuccess.setText("退款失败");
                    DeviceFragment.this.mTvBalance.setText(refundBean.refund + "");
                    if (StringUtils.isNotEmpty(refundBean.ApplicationTime)) {
                        DeviceFragment.this.mTvDate.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime.setText(refundBean.ApplicationTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                        DeviceFragment.this.mTvDate2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime2.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                    }
                    if (StringUtils.isNotEmpty(refundBean.RefundTime)) {
                        DeviceFragment.this.mTvDate3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[0]);
                        DeviceFragment.this.mTvTime3.setText(refundBean.RefundTime.split(PPSLabelView.Code)[1]);
                    }
                    DeviceFragment.this.mImg2.setImageResource(R.mipmap.l_refund_start);
                    DeviceFragment.this.viewEnd.setImageResource(R.mipmap.l_refundfail);
                    DeviceFragment.this.mVLine2.setBackgroundColor(DeviceFragment.this.getResources().getColor(R.color.theme_title_color1));
                    DeviceFragment.this.mTvContent.setVisibility(0);
                    DeviceFragment.this.mTvContent.setText("请前去“充值中心”退款记录查看具体详情");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (DeviceFragment.this.mIsEnable) {
                    ErrorUtil.onFailResult(DeviceFragment.this.getActivity(), DeviceFragment.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }
}
