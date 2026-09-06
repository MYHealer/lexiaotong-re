package client.android.yixiaotong.ui.ammeter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AccountTypeBean;
import client.android.yixiaotong.controller.bean.AmmeterInitBean;
import client.android.yixiaotong.controller.bean.AmmeterPriceBean;
import client.android.yixiaotong.controller.bean.AmmeterPricesBean;
import client.android.yixiaotong.controller.bean.AmmeterStateBean;
import client.android.yixiaotong.controller.bean.AreasBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.HexString;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AESHelper;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothDevice;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager;
import client.android.yixiaotong.util.ammeterbluetooth.AmmeterCommandUtils;
import client.android.yixiaotong.util.ammeterbluetooth.UiThreadUtils;
import client.android.yixiaotong.util.ammeterutil.AmmeterRandomUtils;
import client.android.yixiaotong.util.random.RandomUtils;
import com.afollestad.materialdialogs.MaterialDialog;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class InitAmmeterActivity extends BaseActivity implements AmmeterBluetoothManager.Listener {
    public static final String EXTRAS_DEVICE_ADDRESS = "deviceAddress";
    public static final String EXTRAS_ISHASAMMETER = "ishasammeter";
    public static final String EXTRA_ISFLAG = "extra_isflag";
    public static final String EXTRA_USERNO = "extra_userno";
    public static final String EXTRA_WALLET = "extra_wallet";
    private List<AccountTypeBean> mAccountTypeBeans;
    private AmmeterBluetoothManager mAmmeterBluetoothManager;
    private AmmeterBluetoothDevice mBluetoothDevice;
    private String mDeviceAddress;
    private Spinner mDeviceTypeSpinner;
    private EditText mEtInitMoney;
    private String mId;
    private String mIsFlag;
    private int mIsHasAmmeter;
    private MaterialDialog mMaterialDialog;
    private int mPosition;
    private String mQrcodeData;
    private RelativeLayout mRelAddress;
    private Spinner mSchollSpinner;
    private AccountTypeBean mSelectAccountTypeBean;
    private AreasBean mSelectAreasBean;
    private TitleBar mTitleBar;
    private TextView mTvAddress;
    private Spinner mUseTypeSpinner;
    private Button mVBtnNext;
    private EditText mVEtOwner;
    private WalletModel mWalletModel;
    private String mUserNo = "FFFFFFFF";
    private boolean mUserState = false;
    private boolean mConnected = false;
    private boolean mSupport = false;
    private String mDeviceNo = "";
    private String mReceivedCode = "FF";
    private String mSendCode = "FF";
    private boolean mIsDestroy = false;
    private boolean mIsEnable = true;
    List<AmmeterPriceBean> resultString = new ArrayList();
    private Handler handlersend = new Handler();
    final Runnable runnableSend = new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.12
        private void sendData() {
            InitAmmeterActivity.this.sendGetDeviceInfoData();
        }

        @Override // java.lang.Runnable
        public void run() {
            sendData();
        }
    };

    static {
        StubApp.interface11(6296);
    }

    private boolean isConnected() {
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
    public void onDeviceFound(String str) {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryFinished() {
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDiscoveryStarted() {
    }

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3, int i) {
        if (activity != null) {
            Intent intent = new Intent(activity, (Class<?>) InitAmmeterActivity.class);
            intent.putExtra("extra_wallet", walletModel);
            intent.putExtra("deviceAddress", str);
            intent.putExtra("extra_userno", str2);
            intent.putExtra(EXTRA_ISFLAG, str3);
            intent.putExtra("ishasammeter", i);
            activity.startActivity(intent);
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mVEtOwner = (EditText) findViewById(R.id.v_et_owner);
        this.mVBtnNext = (Button) findViewById(R.id.v_btn_next);
        this.mSchollSpinner = (Spinner) findViewById(R.id.scholl_spinner);
        this.mDeviceTypeSpinner = (Spinner) findViewById(R.id.device_type_spinner);
        this.mEtInitMoney = (EditText) findViewById(R.id.et_initmoney);
        this.mRelAddress = (RelativeLayout) findViewById(R.id.rel_address);
        this.mTvAddress = (TextView) findViewById(R.id.tv_address);
        this.mUseTypeSpinner = (Spinner) findViewById(R.id.use_type_spinner);
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InitAmmeterActivity.this.submit();
        }
    }

    /* JADX INFO: renamed from: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InitAmmeterActivity.this.initAddress();
        }
    }

    private void initTitleBar() {
        if (this.mIsFlag.equals("4")) {
            this.mTitleBar.setTitleView("更换新电表");
            this.mTitleBar.setLeftView(R.mipmap.back);
            this.mTitleBar.setLeftViewOnClickBack(getActivity());
        } else {
            this.mTitleBar.setTitleView("初始化电表");
            this.mTitleBar.setLeftView(R.mipmap.back);
            this.mTitleBar.setLeftViewOnClickBack(getActivity());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra(a.G0);
            this.mId = intent.getStringExtra("id");
            this.mTvAddress.setText(stringExtra);
        }
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

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        this.mIsEnable = false;
        dismissDialog();
        UiThreadUtils.clearHandler(this.handlersend, this.runnableSend);
        AmmeterBluetoothManager.getInstance().disConnectAll();
    }

    private void initSchollSpinner() {
        BusinessControllers.getInstance().getSchoolList(getLoginAccount(), new Listener<List<AreasBean>>() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<AreasBean> list, Object... objArr) {
                if (list == null) {
                    ToastUtils.show(InitAmmeterActivity.this.getContext(), "服务出现问题,请稍候重试");
                    return;
                }
                ArrayList arrayList = new ArrayList();
                long j = InitAmmeterActivity.this.getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
                for (int i = 0; i < list.size(); i++) {
                    AreasBean areasBean = list.get(i);
                    if (areasBean.ID == j) {
                        InitAmmeterActivity.this.mSelectAreasBean = areasBean;
                        arrayList.add(areasBean.Name);
                        break;
                    }
                }
                if (arrayList.isEmpty()) {
                    ToastUtils.show(InitAmmeterActivity.this.getContext(), "服务出现问题,请稍候重试");
                    return;
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(InitAmmeterActivity.this.getContext(), R.layout.simple_spinner_item, (String[]) arrayList.toArray(new String[0]));
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                InitAmmeterActivity.this.mSchollSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                InitAmmeterActivity.this.mSchollSpinner.setSelection(0);
                InitAmmeterActivity.this.initDeviceTypeSpinner();
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(InitAmmeterActivity.this.getContext(), clientException.getDetail());
                InitAmmeterActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initDeviceTypeSpinner() {
        if (this.mWalletModel != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.mWalletModel.name);
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), R.layout.simple_spinner_item, (String[]) arrayList.toArray(new String[0]));
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            this.mDeviceTypeSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
            this.mDeviceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.4
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (InitAmmeterActivity.this.mAccountTypeBeans != null) {
                        InitAmmeterActivity initAmmeterActivity = InitAmmeterActivity.this;
                        initAmmeterActivity.mSelectAccountTypeBean = (AccountTypeBean) initAmmeterActivity.mAccountTypeBeans.get(i);
                    } else {
                        InitAmmeterActivity.this.mSelectAccountTypeBean = null;
                    }
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView<?> adapterView) {
                    InitAmmeterActivity.this.mSelectAccountTypeBean = null;
                }
            });
            return;
        }
        ToastUtils.show(getContext(), "服务出现问题,请稍候重试");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initAddress() {
        SelectAmmeterAddressActivity.launch(getActivity(), 0);
    }

    private void initUseDeviceType() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterGetPrice(getLoginAccount(), randNumMaxStringNonO, new Listener<AmmeterPricesBean>() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterPricesBean ammeterPricesBean, Object... objArr) {
                if (ammeterPricesBean == null || ammeterPricesBean.Records == null || !ammeterPricesBean.rand.equals(randNumMaxStringNonO)) {
                    return;
                }
                InitAmmeterActivity.this.resultString.addAll(ammeterPricesBean.getSortList());
                ArrayList arrayList = new ArrayList();
                arrayList.add("请选择");
                for (int i = 0; i < InitAmmeterActivity.this.resultString.size(); i++) {
                    arrayList.add(InitAmmeterActivity.this.resultString.get(i).name);
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(InitAmmeterActivity.this.getContext(), R.layout.simple_spinner_item, arrayList);
                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                InitAmmeterActivity.this.mUseTypeSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                InitAmmeterActivity.this.mUseTypeSpinner.setSelection(0);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(InitAmmeterActivity.this.getActivity(), clientException.getDetail());
            }
        });
        this.mUseTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.6
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                InitAmmeterActivity.this.mPosition = i + 1;
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                InitAmmeterActivity.this.mPosition = 1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void submit() {
        if (this.mSelectAreasBean == null) {
            ToastUtils.show(getContext(), "请选择校区");
            return;
        }
        try {
            Long.valueOf(this.mVEtOwner.getText().toString());
            if (this.mTvAddress.getText().toString().equals("请选择")) {
                ToastUtils.show(getContext(), "请选择安装地址");
                return;
            }
            if (this.mEtInitMoney.getText().toString().isEmpty()) {
                ToastUtils.show(getContext(), "请输入电表新名称");
            } else if (!isConnected()) {
                ToastUtils.show(getContext(), "电表已断开，请重新连接");
                finish();
            } else {
                sendsetname(strToAsciiHex(this.mEtInitMoney.getText().toString()), this.mReceivedCode);
            }
        } catch (NumberFormatException unused) {
            ToastUtils.show(getContext(), "请填写正确的投资人ID");
        }
    }

    private String strToAsciiHex(String str) {
        StringBuilder sb = new StringBuilder();
        if (!StringUtils.isNotEmpty(str)) {
            return "00";
        }
        for (int i = 0; i < str.length(); i++) {
            sb.append(Integer.toHexString(str.charAt(i)));
        }
        return sb.toString() + "00";
    }

    private void btnInit() {
        if (this.mIsFlag.equals("4")) {
            init();
            return;
        }
        if (this.mIsFlag.equals("1")) {
            int i = this.mIsHasAmmeter;
            if (i == 2) {
                init();
                return;
            }
            if (i == 6) {
                init();
            } else if (this.mUserState && this.mUserNo.equals(this.mQrcodeData)) {
                initSuccess();
            } else {
                init();
            }
        }
    }

    private void init() {
        int i = 0;
        String str = "";
        for (int i2 = 0; i2 < this.resultString.size(); i2++) {
            if (this.resultString.get(i2).name.equals(this.mUseTypeSpinner.getSelectedItem().toString().trim())) {
                int i3 = this.resultString.get(i2).price;
                String str2 = this.resultString.get(i2).code;
                Log.e("test", this.mPosition + "  " + this.mUseTypeSpinner.getSelectedItem().toString() + "  " + i3);
                i = i3;
                str = str2;
            }
        }
        String str3 = getLoginAccount().getAccountManagetStore().getUserInfo().StudentName;
        String localDate = OrderIdUtils.getLocalDate("yyyyMMddHHmmss");
        String str4 = getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId;
        long j = getLoginAccount().getAccountManagetStore().getUserInfo().AreaId;
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        if (StringUtils.isEmpty(str)) {
            ToastUtils.show(getActivity(), "请选择用电类型");
        } else if (i > 30 && i < 655) {
            BusinessControllers.getInstance().ammeterInit(getLoginAccount(), this.mQrcodeData, this.mWalletModel.typeId + "", str4, j + "", str3, localDate, this.mId, this.mBluetoothDevice.mAddress, this.mEtInitMoney.getText().toString(), randNumMaxStringNonO, i, str, new Listener<AmmeterInitBean>() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.7
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    InitAmmeterActivity.this.showDialog();
                    if (InitAmmeterActivity.this.mMaterialDialog != null) {
                        InitAmmeterActivity.this.mMaterialDialog.setContent("正在初始化中，请稍等...");
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, AmmeterInitBean ammeterInitBean, Object... objArr) {
                    String strDecrypt;
                    if (!StringUtils.isNotEmpty(ammeterInitBean.machineid) || !StringUtils.isNotEmpty(ammeterInitBean.moneyVal) || !randNumMaxStringNonO.equals(ammeterInitBean.rand) || !ammeterInitBean.machineid.equals(InitAmmeterActivity.this.mQrcodeData)) {
                        InitAmmeterActivity.this.dismissDialog();
                        ToastUtils.show(InitAmmeterActivity.this.getContext(), "服务器下发的数据有问题");
                        return;
                    }
                    try {
                        strDecrypt = AESHelper.decrypt(ammeterInitBean.moneyVal, StringUtils.asciiToString("121,107,116,95,50,48,49,55,95,64,37,48,50,48,95,87,90,81,73,84,83,84,89,85,73,74,104,100,48,56,48,50"));
                    } catch (Exception e) {
                        e.printStackTrace();
                        strDecrypt = null;
                    }
                    if (!StringUtils.isNotEmpty(strDecrypt) || strDecrypt.length() <= 2) {
                        return;
                    }
                    InitAmmeterActivity.this.mIsDestroy = false;
                    InitAmmeterActivity.this.sendwriteAccountRechargeDestroyData(strDecrypt.substring(0, strDecrypt.length() - 2));
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    InitAmmeterActivity.this.dismissDialog();
                    ToastUtils.show(InitAmmeterActivity.this.getContext(), clientException.getDetail());
                    InitAmmeterActivity.this.finish();
                }
            });
        } else {
            ToastUtils.show(getActivity(), "不合法的电价！");
        }
    }

    private void initSuccess() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterInitSuccess(getLoginAccount(), this.mQrcodeData, this.mId, randNumMaxStringNonO, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, this.mWalletModel.typeId, new Listener<AmmeterStateBean>() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterStateBean ammeterStateBean, Object... objArr) {
                InitAmmeterActivity.this.dismissDialog();
                if (randNumMaxStringNonO.equals(ammeterStateBean.rand)) {
                    ToastUtils.show(InitAmmeterActivity.this.getActivity(), "初始化成功");
                    SettingAmmeterActivity.launch(InitAmmeterActivity.this.getActivity(), InitAmmeterActivity.this.mDeviceAddress);
                    InitAmmeterActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                InitAmmeterActivity.this.dismissDialog();
                ToastUtils.show(InitAmmeterActivity.this.getActivity(), clientException.getDetail());
                InitAmmeterActivity.this.finish();
            }
        });
    }

    private void initSuccess1() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterInitSuccess1(getLoginAccount(), this.mQrcodeData, this.mId, randNumMaxStringNonO, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, this.mWalletModel.typeId, new Listener<AmmeterStateBean>() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterStateBean ammeterStateBean, Object... objArr) {
                InitAmmeterActivity.this.dismissDialog();
                if (randNumMaxStringNonO.equals(ammeterStateBean.rand)) {
                    ToastUtils.show(InitAmmeterActivity.this.getActivity(), "初始化成功");
                    SettingAmmeterActivity.launch(InitAmmeterActivity.this.getActivity(), InitAmmeterActivity.this.mDeviceAddress);
                    InitAmmeterActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                InitAmmeterActivity.this.dismissDialog();
                ToastUtils.show(InitAmmeterActivity.this.getActivity(), clientException.getDetail());
                InitAmmeterActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        try {
            dismissDialog();
            MaterialDialog materialDialogShow = new MaterialDialog.Builder(getActivity()).content("正在连接中...").progress(true, 0).dismissListener(new DialogInterface.OnDismissListener() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.10
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
        runOnUiThread(new Runnable() { // from class: client.android.yixiaotong.ui.ammeter.InitAmmeterActivity.11
            @Override // java.lang.Runnable
            public void run() {
                InitAmmeterActivity.this.mAmmeterBluetoothManager.connect(InitAmmeterActivity.this.mBluetoothDevice.mAddress);
            }
        }, 100L);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendGetDeviceInfoData() {
        this.mReceivedCode = "FF";
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceInfo(randNumMaxString)));
    }

    private void sendGetDeviceTypeStateDeviceNouserNo(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.getDeviceTypeStateDeviceNouserNo(str, randNumMaxString)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendwriteAccountRechargeDestroyData(String str) {
        this.mSendCode = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, AmmeterBluetoothDevice.HexString.hexToBuffer(AmmeterCommandUtils.writeAccountRechargeDestroy("00", Short.parseShort(str), this.mReceivedCode, this.mSendCode)));
    }

    private void sendwriteUserNumber(String str, String str2) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, AmmeterBluetoothDevice.HexString.hexToBuffer(AmmeterCommandUtils.writeUserNumber(str, str2, randNumMaxString)));
    }

    private void sendWriteAccountRechargeDestroy(String str) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.writeAccountRechargeDestroy("02", (short) 0, str, randNumMaxString)));
    }

    private void sendsetname(String str, String str2) {
        String randNumMaxString = AmmeterRandomUtils.getRandNumMaxString(2);
        this.mSendCode = randNumMaxString;
        this.mAmmeterBluetoothManager.sendData(this.mBluetoothDevice.mAddress, HexString.hexToBuffer(AmmeterCommandUtils.setName(str, str2, randNumMaxString)));
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDisconnected(String str) {
        if (this.mIsEnable) {
            dismissDialog();
            AmmeterBluetoothManager.getInstance().disConnectAll();
            ToastUtils.show(getContext(), "电表蓝牙信号不好，请重试");
            finish();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectionFailed(String str) {
        if (this.mIsEnable) {
            dismissDialog();
            AmmeterBluetoothManager.getInstance().disConnectAll();
            ToastUtils.show(getContext(), "连接电表失败");
            finish();
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onConnectState(String str, boolean z) {
        this.mSupport = z;
        if (!z) {
            ToastUtils.show(getContext(), "你连接的不是电表设备");
            return;
        }
        if (isShowingDialog()) {
            this.mMaterialDialog.setContent("电表蓝牙匹配成功，正在连接电表...");
        }
        this.handlersend.postDelayed(this.runnableSend, 1000L);
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
        showDialog();
        if (!z) {
            connet();
        } else {
            this.handlersend.postDelayed(this.runnableSend, 100L);
        }
    }

    @Override // client.android.yixiaotong.util.ammeterbluetooth.AmmeterBluetoothManager.Listener
    public void onDataReceived(String str, byte[] bArr) {
        String strBufferToHex = AmmeterBluetoothDevice.HexString.bufferToHex(bArr);
        AmmeterCommandUtils.isConnectResult(strBufferToHex);
        if ("81".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase;
            if (this.mSendCode.equals(upperCase)) {
                String upperCase2 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase2;
                sendGetDeviceTypeStateDeviceNouserNo(upperCase2);
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("B5".equals(strBufferToHex.substring(4, 6))) {
            dismissDialog();
            String upperCase3 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase3;
            if (this.mSendCode.equals(upperCase3)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                String binaryString = Integer.toBinaryString(Integer.parseInt(strBufferToHex.substring(8, 10), 16));
                if (binaryString.length() < 8) {
                    this.mUserState = false;
                } else if (binaryString.substring(0, 1).equals("1")) {
                    this.mUserState = true;
                } else if (binaryString.substring(0, 1).equals("0")) {
                    this.mUserState = false;
                }
                String strSubstring = strBufferToHex.substring(10, 26);
                this.mDeviceNo = strSubstring;
                if (!this.mQrcodeData.contains(strSubstring.substring(4))) {
                    ToastUtils.show(getActivity(), "连错电表了，请重新选择电表！");
                    finish();
                }
                this.mUserNo = strBufferToHex.substring(26, 50);
                if (!this.mIsFlag.equals("1")) {
                    if (this.mIsFlag.equals("4") && this.mUserState) {
                        this.mIsDestroy = true;
                        sendWriteAccountRechargeDestroy(this.mReceivedCode);
                        return;
                    }
                    return;
                }
                int i = this.mIsHasAmmeter;
                if (i == 2) {
                    if (this.mUserState) {
                        this.mIsDestroy = true;
                        sendWriteAccountRechargeDestroy(this.mReceivedCode);
                        return;
                    }
                    return;
                }
                if (i == 6) {
                    if (this.mUserState) {
                        this.mIsDestroy = true;
                        sendWriteAccountRechargeDestroy(this.mReceivedCode);
                        return;
                    }
                    return;
                }
                if (this.mUserState && this.mUserNo.toUpperCase().contains("FFFFFFFF")) {
                    this.mIsDestroy = true;
                    sendWriteAccountRechargeDestroy(this.mReceivedCode);
                    return;
                }
                return;
            }
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("8B".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase4 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase4;
            if (this.mSendCode.equals(upperCase4)) {
                String upperCase5 = strBufferToHex.substring(2, 4).toUpperCase();
                this.mReceivedCode = upperCase5;
                if (this.mIsDestroy) {
                    return;
                }
                this.mUserState = true;
                sendwriteUserNumber(this.mQrcodeData, upperCase5);
                return;
            }
            dismissDialog();
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("85".equals(strBufferToHex.substring(4, 6))) {
            String upperCase6 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase6;
            if (this.mSendCode.equals(upperCase6)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                if (this.mIsFlag.equals("4")) {
                    initSuccess1();
                    return;
                } else {
                    initSuccess();
                    return;
                }
            }
            dismissDialog();
            ToastUtils.show(getContext(), "校验码出错啦！");
            return;
        }
        if ("8F".equals(strBufferToHex.substring(4, 6).toUpperCase())) {
            String upperCase7 = strBufferToHex.substring(0, 2).toUpperCase();
            this.mReceivedCode = upperCase7;
            if (this.mSendCode.equals(upperCase7)) {
                this.mReceivedCode = strBufferToHex.substring(2, 4).toUpperCase();
                btnInit();
                return;
            } else {
                ToastUtils.show(getContext(), "校验码出错啦！");
                return;
            }
        }
        dismissDialog();
        String strSubstring2 = strBufferToHex.substring(4, 6);
        if (strSubstring2.toUpperCase().equals("C2")) {
            ToastUtils.show(getContext(), "获取设备类型和状态存在异常！");
            return;
        }
        if (strSubstring2.toUpperCase().equals("F5")) {
            ToastUtils.show(getContext(), "设备类型和状态设备编号用户编号存在异常！");
            return;
        }
        if (strSubstring2.toUpperCase().equals("C1")) {
            ToastUtils.show(getContext(), "获取设备信息存在异常！");
            return;
        }
        if (strSubstring2.toUpperCase().equals("C3")) {
            ToastUtils.show(getContext(), "获取设备编号存在异常！");
            return;
        }
        if (strSubstring2.toUpperCase().equals("CB")) {
            ToastUtils.show(getContext(), "初始化电表存在异常！");
            return;
        }
        if (strSubstring2.toUpperCase().equals("C5")) {
            ToastUtils.show(getContext(), "写入用户编号存在异常！");
        } else if (strSubstring2.toUpperCase().equals("CF")) {
            ToastUtils.show(getContext(), "写入蓝牙名称存在异常！");
            finish();
        } else {
            ToastUtils.show(getContext(), "未知错误");
        }
    }
}
