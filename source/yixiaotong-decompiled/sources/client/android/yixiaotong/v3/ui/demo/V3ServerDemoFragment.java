package client.android.yixiaotong.v3.ui.demo;

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
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.permission.PermissionUtil;
import client.android.yixiaotong.v3.bean.login.UseSoftwareProductBean;
import client.android.yixiaotong.v3.ui.control.CashControl;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.wallet.DepositionDetailActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3ServerDemoFragment extends BaseFragment {
    private static final String TAG = "V3ServerDemoFragment";
    private ImageView mIvLogo;
    private RelativeLayout mRelDeposit;
    private RelativeLayout mRelWallet;
    private RelativeLayout mRelZKT;
    private TextView mTvBalance;
    private TextView mTvServerDes;
    private TextView mTvServerPhone;
    private TextView mTvServerTime;
    private TextView mTvVerverName;
    private TextView mTvZKTState;
    private boolean mIsEnable = true;
    private PermissionUtil.PermissionGrant permissionGrant = new PermissionUtil.PermissionGrant() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment.3
        @Override // client.android.yixiaotong.util.permission.PermissionUtil.PermissionGrant
        public void onPermissionGranted(int i) {
            if (i != 5) {
                return;
            }
            V3ServerDemoFragment.this.startActivity(new Intent("android.intent.action.CALL", Uri.parse("tel:" + V3ServerDemoFragment.this.mTvServerPhone.getText().toString())));
        }
    };

    static /* synthetic */ void lambda$initClickListeners$0(View view) {
    }

    static /* synthetic */ void lambda$initClickListeners$2(View view) {
    }

    private void initViewNew(View view) {
        this.mTvVerverName = (TextView) view.findViewById(R.id.tv_servername);
        this.mIvLogo = (ImageView) view.findViewById(R.id.iv_serverimg);
        this.mTvServerDes = (TextView) view.findViewById(R.id.tv_serverdes);
        this.mTvServerPhone = (TextView) view.findViewById(R.id.tv_serverphone);
        this.mTvServerTime = (TextView) view.findViewById(R.id.tv_servertime);
        this.mTvBalance = (TextView) view.findViewById(R.id.tv_balance);
        this.mRelWallet = (RelativeLayout) view.findViewById(R.id.rel_balance);
        this.mRelZKT = (RelativeLayout) view.findViewById(R.id.rel_zhikatong);
        this.mTvZKTState = (TextView) view.findViewById(R.id.tv_zktstate);
        this.mRelDeposit = (RelativeLayout) view.findViewById(R.id.rel_deposit);
    }

    public static V3ServerDemoFragment newInstance() {
        return new V3ServerDemoFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_server_demo, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        return viewInflate;
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_serverinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                V3ServerDemoFragment.lambda$initClickListeners$0(view2);
            }
        });
        view.findViewById(R.id.tv_serverphone).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m359xc547f797(view2);
            }
        });
        view.findViewById(R.id.rel_balance).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                V3ServerDemoFragment.lambda$initClickListeners$2(view2);
            }
        });
        view.findViewById(R.id.rel_zhikatong).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m360xe6b39119(view2);
            }
        });
        view.findViewById(R.id.rel_deposit).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m361xf7695dda(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-demo-V3ServerDemoFragment, reason: not valid java name */
    /* synthetic */ void m359xc547f797(View view) {
        if (StringUtils.isNotEmpty(this.mTvServerPhone.getText().toString())) {
            if (LocalDataUtil.getIsAgreed(getActivity(), 3)) {
                PermissionUtil.requestPerssion(getActivity(), 5, this.permissionGrant);
            } else {
                SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment.1
                    @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                    public void onConfirm() {
                        LocalDataUtil.savePermissIndex(V3ServerDemoFragment.this.getActivity(), 3);
                        PermissionUtil.requestPerssion(V3ServerDemoFragment.this.getActivity(), 5, V3ServerDemoFragment.this.permissionGrant);
                    }
                }, "需要开启电话权限，用于能够使用拨打电话的功能");
            }
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-demo-V3ServerDemoFragment, reason: not valid java name */
    /* synthetic */ void m360xe6b39119(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.demo.V3ServerDemoFragment.2
            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onCancle() {
            }

            @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
            public void onConfirm() {
                CashControl.getInstance().toZFBSmall(V3ServerDemoFragment.this.getContext());
            }
        }, "提示", getResources().getString(R.string.sign_zkt_content2), R.color.ff242933, "取消", "去签约");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-demo-V3ServerDemoFragment, reason: not valid java name */
    /* synthetic */ void m361xf7695dda(View view) {
        UseSoftwareProductBean useSoftwareProductBeanIsUseAndroid = InvestorInfoUtilControl.getInstance().isUseAndroid();
        if (useSoftwareProductBeanIsUseAndroid.isUse) {
            DepositionDetailActivity.launch(getActivity());
        } else {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), useSoftwareProductBeanIsUseAndroid.msg);
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
        LogUtil.e(TAG, "onResume");
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        LogUtil.e(TAG, "V3ServerDemoFragment:onPause");
        BaseMaterialDialog.dissmisMaterialDialog();
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        LogUtil.e(TAG, "V3ServerDemoFragment:onStart");
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        LogUtil.e(TAG, "V3ServerDemoFragment:onStop");
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        StubApp.interface22(i, strArr, iArr);
        PermissionUtil.requestPermissionsResult(getActivity(), i, strArr, iArr, this.permissionGrant);
    }
}
