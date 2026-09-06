package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AmmeterSettingBean;
import client.android.yixiaotong.controller.bean.AmmeterWriteSettingBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothDevice;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.ammeterbluetooth.UiThreadUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SettingAmmeterActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    private boolean isWrite;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private TextView mBlanceText;
    private AmmeterBluetoothDevice mBluetoothDevice;
    private TextView mCalendarStateText;
    private TextView mCellStateText;
    private TextView mDateText;
    private String mDateTime;
    private String mDeviceAddress;
    private TextView mDeviceNOText;
    private TextView mDeviceText;
    private TextView mDeviceTypeText;
    private TextView mElectricityConsumptionText;
    private EditText mElectrovalenceEdit;
    private MaterialDialog mMaterialDialog;
    private TextView mPowerDirectionalStateText;
    private Button mReadButton;
    private TextView mRelayStateText;
    private TitleBar mTitleBar;
    private TextView mUserNOText;
    private TextView mUserStateText;
    private Button mWriteButton;
    private Button mgetTimeButton;
    private boolean mConnected = false;
    private boolean mSupport = false;
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";
    private Handler handlersend = new Handler();
    final Runnable runnableSend = new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.11
        private void sendData() {
            if (!SettingAmmeterActivity.this.mSupport || !SettingAmmeterActivity.this.mConnected) {
                ToastUtils.show(SettingAmmeterActivity.this.getContext(), "电表已断开，请重新连接电表");
                SettingAmmeterActivity.this.finish();
            } else {
                if (SettingAmmeterActivity.this.mMaterialDialog != null) {
                    SettingAmmeterActivity.this.mMaterialDialog.setContent("正在连接电表...");
                }
                SettingAmmeterActivity.this.sendGetDeviceInfoData();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            sendData();
        }
    };

    static {
        StubApp.interface11(6348);
    }

    private boolean isConnected() {
        return this.mSupport && this.mConnected;
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
    public void onDeviceFound(String str) {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    public static void launch(Activity activity, String str) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) SettingAmmeterActivity.class);
            intent.putExtra("deviceAddress", str);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mReadButton = (Button) findViewById(R.id.read);
        this.mWriteButton = (Button) findViewById(R.id.write);
        this.mgetTimeButton = (Button) findViewById(R.id.getTime_btn);
        this.mElectrovalenceEdit = (EditText) findViewById(R.id.electrovalence_edit);
        this.mDateText = (TextView) findViewById(R.id.date_text);
        this.mDeviceText = (TextView) findViewById(R.id.device_text);
        this.mDeviceNOText = (TextView) findViewById(R.id.deviceNO_text);
        this.mUserNOText = (TextView) findViewById(R.id.userNO_text);
        this.mElectricityConsumptionText = (TextView) findViewById(R.id.electricityconsumption_text);
        this.mBlanceText = (TextView) findViewById(R.id.blance_text);
        this.mDeviceTypeText = (TextView) findViewById(R.id.device_type_text);
        this.mUserStateText = (TextView) findViewById(R.id.user_state_text);
        this.mPowerDirectionalStateText = (TextView) findViewById(R.id.power_directional_state_text);
        this.mCalendarStateText = (TextView) findViewById(R.id.calendar_state_text);
        this.mCellStateText = (TextView) findViewById(R.id.cell_state_text);
        this.mRelayStateText = (TextView) findViewById(R.id.relay_state_text);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingAmmeterActivity.this.onClickRead();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingAmmeterActivity.this.onClickWrite();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingAmmeterActivity.this.mDateText.setText(new SimpleDateFormat(TimeUtils.FORMATDATETIME).format(new Date()));
        }
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setLeftViewIsBack();
        this.mTitleBar.setTitleView("电表参数设置");
        this.mTitleBar.setLeftViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingAmmeterActivity.this.mAmmeterBluetoothManager.disConnectAll();
                SettingAmmeterActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String disPlayDate(String str) {
        if (!StringUtils.isNotEmpty(str) || str.length() != 14) {
            return str;
        }
        return str.substring(0, 4) + x.A + str.substring(4, 6) + x.A + str.substring(6, 8) + PPSLabelView.Code + str.substring(8, 10) + x.bQ + str.substring(10, 12) + x.bQ + str.substring(12, 14);
    }

    private String getDate(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(2, 8));
        String str2 = new SimpleDateFormat("EEEE").format(new Date());
        String[] strArr = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        for (int i = 0; i < 7; i++) {
            if (str2.equals(strArr[i])) {
                str2 = "0" + i;
            }
        }
        sb.append(str2);
        sb.append(str.substring(8, 14));
        return sb.toString();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        dismissDialog();
        AmmeterBluetoothManager ammeterBluetoothManager = this.mAmmeterBluetoothManager;
        if (ammeterBluetoothManager != null) {
            ammeterBluetoothManager.disConnectAll();
        }
        UiThreadUtils.clearHandler(this.handlersend, this.runnableSend);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在匹配电表的蓝牙中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.5
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
    public void onResume() {
        super.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        dismissDialog();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickRead() {
        showDialog();
        this.isWrite = false;
        if (isConnected()) {
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog != null) {
                materialDialog.setContent("正在获取电表的数据...");
            }
            sendGetDeviceInfoData();
            return;
        }
        MaterialDialog materialDialog2 = this.mMaterialDialog;
        if (materialDialog2 != null) {
            materialDialog2.setContent("正在连接电表...");
        }
        this.mAmmeterBluetoothManager.disConnectAll();
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.6
            @Override // java.lang.Runnable
            public void run() {
                SettingAmmeterActivity.this.mAmmeterBluetoothManager.connect(SettingAmmeterActivity.this.mBluetoothDevice.mAddress);
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickWrite() {
        showDialog();
        this.isWrite = true;
        String string = this.mElectrovalenceEdit.getText().toString();
        float f = Float.parseFloat(string);
        if (f < 0.3f || f > 6.55f) {
            ToastUtils.show(getActivity(), "电价的取值范围是 0.30-6.55 元 之间");
            dismissDialog();
            return;
        }
        if (string.length() > 4) {
            ToastUtils.show(getActivity(), "电价只能精确到 分 ");
            dismissDialog();
            return;
        }
        if (isConnected()) {
            MaterialDialog materialDialog = this.mMaterialDialog;
            if (materialDialog != null) {
                materialDialog.setContent("正在获取电价和日期...");
            }
            sendGetDeviceInfoData();
            return;
        }
        MaterialDialog materialDialog2 = this.mMaterialDialog;
        if (materialDialog2 != null) {
            materialDialog2.setContent("正在连接电表...");
        }
        this.mAmmeterBluetoothManager.disConnectAll();
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.7
            @Override // java.lang.Runnable
            public void run() {
                SettingAmmeterActivity.this.mAmmeterBluetoothManager.connect(SettingAmmeterActivity.this.mBluetoothDevice.mAddress);
            }
        }, 800L);
    }

    private void sumbitSettings(int i, float f, String str) {
        BusinessControllers.getInstance().ammeterReadInfo(getLoginAccount(), i + "", ((int) (f * 100.0f)) + "", this.mUserNOText.getText().toString().substring(5), getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "", str, RandomUtils.getRandNumMaxStringNonO(6), new Listener<AmmeterSettingBean>() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (SettingAmmeterActivity.this.mMaterialDialog != null) {
                    SettingAmmeterActivity.this.mMaterialDialog.setContent("参数正在上传到服务器中...");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterSettingBean ammeterSettingBean, Object... objArr) {
                SettingAmmeterActivity.this.dismissDialog();
                ToastUtils.show(SettingAmmeterActivity.this.getActivity(), "参数上传成功");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SettingAmmeterActivity.this.dismissDialog();
                ToastUtils.show(SettingAmmeterActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void getSettingData() {
        String strSubstring = this.mUserNOText.getText().toString().substring(5);
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId + "";
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterWriteInfo(getLoginAccount(), strSubstring, str, randNumMaxStringNonO, new Listener<AmmeterWriteSettingBean>() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, final AmmeterWriteSettingBean ammeterWriteSettingBean, Object... objArr) {
                SettingAmmeterActivity.this.dismissDialog();
                if (StringUtils.isNotEmpty(ammeterWriteSettingBean.rand) && randNumMaxStringNonO.equals(ammeterWriteSettingBean.rand) && StringUtils.isNotEmpty(ammeterWriteSettingBean.ElectricityPrice) && StringUtils.isNotEmpty(ammeterWriteSettingBean.systemTime)) {
                    new MaterialDialog.Builder(SettingAmmeterActivity.this.getContext()).title("写入参数").content("电价：" + DecimalUtil.divide(ammeterWriteSettingBean.ElectricityPrice, "100") + "元\n\n日期：" + SettingAmmeterActivity.this.disPlayDate(ammeterWriteSettingBean.systemTime)).cancelable(true).positiveText("确定").onPositive(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.9.2
                        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                            SettingAmmeterActivity.this.mElectrovalenceEdit.setText(DecimalUtil.divide(ammeterWriteSettingBean.ElectricityPrice, "100"));
                            SettingAmmeterActivity.this.mDateTime = ammeterWriteSettingBean.systemTime;
                            SettingAmmeterActivity.this.sendWriteDateAndElectrovalence(ammeterWriteSettingBean.systemTime, SettingAmmeterActivity.this.mReceivedCode);
                            if (SettingAmmeterActivity.this.mMaterialDialog != null) {
                                SettingAmmeterActivity.this.mMaterialDialog.setContent("开始写入电价和日期...");
                            } else {
                                SettingAmmeterActivity.this.showDialog();
                                SettingAmmeterActivity.this.mMaterialDialog.setContent("开始写入电价和日期...");
                            }
                        }
                    }).negativeText("取消").onNegative(new MaterialDialog.SingleButtonCallback() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.9.1
                        @Override // com.afollestad.materialdialogs.MaterialDialog.SingleButtonCallback
                        public void onClick(MaterialDialog materialDialog, DialogAction dialogAction) {
                        }
                    }).show();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SettingAmmeterActivity.this.dismissDialog();
                ToastUtils.show(SettingAmmeterActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void setSuccess() {
        String strSubstring = this.mUserNOText.getText().toString().substring(5);
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterWriteInfoSuccess(getLoginAccount(), strSubstring, randNumMaxStringNonO, new Listener<AmmeterWriteSettingBean>() { // from class: client.android.yixiaotong.ui.ammeter.SettingAmmeterActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterWriteSettingBean ammeterWriteSettingBean, Object... objArr) {
                SettingAmmeterActivity.this.dismissDialog();
                if (StringUtils.isNotEmpty(ammeterWriteSettingBean.rand) && randNumMaxStringNonO.equals(ammeterWriteSettingBean.rand)) {
                    ToastUtils.show(SettingAmmeterActivity.this.getContext(), "写入日期电价成功");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                SettingAmmeterActivity.this.dismissDialog();
                ToastUtils.show(SettingAmmeterActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetDeviceInfoData() {
        this.mReceivedCode = "FF";
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceInfo(randNumMaxString)));
    }

    private void sendGetAllInfo(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getAllInfo(str, randNumMaxString)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendWriteDateAndElectrovalence(String str, String str2) {
        this.mSendCode = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.writeDateTimeAndEle(getDate(str), this.mElectrovalenceEdit.getText().toString(), str2, this.mSendCode)));
    }

    private void sendReadElectrovalence(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getElectrovalence(str, randNumMaxString)));
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getActivity(), "电表蓝牙信号不好，请重试");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        dismissDialog();
        AmmeterBluetoothManager.getInstance().disConnectAll();
        ToastUtils.show(getActivity(), "连接电表失败");
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (z) {
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
        finish();
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strDivide;
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6))) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                if (this.isWrite) {
                    getSettingData();
                    return;
                }
                String strHexToAscii = AmmeterCommandUtils.hexToAscii(strBufferToHex.substring(6));
                String[] strArrSplit = strHexToAscii.split(",");
                if (strArrSplit.length == 3) {
                    this.mDeviceText.setText("制造商：" + strArrSplit[0] + "  硬件版本：" + strArrSplit[1] + "  软件版本：" + strArrSplit[2]);
                } else {
                    this.mDeviceText.setText(strHexToAscii);
                }
                sendGetAllInfo(this.mReceivedCode);
                return;
            }
            dismissDialog();
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B0".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase2 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase2;
            if (this.mSendCode.equals(upperCase2)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                ToastUtils.show(getActivity(), "读取参数成功");
                if ("01".equals(strBufferToHex.substring(6, 8))) {
                    this.mDeviceTypeText.setText("蓝牙电表");
                } else {
                    this.mDeviceTypeText.setText("非蓝牙电表");
                }
                String strSubstring = strBufferToHex.substring(8, 10);
                String binaryString = Integer.toBinaryString(Integer.parseInt(strSubstring, 16));
                if (binaryString.length() < 8) {
                    ToastUtils.show(this, "请找管理员开户");
                    this.mUserStateText.setText("未开户");
                } else {
                    if (binaryString.substring(0, 1).equals("1")) {
                        this.mUserStateText.setText("已开户");
                    } else {
                        this.mUserStateText.setText("未开户");
                    }
                    if (binaryString.substring(3, 4).equals("0")) {
                        this.mPowerDirectionalStateText.setText("正向");
                    } else {
                        this.mPowerDirectionalStateText.setText("反向");
                    }
                    if (binaryString.substring(4, 5).equals("0")) {
                        this.mCalendarStateText.setText("正常");
                    } else {
                        this.mCalendarStateText.setText("错误");
                    }
                    if (binaryString.substring(5, 6).equals("0")) {
                        this.mCellStateText.setText("正常");
                    } else {
                        this.mCellStateText.setText("欠压");
                    }
                    if (binaryString.substring(7, 8).equals("0")) {
                        this.mRelayStateText.setText("闭合");
                    } else {
                        this.mRelayStateText.setText("断开");
                    }
                }
                this.mDeviceNOText.setText("设备编号：" + strBufferToHex.substring(10, 26));
                this.mUserNOText.setText("用户编号：" + strBufferToHex.substring(26, 50));
                StringBuilder sb = new StringBuilder();
                sb.append(BaseWrapper.ENTER_ID_SYSTEM_HELPER + strBufferToHex.substring(50, 52) + x.A);
                sb.append(strBufferToHex.substring(52, 54) + x.A);
                sb.append(strBufferToHex.substring(54, 56) + PPSLabelView.Code);
                sb.append(strBufferToHex.substring(58, 60) + x.bQ);
                sb.append(strBufferToHex.substring(60, 62) + x.bQ);
                sb.append(strBufferToHex.substring(62, 64));
                this.mDateText.setText(sb.toString());
                this.mElectrovalenceEdit.setText(DecimalUtil.divide(strBufferToHex.substring(64, 72), "10000") + "");
                String strSubstring2 = strBufferToHex.substring(73, 80);
                String upperCase3 = strBufferToHex.substring(72, 73).toUpperCase();
                short s = Short.parseShort(upperCase3, 16);
                if (s < 8) {
                    strDivide = DecimalUtil.divide(upperCase3 + strSubstring2, "100");
                } else {
                    strDivide = x.A + DecimalUtil.divide(((s - 8) + "") + strSubstring2, "100");
                }
                String strTwoDecimal = DecimalUtil.twoDecimal(strDivide);
                this.mBlanceText.setText(strTwoDecimal + " 元");
                float f = Float.parseFloat(strBufferToHex.substring(88, 96)) / 100.0f;
                this.mElectricityConsumptionText.setText(f + "  kwh");
                this.mWriteButton.setVisibility(0);
                sumbitSettings((int) (Float.parseFloat(strTwoDecimal) * 100.0f), f, strSubstring);
                return;
            }
            dismissDialog();
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B2".equals(strBufferToHex.substring(4, 6))) {
            String upperCase4 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase4;
            if (this.mSendCode.equals(upperCase4)) {
                String upperCase5 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase5;
                sendReadElectrovalence(upperCase5);
                return;
            } else {
                dismissDialog();
                ToastUtils.show(getContext(), "校验码出错啦！");
                return;
            }
        }
        if ("88".equals(strBufferToHex.substring(4, 6))) {
            String upperCase6 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase6;
            if (this.mSendCode.equals(upperCase6)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                if (this.mElectrovalenceEdit.getText().toString().equals(DecimalUtil.divide(strBufferToHex.substring(6, 14), "10000"))) {
                    setSuccess();
                    return;
                } else {
                    ToastUtils.show(getActivity(), "写入电价失败");
                    return;
                }
            }
            dismissDialog();
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        dismissDialog();
        String strSubstring3 = strBufferToHex.substring(4, 6);
        if (strSubstring3.toUpperCase().equals("C9")) {
            ToastUtils.show(getContext(), "写入电价失败！");
        } else if (strSubstring3.toUpperCase().equals("C1")) {
            ToastUtils.show(getContext(), "获取设备信息存在异常！");
        } else if (strSubstring3.toUpperCase().equals("C7")) {
            ToastUtils.show(getContext(), "写入日期失败！");
        } else if (strSubstring3.toUpperCase().equals("F2")) {
            ToastUtils.show(getContext(), "写入日期电价失败！");
        }
        if (strSubstring3.toUpperCase().equals("C8")) {
            ToastUtils.show(getContext(), "获取电价失败！");
        } else {
            ToastUtils.show(getContext(), "未知错误");
        }
        finish();
    }
}
