package client.android.yixiaotong.v3.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import client.android.yixiaotong.BaseFragment;
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
import client.android.yixiaotong.v3.bean.register.PswBean;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.bean.ykt.OpenYKTBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.about.AboutMeActivity;
import client.android.yixiaotong.v3.ui.account.UserInfoV3Activity;
import client.android.yixiaotong.v3.ui.card.CardCenterActivity;
import client.android.yixiaotong.v3.ui.card.SchoolCardActivity;
import client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog;
import client.android.yixiaotong.v3.ui.discountcoupon.DiscountCouponActivity;
import client.android.yixiaotong.v3.ui.discountcoupon.RedPackageActivity;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.me.ykt.YKTDetailActivity;
import client.android.yixiaotong.v3.ui.order.OrderCenterActivity;
import client.android.yixiaotong.v3.ui.register.ChangeLoginPswActivity;
import client.android.yixiaotong.v3.ui.register.ChangePhoneActivity;
import client.android.yixiaotong.v3.ui.register.MachinePSWActivity;
import client.android.yixiaotong.v3.ui.register.ResetDevicePswActivity;
import client.android.yixiaotong.v3.ui.repair.RepairRecordH5Activity;
import client.android.yixiaotong.v3.ui.server.ChangeSchoolActivity;
import client.android.yixiaotong.v3.ui.server.SchoolInfoListActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfo;
import client.android.yixiaotong.v3.userinfo.UserInfoUtil;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.ClickUtil;
import client.android.yixiaotong.v3.util.Error50XUtil;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v3.util.LogUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.huawei.openalliance.ad.views.PPSLabelView;
import de.greenrobot.event.EventBus;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V3MeFragment extends BaseFragment {
    private static final String TAG = "V3MeFragment";
    private boolean mIsEnable = true;
    private ImageView mIvLogo;
    private RelativeLayout mRelBindYKT;
    private RelativeLayout mRelExitLogin;
    private RelativeLayout mRelWarningError;
    private TextView mTvName;
    private TextView mTvVersion;
    private UserInfo mUserInfo;
    private View mVDot;

    private void initViewNew(View view) {
        this.mRelWarningError = (RelativeLayout) view.findViewById(R.id.rel_warningerror);
        this.mTvName = (TextView) view.findViewById(R.id.tv_name);
        this.mIvLogo = (ImageView) view.findViewById(R.id.iv_icon);
        this.mRelExitLogin = (RelativeLayout) view.findViewById(R.id.rel_exitlogin);
        this.mTvVersion = (TextView) view.findViewById(R.id.tv_vetsion);
        this.mVDot = view.findViewById(R.id.v_dot);
        this.mRelBindYKT = (RelativeLayout) view.findViewById(R.id.rel_bindykt);
    }

    public static V3MeFragment newInstance() {
        return new V3MeFragment();
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_v3_me, viewGroup, false);
        initViewNew(viewInflate);
        initClickListeners(viewInflate);
        EventBus.getDefault().register(this);
        LogUtil.e(TAG, "onCreateView");
        getIsOpenYKT();
        return viewInflate;
    }

    public void onEventMainThread(UIVisableBean uIVisableBean) {
        LogUtil.e(TAG, "onEventMainThread:UIVisableBean" + uIVisableBean.index + PPSLabelView.Code + this.mIsEnable);
        if (uIVisableBean.index == 4) {
            getIsOpenYKT();
        }
    }

    private void initClickListeners(View view) {
        view.findViewById(R.id.rel_info).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m188x6b6d4e6c(view2);
            }
        });
        view.findViewById(R.id.rel_exitlogin).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda13
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m189x24e4dc0b(view2);
            }
        });
        view.findViewById(R.id.rel_cardinfo).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda14
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m196xde5c69aa(view2);
            }
        });
        view.findViewById(R.id.rel_order).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda15
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m197x97d3f749(view2);
            }
        });
        view.findViewById(R.id.rel_discountcoupon).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m198x514b84e8(view2);
            }
        });
        view.findViewById(R.id.rel_redpackage).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m199xac31287(view2);
            }
        });
        view.findViewById(R.id.rel_fqa).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m200xc43aa026(view2);
            }
        });
        view.findViewById(R.id.rel_repair).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m201x7db22dc5(view2);
            }
        });
        view.findViewById(R.id.rel_changeloginpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m202x3729bb64(view2);
            }
        });
        view.findViewById(R.id.rel_changephone).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m203xf0a14903(view2);
            }
        });
        view.findViewById(R.id.rel_bindykt).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m190xeb71911d(view2);
            }
        });
        view.findViewById(R.id.rel_schoolqrcode).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m191xa4e91ebc(view2);
            }
        });
        view.findViewById(R.id.rel_card).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m192x5e60ac5b(view2);
            }
        });
        view.findViewById(R.id.rel_waterpsw).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m193x17d839fa(view2);
            }
        });
        view.findViewById(R.id.rel_abountme).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m194xd14fc799(view2);
            }
        });
        view.findViewById(R.id.rel_versionupdate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment$$ExternalSyntheticLambda12
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f$0.m195x8ac75538(view2);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m188x6b6d4e6c(View view) {
        if (isCheckSchool()) {
            UserInfoV3Activity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m189x24e4dc0b(View view) {
        LocalDataUtil.saveLastTokenInfo(getActivity(), "");
        AccountManager.getInstance().clearLoginAccount();
        LoginActivity.launch(getActivity());
        getActivity().finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m196xde5c69aa(View view) {
        if (isCheckSchool()) {
            CardCenterActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m197x97d3f749(View view) {
        if (isCheckSchool()) {
            OrderCenterActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m198x514b84e8(View view) {
        if (isCheckSchool()) {
            DiscountCouponActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m199xac31287(View view) {
        if (isCheckSchool()) {
            RedPackageActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m200xc43aa026(View view) {
        ToastUtils.show(getContext(), "暂未开通");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m201x7db22dc5(View view) {
        if (isCheckSchool()) {
            RepairRecordH5Activity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$8$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m202x3729bb64(View view) {
        ChangeLoginPswActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$9$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m203xf0a14903(View view) {
        ChangePhoneActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$10$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m190xeb71911d(View view) {
        if (isCheckSchool()) {
            YKTDetailActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$11$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m191xa4e91ebc(View view) {
        if (isCheckSchool()) {
            SchoolInfoListActivity.launch(getActivity(), "", "");
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$12$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m192x5e60ac5b(View view) {
        if (isCheckSchool()) {
            SchoolCardActivity.launch(getActivity());
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$13$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m193x17d839fa(View view) {
        if (isCheckSchool()) {
            findPsw();
        } else {
            showDialog(false, "使用相关功能需要先绑定学校", "退出登录", "去绑定");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$14$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m194xd14fc799(View view) {
        AboutMeActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$15$client-android-yixiaotong-v3-ui-V3MeFragment, reason: not valid java name */
    /* synthetic */ void m195x8ac75538(View view) {
        getVerSion();
    }

    private boolean isCheckSchool() {
        return UserInfoUtil.getInstance().getLoginAccountV3().schoolInfoList != null;
    }

    private void initView() {
        UserInfo userInfo = this.mUserInfo;
        if (userInfo != null) {
            this.mTvName.setText(userInfo.studentName);
            if (this.mUserInfo.studentGender == 1) {
                Glide.with(getContext()).load(getResources().getDrawable(R.mipmap.l_shouye_user)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new CircleCrop())).into(this.mIvLogo);
            } else {
                Glide.with(getContext()).load(getResources().getDrawable(R.mipmap.l_shouye_user)).apply((BaseRequestOptions<?>) RequestOptions.bitmapTransform(new CircleCrop())).into(this.mIvLogo);
            }
        }
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
        showError50XTip();
        this.mUserInfo = UserInfoUtil.getInstance().getLoginAccountV3();
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
        EventBus.getDefault().unregister(this);
    }

    private void exitapp() {
        V3BusinessControllers.getInstance().getUserLogout(getLoginAccount(), new Listener<String>() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V3MeFragment.this.getActivity(), "正在退出APP", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, String str, Object... objArr) {
                if (V3MeFragment.this.mIsEnable) {
                    BaseMaterialDialog.dissmisMaterialDialog();
                    Log.e("getUserLogout", "onComplete:" + str);
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(V3MeFragment.this.getActivity());
                    V3MeFragment.this.getActivity().finish();
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V3MeFragment.this.mIsEnable) {
                    V3MeFragment.this.onError(clientException);
                }
            }
        });
    }

    private void findPsw() {
        V3BusinessControllers.getInstance().getFindMachiniePWD(getLoginAccount(), UserInfoUtilControl.getInstance().getSchoolId(), new Listener<PswBean>() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment.2
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                BaseMaterialDialog.showMaterialDialog(V3MeFragment.this.getActivity(), "加载中.", false);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, PswBean pswBean, Object... objArr) {
                if (V3MeFragment.this.mIsEnable) {
                    V3MeFragment.this.showError50XTip();
                    BaseMaterialDialog.dissmisMaterialDialog();
                    if (pswBean != null) {
                        if (pswBean.statusFlag == 0) {
                            ResetDevicePswActivity.launch(V3MeFragment.this.getActivity(), 0, "");
                        } else if (pswBean.statusFlag == 1) {
                            MachinePSWActivity.launch(V3MeFragment.this.getActivity(), pswBean.password);
                        } else if (pswBean.statusFlag == 2) {
                            ToastUtils.show(V3MeFragment.this.getContext(), "密码已停用");
                        }
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V3MeFragment.this.mIsEnable) {
                    V3MeFragment.this.onError(clientException);
                }
            }
        });
    }

    private void getVerSion() {
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        LocalDataUtil.saveAppUpdateUrl(getActivity(), "");
        V3BusinessControllers.getInstance().getAppVerInfo(getLoginAccount(), schoolId, investorId, new Listener<AppVersionBean>() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment.3
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppVersionBean appVersionBean, Object... objArr) {
                if (V3MeFragment.this.mIsEnable) {
                    V3MeFragment.this.showError50XTip();
                    if (StringUtils.isNotEmpty(appVersionBean.ver)) {
                        LocalDataUtil.saveAppVer(V3MeFragment.this.getContext(), appVersionBean.ver);
                        if (!appVersionBean.ver.equals(V3MeFragment.this.mTvVersion.getText().toString())) {
                            V3MeFragment.this.mVDot.setVisibility(0);
                        }
                    }
                    if (StringUtils.isNotEmpty(appVersionBean.url)) {
                        LocalDataUtil.saveAppUpdateUrl(V3MeFragment.this.getActivity(), appVersionBean.url);
                    }
                    if (appVersionBean.status == 1) {
                        new UpdateAppUtil().showMustUpdateApkDialog(V3MeFragment.this.getActivity(), appVersionBean.msg, false, false);
                    } else if (appVersionBean.status == 2) {
                        new UpdateAppUtil().showMustUpdateApkDialog(V3MeFragment.this.getActivity(), appVersionBean.msg);
                    }
                }
            }
        });
    }

    private void getIsOpenYKT() {
        this.mRelBindYKT.setVisibility(8);
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        LogUtil.e(TAG, investorId + PPSLabelView.Code + schoolId);
        if (StringUtils.isEmpty(investorId) || StringUtils.isEmpty(schoolId)) {
            return;
        }
        V3BusinessControllers.getInstance().getIsOpenYKT(getLoginAccount(), investorId, schoolId, "front_end", new Listener<OpenYKTBean>() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment.4
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, OpenYKTBean openYKTBean, Object... objArr) {
                if (V3MeFragment.this.mIsEnable) {
                    V3MeFragment.this.showError50XTip();
                    if (openYKTBean == null || openYKTBean.dictionaryInfo == null || !StringUtils.isNotEmpty(openYKTBean.dictionaryInfo.bindCard) || !openYKTBean.dictionaryInfo.bindCard.equals("1")) {
                        return;
                    }
                    V3MeFragment.this.mRelBindYKT.setVisibility(0);
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (V3MeFragment.this.mIsEnable) {
                    V3MeFragment.this.showError50XTip();
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
        showError50XTip();
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), "我的", clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
        }
    }

    private void showDialog(boolean z, String str, final String str2, String str3) {
        if (z) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment.5
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    if (str2.equals("退出登录")) {
                        AccountManager.getInstance().clearLoginAccount();
                        LoginActivity.launch(V3MeFragment.this.getActivity());
                        V3MeFragment.this.getActivity().finish();
                    }
                }
            }, str, str2);
        } else {
            TwoButtonDialog.getInstance().showDialog(getActivity(), new TwoButtonDialog.Listener() { // from class: client.android.yixiaotong.v3.ui.V3MeFragment.6
                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onConfirm() {
                    if (ClickUtil.isFastDoubleClick()) {
                        return;
                    }
                    ChangeSchoolActivity.launch(V3MeFragment.this.getActivity());
                }

                @Override // client.android.yixiaotong.v3.ui.dialog.TwoButtonDialog.Listener
                public void onCancle() {
                    AccountManager.getInstance().clearLoginAccount();
                    LoginActivity.launch(V3MeFragment.this.getActivity());
                    V3MeFragment.this.getActivity().finish();
                }
            }, "提示", str, str2, str3);
        }
    }
}
