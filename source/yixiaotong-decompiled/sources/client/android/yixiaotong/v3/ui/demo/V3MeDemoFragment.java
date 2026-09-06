package client.android.yixiaotong.v3.ui.demo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.v3.ui.about.AboutMeActivity;
import client.android.yixiaotong.v3.ui.repair.RepairRecordH5Activity;
import client.android.yixiaotong.v3.ui.server.SchoolInfoListActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3MeDemoFragment extends BaseFragment {
    private static final String TAG = "V3MeDemoFragment";
    private boolean mIsEnable = true;
    private ImageView mIvLogo;
    private RelativeLayout mRelExitLogin;
    private TextView mTvName;
    private TextView mTvVersion;
    private View mVDot;

    static /* synthetic */ void lambda$initClickListeners$0(View view) {
    }

    static /* synthetic */ void lambda$initClickListeners$12(View view) {
    }

    static /* synthetic */ void lambda$initClickListeners$14(View view) {
    }

    private void initViewNew(View view) {
        this.mTvName = (TextView) view.findViewById(R.id.tv_name);
        this.mIvLogo = (ImageView) view.findViewById(R.id.iv_icon);
        this.mRelExitLogin = (RelativeLayout) view.findViewById(R.id.rel_exitlogin);
        this.mTvVersion = (TextView) view.findViewById(R.id.tv_vetsion);
        this.mVDot = view.findViewById(R.id.v_dot);
    }

    public static V3MeDemoFragment newInstance() {
        return new V3MeDemoFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_me_demo, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        return viewInflate;
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_info).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                V3MeDemoFragment.lambda$initClickListeners$0(view2);
            }
        });
        view.findViewById(R.id.rel_exitlogin).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m344xf592d6ec(view2);
            }
        });
        view.findViewById(R.id.rel_cardinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m348x1ee72c2d(view2);
            }
        });
        view.findViewById(R.id.rel_order).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m349x483b816e(view2);
            }
        });
        view.findViewById(R.id.rel_discountcoupon).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m350x718fd6af(view2);
            }
        });
        view.findViewById(R.id.rel_redpackage).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m351x9ae42bf0(view2);
            }
        });
        view.findViewById(R.id.rel_fqa).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m352xc4388131(view2);
            }
        });
        view.findViewById(R.id.rel_repair).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m353xed8cd672(view2);
            }
        });
        view.findViewById(R.id.rel_changeloginpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m354x16e12bb3(view2);
            }
        });
        view.findViewById(R.id.rel_changephone).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m355x403580f4(view2);
            }
        });
        view.findViewById(R.id.rel_schoolqrcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m345xe6abb61a(view2);
            }
        });
        view.findViewById(R.id.rel_card).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m346x10000b5b(view2);
            }
        });
        view.findViewById(R.id.rel_waterpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                V3MeDemoFragment.lambda$initClickListeners$12(view2);
            }
        });
        view.findViewById(R.id.rel_abountme).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m347x62a8b5dd(view2);
            }
        });
        view.findViewById(R.id.rel_versionupdate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.demo.V3MeDemoFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                V3MeDemoFragment.lambda$initClickListeners$14(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m344xf592d6ec(View view) {
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(getActivity());
        getActivity().finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m348x1ee72c2d(View view) {
        ToastUtils.show(getContext(), "卡包中暂无卡片");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m349x483b816e(View view) {
        ToastUtils.show(getContext(), "没有可查看的订单");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m350x718fd6af(View view) {
        ToastUtils.show(getContext(), "没有可用优惠券");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m351x9ae42bf0(View view) {
        ToastUtils.show(getContext(), "没有可用红包");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m352xc4388131(View view) {
        ToastUtils.show(getContext(), "暂未开通");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m353xed8cd672(View view) {
        RepairRecordH5Activity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$8$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m354x16e12bb3(View view) {
        ToastUtils.show(getContext(), "未登录，无法修改密码");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$9$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m355x403580f4(View view) {
        ToastUtils.show(getContext(), "未登录，无法修改手机号码");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$10$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m345xe6abb61a(View view) {
        SchoolInfoListActivity.launch(getActivity(), "", "");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$11$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m346x10000b5b(View view) {
        ToastUtils.show(getContext(), "未登录，没有校园卡片");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$13$client-android-yixiaotong-v3-ui-demo-V3MeDemoFragment, reason: not valid java name */
    /* synthetic */ void m347x62a8b5dd(View view) {
        AboutMeActivity.launch(getActivity());
    }

    private void initView() {
        this.mTvVersion.setText(AppUtils.getVersion(getContext()));
        String appVer = LocalDataUtil.getAppVer(getContext());
        if (!StringUtils.isNotEmpty(appVer) || appVer.equals(this.mTvVersion.getText().toString())) {
            return;
        }
        this.mVDot.setVisibility(0);
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume");
        this.mIsEnable = true;
        initView();
    }

    @Override // client.android.yixiaotong.BaseFragment, android.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
