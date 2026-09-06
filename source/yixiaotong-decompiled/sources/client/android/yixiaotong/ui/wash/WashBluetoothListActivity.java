package client.android.yixiaotong.ui.wash;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.listener.ScanListener;
import android.client.bluetoothsdk.util.ClientException;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
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
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.scancode.ScanQrcodeOrBarcodeActivity;
import client.android.yixiaotong.ui.scancode.ZxingScanActivity;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bluetooth.CommandUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class WashBluetoothListActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_MANAGER = "extra_manager";
    public static final String EXTRA_WALLET = "extra_wallet";
    private BluetoothConnectListener mBluetoothConnectListener;
    private BluetoothDevice mBluetoothDevice;
    private DevicesAdapter mDevicesAdapter;
    ImageView mImgRefreshDevices;
    ImageView mImgResetQuYu;
    private boolean mIsEnable;
    ListView mList;
    private MaterialDialog mMaterialDialog;
    private ScanListener mScanListener;
    TitleBar mTitleBar;
    TextView mTvQuYu;
    TextView mTvSetQuYu;
    private WalletModel mWalletModel;
    private StringBuilder stringBuilder;
    private List<BluetoothDevice> mBluetoothDevices = new ArrayList();
    private boolean mIsManager = false;
    public int leftCount = 0;
    public int mConnectCount = 0;

    static {
        StubApp.interface11(7680);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    private void initViewNew() {
        this.mList = (ListView) findViewById(R.id.recycler_view);
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvQuYu = (TextView) findViewById(R.id.tv_quyu);
        this.mTvSetQuYu = (TextView) findViewById(R.id.tv_setquyu);
        this.mImgResetQuYu = (ImageView) findViewById(R.id.img_reset);
        this.mImgRefreshDevices = (ImageView) findViewById(R.id.img_refresh);
    }

    public static void launch(Activity activity, WalletModel walletModel, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) WashBluetoothListActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra(EXTRA_MANAGER, i);
            activity.startActivity(intent);
        }
    }

    private void initView() {
        this.mList.setOnItemClickListener(this);
        ListView listView = this.mList;
        DevicesAdapter devicesAdapter = new DevicesAdapter();
        this.mDevicesAdapter = devicesAdapter;
        listView.setAdapter((ListAdapter) devicesAdapter);
        this.mTvSetQuYu.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ToastUtils.show(WashBluetoothListActivity.this.getActivity(), "暂未开通！");
            }
        });
        this.mImgResetQuYu.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.mImgRefreshDevices.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BluetoothSDK.getInstance().startScanDevice(6000, WashBluetoothListActivity.this.mScanListener);
            }
        });
    }

    private void initListener() {
        this.mScanListener = new ScanListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.4
            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onBluetoothException(ClientException clientException, int i) {
            }

            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onStart() {
                WashBluetoothListActivity.this.mImgRefreshDevices.setVisibility(8);
                WashBluetoothListActivity.this.mBluetoothDevices.clear();
                WashBluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
            }

            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onScan(BluetoothDevice bluetoothDevice) {
                if (WashBluetoothListActivity.this.mBluetoothDevices.contains(bluetoothDevice)) {
                    return;
                }
                WashBluetoothListActivity.this.mBluetoothDevices.add(bluetoothDevice);
                Collections.sort(WashBluetoothListActivity.this.mBluetoothDevices, new TestComparator());
                WashBluetoothListActivity.this.mDevicesAdapter.notifyDataSetChanged();
            }

            @Override // android.client.bluetoothsdk.listener.ScanListener
            public void onComplete() {
                WashBluetoothListActivity.this.mImgRefreshDevices.setVisibility(0);
            }
        };
        this.mBluetoothConnectListener = new AnonymousClass5();
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.wash.WashBluetoothListActivity$5, reason: invalid class name */
    class AnonymousClass5 extends BluetoothConnectListener {
        AnonymousClass5() {
        }

        @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
        public void onStart(BluetoothDevice bluetoothDevice) {
            WashBluetoothListActivity.this.mImgRefreshDevices.setVisibility(0);
        }

        @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
        public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.5.1
                @Override // java.lang.Runnable
                public void run() {
                    BluetoothSDK.getInstance().SendDataManagerDevice(CommandUtils.getReturnSettingCommand());
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.5.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (WashBluetoothListActivity.this.isShowingDialog()) {
                                WashBluetoothListActivity.this.dismissDialog();
                                ToastUtils.show(WashBluetoothListActivity.this.getActivity(), "发送数据超时！");
                            }
                        }
                    }, 5000L);
                }
            }, 200L);
        }

        @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut, String str) {
            WashBluetoothListActivity.this.mConnectCount++;
            WashBluetoothListActivity.this.dismissDialog();
            ToastUtils.show(WashBluetoothListActivity.this.getActivity(), "连接设备失败!");
        }

        @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
        public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
            if (!str.startsWith("550001") || str.length() < 8) {
                if (WashBluetoothListActivity.this.stringBuilder == null || WashBluetoothListActivity.this.stringBuilder.toString().length() < 8) {
                    if (WashBluetoothListActivity.this.stringBuilder != null && WashBluetoothListActivity.this.stringBuilder.toString().length() < 8) {
                        WashBluetoothListActivity.this.stringBuilder.append(str);
                        if (WashBluetoothListActivity.this.stringBuilder.toString().length() >= 8) {
                            byte[] bArrHexToBuffer = HexString.hexToBuffer(WashBluetoothListActivity.this.stringBuilder.toString().substring(6, 8));
                            byte[] bArr = new byte[4];
                            System.arraycopy(bArrHexToBuffer, 0, bArr, 4 - bArrHexToBuffer.length, bArrHexToBuffer.length);
                            int iBytesToInt2 = IntegerUtils.bytesToInt2(bArr, 0);
                            WashBluetoothListActivity washBluetoothListActivity = WashBluetoothListActivity.this;
                            washBluetoothListActivity.leftCount = ((iBytesToInt2 + 1) * 2) - (washBluetoothListActivity.stringBuilder.toString().length() - 6);
                        }
                    } else {
                        if (!str.startsWith("55") || str.length() >= 8) {
                            return;
                        }
                        WashBluetoothListActivity.this.stringBuilder = new StringBuilder();
                        WashBluetoothListActivity.this.stringBuilder.append(str);
                        WashBluetoothListActivity.this.leftCount = 1;
                    }
                } else {
                    WashBluetoothListActivity.this.stringBuilder.append(str);
                    WashBluetoothListActivity.this.leftCount -= str.length();
                }
            } else {
                WashBluetoothListActivity.this.stringBuilder = new StringBuilder();
                WashBluetoothListActivity.this.stringBuilder.append(str);
                byte[] bArrHexToBuffer2 = HexString.hexToBuffer(str.substring(6, 8));
                byte[] bArr2 = new byte[4];
                System.arraycopy(bArrHexToBuffer2, 0, bArr2, 4 - bArrHexToBuffer2.length, bArrHexToBuffer2.length);
                WashBluetoothListActivity.this.leftCount = ((IntegerUtils.bytesToInt2(bArr2, 0) + 1) * 2) - (str.length() - 6);
            }
            if (WashBluetoothListActivity.this.leftCount > 0 || WashBluetoothListActivity.this.stringBuilder == null) {
                return;
            }
            String string = WashBluetoothListActivity.this.stringBuilder.toString();
            WashBluetoothListActivity.this.stringBuilder = null;
            WashBluetoothListActivity.this.managerData(HexString.hexToBuffer(string));
        }

        @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
        public void onBluetoothException(ClientException clientException) {
            WashBluetoothListActivity.this.dismissDialog();
            ToastUtils.show(WashBluetoothListActivity.this.getActivity(), "请打开蓝牙！");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        BluetoothSDK.getInstance().setListener(this.mBluetoothConnectListener);
        BluetoothSDK.getInstance().startScanDevice(6000, this.mScanListener);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        dismissDialog();
        stopScan();
    }

    private void initTitleBar() {
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setTitleView("更换设备");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setRightView(R.mipmap.l_qrcode_saomiao);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        this.mTitleBar.setRightViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeOrBarcodeActivity.launch(WashBluetoothListActivity.this.getActivity(), WashBluetoothListActivity.this.mWalletModel, "", 3);
                } else {
                    ZxingScanActivity.launch(WashBluetoothListActivity.this.getActivity(), WashBluetoothListActivity.this.mWalletModel, "", 3);
                }
                WashBluetoothListActivity.this.finish();
            }
        });
    }

    private void stopScan() {
        BluetoothSDK.getInstance().stopScanDevice();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        dismissDialog();
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
        } else if (this.mBluetoothDevice != null) {
            showDialog();
            BluetoothSDK.getInstance().ConnectManagerDevice(this.mBluetoothDevice);
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
            finish();
        }
    }

    private void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("蓝牙正在配对中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.7
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
            return WashBluetoothListActivity.this.mBluetoothDevices.size();
        }

        @Override // android.widget.Adapter
        public BluetoothDevice getItem(int i) {
            return (BluetoothDevice) WashBluetoothListActivity.this.mBluetoothDevices.get(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(WashBluetoothListActivity.this.getContext()).inflate(R.layout.bluetooth_devices_list_new_item, (ViewGroup) null);
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
                this.name = (TextView) view.findViewById(R.id.tv_name);
                this.introduce = (TextView) view.findViewById(R.id.tv_address);
                this.rssi = (TextView) view.findViewById(R.id.rssi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void managerData(byte[] bArr) {
        dismissDialog();
        if (CommandUtils.isReturnSettingResult(bArr)) {
            if (CommandUtils.getReturnSettingResultStatus(bArr)) {
                final String returnSettingDeviceIdResult = CommandUtils.getReturnSettingDeviceIdResult(bArr);
                if (!HexString.bufferToHex(bArr).substring(26, 28).toUpperCase().equals("00")) {
                    if (HexString.bufferToHex(bArr).substring(26, 28).toUpperCase().equals("01")) {
                        ToastUtils.show(getActivity(), "洗衣机正忙，请稍后再使用！");
                        return;
                    } else {
                        ToastUtils.show(getActivity(), "洗衣机有异常，错误码：" + HexString.bufferToHex(bArr).substring(26, 28).toUpperCase());
                        return;
                    }
                }
                if (this.mIsManager) {
                    new MaterialDialog.Builder(getContext()).title("选项").content("请选择您要做的操作").positiveText("设备详情").negativeText("设备初始化").neutralText("参数设置").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.10
                        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                            WashSelectOperate2Activity.launch(WashBluetoothListActivity.this.getActivity(), WashBluetoothListActivity.this.mWalletModel, WashBluetoothListActivity.this.mBluetoothDevice.address, WashBluetoothListActivity.this.mBluetoothDevice.name, returnSettingDeviceIdResult);
                            WashBluetoothListActivity.this.getActivity().finish();
                        }
                    }).onNeutral(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.9
                        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                            WashSettingActivity.launch(WashBluetoothListActivity.this.getActivity(), WashBluetoothListActivity.this.mWalletModel, WashBluetoothListActivity.this.mBluetoothDevice.address, WashBluetoothListActivity.this.mBluetoothDevice.name);
                            WashBluetoothListActivity.this.finish();
                        }
                    }).onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.wash.WashBluetoothListActivity.8
                        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                            WashInitActivity.launch(WashBluetoothListActivity.this.getActivity(), WashBluetoothListActivity.this.mWalletModel, WashBluetoothListActivity.this.mBluetoothDevice.address, WashBluetoothListActivity.this.mBluetoothDevice.name);
                            WashBluetoothListActivity.this.finish();
                        }
                    }).show();
                    return;
                } else {
                    WashSelectOperate2Activity.launch(getActivity(), this.mWalletModel, this.mBluetoothDevice.address, this.mBluetoothDevice.name, returnSettingDeviceIdResult);
                    getActivity().finish();
                    return;
                }
            }
            ToastUtils.show(getContext(), "洗衣机设备连接失败,请检查设备或报修");
            BluetoothSDK.getInstance().closeBLE();
            return;
        }
        ToastUtils.show(getContext(), "洗衣机设备连接失败,请检查设备或报修");
        BluetoothSDK.getInstance().closeBLE();
    }
}
