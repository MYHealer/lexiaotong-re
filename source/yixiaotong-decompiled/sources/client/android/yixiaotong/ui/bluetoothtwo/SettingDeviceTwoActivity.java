package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.baseutil.CoderUtils;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.bean.GetDeviceQrCodeBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.set.SetBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener;
import client.android.yixiaotong.sdk.runnable.listener.SettingListener;
import client.android.yixiaotong.sdk.runnable.listener.SettingNameListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.dialog.AppTipDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.LimitEditText;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.drinkwater.PreferenceUtil;
import com.afollestad.materialdialogs.MaterialDialog;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class SettingDeviceTwoActivity extends BaseActivity {
    private String deviceMac;
    private String mAddress;
    private BluetoothDevice mBluetoothDevice;
    private EditText mDeviceEditView;
    private String mDeviceHexID;
    private LimitEditText mDeviceNameText;
    private LimitEditText mDeviceNameText1;
    private String mF5Data;
    private EditText mInitEditView;
    public long mInvestorId;
    private MaterialDialog mMaterialDialog;
    private EditText mMoneyEditView;
    private EditText mNumberEditView;
    private EditText mQValueEditView;
    private Button mReadButton;
    private EditText mReportEditView;
    public long mSchoolId;
    private String mSetData;
    private EditText mSpeedEditView;
    private TitleBar mTitleBar;
    public int mTypeId;
    private int mVersion;
    private Button mWriteButton;
    private Button mWriteDeviceNameButton;
    private String mDeviceType = "0000";
    private boolean hasReadParam = false;
    private boolean mIsEnable = true;
    private String mSetDataFail = "正在获取费率中...";
    private boolean mIsSetData = true;
    private ReadSettingListener mReadSettingListener = new ReadSettingListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.6
        @Override // client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener
        public void onStart(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener
        public void onSuccess(BluetoothDevice bluetoothDevice, String str) {
            SettingDeviceTwoActivity.this.dismissDialog();
            ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置读取成功");
            SettingDeviceTwoActivity.this.hasReadParam = true;
            SettingDeviceTwoActivity.this.mDeviceType = str.substring(24, 28);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SettingDeviceTwoActivity.this.hasReadParam = true;
            SettingDeviceTwoActivity.this.mDeviceEditView.setText(str.substring(0, 2));
            SettingDeviceTwoActivity.this.mNumberEditView.setText(str.substring(2, 4));
            SettingDeviceTwoActivity.this.mMoneyEditView.setText(str.substring(4, 6));
            SettingDeviceTwoActivity.this.mSpeedEditView.setText(str.substring(6, 8));
            SettingDeviceTwoActivity.this.mQValueEditView.setText(str.substring(8, 10));
            SettingDeviceTwoActivity.this.mReportEditView.setText(str.substring(10, 12));
            SettingDeviceTwoActivity.this.mWriteButton.setVisibility(0);
            SettingDeviceTwoActivity.this.mWriteDeviceNameButton.setVisibility(0);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            SettingDeviceTwoActivity.this.mMaterialDialog.dismiss();
            if (timeOut != null) {
                ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置读取超时");
            } else {
                ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置读取失败");
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.ReadSettingListener
        public void onBluetoothException(ClientException clientException) {
            SettingDeviceTwoActivity.this.mMaterialDialog.dismiss();
            ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "请打开蓝牙");
        }
    };
    private SettingListener mSettingListener = new SettingListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.7
        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onStart(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onSuccess(BluetoothDevice bluetoothDevice) {
            SettingDeviceTwoActivity.this.mMaterialDialog.dismiss();
            ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置成功");
            SettingDeviceTwoActivity.this.hasReadParam = false;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            String str;
            SettingDeviceTwoActivity.this.mMaterialDialog.dismiss();
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
                ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), str);
            } else {
                ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置失败:" + timeOut);
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingListener
        public void onBluetoothException(ClientException clientException) {
            SettingDeviceTwoActivity.this.mMaterialDialog.dismiss();
            ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "请打开蓝牙");
        }
    };
    private SettingNameListener mSettingNameListener = new SettingNameListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.8
        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingNameListener
        public void onStart(BluetoothDevice bluetoothDevice) {
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingNameListener
        public void onSuccess(BluetoothDevice bluetoothDevice) {
            SettingDeviceTwoActivity.this.mMaterialDialog.dismiss();
            ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置名称成功");
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingNameListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            String str;
            SettingDeviceTwoActivity.this.mMaterialDialog.dismiss();
            if (timeOut == TimeOut.Connect) {
                str = "水控连接超时";
            } else if (timeOut == TimeOut.Discover) {
                str = "查找水控超时";
            } else if (timeOut == TimeOut.SendGetDeviceSettingCommand) {
                str = "获取参数超时";
            } else {
                str = timeOut == TimeOut.WriteSetting ? "写入名称超时" : timeOut + "";
            }
            if (timeOut != null) {
                ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), str);
            } else {
                ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置名称失败:" + timeOut);
            }
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.SettingNameListener
        public void onBluetoothException(ClientException clientException) {
            SettingDeviceTwoActivity.this.dismissDialog();
            ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "请打开蓝牙");
        }
    };

    static {
        StubApp.interface11(6599);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SettingDeviceTwoActivity.class).putExtra("deviceMac", str).putExtra("devicehexid", str2).putExtra("version", i));
        }
    }

    public static void launch(Activity activity, String str, String str2, int i, String str3) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) SettingDeviceTwoActivity.class).putExtra("deviceMac", str).putExtra("devicehexid", str2).putExtra("version", i).putExtra("f5data", str3));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mReadButton = (Button) findViewById(R.id.read);
        this.mWriteButton = (Button) findViewById(R.id.write);
        this.mWriteDeviceNameButton = (Button) findViewById(R.id.writedevicename);
        this.mDeviceNameText = (LimitEditText) findViewById(R.id.device_name);
        this.mDeviceNameText1 = (LimitEditText) findViewById(R.id.device_name1);
        this.mDeviceEditView = (EditText) findViewById(R.id.device_edit);
        this.mNumberEditView = (EditText) findViewById(R.id.number_edit);
        this.mMoneyEditView = (EditText) findViewById(R.id.money_edit);
        this.mSpeedEditView = (EditText) findViewById(R.id.speed_edit);
        this.mQValueEditView = (EditText) findViewById(R.id.qvalue_edit);
        this.mReportEditView = (EditText) findViewById(R.id.report_edit);
        this.mInitEditView = (EditText) findViewById(R.id.init_edit);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingDeviceTwoActivity.this.onClickRead();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SettingDeviceTwoActivity.this.onClickWrite();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity$3, reason: invalid class name */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (SettingDeviceTwoActivity.this.mDeviceNameText.getText().toString().isEmpty() || SettingDeviceTwoActivity.this.mDeviceNameText1.getText().toString().isEmpty()) {
                return;
            }
            if (CoderUtils.isContainChinese(SettingDeviceTwoActivity.this.mDeviceNameText.getText().toString())) {
                ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "输入的名称中不能包含汉字");
            } else {
                BusinessControllers.getInstance().initDeviceInfo(SettingDeviceTwoActivity.this.getLoginAccount(), SettingDeviceTwoActivity.this.mDeviceHexID, SettingDeviceTwoActivity.this.mTypeId, SettingDeviceTwoActivity.this.mInvestorId, SettingDeviceTwoActivity.this.mSchoolId, SettingDeviceTwoActivity.this.mAddress, SettingDeviceTwoActivity.this.deviceMac, SettingDeviceTwoActivity.this.mDeviceNameText1.getText().toString() + x.A + SettingDeviceTwoActivity.this.mDeviceNameText.getText().toString(), new Listener<GetDeviceQrCodeBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.3.1
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onStart(Controller controller) {
                        SettingDeviceTwoActivity.this.showDialog();
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, GetDeviceQrCodeBean getDeviceQrCodeBean, Object... objArr) {
                        if (SettingDeviceTwoActivity.this.mIsEnable) {
                            SettingDeviceTwoActivity.this.writeAddress();
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                        if (SettingDeviceTwoActivity.this.mIsEnable) {
                            SettingDeviceTwoActivity.this.dismissDialog();
                            SystemErrorTip.getInstance().showTipDialog(SettingDeviceTwoActivity.this.getActivity(), clientException.getDetail());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity$4, reason: invalid class name */
    class AnonymousClass4 extends Listener<DeviceInfoBean> {
        @Override // client.android.yixiaotong.controller.core.Listener
        public void onStart(Controller controller) {
        }

        AnonymousClass4() {
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
            if (SettingDeviceTwoActivity.this.mIsEnable) {
                SettingDeviceTwoActivity.this.mAddress = deviceInfoBean.Address;
                SettingDeviceTwoActivity.this.mTypeId = deviceInfoBean.TypeId;
                SettingDeviceTwoActivity.this.mInvestorId = deviceInfoBean.InvestorId;
                SettingDeviceTwoActivity.this.mSchoolId = deviceInfoBean.SchoolId;
                String[] strArrSplit = deviceInfoBean.Name.split(x.A);
                if (strArrSplit.length == 2 && StringUtils.isNotEmpty(strArrSplit[0]) && StringUtils.isNotEmpty(strArrSplit[1])) {
                    SettingDeviceTwoActivity.this.mDeviceNameText.setText(strArrSplit[1]);
                    SettingDeviceTwoActivity.this.mDeviceNameText1.setText(strArrSplit[0]);
                    SettingDeviceTwoActivity.this.hideSoftKey();
                }
            }
        }

        @Override // client.android.yixiaotong.controller.core.Listener
        public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
            if (SettingDeviceTwoActivity.this.mIsEnable) {
                SystemErrorTip.getInstance().showTipDialog(SettingDeviceTwoActivity.this.getActivity(), clientException.getDetail());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideSoftKey() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mDeviceNameText.getWindowToken(), 0);
        this.mDeviceNameText.requestFocus();
        LimitEditText limitEditText = this.mDeviceNameText;
        limitEditText.setSelection(limitEditText.getText().toString().length());
    }

    private void getNewDeviceInfo() {
        BusinessControllers.getInstance().getNewDeviceInfo(getLoginAccount(), this.mDeviceHexID, PreferenceUtil.getBindRoom(getContext(), "bindRoom" + getLoginAccount().getUid(), 0L), new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, DeviceInfoBean deviceInfoBean, Object... objArr) {
                if (SettingDeviceTwoActivity.this.mIsEnable) {
                    SettingDeviceTwoActivity.this.mAddress = deviceInfoBean.Address;
                    SettingDeviceTwoActivity.this.mTypeId = deviceInfoBean.TypeId;
                    SettingDeviceTwoActivity.this.mInvestorId = deviceInfoBean.InvestorId;
                    SettingDeviceTwoActivity.this.mSchoolId = deviceInfoBean.SchoolId;
                    String[] strArrSplit = deviceInfoBean.Name.split(x.A);
                    if (strArrSplit.length == 2 && StringUtils.isNotEmpty(strArrSplit[0]) && StringUtils.isNotEmpty(strArrSplit[1])) {
                        SettingDeviceTwoActivity.this.mDeviceNameText.setText(strArrSplit[1]);
                        SettingDeviceTwoActivity.this.mDeviceNameText1.setText(strArrSplit[0]);
                        SettingDeviceTwoActivity.this.hideSoftKey();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (SettingDeviceTwoActivity.this.mIsEnable) {
                    SystemErrorTip.getInstance().showTipDialog(SettingDeviceTwoActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeAddress() {
        LeXiaoTongSDK.getInstance().settingDeviceName(this.mBluetoothDevice, this.mSettingNameListener, this.mDeviceNameText1.getText().toString() + x.A + this.mDeviceNameText.getText().toString());
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
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initTitleBar() {
        TitleBar titleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTitleBar = titleBar;
        titleBar.setLeftViewIsBack();
        this.mTitleBar.setTitleView("设置参数");
        this.mTitleBar.setLeftViewOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SettingDeviceTwoActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickRead() {
        showDialog();
        this.mMaterialDialog.setContent("正在读取设备的参数信息...");
        LeXiaoTongSDK.getInstance().readSettingDevice(this.mBluetoothDevice, this.mReadSettingListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onClickWrite() {
        if (!this.hasReadParam) {
            ToastUtils.show(getContext(), "请先读取设备参数!", 1);
            return;
        }
        if (this.mIsSetData) {
            setValue();
        } else if (StringUtils.isNotEmpty(this.mSetData) && this.mSetData.length() > 6) {
            new AppTipDialog().showTipDialog(getActivity(), new AppTipDialog.TipDialogListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.10
                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                public void onCanle() {
                }

                @Override // client.android.yixiaotong.ui.dialog.AppTipDialog.TipDialogListener
                public void onConfirt() {
                    SettingDeviceTwoActivity.this.mMoneyEditView.setText(SettingDeviceTwoActivity.this.mSetData.substring(0, 2));
                    SettingDeviceTwoActivity.this.mSpeedEditView.setText(SettingDeviceTwoActivity.this.mSetData.substring(2, 4));
                    SettingDeviceTwoActivity.this.mQValueEditView.setText(SettingDeviceTwoActivity.this.mSetData.substring(4, 6));
                    SettingDeviceTwoActivity.this.mReportEditView.setText(SettingDeviceTwoActivity.this.mSetData.substring(6));
                    SettingDeviceTwoActivity.this.setValue();
                }
            }, "费率统一由后台分配：\n扣费金额：" + this.mSetData.substring(0, 2) + "\n扣费脉冲或秒：" + this.mSetData.substring(2, 4) + "\n脉冲Q值：" + this.mSetData.substring(4, 6) + "\n报警时间：" + this.mSetData.substring(6), "取消", "设置");
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), this.mSetDataFail);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue() {
        showDialog();
        this.mMaterialDialog.setContent("正在写入参数信息...");
        LeXiaoTongSDK.getInstance().settingDevice(this.mBluetoothDevice, this.mSettingListener, ((getData(this.mDeviceEditView) + getData(this.mNumberEditView) + getData(this.mMoneyEditView) + getData(this.mSpeedEditView) + getData(this.mQValueEditView) + getData(this.mReportEditView) + getData(this.mInitEditView)) + new SimpleDateFormat("yyMMddHHmm").format(Calendar.getInstance().getTime())) + this.mDeviceType + "0E0F", getLoginAccount().getUid());
    }

    private String getData(EditText editText) {
        String string = editText.getText().toString();
        if (TextUtils.isEmpty(string)) {
            return "00";
        }
        if (string.length() > 2) {
            return string.substring(0, 2);
        }
        return string.length() < 2 ? "0" + string : string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        dismissDialog();
        MaterialDialog materialDialogShow = new MaterialDialog.Builder(this).content("正在匹配水控的蓝牙...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.11
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
            }
        }).show();
        this.mMaterialDialog = materialDialogShow;
        materialDialogShow.setCanceledOnTouchOutside(false);
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

    private void setSetValue() {
        BusinessControllers.getInstance().SetEquipmentRateInfo(getLoginAccount(), 1, getData(this.mMoneyEditView), getData(this.mSpeedEditView), getData(this.mQValueEditView), getData(this.mReportEditView), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.12
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                SettingDeviceTwoActivity.this.showDialog();
                SettingDeviceTwoActivity.this.mMaterialDialog.setContent("正在设置参数");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                if (SettingDeviceTwoActivity.this.mIsEnable) {
                    SettingDeviceTwoActivity.this.dismissDialog();
                    if (successBean == null || successBean.success != 1) {
                        ToastUtils.show(SettingDeviceTwoActivity.this.getContext(), "设置参数失败");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (SettingDeviceTwoActivity.this.mIsEnable) {
                    SettingDeviceTwoActivity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(SettingDeviceTwoActivity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getSet() {
        BusinessControllers.getInstance().GetEquipmentRateInfo(getLoginAccount(), 1, new Listener<SetBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.13
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SetBean setBean, Object... objArr) {
                if (!SettingDeviceTwoActivity.this.mIsEnable || setBean == null) {
                    SettingDeviceTwoActivity.this.mSetDataFail = "费率数据异常：数据为空";
                    return;
                }
                if (!StringUtils.isNotEmpty(setBean.amountDeducted) || !StringUtils.isNotEmpty(setBean.ChargeBackPulseNumber) || !StringUtils.isNotEmpty(setBean.PulseQValue) || !StringUtils.isNotEmpty(setBean.AlarmTime)) {
                    SettingDeviceTwoActivity.this.mSetDataFail = "费率数据异常：\n扣费金额：" + setBean.amountDeducted + "\n扣费脉冲或秒：" + setBean.ChargeBackPulseNumber + "\n脉冲Q值：" + setBean.PulseQValue + "\n报警时间：" + setBean.AlarmTime;
                } else {
                    SettingDeviceTwoActivity.this.mSetData = SettingDeviceTwoActivity.this.getTwoData(setBean.amountDeducted) + SettingDeviceTwoActivity.this.getTwoData(setBean.ChargeBackPulseNumber) + SettingDeviceTwoActivity.this.getTwoData(setBean.PulseQValue) + SettingDeviceTwoActivity.this.getTwoData(setBean.AlarmTime);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (SettingDeviceTwoActivity.this.mIsEnable) {
                    SettingDeviceTwoActivity.this.mSetDataFail = clientException.getDetail();
                }
            }
        });
    }

    private void judeSetValue(String str, String str2, String str3, String str4) {
        BusinessControllers.getInstance().JudgeEquipmentRateInfo(getLoginAccount(), 1, str, str2, str3, str4, new Listener<SetBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.SettingDeviceTwoActivity.14
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SetBean setBean, Object... objArr) {
                if (SettingDeviceTwoActivity.this.mIsEnable) {
                    if (setBean == null || setBean.success != 2) {
                        SettingDeviceTwoActivity.this.getSet();
                    } else {
                        SettingDeviceTwoActivity.this.mIsSetData = true;
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                if (SettingDeviceTwoActivity.this.mIsEnable) {
                    SettingDeviceTwoActivity.this.getSet();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getTwoData(String str) {
        return str.length() < 2 ? "0" + str : str;
    }
}
