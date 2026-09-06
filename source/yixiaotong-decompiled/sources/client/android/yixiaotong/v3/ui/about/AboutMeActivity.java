package client.android.yixiaotong.v3.ui.about;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import client.android.yixiaotong.BaseActivity;
import client.android.yixiaotong.R;
import client.android.yixiaotong.controller.core.Controller;
import client.android.yixiaotong.controller.core.Listener;
import client.android.yixiaotong.exception.ClientException;
import client.android.yixiaotong.ui.LeXiaoTongQrcodeActivity;
import client.android.yixiaotong.ui.PrivacyPolicyActivity;
import client.android.yixiaotong.ui.dialog.BaseMaterialDialog;
import client.android.yixiaotong.ui.dialog.SystemErrorTip;
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.update.UpdateAppUtil;
import client.android.yixiaotong.v3.bean.user.AppVersionBean;
import client.android.yixiaotong.v3.http.V3BusinessControllers;
import client.android.yixiaotong.v3.ui.error.V3ErrorTipActivity;
import client.android.yixiaotong.v3.ui.jump.JunpWebActivity;
import client.android.yixiaotong.v3.userinfo.InvestorInfoUtilControl;
import client.android.yixiaotong.v3.userinfo.UserInfoUtilControl;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class AboutMeActivity extends BaseActivity {
    private TitleBar mTitleBar;
    private TextView mTvServerVersion;
    private TextView mTvVersion;
    private String mUpdateMsg;
    private View mVDot;
    private boolean mIsEnable = true;
    private int mVerState = -1;

    static {
        StubApp.interface11(8894);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) AboutMeActivity.class));
        }
    }

    private void initViewNew() {
        this.mTitleBar = (TitleBar) findViewById(R.id.titleBar);
        this.mTvVersion = (TextView) findViewById(R.id.tv_version);
        this.mTvServerVersion = (TextView) findViewById(R.id.tv_serverversion);
        this.mVDot = findViewById(R.id.v_dot);
    }

    private void initTitleBar() {
        this.mTitleBar.setTitleView(getResources().getString(R.string.setting));
        this.mTitleBar.setLeftView(R.mipmap.back);
        this.mTitleBar.setLeftViewOnClickBack(getActivity());
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mIsEnable = true;
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = true;
    }

    private void initClickListeners() {
        findViewById(R.id.rel_verupdate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m214x59389cd(view);
            }
        });
        findViewById(R.id.rel_agreement).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m215x2ee7df0e(view);
            }
        });
        findViewById(R.id.rel_privacypolicy).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m216x583c344f(view);
            }
        });
        findViewById(R.id.rel_informationpermissions).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m217x81908990(view);
            }
        });
        findViewById(R.id.rel_thirdpartyinformationsdk).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m218xaae4ded1(view);
            }
        });
        findViewById(R.id.rel_loadapp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m219xd4393412(view);
            }
        });
        findViewById(R.id.rel_cancelaccount).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m220xfd8d8953(view);
            }
        });
        findViewById(R.id.tv_beian).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m221x26e1de94(view);
            }
        });
        findViewById(R.id.rel_lanuage).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.m222x503633d5(view);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$0$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m214x59389cd(View view) {
        int i = this.mVerState;
        if (i == 1) {
            new UpdateAppUtil().showMustUpdateApkDialog(getActivity(), this.mUpdateMsg, false, true);
        } else if (i == 2) {
            new UpdateAppUtil().showMustUpdateApkDialog(getActivity(), this.mUpdateMsg);
        } else if (i == 0) {
            ToastUtils.show(getContext(), "已是最新版本");
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$1$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m215x2ee7df0e(View view) {
        LicenseV3Activity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$2$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m216x583c344f(View view) {
        PrivacyPolicyActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$3$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m217x81908990(View view) {
        InformationPermissionsActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$4$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m218xaae4ded1(View view) {
        ThirdpartyinformationsdkActivity.launch(getActivity());
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$5$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m219xd4393412(View view) {
        LeXiaoTongQrcodeActivity.launch(getActivity());
        finish();
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$6$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m220xfd8d8953(View view) {
        if (StringUtils.isNotEmpty(LocalDataUtil.getLastTokenInfo(getActivity()))) {
            CancelAccountActivity.launch(getActivity());
            finish();
        }
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$7$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m221x26e1de94(View view) {
        JunpWebActivity.launch(getActivity(), "https://beian.miit.gov.cn");
    }

    /* JADX INFO: renamed from: lambda$initClickListeners$8$client-android-yixiaotong-v3-ui-about-AboutMeActivity, reason: not valid java name */
    /* synthetic */ void m222x503633d5(View view) {
        String lanuage = LocalDataUtil.getLanuage(getActivity());
        boolean zIsNotEmpty = StringUtils.isNotEmpty(lanuage);
        String str = BaseActivity.LANGUAGEEN;
        if (zIsNotEmpty && lanuage.equalsIgnoreCase(BaseActivity.LANGUAGEEN)) {
            str = RedirectReqWrapper.KEY_CHANNEL;
        }
        LocalDataUtil.saveLanuage(getActivity(), str);
        switchLang(str);
    }

    private void getVerSion() {
        if (StringUtils.isEmpty(LocalDataUtil.getLastTokenInfo(getActivity()))) {
            return;
        }
        String schoolId = UserInfoUtilControl.getInstance().getSchoolId();
        String investorId = InvestorInfoUtilControl.getInstance().getInvestorId();
        LocalDataUtil.saveAppUpdateUrl(getActivity(), "");
        V3BusinessControllers.getInstance().getAppVerInfo(getLoginAccount(), schoolId, investorId, new Listener<AppVersionBean>() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity.1
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, AppVersionBean appVersionBean, Object... objArr) {
                if (AboutMeActivity.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(appVersionBean.ver) || (appVersionBean.status != 1 && appVersionBean.status != 2)) {
                        AboutMeActivity.this.mVerState = 0;
                        AboutMeActivity.this.mTvServerVersion.setText(AboutMeActivity.this.mTvVersion.getText().toString());
                        return;
                    }
                    LocalDataUtil.saveAppVer(AboutMeActivity.this.getContext(), appVersionBean.ver);
                    AboutMeActivity.this.mVDot.setVisibility(0);
                    AboutMeActivity.this.mVerState = appVersionBean.status;
                    AboutMeActivity.this.mTvServerVersion.setText(appVersionBean.ver);
                    AboutMeActivity.this.mUpdateMsg = appVersionBean.msg;
                    if (StringUtils.isNotEmpty(appVersionBean.url)) {
                        LocalDataUtil.saveAppUpdateUrl(AboutMeActivity.this.getActivity(), appVersionBean.url);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                if (AboutMeActivity.this.mIsEnable) {
                    AboutMeActivity.this.onError(clientException);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ClientException clientException) {
        BaseMaterialDialog.dissmisMaterialDialog();
        if (clientException.isNeedTip(clientException.getCode())) {
            SystemErrorTip.getInstance().showTipDialog(getActivity(), new SystemErrorTip.SystemErrorDialogListener() { // from class: client.android.yixiaotong.v3.ui.about.AboutMeActivity.2
                @Override // client.android.yixiaotong.ui.dialog.SystemErrorTip.SystemErrorDialogListener
                public void onConfirm() {
                    AboutMeActivity.this.finish();
                }
            }, clientException.getDetail());
        } else {
            V3ErrorTipActivity.launch(getActivity(), this.mTitleBar.getTitleViewContent(), clientException.getDetail(), clientException.getCode(), 2, clientException.getSerial());
            finish();
        }
    }
}
