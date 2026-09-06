package client.android.yixiaotong.ui.hamam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.SuccessBean;
import client.android.yixiaotong.controller.bean.hamam.HamamInitDeviceBean;
import client.android.yixiaotong.controller.bean.hamam.UnRegisterBathHouseBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.model.WalletModel;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.sdk.utils.RandomUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ClickUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import com.hihonor.adsdk.base.g.j.e.a;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HamamInitActivity extends BaseActivity {
    public static final String EXTRA_CONNECTCOUNT = "extra_connectcount";
    public static final String EXTRA_DEVICEVER = "extra_devicever";
    public static final String EXTRA_ISINIT = "extra_isinit";
    public static final String EXTRA_MACHINEID = "extra_machineid";
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_WALLET = "extra_wallet";
    Button btnFinish;
    EditText mEtAnZhuangAddress;
    EditText mEtConnectCount;
    EditText mEtDeviceName;
    private String mHamamId;
    private int mIsInit;
    private String mMachineId;
    private String mPhone;
    RelativeLayout mRelAddress;
    RelativeLayout mRelBindHamam;
    RelativeLayout mRelCount;
    RelativeLayout mRelName;
    TitleBar mTitleBar;
    TextView mTvDeviceType;
    TextView mTvHamamName;
    TextView mTvOwner;
    TextView mTvSchool;
    private WalletModel mWalletModel;
    private String mMaxConnectCount = "0";
    private boolean mIsEnable = true;
    private String mDeviceVer = "";

    static {
        StubApp.interface11(7306);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity, WalletModel walletModel, String str, String str2, String str3, String str4, int i) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HamamInitActivity.class).putExtra("extra_wallet", walletModel).putExtra("extra_machineid", str).putExtra(EXTRA_PHOTO, str2).putExtra(EXTRA_CONNECTCOUNT, str3).putExtra(EXTRA_DEVICEVER, str4).putExtra("extra_isinit", i));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvOwner = (TextView) findViewById(R.id.tv_owner);
        this.mTvSchool = (TextView) findViewById(R.id.tv_scholl);
        this.mTvDeviceType = (TextView) findViewById(R.id.tv_device_type);
        this.mEtDeviceName = (EditText) findViewById(R.id.tv_device_name);
        this.mEtAnZhuangAddress = (EditText) findViewById(R.id.et_anzhuang_address);
        this.mEtConnectCount = (EditText) findViewById(R.id.tv_connect_count);
        this.mRelBindHamam = (RelativeLayout) findViewById(R.id.rl_bind_hamam);
        this.mTvHamamName = (TextView) findViewById(R.id.tv_choose_hamam);
        this.btnFinish = (Button) findViewById(R.id.btn_finish);
        this.mRelName = (RelativeLayout) findViewById(R.id.rel_name);
        this.mRelAddress = (RelativeLayout) findViewById(R.id.rel_address);
        this.mRelCount = (RelativeLayout) findViewById(R.id.rel_count);
    }

    private void initTitleBar() {
        if (this.mIsInit == 1) {
            this.mTitleBar.setTitleView("初始化设备");
            this.mTitleBar.setLeftView(R.mipmap.back);
            this.mTitleBar.setLeftViewOnClickBack(getActivity());
        } else {
            this.mTitleBar.setTitleView("解绑设备");
            this.mTitleBar.setLeftView(R.mipmap.back);
            this.mTitleBar.setLeftViewOnClickBack(getActivity());
        }
    }

    private void initView() {
        if (this.mIsInit == 1) {
            this.mRelAddress.setVisibility(0);
            this.mRelCount.setVisibility(0);
            this.mRelName.setVisibility(0);
        } else {
            this.mRelAddress.setVisibility(8);
            this.mRelCount.setVisibility(8);
            this.mRelName.setVisibility(8);
        }
        this.mTvOwner.setText(getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId);
        this.mTvSchool.setText(getLoginAccount().getAccountManagetStore().getUserInfo().SchoolName);
        this.mRelBindHamam.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamInitActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HamamSelectAddressActivity.launch(HamamInitActivity.this.getActivity(), 0);
            }
        });
        this.btnFinish.setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.hamam.HamamInitActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ClickUtils.isFastDoubleClick()) {
                    return;
                }
                HamamInitActivity.this.init();
            }
        });
    }

    private void hideSoftKey() {
        ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.mEtDeviceName.getWindowToken(), 0);
        this.mEtDeviceName.requestFocus();
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
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null) {
            String stringExtra = intent.getStringExtra(a.G0);
            this.mHamamId = intent.getStringExtra("id");
            if (StringUtils.isNotEmpty(stringExtra)) {
                this.mTvHamamName.setText(stringExtra);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().InvestorId;
        if (this.mIsInit == 1) {
            if (!StringUtils.isNotEmpty(this.mEtDeviceName.getText().toString())) {
                ToastUtils.show(getContext(), "请输入设备名称");
                return;
            }
            if (!StringUtils.isNotEmpty(this.mEtAnZhuangAddress.getText().toString())) {
                ToastUtils.show(getContext(), "请输入安装地址");
                return;
            }
            if (!StringUtils.isNotEmpty(this.mEtConnectCount.getText().toString())) {
                ToastUtils.show(getContext(), "请输入设备数量");
                return;
            }
            if (!StringUtils.isNotEmpty(this.mTvHamamName.getText().toString())) {
                ToastUtils.show(getContext(), "请选择浴室位置");
                return;
            } else {
                if (StringUtils.isNotEmpty(this.mTvOwner.getText().toString()) && StringUtils.isNotEmpty(this.mTvSchool.getText().toString())) {
                    BusinessControllers.getInstance().initHamam(getLoginAccount(), this.mMachineId, this.mWalletModel.typeId, this.mHamamId, str, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, this.mEtDeviceName.getText().toString(), this.mEtConnectCount.getText().toString(), this.mEtAnZhuangAddress.getText().toString(), this.mPhone, this.mMaxConnectCount, this.mDeviceVer, new Listener<HamamInitDeviceBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamInitActivity.3
                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onStart(Controller controller) {
                            super.onStart(controller);
                            BaseMaterialDialog.showMaterialDialog(HamamInitActivity.this.getActivity(), "开始初始化", true);
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onComplete(Controller controller, HamamInitDeviceBean hamamInitDeviceBean, Object... objArr) {
                            if (HamamInitActivity.this.mIsEnable) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                ToastUtils.show(HamamInitActivity.this.getContext(), "设备初始化成功！");
                                HamamInitActivity.this.finish();
                            }
                        }

                        @Override // client.android.yixiaotong.controller.core.Listener
                        public void onFail(Controller controller, ClientException clientException) {
                            if (HamamInitActivity.this.mIsEnable) {
                                BaseMaterialDialog.dissmisMaterialDialog();
                                SystemErrorTip.getInstance().showTipDialog(HamamInitActivity.this.getActivity(), clientException.getDetail());
                            }
                        }
                    });
                    return;
                }
                return;
            }
        }
        if (!StringUtils.isNotEmpty(this.mTvHamamName.getText().toString())) {
            ToastUtils.show(getContext(), "请选择浴室位置");
        } else if (StringUtils.isNotEmpty(this.mTvOwner.getText().toString()) && StringUtils.isNotEmpty(this.mTvSchool.getText().toString())) {
            BusinessControllers.getInstance().uninitHamam(getLoginAccount(), this.mMachineId, this.mWalletModel.typeId, this.mHamamId, getLoginAccount().getAccountManagetStore().getUserInfo().AreaId, new Listener<SuccessBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamInitActivity.4
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, SuccessBean successBean, Object... objArr) {
                    if (HamamInitActivity.this.mIsEnable) {
                        ToastUtils.show(HamamInitActivity.this.getContext(), "设备解绑成功！");
                        HamamInitActivity.this.finish();
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (HamamInitActivity.this.mIsEnable) {
                        SystemErrorTip.getInstance().showTipDialog(HamamInitActivity.this.getActivity(), clientException.getDetail());
                    }
                }
            });
        }
    }

    private void getChangeBathHouse() {
        BusinessControllers.getInstance().getChangeBathHouse(getLoginAccount(), this.mMachineId, RandomUtil.getRandNumMaxString(6), new Listener<UnRegisterBathHouseBean>() { // from class: client.android.yixiaotong.ui.hamam.HamamInitActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, UnRegisterBathHouseBean unRegisterBathHouseBean, Object... objArr) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }
        });
    }
}
