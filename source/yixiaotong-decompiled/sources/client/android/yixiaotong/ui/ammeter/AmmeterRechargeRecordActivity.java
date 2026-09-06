package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothDevice;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.util.bluetooth.TimeOut;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AmmeterRechargeRecordActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRAS_DEVICE_NAME = "deviceName";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int MESSAGE_CONNECT = 2;
    public static final int MESSAGE_CONNECTED = 3;
    public static final int MESSAGE_SCAN = 1;
    public static final int MESSAGE_SENDDATA = 4;
    private String mAddress;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private AmmeterBluetoothDevice mBluetoothDevice;
    private TimeOut mCurrentCheckTimeOut;
    private Handler mHandler;
    private MaterialDialog mMaterialDialog;
    private TextView mTvAllMoney;
    private TextView mTvCounts;
    private TextView mTvDate;
    private TextView mTvKwh;
    private TextView mTvLastMoney;
    private TextView mTvShengYuMoney;
    private TextView mTvType;
    private String mUserNo;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";
    private boolean mConnected = false;
    private boolean mSupport = false;
    private Handler handlersend = new Handler();
    final Runnable runnableSend = new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterRechargeRecordActivity.4
        private void sendData() {
            if (!AmmeterRechargeRecordActivity.this.isConnected()) {
                ToastUtils.show(AmmeterRechargeRecordActivity.this.getContext(), "电表已断开，请重新连接电表");
                AmmeterRechargeRecordActivity.this.finish();
            } else {
                AmmeterRechargeRecordActivity.this.sendGetDeviceInfoData();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            sendData();
        }
    };
    private boolean isFoundDevice = false;

    static {
        StubApp.interface11(6215);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnected() {
        return this.mSupport && this.mConnected;
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

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        Intent intent = new Intent(activity, (Class<?>) AmmeterRechargeRecordActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("deviceAddress", str);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvCounts = (TextView) findViewById(R.id.tv_chongzhicount);
        this.mTvLastMoney = (TextView) findViewById(R.id.tv_last_chongzhimoney);
        this.mTvKwh = (TextView) findViewById(R.id.tv_electricityconsumption);
        this.mTvDate = (TextView) findViewById(R.id.tv_date);
        this.mTvType = (TextView) findViewById(R.id.tv_type);
        this.mTvAllMoney = (TextView) findViewById(R.id.tv_allmoney);
        this.mTvShengYuMoney = (TextView) findViewById(R.id.tv_shengyumoney);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("电表信息");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initHandler() {
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterRechargeRecordActivity.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (TimeOut.Scan == AmmeterRechargeRecordActivity.this.mCurrentCheckTimeOut) {
                        AmmeterRechargeRecordActivity.this.dismissDialog();
                        AmmeterRechargeRecordActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        AmmeterRechargeRecordActivity.this.mAmmeterBluetoothManager.stopScan();
                        ToastUtils.show(AmmeterRechargeRecordActivity.this.getActivity(), "无法搜索到您宿舍的电表，请靠近电表后重试！");
                        return;
                    }
                    return;
                }
                if (message.what == 2) {
                    if (TimeOut.Connect == AmmeterRechargeRecordActivity.this.mCurrentCheckTimeOut) {
                        AmmeterRechargeRecordActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(AmmeterRechargeRecordActivity.this.getActivity(), "连接超时，请靠近电表设备后重试");
                        return;
                    }
                    return;
                }
                if (message.what == 4) {
                    if (TimeOut.WriteSetting == AmmeterRechargeRecordActivity.this.mCurrentCheckTimeOut) {
                        AmmeterRechargeRecordActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(AmmeterRechargeRecordActivity.this.getActivity(), "充值超时，可以在充值账单里面重新充值！");
                        return;
                    }
                    return;
                }
                if (message.what == 3) {
                    TimeOut timeOut = TimeOut.Connected;
                    TimeOut unused = AmmeterRechargeRecordActivity.this.mCurrentCheckTimeOut;
                }
            }
        };
    }

    private void clearHandler(Handler handler, Runnable runnable) {
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private void connetAmmeter() {
        this.mAmmeterBluetoothManager.disConnectAll();
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterRechargeRecordActivity.2
            @Override // java.lang.Runnable
            public void run() {
                AmmeterRechargeRecordActivity.this.mAmmeterBluetoothManager.connect(AmmeterRechargeRecordActivity.this.mAddress);
                AmmeterRechargeRecordActivity.this.mCurrentCheckTimeOut = TimeOut.Connect;
                AmmeterRechargeRecordActivity.this.mHandler.sendEmptyMessageDelayed(2, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }
        }, 800L);
    }

    private void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在连接中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.AmmeterRechargeRecordActivity.3
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AmmeterBluetoothManager.getInstance().stopScan();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        clearHandler(this.handlersend, this.runnableSend);
        this.mCurrentCheckTimeOut = null;
        this.mHandler = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetDeviceInfoData() {
        this.mReceivedCode = "FF";
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceInfo(randNumMaxString)));
    }

    private void sendGetDeviceTypeStateUserNoBalanceEle(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceTypeStateUserNoBalanceEle(str, randNumMaxString)));
    }

    private void sendGetPurchaseRecord(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getPurchaseRecord(1, str, randNumMaxString)));
    }

    private void sendGetElectricityConsumptionData(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getElectricityConsumption(str, randNumMaxString)));
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "电表蓝牙信号不好，请重试");
        finish();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "连接电表失败");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDeviceFound(String str) {
        if (StringUtils.isNotEmpty(str) && this.mAddress.equals(str) && !this.isFoundDevice) {
            this.isFoundDevice = true;
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog != null) {
                materialDialog.setContent("已经查找到您宿舍的电表...");
            }
            connetAmmeter();
            this.mAmmeterBluetoothManager.stopScan();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (z) {
            if (isShowingDialog()) {
                this.mMaterialDialog.setContent("电表蓝牙匹配成功，正在连接电表...");
            }
            this.mCurrentCheckTimeOut = TimeOut.Connected;
            this.handlersend.postDelayed(this.runnableSend, 1000L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onSendDataFailed() {
        dismissDialog();
        ToastUtils.show(getContext(), "数据发送失败！");
        finish();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onBLEState(boolean z) {
        this.mConnected = z;
        this.mSupport = z;
        if (isConnected()) {
            showDialog();
            this.mMaterialDialog.setContent("正在获取电表信息");
            sendGetDeviceInfoData();
        } else {
            this.isFoundDevice = false;
            this.mAmmeterBluetoothManager.disConnectAll();
            this.mAmmeterBluetoothManager.startScan();
            showDialog();
            this.mCurrentCheckTimeOut = TimeOut.Scan;
            this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strBufferToHex = HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                String upperCase2 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase2;
                sendGetPurchaseRecord(upperCase2);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B3".equals(strBufferToHex.substring(4, 6))) {
            String upperCase3 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase3;
            if (this.mSendCode.equals(upperCase3)) {
                String upperCase4 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase4;
                sendGetElectricityConsumptionData(upperCase4);
                this.mTvCounts.setText(Integer.parseInt(strBufferToHex.substring(6, 14)) + "");
                this.mTvLastMoney.setText(Integer.parseInt(strBufferToHex.substring(14, 22)) + "");
                String strSubstring = strBufferToHex.substring(22, 24);
                if (strSubstring.equals("00")) {
                    this.mTvType.setText("开户");
                } else if (strSubstring.equals("01")) {
                    this.mTvType.setText("充值");
                } else if (strSubstring.equals("02")) {
                    this.mTvType.setText("销户");
                }
                this.mTvAllMoney.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(Integer.parseInt(strBufferToHex.substring(24, 32)) + "", "100")));
                this.mTvShengYuMoney.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(Integer.parseInt(strBufferToHex.substring(32, 40)) + "", "100")));
                this.mTvDate.setText(BaseWrapper.ENTER_ID_SYSTEM_HELPER + (strBufferToHex.substring(40, 42) + x.A + strBufferToHex.substring(42, 44) + x.A + strBufferToHex.substring(44, 46)) + PPSLabelView.Code + (strBufferToHex.substring(46, 48) + x.bQ + strBufferToHex.substring(48, 50) + x.bQ + strBufferToHex.substring(50, 52)));
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("8C".equals(strBufferToHex.substring(4, 6))) {
            dismissDialog();
            String upperCase5 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase5;
            if (this.mSendCode.equals(upperCase5)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                this.mTvKwh.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(Integer.parseInt(strBufferToHex.substring(6, 14)) + "", "100")));
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        dismissDialog();
        String strSubstring2 = strBufferToHex.substring(4, 6);
        if (strSubstring2.toUpperCase().equals("C1")) {
            ToastUtils.show(getContext(), "获取设备信息存在异常！");
        } else if (strSubstring2.toUpperCase().equals("F3")) {
            ToastUtils.show(getContext(), "获取购电记录存在异常！");
        } else {
            ToastUtils.show(getContext(), "未知错误");
        }
        finish();
    }
}
