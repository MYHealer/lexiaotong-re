package client.android.yixiaotong.v3.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.DecimalUtil;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfoBean;
import client.android.yixiaotong.v3.bean.login.InvestorInfosBean;
import client.android.yixiaotong.v3.bean.login.PlanInfoBean;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.bean.wallet.CashRedPackageBean;
import client.android.yixiaotong.v3.bean.wallet.WalletInfoBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.control.CashControl;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.discountcoupon.CashRedPackageListActivity;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.server.ChangeServerActivity;
import client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity;
import client.android.yixiaotong.v3.ui.wallet.WalletDetailActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtil;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.bumptech.glide.Glide;
import com.facebook.common.util.UriUtil;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3ServerFragment extends BaseFragment {
    private static final String TAG = "V3ServerFragment";
    private CashRedPackageBean mCashRedPackageBean;
    private InvestorInfoBean mInvestorInfoBean;
    private ImageView mIvLogo;
    private RelativeLayout mRelCashBalance;
    private RelativeLayout mRelDeposit;
    private RelativeLayout mRelWallet;
    private RelativeLayout mRelWarningError;
    private RelativeLayout mRelZKT;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TextView mTvBalance;
    private TextView mTvCashBalance;
    private TextView mTvCashRefunding;
    private TextView mTvServerDes;
    private TextView mTvServerPhone;
    private TextView mTvServerTime;
    private TextView mTvServerTitle;
    private TextView mTvVerverName;
    private TextView mTvZKTState;
    private WalletInfoBean mWalletInfoBean;
    private boolean mIsEnable = true;
    private String mInvestorId = "";
    private boolean mIsLoadWallet = false;
    private boolean mIsAgainLoad = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment.7
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 5) {
                return;
            }
            V3ServerFragment.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + V3ServerFragment.this.mTvServerPhone.getText().toString())));
        }
    };

    private void initViewNew(View view) {
        this.mRelWarningError = (RelativeLayout) view.findViewById(R.id.rel_warningerror);
        this.mTvServerTitle = (TextView) view.findViewById(R.id.tv_server);
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mTvVerverName = (TextView) view.findViewById(R.id.tv_servername);
        this.mIvLogo = (ImageView) view.findViewById(R.id.iv_serverimg);
        this.mTvServerDes = (TextView) view.findViewById(R.id.tv_serverdes);
        this.mTvServerPhone = (TextView) view.findViewById(R.id.tv_serverphone);
        this.mTvServerTime = (TextView) view.findViewById(R.id.tv_servertime);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelWallet = (RelativeLayout) view.findViewById(R.id.rel_balance);
        this.mRelCashBalance = (RelativeLayout) view.findViewById(R.id.rel_cashbalance);
        this.mTvCashRefunding = (TextView) view.findViewById(R.id.tv_cashrefunding);
        this.mTvCashBalance = (TextView) view.findViewById(R.id.tv_cashbalance);
        this.mRelZKT = (RelativeLayout) view.findViewById(R.id.rel_zhikatong);
        this.mTvZKTState = (TextView) view.findViewById(R.id.tv_zktstate);
        this.mRelDeposit = (RelativeLayout) view.findViewById(R.id.rel_deposit);
    }

    public static V3ServerFragment newInstance() {
        return new V3ServerFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_server, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        EventBus.getDefault().register(this);
        LocalDataUtil.saveIsNeedGetWalletInfo(getContext(), true);
        initListener();
        return viewInflate;
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_serverinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m208x251cc317(view2);
            }
        });
        view.findViewById(R.id.tv_serverphone).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m209x16c66936(view2);
            }
        });
        view.findViewById(R.id.rel_balance).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m210x8700f55(view2);
            }
        });
        view.findViewById(R.id.rel_zhikatong).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m211xfa19b574(view2);
            }
        });
        view.findViewById(R.id.rel_deposit).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m212xebc35b93(view2);
            }
        });
        view.findViewById(R.id.rel_cashbalance).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m213xdd6d01b2(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-V3ServerFragment, reason: not valid java name */
    /* synthetic */ void m208x251cc317(View view) {
        if (this.mIsAgainLoad) {
            LocalDataUtil.saveIsNeedGetCashRedPackageInfo(getContext(), true);
            ChangeServerActivity.launch(getActivity());
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-V3ServerFragment, reason: not valid java name */
    /* synthetic */ void m209x16c66936(View view) {
        if (StringUtils.isNotEmpty(this.mTvServerPhone.getText().toString())) {
            if (LocalDataUtil.getIsAgreed(getActivity(), 3)) {
                PermissionUtil.requestPerssion(getActivity(), 5, this.permissionGrant);
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        LocalDataUtil.savePermissIndex(V3ServerFragment.this.getActivity(), 3);
                        PermissionUtil.requestPerssion(V3ServerFragment.this.getActivity(), 5, V3ServerFragment.this.permissionGrant);
                    }
                }, "需要开启电话权限，用于能够使用拨打电话的功能");
            }
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-V3ServerFragment, reason: not valid java name */
    /* synthetic */ void m210x8700f55(View view) {
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid();
        if (useSoftwareProductBeanIsUseAndroid.isUse && this.mIsAgainLoad) {
            WalletDetailActivity.launch(getActivity(), this.mWalletInfoBean);
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid.msg);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-V3ServerFragment, reason: not valid java name */
    /* synthetic */ void m211xfa19b574(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment.2
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                CashControl.getInstance().toZFBSmall(V3ServerFragment.this.getActivity());
            }
        }, "提示", getResources().getString(R.string.sign_zkt_content2), R.color.ff242933, "取消", "去签约");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-V3ServerFragment, reason: not valid java name */
    /* synthetic */ void m212xebc35b93(View view) {
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid();
        if (useSoftwareProductBeanIsUseAndroid.isUse && this.mIsAgainLoad) {
            DepositionDetailActivity.launch(getActivity());
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid.msg);
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-V3ServerFragment, reason: not valid java name */
    /* synthetic */ void m213xdd6d01b2(View view) {
        if (this.mCashRedPackageBean == null || !this.mIsAgainLoad) {
            return;
        }
        CashRedPackageListActivity.launch(getActivity(), this.mCashRedPackageBean.orderId, this.mCashRedPackageBean.refundStatus);
    }

    public void onEventMainThread(InvestorInfosBean investorInfosBean) {
        if (this.mIsEnable) {
            LogUtil.e(TAG, "onEventMainThread");
            LocalDataUtil.saveIsNeedGetWalletInfo(getContext(), true);
            initView();
            getScheme();
        }
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean" + uIVisableBean.index + PPSLabelView.Code + this.mIsEnable);
        if (uIVisableBean.index == 2) {
            LocalDataUtil.saveIsNeedGetWalletInfo(getContext(), true);
            LocalDataUtil.saveIsNeedGetCashRedPackageInfo(getContext(), true);
            initView();
            getScheme();
        }
    }

    private void initListener() {
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                LocalDataUtil.saveIsNeedGetWalletInfo(V3ServerFragment.this.getContext(), true);
                LocalDataUtil.saveIsNeedGetCashRedPackageInfo(V3ServerFragment.this.getContext(), true);
                V3ServerFragment.this.initView();
                V3ServerFragment.this.getScheme();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView() {
        List<InvestorInfosBean> investorInfosV3 = InvestorInfoUtil.getInstance().getInvestorInfosV3();
        String str = "";
        if (investorInfosV3 == null) {
            this.mTvVerverName.setText("");
            this.mIvLogo.setVisibility(4);
            this.mTvServerDes.setText("");
            this.mTvServerPhone.setText("");
            this.mTvServerTime.setText("");
        } else if (investorInfosV3 != null && investorInfosV3.size() > 0) {
            InvestorInfoBean investorInfoBean = InvestorInfoUtilControl.getInstance().getInvestorInfoBean();
            this.mInvestorInfoBean = investorInfoBean;
            this.mTvVerverName.setText(investorInfoBean.providerJson.providerName);
            this.mIvLogo.setVisibility(0);
            this.mIvLogo.setImageURI(UriUtil.parseUriOrNull(this.mInvestorInfoBean.brandLogo));
            Glide.with(getContext()).load(this.mInvestorInfoBean.brandLogo).into(this.mIvLogo);
            this.mTvServerDes.setText(this.mInvestorInfoBean.providerJson.description);
            this.mTvServerPhone.setText(this.mInvestorInfoBean.providerJson.phone);
            Collections.sort(this.mInvestorInfoBean.providerJson.workTimeList);
            for (int i = 0; i < this.mInvestorInfoBean.providerJson.workTimeList.size(); i++) {
                str = this.mInvestorInfoBean.providerJson.workTimeList.get(i).startTime + "~" + this.mInvestorInfoBean.providerJson.workTimeList.get(i).stopTime + IOUtils.LINE_SEPARATOR_UNIX;
            }
            this.mTvServerTime.setText(str);
        }
        this.mRelZKT.setVisibility(8);
        int cloudsaleSign = InvestorInfoUtilControl.getInstance().getCloudsaleSign();
        if (cloudsaleSign == 1 || cloudsaleSign == 3) {
            this.mTvZKTState.setText(getResources().getString(R.string.gotosign));
            this.mRelZKT.setEnabled(false);
            this.mRelZKT.setVisibility(0);
            CashControl.getInstance().setZKTListener(new CashControl.ZKTCashListener() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment.4
                @Override // client.android.yixiaotong.v3.ui.control.CashControl.ZKTCashListener
                public void onSign(int i2) {
                    LogUtil.e(V3ServerFragment.TAG, "onSign:" + i2);
                    if (i2 == 2) {
                        V3ServerFragment.this.mTvZKTState.setText(V3ServerFragment.this.getResources().getString(R.string.havesigned));
                        V3ServerFragment.this.mRelZKT.setEnabled(false);
                    } else if (i2 != 1 && i2 == 0) {
                        V3ServerFragment.this.mRelZKT.setEnabled(true);
                    }
                }
            });
            CashControl.getInstance().paySelectAll(2, false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getScheme() {
        List<PlanInfoBean> list;
        this.mRelWallet.setVisibility(8);
        this.mRelDeposit.setVisibility(8);
        this.mRelCashBalance.setVisibility(8);
        LogUtil.e(TAG, "getScheme:" + (this.mInvestorInfoBean != null));
        InvestorInfoBean investorInfoBean = this.mInvestorInfoBean;
        if (investorInfoBean != null && (list = investorInfoBean.planInfo) != null && list.size() > 0) {
            char c = 0;
            for (int i = 0; i < list.size(); i++) {
                LogUtil.e(TAG, "getScheme:" + list.get(i).base.planFlag);
                if (list.get(i).base.planFlag == 1) {
                    this.mRelWallet.setVisibility(0);
                    getWalletInfo();
                } else {
                    if (list.get(i).base.planFlag == 2) {
                        this.mRelDeposit.setVisibility(0);
                        getWalletInfo();
                    } else if ((list.get(i).base.planFlag == 3 || list.get(i).base.planFlag == 4) && c != 1) {
                        c = 2;
                    }
                }
                c = 1;
            }
            if (c == 2) {
                this.mRelCashBalance.setVisibility(0);
                getMoneyCouponAmount();
            }
        }
        PullRefreshLayout pullRefreshLayout = this.mSwipeRefreshLayout;
        if (pullRefreshLayout != null) {
            pullRefreshLayout.setRefreshing(false);
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        showError50XTip();
        CashControl.getInstance().onResume();
        LogUtil.e(TAG, "onResume");
        initView();
        if (this.mIsAgainLoad) {
            getScheme();
        }
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        LogUtil.e(TAG, "V3ServerFragment:onPause");
        CashControl.getInstance().onPause();
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.e(TAG, "V3ServerFragment:onStart");
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        LogUtil.e(TAG, "V3ServerFragment:onStop");
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    private void getWalletInfo() {
        if (this.mIsLoadWallet) {
            return;
        }
        LogUtil.e(TAG, "getWalletInfo:" + LocalDataUtil.getIsNeedGetWalletInfo(getContext()) + PPSLabelView.Code + this.mInvestorId);
        if (LocalDataUtil.getIsNeedGetWalletInfo(getContext()) || StringUtils.isEmpty(this.mInvestorId) || (StringUtils.isNotEmpty(this.mInvestorId) && !this.mInvestorId.equals(this.mInvestorInfoBean.investorId))) {
            this.mInvestorId = this.mInvestorInfoBean.investorId;
            V3BusinessControllers.getInstance().postGetWalletInfoByInvestorid(getLoginAccount(), this.mInvestorInfoBean.investorId, new Listener<WalletInfoBean>() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment.5
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onStart(Controller controller) {
                    V3ServerFragment.this.mIsLoadWallet = true;
                    V3ServerFragment.this.mIsAgainLoad = true;
                    BaseMaterialDialog.showMaterialDialog(V3ServerFragment.this.getActivity(), "正在获取钱包信息..", false);
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, WalletInfoBean walletInfoBean, Object... objArr) {
                    V3ServerFragment.this.mIsLoadWallet = false;
                    if (V3ServerFragment.this.mIsEnable) {
                        V3ServerFragment.this.showError50XTip();
                        LocalDataUtil.saveIsNeedGetWalletInfo(V3ServerFragment.this.getContext(), false);
                        BaseMaterialDialog.dissmisMaterialDialog();
                        V3ServerFragment.this.mWalletInfoBean = walletInfoBean;
                        V3ServerFragment.this.mTvBalance.setText(DecimalUtil.twoDecimal(DecimalUtil.divide(walletInfoBean.money + "", "100")));
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    V3ServerFragment.this.mIsLoadWallet = false;
                    V3ServerFragment.this.mIsAgainLoad = false;
                    if (V3ServerFragment.this.mIsEnable) {
                        V3ServerFragment.this.onError(clientException, true);
                    }
                }
            });
        }
    }

    private void getMoneyCouponAmount() {
        if (LocalDataUtil.getIsNeedGetCashRedPackageInfo(getContext()) || StringUtils.isEmpty(this.mInvestorId) || (StringUtils.isNotEmpty(this.mInvestorId) && !this.mInvestorId.equals(this.mInvestorInfoBean.investorId))) {
            this.mInvestorId = this.mInvestorInfoBean.investorId;
            V3BusinessControllers.getInstance().getMoneyCouponAmountV2(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), this.mInvestorInfoBean.investorId, new Listener<CashRedPackageBean>() { // from class: client.android.yixiaotong.v3.ui.V3ServerFragment.6
                @Override // client.android.yixiaotong.controller.core.Listener
                public void onComplete(Controller controller, CashRedPackageBean cashRedPackageBean, Object... objArr) {
                    if (V3ServerFragment.this.mIsEnable) {
                        V3ServerFragment.this.showError50XTip();
                        if (cashRedPackageBean != null) {
                            LocalDataUtil.saveIsNeedGetCashRedPackageInfo(V3ServerFragment.this.getContext(), false);
                            V3ServerFragment.this.mTvCashBalance.setText(DecimalUtil.divide(cashRedPackageBean.money + "", "100"));
                            V3ServerFragment.this.mCashRedPackageBean = cashRedPackageBean;
                            if (cashRedPackageBean.money != 0 || cashRedPackageBean.refundStatus == 1) {
                                V3ServerFragment.this.mRelCashBalance.setVisibility(0);
                                if (cashRedPackageBean.refundStatus == 1) {
                                    V3ServerFragment.this.mTvCashRefunding.setVisibility(0);
                                    return;
                                } else {
                                    V3ServerFragment.this.mTvCashRefunding.setVisibility(4);
                                    return;
                                }
                            }
                            V3ServerFragment.this.mRelCashBalance.setVisibility(8);
                        }
                    }
                }

                @Override // client.android.yixiaotong.controller.core.Listener
                public void onFail(Controller controller, ClientException clientException) {
                    if (V3ServerFragment.this.mIsEnable) {
                        LocalDataUtil.saveIsNeedGetCashRedPackageInfo(V3ServerFragment.this.getContext(), false);
                        V3ServerFragment.this.onError(clientException, false);
                    }
                }
            });
        }
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
    public void onError(ClientException clientException, boolean z) {
        BaseMaterialDialog.dissmisMaterialDialog();
        showError50XTip();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTvServerTitle.getText().toString(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        PermissionUtil.requestPermissionsResult(getActivity(), i, strArr, iArr, this.permissionGrant);
    }
}
