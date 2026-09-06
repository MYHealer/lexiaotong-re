package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterBindingRoom;
import client.android.yixiaotong.controller.bean.AmmeterRoomDetail;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.bluetooth.TimeOut;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SelectOperateActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    private static final int CHAYUE = 2;
    private static final int CHONGZHI = 1;
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRA_USERNO = "extra_userno";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int MESSAGE_CONNECT = 2;
    public static final int MESSAGE_CONNECTCOUNT = 5;
    public static final int MESSAGE_CONNECTED = 3;
    public static final int MESSAGE_SCAN = 1;
    public static final int MESSAGE_SCANCOUNT = 4;
    private String mAddress;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private RelativeLayout mChongZhi;
    private TimeOut mCurrentCheckTimeOut;
    private Handler mHandler;
    private MaterialDialog mMaterialDialog;
    private RelativeLayout mOrder;
    private RelativeLayout mRelAmmeter;
    private String mRoomID;
    private RelativeLayout mSubsidies;
    private TitleBar mTitleBar;
    private TextView mTvBindRoom;
    private TextView mTvDeviceid;
    private TextView mTvMac;
    private TextView mTvSuShe;
    private String mUserNo;
    private WalletModel mWalletModel;
    private int mConnectCount = 0;
    private boolean mConnected = false;
    private boolean mSupport = false;
    private int mSelectOperate = 0;
    private int scanMessage = 10;
    private int connectMessage = 12;
    private boolean isFoundDevice = false;

    static {
        StubApp.interface11(6334);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onBLEState(boolean z) {
        this.mConnected = z;
        this.mSupport = z;
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

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    static /* synthetic */ int access$1210(SelectOperateActivity selectOperateActivity) {
        int i = selectOperateActivity.scanMessage;
        selectOperateActivity.scanMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$2610(SelectOperateActivity selectOperateActivity) {
        int i = selectOperateActivity.connectMessage;
        selectOperateActivity.connectMessage = i - 1;
        return i;
    }

    static /* synthetic */ int access$2708(SelectOperateActivity selectOperateActivity) {
        int i = selectOperateActivity.mConnectCount;
        selectOperateActivity.mConnectCount = i + 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SelectOperateActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("deviceAddress", str);
            intent.putExtra("extra_userno", str2);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mChongZhi = (RelativeLayout) findViewById(R.id.rel_chongzhi);
        this.mOrder = (RelativeLayout) findViewById(R.id.rel_order);
        this.mSubsidies = (RelativeLayout) findViewById(R.id.rel_butie);
        this.mTvBindRoom = (TextView) findViewById(R.id.tv_bindroom);
        this.mTvSuShe = (TextView) findViewById(R.id.tv_susheaddress);
        this.mTvMac = (TextView) findViewById(R.id.tv_deviceaddress);
        this.mRelAmmeter = (RelativeLayout) findViewById(R.id.rel_ammeter);
        this.mTvDeviceid = (TextView) findViewById(R.id.tv_deviceid);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectOperateActivity$1, reason: invalid class name */
    class AnonymousClass1 extends Listener<AmmeterRoomDetail> {
        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
        }

        AnonymousClass1() {
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, AmmeterRoomDetail ammeterRoomDetail, Object... objArr) {
            if (ammeterRoomDetail != null) {
                SelectOperateActivity.this.mTvSuShe.setText(ammeterRoomDetail.School + ammeterRoomDetail.Region + ammeterRoomDetail.Building + ammeterRoomDetail.Floor + ammeterRoomDetail.Room);
                SelectOperateActivity.this.mRoomID = ammeterRoomDetail.RoomID;
                SelectOperateActivity.this.mTvBindRoom.setText("解绑");
            }
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, ClientException clientException) {
            ToastUtils.show(SelectOperateActivity.this.getActivity(), clientException.getDetail());
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectOperateActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectOperateActivity.this.mSelectOperate = 1;
            if (SelectOperateActivity.this.mAmmeterBluetoothManager.isBluetoothOn()) {
                if (StringUtils.isNotEmpty(SelectOperateActivity.this.mAddress)) {
                    SelectOperateActivity.this.showDialog();
                    SelectOperateActivity.this.isFoundDevice = false;
                    if (SelectOperateActivity.this.mMaterialDialog != null) {
                        SelectOperateActivity.this.mMaterialDialog.setContent("正在搜索您宿舍的电表 10 秒");
                    }
                    SelectOperateActivity.this.mAmmeterBluetoothManager.disConnectAll();
                    SelectOperateActivity.this.mAmmeterBluetoothManager.startScan();
                    if (SelectOperateActivity.this.mHandler != null) {
                        SelectOperateActivity.this.mCurrentCheckTimeOut = TimeOut.Scan;
                        SelectOperateActivity.this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                        SelectOperateActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                        SelectOperateActivity.this.scanMessage = 10;
                        return;
                    }
                    return;
                }
                return;
            }
            ToastUtils.show(SelectOperateActivity.this.getActivity(), "请打开手机的蓝牙！");
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectOperateActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNotEmpty(SelectOperateActivity.this.mAddress) && StringUtils.isNotEmpty(SelectOperateActivity.this.mUserNo)) {
                AmmeterOrderActivity.launch(SelectOperateActivity.this.getActivity(), SelectOperateActivity.this.mWalletModel, SelectOperateActivity.this.mAddress, SelectOperateActivity.this.mUserNo, SelectOperateActivity.this.mRoomID);
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectOperateActivity$4, reason: invalid class name */
    class AnonymousClass4 implements View.OnClickListener {
        AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (StringUtils.isNotEmpty(SelectOperateActivity.this.mRoomID)) {
                AmmeterSubsidyActivity.launch(SelectOperateActivity.this.getActivity(), SelectOperateActivity.this.mWalletModel, SelectOperateActivity.this.mAddress, SelectOperateActivity.this.mUserNo, SelectOperateActivity.this.mRoomID);
            } else {
                ToastUtils.show(SelectOperateActivity.this.getActivity(), "正在获取宿舍信息，请稍等...");
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectOperateActivity$5, reason: invalid class name */
    class AnonymousClass5 implements View.OnClickListener {
        AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SelectOperateActivity.this.mTvBindRoom.getText().toString().equals("绑宿舍")) {
                SelectAmmeterAddressActivity.launch(SelectOperateActivity.this.getActivity(), 1, SelectOperateActivity.this.mWalletModel);
            } else {
                BusinessControllers.getInstance().ammeterUnBindingRoom(SelectOperateActivity.this.getLoginAccount(), new Listener<AmmeterBindingRoom>() { // from class: client.android.yixiaotong.ui.ammeter.SelectOperateActivity.5.1
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        SelectOperateActivity.this.showDialog();
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, AmmeterBindingRoom ammeterBindingRoom, Object... objArr) {
                        SelectOperateActivity.this.dismissDialog();
                        ToastUtils.show(SelectOperateActivity.this.getActivity(), "宿舍解绑成功！");
                        SelectOperateActivity.this.finish();
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        SelectOperateActivity.this.dismissDialog();
                        ToastUtils.show(SelectOperateActivity.this.getActivity(), clientException.getDetail());
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SelectOperateActivity$6, reason: invalid class name */
    class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectOperateActivity.this.mSelectOperate = 2;
            if (SelectOperateActivity.this.mAmmeterBluetoothManager.isBluetoothOn()) {
                if (StringUtils.isNotEmpty(SelectOperateActivity.this.mAddress)) {
                    SelectOperateActivity.this.showDialog();
                    SelectOperateActivity.this.isFoundDevice = false;
                    if (SelectOperateActivity.this.mMaterialDialog != null) {
                        SelectOperateActivity.this.mMaterialDialog.setContent("正在搜索您宿舍的电表 10 秒");
                    }
                    SelectOperateActivity.this.mAmmeterBluetoothManager.disConnectAll();
                    SelectOperateActivity.this.mAmmeterBluetoothManager.startScan();
                    if (SelectOperateActivity.this.mHandler != null) {
                        SelectOperateActivity.this.mCurrentCheckTimeOut = TimeOut.Scan;
                        SelectOperateActivity.this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
                        SelectOperateActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                        SelectOperateActivity.this.scanMessage = 10;
                        return;
                    }
                    return;
                }
                return;
            }
            ToastUtils.show(SelectOperateActivity.this.getActivity(), "请打开手机的蓝牙！");
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("选择操作");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        AmmeterBluetoothManager ammeterBluetoothManager = AmmeterBluetoothManager.getInstance();
        this.mAmmeterBluetoothManager = ammeterBluetoothManager;
        ammeterBluetoothManager.setListener(this);
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.ammeter.SelectOperateActivity.7
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (TimeOut.Scan == SelectOperateActivity.this.mCurrentCheckTimeOut) {
                        SelectOperateActivity.this.dismissDialog();
                        SelectOperateActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        SelectOperateActivity.this.mAmmeterBluetoothManager.stopScan();
                        ToastUtils.show(SelectOperateActivity.this.getActivity(), "无法搜索到您宿舍的电表，请靠近电表后重试！");
                        return;
                    }
                    return;
                }
                if (message.what == 2) {
                    if (TimeOut.Connect == SelectOperateActivity.this.mCurrentCheckTimeOut) {
                        SelectOperateActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(SelectOperateActivity.this.getActivity(), "连接超时，请靠近电表设备后重试");
                        return;
                    } else {
                        if (TimeOut.DisConnect == SelectOperateActivity.this.mCurrentCheckTimeOut) {
                            AmmeterBluetoothManager.getInstance().disConnectAll();
                            return;
                        }
                        return;
                    }
                }
                if (message.what == 3) {
                    TimeOut timeOut = TimeOut.Connected;
                    TimeOut unused = SelectOperateActivity.this.mCurrentCheckTimeOut;
                    return;
                }
                if (message.what == 4) {
                    if (SelectOperateActivity.this.mMaterialDialog != null) {
                        SelectOperateActivity.access$1210(SelectOperateActivity.this);
                        if (SelectOperateActivity.this.scanMessage > 0) {
                            SelectOperateActivity.this.mMaterialDialog.setContent("正在搜索您宿舍的电表 " + SelectOperateActivity.this.scanMessage + " 秒");
                            SelectOperateActivity.this.mHandler.sendEmptyMessageDelayed(4, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (message.what != 5 || SelectOperateActivity.this.mMaterialDialog == null) {
                    return;
                }
                SelectOperateActivity.access$2610(SelectOperateActivity.this);
                if (SelectOperateActivity.this.connectMessage > 0) {
                    SelectOperateActivity.this.mMaterialDialog.setContent("正在连接电表 " + SelectOperateActivity.this.connectMessage + " 秒");
                    SelectOperateActivity.this.mHandler.sendEmptyMessageDelayed(5, 1000L);
                }
            }
        };
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.mSupport = false;
        this.mConnected = false;
        this.mCurrentCheckTimeOut = null;
        this.mAmmeterBluetoothManager.stopScan();
        this.mAmmeterBluetoothManager.disConnectAll();
    }

    private void connetAmmeter() {
        this.scanMessage = 0;
        if (!isShowingDialog()) {
            showDialog();
        }
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("正在连接电表 12 秒");
            this.mHandler.sendEmptyMessageDelayed(5, 1000L);
            this.connectMessage = 12;
        }
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.SelectOperateActivity.8
            @Override // java.lang.Runnable
            public void run() {
                if (StringUtils.isNotEmpty(SelectOperateActivity.this.mAddress)) {
                    if (SelectOperateActivity.this.mHandler != null) {
                        SelectOperateActivity.this.mCurrentCheckTimeOut = TimeOut.Connect;
                        SelectOperateActivity.access$2708(SelectOperateActivity.this);
                        Message message = new Message();
                        message.what = 2;
                        message.arg1 = SelectOperateActivity.this.mConnectCount;
                        SelectOperateActivity.this.mHandler.sendMessageDelayed(message, 12000L);
                    }
                    SelectOperateActivity.this.mAmmeterBluetoothManager.connect(SelectOperateActivity.this.mAddress);
                }
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在处理中，请稍后...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.SelectOperateActivity.9
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

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        dismissDialog();
        ToastUtils.show(getContext(), "电表蓝牙信号不好，请重试");
        this.mCurrentCheckTimeOut = TimeOut.DisConnect;
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "连接电表失败");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDeviceFound(String str) {
        if (StringUtils.isNotEmpty(this.mAddress) && StringUtils.isNotEmpty(str) && this.mAddress.equals(str) && !this.isFoundDevice) {
            this.isFoundDevice = true;
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog != null) {
                materialDialog.setContent("已经查找到您宿舍的电表...");
            }
            this.mAmmeterBluetoothManager.stopScan();
            connetAmmeter();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (z) {
            if (isShowingDialog()) {
                MaterialDialog materialDialog = this.mMaterialDialog;
                if (materialDialog != null) {
                    materialDialog.setContent("电表蓝牙匹配成功");
                }
                this.connectMessage = 0;
            }
            this.mCurrentCheckTimeOut = TimeOut.Connected;
            runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.SelectOperateActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    SelectOperateActivity.this.dismissDialog();
                    if (SelectOperateActivity.this.mSelectOperate == 1) {
                        if (StringUtils.isNotEmpty(SelectOperateActivity.this.mAddress) && StringUtils.isNotEmpty(SelectOperateActivity.this.mUserNo)) {
                            AmmeterWalletDetailActivity.launch(SelectOperateActivity.this.getActivity(), SelectOperateActivity.this.mWalletModel, SelectOperateActivity.this.mAddress, false, "", "", SelectOperateActivity.this.mUserNo);
                        }
                    } else if (SelectOperateActivity.this.mSelectOperate == 2) {
                        ReadAmmeterBalanceActivity.launch(SelectOperateActivity.this.getActivity(), SelectOperateActivity.this.mWalletModel, SelectOperateActivity.this.mAddress);
                    }
                    SelectOperateActivity.this.mCurrentCheckTimeOut = null;
                    SelectOperateActivity.this.mSupport = false;
                    SelectOperateActivity.this.mConnected = false;
                }
            }, 800L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onSendDataFailed() {
        dismissDialog();
        ToastUtils.show(getContext(), "数据发送失败！");
        finish();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        AmmeterCommandUtils.isConnectResult(HexString.bufferToHex(bArr));
    }
}
