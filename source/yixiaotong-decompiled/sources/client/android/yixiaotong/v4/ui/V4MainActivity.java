package client.android.yixiaotong.v4.ui;

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
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.controller.store.ClientDataManager;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.AlarmSwitchBean2;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.bean.order.NoPayOrderBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.MainListener;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.util.V4AppUpdateControlUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4MainActivity extends BaseActivity {
    private static final String TAG = "V4MainActivity";
    private V4MainFragment mMainFragment;
    private FrameLayout mMainLayoutTab1;
    private FrameLayout mMainLayoutTab2;
    private FrameLayout mMainLayoutTab3;
    private FrameLayout mMainLayoutTab4;
    private ViewFlipper mMainSwitcher;
    private V4MeFragment mMeFragment;
    private V4OrderFragment mOrderFragment;
    private RadioButton mRBtnAccount;
    private RadioButton mRBtnDevice;
    private RadioButton mRBtnMe;
    private RadioButton mRBtnMessage;
    private V4ServerFragment mServerFragment;
    private UIVisableBean mUIVisableBean;
    private int mSelectIndex = 1;
    private boolean mIsEnable = true;
    private MainListener mMainListener = new MainListener() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity.1
        @Override // client.android.yixiaotong.v3.ui.MainListener
        public void onApplication(int i) {
            LogUtil.e(V4MainActivity.TAG, "onApplication:" + i);
            if (i == 0) {
                if (!LocalDataUtil.getIsAgreed(V4MainActivity.this.getActivity(), 1) || !LocalDataUtil.getIsAgreed(V4MainActivity.this.getActivity(), 2)) {
                    SystemErrorTip.getInstance().showTipDialog(V4MainActivity.this.getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity.1.1
                        @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                        public void onConfirm() {
                            LocalDataUtil.savePermissIndex(V4MainActivity.this.getActivity(), 1);
                            LocalDataUtil.savePermissIndex(V4MainActivity.this.getActivity(), 2);
                            PermissionUtil.requestPerssion(V4MainActivity.this.getActivity(), 0, V4MainActivity.this.permissionGrant);
                        }
                    }, "需要开启相机和定位/蓝牙权限，用于扫描学校码、设备码和启用设备的功能");
                } else {
                    PermissionUtil.requestPerssion(V4MainActivity.this.getActivity(), 0, V4MainActivity.this.permissionGrant);
                }
            }
        }
    };
    private long mLastExitTime = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity.2
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(V4MainActivity.TAG, "onPermissionGranted:" + i);
            if (i == 0) {
                PermissionUtil.requestPerssion(V4MainActivity.this.getActivity(), 1, V4MainActivity.this.permissionGrant);
                return;
            }
            if (i != 1) {
                return;
            }
            if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeActivity.launch1(V4MainActivity.this.getActivity(), 11);
                    return;
                } else {
                    ZxingScanV3Activity.launch(V4MainActivity.this.getActivity(), 11);
                    return;
                }
            }
            V4MainActivity.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        }
    };

    static {
        StubApp.interface11(10560);
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
        intent.setClass(activity, V4MainActivity.class);
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
        findViewById(R.id.rbtn_account).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m440xff56058e(view);
            }
        });
        findViewById(R.id.rbtn_service).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m441x3920a76d(view);
            }
        });
        findViewById(R.id.rbtn_order).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m442x72eb494c(view);
            }
        });
        findViewById(R.id.rbtn_me).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m443xacb5eb2b(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-V4MainActivity, reason: not valid java name */
    /* synthetic */ void m440xff56058e(View view) {
        handleTabClick(1, view, new Runnable() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showAccountFragment();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-V4MainActivity, reason: not valid java name */
    /* synthetic */ void m441x3920a76d(View view) {
        handleTabClick(2, view, new Runnable() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showServerFragment();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-V4MainActivity, reason: not valid java name */
    /* synthetic */ void m442x72eb494c(View view) {
        EventBus.getDefault().post(new NoPayOrderBean());
        handleTabClick(3, view, new Runnable() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showOrderFragment();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-V4MainActivity, reason: not valid java name */
    /* synthetic */ void m443xacb5eb2b(View view) {
        handleTabClick(4, view, new Runnable() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.showMeFragment();
            }
        });
    }

    private void handleTabClick(int i, View view, Runnable runnable) {
        if (i == 2 || i == 3) {
            if (isEnableAndroid()) {
                this.mSelectIndex = i;
                chooseRadioBtn(view);
                runnable.run();
                return;
            }
            return;
        }
        this.mSelectIndex = i;
        chooseRadioBtn(view);
        runnable.run();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4AppUpdateControlUtil.getInstance().onResume();
        V4AppUpdateControlUtil.getInstance().getVerSion();
        AdvControlUtil.getInstance().onResume();
        getWhiteState();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        V4AppUpdateControlUtil.getInstance().onPause();
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

    /* JADX INFO: Access modifiers changed from: private */
    public void showAccountFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 0 || this.mMainFragment == null) {
            if (this.mMainFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab1)).removeAllViews();
                this.mMainFragment = V4MainFragment.newInstance();
                getSupportFragmentManager().beginTransaction().add(R.id.main_layout_tab1, this.mMainFragment, "mainFragment");
                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_tab1, this.mMainFragment).commit();
            }
            this.mMainFragment.setMainListener(this.mMainListener);
            this.mMainSwitcher.setDisplayedChild(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showServerFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 1 || this.mServerFragment == null) {
            if (this.mServerFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab2)).removeAllViews();
                this.mServerFragment = V4ServerFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_tab2, this.mServerFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showOrderFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 2 || this.mMeFragment == null) {
            if (this.mOrderFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab3)).removeAllViews();
                this.mOrderFragment = V4OrderFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_tab3, this.mOrderFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showMeFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 3 || this.mMeFragment == null) {
            if (this.mMeFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab4)).removeAllViews();
                this.mMeFragment = V4MeFragment.newInstance();
                getSupportFragmentManager().beginTransaction().replace(R.id.main_layout_tab4, this.mMeFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(3);
            V4AppUpdateControlUtil.getInstance().updateTip();
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
        this.mMainFragment = null;
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

    private boolean isEnableAndroid() {
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = V4ProjectConfigInfoUtil.getInstance().isUseAndroid();
        if (useSoftwareProductBeanIsUseAndroid.isUse) {
            return true;
        }
        SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid.msg);
        return false;
    }

    private void getWhiteState() {
        V3BusinessControllers.getInstance().alarmSwitch2(getLoginAccount(), V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId + ClientDataManager.getInstance().getString(ClientDataManager.LOGIN_ACCOUNT), new Listener<AlarmSwitchBean2>() { // from class: client.android.yixiaotong.v4.ui.V4MainActivity.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AlarmSwitchBean2 alarmSwitchBean2, Object... objArr) {
                super.onComplete(controller, alarmSwitchBean2, objArr);
                LocalDataUtil.saveAlarmSwitch(V4MainActivity.this.getActivity(), alarmSwitchBean2.goWhite);
                LocalDataUtil.saveAlarmPsw(V4MainActivity.this.getActivity(), alarmSwitchBean2.openPassword);
                LogUtil.log("alarmSwitch:" + alarmSwitchBean2.openPassword + PPSLabelView.Code + alarmSwitchBean2.goWhite);
                LogUtil.e("alarmSwitch", "alarmSwitch:" + alarmSwitchBean2);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                super.onFail(controller, clientException);
                LocalDataUtil.saveAlarmSwitch(V4MainActivity.this.getActivity(), false);
                LogUtil.log("alarmSwitch:" + clientException.getDetail());
                LogUtil.e("alarmSwitch", "alarmSwitch:" + clientException.getDetail());
            }
        });
    }
}
