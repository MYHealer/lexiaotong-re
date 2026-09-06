package client.android.yixiaotong.v4.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseXFragment;
import client.android.yixiaotong.R;
import client.android.yixiaotong.account.AccountManager;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.login.LoginActivity;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.update.UpdateAppUtil;
import client.android.yixiaotong.v3.bean.UIVisableBean;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.V4HttpConfig;
import client.android.yixiaotong.v4.ui.about.V4AboutMeActivity;
import client.android.yixiaotong.v4.ui.area.V4SelectAddressActivity;
import client.android.yixiaotong.v4.ui.card.V4SchoolCardActivity;
import client.android.yixiaotong.v4.ui.devicepassword.V4MachinePSWActivity;
import client.android.yixiaotong.v4.ui.devicepassword.V4ResetDevicePswActivity;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.ui.repair.V4RepairRecordActivity;
import client.android.yixiaotong.v4.ui.user.V4ChangeLoginPswActivity;
import client.android.yixiaotong.v4.ui.user.V4ChangePhoneActivity;
import client.android.yixiaotong.v4.ui.user.V4SchoolQrcodeActivity;
import client.android.yixiaotong.v4.ui.user.V4UserInfoActivity;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoBean;
import client.android.yixiaotong.v4.util.userinfo.V4UserInfoUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4MeFragment extends BaseXFragment {
    private static final String TAG = "V4MeFragment";
    private boolean mIsEnable = true;
    private ImageView mIvLogo;
    private RelativeLayout mRelExitLogin;
    private RelativeLayout mRelWarningError;
    private TextView mTvName;
    private TextView mTvVersion;
    private View mVDot;

    private boolean isCheckSchool() {
        return true;
    }

    private void showError50XTip() {
    }

    private void initViewNew(View view) {
        this.mRelWarningError = (RelativeLayout) view.findViewById(R.id.rel_warningerror);
        this.mTvName = (TextView) view.findViewById(R.id.tv_name);
        this.mIvLogo = (ImageView) view.findViewById(R.id.iv_icon);
        this.mRelExitLogin = (RelativeLayout) view.findViewById(R.id.rel_exitlogin);
        this.mTvVersion = (TextView) view.findViewById(R.id.tv_vetsion);
        this.mVDot = view.findViewById(R.id.v_dot);
    }

    public static V4MeFragment newInstance() {
        return new V4MeFragment();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v4_me, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        EventBus.getDefault().register(this);
        LogUtil.e(TAG, "onCreateView");
        return viewInflate;
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean" + uIVisableBean.index + PPSLabelView.Code + this.mIsEnable);
        int i = uIVisableBean.index;
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_info).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m446x50fbdf2e(view2);
            }
        });
        view.findViewById(R.id.rel_exitlogin).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m447xa736ccd(view2);
            }
        });
        view.findViewById(R.id.rel_fqa).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m450xc3eafa6c(view2);
            }
        });
        view.findViewById(R.id.rel_repair).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m451x7d62880b(view2);
            }
        });
        view.findViewById(R.id.rel_changeloginpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m452x36da15aa(view2);
            }
        });
        view.findViewById(R.id.rel_changephone).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m453xf051a349(view2);
            }
        });
        view.findViewById(R.id.rel_bindroom).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m454xa9c930e8(view2);
            }
        });
        view.findViewById(R.id.rel_schoolqrcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m455x6340be87(view2);
            }
        });
        view.findViewById(R.id.rel_card).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m456x1cb84c26(view2);
            }
        });
        view.findViewById(R.id.rel_waterpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m457xd62fd9c5(view2);
            }
        });
        view.findViewById(R.id.rel_abountme).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m448xd10021df(view2);
            }
        });
        view.findViewById(R.id.rel_versionupdate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m449x8a77af7e(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m446x50fbdf2e(View view) {
        if (isCheckSchool()) {
            V4UserInfoActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m447xa736ccd(View view) {
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch((Activity) getActivity());
        getActivity().finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m450xc3eafa6c(View view) {
        ToastUtils.show(getContext(), "暂未开通");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m451x7d62880b(View view) {
        if (ClickUtil.isFastDoubleClick()) {
            return;
        }
        V4RepairRecordActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m452x36da15aa(View view) {
        V4ChangeLoginPswActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m453xf051a349(View view) {
        V4ChangePhoneActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m454xa9c930e8(View view) {
        V4SelectAddressActivity.launch(getActivity(), 0);
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m455x6340be87(View view) {
        V4SchoolQrcodeActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$8$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m456x1cb84c26(View view) {
        if (isCheckSchool()) {
            V4SchoolCardActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$9$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m457xd62fd9c5(View view) {
        if (isCheckSchool()) {
            findPsw();
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$10$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m448xd10021df(View view) {
        V4AboutMeActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$11$client-android-yixiaotong-v4-ui-V4MeFragment, reason: not valid java name */
    /* synthetic */ void m449x8a77af7e(View view) {
        getVerSion();
    }

    private void initView() {
        V4UserInfoBean loginAccountV4 = V4UserInfoUtil.getInstance().getLoginAccountV4();
        if (loginAccountV4 != null) {
            this.mTvName.setText(loginAccountV4.name);
            Glide.with(getContext()).load(getResources().getDrawable(R.mipmap.l_shouye_user)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new CircleCrop())).into(this.mIvLogo);
        }
        this.mTvVersion.setText(AppUtils.getVersion(getContext()));
        String appVer = V4LocalDataUtil.getAppVer(getContext());
        if (!StringUtils.isNotEmpty(appVer) || appVer.equals(this.mTvVersion.getText().toString())) {
            return;
        }
        this.mVDot.setVisibility(0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LogUtil.e(TAG, "onResume");
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onResume();
        showError50XTip();
        initView();
    }

    @Override // client.android.yixiaotong.BaseXFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mIsEnable = false;
        V4ErrorControlUtil.getInstance().onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    private void findPsw() {
        V4BusinessControllers.getInstance().getDevicePassword(getLoginAccount(), new Listener<String>() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V4MeFragment.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                if (V4MeFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (StringUtils.isNotEmpty(str)) {
                        V4MachinePSWActivity.launch(V4MeFragment.this.getActivity(), str);
                    } else {
                        V4ResetDevicePswActivity.launch(V4MeFragment.this.getActivity(), 0, "");
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V4MeFragment.this.mIsEnable) {
                    V4MeFragment.this.onError(clientException);
                }
            }
        });
    }

    private void getVerSion() {
        String version = AppUtils.getVersion(getContext());
        V4LocalDataUtil.saveAppUpdateUrl(getActivity(), "");
        V3BusinessControllers.getInstance().getAppVerInfo2(getLoginAccount(), version, "1", V4HttpConfig.PRODUCTCODE, new Listener<AppVersionBean>() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppVersionBean appVersionBean, Object... objArr) {
                if (V4MeFragment.this.mIsEnable) {
                    if (StringUtils.isNotEmpty(appVersionBean.ver)) {
                        V4LocalDataUtil.saveAppVer(V4MeFragment.this.getContext(), appVersionBean.ver);
                        if (!appVersionBean.ver.equals(V4MeFragment.this.mTvVersion.getText().toString())) {
                            V4MeFragment.this.mVDot.setVisibility(0);
                        }
                    }
                    if (StringUtils.isNotEmpty(appVersionBean.url)) {
                        V4LocalDataUtil.saveAppUpdateUrl(V4MeFragment.this.getActivity(), appVersionBean.url);
                    }
                    if (appVersionBean.status == 1) {
                        new UpdateAppUtil().showMustUpdateApkDialog(V4MeFragment.this.getActivity(), appVersionBean.msg, false, false);
                    } else if (appVersionBean.status == 2) {
                        new UpdateAppUtil().showMustUpdateApkDialog(V4MeFragment.this.getActivity(), appVersionBean.msg);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        showError50XTip();
        BaseMaterialDialog.dissmisMaterialDialog();
        V4ErrorControlUtil.getInstance().showDialog(clientException, getActivity(), false);
    }

    private void showDialog(boolean z, String str, final String str2, String str3) {
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment.3
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (str2.equals("退出登录")) {
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch((Activity) V4MeFragment.this.getActivity());
                        V4MeFragment.this.getActivity().finish();
                    }
                }
            }, str, str2);
        } else {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v4.ui.V4MeFragment.4
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    if (ClickUtil.isFastDoubleClick()) {
                        return;
                    }
                    ChangeSchoolActivity.launch(V4MeFragment.this.getActivity());
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch((Activity) V4MeFragment.this.getActivity());
                    V4MeFragment.this.getActivity().finish();
                }
            }, "提示", str, str2, str3);
        }
    }
}
