package client.android.yixiaotong.v3.ui.demo;

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
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.android.NetworkUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.ui.MainListener;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3MainDemoActivity extends BaseActivity {
    private static final String TAG = "V3MainDemoActivity";
    private V3ApplicationDemoFragment mApplicationFragment;
    private FrameLayout mMainLayoutTab1;
    private FrameLayout mMainLayoutTab2;
    private FrameLayout mMainLayoutTab3;
    private FrameLayout mMainLayoutTab4;
    private ViewFlipper mMainSwitcher;
    private V3MeDemoFragment mMeFragment;
    private V3OrderDemoFragment mOrderFragment;
    private RadioButton mRBtnAccount;
    private RadioButton mRBtnDevice;
    private RadioButton mRBtnMe;
    private RadioButton mRBtnMessage;
    private V3ServerDemoFragment mServerFragment;
    private UIVisableBean mUIVisableBean;
    private int mSelectIndex = 1;
    private MainListener mMainListener = new MainListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MainDemoActivity.1
        @Override // client.android.yixiaotong.v3.ui.MainListener
        public void onApplication(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(V3MainDemoActivity.this.getActivity(), 0, V3MainDemoActivity.this.permissionGrant);
            }
        }
    };
    private long mLastExitTime = 0;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.demo.V3MainDemoActivity.2
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            LogUtil.e(V3MainDemoActivity.TAG, "onPermissionGranted:" + i);
            if (i == 0) {
                PermissionUtil.requestPerssion(V3MainDemoActivity.this.getActivity(), 1, V3MainDemoActivity.this.permissionGrant);
                return;
            }
            if (i != 1) {
                return;
            }
            if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                if (AppUtils.isUserHuaWeiScan()) {
                    ScanQrcodeActivity.launch1(V3MainDemoActivity.this.getActivity(), 11);
                    return;
                } else {
                    ZxingScanV3Activity.launch(V3MainDemoActivity.this.getActivity(), 11);
                    return;
                }
            }
            V3MainDemoActivity.this.startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        }
    };

    static {
        StubApp.interface11(9743);
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
        intent.setClass(activity, V3MainDemoActivity.class);
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
        findViewById(R.id.rbtn_account).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MainDemoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m340x150390b(view);
            }
        });
        findViewById(R.id.rbtn_service).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MainDemoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m341x26e4420c(view);
            }
        });
        findViewById(R.id.rbtn_order).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MainDemoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m342x4c784b0d(view);
            }
        });
        findViewById(R.id.rbtn_me).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MainDemoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m343x720c540e(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-demo-V3MainDemoActivity, reason: not valid java name */
    /* synthetic */ void m340x150390b(View view) {
        this.mSelectIndex = 1;
        chooseRadioBtn(view);
        showAccountFragment();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-demo-V3MainDemoActivity, reason: not valid java name */
    /* synthetic */ void m341x26e4420c(View view) {
        this.mSelectIndex = 2;
        chooseRadioBtn(view);
        showServerFragment();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-demo-V3MainDemoActivity, reason: not valid java name */
    /* synthetic */ void m342x4c784b0d(View view) {
        this.mSelectIndex = 3;
        chooseRadioBtn(view);
        showOrderFragment();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-demo-V3MainDemoActivity, reason: not valid java name */
    /* synthetic */ void m343x720c540e(View view) {
        this.mSelectIndex = 4;
        chooseRadioBtn(view);
        showMeFragment();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
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
                this.mApplicationFragment = V3ApplicationDemoFragment.newInstance();
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
                this.mServerFragment = V3ServerDemoFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab2, this.mServerFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(1);
        }
    }

    private void showOrderFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 2 || this.mMeFragment == null) {
            if (this.mOrderFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab3)).removeAllViews();
                this.mOrderFragment = V3OrderDemoFragment.newInstance();
                getFragmentManager().beginTransaction().replace(R.id.main_layout_tab3, this.mOrderFragment).commit();
            }
            this.mMainSwitcher.setDisplayedChild(2);
        }
    }

    private void showMeFragment() {
        if (this.mMainSwitcher.getDisplayedChild() != 3 || this.mMeFragment == null) {
            if (this.mMeFragment == null) {
                ((FrameLayout) findViewById(R.id.main_layout_tab4)).removeAllViews();
                this.mMeFragment = V3MeDemoFragment.newInstance();
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
    protected void onDestroy() {
        super.onDestroy();
        BaseMaterialDialog.dissmisMaterialDialog();
        this.mApplicationFragment = null;
        this.mMainLayoutTab1.removeAllViews();
        this.mMainLayoutTab2.removeAllViews();
        this.mMainLayoutTab3.removeAllViews();
        this.mMainLayoutTab4.removeAllViews();
        EventBus.getDefault().unregister(this);
    }
}
