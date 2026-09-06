package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
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
import client.android.yixiaotong.controller.db.LocalSqliteHelper;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.LoadMoreFooter;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothDevice;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.bluetooth.CommandUtils;
import client.android.yixiaotong.util.bluetooth.TimeOut;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.view.load.MultiStateView;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashBluetoothList2Activity extends BaseActivity implements AdapterView.OnItemClickListener, BluetoothManager.Listener {
    private String mAddress;
    private BluetoothManager mBluetoothManager;
    private Context mContext;
    TimeOut mCurrentCheckTimeOut;
    private DevicesAdapter mDevicesAdapter;
    private ListView mList;
    private LoadMoreFooter mLoadMoreFootView;
    private MaterialDialog mMaterialDialog;
    MultiStateView mMultiStateView;
    PullRefreshLayout mSwipeRefreshLayout;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean mIsManager = false;
    private int mConnectCount = 0;
    private boolean mIsOpen = true;

    static {
        StubApp.interface11(7664);
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnecting(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) WashBluetoothList2Activity.class).putExtra(LocalSqliteHelper.TABLE_NAME_WALLET, walletModel).putExtra("manager", i));
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
        this.mMultiStateView.getView(1).findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WashBluetoothList2Activity.this.mMultiStateView.setViewState(3);
            }
        });
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.2
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                WashBluetoothList2Activity.this.initTitleBarWithScan();
                WashBluetoothList2Activity.this.mBluetoothManager.stopScan();
                WashBluetoothList2Activity.this.mBluetoothManager.disConnectAll();
                WashBluetoothList2Activity.this.runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (WashBluetoothList2Activity.this.mBluetoothManager.isBluetoothOn()) {
                            WashBluetoothList2Activity.this.mBluetoothManager.disConnectAll();
                            WashBluetoothList2Activity.this.mBluetoothManager.startScan();
                        }
                    }
                }, 1000L);
            }
        });
        this.mLoadMoreFootView.setUseProgressBar(true);
        this.mLoadMoreFootView.setOnClickLoadMoreListener(new LoadMoreFooter.OnClickLoadMoreListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.3
            @Override // client.android.yixiaotong.ui.widget.LoadMoreFooter.OnClickLoadMoreListener
            public void onClick() {
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mBluetoothManager.setListener(this);
        if (this.mBluetoothDevices.isEmpty()) {
            if (this.mBluetoothManager.isBluetoothOn()) {
                this.mBluetoothManager.disConnectAll();
                this.mBluetoothManager.startScan();
            } else if (this.mIsOpen) {
                this.mBluetoothManager.askUserToEnableBluetoothIfNeeded(this);
            }
        }
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("设备列表");
        this.mTitleBar.setLeftView("扫描二维码");
        this.mTitleBar.setLeftViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeOrBarcodeActivity.launch(WashBluetoothList2Activity.this.getActivity(), WashBluetoothList2Activity.this.mWalletModel, "", 3);
                } else {
                    ZxingScanActivity.launch(WashBluetoothList2Activity.this.getActivity(), WashBluetoothList2Activity.this.mWalletModel, "", 3);
                }
                WashBluetoothList2Activity.this.finish();
            }
        });
        initTitleBarWithScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTitleBarWithScan() {
        this.mTitleBar.setRightView("扫描");
        this.mTitleBar.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (WashBluetoothList2Activity.this.mBluetoothManager.isBluetoothOn()) {
                    WashBluetoothList2Activity.this.mBluetoothManager.disConnectAll();
                    WashBluetoothList2Activity.this.mBluetoothManager.startScan();
                }
            }
        });
    }

    private void initTitleBarWithStopScan() {
        this.mTitleBar.setRightView("停止扫描");
        this.mTitleBar.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WashBluetoothList2Activity.this.initTitleBarWithScan();
                WashBluetoothList2Activity.this.mBluetoothManager.stopScan();
                WashBluetoothList2Activity.this.mBluetoothManager.disConnectAll();
            }
        });
    }

    @Override // android.app.Activity
    public void finish() {
        dismissDialog();
        super.finish();
        this.mBluetoothManager.stopScan();
    }

    private void sendReturnParamsData(BluetoothDevice bluetoothDevice) {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("正在连接洗衣机设备...");
        }
        this.mAddress = bluetoothDevice.mAddress;
        Log.e("test", "开始发送数据");
        this.mBluetoothManager.sendData("f5", this.mAddress, HexString.hexToBuffer(CommandUtils.getReturnSettingCommand()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkTimeOut(TimeOut timeOut, int i) {
        this.mCurrentCheckTimeOut = timeOut;
        MainThreadExecutor.getInstance().executeDelayed(new CheckRunnable(timeOut), Math.max(i, 1000));
    }

    private class CheckRunnable implements Runnable {
        private TimeOut timeOut;

        public CheckRunnable(TimeOut timeOut) {
            this.timeOut = timeOut;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TimeOut.Connect == WashBluetoothList2Activity.this.mCurrentCheckTimeOut) {
                WashBluetoothList2Activity.this.dismissDialog();
                ToastUtils.show(WashBluetoothList2Activity.this.getContext(), "洗衣机设备连接超时,请重试！");
                BluetoothManager.getInstance().stopScan();
                BluetoothManager.getInstance().disConnectAll();
            }
        }
    }

    private void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("蓝牙正在配对中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.7
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

    private void connect(final BluetoothDevice bluetoothDevice) {
        if (this.mBluetoothManager.isBluetoothLeMode() || this.mBluetoothManager.isBond(bluetoothDevice)) {
            showDialog();
            this.mBluetoothManager.disConnectAll();
            runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.8
                @Override // java.lang.Runnable
                public void run() {
                    WashBluetoothList2Activity.this.checkTimeOut(TimeOut.Connect, 8000);
                    BluetoothDevice bluetoothDevice2 = bluetoothDevice;
                    if (bluetoothDevice2 != null && bluetoothDevice2.mRssi < -85) {
                        ToastUtils.show(WashBluetoothList2Activity.this.getContext(), "您离洗衣机设备较远，可能会导致信号不稳定，请靠近洗衣机设备!");
                    }
                    WashBluetoothList2Activity.this.mBluetoothManager.connect(bluetoothDevice.mAddress);
                }
            }, 100L);
            return;
        }
        ToastUtils.show(getContext(), "请在系统蓝牙设置中绑定需要连接的洗衣机设备!", 1);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (!NetworkUtils.isNetworkAvailable(getContext())) {
            ToastUtils.show(getContext(), "请检查网络后重试");
            return;
        }
        BluetoothDevice item = this.mDevicesAdapter.getItem(i);
        if (item != null) {
            this.mConnectCount = 0;
            connect(item);
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnected(String str) {
        Log.e("demo", "2:物理连接建立成功!");
        this.mCurrentCheckTimeOut = null;
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("蓝牙配对成功...");
        }
        BluetoothDevice bluetoothDevice = this.mBluetoothManager.getBluetoothDevice(str);
        if (this.mBluetoothManager.isBluetoothLeMode()) {
            for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothDevice.getAllBluetoothGattCharacteristic()) {
                if (bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe1") == 0) {
                    bluetoothDevice.setReadBluetoothGattCharacteristic(bluetoothGattCharacteristic);
                } else if (bluetoothGattCharacteristic.getUuid().toString().toLowerCase().indexOf("0000ffe2") == 0) {
                    bluetoothDevice.setReadWriteBluetoothGattCharacteristic(bluetoothGattCharacteristic);
                }
            }
            sendReturnParamsData(bluetoothDevice);
            return;
        }
        sendReturnParamsData(bluetoothDevice);
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDisconnected(String str) {
        int i = this.mConnectCount;
        if (i == 3) {
            dismissDialog();
            BluetoothManager.getInstance().disConnectAll();
        } else {
            this.mConnectCount = i + 1;
            dismissDialog();
            connect(this.mBluetoothManager.getBluetoothDevice(str));
            ToastUtils.show(getContext(), "洗衣机的蓝牙信号不稳定，正在重新连接中...");
        }
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        BluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "无法连接到" + str + "，请重试");
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDiscoveryStarted() {
        initTitleBarWithStopScan();
        this.mBluetoothDevices.clear();
        this.mDevicesAdapter.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDiscoveryFinished() {
        initTitleBarWithScan();
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDeviceFound(String str) {
        BluetoothDevice bluetoothDevice = this.mBluetoothManager.getBluetoothDevice(str);
        if (this.mBluetoothDevices.contains(bluetoothDevice)) {
            return;
        }
        this.mMultiStateView.setViewState(0);
        this.mSwipeRefreshLayout.setRefreshing(false);
        this.mBluetoothDevices.add(bluetoothDevice);
        Collections.sort(this.mBluetoothDevices, new TestComparator());
        this.mDevicesAdapter.notifyDataSetChanged();
    }

    private void sendConnectData(BluetoothDevice bluetoothDevice) {
        this.mBluetoothManager.sendData("f0", bluetoothDevice.mAddress, HexString.hexToBuffer(CommandUtils.getOnlineConnectCommand(getLoginAccount().getUid())));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // client.android.yixiaotong.util.bluetooth.BluetoothManager.Listener
    public void onDataReceived(final String str, byte[] bArr) {
        if (isShowingDialog()) {
            final BluetoothDevice bluetoothDevice = this.mBluetoothManager.getBluetoothDevice(str);
            if (CommandUtils.isReturnSettingResult(bArr)) {
                this.mCurrentCheckTimeOut = null;
                if (CommandUtils.getReturnSettingResultStatus(bArr)) {
                    bluetoothDevice.mDeviceHexID = CommandUtils.getReturnSettingDeviceIdResult(bArr);
                    if (HexString.bufferToHex(bArr).substring(26, 28).toUpperCase().equals("01")) {
                        if (this.mIsManager) {
                            new MaterialDialog.Builder(getContext()).title("选项").content("请选择您要做的操作").positiveText("设备详情").negativeText("设备初始化").neutralText("参数设置").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.11
                                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                                    WashSelectOperate2Activity.launch(WashBluetoothList2Activity.this.getActivity(), WashBluetoothList2Activity.this.mWalletModel, str, bluetoothDevice.mName);
                                    WashBluetoothList2Activity.this.getActivity().finish();
                                }
                            }).onNeutral(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.10
                                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                                    WashSettingActivity.launch(WashBluetoothList2Activity.this.getActivity(), WashBluetoothList2Activity.this.mWalletModel, str, bluetoothDevice.mName);
                                    WashBluetoothList2Activity.this.finish();
                                }
                            }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothList2Activity.9
                                @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                                public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                                    WashInitActivity.launch(WashBluetoothList2Activity.this.getActivity(), WashBluetoothList2Activity.this.mWalletModel, str, bluetoothDevice.mName);
                                    WashBluetoothList2Activity.this.finish();
                                }
                            }).show();
                            return;
                        } else {
                            WashSelectOperate2Activity.launch(getActivity(), this.mWalletModel, str, bluetoothDevice.mName);
                            getActivity().finish();
                            return;
                        }
                    }
                    if (HexString.bufferToHex(bArr).substring(26, 28).toUpperCase().equals("00")) {
                        dismissDialog();
                        ToastUtils.show(getActivity(), "洗衣机正忙，请稍后再使用！");
                        return;
                    } else {
                        dismissDialog();
                        ToastUtils.show(getActivity(), "洗衣机有异常，错误码：" + HexString.bufferToHex(bArr).substring(26, 28).toUpperCase());
                        return;
                    }
                }
                return;
            }
            dismissDialog();
            ToastUtils.show(getContext(), "洗衣机设备连接失败,请检查设备或报修");
            initTitleBarWithStopScan();
            BluetoothManager.getInstance().stopScan();
            BluetoothManager.getInstance().disConnectAll();
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
            return WashBluetoothList2Activity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) WashBluetoothList2Activity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WashBluetoothList2Activity.this.getContext()).inflate(R.layout.bluetooth_devices_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            BluetoothDevice item = getItem(i);
            viewHolder.name.setText(item.mName);
            viewHolder.introduce.setText(item.mAddress);
            viewHolder.rssi.setText(item.mRssi + "");
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

    static class TestComparator implements Comparator<BluetoothDevice> {
        TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(BluetoothDevice bluetoothDevice, BluetoothDevice bluetoothDevice2) {
            return bluetoothDevice2.mRssi - bluetoothDevice.mRssi;
        }
    }

    private IntentFilter makeFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
        return intentFilter;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 2001 && i2 == 0) {
            this.mIsOpen = false;
            finish();
        }
    }
}
