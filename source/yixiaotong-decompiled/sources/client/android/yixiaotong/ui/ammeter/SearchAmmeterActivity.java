package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothDevice;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.ammeterbluetooth.UiThreadUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SearchAmmeterActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_ISHASAMMETER = "ishasammeter";
    public static final String EXTRAS_STATE = "devicestate";
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_QRCODEDATA = "extra_qrcodedata";
    public static final String EXTRA_WALLET = "extra_wallet";
    private AmmeterBluetoothDevice mAmmeterBluetoothDevice;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private DeviceListAdapter mDeviceListAdapter;
    private int mIsHasAmmeter;
    private ListView mListView;
    private MaterialDialog mMaterialDialog;
    private String mQrcodeData;
    private int mState;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    private Runnable runnableSend;
    private List<AmmeterBluetoothDevice> mAmmeterBluetoothDevices = new ArrayList();
    private boolean mConnected = false;
    private boolean mSupport = false;
    private Handler handlersend = new Handler();
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";

    static {
        StubApp.interface11(6312);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onBLEState(boolean z) {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnected(String str, boolean z) {
        this.mConnected = z;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnecting(String str) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, String str, int i, int i2) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SearchAmmeterActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("extra_qrcodedata", str);
            intent.putExtra("devicestate", i);
            intent.putExtra("ishasammeter", i2);
            activity.startActivity(intent);
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity$1, reason: invalid class name */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        AnonymousClass1() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (!NetworkUtils.isNetworkAvailable(SearchAmmeterActivity.this)) {
                ToastUtils.show(SearchAmmeterActivity.this.getContext(), "请检查网络后重试");
                return;
            }
            SearchAmmeterActivity searchAmmeterActivity = SearchAmmeterActivity.this;
            searchAmmeterActivity.mAmmeterBluetoothDevice = searchAmmeterActivity.mDeviceListAdapter.getItem(i);
            if (SearchAmmeterActivity.this.mAmmeterBluetoothDevice != null) {
                SearchAmmeterActivity.this.showDialog();
                SearchAmmeterActivity.this.mAmmeterBluetoothManager.disConnectAll();
                SearchAmmeterActivity.this.runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SearchAmmeterActivity.this.mAmmeterBluetoothManager.connect(SearchAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress);
                    }
                }, 800L);
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        private void connetState() {
            if (!SearchAmmeterActivity.this.mConnected || !SearchAmmeterActivity.this.mSupport) {
                SearchAmmeterActivity.this.dismissDialog();
                ToastUtils.show(SearchAmmeterActivity.this, "连接电表失败!");
                return;
            }
            SearchAmmeterActivity.this.dismissDialog();
            if (SearchAmmeterActivity.this.mState != 1) {
                if (SearchAmmeterActivity.this.mState != 2) {
                    if (SearchAmmeterActivity.this.mState != 3) {
                        if (SearchAmmeterActivity.this.mState != 4) {
                            if (SearchAmmeterActivity.this.mState != 6) {
                                if (SearchAmmeterActivity.this.mState == 7) {
                                    AmmeterBluetoothManager.getInstance().stopScan();
                                    AmmeterRechargeRecordActivity.launch(SearchAmmeterActivity.this.getActivity(), SearchAmmeterActivity.this.mWalletModel, SearchAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress);
                                    SearchAmmeterActivity.this.finish();
                                    return;
                                }
                                return;
                            }
                            AmmeterBluetoothManager.getInstance().stopScan();
                            InitAmmeterActivity.launch(SearchAmmeterActivity.this.getActivity(), SearchAmmeterActivity.this.mWalletModel, SearchAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress, Constant.DEFAULT_CVN2 + SearchAmmeterActivity.this.mQrcodeData, "1", 6);
                            SearchAmmeterActivity.this.finish();
                            return;
                        }
                        AmmeterBluetoothManager.getInstance().stopScan();
                        InitAmmeterActivity.launch(SearchAmmeterActivity.this.getActivity(), SearchAmmeterActivity.this.mWalletModel, SearchAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress, Constant.DEFAULT_CVN2 + SearchAmmeterActivity.this.mQrcodeData, "4", SearchAmmeterActivity.this.mIsHasAmmeter);
                        SearchAmmeterActivity.this.finish();
                        return;
                    }
                    AmmeterBluetoothManager.getInstance().stopScan();
                    DestroyAmmeterActivity.launch(SearchAmmeterActivity.this.getActivity(), SearchAmmeterActivity.this.mWalletModel, SearchAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress);
                    SearchAmmeterActivity.this.finish();
                    return;
                }
                AmmeterBluetoothManager.getInstance().stopScan();
                SettingAmmeterActivity.launch(SearchAmmeterActivity.this.getActivity(), SearchAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress);
                SearchAmmeterActivity.this.finish();
                return;
            }
            AmmeterBluetoothManager.getInstance().stopScan();
            InitAmmeterActivity.launch(SearchAmmeterActivity.this.getActivity(), SearchAmmeterActivity.this.mWalletModel, SearchAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress, Constant.DEFAULT_CVN2 + SearchAmmeterActivity.this.mQrcodeData, "1", SearchAmmeterActivity.this.mIsHasAmmeter);
            SearchAmmeterActivity.this.finish();
        }

        @Override // java.lang.Runnable
        public void run() {
            connetState();
        }
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("电表设备列表");
        initTitleBarWithScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initTitleBarWithScan() {
        this.mTitleBar.setRightView("扫描");
        this.mTitleBar.setRightViewTextColor(getResources().getColor(R.color.ff4A90E2));
        this.mTitleBar.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SearchAmmeterActivity.this.mAmmeterBluetoothManager.isBluetoothOn()) {
                    SearchAmmeterActivity.this.mAmmeterBluetoothManager.disConnectAll();
                    SearchAmmeterActivity.this.mAmmeterBluetoothManager.startScan();
                }
            }
        });
    }

    private void initTitleBarWithStopScan() {
        this.mTitleBar.setRightView("停止扫描");
        this.mTitleBar.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SearchAmmeterActivity.this.initTitleBarWithScan();
                SearchAmmeterActivity.this.mAmmeterBluetoothManager.stopScan();
                SearchAmmeterActivity.this.mAmmeterBluetoothManager.disConnectAll();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在匹配电表的蓝牙中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.SearchAmmeterActivity.5
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

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.mAmmeterBluetoothDevices.isEmpty()) {
            if (this.mAmmeterBluetoothManager.isBluetoothOn()) {
                this.mAmmeterBluetoothManager.disConnectAll();
                this.mAmmeterBluetoothManager.startScan();
            } else {
                this.mAmmeterBluetoothManager.askUserToEnableBluetoothIfNeeded(this);
            }
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.mAmmeterBluetoothManager.stopScan();
        UiThreadUtils.clearHandler(this.handlersend, this.runnableSend);
    }

    private void sendGetDeviceInfoData() {
        this.mReceivedCode = "FF";
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAmmeterBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceInfo(randNumMaxString)));
    }

    private void sendWriteAccountRechargeDestroy(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAmmeterBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.writeAccountRechargeDestroy("02", (short) 0, str, randNumMaxString)));
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "电表的蓝牙信号不稳定，请靠近电表后重试!");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "连接电表失败!");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
        initTitleBarWithStopScan();
        this.mAmmeterBluetoothDevices.clear();
        this.mDeviceListAdapter.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
        initTitleBarWithScan();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDeviceFound(String str) {
        AmmeterBluetoothDevice ammeterBluetoothDevice = this.mAmmeterBluetoothManager.getAmmeterBluetoothDevice(str);
        if (this.mAmmeterBluetoothDevices.contains(ammeterBluetoothDevice)) {
            return;
        }
        this.mAmmeterBluetoothDevices.add(ammeterBluetoothDevice);
        Collections.sort(this.mAmmeterBluetoothDevices, new TestComparator());
        this.mDeviceListAdapter.notifyDataSetChanged();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (!z) {
            ToastUtils.show(getContext(), "你连接的不是电表设备");
            dismissDialog();
        } else {
            if (isShowingDialog()) {
                this.mMaterialDialog.setContent("电表蓝牙匹配成功，正在连接电表...");
            }
            this.handlersend.postDelayed(this.runnableSend, 1000L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onSendDataFailed() {
        dismissDialog();
        ToastUtils.show(getContext(), "数据发送失败！");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                String upperCase2 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase2;
                sendWriteAccountRechargeDestroy(upperCase2);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("8B".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            dismissDialog();
            String upperCase3 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase3;
            if (this.mSendCode.equals(upperCase3)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                ToastUtils.show(getContext(), "销户成功");
                return;
            } else {
                ToastUtils.show(getContext(), "校验码出错啦！");
                return;
            }
        }
        if ("8C".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            dismissDialog();
            String upperCase4 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase4;
            if (this.mSendCode.equals(upperCase4)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                ToastUtils.show(getContext(), "销户失败");
                return;
            } else {
                ToastUtils.show(getContext(), "校验码出错啦！");
                return;
            }
        }
        dismissDialog();
        String strSubstring = strBufferToHex.substring(4, 6);
        if (strSubstring.toUpperCase().equals("CB")) {
            ToastUtils.show(getContext(), "销户存在异常！");
        } else if (strSubstring.toUpperCase().equals("C1")) {
            ToastUtils.show(getContext(), "获取设备状态存在异常！");
        } else {
            ToastUtils.show(getContext(), "未知错误");
        }
    }

    private class DeviceListAdapter extends BaseAdapter {
        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        private DeviceListAdapter() {
        }

        /* synthetic */ DeviceListAdapter(SearchAmmeterActivity searchAmmeterActivity, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return SearchAmmeterActivity.this.mAmmeterBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public AmmeterBluetoothDevice getItem(int i) {
            return (AmmeterBluetoothDevice) SearchAmmeterActivity.this.mAmmeterBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(SearchAmmeterActivity.this).inflate(R.layout.ammeter_bluetooth_devices_list_item, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            AmmeterBluetoothDevice item = getItem(i);
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

    static class TestComparator implements Comparator<AmmeterBluetoothDevice> {
        TestComparator() {
        }

        @Override // java.util.Comparator
        public int compare(AmmeterBluetoothDevice ammeterBluetoothDevice, AmmeterBluetoothDevice ammeterBluetoothDevice2) {
            return ammeterBluetoothDevice2.mRssi - ammeterBluetoothDevice.mRssi;
        }
    }
}
