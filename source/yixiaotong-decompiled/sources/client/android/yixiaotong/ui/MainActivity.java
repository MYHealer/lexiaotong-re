package client.android.yixiaotong.ui;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewFlipper;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.BaseApplication;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.baseutil.ActivitiesHelper;
import client.android.yixiaotong.controller.BusinessControllers;
import client.android.yixiaotong.controller.bean.AeemterAuthorizeBean;
import client.android.yixiaotong.controller.bean.AmmeterDestroyBean;
import client.android.yixiaotong.controller.bean.DeviceInfoBean;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.LocalBusinessStore;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.OrderIdUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.bluetooth.BluetoothManager;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.util.random.RandomUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.stub.StubApp;
import java.math.BigDecimal;
import lxt.com.a.S;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6847780.dex */
public class MainActivity extends BaseActivity {
    private ApplicationFragment mApplicationFragment;
    private View mChooseTab;
    private DeviceFragment mDeviceFragment;
    FrameLayout mMainLayoutTab1;
    FrameLayout mMainLayoutTab2;
    FrameLayout mMainLayoutTab3;
    FrameLayout mMainLayoutTab4;
    ViewFlipper mMainSwitcher;
    private MeFragment mMeFragment;
    private MessageFragment mMessageFragment;
    RadioButton mRBtnAccount;
    RadioButton mRBtnDevice;
    RadioButton mRBtnMe;
    RadioButton mRBtnMessage;
    private boolean mIsOpenDevice = false;
    private long mLastExitTime = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.ui.MainActivity.5
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 1 && MainActivity.this.mIsOpenDevice) {
                if (BluetoothManager.getInstance().isBluetoothOn()) {
                    MainActivity.this.showDeviceFragment();
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.chooseRadioBtn(mainActivity.mChooseTab);
                } else {
                    MainActivity.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 2001);
                }
            }
        }
    };
    private boolean mIsOpen = true;

    static {
        StubApp.interface11(5965);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    private void initViewNew() {
        this.mMainLayoutTab1 = (FrameLayout) findViewById(R.id.main_layout_tab1);
        this.mMainLayoutTab2 = (FrameLayout) findViewById(R.id.main_layout_tab2);
        this.mMainLayoutTab3 = (FrameLayout) findViewById(R.id.main_layout_tab3);
        this.mMainLayoutTab4 = (FrameLayout) findViewById(R.id.main_layout_tab4);
        this.mMainSwitcher = (ViewFlipper) findViewById(R.id.main_switcher);
        this.mRBtnAccount = (RadioButton) findViewById(R.id.rbtn_account);
        this.mRBtnDevice = (RadioButton) findViewById(R.id.rbtn_device);
        this.mRBtnMessage = (RadioButton) findViewById(R.id.rbtn_message);
        this.mRBtnMe = (RadioButton) findViewById(R.id.rbtn_me);
    }

    private void initClickListeners() {
        findViewById(R.id.rbtn_account).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MainActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.mIsOpenDevice = false;
                MainActivity.this.chooseRadioBtn(view);
                MainActivity.this.showAccountFragment();
            }
        });
        findViewById(R.id.rbtn_device).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MainActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.mIsOpenDevice = true;
                MainActivity.this.mChooseTab = view;
                PermissionUtil.requestPerssion(MainActivity.this.getActivity(), 1, MainActivity.this.permissionGrant);
            }
        });
        findViewById(R.id.rbtn_message).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MainActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.mIsOpenDevice = false;
                MainActivity.this.chooseRadioBtn(view);
                MainActivity.this.showMessageFragment();
            }
        });
        findViewById(R.id.rbtn_me).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.ui.MainActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MainActivity.this.mIsOpenDevice = false;
                MainActivity.this.chooseRadioBtn(view);
                MainActivity.this.showMeFragment();
            }
        });
    }

    public static void launch(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        if (NetworkUtils.isNetworkAvailable(getContext())) {
            ApplicationFragment applicationFragment = (ApplicationFragment) getFragmentManager().findFragmentById(R.id.main_layout_tab1);
            if (applicationFragment.mNoticePagerGalleryView != null) {
                applicationFragment.mNoticePagerGalleryView.startTimer();
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        if (NetworkUtils.isNetworkAvailable(getContext())) {
            ApplicationFragment applicationFragment = (ApplicationFragment) getFragmentManager().findFragmentById(R.id.main_layout_tab1);
            if (applicationFragment.mNoticePagerGalleryView != null) {
                applicationFragment.mNoticePagerGalleryView.stopTimer();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseRadioBtn(View view) {
        this.mRBtnAccount.setChecked(false);
        this.mRBtnDevice.setChecked(false);
        this.mRBtnMessage.setChecked(false);
        this.mRBtnMe.setChecked(false);
        ((RadioButton) view).setChecked(true);
        if (this.mIsOpenDevice) {
            LocalBusinessStore.saveDeviceFragmentVisable(getContext(), true);
        } else {
            LocalBusinessStore.saveDeviceFragmentVisable(getContext(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAccountFragment() {
        if (this.mApplicationFragment == null || this.mMainSwitcher.getDisplayedChild() != 0) {
            if (this.mApplicationFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab1)).removeAllViews();
                this.mApplicationFragment = ApplicationFragment.newInstance();
                getFragmentManager().beginTransaction().add(R.id.main_layout_tab1, this.mApplicationFragment, "mainFragment");
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab1, this.mApplicationFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDeviceFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 1 || this.mDeviceFragment == null) {
            if (this.mDeviceFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab2)).removeAllViews();
                this.mDeviceFragment = DeviceFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab2, this.mDeviceFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMessageFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 2 || this.mMessageFragment == null) {
            if (this.mMessageFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab3)).removeAllViews();
                this.mMessageFragment = MessageFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab3, this.mMessageFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMeFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 3 || this.mMeFragment == null) {
            if (this.mMeFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab4)).removeAllViews();
                this.mMeFragment = MeFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab4, this.mMeFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(3);
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            exitApp();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    public void exitApp() {
        if (System.currentTimeMillis() - this.mLastExitTime > 1000) {
            Toast.makeText(getContext(), "再按一次退出程序", 0).show();
            this.mLastExitTime = System.currentTimeMillis();
            return;
        }
        LocalDataUtil.saveIsNeedLoadAdv(getActivity(), true);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        startActivity(intent);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        LocalDataUtil.saveIsNeedLoadAdv(getActivity(), false);
        if (S.b(getContext())) {
            return;
        }
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(BaseApplication.app);
        ActivitiesHelper.getInstance().closeExcept(LoginActivity.class);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mApplicationFragment = null;
        this.mMainLayoutTab1.removeAllViews();
        this.mMainLayoutTab2.removeAllViews();
        this.mMainLayoutTab3.removeAllViews();
        this.mMainLayoutTab4.removeAllViews();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 2001) {
            if (i2 != -1) {
                if (i2 != 0) {
                    return;
                }
                this.mIsOpen = false;
            } else {
                this.mIsOpen = true;
                showDeviceFragment();
                chooseRadioBtn(this.mChooseTab);
            }
        }
    }

    private void ammeterAuth() {
        BusinessControllers.getInstance().ammeterAuthorize(getLoginAccount(), "27", 0, "000000001177000000463273", 7, 0, "123456", 1, "CDQ20240617143016395_G56XH8", new BigDecimal("1.34").multiply(new BigDecimal(100.0d)).intValue() + "", new BigDecimal("192.27").multiply(new BigDecimal(100.0d)).intValue() + "", new Listener<AeemterAuthorizeBean>() { // from class: client.android.yixiaotong.ui.MainActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (clientException.getCode() == 4080) {
                    MainActivity.this.shouquanHistory(((AeemterAuthorizeBean) clientException.getObject()).orderid);
                } else {
                    SystemErrorTip.getInstance().showTipDialog(MainActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.ui.MainActivity.6.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            MainActivity.this.finish();
                        }
                    }, clientException.getDetail());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shouquanHistory(String str) {
        BusinessControllers.getInstance().ammeterAuthorize(getLoginAccount(), "27", 0, "000000001177000000463273", 7, 0, "654321", 1, str, new BigDecimal("1.34").multiply(new BigDecimal(100.0d)).intValue() + "", new BigDecimal("192.27").multiply(new BigDecimal(100.0d)).intValue() + "", new Listener<AeemterAuthorizeBean>() { // from class: client.android.yixiaotong.ui.MainActivity.7
        });
    }

    private void ammerSala() {
        String localDate = OrderIdUtils.getLocalDate("yyyyMMddHHmmss");
        String str = getLoginAccount().getAccountManagetStore().getUserInfo().StudentName;
        String localDate2 = OrderIdUtils.getLocalDate("yyyyMMddHHmmss");
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterSales(getLoginAccount(), "AC:9A:22:3B:35:FF", "30338", "1189000000598348", "6332", localDate, str, localDate2, randNumMaxStringNonO, "000000001189000000598348", new Listener<AmmeterDestroyBean>() { // from class: client.android.yixiaotong.ui.MainActivity.8
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterDestroyBean ammeterDestroyBean, Object... objArr) {
                if (randNumMaxStringNonO.equals(ammeterDestroyBean.rand)) {
                    return;
                }
                ToastUtils.show(MainActivity.this.getActivity(), "电表已经销户了");
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (clientException.getCode() == 4059) {
                    return;
                }
                ToastUtils.show(MainActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void salesSuccess() {
        final String randNumMaxStringNonO = RandomUtils.getRandNumMaxStringNonO(6);
        BusinessControllers.getInstance().ammeterSalesSuccess(getLoginAccount(), "000000001189000000598348", randNumMaxStringNonO, "AC:9A:22:3B:35:FF", "000000598348", new Listener<AmmeterDestroyBean>() { // from class: client.android.yixiaotong.ui.MainActivity.9
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AmmeterDestroyBean ammeterDestroyBean, Object... objArr) {
                if (StringUtils.isNotEmpty(ammeterDestroyBean.rand) && randNumMaxStringNonO.equals(ammeterDestroyBean.rand)) {
                    ToastUtils.show(MainActivity.this.getContext(), "销户成功");
                    MainActivity.this.finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                ToastUtils.show(MainActivity.this.getActivity(), clientException.getDetail());
            }
        });
    }

    private void bathSmallGetDeviceInfo() {
        BusinessControllers.getInstance().getSmpDeviceInfo(getLoginAccount(), "A3752A1D", new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.MainActivity.10
        });
    }

    private void getNewDeviceInfo() {
        BusinessControllers.getInstance().getNewDeviceInfo(getLoginAccount(), "1414010848872D2CD8DC", 340000000000160217L, new Listener<DeviceInfoBean>() { // from class: client.android.yixiaotong.ui.MainActivity.11
        });
    }
}
