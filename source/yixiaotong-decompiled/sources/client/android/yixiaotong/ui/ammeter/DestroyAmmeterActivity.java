package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterDestroyBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothDevice;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.google.android.exoplayer2.C;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DestroyAmmeterActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_WALLET = "extra_wallet";
    private AmmeterBluetoothDevice mAmmeterBluetoothDevice;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private boolean mAmmeterStatus;
    private Button mDestroy;
    private String mDeviceNo;
    private String mDeviceTime;
    private String mMac;
    private MaterialDialog mMaterialDialog;
    private TitleBar mTitleBar;
    private TextView mTvBalance;
    private TextView mTvKWH;
    private String mUserNo;
    private WalletModel mWalletModel;
    private boolean mConnected = false;
    private boolean mSupport = false;
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";

    static {
        StubApp.interface11(6269);
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
    public void onDeviceFound(String str) {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    public static void launch(Activity activity, WalletModel walletModel, String str) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) DestroyAmmeterActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("extra_mac", str);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mDestroy = (Button) findViewById(R.id.btn_destroy);
        this.mTvBalance = (TextView) findViewById(R.id.tv_balance);
        this.mTvKWH = (TextView) findViewById(R.id.tv_kwh);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.DestroyAmmeterActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int i = (int) (Float.parseFloat(DestroyAmmeterActivity.this.mTvBalance.getText().toString()) * 100.0f);
            int i2 = (int) (Float.parseFloat(DestroyAmmeterActivity.this.mTvKWH.getText().toString()) * 100.0f);
            OrderIdUtils.getLocalDate("yyyyMMddHHmmss");
            String str = DestroyAmmeterActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().StudentName;
            String localDate = OrderIdUtils.getLocalDate("yyyyMMddHHmmss");
            final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
            if (StringUtils.isNotEmpty(DestroyAmmeterActivity.this.mDeviceNo) && StringUtils.isNotEmpty(DestroyAmmeterActivity.this.mDeviceTime) && StringUtils.isNotEmpty(DestroyAmmeterActivity.this.mUserNo)) {
                BusinessControllers.getInstance().ammeterSales(DestroyAmmeterActivity.this.getLoginAccount(), DestroyAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress, i + "", DestroyAmmeterActivity.this.mDeviceNo, i2 + "", DestroyAmmeterActivity.this.mDeviceTime, str, localDate, randNumMaxStringNonO, DestroyAmmeterActivity.this.mUserNo, new Listener<AmmeterDestroyBean>() { // from class: client.android.yixiaotong.ui.ammeter.DestroyAmmeterActivity.1.1
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        DestroyAmmeterActivity.this.showDialog();
                        if (DestroyAmmeterActivity.this.mMaterialDialog != null) {
                            DestroyAmmeterActivity.this.mMaterialDialog.setContent("正在开始销户...");
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, AmmeterDestroyBean ammeterDestroyBean, Object... objArr) {
                        if (!randNumMaxStringNonO.equals(ammeterDestroyBean.rand) || !DestroyAmmeterActivity.this.mAmmeterStatus) {
                            DestroyAmmeterActivity.this.dismissDialog();
                            ToastUtils.show(DestroyAmmeterActivity.this.getActivity(), "电表已经销户了");
                        } else {
                            DestroyAmmeterActivity.this.sendWriteAccountRechargeDestroy(DestroyAmmeterActivity.this.mReceivedCode);
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (clientException.getCode() == 4059) {
                            DestroyAmmeterActivity.this.salesSuccess();
                        } else {
                            DestroyAmmeterActivity.this.dismissDialog();
                            ToastUtils.show(DestroyAmmeterActivity.this.getActivity(), clientException.getDetail());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void salesSuccess() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterSalesSuccess(getLoginAccount(), this.mUserNo, randNumMaxStringNonO, this.mMac, this.mDeviceNo.substring(4), new Listener<AmmeterDestroyBean>() { // from class: client.android.yixiaotong.ui.ammeter.DestroyAmmeterActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterDestroyBean ammeterDestroyBean, Object... objArr) {
                DestroyAmmeterActivity.this.dismissDialog();
                if (StringUtils.isNotEmpty(ammeterDestroyBean.rand) && randNumMaxStringNonO.equals(ammeterDestroyBean.rand)) {
                    ToastUtils.show(DestroyAmmeterActivity.this.getContext(), "销户成功");
                    DestroyAmmeterActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                DestroyAmmeterActivity.this.dismissDialog();
                ToastUtils.show(DestroyAmmeterActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("电表销户");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        AmmeterBluetoothManager.getInstance().stopScan();
        AmmeterBluetoothManager.getInstance().disConnectAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("正在连接中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.DestroyAmmeterActivity.3
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

    private void connet() {
        this.mAmmeterBluetoothManager.disConnectAll();
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.DestroyAmmeterActivity.4
            @Override // java.lang.Runnable
            public void run() {
                DestroyAmmeterActivity.this.mAmmeterBluetoothManager.connect(DestroyAmmeterActivity.this.mAmmeterBluetoothDevice.mAddress);
                MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.DestroyAmmeterActivity.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (DestroyAmmeterActivity.this.mSupport && DestroyAmmeterActivity.this.mConnected) {
                            return;
                        }
                        ToastUtils.show(DestroyAmmeterActivity.this.getContext(), "电表蓝牙匹配超时！");
                        DestroyAmmeterActivity.this.finish();
                    }
                }, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetDeviceInfoData() {
        this.mReceivedCode = "FF";
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAmmeterBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceInfo(randNumMaxString)));
    }

    private void sendGetDeviceTypeStatusData(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAmmeterBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceTypeAndState(str, randNumMaxString)));
    }

    private void sendGetDeviceNoUserNoDateBalabceEle(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAmmeterBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceNoUserNoDateBalabceEle(str, randNumMaxString)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWriteAccountRechargeDestroy(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mAmmeterBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.writeAccountRechargeDestroy("02", (short) 0, str, randNumMaxString)));
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "电表的蓝牙信号不稳定，请靠近电表后重试!");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getContext(), "连接电表失败!");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (!z) {
            ToastUtils.show(getContext(), "你连接的不是电表设备");
        } else {
            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.DestroyAmmeterActivity.5
                @Override // java.lang.Runnable
                public void run() {
                    DestroyAmmeterActivity.this.sendGetDeviceInfoData();
                }
            }, 1000L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onSendDataFailed() {
        ToastUtils.show(getContext(), "数据发送失败！");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onBLEState(boolean z) {
        this.mConnected = z;
        this.mSupport = z;
        showDialog();
        if (!z) {
            connet();
            return;
        }
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null) {
            materialDialog.setContent("正在获取电表的数据");
        }
        sendGetDeviceInfoData();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strDivide;
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                String upperCase2 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase2;
                sendGetDeviceTypeStatusData(upperCase2);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("82".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase3 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase3;
            if (this.mSendCode.equals(upperCase3)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                if (Integer.toBinaryString(Integer.parseInt(strBufferToHex.substring(8, 10), 16)).length() < 8) {
                    this.mAmmeterStatus = false;
                } else {
                    this.mAmmeterStatus = true;
                }
                sendGetDeviceNoUserNoDateBalabceEle(this.mReceivedCode);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B6".equals(strBufferToHex.substring(4, 6))) {
            dismissDialog();
            String upperCase4 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase4;
            if (this.mSendCode.equals(upperCase4)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                this.mDeviceNo = strBufferToHex.substring(6, 22);
                this.mUserNo = strBufferToHex.substring(22, 46);
                StringBuilder sb = new StringBuilder();
                sb.append(BaseWrapper.ENTER_ID_SYSTEM_HELPER + strBufferToHex.substring(46, 48));
                sb.append(strBufferToHex.substring(48, 50));
                sb.append(strBufferToHex.substring(50, 52));
                sb.append(strBufferToHex.substring(54, 56));
                sb.append(strBufferToHex.substring(56, 58));
                sb.append(strBufferToHex.substring(58, 60));
                this.mDeviceTime = sb.toString();
                String strSubstring = strBufferToHex.substring(61, 68);
                String upperCase5 = strBufferToHex.substring(60, 61).toUpperCase();
                short s = Short.parseShort(upperCase5, 16);
                if (s < 8) {
                    strDivide = DecimalUtil.divide(upperCase5 + strSubstring, "100");
                } else {
                    strDivide = x.A + DecimalUtil.divide(((s - 8) + "") + strSubstring, "100");
                }
                this.mTvBalance.setText(DecimalUtil.twoDecimal(strDivide));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Float.parseFloat(strBufferToHex.substring(68, 76)) / 100.0f);
                this.mTvKWH.setText(sb2.toString());
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("8B".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            dismissDialog();
            String upperCase6 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase6;
            if (this.mSendCode.equals(upperCase6)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                salesSuccess();
                return;
            } else {
                ToastUtils.show(getContext(), "校验码出错啦！");
                return;
            }
        }
        if ("8C".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            dismissDialog();
            String upperCase7 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase7;
            if (this.mSendCode.equals(upperCase7)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                ToastUtils.show(getContext(), "销户失败");
                return;
            } else {
                ToastUtils.show(getContext(), "校验码出错啦！");
                return;
            }
        }
        dismissDialog();
        String strSubstring2 = strBufferToHex.substring(4, 6);
        if (strSubstring2.toUpperCase().equals("CB")) {
            ToastUtils.show(getContext(), "销户存在异常！");
            return;
        }
        if (strSubstring2.toUpperCase().equals("F6")) {
            ToastUtils.show(getContext(), "设备编号用户编号日期和时间余额用电量存在异常！");
            return;
        }
        if (strSubstring2.toUpperCase().equals("C1")) {
            ToastUtils.show(getContext(), "获取设备状态存在异常！");
        } else if (strSubstring2.toUpperCase().equals("C2")) {
            ToastUtils.show(getContext(), "获取设备类型和状态存在异常！");
        } else {
            ToastUtils.show(getContext(), "未知错误");
        }
    }
}
