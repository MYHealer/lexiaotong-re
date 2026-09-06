package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.SettingListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SetBluetoothDeviceActivity extends BaseActivity {
    private String deviceMac;
    private BluetoothDevice mBluetoothDevice;
    private EditText mDeviceEditView;
    private EditText mEtMaxMoney;
    private EditText mEtMoneyLi;
    private String mF5Data;
    private EditText mMoneyEditView;
    private EditText mNumberEditView;
    private EditText mQValueEditView;
    private EditText mReportEditView;
    private EditText mSpeedEditView;
    private TitleBar mTitleBar;
    private Button mWriteButton;
    private String mDeviceType = "01";
    private boolean mIsEnable = true;
    private SettingListener mSettingListener = new SettingListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SetBluetoothDeviceActivity.2
        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onStart(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onSuccess(BluetoothDevice bluetoothDevice) {
            if (SetBluetoothDeviceActivity.this.mIsEnable) {
                BaseMaterialDialog.dissmisMaterialDialog();
                ToastUtils.show(SetBluetoothDeviceActivity.this.getContext(), "设置成功");
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            String str;
            if (SetBluetoothDeviceActivity.this.mIsEnable) {
                BaseMaterialDialog.dissmisMaterialDialog();
                if (timeOut == TimeOut.Connect) {
                    str = "水控连接超时";
                } else if (timeOut == TimeOut.Discover) {
                    str = "查找水控超时";
                } else if (timeOut == TimeOut.SendGetDeviceSettingCommand) {
                    str = "获取参数超时";
                } else {
                    str = timeOut == TimeOut.WriteSetting ? "写入参数超时" : timeOut + "";
                }
                if (timeOut != null) {
                    SystemErrorTip.getInstance().showTipDialog(SetBluetoothDeviceActivity.this.getActivity(), str);
                } else {
                    SystemErrorTip.getInstance().showTipDialog(SetBluetoothDeviceActivity.this.getActivity(), "设置失败:" + timeOut);
                }
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onBluetoothException(ClientException clientException) {
            if (SetBluetoothDeviceActivity.this.mIsEnable) {
                BaseMaterialDialog.dissmisMaterialDialog();
                ToastUtils.show(SetBluetoothDeviceActivity.this.getContext(), "请打开蓝牙");
            }
        }
    };

    static {
        StubApp.interface11(6583);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i, String str3) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SetBluetoothDeviceActivity.class).putExtra("deviceMac", str).putExtra("devicehexid", str2).putExtra("version", i).putExtra("f5data", str3));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mWriteButton = (Button) findViewById(R.id.btn_set);
        this.mDeviceEditView = (EditText) findViewById(R.id.et_type);
        this.mNumberEditView = (EditText) findViewById(R.id.et_shanqu);
        this.mMoneyEditView = (EditText) findViewById(R.id.et_money);
        this.mSpeedEditView = (EditText) findViewById(R.id.et_maichong);
        this.mQValueEditView = (EditText) findViewById(R.id.et_maichongq);
        this.mReportEditView = (EditText) findViewById(R.id.et_time);
        this.mEtMoneyLi = (EditText) findViewById(R.id.et_limoney);
        this.mEtMaxMoney = (EditText) findViewById(R.id.et_maxmoney);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.SetBluetoothDeviceActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SetBluetoothDeviceActivity.this.setValue();
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("设置参数");
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue() {
        if (StringUtils.isEmpty(this.mDeviceEditView.getText().toString())) {
            ToastUtils.show(getActivity(), "请设置设备类型");
            return;
        }
        if (StringUtils.isEmpty(this.mNumberEditView.getText().toString())) {
            ToastUtils.show(getActivity(), "请设置扇区号");
            return;
        }
        if (Double.parseDouble(this.mEtMaxMoney.getText().toString()) == 0.0d || Double.parseDouble(this.mEtMaxMoney.getText().toString()) > 50.0d) {
            ToastUtils.show(getActivity(), "设备限额取值范围1-50元");
            return;
        }
        if (StringUtils.isEmpty(this.mEtMoneyLi.getText().toString())) {
            ToastUtils.show(getActivity(), "请设置费率厘");
            return;
        }
        if (StringUtils.isEmpty(this.mMoneyEditView.getText().toString())) {
            ToastUtils.show(getActivity(), "请设置热水费率");
            return;
        }
        if (StringUtils.isEmpty(this.mSpeedEditView.getText().toString())) {
            ToastUtils.show(getActivity(), "请设置脉冲或秒");
            return;
        }
        if (StringUtils.isEmpty(this.mQValueEditView.getText().toString())) {
            ToastUtils.show(getActivity(), "请设置脉冲Q值");
            return;
        }
        if (StringUtils.isEmpty(this.mReportEditView.getText().toString())) {
            ToastUtils.show(getActivity(), "请设置报警时间");
            return;
        }
        int i = Integer.parseInt(this.mMoneyEditView.getText().toString());
        int i2 = Integer.parseInt(this.mSpeedEditView.getText().toString());
        int i3 = Integer.parseInt(this.mQValueEditView.getText().toString());
        int i4 = Integer.parseInt(this.mReportEditView.getText().toString());
        int i5 = Integer.parseInt(this.mNumberEditView.getText().toString());
        if (!this.mDeviceEditView.getText().toString().equals("01") && !this.mDeviceEditView.getText().toString().equals("02") && !this.mDeviceEditView.getText().toString().equals("00")) {
            ToastUtils.show(getContext(), "设备类型只能输入01或02");
            return;
        }
        if (i5 > 255 || i5 < 1) {
            ToastUtils.show(getContext(), "扇区区间是01-255");
            return;
        }
        if (i > 255) {
            ToastUtils.show(getContext(), "热水费率要小于255分");
            return;
        }
        if (i2 > 255) {
            ToastUtils.show(getContext(), "热水费率要小于255秒/脉冲）");
            return;
        }
        if (i3 > 255) {
            ToastUtils.show(getContext(), "脉冲Q值要小于255");
            return;
        }
        if (i4 > 255) {
            ToastUtils.show(getContext(), "报警时间要小于255");
            return;
        }
        if (BaseMaterialDialog.isShowMaterialDialog()) {
            return;
        }
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在写入参数信息...", false);
        LeXiaoTongSDK.getInstance().settingDevice(this.mBluetoothDevice, this.mSettingListener, ((((getTwoData(this.mDeviceEditView.getText().toString()) + getTwoData(getHexData(this.mNumberEditView.getText().toString())) + getTwoData(getHexData(this.mMoneyEditView.getText().toString())) + getTwoData(getHexData(this.mSpeedEditView.getText().toString())) + getTwoData(getHexData(this.mQValueEditView.getText().toString())) + getTwoData(getHexData(Integer.parseInt(this.mReportEditView.getText().toString()) + "")) + "00") + new SimpleDateFormat("yyMMddHHmm").format(Calendar.getInstance().getTime())) + getTwoData(this.mEtMoneyLi.getText().toString())) + this.mDeviceType) + getFourString(Integer.toHexString((int) (Float.parseFloat(this.mEtMaxMoney.getText().toString()) * 100.0f))), getLoginAccount().getUid());
    }

    private String getHexData(String str) {
        return Integer.toHexString(Integer.parseInt(str));
    }

    private String getTwoData(String str) {
        return str.length() < 2 ? "0" + str : str;
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
}
