package client.android.yixiaotong.ui.deviceinit;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.init.SetNBDrinkWaterBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.drinkwater.DrinkWaterCommand;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.exoplayer2.ExoPlayer;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class DeviceSetDrinkWaterActivity extends BaseActivity {
    public static final String EXTRA_F0 = "extra_f0";
    public static final String EXTRA_MAC = "extra_mac";
    public static final String EXTRA_MACHINERAND = "extra_machinerand";
    public static final String EXTRA_MACHINEVER = "extra_machinever";
    public static final String EXTRA_WALLET = "extra_wallet";
    private String mAuthSetData;
    private BluetoothDevice mBluetoothDevice;
    private EditText mEtColdMaiChong;
    private EditText mEtColdMoney;
    private EditText mEtLiMoney;
    private EditText mEtLiMoney2;
    private EditText mEtMaiChong;
    private EditText mEtMaiChongQ;
    private EditText mEtMaxMoney;
    private EditText mEtMoney;
    private EditText mEtShanQu;
    private EditText mEtTime;
    private EditText mEtType;
    private String mF0Data;
    private LocalPreferencesHelper mLocalPreferenceshelper;
    private String mMac;
    private String mMachineId;
    private String mMachineRand;
    private int mMachineTypeid;
    private int mMachineVer;
    private MaterialDialog mMaterialDialog;
    private RelativeLayout mRelColdFeiLv;
    private TitleBar mTitleBar;
    private WalletModel mWalletModel;
    public StringBuilder stringBuilderAll;
    private String mSetData = "010203040506070809";
    private boolean mIsEnable = true;
    private int mConnectCount = 0;
    private ConnectState mConnectState = ConnectState.none;
    private SendDataState mSendDataState = SendDataState.none;
    private boolean mIsAutoConnect = true;
    public int leftCount = 0;

    private enum ConnectState {
        none,
        connecting,
        connected,
        disconnect
    }

    private enum SendDataState {
        none,
        f08,
        f07
    }

    static {
        StubApp.interface11(6741);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) DeviceSetDrinkWaterActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_f0", str).putExtra("extra_machinerand", str2).putExtra("extra_mac", str3));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.tb_name);
        this.mEtShanQu = (EditText) findViewById(R.id.et_shanqu);
        this.mEtMoney = (EditText) findViewById(R.id.et_money);
        this.mEtMaiChong = (EditText) findViewById(R.id.et_maichong);
        this.mEtColdMoney = (EditText) findViewById(R.id.et_money1);
        this.mEtColdMaiChong = (EditText) findViewById(R.id.et_maichong1);
        this.mEtMaiChongQ = (EditText) findViewById(R.id.et_maichongq);
        this.mEtTime = (EditText) findViewById(R.id.et_time);
        this.mEtType = (EditText) findViewById(R.id.et_type);
        this.mEtMaxMoney = (EditText) findViewById(R.id.et_maxmoney);
        this.mRelColdFeiLv = (RelativeLayout) findViewById(R.id.rel_coldfeilv);
        this.mEtLiMoney = (EditText) findViewById(R.id.et_limoney);
        this.mEtLiMoney2 = (EditText) findViewById(R.id.et_limoney2);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设备参数");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initView() {
        int i = this.mWalletModel.typeId;
        String string = this.mLocalPreferenceshelper.getString("setdata");
        if (StringUtils.isNotEmpty(string) && string.length() == 24) {
            this.mEtMoney.setText(Integer.parseInt(string.substring(0, 2), 16) + "");
            this.mEtMaiChong.setText(Integer.parseInt(string.substring(2, 4), 16) + "");
            this.mEtLiMoney.setText(Integer.parseInt(string.substring(4, 6), 16) + "");
            this.mEtMaxMoney.setText((Integer.parseInt(string.substring(6, 10), 16) / 100) + "");
            this.mEtType.setText(string.substring(10, 12));
            this.mEtMaiChongQ.setText(Integer.parseInt(string.substring(12, 14), 16) + "");
            this.mEtTime.setText(Integer.parseInt(string.substring(14, 16), 16) + "");
            this.mEtShanQu.setText(Integer.parseInt(string.substring(16, 18), 16) + "");
            this.mEtColdMoney.setText(Integer.parseInt(string.substring(18, 20), 16) + "");
            this.mEtColdMaiChong.setText(Integer.parseInt(string.substring(20, 22), 16) + "");
            this.mEtLiMoney2.setText(Integer.parseInt(string.substring(22, 24), 16) + "");
        }
    }

    public void onSet(View view) {
        this.mIsAutoConnect = true;
        this.mSetData = "";
        ininData();
        if (StringUtils.isNotEmpty(this.mSetData)) {
            connectDevice();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDeviceConfiguration() {
        String strReceivedResult = BathUtil.receivedResult(this.mF0Data.substring(14, 16), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        String strReceivedResult2 = BathUtil.receivedResult(this.mF0Data.substring(16, 18), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(18, 20), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(20, 22), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        this.mMachineId = this.mF0Data.substring(22, 38);
        this.mMachineTypeid = BathUtil.HexStringToInt(strReceivedResult);
        this.mMachineVer = BathUtil.HexStringToInt(strReceivedResult2);
        Log.e("test", "参数：" + this.mSetData);
        this.mLocalPreferenceshelper.saveOrUpdate("setdata", this.mSetData);
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().postDeviceConfiguration(getLoginAccount(), this.mWalletModel.typeId, this.mMachineId, this.mMachineTypeid, this.mMachineVer, this.mMachineRand, this.mSetData.toUpperCase(), randNumMaxString, "1", new Listener<SetNBDrinkWaterBean>() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceSetDrinkWaterActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (DeviceSetDrinkWaterActivity.this.isShowing()) {
                    DeviceSetDrinkWaterActivity.this.mMaterialDialog.setContent("正在获取参数..");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SetNBDrinkWaterBean setNBDrinkWaterBean, Object... objArr) {
                if (DeviceSetDrinkWaterActivity.this.mIsEnable) {
                    if (setNBDrinkWaterBean == null || !StringUtils.isNotEmpty(setNBDrinkWaterBean.systemdata) || !StringUtils.isNotEmpty(setNBDrinkWaterBean.rand) || !setNBDrinkWaterBean.rand.equals(randNumMaxString)) {
                        DeviceSetDrinkWaterActivity.this.dismissDialog();
                        ToastUtils.show(DeviceSetDrinkWaterActivity.this.getContext(), "获取服务器参数异常");
                        return;
                    }
                    DeviceSetDrinkWaterActivity.this.mAuthSetData = setNBDrinkWaterBean.systemdata;
                    Log.e("test", "授权参数：" + DeviceSetDrinkWaterActivity.this.mAuthSetData);
                    if (DeviceSetDrinkWaterActivity.this.isShowing()) {
                        DeviceSetDrinkWaterActivity.this.mMaterialDialog.setContent("获取参数成功，正在设置参数中..");
                    }
                    final String strSetMachineNoCommand = DrinkWaterCommand.SetMachineNoCommand(DeviceSetDrinkWaterActivity.this.mAuthSetData);
                    if (DeviceSetDrinkWaterActivity.this.mConnectState == ConnectState.connected) {
                        DeviceSetDrinkWaterActivity.this.mSendDataState = SendDataState.f07;
                        if (strSetMachineNoCommand.length() > 40) {
                            BluetoothSDK.getInstance().SendDataManagerDevice(strSetMachineNoCommand.substring(0, 40));
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceSetDrinkWaterActivity.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    BluetoothSDK bluetoothSDK = BluetoothSDK.getInstance();
                                    String str = strSetMachineNoCommand;
                                    bluetoothSDK.SendDataManagerDevice(str.substring(40, str.length()));
                                }
                            }, 10L);
                            return;
                        } else {
                            BluetoothSDK.getInstance().SendDataManagerDevice(strSetMachineNoCommand);
                            return;
                        }
                    }
                    if (DeviceSetDrinkWaterActivity.this.mConnectState != ConnectState.connecting) {
                        DeviceSetDrinkWaterActivity.this.connectDevice();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (DeviceSetDrinkWaterActivity.this.mIsEnable) {
                    DeviceSetDrinkWaterActivity.this.mIsAutoConnect = false;
                    DeviceSetDrinkWaterActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(DeviceSetDrinkWaterActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    private String getTwoString(String str) {
        return (StringUtils.isNotEmpty(str) && str.length() == 1) ? "0" + str : str;
    }

    private String getFourString(String str) {
        if (StringUtils.isNotEmpty(str) && str.length() == 1) {
            return Constant.DEFAULT_CVN2 + str;
        }
        if (StringUtils.isNotEmpty(str) && str.length() == 2) {
            return "00" + str;
        }
        return (StringUtils.isNotEmpty(str) && str.length() == 3) ? "0" + str : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectDevice() {
        showDialog();
        BluetoothSDK.getInstance().ConnectManagerDevice(this.mBluetoothDevice);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        BluetoothSDK.getInstance().closeBLE();
    }

    private void setBluetoothListener() {
        this.mBluetoothDevice = new BluetoothDevice("test", this.mMac);
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceSetDrinkWaterActivity.2
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                DeviceSetDrinkWaterActivity.this.mConnectState = ConnectState.connecting;
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                if (DeviceSetDrinkWaterActivity.this.mIsEnable) {
                    Log.e("test", "连接成功");
                    if (DeviceSetDrinkWaterActivity.this.isShowing()) {
                        DeviceSetDrinkWaterActivity.this.mMaterialDialog.setContent("设备连接成功");
                    }
                    DeviceSetDrinkWaterActivity.this.mConnectState = ConnectState.connected;
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceSetDrinkWaterActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (DeviceSetDrinkWaterActivity.this.isShowing()) {
                                DeviceSetDrinkWaterActivity.this.mMaterialDialog.setContent("正在获取随机数");
                            }
                            DeviceSetDrinkWaterActivity.this.mSendDataState = SendDataState.f08;
                            BluetoothSDK.getInstance().SendDataManagerDevice(DrinkWaterCommand.getRandCommand());
                        }
                    }, 500L);
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str) {
                if (DeviceSetDrinkWaterActivity.this.mIsEnable) {
                    Log.e("test", "收到数据:" + str);
                    DeviceSetDrinkWaterActivity.this.receivedData(str);
                    if (DeviceSetDrinkWaterActivity.this.leftCount > 0 || DeviceSetDrinkWaterActivity.this.stringBuilderAll == null || !StringUtils.isNotEmpty(DeviceSetDrinkWaterActivity.this.stringBuilderAll.toString())) {
                        return;
                    }
                    String string = DeviceSetDrinkWaterActivity.this.stringBuilderAll.toString();
                    DeviceSetDrinkWaterActivity.this.stringBuilderAll = null;
                    if (DeviceSetDrinkWaterActivity.this.mSendDataState != SendDataState.f08) {
                        if (DeviceSetDrinkWaterActivity.this.mSendDataState == SendDataState.f07) {
                            DeviceSetDrinkWaterActivity.this.dismissDialog();
                            if (!StringUtils.isNotEmpty(string) || string.length() <= 24) {
                                return;
                            }
                            if ("00".equals(string.substring(22, 24))) {
                                ToastUtils.show(DeviceSetDrinkWaterActivity.this.getContext(), "设置参数成功！");
                            } else {
                                ToastUtils.show(DeviceSetDrinkWaterActivity.this.getContext(), "设置参数失败！");
                            }
                            DeviceSetDrinkWaterActivity.this.mSendDataState = SendDataState.none;
                            BluetoothSDK.getInstance().closeBLE();
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNotEmpty(string) || string.length() <= 30) {
                        return;
                    }
                    DeviceSetDrinkWaterActivity.this.mMachineRand = string.substring(22, 30);
                    DeviceSetDrinkWaterActivity.this.postDeviceConfiguration();
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str) {
                if (DeviceSetDrinkWaterActivity.this.mIsEnable && DeviceSetDrinkWaterActivity.this.mIsAutoConnect) {
                    DeviceSetDrinkWaterActivity.this.dismissDialog();
                    DeviceSetDrinkWaterActivity.this.mConnectState = ConnectState.disconnect;
                    new Thread(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceSetDrinkWaterActivity.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                DeviceSetDrinkWaterActivity.this.mConnectCount++;
                                if (DeviceSetDrinkWaterActivity.this.mConnectCount <= 1) {
                                    BluetoothSDK.getInstance().closeBLE();
                                    Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                    BluetoothSDK.getInstance().ConnectManagerDevice(DeviceSetDrinkWaterActivity.this.mBluetoothDevice);
                                } else {
                                    if (str != null) {
                                        ToastUtils.show(DeviceSetDrinkWaterActivity.this.getContext(), "连接设备超时" + timeOut + str);
                                    } else {
                                        ToastUtils.show(DeviceSetDrinkWaterActivity.this.getContext(), "连接设备失败");
                                    }
                                    BluetoothSDK.getInstance().closeBLE();
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onBluetoothException(android.client.bluetoothsdk.util.ClientException clientException) {
                if (DeviceSetDrinkWaterActivity.this.mIsEnable) {
                    DeviceSetDrinkWaterActivity.this.dismissDialog();
                    DeviceSetDrinkWaterActivity.this.mConnectState = ConnectState.disconnect;
                    ToastUtils.show(DeviceSetDrinkWaterActivity.this.getContext(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void receivedData(String str) {
        StringBuilder sb;
        if (str.startsWith("A5")) {
            this.stringBuilderAll = null;
            StringBuilder sb2 = new StringBuilder();
            this.stringBuilderAll = sb2;
            sb2.append(str);
        } else {
            StringBuilder sb3 = this.stringBuilderAll;
            if (sb3 != null) {
                sb3.append(str);
            }
        }
        StringBuilder sb4 = this.stringBuilderAll;
        if (sb4 != null && sb4.length() >= 4) {
            String strReceivedDataManage = DrinkWaterCommand.receivedDataManage(this.stringBuilderAll.toString());
            StringBuilder sb5 = this.stringBuilderAll;
            sb5.delete(0, sb5.length());
            this.stringBuilderAll.append(strReceivedDataManage);
            this.leftCount = ((Integer.parseInt(this.stringBuilderAll.substring(2, 4), 16) * 2) + 6) - this.stringBuilderAll.length();
        }
        if (this.leftCount > 0 || (sb = this.stringBuilderAll) == null) {
            return;
        }
        sb.toString();
    }

    private void showDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog != null && materialDialog.isShowing()) {
            this.mMaterialDialog.setContent("正在连接设备中...");
        } else {
            this.mMaterialDialog = new MaterialDialog.Builder(getActivity()).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.deviceinit.DeviceSetDrinkWaterActivity.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    BluetoothSDK.getInstance().closeBLE();
                }
            }).content("正在连接设备中...").progress(true, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismissDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog == null || !materialDialog.isShowing()) {
            return;
        }
        this.mMaterialDialog.dismiss();
        this.mMaterialDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isShowing() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        return materialDialog != null && materialDialog.isShowing();
    }

    private void ininData() {
        String string = this.mEtType.getText().toString();
        String string2 = this.mEtShanQu.getText().toString();
        String string3 = this.mEtMoney.getText().toString();
        String string4 = this.mEtMaiChong.getText().toString();
        String string5 = this.mEtColdMoney.getText().toString();
        String string6 = this.mEtColdMaiChong.getText().toString();
        String string7 = this.mEtMaiChongQ.getText().toString();
        String string8 = this.mEtTime.getText().toString();
        if (StringUtils.isEmpty(string2)) {
            ToastUtils.show(getContext(), "请输入扇区号");
            return;
        }
        if (StringUtils.isEmpty(string)) {
            ToastUtils.show(getContext(), "请输入设备类型");
            return;
        }
        if (StringUtils.isEmpty(this.mEtMaxMoney.getText().toString())) {
            ToastUtils.show(getContext(), "请输入设备限额");
            return;
        }
        if (StringUtils.isEmpty(this.mEtLiMoney.getText().toString()) || StringUtils.isEmpty(this.mEtLiMoney2.getText().toString())) {
            ToastUtils.show(getContext(), "请输入厘");
            return;
        }
        if (StringUtils.isEmpty(string3)) {
            ToastUtils.show(getContext(), "请输入热水费率（分）");
            return;
        }
        if (StringUtils.isEmpty(string4)) {
            ToastUtils.show(getContext(), "请输入热水费率（秒/脉冲）");
            return;
        }
        if (this.mWalletModel.typeId != 1) {
            if (StringUtils.isEmpty(string5)) {
                ToastUtils.show(getContext(), "请输入冷水费率（分）");
                return;
            } else if (StringUtils.isEmpty(string6)) {
                ToastUtils.show(getContext(), "请输入冷水费率（秒/脉冲）");
                return;
            }
        }
        if (StringUtils.isEmpty(string7)) {
            ToastUtils.show(getContext(), "请输入脉冲Q值");
            return;
        }
        if (StringUtils.isEmpty(string8)) {
            ToastUtils.show(getContext(), "请输入报警时间");
            return;
        }
        if (Integer.parseInt(this.mEtMaxMoney.getText().toString()) > 50 || Integer.parseInt(this.mEtMaxMoney.getText().toString()) < 1) {
            ToastUtils.show(getContext(), "限额范围是1-50元");
            return;
        }
        int i = Integer.parseInt(this.mEtMaxMoney.getText().toString()) * 100;
        int i2 = Integer.parseInt(this.mEtMoney.getText().toString());
        int i3 = Integer.parseInt(string4);
        int i4 = Integer.parseInt(this.mEtColdMoney.getText().toString());
        int i5 = Integer.parseInt(string6);
        int i6 = Integer.parseInt(string7);
        int i7 = Integer.parseInt(string8);
        int i8 = Integer.parseInt(string2);
        if (!string.equals("01") && !string.equals("02")) {
            ToastUtils.show(getContext(), "设备类型只能输入01或02");
            return;
        }
        if (i8 > 31 || i8 < 1) {
            ToastUtils.show(getContext(), "扇区区间是01-31");
            return;
        }
        if (i2 > 255) {
            ToastUtils.show(getContext(), "热水费率要小于255分");
            return;
        }
        if (i3 > 255) {
            ToastUtils.show(getContext(), "热水费率要小于255秒/脉冲）");
            return;
        }
        if (i4 > 255) {
            ToastUtils.show(getContext(), "冷水费率要小于255分");
            return;
        }
        if (i5 > 255) {
            ToastUtils.show(getContext(), "冷水费率要小于255秒/脉冲）");
            return;
        }
        if (i6 > 255) {
            ToastUtils.show(getContext(), "脉冲Q值要小于255");
            return;
        }
        if (i7 > 255) {
            ToastUtils.show(getContext(), "报警时间要小于255");
            return;
        }
        String twoString = getTwoString(Integer.toHexString(i8));
        String fourString = getFourString(Integer.toHexString(i));
        String twoString2 = getTwoString(Integer.toHexString(i2));
        String hexString = Integer.toHexString(i3);
        String twoString3 = getTwoString(Integer.toHexString(i4));
        String twoString4 = getTwoString(Integer.toHexString(i5));
        String twoString5 = getTwoString(hexString);
        String twoString6 = getTwoString(Integer.toHexString(i6));
        String twoString7 = getTwoString(Integer.toHexString(i7));
        String twoString8 = getTwoString(string);
        String twoString9 = getTwoString(this.mEtLiMoney.getText().toString());
        String twoString10 = getTwoString(this.mEtLiMoney2.getText().toString());
        if (this.mWalletModel.typeId == 1) {
            this.mSetData = twoString2 + twoString5 + twoString9 + fourString + twoString8 + twoString6 + twoString7 + twoString;
        } else {
            this.mSetData = twoString2 + twoString5 + twoString9 + fourString + twoString8 + twoString6 + twoString7 + twoString + twoString3 + twoString4 + twoString10;
        }
    }
}
