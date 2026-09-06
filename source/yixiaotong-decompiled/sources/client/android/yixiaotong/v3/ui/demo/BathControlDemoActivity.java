package client.android.yixiaotong.v3.ui.demo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.ui.appcontrol.bath.AppointmentBathActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathControlDemoActivity extends BaseActivity {
    private FrameLayout flContainer;
    private ImageView mImgDD;
    private ImageView mImgDDTop;
    private ImageView mImgQB;
    private ImageView mImgQBTop;
    private ImageView mImgYY;
    private ImageView mImgYYTop;
    private int mIndex;
    private ImageView mIvScan;
    private ImageView mIvSpeedOpen;
    private String mMac;
    private String mOpenTime;
    private RelativeLayout mRelAppointment;
    private RelativeLayout mRelMyWallet;
    private RelativeLayout mRelPswOpen;
    private RelativeLayout mRelTopSpeedOpen;
    private TitleBar mTitleBar;
    private TextView mTvAppointmentText;
    private TextView mTvPlanType;
    private int mPlanFlag = 0;
    private boolean mIsEnable = true;
    private int mState = 0;
    private boolean mIsFirst = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity.2
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(BathControlDemoActivity.this.getActivity(), 1, BathControlDemoActivity.this.permissionGrant);
                return;
            }
            if (i != 1) {
                return;
            }
            int i2 = BathControlDemoActivity.this.mIndex;
            if (i2 == 0) {
                BathControlDemoActivity.this.checkIsOpenBluetooth();
            } else {
                if (i2 != 2) {
                    return;
                }
                BathControlDemoActivity.this.checkIsOpenBluetooth();
            }
        }
    };

    static {
        StubApp.interface11(9728);
    }

    private void initData() {
    }

    static /* synthetic */ void lambda$initClickListeners$3(View view) {
    }

    static /* synthetic */ void lambda$initClickListeners$6(View view) {
    }

    private void setListenerView() {
    }

    private void speedOpen() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BathControlDemoActivity.class).putExtra("bean", typeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mIvScan = (ImageView) findViewById(R.id.iv_scan);
        this.mRelTopSpeedOpen = (RelativeLayout) findViewById(R.id.rel_topspeedopen);
        this.mIvSpeedOpen = (ImageView) findViewById(R.id.iv_yhq);
        this.mRelPswOpen = (RelativeLayout) findViewById(R.id.rel_pswopen);
        this.mTvPlanType = (TextView) findViewById(R.id.tv_wdqbtext);
        this.mImgDDTop = (ImageView) findViewById(R.id.iv_wdddtop);
        this.mImgDD = (ImageView) findViewById(R.id.iv_wddd);
        this.mImgQBTop = (ImageView) findViewById(R.id.iv_wdqbtop);
        this.mImgQB = (ImageView) findViewById(R.id.iv_wdqb);
        this.mImgYYTop = (ImageView) findViewById(R.id.iv_appointmenttop);
        this.mImgYY = (ImageView) findViewById(R.id.iv_appointment);
        this.mRelMyWallet = (RelativeLayout) findViewById(R.id.rel_mywallet);
        this.mRelAppointment = (RelativeLayout) findViewById(R.id.rel_appointment);
        this.mTvAppointmentText = (TextView) findViewById(R.id.iv_appointmenttext);
        this.flContainer = (FrameLayout) findViewById(R.id.flContainer);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView("洗澡");
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
        this.mIsEnable = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (this.mIsFirst) {
            LogUtil.e("ABthControlActivity", "onWindowFocusChanged");
            this.mIsFirst = false;
            initView();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m331x24ea6df9(view);
            }
        });
        findViewById(R.id.rel_bluetoothopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m332xb928dd98(view);
            }
        });
        findViewById(R.id.rel_topspeedopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m333x4d674d37(view);
            }
        });
        findViewById(R.id.rel_pswopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BathControlDemoActivity.lambda$initClickListeners$3(view);
            }
        });
        findViewById(R.id.rel_appointment).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m334x75e42c75(view);
            }
        });
        findViewById(R.id.rel_myorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m335xa229c14(view);
            }
        });
        findViewById(R.id.rel_mywallet).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BathControlDemoActivity.lambda$initClickListeners$6(view);
            }
        });
        findViewById(R.id.iv_bathhelp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m336x329f7b52(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-demo-BathControlDemoActivity, reason: not valid java name */
    /* synthetic */ void m331x24ea6df9(View view) {
        ToastUtils.show(getActivity(), "暂无可用设备");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-demo-BathControlDemoActivity, reason: not valid java name */
    /* synthetic */ void m332xb928dd98(View view) {
        ToastUtils.show(getActivity(), "暂无可用设备");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-demo-BathControlDemoActivity, reason: not valid java name */
    /* synthetic */ void m333x4d674d37(View view) {
        ToastUtils.show(getActivity(), "暂无可用设备");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-demo-BathControlDemoActivity, reason: not valid java name */
    /* synthetic */ void m334x75e42c75(View view) {
        int i = this.mState;
        if (i != 0 && i == 2) {
            AppointmentBathActivity.launch(getActivity(), 1, this.mState);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-demo-BathControlDemoActivity, reason: not valid java name */
    /* synthetic */ void m335xa229c14(View view) {
        ToastUtils.show(getActivity(), "暂无可查看的订单");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-v3-ui-demo-BathControlDemoActivity, reason: not valid java name */
    /* synthetic */ void m336x329f7b52(View view) {
        ToastUtils.show(getContext(), "暂未开通！");
    }

    private void initView() {
        LocalDataUtil.getGuideTip(getActivity(), 1);
    }

    private void showDialog(boolean z, boolean z2, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")";
        }
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.demo.BathControlDemoActivity.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BathControlDemoActivity.this.finish();
                }
            }, str);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
        }
    }

    public void checkIsOpenBluetooth() {
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
            return;
        }
        int i = this.mIndex;
        if (i != 0) {
            if (i == 2) {
                speedOpen();
            }
        } else if (AppUtils.isUserHuaWeiScan()) {
            ScanQrcodeActivity.launch(getActivity(), 10);
        } else {
            ZxingScanV3Activity.launch(getActivity(), 10);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            int i3 = this.mIndex;
            if (i3 != 0) {
                if (i3 == 2) {
                    speedOpen();
                }
            } else if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeActivity.launch(getActivity(), 10);
            } else {
                ZxingScanV3Activity.launch(getActivity(), 10);
            }
        }
    }
}
