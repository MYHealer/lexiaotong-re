package client.android.yixiaotong.v4.ui.app.bath;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.bean.region.CircleRegion;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.LocationUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.appcontrol.bath.BathGuideActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.CloseSuccessActivity;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.ui.device.V4BluetoothListActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity;
import client.android.yixiaotong.v4.ui.scan.V4ScanQrcodeActivity;
import client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4BathControlActivity extends BaseActivity {
    private static final String TAG = "BathControlActivity";
    RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    ImageView mImgDD;
    ImageView mImgDDTop;
    ImageView mImgQB;
    ImageView mImgQBTop;
    ImageView mImgYY;
    ImageView mImgYYTop;
    private int mIndex;
    ImageView mIvScan;
    ImageView mIvSpeedOpen;
    private String mMac;
    private V4NBOr4GCloseControlUtil mNBOr4GCloseControlUtil;
    private NativeUtil mNativeUtil;
    RelativeLayout mRelClose;
    RelativeLayout mRelMyWallet;
    RelativeLayout mRelPswOpen;
    RelativeLayout mRelTopSpeedOpen;
    RelativeLayout mRelWarningError;
    ScrollView mScrollView;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvPlanType;
    private boolean mIsEnable = true;
    private boolean mIsFirst = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity.4
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(V4BathControlActivity.this.getActivity(), 1, V4BathControlActivity.this.permissionGrant);
                return;
            }
            if (i != 1) {
                return;
            }
            int i2 = V4BathControlActivity.this.mIndex;
            if (i2 == 0) {
                V4BathControlActivity.this.checkIsOpenBluetooth();
            } else if (i2 == 1) {
                V4BluetoothListActivity.launch(V4BathControlActivity.this.getActivity(), null);
            } else {
                if (i2 != 2) {
                    return;
                }
                V4BathControlActivity.this.checkIsOpenBluetooth();
            }
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(10657);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, V4HomeInfoBean v4HomeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4BathControlActivity.class).putExtra("bean", v4HomeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelWarningError = (RelativeLayout) findViewById(R.id.rel_warningerror);
        this.mIvScan = (ImageView) findViewById(R.id.iv_scan);
        this.mRelTopSpeedOpen = (RelativeLayout) findViewById(R.id.rel_topspeedopen);
        this.mIvSpeedOpen = (ImageView) findViewById(R.id.iv_yhq);
        this.mRelPswOpen = (RelativeLayout) findViewById(R.id.rel_pswopen);
        this.mRelClose = (RelativeLayout) findViewById(R.id.rel_close);
        this.mTvPlanType = (TextView) findViewById(R.id.tv_wdqbtext);
        this.mImgDDTop = (ImageView) findViewById(R.id.iv_wdddtop);
        this.mImgDD = (ImageView) findViewById(R.id.iv_wddd);
        this.mImgQBTop = (ImageView) findViewById(R.id.iv_wdqbtop);
        this.mImgQB = (ImageView) findViewById(R.id.iv_wdqb);
        this.mImgYYTop = (ImageView) findViewById(R.id.iv_appointmenttop);
        this.mImgYY = (ImageView) findViewById(R.id.iv_appointment);
        this.mRelMyWallet = (RelativeLayout) findViewById(R.id.rel_mywallet);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getString(R.string.bath));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m467x23cb611(view);
            }
        });
        findViewById(R.id.rel_bluetoothopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m468x809db9f0(view);
            }
        });
        findViewById(R.id.rel_topspeedopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m469xfefebdcf(view);
            }
        });
        findViewById(R.id.rel_pswopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m470x7d5fc1ae(view);
            }
        });
        findViewById(R.id.rel_close).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClickUtil.isFastDoubleClick();
            }
        });
        findViewById(R.id.rel_myorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m471x7a21c96c(view);
            }
        });
        findViewById(R.id.rel_mywallet).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m472xf882cd4b(view);
            }
        });
        findViewById(R.id.iv_bathhelp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m473x76e3d12a(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$client-android-yixiaotong-v4-ui-app-bath-V4BathControlActivity, reason: not valid java name */
    /* synthetic */ void m467x23cb611(View view) {
        checkPre(1);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$1$client-android-yixiaotong-v4-ui-app-bath-V4BathControlActivity, reason: not valid java name */
    /* synthetic */ void m468x809db9f0(View view) {
        checkPre(0);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$2$client-android-yixiaotong-v4-ui-app-bath-V4BathControlActivity, reason: not valid java name */
    /* synthetic */ void m469xfefebdcf(View view) {
        checkPre(2);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$3$client-android-yixiaotong-v4-ui-app-bath-V4BathControlActivity, reason: not valid java name */
    /* synthetic */ void m470x7d5fc1ae(View view) {
        checkPre(3);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$5$client-android-yixiaotong-v4-ui-app-bath-V4BathControlActivity, reason: not valid java name */
    /* synthetic */ void m471x7a21c96c(View view) {
        V4ConsumeRecordActivity.launch(getActivity(), 1);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$6$client-android-yixiaotong-v4-ui-app-bath-V4BathControlActivity, reason: not valid java name */
    /* synthetic */ void m472xf882cd4b(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4WalletDetailActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$7$client-android-yixiaotong-v4-ui-app-bath-V4BathControlActivity, reason: not valid java name */
    /* synthetic */ void m473x76e3d12a(View view) {
        ToastUtils.show(getContext(), getString(R.string.notopen));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        BluetoothControlUtil.getInstance().onResume();
        if (V4LocalDataUtil.getGuideTip(getActivity(), 1)) {
            return;
        }
        getAdv();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        disconnect();
        V4ErrorControlUtil.getInstance().onPause();
        BluetoothControlUtil.getInstance().onPause();
        V4NBOr4GCloseControlUtil v4NBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (v4NBOr4GCloseControlUtil != null) {
            v4NBOr4GCloseControlUtil.onPause();
        }
        BaseMaterialDialog.dissmisMaterialDialog();
        this.mIsEnable = false;
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
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
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initView() {
        if (V4LocalDataUtil.getGuideTip(getActivity(), 1)) {
            toGuide();
        }
    }

    private void toGuide() {
        LogUtil.e(TAG, this.mRelTopSpeedOpen.getHeight() + "  " + this.mRelTopSpeedOpen.getWidth() + "  " + this.mIvSpeedOpen.getHeight() + "  " + this.mIvSpeedOpen.getWidth());
        ArrayList arrayList = new ArrayList();
        RectF viewLocation = LocationUtils.getViewLocation(this.mRelTopSpeedOpen);
        LocationUtils.expandRectF(viewLocation, 0);
        arrayList.add(new CircleRegion(viewLocation, this.mRelTopSpeedOpen.getWidth() / 3));
        BathGuideActivity.launch(getActivity(), arrayList, 1, 2);
    }

    private void checkPre(int i) {
        this.mIndex = i;
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        toOpen(i);
    }

    private void toOpen(int i) {
        if (i == 0) {
            if (LocalDataUtil.getIsAgreed(getActivity(), 1) && LocalDataUtil.getIsAgreed(getActivity(), 2)) {
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        LocalDataUtil.savePermissIndex(V4BathControlActivity.this.getActivity(), 1);
                        LocalDataUtil.savePermissIndex(V4BathControlActivity.this.getActivity(), 2);
                        PermissionUtil.requestPerssion(V4BathControlActivity.this.getActivity(), 0, V4BathControlActivity.this.permissionGrant);
                    }
                }, "需要开启相机和定位/蓝牙权限，用于扫描设备二维码和启用设备的功能");
                return;
            }
        }
        if (i == 1 || i == 2) {
            if (LocalDataUtil.getIsAgreed(getActivity(), 2)) {
                PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity.2
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        LocalDataUtil.savePermissIndex(V4BathControlActivity.this.getActivity(), 2);
                        PermissionUtil.requestPerssion(V4BathControlActivity.this.getActivity(), 1, V4BathControlActivity.this.permissionGrant);
                    }
                }, "需要开启相机和定位/蓝牙权限，用于扫描附近设备和启用设备的功能");
            }
        }
    }

    public void checkIsOpenBluetooth() {
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
            return;
        }
        int i = this.mIndex;
        if (i == 0) {
            V4ScanQrcodeActivity.launch(getActivity(), 10);
        } else if (i == 2) {
            speedOpen();
        }
    }

    private void speedOpen() {
        String bathMacInfo = V4LocalDataUtil.getBathMacInfo(getContext());
        if (StringUtils.isNotEmpty(bathMacInfo)) {
            this.mMac = bathMacInfo;
            String[] strArrSplit = bathMacInfo.contains(",") ? bathMacInfo.split(",") : null;
            if (strArrSplit != null && strArrSplit.length >= 2) {
                this.mMac = bathMacInfo.split(",")[0];
                showSpeedDialog(strArrSplit.length >= 3 ? bathMacInfo.split(",")[2] : "", this.mMac, bathMacInfo.split(",")[1]);
                return;
            }
            V4ScanQrcodeActivity.launch(getActivity(), 10);
            return;
        }
        V4ScanQrcodeActivity.launch(getActivity(), 10);
    }

    private void showSpeedDialog(String str, String str2, final String str3) {
        BathFirstTipDialog.getInstance().showDialog(getActivity(), new BathFirstTipDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity.3
            @Override // client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog.Listener
            public void onConfirm() {
                V4BathDetailActivity.launch(V4BathControlActivity.this.getActivity(), new BluetoothDevice("test", V4BathControlActivity.this.mMac, 0).address, str3, 1, "", false);
            }
        }, str, str2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            int i3 = this.mIndex;
            if (i3 == 0) {
                V4ScanQrcodeActivity.launch(getActivity(), 10);
            } else if (i3 == 2) {
                speedOpen();
            }
        }
    }

    private void onClose() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在关阀中.", false);
        this.mNBOr4GCloseControlUtil.closeStart();
    }

    private void toCloseDevice() {
        final String str = V4UserInfoUtil.getInstance().getLoginAccountV4().hexUserId;
        String openSuccessInfo = V4LocalDataUtil.getOpenSuccessInfo(getActivity(), str);
        LogUtil.e(TAG, "toCloseDevice:" + openSuccessInfo);
        if (StringUtils.isNotEmpty(openSuccessInfo)) {
            String[] strArrSplit = openSuccessInfo.split(",");
            if (strArrSplit.length >= 6) {
                Integer.parseInt(strArrSplit[0]);
                this.mMac = strArrSplit[1];
                String str2 = this.mMac;
                new BluetoothDevice(str2, str2, 0);
                Integer.parseInt(strArrSplit[2]);
                String str3 = strArrSplit[3] + "," + strArrSplit[4];
                String str4 = strArrSplit[5];
                V4NBOr4GCloseControlUtil v4NBOr4GCloseControlUtil = new V4NBOr4GCloseControlUtil();
                this.mNBOr4GCloseControlUtil = v4NBOr4GCloseControlUtil;
                v4NBOr4GCloseControlUtil.onResume();
                this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity.5
                    @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
                    public void onCloseEnd() {
                        V4LocalDataUtil.saveOpenSuccessInfo(V4BathControlActivity.this.getActivity(), str, "");
                        CloseSuccessActivity.launchForClose(V4BathControlActivity.this.getActivity(), 1, true);
                    }
                });
                this.mNBOr4GCloseControlUtil.setDeviceInfo(str4);
                this.mNBOr4GCloseControlUtil.setCloseDevice();
                initBluetooth();
                onClose();
            }
        }
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(getContext());
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity.6
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.d(V4BathControlActivity.TAG, "onConnected:");
                V4BathControlActivity.this.mNBOr4GCloseControlUtil.connected();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.d(V4BathControlActivity.TAG, "onFail" + i + "  " + str);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                V4BathControlActivity.this.onError(i, str);
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.d(V4BathControlActivity.TAG, "onReceivedData:" + str);
                V4BathControlActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
            }
        });
    }

    private void disconnect() {
        BluetoothControlUtil.getInstance().disconnect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(int i, String str) {
        BaseMaterialDialog.dissmisMaterialDialog();
        V3ErrorTipActivity.launchBluetoothFail(getActivity(), this.mTitleBar.getTitleViewContent(), str, i);
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.app.bath.V4BathControlActivity.7
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                V4BathControlActivity.this.mIsShowAdv = true;
            }
        };
        boolean zIsOpenAdv = V4HomeInfoUtil.getInstance().isOpenAdv();
        LogUtil.e(TAG, "广告是否开启：" + zIsOpenAdv);
        if (zIsOpenAdv) {
            this.mNativeUtil.initNative(getActivity(), this.mAdvListener, 1);
            this.mNativeUtil.onNative(this.flContainer);
        }
    }
}
