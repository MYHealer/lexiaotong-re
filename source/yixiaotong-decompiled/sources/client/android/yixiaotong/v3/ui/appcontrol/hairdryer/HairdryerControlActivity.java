package client.android.yixiaotong.v3.ui.appcontrol.hairdryer;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.TimeUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeJsonBean;
import client.android.yixiaotong.v3.bean.login.OperationTimeListBean;
import client.android.yixiaotong.v3.bean.login.TypeInfoBean;
import client.android.yixiaotong.v3.bean.login.UseToolsJsonBean;
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
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
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class HairdryerControlActivity extends BaseActivity {
    private static final String TAG = "HairdryerControlActivity";
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private ImageView mImgDD;
    private ImageView mImgDDTop;
    private ImageView mImgPsw;
    private ImageView mImgPswTop;
    private ImageView mImgQB;
    private ImageView mImgQBTop;
    private InvestorInfoBean mInvestorInfoBean;
    private NativeUtil mNativeUtil;
    private String mOpenTime;
    private OperationTimeJsonBean mOperationTimeJsonBean;
    private RelativeLayout mRelMyWallet;
    private RelativeLayout mRelPswOpen;
    private RelativeLayout mRelWarningError;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvPlanType;
    private TypeInfoBean mTypeInfoBean;
    private UseToolsJsonBean mUseToolsJsonBean;
    private WalletInfoBean mWalletInfoBean;
    private int mPlanFlag = 0;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity.3
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                HairdryerControlActivity.this.checkIsOpenBluetooth();
            } else {
                if (i != 1) {
                    return;
                }
                PermissionUtil.requestPerssion(HairdryerControlActivity.this.getActivity(), 0, HairdryerControlActivity.this.permissionGrant);
            }
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(9360);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) HairdryerControlActivity.class).putExtra("bean", typeInfoBean));
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
        if (StringUtils.isNotEmpty(this.mTypeInfoBean.base.appName)) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBean.base.typeId, this.mTypeInfoBean.base.appName));
        } else {
            this.mTitleBar.setTitleView(getString(R.string.hairdryer));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        showError50XTip();
        getAdv();
        AdvControlUtil.getInstance().onResume();
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
        AdvControlUtil.getInstance().onPause();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onPause();
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
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m277xc7a66117(view);
            }
        });
        findViewById(R.id.rel_pswopen).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m278xcecf4358(view);
            }
        });
        findViewById(R.id.rel_myorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m279xd5f82599(view);
            }
        });
        findViewById(R.id.rel_mywallet).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m280xdd2107da(view);
            }
        });
        findViewById(R.id.iv_drinkwaterhelp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m281xe449ea1b(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-hairdryer-HairdryerControlActivity, reason: not valid java name */
    /* synthetic */ void m277xc7a66117(View view) {
        checkPre(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-hairdryer-HairdryerControlActivity, reason: not valid java name */
    /* synthetic */ void m278xcecf4358(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            checkPre(1);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-hairdryer-HairdryerControlActivity, reason: not valid java name */
    /* synthetic */ void m279xd5f82599(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            ConsumeRecordActivity.launch(getActivity(), this.mTypeInfoBean.base.typeId);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-hairdryer-HairdryerControlActivity, reason: not valid java name */
    /* synthetic */ void m280xdd2107da(View view) {
        if (LocalDataUtil.getAlarmSwitch(getActivity())) {
            ToastUtils.show(getActivity(), getString(R.string.alarmswitch));
        } else {
            getWalletInfo();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-appcontrol-hairdryer-HairdryerControlActivity, reason: not valid java name */
    /* synthetic */ void m281xe449ea1b(View view) {
        ToastUtils.show(getActivity(), getString(R.string.notopen));
    }

    private void initData() {
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
        if (useToolsJsonBean == null || useToolsJsonBean.useMachinePwdFlag != 1) {
            return;
        }
        this.mRelPswOpen.setVisibility(0);
        this.mImgDDTop.setVisibility(0);
        this.mImgDD.setVisibility(8);
        this.mImgQBTop.setVisibility(0);
        this.mImgQB.setVisibility(8);
        this.mImgPswTop.setVisibility(0);
        this.mImgPsw.setVisibility(8);
    }

    private void checkPre(int i) {
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
                    showDialog("暂停服务，开放时间为\n每日" + this.mOpenTime);
                    return;
                }
            }
            isPhoneUse(i);
            return;
        }
        showDialog(getString(R.string.appstop));
    }

    private void isPhoneUse(int i) {
        UseToolsJsonBean useToolsJsonBean = this.mUseToolsJsonBean;
        if (useToolsJsonBean != null && useToolsJsonBean.usePhoneOnMachineFlag == 2 && i == 0) {
            showDialog("本校设备不支持使用，请绑卡使用");
        } else {
            toOpen(i);
        }
    }

    private void toOpen(int i) {
        if (i == 0) {
            PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
        } else {
            if (i != 1) {
                return;
            }
            findPsw();
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
            Log.e("test", i2 + "  " + i3 + "  " + i4 + "  " + i5);
            if (TimeUtils.isCurrentInTimeScope(i2, i3, i4, i5)) {
                return true;
            }
        }
        return false;
    }

    private void showDialog(String str) {
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }

    private void getWalletInfo() {
        int i = this.mPlanFlag;
        if (i == 1) {
            V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(getLoginAccount(), this.mInvestorInfoBean.investorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(HairdryerControlActivity.this.getActivity(), "正在获取钱包信息..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                    if (HairdryerControlActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        HairdryerControlActivity.this.showError50XTip();
                        HairdryerControlActivity.this.mWalletInfoBean = walletInfoBean;
                        WalletDetailActivity.launch(HairdryerControlActivity.this.getActivity(), HairdryerControlActivity.this.mWalletInfoBean);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (HairdryerControlActivity.this.mIsEnable) {
                        HairdryerControlActivity.this.onError(clientException);
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
        V3BusinessControllers.getInstance().getFindMachiniePWD(getLoginAccount(), UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList.get(UserInfoUtil.getInstance().getSchoolInfosIndex()).id + "", new Listener<PswBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(HairdryerControlActivity.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PswBean pswBean, Object... objArr) {
                if (HairdryerControlActivity.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    HairdryerControlActivity.this.showError50XTip();
                    if (pswBean != null) {
                        if (pswBean.statusFlag == 0) {
                            ResetDevicePswActivity.launch(HairdryerControlActivity.this.getActivity(), 0, "");
                        } else if (pswBean.statusFlag == 1) {
                            MachinePSWActivity.launch(HairdryerControlActivity.this.getActivity(), pswBean.password);
                        } else if (pswBean.statusFlag == 2) {
                            ToastUtils.show(HairdryerControlActivity.this.getContext(), "密码已停用");
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (HairdryerControlActivity.this.mIsEnable) {
                    HairdryerControlActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError50XTip() {
        if (Error50XUtil.isInterrupt(getActivity())) {
            this.mRelWarningError.setVisibility(0);
        } else {
            this.mRelWarningError.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        showError50XTip();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail() + "\n(" + LocalDataUtil.getTraceID(getContext()) + ")");
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            getActivity().finish();
        }
    }

    public void checkIsOpenBluetooth() {
        if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeActivity.launch(getActivity(), 6);
                return;
            } else {
                ZxingScanV3Activity.launch(getActivity(), 6);
                return;
            }
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1) {
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeActivity.launch(getActivity(), 6);
            } else {
                ZxingScanV3Activity.launch(getActivity(), 6);
            }
        }
    }

    private void initAdv() {
        this.mNativeUtil = new NativeUtil();
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.hairdryer.HairdryerControlActivity.4
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    HairdryerControlActivity.this.mNativeUtil.initNative(HairdryerControlActivity.this.getActivity(), HairdryerControlActivity.this.mAdvListener, 1);
                    HairdryerControlActivity.this.mNativeUtil.onNative(HairdryerControlActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                HairdryerControlActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 1, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
