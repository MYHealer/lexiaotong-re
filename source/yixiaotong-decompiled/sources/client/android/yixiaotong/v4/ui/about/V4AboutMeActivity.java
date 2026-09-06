package client.android.yixiaotong.v4.ui.about;

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
import client.android.yixiaotong.ui.widget.TitleBar;
import client.android.yixiaotong.util.AppUtils;
import client.android.yixiaotong.util.StringUtils;
import client.android.yixiaotong.util.ToastUtils;
import client.android.yixiaotong.util.update.UpdateAppUtil;
import client.android.yixiaotong.v3.ui.about.InformationPermissionsActivity;
import client.android.yixiaotong.v3.ui.about.LicenseV3Activity;
import client.android.yixiaotong.v3.ui.about.ThirdpartyinformationsdkActivity;
import client.android.yixiaotong.v3.ui.jump.JunpWebActivity;
import client.android.yixiaotong.v3.util.LocalDataUtil;
import client.android.yixiaotong.v4.http.V4BusinessControllers;
import client.android.yixiaotong.v4.http.bean.V4VersionInfoBean;
import client.android.yixiaotong.v4.ui.error.V4ErrorControlUtil;
import client.android.yixiaotong.v4.util.V4LocalDataUtil;
import com.cdo.oaps.ad.wrapper.download.RedirectReqWrapper;
import com.stub.StubApp;

/* JADX INFO: loaded from: C:\Users\MR\AppData\Local\Temp\yixiaotong-dex\6635224.dex */
public class V4AboutMeActivity extends BaseActivity {
    TitleBar mTitleBar;
    TextView mTvServerVersion;
    TextView mTvVersion;
    private String mUpdateMsg;
    View mVDot;
    private boolean mIsEnable = true;
    private int mVerState = -1;

    static {
        StubApp.interface11(10624);
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected native void onCreate(Bundle bundle);

    public static void launch(Activity activity) {
        if (activity != null) {
            activity.startActivity(new Intent(activity, (Class<?>) V4AboutMeActivity.class));
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
        V4ErrorControlUtil.getInstance().onResume();
    }

    @Override // client.android.yixiaotong.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mIsEnable = true;
        V4ErrorControlUtil.getInstance().onPause();
    }

    private void initClickListeners() {
        findViewById(R.id.rel_verupdate).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (V4AboutMeActivity.this.mVerState == 1) {
                    new UpdateAppUtil().showMustUpdateApkDialog(V4AboutMeActivity.this.getActivity(), V4AboutMeActivity.this.mUpdateMsg, false, true);
                } else if (V4AboutMeActivity.this.mVerState == 2) {
                    new UpdateAppUtil().showMustUpdateApkDialog(V4AboutMeActivity.this.getActivity(), V4AboutMeActivity.this.mUpdateMsg);
                } else if (V4AboutMeActivity.this.mVerState == 0) {
                    ToastUtils.show(V4AboutMeActivity.this.getContext(), "已是最新版本");
                }
            }
        });
        findViewById(R.id.rel_agreement).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LicenseV3Activity.launch(V4AboutMeActivity.this.getActivity());
            }
        });
        findViewById(R.id.rel_privacypolicy).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PrivacyPolicyActivity.launch(V4AboutMeActivity.this.getActivity());
            }
        });
        findViewById(R.id.rel_informationpermissions).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                InformationPermissionsActivity.launch(V4AboutMeActivity.this.getActivity());
            }
        });
        findViewById(R.id.rel_thirdpartyinformationsdk).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ThirdpartyinformationsdkActivity.launch(V4AboutMeActivity.this.getActivity());
            }
        });
        findViewById(R.id.rel_loadapp).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                LeXiaoTongQrcodeActivity.launch(V4AboutMeActivity.this.getActivity());
                V4AboutMeActivity.this.finish();
            }
        });
        findViewById(R.id.rel_cancelaccount).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                V4CancelAccountActivity.launch(V4AboutMeActivity.this.getActivity());
                V4AboutMeActivity.this.finish();
            }
        });
        findViewById(R.id.tv_beian).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JunpWebActivity.launch(V4AboutMeActivity.this.getActivity(), "https://beian.miit.gov.cn");
            }
        });
        findViewById(R.id.rel_lanuage).setOnClickListener(new View.OnClickListener() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String lanuage = LocalDataUtil.getLanuage(V4AboutMeActivity.this.getActivity());
                boolean zIsNotEmpty = StringUtils.isNotEmpty(lanuage);
                String str = BaseActivity.LANGUAGEEN;
                if (zIsNotEmpty && lanuage.equalsIgnoreCase(BaseActivity.LANGUAGEEN)) {
                    str = RedirectReqWrapper.KEY_CHANNEL;
                }
                LocalDataUtil.saveLanuage(V4AboutMeActivity.this.getActivity(), str);
                V4AboutMeActivity.this.switchLang(str);
            }
        });
    }

    private void getVerSion() {
        String version = AppUtils.getVersion(getActivity());
        V4LocalDataUtil.saveAppUpdateUrl(getActivity(), "");
        V4BusinessControllers.getInstance().getAppVersionInfo(getLoginAccount(), version, new Listener<V4VersionInfoBean>() { // from class: client.android.yixiaotong.v4.ui.about.V4AboutMeActivity.10
            @Override // client.android.yixiaotong.controller.core.Listener
            public void onStart(Controller controller) {
                super.onStart(controller);
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onComplete(Controller controller, V4VersionInfoBean v4VersionInfoBean, Object... objArr) {
                if (V4AboutMeActivity.this.mIsEnable) {
                    if (!StringUtils.isNotEmpty(v4VersionInfoBean.ver) || (v4VersionInfoBean.status != 1 && v4VersionInfoBean.status != 2)) {
                        V4AboutMeActivity.this.mVerState = 0;
                        V4AboutMeActivity.this.mTvServerVersion.setText(V4AboutMeActivity.this.mTvVersion.getText().toString());
                        return;
                    }
                    V4LocalDataUtil.saveAppVer(V4AboutMeActivity.this.getContext(), v4VersionInfoBean.ver);
                    V4AboutMeActivity.this.mVDot.setVisibility(0);
                    V4AboutMeActivity.this.mVerState = v4VersionInfoBean.status;
                    V4AboutMeActivity.this.mTvServerVersion.setText(v4VersionInfoBean.ver);
                    V4AboutMeActivity.this.mUpdateMsg = v4VersionInfoBean.msg;
                    if (StringUtils.isNotEmpty(v4VersionInfoBean.url)) {
                        V4LocalDataUtil.saveAppUpdateUrl(V4AboutMeActivity.this.getActivity(), v4VersionInfoBean.url);
                    }
                }
            }

            @Override // client.android.yixiaotong.controller.core.Listener
            public void onFail(Controller controller, ClientException clientException) {
                boolean unused = V4AboutMeActivity.this.mIsEnable;
            }
        });
    }
}
