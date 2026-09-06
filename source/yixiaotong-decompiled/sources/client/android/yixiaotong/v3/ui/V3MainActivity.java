package client.android.yixiaotong.v3.ui;

import android.app.Activity;
import android.app.Fragment;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewFlipper;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.activitycontrol.WelcomeControlUtil;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.android.ClientUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.AlarmSwitchBean2;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.control.AppUpdateControlUtil;
import client.android.yixiaotong.v3.ui.control.BindSchoolGiveControl;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3MainActivity extends BaseActivity {
    private static final String TAG = "V3MainActivity";
    private V3ApplicationFragment mApplicationFragment;
    private boolean mIsWaitAlarmSwitchUserInfo;
    private FrameLayout mMainLayoutTab1;
    private FrameLayout mMainLayoutTab2;
    private FrameLayout mMainLayoutTab3;
    private FrameLayout mMainLayoutTab4;
    private ViewFlipper mMainSwitcher;
    private V3MeFragment mMeFragment;
    private V3OrderFragment mOrderFragment;
    private RadioButton mRBtnAccount;
    private RadioButton mRBtnDevice;
    private RadioButton mRBtnMe;
    private RadioButton mRBtnMessage;
    private V3ServerFragment mServerFragment;
    private UIVisableBean mUIVisableBean;
    private int mSelectIndex = 1;
    private boolean mIsEnable = true;
    private MainListener mMainListener = new MainListener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity.3
        @Override // client.android.yixiaotong.v3.ui.MainListener
        public void onApplication(int i) {
            LogUtil.e(V3MainActivity.TAG, "onApplication:" + i);
            if (i == 0) {
                if (!LocalDataUtil.getIsAgreed(V3MainActivity.this.getActivity(), 1) || !LocalDataUtil.getIsAgreed(V3MainActivity.this.getActivity(), 2)) {
                    SystemErrorTip.getInstance().showTipDialog(V3MainActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity.3.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            LocalDataUtil.savePermissIndex(V3MainActivity.this.getActivity(), 1);
                            LocalDataUtil.savePermissIndex(V3MainActivity.this.getActivity(), 2);
                            PermissionUtil.requestPerssion(V3MainActivity.this.getActivity(), 0, V3MainActivity.this.permissionGrant);
                        }
                    }, "需要开启相机和定位/蓝牙权限，用于扫描学校码、设备码和启用设备的功能");
                } else {
                    PermissionUtil.requestPerssion(V3MainActivity.this.getActivity(), 0, V3MainActivity.this.permissionGrant);
                }
            }
        }
    };
    private long mLastExitTime = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity.5
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(V3MainActivity.TAG, "onPermissionGranted:" + i);
            if (i == 0) {
                PermissionUtil.requestPerssion(V3MainActivity.this.getActivity(), 1, V3MainActivity.this.permissionGrant);
                return;
            }
            if (i != 1) {
                return;
            }
            if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeActivity.launch1(V3MainActivity.this.getActivity(), 11);
                    return;
                } else {
                    ZxingScanV3Activity.launch(V3MainActivity.this.getActivity(), 11);
                    return;
                }
            }
            V3MainActivity.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        }
    };

    static {
        StubApp.interface11(8822);
    }

    @Override // android.app.Activity
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, V3MainActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    private void initViewNew() {
        this.mMainLayoutTab1 = (FrameLayout) findViewById(R.id.main_layout_tab1);
        this.mMainLayoutTab2 = (FrameLayout) findViewById(R.id.main_layout_tab2);
        this.mMainLayoutTab3 = (FrameLayout) findViewById(R.id.main_layout_tab3);
        this.mMainLayoutTab4 = (FrameLayout) findViewById(R.id.main_layout_tab4);
        this.mMainSwitcher = (ViewFlipper) findViewById(R.id.main_switcher);
        this.mRBtnAccount = (RadioButton) findViewById(R.id.rbtn_account);
        this.mRBtnDevice = (RadioButton) findViewById(R.id.rbtn_service);
        this.mRBtnMessage = (RadioButton) findViewById(R.id.rbtn_order);
        this.mRBtnMe = (RadioButton) findViewById(R.id.rbtn_me);
    }

    private void initClickListeners() {
        findViewById(R.id.rbtn_account).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m184x43289d4c(view);
            }
        });
        findViewById(R.id.rbtn_service).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m185x7cf33f2b(view);
            }
        });
        findViewById(R.id.rbtn_order).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m186xb6bde10a(view);
            }
        });
        findViewById(R.id.rbtn_me).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m187xf08882e9(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-V3MainActivity, reason: not valid java name */
    /* synthetic */ void m184x43289d4c(View view) {
        this.mSelectIndex = 1;
        chooseRadioBtn(view);
        showAccountFragment();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-V3MainActivity, reason: not valid java name */
    /* synthetic */ void m185x7cf33f2b(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            initView();
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            if (isCheckSchool()) {
                this.mSelectIndex = 2;
                chooseRadioBtn(view);
                showServerFragment();
                return;
            }
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-V3MainActivity, reason: not valid java name */
    /* synthetic */ void m186xb6bde10a(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            initView();
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
            return;
        }
        if (isCheckSchool()) {
            UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid();
            if (useSoftwareProductBeanIsUseAndroid.isUse) {
                EventBus.getDefault().post(new NoPayOrderBean());
                this.mSelectIndex = 3;
                chooseRadioBtn(view);
                showOrderFragment();
                return;
            }
            showDialog(true, useSoftwareProductBeanIsUseAndroid.msg, "确定", "");
            return;
        }
        showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-V3MainActivity, reason: not valid java name */
    /* synthetic */ void m187xf08882e9(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            initView();
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
            return;
        }
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid();
        if (useSoftwareProductBeanIsUseAndroid.isUse || !isCheckSchool()) {
            this.mSelectIndex = 4;
            chooseRadioBtn(view);
            showMeFragment();
            return;
        }
        showDialog(true, useSoftwareProductBeanIsUseAndroid.msg, "退出登录", "");
    }

    private boolean isCheckSchool() {
        return UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList != null;
    }

    private void initView() {
        int i = this.mSelectIndex;
        if (i == 2) {
            this.mRBtnAccount.setChecked(false);
            this.mRBtnDevice.setChecked(true);
            this.mRBtnMessage.setChecked(false);
            this.mRBtnMe.setChecked(false);
            return;
        }
        if (i == 3) {
            this.mRBtnAccount.setChecked(false);
            this.mRBtnDevice.setChecked(false);
            this.mRBtnMessage.setChecked(true);
            this.mRBtnMe.setChecked(false);
            return;
        }
        if (i == 4) {
            this.mRBtnAccount.setChecked(false);
            this.mRBtnDevice.setChecked(false);
            this.mRBtnMessage.setChecked(false);
            this.mRBtnMe.setChecked(true);
            return;
        }
        this.mRBtnAccount.setChecked(true);
        this.mRBtnDevice.setChecked(false);
        this.mRBtnMessage.setChecked(false);
        this.mRBtnMe.setChecked(false);
    }

    private void showDialog(boolean z, String str, final String str2, String str3) {
        initView();
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (str2.equals("退出登录")) {
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(V3MainActivity.this.getActivity());
                        V3MainActivity.this.getActivity().finish();
                    }
                }
            }, str, str2);
        } else {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity.2
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    if (ClickUtil.isFastDoubleClick()) {
                        return;
                    }
                    ChangeSchoolActivity.launch(V3MainActivity.this.getActivity());
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(V3MainActivity.this.getActivity());
                    V3MainActivity.this.getActivity().finish();
                }
            }, "提示", str, str2, str3);
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        handlerOnResume();
    }

    private void handlerOnCreate() {
        LogUtil.e(TAG, "onCreate:");
        this.mUIVisableBean = new UIVisableBean();
        getLoginAccount().setUid(1L);
        ClientUtils.setIsLoginSuccess(getActivity(), true);
        LocalDataUtil.saveIsNeedLoadVersion(getActivity(), 0);
        AppUpdateControlUtil.getInstance().init(getLoginAccount(), getActivity(), "首页");
    }

    private void handlerOnResume() {
        AppUpdateControlUtil.getInstance().onResume();
        AppUpdateControlUtil.getInstance().getVerSion();
        BindSchoolGiveControl.getInstance().init(getLoginAccount(), getActivity(), "首页");
        BindSchoolGiveControl.getInstance().onResume();
        LocalDataUtil.saveIsNeedLoadAdv(getActivity(), false);
        WelcomeControlUtil.getInstance().userActiveInfo(getLoginAccount(), getActivity());
        AdvControlUtil.getInstance().onResume();
        loadAlarmSwitch2("handlerOnResume");
    }

    public void onUserInfoLoadedForAlarmSwitch() {
        if (this.mIsWaitAlarmSwitchUserInfo) {
            LogUtil.e("AlarmPswTrace", "V3MainActivity userInfo loaded retry alarmSwitch2");
            loadAlarmSwitch2("userInfoLoaded");
        }
    }

    private void loadAlarmSwitch2(final String str) {
        String str2 = UserInfoUtil.getInstance().getLoginAccountV3() != null ? UserInfoUtil.getInstance().getLoginAccountV3().studentHex : "";
        if (StringUtils.isEmpty(str2)) {
            this.mIsWaitAlarmSwitchUserInfo = true;
            LocalDataUtil.saveAlarmSwitch(getActivity(), false);
            LocalDataUtil.saveAlarmPsw(getActivity(), "");
            LogUtil.e("AlarmPswTrace", "V3MainActivity alarmSwitch2 wait userInfo source=" + str + " studentHex=" + str2);
            return;
        }
        this.mIsWaitAlarmSwitchUserInfo = false;
        final String str3 = str2 + ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT);
        LogUtil.e("AlarmPswTrace", "V3MainActivity alarmSwitch2 request source=" + str + " seed=" + str3);
        V3BusinessControllers.getInstance().alarmSwitch2(getLoginAccount(), str3, new Listener<AlarmSwitchBean2>() { // from class: client.android.yixiaotong.v3.ui.V3MainActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AlarmSwitchBean2 alarmSwitchBean2, Object... objArr) {
                super.onComplete(controller, alarmSwitchBean2, objArr);
                LogUtil.e("AlarmPswTrace", "V3MainActivity alarmSwitch2 complete source=" + str + " seed=" + str3 + " goWhite=" + alarmSwitchBean2.goWhite + " openPassword=" + alarmSwitchBean2.openPassword);
                LocalDataUtil.saveAlarmSwitch(V3MainActivity.this.getActivity(), alarmSwitchBean2.goWhite);
                LocalDataUtil.saveAlarmPsw(V3MainActivity.this.getActivity(), alarmSwitchBean2.openPassword);
                LogUtil.log("alarmSwitch:" + alarmSwitchBean2);
                LogUtil.e("alarmSwitch", "alarmSwitch:" + alarmSwitchBean2);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                LogUtil.e("AlarmPswTrace", "V3MainActivity alarmSwitch2 fail source=" + str + " seed=" + str3 + " error=" + clientException.getDetail());
                LocalDataUtil.saveAlarmSwitch(V3MainActivity.this.getActivity(), false);
                LogUtil.log("alarmSwitch:" + clientException.getDetail());
                LogUtil.e("alarmSwitch", "alarmSwitch:" + clientException.getDetail());
            }
        });
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        AppUpdateControlUtil.getInstance().onPause();
        BindSchoolGiveControl.getInstance().onPause();
        AdvControlUtil.getInstance().onPause();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        NetworkUtils.isNetworkAvailable(getContext());
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        NetworkUtils.isNetworkAvailable(getContext());
    }

    private void chooseRadioBtn(View view) {
        this.mUIVisableBean.index = this.mSelectIndex;
        EventBus.getDefault().post(this.mUIVisableBean);
        this.mRBtnAccount.setChecked(false);
        this.mRBtnDevice.setChecked(false);
        this.mRBtnMessage.setChecked(false);
        this.mRBtnMe.setChecked(false);
        ((RadioButton) view).setChecked(true);
    }

    private void showAccountFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 0 || this.mApplicationFragment == null) {
            if (this.mApplicationFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab1)).removeAllViews();
                this.mApplicationFragment = V3ApplicationFragment.newInstance();
                getFragmentManager().beginTransaction().add(R.id.main_layout_tab1, this.mApplicationFragment, "mainFragment");
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab1, this.mApplicationFragment).commit();
            }
            this.mApplicationFragment.setMainListener(this.mMainListener);
            this.mMainSwitcher.setDisplayedChild(0);
        }
    }

    private void showServerFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 1 || this.mServerFragment == null) {
            if (this.mServerFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab2)).removeAllViews();
                this.mServerFragment = V3ServerFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab2, this.mServerFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(1);
        }
    }

    private void showOrderFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 2 || this.mMeFragment == null) {
            if (this.mOrderFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab3)).removeAllViews();
                this.mOrderFragment = V3OrderFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab3, this.mOrderFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(2);
        }
    }

    private void showMeFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 3 || this.mMeFragment == null) {
            if (this.mMeFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab4)).removeAllViews();
                this.mMeFragment = V3MeFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab4, this.mMeFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(3);
            AppUpdateControlUtil.getInstance().updateTip();
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
    protected void onDestroy() {
        super.onDestroy();
        this.mIsEnable = false;
        BaseMaterialDialog.dissmisMaterialDialog();
        this.mApplicationFragment = null;
        this.mMainLayoutTab1.removeAllViews();
        this.mMainLayoutTab2.removeAllViews();
        this.mMainLayoutTab3.removeAllViews();
        this.mMainLayoutTab4.removeAllViews();
        EventBus.getDefault().unregister(this);
        AdvControlUtil.getInstance().onDestroy(getActivity());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LogUtil.e(TAG, "onActivityResult:" + i + "  " + i2);
        if (i == 200 && i2 == -1) {
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeActivity.launch1(getActivity(), 11);
            } else {
                ZxingScanV3Activity.launch(getActivity(), 11);
            }
        }
    }
}
