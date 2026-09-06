package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.client.bluetoothsdk.util.executor.MainThreadExecutor;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoBean;
import client.android.yixiaotong.controller.bean.bath.BathDevicesInfoListBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.controller.error.ErrorUtil;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.event.ChangeModeEvent;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.bluetooth.spp.ClsUtils;
import client.android.yixiaotong.sdk.bluetooth.utils.BluetoothUtils;
import client.android.yixiaotong.sdk.runnable.listener.ScanListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
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
import com.stub.StubApp;
import de.greenrobot.event.EventBus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BluetoothListTwoNewActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private BluetoothDevice mBluetoothDevice;
    private DevicesAdapter mDevicesAdapter;
    private String mId;
    private ImageView mImgRefreshDevices;
    private ImageView mImgResetQuYu;
    private ListView mList;
    private OpenController mOpenController;
    private RelativeLayout mRelQuyu;
    private TitleBar mTitleBar;
    private TextView mTvQuYu;
    private TextView mTvSetQuYu;
    private WalletModel mWalletModel;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean mIsEnable = true;
    private boolean mIsScanQuYuDevice = false;
    private boolean mIsBLEMode = true;
    private List<BathDevicesInfoBean> mBathDevicesInfoList = new ArrayList();
    private long mCurrentTime = 0;
    private AppTipDialog.TipDialogListener tipDialogListener = new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.4
        @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
        public void onCanle() {
        }

        @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
        public void onConfirt() {
            BluetoothListTwoNewActivity.this.mTvQuYu.setText("目前未设置区域，只显示附近设备");
            BluetoothListTwoNewActivity.this.mImgResetQuYu.setVisibility(8);
            BluetoothListTwoNewActivity.this.mTvSetQuYu.setVisibility(0);
            BluetoothListTwoNewActivity.this.mIsScanQuYuDevice = false;
            BluetoothListTwoNewActivity.this.mId = "";
            LocalBusinessStore.saveLastXiZaoQuYu(BluetoothListTwoNewActivity.this.getContext(), BluetoothListTwoNewActivity.this.mWalletModel.typeId, "");
            LocalBusinessStore.saveLastXiZaoId(BluetoothListTwoNewActivity.this.getContext(), BluetoothListTwoNewActivity.this.mWalletModel.typeId, "");
            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothListTwoNewActivity.this.mScanListener, BluetoothListTwoNewActivity.this.mIsBLEMode);
        }
    };
    private ScanListener mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.6
        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onBluetoothException(ClientException clientException) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onStart() {
            BluetoothListTwoNewActivity.this.mOpenController.startScan();
            BluetoothListTwoNewActivity.this.mImgRefreshDevices.setVisibility(8);
            BluetoothListTwoNewActivity.this.mBluetoothDevices.clear();
            BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onScan(BluetoothDevice bluetoothDevice) {
            if (!BluetoothListTwoNewActivity.this.mIsBLEMode) {
                if (BluetoothListTwoNewActivity.this.mBluetoothDevices.contains(bluetoothDevice) || bluetoothDevice.address.startsWith("00:0E:0B")) {
                    return;
                }
                BluetoothListTwoNewActivity.this.mBluetoothDevices.add(bluetoothDevice);
                Collections.sort(BluetoothListTwoNewActivity.this.mBluetoothDevices, new TestComparator());
                BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
                return;
            }
            if (BluetoothListTwoNewActivity.this.mIsScanQuYuDevice) {
                if (BluetoothListTwoNewActivity.this.mBathDevicesInfoList.size() <= 0 || BluetoothListTwoNewActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                    return;
                }
                for (int i = 0; i < BluetoothListTwoNewActivity.this.mBathDevicesInfoList.size(); i++) {
                    if (bluetoothDevice.address.replace(x.bQ, "").toUpperCase().equals(((BathDevicesInfoBean) BluetoothListTwoNewActivity.this.mBathDevicesInfoList.get(i)).Mac.replace(x.bQ, "").toUpperCase()) && !BluetoothListTwoNewActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                        BluetoothListTwoNewActivity.this.mBluetoothDevices.add(new BluetoothDevice(((BathDevicesInfoBean) BluetoothListTwoNewActivity.this.mBathDevicesInfoList.get(i)).machineName, bluetoothDevice.address, bluetoothDevice.rssi));
                        BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
                        return;
                    }
                }
                return;
            }
            if (BluetoothListTwoNewActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                return;
            }
            BluetoothListTwoNewActivity.this.mBluetoothDevices.add(bluetoothDevice);
            Collections.sort(BluetoothListTwoNewActivity.this.mBluetoothDevices, new TestComparator());
            BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ScanListener
        public void onComplete() {
            BluetoothListTwoNewActivity.this.mImgRefreshDevices.setVisibility(0);
            if (BluetoothListTwoNewActivity.this.mBluetoothDevices.size() == 0) {
                ToastUtils.show(BluetoothListTwoNewActivity.this.getActivity(), "无法扫描到设备！");
                SystemErrorTip.getInstance().showTipDialog(BluetoothListTwoNewActivity.this.getActivity(), "无法扫描到设备，尝试打开定位/GPS再试");
            }
            BluetoothListTwoNewActivity.this.mOpenController.stopScan();
        }
    };
    private boolean mIsOpen = true;
    private BroadcastReceiver mReceiver = new BroadcastReceiver() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.10
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("android.bluetooth.device.action.PAIRING_REQUEST")) {
                android.bluetooth.BluetoothDevice remoteDevice = BluetoothUtils.getBluetoothAdapter(BluetoothListTwoNewActivity.this.getContext()).getRemoteDevice(BluetoothListTwoNewActivity.this.mBluetoothDevice.address);
                try {
                    BluetoothListTwoNewActivity.this.mReceiver.abortBroadcast();
                    ClsUtils.setPin(remoteDevice.getClass(), remoteDevice, "1234");
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if ("android.bluetooth.device.action.BOND_STATE_CHANGED".equals(action)) {
                android.bluetooth.BluetoothDevice remoteDevice2 = BluetoothUtils.getBluetoothAdapter(BluetoothListTwoNewActivity.this.getContext()).getRemoteDevice(BluetoothListTwoNewActivity.this.mBluetoothDevice.address);
                Log.e("test", remoteDevice2.getBondState() + PPSLabelView.Code);
                int bondState = remoteDevice2.getBondState();
                if (bondState == 10) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    SystemErrorTip.getInstance().showTipDialog(BluetoothListTwoNewActivity.this.getActivity(), "配对失败，请重试或者请到手机本地设置中找到设备蓝牙后进行配对，配对成功后返回APP点击配对设备即可连接使用");
                } else {
                    if (bondState != 12) {
                        return;
                    }
                    BaseMaterialDialog.setConnectMaterialDialog("配对完成，开始连接设备");
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothListTwoNewActivity.this.mOpenController.openDevice();
                        }
                    }, 800L);
                }
            }
        }
    };

    static {
        StubApp.interface11(6555);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BluetoothListTwoNewActivity.class).putExtra(LocalSqliteHelper.TABLE_NAME_WALLET, walletModel));
        }
    }

    private void initViewNew() {
        this.mRelQuyu = (RelativeLayout) findViewById(R.id.rel_quyu);
        this.mList = (ListView) findViewById(R.id.recycler_view);
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvQuYu = (TextView) findViewById(R.id.tv_quyu);
        this.mTvSetQuYu = (TextView) findViewById(R.id.tv_setquyu);
        this.mImgResetQuYu = (ImageView) findViewById(R.id.img_reset);
        this.mImgRefreshDevices = (ImageView) findViewById(R.id.img_refresh);
    }

    private void initView() {
        this.mList.setOnItemClickListener(this);
        ListView listView = this.mList;
        DevicesAdapter devicesAdapter = new DevicesAdapter();
        this.mDevicesAdapter = devicesAdapter;
        listView.setAdapter((ListAdapter) devicesAdapter);
        this.mTvSetQuYu.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(BluetoothListTwoNewActivity.this.mIsBLEMode);
                BluetoothListTwoNewActivity.this.mBluetoothDevices.clear();
                BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
                BluetoothListTwoNewActivity.this.mId = "";
                SelectAmmeterAddressActivity.launch(BluetoothListTwoNewActivity.this.getActivity(), 0);
            }
        });
        this.mImgResetQuYu.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new AppTipDialog().showTipDialog(BluetoothListTwoNewActivity.this.getActivity(), BluetoothListTwoNewActivity.this.tipDialogListener, "是否重置区域，重置之后默认显示附近设备", "取消", "重置");
            }
        });
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothListTwoNewActivity.this.mScanListener, BluetoothListTwoNewActivity.this.mIsBLEMode);
            }
        });
    }

    private void initData() {
        if (StringUtils.isNotEmpty(LocalBusinessStore.getLastXiZaoQuYu(getContext(), this.mWalletModel.typeId))) {
            this.mId = LocalBusinessStore.getLastXiZaoId(getContext(), this.mWalletModel.typeId);
            initSelectQuYuView(LocalBusinessStore.getLastXiZaoQuYu(getContext(), this.mWalletModel.typeId));
        }
    }

    private void initSelectQuYuView(final String str) {
        this.mTvQuYu.setText(str);
        this.mTvSetQuYu.setVisibility(8);
        this.mImgResetQuYu.setVisibility(0);
        this.mImgRefreshDevices.setVisibility(8);
        this.mIsScanQuYuDevice = true;
        LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener, this.mIsBLEMode);
        this.mBathDevicesInfoList.clear();
        BusinessControllers.getInstance().GetEquipmentSerialNumbers(getLoginAccount(), this.mId, this.mWalletModel.typeId, new Listener<BathDevicesInfoListBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, BathDevicesInfoListBean bathDevicesInfoListBean, Object... objArr) {
                if (!BluetoothListTwoNewActivity.this.mIsEnable || bathDevicesInfoListBean == null || bathDevicesInfoListBean.objList.size() <= 0) {
                    return;
                }
                BluetoothListTwoNewActivity.this.mBathDevicesInfoList = bathDevicesInfoListBean.objList;
                LocalBusinessStore.saveLastXiZaoQuYu(BluetoothListTwoNewActivity.this.getContext(), BluetoothListTwoNewActivity.this.mWalletModel.typeId, str);
                LocalBusinessStore.saveLastXiZaoId(BluetoothListTwoNewActivity.this.getContext(), BluetoothListTwoNewActivity.this.mWalletModel.typeId, BluetoothListTwoNewActivity.this.mId);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (BluetoothListTwoNewActivity.this.mIsEnable) {
                    LocalBusinessStore.saveLastXiZaoQuYu(BluetoothListTwoNewActivity.this.getContext(), BluetoothListTwoNewActivity.this.mWalletModel.typeId, "");
                    LocalBusinessStore.saveLastXiZaoId(BluetoothListTwoNewActivity.this.getContext(), BluetoothListTwoNewActivity.this.mWalletModel.typeId, "");
                    LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(BluetoothListTwoNewActivity.this.mIsBLEMode);
                    ErrorUtil.onFailResult(BluetoothListTwoNewActivity.this.getActivity(), BluetoothListTwoNewActivity.this.mTitleBar.getTitleViewContent(), clientException, false);
                }
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        this.mOpenController.onResume();
        if (!BluetoothManager.getInstance().isBluetoothOn()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
        } else if (StringUtils.isEmpty(this.mId) && this.mIsOpen) {
            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(this.mScanListener, this.mIsBLEMode);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
        this.mIsEnable = false;
        this.mOpenController.onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        BaseMaterialDialog.dissmisMaterialDialog();
        stopScan();
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("更换设备");
        this.mTitleBar.setRightView(R.mipmap.l_qrcode_saomiao);
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BluetoothListTwoNewActivity.this.startActivityForResult(new Intent(BluetoothListTwoNewActivity.this.getActivity(), (Class<?>) ScanQrcodeOrBarcodeActivity.class).putExtra(c.d, 3), 3);
            }
        });
        this.mTitleBar.setLeftView("帮助");
        this.mTitleBar.setLeftViewTextColor(-14385452);
        this.mTitleBar.setLeftViewOnClick(new AnonymousClass8());
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity$8, reason: invalid class name */
    class AnonymousClass8 implements View.OnClickListener {
        AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            new MaterialDialog.Builder(BluetoothListTwoNewActivity.this.getContext()).title("温馨提示").content("如果经常连接不上洗澡设备，可以更换第二个通道来连接设备").positiveText("更换").negativeText("不更换").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.8.2
                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                    LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(BluetoothListTwoNewActivity.this.mIsBLEMode);
                    if (BluetoothListTwoNewActivity.this.mIsBLEMode) {
                        BluetoothListTwoNewActivity.this.mRelQuyu.setVisibility(8);
                        BluetoothListTwoNewActivity.this.mIsBLEMode = false;
                        BluetoothListTwoNewActivity.this.mOpenController.setBLEMode(BluetoothListTwoNewActivity.this.mIsBLEMode);
                        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.8.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                BluetoothListTwoNewActivity.this.mBluetoothDevices.clear();
                                BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
                                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothListTwoNewActivity.this.mScanListener, BluetoothListTwoNewActivity.this.mIsBLEMode);
                            }
                        }, 500L);
                        return;
                    }
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.8.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothListTwoNewActivity.this.mRelQuyu.setVisibility(0);
                            BluetoothListTwoNewActivity.this.mIsBLEMode = true;
                            BluetoothListTwoNewActivity.this.mOpenController.setBLEMode(BluetoothListTwoNewActivity.this.mIsBLEMode);
                            BluetoothListTwoNewActivity.this.mBluetoothDevices.clear();
                            BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
                            LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothListTwoNewActivity.this.mScanListener, BluetoothListTwoNewActivity.this.mIsBLEMode);
                        }
                    }, 300L);
                }
            }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.8.1
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2001) {
            if (i2 == -1) {
                this.mIsOpen = true;
                return;
            } else {
                if (i2 != 0) {
                    return;
                }
                this.mIsOpen = false;
                finish();
                return;
            }
        }
        if (i != 3) {
            if (intent != null) {
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
                    ToastUtils.show(getContext(), "请打开网络后重试");
                    return;
                }
                LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(this.mIsBLEMode);
                BluetoothDevice bluetoothDevice = new BluetoothDevice(strSubstring, strSubstring, 0);
                this.mBluetoothDevice = bluetoothDevice;
                this.mOpenController.setBluetoothDevice(bluetoothDevice);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.9
                    @Override // java.lang.Runnable
                    public void run() {
                        BluetoothListTwoNewActivity.this.startOpenDevice();
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
            return BluetoothListTwoNewActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) BluetoothListTwoNewActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(BluetoothListTwoNewActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_new_item, (ViewGroup) null);
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
                if (!BluetoothListTwoNewActivity.this.mIsBLEMode && BluetoothListTwoNewActivity.this.mBluetoothDevice != null && StringUtils.isNotEmpty(BluetoothListTwoNewActivity.this.mBluetoothDevice.address) && (BluetoothListTwoNewActivity.this.mBluetoothDevice.address.substring(3).equals(item.address.substring(3)) || (BluetoothListTwoNewActivity.this.mBluetoothDevice.address.startsWith("00:0E") && BluetoothListTwoNewActivity.this.mBluetoothDevice.address.substring(9).equals(item.address.substring(9))))) {
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
            ToastUtils.show(getContext(), "请打开网络后重试");
            return;
        }
        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(this.mIsBLEMode);
        BluetoothDevice item = this.mDevicesAdapter.getItem(i);
        this.mBluetoothDevice = item;
        this.mOpenController.setBluetoothDevice(item);
        startOpenDevice();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.mReceiver);
        EventBus.getDefault().unregister(this);
    }

    public void onEventMainThread(ChangeModeEvent changeModeEvent) {
        this.mRelQuyu.setVisibility(8);
        LeXiaoTongSDK.getInstance().stopScanBluetoothDevices(this.mIsBLEMode);
        this.mIsBLEMode = false;
        this.mOpenController.setBLEMode(false);
        MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.bluetoothtwo.BluetoothListTwoNewActivity.11
            @Override // java.lang.Runnable
            public void run() {
                BluetoothListTwoNewActivity.this.mBluetoothDevices.clear();
                BluetoothListTwoNewActivity.this.mDevicesAdapter.notifyDataSetChanged();
                LeXiaoTongSDK.getInstance().startScanBluetoothDevices(BluetoothListTwoNewActivity.this.mScanListener, false);
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
}
