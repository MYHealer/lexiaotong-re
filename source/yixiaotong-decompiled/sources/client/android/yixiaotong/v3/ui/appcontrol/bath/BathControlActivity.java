package client.android.yixiaotong.v3.ui.appcontrol.bath;

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
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.CountTimeUtil;
import client.android.yixiaotong.util.LocationUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.appointment.UsingBean;
import client.android.yixiaotong.v3.bean.deviceinfo.MachineByMacBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeJsonBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeListBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.CloseSuccessActivity;
import client.android.yixiaotong.v3.ui.appcontrol.drinkwater.NBOr4GCloseControlUtil;
import client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener;
import client.android.yixiaotong.v3.ui.device.BluetoothListActivity;
import client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity;
import client.android.yixiaotong.v3.ui.register.MachinePSWActivity;
import client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity;
import client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.constant.x;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.lxt.bluetoothsdk.BluetoothSDK;
import com.lxt.bluetoothsdk.model.BluetoothDevice;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class BathControlActivity extends BaseActivity {
    private static final String TAG = "BathControlActivity";
    RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private CountTimeUtil mCountTimeUtil;
    ImageView mImgDD;
    ImageView mImgDDTop;
    ImageView mImgQB;
    ImageView mImgQBTop;
    ImageView mImgYY;
    ImageView mImgYYTop;
    private int mIndex;
    private InvestorInfoBean mInvestorInfoBean;
    ImageView mIvScan;
    ImageView mIvSpeedOpen;
    private String mMac;
    private NBOr4GCloseControlUtil mNBOr4GCloseControlUtil;
    private NativeUtil mNativeUtil;
    private String mOpenTime;
    private OperationTimeJsonBean mOperationTimeJsonBean;
    RelativeLayout mRelAppointment;
    RelativeLayout mRelClose;
    RelativeLayout mRelMyWallet;
    RelativeLayout mRelPswOpen;
    RelativeLayout mRelTopSpeedOpen;
    RelativeLayout mRelWarningError;
    ScrollView mScrollView;
    TitleBar mTitleBar;
    TextView mTvAdvName;
    TextView mTvAppointmentText;
    TextView mTvPlanType;
    private TypeInfoBean mTypeInfoBean;
    private UseToolsJsonBean mUseToolsJsonBean;
    private WalletInfoBean mWalletInfoBean;
    private int mPlanFlag = 0;
    private boolean mIsEnable = true;
    private int mState = 0;
    private boolean mIsFirst = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.9
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                PermissionUtil.requestPerssion(BathControlActivity.this.getActivity(), 1, BathControlActivity.this.permissionGrant);
                return;
            }
            if (i != 1) {
                return;
            }
            int i2 = BathControlActivity.this.mIndex;
            if (i2 == 0) {
                BathControlActivity.this.checkIsOpenBluetooth();
            } else if (i2 == 1) {
                BluetoothListActivity.launch(BathControlActivity.this.getActivity(), BathControlActivity.this.mTypeInfoBean.base);
            } else {
                if (i2 != 2) {
                    return;
                }
                BathControlActivity.this.checkIsOpenBluetooth();
            }
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(9062);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) BathControlActivity.class).putExtra("bean", typeInfoBean));
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
        this.mRelAppointment = (RelativeLayout) findViewById(R.id.rel_appointment);
        this.mTvAppointmentText = (TextView) findViewById(R.id.iv_appointmenttext);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mScrollView = (ScrollView) findViewById(R.id.scrollview);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        if (StringUtils.isNotEmpty(this.mTypeInfoBean.base.appName)) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBean.base.typeId, this.mTypeInfoBean.base.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.bath));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        BluetoothControlUtil.getInstance().onResume();
        showError50XTip();
        if (!LocalDataUtil.getGuideTip(getActivity(), this.mTypeInfoBean.base.typeId)) {
            getAdv();
            AdvControlUtil.getInstance().onResume();
            NativeUtil nativeUtil = this.mNativeUtil;
            if (nativeUtil != null) {
                nativeUtil.onResume();
            }
        }
        String openSuccessInfo = LocalDataUtil.getOpenSuccessInfo(getActivity(), UserInfoUtil.getInstance().getLoginAccountV3().studentHex);
        LogUtil.e(TAG, "onResume:" + openSuccessInfo + PPSLabelView.Code + (this.mUseToolsJsonBean.useDeviceTimeoutAlert != null) + PPSLabelView.Code + LocalDataUtil.getUseDeviceTimeoutAlert(getActivity()));
        if (StringUtils.isNotEmpty(openSuccessInfo)) {
            this.mRelClose.setVisibility(0);
            if (this.mUseToolsJsonBean.useDeviceTimeoutAlert == null || this.mUseToolsJsonBean.useDeviceTimeoutAlert.intValue() != 0) {
                return;
            }
            final int useDeviceTimeoutAlert = LocalDataUtil.getUseDeviceTimeoutAlert(getActivity());
            long openTime = LocalDataUtil.getOpenTime(getActivity());
            long jCurrentTimeMillis = ((((long) useDeviceTimeoutAlert) * 60000) + openTime) - System.currentTimeMillis();
            LogUtil.e(TAG, "onResume:" + useDeviceTimeoutAlert + PPSLabelView.Code + openTime + PPSLabelView.Code + jCurrentTimeMillis);
            if (useDeviceTimeoutAlert == 0 || openTime == 0) {
                return;
            }
            if (jCurrentTimeMillis > 0) {
                CountTimeUtil countTimeUtil = new CountTimeUtil();
                this.mCountTimeUtil = countTimeUtil;
                countTimeUtil.startCountdown(jCurrentTimeMillis, jCurrentTimeMillis, new CountTimeUtil.OnListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda0
                    @Override // client.android.yixiaotong.util.CountTimeUtil.OnListener
                    public final void onFinish() {
                        this.f$0.m248x5769138e(useDeviceTimeoutAlert);
                    }
                });
                return;
            }
            showDialogUseTime("您的本次用水时长已超过 " + useDeviceTimeoutAlert + " 分钟，请留意是否已关阀");
            return;
        }
        this.mRelClose.setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$onResume$0$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m248x5769138e(int i) {
        showDialogUseTime("您的本次用水时长已超过 " + i + " 分钟，请留意是否已关阀");
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        disconnect();
        BluetoothControlUtil.getInstance().onPause();
        NBOr4GCloseControlUtil nBOr4GCloseControlUtil = this.mNBOr4GCloseControlUtil;
        if (nBOr4GCloseControlUtil != null) {
            nBOr4GCloseControlUtil.onPause();
        }
        BaseMaterialDialog.dissmisMaterialDialog();
        this.mIsEnable = false;
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
        }
        CountTimeUtil countTimeUtil = this.mCountTimeUtil;
        if (countTimeUtil != null) {
            countTimeUtil.stopCountdown();
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
        AdvControlUtil.getInstance().onDestroy(getActivity());
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onDestroy();
        }
        super.onDestroy();
    }

    private void initClickListeners() {
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m239x49a7de6a(view);
            }
        });
        findViewById(R.id.rel_bluetoothopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m240x3af96deb(view);
            }
        });
        findViewById(R.id.rel_topspeedopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m241x2c4afd6c(view);
            }
        });
        findViewById(R.id.rel_pswopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m242x1d9c8ced(view);
            }
        });
        findViewById(R.id.rel_close).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m243xeee1c6e(view);
            }
        });
        findViewById(R.id.rel_appointment).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m244x3fabef(view);
            }
        });
        findViewById(R.id.rel_myorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m245xf1913b70(view);
            }
        });
        findViewById(R.id.rel_mywallet).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m246xe2e2caf1(view);
            }
        });
        findViewById(R.id.iv_bathhelp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m247xd4345a72(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m239x49a7de6a(View view) {
        checkPre(1);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m240x3af96deb(View view) {
        checkPre(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m241x2c4afd6c(View view) {
        checkPre(2);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m242x1d9c8ced(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            checkPre(3);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m243xeee1c6e(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        toCloseDevice();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m244x3fabef(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
            return;
        }
        int i = this.mState;
        if (i == 0) {
            getAppiontmentState();
        } else if (i == 2) {
            AppointmentBathActivity.launch(getActivity(), 1, this.mState);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m245xf1913b70(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            ConsumeRecordActivity.launch(getActivity(), this.mTypeInfoBean.base.typeId);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$8$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m246xe2e2caf1(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            getWalletInfo();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$9$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m247xd4345a72(View view) {
        ToastUtils.show(getContext(), getString(R.string.notopen));
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0077  */
    private void initData() {
        boolean z;
        this.mInvestorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
        int planFlag = InvestorInfoUtilControl.getInstance().getPlanFlag(this.mTypeInfoBean.base.typeId);
        this.mPlanFlag = planFlag;
        if (planFlag == 1) {
            this.mTvPlanType.setText(getString(R.string.mywallet2));
        } else if (planFlag == 2) {
            this.mTvPlanType.setText(getString(R.string.mydeposit));
        } else {
            this.mRelMyWallet.setVisibility(8);
        }
        this.mOperationTimeJsonBean = InvestorInfoUtilControl.getInstance().getOperationTimeJson(this.mTypeInfoBean.base.typeId, this.mPlanFlag);
        UseToolsJsonBean useToolsJsonBean = this.mTypeInfoBean.useToolsJson;
        this.mUseToolsJsonBean = useToolsJsonBean;
        if (useToolsJsonBean != null && useToolsJsonBean.useMachinePwdFlag == 1) {
            this.mRelPswOpen.setVisibility(0);
        }
        UseToolsJsonBean useToolsJsonBean2 = this.mUseToolsJsonBean;
        if (useToolsJsonBean2 == null || useToolsJsonBean2.booking == null) {
            z = false;
        } else {
            int i = this.mUseToolsJsonBean.booking.state;
            this.mState = i;
            if (i == 0) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            this.mRelAppointment.setVisibility(0);
        }
        if (this.mState == 2) {
            this.mRelAppointment.setVisibility(0);
            this.mTvAppointmentText.setText("水控状态");
        }
        int i2 = this.mPlanFlag;
        if ((i2 == 1 || i2 == 2) && (z || this.mState == 2)) {
            this.mImgDD.setVisibility(8);
            this.mImgDDTop.setVisibility(0);
            this.mImgQB.setVisibility(8);
            this.mImgQBTop.setVisibility(0);
            this.mImgYY.setVisibility(8);
            this.mImgYYTop.setVisibility(0);
            return;
        }
        this.mImgDD.setVisibility(0);
        this.mImgDDTop.setVisibility(8);
        this.mImgQB.setVisibility(0);
        this.mImgQBTop.setVisibility(8);
        this.mImgYY.setVisibility(0);
        this.mImgYYTop.setVisibility(8);
    }

    private void initView() {
        if (LocalDataUtil.getGuideTip(getActivity(), this.mTypeInfoBean.base.typeId)) {
            toGuide();
        }
    }

    private void toGuide() {
        LogUtil.e(TAG, this.mRelTopSpeedOpen.getHeight() + "  " + this.mRelTopSpeedOpen.getWidth() + "  " + this.mIvSpeedOpen.getHeight() + "  " + this.mIvSpeedOpen.getWidth());
        ArrayList arrayList = new ArrayList();
        RectF viewLocation = LocationUtils.getViewLocation(this.mRelTopSpeedOpen);
        LocationUtils.expandRectF(viewLocation, 0);
        UseToolsJsonBean useToolsJsonBean = this.mUseToolsJsonBean;
        if (useToolsJsonBean != null && useToolsJsonBean.useMachinePwdFlag == 1) {
            arrayList.add(new CircleRegion(viewLocation, this.mRelTopSpeedOpen.getWidth() / 2));
            BathGuideActivity.launch(getActivity(), arrayList, this.mTypeInfoBean.base.typeId, 1);
        } else {
            arrayList.add(new CircleRegion(viewLocation, this.mRelTopSpeedOpen.getWidth() / 3));
            BathGuideActivity.launch(getActivity(), arrayList, this.mTypeInfoBean.base.typeId, 2);
        }
    }

    private void checkPre(int i) {
        this.mIndex = i;
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mTypeInfoBean.base.statusFlag == 1) {
            OperationTimeJsonBean operationTimeJsonBean = this.mOperationTimeJsonBean;
            if (operationTimeJsonBean != null && operationTimeJsonBean.operationFlag == 2) {
                if (isOpenTime()) {
                    isPhoneUse(i);
                    return;
                } else {
                    showDialog(false, false, "暂停服务，开放时间为\n每日" + this.mOpenTime);
                    return;
                }
            }
            isPhoneUse(i);
            return;
        }
        showDialog(false, false, getString(R.string.appstop));
    }

    private void isPhoneUse(int i) {
        UseToolsJsonBean useToolsJsonBean = this.mUseToolsJsonBean;
        if (useToolsJsonBean != null && useToolsJsonBean.usePhoneOnMachineFlag == 2 && i != 3) {
            showDialog(false, false, "本校设备不支持使用，请绑卡使用");
        } else {
            toOpen(i);
        }
    }

    private void toOpen(int i) {
        if (i == 0) {
            if (LocalDataUtil.getIsAgreed(getActivity(), 1) && LocalDataUtil.getIsAgreed(getActivity(), 2)) {
                PermissionUtil.requestPerssion(getActivity(), 0, this.permissionGrant);
                return;
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        LocalDataUtil.savePermissIndex(BathControlActivity.this.getActivity(), 1);
                        LocalDataUtil.savePermissIndex(BathControlActivity.this.getActivity(), 2);
                        PermissionUtil.requestPerssion(BathControlActivity.this.getActivity(), 0, BathControlActivity.this.permissionGrant);
                    }
                }, "需要开启相机和定位/蓝牙权限，用于扫描设备二维码和启用设备的功能");
                return;
            }
        }
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            findPsw();
        } else if (LocalDataUtil.getIsAgreed(getActivity(), 2)) {
            PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    LocalDataUtil.savePermissIndex(BathControlActivity.this.getActivity(), 2);
                    PermissionUtil.requestPerssion(BathControlActivity.this.getActivity(), 1, BathControlActivity.this.permissionGrant);
                }
            }, "需要开启相机和定位/蓝牙权限，用于扫描附近设备和启用设备的功能");
        }
    }

    private boolean isOpenTime() {
        this.mOpenTime = "";
        List<OperationTimeListBean> list = this.mOperationTimeJsonBean.operationTimeList;
        if (list == null || list.size() <= 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            this.mOpenTime += list.get(i).startTime + "至" + list.get(i).stopTime + "时\n";
            int i2 = Integer.parseInt(list.get(i).startTime.split(x.bQ)[0]);
            int i3 = Integer.parseInt(list.get(i).startTime.split(x.bQ)[1]);
            int i4 = Integer.parseInt(list.get(i).stopTime.split(x.bQ)[0]);
            int i5 = Integer.parseInt(list.get(i).stopTime.split(x.bQ)[1]);
            LogUtil.e(TAG, i2 + "  " + i3 + "  " + i4 + "  " + i5);
            if (TimeUtils.isCurrentInTimeScope(i2, i3, i4, i5)) {
                return true;
            }
        }
        return false;
    }

    private void getWalletInfo() {
        int i = this.mPlanFlag;
        if (i == 1) {
            V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(getLoginAccount(), this.mInvestorInfoBean.investorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.3
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(BathControlActivity.this.getActivity(), "正在获取钱包信息..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                    if (BathControlActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        BathControlActivity.this.showError50XTip();
                        BathControlActivity.this.mWalletInfoBean = walletInfoBean;
                        WalletDetailActivity.launch(BathControlActivity.this.getActivity(), BathControlActivity.this.mWalletInfoBean);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (BathControlActivity.this.mIsEnable) {
                        BathControlActivity.this.onError(clientException);
                    }
                }
            });
        } else if (i == 2) {
            DepositionDetailActivity.launch(getActivity());
        } else {
            ToastUtils.show(getContext(), "不支持此方案" + this.mPlanFlag);
        }
    }

    private void findPsw() {
        V3BusinessControllers.getInstance().getFindMachiniePWD(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", new Listener<PswBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(BathControlActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PswBean pswBean, Object... objArr) {
                if (BathControlActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BathControlActivity.this.showError50XTip();
                    if (pswBean != null) {
                        if (pswBean.statusFlag == 0) {
                            ResetDevicePswActivity.launch(BathControlActivity.this.getActivity(), 0, "");
                        } else if (pswBean.statusFlag == 1) {
                            MachinePSWActivity.launch(BathControlActivity.this.getActivity(), pswBean.password);
                        } else if (pswBean.statusFlag == 2) {
                            ToastUtils.show(BathControlActivity.this.getContext(), "密码已停用");
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathControlActivity.this.mIsEnable) {
                    BathControlActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getAppiontmentState() {
        V3BusinessControllers.getInstance().getUsingList(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), InvestorInfoUtilControl.getInstance().getInvestorInfoBean().investorId, this.mTypeInfoBean.base.typeId, new Listener<List<UsingBean>>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(BathControlActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, List<UsingBean> list, Object... objArr) {
                if (BathControlActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BathControlActivity.this.showError50XTip();
                    if (list == null || list.size() <= 0) {
                        AppointmentBathActivity.launch(BathControlActivity.this.getActivity(), BathControlActivity.this.mTypeInfoBean.base.typeId, BathControlActivity.this.mState);
                    } else if (list.get(0).curStatus == 121) {
                        AppointBathSuccessActivity.launch(BathControlActivity.this.getActivity(), list.get(0), BathControlActivity.this.mTypeInfoBean.base.typeId);
                    } else {
                        AppointmentBathActivity.launch(BathControlActivity.this.getActivity(), BathControlActivity.this.mTypeInfoBean.base.typeId, BathControlActivity.this.mState);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathControlActivity.this.mIsEnable) {
                    BathControlActivity.this.onError(clientException);
                }
            }
        });
    }

    private void getDeviceInfo(final String str) {
        V3BusinessControllers.getInstance().getMachineByMac(getLoginAccount(), str, 1, new Listener<MachineByMacBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.6
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(BathControlActivity.this.getActivity(), "加载地址中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, MachineByMacBean machineByMacBean, Object... objArr) {
                if (BathControlActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BathControlActivity.this.showError50XTip();
                    if (machineByMacBean == null || !StringUtils.isNotEmpty(machineByMacBean.roominfo)) {
                        BathControlActivity bathControlActivity = BathControlActivity.this;
                        bathControlActivity.showSpeedDialog("", bathControlActivity.mMac);
                    } else {
                        LocalDataUtil.saveBathMacInfo(BathControlActivity.this.getContext(), str + "," + machineByMacBean.roominfo);
                        BathControlActivity.this.showSpeedDialog(machineByMacBean.roominfo, BathControlActivity.this.mMac);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (BathControlActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    BathControlActivity bathControlActivity = BathControlActivity.this;
                    bathControlActivity.showSpeedDialog("", bathControlActivity.mMac);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError50XTip() {
        if (Error50XUtil.isInterrupt(getActivity()) && !LocalDataUtil.getIsEnableOffline(getActivity())) {
            this.mRelWarningError.setVisibility(0);
        } else {
            this.mRelWarningError.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        showError50XTip();
        if (LocalDataUtil.getIsEnableOffline(getActivity())) {
            return;
        }
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private void showDialog(boolean z, boolean z2, String str) {
        if (z2) {
            str = str + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")";
        }
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.7
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    BathControlActivity.this.finish();
                }
            }, str);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
        }
    }

    private void showDialogUseTime(String str) {
        SystemErrorTip.getInstance().showTipDialog(getActivity(), "提示", str, "我知道了", false, new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity$$ExternalSyntheticLambda1
            @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
            public final void onConfirm() {
                this.f$0.m249xf8ea812a();
            }
        });
    }

    /* JADX INFO: renamed from: lambda$showDialogUseTime$10$client-android-yixiaotong-v3-ui-appcontrol-bath-BathControlActivity, reason: not valid java name */
    /* synthetic */ void m249xf8ea812a() {
        LocalDataUtil.saveOpenTime(getActivity(), 0L);
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

    private void speedOpen() {
        String str;
        String bathMacInfo = LocalDataUtil.getBathMacInfo(getContext());
        if (StringUtils.isNotEmpty(bathMacInfo)) {
            this.mMac = bathMacInfo;
            if (bathMacInfo.contains(",")) {
                this.mMac = bathMacInfo.split(",")[0];
                str = bathMacInfo.split(",")[1];
            } else {
                str = "";
            }
            if (StringUtils.isNotEmpty(str)) {
                showSpeedDialog(str, this.mMac);
                return;
            } else {
                getDeviceInfo(this.mMac);
                return;
            }
        }
        if (AppUtils.isUserHuaWeiScan()) {
            ScanQrcodeActivity.launch(getActivity(), 10);
        } else {
            ZxingScanV3Activity.launch(getActivity(), 10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showSpeedDialog(String str, String str2) {
        BathFirstTipDialog.getInstance().showDialog(getActivity(), new BathFirstTipDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.8
            @Override // client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.BathFirstTipDialog.Listener
            public void onConfirm() {
                BathDetailActivity.launch(BathControlActivity.this.getActivity(), new BluetoothDevice("test", BathControlActivity.this.mMac, 0).address, true);
            }
        }, str, str2);
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

    private void onClose() {
        BaseMaterialDialog.showMaterialDialog(getActivity(), "正在关阀中.", false);
        this.mNBOr4GCloseControlUtil.closeStart();
    }

    private void toCloseDevice() {
        final String str = UserInfoUtil.getInstance().getLoginAccountV3().studentHex;
        String openSuccessInfo = LocalDataUtil.getOpenSuccessInfo(getActivity(), str);
        LogUtil.e(TAG, "toCloseDevice:" + openSuccessInfo);
        if (StringUtils.isNotEmpty(openSuccessInfo)) {
            String[] strArrSplit = openSuccessInfo.split(",");
            if (strArrSplit.length >= 6) {
                Integer.parseInt(strArrSplit[0]);
                this.mMac = strArrSplit[1];
                String str2 = this.mMac;
                BluetoothDevice bluetoothDevice = new BluetoothDevice(str2, str2, 0);
                int i = Integer.parseInt(strArrSplit[2]);
                String str3 = strArrSplit[3] + "," + strArrSplit[4];
                String str4 = strArrSplit[5];
                NBOr4GCloseControlUtil nBOr4GCloseControlUtil = new NBOr4GCloseControlUtil();
                this.mNBOr4GCloseControlUtil = nBOr4GCloseControlUtil;
                nBOr4GCloseControlUtil.onResume();
                this.mNBOr4GCloseControlUtil.init(getActivity(), getLoginAccount(), bluetoothDevice, this.mTypeInfoBean.base, 1, str, this.mTitleBar.getTitleViewContent());
                this.mNBOr4GCloseControlUtil.setListener(new CloseControlListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.10
                    @Override // client.android.yixiaotong.v3.ui.appcontrol.listener.CloseControlListener
                    public void onCloseEnd() {
                        LocalDataUtil.saveOpenSuccessInfo(BathControlActivity.this.getActivity(), str, "");
                        CloseSuccessActivity.launchForClose(BathControlActivity.this.getActivity(), 1, true);
                    }
                });
                this.mNBOr4GCloseControlUtil.setDeviceInfo(i, str3, str4);
                this.mNBOr4GCloseControlUtil.setCloseDevice();
                initBluetooth();
                onClose();
            }
        }
    }

    public void initBluetooth() {
        BluetoothSDK.getInstance().init(getContext());
        BluetoothControlUtil.getInstance().init(getActivity());
        BluetoothControlUtil.getInstance().setListener(new BluetoothControlUtil.Listener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.11
            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onConnected() {
                super.onConnected();
                LogUtil.d(BathControlActivity.TAG, "onConnected:");
                BathControlActivity.this.mNBOr4GCloseControlUtil.connected();
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onFail(int i, String str) {
                super.onFail(i, str);
                LogUtil.d(BathControlActivity.TAG, "onFail" + i + "  " + str);
                if (str.equalsIgnoreCase("Discover") || str.equalsIgnoreCase("Connect")) {
                    str = "尝试重启手机或设备蓝牙再试";
                }
                BathControlActivity.this.onError(i, str);
            }

            @Override // client.android.yixiaotong.v3.bluetoothutil.BluetoothControlUtil.Listener
            public void onReceivedData(String str) {
                super.onReceivedData(str);
                LogUtil.d(BathControlActivity.TAG, "onReceivedData:" + str);
                BathControlActivity.this.mNBOr4GCloseControlUtil.onReceivedData(str);
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
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.bath.BathControlActivity.12
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    BathControlActivity.this.mNativeUtil.initNative(BathControlActivity.this.getActivity(), BathControlActivity.this.mAdvListener, 1);
                    BathControlActivity.this.mNativeUtil.onNative(BathControlActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                BathControlActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
