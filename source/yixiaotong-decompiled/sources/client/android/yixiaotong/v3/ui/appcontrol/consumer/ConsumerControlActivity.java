package client.android.yixiaotong.v3.ui.appcontrol.consumer;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.adv.AdvControlUtil;
import client.android.yixiaotong.v3.ui.adv.Common;
import client.android.yixiaotong.v3.ui.adv.NativeUtil;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.order.ConsumeRecordActivity;
import client.android.yixiaotong.v3.ui.scan.ScanQrcodeActivity;
import client.android.yixiaotong.v3.ui.scan.ZxingScanV3Activity;
import client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity;
import client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LanguageUtils;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.huawei.openalliance.ad.constant.x;
import com.stub.StubApp;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class ConsumerControlActivity extends BaseActivity {
    private static final String TAG = "ConsumerControlActivity";
    private RelativeLayout flContainer;
    private AdvControlUtil.AdvListener mAdvListener;
    private ConsumerControlUtil mConsumerControlUtil;
    private InvestorInfoBean mInvestorInfoBean;
    private NativeUtil mNativeUtil;
    private String mOpenTime;
    private OperationTimeJsonBean mOperationTimeJsonBean;
    private String mQrcode;
    private RelativeLayout mRelMyWallet;
    private TitleBar mTitleBar;
    private TextView mTvAdvName;
    private TextView mTvPlanType;
    private TypeInfoBean mTypeInfoBean;
    private WalletInfoBean mWalletInfoBean;
    private int mPlanFlag = 0;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity.2
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i == 0) {
                ConsumerControlActivity.this.checkIsOpenBluetooth();
            } else {
                if (i != 1) {
                    return;
                }
                PermissionUtil.requestPerssion(ConsumerControlActivity.this.getActivity(), 0, ConsumerControlActivity.this.permissionGrant);
            }
        }
    };
    private boolean mIsShowAdv = false;

    static {
        StubApp.interface11(9109);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public native void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public static void launch(Activity activity, TypeInfoBean typeInfoBean) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ConsumerControlActivity.class).putExtra("bean", typeInfoBean));
        }
    }

    public static void launch(Activity activity, TypeInfoBean typeInfoBean, String str) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) ConsumerControlActivity.class).putExtra("bean", typeInfoBean).putExtra("qrcode", str));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titlebar);
        this.mTvPlanType = (TextView) findViewById(R.id.tv_wdqbtext);
        this.mRelMyWallet = (RelativeLayout) findViewById(R.id.rel_mywallet);
        this.flContainer = (RelativeLayout) findViewById(R.id.flContainer);
        this.mTvAdvName = (TextView) findViewById(R.id.tv_advname);
    }

    private void initTitleBar() {
        if (StringUtils.isNotEmpty(this.mTypeInfoBean.base.appName)) {
            this.mTitleBar.setTitleView(LanguageUtils.getAppName(getActivity(), this.mTypeInfoBean.base.typeId, this.mTypeInfoBean.base.appName));
        } else if (this.mTypeInfoBean.base.typeId == 2) {
            this.mTitleBar.setTitleView(getString(R.string.vendingmachine));
        } else if (this.mTypeInfoBean.base.typeId == 26) {
            this.mTitleBar.setTitleView(getString(R.string.consumermachine));
        }
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
        getAdv();
        AdvControlUtil.getInstance().onResume();
        NativeUtil nativeUtil = this.mNativeUtil;
        if (nativeUtil != null) {
            nativeUtil.onResume();
        }
        ConsumerControlUtil consumerControlUtil = this.mConsumerControlUtil;
        if (consumerControlUtil != null) {
            consumerControlUtil.onResume();
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
        ConsumerControlUtil consumerControlUtil = this.mConsumerControlUtil;
        if (consumerControlUtil != null) {
            consumerControlUtil.onPause();
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
        findViewById(R.id.iv_scan).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m250x99015289(view);
            }
        });
        findViewById(R.id.rel_myorder).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m251x99cfd10a(view);
            }
        });
        findViewById(R.id.rel_mywallet).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m252x9a9e4f8b(view);
            }
        });
        findViewById(R.id.iv_drinkwaterhelp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m253x9b6cce0c(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-appcontrol-consumer-ConsumerControlActivity, reason: not valid java name */
    /* synthetic */ void m250x99015289(View view) {
        checkPre(0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-appcontrol-consumer-ConsumerControlActivity, reason: not valid java name */
    /* synthetic */ void m251x99cfd10a(View view) {
        ConsumeRecordActivity.launch(getActivity(), this.mTypeInfoBean.base.typeId);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-appcontrol-consumer-ConsumerControlActivity, reason: not valid java name */
    /* synthetic */ void m252x9a9e4f8b(View view) {
        getWalletInfo();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-appcontrol-consumer-ConsumerControlActivity, reason: not valid java name */
    /* synthetic */ void m253x9b6cce0c(View view) {
        ToastUtils.show(getContext(), getString(R.string.notopen));
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
        this.mConsumerControlUtil = new ConsumerControlUtil(getActivity(), getLoginAccount(), this.mInvestorInfoBean, this.mTitleBar.getTitleViewContent(), this.mPlanFlag, this.mTypeInfoBean.base.typeId);
        if (StringUtils.isNotEmpty(this.mQrcode)) {
            if ((this.mQrcode.length() < 52 || this.mTypeInfoBean.base.typeId != 26) && this.mTypeInfoBean.base.typeId != 2) {
                return;
            }
            this.mConsumerControlUtil.setQrcode(this.mQrcode);
        }
    }

    private void checkPre(int i) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        if (this.mTypeInfoBean.base.statusFlag == 1) {
            OperationTimeJsonBean operationTimeJsonBean = this.mOperationTimeJsonBean;
            if (operationTimeJsonBean != null && operationTimeJsonBean.operationFlag == 2) {
                if (isOpenTime()) {
                    toOpen(i);
                    return;
                } else {
                    showDialog("暂停服务，开放时间为\n每日" + this.mOpenTime);
                    return;
                }
            }
            toOpen(i);
            return;
        }
        showDialog(getString(R.string.appstop));
    }

    private void toOpen(int i) {
        if (i != 0) {
            return;
        }
        PermissionUtil.requestPerssion(getActivity(), 1, this.permissionGrant);
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

    private void showDialog(String str) {
        SystemErrorTip.getInstance().showTipDialog(getActivity(), str);
    }

    private void getWalletInfo() {
        int i = this.mPlanFlag;
        if (i == 1) {
            V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(getLoginAccount(), this.mInvestorInfoBean.investorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity.1
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    BaseMaterialDialog.showMaterialDialog(ConsumerControlActivity.this.getActivity(), "正在获取钱包信息..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                    if (ConsumerControlActivity.this.mIsEnable) {
                        BaseMaterialDialog.dissmisMaterialDialog();
                        ConsumerControlActivity.this.mWalletInfoBean = walletInfoBean;
                        WalletDetailActivity.launch(ConsumerControlActivity.this.getActivity(), ConsumerControlActivity.this.mWalletInfoBean);
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (ConsumerControlActivity.this.mIsEnable) {
                        ConsumerControlActivity.this.onError(clientException);
                    }
                }
            });
        } else if (i == 2) {
            DepositionDetailActivity.launch(getActivity());
        } else {
            ToastUtils.show(getContext(), "不支持此方案" + this.mPlanFlag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
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
                ScanQrcodeActivity.launch(getActivity(), 16);
                return;
            } else {
                ZxingScanV3Activity.launch(getActivity(), 16);
                return;
            }
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 200);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200) {
            if (i2 != -1) {
                return;
            }
            if (AppUtils.isUserHuaWeiScan()) {
                ScanQrcodeActivity.launch(getActivity(), 16);
                return;
            } else {
                ZxingScanV3Activity.launch(getActivity(), 16);
                return;
            }
        }
        if (i2 != 16 || intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("qrcode");
        LogUtil.e(TAG, "onActivityResult:" + stringExtra);
        if (StringUtils.isNotEmpty(stringExtra)) {
            this.mQrcode = stringExtra;
            if ((stringExtra.length() >= 52 && this.mTypeInfoBean.base.typeId == 26) || this.mTypeInfoBean.base.typeId == 2) {
                this.mConsumerControlUtil.setQrcode(stringExtra);
                return;
            } else {
                ToastUtils.show(getActivity(), "不合法的二维码！" + stringExtra);
                return;
            }
        }
        ToastUtils.show(getActivity(), "不合法的二维码！" + stringExtra);
    }

    private void getAdv() {
        if (this.mIsShowAdv) {
            return;
        }
        this.mNativeUtil = new NativeUtil();
        this.mAdvListener = new AdvControlUtil.AdvListener() { // from class: client.android.yixiaotong.v3.ui.appcontrol.consumer.ConsumerControlActivity.3
            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdClosed(Common.AdvType advType) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onRenderSuccess(View view, int i) {
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void isOpen(int i, int i2, int i3, int i4, int i5) {
                if (i5 == 1) {
                    ConsumerControlActivity.this.mNativeUtil.initNative(ConsumerControlActivity.this.getActivity(), ConsumerControlActivity.this.mAdvListener, 1);
                    ConsumerControlActivity.this.mNativeUtil.onNative(ConsumerControlActivity.this.flContainer);
                }
            }

            @Override // client.android.yixiaotong.v3.ui.adv.AdvControlUtil.AdvListener
            public void onAdShow(String str, Common.AdvType advType) {
                ConsumerControlActivity.this.mIsShowAdv = true;
            }
        };
        AdvControlUtil.getInstance().init(getActivity(), this.mAdvListener, 26, true, "");
        AdvControlUtil.getInstance().initAdvInfo();
    }
}
