package client.android.yixiaotong.v4.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseXFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4ServerListBean;
import client.android.yixiaotong.v4.http.bean.V4UserInfoDetailBean;
import client.android.yixiaotong.v4.ui.control.V4MainControl;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.user.V4ChangeServerActivity;
import client.android.yixiaotong.v4.ui.wallet.V4WalletDetailActivity;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectConfigInfoUtil;
import client.android.yixiaotong.v4.util.projectconfig.V4ProjectInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import client.android.yixiaotong.view.load.PullRefreshLayout;
import com.huawei.openalliance.ad.views.PPSLabelView;
import com.stub.StubApp;
import de.greenrobot.event.EventBus;
import java.util.List;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4ServerFragment extends BaseXFragment {
    private static final String TAG = "V4ServerFragment";
    private ImageView mIvLogo;
    private RelativeLayout mRelCashBalance;
    private RelativeLayout mRelWallet;
    private RelativeLayout mRelWarningError;
    private RelativeLayout mRelZKT;
    private PullRefreshLayout mSwipeRefreshLayout;
    private TextView mTvBalance;
    private TextView mTvCashBalance;
    private TextView mTvCashRefunding;
    private TextView mTvServerDes;
    private TextView mTvServerName;
    private TextView mTvServerPhone;
    private TextView mTvServerTime;
    private TextView mTvServerTitle;
    private TextView mTvZKTState;
    private V4UserInfoDetailBean mWalletInfoBean;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment.6
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 5) {
                return;
            }
            V4ServerFragment.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + V4ServerFragment.this.mTvServerPhone.getText().toString())));
        }
    };

    private void showError50XTip() {
    }

    private void initViewNew(View view) {
        this.mRelWarningError = (RelativeLayout) view.findViewById(R.id.rel_warningerror);
        this.mTvServerTitle = (TextView) view.findViewById(R.id.tv_server);
        this.mSwipeRefreshLayout = (PullRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.mTvServerName = (TextView) view.findViewById(R.id.tv_servername);
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
    }

    public static V4ServerFragment newInstance() {
        return new V4ServerFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v4_server, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        LogUtil.e(TAG, "onCreateView");
        EventBus.getDefault().register(this);
        initListener();
        getScheme();
        return viewInflate;
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_serverinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m462x8b9122d9(view2);
            }
        });
        view.findViewById(R.id.tv_serverphone).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m463x7d3ac8f8(view2);
            }
        });
        view.findViewById(R.id.rel_balance).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m464x6ee46f17(view2);
            }
        });
        view.findViewById(R.id.rel_zhikatong).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m465x608e1536(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-V4ServerFragment, reason: not valid java name */
    /* synthetic */ void m462x8b9122d9(View view) {
        V4ChangeServerActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-V4ServerFragment, reason: not valid java name */
    /* synthetic */ void m463x7d3ac8f8(View view) {
        if (StringUtils.isNotEmpty(this.mTvServerPhone.getText().toString())) {
            if (LocalDataUtil.getIsAgreed(getActivity(), 3)) {
                PermissionUtil.requestPerssion(getActivity(), 5, this.permissionGrant);
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        LocalDataUtil.savePermissIndex(V4ServerFragment.this.getActivity(), 3);
                        PermissionUtil.requestPerssion(V4ServerFragment.this.getActivity(), 5, V4ServerFragment.this.permissionGrant);
                    }
                }, "需要开启电话权限，用于能够使用拨打电话的功能");
            }
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-V4ServerFragment, reason: not valid java name */
    /* synthetic */ void m464x6ee46f17(View view) {
        if (ClickUtil.isFastDoubleClick() || !V4ProjectConfigInfoUtil.getInstance().isEnableUse(getActivity())) {
            return;
        }
        V4WalletDetailActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-V4ServerFragment, reason: not valid java name */
    /* synthetic */ void m465x608e1536(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment.2
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                V4MainControl.getInstance().toZFBSmall(V4ServerFragment.this.getActivity());
            }
        }, "提示", getResources().getString(R.string.sign_zkt_content2), R.color.ff242933, "取消", "去签约");
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean" + uIVisableBean.index + PPSLabelView.Code + this.mIsEnable);
        if (uIVisableBean.index == 2) {
            getScheme();
        }
    }

    private void initListener() {
        this.mSwipeRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment.3
            @Override // client.android.yixiaotong.view.load.PullRefreshLayout.OnRefreshListener
            public void onRefresh() {
                V4ServerFragment.this.getScheme();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initView(V4ServerListBean v4ServerListBean) {
        if (v4ServerListBean == null) {
            this.mTvServerName.setText("");
            this.mIvLogo.setVisibility(4);
            this.mTvServerDes.setText("");
            this.mTvServerPhone.setText("");
            this.mTvServerTime.setText("");
        } else {
            this.mTvBalance.setText(v4ServerListBean.totalBalance);
            this.mTvServerName.setText(v4ServerListBean.serviceName);
            this.mIvLogo.setVisibility(0);
            this.mTvServerPhone.setText(v4ServerListBean.phone);
        }
        this.mRelZKT.setVisibility(8);
        V4ProjectInfoBean projectInfoV4 = V4ProjectConfigInfoUtil.getInstance().getProjectInfoV4();
        if (projectInfoV4 != null) {
            if (projectInfoV4.aliCartoonSign.intValue() == 1 || projectInfoV4.aliCartoonSign.intValue() == 2) {
                this.mTvZKTState.setText(getResources().getString(R.string.gotosign));
                this.mRelZKT.setEnabled(false);
                this.mRelZKT.setVisibility(0);
                V4MainControl.getInstance().setZKTListener(new V4MainControl.ZKTCashListener() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment.4
                    @Override // client.android.yixiaotong.v4.ui.control.V4MainControl.ZKTCashListener
                    public void onSign(int i) {
                        LogUtil.e(V4ServerFragment.TAG, "onSign:" + i);
                        if (i == 2) {
                            V4ServerFragment.this.mTvZKTState.setText(V4ServerFragment.this.getResources().getString(R.string.havesigned));
                            V4ServerFragment.this.mRelZKT.setEnabled(false);
                        } else if (i != 1 && i == 0) {
                            V4ServerFragment.this.mRelZKT.setEnabled(true);
                        }
                    }
                });
                V4MainControl.getInstance().paySelectAll(getLoginAccount(), getActivity(), 2, false, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getScheme() {
        this.mRelWallet.setVisibility(0);
        PullRefreshLayout pullRefreshLayout = this.mSwipeRefreshLayout;
        if (pullRefreshLayout != null) {
            pullRefreshLayout.setRefreshing(false);
        }
        getServerList();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsEnable = true;
        showError50XTip();
        LogUtil.e(TAG, "onResume");
        V4ErrorControlUtil.getInstance().onResume();
        V4MainControl.getInstance().onResume();
        List<V4ServerListBean> list = V4UserInfoUtil.getInstance().getLoginAccountV4().serverInfoList;
        if (list == null || list.size() <= 0) {
            return;
        }
        String str = V4UserInfoUtil.getInstance().getLoginAccountV4().projectId;
        if (StringUtils.isNotEmpty(str)) {
            for (V4ServerListBean v4ServerListBean : list) {
                if (v4ServerListBean.projectId.equals(str)) {
                    initView(v4ServerListBean);
                }
            }
        }
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        LogUtil.e(TAG, "V4ServerFragment:onPause");
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().onPause();
        V4MainControl.getInstance().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.e(TAG, "V4ServerFragment:onStart");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        LogUtil.e(TAG, "V4ServerFragment:onStop");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    private void getServerList() {
        V4BusinessControllers.getInstance().getServerList(getLoginAccount(), new Listener<V4ServerListBean>() { // from class: client.android.yixiaotong.v4.ui.V4ServerFragment.5
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4ServerFragment.this.getActivity(), "正在获取服务商信息..", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4ServerListBean v4ServerListBean, Object... objArr) {
                if (V4ServerFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4ServerFragment.this.initView(v4ServerListBean);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4ServerFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    V4ErrorControlUtil.getInstance().showDialog(clientException, V4ServerFragment.this.getActivity(), false);
                }
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        PermissionUtil.requestPermissionsResult(getActivity(), i, strArr, iArr, this.permissionGrant);
    }
}
