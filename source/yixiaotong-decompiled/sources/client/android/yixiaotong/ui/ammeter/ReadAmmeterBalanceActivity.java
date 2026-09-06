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
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterEndBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
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
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.math.BigDecimal;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ReadAmmeterBalanceActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRAS_DEVICE_NAME = "deviceName";
    public static final String EXTRA_WALLET = "extra_wallet";
    public static final int MESSAGE_CONNECT = 2;
    public static final int MESSAGE_CONNECTED = 3;
    public static final int MESSAGE_GETDATA = 7;
    public static final int MESSAGE_SCAN = 1;
    public static final int MESSAGE_SCANCOUNT = 5;
    public static final int MESSAGE_SENDDATA = 4;
    private String mAddress;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private AmmeterBluetoothDevice mBluetoothDevice;
    private TimeOut mCurrentCheckTimeOut;
    private Handler mHandler;
    private MaterialDialog mMaterialDialog;
    private TextView mTvAmmeterBalance;
    private TextView mTvKWH;
    private String mUserNo;
    private TitleBar mVTitleBar;
    private WalletModel mWalletModel;
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";
    private int getDataMessage = 8;
    private boolean mConnected = false;
    private boolean mSupport = false;
    private Handler handlersend = new Handler();
    final Runnable runnableSend = new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.ReadAmmeterBalanceActivity.5
        private void sendData() {
            if (!ReadAmmeterBalanceActivity.this.isConnected()) {
                ToastUtils.show(ReadAmmeterBalanceActivity.this.getContext(), "电表已断开，请重新连接电表");
                ReadAmmeterBalanceActivity.this.finish();
            } else {
                ReadAmmeterBalanceActivity.this.sendGetDeviceInfoData();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            sendData();
        }
    };
    private boolean isFoundDevice = false;

    static {
        StubApp.interface11(6302);
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

    static /* synthetic */ int access$810(ReadAmmeterBalanceActivity readAmmeterBalanceActivity) {
        int i = readAmmeterBalanceActivity.getDataMessage;
        readAmmeterBalanceActivity.getDataMessage = i - 1;
        return i;
    }

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        Intent intent = new Intent(activity, (Class<?>) ReadAmmeterBalanceActivity.class);
        intent.putExtra("extra_wallet", walletModel);
        intent.putExtra("deviceAddress", str);
        activity.startActivity(intent);
    }

    private void initViewNew() {
        this.mVTitleBar = (TitleBar) findViewById(R.id.v_titleBar);
        this.mTvAmmeterBalance = (TextView) findViewById(R.id.tv_balance);
        this.mTvKWH = (TextView) findViewById(R.id.tv_ele);
    }

    private void initTitleBar() {
        this.mVTitleBar.setTitleView("电表信息");
        this.mVTitleBar.setLeftView(R.mipmap.back);
        this.mVTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void readAmmeterInfo() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterDetails(getLoginAccount(), this.mUserNo, randNumMaxStringNonO, new BigDecimal(this.mTvAmmeterBalance.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new BigDecimal(this.mTvKWH.getText().toString()).multiply(new BigDecimal(100.0d)).intValue() + "", new Listener<AmmeterEndBean>() { // from class: client.android.yixiaotong.ui.ammeter.ReadAmmeterBalanceActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterEndBean ammeterEndBean, Object... objArr) {
                ammeterEndBean.rand.equals(randNumMaxStringNonO);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(ReadAmmeterBalanceActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void initHandler() {
        this.mHandler = new Handler() { // from class: client.android.yixiaotong.ui.ammeter.ReadAmmeterBalanceActivity.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    if (TimeOut.Scan == ReadAmmeterBalanceActivity.this.mCurrentCheckTimeOut) {
                        ReadAmmeterBalanceActivity.this.dismissDialog();
                        ReadAmmeterBalanceActivity.this.mAmmeterBluetoothManager.disConnectAll();
                        ReadAmmeterBalanceActivity.this.mAmmeterBluetoothManager.stopScan();
                        ToastUtils.show(ReadAmmeterBalanceActivity.this.getActivity(), "无法搜索到您宿舍的电表，请靠近电表后重试！");
                        return;
                    }
                    return;
                }
                if (message.what == 2) {
                    if (TimeOut.Connect == ReadAmmeterBalanceActivity.this.mCurrentCheckTimeOut) {
                        ReadAmmeterBalanceActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(ReadAmmeterBalanceActivity.this.getActivity(), "连接超时，请靠近电表设备后重试");
                        return;
                    }
                    return;
                }
                if (message.what == 4) {
                    if (TimeOut.WriteSetting == ReadAmmeterBalanceActivity.this.mCurrentCheckTimeOut) {
                        ReadAmmeterBalanceActivity.this.dismissDialog();
                        AmmeterBluetoothManager.getInstance().disConnectAll();
                        ToastUtils.show(ReadAmmeterBalanceActivity.this.getActivity(), "充值超时，可以在充值账单里面重新充值！");
                        return;
                    }
                    return;
                }
                if (message.what == 3) {
                    TimeOut timeOut = TimeOut.Connected;
                    TimeOut unused = ReadAmmeterBalanceActivity.this.mCurrentCheckTimeOut;
                } else {
                    if (message.what != 7 || ReadAmmeterBalanceActivity.this.mMaterialDialog == null) {
                        return;
                    }
                    ReadAmmeterBalanceActivity.access$810(ReadAmmeterBalanceActivity.this);
                    if (ReadAmmeterBalanceActivity.this.getDataMessage > 0) {
                        ReadAmmeterBalanceActivity.this.mMaterialDialog.setContent("正在获取电表信息 " + ReadAmmeterBalanceActivity.this.getDataMessage + " 秒");
                        ReadAmmeterBalanceActivity.this.mHandler.sendEmptyMessageDelayed(7, 1000L);
                    } else {
                        ToastUtils.show(ReadAmmeterBalanceActivity.this.getActivity(), "获取电表数据超时！");
                        ReadAmmeterBalanceActivity.this.finish();
                    }
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
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.ReadAmmeterBalanceActivity.3
            @Override // java.lang.Runnable
            public void run() {
                ReadAmmeterBalanceActivity.this.mAmmeterBluetoothManager.connect(ReadAmmeterBalanceActivity.this.mAddress);
                ReadAmmeterBalanceActivity.this.mCurrentCheckTimeOut = TimeOut.Connect;
                ReadAmmeterBalanceActivity.this.mHandler.sendEmptyMessageDelayed(2, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
            }
        }, 800L);
    }

    private void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在连接中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.ReadAmmeterBalanceActivity.4
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
            this.mMaterialDialog.setContent("正在获取电表信息 8 秒");
            this.mHandler.sendEmptyMessageDelayed(7, 1000L);
            sendGetDeviceInfoData();
            return;
        }
        this.isFoundDevice = false;
        this.mAmmeterBluetoothManager.disConnectAll();
        this.mAmmeterBluetoothManager.startScan();
        showDialog();
        this.mCurrentCheckTimeOut = TimeOut.Scan;
        this.mHandler.sendEmptyMessageDelayed(1, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT);
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strDivide;
        String strBufferToHex = HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                String upperCase2 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase2;
                sendGetDeviceTypeStateUserNoBalanceEle(upperCase2);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B7".equals(strBufferToHex.substring(4, 6))) {
            this.getDataMessage = 0;
            dismissDialog();
            String upperCase3 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase3;
            if (this.mSendCode.equals(upperCase3)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                Integer.toBinaryString(Integer.parseInt(strBufferToHex.substring(8, 10), 16));
                String strSubstring = strBufferToHex.substring(10, 34);
                this.mUserNo = strSubstring;
                if (strSubstring.toUpperCase().contains("FFFFFFFF")) {
                    ToastUtils.show(getActivity(), "用户编号有异常，请联系管理员");
                    finish();
                }
                String strSubstring2 = strBufferToHex.substring(35, 42);
                String upperCase4 = strBufferToHex.substring(34, 35).toUpperCase();
                short s = Short.parseShort(upperCase4, 16);
                if (s < 8) {
                    strDivide = DecimalUtil.divide(upperCase4 + strSubstring2, "100");
                } else {
                    strDivide = x.A + DecimalUtil.divide(((s - 8) + "") + strSubstring2, "100");
                }
                this.mTvAmmeterBalance.setText(DecimalUtil.twoDecimal(strDivide));
                StringBuilder sb = new StringBuilder();
                sb.append(Float.parseFloat(strBufferToHex.substring(42, 50)) / 100.0f);
                this.mTvKWH.setText(sb.toString());
                readAmmeterInfo();
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        dismissDialog();
        String strSubstring3 = strBufferToHex.substring(4, 6);
        if (strSubstring3.toUpperCase().equals("C1")) {
            ToastUtils.show(getContext(), "获取设备信息存在异常！");
        } else if (strSubstring3.toUpperCase().equals("F7")) {
            ToastUtils.show(getContext(), "备类型和状态用户编号余额用电量存在异常！");
        } else {
            ToastUtils.show(getContext(), "未知错误");
        }
        finish();
    }
}
