package client.android.yixiaotong.ui.bluetoothtwo;

import android.app.Activity;
import android.client.bluetoothsdk.util.HexString;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.GetDeviceQrCodeBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.sdk.LeXiaoTongSDK;
import client.android.yixiaotong.sdk.bluetooth.BluetoothDevice;
import client.android.yixiaotong.sdk.runnable.DeviceBean;
import client.android.yixiaotong.sdk.runnable.TimeOut;
import client.android.yixiaotong.sdk.runnable.listener.InitListener;
import client.android.yixiaotong.sdk.utils.ClientException;
import client.android.yixiaotong.ui.ammeter.SelectAmmeterAddressActivity;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.KeyboardPatch;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ClickUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.LocalPreferencesHelper;
import com.afollestad.materialdialogs.MaterialDialog;
import com.hihonor.adsdk.base.g.j.e.a;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import com.unionpay.tsmservice.data.Constant;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InitDeviceNewTwoActivity extends BaseActivity {
    private String mAddress;
    private BluetoothDevice mBluetoothDevice;
    private String mDeviceHexID;
    private EditText mEtDuShu;
    private String mId;
    private String mMachineid;
    private MaterialDialog mMaterialDialog;
    private String mQrcodeByteArray;
    private RadioButton mRadioNoQrcode;
    private RelativeLayout mRelBleName;
    private RelativeLayout mRelDuShu;
    private TextView mSchollSpinner;
    private long mSchoolID;
    private ScrollView mScrollView;
    private TitleBar mTitleBar;
    private Button mVBtnNext;
    private EditText mVEtAddress;
    private EditText mVEtAddress1;
    private EditText mVEtAnZhuangAddress;
    private EditText mVEtOwner;
    private WalletModel mWalletModel;
    private RelativeLayout rlBindRoom;
    private TextView tvChooseRoom;
    private boolean mIsEnable = true;
    private InitListener initListener = new InitListener() { // from class: client.android.yixiaotong.ui.bluetoothtwo.InitDeviceNewTwoActivity.5
        @Override // client.android.yixiaotong.sdk.runnable.listener.InitListener
        public String needName(BluetoothDevice bluetoothDevice) {
            String string = InitDeviceNewTwoActivity.this.mVEtAddress.getText().toString();
            String string2 = InitDeviceNewTwoActivity.this.mVEtAddress1.getText().toString();
            if (!StringUtils.isNotEmpty(string)) {
                string = "000000";
            }
            if (!StringUtils.isNotEmpty(string2)) {
                string2 = Constant.DEFAULT_CVN2;
            }
            return string2 + x.A + string;
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.InitListener
        public byte[] needServerInit(BluetoothDevice bluetoothDevice, DeviceBean deviceBean) {
            return HexString.hexToBuffer(InitDeviceNewTwoActivity.this.mQrcodeByteArray);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.InitListener
        public void onFail(BluetoothDevice bluetoothDevice, TimeOut timeOut) {
            String str;
            InitDeviceNewTwoActivity.this.dismissDialog();
            if (timeOut == TimeOut.Connect) {
                str = "水控连接超时";
            } else if (timeOut == TimeOut.Discover) {
                str = "查找水控超时";
            } else if (timeOut == TimeOut.SendGetDeviceSettingCommand) {
                str = "获取参数超时";
            } else if (timeOut == TimeOut.SendGetDeviceSetting) {
                str = "写入参数超时";
            } else {
                str = timeOut == TimeOut.WriteQrcode ? "写入数据超时" : timeOut + "";
            }
            SystemErrorTip.getInstance().showTipDialog(InitDeviceNewTwoActivity.this.getActivity(), "初始化失败:" + str);
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.InitListener
        public void onBluetoothException(ClientException clientException) {
            InitDeviceNewTwoActivity.this.dismissDialog();
            SystemErrorTip.getInstance().showTipDialog(InitDeviceNewTwoActivity.this.getActivity(), clientException.getDetail());
        }

        @Override // client.android.yixiaotong.sdk.runnable.listener.InitListener
        public void onSuccess(BluetoothDevice bluetoothDevice) {
            InitDeviceNewTwoActivity.this.dismissDialog();
            ToastUtils.show(InitDeviceNewTwoActivity.this.getContext(), "初始化完成");
            InitDeviceNewTwoActivity.this.finish();
        }
    };

    static {
        StubApp.interface11(6562);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, String str, WalletModel walletModel, String str2) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) InitDeviceNewTwoActivity.class).putExtra("deviceAddress", str).putExtra("walletmodel", walletModel).putExtra("devicehexid", str2));
        }
    }

    public static void launch(Activity activity, String str, WalletModel walletModel, String str2, String str3) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) InitDeviceNewTwoActivity.class).putExtra("deviceAddress", str).putExtra("walletmodel", walletModel).putExtra("devicehexid", str2).putExtra("machineid", str3));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
        this.mVEtOwner = (EditText) findViewById(R.id.v_et_owner);
        this.mVEtAddress = (EditText) findViewById(R.id.v_et_address);
        this.mVEtAddress1 = (EditText) findViewById(R.id.v_et_address1);
        this.mVEtAnZhuangAddress = (EditText) findViewById(R.id.v_et_anzhuang_address);
        this.mVBtnNext = (Button) findViewById(R.id.v_btn_next);
        this.mSchollSpinner = (TextView) findViewById(R.id.scholl_spinner);
        this.mRadioNoQrcode = (RadioButton) findViewById(R.id.radio_no);
        this.tvChooseRoom = (TextView) findViewById(R.id.tv_choose_room);
        this.rlBindRoom = (RelativeLayout) findViewById(R.id.rl_bind_room);
        this.mRelBleName = (RelativeLayout) findViewById(R.id.rel_name);
        this.mEtDuShu = (EditText) findViewById(R.id.v_et_dushu);
        this.mRelDuShu = (RelativeLayout) findViewById(R.id.rel_dushu);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.InitDeviceNewTwoActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ClickUtils.isFastDoubleClick()) {
                return;
            }
            InitDeviceNewTwoActivity.this.submit();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.bluetoothtwo.InitDeviceNewTwoActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SelectAmmeterAddressActivity.launch(InitDeviceNewTwoActivity.this.getActivity(), 0);
        }
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("初始化设备");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    private void hideSoftKey() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mVEtAddress1.getWindowToken(), 0);
        this.mVEtAddress1.requestFocus();
        EditText editText = this.mVEtAddress1;
        editText.setSelection(editText.getText().toString().length());
        KeyboardPatch.setScroll(this.mScrollView, this.mVEtAnZhuangAddress, this.mEtDuShu);
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
    public void submit() {
        if (this.tvChooseRoom.getText().toString().isEmpty()) {
            ToastUtils.show(getContext(), "请选择要绑定的房间");
            return;
        }
        if (LocalBusinessStore.getLastBathVersion(getContext(), 1, this.mBluetoothDevice.address) == 3 && this.mEtDuShu.getText().toString().isEmpty()) {
            ToastUtils.show(getContext(), "请输入水表上的八位读数");
            return;
        }
        LocalPreferencesHelper localPreferencesHelper = new LocalPreferencesHelper(getContext(), "default_init_preferences");
        localPreferencesHelper.saveOrUpdate("owner", this.mVEtOwner.getText().toString());
        localPreferencesHelper.saveOrUpdate(a.G0, this.mVEtAddress.getText().toString());
        localPreferencesHelper.saveOrUpdate("address1", this.mVEtAddress1.getText().toString());
        localPreferencesHelper.saveOrUpdate("anzhuangaddress", this.mVEtAnZhuangAddress.getText().toString());
        String string = this.mVEtAddress.getText().toString();
        String string2 = this.mVEtAddress1.getText().toString();
        if (!StringUtils.isNotEmpty(string)) {
            string = "000000";
        }
        if (!StringUtils.isNotEmpty(string2)) {
            string2 = Constant.DEFAULT_CVN2;
        }
        if (LocalBusinessStore.getLastBathVersion(getContext(), 1, this.mBluetoothDevice.address) == 3) {
            BusinessControllers.getInstance().initDeviceInfoNew(getLoginAccount(), this.mMachineid, 1, Long.valueOf(this.mVEtOwner.getText().toString()).longValue(), this.mSchoolID, this.mVEtAnZhuangAddress.getText().toString(), this.mBluetoothDevice.address, string2 + x.A + string, this.mId, this.mEtDuShu.getText().toString(), new Listener<GetDeviceQrCodeBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.InitDeviceNewTwoActivity.3
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    InitDeviceNewTwoActivity.this.showDialog();
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, GetDeviceQrCodeBean getDeviceQrCodeBean, Object... objArr) {
                    if (InitDeviceNewTwoActivity.this.mIsEnable) {
                        ToastUtils.show(InitDeviceNewTwoActivity.this.getContext(), "初始化成功");
                        InitDeviceNewTwoActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (InitDeviceNewTwoActivity.this.mIsEnable) {
                        InitDeviceNewTwoActivity.this.dismissDialog();
                        SystemErrorTip.getInstance().showTipDialog(InitDeviceNewTwoActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
        } else {
            BusinessControllers.getInstance().initDeviceInfoNew(getLoginAccount(), this.mDeviceHexID, 1, Long.valueOf(this.mVEtOwner.getText().toString()).longValue(), this.mSchoolID, this.mVEtAnZhuangAddress.getText().toString(), this.mAddress, string2 + x.A + string, this.mId, "", new Listener<GetDeviceQrCodeBean>() { // from class: client.android.yixiaotong.ui.bluetoothtwo.InitDeviceNewTwoActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    InitDeviceNewTwoActivity.this.showDialog();
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, GetDeviceQrCodeBean getDeviceQrCodeBean, Object... objArr) {
                    if (InitDeviceNewTwoActivity.this.mIsEnable) {
                        ToastUtils.show(InitDeviceNewTwoActivity.this.getContext(), "已从服务器获取到初始化数据,开始写入设备");
                        InitDeviceNewTwoActivity.this.writeQrcode(getDeviceQrCodeBean.byteArray);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, client.android.yixiaotong.exception.ClientException clientException) {
                    if (InitDeviceNewTwoActivity.this.mIsEnable) {
                        InitDeviceNewTwoActivity.this.dismissDialog();
                        SystemErrorTip.getInstance().showTipDialog(InitDeviceNewTwoActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeQrcode(String str) {
        this.mQrcodeByteArray = str;
        LeXiaoTongSDK.getInstance().initDevice(this.mBluetoothDevice, this.initListener, !this.mRadioNoQrcode.isChecked());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra(a.G0);
            this.mId = intent.getStringExtra("id");
            this.tvChooseRoom.setText(stringExtra);
        }
    }
}
