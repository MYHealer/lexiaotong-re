package client.android.yixiaotong.v4.ui.app.drink;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.bean.V4HomeInfoBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.order.V4ConsumeRecordActivity;
import client.android.yixiaotong.v4.ui.scan.V4ScanQrcodeActivity;
import client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity;
import client.android.yixiaotong.v4.util.homeinfo.V4HomeInfoUtil;
import client.android.yixiaotong.v4.util.homeinfo.V4TypeIDSetUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4DrinkWaterControlActivity extends BaseActivity {
    private static final String TAG = "V4DrinkWaterControlActivity";
    RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    ImageView mImgDD;
    ImageView mImgDDTop;
    ImageView mImgPsw;
    ImageView mImgPswTop;
    ImageView mImgQB;
    ImageView mImgQBTop;
    private boolean mIsEnable;
    private NativeUtil mNativeUtil;
    RelativeLayout mRelMyWallet;
    RelativeLayout mRelPswOpen;
    RelativeLayout mRelWarningError;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvPlanType;
    private V4HomeInfoBean mV4HomeInfoBean;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity.2
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                V4DrinkWaterControlActivity.this.checkIsOpenBluetooth();
            } else {
                if (i != 1) {
                    return;
                }
                PermissionUtil.requestPerssion(V4DrinkWaterControlActivity.this.getActivity(), 0, V4DrinkWaterControlActivity.this.permissionGrant);
            }
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(10702);
    }

    private void findPsw() {
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, V4HomeInfoBean v4HomeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4DrinkWaterControlActivity.class).putExtra("bean", v4HomeInfoBean));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mRelWarningError = (RelativeLayout) findViewById(R.id.rel_warningerror);
        this.mTvPlanType = (TextView) findViewById(R.id.tv_wdqbtext);
        this.mRelMyWallet = (RelativeLayout) findViewById(R.id.rel_mywallet);
        this.mRelPswOpen = (RelativeLayout) findViewById(R.id.rel_pswopen);
        this.mImgDDTop = (ImageView) findViewById(R.id.iv_wdddtop);
        this.mImgDD = (ImageView) findViewById(R.id.iv_wddd);
        this.mImgQBTop = (ImageView) findViewById(R.id.iv_wdqbtop);
        this.mImgQB = (ImageView) findViewById(R.id.iv_wdqb);
        this.mImgPswTop = (ImageView) findViewById(R.id.iv_pswopentop);
        this.mImgPsw = (ImageView) findViewById(R.id.iv_pswopen);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(V4TypeIDSetUtil.getAppName(getActivity(), this.mV4HomeInfoBean.productId));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m475xba4aaa(view);
            }
        });
        findViewById(R.id.rel_pswopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m476xe3e5fdeb(view);
            }
        });
        findViewById(R.id.rel_myorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m477xc711b12c(view);
            }
        });
        findViewById(R.id.rel_mywallet).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m478xaa3d646d(view);
            }
        });
        findViewById(R.id.iv_drinkwaterhelp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m479x8d6917ae(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$0$client-android-yixiaotong-v4-ui-app-drink-V4DrinkWaterControlActivity, reason: not valid java name */
    /* synthetic */ void m475xba4aaa(View view) {
        checkPre(0);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$1$client-android-yixiaotong-v4-ui-app-drink-V4DrinkWaterControlActivity, reason: not valid java name */
    /* synthetic */ void m476xe3e5fdeb(View view) {
        checkPre(1);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$2$client-android-yixiaotong-v4-ui-app-drink-V4DrinkWaterControlActivity, reason: not valid java name */
    /* synthetic */ void m477xc711b12c(View view) {
        V4ConsumeRecordActivity.launch(getActivity(), this.mV4HomeInfoBean.productId);
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$3$client-android-yixiaotong-v4-ui-app-drink-V4DrinkWaterControlActivity, reason: not valid java name */
    /* synthetic */ void m478xaa3d646d(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4WalletDetailActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initTitleBar$4$client-android-yixiaotong-v4-ui-app-drink-V4DrinkWaterControlActivity, reason: not valid java name */
    /* synthetic */ void m479x8d6917ae(View view) {
        ToastUtils.show(getContext(), getString(R.string.notopen));
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        getAdv();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
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

    private void checkPre(int i) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        isPhoneUse(i);
    }

    private void isPhoneUse(int i) {
        toOpen(i);
    }

    private void toOpen(int i) {
        if (i != 0) {
            if (i != 1) {
                return;
            }
            findPsw();
        } else if (LocalDataUtil.getIsAgreed(getActivity(), 1) && LocalDataUtil.getIsAgreed(getActivity(), 2)) {
            PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity.1
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    LocalDataUtil.savePermissIndex(V4DrinkWaterControlActivity.this.getActivity(), 1);
                    LocalDataUtil.savePermissIndex(V4DrinkWaterControlActivity.this.getActivity(), 2);
                    PermissionUtil.requestPerssion(V4DrinkWaterControlActivity.this.getActivity(), 1, V4DrinkWaterControlActivity.this.permissionGrant);
                }
            }, "需要开启相机和定位/蓝牙权限，用于扫描设备二维码和启用设备的功能");
        }
    }

    private void toLaunch() {
        if (this.mV4HomeInfoBean.productId == 2) {
            V4ScanQrcodeActivity.launch(getActivity(), 5);
            return;
        }
        if (this.mV4HomeInfoBean.productId == 3) {
            V4ScanQrcodeActivity.launch(getActivity(), 6);
        } else if (this.mV4HomeInfoBean.productId == 4) {
            V4ScanQrcodeActivity.launch(getActivity(), 7);
        } else if (this.mV4HomeInfoBean.productId == 11) {
            V4ScanQrcodeActivity.launch(getActivity(), 9);
        }
    }

    private void onError(ClientException clientException) {
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    public void checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            toLaunch();
        } else {
            startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            toLaunch();
        }
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v4.ui.app.drink.V4DrinkWaterControlActivity.3
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
                V4DrinkWaterControlActivity.this.mIsShowAdv = true;
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
