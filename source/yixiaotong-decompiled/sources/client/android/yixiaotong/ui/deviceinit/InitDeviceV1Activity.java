package client.android.yixiaotong.ui.deviceinit;

import android.app.Activity;
import android.client.bluetoothsdk.BluetoothSDK;
import android.client.bluetoothsdk.bluetooth.BluetoothDevice;
import android.client.bluetoothsdk.listener.BluetoothConnectListener;
import android.client.bluetoothsdk.util.TimeOut;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.init.SetNBDrinkWaterBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.sdk.utils.StringUtils;
import client.android.yixiaotong.ui.address.NBDrinkSelectAddressActivity;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.BathUtil;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import client.android.yixiaotong.util.drinkwater.DrinkWaterCommand;
import client.android.yixiaotong.util.executor.MainThreadExecutor;
import com.afollestad.materialdialogs.MaterialDialog;
import com.google.android.exoplayer2.ExoPlayer;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InitDeviceV1Activity extends BaseActivity {
    private String mAddress;
    private String mAuthSetData;
    private BluetoothDevice mBluetoothDevice;
    private String mDeviceName;
    TextView mDeviceTypeSpinner;
    EditText mEtDeviceName;
    EditText mEtDuShu;
    private String mF0Data;
    private String mId;
    private String mImei;
    private boolean mIsPublicArea;
    private LocalPreferencesHelper mLocalPreferenceshelper;
    private String mMachineRand;
    private String mMachineid;
    private MaterialDialog mMaterialDialog;
    private String mNbFlag;
    RadioButton mRadioPublic;
    RelativeLayout mRelBindType;
    RelativeLayout mRelBleName;
    RelativeLayout mRelDeShu;
    Spinner mSchollSpinner;
    private AreasBean mSelectAreasBean;
    private String mSetData;
    TitleBar mTitleBar;
    Button mVBtnNext;
    EditText mVEtAddress;
    EditText mVEtAddress1;
    EditText mVEtOwner;
    private WalletModel mWalletModel;
    RelativeLayout rlBindRoom;
    public StringBuilder stringBuilderAll;
    TextView tvChooseRoom;
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
        StubApp.interface11(6765);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, String str2, WalletModel walletModel, String str3, String str4, String str5) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) InitDeviceV1Activity.class).putExtra("deviceAddress", str).putExtra("walletmodel", walletModel).putExtra("machineid", str3).putExtra("devicename", str2).putExtra("nbflag", str4).putExtra("imei", str5));
        }
    }

    public static void launch(Activity activity, String str, String str2, WalletModel walletModel, String str3, String str4, String str5, String str6, String str7) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) InitDeviceV1Activity.class).putExtra("deviceAddress", str).putExtra("walletmodel", walletModel).putExtra("machineid", str3).putExtra("devicename", str2).putExtra("nbflag", str4).putExtra("imei", str5).putExtra("setdata", str6).putExtra("f0data", str7));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mVEtOwner = (EditText) findViewById(R.id.v_et_owner);
        this.mVEtAddress = (EditText) findViewById(R.id.v_et_address);
        this.mVEtAddress1 = (EditText) findViewById(R.id.v_et_address1);
        this.mEtDeviceName = (EditText) findViewById(R.id.v_et_devicename);
        this.mVBtnNext = (Button) findViewById(R.id.v_btn_next);
        this.mSchollSpinner = (Spinner) findViewById(R.id.scholl_spinner);
        this.mDeviceTypeSpinner = (TextView) findViewById(R.id.device_type_spinner);
        this.tvChooseRoom = (TextView) findViewById(R.id.tv_choose_room);
        this.mRelBindType = (RelativeLayout) findViewById(R.id.rl_bind);
        this.rlBindRoom = (RelativeLayout) findViewById(R.id.rl_bind_room);
        this.mRelBleName = (RelativeLayout) findViewById(R.id.rel_name);
        this.mEtDuShu = (EditText) findViewById(R.id.v_et_dushu);
        this.mRelDeShu = (RelativeLayout) findViewById(R.id.rel_dushu);
        this.mRadioPublic = (RadioButton) findViewById(R.id.radio1);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InitDeviceV1Activity.this.submit();
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("初始化设备");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void initListener() {
        this.rlBindRoom.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InitDeviceV1Activity.this.initAddress();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAddress() {
        boolean zIsChecked = this.mRadioPublic.isChecked();
        this.mIsPublicArea = zIsChecked;
        if (zIsChecked) {
            NBDrinkSelectAddressActivity.launch(getActivity(), 0);
        } else {
            SelectAmmeterAddressActivity.launch(getActivity(), 0);
        }
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        dismissDialog();
    }

    private void initSchollSpinner() {
        BusinessControllers.getInstance().getSchoolList(getLoginAccount(), new Listener<List<AreasBean>>() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                InitDeviceV1Activity.this.showDialog();
                InitDeviceV1Activity.this.mMaterialDialog.setContent("正在获取学校信息..");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreasBean> list, Object... objArr) {
                if (InitDeviceV1Activity.this.mIsEnable) {
                    InitDeviceV1Activity.this.dismissDialog();
                    if (list == null) {
                        InitDeviceV1Activity.this.dismissDialog();
                        ToastUtils.show(InitDeviceV1Activity.this.getContext(), "服务出现问题,请稍候重试");
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    long j = InitDeviceV1Activity.this.getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
                    for (int i = 0; i < list.size(); i++) {
                        AreasBean areasBean = list.get(i);
                        if (areasBean.ID == j) {
                            InitDeviceV1Activity.this.mSelectAreasBean = areasBean;
                            arrayList.add(areasBean.Name);
                            break;
                        }
                    }
                    if (arrayList.isEmpty()) {
                        ToastUtils.show(InitDeviceV1Activity.this.getContext(), "服务出现问题,请稍候重试");
                        return;
                    }
                    ArrayAdapter arrayAdapter = new ArrayAdapter(InitDeviceV1Activity.this.getContext(), R.layout.simple_spinner_item, (String[]) arrayList.toArray(new String[0]));
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    InitDeviceV1Activity.this.mSchollSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                    InitDeviceV1Activity.this.mSchollSpinner.setSelection(0);
                    InitDeviceV1Activity.this.initDeviceTypeSpinner();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (InitDeviceV1Activity.this.mIsEnable) {
                    InitDeviceV1Activity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(InitDeviceV1Activity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDeviceTypeSpinner() {
        this.mDeviceTypeSpinner.setText(this.mWalletModel.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submit() {
        if (this.mSelectAreasBean == null) {
            ToastUtils.show(getContext(), "请选择校区");
            return;
        }
        try {
            Long.valueOf(this.mVEtOwner.getText().toString());
            if (this.tvChooseRoom.getText().toString().isEmpty()) {
                ToastUtils.show(getContext(), "请选择要绑定的房间");
            } else if (this.mEtDuShu.getText().toString().isEmpty() && this.mWalletModel.typeId != 6) {
                ToastUtils.show(getContext(), "请输入水表上的八位读数");
            } else {
                BusinessControllers.getInstance().postInitNBMachine(getLoginAccount(), this.mMachineid, this.mVEtOwner.getText().toString(), this.mWalletModel.typeId, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, this.mImei, this.mNbFlag, this.mAddress, this.mId, this.mDeviceName, this.mEtDuShu.getText().toString(), this.mEtDeviceName.getText().toString(), new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.4
                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                        if (InitDeviceV1Activity.this.mIsEnable) {
                            if (successBean == null || successBean.success != 1) {
                                ToastUtils.show(InitDeviceV1Activity.this.getContext(), "初始化失败");
                            } else {
                                ToastUtils.show(InitDeviceV1Activity.this.getContext(), "初始化成功");
                                InitDeviceV1Activity.this.finish();
                            }
                        }
                    }

                    @Override // client.android.yixiaotong.controller.core.Listener
                    public void onFail(Controller controller, ClientException clientException) {
                        if (InitDeviceV1Activity.this.mIsEnable) {
                            SystemErrorTip.getInstance().showTipDialog(InitDeviceV1Activity.this.getActivity(), clientException.getDetail());
                        }
                    }
                });
            }
        } catch (NumberFormatException unused) {
            ToastUtils.show(getContext(), "请填写正确的投资人ID");
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(a.G0);
            this.mId = intent.getStringExtra("id");
            this.tvChooseRoom.setText(stringExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        MaterialDialog materialDialog = this.mMaterialDialog;
        if (materialDialog == null) {
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("正在初始化设备...").progress(true, 0).show();
            this.mMaterialDialog = materialDialogShow;
            materialDialogShow.setCanceledOnTouchOutside(false);
        } else {
            if (materialDialog.isShowing()) {
                return;
            }
            this.mMaterialDialog.show();
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

    private void setBluetoothListener() {
        String str = this.mAddress;
        this.mBluetoothDevice = new BluetoothDevice(str, str);
        BluetoothSDK.getInstance().setListener(new BluetoothConnectListener() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.5
            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onStart(BluetoothDevice bluetoothDevice) {
                InitDeviceV1Activity.this.mConnectState = ConnectState.connecting;
                InitDeviceV1Activity.this.mMaterialDialog.setContent("正在连接设备");
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessConnect(BluetoothDevice bluetoothDevice) {
                if (InitDeviceV1Activity.this.mIsEnable) {
                    Log.e("test", "连接成功");
                    if (InitDeviceV1Activity.this.isShowing()) {
                        InitDeviceV1Activity.this.mMaterialDialog.setContent("设备连接成功");
                    }
                    InitDeviceV1Activity.this.mConnectState = ConnectState.connected;
                    MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (InitDeviceV1Activity.this.isShowing()) {
                                InitDeviceV1Activity.this.mMaterialDialog.setContent("正在获取随机数");
                            }
                            InitDeviceV1Activity.this.mSendDataState = SendDataState.f08;
                            BluetoothSDK.getInstance().SendDataManagerDevice(DrinkWaterCommand.getRandCommand());
                        }
                    }, 500L);
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onSuccessSendData(BluetoothDevice bluetoothDevice, String str2) {
                if (InitDeviceV1Activity.this.mIsEnable) {
                    InitDeviceV1Activity.this.receivedData(str2);
                    if (InitDeviceV1Activity.this.leftCount > 0 || InitDeviceV1Activity.this.stringBuilderAll == null || !StringUtils.isNotEmpty(InitDeviceV1Activity.this.stringBuilderAll.toString())) {
                        return;
                    }
                    String string = InitDeviceV1Activity.this.stringBuilderAll.toString();
                    InitDeviceV1Activity.this.stringBuilderAll = null;
                    if (InitDeviceV1Activity.this.mSendDataState != SendDataState.f08) {
                        if (InitDeviceV1Activity.this.mSendDataState == SendDataState.f07) {
                            InitDeviceV1Activity.this.dismissDialog();
                            if (!StringUtils.isNotEmpty(string) || string.length() <= 24) {
                                return;
                            }
                            if ("00".equals(string.substring(22, 24))) {
                                ToastUtils.show(InitDeviceV1Activity.this.getContext(), "初始化成功");
                                InitDeviceV1Activity.this.finish();
                            } else {
                                SystemErrorTip.getInstance().showTipDialog(InitDeviceV1Activity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.5.2
                                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                                    public void onConfirm() {
                                    }
                                }, "初始化设置参数失败,去重新设置参数");
                            }
                            InitDeviceV1Activity.this.mSendDataState = SendDataState.none;
                            BluetoothSDK.getInstance().closeBLE();
                            return;
                        }
                        return;
                    }
                    if (!StringUtils.isNotEmpty(string) || string.length() <= 30) {
                        return;
                    }
                    InitDeviceV1Activity.this.mMachineRand = string.substring(22, 30);
                    InitDeviceV1Activity.this.postDeviceConfiguration();
                }
            }

            @Override // android.client.bluetoothsdk.listener.BluetoothConnectListener
            public void onFail(BluetoothDevice bluetoothDevice, final TimeOut timeOut, final String str2) {
                if (InitDeviceV1Activity.this.mIsEnable && InitDeviceV1Activity.this.mIsAutoConnect) {
                    InitDeviceV1Activity.this.dismissDialog();
                    InitDeviceV1Activity.this.mConnectState = ConnectState.disconnect;
                    new Thread(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.5.3
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                InitDeviceV1Activity.this.mConnectCount++;
                                if (InitDeviceV1Activity.this.mConnectCount <= 2) {
                                    BluetoothSDK.getInstance().closeBLE();
                                    Thread.sleep(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                                    InitDeviceV1Activity.this.connectDevice();
                                } else {
                                    if (str2 != null) {
                                        ToastUtils.show(InitDeviceV1Activity.this.getContext(), "连接设备超时" + timeOut + str2);
                                    } else {
                                        ToastUtils.show(InitDeviceV1Activity.this.getContext(), "连接设备失败");
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
                if (InitDeviceV1Activity.this.mIsEnable) {
                    InitDeviceV1Activity.this.dismissDialog();
                    InitDeviceV1Activity.this.mConnectState = ConnectState.disconnect;
                    ToastUtils.show(InitDeviceV1Activity.this.getContext(), clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectDevice() {
        MainThreadExecutor.getInstance().execute(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.6
            @Override // java.lang.Runnable
            public void run() {
                InitDeviceV1Activity.this.showDialog();
                BluetoothSDK.getInstance().ConnectManagerDevice(InitDeviceV1Activity.this.mBluetoothDevice);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void postDeviceConfiguration() {
        String strReceivedResult = BathUtil.receivedResult(this.mF0Data.substring(14, 16), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        String strReceivedResult2 = BathUtil.receivedResult(this.mF0Data.substring(16, 18), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(18, 20), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        BathUtil.receivedResult(this.mF0Data.substring(20, 22), this.mF0Data.substring(4, 6), this.mF0Data.substring(6, 8));
        String strSubstring = this.mF0Data.substring(22, 38);
        int iHexStringToInt = BathUtil.HexStringToInt(strReceivedResult);
        int iHexStringToInt2 = BathUtil.HexStringToInt(strReceivedResult2);
        Log.e("test", "参数：" + this.mSetData);
        if (this.mWalletModel.typeId == 1) {
            this.mLocalPreferenceshelper.saveOrUpdate("setbathdata", this.mSetData);
        } else {
            this.mLocalPreferenceshelper.saveOrUpdate("setdata", this.mSetData);
        }
        final String randNumMaxString = RandomUtil.getRandNumMaxString(6);
        BusinessControllers.getInstance().postDeviceConfiguration(getLoginAccount(), this.mWalletModel.typeId, strSubstring, iHexStringToInt, iHexStringToInt2, this.mMachineRand, this.mSetData.toUpperCase(), randNumMaxString, "1", new Listener<SetNBDrinkWaterBean>() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.7
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                if (InitDeviceV1Activity.this.isShowing()) {
                    InitDeviceV1Activity.this.mMaterialDialog.setContent("正在获取参数..");
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, SetNBDrinkWaterBean setNBDrinkWaterBean, Object... objArr) {
                if (InitDeviceV1Activity.this.mIsEnable) {
                    if (setNBDrinkWaterBean == null || !StringUtils.isNotEmpty(setNBDrinkWaterBean.systemdata) || !StringUtils.isNotEmpty(setNBDrinkWaterBean.rand) || !setNBDrinkWaterBean.rand.equals(randNumMaxString)) {
                        InitDeviceV1Activity.this.dismissDialog();
                        ToastUtils.show(InitDeviceV1Activity.this.getContext(), "获取服务器参数异常");
                        return;
                    }
                    InitDeviceV1Activity.this.mAuthSetData = setNBDrinkWaterBean.systemdata;
                    Log.e("test", "授权参数：" + InitDeviceV1Activity.this.mAuthSetData);
                    if (InitDeviceV1Activity.this.isShowing()) {
                        InitDeviceV1Activity.this.mMaterialDialog.setContent("获取参数成功，正在设置参数中..");
                    }
                    final String strSetMachineNoCommand = DrinkWaterCommand.SetMachineNoCommand(InitDeviceV1Activity.this.mAuthSetData);
                    if (InitDeviceV1Activity.this.mConnectState == ConnectState.connected) {
                        InitDeviceV1Activity.this.mSendDataState = SendDataState.f07;
                        if (strSetMachineNoCommand.length() > 40) {
                            BluetoothSDK.getInstance().SendDataManagerDevice(strSetMachineNoCommand.substring(0, 40));
                            MainThreadExecutor.getInstance().executeDelayed(new Runnable() { // from class: client.android.yixiaotong.ui.deviceinit.InitDeviceV1Activity.7.1
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
                    if (InitDeviceV1Activity.this.mConnectState != ConnectState.connecting) {
                        InitDeviceV1Activity.this.connectDevice();
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (InitDeviceV1Activity.this.mIsEnable) {
                    InitDeviceV1Activity.this.mIsAutoConnect = false;
                    InitDeviceV1Activity.this.dismissDialog();
                    SystemErrorTip.getInstance().showTipDialog(InitDeviceV1Activity.this.getActivity(), clientException.getDetail());
                }
            }
        });
    }
}
